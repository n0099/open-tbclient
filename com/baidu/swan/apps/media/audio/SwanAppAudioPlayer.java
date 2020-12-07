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
/* loaded from: classes25.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer cAx;
    private a dgC;
    private String dga;
    private c dgy;
    private com.baidu.swan.apps.media.audio.b.a dgz;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b dgx = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus dgA = PlayerStatus.NONE;
    private UserStatus dgB = UserStatus.OPEN;
    private boolean dgD = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.dga = "";
        this.dga = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        ajB().start();
        if (this.dgy != null) {
            this.dgy.sendEmptyMessage(0);
        }
        if (this.dgz != null) {
            this.dgz.qx("onPlay");
        }
        aCQ();
        if (this.dgx.dge > 0) {
            seekTo(this.dgx.dge);
        }
        if (asd()) {
            aCN();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.dgB = UserStatus.PAUSE;
        aCN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCN() {
        if (ajB().isPlaying()) {
            ajB().pause();
            if (this.dgz != null) {
                this.dgz.qx(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.dgy != null) {
                this.dgy.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.dgA == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            ajB().seekTo((int) (i * 1000));
            if (this.dgz != null) {
                this.dgz.qx("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        ajB().setLooping(z);
    }

    public void stop() {
        this.dgB = UserStatus.STOP;
        if (this.dgA == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            ajB().stop();
            this.dgA = PlayerStatus.IDLE;
            if (this.dgy != null) {
                this.dgy.removeMessages(0);
            }
            if (this.dgz != null) {
                this.dgz.qx(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.dgB = UserStatus.DESTROY;
        abandonAudioFocus();
        ajB().release();
        this.dgA = PlayerStatus.NONE;
        this.cAx = null;
        if (this.dgy != null) {
            this.dgy.removeMessages(0);
            this.dgy = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ajB() {
        if (this.cAx == null) {
            this.cAx = new MediaPlayer();
            b bVar = new b();
            this.cAx.setOnPreparedListener(bVar);
            this.cAx.setOnCompletionListener(bVar);
            this.cAx.setOnInfoListener(bVar);
            this.cAx.setOnErrorListener(bVar);
            this.cAx.setOnSeekCompleteListener(bVar);
            this.cAx.setOnBufferingUpdateListener(bVar);
            this.dgy = new c();
        }
        return this.cAx;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ayG() {
        return this.dga;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aCI() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dgx.cBI;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aCJ() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fQ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aJU = e.aJU();
        if (aJU != null && aJU.aKn()) {
            if (!z) {
                aCN();
            } else if (this.dgB == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fR(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            aCN();
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
        e aJU = e.aJU();
        if (aJU != null && aJU.aKn()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aCO() {
        return this.dgx;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.dgB = UserStatus.OPEN;
        this.dgx = bVar;
        if (this.dgx.dgg != null) {
            try {
                this.dgz = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dgx.dgg));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        ajB().reset();
        setDataSource(this.dgx.mUrl);
        aCP();
    }

    private void setDataSource(String str) {
        try {
            String uh = f.aCp().aBV().uh(str);
            if (!TextUtils.isEmpty(uh)) {
                HashMap hashMap = new HashMap();
                String aPh = ab.aPh();
                if (!TextUtils.isEmpty(aPh) && ab.uR(uh)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aPh);
                    }
                    hashMap.put("Referer", aPh);
                }
                String auG = com.baidu.swan.apps.core.turbo.d.aui().auG();
                if (!TextUtils.isEmpty(auG)) {
                    hashMap.put("User-Agent", auG);
                }
                ajB().setDataSource(AppRuntime.getAppContext(), Uri.parse(uh), hashMap);
                this.dgA = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.dgz != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.dgz.qx("onError");
            }
        }
    }

    private void aCP() {
        if (this.dgD) {
            ajB().reset();
            setDataSource(this.dgx.mUrl);
            this.dgD = false;
        }
        ajB().prepareAsync();
        this.dgA = PlayerStatus.PREPARING;
    }

    public void play() {
        this.dgB = UserStatus.PLAY;
        if (!asd()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.dgA == PlayerStatus.PREPARED) {
                ajB().start();
                if (this.dgy != null) {
                    this.dgy.sendEmptyMessage(0);
                }
                if (this.dgz != null) {
                    this.dgz.qx("onPlay");
                }
            } else if (this.dgA == PlayerStatus.IDLE) {
                ajB().prepareAsync();
                this.dgA = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.dgx.mUrl;
        this.dgx = bVar;
        if (this.dgz != null) {
            this.dgz.qw(this.dgx.dgg);
        }
        aCQ();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.dgD = true;
            aCP();
        }
    }

    private boolean asd() {
        if (e.aJU() == null || !e.aJU().aKn()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f aim = f.aCp().aim();
        if (aim == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c arB = aim.arB();
        if (arB == null || !(arB instanceof j)) {
            return true;
        }
        return ((j) arB).asd();
    }

    private void aCQ() {
        setLooping(this.dgx.mLoop);
        setVolume(this.dgx.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        ajB().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!asf() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dgC == null) {
                this.dgC = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.dgC, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.dgC != null) {
                this.mAudioManager.abandonAudioFocus(this.dgC);
                this.mAudioManager = null;
                this.dgC = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asf() {
        e aJU = e.aJU();
        boolean booleanValue = aJU != null ? aJU.aKm().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.ajB().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.ajB().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.dgz != null) {
                        SwanAppAudioPlayer.this.dgz.g("onTimeUpdate", jSONObject);
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
    /* loaded from: classes25.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.dgA = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dgz != null) {
                SwanAppAudioPlayer.this.dgz.qx("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.dgB) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.ajB().isLooping()) {
                SwanAppAudioPlayer.this.dgB = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.dgA = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dgz != null) {
                SwanAppAudioPlayer.this.dgz.qx("onEnded");
            }
            SwanAppAudioPlayer.this.dgy.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.dgz != null) {
                SwanAppAudioPlayer.this.dgz.g("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.dgz != null) {
                SwanAppAudioPlayer.this.dgz.qx("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.dgA == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.ajB().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.ajB().getCurrentPosition() && SwanAppAudioPlayer.this.dgz != null) {
                SwanAppAudioPlayer.this.dgz.qx("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.asf()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aCN();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aCN();
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
