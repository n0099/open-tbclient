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
    protected com.baidu.swan.apps.media.audio.b.a bAX;
    private String bAz;
    private com.baidu.swan.games.audio.b.c cjK;
    private int cjN;
    private String cjO;
    private a cjP;
    private boolean cjR;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cjI = PlayerStatus.NONE;
    protected UserStatus cjJ = UserStatus.OPEN;
    private d cjL = new d();
    private b cjM = new b();
    private float cjQ = -1.0f;
    private TypedCallbackHandler cjS = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.bAz = "";
        this.bAz = str;
    }

    public void pause() {
        this.cjJ = UserStatus.PAUSE;
        Xg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xg() {
        if (als()) {
            this.cjK.pause();
        }
    }

    private void alk() {
        ol(MissionEvent.MESSAGE_PAUSE);
        this.cjM.removeMessages(0);
    }

    public void Z(float f) {
        try {
            ol("onSeeking");
            int i = (int) (1000.0f * f);
            if (als()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cjK.seek(i);
                }
                this.cjQ = -1.0f;
                return;
            }
            if (this.cjR && this.cjI == PlayerStatus.IDLE) {
                alq();
            }
            this.cjQ = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (als()) {
                this.cjK.ez(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cjJ = UserStatus.STOP;
        if (als()) {
            this.cjK.stop();
        }
        all();
        ol(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        all();
        this.cjR = false;
        this.cjJ = UserStatus.DESTROY;
        this.cjI = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void all() {
        this.cjI = PlayerStatus.IDLE;
        if (this.cjK != null) {
            this.cjK.destroy();
            this.cjK = null;
        }
        this.cjM.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cjK != null) {
                return this.cjK.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (als()) {
            return this.cjK.getCurrentTime();
        }
        return 0;
    }

    public int alm() {
        return this.cjN;
    }

    public float getVolume() {
        if (this.cjL != null) {
            return this.cjL.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (als()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cjK.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aln() {
        if (this.cjK == null || this.cjK.alF()) {
            this.cjK = com.baidu.swan.games.audio.b.b.alB().G(this.cjO, this.cjL.mLoop);
            registerListener();
        }
        return this.cjK;
    }

    protected void registerListener() {
        if (this.cjP == null) {
            this.cjP = new a();
        }
        this.cjK.setOnPreparedListener(this.cjP);
        this.cjK.setOnCompletionListener(this.cjP);
        this.cjK.setOnInfoListener(this.cjP);
        this.cjK.setOnErrorListener(this.cjP);
        this.cjK.a((MediaPlayer.OnSeekCompleteListener) this.cjP);
        this.cjK.a((MediaPlayer.OnBufferingUpdateListener) this.cjP);
        this.cjK.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bAz;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cjL.bci;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null && acF.acW() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.anB()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.alB().alD().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.Xg();
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
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null && acF.acW()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF == null || !acF.acW()) {
            return null;
        }
        SwanAppActivity acB = acF.acB();
        if (acB == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c Gv = acB.Gv();
        if (Gv instanceof com.baidu.swan.games.i.b) {
            return ((com.baidu.swan.games.i.b) Gv).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cjK != null) {
            all();
        }
        this.cjJ = UserStatus.OPEN;
        this.cjL = dVar;
        this.cjN = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.WS().Wz().mg(this.cjL.mUrl);
        this.cjI = PlayerStatus.IDLE;
        ol("onWaiting");
        alo();
    }

    private void alo() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b alB = com.baidu.swan.games.audio.b.b.alB();
                File file = new File(alB.os(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cjO = file.getAbsolutePath();
                    alp();
                } else {
                    alB.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void bA(String str, String str2) {
                            AudioPlayer.this.cjO = str2;
                            AudioPlayer.this.alp();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void G(int i, String str) {
                            AudioPlayer.this.ok(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cjO = this.mDataSource;
                alp();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alp() {
        alq();
    }

    private void alq() {
        try {
            File file = new File(this.cjO);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.alB().ot(this.cjO);
                if (0 != this.mDuration) {
                    aln().setSrc(this.cjO);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cjO);
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

    public boolean alr() {
        return (UserStatus.STOP == this.cjJ || UserStatus.DESTROY == this.cjJ) ? false : true;
    }

    public void play() {
        this.cjJ = UserStatus.PLAY;
        if (this.cjR) {
            try {
                if (!OR() && alt()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cjO);
                    }
                    if (this.cjI == PlayerStatus.PREPARED) {
                        this.cjM.sendEmptyMessage(0);
                        Xi();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cjO);
                        }
                        aln().play();
                        ol("onPlay");
                    } else if (this.cjI == PlayerStatus.IDLE) {
                        try {
                            aln().setSrc(this.cjO);
                            this.cjI = PlayerStatus.PREPARING;
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
    public boolean als() {
        return this.cjK != null && this.cjI == PlayerStatus.PREPARED;
    }

    private boolean alt() throws JSONException {
        File file = new File(this.cjO);
        if (!file.exists() || file.isDirectory()) {
            ok("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cjL = dVar;
        if (this.bAX != null) {
            this.bAX.jb(this.cjL.bAE);
        }
        Xi();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bAX = aVar;
    }

    private boolean OR() {
        if (com.baidu.swan.apps.runtime.e.acF() == null || !com.baidu.swan.apps.runtime.e.acF().acW()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b On = GC.On();
        if (On == null || !(On instanceof i)) {
            return true;
        }
        return ((i) On).OR();
    }

    private void Xi() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cjL.toString());
        }
        setLooping(this.cjL.mLoop);
        setVolume(this.cjL.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        alk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.alB().alD().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cjI == PlayerStatus.PREPARED) {
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
            AudioPlayer.this.cjI = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cjR) {
                AudioPlayer.this.ol("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cjO);
            }
            AudioPlayer.this.cjR = true;
            if (UserStatus.PLAY == AudioPlayer.this.cjJ) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cjL.cjV > 0.0f) {
                    AudioPlayer.this.aln().seek(AudioPlayer.this.cjL.cjV);
                } else if (AudioPlayer.this.cjQ >= 0.0f) {
                    AudioPlayer.this.aln().seek(AudioPlayer.this.cjQ);
                    AudioPlayer.this.cjQ = -1.0f;
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
                if (!AudioPlayer.this.cjL.mLoop) {
                    AudioPlayer.this.cjJ = UserStatus.STOP;
                    AudioPlayer.this.all();
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cjL.bAz + " url = " + AudioPlayer.this.cjL.mUrl);
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
            AudioPlayer.this.all();
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
                if (AudioPlayer.this.als()) {
                    AudioPlayer.this.cjN = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bAX != null) {
                        AudioPlayer.this.ol("onBufferingUpdate");
                        if (AudioPlayer.this.cjI == PlayerStatus.PREPARED && AudioPlayer.this.cjJ != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
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
        if (this.bAX != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bAX.d("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(String str) {
        i(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, JSONObject jSONObject) {
        if (this.bAX != null) {
            this.bAX.d(str, jSONObject);
        }
    }
}
