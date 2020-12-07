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
/* loaded from: classes25.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.audio.b.c dVV;
    private int dVY;
    private String dVZ;
    private a dWa;
    private boolean dWc;
    private String dga;
    protected com.baidu.swan.apps.media.audio.b.a dgz;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus dVT = PlayerStatus.NONE;
    protected UserStatus dVU = UserStatus.OPEN;
    private d dVW = new d();
    private b dVX = new b();
    private float dWb = -1.0f;
    private TypedCallbackHandler dWd = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes25.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes25.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.dga = "";
        this.dga = str;
    }

    public void pause() {
        this.dVU = UserStatus.PAUSE;
        aCN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCN() {
        if (aVh()) {
            this.dVV.pause();
        }
    }

    private void aUZ() {
        wL(MissionEvent.MESSAGE_PAUSE);
        this.dVX.removeMessages(0);
    }

    public void U(float f) {
        try {
            wL("onSeeking");
            int i = (int) (1000.0f * f);
            if (aVh()) {
                if (i >= 0 && i <= getDuration()) {
                    this.dVV.seek(i);
                }
                this.dWb = -1.0f;
                return;
            }
            if (this.dWc && this.dVT == PlayerStatus.IDLE) {
                aVf();
            }
            this.dWb = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aVh()) {
                this.dVV.hJ(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dVU = UserStatus.STOP;
        if (aVh()) {
            this.dVV.stop();
        }
        aVa();
        wL(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aVa();
        this.dWc = false;
        this.dVU = UserStatus.DESTROY;
        this.dVT = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVa() {
        this.dVT = PlayerStatus.IDLE;
        if (this.dVV != null) {
            this.dVV.destroy();
            this.dVV = null;
        }
        this.dVX.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.dVV != null) {
                return this.dVV.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aVh()) {
            return this.dVV.getCurrentTime();
        }
        return 0;
    }

    public int aVb() {
        return this.dVY;
    }

    public float getVolume() {
        if (this.dVW != null) {
            return this.dVW.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aVh()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.dVV.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aVc() {
        if (this.dVV == null || this.dVV.aVu()) {
            this.dVV = com.baidu.swan.games.audio.b.b.aVq().al(this.dVZ, this.dVW.mLoop);
            registerListener();
        }
        return this.dVV;
    }

    protected void registerListener() {
        if (this.dWa == null) {
            this.dWa = new a();
        }
        this.dVV.setOnPreparedListener(this.dWa);
        this.dVV.setOnCompletionListener(this.dWa);
        this.dVV.setOnInfoListener(this.dWa);
        this.dVV.setOnErrorListener(this.dWa);
        this.dVV.a((MediaPlayer.OnSeekCompleteListener) this.dWa);
        this.dVV.a((MediaPlayer.OnBufferingUpdateListener) this.dWa);
        this.dVV.a(this);
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
        return this.dVW.cBI;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aCJ() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fQ(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null && aJU.aKn() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aXr()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aVq().aVs().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.aCN();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null && aJU.aKn()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null || !aJU.aKn()) {
            return null;
        }
        SwanAppActivity aJO = aJU.aJO();
        if (aJO == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c aif = aJO.aif();
        if (aif instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) aif).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.dVV != null) {
            aVa();
        }
        this.dVU = UserStatus.OPEN;
        this.dVW = dVar;
        this.dVY = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.aCp().aBV().uh(this.dVW.mUrl);
        this.dVT = PlayerStatus.IDLE;
        wL("onWaiting");
        aVd();
    }

    private void aVd() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aVq = com.baidu.swan.games.audio.b.b.aVq();
                File file = new File(aVq.wR(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dVZ = file.getAbsolutePath();
                    aVe();
                } else {
                    aVq.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cS(String str, String str2) {
                            AudioPlayer.this.dVZ = str2;
                            AudioPlayer.this.aVe();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void au(int i, String str) {
                            AudioPlayer.this.wK(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dVZ = this.mDataSource;
                aVe();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVe() {
        aVf();
    }

    private void aVf() {
        try {
            File file = new File(this.dVZ);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aVq().wS(this.dVZ);
                if (0 != this.mDuration) {
                    aVc().setSrc(this.dVZ);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dVZ);
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
        wK("10003");
    }

    public boolean aVg() {
        return (UserStatus.STOP == this.dVU || UserStatus.DESTROY == this.dVU) ? false : true;
    }

    public void play() {
        this.dVU = UserStatus.PLAY;
        if (this.dWc) {
            try {
                if (!asd() && aVi()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dVZ);
                    }
                    if (this.dVT == PlayerStatus.PREPARED) {
                        this.dVX.sendEmptyMessage(0);
                        aCQ();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dVZ);
                        }
                        aVc().play();
                        wL("onPlay");
                    } else if (this.dVT == PlayerStatus.IDLE) {
                        try {
                            aVc().setSrc(this.dVZ);
                            this.dVT = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            wK(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aVh() {
        return this.dVV != null && this.dVT == PlayerStatus.PREPARED;
    }

    private boolean aVi() throws JSONException {
        File file = new File(this.dVZ);
        if (!file.exists() || file.isDirectory()) {
            wK("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.dVW = dVar;
        if (this.dgz != null) {
            this.dgz.qw(this.dVW.dgg);
        }
        aCQ();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.dgz = aVar;
    }

    private boolean asd() {
        if (com.baidu.swan.apps.runtime.e.aJU() == null || !com.baidu.swan.apps.runtime.e.aJU().aKn()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
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
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.dVW.toString());
        }
        setLooping(this.dVW.mLoop);
        setVolume(this.dVW.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aUZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aVq().aVs().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.dVT == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.getCurrentPosition() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.getDuration() / 1000));
                    AudioPlayer.this.l("onTimeUpdate", jSONObject);
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
    /* loaded from: classes25.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.dVT = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.dWc) {
                AudioPlayer.this.wL("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dVZ);
            }
            AudioPlayer.this.dWc = true;
            if (UserStatus.PLAY == AudioPlayer.this.dVU) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.dVW.dWg > 0.0f) {
                    AudioPlayer.this.aVc().seek(AudioPlayer.this.dVW.dWg);
                } else if (AudioPlayer.this.dWb >= 0.0f) {
                    AudioPlayer.this.aVc().seek(AudioPlayer.this.dWb);
                    AudioPlayer.this.dWb = -1.0f;
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
                if (!AudioPlayer.this.dVW.mLoop) {
                    AudioPlayer.this.dVU = UserStatus.STOP;
                    AudioPlayer.this.aVa();
                }
                AudioPlayer.this.wL("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.dVW.dga + " url = " + AudioPlayer.this.dVW.mUrl);
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
            AudioPlayer.this.wK(str);
            AudioPlayer.this.aVa();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.wL("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aVh()) {
                    AudioPlayer.this.dVY = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.dgz != null) {
                        AudioPlayer.this.wL("onBufferingUpdate");
                        if (AudioPlayer.this.dVT == PlayerStatus.PREPARED && AudioPlayer.this.dVU != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.wL("onWaiting");
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
    public void wK(String str) {
        if (this.dgz != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.dgz.g("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(String str) {
        l(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, JSONObject jSONObject) {
        if (this.dgz != null) {
            this.dgz.g(str, jSONObject);
        }
    }
}
