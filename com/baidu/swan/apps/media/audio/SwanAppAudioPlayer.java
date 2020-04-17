package com.baidu.swan.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.h.l;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bYS;
    private c bZp;
    private com.baidu.swan.apps.media.audio.b.a bZq;
    private a bZt;
    private MediaPlayer bzL;
    private boolean bzO;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bZo = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bZr = PlayerStatus.NONE;
    private UserStatus bZs = UserStatus.OPEN;
    private boolean bZu = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.bYS = "";
        this.bYS = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Eb();
        Pt().start();
        if (this.bZp != null) {
            this.bZp.sendEmptyMessage(0);
        }
        if (this.bZq != null) {
            this.bZq.ko("onPlay");
        }
        afc();
        if (this.bZo.bYV > 0) {
            seekTo(this.bZo.bYV);
        }
        if (WJ()) {
            afa();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bZs = UserStatus.PAUSE;
        afa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afa() {
        if (Pt().isPlaying()) {
            Pt().pause();
            if (this.bZq != null) {
                this.bZq.ko(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bZp != null) {
                this.bZp.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bZr == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Pt().seekTo((int) (i * 1000));
            if (this.bZq != null) {
                this.bZq.ko("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Pt().setLooping(z);
    }

    public void stop() {
        this.bZs = UserStatus.STOP;
        if (this.bZr == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Pt().stop();
            this.bZr = PlayerStatus.IDLE;
            if (this.bZp != null) {
                this.bZp.removeMessages(0);
            }
            if (this.bZq != null) {
                this.bZq.ko(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bZs = UserStatus.DESTROY;
        Ec();
        Pt().release();
        this.bZr = PlayerStatus.NONE;
        this.bzL = null;
        if (this.bZp != null) {
            this.bZp.removeMessages(0);
            this.bZp = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Pt() {
        if (this.bzL == null) {
            this.bzL = new MediaPlayer();
            b bVar = new b();
            this.bzL.setOnPreparedListener(bVar);
            this.bzL.setOnCompletionListener(bVar);
            this.bzL.setOnInfoListener(bVar);
            this.bzL.setOnErrorListener(bVar);
            this.bzL.setOnSeekCompleteListener(bVar);
            this.bzL.setOnBufferingUpdateListener(bVar);
            this.bZp = new c();
        }
        return this.bzL;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return this.bYS;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeU() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bZo.bAK;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeV() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e akN = e.akN();
        if (akN != null && akN.ale()) {
            if (!z) {
                afa();
            } else if (this.bZs == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            afa();
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
        e akN = e.akN();
        if (akN != null && akN.ale()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b afb() {
        return this.bZo;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bZs = UserStatus.OPEN;
        this.bZo = bVar;
        if (this.bZo.bYX != null) {
            try {
                this.bZq = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bZo.bYX));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Pt().reset();
        b(callbackHandler, this.bZo.mUrl);
    }

    private void b(CallbackHandler callbackHandler, String str) {
        String str2;
        try {
            e akN = e.akN();
            if (akN == null) {
                str2 = str;
            } else if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                str2 = l.ns(str);
            } else {
                str2 = com.baidu.swan.apps.storage.b.d(str, akN);
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String apd = y.apd();
                if (!TextUtils.isEmpty(apd) && y.nZ(str2)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + apd);
                    }
                    hashMap.put("Referer", apd);
                }
                String YL = com.baidu.swan.apps.core.k.d.Yo().YL();
                if (!TextUtils.isEmpty(YL)) {
                    hashMap.put("User-Agent", YL);
                }
                Pt().setDataSource(AppRuntime.getAppContext(), Uri.parse(str2), hashMap);
                this.bZr = PlayerStatus.IDLE;
                if (this.bZq != null) {
                    this.bZq.ko("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bZq != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bZq.ko("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bZu) {
            Pt().reset();
            b(callbackHandler, this.bZo.mUrl);
            this.bZu = false;
        }
        play();
    }

    public void play() {
        this.bZs = UserStatus.PLAY;
        if (!WJ()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Eb();
            if (this.bZr == PlayerStatus.PREPARED) {
                Pt().start();
                if (this.bZp != null) {
                    this.bZp.sendEmptyMessage(0);
                }
                if (this.bZq != null) {
                    this.bZq.ko("onPlay");
                }
            } else if (this.bZr == PlayerStatus.IDLE) {
                Pt().prepareAsync();
                this.bZr = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bZo.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bZu = true;
        }
        this.bZo = bVar;
        if (this.bZq != null) {
            this.bZq.kn(this.bZo.bYX);
        }
        afc();
    }

    private boolean WJ() {
        if (e.akN() == null || !e.akN().ale()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e Ou = f.aeK().Ou();
        if (Ou == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b We = Ou.We();
        if (We == null || !(We instanceof i)) {
            return true;
        }
        return ((i) We).WJ();
    }

    private void afc() {
        setLooping(this.bZo.mLoop);
        setVolume(this.bZo.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        Pt().setVolume(f, f);
    }

    private void Eb() {
        if (!WL() && !this.bzO) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bZt == null) {
                this.bZt = new a();
            }
            this.bzO = this.mAudioManager.requestAudioFocus(this.bZt, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ec() {
        if (this.bzO) {
            if (this.mAudioManager != null && this.bZt != null) {
                this.mAudioManager.abandonAudioFocus(this.bZt);
                this.mAudioManager = null;
                this.bZt = null;
            }
            this.bzO = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WL() {
        e akN = e.akN();
        boolean booleanValue = akN != null ? akN.ald().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Pt().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.Pt().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.bZq != null) {
                        SwanAppAudioPlayer.this.bZq.e("onTimeUpdate", jSONObject);
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
    /* loaded from: classes11.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.bZr = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Pt().isLooping()) {
                SwanAppAudioPlayer.this.bZs = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bZr = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bZq != null) {
                SwanAppAudioPlayer.this.bZq.ko("onEnded");
            }
            SwanAppAudioPlayer.this.bZp.removeMessages(0);
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
                    str = "-1";
                    break;
                case 100:
                    str = "10001";
                    break;
                default:
                    str = "-1";
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
            if (SwanAppAudioPlayer.this.bZq != null) {
                SwanAppAudioPlayer.this.bZq.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bZq != null) {
                SwanAppAudioPlayer.this.bZq.ko("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bZr == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Pt().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Pt().getCurrentPosition() && SwanAppAudioPlayer.this.bZq != null) {
                SwanAppAudioPlayer.this.bZq.ko("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.WL()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.Ec();
                                SwanAppAudioPlayer.this.afa();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.Ec();
                                SwanAppAudioPlayer.this.afa();
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
