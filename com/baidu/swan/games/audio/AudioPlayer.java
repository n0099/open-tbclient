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
/* loaded from: classes10.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.media.audio.b.a bwO;
    private String bwp;
    private com.baidu.swan.games.audio.b.c cfF;
    private int cfI;
    private String cfJ;
    private a cfK;
    private boolean cfM;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cfD = PlayerStatus.NONE;
    protected UserStatus cfE = UserStatus.OPEN;
    private d cfG = new d();
    private b cfH = new b();
    private float cfL = -1.0f;
    private TypedCallbackHandler cfN = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.bwp = "";
        this.bwp = str;
    }

    public void pause() {
        this.cfE = UserStatus.PAUSE;
        UQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UQ() {
        if (ajc()) {
            this.cfF.pause();
        }
    }

    private void aiU() {
        nV(MissionEvent.MESSAGE_PAUSE);
        this.cfH.removeMessages(0);
    }

    public void aa(float f) {
        try {
            nV("onSeeking");
            int i = (int) (1000.0f * f);
            if (ajc()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cfF.seek(i);
                }
                this.cfL = -1.0f;
                return;
            }
            if (this.cfM && this.cfD == PlayerStatus.IDLE) {
                aja();
            }
            this.cfL = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (ajc()) {
                this.cfF.es(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cfE = UserStatus.STOP;
        if (ajc()) {
            this.cfF.stop();
        }
        aiV();
        nV(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aiV();
        this.cfM = false;
        this.cfE = UserStatus.DESTROY;
        this.cfD = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiV() {
        this.cfD = PlayerStatus.IDLE;
        if (this.cfF != null) {
            this.cfF.destroy();
            this.cfF = null;
        }
        this.cfH.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cfF != null) {
                return this.cfF.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (ajc()) {
            return this.cfF.getCurrentTime();
        }
        return 0;
    }

    public int aiW() {
        return this.cfI;
    }

    public float getVolume() {
        if (this.cfG != null) {
            return this.cfG.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (ajc()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cfF.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aiX() {
        if (this.cfF == null || this.cfF.ajp()) {
            this.cfF = com.baidu.swan.games.audio.b.b.ajl().G(this.cfJ, this.cfG.bwy);
            registerListener();
        }
        return this.cfF;
    }

    protected void registerListener() {
        if (this.cfK == null) {
            this.cfK = new a();
        }
        this.cfF.setOnPreparedListener(this.cfK);
        this.cfF.setOnCompletionListener(this.cfK);
        this.cfF.setOnInfoListener(this.cfK);
        this.cfF.setOnErrorListener(this.cfK);
        this.cfF.a((MediaPlayer.OnSeekCompleteListener) this.cfK);
        this.cfF.a((MediaPlayer.OnBufferingUpdateListener) this.cfK);
        this.cfF.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String UK() {
        return this.bwp;
    }

    @Override // com.baidu.swan.apps.media.a
    public String UL() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cfG.aXX;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object UM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cJ(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null && aap.aaG() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.alm()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.ajl().ajn().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.UQ();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cK(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null && aap.aaG()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap == null || !aap.aaG()) {
            return null;
        }
        SwanAppActivity aal = aap.aal();
        if (aal == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c Ee = aal.Ee();
        if (Ee instanceof com.baidu.swan.games.i.b) {
            return ((com.baidu.swan.games.i.b) Ee).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cfF != null) {
            aiV();
        }
        this.cfE = UserStatus.OPEN;
        this.cfG = dVar;
        this.cfI = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.UC().Uj().lR(this.cfG.mUrl);
        this.cfD = PlayerStatus.IDLE;
        nV("onWaiting");
        aiY();
    }

    private void aiY() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b ajl = com.baidu.swan.games.audio.b.b.ajl();
                File file = new File(ajl.ob(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cfJ = file.getAbsolutePath();
                    aiZ();
                } else {
                    ajl.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void br(String str, String str2) {
                            AudioPlayer.this.cfJ = str2;
                            AudioPlayer.this.aiZ();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void E(int i, String str) {
                            AudioPlayer.this.nU(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cfJ = this.mDataSource;
                aiZ();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiZ() {
        aja();
    }

    private void aja() {
        try {
            File file = new File(this.cfJ);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.ajl().oc(this.cfJ);
                if (0 != this.mDuration) {
                    aiX().setSrc(this.cfJ);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cfJ);
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
        nU("10003");
    }

    public boolean ajb() {
        return (UserStatus.STOP == this.cfE || UserStatus.DESTROY == this.cfE) ? false : true;
    }

    public void play() {
        this.cfE = UserStatus.PLAY;
        if (this.cfM) {
            try {
                if (!MB() && ajd()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cfJ);
                    }
                    if (this.cfD == PlayerStatus.PREPARED) {
                        this.cfH.sendEmptyMessage(0);
                        US();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cfJ);
                        }
                        aiX().play();
                        nV("onPlay");
                    } else if (this.cfD == PlayerStatus.IDLE) {
                        try {
                            aiX().setSrc(this.cfJ);
                            this.cfD = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            nU(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean ajc() {
        return this.cfF != null && this.cfD == PlayerStatus.PREPARED;
    }

    private boolean ajd() throws JSONException {
        File file = new File(this.cfJ);
        if (!file.exists() || file.isDirectory()) {
            nU("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cfG = dVar;
        if (this.bwO != null) {
            this.bwO.iM(this.cfG.bwu);
        }
        US();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bwO = aVar;
    }

    private boolean MB() {
        if (com.baidu.swan.apps.runtime.e.aap() == null || !com.baidu.swan.apps.runtime.e.aap().aaG()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b LX = El.LX();
        if (LX == null || !(LX instanceof i)) {
            return true;
        }
        return ((i) LX).MB();
    }

    private void US() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cfG.toString());
        }
        setLooping(this.cfG.bwy);
        setVolume(this.cfG.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aiU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.ajl().ajn().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cfD == PlayerStatus.PREPARED) {
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
    /* loaded from: classes10.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.cfD = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cfM) {
                AudioPlayer.this.nV("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cfJ);
            }
            AudioPlayer.this.cfM = true;
            if (UserStatus.PLAY == AudioPlayer.this.cfE) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cfG.cfQ > 0.0f) {
                    AudioPlayer.this.aiX().seek(AudioPlayer.this.cfG.cfQ);
                } else if (AudioPlayer.this.cfL >= 0.0f) {
                    AudioPlayer.this.aiX().seek(AudioPlayer.this.cfL);
                    AudioPlayer.this.cfL = -1.0f;
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
                if (!AudioPlayer.this.cfG.bwy) {
                    AudioPlayer.this.cfE = UserStatus.STOP;
                    AudioPlayer.this.aiV();
                }
                AudioPlayer.this.nV("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cfG.bwp + " url = " + AudioPlayer.this.cfG.mUrl);
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
            AudioPlayer.this.nU(str);
            AudioPlayer.this.aiV();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.nV("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.ajc()) {
                    AudioPlayer.this.cfI = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bwO != null) {
                        AudioPlayer.this.nV("onBufferingUpdate");
                        if (AudioPlayer.this.cfD == PlayerStatus.PREPARED && AudioPlayer.this.cfE != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.nV("onWaiting");
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
    public void nU(String str) {
        if (this.bwO != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bwO.d("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nV(String str) {
        i(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, JSONObject jSONObject) {
        if (this.bwO != null) {
            this.bwO.d(str, jSONObject);
        }
    }
}
