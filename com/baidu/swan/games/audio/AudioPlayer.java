package com.baidu.swan.games.audio;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.File;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bvC;
    protected com.baidu.swan.apps.media.audio.b.a bwb;
    private com.baidu.swan.games.audio.b.c cfs;
    private int cfv;
    private String cfw;
    private a cfx;
    private boolean cfz;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cfq = PlayerStatus.NONE;
    protected UserStatus cfr = UserStatus.OPEN;
    private d cft = new d();
    private b cfu = new b();
    private float cfy = -1.0f;
    private TypedCallbackHandler cfA = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.bvC = "";
        this.bvC = str;
    }

    public void pause() {
        this.cfr = UserStatus.PAUSE;
        Ut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ut() {
        if (aiJ()) {
            this.cfs.pause();
        }
    }

    private void aiB() {
        nS(MissionEvent.MESSAGE_PAUSE);
        this.cfu.removeMessages(0);
    }

    public void ab(float f) {
        try {
            nS("onSeeking");
            int i = (int) (1000.0f * f);
            if (aiJ()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cfs.seek(i);
                }
                this.cfy = -1.0f;
                return;
            }
            if (this.cfz && this.cfq == PlayerStatus.IDLE) {
                aiH();
            }
            this.cfy = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aiJ()) {
                this.cfs.en(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cfr = UserStatus.STOP;
        if (aiJ()) {
            this.cfs.stop();
        }
        aiC();
        nS(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aiC();
        this.cfz = false;
        this.cfr = UserStatus.DESTROY;
        this.cfq = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        this.cfq = PlayerStatus.IDLE;
        if (this.cfs != null) {
            this.cfs.destroy();
            this.cfs = null;
        }
        this.cfu.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cfs != null) {
                return this.cfs.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aiJ()) {
            return this.cfs.getCurrentTime();
        }
        return 0;
    }

    public int aiD() {
        return this.cfv;
    }

    public float getVolume() {
        if (this.cft != null) {
            return this.cft.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aiJ()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cfs.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aiE() {
        if (this.cfs == null || this.cfs.aiW()) {
            this.cfs = com.baidu.swan.games.audio.b.b.aiS().G(this.cfw, this.cft.bvL);
            registerListener();
        }
        return this.cfs;
    }

    protected void registerListener() {
        if (this.cfx == null) {
            this.cfx = new a();
        }
        this.cfs.setOnPreparedListener(this.cfx);
        this.cfs.setOnCompletionListener(this.cfx);
        this.cfs.setOnInfoListener(this.cfx);
        this.cfs.setOnErrorListener(this.cfx);
        this.cfs.a((MediaPlayer.OnSeekCompleteListener) this.cfx);
        this.cfs.a((MediaPlayer.OnBufferingUpdateListener) this.cfx);
        this.cfs.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Un() {
        return this.bvC;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Uo() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cft.aXf;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Up() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cE(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null && ZS.aaj() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.akT()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aiS().aiU().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.Ut();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cF(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null && ZS.aaj()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS == null || !ZS.aaj()) {
            return null;
        }
        SwanAppActivity ZO = ZS.ZO();
        if (ZO == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c DI = ZO.DI();
        if (DI instanceof com.baidu.swan.games.i.b) {
            return ((com.baidu.swan.games.i.b) DI).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cfs != null) {
            aiC();
        }
        this.cfr = UserStatus.OPEN;
        this.cft = dVar;
        this.cfv = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.Uf().TM().lO(this.cft.mUrl);
        this.cfq = PlayerStatus.IDLE;
        nS("onWaiting");
        aiF();
    }

    private void aiF() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aiS = com.baidu.swan.games.audio.b.b.aiS();
                File file = new File(aiS.nY(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cfw = file.getAbsolutePath();
                    aiG();
                } else {
                    aiS.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void bq(String str, String str2) {
                            AudioPlayer.this.cfw = str2;
                            AudioPlayer.this.aiG();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void C(int i, String str) {
                            AudioPlayer.this.nR(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cfw = this.mDataSource;
                aiG();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiG() {
        aiH();
    }

    private void aiH() {
        try {
            File file = new File(this.cfw);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aiS().nZ(this.cfw);
                if (0 != this.mDuration) {
                    aiE().setSrc(this.cfw);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cfw);
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
        nR("10003");
    }

    public boolean aiI() {
        return (UserStatus.STOP == this.cfr || UserStatus.DESTROY == this.cfr) ? false : true;
    }

    public void play() {
        this.cfr = UserStatus.PLAY;
        if (this.cfz) {
            try {
                if (!Mf() && aiK()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cfw);
                    }
                    if (this.cfq == PlayerStatus.PREPARED) {
                        this.cfu.sendEmptyMessage(0);
                        Uv();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cfw);
                        }
                        aiE().play();
                        nS("onPlay");
                    } else if (this.cfq == PlayerStatus.IDLE) {
                        try {
                            aiE().setSrc(this.cfw);
                            this.cfq = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            nR(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aiJ() {
        return this.cfs != null && this.cfq == PlayerStatus.PREPARED;
    }

    private boolean aiK() throws JSONException {
        File file = new File(this.cfw);
        if (!file.exists() || file.isDirectory()) {
            nR("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cft = dVar;
        if (this.bwb != null) {
            this.bwb.iJ(this.cft.bvH);
        }
        Uv();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bwb = aVar;
    }

    private boolean Mf() {
        if (com.baidu.swan.apps.runtime.e.ZS() == null || !com.baidu.swan.apps.runtime.e.ZS().aaj()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b LB = DP.LB();
        if (LB == null || !(LB instanceof i)) {
            return true;
        }
        return ((i) LB).Mf();
    }

    private void Uv() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cft.toString());
        }
        setLooping(this.cft.bvL);
        setVolume(this.cft.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aiB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aiS().aiU().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cfq == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.getCurrentPosition() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.getDuration() / 1000));
                    AudioPlayer.this.i("onTimeUpdate", jSONObject);
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
            AudioPlayer.this.cfq = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cfz) {
                AudioPlayer.this.nS("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cfw);
            }
            AudioPlayer.this.cfz = true;
            if (UserStatus.PLAY == AudioPlayer.this.cfr) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cft.cfD > 0.0f) {
                    AudioPlayer.this.aiE().seek(AudioPlayer.this.cft.cfD);
                } else if (AudioPlayer.this.cfy >= 0.0f) {
                    AudioPlayer.this.aiE().seek(AudioPlayer.this.cfy);
                    AudioPlayer.this.cfy = -1.0f;
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
                if (!AudioPlayer.this.cft.bvL) {
                    AudioPlayer.this.cfr = UserStatus.STOP;
                    AudioPlayer.this.aiC();
                }
                AudioPlayer.this.nS("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cft.bvC + " url = " + AudioPlayer.this.cft.mUrl);
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
            AudioPlayer.this.nR(str);
            AudioPlayer.this.aiC();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.nS("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aiJ()) {
                    AudioPlayer.this.cfv = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bwb != null) {
                        AudioPlayer.this.nS("onBufferingUpdate");
                        if (AudioPlayer.this.cfq == PlayerStatus.PREPARED && AudioPlayer.this.cfr != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.nS("onWaiting");
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
    public void nR(String str) {
        if (this.bwb != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bwb.d("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nS(String str) {
        i(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, JSONObject jSONObject) {
        if (this.bwb != null) {
            this.bwb.d(str, jSONObject);
        }
    }
}
