package com.baidu.swan.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.f;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer bUC;
    private c cAN;
    private com.baidu.swan.apps.media.audio.b.a cAO;
    private a cAR;
    private String cAp;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b cAM = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cAP = PlayerStatus.NONE;
    private UserStatus cAQ = UserStatus.OPEN;
    private boolean cAS = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.cAp = "";
        this.cAp = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        ZV().start();
        if (this.cAN != null) {
            this.cAN.sendEmptyMessage(0);
        }
        if (this.cAO != null) {
            this.cAO.oD("onPlay");
        }
        atk();
        if (this.cAM.cAt > 0) {
            seekTo(this.cAM.cAt);
        }
        if (aiy()) {
            ath();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.cAQ = UserStatus.PAUSE;
        ath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ath() {
        if (ZV().isPlaying()) {
            ZV().pause();
            if (this.cAO != null) {
                this.cAO.oD(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cAN != null) {
                this.cAN.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cAP == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            ZV().seekTo((int) (i * 1000));
            if (this.cAO != null) {
                this.cAO.oD("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        ZV().setLooping(z);
    }

    public void stop() {
        this.cAQ = UserStatus.STOP;
        if (this.cAP == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            ZV().stop();
            this.cAP = PlayerStatus.IDLE;
            if (this.cAN != null) {
                this.cAN.removeMessages(0);
            }
            if (this.cAO != null) {
                this.cAO.oD(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.cAQ = UserStatus.DESTROY;
        abandonAudioFocus();
        ZV().release();
        this.cAP = PlayerStatus.NONE;
        this.bUC = null;
        if (this.cAN != null) {
            this.cAN.removeMessages(0);
            this.cAN = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ZV() {
        if (this.bUC == null) {
            this.bUC = new MediaPlayer();
            b bVar = new b();
            this.bUC.setOnPreparedListener(bVar);
            this.bUC.setOnCompletionListener(bVar);
            this.bUC.setOnInfoListener(bVar);
            this.bUC.setOnErrorListener(bVar);
            this.bUC.setOnSeekCompleteListener(bVar);
            this.bUC.setOnBufferingUpdateListener(bVar);
            this.cAN = new c();
        }
        return this.bUC;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aoZ() {
        return this.cAp;
    }

    @Override // com.baidu.swan.apps.media.a
    public String atc() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cAM.bVN;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object atd() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eG(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aAr = e.aAr();
        if (aAr != null && aAr.aAK()) {
            if (!z) {
                ath();
            } else if (this.cAQ == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            ath();
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
        e aAr = e.aAr();
        if (aAr != null && aAr.aAK()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b ati() {
        return this.cAM;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.cAQ = UserStatus.OPEN;
        this.cAM = bVar;
        if (this.cAM.cAv != null) {
            try {
                this.cAO = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cAM.cAv));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        ZV().reset();
        setDataSource(this.cAM.mUrl);
        atj();
    }

    private void setDataSource(String str) {
        try {
            String sl = f.asJ().asp().sl(str);
            if (!TextUtils.isEmpty(sl)) {
                HashMap hashMap = new HashMap();
                String aFF = ab.aFF();
                if (!TextUtils.isEmpty(aFF) && ab.sW(sl)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aFF);
                    }
                    hashMap.put("Referer", aFF);
                }
                String ala = com.baidu.swan.apps.core.turbo.d.akC().ala();
                if (!TextUtils.isEmpty(ala)) {
                    hashMap.put("User-Agent", ala);
                }
                ZV().setDataSource(AppRuntime.getAppContext(), Uri.parse(sl), hashMap);
                this.cAP = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cAO != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.cAO.oD("onError");
            }
        }
    }

    private void atj() {
        if (this.cAS) {
            ZV().reset();
            setDataSource(this.cAM.mUrl);
            this.cAS = false;
        }
        ZV().prepareAsync();
        this.cAP = PlayerStatus.PREPARING;
    }

    public void play() {
        this.cAQ = UserStatus.PLAY;
        if (!aiy()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.cAP == PlayerStatus.PREPARED) {
                ZV().start();
                if (this.cAN != null) {
                    this.cAN.sendEmptyMessage(0);
                }
                if (this.cAO != null) {
                    this.cAO.oD("onPlay");
                }
            } else if (this.cAP == PlayerStatus.IDLE) {
                ZV().prepareAsync();
                this.cAP = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cAM.mUrl;
        this.cAM = bVar;
        if (this.cAO != null) {
            this.cAO.oC(this.cAM.cAv);
        }
        atk();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.cAS = true;
            atj();
        }
    }

    private boolean aiy() {
        if (e.aAr() == null || !e.aAr().aAK()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f YG = f.asJ().YG();
        if (YG == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c ahW = YG.ahW();
        if (ahW == null || !(ahW instanceof j)) {
            return true;
        }
        return ((j) ahW).aiy();
    }

    private void atk() {
        setLooping(this.cAM.mLoop);
        setVolume(this.cAM.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        ZV().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!aiA() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cAR == null) {
                this.cAR = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cAR, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cAR != null) {
                this.mAudioManager.abandonAudioFocus(this.cAR);
                this.mAudioManager = null;
                this.cAR = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiA() {
        e aAr = e.aAr();
        boolean booleanValue = aAr != null ? aAr.aAJ().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.ZV().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.ZV().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.cAO != null) {
                        SwanAppAudioPlayer.this.cAO.e("onTimeUpdate", jSONObject);
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
    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.cAP = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cAO != null) {
                SwanAppAudioPlayer.this.cAO.oD("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.cAQ) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.ZV().isLooping()) {
                SwanAppAudioPlayer.this.cAQ = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cAP = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cAO != null) {
                SwanAppAudioPlayer.this.cAO.oD("onEnded");
            }
            SwanAppAudioPlayer.this.cAN.removeMessages(0);
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
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (SwanAppAudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            if (SwanAppAudioPlayer.this.cAO != null) {
                SwanAppAudioPlayer.this.cAO.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cAO != null) {
                SwanAppAudioPlayer.this.cAO.oD("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cAP == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.ZV().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.ZV().getCurrentPosition() && SwanAppAudioPlayer.this.cAO != null) {
                SwanAppAudioPlayer.this.cAO.oD("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.aiA()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.ath();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.ath();
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
