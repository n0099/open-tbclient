package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.tieba.dc0;
import com.baidu.tieba.gt2;
import com.baidu.tieba.he4;
import com.baidu.tieba.ie4;
import com.baidu.tieba.vc0;
import com.baidu.tieba.w14;
import com.baidu.tieba.xc0;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {
    public AREngineDelegate a;
    public xc0 b;
    public RecorderState c;
    public dc0 d;
    public long e;
    public ie4 f = new a();

    /* loaded from: classes3.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    /* loaded from: classes3.dex */
    public class a implements ie4 {
        public a() {
        }

        @Override // com.baidu.tieba.ie4
        public void a(he4 he4Var) {
            if (GameRecorderController.this.d != null) {
                GameRecorderController.this.d.onAudioFrameAvailable(ByteBuffer.wrap(he4Var.a), (int) he4Var.b, he4Var.c - GameRecorderController.this.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements vc0 {
        public c() {
        }

        @Override // com.baidu.tieba.vc0
        public void a(dc0 dc0Var) {
            GameRecorderController.this.d = dc0Var;
            GameRecorderController.this.e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public final /* synthetic */ boolean a;

        public d(GameRecorderController gameRecorderController, boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setAudioRecord(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements xc0 {
        public e() {
        }

        @Override // com.baidu.tieba.xc0
        public void onError(int i) {
            GameRecorderController.this.c = RecorderState.IDLE;
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.onError(i);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.xc0
        public void w(int i, String str) {
            GameRecorderController.this.c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.w(i, str);
            }
        }

        @Override // com.baidu.tieba.xc0
        public void onPause() {
            GameRecorderController.this.c = RecorderState.PAUSE;
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.onPause();
            }
        }

        @Override // com.baidu.tieba.xc0
        public void onResume() {
            GameRecorderController.this.c = RecorderState.RECORDING;
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.onResume();
            }
        }

        @Override // com.baidu.tieba.xc0
        public void onStart() {
            GameRecorderController.this.c = RecorderState.RECORDING;
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.onStart();
            }
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        w14.h().e().post(new b());
    }

    public final void r(boolean z) {
        w14.h().e().post(new d(this, z));
    }

    public void s(xc0 xc0Var) {
        this.b = xc0Var;
    }

    public void t(int i, String str) {
        boolean z;
        if (this.a != null) {
            SwanAppActivity activity = gt2.U().getActivity();
            if (activity != null && activity.k0()) {
                z = true;
            } else {
                z = false;
            }
            this.a.setAudioEngineProxy(new c());
            this.a.startRecord(true, i, str, z);
        }
    }

    public static GameRecorderController j() {
        return new GameRecorderController(null);
    }

    public long k() {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getCurrentRecordProcess();
        }
        return 0L;
    }

    public RecorderState l() {
        return this.c;
    }

    public final void m() {
        if (this.d != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.d.a(true, audioParams);
        }
        r(true);
    }

    public final void n() {
        dc0 dc0Var = this.d;
        if (dc0Var != null) {
            dc0Var.onAudioStop(true);
        }
        r(false);
    }

    public void o() {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.pauseRecord();
        }
        r(false);
    }

    public void p() {
        if (this.a != null && this.b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
            this.b.onError(-1);
        }
        s(null);
        this.c = RecorderState.IDLE;
    }

    public void q() {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.resumeRecord();
        }
        r(true);
    }

    public void u() {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.stopRecord();
        }
    }
}
