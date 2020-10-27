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
/* loaded from: classes10.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cUQ;
    protected com.baidu.swan.apps.media.audio.b.a cVp;
    private com.baidu.swan.games.audio.b.c dKN;
    private int dKQ;
    private String dKR;
    private a dKS;
    private boolean dKU;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus dKL = PlayerStatus.NONE;
    protected UserStatus dKM = UserStatus.OPEN;
    private d dKO = new d();
    private b dKP = new b();
    private float dKT = -1.0f;
    private TypedCallbackHandler dKV = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes10.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.cUQ = "";
        this.cUQ = str;
    }

    public void pause() {
        this.dKM = UserStatus.PAUSE;
        axM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axM() {
        if (aQk()) {
            this.dKN.pause();
        }
    }

    private void aQc() {
        vV(MissionEvent.MESSAGE_PAUSE);
        this.dKP.removeMessages(0);
    }

    public void T(float f) {
        try {
            vV("onSeeking");
            int i = (int) (1000.0f * f);
            if (aQk()) {
                if (i >= 0 && i <= getDuration()) {
                    this.dKN.seek(i);
                }
                this.dKT = -1.0f;
                return;
            }
            if (this.dKU && this.dKL == PlayerStatus.IDLE) {
                aQi();
            }
            this.dKT = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aQk()) {
                this.dKN.hi(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dKM = UserStatus.STOP;
        if (aQk()) {
            this.dKN.stop();
        }
        aQd();
        vV(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aQd();
        this.dKU = false;
        this.dKM = UserStatus.DESTROY;
        this.dKL = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQd() {
        this.dKL = PlayerStatus.IDLE;
        if (this.dKN != null) {
            this.dKN.destroy();
            this.dKN = null;
        }
        this.dKP.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.dKN != null) {
                return this.dKN.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aQk()) {
            return this.dKN.getCurrentTime();
        }
        return 0;
    }

    public int aQe() {
        return this.dKQ;
    }

    public float getVolume() {
        if (this.dKO != null) {
            return this.dKO.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aQk()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.dKN.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aQf() {
        if (this.dKN == null || this.dKN.aQx()) {
            this.dKN = com.baidu.swan.games.audio.b.b.aQt().ak(this.dKR, this.dKO.mLoop);
            registerListener();
        }
        return this.dKN;
    }

    protected void registerListener() {
        if (this.dKS == null) {
            this.dKS = new a();
        }
        this.dKN.setOnPreparedListener(this.dKS);
        this.dKN.setOnCompletionListener(this.dKS);
        this.dKN.setOnInfoListener(this.dKS);
        this.dKN.setOnErrorListener(this.dKS);
        this.dKN.a((MediaPlayer.OnSeekCompleteListener) this.dKS);
        this.dKN.a((MediaPlayer.OnBufferingUpdateListener) this.dKS);
        this.dKN.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String atG() {
        return this.cUQ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String axH() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dKO.cqC;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object axI() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fp(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null && aEU.aFn() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aSu()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aQt().aQv().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.axM();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fq(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null && aEU.aFn()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU == null || !aEU.aFn()) {
            return null;
        }
        SwanAppActivity aEO = aEU.aEO();
        if (aEO == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c adf = aEO.adf();
        if (adf instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) adf).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.dKN != null) {
            aQd();
        }
        this.dKM = UserStatus.OPEN;
        this.dKO = dVar;
        this.dKQ = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.axo().awU().tr(this.dKO.mUrl);
        this.dKL = PlayerStatus.IDLE;
        vV("onWaiting");
        aQg();
    }

    private void aQg() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aQt = com.baidu.swan.games.audio.b.b.aQt();
                File file = new File(aQt.wb(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dKR = file.getAbsolutePath();
                    aQh();
                } else {
                    aQt.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cM(String str, String str2) {
                            AudioPlayer.this.dKR = str2;
                            AudioPlayer.this.aQh();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void aq(int i, String str) {
                            AudioPlayer.this.vU(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dKR = this.mDataSource;
                aQh();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQh() {
        aQi();
    }

    private void aQi() {
        try {
            File file = new File(this.dKR);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aQt().wc(this.dKR);
                if (0 != this.mDuration) {
                    aQf().setSrc(this.dKR);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dKR);
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
        vU("10003");
    }

    public boolean aQj() {
        return (UserStatus.STOP == this.dKM || UserStatus.DESTROY == this.dKM) ? false : true;
    }

    public void play() {
        this.dKM = UserStatus.PLAY;
        if (this.dKU) {
            try {
                if (!and() && aQl()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dKR);
                    }
                    if (this.dKL == PlayerStatus.PREPARED) {
                        this.dKP.sendEmptyMessage(0);
                        axP();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dKR);
                        }
                        aQf().play();
                        vV("onPlay");
                    } else if (this.dKL == PlayerStatus.IDLE) {
                        try {
                            aQf().setSrc(this.dKR);
                            this.dKL = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            vU(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aQk() {
        return this.dKN != null && this.dKL == PlayerStatus.PREPARED;
    }

    private boolean aQl() throws JSONException {
        File file = new File(this.dKR);
        if (!file.exists() || file.isDirectory()) {
            vU("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.dKO = dVar;
        if (this.cVp != null) {
            this.cVp.pH(this.dKO.cUW);
        }
        axP();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cVp = aVar;
    }

    private boolean and() {
        if (com.baidu.swan.apps.runtime.e.aEU() == null || !com.baidu.swan.apps.runtime.e.aEU().aFn()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c amB = adm.amB();
        if (amB == null || !(amB instanceof j)) {
            return true;
        }
        return ((j) amB).and();
    }

    private void axP() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.dKO.toString());
        }
        setLooping(this.dKO.mLoop);
        setVolume(this.dKO.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aQc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aQt().aQv().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.dKL == PlayerStatus.PREPARED) {
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
    /* loaded from: classes10.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.dKL = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.dKU) {
                AudioPlayer.this.vV("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dKR);
            }
            AudioPlayer.this.dKU = true;
            if (UserStatus.PLAY == AudioPlayer.this.dKM) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.dKO.dKY > 0.0f) {
                    AudioPlayer.this.aQf().seek(AudioPlayer.this.dKO.dKY);
                } else if (AudioPlayer.this.dKT >= 0.0f) {
                    AudioPlayer.this.aQf().seek(AudioPlayer.this.dKT);
                    AudioPlayer.this.dKT = -1.0f;
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
                if (!AudioPlayer.this.dKO.mLoop) {
                    AudioPlayer.this.dKM = UserStatus.STOP;
                    AudioPlayer.this.aQd();
                }
                AudioPlayer.this.vV("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.dKO.cUQ + " url = " + AudioPlayer.this.dKO.mUrl);
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
            AudioPlayer.this.vU(str);
            AudioPlayer.this.aQd();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.vV("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aQk()) {
                    AudioPlayer.this.dKQ = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cVp != null) {
                        AudioPlayer.this.vV("onBufferingUpdate");
                        if (AudioPlayer.this.dKL == PlayerStatus.PREPARED && AudioPlayer.this.dKM != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.vV("onWaiting");
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
    public void vU(String str) {
        if (this.cVp != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cVp.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.cVp != null) {
            this.cVp.e(str, jSONObject);
        }
    }
}
