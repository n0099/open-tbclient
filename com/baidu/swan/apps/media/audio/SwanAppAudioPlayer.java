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
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.ao.ak;
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
    private MediaPlayer cEx;
    private String djT;
    private c dks;
    private com.baidu.swan.apps.media.audio.b.a dkt;
    private a dkw;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b dkr = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus dku = PlayerStatus.NONE;
    private UserStatus dkv = UserStatus.OPEN;
    private boolean dkx = false;

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
        this.djT = "";
        this.djT = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        ahr().start();
        if (this.dks != null) {
            this.dks.sendEmptyMessage(0);
        }
        if (this.dkt != null) {
            this.dkt.pE("onPlay");
        }
        aAP();
        if (this.dkr.djX > 0) {
            seekTo(this.dkr.djX);
        }
        if (aqc()) {
            aAM();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.dkv = UserStatus.PAUSE;
        aAM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAM() {
        if (ahr().isPlaying()) {
            ahr().pause();
            if (this.dkt != null) {
                this.dkt.pE(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.dks != null) {
                this.dks.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.dku == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            ahr().seekTo((int) (i * 1000));
            if (this.dkt != null) {
                this.dkt.pE("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        ahr().setLooping(z);
    }

    public void stop() {
        this.dkv = UserStatus.STOP;
        if (this.dku == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            ahr().stop();
            this.dku = PlayerStatus.IDLE;
            if (this.dks != null) {
                this.dks.removeMessages(0);
            }
            if (this.dkt != null) {
                this.dkt.pE(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.dkv = UserStatus.DESTROY;
        abandonAudioFocus();
        ahr().release();
        this.dku = PlayerStatus.NONE;
        this.cEx = null;
        if (this.dks != null) {
            this.dks.removeMessages(0);
            this.dks = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ahr() {
        if (this.cEx == null) {
            this.cEx = new MediaPlayer();
            b bVar = new b();
            this.cEx.setOnPreparedListener(bVar);
            this.cEx.setOnCompletionListener(bVar);
            this.cEx.setOnInfoListener(bVar);
            this.cEx.setOnErrorListener(bVar);
            this.cEx.setOnSeekCompleteListener(bVar);
            this.cEx.setOnBufferingUpdateListener(bVar);
            this.dks = new c();
        }
        return this.cEx;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awF() {
        return this.djT;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAH() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dkr.cFI;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAI() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fX(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aIN = e.aIN();
        if (aIN != null && aIN.aJg()) {
            if (!z) {
                aAM();
            } else if (this.dkv == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fY(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            aAM();
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
        e aIN = e.aIN();
        if (aIN != null && aIN.aJg()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aAN() {
        return this.dkr;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.dkv = UserStatus.OPEN;
        this.dkr = bVar;
        if (this.dkr.djZ != null) {
            try {
                this.dkt = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dkr.djZ));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        ahr().reset();
        setDataSource(this.dkr.mUrl);
        aAO();
    }

    private void setDataSource(String str) {
        try {
            String tt = f.aAo().azU().tt(str);
            if (!TextUtils.isEmpty(tt)) {
                HashMap hashMap = new HashMap();
                String aOb = ab.aOb();
                if (!TextUtils.isEmpty(aOb) && ab.uf(tt)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aOb);
                    }
                    hashMap.put("Referer", aOb);
                }
                String asG = com.baidu.swan.apps.core.turbo.d.ash().asG();
                if (!TextUtils.isEmpty(asG)) {
                    hashMap.put("User-Agent", asG);
                }
                ahr().setDataSource(AppRuntime.getAppContext(), Uri.parse(tt), hashMap);
                this.dku = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.dkt != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.dkt.pE("onError");
            }
        }
    }

    private void aAO() {
        if (this.dkx) {
            ahr().reset();
            setDataSource(this.dkr.mUrl);
            this.dkx = false;
        }
        ahr().prepareAsync();
        this.dku = PlayerStatus.PREPARING;
    }

    public void play() {
        this.dkv = UserStatus.PLAY;
        if (!aqc()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.dku == PlayerStatus.PREPARED) {
                ahr().start();
                if (this.dks != null) {
                    this.dks.sendEmptyMessage(0);
                }
                if (this.dkt != null) {
                    this.dkt.pE("onPlay");
                }
            } else if (this.dku == PlayerStatus.IDLE) {
                ahr().prepareAsync();
                this.dku = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.dkr.mUrl;
        this.dkr = bVar;
        if (this.dkt != null) {
            this.dkt.pD(this.dkr.djZ);
        }
        aAP();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.dkx = true;
            aAO();
        }
    }

    private boolean aqc() {
        if (e.aIN() == null || !e.aIN().aJg()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f aga = f.aAo().aga();
        if (aga == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c apA = aga.apA();
        if (apA == null || !(apA instanceof j)) {
            return true;
        }
        return ((j) apA).aqc();
    }

    private void aAP() {
        setLooping(this.dkr.mLoop);
        setVolume(this.dkr.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        ahr().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!aqe() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dkw == null) {
                this.dkw = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.dkw, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.dkw != null) {
                this.mAudioManager.abandonAudioFocus(this.dkw);
                this.mAudioManager = null;
                this.dkw = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqe() {
        e aIN = e.aIN();
        boolean booleanValue = aIN != null ? aIN.aJf().c("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.ahr().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.ahr().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.dkt != null) {
                        SwanAppAudioPlayer.this.dkt.i("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.dku = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dkt != null) {
                SwanAppAudioPlayer.this.dkt.pE("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.dkv) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.ahr().isLooping()) {
                SwanAppAudioPlayer.this.dkv = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.dku = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dkt != null) {
                SwanAppAudioPlayer.this.dkt.pE("onEnded");
            }
            SwanAppAudioPlayer.this.dks.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.dkt != null) {
                SwanAppAudioPlayer.this.dkt.i("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.dkt != null) {
                SwanAppAudioPlayer.this.dkt.pE("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.dku == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.ahr().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.ahr().getCurrentPosition() && SwanAppAudioPlayer.this.dkt != null) {
                SwanAppAudioPlayer.this.dkt.pE("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.aqe()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAM();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAM();
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
