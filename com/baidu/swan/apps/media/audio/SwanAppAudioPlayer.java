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
        akK().start();
        if (this.dls != null) {
            this.dls.sendEmptyMessage(0);
        }
        if (this.dlt != null) {
            this.dlt.qq("onPlay");
        }
        aEi();
        if (this.dlr.dkX > 0) {
            seekTo(this.dlr.dkX);
        }
        if (atw()) {
            aEf();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.dlv = UserStatus.PAUSE;
        aEf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEf() {
        if (akK().isPlaying()) {
            akK().pause();
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
            akK().seekTo((int) (i * 1000));
            if (this.dlt != null) {
                this.dlt.qq("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        akK().setLooping(z);
    }

    public void stop() {
        this.dlv = UserStatus.STOP;
        if (this.dlu == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            akK().stop();
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
        akK().release();
        this.dlu = PlayerStatus.NONE;
        this.cFn = null;
        if (this.dls != null) {
            this.dls.removeMessages(0);
            this.dls = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer akK() {
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
    public String azY() {
        return this.dkT;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aEa() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dlr.cGy;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aEb() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fZ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aMl = e.aMl();
        if (aMl != null && aMl.aME()) {
            if (!z) {
                aEf();
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
            aEf();
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
        e aMl = e.aMl();
        if (aMl != null && aMl.aME()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aEg() {
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
        akK().reset();
        setDataSource(this.dlr.mUrl);
        aEh();
    }

    private void setDataSource(String str) {
        try {
            String ue = f.aDH().aDn().ue(str);
            if (!TextUtils.isEmpty(ue)) {
                HashMap hashMap = new HashMap();
                String aRz = ab.aRz();
                if (!TextUtils.isEmpty(aRz) && ab.uQ(ue)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aRz);
                    }
                    hashMap.put("Referer", aRz);
                }
                String avZ = com.baidu.swan.apps.core.turbo.d.avB().avZ();
                if (!TextUtils.isEmpty(avZ)) {
                    hashMap.put("User-Agent", avZ);
                }
                akK().setDataSource(AppRuntime.getAppContext(), Uri.parse(ue), hashMap);
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

    private void aEh() {
        if (this.dlx) {
            akK().reset();
            setDataSource(this.dlr.mUrl);
            this.dlx = false;
        }
        akK().prepareAsync();
        this.dlu = PlayerStatus.PREPARING;
    }

    public void play() {
        this.dlv = UserStatus.PLAY;
        if (!atw()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.dlu == PlayerStatus.PREPARED) {
                akK().start();
                if (this.dls != null) {
                    this.dls.sendEmptyMessage(0);
                }
                if (this.dlt != null) {
                    this.dlt.qq("onPlay");
                }
            } else if (this.dlu == PlayerStatus.IDLE) {
                akK().prepareAsync();
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
        aEi();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.dlx = true;
            aEh();
        }
    }

    private boolean atw() {
        if (e.aMl() == null || !e.aMl().aME()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f ajt = f.aDH().ajt();
        if (ajt == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c asU = ajt.asU();
        if (asU == null || !(asU instanceof j)) {
            return true;
        }
        return ((j) asU).atw();
    }

    private void aEi() {
        setLooping(this.dlr.mLoop);
        setVolume(this.dlr.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        akK().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!aty() && !this.mHasAudioFocus) {
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
    public boolean aty() {
        e aMl = e.aMl();
        boolean booleanValue = aMl != null ? aMl.aMD().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.akK().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.akK().getDuration() / 1000));
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
            if (!SwanAppAudioPlayer.this.akK().isLooping()) {
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
            if (SwanAppAudioPlayer.this.dlu == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.akK().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.akK().getCurrentPosition() && SwanAppAudioPlayer.this.dlt != null) {
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
                    if (!SwanAppAudioPlayer.this.aty()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aEf();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aEf();
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
