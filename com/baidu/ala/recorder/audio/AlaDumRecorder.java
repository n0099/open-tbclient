package com.baidu.ala.recorder.audio;

import android.content.Context;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.recorder.audio.IAudioService;
import java.util.Arrays;
/* loaded from: classes14.dex */
class AlaDumRecorder implements IAudioService {
    private AlaAudioConfig mAudioConfig = null;
    private byte[] mBuffer = null;
    private AlaAudioFrame mAudioFrame = new AlaAudioFrame();
    private IAudioService.FrameCallback mCallback = null;
    private long mInterval = 0;

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onCreate(Context context, IAudioService.FrameCallback frameCallback) {
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
        return true;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public boolean stop() {
        return true;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public AlaAudioFrame readFrame() {
        try {
            Arrays.fill(this.mBuffer, (byte) 0);
            this.mAudioFrame.fillAudioData(this.mBuffer, 2048);
            Thread.sleep(this.mInterval);
            return this.mAudioFrame;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onDestroy() {
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void mute(boolean z) {
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public int getType() {
        return 4;
    }

    private void initData() {
        if (this.mBuffer == null) {
            this.mBuffer = new byte[2048];
        }
        if (this.mAudioConfig != null && this.mAudioConfig.sampleRate > 0) {
            this.mInterval = 900000 / this.mAudioConfig.sampleRate;
        } else {
            this.mInterval = 20L;
        }
    }
}
