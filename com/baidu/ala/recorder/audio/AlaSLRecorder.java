package com.baidu.ala.recorder.audio;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.helper.AlaAudioPlugins;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.ndk.AudioProcessModule;
import com.baidu.ala.recorder.audio.IAudioService;
/* loaded from: classes14.dex */
public class AlaSLRecorder implements IAudioService {
    private static final int STATUS_IDEL = 0;
    private static final int STATUS_WORK = 1;
    private static final String TAG = AlaSLRecorder.class.getSimpleName();
    private Context mContext = null;
    private AlaAudioPlugins mAudioPlugin = null;
    private AlaAudioFrame mAudioFrame = new AlaAudioFrame();
    private IAudioService.FrameCallback mCallback = null;
    private AlaAudioConfig mAudioConfig = null;
    private int mStatus = 0;
    private long mLastCaptureTimestamp = 0;
    private long mInterval = 0;
    private AudioProcessModule.CaptureCallback mOpenSLESCallback = new AudioProcessModule.CaptureCallback() { // from class: com.baidu.ala.recorder.audio.AlaSLRecorder.1
        @Override // com.baidu.ala.ndk.AudioProcessModule.CaptureCallback
        public void onCaptureData(int i) {
            Log.i(AlaSLRecorder.TAG, "mOpenSLESCallback.onCaptureData len:" + i);
            if (i > 0) {
                AlaSLRecorder.this.mLastCaptureTimestamp = System.currentTimeMillis();
            }
        }
    };

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onCreate(Context context, IAudioService.FrameCallback frameCallback) {
        this.mContext = context;
        this.mCallback = frameCallback;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public boolean start(AlaAudioConfig alaAudioConfig) {
        if (alaAudioConfig == null) {
            BdLog.e("AlaSLRecorder start error, config = null");
            return false;
        } else if (this.mStatus != 0) {
            BdLog.e("AlaSLRecorder start error, status = " + this.mStatus);
            return false;
        } else {
            this.mAudioConfig = new AlaAudioConfig(alaAudioConfig);
            initData();
            setup(alaAudioConfig.sampleRate, alaAudioConfig.format);
            boolean startDevice = startDevice();
            this.mStatus = 1;
            return startDevice;
        }
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public boolean stop() {
        if (this.mStatus == 0) {
            BdLog.e("AlaSLRecorder stop error, status = " + this.mStatus);
            return true;
        }
        boolean stopDevice = stopDevice();
        this.mStatus = 0;
        return stopDevice;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public AlaAudioFrame readFrame() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > this.mLastCaptureTimestamp + 5000) {
                if (this.mCallback != null) {
                    this.mCallback.onError(300, "No Data error = 300");
                }
                this.mLastCaptureTimestamp = currentTimeMillis;
            }
            Thread.sleep(this.mInterval);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.mAudioFrame;
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void onDestroy() {
        this.mStatus = 0;
        stopDevice();
        if (this.mAudioPlugin != null) {
            this.mAudioPlugin.onDestroy();
            this.mAudioPlugin = null;
        }
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public void mute(boolean z) {
        if (this.mStatus != 0) {
            if (AudioProcessModule.sharedInstance().audioRecorderSetOpt(z ? 3 : 4) != 0) {
                BdLog.e("OpenSLES audio recorder mute/unmute failed, on:" + z);
            }
        }
    }

    @Override // com.baidu.ala.recorder.audio.IAudioService
    public int getType() {
        return 3;
    }

    private void initData() {
        if (this.mAudioPlugin == null) {
            this.mAudioPlugin = new AlaAudioPlugins(this.mContext);
        }
        if (this.mAudioConfig != null && this.mAudioConfig.sampleRate > 0) {
            this.mInterval = 900000 / this.mAudioConfig.sampleRate;
        } else {
            this.mInterval = 20L;
        }
    }

    private void setup(int i, int i2) {
        int i3 = i2 == 12 ? 2 : 1;
        AudioProcessModule.sharedInstance().createAudioProcessModule(i, i, i3, i3, 1, 1, 1);
        AudioProcessModule.sharedInstance().updateSystemInfo(Build.VERSION.SDK_INT, Build.MODEL);
        AudioProcessModule.sharedInstance().createAudioRecorder(i, i3, i / 100);
    }

    private boolean startDevice() {
        this.mLastCaptureTimestamp = System.currentTimeMillis();
        if (AudioProcessModule.sharedInstance().audioRecorderStart() == 0) {
            AudioProcessModule.sharedInstance().setCaptureCallback(this.mOpenSLESCallback);
        }
        this.mAudioPlugin.startListen();
        return true;
    }

    private boolean stopDevice() {
        if (AudioProcessModule.sharedInstance().audioRecorderStop() != 0) {
            BdLog.e("OpenSLES audio recorder stop failed");
        }
        this.mAudioPlugin.stopListen();
        if (AudioProcessModule.sharedInstance().destroyAudioProcessModule() != 0) {
            BdLog.e("destroy apm  failed");
        }
        AudioProcessModule.sharedInstance().setCaptureCallback(null);
        return true;
    }
}
