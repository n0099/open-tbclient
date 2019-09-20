package com.baidu.swan.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.games.f.g;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aBA;
    private MediaPlayer aBZ;
    private c aCb;
    private com.baidu.swan.apps.media.audio.b.a aCc;
    private boolean aCf;
    private a aCg;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b aCa = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus aCd = PlayerStatus.NONE;
    private UserStatus aCe = UserStatus.OPEN;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.aBA = "";
        this.aBA = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Hd();
        Ha().start();
        if (this.aCb != null) {
            this.aCb.sendEmptyMessage(0);
        }
        if (this.aCc != null) {
            this.aCc.fq("onPlay");
        }
        Hc();
        if (this.aCa.aBE > 0) {
            seekTo(this.aCa.aBE);
        }
        if (AV()) {
            GY();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.aCe = UserStatus.PAUSE;
        GY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY() {
        if (Ha().isPlaying()) {
            Ha().pause();
            if (this.aCc != null) {
                this.aCc.fq("onPause");
            }
            if (this.aCb != null) {
                this.aCb.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.aCd == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Ha().seekTo((int) (i * 1000));
            if (this.aCc != null) {
                this.aCc.fq("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Ha().setLooping(z);
    }

    public void stop() {
        this.aCe = UserStatus.STOP;
        if (this.aCd == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Ha().stop();
            this.aCd = PlayerStatus.IDLE;
            if (this.aCb != null) {
                this.aCb.removeMessages(0);
            }
            if (this.aCc != null) {
                this.aCc.fq("onStop");
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.aCe = UserStatus.DESTROY;
        zT();
        Ha().release();
        this.aCd = PlayerStatus.NONE;
        this.aBZ = null;
        if (this.aCb != null) {
            this.aCb.removeMessages(0);
            this.aCb = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    private int GZ() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   getSystemVolume -> " + streamVolume);
        }
        return streamVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Ha() {
        if (this.aBZ == null) {
            this.aBZ = new MediaPlayer();
            b bVar = new b();
            this.aBZ.setOnPreparedListener(bVar);
            this.aBZ.setOnCompletionListener(bVar);
            this.aBZ.setOnInfoListener(bVar);
            this.aBZ.setOnErrorListener(bVar);
            this.aBZ.setOnSeekCompleteListener(bVar);
            this.aBZ.setOnBufferingUpdateListener(bVar);
            this.aCb = new c();
        }
        return this.aBZ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GQ() {
        return this.aBA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GR() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aCa.aBB;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GS() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null && Mh.Mt()) {
            if (!z) {
                GY();
            } else if (this.aCe == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            GY();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onDestroy");
        }
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null && Mh.Mt()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Hb() {
        return this.aCa;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.aCe = UserStatus.OPEN;
        this.aCa = bVar;
        if (this.aCa.aBG != null) {
            try {
                this.aCc = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aCa.aBG));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Ha().reset();
        try {
            String str = this.aCa.mUrl;
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (Mh != null) {
                if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                    str = g.jz(str);
                } else {
                    str = com.baidu.swan.apps.storage.b.b(str, Mh);
                }
            }
            Ha().setDataSource(str);
            this.aCd = PlayerStatus.IDLE;
            if (this.aCc != null) {
                this.aCc.fq("onCanplay");
            }
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.aCc != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errorCode", "10002");
                } else {
                    jSONObject.optString("errorCode", "10003");
                }
                this.aCc.fq("onError");
            }
        }
    }

    public void play() {
        this.aCe = UserStatus.PLAY;
        if (!AV()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Hd();
            if (this.aCd == PlayerStatus.PREPARED) {
                Ha().start();
                if (this.aCb != null) {
                    this.aCb.sendEmptyMessage(0);
                }
                if (this.aCc != null) {
                    this.aCc.fq("onPlay");
                }
            } else if (this.aCd == PlayerStatus.IDLE) {
                Ha().prepareAsync();
                this.aCd = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        this.aCa = bVar;
        if (this.aCc != null) {
            this.aCc.fp(this.aCa.aBG);
        }
        Hc();
    }

    private boolean AV() {
        if (com.baidu.swan.apps.ae.b.Mh() == null || !com.baidu.swan.apps.ae.b.Mh().Mt()) {
            return false;
        }
        e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Av = vN.Av();
        if (Av == null || !(Av instanceof h)) {
            return true;
        }
        return ((h) Av).AV();
    }

    private void Hc() {
        setLooping(this.aCa.mLoop);
        setVolume(this.aCa.aBL);
        if (GZ() > 0 || !this.aCa.aBK) {
            setVolume(this.aCa.aBL);
        } else {
            setVolume(0.0f);
        }
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        Ha().setVolume(f, f);
    }

    private void Hd() {
        if (!He() && !this.aCf) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aCg == null) {
                this.aCg = new a();
            }
            this.aCf = this.mAudioManager.requestAudioFocus(this.aCg, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT() {
        if (this.aCf) {
            if (this.mAudioManager != null && this.aCg != null) {
                this.mAudioManager.abandonAudioFocus(this.aCg);
                this.mAudioManager = null;
                this.aCg = null;
            }
            this.aCf = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        boolean z = Mh != null ? Mh.Mr().getBoolean("key_audio_is_mix_with_other", false) : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Ha().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.Ha().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.aCc != null) {
                        SwanAppAudioPlayer.this.aCc.f("onTimeUpdate", jSONObject);
                    }
                } catch (JSONException e) {
                    if (SwanAppAudioPlayer.DEBUG) {
                        e.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.aCd = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Ha().isLooping()) {
                SwanAppAudioPlayer.this.aCe = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.aCd = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.aCc != null) {
                SwanAppAudioPlayer.this.aCc.fq("onEnded");
            }
            SwanAppAudioPlayer.this.aCb.removeMessages(0);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--oninfo -> what: " + i + " ,extra: " + i2);
                return false;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onError -> what: " + i + " extra: " + i2);
            }
            switch (i) {
                case 1:
                    str = LivenessStat.TYPE_STRING_DEFAULT;
                    break;
                case 100:
                    str = "10001";
                    break;
                default:
                    str = LivenessStat.TYPE_STRING_DEFAULT;
                    break;
            }
            if (i2 == -1007) {
                str = "10004";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errorCode", str);
            } catch (JSONException e) {
                if (SwanAppAudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            if (SwanAppAudioPlayer.this.aCc != null) {
                SwanAppAudioPlayer.this.aCc.f("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.aCc != null) {
                SwanAppAudioPlayer.this.aCc.fq("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.aCd == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Ha().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Ha().getCurrentPosition() && SwanAppAudioPlayer.this.aCc != null) {
                SwanAppAudioPlayer.this.aCc.fq("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.He()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.zT();
                                SwanAppAudioPlayer.this.GY();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.zT();
                                SwanAppAudioPlayer.this.GY();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }
}
