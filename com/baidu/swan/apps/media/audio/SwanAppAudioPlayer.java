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
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ai2;
import com.baidu.tieba.ap3;
import com.baidu.tieba.ck3;
import com.baidu.tieba.ey2;
import com.baidu.tieba.fy2;
import com.baidu.tieba.gb3;
import com.baidu.tieba.hy2;
import com.baidu.tieba.mi3;
import com.baidu.tieba.my2;
import com.baidu.tieba.no3;
import com.baidu.tieba.ou2;
import com.baidu.tieba.qr1;
import com.baidu.tieba.tw2;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppAudioPlayer implements ey2 {
    public static final boolean l = qr1.a;
    public String a;
    public MediaPlayer b;
    public d d;
    public my2 e;
    public AudioManager h;
    public boolean i;
    public b j;
    public hy2 c = new hy2();
    public PlayerStatus f = PlayerStatus.NONE;
    public UserStatus g = UserStatus.OPEN;
    public boolean k = false;

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

    @Override // com.baidu.tieba.ey2
    public String f() {
        return null;
    }

    @Override // com.baidu.tieba.ey2
    public Object i() {
        return this;
    }

    @Override // com.baidu.tieba.ey2
    public boolean onBackPressed() {
        return false;
    }

    /* loaded from: classes4.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioPlayer.this.w()) {
                    return;
                }
                int i = this.a;
                if (i != -2) {
                    if (i == -1) {
                        if (SwanAppAudioPlayer.l) {
                            Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                        }
                        SwanAppAudioPlayer.this.a();
                        SwanAppAudioPlayer.this.z();
                        return;
                    }
                    return;
                }
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                }
                SwanAppAudioPlayer.this.a();
                SwanAppAudioPlayer.this.z();
            }
        }

        public b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            ap3.e0(new a(i));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.e != null) {
                SwanAppAudioPlayer.this.e.a("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.f == PlayerStatus.PREPARED && (i * SwanAppAudioPlayer.this.v().getDuration()) / 100 <= SwanAppAudioPlayer.this.v().getCurrentPosition() && SwanAppAudioPlayer.this.e != null) {
                SwanAppAudioPlayer.this.e.a("onWaiting");
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.v().isLooping()) {
                SwanAppAudioPlayer.this.g = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.e != null) {
                SwanAppAudioPlayer.this.e.a("onEnded");
            }
            SwanAppAudioPlayer.this.d.removeMessages(0);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.f = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.e != null) {
                SwanAppAudioPlayer.this.e.a("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.g) {
                SwanAppAudioPlayer.this.I();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (SwanAppAudioPlayer.l) {
                Log.d("SwanAppAudioPlayer", "--onError -> what: " + i + " extra: " + i2);
            }
            String str = "-1";
            if (i != 1 && i == 100) {
                str = "10001";
            }
            if (i2 == -1007) {
                str = "10004";
            }
            mi3.b("audio", 2008, "audio fail, src: " + SwanAppAudioPlayer.this.c.c, Integer.parseInt(str), "");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(StatConstants.KEY_EXT_ERR_CODE, str);
            } catch (JSONException e) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            if (SwanAppAudioPlayer.this.e != null) {
                SwanAppAudioPlayer.this.e.b(GameAssistConstKt.TYPE_CALLBACK_ERROR, jSONObject);
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
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.v().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.v().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.e != null) {
                        SwanAppAudioPlayer.this.e.b("onTimeUpdate", jSONObject);
                    }
                } catch (JSONException e) {
                    if (SwanAppAudioPlayer.l) {
                        e.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void B() {
        if (this.k) {
            v().reset();
            F(this.c.c);
            this.k = false;
        }
        v().prepareAsync();
        this.f = PlayerStatus.PREPARING;
    }

    public void C() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.g = UserStatus.DESTROY;
        a();
        v().release();
        this.f = PlayerStatus.NONE;
        this.b = null;
        d dVar = this.d;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.d = null;
        }
        fy2.k(this);
    }

    public final void K() {
        G(this.c.f);
        H(this.c.i);
    }

    public final void a() {
        b bVar;
        if (!this.i) {
            return;
        }
        AudioManager audioManager = this.h;
        if (audioManager != null && (bVar = this.j) != null) {
            audioManager.abandonAudioFocus(bVar);
            this.h = null;
            this.j = null;
        }
        this.i = false;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
        }
    }

    @Override // com.baidu.tieba.ey2
    public String b() {
        return this.c.b;
    }

    @Override // com.baidu.tieba.ey2
    public String c() {
        return this.a;
    }

    @Override // com.baidu.tieba.ey2
    public void onDestroy() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onDestroy");
        }
        gb3 M = gb3.M();
        if (M != null && M.w0()) {
            C();
        }
    }

    public hy2 u() {
        return this.c;
    }

    public void y() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.g = UserStatus.PAUSE;
        z();
    }

    public final void z() {
        if (v().isPlaying()) {
            v().pause();
            my2 my2Var = this.e;
            if (my2Var != null) {
                my2Var.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    public SwanAppAudioPlayer(String str) {
        this.a = "";
        this.a = str;
        fy2.a(this);
    }

    public final void G(boolean z) {
        v().setLooping(z);
    }

    public final void H(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        v().setVolume(f, f);
    }

    @Override // com.baidu.tieba.ey2
    public void j(boolean z) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            z();
        }
    }

    public void A() {
        this.g = UserStatus.PLAY;
        if (ou2.f().b()) {
            return;
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "===play");
        }
        D();
        PlayerStatus playerStatus = this.f;
        if (playerStatus == PlayerStatus.PREPARED) {
            v().start();
            d dVar = this.d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            my2 my2Var = this.e;
            if (my2Var != null) {
                my2Var.a("onPlay");
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            v().prepareAsync();
            this.f = PlayerStatus.PREPARING;
        }
    }

    public final void D() {
        if (w() || this.i) {
            return;
        }
        if (this.h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b();
        }
        boolean z = true;
        if (this.h.requestAudioFocus(this.j, 3, 1) != 1) {
            z = false;
        }
        this.i = z;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
        }
    }

    public void E(int i) {
        if (this.f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            v().seekTo((int) (i * 1000));
            my2 my2Var = this.e;
            if (my2Var != null) {
                my2Var.a("onSeeking");
            }
        }
    }

    @Override // com.baidu.tieba.ey2
    public void k(boolean z) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        gb3 M = gb3.M();
        if (M != null && M.w0()) {
            if (!z) {
                z();
            } else if (this.g == UserStatus.PLAY) {
                A();
            }
        }
    }

    public final void F(String str) {
        try {
            str = tw2.T().G().a(str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            HashMap hashMap = new HashMap();
            String b2 = no3.b();
            if (!TextUtils.isEmpty(b2) && no3.c(str)) {
                if (l) {
                    Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + b2);
                }
                hashMap.put("Referer", b2);
            }
            String g0 = ai2.U().g0();
            if (!TextUtils.isEmpty(g0)) {
                hashMap.put("User-Agent", g0);
            }
            String j = ck3.l().j(str);
            if (!TextUtils.isEmpty(j)) {
                hashMap.put("Cookie", j);
                if (l) {
                    Log.d("SwanAppAudioPlayer", "addCookiesToHeader cookie: " + j);
                }
            }
            v().setDataSource(AppRuntime.getAppContext(), Uri.parse(str), hashMap);
            this.f = PlayerStatus.IDLE;
        } catch (IOException unused) {
            mi3.b("audio", 1001, "src replace fail, src is" + str, -1, "");
            if (l) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.e != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.i(null)) {
                    jSONObject.optString(StatConstants.KEY_EXT_ERR_CODE, "10002");
                } else {
                    jSONObject.optString(StatConstants.KEY_EXT_ERR_CODE, "10003");
                }
                this.e.a(GameAssistConstKt.TYPE_CALLBACK_ERROR);
            }
        }
    }

    public final void I() {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        D();
        v().start();
        d dVar = this.d;
        if (dVar != null) {
            dVar.sendEmptyMessage(0);
        }
        my2 my2Var = this.e;
        if (my2Var != null) {
            my2Var.a("onPlay");
        }
        K();
        int i = this.c.d;
        if (i > 0) {
            E(i);
        }
        if (ou2.f().b()) {
            z();
        }
    }

    public void J() {
        this.g = UserStatus.STOP;
        if (this.f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            v().stop();
            this.f = PlayerStatus.IDLE;
            d dVar = this.d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
            my2 my2Var = this.e;
            if (my2Var != null) {
                my2Var.a(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public final MediaPlayer v() {
        if (this.b == null) {
            this.b = new MediaPlayer();
            c cVar = new c();
            this.b.setOnPreparedListener(cVar);
            this.b.setOnCompletionListener(cVar);
            this.b.setOnInfoListener(cVar);
            this.b.setOnErrorListener(cVar);
            this.b.setOnSeekCompleteListener(cVar);
            this.b.setOnBufferingUpdateListener(cVar);
            this.d = new d();
        }
        return this.b;
    }

    public final boolean w() {
        boolean booleanValue;
        gb3 M = gb3.M();
        if (M == null) {
            booleanValue = false;
        } else {
            booleanValue = M.U().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
        }
        if (l) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public void update(hy2 hy2Var) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===update -> " + hy2Var);
        }
        String str = this.c.c;
        this.c = hy2Var;
        my2 my2Var = this.e;
        if (my2Var != null) {
            my2Var.d(hy2Var.j);
        }
        K();
        if (!TextUtils.equals(hy2Var.c, str)) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "update src: " + hy2Var.c);
            }
            this.k = true;
            B();
        }
    }

    public void x(hy2 hy2Var, CallbackHandler callbackHandler) {
        if (l) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.g = UserStatus.OPEN;
        this.c = hy2Var;
        if (hy2Var.j != null) {
            try {
                this.e = new my2(callbackHandler, new JSONObject(this.c.j));
            } catch (JSONException unused) {
                mi3.b("audio", 2009, "Audio callback is not jsonObject", -1, "");
                if (l) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        v().reset();
        F(this.c.c);
        B();
    }
}
