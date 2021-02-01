package com.baidu.swan.games.audio;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.File;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.media.audio.b.a diS;
    private String diq;
    private com.baidu.swan.games.audio.b.c ecn;
    private int ecq;
    private String ecr;
    private a ecs;
    private boolean ecu;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus ecl = PlayerStatus.NONE;
    protected UserStatus ecm = UserStatus.OPEN;
    private d eco = new d();
    private b ecp = new b();
    private float ect = -1.0f;
    private TypedCallbackHandler ecv = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
        @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
        public int getInvokeSourceType() {
            return 1;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.diq = "";
        this.diq = str;
    }

    public void pause() {
        this.ecm = UserStatus.PAUSE;
        aAJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAJ() {
        if (aTU()) {
            this.ecn.pause();
        }
    }

    private void aTM() {
        vS(MissionEvent.MESSAGE_PAUSE);
        this.ecp.removeMessages(0);
    }

    public void X(float f) {
        try {
            vS("onSeeking");
            int i = (int) (1000.0f * f);
            if (aTU()) {
                if (i >= 0 && i <= getDuration()) {
                    this.ecn.seek(i);
                }
                this.ect = -1.0f;
                return;
            }
            if (this.ecu && this.ecl == PlayerStatus.IDLE) {
                aTS();
            }
            this.ect = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aTU()) {
                this.ecn.hZ(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.ecm = UserStatus.STOP;
        if (aTU()) {
            this.ecn.stop();
        }
        aTN();
        vS(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aTN();
        this.ecu = false;
        this.ecm = UserStatus.DESTROY;
        this.ecl = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTN() {
        this.ecl = PlayerStatus.IDLE;
        if (this.ecn != null) {
            this.ecn.destroy();
            this.ecn = null;
        }
        this.ecp.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.ecn != null) {
                return this.ecn.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aTU()) {
            return this.ecn.getCurrentTime();
        }
        return 0;
    }

    public int aTO() {
        return this.ecq;
    }

    public float getVolume() {
        if (this.eco != null) {
            return this.eco.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aTU()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.ecn.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aTP() {
        if (this.ecn == null || this.ecn.aUh()) {
            this.ecn = com.baidu.swan.games.audio.b.b.aUd().ak(this.ecr, this.eco.mLoop);
            registerListener();
        }
        return this.ecn;
    }

    protected void registerListener() {
        if (this.ecs == null) {
            this.ecs = new a();
        }
        this.ecn.setOnPreparedListener(this.ecs);
        this.ecn.setOnCompletionListener(this.ecs);
        this.ecn.setOnInfoListener(this.ecs);
        this.ecn.setOnErrorListener(this.ecs);
        this.ecn.a((MediaPlayer.OnSeekCompleteListener) this.ecs);
        this.ecn.a((MediaPlayer.OnBufferingUpdateListener) this.ecs);
        this.ecn.a(this);
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
        return this.eco.cEi;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAF() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fX(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && aIK.aJd() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aWe()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aUd().aUf().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.aAJ();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fY(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && aIK.aJd()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK == null || !aIK.aJd()) {
            return null;
        }
        SwanAppActivity aIE = aIK.aIE();
        if (aIE == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c afQ = aIE.afQ();
        if (afQ instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) afQ).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.ecn != null) {
            aTN();
        }
        this.ecm = UserStatus.OPEN;
        this.eco = dVar;
        this.ecq = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.aAl().azR().tm(this.eco.mUrl);
        this.ecl = PlayerStatus.IDLE;
        vS("onWaiting");
        aTQ();
    }

    private void aTQ() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aUd = com.baidu.swan.games.audio.b.b.aUd();
                File file = new File(aUd.vY(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.ecr = file.getAbsolutePath();
                    aTR();
                } else {
                    aUd.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cK(String str, String str2) {
                            AudioPlayer.this.ecr = str2;
                            AudioPlayer.this.aTR();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void aB(int i, String str) {
                            AudioPlayer.this.vR(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.ecr = this.mDataSource;
                aTR();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTR() {
        aTS();
    }

    private void aTS() {
        try {
            File file = new File(this.ecr);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aUd().vZ(this.ecr);
                if (0 != this.mDuration) {
                    aTP().setSrc(this.ecr);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.ecr);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "set data source fail");
                e.printStackTrace();
            }
        }
        vR("10003");
    }

    public boolean aTT() {
        return (UserStatus.STOP == this.ecm || UserStatus.DESTROY == this.ecm) ? false : true;
    }

    public void play() {
        this.ecm = UserStatus.PLAY;
        if (this.ecu) {
            try {
                if (!apZ() && aTV()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.ecr);
                    }
                    if (this.ecl == PlayerStatus.PREPARED) {
                        this.ecp.sendEmptyMessage(0);
                        aAM();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.ecr);
                        }
                        aTP().play();
                        vS("onPlay");
                    } else if (this.ecl == PlayerStatus.IDLE) {
                        try {
                            aTP().setSrc(this.ecr);
                            this.ecl = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            vR(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    }
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTU() {
        return this.ecn != null && this.ecl == PlayerStatus.PREPARED;
    }

    private boolean aTV() throws JSONException {
        File file = new File(this.ecr);
        if (!file.exists() || file.isDirectory()) {
            vR("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.eco = dVar;
        if (this.diS != null) {
            this.diS.pw(this.eco.diy);
        }
        aAM();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.diS = aVar;
    }

    private boolean apZ() {
        if (com.baidu.swan.apps.runtime.e.aIK() == null || !com.baidu.swan.apps.runtime.e.aIK().aJd()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
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
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.eco.toString());
        }
        setLooping(this.eco.mLoop);
        setVolume(this.eco.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aTM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aUd().aUf().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.ecl == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.getCurrentPosition() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.getDuration() / 1000));
                    AudioPlayer.this.m("onTimeUpdate", jSONObject);
                } catch (Exception e) {
                    if (AudioPlayer.DEBUG) {
                        e.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.ecl = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.ecu) {
                AudioPlayer.this.vS("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.ecr);
            }
            AudioPlayer.this.ecu = true;
            if (UserStatus.PLAY == AudioPlayer.this.ecm) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.eco.ecy > 0.0f) {
                    AudioPlayer.this.aTP().seek(AudioPlayer.this.eco.ecy);
                } else if (AudioPlayer.this.ect >= 0.0f) {
                    AudioPlayer.this.aTP().seek(AudioPlayer.this.ect);
                    AudioPlayer.this.ect = -1.0f;
                }
            } catch (Exception e) {
                if (AudioPlayer.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "comCompletion");
            }
            try {
                if (!AudioPlayer.this.eco.mLoop) {
                    AudioPlayer.this.ecm = UserStatus.STOP;
                    AudioPlayer.this.aTN();
                }
                AudioPlayer.this.vS("onEnded");
            } catch (Exception e) {
                if (AudioPlayer.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "oninfo : what is " + i + " extra is " + i2);
                return false;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onError : what is " + i + " extra is " + i2);
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.eco.diq + " url = " + AudioPlayer.this.eco.mUrl);
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
            AudioPlayer.this.vR(str);
            AudioPlayer.this.aTN();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.vS("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aTU()) {
                    AudioPlayer.this.ecq = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.diS != null) {
                        AudioPlayer.this.vS("onBufferingUpdate");
                        if (AudioPlayer.this.ecl == PlayerStatus.PREPARED && AudioPlayer.this.ecm != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.vS("onWaiting");
                        }
                    }
                }
            } catch (Exception e) {
                if (AudioPlayer.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(String str) {
        if (this.diS != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.diS.h("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(String str) {
        m(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, JSONObject jSONObject) {
        if (this.diS != null) {
            this.diS.h(str, jSONObject);
        }
    }
}
