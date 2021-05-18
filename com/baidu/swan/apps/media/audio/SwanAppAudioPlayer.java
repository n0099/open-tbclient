package com.baidu.swan.apps.media.audio;

import android.annotation.SuppressLint;
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
import d.a.i0.a.a2.e;
import d.a.i0.a.g1.f;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.d0;
import d.a.i0.a.v2.q0;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class SwanAppAudioPlayer implements d.a.i0.a.i1.a {
    public static final boolean l = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f10922a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f10923b;

    /* renamed from: d  reason: collision with root package name */
    public d f10925d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.i1.c.e.a f10926e;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f10929h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10930i;
    public b j;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.i1.c.b f10924c = new d.a.i0.a.i1.c.b();

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f10927f = PlayerStatus.NONE;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f10928g = UserStatus.OPEN;
    public boolean k = false;

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
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f10932e;

            public a(int i2) {
                this.f10932e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioPlayer.this.v()) {
                    return;
                }
                int i2 = this.f10932e;
                if (i2 == -2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    SwanAppAudioPlayer.this.a();
                    SwanAppAudioPlayer.this.y();
                } else if (i2 != -1) {
                } else {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                    }
                    SwanAppAudioPlayer.this.a();
                    SwanAppAudioPlayer.this.y();
                }
            }
        }

        public b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            q0.b0(new a(i2));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i2 + "%");
            }
            if (SwanAppAudioPlayer.this.f10927f != PlayerStatus.PREPARED || (i2 * SwanAppAudioPlayer.this.u().getDuration()) / 100 > SwanAppAudioPlayer.this.u().getCurrentPosition() || SwanAppAudioPlayer.this.f10926e == null) {
                return;
            }
            SwanAppAudioPlayer.this.f10926e.a("onWaiting");
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.u().isLooping()) {
                SwanAppAudioPlayer.this.f10928g = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.f10927f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f10926e != null) {
                SwanAppAudioPlayer.this.f10926e.a("onEnded");
            }
            SwanAppAudioPlayer.this.f10925d.removeMessages(0);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onError -> what: " + i2 + " extra: " + i3);
            }
            String str = "-1";
            if (i2 != 1 && i2 == 100) {
                str = LightappConstants.ERRCODE_INVALID_PARAMETER;
            }
            if (i3 == -1007) {
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
            if (SwanAppAudioPlayer.this.f10926e != null) {
                SwanAppAudioPlayer.this.f10926e.b("onError", jSONObject);
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--oninfo -> what: " + i2 + " ,extra: " + i3);
                return false;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.f10927f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f10926e != null) {
                SwanAppAudioPlayer.this.f10926e.a("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.f10928g) {
                SwanAppAudioPlayer.this.H();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.f10926e != null) {
                SwanAppAudioPlayer.this.f10926e.a("onSeeked");
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
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
                    if (SwanAppAudioPlayer.this.f10926e != null) {
                        SwanAppAudioPlayer.this.f10926e.b("onTimeUpdate", jSONObject);
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
        this.f10922a = "";
        this.f10922a = str;
        d.a.i0.a.i1.b.a(this);
    }

    public final void A() {
        if (this.k) {
            u().reset();
            E(this.f10924c.f42547c);
            this.k = false;
        }
        u().prepareAsync();
        this.f10927f = PlayerStatus.PREPARING;
    }

    public void B() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.f10928g = UserStatus.DESTROY;
        a();
        u().release();
        this.f10927f = PlayerStatus.NONE;
        this.f10923b = null;
        d dVar = this.f10925d;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f10925d = null;
        }
        d.a.i0.a.i1.b.j(this);
    }

    public final void C() {
        if (v() || this.f10930i) {
            return;
        }
        if (this.f10929h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f10929h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b();
        }
        this.f10930i = this.f10929h.requestAudioFocus(this.j, 3, 1) == 1;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
        }
    }

    public void D(int i2) {
        if (this.f10927f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i2);
            }
            u().seekTo((int) (i2 * 1000));
            d.a.i0.a.i1.c.e.a aVar = this.f10926e;
            if (aVar != null) {
                aVar.a("onSeeking");
            }
        }
    }

    public final void E(String str) {
        try {
            String a2 = f.V().I().a(str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            HashMap hashMap = new HashMap();
            String b2 = d0.b();
            if (!TextUtils.isEmpty(b2) && d0.c(a2)) {
                if (l) {
                    Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + b2);
                }
                hashMap.put("Referer", b2);
            }
            String Y = g.N().Y();
            if (!TextUtils.isEmpty(Y)) {
                hashMap.put("User-Agent", Y);
            }
            String j = d.a.i0.a.l2.b.l().j(a2);
            if (!TextUtils.isEmpty(j)) {
                hashMap.put("Cookie", j);
                if (l) {
                    Log.d("SwanAppAudioPlayer", "addCookiesToHeader cookie: " + j);
                }
            }
            u().setDataSource(AppRuntime.getAppContext(), Uri.parse(a2), hashMap);
            this.f10927f = PlayerStatus.IDLE;
        } catch (IOException unused) {
            if (l) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.f10926e != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.i(null)) {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_NO_PERMISSION);
                } else {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                }
                this.f10926e.a("onError");
            }
        }
    }

    public final void F(boolean z) {
        u().setLooping(z);
    }

    public final void G(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        u().setVolume(f2, f2);
    }

    public final void H() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        C();
        u().start();
        d dVar = this.f10925d;
        if (dVar != null) {
            dVar.sendEmptyMessage(0);
        }
        d.a.i0.a.i1.c.e.a aVar = this.f10926e;
        if (aVar != null) {
            aVar.a("onPlay");
        }
        K();
        int i2 = this.f10924c.f42548d;
        if (i2 > 0) {
            D(i2);
        }
        if (d.a.i0.a.c1.b.f().b()) {
            y();
        }
    }

    public void I() {
        this.f10928g = UserStatus.STOP;
        if (this.f10927f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            u().stop();
            this.f10927f = PlayerStatus.IDLE;
            d dVar = this.f10925d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
            d.a.i0.a.i1.c.e.a aVar = this.f10926e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void J(d.a.i0.a.i1.c.b bVar) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.f10924c.f42547c;
        this.f10924c = bVar;
        d.a.i0.a.i1.c.e.a aVar = this.f10926e;
        if (aVar != null) {
            aVar.d(bVar.j);
        }
        K();
        if (TextUtils.equals(bVar.f42547c, str)) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "update src: " + bVar.f42547c);
        }
        this.k = true;
        A();
    }

    public final void K() {
        F(this.f10924c.f42550f);
        G(this.f10924c.f42553i);
    }

    public final void a() {
        b bVar;
        if (this.f10930i) {
            AudioManager audioManager = this.f10929h;
            if (audioManager != null && (bVar = this.j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f10929h = null;
                this.j = null;
            }
            this.f10930i = false;
            if (l) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.i0.a.i1.a
    public String b() {
        return this.f10924c.f42546b;
    }

    @Override // d.a.i0.a.i1.a
    public String c() {
        return this.f10922a;
    }

    @Override // d.a.i0.a.i1.a
    public String f() {
        return null;
    }

    @Override // d.a.i0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.i0.a.i1.a
    public void j(boolean z) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (z) {
            return;
        }
        y();
    }

    @Override // d.a.i0.a.i1.a
    public void k(boolean z) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e i2 = e.i();
        if (i2 == null || !i2.m0()) {
            return;
        }
        if (!z) {
            y();
        } else if (this.f10928g == UserStatus.PLAY) {
            z();
        }
    }

    @Override // d.a.i0.a.i1.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // d.a.i0.a.i1.a
    public void onDestroy() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onDestroy");
        }
        e i2 = e.i();
        if (i2 == null || !i2.m0()) {
            return;
        }
        B();
    }

    public d.a.i0.a.i1.c.b t() {
        return this.f10924c;
    }

    public final MediaPlayer u() {
        if (this.f10923b == null) {
            this.f10923b = new MediaPlayer();
            c cVar = new c();
            this.f10923b.setOnPreparedListener(cVar);
            this.f10923b.setOnCompletionListener(cVar);
            this.f10923b.setOnInfoListener(cVar);
            this.f10923b.setOnErrorListener(cVar);
            this.f10923b.setOnSeekCompleteListener(cVar);
            this.f10923b.setOnBufferingUpdateListener(cVar);
            this.f10925d = new d();
        }
        return this.f10923b;
    }

    public final boolean v() {
        e i2 = e.i();
        boolean booleanValue = i2 == null ? false : i2.J().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
        if (l) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public void w(d.a.i0.a.i1.c.b bVar, CallbackHandler callbackHandler) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.f10928g = UserStatus.OPEN;
        this.f10924c = bVar;
        if (bVar.j != null) {
            try {
                this.f10926e = new d.a.i0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f10924c.j));
            } catch (JSONException unused) {
                if (l) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        u().reset();
        E(this.f10924c.f42547c);
        A();
    }

    public void x() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.f10928g = UserStatus.PAUSE;
        y();
    }

    public final void y() {
        if (u().isPlaying()) {
            u().pause();
            d.a.i0.a.i1.c.e.a aVar = this.f10926e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f10925d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    public void z() {
        this.f10928g = UserStatus.PLAY;
        if (d.a.i0.a.c1.b.f().b()) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "===play");
        }
        C();
        PlayerStatus playerStatus = this.f10927f;
        if (playerStatus == PlayerStatus.PREPARED) {
            u().start();
            d dVar = this.f10925d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            d.a.i0.a.i1.c.e.a aVar = this.f10926e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            u().prepareAsync();
            this.f10927f = PlayerStatus.PREPARING;
        }
    }
}
