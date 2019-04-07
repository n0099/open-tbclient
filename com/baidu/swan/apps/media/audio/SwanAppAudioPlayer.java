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
    private boolean aAb;
    private a aAc;
    private MediaPlayer azV;
    private c azX;
    private com.baidu.swan.apps.media.audio.b.a azY;
    private String azv;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b azW = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus azZ = PlayerStatus.NONE;
    private UserStatus aAa = UserStatus.OPEN;

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
        this.azv = "";
        this.azv = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Et();
        Eq().start();
        if (this.azX != null) {
            this.azX.sendEmptyMessage(0);
        }
        if (this.azY != null) {
            this.azY.eZ("onPlay");
        }
        Es();
        if (this.azW.azA > 0) {
            seekTo(this.azW.azA);
        }
        if (zk()) {
            Eo();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.aAa = UserStatus.PAUSE;
        Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        if (Eq().isPlaying()) {
            Eq().pause();
            if (this.azY != null) {
                this.azY.eZ("onPause");
            }
            if (this.azX != null) {
                this.azX.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.azZ == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Eq().seekTo((int) (i * 1000));
            if (this.azY != null) {
                this.azY.eZ("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Eq().setLooping(z);
    }

    public void stop() {
        this.aAa = UserStatus.STOP;
        if (this.azZ == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Eq().stop();
            this.azZ = PlayerStatus.IDLE;
            if (this.azX != null) {
                this.azX.removeMessages(0);
            }
            if (this.azY != null) {
                this.azY.eZ("onStop");
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.aAa = UserStatus.DESTROY;
        yo();
        Eq().release();
        this.azZ = PlayerStatus.NONE;
        this.azV = null;
        if (this.azX != null) {
            this.azX.removeMessages(0);
            this.azX = null;
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
        if (this.azV == null) {
            this.azV = new MediaPlayer();
            b bVar = new b();
            this.azV.setOnPreparedListener(bVar);
            this.azV.setOnCompletionListener(bVar);
            this.azV.setOnInfoListener(bVar);
            this.azV.setOnErrorListener(bVar);
            this.azV.setOnSeekCompleteListener(bVar);
            this.azV.setOnBufferingUpdateListener(bVar);
            this.azX = new c();
        }
        return this.azV;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.azv;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eh() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.azW.azw;
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
            } else if (this.aAa == UserStatus.PLAY) {
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
        return this.azW;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.aAa = UserStatus.OPEN;
        this.azW = bVar;
        if (this.azW.azC != null) {
            try {
                this.azY = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.azW.azC));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Eq().reset();
        try {
            String str = this.azW.mUrl;
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            if (IV != null) {
                if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                    str = g.iG(str);
                } else {
                    str = com.baidu.swan.apps.storage.b.b(str, IV);
                }
            }
            Eq().setDataSource(str);
            this.azZ = PlayerStatus.IDLE;
            if (this.azY != null) {
                this.azY.eZ("onCanplay");
            }
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.azY != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errorCode", "10002");
                } else {
                    jSONObject.optString("errorCode", "10003");
                }
                this.azY.eZ("onError");
            }
        }
    }

    public void play() {
        this.aAa = UserStatus.PLAY;
        if (!zk()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Et();
            if (this.azZ == PlayerStatus.PREPARED) {
                Eq().start();
                if (this.azX != null) {
                    this.azX.sendEmptyMessage(0);
                }
                if (this.azY != null) {
                    this.azY.eZ("onPlay");
                }
            } else if (this.azZ == PlayerStatus.IDLE) {
                Eq().prepareAsync();
                this.azZ = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        this.azW = bVar;
        if (this.azY != null) {
            this.azY.eY(this.azW.azC);
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
        setLooping(this.azW.mLoop);
        setVolume(this.azW.azH);
        if (Ep() > 0 || !this.azW.azG) {
            setVolume(this.azW.azH);
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
        if (!Eu() && !this.aAb) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aAc == null) {
                this.aAc = new a();
            }
            this.aAb = this.mAudioManager.requestAudioFocus(this.aAc, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo() {
        if (this.aAb) {
            if (this.mAudioManager != null && this.aAc != null) {
                this.mAudioManager.abandonAudioFocus(this.aAc);
                this.mAudioManager = null;
                this.aAc = null;
            }
            this.aAb = false;
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
                    if (SwanAppAudioPlayer.this.azY != null) {
                        SwanAppAudioPlayer.this.azY.f("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.azZ = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Eq().isLooping()) {
                SwanAppAudioPlayer.this.aAa = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.azZ = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.azY != null) {
                SwanAppAudioPlayer.this.azY.eZ("onEnded");
            }
            SwanAppAudioPlayer.this.azX.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.azY != null) {
                SwanAppAudioPlayer.this.azY.f("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.azY != null) {
                SwanAppAudioPlayer.this.azY.eZ("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.azZ == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Eq().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Eq().getCurrentPosition() && SwanAppAudioPlayer.this.azY != null) {
                SwanAppAudioPlayer.this.azY.eZ("onWaiting");
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
