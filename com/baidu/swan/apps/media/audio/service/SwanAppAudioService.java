package com.baidu.swan.apps.media.audio.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.tieba.nt2;
import com.baidu.tieba.qd3;
import com.baidu.tieba.rp2;
import com.baidu.tieba.rt2;
import com.baidu.tieba.vm1;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public final class SwanAppAudioService extends Service implements rt2 {
    public static final boolean DEBUG = vm1.a;
    public static final int INVALID_DURATION = -1;
    public static final int INVALID_ERROR_CODE = -1;
    public static final String TAG = "SwanAppAudioService";
    public v<IAudioListener> mCallback = new v<>(this, null);
    public Binder mBinder = new AudioServiceStub(this);
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public interface u<E extends IAudioListener> {
        void a(E e) throws RemoteException;
    }

    public boolean isDestroyed() {
        return false;
    }

    @Override // com.baidu.tieba.rt2
    public void onGetDuration(int i2) {
    }

    public void onPlayModeChange(int i2) {
    }

    /* loaded from: classes4.dex */
    public static class AudioServiceStub extends IAudioService.Stub {
        public WeakReference<SwanAppAudioService> mAudioService;

        public AudioServiceStub(SwanAppAudioService swanAppAudioService) {
            this.mAudioService = new WeakReference<>(swanAppAudioService);
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void registerListener(IAudioListener iAudioListener) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().mCallback.register(iAudioListener);
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void seek(int i) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().seek(i);
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void setParams(String str) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().setParams(str);
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void unregisterListener(IAudioListener iAudioListener) throws RemoteException {
            WeakReference<SwanAppAudioService> weakReference = this.mAudioService;
            if (weakReference != null) {
                weakReference.get().mCallback.unregister(iAudioListener);
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
        public boolean isPlaying() throws RemoteException {
            if (this.mAudioService.get() != null) {
                return this.mAudioService.get().isPlaying();
            }
            return false;
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void pause() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().pause();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void play() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().play();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void release() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().release();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void stop() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().stop();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements u {
        public a() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onStop();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements u {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onChangeSrc(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements u {
        public c() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onEnded();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements u {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onError(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements u {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onTimeUpdate(this.a, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements u {
        public final /* synthetic */ int a;

        public f(int i) {
            this.a = i;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onDownloadProgress(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements u {
        public g() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPrev();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements u {
        public h() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onNext();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements u {
        public i() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onSeeking();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements u {
        public j() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onSeekEnd();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;

        public k(long j, String str) {
            this.a = j;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            nt2.b(SwanAppAudioService.TAG, "post#setParams id=" + this.a + " params=" + this.b);
            rp2.f().a(this.b, SwanAppAudioService.this);
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class l {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BgMusicPlayState.values().length];
            a = iArr;
            try {
                iArr[BgMusicPlayState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BgMusicPlayState.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BgMusicPlayState.REPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BgMusicPlayState.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BgMusicPlayState.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[BgMusicPlayState.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[BgMusicPlayState.INTERRUPT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[BgMusicPlayState.LOADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public final /* synthetic */ long a;

        public m(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            nt2.b(SwanAppAudioService.TAG, "post#play  id=" + this.a);
            rp2.f().play();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public final /* synthetic */ long a;

        public n(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            nt2.b(SwanAppAudioService.TAG, "post#pause  id=" + this.a);
            rp2.f().pause();
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public final /* synthetic */ long a;

        public o(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            nt2.b(SwanAppAudioService.TAG, "post#stop id=" + this.a);
            rp2.f().stop();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;

        public p(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            nt2.b(SwanAppAudioService.TAG, "post#seek id=" + this.a + " position=" + this.b);
            rp2.f().seek(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class q implements Runnable {
        public final /* synthetic */ long a;

        public q(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            nt2.b(SwanAppAudioService.TAG, "post#release id=" + this.a);
            SwanAppAudioService.this.notifyEventOnStop();
            SwanAppAudioService.this.stopSelf();
            rp2.f().onRelease();
        }
    }

    /* loaded from: classes4.dex */
    public class r implements u {
        public r() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onCanPlay();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements u {
        public s() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPlay();
        }
    }

    /* loaded from: classes4.dex */
    public class t implements u {
        public t() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPause();
        }
    }

    /* loaded from: classes4.dex */
    public class v<E extends IAudioListener> extends RemoteCallbackList<IAudioListener> {
        public v() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(IAudioListener iAudioListener) {
            nt2.b(SwanAppAudioService.TAG, "AudioRemoteCallbackList#onCallbackDied");
            SwanAppAudioService.this.stop();
        }

        public /* synthetic */ v(SwanAppAudioService swanAppAudioService, k kVar) {
            this();
        }
    }

    private void notifyEventOnCanPlay() {
        handleAudioEvent(new r());
    }

    private void notifyEventOnEnded() {
        handleAudioEvent(new c());
    }

    private void notifyEventOnPause() {
        handleAudioEvent(new t());
    }

    private void notifyEventOnPlay() {
        handleAudioEvent(new s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEventOnStop() {
        handleAudioEvent(new a());
    }

    public int getDuration() {
        return rp2.f().getDuration();
    }

    public boolean isPlaying() {
        return rp2.f().isPlaying();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        nt2.b(TAG, "#onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        nt2.b(TAG, "#onDestroy");
        this.mCallback.kill();
        this.mMainHandler.removeCallbacksAndMessages(null);
        release();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.rt2
    public void onInvokeFailed() {
        qd3.b("audio", 2001, "invoke fail", -1, "");
        notifyEventOnError(-1);
    }

    public void onNext() {
        handleAudioEvent(new h());
    }

    public void onPrev() {
        handleAudioEvent(new g());
    }

    public void onSeekEnd() {
        handleAudioEvent(new j());
    }

    public void onSeeking() {
        handleAudioEvent(new i());
    }

    public void pause() {
        long nanoTime = System.nanoTime();
        nt2.b(TAG, "#pause id=" + nanoTime);
        this.mMainHandler.post(new n(nanoTime));
    }

    public void play() {
        long nanoTime = System.nanoTime();
        nt2.b(TAG, "#play id=" + nanoTime);
        this.mMainHandler.post(new m(nanoTime));
    }

    public void release() {
        long nanoTime = System.nanoTime();
        nt2.b(TAG, "#release id=" + nanoTime);
        this.mMainHandler.post(new q(nanoTime));
    }

    public void stop() {
        long nanoTime = System.nanoTime();
        nt2.b(TAG, "#stop id=" + nanoTime);
        this.mMainHandler.post(new o(nanoTime));
    }

    private void handleAudioEvent(@NonNull u uVar) {
        try {
            try {
                int beginBroadcast = this.mCallback.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    uVar.a(this.mCallback.getBroadcastItem(i2));
                }
            } catch (RemoteException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        } finally {
            this.mCallback.finishBroadcast();
        }
    }

    private void handleStateChanged(BgMusicPlayState bgMusicPlayState) {
        int i2 = l.a[bgMusicPlayState.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            notifyEventOnEnded();
                            return;
                        }
                        return;
                    }
                    notifyEventOnStop();
                    return;
                }
                notifyEventOnPause();
                return;
            }
            notifyEventOnPlay();
            return;
        }
        notifyEventOnCanPlay();
    }

    private void notifyEventOnError(int i2) {
        handleAudioEvent(new d(i2));
    }

    private void notifyOnChangeSrc(String str) {
        handleAudioEvent(new b(str));
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        nt2.b(TAG, "#onBind");
        return this.mBinder;
    }

    public void onError(int i2) {
        qd3.b("audio", 2008, "error code is" + i2, -1, "");
        notifyEventOnError(i2);
    }

    @Override // com.baidu.tieba.rt2
    public void onGetCurrentSong(String str) {
        notifyOnChangeSrc(str);
    }

    @Override // com.baidu.tieba.rt2
    public void onGetDownloadProgress(int i2) {
        handleAudioEvent(new f(i2));
    }

    @Override // com.baidu.tieba.rt2
    public void onStateChanged(BgMusicPlayState bgMusicPlayState) {
        nt2.c(TAG, "#onStateChanged state=" + bgMusicPlayState, new Exception("stack"));
        handleStateChanged(bgMusicPlayState);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        nt2.b(TAG, "#onUnbind");
        return false;
    }

    public void seek(int i2) {
        long nanoTime = System.nanoTime();
        nt2.b(TAG, "#seek id=" + nanoTime);
        this.mMainHandler.post(new p(nanoTime, i2));
    }

    public void setParams(String str) {
        long nanoTime = System.nanoTime();
        nt2.b(TAG, "#setParams id=" + nanoTime);
        this.mMainHandler.post(new k(nanoTime, str));
    }

    @Override // com.baidu.tieba.rt2
    public void onGetPosition(int i2, int i3) {
        handleAudioEvent(new e(i2, i3));
    }
}
