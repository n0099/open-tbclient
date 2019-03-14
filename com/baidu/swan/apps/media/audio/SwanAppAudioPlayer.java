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
    private MediaPlayer azS;
    private c azU;
    private com.baidu.swan.apps.media.audio.b.a azV;
    private boolean azY;
    private a azZ;
    private String azs;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b azT = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus azW = PlayerStatus.NONE;
    private UserStatus azX = UserStatus.OPEN;

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
        this.azs = "";
        this.azs = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Ev();
        Es().start();
        if (this.azU != null) {
            this.azU.sendEmptyMessage(0);
        }
        if (this.azV != null) {
            this.azV.eY("onPlay");
        }
        Eu();
        if (this.azT.azx > 0) {
            seekTo(this.azT.azx);
        }
        if (zl()) {
            Eq();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.azX = UserStatus.PAUSE;
        Eq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        if (Es().isPlaying()) {
            Es().pause();
            if (this.azV != null) {
                this.azV.eY("onPause");
            }
            if (this.azU != null) {
                this.azU.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.azW == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Es().seekTo((int) (i * 1000));
            if (this.azV != null) {
                this.azV.eY("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Es().setLooping(z);
    }

    public void stop() {
        this.azX = UserStatus.STOP;
        if (this.azW == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Es().stop();
            this.azW = PlayerStatus.IDLE;
            if (this.azU != null) {
                this.azU.removeMessages(0);
            }
            if (this.azV != null) {
                this.azV.eY("onStop");
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.azX = UserStatus.DESTROY;
        yp();
        Es().release();
        this.azW = PlayerStatus.NONE;
        this.azS = null;
        if (this.azU != null) {
            this.azU.removeMessages(0);
            this.azU = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    private int Er() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   getSystemVolume -> " + streamVolume);
        }
        return streamVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Es() {
        if (this.azS == null) {
            this.azS = new MediaPlayer();
            b bVar = new b();
            this.azS.setOnPreparedListener(bVar);
            this.azS.setOnCompletionListener(bVar);
            this.azS.setOnInfoListener(bVar);
            this.azS.setOnErrorListener(bVar);
            this.azS.setOnSeekCompleteListener(bVar);
            this.azS.setOnBufferingUpdateListener(bVar);
            this.azU = new c();
        }
        return this.azS;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ei() {
        return this.azs;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ej() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.azT.azt;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ek() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bk(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.Jj()) {
            if (!z) {
                Eq();
            } else if (this.azX == UserStatus.PLAY) {
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
            Eq();
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
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.Jj()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Et() {
        return this.azT;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.azX = UserStatus.OPEN;
        this.azT = bVar;
        if (this.azT.azz != null) {
            try {
                this.azV = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.azT.azz));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Es().reset();
        try {
            String str = this.azT.mUrl;
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            if (IX != null) {
                if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                    str = g.iF(str);
                } else {
                    str = com.baidu.swan.apps.storage.b.b(str, IX);
                }
            }
            Es().setDataSource(str);
            this.azW = PlayerStatus.IDLE;
            if (this.azV != null) {
                this.azV.eY("onCanplay");
            }
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.azV != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errorCode", "10002");
                } else {
                    jSONObject.optString("errorCode", "10003");
                }
                this.azV.eY("onError");
            }
        }
    }

    public void play() {
        this.azX = UserStatus.PLAY;
        if (!zl()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Ev();
            if (this.azW == PlayerStatus.PREPARED) {
                Es().start();
                if (this.azU != null) {
                    this.azU.sendEmptyMessage(0);
                }
                if (this.azV != null) {
                    this.azV.eY("onPlay");
                }
            } else if (this.azW == PlayerStatus.IDLE) {
                Es().prepareAsync();
                this.azW = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        this.azT = bVar;
        if (this.azV != null) {
            this.azV.eX(this.azT.azz);
        }
        Eu();
    }

    private boolean zl() {
        if (com.baidu.swan.apps.ae.b.IX() == null || !com.baidu.swan.apps.ae.b.IX().Jj()) {
            return false;
        }
        e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            return true;
        }
        com.baidu.swan.apps.core.c.b yO = uz.yO();
        if (yO == null || !(yO instanceof h)) {
            return true;
        }
        return ((h) yO).zl();
    }

    private void Eu() {
        setLooping(this.azT.mLoop);
        setVolume(this.azT.azE);
        if (Er() > 0 || !this.azT.azD) {
            setVolume(this.azT.azE);
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
        Es().setVolume(f, f);
    }

    private void Ev() {
        if (!Ew() && !this.azY) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.azZ == null) {
                this.azZ = new a();
            }
            this.azY = this.mAudioManager.requestAudioFocus(this.azZ, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp() {
        if (this.azY) {
            if (this.mAudioManager != null && this.azZ != null) {
                this.mAudioManager.abandonAudioFocus(this.azZ);
                this.mAudioManager = null;
                this.azZ = null;
            }
            this.azY = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ew() {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        boolean z = IX != null ? IX.Jh().getBoolean("key_audio_is_mix_with_other", false) : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Es().getCurrentPosition() / 1000));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(SwanAppAudioPlayer.this.Es().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.azV != null) {
                        SwanAppAudioPlayer.this.azV.f("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.azW = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Es().isLooping()) {
                SwanAppAudioPlayer.this.azX = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.azW = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.azV != null) {
                SwanAppAudioPlayer.this.azV.eY("onEnded");
            }
            SwanAppAudioPlayer.this.azU.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.azV != null) {
                SwanAppAudioPlayer.this.azV.f("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.azV != null) {
                SwanAppAudioPlayer.this.azV.eY("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.azW == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Es().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Es().getCurrentPosition() && SwanAppAudioPlayer.this.azV != null) {
                SwanAppAudioPlayer.this.azV.eY("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.Ew()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.yp();
                                SwanAppAudioPlayer.this.Eq();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.yp();
                                SwanAppAudioPlayer.this.Eq();
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
