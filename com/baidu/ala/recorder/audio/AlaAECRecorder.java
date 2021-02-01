package com.baidu.ala.recorder.audio;

import android.content.Context;
import android.media.AudioRecord;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.helper.AlaAudioBuffer;
import com.baidu.ala.helper.AlaAudioPlugins;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.ndk.AudioProcessModule;
import com.baidu.ala.recorder.audio.IAudioService;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AlaAECRecorder implements IAudioService {
    private int mFramesPerBuffer = 256;
    private volatile AudioRecord mAudioRecord = null;
    private byte[] mBuffer = null;
    private ByteBuffer mNativeBuffer = null;
    private AlaAudioBuffer mAudioBuffer = null;
    private Context mContext = null;
    private AlaAudioPlugins mAudioPlugin = null;
    private AlaAudioFrame mAudioFrame = new AlaAudioFrame();
    private AlaAudioConfig mAudioConfig = null;
    private IAudioService.FrameCallback mCallback = null;
    private int[] mNativePosArr = new int[1];
    private int[] mNativeLenArr = new int[1];

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onCreate(Context context, IAudioService.FrameCallback frameCallback) {
        this.mContext = context;
        IAudioService.FrameCallback frameCallback2 = this.mCallback;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public boolean start(AlaAudioConfig alaAudioConfig) {
        if (alaAudioConfig == null) {
            BdLog.e("AlaStdRecorder start, config = null");
            return false;
        }
        this.mAudioConfig = new AlaAudioConfig(alaAudioConfig);
        initData();
        setup(alaAudioConfig.sampleRate, alaAudioConfig.format);
        return startDevice();
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public boolean stop() {
        return stopDevice();
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public AlaAudioFrame readFrame() {
        boolean z = false;
        if (this.mAudioRecord == null) {
            return null;
        }
        if (!this.mAudioConfig.enableAPM) {
            return read1KSamples();
        }
        while (true) {
            try {
                int read = this.mAudioRecord.read(this.mNativeBuffer.array(), this.mNativeBuffer.arrayOffset(), this.mFramesPerBuffer);
                if (read != this.mFramesPerBuffer) {
                    if (this.mCallback != null) {
                        this.mCallback.onError(201, "read failed error = 201");
                    }
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
        if (z) {
            this.mAudioFrame.fillAudioData(this.mBuffer, 2048);
            return this.mAudioFrame;
        }
        return null;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onDestroy() {
        stopDevice();
        if (this.mAudioPlugin != null) {
            this.mAudioPlugin.onDestroy();
            this.mAudioPlugin = null;
        }
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void mute(boolean z) {
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public int getType() {
        return 2;
    }

    private AlaAudioFrame read1KSamples() {
        if (this.mAudioRecord == null) {
            return null;
        }
        int read = this.mAudioRecord.read(this.mBuffer, 0, 2048);
        if (read == 2048) {
            this.mAudioFrame.fillAudioData(this.mBuffer, 2048);
            return this.mAudioFrame;
        }
        BdLog.e("audiorecorder read data error. length is " + read);
        if (this.mCallback != null) {
            this.mCallback.onError(201, "read failed error = 201");
            return null;
        }
        return null;
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
        if (this.mAudioPlugin == null) {
            this.mAudioPlugin = new AlaAudioPlugins(this.mContext);
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
                this.mAudioRecord = new AudioRecord(7, i, i2, 2, minBufferSize);
                this.mFramesPerBuffer = (i / 100) * 2;
                int i3 = i2 == 12 ? 2 : 1;
                AudioProcessModule.sharedInstance().createAudioProcessModule(i, i, i3, i3, 0, 1, 1);
                AudioProcessModule.sharedInstance().setCaptureBuffer(this.mNativeBuffer, 1.4f);
                if (this.mAudioRecord.getState() == 0) {
                    this.mAudioRecord = null;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                this.mAudioRecord = null;
                if (this.mCallback != null) {
                    this.mCallback.onError(200, "setup failed error = 200");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mAudioRecord = null;
                if (this.mCallback != null) {
                    this.mCallback.onError(200, "setup failed error = 200");
                }
            }
        }
    }

    private boolean startDevice() {
        if (this.mAudioRecord != null && this.mAudioRecord.getState() == 1) {
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    return false;
                }
            } catch (IllegalStateException e) {
                return false;
            }
        }
        this.mAudioPlugin.startListen();
        return true;
    }

    private boolean stopDevice() {
        if (this.mAudioRecord != null) {
            try {
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
            } catch (Exception e) {
                BdLog.e("audiorecorder catch Exception " + e);
                if (this.mCallback != null) {
                    this.mCallback.onError(202, "close failed error = 202");
                }
            }
            this.mAudioRecord = null;
            this.mAudioPlugin.stopListen();
            if (AudioProcessModule.sharedInstance().destroyAudioProcessModule() != 0) {
                BdLog.e("destroy apm  failed");
            }
            AudioProcessModule.sharedInstance().setCaptureCallback(null);
        }
        return true;
    }
}
