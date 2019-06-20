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
import com.baidu.ubc.UBC;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aAT;
    private c aAV;
    private com.baidu.swan.apps.media.audio.b.a aAW;
    private boolean aAZ;
    private String aAu;
    private a aBa;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b aAU = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus aAX = PlayerStatus.NONE;
    private UserStatus aAY = UserStatus.OPEN;

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
        this.aAu = "";
        this.aAu = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Gp();
        Gm().start();
        if (this.aAV != null) {
            this.aAV.sendEmptyMessage(0);
        }
        if (this.aAW != null) {
            this.aAW.fj("onPlay");
        }
        Go();
        if (this.aAU.aAy > 0) {
            seekTo(this.aAU.aAy);
        }
        if (Ak()) {
            Gk();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.aAY = UserStatus.PAUSE;
        Gk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk() {
        if (Gm().isPlaying()) {
            Gm().pause();
            if (this.aAW != null) {
                this.aAW.fj("onPause");
            }
            if (this.aAV != null) {
                this.aAV.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.aAX == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Gm().seekTo((int) (i * 1000));
            if (this.aAW != null) {
                this.aAW.fj("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Gm().setLooping(z);
    }

    public void stop() {
        this.aAY = UserStatus.STOP;
        if (this.aAX == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Gm().stop();
            this.aAX = PlayerStatus.IDLE;
            if (this.aAV != null) {
                this.aAV.removeMessages(0);
            }
            if (this.aAW != null) {
                this.aAW.fj("onStop");
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.aAY = UserStatus.DESTROY;
        zi();
        Gm().release();
        this.aAX = PlayerStatus.NONE;
        this.aAT = null;
        if (this.aAV != null) {
            this.aAV.removeMessages(0);
            this.aAV = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    private int Gl() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   getSystemVolume -> " + streamVolume);
        }
        return streamVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Gm() {
        if (this.aAT == null) {
            this.aAT = new MediaPlayer();
            b bVar = new b();
            this.aAT.setOnPreparedListener(bVar);
            this.aAT.setOnCompletionListener(bVar);
            this.aAT.setOnInfoListener(bVar);
            this.aAT.setOnErrorListener(bVar);
            this.aAT.setOnSeekCompleteListener(bVar);
            this.aAT.setOnBufferingUpdateListener(bVar);
            this.aAV = new c();
        }
        return this.aAT;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gc() {
        return this.aAu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gd() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aAU.aAv;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ge() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bt(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && Lq.LC()) {
            if (!z) {
                Gk();
            } else if (this.aAY == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bu(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            Gk();
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
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && Lq.LC()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Gn() {
        return this.aAU;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.aAY = UserStatus.OPEN;
        this.aAU = bVar;
        if (this.aAU.aAA != null) {
            try {
                this.aAW = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aAU.aAA));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Gm().reset();
        try {
            String str = this.aAU.mUrl;
            com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
            if (Lq != null) {
                if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                    str = g.jp(str);
                } else {
                    str = com.baidu.swan.apps.storage.b.b(str, Lq);
                }
            }
            Gm().setDataSource(str);
            this.aAX = PlayerStatus.IDLE;
            if (this.aAW != null) {
                this.aAW.fj("onCanplay");
            }
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.aAW != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errorCode", "10002");
                } else {
                    jSONObject.optString("errorCode", "10003");
                }
                this.aAW.fj("onError");
            }
        }
    }

    public void play() {
        this.aAY = UserStatus.PLAY;
        if (!Ak()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Gp();
            if (this.aAX == PlayerStatus.PREPARED) {
                Gm().start();
                if (this.aAV != null) {
                    this.aAV.sendEmptyMessage(0);
                }
                if (this.aAW != null) {
                    this.aAW.fj("onPlay");
                }
            } else if (this.aAX == PlayerStatus.IDLE) {
                Gm().prepareAsync();
                this.aAX = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        this.aAU = bVar;
        if (this.aAW != null) {
            this.aAW.fi(this.aAU.aAA);
        }
        Go();
    }

    private boolean Ak() {
        if (com.baidu.swan.apps.ae.b.Lq() == null || !com.baidu.swan.apps.ae.b.Lq().LC()) {
            return false;
        }
        e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b zK = vi.zK();
        if (zK == null || !(zK instanceof h)) {
            return true;
        }
        return ((h) zK).Ak();
    }

    private void Go() {
        setLooping(this.aAU.mLoop);
        setVolume(this.aAU.aAF);
        if (Gl() > 0 || !this.aAU.aAE) {
            setVolume(this.aAU.aAF);
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
        Gm().setVolume(f, f);
    }

    private void Gp() {
        if (!Gq() && !this.aAZ) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aBa == null) {
                this.aBa = new a();
            }
            this.aAZ = this.mAudioManager.requestAudioFocus(this.aBa, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        if (this.aAZ) {
            if (this.mAudioManager != null && this.aBa != null) {
                this.mAudioManager.abandonAudioFocus(this.aBa);
                this.mAudioManager = null;
                this.aBa = null;
            }
            this.aAZ = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gq() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        boolean z = Lq != null ? Lq.LA().getBoolean("key_audio_is_mix_with_other", false) : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Gm().getCurrentPosition() / 1000));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(SwanAppAudioPlayer.this.Gm().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.aAW != null) {
                        SwanAppAudioPlayer.this.aAW.f("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.aAX = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Gm().isLooping()) {
                SwanAppAudioPlayer.this.aAY = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.aAX = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.aAW != null) {
                SwanAppAudioPlayer.this.aAW.fj("onEnded");
            }
            SwanAppAudioPlayer.this.aAV.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.aAW != null) {
                SwanAppAudioPlayer.this.aAW.f("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.aAW != null) {
                SwanAppAudioPlayer.this.aAW.fj("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.aAX == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Gm().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Gm().getCurrentPosition() && SwanAppAudioPlayer.this.aAW != null) {
                SwanAppAudioPlayer.this.aAW.fj("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.Gq()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.zi();
                                SwanAppAudioPlayer.this.Gk();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.zi();
                                SwanAppAudioPlayer.this.Gk();
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
