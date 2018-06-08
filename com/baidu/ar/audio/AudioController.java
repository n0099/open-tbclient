package com.baidu.ar.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes3.dex */
public class AudioController implements IAudio, c {
    private static final String AUDIO_THREAD_NAME = "AudioHandlerThread";
    private static final String TAG = AudioController.class.getSimpleName();
    private static volatile AudioController sInstance;
    private com.baidu.ar.audio.a mAudioEngine;
    private Handler mAudioHandler;
    private HandlerThread mAudioThread;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private c a;

        public a(Looper looper, c cVar) {
            super(looper);
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a != null) {
                this.a.handleMessage(message);
            }
        }
    }

    private AudioController() {
    }

    public static AudioController getInstance() {
        if (sInstance == null) {
            synchronized (AudioController.class) {
                if (sInstance == null) {
                    sInstance = new AudioController();
                }
            }
        }
        return sInstance;
    }

    private void handleQuit() {
        this.mAudioThread.getLooper().quit();
        this.mAudioThread = null;
        this.mAudioHandler = null;
        releaseInstance();
    }

    private void handleReleaseAudioEngine() {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.c();
        }
        this.mAudioEngine = null;
    }

    private void handleSetupAudioEngine(AudioParams audioParams) {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.a(audioParams);
        }
    }

    private void handleStartAudioEngine() {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.a();
        }
    }

    private void handleStopAudioEngine() {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.b();
        }
    }

    private static void releaseInstance() {
        sInstance = null;
    }

    private void startAudioThread() {
        this.mAudioThread = new HandlerThread(AUDIO_THREAD_NAME);
        this.mAudioThread.start();
        this.mAudioHandler = new a(this.mAudioThread.getLooper(), this);
    }

    public AudioParams getAudioParams() {
        if (this.mAudioEngine != null) {
            return this.mAudioEngine.d();
        }
        return null;
    }

    @Override // com.baidu.ar.audio.c
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                handleSetupAudioEngine((AudioParams) message.obj);
                return;
            case 1002:
                handleStartAudioEngine();
                return;
            case 1003:
                handleStopAudioEngine();
                return;
            case 1004:
                handleReleaseAudioEngine();
                return;
            case 1005:
                handleQuit();
                return;
            default:
                return;
        }
    }

    public boolean hasPermission(Context context) {
        return b.a(context);
    }

    public boolean isRunning() {
        return this.mAudioThread != null && this.mAudioThread.isAlive();
    }

    @Override // com.baidu.ar.audio.IAudio
    public void releaseAudio() {
        if (this.mAudioHandler != null) {
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1004));
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1005));
        }
    }

    @Override // com.baidu.ar.audio.IAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.mAudioEngine == null) {
                this.mAudioEngine = new com.baidu.ar.audio.a();
            }
            this.mAudioEngine.a(volumeListener);
        }
    }

    @Override // com.baidu.ar.audio.IAudio
    public boolean setupAudio(AudioParams audioParams, AudioCallback audioCallback) {
        if (isRunning()) {
            Log.e(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.mAudioEngine == null) {
            this.mAudioEngine = new com.baidu.ar.audio.a();
        }
        this.mAudioEngine.a(audioCallback);
        startAudioThread();
        this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1001, audioParams));
        return true;
    }

    @Override // com.baidu.ar.audio.IAudio
    public void startAudio() {
        if (this.mAudioHandler != null) {
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1002));
        }
    }

    @Override // com.baidu.ar.audio.IAudio
    public void stopAudio() {
        handleStopAudioEngine();
    }
}
