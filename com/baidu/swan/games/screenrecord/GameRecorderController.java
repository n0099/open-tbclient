package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.l0.a.g1.f;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {

    /* renamed from: a  reason: collision with root package name */
    public AREngineDelegate f11736a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.w.c.c f11737b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f11738c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.w.a.a.a f11739d;

    /* renamed from: e  reason: collision with root package name */
    public long f11740e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.l.a.b f11741f = new a();

    /* loaded from: classes3.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.l.a.b {
        public a() {
        }

        @Override // d.a.l0.l.a.b
        public void a(d.a.l0.l.a.a aVar) {
            if (GameRecorderController.this.f11739d != null) {
                GameRecorderController.this.f11739d.a(ByteBuffer.wrap(aVar.f51640a), (int) aVar.f51641b, aVar.f51642c - GameRecorderController.this.f11740e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f11741f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.w.c.a {
        public c() {
        }

        @Override // d.a.w.c.a
        public void a(d.a.w.a.a.a aVar) {
            GameRecorderController.this.f11739d = aVar;
            GameRecorderController.this.f11740e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11745e;

        public d(GameRecorderController gameRecorderController, boolean z) {
            this.f11745e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setAudioRecord(this.f11745e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.w.c.c {
        public e() {
        }

        @Override // d.a.w.c.c
        public void onError(int i2) {
            GameRecorderController.this.f11738c = RecorderState.IDLE;
            if (GameRecorderController.this.f11737b != null) {
                GameRecorderController.this.f11737b.onError(i2);
            }
        }

        @Override // d.a.w.c.c
        public void onPause() {
            GameRecorderController.this.f11738c = RecorderState.PAUSE;
            if (GameRecorderController.this.f11737b != null) {
                GameRecorderController.this.f11737b.onPause();
            }
        }

        @Override // d.a.w.c.c
        public void onResume() {
            GameRecorderController.this.f11738c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11737b != null) {
                GameRecorderController.this.f11737b.onResume();
            }
        }

        @Override // d.a.w.c.c
        public void onStart() {
            GameRecorderController.this.f11738c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11737b != null) {
                GameRecorderController.this.f11737b.onStart();
            }
        }

        @Override // d.a.w.c.c
        public void y(int i2, String str) {
            GameRecorderController.this.f11738c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.f11737b != null) {
                GameRecorderController.this.f11737b.y(i2, str);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.f11736a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f11738c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        d.a.l0.h.c.j.b.h().e().post(new b());
    }

    public static GameRecorderController j() {
        return new GameRecorderController(null);
    }

    public long k() {
        AREngineDelegate aREngineDelegate = this.f11736a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getCurrentRecordProcess();
        }
        return 0L;
    }

    public RecorderState l() {
        return this.f11738c;
    }

    public final void m() {
        if (this.f11739d != null) {
            int i2 = SwanAudioPlayer.mSampleRate;
            int i3 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i2 * 2);
            audioParams.setAudioBufferSize(i3 * 2);
            audioParams.setChannelConfig(1);
            this.f11739d.b(true, audioParams);
        }
        r(true);
    }

    public final void n() {
        d.a.w.a.a.a aVar = this.f11739d;
        if (aVar != null) {
            aVar.c(true);
        }
        r(false);
    }

    public void o() {
        AREngineDelegate aREngineDelegate = this.f11736a;
        if (aREngineDelegate != null) {
            aREngineDelegate.pauseRecord();
        }
        r(false);
    }

    public void p() {
        if (this.f11736a != null && this.f11737b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
            this.f11737b.onError(-1);
        }
        s(null);
        this.f11738c = RecorderState.IDLE;
    }

    public void q() {
        AREngineDelegate aREngineDelegate = this.f11736a;
        if (aREngineDelegate != null) {
            aREngineDelegate.resumeRecord();
        }
        r(true);
    }

    public final void r(boolean z) {
        d.a.l0.h.c.j.b.h().e().post(new d(this, z));
    }

    public void s(d.a.w.c.c cVar) {
        this.f11737b = cVar;
    }

    public void t(int i2, String str) {
        if (this.f11736a != null) {
            SwanAppActivity activity = f.V().getActivity();
            boolean z = activity != null && activity.isLandScape();
            this.f11736a.setAudioEngineProxy(new c());
            this.f11736a.startRecord(true, i2, str, z);
        }
    }

    public void u() {
        AREngineDelegate aREngineDelegate = this.f11736a;
        if (aREngineDelegate != null) {
            aREngineDelegate.stopRecord();
        }
    }
}
