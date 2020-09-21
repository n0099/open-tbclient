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
/* loaded from: classes3.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.media.audio.b.a cAO;
    private String cAp;
    private com.baidu.swan.games.audio.b.c dqm;
    private int dqp;
    private String dqq;
    private a dqr;
    private boolean dqt;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus dqk = PlayerStatus.NONE;
    protected UserStatus dql = UserStatus.OPEN;
    private d dqn = new d();
    private b dqo = new b();
    private float dqs = -1.0f;
    private TypedCallbackHandler dqu = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes3.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.cAp = "";
        this.cAp = str;
    }

    public void pause() {
        this.dql = UserStatus.PAUSE;
        ath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ath() {
        if (aLH()) {
            this.dqm.pause();
        }
    }

    private void aLz() {
        uQ(MissionEvent.MESSAGE_PAUSE);
        this.dqo.removeMessages(0);
    }

    public void P(float f) {
        try {
            uQ("onSeeking");
            int i = (int) (1000.0f * f);
            if (aLH()) {
                if (i >= 0 && i <= getDuration()) {
                    this.dqm.seek(i);
                }
                this.dqs = -1.0f;
                return;
            }
            if (this.dqt && this.dqk == PlayerStatus.IDLE) {
                aLF();
            }
            this.dqs = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aLH()) {
                this.dqm.gz(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dql = UserStatus.STOP;
        if (aLH()) {
            this.dqm.stop();
        }
        aLA();
        uQ(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aLA();
        this.dqt = false;
        this.dql = UserStatus.DESTROY;
        this.dqk = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLA() {
        this.dqk = PlayerStatus.IDLE;
        if (this.dqm != null) {
            this.dqm.destroy();
            this.dqm = null;
        }
        this.dqo.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.dqm != null) {
                return this.dqm.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aLH()) {
            return this.dqm.getCurrentTime();
        }
        return 0;
    }

    public int aLB() {
        return this.dqp;
    }

    public float getVolume() {
        if (this.dqn != null) {
            return this.dqn.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aLH()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.dqm.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aLC() {
        if (this.dqm == null || this.dqm.aLU()) {
            this.dqm = com.baidu.swan.games.audio.b.b.aLQ().ae(this.dqq, this.dqn.mLoop);
            registerListener();
        }
        return this.dqm;
    }

    protected void registerListener() {
        if (this.dqr == null) {
            this.dqr = new a();
        }
        this.dqm.setOnPreparedListener(this.dqr);
        this.dqm.setOnCompletionListener(this.dqr);
        this.dqm.setOnInfoListener(this.dqr);
        this.dqm.setOnErrorListener(this.dqr);
        this.dqm.a((MediaPlayer.OnSeekCompleteListener) this.dqr);
        this.dqm.a((MediaPlayer.OnBufferingUpdateListener) this.dqr);
        this.dqm.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String aoZ() {
        return this.cAp;
    }

    @Override // com.baidu.swan.apps.media.a
    public String atc() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dqn.bVN;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object atd() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eG(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && aAr.aAK() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aNR()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aLQ().aLS().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.ath();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && aAr.aAK()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null || !aAr.aAK()) {
            return null;
        }
        SwanAppActivity aAl = aAr.aAl();
        if (aAl == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c Yz = aAl.Yz();
        if (Yz instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) Yz).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.dqm != null) {
            aLA();
        }
        this.dql = UserStatus.OPEN;
        this.dqn = dVar;
        this.dqp = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.asJ().asp().sl(this.dqn.mUrl);
        this.dqk = PlayerStatus.IDLE;
        uQ("onWaiting");
        aLD();
    }

    private void aLD() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aLQ = com.baidu.swan.games.audio.b.b.aLQ();
                File file = new File(aLQ.uW(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dqq = file.getAbsolutePath();
                    aLE();
                } else {
                    aLQ.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cA(String str, String str2) {
                            AudioPlayer.this.dqq = str2;
                            AudioPlayer.this.aLE();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ad(int i, String str) {
                            AudioPlayer.this.uP(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dqq = this.mDataSource;
                aLE();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLE() {
        aLF();
    }

    private void aLF() {
        try {
            File file = new File(this.dqq);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aLQ().uX(this.dqq);
                if (0 != this.mDuration) {
                    aLC().setSrc(this.dqq);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dqq);
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
        uP("10003");
    }

    public boolean aLG() {
        return (UserStatus.STOP == this.dql || UserStatus.DESTROY == this.dql) ? false : true;
    }

    public void play() {
        this.dql = UserStatus.PLAY;
        if (this.dqt) {
            try {
                if (!aiy() && aLI()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dqq);
                    }
                    if (this.dqk == PlayerStatus.PREPARED) {
                        this.dqo.sendEmptyMessage(0);
                        atk();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dqq);
                        }
                        aLC().play();
                        uQ("onPlay");
                    } else if (this.dqk == PlayerStatus.IDLE) {
                        try {
                            aLC().setSrc(this.dqq);
                            this.dqk = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            uP(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aLH() {
        return this.dqm != null && this.dqk == PlayerStatus.PREPARED;
    }

    private boolean aLI() throws JSONException {
        File file = new File(this.dqq);
        if (!file.exists() || file.isDirectory()) {
            uP("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.dqn = dVar;
        if (this.cAO != null) {
            this.cAO.oC(this.dqn.cAv);
        }
        atk();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cAO = aVar;
    }

    private boolean aiy() {
        if (com.baidu.swan.apps.runtime.e.aAr() == null || !com.baidu.swan.apps.runtime.e.aAr().aAK()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c ahW = YG.ahW();
        if (ahW == null || !(ahW instanceof j)) {
            return true;
        }
        return ((j) ahW).aiy();
    }

    private void atk() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.dqn.toString());
        }
        setLooping(this.dqn.mLoop);
        setVolume(this.dqn.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aLz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aLQ().aLS().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.dqk == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.getCurrentPosition() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.getDuration() / 1000));
                    AudioPlayer.this.j("onTimeUpdate", jSONObject);
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
    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.dqk = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.dqt) {
                AudioPlayer.this.uQ("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dqq);
            }
            AudioPlayer.this.dqt = true;
            if (UserStatus.PLAY == AudioPlayer.this.dql) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.dqn.dqx > 0.0f) {
                    AudioPlayer.this.aLC().seek(AudioPlayer.this.dqn.dqx);
                } else if (AudioPlayer.this.dqs >= 0.0f) {
                    AudioPlayer.this.aLC().seek(AudioPlayer.this.dqs);
                    AudioPlayer.this.dqs = -1.0f;
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
                if (!AudioPlayer.this.dqn.mLoop) {
                    AudioPlayer.this.dql = UserStatus.STOP;
                    AudioPlayer.this.aLA();
                }
                AudioPlayer.this.uQ("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.dqn.cAp + " url = " + AudioPlayer.this.dqn.mUrl);
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
            AudioPlayer.this.uP(str);
            AudioPlayer.this.aLA();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.uQ("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aLH()) {
                    AudioPlayer.this.dqp = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cAO != null) {
                        AudioPlayer.this.uQ("onBufferingUpdate");
                        if (AudioPlayer.this.dqk == PlayerStatus.PREPARED && AudioPlayer.this.dql != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.uQ("onWaiting");
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
    public void uP(String str) {
        if (this.cAO != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cAO.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.cAO != null) {
            this.cAO.e(str, jSONObject);
        }
    }
}
