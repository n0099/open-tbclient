package com.baidu.swan.games.audio;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.az2;
import com.baidu.tieba.b64;
import com.baidu.tieba.bp2;
import com.baidu.tieba.cc3;
import com.baidu.tieba.d84;
import com.baidu.tieba.f64;
import com.baidu.tieba.g64;
import com.baidu.tieba.ib2;
import com.baidu.tieba.iz2;
import com.baidu.tieba.kj2;
import com.baidu.tieba.lb2;
import com.baidu.tieba.ms1;
import com.baidu.tieba.px2;
import com.baidu.tieba.si4;
import com.baidu.tieba.w54;
import com.baidu.tieba.z74;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AudioPlayer implements az2, si4 {
    public static final boolean o = ms1.a;
    public iz2 a;
    public String d;
    public g64 e;
    public int h;
    public String i;
    public String j;
    public d k;
    public boolean m;
    public long n;
    public PlayerStatus b = PlayerStatus.NONE;
    public UserStatus c = UserStatus.OPEN;
    public w54 f = new w54();
    public e g = new e();
    public float l = -1.0f;

    /* loaded from: classes4.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* loaded from: classes4.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* loaded from: classes4.dex */
    public class a implements TypedCallbackHandler {
    }

    @Override // com.baidu.tieba.az2
    public String f() {
        return null;
    }

    @Override // com.baidu.tieba.az2
    public Object i() {
        return this;
    }

    @Override // com.baidu.tieba.az2
    public void j(boolean z) {
    }

    @Override // com.baidu.tieba.az2
    public boolean onBackPressed() {
        return false;
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AudioPlayer.this.P();
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f64.h().e().post(new a());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b64 {
        public c() {
        }

        @Override // com.baidu.tieba.b64
        public void a(String str, String str2) {
            AudioPlayer.this.j = str2;
            AudioPlayer.this.w();
        }

        @Override // com.baidu.tieba.b64
        public void fail(int i, String str) {
            String str2;
            AudioPlayer audioPlayer = AudioPlayer.this;
            if (!SwanAppNetworkUtils.i(null)) {
                str2 = "10003";
            } else {
                str2 = "10002";
            }
            audioPlayer.L(str2);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.J("onSeeked");
        }

        public /* synthetic */ d(AudioPlayer audioPlayer, a aVar) {
            this();
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.o) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.H()) {
                    AudioPlayer.this.h = (((int) AudioPlayer.this.A()) * i) / 100;
                    if (AudioPlayer.this.a != null) {
                        AudioPlayer.this.J("onBufferingUpdate");
                        if (AudioPlayer.this.b == PlayerStatus.PREPARED && AudioPlayer.this.c != UserStatus.STOP && (i * AudioPlayer.this.A()) / 100 <= AudioPlayer.this.z()) {
                            AudioPlayer.this.J("onWaiting");
                        }
                    }
                }
            } catch (Exception e) {
                if (AudioPlayer.o) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "comCompletion");
            }
            try {
                if (!AudioPlayer.this.f.f) {
                    AudioPlayer.this.c = UserStatus.STOP;
                    AudioPlayer.this.F();
                }
                AudioPlayer.this.J("onEnded");
            } catch (Exception e) {
                if (AudioPlayer.o) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "onError : what is " + i + " extra is " + i2);
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.f.a + " url = " + AudioPlayer.this.f.c);
            }
            String str = "-1";
            if (i != 1 && i == 100) {
                str = "10001";
            }
            if (i2 == -1007) {
                str = "10004";
            }
            AudioPlayer.this.L(str);
            AudioPlayer.this.F();
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "oninfo : what is " + i + " extra is " + i2);
                return false;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer audioPlayer = AudioPlayer.this;
            audioPlayer.b = PlayerStatus.PREPARED;
            if (!audioPlayer.m) {
                AudioPlayer.this.J("onCanplay");
            }
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.j);
            }
            AudioPlayer.this.m = true;
            UserStatus userStatus = UserStatus.PLAY;
            AudioPlayer audioPlayer2 = AudioPlayer.this;
            if (userStatus == audioPlayer2.c) {
                audioPlayer2.Q();
            }
            try {
                if (AudioPlayer.this.f.d > 0.0f) {
                    AudioPlayer.this.B().seek(AudioPlayer.this.f.d);
                } else if (AudioPlayer.this.l >= 0.0f) {
                    AudioPlayer.this.B().seek(AudioPlayer.this.l);
                    AudioPlayer.this.l = -1.0f;
                }
            } catch (Exception e) {
                if (AudioPlayer.o) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class e extends Handler {
        public e() {
            super(f64.h().e().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.b == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.z() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.A() / 1000));
                    AudioPlayer.this.K("onTimeUpdate", jSONObject);
                } catch (Exception e) {
                    if (AudioPlayer.o) {
                        e.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public long A() {
        try {
            if (0 == this.n && this.e != null) {
                return this.e.getDuration();
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
        return this.n;
    }

    public g64 B() {
        g64 g64Var = this.e;
        if (g64Var == null || g64Var.s()) {
            this.e = f64.h().d(this.j, this.f.f);
            S();
        }
        return this.e;
    }

    public final kj2 C() {
        SwanAppActivity w;
        cc3 M = cc3.M();
        if (M == null || !M.w0() || (w = M.w()) == null) {
            return null;
        }
        bp2 R = w.R();
        if (!(R instanceof d84)) {
            return null;
        }
        return ((d84) R).g1();
    }

    public float D() {
        w54 w54Var = this.f;
        if (w54Var != null) {
            return w54Var.i;
        }
        return 1.0f;
    }

    public final void E() {
        J(MissionEvent.MESSAGE_PAUSE);
        this.g.removeMessages(0);
    }

    public final void F() {
        this.b = PlayerStatus.IDLE;
        g64 g64Var = this.e;
        if (g64Var != null) {
            g64Var.destroy();
            this.e = null;
        }
        this.g.removeMessages(0);
    }

    public final boolean G() {
        ib2 m;
        if (cc3.M() != null && cc3.M().w0()) {
            lb2 U = px2.T().U();
            if (U == null || (m = U.m()) == null || !(m instanceof z74)) {
                return true;
            }
            return ((z74) m).F3();
        }
        return false;
    }

    public final boolean H() {
        if (this.e != null && this.b == PlayerStatus.PREPARED) {
            return true;
        }
        return false;
    }

    public boolean I() {
        UserStatus userStatus = UserStatus.STOP;
        UserStatus userStatus2 = this.c;
        if (userStatus != userStatus2 && UserStatus.DESTROY != userStatus2) {
            return true;
        }
        return false;
    }

    public void O() {
        this.c = UserStatus.PAUSE;
        P();
    }

    public final void P() {
        if (H()) {
            this.e.pause();
        }
    }

    public void T() {
        F();
        this.m = false;
        this.c = UserStatus.DESTROY;
        this.b = PlayerStatus.NONE;
    }

    public void Y() {
        this.c = UserStatus.STOP;
        if (H()) {
            this.e.stop();
        }
        F();
        J(MissionEvent.MESSAGE_STOP);
    }

    public final void Z() {
        if (o) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.f.toString());
        }
        W(this.f.f);
        X(this.f.i);
    }

    @Override // com.baidu.tieba.az2
    public String b() {
        return this.f.b;
    }

    @Override // com.baidu.tieba.az2
    public String c() {
        return this.d;
    }

    @Override // com.baidu.tieba.az2
    public void onDestroy() {
        cc3 M = cc3.M();
        if (M != null && M.w0()) {
            T();
        }
    }

    @Override // com.baidu.tieba.si4
    public void onPause() {
        E();
    }

    public final void w() {
        R();
    }

    public final boolean x() throws JSONException {
        File file = new File(this.j);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        L("10003");
        return false;
    }

    public int y() {
        return this.h;
    }

    public int z() {
        if (H()) {
            return this.e.v();
        }
        return 0;
    }

    public AudioPlayer(String str) {
        this.d = "";
        this.d = str;
    }

    public final void J(String str) {
        K(str, null);
    }

    public final void L(String str) {
        if (this.a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(StatConstants.KEY_EXT_ERR_CODE, str);
            } catch (JSONException e2) {
                if (o) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e2));
                }
            }
            this.a.b(GameAssistConstKt.TYPE_CALLBACK_ERROR, jSONObject);
        }
    }

    public void V(iz2 iz2Var) {
        this.a = iz2Var;
    }

    public final void W(boolean z) {
        try {
            if (H()) {
                this.e.a(z);
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public final void X(float f) {
        if (H()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.e.setVolume(f);
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tieba.az2
    public void k(boolean z) {
        kj2 C;
        cc3 M = cc3.M();
        if (M != null && M.w0() && !z && (C = C()) != null && !C.r0()) {
            C.runOnJSThread(new b());
        }
    }

    public void update(w54 w54Var) {
        this.f = w54Var;
        iz2 iz2Var = this.a;
        if (iz2Var != null) {
            iz2Var.d(w54Var.j);
        }
        Z();
    }

    public final void K(String str, JSONObject jSONObject) {
        iz2 iz2Var = this.a;
        if (iz2Var != null) {
            iz2Var.b(str, jSONObject);
        }
    }

    public final void M() {
        try {
            if (this.i.contains("http")) {
                f64 h = f64.h();
                File file = new File(h.g(this.i));
                if (file.exists() && !file.isDirectory()) {
                    this.j = file.getAbsolutePath();
                    w();
                } else {
                    h.j(this.i, new c());
                }
            } else {
                this.j = this.i;
                w();
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public final void R() {
        try {
            File file = new File(this.j);
            if (file.exists() && !file.isDirectory()) {
                long f = f64.h().f(this.j);
                this.n = f;
                if (0 != f) {
                    B().c(this.j);
                    if (o) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.j);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e2) {
            if (o) {
                Log.d("SwanAppAudioPlayer", "set data source fail");
                e2.printStackTrace();
            }
        }
        L("10003");
    }

    public void N(w54 w54Var) {
        if (o) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.e != null) {
            F();
        }
        this.c = UserStatus.OPEN;
        this.f = w54Var;
        this.h = 0;
        this.i = px2.T().G().a(this.f.c);
        this.b = PlayerStatus.IDLE;
        J("onWaiting");
        M();
    }

    public void U(float f) {
        try {
            J("onSeeking");
            int i = (int) (f * 1000.0f);
            if (H()) {
                if (i >= 0 && i <= A()) {
                    this.e.seek(i);
                }
                this.l = -1.0f;
                return;
            }
            if (this.m && this.b == PlayerStatus.IDLE) {
                R();
            }
            this.l = i;
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public void Q() {
        String str;
        this.c = UserStatus.PLAY;
        if (!this.m) {
            return;
        }
        try {
            if (G() || !x()) {
                return;
            }
            if (o) {
                Log.d("SwanAppAudioPlayer", "play music first: " + this.j);
            }
            if (this.b == PlayerStatus.PREPARED) {
                this.g.sendEmptyMessage(0);
                Z();
                if (o) {
                    Log.d("SwanAppAudioPlayer", "play music: " + this.j);
                }
                B().play();
                J("onPlay");
            } else if (this.b == PlayerStatus.IDLE) {
                try {
                    B().c(this.j);
                    this.b = PlayerStatus.PREPARING;
                } catch (Exception e2) {
                    if (o) {
                        Log.d("SwanAppAudioPlayer", "set data source fail");
                        e2.printStackTrace();
                    }
                    if (!SwanAppNetworkUtils.i(null)) {
                        str = "10003";
                    } else {
                        str = "10002";
                    }
                    L(str);
                }
            }
        } catch (Exception e3) {
            if (o) {
                e3.printStackTrace();
            }
        }
    }

    public void S() {
        if (this.k == null) {
            this.k = new d(this, null);
        }
        this.e.j(this.k);
        this.e.q(this.k);
        this.e.g(this.k);
        this.e.l(this.k);
        this.e.h(this.k);
        this.e.n(this.k);
        this.e.f(this);
    }
}
