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
    private MediaPlayer bSy;
    private c cyI;
    private com.baidu.swan.apps.media.audio.b.a cyJ;
    private a cyM;
    private String cyk;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b cyH = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cyK = PlayerStatus.NONE;
    private UserStatus cyL = UserStatus.OPEN;
    private boolean cyN = false;

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
        this.cyk = "";
        this.cyk = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        Zm().start();
        if (this.cyI != null) {
            this.cyI.sendEmptyMessage(0);
        }
        if (this.cyJ != null) {
            this.cyJ.oi("onPlay");
        }
        asA();
        if (this.cyH.cyo > 0) {
            seekTo(this.cyH.cyo);
        }
        if (ahO()) {
            asx();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.cyL = UserStatus.PAUSE;
        asx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asx() {
        if (Zm().isPlaying()) {
            Zm().pause();
            if (this.cyJ != null) {
                this.cyJ.oi(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cyI != null) {
                this.cyI.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cyK == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Zm().seekTo((int) (i * 1000));
            if (this.cyJ != null) {
                this.cyJ.oi("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Zm().setLooping(z);
    }

    public void stop() {
        this.cyL = UserStatus.STOP;
        if (this.cyK == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Zm().stop();
            this.cyK = PlayerStatus.IDLE;
            if (this.cyI != null) {
                this.cyI.removeMessages(0);
            }
            if (this.cyJ != null) {
                this.cyJ.oi(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.cyL = UserStatus.DESTROY;
        abandonAudioFocus();
        Zm().release();
        this.cyK = PlayerStatus.NONE;
        this.bSy = null;
        if (this.cyI != null) {
            this.cyI.removeMessages(0);
            this.cyI = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Zm() {
        if (this.bSy == null) {
            this.bSy = new MediaPlayer();
            b bVar = new b();
            this.bSy.setOnPreparedListener(bVar);
            this.bSy.setOnCompletionListener(bVar);
            this.bSy.setOnInfoListener(bVar);
            this.bSy.setOnErrorListener(bVar);
            this.bSy.setOnSeekCompleteListener(bVar);
            this.bSy.setOnBufferingUpdateListener(bVar);
            this.cyI = new c();
        }
        return this.bSy;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cyk;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cyH.bTJ;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e azI = e.azI();
        if (azI != null && azI.aAb()) {
            if (!z) {
                asx();
            } else if (this.cyL == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
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
        return this.cyH;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.cyL = UserStatus.OPEN;
        this.cyH = bVar;
        if (this.cyH.cyq != null) {
            try {
                this.cyJ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cyH.cyq));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Zm().reset();
        setDataSource(this.cyH.mUrl);
        asz();
    }

    private void setDataSource(String str) {
        try {
            String rR = f.arY().arE().rR(str);
            if (!TextUtils.isEmpty(rR)) {
                HashMap hashMap = new HashMap();
                String aEV = ab.aEV();
                if (!TextUtils.isEmpty(aEV) && ab.sC(rR)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aEV);
                    }
                    hashMap.put("Referer", aEV);
                }
                String akq = com.baidu.swan.apps.core.turbo.d.ajS().akq();
                if (!TextUtils.isEmpty(akq)) {
                    hashMap.put("User-Agent", akq);
                }
                Zm().setDataSource(AppRuntime.getAppContext(), Uri.parse(rR), hashMap);
                this.cyK = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cyJ != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.cyJ.oi("onError");
            }
        }
    }

    private void asz() {
        if (this.cyN) {
            Zm().reset();
            setDataSource(this.cyH.mUrl);
            this.cyN = false;
        }
        Zm().prepareAsync();
        this.cyK = PlayerStatus.PREPARING;
    }

    public void play() {
        this.cyL = UserStatus.PLAY;
        if (!ahO()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.cyK == PlayerStatus.PREPARED) {
                Zm().start();
                if (this.cyI != null) {
                    this.cyI.sendEmptyMessage(0);
                }
                if (this.cyJ != null) {
                    this.cyJ.oi("onPlay");
                }
            } else if (this.cyK == PlayerStatus.IDLE) {
                Zm().prepareAsync();
                this.cyK = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cyH.mUrl;
        this.cyH = bVar;
        if (this.cyJ != null) {
            this.cyJ.oh(this.cyH.cyq);
        }
        asA();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.cyN = true;
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
        setLooping(this.cyH.mLoop);
        setVolume(this.cyH.mVolume);
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
            if (this.cyM == null) {
                this.cyM = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cyM, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cyM != null) {
                this.mAudioManager.abandonAudioFocus(this.cyM);
                this.mAudioManager = null;
                this.cyM = null;
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
                    if (SwanAppAudioPlayer.this.cyJ != null) {
                        SwanAppAudioPlayer.this.cyJ.e("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.cyK = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cyJ != null) {
                SwanAppAudioPlayer.this.cyJ.oi("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.cyL) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Zm().isLooping()) {
                SwanAppAudioPlayer.this.cyL = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cyK = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cyJ != null) {
                SwanAppAudioPlayer.this.cyJ.oi("onEnded");
            }
            SwanAppAudioPlayer.this.cyI.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.cyJ != null) {
                SwanAppAudioPlayer.this.cyJ.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cyJ != null) {
                SwanAppAudioPlayer.this.cyJ.oi("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cyK == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Zm().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Zm().getCurrentPosition() && SwanAppAudioPlayer.this.cyJ != null) {
                SwanAppAudioPlayer.this.cyJ.oi("onWaiting");
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
