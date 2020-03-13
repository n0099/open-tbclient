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
    private String bAA;
    protected com.baidu.swan.apps.media.audio.b.a bAY;
    private com.baidu.swan.games.audio.b.c cjL;
    private int cjO;
    private String cjP;
    private a cjQ;
    private boolean cjS;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cjJ = PlayerStatus.NONE;
    protected UserStatus cjK = UserStatus.OPEN;
    private d cjM = new d();
    private b cjN = new b();
    private float cjR = -1.0f;
    private TypedCallbackHandler cjT = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.bAA = "";
        this.bAA = str;
    }

    public void pause() {
        this.cjK = UserStatus.PAUSE;
        Xg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xg() {
        if (als()) {
            this.cjL.pause();
        }
    }

    private void alk() {
        ol(MissionEvent.MESSAGE_PAUSE);
        this.cjN.removeMessages(0);
    }

    public void Z(float f) {
        try {
            ol("onSeeking");
            int i = (int) (1000.0f * f);
            if (als()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cjL.seek(i);
                }
                this.cjR = -1.0f;
                return;
            }
            if (this.cjS && this.cjJ == PlayerStatus.IDLE) {
                alq();
            }
            this.cjR = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (als()) {
                this.cjL.ez(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cjK = UserStatus.STOP;
        if (als()) {
            this.cjL.stop();
        }
        all();
        ol(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        all();
        this.cjS = false;
        this.cjK = UserStatus.DESTROY;
        this.cjJ = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void all() {
        this.cjJ = PlayerStatus.IDLE;
        if (this.cjL != null) {
            this.cjL.destroy();
            this.cjL = null;
        }
        this.cjN.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cjL != null) {
                return this.cjL.getDuration();
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
            return this.cjL.getCurrentTime();
        }
        return 0;
    }

    public int alm() {
        return this.cjO;
    }

    public float getVolume() {
        if (this.cjM != null) {
            return this.cjM.mVolume;
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
                this.cjL.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aln() {
        if (this.cjL == null || this.cjL.alF()) {
            this.cjL = com.baidu.swan.games.audio.b.b.alB().G(this.cjP, this.cjM.mLoop);
            registerListener();
        }
        return this.cjL;
    }

    protected void registerListener() {
        if (this.cjQ == null) {
            this.cjQ = new a();
        }
        this.cjL.setOnPreparedListener(this.cjQ);
        this.cjL.setOnCompletionListener(this.cjQ);
        this.cjL.setOnInfoListener(this.cjQ);
        this.cjL.setOnErrorListener(this.cjQ);
        this.cjL.a((MediaPlayer.OnSeekCompleteListener) this.cjQ);
        this.cjL.a((MediaPlayer.OnBufferingUpdateListener) this.cjQ);
        this.cjL.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bAA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cjM.bcj;
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
        if (this.cjL != null) {
            all();
        }
        this.cjK = UserStatus.OPEN;
        this.cjM = dVar;
        this.cjO = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.WS().Wz().mg(this.cjM.mUrl);
        this.cjJ = PlayerStatus.IDLE;
        ol("onWaiting");
        alo();
    }

    private void alo() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b alB = com.baidu.swan.games.audio.b.b.alB();
                File file = new File(alB.os(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cjP = file.getAbsolutePath();
                    alp();
                } else {
                    alB.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void bA(String str, String str2) {
                            AudioPlayer.this.cjP = str2;
                            AudioPlayer.this.alp();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void G(int i, String str) {
                            AudioPlayer.this.ok(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cjP = this.mDataSource;
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
            File file = new File(this.cjP);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.alB().ot(this.cjP);
                if (0 != this.mDuration) {
                    aln().setSrc(this.cjP);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cjP);
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
        return (UserStatus.STOP == this.cjK || UserStatus.DESTROY == this.cjK) ? false : true;
    }

    public void play() {
        this.cjK = UserStatus.PLAY;
        if (this.cjS) {
            try {
                if (!OR() && alt()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cjP);
                    }
                    if (this.cjJ == PlayerStatus.PREPARED) {
                        this.cjN.sendEmptyMessage(0);
                        Xi();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cjP);
                        }
                        aln().play();
                        ol("onPlay");
                    } else if (this.cjJ == PlayerStatus.IDLE) {
                        try {
                            aln().setSrc(this.cjP);
                            this.cjJ = PlayerStatus.PREPARING;
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
        return this.cjL != null && this.cjJ == PlayerStatus.PREPARED;
    }

    private boolean alt() throws JSONException {
        File file = new File(this.cjP);
        if (!file.exists() || file.isDirectory()) {
            ok("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cjM = dVar;
        if (this.bAY != null) {
            this.bAY.jb(this.cjM.bAF);
        }
        Xi();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bAY = aVar;
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
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cjM.toString());
        }
        setLooping(this.cjM.mLoop);
        setVolume(this.cjM.mVolume);
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
            if (message.what == 0 && AudioPlayer.this.cjJ == PlayerStatus.PREPARED) {
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
            AudioPlayer.this.cjJ = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cjS) {
                AudioPlayer.this.ol("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cjP);
            }
            AudioPlayer.this.cjS = true;
            if (UserStatus.PLAY == AudioPlayer.this.cjK) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cjM.cjW > 0.0f) {
                    AudioPlayer.this.aln().seek(AudioPlayer.this.cjM.cjW);
                } else if (AudioPlayer.this.cjR >= 0.0f) {
                    AudioPlayer.this.aln().seek(AudioPlayer.this.cjR);
                    AudioPlayer.this.cjR = -1.0f;
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
                if (!AudioPlayer.this.cjM.mLoop) {
                    AudioPlayer.this.cjK = UserStatus.STOP;
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cjM.bAA + " url = " + AudioPlayer.this.cjM.mUrl);
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
                    AudioPlayer.this.cjO = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bAY != null) {
                        AudioPlayer.this.ol("onBufferingUpdate");
                        if (AudioPlayer.this.cjJ == PlayerStatus.PREPARED && AudioPlayer.this.cjK != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
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
        if (this.bAY != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bAY.d("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(String str) {
        i(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, JSONObject jSONObject) {
        if (this.bAY != null) {
            this.bAY.d(str, jSONObject);
        }
    }
}
