package com.baidu.ala.recorder.audio;

import android.content.Context;
import android.media.AudioRecord;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.recorder.audio.IAudioService;
/* loaded from: classes5.dex */
public class AlaStdRecorder implements IAudioService {
    private AlaAudioConfig mAudioConfig = null;
    private volatile AudioRecord mAudioRecord = null;
    private byte[] mBuffer = null;
    private Context mContext = null;
    private AlaAudioFrame mAudioFrame = new AlaAudioFrame();
    private IAudioService.FrameCallback mCallback = null;

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onCreate(Context context, IAudioService.FrameCallback frameCallback) {
        this.mContext = context;
        this.mCallback = frameCallback;
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
            this.mCallback.onError(101, "std read failed error = 101");
            return null;
        }
        return null;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onDestroy() {
        stopDevice();
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void mute(boolean z) {
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public int getType() {
        return 1;
    }

    private void initData() {
        if (this.mBuffer == null) {
            this.mBuffer = new byte[2048];
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
                this.mAudioRecord = new AudioRecord(1, i, i2, 2, minBufferSize);
                if (this.mAudioRecord.getState() == 0) {
                    this.mAudioRecord = null;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                this.mAudioRecord = null;
                if (this.mCallback != null) {
                    this.mCallback.onError(100, "IllegalArgumentException setup failed error = 100");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mAudioRecord = null;
                if (this.mCallback != null) {
                    this.mCallback.onError(100, "Exception setup failed error = 100");
                }
            }
        }
    }

    private boolean startDevice() {
        if (this.mAudioRecord == null || this.mAudioRecord.getState() != 1) {
            return false;
        }
        try {
            this.mAudioRecord.startRecording();
            return this.mAudioRecord.getRecordingState() == 3;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    private boolean stopDevice() {
        if (this.mAudioRecord != null) {
            try {
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
            } catch (Exception e) {
                BdLog.e(" catch Exception " + e);
                if (this.mCallback != null) {
                    this.mCallback.onError(102, "close failed error = 102");
                }
            }
            this.mAudioRecord = null;
        }
        return true;
    }
}
