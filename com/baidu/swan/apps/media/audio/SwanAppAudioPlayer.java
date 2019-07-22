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
    private MediaPlayer aBB;
    private c aBD;
    private com.baidu.swan.apps.media.audio.b.a aBE;
    private boolean aBH;
    private a aBI;
    private String aBc;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b aBC = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus aBF = PlayerStatus.NONE;
    private UserStatus aBG = UserStatus.OPEN;

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
        this.aBc = "";
        this.aBc = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        GZ();
        GW().start();
        if (this.aBD != null) {
            this.aBD.sendEmptyMessage(0);
        }
        if (this.aBE != null) {
            this.aBE.fo("onPlay");
        }
        GY();
        if (this.aBC.aBg > 0) {
            seekTo(this.aBC.aBg);
        }
        if (AR()) {
            GU();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.aBG = UserStatus.PAUSE;
        GU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (GW().isPlaying()) {
            GW().pause();
            if (this.aBE != null) {
                this.aBE.fo("onPause");
            }
            if (this.aBD != null) {
                this.aBD.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.aBF == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            GW().seekTo((int) (i * 1000));
            if (this.aBE != null) {
                this.aBE.fo("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        GW().setLooping(z);
    }

    public void stop() {
        this.aBG = UserStatus.STOP;
        if (this.aBF == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            GW().stop();
            this.aBF = PlayerStatus.IDLE;
            if (this.aBD != null) {
                this.aBD.removeMessages(0);
            }
            if (this.aBE != null) {
                this.aBE.fo("onStop");
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.aBG = UserStatus.DESTROY;
        zP();
        GW().release();
        this.aBF = PlayerStatus.NONE;
        this.aBB = null;
        if (this.aBD != null) {
            this.aBD.removeMessages(0);
            this.aBD = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    private int GV() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   getSystemVolume -> " + streamVolume);
        }
        return streamVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer GW() {
        if (this.aBB == null) {
            this.aBB = new MediaPlayer();
            b bVar = new b();
            this.aBB.setOnPreparedListener(bVar);
            this.aBB.setOnCompletionListener(bVar);
            this.aBB.setOnInfoListener(bVar);
            this.aBB.setOnErrorListener(bVar);
            this.aBB.setOnSeekCompleteListener(bVar);
            this.aBB.setOnBufferingUpdateListener(bVar);
            this.aBD = new c();
        }
        return this.aBB;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GM() {
        return this.aBc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GN() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.aBC.aBd;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null && Md.Mp()) {
            if (!z) {
                GU();
            } else if (this.aBG == UserStatus.PLAY) {
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
            GU();
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
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null && Md.Mp()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b GX() {
        return this.aBC;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.aBG = UserStatus.OPEN;
        this.aBC = bVar;
        if (this.aBC.aBi != null) {
            try {
                this.aBE = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aBC.aBi));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        GW().reset();
        try {
            String str = this.aBC.mUrl;
            com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
            if (Md != null) {
                if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                    str = g.jx(str);
                } else {
                    str = com.baidu.swan.apps.storage.b.b(str, Md);
                }
            }
            GW().setDataSource(str);
            this.aBF = PlayerStatus.IDLE;
            if (this.aBE != null) {
                this.aBE.fo("onCanplay");
            }
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.aBE != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errorCode", "10002");
                } else {
                    jSONObject.optString("errorCode", "10003");
                }
                this.aBE.fo("onError");
            }
        }
    }

    public void play() {
        this.aBG = UserStatus.PLAY;
        if (!AR()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            GZ();
            if (this.aBF == PlayerStatus.PREPARED) {
                GW().start();
                if (this.aBD != null) {
                    this.aBD.sendEmptyMessage(0);
                }
                if (this.aBE != null) {
                    this.aBE.fo("onPlay");
                }
            } else if (this.aBF == PlayerStatus.IDLE) {
                GW().prepareAsync();
                this.aBF = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        this.aBC = bVar;
        if (this.aBE != null) {
            this.aBE.fn(this.aBC.aBi);
        }
        GY();
    }

    private boolean AR() {
        if (com.baidu.swan.apps.ae.b.Md() == null || !com.baidu.swan.apps.ae.b.Md().Mp()) {
            return false;
        }
        e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Ar = vJ.Ar();
        if (Ar == null || !(Ar instanceof h)) {
            return true;
        }
        return ((h) Ar).AR();
    }

    private void GY() {
        setLooping(this.aBC.mLoop);
        setVolume(this.aBC.aBn);
        if (GV() > 0 || !this.aBC.aBm) {
            setVolume(this.aBC.aBn);
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
        GW().setVolume(f, f);
    }

    private void GZ() {
        if (!Ha() && !this.aBH) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aBI == null) {
                this.aBI = new a();
            }
            this.aBH = this.mAudioManager.requestAudioFocus(this.aBI, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zP() {
        if (this.aBH) {
            if (this.mAudioManager != null && this.aBI != null) {
                this.mAudioManager.abandonAudioFocus(this.aBI);
                this.mAudioManager = null;
                this.aBI = null;
            }
            this.aBH = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ha() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        boolean z = Md != null ? Md.Mn().getBoolean("key_audio_is_mix_with_other", false) : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.GW().getCurrentPosition() / 1000));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(SwanAppAudioPlayer.this.GW().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.aBE != null) {
                        SwanAppAudioPlayer.this.aBE.f("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.aBF = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.GW().isLooping()) {
                SwanAppAudioPlayer.this.aBG = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.aBF = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.aBE != null) {
                SwanAppAudioPlayer.this.aBE.fo("onEnded");
            }
            SwanAppAudioPlayer.this.aBD.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.aBE != null) {
                SwanAppAudioPlayer.this.aBE.f("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.aBE != null) {
                SwanAppAudioPlayer.this.aBE.fo("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.aBF == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.GW().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.GW().getCurrentPosition() && SwanAppAudioPlayer.this.aBE != null) {
                SwanAppAudioPlayer.this.aBE.fo("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.Ha()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.zP();
                                SwanAppAudioPlayer.this.GU();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.zP();
                                SwanAppAudioPlayer.this.GU();
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
