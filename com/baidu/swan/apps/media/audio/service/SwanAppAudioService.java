package com.baidu.swan.apps.media.audio.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class SwanAppAudioService extends Service implements com.baidu.swan.apps.media.audio.service.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int INVALID_DURATION = -1;
    private static final int INVALID_ERROR_CODE = -1;
    private static final String TAG = "SwanAppAudioService";
    private b<IAudioListener> mCallback = new b<>();
    private Binder mBinder = new AudioServiceStub(this);
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface a<E extends IAudioListener> {
        void a(E e) throws RemoteException;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (DEBUG) {
            Log.d(TAG, MissionEvent.MESSAGE_CREATE);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind");
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onUnbind");
            return false;
        }
        return false;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (DEBUG) {
            Log.d(TAG, MissionEvent.MESSAGE_DESTROY);
        }
        this.mCallback.kill();
        this.mMainHandler.removeCallbacksAndMessages(null);
        release();
        super.onDestroy();
    }

    private void handleStateChanged(BgMusicPlayState bgMusicPlayState) {
        switch (bgMusicPlayState) {
            case READY:
                notifyEventOnCanPlay();
                return;
            case PLAY:
                notifyEventOnPlay();
                return;
            case REPLAY:
            case INTERRUPT:
            case LOADING:
            default:
                return;
            case PAUSE:
                notifyEventOnPause();
                return;
            case STOP:
                notifyEventOnStop();
                return;
            case END:
                notifyEventOnEnded();
                return;
        }
    }

    public void setParams(final String str) {
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.w.a.Sf().a(str, SwanAppAudioService.this);
            }
        });
    }

    public void play() {
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.12
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.w.a.Sf().play();
            }
        });
    }

    public void pause() {
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.13
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.w.a.Sf().pause();
            }
        });
    }

    public void stop() {
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.14
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.w.a.Sf().stop();
            }
        });
    }

    public void seek(int i) {
        com.baidu.swan.apps.w.a.Sf().seek(i);
    }

    public int getDuration() {
        return com.baidu.swan.apps.w.a.Sf().getDuration();
    }

    public boolean isPlaying() {
        return com.baidu.swan.apps.w.a.Sf().isPlaying();
    }

    public void release() {
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.15
            @Override // java.lang.Runnable
            public void run() {
                SwanAppAudioService.this.notifyEventOnStop();
                SwanAppAudioService.this.stopSelf();
                com.baidu.swan.apps.w.a.Sf().onRelease();
            }
        });
    }

    private void notifyEventOnCanPlay() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.16
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onCanPlay();
            }
        });
    }

    private void notifyEventOnPlay() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.17
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onPlay();
            }
        });
    }

    private void notifyEventOnPause() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.18
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onPause();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEventOnStop() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.19
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onStop();
            }
        });
    }

    private void notifyOnChangeSrc(final String str) {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.2
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onChangeSrc(str);
            }
        });
    }

    private void notifyEventOnEnded() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.3
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onEnded();
            }
        });
    }

    private void notifyEventOnError(final int i) {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.4
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onError(i);
            }
        });
    }

    @Override // com.baidu.swan.apps.media.audio.service.a
    public void onStateChanged(BgMusicPlayState bgMusicPlayState) {
        if (DEBUG) {
            Log.d(TAG, "onStateChanged() " + bgMusicPlayState);
        }
        handleStateChanged(bgMusicPlayState);
    }

    @Override // com.baidu.swan.apps.media.audio.service.a
    public void onGetDuration(int i) {
    }

    @Override // com.baidu.swan.apps.media.audio.service.a
    public void onGetPosition(final int i, final int i2) {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.5
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onTimeUpdate(i, i2);
            }
        });
    }

    @Override // com.baidu.swan.apps.media.audio.service.a
    public void onGetDownloadProgress(final int i) {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.6
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onDownloadProgress(i);
            }
        });
    }

    @Override // com.baidu.swan.apps.media.audio.service.a
    public void onGetCurrentSong(String str) {
        notifyOnChangeSrc(str);
    }

    public void onPlayModeChange(int i) {
    }

    @Override // com.baidu.swan.apps.media.audio.service.a
    public void onInvokeFailed() {
        notifyEventOnError(-1);
    }

    public boolean isDestroyed() {
        return false;
    }

    public void onPrev() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.7
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onPrev();
            }
        });
    }

    public void onNext() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.8
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onNext();
            }
        });
    }

    public void onSeeking() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.9
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onSeeking();
            }
        });
    }

    public void onSeekEnd() {
        handleAudioEvent(new a() { // from class: com.baidu.swan.apps.media.audio.service.SwanAppAudioService.10
            @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.a
            public void a(IAudioListener iAudioListener) throws RemoteException {
                iAudioListener.onSeekEnd();
            }
        });
    }

    public void onError(int i) {
        notifyEventOnError(i);
    }

    /* loaded from: classes10.dex */
    static class AudioServiceStub extends IAudioService.Stub {
        private WeakReference<SwanAppAudioService> mAudioService;

        AudioServiceStub(SwanAppAudioService swanAppAudioService) {
            this.mAudioService = new WeakReference<>(swanAppAudioService);
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void setParams(String str) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().setParams(str);
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public int getDuration() throws RemoteException {
            if (this.mAudioService.get() != null) {
                return this.mAudioService.get().getDuration();
            }
            return -1;
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void play() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().play();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void pause() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().pause();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void stop() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().stop();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void seek(int i) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().seek(i);
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public boolean isPlaying() throws RemoteException {
            if (this.mAudioService.get() != null) {
                return this.mAudioService.get().isPlaying();
            }
            return false;
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void release() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().release();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void registerListener(IAudioListener iAudioListener) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().mCallback.register(iAudioListener);
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void unregisterListener(IAudioListener iAudioListener) throws RemoteException {
            if (this.mAudioService != null) {
                this.mAudioService.get().mCallback.unregister(iAudioListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b<E extends IAudioListener> extends RemoteCallbackList<IAudioListener> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.RemoteCallbackList
        /* renamed from: b */
        public void onCallbackDied(IAudioListener iAudioListener) {
            if (SwanAppAudioService.DEBUG) {
                Log.d(SwanAppAudioService.TAG, "onCallbackDied: " + iAudioListener.getClass().getName());
            }
            SwanAppAudioService.this.stop();
        }
    }

    private void handleAudioEvent(@NonNull a aVar) {
        try {
            int beginBroadcast = this.mCallback.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                aVar.a(this.mCallback.getBroadcastItem(i));
            }
        } catch (RemoteException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        } finally {
            this.mCallback.finishBroadcast();
        }
    }
}
