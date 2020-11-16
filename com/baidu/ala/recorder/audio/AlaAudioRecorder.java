package com.baidu.ala.recorder.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.media.AudioRecord;
import android.os.Build;
import com.baidu.ala.helper.AlaAudioBuffer;
import com.baidu.ala.helper.AlaAudioSession;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.ndk.AudioProcessModule;
import com.baidu.live.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes15.dex */
public class AlaAudioRecorder {
    public static final int BUFFER_LENGTH = 2048;
    private int mChannels;
    private Context mContext;
    private boolean mEnableACE;
    private int mSampleRate;
    private int mFramesPerBuffer = 256;
    private volatile AudioRecord mAudioRecord = null;
    private byte[] mBuffer = null;
    private ByteBuffer mNativeBuffer = null;
    private AlaAudioBuffer mAudioBuffer = null;
    private AlaAudioSession mAudioSession = null;
    private boolean mRunOpenSLES = false;
    private volatile AlaAudioRecorderCallback mCallback = null;
    private long mLastCaptureTimestamp = 0;
    private AudioProcessModule.CaptureCallback mOpenSLESCallback = null;
    private BroadcastReceiver mReceiver = null;
    private AlaAudioFrame mAudioFrame = new AlaAudioFrame();
    private int[] mNativePosArr = new int[1];
    private int[] mNativeLenArr = new int[1];

    /* loaded from: classes15.dex */
    public interface AlaAudioRecorderCallback {
        void onAudioRecordError(String str);

        void onAudioRecordInitError(String str);
    }

    public AlaAudioRecorder(Context context, int i, int i2, boolean z) {
        this.mEnableACE = false;
        this.mSampleRate = 0;
        this.mChannels = 0;
        this.mContext = null;
        this.mContext = context;
        this.mSampleRate = i;
        this.mChannels = i2;
        this.mEnableACE = z;
        initData();
        setup(i, i2);
    }

    public boolean start() {
        initData();
        setup(this.mSampleRate, this.mChannels);
        if (this.mAudioRecord != null && this.mAudioRecord.getState() == 1) {
            try {
                this.mAudioRecord.startRecording();
                return this.mAudioRecord.getRecordingState() == 3;
            } catch (IllegalStateException e) {
                return false;
            }
        }
        if (this.mEnableACE) {
            this.mAudioSession.startRTC();
        }
        this.mAudioSession.startListen();
        if (this.mEnableACE && this.mRunOpenSLES) {
            if (this.mOpenSLESCallback == null) {
                this.mOpenSLESCallback = new AudioProcessModule.CaptureCallback() { // from class: com.baidu.ala.recorder.audio.AlaAudioRecorder.1
                    @Override // com.baidu.ala.ndk.AudioProcessModule.CaptureCallback
                    public void onCaptureData(int i) {
                        if (i > 0) {
                            AlaAudioRecorder.this.mLastCaptureTimestamp = System.currentTimeMillis();
                        }
                    }
                };
            }
            if (AudioProcessModule.sharedInstance().audioRecorderStart() == 0) {
                AudioProcessModule.sharedInstance().setCaptureCallback(this.mOpenSLESCallback);
                return true;
            }
            return false;
        }
        return false;
    }

    public void setCallback(AlaAudioRecorderCallback alaAudioRecorderCallback) {
        this.mCallback = alaAudioRecorderCallback;
    }

    private void initData() {
        if (this.mBuffer == null) {
            this.mBuffer = new byte[2048];
        }
        if (this.mAudioBuffer == null) {
            this.mAudioBuffer = new AlaAudioBuffer();
        }
        if (this.mNativeBuffer == null) {
            this.mNativeBuffer = ByteBuffer.allocateDirect(4096);
        }
        if (this.mAudioSession == null) {
            this.mAudioSession = new AlaAudioSession(this.mContext);
        }
    }

    private void setup(int i, int i2) {
        if (this.mAudioRecord == null) {
            initData();
            int minBufferSize = AudioRecord.getMinBufferSize(i, i2, 2);
            if (minBufferSize < i) {
                minBufferSize = i;
            }
            try {
                this.mAudioFrame.setupConfig(i, i2);
                if (StreamConfig.initConfig(this.mContext) < 0) {
                    BdLog.e("StreamConfig.initConfig failed");
                }
                this.mRunOpenSLES = StreamConfig.useOpenSLES();
                if (this.mEnableACE) {
                    if (this.mRunOpenSLES) {
                        this.mAudioRecord = null;
                        int i3 = i2 == 12 ? 2 : 1;
                        AudioProcessModule.sharedInstance().createAudioProcessModule(i, i, i3, i3, 1, 1, 1);
                        AudioProcessModule.sharedInstance().updateSystemInfo(Build.VERSION.SDK_INT, Build.MODEL);
                        AudioProcessModule.sharedInstance().createAudioRecorder(i, i3, i / 100);
                    } else {
                        this.mAudioRecord = new AudioRecord(7, i, i2, 2, minBufferSize);
                        this.mFramesPerBuffer = (i / 100) * 2;
                        int i4 = i2 == 12 ? 2 : 1;
                        AudioProcessModule.sharedInstance().createAudioProcessModule(i, i, i4, i4, 0, 1, 1);
                        AudioProcessModule.sharedInstance().setCaptureBuffer(this.mNativeBuffer, 1.4f);
                    }
                } else {
                    this.mAudioRecord = new AudioRecord(1, i, i2, 2, minBufferSize);
                }
                if (!this.mRunOpenSLES && this.mAudioRecord.getState() == 0) {
                    this.mAudioRecord = null;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                this.mAudioRecord = null;
                if (this.mCallback != null) {
                    this.mCallback.onAudioRecordInitError("IllegalArgumentException " + e.getLocalizedMessage());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mAudioRecord = null;
                if (this.mCallback != null) {
                    this.mCallback.onAudioRecordInitError("1 Exception " + e2.getLocalizedMessage());
                }
            }
        }
    }

    public AlaAudioFrame readData() {
        if (this.mEnableACE) {
            if (this.mRunOpenSLES) {
                return null;
            }
            return readDataAndACE();
        } else if (this.mAudioRecord != null) {
            int read = this.mAudioRecord.read(this.mBuffer, 0, 2048);
            if (read == 2048) {
                this.mAudioFrame.fillAudioData(this.mBuffer, 2048);
                return this.mAudioFrame;
            }
            BdLog.e("audiorecorder read data error. length is " + read);
            if (this.mCallback != null) {
                this.mCallback.onAudioRecordError("audiorecorder read data error " + read);
                return null;
            }
            return null;
        } else {
            return null;
        }
    }

    public void pause() {
        if (this.mEnableACE && this.mRunOpenSLES && AudioProcessModule.sharedInstance().audioRecorderSetOpt(1) != 0) {
            BdLog.e("OpenSLES audio recorder pause failed");
        }
    }

    public void resume() {
        if (this.mEnableACE && this.mRunOpenSLES && AudioProcessModule.sharedInstance().audioRecorderSetOpt(2) != 0) {
            BdLog.e("OpenSLES audio recorder resume failed");
        }
    }

    public void mutex(boolean z) {
        if (this.mEnableACE && this.mRunOpenSLES) {
            if (z) {
                if (AudioProcessModule.sharedInstance().audioRecorderSetOpt(3) != 0) {
                    BdLog.e("OpenSLES audio recorder mute failed");
                }
            } else if (AudioProcessModule.sharedInstance().audioRecorderSetOpt(4) != 0) {
                BdLog.e("OpenSLES audio recorder unmute failed");
            }
        }
    }

    public long getLastCaptureTimestamp() {
        return this.mLastCaptureTimestamp;
    }

    public void stopAndRelease() {
        if (this.mRunOpenSLES && AudioProcessModule.sharedInstance().audioRecorderStop() != 0) {
            BdLog.e("OpenSLES audio recorder stop failed");
        }
        if (this.mEnableACE) {
            if (AudioProcessModule.sharedInstance().destroyAudioProcessModule() != 0) {
                BdLog.e("destroy apm  failed");
            }
            AudioProcessModule.sharedInstance().setCaptureCallback(null);
        }
        if (this.mAudioSession != null) {
            this.mAudioSession.stopRTC();
            this.mAudioSession.stopListen();
            this.mAudioSession.onDestroy();
        }
        if (this.mAudioRecord != null) {
            try {
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
            } catch (Exception e) {
                BdLog.e("audiorecorder catch Exception " + e);
                if (this.mCallback != null) {
                    this.mCallback.onAudioRecordError("stopAndRelease - Exception " + e.getLocalizedMessage());
                }
            }
            this.mAudioRecord = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a9, code lost:
        if (r1 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ab, code lost:
        r8.mAudioFrame.fillAudioData(r8.mBuffer, 2048);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return r8.mAudioFrame;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AlaAudioFrame readDataAndACE() {
        boolean z = false;
        if (this.mAudioRecord == null) {
            return null;
        }
        while (true) {
            try {
                int read = this.mAudioRecord.read(this.mNativeBuffer.array(), this.mNativeBuffer.arrayOffset(), this.mFramesPerBuffer);
                if (read != this.mFramesPerBuffer) {
                    BdLog.e("readDataRTC read data error. length is " + read);
                    return null;
                }
                this.mNativePosArr[0] = 0;
                this.mNativeLenArr[0] = this.mFramesPerBuffer;
                int updateCaptureBuffer = AudioProcessModule.sharedInstance().updateCaptureBuffer(this.mNativePosArr, this.mNativeLenArr);
                if (updateCaptureBuffer != 0) {
                    BdLog.e("AudioProcessModule.updateCaptureBuffer failed " + updateCaptureBuffer);
                }
                if (updateCaptureBuffer != 0 || this.mNativeLenArr[0] <= 0) {
                    break;
                }
                this.mAudioBuffer.write(this.mNativeBuffer.array(), this.mNativeBuffer.arrayOffset(), this.mNativeLenArr[0]);
                if (this.mAudioBuffer.size() > 2048) {
                    this.mAudioBuffer.read(this.mBuffer, 0, 2048);
                    this.mAudioBuffer.delete(2048);
                    z = true;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
