package com.baidu.swan.games.audio;

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
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.l.j;
import d.b.g0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AudioPlayer implements d.b.g0.a.b1.a, d.b.g0.j.a.c {
    public static final boolean o = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.b1.c.e.a f12801a;

    /* renamed from: d  reason: collision with root package name */
    public String f12804d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.c.j.c f12805e;

    /* renamed from: h  reason: collision with root package name */
    public int f12808h;
    public String i;
    public String j;
    public d k;
    public boolean m;
    public long n;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f12802b = PlayerStatus.NONE;

    /* renamed from: c  reason: collision with root package name */
    public UserStatus f12803c = UserStatus.OPEN;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.c.d f12806f = new d.b.g0.g.c.d();

    /* renamed from: g  reason: collision with root package name */
    public e f12807g = new e();
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
            d.b.g0.g.c.j.b.h().e().post(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.g.c.i.a {
        public c() {
        }

        @Override // d.b.g0.g.c.i.a
        public void a(String str, String str2) {
            AudioPlayer.this.j = str2;
            AudioPlayer.this.w();
        }

        @Override // d.b.g0.g.c.i.a
        public void fail(int i, String str) {
            AudioPlayer.this.L(!SwanAppNetworkUtils.h(null) ? LightappConstants.ERRCODE_INNER_ERROR : LightappConstants.ERRCODE_NO_PERMISSION);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.o) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.H()) {
                    AudioPlayer.this.f12808h = (((int) AudioPlayer.this.A()) * i) / 100;
                    if (AudioPlayer.this.f12801a != null) {
                        AudioPlayer.this.J("onBufferingUpdate");
                        if (AudioPlayer.this.f12802b != PlayerStatus.PREPARED || AudioPlayer.this.f12803c == UserStatus.STOP || (i * AudioPlayer.this.A()) / 100 > AudioPlayer.this.z()) {
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
                if (!AudioPlayer.this.f12806f.f47939f) {
                    AudioPlayer.this.f12803c = UserStatus.STOP;
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
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "onError : what is " + i + " extra is " + i2);
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.f12806f.f47934a + " url = " + AudioPlayer.this.f12806f.f47936c);
            }
            String str = "-1";
            if (i != 1 && i == 100) {
                str = LightappConstants.ERRCODE_INVALID_PARAMETER;
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
            audioPlayer.f12802b = PlayerStatus.PREPARED;
            if (!audioPlayer.m) {
                AudioPlayer.this.J("onCanplay");
            }
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.j);
            }
            AudioPlayer.this.m = true;
            UserStatus userStatus = UserStatus.PLAY;
            AudioPlayer audioPlayer2 = AudioPlayer.this;
            if (userStatus == audioPlayer2.f12803c) {
                audioPlayer2.Q();
            }
            try {
                if (AudioPlayer.this.f12806f.f47937d > 0.0f) {
                    AudioPlayer.this.B().seek(AudioPlayer.this.f12806f.f47937d);
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

    /* loaded from: classes3.dex */
    public class e extends Handler {
        public e() {
            super(d.b.g0.g.c.j.b.h().e().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.f12802b == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    double z = AudioPlayer.this.z();
                    Double.isNaN(z);
                    jSONObject.putOpt("currentTime", Double.valueOf(z / 1000.0d));
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
        this.f12804d = "";
        this.f12804d = str;
    }

    public long A() {
        try {
            if (0 == this.n && this.f12805e != null) {
                return this.f12805e.getDuration();
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
        return this.n;
    }

    public d.b.g0.g.c.j.c B() {
        d.b.g0.g.c.j.c cVar = this.f12805e;
        if (cVar == null || cVar.n()) {
            this.f12805e = d.b.g0.g.c.j.b.h().d(this.j, this.f12806f.f47939f);
            S();
        }
        return this.f12805e;
    }

    public final d.b.g0.g.i.a C() {
        SwanAppActivity n;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || !y.i0() || (n = y.n()) == null) {
            return null;
        }
        d.b.g0.a.o0.c frame = n.getFrame();
        if (frame instanceof d.b.g0.g.m.b) {
            return ((d.b.g0.g.m.b) frame).U0();
        }
        return null;
    }

    public float D() {
        d.b.g0.g.c.d dVar = this.f12806f;
        if (dVar != null) {
            return dVar.i;
        }
        return 1.0f;
    }

    public final void E() {
        J(MissionEvent.MESSAGE_PAUSE);
        this.f12807g.removeMessages(0);
    }

    public final void F() {
        this.f12802b = PlayerStatus.IDLE;
        d.b.g0.g.c.j.c cVar = this.f12805e;
        if (cVar != null) {
            cVar.destroy();
            this.f12805e = null;
        }
        this.f12807g.removeMessages(0);
    }

    public final boolean G() {
        d.b.g0.a.e0.l.c m;
        if (d.b.g0.a.r1.e.y() == null || !d.b.g0.a.r1.e.y().i0()) {
            return false;
        }
        f W = d.b.g0.a.z0.f.V().W();
        if (W == null || (m = W.m()) == null || !(m instanceof j)) {
            return true;
        }
        return ((j) m).d3();
    }

    public final boolean H() {
        return this.f12805e != null && this.f12802b == PlayerStatus.PREPARED;
    }

    public boolean I() {
        UserStatus userStatus = UserStatus.STOP;
        UserStatus userStatus2 = this.f12803c;
        return (userStatus == userStatus2 || UserStatus.DESTROY == userStatus2) ? false : true;
    }

    public final void J(String str) {
        K(str, null);
    }

    public final void K(String str, JSONObject jSONObject) {
        d.b.g0.a.b1.c.e.a aVar = this.f12801a;
        if (aVar != null) {
            aVar.b(str, jSONObject);
        }
    }

    public final void L(String str) {
        if (this.f12801a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, str);
            } catch (JSONException e2) {
                if (o) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e2));
                }
            }
            this.f12801a.b("onError", jSONObject);
        }
    }

    public final void M() {
        try {
            if (this.i.contains("http")) {
                d.b.g0.g.c.j.b h2 = d.b.g0.g.c.j.b.h();
                File file = new File(h2.g(this.i));
                if (file.exists() && !file.isDirectory()) {
                    this.j = file.getAbsolutePath();
                    w();
                } else {
                    h2.j(this.i, new c());
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

    public void N(d.b.g0.g.c.d dVar) {
        if (o) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.f12805e != null) {
            F();
        }
        this.f12803c = UserStatus.OPEN;
        this.f12806f = dVar;
        this.f12808h = 0;
        this.i = d.b.g0.a.z0.f.V().y().m(this.f12806f.f47936c);
        this.f12802b = PlayerStatus.IDLE;
        J("onWaiting");
        M();
    }

    public void O() {
        this.f12803c = UserStatus.PAUSE;
        P();
    }

    public final void P() {
        if (H()) {
            this.f12805e.pause();
        }
    }

    public void Q() {
        this.f12803c = UserStatus.PLAY;
        if (this.m) {
            try {
                if (!G() && x()) {
                    if (o) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.j);
                    }
                    if (this.f12802b == PlayerStatus.PREPARED) {
                        this.f12807g.sendEmptyMessage(0);
                        a0();
                        if (o) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.j);
                        }
                        B().play();
                        J("onPlay");
                    } else if (this.f12802b == PlayerStatus.IDLE) {
                        try {
                            B().e(this.j);
                            this.f12802b = PlayerStatus.PREPARING;
                        } catch (Exception e2) {
                            if (o) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e2.printStackTrace();
                            }
                            L(!SwanAppNetworkUtils.h(null) ? LightappConstants.ERRCODE_INNER_ERROR : LightappConstants.ERRCODE_NO_PERMISSION);
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
                long f2 = d.b.g0.g.c.j.b.h().f(this.j);
                this.n = f2;
                if (0 != f2) {
                    B().e(this.j);
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
        this.f12805e.x(this.k);
        this.f12805e.j(this.k);
        this.f12805e.p(this.k);
        this.f12805e.y(this.k);
        this.f12805e.r(this.k);
        this.f12805e.b(this.k);
        this.f12805e.m(this);
    }

    public void T() {
        F();
        this.m = false;
        this.f12803c = UserStatus.DESTROY;
        this.f12802b = PlayerStatus.NONE;
    }

    public void U(float f2) {
        try {
            J("onSeeking");
            int i = (int) (f2 * 1000.0f);
            if (H()) {
                if (i >= 0 && i <= A()) {
                    this.f12805e.seek(i);
                }
                this.l = -1.0f;
                return;
            }
            if (this.m && this.f12802b == PlayerStatus.IDLE) {
                R();
            }
            this.l = i;
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public void V(d.b.g0.a.b1.c.e.a aVar) {
        this.f12801a = aVar;
    }

    public final void W(boolean z) {
        try {
            if (H()) {
                this.f12805e.a(z);
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
                this.f12805e.t(f2);
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void Y() {
        this.f12803c = UserStatus.STOP;
        if (H()) {
            this.f12805e.stop();
        }
        F();
        J(MissionEvent.MESSAGE_STOP);
    }

    public void Z(d.b.g0.g.c.d dVar) {
        this.f12806f = dVar;
        d.b.g0.a.b1.c.e.a aVar = this.f12801a;
        if (aVar != null) {
            aVar.d(dVar.j);
        }
        a0();
    }

    @Override // d.b.g0.a.b1.a
    public Object a() {
        return this;
    }

    public final void a0() {
        if (o) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.f12806f.toString());
        }
        W(this.f12806f.f47939f);
        X(this.f12806f.i);
    }

    @Override // d.b.g0.a.b1.a
    public String b() {
        return this.f12806f.f47935b;
    }

    @Override // d.b.g0.a.b1.a
    public String c() {
        return this.f12804d;
    }

    @Override // d.b.g0.a.b1.a
    public void d(boolean z) {
    }

    @Override // d.b.g0.a.b1.a
    public String e() {
        return null;
    }

    @Override // d.b.g0.a.b1.a
    public void f(boolean z) {
        d.b.g0.g.i.a C;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || !y.i0() || z || (C = C()) == null || C.n0()) {
            return;
        }
        C.runOnJSThread(new b());
    }

    @Override // d.b.g0.a.b1.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // d.b.g0.a.b1.a
    public void onDestroy() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || !y.i0()) {
            return;
        }
        T();
    }

    @Override // d.b.g0.j.a.c
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
        return this.f12808h;
    }

    public int z() {
        if (H()) {
            return this.f12805e.u();
        }
        return 0;
    }
}
