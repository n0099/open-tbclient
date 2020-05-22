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
    private MediaPlayer bHv;
    private boolean bHy;
    private String cjA;
    private c cjY;
    private com.baidu.swan.apps.media.audio.b.a cjZ;
    private a ckc;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b cjX = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cka = PlayerStatus.NONE;
    private UserStatus ckb = UserStatus.OPEN;
    private boolean ckd = false;

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
        this.cjA = "";
        this.cjA = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        FQ();
        RL().start();
        if (this.cjY != null) {
            this.cjY.sendEmptyMessage(0);
        }
        if (this.cjZ != null) {
            this.cjZ.lB("onPlay");
        }
        aiq();
        if (this.cjX.cjE > 0) {
            seekTo(this.cjX.cjE);
        }
        if (Zu()) {
            ain();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.ckb = UserStatus.PAUSE;
        ain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ain() {
        if (RL().isPlaying()) {
            RL().pause();
            if (this.cjZ != null) {
                this.cjZ.lB(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cjY != null) {
                this.cjY.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cka == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            RL().seekTo((int) (i * 1000));
            if (this.cjZ != null) {
                this.cjZ.lB("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        RL().setLooping(z);
    }

    public void stop() {
        this.ckb = UserStatus.STOP;
        if (this.cka == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            RL().stop();
            this.cka = PlayerStatus.IDLE;
            if (this.cjY != null) {
                this.cjY.removeMessages(0);
            }
            if (this.cjZ != null) {
                this.cjZ.lB(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.ckb = UserStatus.DESTROY;
        FR();
        RL().release();
        this.cka = PlayerStatus.NONE;
        this.bHv = null;
        if (this.cjY != null) {
            this.cjY.removeMessages(0);
            this.cjY = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer RL() {
        if (this.bHv == null) {
            this.bHv = new MediaPlayer();
            b bVar = new b();
            this.bHv.setOnPreparedListener(bVar);
            this.bHv.setOnCompletionListener(bVar);
            this.bHv.setOnInfoListener(bVar);
            this.bHv.setOnErrorListener(bVar);
            this.bHv.setOnSeekCompleteListener(bVar);
            this.bHv.setOnBufferingUpdateListener(bVar);
            this.cjY = new c();
        }
        return this.bHv;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aey() {
        return this.cjA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aih() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cjX.bIH;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aii() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ee(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aoF = e.aoF();
        if (aoF != null && aoF.aoY()) {
            if (!z) {
                ain();
            } else if (this.ckb == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ef(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            ain();
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
        e aoF = e.aoF();
        if (aoF != null && aoF.aoY()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aio() {
        return this.cjX;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.ckb = UserStatus.OPEN;
        this.cjX = bVar;
        if (this.cjX.cjG != null) {
            try {
                this.cjZ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cjX.cjG));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        RL().reset();
        setDataSource(this.cjX.mUrl);
        aip();
    }

    private void setDataSource(String str) {
        try {
            String oY = f.ahV().ahB().oY(str);
            if (!TextUtils.isEmpty(oY)) {
                HashMap hashMap = new HashMap();
                String atD = z.atD();
                if (!TextUtils.isEmpty(atD) && z.pI(oY)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + atD);
                    }
                    hashMap.put("Referer", atD);
                }
                String abJ = com.baidu.swan.apps.core.turbo.d.abl().abJ();
                if (!TextUtils.isEmpty(abJ)) {
                    hashMap.put("User-Agent", abJ);
                }
                RL().setDataSource(AppRuntime.getAppContext(), Uri.parse(oY), hashMap);
                this.cka = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cjZ != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.cjZ.lB("onError");
            }
        }
    }

    private void aip() {
        if (this.ckd) {
            RL().reset();
            setDataSource(this.cjX.mUrl);
            this.ckd = false;
        }
        RL().prepareAsync();
        this.cka = PlayerStatus.PREPARING;
    }

    public void play() {
        this.ckb = UserStatus.PLAY;
        if (!Zu()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            FQ();
            if (this.cka == PlayerStatus.PREPARED) {
                RL().start();
                if (this.cjY != null) {
                    this.cjY.sendEmptyMessage(0);
                }
                if (this.cjZ != null) {
                    this.cjZ.lB("onPlay");
                }
            } else if (this.cka == PlayerStatus.IDLE) {
                RL().prepareAsync();
                this.cka = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cjX.mUrl;
        this.cjX = bVar;
        if (this.cjZ != null) {
            this.cjZ.lA(this.cjX.cjG);
        }
        aiq();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.ckd = true;
            aip();
        }
    }

    private boolean Zu() {
        if (e.aoF() == null || !e.aoF().aoY()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e QH = f.ahV().QH();
        if (QH == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b YP = QH.YP();
        if (YP == null || !(YP instanceof i)) {
            return true;
        }
        return ((i) YP).Zu();
    }

    private void aiq() {
        setLooping(this.cjX.mLoop);
        setVolume(this.cjX.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        RL().setVolume(f, f);
    }

    private void FQ() {
        if (!Zw() && !this.bHy) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.ckc == null) {
                this.ckc = new a();
            }
            this.bHy = this.mAudioManager.requestAudioFocus(this.ckc, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR() {
        if (this.bHy) {
            if (this.mAudioManager != null && this.ckc != null) {
                this.mAudioManager.abandonAudioFocus(this.ckc);
                this.mAudioManager = null;
                this.ckc = null;
            }
            this.bHy = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zw() {
        e aoF = e.aoF();
        boolean booleanValue = aoF != null ? aoF.aoX().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.RL().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.RL().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.cjZ != null) {
                        SwanAppAudioPlayer.this.cjZ.e("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.cka = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cjZ != null) {
                SwanAppAudioPlayer.this.cjZ.lB("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.ckb) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.RL().isLooping()) {
                SwanAppAudioPlayer.this.ckb = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cka = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cjZ != null) {
                SwanAppAudioPlayer.this.cjZ.lB("onEnded");
            }
            SwanAppAudioPlayer.this.cjY.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.cjZ != null) {
                SwanAppAudioPlayer.this.cjZ.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cjZ != null) {
                SwanAppAudioPlayer.this.cjZ.lB("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cka == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.RL().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.RL().getCurrentPosition() && SwanAppAudioPlayer.this.cjZ != null) {
                SwanAppAudioPlayer.this.cjZ.lB("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.Zw()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.FR();
                                SwanAppAudioPlayer.this.ain();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.FR();
                                SwanAppAudioPlayer.this.ain();
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
