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
/* loaded from: classes9.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer cCX;
    private c diR;
    private com.baidu.swan.apps.media.audio.b.a diS;
    private a diV;
    private String diq;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b diQ = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus diT = PlayerStatus.NONE;
    private UserStatus diU = UserStatus.OPEN;
    private boolean diW = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.diq = "";
        this.diq = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        aho().start();
        if (this.diR != null) {
            this.diR.sendEmptyMessage(0);
        }
        if (this.diS != null) {
            this.diS.px("onPlay");
        }
        aAM();
        if (this.diQ.diw > 0) {
            seekTo(this.diQ.diw);
        }
        if (apZ()) {
            aAJ();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.diU = UserStatus.PAUSE;
        aAJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAJ() {
        if (aho().isPlaying()) {
            aho().pause();
            if (this.diS != null) {
                this.diS.px(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.diR != null) {
                this.diR.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.diT == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            aho().seekTo((int) (i * 1000));
            if (this.diS != null) {
                this.diS.px("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        aho().setLooping(z);
    }

    public void stop() {
        this.diU = UserStatus.STOP;
        if (this.diT == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            aho().stop();
            this.diT = PlayerStatus.IDLE;
            if (this.diR != null) {
                this.diR.removeMessages(0);
            }
            if (this.diS != null) {
                this.diS.px(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.diU = UserStatus.DESTROY;
        abandonAudioFocus();
        aho().release();
        this.diT = PlayerStatus.NONE;
        this.cCX = null;
        if (this.diR != null) {
            this.diR.removeMessages(0);
            this.diR = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer aho() {
        if (this.cCX == null) {
            this.cCX = new MediaPlayer();
            b bVar = new b();
            this.cCX.setOnPreparedListener(bVar);
            this.cCX.setOnCompletionListener(bVar);
            this.cCX.setOnInfoListener(bVar);
            this.cCX.setOnErrorListener(bVar);
            this.cCX.setOnSeekCompleteListener(bVar);
            this.cCX.setOnBufferingUpdateListener(bVar);
            this.diR = new c();
        }
        return this.cCX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awC() {
        return this.diq;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAE() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.diQ.cEi;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAF() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fX(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aIK = e.aIK();
        if (aIK != null && aIK.aJd()) {
            if (!z) {
                aAJ();
            } else if (this.diU == UserStatus.PLAY) {
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
            aAJ();
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
        e aIK = e.aIK();
        if (aIK != null && aIK.aJd()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aAK() {
        return this.diQ;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.diU = UserStatus.OPEN;
        this.diQ = bVar;
        if (this.diQ.diy != null) {
            try {
                this.diS = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.diQ.diy));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        aho().reset();
        setDataSource(this.diQ.mUrl);
        aAL();
    }

    private void setDataSource(String str) {
        try {
            String tm = f.aAl().azR().tm(str);
            if (!TextUtils.isEmpty(tm)) {
                HashMap hashMap = new HashMap();
                String aNY = ab.aNY();
                if (!TextUtils.isEmpty(aNY) && ab.tY(tm)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aNY);
                    }
                    hashMap.put("Referer", aNY);
                }
                String asD = com.baidu.swan.apps.core.turbo.d.ase().asD();
                if (!TextUtils.isEmpty(asD)) {
                    hashMap.put("User-Agent", asD);
                }
                aho().setDataSource(AppRuntime.getAppContext(), Uri.parse(tm), hashMap);
                this.diT = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.diS != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.diS.px("onError");
            }
        }
    }

    private void aAL() {
        if (this.diW) {
            aho().reset();
            setDataSource(this.diQ.mUrl);
            this.diW = false;
        }
        aho().prepareAsync();
        this.diT = PlayerStatus.PREPARING;
    }

    public void play() {
        this.diU = UserStatus.PLAY;
        if (!apZ()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.diT == PlayerStatus.PREPARED) {
                aho().start();
                if (this.diR != null) {
                    this.diR.sendEmptyMessage(0);
                }
                if (this.diS != null) {
                    this.diS.px("onPlay");
                }
            } else if (this.diT == PlayerStatus.IDLE) {
                aho().prepareAsync();
                this.diT = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.diQ.mUrl;
        this.diQ = bVar;
        if (this.diS != null) {
            this.diS.pw(this.diQ.diy);
        }
        aAM();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.diW = true;
            aAL();
        }
    }

    private boolean apZ() {
        if (e.aIK() == null || !e.aIK().aJd()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afX = f.aAl().afX();
        if (afX == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c apx = afX.apx();
        if (apx == null || !(apx instanceof j)) {
            return true;
        }
        return ((j) apx).apZ();
    }

    private void aAM() {
        setLooping(this.diQ.mLoop);
        setVolume(this.diQ.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        aho().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!aqb() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.diV == null) {
                this.diV = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.diV, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.diV != null) {
                this.mAudioManager.abandonAudioFocus(this.diV);
                this.mAudioManager = null;
                this.diV = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqb() {
        e aIK = e.aIK();
        boolean booleanValue = aIK != null ? aIK.aJc().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.aho().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.aho().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.diS != null) {
                        SwanAppAudioPlayer.this.diS.h("onTimeUpdate", jSONObject);
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
    /* loaded from: classes9.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.diT = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.diS != null) {
                SwanAppAudioPlayer.this.diS.px("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.diU) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.aho().isLooping()) {
                SwanAppAudioPlayer.this.diU = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.diT = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.diS != null) {
                SwanAppAudioPlayer.this.diS.px("onEnded");
            }
            SwanAppAudioPlayer.this.diR.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.diS != null) {
                SwanAppAudioPlayer.this.diS.h("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.diS != null) {
                SwanAppAudioPlayer.this.diS.px("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.diT == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.aho().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.aho().getCurrentPosition() && SwanAppAudioPlayer.this.diS != null) {
                SwanAppAudioPlayer.this.diS.px("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.aqb()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAJ();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAJ();
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
