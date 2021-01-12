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
    private MediaPlayer cAB;
    private c dgD;
    private com.baidu.swan.apps.media.audio.b.a dgE;
    private a dgH;
    private String dge;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b dgC = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus dgF = PlayerStatus.NONE;
    private UserStatus dgG = UserStatus.OPEN;
    private boolean dgI = false;

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
        this.dge = "";
        this.dge = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        agQ().start();
        if (this.dgD != null) {
            this.dgD.sendEmptyMessage(0);
        }
        if (this.dgE != null) {
            this.dgE.pf("onPlay");
        }
        aAo();
        if (this.dgC.dgi > 0) {
            seekTo(this.dgC.dgi);
        }
        if (apB()) {
            aAl();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.dgG = UserStatus.PAUSE;
        aAl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAl() {
        if (agQ().isPlaying()) {
            agQ().pause();
            if (this.dgE != null) {
                this.dgE.pf(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.dgD != null) {
                this.dgD.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.dgF == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            agQ().seekTo((int) (i * 1000));
            if (this.dgE != null) {
                this.dgE.pf("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        agQ().setLooping(z);
    }

    public void stop() {
        this.dgG = UserStatus.STOP;
        if (this.dgF == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            agQ().stop();
            this.dgF = PlayerStatus.IDLE;
            if (this.dgD != null) {
                this.dgD.removeMessages(0);
            }
            if (this.dgE != null) {
                this.dgE.pf(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.dgG = UserStatus.DESTROY;
        abandonAudioFocus();
        agQ().release();
        this.dgF = PlayerStatus.NONE;
        this.cAB = null;
        if (this.dgD != null) {
            this.dgD.removeMessages(0);
            this.dgD = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer agQ() {
        if (this.cAB == null) {
            this.cAB = new MediaPlayer();
            b bVar = new b();
            this.cAB.setOnPreparedListener(bVar);
            this.cAB.setOnCompletionListener(bVar);
            this.cAB.setOnInfoListener(bVar);
            this.cAB.setOnErrorListener(bVar);
            this.cAB.setOnSeekCompleteListener(bVar);
            this.cAB.setOnBufferingUpdateListener(bVar);
            this.dgD = new c();
        }
        return this.cAB;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awe() {
        return this.dge;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAg() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dgC.cBM;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAh() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fV(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aIr = e.aIr();
        if (aIr != null && aIr.aIK()) {
            if (!z) {
                aAl();
            } else if (this.dgG == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fW(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            aAl();
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
        e aIr = e.aIr();
        if (aIr != null && aIr.aIK()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aAm() {
        return this.dgC;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.dgG = UserStatus.OPEN;
        this.dgC = bVar;
        if (this.dgC.dgk != null) {
            try {
                this.dgE = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dgC.dgk));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        agQ().reset();
        setDataSource(this.dgC.mUrl);
        aAn();
    }

    private void setDataSource(String str) {
        try {
            String sT = f.azN().azt().sT(str);
            if (!TextUtils.isEmpty(sT)) {
                HashMap hashMap = new HashMap();
                String aNF = ab.aNF();
                if (!TextUtils.isEmpty(aNF) && ab.tF(sT)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aNF);
                    }
                    hashMap.put("Referer", aNF);
                }
                String ase = com.baidu.swan.apps.core.turbo.d.arG().ase();
                if (!TextUtils.isEmpty(ase)) {
                    hashMap.put("User-Agent", ase);
                }
                agQ().setDataSource(AppRuntime.getAppContext(), Uri.parse(sT), hashMap);
                this.dgF = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.dgE != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.dgE.pf("onError");
            }
        }
    }

    private void aAn() {
        if (this.dgI) {
            agQ().reset();
            setDataSource(this.dgC.mUrl);
            this.dgI = false;
        }
        agQ().prepareAsync();
        this.dgF = PlayerStatus.PREPARING;
    }

    public void play() {
        this.dgG = UserStatus.PLAY;
        if (!apB()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.dgF == PlayerStatus.PREPARED) {
                agQ().start();
                if (this.dgD != null) {
                    this.dgD.sendEmptyMessage(0);
                }
                if (this.dgE != null) {
                    this.dgE.pf("onPlay");
                }
            } else if (this.dgF == PlayerStatus.IDLE) {
                agQ().prepareAsync();
                this.dgF = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.dgC.mUrl;
        this.dgC = bVar;
        if (this.dgE != null) {
            this.dgE.pe(this.dgC.dgk);
        }
        aAo();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.dgI = true;
            aAn();
        }
    }

    private boolean apB() {
        if (e.aIr() == null || !e.aIr().aIK()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afz = f.azN().afz();
        if (afz == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c aoY = afz.aoY();
        if (aoY == null || !(aoY instanceof j)) {
            return true;
        }
        return ((j) aoY).apB();
    }

    private void aAo() {
        setLooping(this.dgC.mLoop);
        setVolume(this.dgC.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        agQ().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!apD() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dgH == null) {
                this.dgH = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.dgH, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.dgH != null) {
                this.mAudioManager.abandonAudioFocus(this.dgH);
                this.mAudioManager = null;
                this.dgH = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apD() {
        e aIr = e.aIr();
        boolean booleanValue = aIr != null ? aIr.aIJ().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.agQ().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.agQ().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.dgE != null) {
                        SwanAppAudioPlayer.this.dgE.h("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.dgF = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dgE != null) {
                SwanAppAudioPlayer.this.dgE.pf("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.dgG) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.agQ().isLooping()) {
                SwanAppAudioPlayer.this.dgG = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.dgF = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dgE != null) {
                SwanAppAudioPlayer.this.dgE.pf("onEnded");
            }
            SwanAppAudioPlayer.this.dgD.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.dgE != null) {
                SwanAppAudioPlayer.this.dgE.h("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.dgE != null) {
                SwanAppAudioPlayer.this.dgE.pf("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.dgF == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.agQ().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.agQ().getCurrentPosition() && SwanAppAudioPlayer.this.dgE != null) {
                SwanAppAudioPlayer.this.dgE.pf("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.apD()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAl();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAl();
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
