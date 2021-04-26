package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.h0.a.z0.f;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {

    /* renamed from: a  reason: collision with root package name */
    public AREngineDelegate f12431a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.u.c.c f12432b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f12433c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.u.a.a.a f12434d;

    /* renamed from: e  reason: collision with root package name */
    public long f12435e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.j.a.b f12436f = new a();

    /* loaded from: classes3.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.j.a.b {
        public a() {
        }

        @Override // d.a.h0.j.a.b
        public void a(d.a.h0.j.a.a aVar) {
            if (GameRecorderController.this.f12434d != null) {
                GameRecorderController.this.f12434d.a(ByteBuffer.wrap(aVar.f47103a), (int) aVar.f47104b, aVar.f47105c - GameRecorderController.this.f12435e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f12436f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.u.c.a {
        public c() {
        }

        @Override // d.a.u.c.a
        public void a(d.a.u.a.a.a aVar) {
            GameRecorderController.this.f12434d = aVar;
            GameRecorderController.this.f12435e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f12440e;

        public d(GameRecorderController gameRecorderController, boolean z) {
            this.f12440e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setAudioRecord(this.f12440e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.u.c.c {
        public e() {
        }

        @Override // d.a.u.c.c
        public void onError(int i2) {
            GameRecorderController.this.f12433c = RecorderState.IDLE;
            if (GameRecorderController.this.f12432b != null) {
                GameRecorderController.this.f12432b.onError(i2);
            }
        }

        @Override // d.a.u.c.c
        public void onPause() {
            GameRecorderController.this.f12433c = RecorderState.PAUSE;
            if (GameRecorderController.this.f12432b != null) {
                GameRecorderController.this.f12432b.onPause();
            }
        }

        @Override // d.a.u.c.c
        public void onResume() {
            GameRecorderController.this.f12433c = RecorderState.RECORDING;
            if (GameRecorderController.this.f12432b != null) {
                GameRecorderController.this.f12432b.onResume();
            }
        }

        @Override // d.a.u.c.c
        public void onStart() {
            GameRecorderController.this.f12433c = RecorderState.RECORDING;
            if (GameRecorderController.this.f12432b != null) {
                GameRecorderController.this.f12432b.onStart();
            }
        }

        @Override // d.a.u.c.c
        public void z(int i2, String str) {
            GameRecorderController.this.f12433c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.f12432b != null) {
                GameRecorderController.this.f12432b.z(i2, str);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.f12431a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f12433c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        d.a.h0.g.c.j.b.h().e().post(new b());
    }

    public static GameRecorderController j() {
        return new GameRecorderController(null);
    }

    public long k() {
        AREngineDelegate aREngineDelegate = this.f12431a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getCurrentRecordProcess();
        }
        return 0L;
    }

    public RecorderState l() {
        return this.f12433c;
    }

    public final void m() {
        if (this.f12434d != null) {
            int i2 = SwanAudioPlayer.mSampleRate;
            int i3 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i2 * 2);
            audioParams.setAudioBufferSize(i3 * 2);
            audioParams.setChannelConfig(1);
            this.f12434d.b(true, audioParams);
        }
        r(true);
    }

    public final void n() {
        d.a.u.a.a.a aVar = this.f12434d;
        if (aVar != null) {
            aVar.c(true);
        }
        r(false);
    }

    public void o() {
        AREngineDelegate aREngineDelegate = this.f12431a;
        if (aREngineDelegate != null) {
            aREngineDelegate.pauseRecord();
        }
        r(false);
    }

    public void p() {
        if (this.f12431a != null && this.f12432b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
            this.f12432b.onError(-1);
        }
        s(null);
        this.f12433c = RecorderState.IDLE;
    }

    public void q() {
        AREngineDelegate aREngineDelegate = this.f12431a;
        if (aREngineDelegate != null) {
            aREngineDelegate.resumeRecord();
        }
        r(true);
    }

    public final void r(boolean z) {
        d.a.h0.g.c.j.b.h().e().post(new d(this, z));
    }

    public void s(d.a.u.c.c cVar) {
        this.f12432b = cVar;
    }

    public void t(int i2, String str) {
        if (this.f12431a != null) {
            SwanAppActivity activity = f.V().getActivity();
            boolean z = activity != null && activity.isLandScape();
            this.f12431a.setAudioEngineProxy(new c());
            this.f12431a.startRecord(true, i2, str, z);
        }
    }

    public void u() {
        AREngineDelegate aREngineDelegate = this.f12431a;
        if (aREngineDelegate != null) {
            aREngineDelegate.stopRecord();
        }
    }
}
