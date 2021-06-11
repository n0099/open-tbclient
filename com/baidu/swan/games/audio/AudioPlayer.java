package com.baidu.swan.games.audio;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.RouterCallback;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AudioPlayer implements d.a.l0.a.i1.a, d.a.l0.l.a.c {
    public static final boolean o = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.i1.c.e.a f11695a;

    /* renamed from: d  reason: collision with root package name */
    public String f11698d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.h.c.j.c f11699e;

    /* renamed from: h  reason: collision with root package name */
    public int f11702h;

    /* renamed from: i  reason: collision with root package name */
    public String f11703i;
    public String j;
    public d k;
    public boolean m;
    public long n;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f11696b = PlayerStatus.NONE;

    /* renamed from: c  reason: collision with root package name */
    public UserStatus f11697c = UserStatus.OPEN;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.h.c.d f11700f = new d.a.l0.h.c.d();

    /* renamed from: g  reason: collision with root package name */
    public e f11701g = new e();
    public float l = -1.0f;

    /* loaded from: classes3.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* loaded from: classes3.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* loaded from: classes3.dex */
    public class a implements TypedCallbackHandler {
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* loaded from: classes3.dex */
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
            d.a.l0.h.c.j.b.h().e().post(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.h.c.i.a {
        public c() {
        }

        @Override // d.a.l0.h.c.i.a
        public void a(String str, String str2) {
            AudioPlayer.this.j = str2;
            AudioPlayer.this.w();
        }

        @Override // d.a.l0.h.c.i.a
        public void fail(int i2, String str) {
            AudioPlayer.this.L(!SwanAppNetworkUtils.i(null) ? LightappConstants.ERRCODE_INNER_ERROR : LightappConstants.ERRCODE_NO_PERMISSION);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            try {
                if (AudioPlayer.o) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i2 + "%");
                }
                if (AudioPlayer.this.H()) {
                    AudioPlayer.this.f11702h = (((int) AudioPlayer.this.A()) * i2) / 100;
                    if (AudioPlayer.this.f11695a != null) {
                        AudioPlayer.this.J("onBufferingUpdate");
                        if (AudioPlayer.this.f11696b != PlayerStatus.PREPARED || AudioPlayer.this.f11697c == UserStatus.STOP || (i2 * AudioPlayer.this.A()) / 100 > AudioPlayer.this.z()) {
                            return;
                        }
                        AudioPlayer.this.J("onWaiting");
                    }
                }
            } catch (Exception e2) {
                if (AudioPlayer.o) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "comCompletion");
            }
            try {
                if (!AudioPlayer.this.f11700f.f50854f) {
                    AudioPlayer.this.f11697c = UserStatus.STOP;
                    AudioPlayer.this.F();
                }
                AudioPlayer.this.J("onEnded");
            } catch (Exception e2) {
                if (AudioPlayer.o) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "onError : what is " + i2 + " extra is " + i3);
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i2 + "playerId = " + AudioPlayer.this.f11700f.f50849a + " url = " + AudioPlayer.this.f11700f.f50851c);
            }
            String str = "-1";
            if (i2 != 1 && i2 == 100) {
                str = LightappConstants.ERRCODE_INVALID_PARAMETER;
            }
            if (i3 == -1007) {
                str = "10004";
            }
            AudioPlayer.this.L(str);
            AudioPlayer.this.F();
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "oninfo : what is " + i2 + " extra is " + i3);
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
            audioPlayer.f11696b = PlayerStatus.PREPARED;
            if (!audioPlayer.m) {
                AudioPlayer.this.J("onCanplay");
            }
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.j);
            }
            AudioPlayer.this.m = true;
            UserStatus userStatus = UserStatus.PLAY;
            AudioPlayer audioPlayer2 = AudioPlayer.this;
            if (userStatus == audioPlayer2.f11697c) {
                audioPlayer2.Q();
            }
            try {
                if (AudioPlayer.this.f11700f.f50852d > 0.0f) {
                    AudioPlayer.this.B().seek(AudioPlayer.this.f11700f.f50852d);
                } else if (AudioPlayer.this.l >= 0.0f) {
                    AudioPlayer.this.B().seek(AudioPlayer.this.l);
                    AudioPlayer.this.l = -1.0f;
                }
            } catch (Exception e2) {
                if (AudioPlayer.o) {
                    e2.printStackTrace();
                }
            }
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
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class e extends Handler {
        public e() {
            super(d.a.l0.h.c.j.b.h().e().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.f11696b == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.z() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.A() / 1000));
                    AudioPlayer.this.K("onTimeUpdate", jSONObject);
                } catch (Exception e2) {
                    if (AudioPlayer.o) {
                        e2.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public AudioPlayer(String str) {
        this.f11698d = "";
        this.f11698d = str;
    }

    public long A() {
        try {
            if (0 == this.n && this.f11699e != null) {
                return this.f11699e.getDuration();
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
        return this.n;
    }

    public d.a.l0.h.c.j.c B() {
        d.a.l0.h.c.j.c cVar = this.f11699e;
        if (cVar == null || cVar.t()) {
            this.f11699e = d.a.l0.h.c.j.b.h().d(this.j, this.f11700f.f50854f);
            S();
        }
        return this.f11699e;
    }

    public final d.a.l0.a.l0.a C() {
        SwanAppActivity x;
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || !i2.m0() || (x = i2.x()) == null) {
            return null;
        }
        d.a.l0.a.t0.c frame = x.getFrame();
        if (frame instanceof d.a.l0.h.o.d) {
            return ((d.a.l0.h.o.d) frame).X0();
        }
        return null;
    }

    public float D() {
        d.a.l0.h.c.d dVar = this.f11700f;
        if (dVar != null) {
            return dVar.f50857i;
        }
        return 1.0f;
    }

    public final void E() {
        J(MissionEvent.MESSAGE_PAUSE);
        this.f11701g.removeMessages(0);
    }

    public final void F() {
        this.f11696b = PlayerStatus.IDLE;
        d.a.l0.h.c.j.c cVar = this.f11699e;
        if (cVar != null) {
            cVar.destroy();
            this.f11699e = null;
        }
        this.f11701g.removeMessages(0);
    }

    public final boolean G() {
        d.a.l0.a.h0.g.d m;
        if (d.a.l0.a.a2.e.i() == null || !d.a.l0.a.a2.e.i().m0()) {
            return false;
        }
        g W = f.V().W();
        if (W == null || (m = W.m()) == null || !(m instanceof d.a.l0.h.n.a)) {
            return true;
        }
        return ((d.a.l0.h.n.a) m).p3();
    }

    public final boolean H() {
        return this.f11699e != null && this.f11696b == PlayerStatus.PREPARED;
    }

    public boolean I() {
        UserStatus userStatus = UserStatus.STOP;
        UserStatus userStatus2 = this.f11697c;
        return (userStatus == userStatus2 || UserStatus.DESTROY == userStatus2) ? false : true;
    }

    public final void J(String str) {
        K(str, null);
    }

    public final void K(String str, JSONObject jSONObject) {
        d.a.l0.a.i1.c.e.a aVar = this.f11695a;
        if (aVar != null) {
            aVar.b(str, jSONObject);
        }
    }

    public final void L(String str) {
        if (this.f11695a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, str);
            } catch (JSONException e2) {
                if (o) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e2));
                }
            }
            this.f11695a.b("onError", jSONObject);
        }
    }

    public final void M() {
        try {
            if (this.f11703i.contains("http")) {
                d.a.l0.h.c.j.b h2 = d.a.l0.h.c.j.b.h();
                File file = new File(h2.g(this.f11703i));
                if (file.exists() && !file.isDirectory()) {
                    this.j = file.getAbsolutePath();
                    w();
                } else {
                    h2.j(this.f11703i, new c());
                }
            } else {
                this.j = this.f11703i;
                w();
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public void N(d.a.l0.h.c.d dVar) {
        if (o) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.f11699e != null) {
            F();
        }
        this.f11697c = UserStatus.OPEN;
        this.f11700f = dVar;
        this.f11702h = 0;
        this.f11703i = f.V().I().a(this.f11700f.f50851c);
        this.f11696b = PlayerStatus.IDLE;
        J("onWaiting");
        M();
    }

    public void O() {
        this.f11697c = UserStatus.PAUSE;
        P();
    }

    public final void P() {
        if (H()) {
            this.f11699e.pause();
        }
    }

    public void Q() {
        this.f11697c = UserStatus.PLAY;
        if (this.m) {
            try {
                if (!G() && x()) {
                    if (o) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.j);
                    }
                    if (this.f11696b == PlayerStatus.PREPARED) {
                        this.f11701g.sendEmptyMessage(0);
                        a0();
                        if (o) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.j);
                        }
                        B().play();
                        J("onPlay");
                    } else if (this.f11696b == PlayerStatus.IDLE) {
                        try {
                            B().c(this.j);
                            this.f11696b = PlayerStatus.PREPARING;
                        } catch (Exception e2) {
                            if (o) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e2.printStackTrace();
                            }
                            L(!SwanAppNetworkUtils.i(null) ? LightappConstants.ERRCODE_INNER_ERROR : LightappConstants.ERRCODE_NO_PERMISSION);
                        }
                    }
                }
            } catch (Exception e3) {
                if (o) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final void R() {
        try {
            File file = new File(this.j);
            if (file.exists() && !file.isDirectory()) {
                long f2 = d.a.l0.h.c.j.b.h().f(this.j);
                this.n = f2;
                if (0 != f2) {
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
        L(LightappConstants.ERRCODE_INNER_ERROR);
    }

    public void S() {
        if (this.k == null) {
            this.k = new d(this, null);
        }
        this.f11699e.j(this.k);
        this.f11699e.r(this.k);
        this.f11699e.g(this.k);
        this.f11699e.l(this.k);
        this.f11699e.h(this.k);
        this.f11699e.o(this.k);
        this.f11699e.e(this);
    }

    public void T() {
        F();
        this.m = false;
        this.f11697c = UserStatus.DESTROY;
        this.f11696b = PlayerStatus.NONE;
    }

    public void U(float f2) {
        try {
            J("onSeeking");
            int i2 = (int) (f2 * 1000.0f);
            if (H()) {
                if (i2 >= 0 && i2 <= A()) {
                    this.f11699e.seek(i2);
                }
                this.l = -1.0f;
                return;
            }
            if (this.m && this.f11696b == PlayerStatus.IDLE) {
                R();
            }
            this.l = i2;
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public void V(d.a.l0.a.i1.c.e.a aVar) {
        this.f11695a = aVar;
    }

    public final void W(boolean z) {
        try {
            if (H()) {
                this.f11699e.a(z);
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public final void X(float f2) {
        if (H()) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            try {
                this.f11699e.w(f2);
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void Y() {
        this.f11697c = UserStatus.STOP;
        if (H()) {
            this.f11699e.stop();
        }
        F();
        J(MissionEvent.MESSAGE_STOP);
    }

    public void Z(d.a.l0.h.c.d dVar) {
        this.f11700f = dVar;
        d.a.l0.a.i1.c.e.a aVar = this.f11695a;
        if (aVar != null) {
            aVar.d(dVar.j);
        }
        a0();
    }

    public final void a0() {
        if (o) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.f11700f.toString());
        }
        W(this.f11700f.f50854f);
        X(this.f11700f.f50857i);
    }

    @Override // d.a.l0.a.i1.a
    public String b() {
        return this.f11700f.f50850b;
    }

    @Override // d.a.l0.a.i1.a
    public String c() {
        return this.f11698d;
    }

    @Override // d.a.l0.a.i1.a
    public String f() {
        return null;
    }

    @Override // d.a.l0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.l0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.l0.a.i1.a
    public void k(boolean z) {
        d.a.l0.a.l0.a C;
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || !i2.m0() || z || (C = C()) == null || C.s0()) {
            return;
        }
        C.runOnJSThread(new b());
    }

    @Override // d.a.l0.a.i1.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // d.a.l0.a.i1.a
    public void onDestroy() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || !i2.m0()) {
            return;
        }
        T();
    }

    @Override // d.a.l0.l.a.c
    public void onPause() {
        E();
    }

    public final void w() {
        R();
    }

    public final boolean x() throws JSONException {
        File file = new File(this.j);
        if (!file.exists() || file.isDirectory()) {
            L(LightappConstants.ERRCODE_INNER_ERROR);
            return false;
        }
        return true;
    }

    public int y() {
        return this.f11702h;
    }

    public int z() {
        if (H()) {
            return this.f11699e.x();
        }
        return 0;
    }
}
