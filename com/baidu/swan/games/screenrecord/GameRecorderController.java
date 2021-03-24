package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.b.g0.a.z0.f;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {

    /* renamed from: a  reason: collision with root package name */
    public AREngineDelegate f12868a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.u.c.c f12869b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f12870c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.u.a.a.a f12871d;

    /* renamed from: e  reason: collision with root package name */
    public long f12872e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.j.a.b f12873f = new a();

    /* loaded from: classes3.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.j.a.b {
        public a() {
        }

        @Override // d.b.g0.j.a.b
        public void a(d.b.g0.j.a.a aVar) {
            if (GameRecorderController.this.f12871d != null) {
                GameRecorderController.this.f12871d.a(ByteBuffer.wrap(aVar.f48875a), (int) aVar.f48876b, aVar.f48877c - GameRecorderController.this.f12872e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f12873f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.u.c.a {
        public c() {
        }

        @Override // d.b.u.c.a
        public void a(d.b.u.a.a.a aVar) {
            GameRecorderController.this.f12871d = aVar;
            GameRecorderController.this.f12872e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f12877e;

        public d(GameRecorderController gameRecorderController, boolean z) {
            this.f12877e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setAudioRecord(this.f12877e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.u.c.c {
        public e() {
        }

        @Override // d.b.u.c.c
        public void onError(int i) {
            GameRecorderController.this.f12870c = RecorderState.IDLE;
            if (GameRecorderController.this.f12869b != null) {
                GameRecorderController.this.f12869b.onError(i);
            }
        }

        @Override // d.b.u.c.c
        public void onPause() {
            GameRecorderController.this.f12870c = RecorderState.PAUSE;
            if (GameRecorderController.this.f12869b != null) {
                GameRecorderController.this.f12869b.onPause();
            }
        }

        @Override // d.b.u.c.c
        public void onResume() {
            GameRecorderController.this.f12870c = RecorderState.RECORDING;
            if (GameRecorderController.this.f12869b != null) {
                GameRecorderController.this.f12869b.onResume();
            }
        }

        @Override // d.b.u.c.c
        public void onStart() {
            GameRecorderController.this.f12870c = RecorderState.RECORDING;
            if (GameRecorderController.this.f12869b != null) {
                GameRecorderController.this.f12869b.onStart();
            }
        }

        @Override // d.b.u.c.c
        public void w(int i, String str) {
            GameRecorderController.this.f12870c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.f12869b != null) {
                GameRecorderController.this.f12869b.w(i, str);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.f12868a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f12870c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        d.b.g0.g.c.j.b.h().e().post(new b());
    }

    public static GameRecorderController j() {
        return new GameRecorderController(null);
    }

    public long k() {
        AREngineDelegate aREngineDelegate = this.f12868a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getCurrentRecordProcess();
        }
        return 0L;
    }

    public RecorderState l() {
        return this.f12870c;
    }

    public final void m() {
        if (this.f12871d != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.f12871d.c(true, audioParams);
        }
        r(true);
    }

    public final void n() {
        d.b.u.a.a.a aVar = this.f12871d;
        if (aVar != null) {
            aVar.b(true);
        }
        r(false);
    }

    public void o() {
        AREngineDelegate aREngineDelegate = this.f12868a;
        if (aREngineDelegate != null) {
            aREngineDelegate.pauseRecord();
        }
        r(false);
    }

    public void p() {
        if (this.f12868a != null && this.f12869b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
            this.f12869b.onError(-1);
        }
        s(null);
        this.f12870c = RecorderState.IDLE;
    }

    public void q() {
        AREngineDelegate aREngineDelegate = this.f12868a;
        if (aREngineDelegate != null) {
            aREngineDelegate.resumeRecord();
        }
        r(true);
    }

    public final void r(boolean z) {
        d.b.g0.g.c.j.b.h().e().post(new d(this, z));
    }

    public void s(d.b.u.c.c cVar) {
        this.f12869b = cVar;
    }

    public void t(int i, String str) {
        if (this.f12868a != null) {
            SwanAppActivity activity = f.V().getActivity();
            boolean z = activity != null && activity.isLandScape();
            this.f12868a.setAudioEngineProxy(new c());
            this.f12868a.startRecord(true, i, str, z);
        }
    }

    public void u() {
        AREngineDelegate aREngineDelegate = this.f12868a;
        if (aREngineDelegate != null) {
            aREngineDelegate.stopRecord();
        }
    }
}
