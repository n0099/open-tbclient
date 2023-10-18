package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.tieba.b90;
import com.baidu.tieba.cr2;
import com.baidu.tieba.d90;
import com.baidu.tieba.dc4;
import com.baidu.tieba.ec4;
import com.baidu.tieba.j80;
import com.baidu.tieba.sz3;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class GameRecorderController {
    public AREngineDelegate a;
    public d90 b;
    public RecorderState c;
    public j80 d;
    public long e;
    public ec4 f = new a();

    /* loaded from: classes4.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    /* loaded from: classes4.dex */
    public class a implements ec4 {
        public a() {
        }

        @Override // com.baidu.tieba.ec4
        public void a(dc4 dc4Var) {
            if (GameRecorderController.this.d != null) {
                GameRecorderController.this.d.onAudioFrameAvailable(ByteBuffer.wrap(dc4Var.a), (int) dc4Var.b, dc4Var.c - GameRecorderController.this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.f);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b90 {
        public c() {
        }

        @Override // com.baidu.tieba.b90
        public void a(j80 j80Var) {
            GameRecorderController.this.d = j80Var;
            GameRecorderController.this.e = System.nanoTime();
            GameRecorderController.this.m();
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class e implements d90 {
        public e() {
        }

        @Override // com.baidu.tieba.d90
        public void onError(int i) {
            GameRecorderController.this.c = RecorderState.IDLE;
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.onError(i);
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.d90
        public void v(int i, String str) {
            GameRecorderController.this.c = RecorderState.STOP;
            GameRecorderController.this.n();
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.v(i, str);
            }
        }

        @Override // com.baidu.tieba.d90
        public void onPause() {
            GameRecorderController.this.c = RecorderState.PAUSE;
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.onPause();
            }
        }

        @Override // com.baidu.tieba.d90
        public void onResume() {
            GameRecorderController.this.c = RecorderState.RECORDING;
            if (GameRecorderController.this.b != null) {
                GameRecorderController.this.b.onResume();
            }
        }

        @Override // com.baidu.tieba.d90
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
        sz3.h().e().post(new b());
    }

    public final void r(boolean z) {
        sz3.h().e().post(new d(this, z));
    }

    public void s(d90 d90Var) {
        this.b = d90Var;
    }

    public void t(int i, String str) {
        boolean z;
        if (this.a != null) {
            SwanAppActivity activity = cr2.V().getActivity();
            if (activity != null && activity.j0()) {
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
        j80 j80Var = this.d;
        if (j80Var != null) {
            j80Var.onAudioStop(true);
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
