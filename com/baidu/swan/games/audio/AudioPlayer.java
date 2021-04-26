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
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.l.j;
import d.a.h0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AudioPlayer implements d.a.h0.a.b1.a, d.a.h0.j.a.c {
    public static final boolean o = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.b1.c.e.a f12358a;

    /* renamed from: d  reason: collision with root package name */
    public String f12361d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.g.c.j.c f12362e;

    /* renamed from: h  reason: collision with root package name */
    public int f12365h;

    /* renamed from: i  reason: collision with root package name */
    public String f12366i;
    public String j;
    public d k;
    public boolean m;
    public long n;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f12359b = PlayerStatus.NONE;

    /* renamed from: c  reason: collision with root package name */
    public UserStatus f12360c = UserStatus.OPEN;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.c.d f12363f = new d.a.h0.g.c.d();

    /* renamed from: g  reason: collision with root package name */
    public e f12364g = new e();
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
            d.a.h0.g.c.j.b.h().e().post(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.g.c.i.a {
        public c() {
        }

        @Override // d.a.h0.g.c.i.a
        public void a(String str, String str2) {
            AudioPlayer.this.j = str2;
            AudioPlayer.this.w();
        }

        @Override // d.a.h0.g.c.i.a
        public void fail(int i2, String str) {
            AudioPlayer.this.L(!SwanAppNetworkUtils.h(null) ? LightappConstants.ERRCODE_INNER_ERROR : LightappConstants.ERRCODE_NO_PERMISSION);
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
                    AudioPlayer.this.f12365h = (((int) AudioPlayer.this.A()) * i2) / 100;
                    if (AudioPlayer.this.f12358a != null) {
                        AudioPlayer.this.J("onBufferingUpdate");
                        if (AudioPlayer.this.f12359b != PlayerStatus.PREPARED || AudioPlayer.this.f12360c == UserStatus.STOP || (i2 * AudioPlayer.this.A()) / 100 > AudioPlayer.this.z()) {
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
                if (!AudioPlayer.this.f12363f.f46126f) {
                    AudioPlayer.this.f12360c = UserStatus.STOP;
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i2 + "playerId = " + AudioPlayer.this.f12363f.f46121a + " url = " + AudioPlayer.this.f12363f.f46123c);
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
            audioPlayer.f12359b = PlayerStatus.PREPARED;
            if (!audioPlayer.m) {
                AudioPlayer.this.J("onCanplay");
            }
            if (AudioPlayer.o) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.j);
            }
            AudioPlayer.this.m = true;
            UserStatus userStatus = UserStatus.PLAY;
            AudioPlayer audioPlayer2 = AudioPlayer.this;
            if (userStatus == audioPlayer2.f12360c) {
                audioPlayer2.Q();
            }
            try {
                if (AudioPlayer.this.f12363f.f46124d > 0.0f) {
                    AudioPlayer.this.B().seek(AudioPlayer.this.f12363f.f46124d);
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
            super(d.a.h0.g.c.j.b.h().e().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.f12359b == PlayerStatus.PREPARED) {
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
        this.f12361d = "";
        this.f12361d = str;
    }

    public long A() {
        try {
            if (0 == this.n && this.f12362e != null) {
                return this.f12362e.getDuration();
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
        return this.n;
    }

    public d.a.h0.g.c.j.c B() {
        d.a.h0.g.c.j.c cVar = this.f12362e;
        if (cVar == null || cVar.u()) {
            this.f12362e = d.a.h0.g.c.j.b.h().d(this.j, this.f12363f.f46126f);
            S();
        }
        return this.f12362e;
    }

    public final d.a.h0.g.i.a C() {
        SwanAppActivity v;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || !h2.i0() || (v = h2.v()) == null) {
            return null;
        }
        d.a.h0.a.o0.c frame = v.getFrame();
        if (frame instanceof d.a.h0.g.m.b) {
            return ((d.a.h0.g.m.b) frame).U0();
        }
        return null;
    }

    public float D() {
        d.a.h0.g.c.d dVar = this.f12363f;
        if (dVar != null) {
            return dVar.f46129i;
        }
        return 1.0f;
    }

    public final void E() {
        J(MissionEvent.MESSAGE_PAUSE);
        this.f12364g.removeMessages(0);
    }

    public final void F() {
        this.f12359b = PlayerStatus.IDLE;
        d.a.h0.g.c.j.c cVar = this.f12362e;
        if (cVar != null) {
            cVar.destroy();
            this.f12362e = null;
        }
        this.f12364g.removeMessages(0);
    }

    public final boolean G() {
        d.a.h0.a.e0.l.c m;
        if (d.a.h0.a.r1.e.h() == null || !d.a.h0.a.r1.e.h().i0()) {
            return false;
        }
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null || (m = W.m()) == null || !(m instanceof j)) {
            return true;
        }
        return ((j) m).c3();
    }

    public final boolean H() {
        return this.f12362e != null && this.f12359b == PlayerStatus.PREPARED;
    }

    public boolean I() {
        UserStatus userStatus = UserStatus.STOP;
        UserStatus userStatus2 = this.f12360c;
        return (userStatus == userStatus2 || UserStatus.DESTROY == userStatus2) ? false : true;
    }

    public final void J(String str) {
        K(str, null);
    }

    public final void K(String str, JSONObject jSONObject) {
        d.a.h0.a.b1.c.e.a aVar = this.f12358a;
        if (aVar != null) {
            aVar.b(str, jSONObject);
        }
    }

    public final void L(String str) {
        if (this.f12358a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, str);
            } catch (JSONException e2) {
                if (o) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e2));
                }
            }
            this.f12358a.b("onError", jSONObject);
        }
    }

    public final void M() {
        try {
            if (this.f12366i.contains("http")) {
                d.a.h0.g.c.j.b h2 = d.a.h0.g.c.j.b.h();
                File file = new File(h2.g(this.f12366i));
                if (file.exists() && !file.isDirectory()) {
                    this.j = file.getAbsolutePath();
                    w();
                } else {
                    h2.j(this.f12366i, new c());
                }
            } else {
                this.j = this.f12366i;
                w();
            }
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public void N(d.a.h0.g.c.d dVar) {
        if (o) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.f12362e != null) {
            F();
        }
        this.f12360c = UserStatus.OPEN;
        this.f12363f = dVar;
        this.f12365h = 0;
        this.f12366i = d.a.h0.a.z0.f.V().I().e(this.f12363f.f46123c);
        this.f12359b = PlayerStatus.IDLE;
        J("onWaiting");
        M();
    }

    public void O() {
        this.f12360c = UserStatus.PAUSE;
        P();
    }

    public final void P() {
        if (H()) {
            this.f12362e.pause();
        }
    }

    public void Q() {
        this.f12360c = UserStatus.PLAY;
        if (this.m) {
            try {
                if (!G() && x()) {
                    if (o) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.j);
                    }
                    if (this.f12359b == PlayerStatus.PREPARED) {
                        this.f12364g.sendEmptyMessage(0);
                        a0();
                        if (o) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.j);
                        }
                        B().play();
                        J("onPlay");
                    } else if (this.f12359b == PlayerStatus.IDLE) {
                        try {
                            B().c(this.j);
                            this.f12359b = PlayerStatus.PREPARING;
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
                long f2 = d.a.h0.g.c.j.b.h().f(this.j);
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
        this.f12362e.l(this.k);
        this.f12362e.s(this.k);
        this.f12362e.h(this.k);
        this.f12362e.n(this.k);
        this.f12362e.i(this.k);
        this.f12362e.p(this.k);
        this.f12362e.g(this);
    }

    public void T() {
        F();
        this.m = false;
        this.f12360c = UserStatus.DESTROY;
        this.f12359b = PlayerStatus.NONE;
    }

    public void U(float f2) {
        try {
            J("onSeeking");
            int i2 = (int) (f2 * 1000.0f);
            if (H()) {
                if (i2 >= 0 && i2 <= A()) {
                    this.f12362e.seek(i2);
                }
                this.l = -1.0f;
                return;
            }
            if (this.m && this.f12359b == PlayerStatus.IDLE) {
                R();
            }
            this.l = i2;
        } catch (Exception e2) {
            if (o) {
                e2.printStackTrace();
            }
        }
    }

    public void V(d.a.h0.a.b1.c.e.a aVar) {
        this.f12358a = aVar;
    }

    public final void W(boolean z) {
        try {
            if (H()) {
                this.f12362e.a(z);
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
                this.f12362e.x(f2);
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void Y() {
        this.f12360c = UserStatus.STOP;
        if (H()) {
            this.f12362e.stop();
        }
        F();
        J(MissionEvent.MESSAGE_STOP);
    }

    public void Z(d.a.h0.g.c.d dVar) {
        this.f12363f = dVar;
        d.a.h0.a.b1.c.e.a aVar = this.f12358a;
        if (aVar != null) {
            aVar.d(dVar.j);
        }
        a0();
    }

    @Override // d.a.h0.a.b1.a
    public String a() {
        return this.f12363f.f46122b;
    }

    public final void a0() {
        if (o) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.f12363f.toString());
        }
        W(this.f12363f.f46126f);
        X(this.f12363f.f46129i);
    }

    @Override // d.a.h0.a.b1.a
    public String b() {
        return this.f12361d;
    }

    @Override // d.a.h0.a.b1.a
    public String c() {
        return null;
    }

    @Override // d.a.h0.a.b1.a
    public Object d() {
        return this;
    }

    @Override // d.a.h0.a.b1.a
    public void e(boolean z) {
    }

    @Override // d.a.h0.a.b1.a
    public void f(boolean z) {
        d.a.h0.g.i.a C;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || !h2.i0() || z || (C = C()) == null || C.o0()) {
            return;
        }
        C.runOnJSThread(new b());
    }

    @Override // d.a.h0.a.b1.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // d.a.h0.a.b1.a
    public void onDestroy() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || !h2.i0()) {
            return;
        }
        T();
    }

    @Override // d.a.h0.j.a.c
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
        return this.f12365h;
    }

    public int z() {
        if (H()) {
            return this.f12362e.y();
        }
        return 0;
    }
}
