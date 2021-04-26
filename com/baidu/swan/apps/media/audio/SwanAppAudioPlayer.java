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
import d.a.h0.a.e0.l.j;
import d.a.h0.a.i2.b0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.z0.f;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class SwanAppAudioPlayer implements d.a.h0.a.b1.a {
    public static final boolean l = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f11756a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f11757b;

    /* renamed from: d  reason: collision with root package name */
    public d f11759d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.b1.c.e.a f11760e;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f11763h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11764i;
    public b j;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.b1.c.b f11758c = new d.a.h0.a.b1.c.b();

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f11761f = PlayerStatus.NONE;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f11762g = UserStatus.OPEN;
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
            public final /* synthetic */ int f11766e;

            public a(int i2) {
                this.f11766e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioPlayer.this.w()) {
                    return;
                }
                int i2 = this.f11766e;
                if (i2 == -2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    SwanAppAudioPlayer.this.g();
                    SwanAppAudioPlayer.this.z();
                } else if (i2 != -1) {
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
        public void onAudioFocusChange(int i2) {
            k0.X(new a(i2));
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
            if (SwanAppAudioPlayer.this.f11761f != PlayerStatus.PREPARED || (i2 * SwanAppAudioPlayer.this.u().getDuration()) / 100 > SwanAppAudioPlayer.this.u().getCurrentPosition() || SwanAppAudioPlayer.this.f11760e == null) {
                return;
            }
            SwanAppAudioPlayer.this.f11760e.a("onWaiting");
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.u().isLooping()) {
                SwanAppAudioPlayer.this.f11762g = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.f11761f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f11760e != null) {
                SwanAppAudioPlayer.this.f11760e.a("onEnded");
            }
            SwanAppAudioPlayer.this.f11759d.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.f11760e != null) {
                SwanAppAudioPlayer.this.f11760e.b("onError", jSONObject);
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
            SwanAppAudioPlayer.this.f11761f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.f11760e != null) {
                SwanAppAudioPlayer.this.f11760e.a("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.f11762g) {
                SwanAppAudioPlayer.this.I();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.f11760e != null) {
                SwanAppAudioPlayer.this.f11760e.a("onSeeked");
            }
        }
    }

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
                    if (SwanAppAudioPlayer.this.f11760e != null) {
                        SwanAppAudioPlayer.this.f11760e.b("onTimeUpdate", jSONObject);
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
        this.f11756a = "";
        this.f11756a = str;
        d.a.h0.a.b1.b.a(this);
    }

    public void A() {
        this.f11762g = UserStatus.PLAY;
        if (v()) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "===play");
        }
        D();
        PlayerStatus playerStatus = this.f11761f;
        if (playerStatus == PlayerStatus.PREPARED) {
            u().start();
            d dVar = this.f11759d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            d.a.h0.a.b1.c.e.a aVar = this.f11760e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            u().prepareAsync();
            this.f11761f = PlayerStatus.PREPARING;
        }
    }

    public final void B() {
        if (this.k) {
            u().reset();
            F(this.f11758c.f41280c);
            this.k = false;
        }
        u().prepareAsync();
        this.f11761f = PlayerStatus.PREPARING;
    }

    public void C() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.f11762g = UserStatus.DESTROY;
        g();
        u().release();
        this.f11761f = PlayerStatus.NONE;
        this.f11757b = null;
        d dVar = this.f11759d;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f11759d = null;
        }
        d.a.h0.a.b1.b.j(this);
    }

    public final void D() {
        if (w() || this.f11764i) {
            return;
        }
        if (this.f11763h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f11763h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b();
        }
        this.f11764i = this.f11763h.requestAudioFocus(this.j, 3, 1) == 1;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
        }
    }

    public void E(int i2) {
        if (this.f11761f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i2);
            }
            u().seekTo((int) (i2 * 1000));
            d.a.h0.a.b1.c.e.a aVar = this.f11760e;
            if (aVar != null) {
                aVar.a("onSeeking");
            }
        }
    }

    public final void F(String str) {
        try {
            String e2 = f.V().I().e(str);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            HashMap hashMap = new HashMap();
            String b2 = b0.b();
            if (!TextUtils.isEmpty(b2) && b0.c(e2)) {
                if (l) {
                    Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + b2);
                }
                hashMap.put("Referer", b2);
            }
            String W = d.a.h0.a.e0.w.d.L().W();
            if (!TextUtils.isEmpty(W)) {
                hashMap.put("User-Agent", W);
            }
            u().setDataSource(AppRuntime.getAppContext(), Uri.parse(e2), hashMap);
            this.f11761f = PlayerStatus.IDLE;
        } catch (IOException unused) {
            if (l) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.f11760e != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.h(null)) {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_NO_PERMISSION);
                } else {
                    jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                }
                this.f11760e.a("onError");
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
        d dVar = this.f11759d;
        if (dVar != null) {
            dVar.sendEmptyMessage(0);
        }
        d.a.h0.a.b1.c.e.a aVar = this.f11760e;
        if (aVar != null) {
            aVar.a("onPlay");
        }
        L();
        int i2 = this.f11758c.f41281d;
        if (i2 > 0) {
            E(i2);
        }
        if (v()) {
            z();
        }
    }

    public void J() {
        this.f11762g = UserStatus.STOP;
        if (this.f11761f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            u().stop();
            this.f11761f = PlayerStatus.IDLE;
            d dVar = this.f11759d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
            d.a.h0.a.b1.c.e.a aVar = this.f11760e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void K(d.a.h0.a.b1.c.b bVar) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.f11758c.f41280c;
        this.f11758c = bVar;
        d.a.h0.a.b1.c.e.a aVar = this.f11760e;
        if (aVar != null) {
            aVar.d(bVar.j);
        }
        L();
        if (TextUtils.equals(bVar.f41280c, str)) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "update src: " + bVar.f41280c);
        }
        this.k = true;
        B();
    }

    public final void L() {
        G(this.f11758c.f41283f);
        H(this.f11758c.f41286i);
    }

    @Override // d.a.h0.a.b1.a
    public String a() {
        return this.f11758c.f41279b;
    }

    @Override // d.a.h0.a.b1.a
    public String b() {
        return this.f11756a;
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
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (z) {
            return;
        }
        z();
    }

    @Override // d.a.h0.a.b1.a
    public void f(boolean z) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e h2 = e.h();
        if (h2 == null || !h2.i0()) {
            return;
        }
        if (!z) {
            z();
        } else if (this.f11762g == UserStatus.PLAY) {
            A();
        }
    }

    public final void g() {
        b bVar;
        if (this.f11764i) {
            AudioManager audioManager = this.f11763h;
            if (audioManager != null && (bVar = this.j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f11763h = null;
                this.j = null;
            }
            this.f11764i = false;
            if (l) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.h0.a.b1.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // d.a.h0.a.b1.a
    public void onDestroy() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onDestroy");
        }
        e h2 = e.h();
        if (h2 == null || !h2.i0()) {
            return;
        }
        C();
    }

    public d.a.h0.a.b1.c.b t() {
        return this.f11758c;
    }

    public final MediaPlayer u() {
        if (this.f11757b == null) {
            this.f11757b = new MediaPlayer();
            c cVar = new c();
            this.f11757b.setOnPreparedListener(cVar);
            this.f11757b.setOnCompletionListener(cVar);
            this.f11757b.setOnInfoListener(cVar);
            this.f11757b.setOnErrorListener(cVar);
            this.f11757b.setOnSeekCompleteListener(cVar);
            this.f11757b.setOnBufferingUpdateListener(cVar);
            this.f11759d = new d();
        }
        return this.f11757b;
    }

    public final boolean v() {
        d.a.h0.a.e0.l.c m;
        if (e.h() == null || !e.h().i0()) {
            return false;
        }
        d.a.h0.a.e0.l.f W = f.V().W();
        if (W == null || (m = W.m()) == null || !(m instanceof j)) {
            return true;
        }
        return ((j) m).c3();
    }

    public final boolean w() {
        e h2 = e.h();
        boolean booleanValue = h2 == null ? false : h2.H().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
        if (l) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public void x(d.a.h0.a.b1.c.b bVar, CallbackHandler callbackHandler) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.f11762g = UserStatus.OPEN;
        this.f11758c = bVar;
        if (bVar.j != null) {
            try {
                this.f11760e = new d.a.h0.a.b1.c.e.a(callbackHandler, new JSONObject(this.f11758c.j));
            } catch (JSONException unused) {
                if (l) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        u().reset();
        F(this.f11758c.f41280c);
        B();
    }

    public void y() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.f11762g = UserStatus.PAUSE;
        z();
    }

    public final void z() {
        if (u().isPlaying()) {
            u().pause();
            d.a.h0.a.b1.c.e.a aVar = this.f11760e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f11759d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
