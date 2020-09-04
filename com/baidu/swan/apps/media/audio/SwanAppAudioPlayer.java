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
/* loaded from: classes8.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer bSC;
    private c cyM;
    private com.baidu.swan.apps.media.audio.b.a cyN;
    private a cyQ;
    private String cyo;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b cyL = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cyO = PlayerStatus.NONE;
    private UserStatus cyP = UserStatus.OPEN;
    private boolean cyR = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.cyo = "";
        this.cyo = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        Zm().start();
        if (this.cyM != null) {
            this.cyM.sendEmptyMessage(0);
        }
        if (this.cyN != null) {
            this.cyN.oj("onPlay");
        }
        asA();
        if (this.cyL.cys > 0) {
            seekTo(this.cyL.cys);
        }
        if (ahO()) {
            asx();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.cyP = UserStatus.PAUSE;
        asx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asx() {
        if (Zm().isPlaying()) {
            Zm().pause();
            if (this.cyN != null) {
                this.cyN.oj(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cyM != null) {
                this.cyM.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cyO == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Zm().seekTo((int) (i * 1000));
            if (this.cyN != null) {
                this.cyN.oj("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Zm().setLooping(z);
    }

    public void stop() {
        this.cyP = UserStatus.STOP;
        if (this.cyO == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Zm().stop();
            this.cyO = PlayerStatus.IDLE;
            if (this.cyM != null) {
                this.cyM.removeMessages(0);
            }
            if (this.cyN != null) {
                this.cyN.oj(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.cyP = UserStatus.DESTROY;
        abandonAudioFocus();
        Zm().release();
        this.cyO = PlayerStatus.NONE;
        this.bSC = null;
        if (this.cyM != null) {
            this.cyM.removeMessages(0);
            this.cyM = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Zm() {
        if (this.bSC == null) {
            this.bSC = new MediaPlayer();
            b bVar = new b();
            this.bSC.setOnPreparedListener(bVar);
            this.bSC.setOnCompletionListener(bVar);
            this.bSC.setOnInfoListener(bVar);
            this.bSC.setOnErrorListener(bVar);
            this.bSC.setOnSeekCompleteListener(bVar);
            this.bSC.setOnBufferingUpdateListener(bVar);
            this.cyM = new c();
        }
        return this.bSC;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cyo;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cyL.bTN;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e azI = e.azI();
        if (azI != null && azI.aAb()) {
            if (!z) {
                asx();
            } else if (this.cyP == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eJ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            asx();
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
        e azI = e.azI();
        if (azI != null && azI.aAb()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b asy() {
        return this.cyL;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.cyP = UserStatus.OPEN;
        this.cyL = bVar;
        if (this.cyL.cyu != null) {
            try {
                this.cyN = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cyL.cyu));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Zm().reset();
        setDataSource(this.cyL.mUrl);
        asz();
    }

    private void setDataSource(String str) {
        try {
            String rS = f.arY().arE().rS(str);
            if (!TextUtils.isEmpty(rS)) {
                HashMap hashMap = new HashMap();
                String aEV = ab.aEV();
                if (!TextUtils.isEmpty(aEV) && ab.sD(rS)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aEV);
                    }
                    hashMap.put("Referer", aEV);
                }
                String akq = com.baidu.swan.apps.core.turbo.d.ajS().akq();
                if (!TextUtils.isEmpty(akq)) {
                    hashMap.put("User-Agent", akq);
                }
                Zm().setDataSource(AppRuntime.getAppContext(), Uri.parse(rS), hashMap);
                this.cyO = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cyN != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.cyN.oj("onError");
            }
        }
    }

    private void asz() {
        if (this.cyR) {
            Zm().reset();
            setDataSource(this.cyL.mUrl);
            this.cyR = false;
        }
        Zm().prepareAsync();
        this.cyO = PlayerStatus.PREPARING;
    }

    public void play() {
        this.cyP = UserStatus.PLAY;
        if (!ahO()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.cyO == PlayerStatus.PREPARED) {
                Zm().start();
                if (this.cyM != null) {
                    this.cyM.sendEmptyMessage(0);
                }
                if (this.cyN != null) {
                    this.cyN.oj("onPlay");
                }
            } else if (this.cyO == PlayerStatus.IDLE) {
                Zm().prepareAsync();
                this.cyO = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cyL.mUrl;
        this.cyL = bVar;
        if (this.cyN != null) {
            this.cyN.oi(this.cyL.cyu);
        }
        asA();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.cyR = true;
            asz();
        }
    }

    private boolean ahO() {
        if (e.azI() == null || !e.azI().aAb()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f XX = f.arY().XX();
        if (XX == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c ahm = XX.ahm();
        if (ahm == null || !(ahm instanceof j)) {
            return true;
        }
        return ((j) ahm).ahO();
    }

    private void asA() {
        setLooping(this.cyL.mLoop);
        setVolume(this.cyL.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        Zm().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!ahQ() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cyQ == null) {
                this.cyQ = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cyQ, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cyQ != null) {
                this.mAudioManager.abandonAudioFocus(this.cyQ);
                this.mAudioManager = null;
                this.cyQ = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahQ() {
        e azI = e.azI();
        boolean booleanValue = azI != null ? azI.aAa().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Zm().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.Zm().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.cyN != null) {
                        SwanAppAudioPlayer.this.cyN.e("onTimeUpdate", jSONObject);
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
    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.cyO = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cyN != null) {
                SwanAppAudioPlayer.this.cyN.oj("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.cyP) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Zm().isLooping()) {
                SwanAppAudioPlayer.this.cyP = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cyO = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cyN != null) {
                SwanAppAudioPlayer.this.cyN.oj("onEnded");
            }
            SwanAppAudioPlayer.this.cyM.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.cyN != null) {
                SwanAppAudioPlayer.this.cyN.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cyN != null) {
                SwanAppAudioPlayer.this.cyN.oj("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cyO == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Zm().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Zm().getCurrentPosition() && SwanAppAudioPlayer.this.cyN != null) {
                SwanAppAudioPlayer.this.cyN.oj("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.ahQ()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.asx();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.asx();
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
