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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.core.c.h;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.games.f.g;
import com.baidu.ubc.UBC;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aAc;
    private a aAd;
    private MediaPlayer azW;
    private c azY;
    private com.baidu.swan.apps.media.audio.b.a azZ;
    private String azw;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b azX = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus aAa = PlayerStatus.NONE;
    private UserStatus aAb = UserStatus.OPEN;

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
        this.azw = "";
        this.azw = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Et();
        Eq().start();
        if (this.azY != null) {
            this.azY.sendEmptyMessage(0);
        }
        if (this.azZ != null) {
            this.azZ.eZ("onPlay");
        }
        Es();
        if (this.azX.azB > 0) {
            seekTo(this.azX.azB);
        }
        if (zk()) {
            Eo();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.aAb = UserStatus.PAUSE;
        Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        if (Eq().isPlaying()) {
            Eq().pause();
            if (this.azZ != null) {
                this.azZ.eZ("onPause");
            }
            if (this.azY != null) {
                this.azY.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.aAa == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Eq().seekTo((int) (i * 1000));
            if (this.azZ != null) {
                this.azZ.eZ("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Eq().setLooping(z);
    }

    public void stop() {
        this.aAb = UserStatus.STOP;
        if (this.aAa == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Eq().stop();
            this.aAa = PlayerStatus.IDLE;
            if (this.azY != null) {
                this.azY.removeMessages(0);
            }
            if (this.azZ != null) {
                this.azZ.eZ("onStop");
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.aAb = UserStatus.DESTROY;
        yo();
        Eq().release();
        this.aAa = PlayerStatus.NONE;
        this.azW = null;
        if (this.azY != null) {
            this.azY.removeMessages(0);
            this.azY = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    private int Ep() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   getSystemVolume -> " + streamVolume);
        }
        return streamVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Eq() {
        if (this.azW == null) {
            this.azW = new MediaPlayer();
            b bVar = new b();
            this.azW.setOnPreparedListener(bVar);
            this.azW.setOnCompletionListener(bVar);
            this.azW.setOnInfoListener(bVar);
            this.azW.setOnErrorListener(bVar);
            this.azW.setOnSeekCompleteListener(bVar);
            this.azW.setOnBufferingUpdateListener(bVar);
            this.azY = new c();
        }
        return this.azW;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.azw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eh() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.azX.azx;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ei() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bk(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && IV.Jh()) {
            if (!z) {
                Eo();
            } else if (this.aAb == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bl(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            Eo();
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
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && IV.Jh()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Er() {
        return this.azX;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.aAb = UserStatus.OPEN;
        this.azX = bVar;
        if (this.azX.azD != null) {
            try {
                this.azZ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.azX.azD));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Eq().reset();
        try {
            String str = this.azX.mUrl;
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            if (IV != null) {
                if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                    str = g.iG(str);
                } else {
                    str = com.baidu.swan.apps.storage.b.b(str, IV);
                }
            }
            Eq().setDataSource(str);
            this.aAa = PlayerStatus.IDLE;
            if (this.azZ != null) {
                this.azZ.eZ("onCanplay");
            }
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.azZ != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errorCode", "10002");
                } else {
                    jSONObject.optString("errorCode", "10003");
                }
                this.azZ.eZ("onError");
            }
        }
    }

    public void play() {
        this.aAb = UserStatus.PLAY;
        if (!zk()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Et();
            if (this.aAa == PlayerStatus.PREPARED) {
                Eq().start();
                if (this.azY != null) {
                    this.azY.sendEmptyMessage(0);
                }
                if (this.azZ != null) {
                    this.azZ.eZ("onPlay");
                }
            } else if (this.aAa == PlayerStatus.IDLE) {
                Eq().prepareAsync();
                this.aAa = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        this.azX = bVar;
        if (this.azZ != null) {
            this.azZ.eY(this.azX.azD);
        }
        Es();
    }

    private boolean zk() {
        if (com.baidu.swan.apps.ae.b.IV() == null || !com.baidu.swan.apps.ae.b.IV().Jh()) {
            return false;
        }
        e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy == null) {
            return true;
        }
        com.baidu.swan.apps.core.c.b yN = uy.yN();
        if (yN == null || !(yN instanceof h)) {
            return true;
        }
        return ((h) yN).zk();
    }

    private void Es() {
        setLooping(this.azX.mLoop);
        setVolume(this.azX.azI);
        if (Ep() > 0 || !this.azX.azH) {
            setVolume(this.azX.azI);
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
        Eq().setVolume(f, f);
    }

    private void Et() {
        if (!Eu() && !this.aAc) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aAd == null) {
                this.aAd = new a();
            }
            this.aAc = this.mAudioManager.requestAudioFocus(this.aAd, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo() {
        if (this.aAc) {
            if (this.mAudioManager != null && this.aAd != null) {
                this.mAudioManager.abandonAudioFocus(this.aAd);
                this.mAudioManager = null;
                this.aAd = null;
            }
            this.aAc = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Eu() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        boolean z = IV != null ? IV.Jf().getBoolean("key_audio_is_mix_with_other", false) : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Eq().getCurrentPosition() / 1000));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(SwanAppAudioPlayer.this.Eq().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.azZ != null) {
                        SwanAppAudioPlayer.this.azZ.f("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.aAa = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Eq().isLooping()) {
                SwanAppAudioPlayer.this.aAb = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.aAa = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.azZ != null) {
                SwanAppAudioPlayer.this.azZ.eZ("onEnded");
            }
            SwanAppAudioPlayer.this.azY.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.azZ != null) {
                SwanAppAudioPlayer.this.azZ.f("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.azZ != null) {
                SwanAppAudioPlayer.this.azZ.eZ("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.aAa == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Eq().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Eq().getCurrentPosition() && SwanAppAudioPlayer.this.azZ != null) {
                SwanAppAudioPlayer.this.azZ.eZ("onWaiting");
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
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.Eu()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.yo();
                                SwanAppAudioPlayer.this.Eo();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.yo();
                                SwanAppAudioPlayer.this.Eo();
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
