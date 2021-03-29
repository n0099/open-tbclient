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
    public static final boolean l = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f12250a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f12251b;

    /* renamed from: d  reason: collision with root package name */
    public d f12253d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.b1.c.e.a f12254e;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f12257h;
    public boolean i;
    public b j;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.b1.c.b f12252c = new d.b.g0.a.b1.c.b();

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f12255f = PlayerStatus.NONE;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f12256g = UserStatus.OPEN;
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
            public final /* synthetic */ int f12259e;

            public a(int i) {
                this.f12259e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioPlayer.this.w()) {
                    return;
                }
                int i = this.f12259e;
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
            if (SwanAppAudioPlayer.this.f12255f != PlayerStatus.PREPARED || (i * SwanAppAudioPlayer.this.u().getDuration()) / 100 > SwanAppAudioPlayer.this.u().getCurrentPosition() || SwanAppAudioPlayer.this.f12254e == null) {
                return;
            }
            SwanAppAudioPlayer.this.f12254e.a("onWaiting");
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.u().isLooping()) {
                SwanAppAudioPlayer.this.f12256g = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.f12255f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f12254e != null) {
                SwanAppAudioPlayer.this.f12254e.a("onEnded");
            }
            SwanAppAudioPlayer.this.f12253d.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.f12254e != null) {
                SwanAppAudioPlayer.this.f12254e.b("onError", jSONObject);
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
            SwanAppAudioPlayer.this.f12255f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f12254e != null) {
                SwanAppAudioPlayer.this.f12254e.a("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.f12256g) {
                SwanAppAudioPlayer.this.I();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.f12254e != null) {
                SwanAppAudioPlayer.this.f12254e.a("onSeeked");
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
                    if (SwanAppAudioPlayer.this.f12254e != null) {
                        SwanAppAudioPlayer.this.f12254e.b("onTimeUpdate", jSONObject);
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
        this.f12250a = "";
        this.f12250a = str;
        d.b.g0.a.b1.b.a(this);
    }

    public void A() {
        this.f12256g = UserStatus.PLAY;
        if (v()) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "===play");
        }
        D();
        PlayerStatus playerStatus = this.f12255f;
        if (playerStatus == PlayerStatus.PREPARED) {
            u().start();
            d dVar = this.f12253d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            d.b.g0.a.b1.c.e.a aVar = this.f12254e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            u().prepareAsync();
            this.f12255f = PlayerStatus.PREPARING;
        }
    }

    public final void B() {
        if (this.k) {
            u().reset();
            F(this.f12252c.f43288c);
            this.k = false;
        }
        u().prepareAsync();
        this.f12255f = PlayerStatus.PREPARING;
    }

    public void C() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.f12256g = UserStatus.DESTROY;
        g();
        u().release();
        this.f12255f = PlayerStatus.NONE;
        this.f12251b = null;
        d dVar = this.f12253d;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f12253d = null;
        }
        d.b.g0.a.b1.b.j(this);
    }

    public final void D() {
        if (w() || this.i) {
            return;
        }
        if (this.f12257h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.f12257h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b();
        }
        this.i = this.f12257h.requestAudioFocus(this.j, 3, 1) == 1;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
        }
    }

    public void E(int i) {
        if (this.f12255f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            u().seekTo((int) (i * 1000));
            d.b.g0.a.b1.c.e.a aVar = this.f12254e;
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
            this.f12255f = PlayerStatus.IDLE;
        } catch (IOException unused) {
            if (l) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.f12254e != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.h(null)) {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_NO_PERMISSION);
                } else {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                }
                this.f12254e.a("onError");
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
        d dVar = this.f12253d;
        if (dVar != null) {
            dVar.sendEmptyMessage(0);
        }
        d.b.g0.a.b1.c.e.a aVar = this.f12254e;
        if (aVar != null) {
            aVar.a("onPlay");
        }
        L();
        int i = this.f12252c.f43289d;
        if (i > 0) {
            E(i);
        }
        if (v()) {
            z();
        }
    }

    public void J() {
        this.f12256g = UserStatus.STOP;
        if (this.f12255f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            u().stop();
            this.f12255f = PlayerStatus.IDLE;
            d dVar = this.f12253d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
            d.b.g0.a.b1.c.e.a aVar = this.f12254e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void K(d.b.g0.a.b1.c.b bVar) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.f12252c.f43288c;
        this.f12252c = bVar;
        d.b.g0.a.b1.c.e.a aVar = this.f12254e;
        if (aVar != null) {
            aVar.d(bVar.j);
        }
        L();
        if (TextUtils.equals(bVar.f43288c, str)) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "update src: " + bVar.f43288c);
        }
        this.k = true;
        B();
    }

    public final void L() {
        G(this.f12252c.f43291f);
        H(this.f12252c.i);
    }

    @Override // d.b.g0.a.b1.a
    public Object a() {
        return this;
    }

    @Override // d.b.g0.a.b1.a
    public String b() {
        return this.f12252c.f43287b;
    }

    @Override // d.b.g0.a.b1.a
    public String c() {
        return this.f12250a;
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
        } else if (this.f12256g == UserStatus.PLAY) {
            A();
        }
    }

    public final void g() {
        b bVar;
        if (this.i) {
            AudioManager audioManager = this.f12257h;
            if (audioManager != null && (bVar = this.j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f12257h = null;
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
        return this.f12252c;
    }

    public final MediaPlayer u() {
        if (this.f12251b == null) {
            this.f12251b = new MediaPlayer();
            c cVar = new c();
            this.f12251b.setOnPreparedListener(cVar);
            this.f12251b.setOnCompletionListener(cVar);
            this.f12251b.setOnInfoListener(cVar);
            this.f12251b.setOnErrorListener(cVar);
            this.f12251b.setOnSeekCompleteListener(cVar);
            this.f12251b.setOnBufferingUpdateListener(cVar);
            this.f12253d = new d();
        }
        return this.f12251b;
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
        this.f12256g = UserStatus.OPEN;
        this.f12252c = bVar;
        if (bVar.j != null) {
            try {
                this.f12254e = new d.b.g0.a.b1.c.e.a(callbackHandler, new JSONObject(this.f12252c.j));
            } catch (JSONException unused) {
                if (l) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        u().reset();
        F(this.f12252c.f43288c);
        B();
    }

    public void y() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.f12256g = UserStatus.PAUSE;
        z();
    }

    public final void z() {
        if (u().isPlaying()) {
            u().pause();
            d.b.g0.a.b1.c.e.a aVar = this.f12254e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f12253d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
