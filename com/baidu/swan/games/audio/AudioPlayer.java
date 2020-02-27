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
/* loaded from: classes11.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.media.audio.b.a bAW;
    private String bAy;
    private com.baidu.swan.games.audio.b.c cjJ;
    private int cjM;
    private String cjN;
    private a cjO;
    private boolean cjQ;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cjH = PlayerStatus.NONE;
    protected UserStatus cjI = UserStatus.OPEN;
    private d cjK = new d();
    private b cjL = new b();
    private float cjP = -1.0f;
    private TypedCallbackHandler cjR = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes11.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.bAy = "";
        this.bAy = str;
    }

    public void pause() {
        this.cjI = UserStatus.PAUSE;
        Xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xe() {
        if (alq()) {
            this.cjJ.pause();
        }
    }

    private void ali() {
        ol(MissionEvent.MESSAGE_PAUSE);
        this.cjL.removeMessages(0);
    }

    public void Z(float f) {
        try {
            ol("onSeeking");
            int i = (int) (1000.0f * f);
            if (alq()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cjJ.seek(i);
                }
                this.cjP = -1.0f;
                return;
            }
            if (this.cjQ && this.cjH == PlayerStatus.IDLE) {
                alo();
            }
            this.cjP = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (alq()) {
                this.cjJ.ez(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cjI = UserStatus.STOP;
        if (alq()) {
            this.cjJ.stop();
        }
        alj();
        ol(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        alj();
        this.cjQ = false;
        this.cjI = UserStatus.DESTROY;
        this.cjH = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        this.cjH = PlayerStatus.IDLE;
        if (this.cjJ != null) {
            this.cjJ.destroy();
            this.cjJ = null;
        }
        this.cjL.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cjJ != null) {
                return this.cjJ.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (alq()) {
            return this.cjJ.getCurrentTime();
        }
        return 0;
    }

    public int alk() {
        return this.cjM;
    }

    public float getVolume() {
        if (this.cjK != null) {
            return this.cjK.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (alq()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cjJ.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c all() {
        if (this.cjJ == null || this.cjJ.alD()) {
            this.cjJ = com.baidu.swan.games.audio.b.b.alz().G(this.cjN, this.cjK.mLoop);
            registerListener();
        }
        return this.cjJ;
    }

    protected void registerListener() {
        if (this.cjO == null) {
            this.cjO = new a();
        }
        this.cjJ.setOnPreparedListener(this.cjO);
        this.cjJ.setOnCompletionListener(this.cjO);
        this.cjJ.setOnInfoListener(this.cjO);
        this.cjJ.setOnErrorListener(this.cjO);
        this.cjJ.a((MediaPlayer.OnSeekCompleteListener) this.cjO);
        this.cjJ.a((MediaPlayer.OnBufferingUpdateListener) this.cjO);
        this.cjJ.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String WY() {
        return this.bAy;
    }

    @Override // com.baidu.swan.apps.media.a
    public String WZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cjK.bch;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null && acD.acU() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.anz()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.alz().alB().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.Xe();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null && acD.acU()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD == null || !acD.acU()) {
            return null;
        }
        SwanAppActivity acz = acD.acz();
        if (acz == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c Gt = acz.Gt();
        if (Gt instanceof com.baidu.swan.games.i.b) {
            return ((com.baidu.swan.games.i.b) Gt).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cjJ != null) {
            alj();
        }
        this.cjI = UserStatus.OPEN;
        this.cjK = dVar;
        this.cjM = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.WQ().Wx().mg(this.cjK.mUrl);
        this.cjH = PlayerStatus.IDLE;
        ol("onWaiting");
        alm();
    }

    private void alm() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b alz = com.baidu.swan.games.audio.b.b.alz();
                File file = new File(alz.os(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cjN = file.getAbsolutePath();
                    aln();
                } else {
                    alz.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void bA(String str, String str2) {
                            AudioPlayer.this.cjN = str2;
                            AudioPlayer.this.aln();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void G(int i, String str) {
                            AudioPlayer.this.ok(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cjN = this.mDataSource;
                aln();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aln() {
        alo();
    }

    private void alo() {
        try {
            File file = new File(this.cjN);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.alz().ot(this.cjN);
                if (0 != this.mDuration) {
                    all().setSrc(this.cjN);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cjN);
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
        ok("10003");
    }

    public boolean alp() {
        return (UserStatus.STOP == this.cjI || UserStatus.DESTROY == this.cjI) ? false : true;
    }

    public void play() {
        this.cjI = UserStatus.PLAY;
        if (this.cjQ) {
            try {
                if (!OP() && alr()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cjN);
                    }
                    if (this.cjH == PlayerStatus.PREPARED) {
                        this.cjL.sendEmptyMessage(0);
                        Xg();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cjN);
                        }
                        all().play();
                        ol("onPlay");
                    } else if (this.cjH == PlayerStatus.IDLE) {
                        try {
                            all().setSrc(this.cjN);
                            this.cjH = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            ok(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean alq() {
        return this.cjJ != null && this.cjH == PlayerStatus.PREPARED;
    }

    private boolean alr() throws JSONException {
        File file = new File(this.cjN);
        if (!file.exists() || file.isDirectory()) {
            ok("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cjK = dVar;
        if (this.bAW != null) {
            this.bAW.jb(this.cjK.bAD);
        }
        Xg();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bAW = aVar;
    }

    private boolean OP() {
        if (com.baidu.swan.apps.runtime.e.acD() == null || !com.baidu.swan.apps.runtime.e.acD().acU()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
        if (GA == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Ol = GA.Ol();
        if (Ol == null || !(Ol instanceof i)) {
            return true;
        }
        return ((i) Ol).OP();
    }

    private void Xg() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cjK.toString());
        }
        setLooping(this.cjK.mLoop);
        setVolume(this.cjK.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        ali();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.alz().alB().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cjH == PlayerStatus.PREPARED) {
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
    /* loaded from: classes11.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.cjH = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cjQ) {
                AudioPlayer.this.ol("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cjN);
            }
            AudioPlayer.this.cjQ = true;
            if (UserStatus.PLAY == AudioPlayer.this.cjI) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cjK.cjU > 0.0f) {
                    AudioPlayer.this.all().seek(AudioPlayer.this.cjK.cjU);
                } else if (AudioPlayer.this.cjP >= 0.0f) {
                    AudioPlayer.this.all().seek(AudioPlayer.this.cjP);
                    AudioPlayer.this.cjP = -1.0f;
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
                if (!AudioPlayer.this.cjK.mLoop) {
                    AudioPlayer.this.cjI = UserStatus.STOP;
                    AudioPlayer.this.alj();
                }
                AudioPlayer.this.ol("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cjK.bAy + " url = " + AudioPlayer.this.cjK.mUrl);
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
            AudioPlayer.this.ok(str);
            AudioPlayer.this.alj();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.ol("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.alq()) {
                    AudioPlayer.this.cjM = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bAW != null) {
                        AudioPlayer.this.ol("onBufferingUpdate");
                        if (AudioPlayer.this.cjH == PlayerStatus.PREPARED && AudioPlayer.this.cjI != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.ol("onWaiting");
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
    public void ok(String str) {
        if (this.bAW != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bAW.d("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(String str) {
        i(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, JSONObject jSONObject) {
        if (this.bAW != null) {
            this.bAW.d(str, jSONObject);
        }
    }
}
