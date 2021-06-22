package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.m0.a.g1.f;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {

    /* renamed from: a  reason: collision with root package name */
    public AREngineDelegate f11818a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.w.c.c f11819b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f11820c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.w.a.a.a f11821d;

    /* renamed from: e  reason: collision with root package name */
    public long f11822e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.l.a.b f11823f = new a();

    /* loaded from: classes3.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.l.a.b {
        public a() {
        }

        @Override // d.a.m0.l.a.b
        public void a(d.a.m0.l.a.a aVar) {
            if (GameRecorderController.this.f11821d != null) {
                GameRecorderController.this.f11821d.a(ByteBuffer.wrap(aVar.f51748a), (int) aVar.f51749b, aVar.f51750c - GameRecorderController.this.f11822e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f11823f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.w.c.a {
        public c() {
        }

        @Override // d.a.w.c.a
        public void a(d.a.w.a.a.a aVar) {
            GameRecorderController.this.f11821d = aVar;
            GameRecorderController.this.f11822e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11827e;

        public d(GameRecorderController gameRecorderController, boolean z) {
            this.f11827e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setAudioRecord(this.f11827e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.w.c.c {
        public e() {
        }

        @Override // d.a.w.c.c
        public void onError(int i2) {
            GameRecorderController.this.f11820c = RecorderState.IDLE;
            if (GameRecorderController.this.f11819b != null) {
                GameRecorderController.this.f11819b.onError(i2);
            }
        }

        @Override // d.a.w.c.c
        public void onPause() {
            GameRecorderController.this.f11820c = RecorderState.PAUSE;
            if (GameRecorderController.this.f11819b != null) {
                GameRecorderController.this.f11819b.onPause();
            }
        }

        @Override // d.a.w.c.c
        public void onResume() {
            GameRecorderController.this.f11820c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11819b != null) {
                GameRecorderController.this.f11819b.onResume();
            }
        }

        @Override // d.a.w.c.c
        public void onStart() {
            GameRecorderController.this.f11820c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11819b != null) {
                GameRecorderController.this.f11819b.onStart();
            }
        }

        @Override // d.a.w.c.c
        public void y(int i2, String str) {
            GameRecorderController.this.f11820c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.f11819b != null) {
                GameRecorderController.this.f11819b.y(i2, str);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.f11818a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f11820c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        d.a.m0.h.c.j.b.h().e().post(new b());
    }

    public static GameRecorderController j() {
        return new GameRecorderController(null);
    }

    public long k() {
        AREngineDelegate aREngineDelegate = this.f11818a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getCurrentRecordProcess();
        }
        return 0L;
    }

    public RecorderState l() {
        return this.f11820c;
    }

    public final void m() {
        if (this.f11821d != null) {
            int i2 = SwanAudioPlayer.mSampleRate;
            int i3 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i2 * 2);
            audioParams.setAudioBufferSize(i3 * 2);
            audioParams.setChannelConfig(1);
            this.f11821d.b(true, audioParams);
        }
        r(true);
    }

    public final void n() {
        d.a.w.a.a.a aVar = this.f11821d;
        if (aVar != null) {
            aVar.c(true);
        }
        r(false);
    }

    public void o() {
        AREngineDelegate aREngineDelegate = this.f11818a;
        if (aREngineDelegate != null) {
            aREngineDelegate.pauseRecord();
        }
        r(false);
    }

    public void p() {
        if (this.f11818a != null && this.f11819b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
            this.f11819b.onError(-1);
        }
        s(null);
        this.f11820c = RecorderState.IDLE;
    }

    public void q() {
        AREngineDelegate aREngineDelegate = this.f11818a;
        if (aREngineDelegate != null) {
            aREngineDelegate.resumeRecord();
        }
        r(true);
    }

    public final void r(boolean z) {
        d.a.m0.h.c.j.b.h().e().post(new d(this, z));
    }

    public void s(d.a.w.c.c cVar) {
        this.f11819b = cVar;
    }

    public void t(int i2, String str) {
        if (this.f11818a != null) {
            SwanAppActivity activity = f.V().getActivity();
            boolean z = activity != null && activity.isLandScape();
            this.f11818a.setAudioEngineProxy(new c());
            this.f11818a.startRecord(true, i2, str, z);
        }
    }

    public void u() {
        AREngineDelegate aREngineDelegate = this.f11818a;
        if (aREngineDelegate != null) {
            aREngineDelegate.stopRecord();
        }
    }
}
