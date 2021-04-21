package com.baidu.swan.apps.media.audio.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class SwanAppAudioService extends Service implements d.b.h0.a.b1.c.f.a {
    public static final boolean DEBUG = d.b.h0.a.k.f45772a;
    public static final int INVALID_DURATION = -1;
    public static final int INVALID_ERROR_CODE = -1;
    public static final String TAG = "SwanAppAudioService";
    public u<IAudioListener> mCallback = new u<>(this, null);
    public Binder mBinder = new AudioServiceStub(this);
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public static class AudioServiceStub extends IAudioService.Stub {
        public WeakReference<SwanAppAudioService> mAudioService;

        public AudioServiceStub(SwanAppAudioService swanAppAudioService) {
            this.mAudioService = new WeakReference<>(swanAppAudioService);
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
        public void registerListener(IAudioListener iAudioListener) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().mCallback.register(iAudioListener);
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void release() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().release();
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
        public void stop() throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().stop();
            }
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void unregisterListener(IAudioListener iAudioListener) throws RemoteException {
            WeakReference<SwanAppAudioService> weakReference = this.mAudioService;
            if (weakReference != null) {
                weakReference.get().mCallback.unregister(iAudioListener);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11932a;

        public a(String str) {
            this.f11932a = str;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onChangeSrc(this.f11932a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements t {
        public b() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onEnded();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f11935a;

        public c(int i) {
            this.f11935a = i;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onError(this.f11935a);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f11937a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f11938b;

        public d(int i, int i2) {
            this.f11937a = i;
            this.f11938b = i2;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onTimeUpdate(this.f11937a, this.f11938b);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f11940a;

        public e(int i) {
            this.f11940a = i;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onDownloadProgress(this.f11940a);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements t {
        public f() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPrev();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements t {
        public g() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onNext();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements t {
        public h() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onSeeking();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements t {
        public i() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onSeekEnd();
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class j {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11946a;

        static {
            int[] iArr = new int[BgMusicPlayState.values().length];
            f11946a = iArr;
            try {
                iArr[BgMusicPlayState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11946a[BgMusicPlayState.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11946a[BgMusicPlayState.REPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11946a[BgMusicPlayState.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11946a[BgMusicPlayState.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11946a[BgMusicPlayState.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11946a[BgMusicPlayState.INTERRUPT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11946a[BgMusicPlayState.LOADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11947e;

        public k(String str) {
            this.f11947e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.w0.a.e().a(this.f11947e, SwanAppAudioService.this);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.w0.a.e().play();
        }
    }

    /* loaded from: classes2.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.w0.a.e().pause();
        }
    }

    /* loaded from: classes2.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.w0.a.e().stop();
        }
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppAudioService.this.notifyEventOnStop();
            SwanAppAudioService.this.stopSelf();
            d.b.h0.a.w0.a.e().onRelease();
        }
    }

    /* loaded from: classes2.dex */
    public class p implements t {
        public p() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onCanPlay();
        }
    }

    /* loaded from: classes2.dex */
    public class q implements t {
        public q() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPlay();
        }
    }

    /* loaded from: classes2.dex */
    public class r implements t {
        public r() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPause();
        }
    }

    /* loaded from: classes2.dex */
    public class s implements t {
        public s() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.t
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onStop();
        }
    }

    /* loaded from: classes2.dex */
    public interface t<E extends IAudioListener> {
        void a(E e2) throws RemoteException;
    }

    /* loaded from: classes2.dex */
    public class u<E extends IAudioListener> extends RemoteCallbackList<IAudioListener> {
        public u() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(IAudioListener iAudioListener) {
            if (SwanAppAudioService.DEBUG) {
                Log.d(SwanAppAudioService.TAG, "onCallbackDied: " + iAudioListener.getClass().getName());
            }
            SwanAppAudioService.this.stop();
        }

        public /* synthetic */ u(SwanAppAudioService swanAppAudioService, k kVar) {
            this();
        }
    }

    private void handleAudioEvent(@NonNull t tVar) {
        try {
            try {
                int beginBroadcast = this.mCallback.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    tVar.a(this.mCallback.getBroadcastItem(i2));
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
        int i2 = j.f11946a[bgMusicPlayState.ordinal()];
        if (i2 == 1) {
            notifyEventOnCanPlay();
        } else if (i2 == 2) {
            notifyEventOnPlay();
        } else if (i2 == 4) {
            notifyEventOnPause();
        } else if (i2 == 5) {
            notifyEventOnStop();
        } else if (i2 != 6) {
        } else {
            notifyEventOnEnded();
        }
    }

    private void notifyEventOnCanPlay() {
        handleAudioEvent(new p());
    }

    private void notifyEventOnEnded() {
        handleAudioEvent(new b());
    }

    private void notifyEventOnError(int i2) {
        handleAudioEvent(new c(i2));
    }

    private void notifyEventOnPause() {
        handleAudioEvent(new r());
    }

    private void notifyEventOnPlay() {
        handleAudioEvent(new q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEventOnStop() {
        handleAudioEvent(new s());
    }

    private void notifyOnChangeSrc(String str) {
        handleAudioEvent(new a(str));
    }

    public int getDuration() {
        return d.b.h0.a.w0.a.e().getDuration();
    }

    public boolean isDestroyed() {
        return false;
    }

    public boolean isPlaying() {
        return d.b.h0.a.w0.a.e().isPlaying();
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
    public void onCreate() {
        super.onCreate();
        if (DEBUG) {
            Log.d(TAG, MissionEvent.MESSAGE_CREATE);
        }
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

    public void onError(int i2) {
        notifyEventOnError(i2);
    }

    @Override // d.b.h0.a.b1.c.f.a
    public void onGetCurrentSong(String str) {
        notifyOnChangeSrc(str);
    }

    @Override // d.b.h0.a.b1.c.f.a
    public void onGetDownloadProgress(int i2) {
        handleAudioEvent(new e(i2));
    }

    @Override // d.b.h0.a.b1.c.f.a
    public void onGetDuration(int i2) {
    }

    @Override // d.b.h0.a.b1.c.f.a
    public void onGetPosition(int i2, int i3) {
        handleAudioEvent(new d(i2, i3));
    }

    @Override // d.b.h0.a.b1.c.f.a
    public void onInvokeFailed() {
        notifyEventOnError(-1);
    }

    public void onNext() {
        handleAudioEvent(new g());
    }

    public void onPlayModeChange(int i2) {
    }

    public void onPrev() {
        handleAudioEvent(new f());
    }

    public void onSeekEnd() {
        handleAudioEvent(new i());
    }

    public void onSeeking() {
        handleAudioEvent(new h());
    }

    @Override // d.b.h0.a.b1.c.f.a
    public void onStateChanged(BgMusicPlayState bgMusicPlayState) {
        if (DEBUG) {
            Log.d(TAG, "onStateChanged() " + bgMusicPlayState);
        }
        handleStateChanged(bgMusicPlayState);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onUnbind");
            return false;
        }
        return false;
    }

    public void pause() {
        this.mMainHandler.post(new m());
    }

    public void play() {
        this.mMainHandler.post(new l());
    }

    public void release() {
        this.mMainHandler.post(new o());
    }

    public void seek(int i2) {
        d.b.h0.a.w0.a.e().seek(i2);
    }

    public void setParams(String str) {
        this.mMainHandler.post(new k(str));
    }

    public void stop() {
        this.mMainHandler.post(new n());
    }
}
