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
    private MediaPlayer cFn;
    private String dkT;
    private c dls;
    private com.baidu.swan.apps.media.audio.b.a dlt;
    private a dlw;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b dlr = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus dlu = PlayerStatus.NONE;
    private UserStatus dlv = UserStatus.OPEN;
    private boolean dlx = false;

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
        this.dkT = "";
        this.dkT = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        akJ().start();
        if (this.dls != null) {
            this.dls.sendEmptyMessage(0);
        }
        if (this.dlt != null) {
            this.dlt.qq("onPlay");
        }
        aEh();
        if (this.dlr.dkX > 0) {
            seekTo(this.dlr.dkX);
        }
        if (atv()) {
            aEe();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.dlv = UserStatus.PAUSE;
        aEe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEe() {
        if (akJ().isPlaying()) {
            akJ().pause();
            if (this.dlt != null) {
                this.dlt.qq(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.dls != null) {
                this.dls.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.dlu == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            akJ().seekTo((int) (i * 1000));
            if (this.dlt != null) {
                this.dlt.qq("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        akJ().setLooping(z);
    }

    public void stop() {
        this.dlv = UserStatus.STOP;
        if (this.dlu == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            akJ().stop();
            this.dlu = PlayerStatus.IDLE;
            if (this.dls != null) {
                this.dls.removeMessages(0);
            }
            if (this.dlt != null) {
                this.dlt.qq(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.dlv = UserStatus.DESTROY;
        abandonAudioFocus();
        akJ().release();
        this.dlu = PlayerStatus.NONE;
        this.cFn = null;
        if (this.dls != null) {
            this.dls.removeMessages(0);
            this.dls = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer akJ() {
        if (this.cFn == null) {
            this.cFn = new MediaPlayer();
            b bVar = new b();
            this.cFn.setOnPreparedListener(bVar);
            this.cFn.setOnCompletionListener(bVar);
            this.cFn.setOnInfoListener(bVar);
            this.cFn.setOnErrorListener(bVar);
            this.cFn.setOnSeekCompleteListener(bVar);
            this.cFn.setOnBufferingUpdateListener(bVar);
            this.dls = new c();
        }
        return this.cFn;
    }

    @Override // com.baidu.swan.apps.media.a
    public String azX() {
        return this.dkT;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aDZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dlr.cGy;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aEa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fZ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aMk = e.aMk();
        if (aMk != null && aMk.aMD()) {
            if (!z) {
                aEe();
            } else if (this.dlv == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ga(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            aEe();
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
        e aMk = e.aMk();
        if (aMk != null && aMk.aMD()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aEf() {
        return this.dlr;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.dlv = UserStatus.OPEN;
        this.dlr = bVar;
        if (this.dlr.dkZ != null) {
            try {
                this.dlt = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dlr.dkZ));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        akJ().reset();
        setDataSource(this.dlr.mUrl);
        aEg();
    }

    private void setDataSource(String str) {
        try {
            String ue = f.aDG().aDm().ue(str);
            if (!TextUtils.isEmpty(ue)) {
                HashMap hashMap = new HashMap();
                String aRy = ab.aRy();
                if (!TextUtils.isEmpty(aRy) && ab.uQ(ue)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aRy);
                    }
                    hashMap.put("Referer", aRy);
                }
                String avY = com.baidu.swan.apps.core.turbo.d.avA().avY();
                if (!TextUtils.isEmpty(avY)) {
                    hashMap.put("User-Agent", avY);
                }
                akJ().setDataSource(AppRuntime.getAppContext(), Uri.parse(ue), hashMap);
                this.dlu = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.dlt != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.dlt.qq("onError");
            }
        }
    }

    private void aEg() {
        if (this.dlx) {
            akJ().reset();
            setDataSource(this.dlr.mUrl);
            this.dlx = false;
        }
        akJ().prepareAsync();
        this.dlu = PlayerStatus.PREPARING;
    }

    public void play() {
        this.dlv = UserStatus.PLAY;
        if (!atv()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.dlu == PlayerStatus.PREPARED) {
                akJ().start();
                if (this.dls != null) {
                    this.dls.sendEmptyMessage(0);
                }
                if (this.dlt != null) {
                    this.dlt.qq("onPlay");
                }
            } else if (this.dlu == PlayerStatus.IDLE) {
                akJ().prepareAsync();
                this.dlu = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.dlr.mUrl;
        this.dlr = bVar;
        if (this.dlt != null) {
            this.dlt.qp(this.dlr.dkZ);
        }
        aEh();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.dlx = true;
            aEg();
        }
    }

    private boolean atv() {
        if (e.aMk() == null || !e.aMk().aMD()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f ajs = f.aDG().ajs();
        if (ajs == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c asT = ajs.asT();
        if (asT == null || !(asT instanceof j)) {
            return true;
        }
        return ((j) asT).atv();
    }

    private void aEh() {
        setLooping(this.dlr.mLoop);
        setVolume(this.dlr.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        akJ().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!atx() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dlw == null) {
                this.dlw = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.dlw, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.dlw != null) {
                this.mAudioManager.abandonAudioFocus(this.dlw);
                this.mAudioManager = null;
                this.dlw = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atx() {
        e aMk = e.aMk();
        boolean booleanValue = aMk != null ? aMk.aMC().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.akJ().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.akJ().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.dlt != null) {
                        SwanAppAudioPlayer.this.dlt.h("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.dlu = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dlt != null) {
                SwanAppAudioPlayer.this.dlt.qq("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.dlv) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.akJ().isLooping()) {
                SwanAppAudioPlayer.this.dlv = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.dlu = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dlt != null) {
                SwanAppAudioPlayer.this.dlt.qq("onEnded");
            }
            SwanAppAudioPlayer.this.dls.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.dlt != null) {
                SwanAppAudioPlayer.this.dlt.h("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.dlt != null) {
                SwanAppAudioPlayer.this.dlt.qq("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.dlu == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.akJ().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.akJ().getCurrentPosition() && SwanAppAudioPlayer.this.dlt != null) {
                SwanAppAudioPlayer.this.dlt.qq("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.atx()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aEe();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aEe();
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
