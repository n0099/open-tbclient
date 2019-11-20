package com.baidu.swan.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private MediaPlayer aUW;
    private c aUY;
    private com.baidu.swan.apps.media.audio.b.a aUZ;
    private String aUw;
    private boolean aVc;
    private a aVd;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b aUX = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus aVa = PlayerStatus.NONE;
    private UserStatus aVb = UserStatus.OPEN;

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
        this.aUw = "";
        this.aUw = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        LY();
        LV().start();
        if (this.aUY != null) {
            this.aUY.sendEmptyMessage(0);
        }
        if (this.aUZ != null) {
            this.aUZ.fW("onPlay");
        }
        LX();
        if (this.aUX.aUA > 0) {
            seekTo(this.aUX.aUA);
        }
        if (FR()) {
            LT();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.aVb = UserStatus.PAUSE;
        LT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LT() {
        if (LV().isPlaying()) {
            LV().pause();
            if (this.aUZ != null) {
                this.aUZ.fW("onPause");
            }
            if (this.aUY != null) {
                this.aUY.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.aVa == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            LV().seekTo((int) (i * 1000));
            if (this.aUZ != null) {
                this.aUZ.fW("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        LV().setLooping(z);
    }

    public void stop() {
        this.aVb = UserStatus.STOP;
        if (this.aVa == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            LV().stop();
            this.aVa = PlayerStatus.IDLE;
            if (this.aUY != null) {
                this.aUY.removeMessages(0);
            }
            if (this.aUZ != null) {
                this.aUZ.fW("onStop");
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.aVb = UserStatus.DESTROY;
        EP();
        LV().release();
        this.aVa = PlayerStatus.NONE;
        this.aUW = null;
        if (this.aUY != null) {
            this.aUY.removeMessages(0);
            this.aUY = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    private int LU() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   getSystemVolume -> " + streamVolume);
        }
        return streamVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer LV() {
        if (this.aUW == null) {
            this.aUW = new MediaPlayer();
            b bVar = new b();
            this.aUW.setOnPreparedListener(bVar);
            this.aUW.setOnCompletionListener(bVar);
            this.aUW.setOnInfoListener(bVar);
            this.aUW.setOnErrorListener(bVar);
            this.aUW.setOnSeekCompleteListener(bVar);
            this.aUW.setOnBufferingUpdateListener(bVar);
            this.aUY = new c();
        }
        return this.aUW;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return this.aUw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LM() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aUX.aUx;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LN() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && Ra.Rn()) {
            if (!z) {
                LT();
            } else if (this.aVb == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            LT();
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
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && Ra.Rn()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b LW() {
        return this.aUX;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.aVb = UserStatus.OPEN;
        this.aUX = bVar;
        if (this.aUX.aUC != null) {
            try {
                this.aUZ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aUX.aUC));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        LV().reset();
        try {
            String str = this.aUX.mUrl;
            com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
            if (Ra != null) {
                if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                    str = g.kb(str);
                } else {
                    str = com.baidu.swan.apps.storage.b.b(str, Ra);
                }
            }
            LV().setDataSource(str);
            this.aVa = PlayerStatus.IDLE;
            if (this.aUZ != null) {
                this.aUZ.fW("onCanplay");
            }
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.aUZ != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.aUZ.fW("onError");
            }
        }
    }

    public void play() {
        this.aVb = UserStatus.PLAY;
        if (!FR()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            LY();
            if (this.aVa == PlayerStatus.PREPARED) {
                LV().start();
                if (this.aUY != null) {
                    this.aUY.sendEmptyMessage(0);
                }
                if (this.aUZ != null) {
                    this.aUZ.fW("onPlay");
                }
            } else if (this.aVa == PlayerStatus.IDLE) {
                LV().prepareAsync();
                this.aVa = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        this.aUX = bVar;
        if (this.aUZ != null) {
            this.aUZ.fV(this.aUX.aUC);
        }
        LX();
    }

    private boolean FR() {
        if (com.baidu.swan.apps.ae.b.Ra() == null || !com.baidu.swan.apps.ae.b.Ra().Rn()) {
            return false;
        }
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Fr = AI.Fr();
        if (Fr == null || !(Fr instanceof h)) {
            return true;
        }
        return ((h) Fr).FR();
    }

    private void LX() {
        setLooping(this.aUX.aUG);
        setVolume(this.aUX.aUI);
        if (LU() > 0 || !this.aUX.aUH) {
            setVolume(this.aUX.aUI);
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
        LV().setVolume(f, f);
    }

    private void LY() {
        if (!LZ() && !this.aVc) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aVd == null) {
                this.aVd = new a();
            }
            this.aVc = this.mAudioManager.requestAudioFocus(this.aVd, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP() {
        if (this.aVc) {
            if (this.mAudioManager != null && this.aVd != null) {
                this.mAudioManager.abandonAudioFocus(this.aVd);
                this.mAudioManager = null;
                this.aVd = null;
            }
            this.aVc = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LZ() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        boolean z = Ra != null ? Ra.Rl().getBoolean("key_audio_is_mix_with_other", false) : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.LV().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.LV().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.aUZ != null) {
                        SwanAppAudioPlayer.this.aUZ.f("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.aVa = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.LV().isLooping()) {
                SwanAppAudioPlayer.this.aVb = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.aVa = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.aUZ != null) {
                SwanAppAudioPlayer.this.aUZ.fW("onEnded");
            }
            SwanAppAudioPlayer.this.aUY.removeMessages(0);
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
                jSONObject.putOpt(TiebaInitialize.LogFields.ERROR_CODE, str);
            } catch (JSONException e) {
                if (SwanAppAudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            if (SwanAppAudioPlayer.this.aUZ != null) {
                SwanAppAudioPlayer.this.aUZ.f("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.aUZ != null) {
                SwanAppAudioPlayer.this.aUZ.fW("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.aVa == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.LV().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.LV().getCurrentPosition() && SwanAppAudioPlayer.this.aUZ != null) {
                SwanAppAudioPlayer.this.aUZ.fW("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.LZ()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.EP();
                                SwanAppAudioPlayer.this.LT();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.EP();
                                SwanAppAudioPlayer.this.LT();
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
