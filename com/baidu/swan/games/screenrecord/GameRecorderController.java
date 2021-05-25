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
    public AREngineDelegate f11674a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.w.c.c f11675b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f11676c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.w.a.a.a f11677d;

    /* renamed from: e  reason: collision with root package name */
    public long f11678e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.l.a.b f11679f = new a();

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
            if (GameRecorderController.this.f11677d != null) {
                GameRecorderController.this.f11677d.a(ByteBuffer.wrap(aVar.f47966a), (int) aVar.f47967b, aVar.f47968c - GameRecorderController.this.f11678e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f11679f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.w.c.a {
        public c() {
        }

        @Override // d.a.w.c.a
        public void a(d.a.w.a.a.a aVar) {
            GameRecorderController.this.f11677d = aVar;
            GameRecorderController.this.f11678e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11683e;

        public d(GameRecorderController gameRecorderController, boolean z) {
            this.f11683e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setAudioRecord(this.f11683e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.w.c.c {
        public e() {
        }

        @Override // d.a.w.c.c
        public void onError(int i2) {
            GameRecorderController.this.f11676c = RecorderState.IDLE;
            if (GameRecorderController.this.f11675b != null) {
                GameRecorderController.this.f11675b.onError(i2);
            }
        }

        @Override // d.a.w.c.c
        public void onPause() {
            GameRecorderController.this.f11676c = RecorderState.PAUSE;
            if (GameRecorderController.this.f11675b != null) {
                GameRecorderController.this.f11675b.onPause();
            }
        }

        @Override // d.a.w.c.c
        public void onResume() {
            GameRecorderController.this.f11676c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11675b != null) {
                GameRecorderController.this.f11675b.onResume();
            }
        }

        @Override // d.a.w.c.c
        public void onStart() {
            GameRecorderController.this.f11676c = RecorderState.RECORDING;
            if (GameRecorderController.this.f11675b != null) {
                GameRecorderController.this.f11675b.onStart();
            }
        }

        @Override // d.a.w.c.c
        public void y(int i2, String str) {
            GameRecorderController.this.f11676c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.f11675b != null) {
                GameRecorderController.this.f11675b.y(i2, str);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.f11674a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f11676c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        d.a.l0.h.c.j.b.h().e().post(new b());
    }

    public static GameRecorderController j() {
        return new GameRecorderController(null);
    }

    public long k() {
        AREngineDelegate aREngineDelegate = this.f11674a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getCurrentRecordProcess();
        }
        return 0L;
    }

    public RecorderState l() {
        return this.f11676c;
    }

    public final void m() {
        if (this.f11677d != null) {
            int i2 = SwanAudioPlayer.mSampleRate;
            int i3 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i2 * 2);
            audioParams.setAudioBufferSize(i3 * 2);
            audioParams.setChannelConfig(1);
            this.f11677d.b(true, audioParams);
        }
        r(true);
    }

    public final void n() {
        d.a.w.a.a.a aVar = this.f11677d;
        if (aVar != null) {
            aVar.c(true);
        }
        r(false);
    }

    public void o() {
        AREngineDelegate aREngineDelegate = this.f11674a;
        if (aREngineDelegate != null) {
            aREngineDelegate.pauseRecord();
        }
        r(false);
    }

    public void p() {
        if (this.f11674a != null && this.f11675b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
            this.f11675b.onError(-1);
        }
        s(null);
        this.f11676c = RecorderState.IDLE;
    }

    public void q() {
        AREngineDelegate aREngineDelegate = this.f11674a;
        if (aREngineDelegate != null) {
            aREngineDelegate.resumeRecord();
        }
        r(true);
    }

    public final void r(boolean z) {
        d.a.l0.h.c.j.b.h().e().post(new d(this, z));
    }

    public void s(d.a.w.c.c cVar) {
        this.f11675b = cVar;
    }

    public void t(int i2, String str) {
        if (this.f11674a != null) {
            SwanAppActivity activity = f.V().getActivity();
            boolean z = activity != null && activity.isLandScape();
            this.f11674a.setAudioEngineProxy(new c());
            this.f11674a.startRecord(true, i2, str, z);
        }
    }

    public void u() {
        AREngineDelegate aREngineDelegate = this.f11674a;
        if (aREngineDelegate != null) {
            aREngineDelegate.stopRecord();
        }
    }
}
