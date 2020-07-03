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
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.w.f;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer bMj;
    private boolean bMm;
    private c coN;
    private com.baidu.swan.apps.media.audio.b.a coO;
    private a coR;
    private String cop;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b coM = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus coP = PlayerStatus.NONE;
    private UserStatus coQ = UserStatus.OPEN;
    private boolean coS = false;

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
        this.cop = "";
        this.cop = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Gz();
        SR().start();
        if (this.coN != null) {
            this.coN.sendEmptyMessage(0);
        }
        if (this.coO != null) {
            this.coO.lJ("onPlay");
        }
        ajw();
        if (this.coM.cot > 0) {
            seekTo(this.coM.cot);
        }
        if (aaA()) {
            ajt();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.coQ = UserStatus.PAUSE;
        ajt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajt() {
        if (SR().isPlaying()) {
            SR().pause();
            if (this.coO != null) {
                this.coO.lJ(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.coN != null) {
                this.coN.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.coP == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            SR().seekTo((int) (i * 1000));
            if (this.coO != null) {
                this.coO.lJ("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        SR().setLooping(z);
    }

    public void stop() {
        this.coQ = UserStatus.STOP;
        if (this.coP == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            SR().stop();
            this.coP = PlayerStatus.IDLE;
            if (this.coN != null) {
                this.coN.removeMessages(0);
            }
            if (this.coO != null) {
                this.coO.lJ(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.coQ = UserStatus.DESTROY;
        GA();
        SR().release();
        this.coP = PlayerStatus.NONE;
        this.bMj = null;
        if (this.coN != null) {
            this.coN.removeMessages(0);
            this.coN = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer SR() {
        if (this.bMj == null) {
            this.bMj = new MediaPlayer();
            b bVar = new b();
            this.bMj.setOnPreparedListener(bVar);
            this.bMj.setOnCompletionListener(bVar);
            this.bMj.setOnInfoListener(bVar);
            this.bMj.setOnErrorListener(bVar);
            this.bMj.setOnSeekCompleteListener(bVar);
            this.bMj.setOnBufferingUpdateListener(bVar);
            this.coN = new c();
        }
        return this.bMj;
    }

    @Override // com.baidu.swan.apps.media.a
    public String afE() {
        return this.cop;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ajn() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.coM.bNv;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ajo() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ej(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e apM = e.apM();
        if (apM != null && apM.aqf()) {
            if (!z) {
                ajt();
            } else if (this.coQ == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ek(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            ajt();
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
        e apM = e.apM();
        if (apM != null && apM.aqf()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aju() {
        return this.coM;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.coQ = UserStatus.OPEN;
        this.coM = bVar;
        if (this.coM.cov != null) {
            try {
                this.coO = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.coM.cov));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        SR().reset();
        setDataSource(this.coM.mUrl);
        ajv();
    }

    private void setDataSource(String str) {
        try {
            String pg = f.ajb().aiH().pg(str);
            if (!TextUtils.isEmpty(pg)) {
                HashMap hashMap = new HashMap();
                String auJ = z.auJ();
                if (!TextUtils.isEmpty(auJ) && z.pQ(pg)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + auJ);
                    }
                    hashMap.put("Referer", auJ);
                }
                String acP = com.baidu.swan.apps.core.turbo.d.acr().acP();
                if (!TextUtils.isEmpty(acP)) {
                    hashMap.put("User-Agent", acP);
                }
                SR().setDataSource(AppRuntime.getAppContext(), Uri.parse(pg), hashMap);
                this.coP = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.coO != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.coO.lJ("onError");
            }
        }
    }

    private void ajv() {
        if (this.coS) {
            SR().reset();
            setDataSource(this.coM.mUrl);
            this.coS = false;
        }
        SR().prepareAsync();
        this.coP = PlayerStatus.PREPARING;
    }

    public void play() {
        this.coQ = UserStatus.PLAY;
        if (!aaA()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Gz();
            if (this.coP == PlayerStatus.PREPARED) {
                SR().start();
                if (this.coN != null) {
                    this.coN.sendEmptyMessage(0);
                }
                if (this.coO != null) {
                    this.coO.lJ("onPlay");
                }
            } else if (this.coP == PlayerStatus.IDLE) {
                SR().prepareAsync();
                this.coP = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.coM.mUrl;
        this.coM = bVar;
        if (this.coO != null) {
            this.coO.lI(this.coM.cov);
        }
        ajw();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.coS = true;
            ajv();
        }
    }

    private boolean aaA() {
        if (e.apM() == null || !e.apM().aqf()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e RN = f.ajb().RN();
        if (RN == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b ZV = RN.ZV();
        if (ZV == null || !(ZV instanceof i)) {
            return true;
        }
        return ((i) ZV).aaA();
    }

    private void ajw() {
        setLooping(this.coM.mLoop);
        setVolume(this.coM.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        SR().setVolume(f, f);
    }

    private void Gz() {
        if (!aaC() && !this.bMm) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.coR == null) {
                this.coR = new a();
            }
            this.bMm = this.mAudioManager.requestAudioFocus(this.coR, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GA() {
        if (this.bMm) {
            if (this.mAudioManager != null && this.coR != null) {
                this.mAudioManager.abandonAudioFocus(this.coR);
                this.mAudioManager = null;
                this.coR = null;
            }
            this.bMm = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaC() {
        e apM = e.apM();
        boolean booleanValue = apM != null ? apM.aqe().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.SR().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.SR().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.coO != null) {
                        SwanAppAudioPlayer.this.coO.e("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.coP = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.coO != null) {
                SwanAppAudioPlayer.this.coO.lJ("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.coQ) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.SR().isLooping()) {
                SwanAppAudioPlayer.this.coQ = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.coP = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.coO != null) {
                SwanAppAudioPlayer.this.coO.lJ("onEnded");
            }
            SwanAppAudioPlayer.this.coN.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.coO != null) {
                SwanAppAudioPlayer.this.coO.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.coO != null) {
                SwanAppAudioPlayer.this.coO.lJ("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.coP == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.SR().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.SR().getCurrentPosition() && SwanAppAudioPlayer.this.coO != null) {
                SwanAppAudioPlayer.this.coO.lJ("onWaiting");
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
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.aaC()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.GA();
                                SwanAppAudioPlayer.this.ajt();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.GA();
                                SwanAppAudioPlayer.this.ajt();
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
