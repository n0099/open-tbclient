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
/* loaded from: classes3.dex */
public final class SwanAppAudioService extends Service implements d.a.m0.a.i1.c.f.a {
    public static final boolean DEBUG = d.a.m0.a.k.f46983a;
    public static final int INVALID_DURATION = -1;
    public static final int INVALID_ERROR_CODE = -1;
    public static final String TAG = "SwanAppAudioService";
    public v<IAudioListener> mCallback = new v<>(this, null);
    public Binder mBinder = new AudioServiceStub(this);
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
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
        public void seek(int i2) throws RemoteException {
            if (this.mAudioService.get() != null) {
                this.mAudioService.get().seek(i2);
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

    /* loaded from: classes3.dex */
    public class a implements u {
        public a() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onStop();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10982a;

        public b(String str) {
            this.f10982a = str;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onChangeSrc(this.f10982a);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements u {
        public c() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onEnded();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f10985a;

        public d(int i2) {
            this.f10985a = i2;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onError(this.f10985a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f10987a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f10988b;

        public e(int i2, int i3) {
            this.f10987a = i2;
            this.f10988b = i3;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onTimeUpdate(this.f10987a, this.f10988b);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f10990a;

        public f(int i2) {
            this.f10990a = i2;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onDownloadProgress(this.f10990a);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements u {
        public g() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPrev();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements u {
        public h() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onNext();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements u {
        public i() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onSeeking();
        }
    }

    /* loaded from: classes3.dex */
    public class j implements u {
        public j() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onSeekEnd();
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10996e;

        public k(String str) {
            this.f10996e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.c1.a.e().a(this.f10996e, SwanAppAudioService.this);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class l {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10998a;

        static {
            int[] iArr = new int[BgMusicPlayState.values().length];
            f10998a = iArr;
            try {
                iArr[BgMusicPlayState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10998a[BgMusicPlayState.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10998a[BgMusicPlayState.REPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10998a[BgMusicPlayState.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10998a[BgMusicPlayState.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10998a[BgMusicPlayState.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10998a[BgMusicPlayState.INTERRUPT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10998a[BgMusicPlayState.LOADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.c1.a.e().play();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.c1.a.e().pause();
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.c1.a.e().stop();
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f11002e;

        public p(int i2) {
            this.f11002e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.c1.a.e().seek(this.f11002e);
        }
    }

    /* loaded from: classes3.dex */
    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppAudioService.this.notifyEventOnStop();
            SwanAppAudioService.this.stopSelf();
            d.a.m0.a.c1.a.e().onRelease();
        }
    }

    /* loaded from: classes3.dex */
    public class r implements u {
        public r() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onCanPlay();
        }
    }

    /* loaded from: classes3.dex */
    public class s implements u {
        public s() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPlay();
        }
    }

    /* loaded from: classes3.dex */
    public class t implements u {
        public t() {
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            iAudioListener.onPause();
        }
    }

    /* loaded from: classes3.dex */
    public interface u<E extends IAudioListener> {
        void a(E e2) throws RemoteException;
    }

    /* loaded from: classes3.dex */
    public class v<E extends IAudioListener> extends RemoteCallbackList<IAudioListener> {
        public v() {
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

        public /* synthetic */ v(SwanAppAudioService swanAppAudioService, k kVar) {
            this();
        }
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
        int i2 = l.f10998a[bgMusicPlayState.ordinal()];
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
        handleAudioEvent(new r());
    }

    private void notifyEventOnEnded() {
        handleAudioEvent(new c());
    }

    private void notifyEventOnError(int i2) {
        handleAudioEvent(new d(i2));
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

    private void notifyOnChangeSrc(String str) {
        handleAudioEvent(new b(str));
    }

    public int getDuration() {
        return d.a.m0.a.c1.a.e().getDuration();
    }

    public boolean isDestroyed() {
        return false;
    }

    public boolean isPlaying() {
        return d.a.m0.a.c1.a.e().isPlaying();
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

    @Override // d.a.m0.a.i1.c.f.a
    public void onGetCurrentSong(String str) {
        notifyOnChangeSrc(str);
    }

    @Override // d.a.m0.a.i1.c.f.a
    public void onGetDownloadProgress(int i2) {
        handleAudioEvent(new f(i2));
    }

    @Override // d.a.m0.a.i1.c.f.a
    public void onGetDuration(int i2) {
    }

    @Override // d.a.m0.a.i1.c.f.a
    public void onGetPosition(int i2, int i3) {
        handleAudioEvent(new e(i2, i3));
    }

    @Override // d.a.m0.a.i1.c.f.a
    public void onInvokeFailed() {
        notifyEventOnError(-1);
    }

    public void onNext() {
        handleAudioEvent(new h());
    }

    public void onPlayModeChange(int i2) {
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

    @Override // d.a.m0.a.i1.c.f.a
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
        this.mMainHandler.post(new n());
    }

    public void play() {
        this.mMainHandler.post(new m());
    }

    public void release() {
        this.mMainHandler.post(new q());
    }

    public void seek(int i2) {
        this.mMainHandler.post(new p(i2));
    }

    public void setParams(String str) {
        this.mMainHandler.post(new k(str));
    }

    public void stop() {
        this.mMainHandler.post(new o());
    }
}
