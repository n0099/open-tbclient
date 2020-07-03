package com.baidu.ala.recorder.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import com.baidu.ala.helper.AlaAudioBuffer;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.ndk.AudioProcessModule;
import com.baidu.live.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
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
    private AudioManager mAudioManager = null;
    private boolean mRunOpenSLES = false;
    private volatile AlaAudioRecorderCallback mCallback = null;
    private long mLastCaptureTimestamp = 0;
    private AudioProcessModule.CaptureCallback mOpenSLESCallback = null;
    private BroadcastReceiver mReceiver = null;
    private AlaAudioFrame mAudioFrame = new AlaAudioFrame();
    private int[] mNativePosArr = new int[1];
    private int[] mNativeLenArr = new int[1];

    /* loaded from: classes3.dex */
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
        } else if (this.mEnableACE && this.mRunOpenSLES) {
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
        } else {
            return false;
        }
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
        if (this.mAudioManager == null) {
            try {
                this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
            } catch (Exception e) {
                BdLog.e(e);
            }
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
                } else {
                    registerHeadset();
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
        unregisterHeadset();
        if (this.mRunOpenSLES && AudioProcessModule.sharedInstance().audioRecorderStop() != 0) {
            BdLog.e("OpenSLES audio recorder stop failed");
        }
        if (this.mEnableACE) {
            if (AudioProcessModule.sharedInstance().destroyAudioProcessModule() != 0) {
                BdLog.e("destroy apm  failed");
            }
            AudioProcessModule.sharedInstance().setCaptureCallback(null);
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

    private void registerHeadset() {
        try {
            if (this.mContext != null) {
                if (this.mReceiver == null) {
                    this.mReceiver = new HeadSetReceiver();
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                try {
                    if (this.mAudioManager.isBluetoothScoAvailableOffCall()) {
                        intentFilter.addAction("android.media.SCO_AUDIO_STATE_CHANGED");
                        this.mAudioManager.startBluetoothSco();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mContext.registerReceiver(this.mReceiver, intentFilter);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void unregisterHeadset() {
        if (this.mReceiver != null && this.mContext != null) {
            try {
                if (this.mAudioManager != null && this.mAudioManager.isBluetoothScoOn()) {
                    this.mAudioManager.setBluetoothScoOn(false);
                    this.mAudioManager.stopBluetoothSco();
                }
                this.mContext.unregisterReceiver(this.mReceiver);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    this.mContext.unregisterReceiver(this.mReceiver);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class HeadSetReceiver extends BroadcastReceiver {
        private AudioManager audioManager;

        public HeadSetReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.media.SCO_AUDIO_STATE_CHANGED".equals(action)) {
                if (1 == intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) && AlaAudioRecorder.this.mAudioManager != null) {
                    AlaAudioRecorder.this.mAudioManager.setBluetoothScoOn(true);
                    try {
                        AlaAudioRecorder.this.mContext.unregisterReceiver(this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if ("android.intent.action.HEADSET_PLUG".equals(action) && intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) == 0) {
                    AlaAudioRecorder.this.setEnableSpeaker(context, true);
                } else if (intent.getIntExtra("state", 0) == 1) {
                    AlaAudioRecorder.this.setEnableSpeaker(context, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnableSpeaker(Context context, boolean z) {
        if (this.mAudioManager == null) {
            try {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception e) {
                BdLog.e(e);
                return;
            }
        }
        try {
            this.mAudioManager.setSpeakerphoneOn(z);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
