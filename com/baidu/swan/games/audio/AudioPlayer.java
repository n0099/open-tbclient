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
    private com.baidu.swan.games.audio.b.c dQF;
    private int dQI;
    private String dQJ;
    private a dQK;
    private boolean dQM;
    private String daK;
    protected com.baidu.swan.apps.media.audio.b.a dbj;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus dQD = PlayerStatus.NONE;
    protected UserStatus dQE = UserStatus.OPEN;
    private d dQG = new d();
    private b dQH = new b();
    private float dQL = -1.0f;
    private TypedCallbackHandler dQN = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.daK = "";
        this.daK = str;
    }

    public void pause() {
        this.dQE = UserStatus.PAUSE;
        aAm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAm() {
        if (aSK()) {
            this.dQF.pause();
        }
    }

    private void aSC() {
        wj(MissionEvent.MESSAGE_PAUSE);
        this.dQH.removeMessages(0);
    }

    public void V(float f) {
        try {
            wj("onSeeking");
            int i = (int) (1000.0f * f);
            if (aSK()) {
                if (i >= 0 && i <= getDuration()) {
                    this.dQF.seek(i);
                }
                this.dQL = -1.0f;
                return;
            }
            if (this.dQM && this.dQD == PlayerStatus.IDLE) {
                aSI();
            }
            this.dQL = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aSK()) {
                this.dQF.hr(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dQE = UserStatus.STOP;
        if (aSK()) {
            this.dQF.stop();
        }
        aSD();
        wj(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aSD();
        this.dQM = false;
        this.dQE = UserStatus.DESTROY;
        this.dQD = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSD() {
        this.dQD = PlayerStatus.IDLE;
        if (this.dQF != null) {
            this.dQF.destroy();
            this.dQF = null;
        }
        this.dQH.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.dQF != null) {
                return this.dQF.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aSK()) {
            return this.dQF.getCurrentTime();
        }
        return 0;
    }

    public int aSE() {
        return this.dQI;
    }

    public float getVolume() {
        if (this.dQG != null) {
            return this.dQG.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aSK()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.dQF.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aSF() {
        if (this.dQF == null || this.dQF.aSX()) {
            this.dQF = com.baidu.swan.games.audio.b.b.aST().ak(this.dQJ, this.dQG.mLoop);
            registerListener();
        }
        return this.dQF;
    }

    protected void registerListener() {
        if (this.dQK == null) {
            this.dQK = new a();
        }
        this.dQF.setOnPreparedListener(this.dQK);
        this.dQF.setOnCompletionListener(this.dQK);
        this.dQF.setOnInfoListener(this.dQK);
        this.dQF.setOnErrorListener(this.dQK);
        this.dQF.a((MediaPlayer.OnSeekCompleteListener) this.dQK);
        this.dQF.a((MediaPlayer.OnBufferingUpdateListener) this.dQK);
        this.dQF.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String awg() {
        return this.daK;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAh() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dQG.cwA;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAi() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fy(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && aHu.aHN() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aUU()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aST().aSV().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.aAm();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fz(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && aHu.aHN()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu == null || !aHu.aHN()) {
            return null;
        }
        SwanAppActivity aHo = aHu.aHo();
        if (aHo == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c afF = aHo.afF();
        if (afF instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) afF).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.dQF != null) {
            aSD();
        }
        this.dQE = UserStatus.OPEN;
        this.dQG = dVar;
        this.dQI = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.azO().azu().tF(this.dQG.mUrl);
        this.dQD = PlayerStatus.IDLE;
        wj("onWaiting");
        aSG();
    }

    private void aSG() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aST = com.baidu.swan.games.audio.b.b.aST();
                File file = new File(aST.wp(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dQJ = file.getAbsolutePath();
                    aSH();
                } else {
                    aST.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cM(String str, String str2) {
                            AudioPlayer.this.dQJ = str2;
                            AudioPlayer.this.aSH();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void au(int i, String str) {
                            AudioPlayer.this.wi(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dQJ = this.mDataSource;
                aSH();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSH() {
        aSI();
    }

    private void aSI() {
        try {
            File file = new File(this.dQJ);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aST().wq(this.dQJ);
                if (0 != this.mDuration) {
                    aSF().setSrc(this.dQJ);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dQJ);
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
        wi("10003");
    }

    public boolean aSJ() {
        return (UserStatus.STOP == this.dQE || UserStatus.DESTROY == this.dQE) ? false : true;
    }

    public void play() {
        this.dQE = UserStatus.PLAY;
        if (this.dQM) {
            try {
                if (!apE() && aSL()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dQJ);
                    }
                    if (this.dQD == PlayerStatus.PREPARED) {
                        this.dQH.sendEmptyMessage(0);
                        aAp();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dQJ);
                        }
                        aSF().play();
                        wj("onPlay");
                    } else if (this.dQD == PlayerStatus.IDLE) {
                        try {
                            aSF().setSrc(this.dQJ);
                            this.dQD = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            wi(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aSK() {
        return this.dQF != null && this.dQD == PlayerStatus.PREPARED;
    }

    private boolean aSL() throws JSONException {
        File file = new File(this.dQJ);
        if (!file.exists() || file.isDirectory()) {
            wi("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.dQG = dVar;
        if (this.dbj != null) {
            this.dbj.pV(this.dQG.daQ);
        }
        aAp();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.dbj = aVar;
    }

    private boolean apE() {
        if (com.baidu.swan.apps.runtime.e.aHu() == null || !com.baidu.swan.apps.runtime.e.aHu().aHN()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c apb = afM.apb();
        if (apb == null || !(apb instanceof j)) {
            return true;
        }
        return ((j) apb).apE();
    }

    private void aAp() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.dQG.toString());
        }
        setLooping(this.dQG.mLoop);
        setVolume(this.dQG.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aSC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aST().aSV().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.dQD == PlayerStatus.PREPARED) {
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
    /* loaded from: classes10.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.dQD = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.dQM) {
                AudioPlayer.this.wj("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dQJ);
            }
            AudioPlayer.this.dQM = true;
            if (UserStatus.PLAY == AudioPlayer.this.dQE) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.dQG.dQQ > 0.0f) {
                    AudioPlayer.this.aSF().seek(AudioPlayer.this.dQG.dQQ);
                } else if (AudioPlayer.this.dQL >= 0.0f) {
                    AudioPlayer.this.aSF().seek(AudioPlayer.this.dQL);
                    AudioPlayer.this.dQL = -1.0f;
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
                if (!AudioPlayer.this.dQG.mLoop) {
                    AudioPlayer.this.dQE = UserStatus.STOP;
                    AudioPlayer.this.aSD();
                }
                AudioPlayer.this.wj("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.dQG.daK + " url = " + AudioPlayer.this.dQG.mUrl);
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
            AudioPlayer.this.wi(str);
            AudioPlayer.this.aSD();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.wj("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aSK()) {
                    AudioPlayer.this.dQI = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.dbj != null) {
                        AudioPlayer.this.wj("onBufferingUpdate");
                        if (AudioPlayer.this.dQD == PlayerStatus.PREPARED && AudioPlayer.this.dQE != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.wj("onWaiting");
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
    public void wi(String str) {
        if (this.dbj != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.dbj.g("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(String str) {
        l(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, JSONObject jSONObject) {
        if (this.dbj != null) {
            this.dbj.g(str, jSONObject);
        }
    }
}
