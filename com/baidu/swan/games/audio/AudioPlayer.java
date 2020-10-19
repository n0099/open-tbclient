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
    protected com.baidu.swan.apps.media.audio.b.a cMT;
    private String cMu;
    private com.baidu.swan.games.audio.b.c dCq;
    private int dCt;
    private String dCu;
    private a dCv;
    private boolean dCx;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus dCo = PlayerStatus.NONE;
    protected UserStatus dCp = UserStatus.OPEN;
    private d dCr = new d();
    private b dCs = new b();
    private float dCw = -1.0f;
    private TypedCallbackHandler dCy = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.cMu = "";
        this.cMu = str;
    }

    public void pause() {
        this.dCp = UserStatus.PAUSE;
        avS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avS() {
        if (aOq()) {
            this.dCq.pause();
        }
    }

    private void aOi() {
        vC(MissionEvent.MESSAGE_PAUSE);
        this.dCs.removeMessages(0);
    }

    public void R(float f) {
        try {
            vC("onSeeking");
            int i = (int) (1000.0f * f);
            if (aOq()) {
                if (i >= 0 && i <= getDuration()) {
                    this.dCq.seek(i);
                }
                this.dCw = -1.0f;
                return;
            }
            if (this.dCx && this.dCo == PlayerStatus.IDLE) {
                aOo();
            }
            this.dCw = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aOq()) {
                this.dCq.gV(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dCp = UserStatus.STOP;
        if (aOq()) {
            this.dCq.stop();
        }
        aOj();
        vC(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aOj();
        this.dCx = false;
        this.dCp = UserStatus.DESTROY;
        this.dCo = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOj() {
        this.dCo = PlayerStatus.IDLE;
        if (this.dCq != null) {
            this.dCq.destroy();
            this.dCq = null;
        }
        this.dCs.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.dCq != null) {
                return this.dCq.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aOq()) {
            return this.dCq.getCurrentTime();
        }
        return 0;
    }

    public int aOk() {
        return this.dCt;
    }

    public float getVolume() {
        if (this.dCr != null) {
            return this.dCr.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aOq()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.dCq.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aOl() {
        if (this.dCq == null || this.dCq.aOD()) {
            this.dCq = com.baidu.swan.games.audio.b.b.aOz().ai(this.dCu, this.dCr.mLoop);
            registerListener();
        }
        return this.dCq;
    }

    protected void registerListener() {
        if (this.dCv == null) {
            this.dCv = new a();
        }
        this.dCq.setOnPreparedListener(this.dCv);
        this.dCq.setOnCompletionListener(this.dCv);
        this.dCq.setOnInfoListener(this.dCv);
        this.dCq.setOnErrorListener(this.dCv);
        this.dCq.a((MediaPlayer.OnSeekCompleteListener) this.dCv);
        this.dCq.a((MediaPlayer.OnBufferingUpdateListener) this.dCv);
        this.dCq.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String arL() {
        return this.cMu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String avN() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dCr.cib;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object avO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fc(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null && aDa.aDt() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aQA()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aOz().aOB().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.avS();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fd(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null && aDa.aDt()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa == null || !aDa.aDt()) {
            return null;
        }
        SwanAppActivity aCU = aDa.aCU();
        if (aCU == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c abl = aCU.abl();
        if (abl instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) abl).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.dCq != null) {
            aOj();
        }
        this.dCp = UserStatus.OPEN;
        this.dCr = dVar;
        this.dCt = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.avu().ava().sY(this.dCr.mUrl);
        this.dCo = PlayerStatus.IDLE;
        vC("onWaiting");
        aOm();
    }

    private void aOm() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aOz = com.baidu.swan.games.audio.b.b.aOz();
                File file = new File(aOz.vI(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dCu = file.getAbsolutePath();
                    aOn();
                } else {
                    aOz.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cF(String str, String str2) {
                            AudioPlayer.this.dCu = str2;
                            AudioPlayer.this.aOn();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ao(int i, String str) {
                            AudioPlayer.this.vB(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dCu = this.mDataSource;
                aOn();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOn() {
        aOo();
    }

    private void aOo() {
        try {
            File file = new File(this.dCu);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aOz().vJ(this.dCu);
                if (0 != this.mDuration) {
                    aOl().setSrc(this.dCu);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dCu);
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
        vB("10003");
    }

    public boolean aOp() {
        return (UserStatus.STOP == this.dCp || UserStatus.DESTROY == this.dCp) ? false : true;
    }

    public void play() {
        this.dCp = UserStatus.PLAY;
        if (this.dCx) {
            try {
                if (!alj() && aOr()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dCu);
                    }
                    if (this.dCo == PlayerStatus.PREPARED) {
                        this.dCs.sendEmptyMessage(0);
                        avV();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dCu);
                        }
                        aOl().play();
                        vC("onPlay");
                    } else if (this.dCo == PlayerStatus.IDLE) {
                        try {
                            aOl().setSrc(this.dCu);
                            this.dCo = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            vB(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aOq() {
        return this.dCq != null && this.dCo == PlayerStatus.PREPARED;
    }

    private boolean aOr() throws JSONException {
        File file = new File(this.dCu);
        if (!file.exists() || file.isDirectory()) {
            vB("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.dCr = dVar;
        if (this.cMT != null) {
            this.cMT.po(this.dCr.cMA);
        }
        avV();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cMT = aVar;
    }

    private boolean alj() {
        if (com.baidu.swan.apps.runtime.e.aDa() == null || !com.baidu.swan.apps.runtime.e.aDa().aDt()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c akH = abs.akH();
        if (akH == null || !(akH instanceof j)) {
            return true;
        }
        return ((j) akH).alj();
    }

    private void avV() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.dCr.toString());
        }
        setLooping(this.dCr.mLoop);
        setVolume(this.dCr.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aOi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aOz().aOB().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.dCo == PlayerStatus.PREPARED) {
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
            AudioPlayer.this.dCo = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.dCx) {
                AudioPlayer.this.vC("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dCu);
            }
            AudioPlayer.this.dCx = true;
            if (UserStatus.PLAY == AudioPlayer.this.dCp) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.dCr.dCB > 0.0f) {
                    AudioPlayer.this.aOl().seek(AudioPlayer.this.dCr.dCB);
                } else if (AudioPlayer.this.dCw >= 0.0f) {
                    AudioPlayer.this.aOl().seek(AudioPlayer.this.dCw);
                    AudioPlayer.this.dCw = -1.0f;
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
                if (!AudioPlayer.this.dCr.mLoop) {
                    AudioPlayer.this.dCp = UserStatus.STOP;
                    AudioPlayer.this.aOj();
                }
                AudioPlayer.this.vC("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.dCr.cMu + " url = " + AudioPlayer.this.dCr.mUrl);
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
            AudioPlayer.this.vB(str);
            AudioPlayer.this.aOj();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.vC("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aOq()) {
                    AudioPlayer.this.dCt = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cMT != null) {
                        AudioPlayer.this.vC("onBufferingUpdate");
                        if (AudioPlayer.this.dCo == PlayerStatus.PREPARED && AudioPlayer.this.dCp != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.vC("onWaiting");
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
    public void vB(String str) {
        if (this.cMT != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cMT.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.cMT != null) {
            this.cMT.e(str, jSONObject);
        }
    }
}
