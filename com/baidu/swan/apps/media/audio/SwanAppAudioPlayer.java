package com.baidu.swan.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.RouterCallback;
import d.b.g0.a.e0.l.j;
import d.b.g0.a.i2.b0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.z0.f;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAudioPlayer implements d.b.g0.a.b1.a {
    public static final boolean l = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f11911a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f11912b;

    /* renamed from: d  reason: collision with root package name */
    public d f11914d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.b1.c.e.a f11915e;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f11918h;
    public boolean i;
    public b j;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.b1.c.b f11913c = new d.b.g0.a.b1.c.b();

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f11916f = PlayerStatus.NONE;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f11917g = UserStatus.OPEN;
    public boolean k = false;

    /* loaded from: classes2.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* loaded from: classes2.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* loaded from: classes2.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f11920e;

            public a(int i) {
                this.f11920e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioPlayer.this.w()) {
                    return;
                }
                int i = this.f11920e;
                if (i == -2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    SwanAppAudioPlayer.this.g();
                    SwanAppAudioPlayer.this.z();
                } else if (i != -1) {
                } else {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                    }
                    SwanAppAudioPlayer.this.g();
                    SwanAppAudioPlayer.this.z();
                }
            }
        }

        public b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            k0.X(new a(i));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.f11916f != PlayerStatus.PREPARED || (i * SwanAppAudioPlayer.this.u().getDuration()) / 100 > SwanAppAudioPlayer.this.u().getCurrentPosition() || SwanAppAudioPlayer.this.f11915e == null) {
                return;
            }
            SwanAppAudioPlayer.this.f11915e.a("onWaiting");
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.u().isLooping()) {
                SwanAppAudioPlayer.this.f11917g = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.f11916f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f11915e != null) {
                SwanAppAudioPlayer.this.f11915e.a("onEnded");
            }
            SwanAppAudioPlayer.this.f11914d.removeMessages(0);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onError -> what: " + i + " extra: " + i2);
            }
            String str = "-1";
            if (i != 1 && i == 100) {
                str = LightappConstants.ERRCODE_INVALID_PARAMETER;
            }
            if (i2 == -1007) {
                str = "10004";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, str);
            } catch (JSONException e2) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e2));
                }
            }
            if (SwanAppAudioPlayer.this.f11915e != null) {
                SwanAppAudioPlayer.this.f11915e.b("onError", jSONObject);
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--oninfo -> what: " + i + " ,extra: " + i2);
                return false;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.f11916f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f11915e != null) {
                SwanAppAudioPlayer.this.f11915e.a("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.f11917g) {
                SwanAppAudioPlayer.this.I();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.f11915e != null) {
                SwanAppAudioPlayer.this.f11915e.a("onSeeked");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.u().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.u().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.f11915e != null) {
                        SwanAppAudioPlayer.this.f11915e.b("onTimeUpdate", jSONObject);
                    }
                } catch (JSONException e2) {
                    if (SwanAppAudioPlayer.l) {
                        e2.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public SwanAppAudioPlayer(String str) {
        this.f11911a = "";
        this.f11911a = str;
        d.b.g0.a.b1.b.a(this);
    }

    public void A() {
        this.f11917g = UserStatus.PLAY;
        if (v()) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "===play");
        }
        D();
        PlayerStatus playerStatus = this.f11916f;
        if (playerStatus == PlayerStatus.PREPARED) {
            u().start();
            d dVar = this.f11914d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            d.b.g0.a.b1.c.e.a aVar = this.f11915e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            u().prepareAsync();
            this.f11916f = PlayerStatus.PREPARING;
        }
    }

    public final void B() {
        if (this.k) {
            u().reset();
            F(this.f11913c.f43680c);
            this.k = false;
        }
        u().prepareAsync();
        this.f11916f = PlayerStatus.PREPARING;
    }

    public void C() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.f11917g = UserStatus.DESTROY;
        g();
        u().release();
        this.f11916f = PlayerStatus.NONE;
        this.f11912b = null;
        d dVar = this.f11914d;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f11914d = null;
        }
        d.b.g0.a.b1.b.j(this);
    }

    public final void D() {
        if (w() || this.i) {
            return;
        }
        if (this.f11918h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.f11918h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b();
        }
        this.i = this.f11918h.requestAudioFocus(this.j, 3, 1) == 1;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
        }
    }

    public void E(int i) {
        if (this.f11916f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            u().seekTo((int) (i * 1000));
            d.b.g0.a.b1.c.e.a aVar = this.f11915e;
            if (aVar != null) {
                aVar.a("onSeeking");
            }
        }
    }

    public final void F(String str) {
        try {
            String m = f.V().y().m(str);
            if (TextUtils.isEmpty(m)) {
                return;
            }
            HashMap hashMap = new HashMap();
            String b2 = b0.b();
            if (!TextUtils.isEmpty(b2) && b0.c(m)) {
                if (l) {
                    Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + b2);
                }
                hashMap.put("Referer", b2);
            }
            String W = d.b.g0.a.e0.w.d.L().W();
            if (!TextUtils.isEmpty(W)) {
                hashMap.put("User-Agent", W);
            }
            u().setDataSource(AppRuntime.getAppContext(), Uri.parse(m), hashMap);
            this.f11916f = PlayerStatus.IDLE;
        } catch (IOException unused) {
            if (l) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.f11915e != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.h(null)) {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_NO_PERMISSION);
                } else {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                }
                this.f11915e.a("onError");
            }
        }
    }

    public final void G(boolean z) {
        u().setLooping(z);
    }

    public final void H(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        u().setVolume(f2, f2);
    }

    public final void I() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        D();
        u().start();
        d dVar = this.f11914d;
        if (dVar != null) {
            dVar.sendEmptyMessage(0);
        }
        d.b.g0.a.b1.c.e.a aVar = this.f11915e;
        if (aVar != null) {
            aVar.a("onPlay");
        }
        L();
        int i = this.f11913c.f43681d;
        if (i > 0) {
            E(i);
        }
        if (v()) {
            z();
        }
    }

    public void J() {
        this.f11917g = UserStatus.STOP;
        if (this.f11916f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            u().stop();
            this.f11916f = PlayerStatus.IDLE;
            d dVar = this.f11914d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
            d.b.g0.a.b1.c.e.a aVar = this.f11915e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void K(d.b.g0.a.b1.c.b bVar) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.f11913c.f43680c;
        this.f11913c = bVar;
        d.b.g0.a.b1.c.e.a aVar = this.f11915e;
        if (aVar != null) {
            aVar.d(bVar.j);
        }
        L();
        if (TextUtils.equals(bVar.f43680c, str)) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "update src: " + bVar.f43680c);
        }
        this.k = true;
        B();
    }

    public final void L() {
        G(this.f11913c.f43683f);
        H(this.f11913c.i);
    }

    @Override // d.b.g0.a.b1.a
    public Object a() {
        return this;
    }

    @Override // d.b.g0.a.b1.a
    public String b() {
        return this.f11913c.f43679b;
    }

    @Override // d.b.g0.a.b1.a
    public String c() {
        return this.f11911a;
    }

    @Override // d.b.g0.a.b1.a
    public void d(boolean z) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (z) {
            return;
        }
        z();
    }

    @Override // d.b.g0.a.b1.a
    public String e() {
        return null;
    }

    @Override // d.b.g0.a.b1.a
    public void f(boolean z) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e y = e.y();
        if (y == null || !y.i0()) {
            return;
        }
        if (!z) {
            z();
        } else if (this.f11917g == UserStatus.PLAY) {
            A();
        }
    }

    public final void g() {
        b bVar;
        if (this.i) {
            AudioManager audioManager = this.f11918h;
            if (audioManager != null && (bVar = this.j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f11918h = null;
                this.j = null;
            }
            this.i = false;
            if (l) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.b.g0.a.b1.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // d.b.g0.a.b1.a
    public void onDestroy() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onDestroy");
        }
        e y = e.y();
        if (y == null || !y.i0()) {
            return;
        }
        C();
    }

    public d.b.g0.a.b1.c.b t() {
        return this.f11913c;
    }

    public final MediaPlayer u() {
        if (this.f11912b == null) {
            this.f11912b = new MediaPlayer();
            c cVar = new c();
            this.f11912b.setOnPreparedListener(cVar);
            this.f11912b.setOnCompletionListener(cVar);
            this.f11912b.setOnInfoListener(cVar);
            this.f11912b.setOnErrorListener(cVar);
            this.f11912b.setOnSeekCompleteListener(cVar);
            this.f11912b.setOnBufferingUpdateListener(cVar);
            this.f11914d = new d();
        }
        return this.f11912b;
    }

    public final boolean v() {
        d.b.g0.a.e0.l.c m;
        if (e.y() == null || !e.y().i0()) {
            return false;
        }
        d.b.g0.a.e0.l.f W = f.V().W();
        if (W == null || (m = W.m()) == null || !(m instanceof j)) {
            return true;
        }
        return ((j) m).d3();
    }

    public final boolean w() {
        e y = e.y();
        boolean booleanValue = y == null ? false : y.H().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
        if (l) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public void x(d.b.g0.a.b1.c.b bVar, CallbackHandler callbackHandler) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.f11917g = UserStatus.OPEN;
        this.f11913c = bVar;
        if (bVar.j != null) {
            try {
                this.f11915e = new d.b.g0.a.b1.c.e.a(callbackHandler, new JSONObject(this.f11913c.j));
            } catch (JSONException unused) {
                if (l) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        u().reset();
        F(this.f11913c.f43680c);
        B();
    }

    public void y() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.f11917g = UserStatus.PAUSE;
        z();
    }

    public final void z() {
        if (u().isPlaying()) {
            u().pause();
            d.b.g0.a.b1.c.e.a aVar = this.f11915e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f11914d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
