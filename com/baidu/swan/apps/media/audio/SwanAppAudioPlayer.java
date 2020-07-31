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
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.f;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer bMY;
    private boolean bNb;
    private c cqS;
    private com.baidu.swan.apps.media.audio.b.a cqT;
    private a cqW;
    private String cqu;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b cqR = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cqU = PlayerStatus.NONE;
    private UserStatus cqV = UserStatus.OPEN;
    private boolean cqX = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.cqu = "";
        this.cqu = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Gu();
        Tm().start();
        if (this.cqS != null) {
            this.cqS.sendEmptyMessage(0);
        }
        if (this.cqT != null) {
            this.cqT.mk("onPlay");
        }
        akM();
        if (this.cqR.cqy > 0) {
            seekTo(this.cqR.cqy);
        }
        if (abC()) {
            akJ();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.cqV = UserStatus.PAUSE;
        akJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        if (Tm().isPlaying()) {
            Tm().pause();
            if (this.cqT != null) {
                this.cqT.mk(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cqS != null) {
                this.cqS.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cqU == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Tm().seekTo((int) (i * 1000));
            if (this.cqT != null) {
                this.cqT.mk("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Tm().setLooping(z);
    }

    public void stop() {
        this.cqV = UserStatus.STOP;
        if (this.cqU == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Tm().stop();
            this.cqU = PlayerStatus.IDLE;
            if (this.cqS != null) {
                this.cqS.removeMessages(0);
            }
            if (this.cqT != null) {
                this.cqT.mk(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.cqV = UserStatus.DESTROY;
        Gv();
        Tm().release();
        this.cqU = PlayerStatus.NONE;
        this.bMY = null;
        if (this.cqS != null) {
            this.cqS.removeMessages(0);
            this.cqS = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Tm() {
        if (this.bMY == null) {
            this.bMY = new MediaPlayer();
            b bVar = new b();
            this.bMY.setOnPreparedListener(bVar);
            this.bMY.setOnCompletionListener(bVar);
            this.bMY.setOnInfoListener(bVar);
            this.bMY.setOnErrorListener(bVar);
            this.bMY.setOnSeekCompleteListener(bVar);
            this.bMY.setOnBufferingUpdateListener(bVar);
            this.cqS = new c();
        }
        return this.bMY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String agP() {
        return this.cqu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String akD() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cqR.bOl;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object akE() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void er(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e arv = e.arv();
        if (arv != null && arv.arO()) {
            if (!z) {
                akJ();
            } else if (this.cqV == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void es(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            akJ();
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
        e arv = e.arv();
        if (arv != null && arv.arO()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b akK() {
        return this.cqR;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.cqV = UserStatus.OPEN;
        this.cqR = bVar;
        if (this.cqR.cqA != null) {
            try {
                this.cqT = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cqR.cqA));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Tm().reset();
        setDataSource(this.cqR.mUrl);
        akL();
    }

    private void setDataSource(String str) {
        try {
            String pR = f.akr().ajX().pR(str);
            if (!TextUtils.isEmpty(pR)) {
                HashMap hashMap = new HashMap();
                String awL = aa.awL();
                if (!TextUtils.isEmpty(awL) && aa.qB(pR)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + awL);
                    }
                    hashMap.put("Referer", awL);
                }
                String adT = com.baidu.swan.apps.core.turbo.d.adw().adT();
                if (!TextUtils.isEmpty(adT)) {
                    hashMap.put("User-Agent", adT);
                }
                Tm().setDataSource(AppRuntime.getAppContext(), Uri.parse(pR), hashMap);
                this.cqU = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cqT != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.cqT.mk("onError");
            }
        }
    }

    private void akL() {
        if (this.cqX) {
            Tm().reset();
            setDataSource(this.cqR.mUrl);
            this.cqX = false;
        }
        Tm().prepareAsync();
        this.cqU = PlayerStatus.PREPARING;
    }

    public void play() {
        this.cqV = UserStatus.PLAY;
        if (!abC()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Gu();
            if (this.cqU == PlayerStatus.PREPARED) {
                Tm().start();
                if (this.cqS != null) {
                    this.cqS.sendEmptyMessage(0);
                }
                if (this.cqT != null) {
                    this.cqT.mk("onPlay");
                }
            } else if (this.cqU == PlayerStatus.IDLE) {
                Tm().prepareAsync();
                this.cqU = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cqR.mUrl;
        this.cqR = bVar;
        if (this.cqT != null) {
            this.cqT.mj(this.cqR.cqA);
        }
        akM();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.cqX = true;
            akL();
        }
    }

    private boolean abC() {
        if (e.arv() == null || !e.arv().arO()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f Sc = f.akr().Sc();
        if (Sc == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
        if (aaZ == null || !(aaZ instanceof j)) {
            return true;
        }
        return ((j) aaZ).abC();
    }

    private void akM() {
        setLooping(this.cqR.mLoop);
        setVolume(this.cqR.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        Tm().setVolume(f, f);
    }

    private void Gu() {
        if (!abE() && !this.bNb) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cqW == null) {
                this.cqW = new a();
            }
            this.bNb = this.mAudioManager.requestAudioFocus(this.cqW, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv() {
        if (this.bNb) {
            if (this.mAudioManager != null && this.cqW != null) {
                this.mAudioManager.abandonAudioFocus(this.cqW);
                this.mAudioManager = null;
                this.cqW = null;
            }
            this.bNb = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abE() {
        e arv = e.arv();
        boolean booleanValue = arv != null ? arv.arN().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Tm().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.Tm().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.cqT != null) {
                        SwanAppAudioPlayer.this.cqT.e("onTimeUpdate", jSONObject);
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
    /* loaded from: classes7.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.cqU = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cqT != null) {
                SwanAppAudioPlayer.this.cqT.mk("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.cqV) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Tm().isLooping()) {
                SwanAppAudioPlayer.this.cqV = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cqU = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cqT != null) {
                SwanAppAudioPlayer.this.cqT.mk("onEnded");
            }
            SwanAppAudioPlayer.this.cqS.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.cqT != null) {
                SwanAppAudioPlayer.this.cqT.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cqT != null) {
                SwanAppAudioPlayer.this.cqT.mk("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cqU == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Tm().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Tm().getCurrentPosition() && SwanAppAudioPlayer.this.cqT != null) {
                SwanAppAudioPlayer.this.cqT.mk("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.abE()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.Gv();
                                SwanAppAudioPlayer.this.akJ();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.Gv();
                                SwanAppAudioPlayer.this.akJ();
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
