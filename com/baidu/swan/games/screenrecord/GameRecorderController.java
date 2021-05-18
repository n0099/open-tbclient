package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.i0.a.g1.f;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {

    /* renamed from: a  reason: collision with root package name */
    public AREngineDelegate f11773a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.u.c.c f11774b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f11775c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.u.a.a.a f11776d;

    /* renamed from: e  reason: collision with root package name */
    public long f11777e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.l.a.b f11778f = new a();

    /* loaded from: classes3.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.l.a.b {
        public a() {
        }

        @Override // d.a.i0.l.a.b
        public void a(d.a.i0.l.a.a aVar) {
            if (GameRecorderController.this.f11776d != null) {
                GameRecorderController.this.f11776d.a(ByteBuffer.wrap(aVar.f47790a), (int) aVar.f47791b, aVar.f47792c - GameRecorderController.this.f11777e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f11778f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.u.c.a {
        public c() {
        }

        @Override // d.a.u.c.a
        public void a(d.a.u.a.a.a aVar) {
            GameRecorderController.this.f11776d = aVar;
            GameRecorderController.this.f11777e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11782e;

        public d(GameRecorderController gameRecorderController, boolean z) {
            this.f11782e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setAudioRecord(this.f11782e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.u.c.c {
        public e() {
        }

        @Override // d.a.u.c.c
        public void onError(int i2) {
            GameRecorderController.this.f11775c = RecorderState.IDLE;
            if (GameRecorderController.this.f11774b != null) {
                GameRecorderController.this.f11774b.onError(i2);
            }
        }

        @Override // d.a.u.c.c
        public void onPause() {
            GameRecorderController.this.f11775c = RecorderState.PAUSE;
            if (GameRecorderController.this.f11774b != null) {
                GameRecorderController.this.f11774b.onPause();
            }
        }

        @Override // d.a.u.c.c
        public void onResume() {
            GameRecorderController.this.f11775c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11774b != null) {
                GameRecorderController.this.f11774b.onResume();
            }
        }

        @Override // d.a.u.c.c
        public void onStart() {
            GameRecorderController.this.f11775c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11774b != null) {
                GameRecorderController.this.f11774b.onStart();
            }
        }

        @Override // d.a.u.c.c
        public void y(int i2, String str) {
            GameRecorderController.this.f11775c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.f11774b != null) {
                GameRecorderController.this.f11774b.y(i2, str);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.f11773a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f11775c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        d.a.i0.h.c.j.b.h().e().post(new b());
    }

    public static GameRecorderController j() {
        return new GameRecorderController(null);
    }

    public long k() {
        AREngineDelegate aREngineDelegate = this.f11773a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getCurrentRecordProcess();
        }
        return 0L;
    }

    public RecorderState l() {
        return this.f11775c;
    }

    public final void m() {
        if (this.f11776d != null) {
            int i2 = SwanAudioPlayer.mSampleRate;
            int i3 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i2 * 2);
            audioParams.setAudioBufferSize(i3 * 2);
            audioParams.setChannelConfig(1);
            this.f11776d.b(true, audioParams);
        }
        r(true);
    }

    public final void n() {
        d.a.u.a.a.a aVar = this.f11776d;
        if (aVar != null) {
            aVar.c(true);
        }
        r(false);
    }

    public void o() {
        AREngineDelegate aREngineDelegate = this.f11773a;
        if (aREngineDelegate != null) {
            aREngineDelegate.pauseRecord();
        }
        r(false);
    }

    public void p() {
        if (this.f11773a != null && this.f11774b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
            this.f11774b.onError(-1);
        }
        s(null);
        this.f11775c = RecorderState.IDLE;
    }

    public void q() {
        AREngineDelegate aREngineDelegate = this.f11773a;
        if (aREngineDelegate != null) {
            aREngineDelegate.resumeRecord();
        }
        r(true);
    }

    public final void r(boolean z) {
        d.a.i0.h.c.j.b.h().e().post(new d(this, z));
    }

    public void s(d.a.u.c.c cVar) {
        this.f11774b = cVar;
    }

    public void t(int i2, String str) {
        if (this.f11773a != null) {
            SwanAppActivity activity = f.V().getActivity();
            boolean z = activity != null && activity.isLandScape();
            this.f11773a.setAudioEngineProxy(new c());
            this.f11773a.startRecord(true, i2, str, z);
        }
    }

    public void u() {
        AREngineDelegate aREngineDelegate = this.f11773a;
        if (aREngineDelegate != null) {
            aREngineDelegate.stopRecord();
        }
    }
}
