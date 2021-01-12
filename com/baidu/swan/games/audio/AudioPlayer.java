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
/* loaded from: classes8.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.media.audio.b.a dgE;
    private String dge;
    private com.baidu.swan.games.audio.b.c eag;
    private int eaj;
    private String eak;
    private a eal;
    private boolean ean;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus eae = PlayerStatus.NONE;
    protected UserStatus eaf = UserStatus.OPEN;
    private d eah = new d();
    private b eai = new b();
    private float eam = -1.0f;
    private TypedCallbackHandler eao = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes8.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.dge = "";
        this.dge = str;
    }

    public void pause() {
        this.eaf = UserStatus.PAUSE;
        aAl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAl() {
        if (aTI()) {
            this.eag.pause();
        }
    }

    private void aTA() {
        vz(MissionEvent.MESSAGE_PAUSE);
        this.eai.removeMessages(0);
    }

    public void W(float f) {
        try {
            vz("onSeeking");
            int i = (int) (1000.0f * f);
            if (aTI()) {
                if (i >= 0 && i <= getDuration()) {
                    this.eag.seek(i);
                }
                this.eam = -1.0f;
                return;
            }
            if (this.ean && this.eae == PlayerStatus.IDLE) {
                aTG();
            }
            this.eam = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aTI()) {
                this.eag.hX(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.eaf = UserStatus.STOP;
        if (aTI()) {
            this.eag.stop();
        }
        aTB();
        vz(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aTB();
        this.ean = false;
        this.eaf = UserStatus.DESTROY;
        this.eae = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTB() {
        this.eae = PlayerStatus.IDLE;
        if (this.eag != null) {
            this.eag.destroy();
            this.eag = null;
        }
        this.eai.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.eag != null) {
                return this.eag.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aTI()) {
            return this.eag.getCurrentTime();
        }
        return 0;
    }

    public int aTC() {
        return this.eaj;
    }

    public float getVolume() {
        if (this.eah != null) {
            return this.eah.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aTI()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.eag.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aTD() {
        if (this.eag == null || this.eag.aTV()) {
            this.eag = com.baidu.swan.games.audio.b.b.aTR().al(this.eak, this.eah.mLoop);
            registerListener();
        }
        return this.eag;
    }

    protected void registerListener() {
        if (this.eal == null) {
            this.eal = new a();
        }
        this.eag.setOnPreparedListener(this.eal);
        this.eag.setOnCompletionListener(this.eal);
        this.eag.setOnInfoListener(this.eal);
        this.eag.setOnErrorListener(this.eal);
        this.eag.a((MediaPlayer.OnSeekCompleteListener) this.eal);
        this.eag.a((MediaPlayer.OnBufferingUpdateListener) this.eal);
        this.eag.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String awe() {
        return this.dge;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAg() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eah.cBM;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAh() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fV(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null && aIr.aIK() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aVS()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aTR().aTT().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.aAl();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fW(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null && aIr.aIK()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr == null || !aIr.aIK()) {
            return null;
        }
        SwanAppActivity aIl = aIr.aIl();
        if (aIl == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c afs = aIl.afs();
        if (afs instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) afs).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.eag != null) {
            aTB();
        }
        this.eaf = UserStatus.OPEN;
        this.eah = dVar;
        this.eaj = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.azN().azt().sT(this.eah.mUrl);
        this.eae = PlayerStatus.IDLE;
        vz("onWaiting");
        aTE();
    }

    private void aTE() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aTR = com.baidu.swan.games.audio.b.b.aTR();
                File file = new File(aTR.vF(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.eak = file.getAbsolutePath();
                    aTF();
                } else {
                    aTR.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cQ(String str, String str2) {
                            AudioPlayer.this.eak = str2;
                            AudioPlayer.this.aTF();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ax(int i, String str) {
                            AudioPlayer.this.vy(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.eak = this.mDataSource;
                aTF();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTF() {
        aTG();
    }

    private void aTG() {
        try {
            File file = new File(this.eak);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aTR().vG(this.eak);
                if (0 != this.mDuration) {
                    aTD().setSrc(this.eak);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.eak);
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
        vy("10003");
    }

    public boolean aTH() {
        return (UserStatus.STOP == this.eaf || UserStatus.DESTROY == this.eaf) ? false : true;
    }

    public void play() {
        this.eaf = UserStatus.PLAY;
        if (this.ean) {
            try {
                if (!apB() && aTJ()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.eak);
                    }
                    if (this.eae == PlayerStatus.PREPARED) {
                        this.eai.sendEmptyMessage(0);
                        aAo();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.eak);
                        }
                        aTD().play();
                        vz("onPlay");
                    } else if (this.eae == PlayerStatus.IDLE) {
                        try {
                            aTD().setSrc(this.eak);
                            this.eae = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            vy(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aTI() {
        return this.eag != null && this.eae == PlayerStatus.PREPARED;
    }

    private boolean aTJ() throws JSONException {
        File file = new File(this.eak);
        if (!file.exists() || file.isDirectory()) {
            vy("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.eah = dVar;
        if (this.dgE != null) {
            this.dgE.pe(this.eah.dgk);
        }
        aAo();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.dgE = aVar;
    }

    private boolean apB() {
        if (com.baidu.swan.apps.runtime.e.aIr() == null || !com.baidu.swan.apps.runtime.e.aIr().aIK()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c aoY = afz.aoY();
        if (aoY == null || !(aoY instanceof j)) {
            return true;
        }
        return ((j) aoY).apB();
    }

    private void aAo() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.eah.toString());
        }
        setLooping(this.eah.mLoop);
        setVolume(this.eah.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aTA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aTR().aTT().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.eae == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.getCurrentPosition() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.getDuration() / 1000));
                    AudioPlayer.this.m("onTimeUpdate", jSONObject);
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
    /* loaded from: classes8.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.eae = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.ean) {
                AudioPlayer.this.vz("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.eak);
            }
            AudioPlayer.this.ean = true;
            if (UserStatus.PLAY == AudioPlayer.this.eaf) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.eah.ear > 0.0f) {
                    AudioPlayer.this.aTD().seek(AudioPlayer.this.eah.ear);
                } else if (AudioPlayer.this.eam >= 0.0f) {
                    AudioPlayer.this.aTD().seek(AudioPlayer.this.eam);
                    AudioPlayer.this.eam = -1.0f;
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
                if (!AudioPlayer.this.eah.mLoop) {
                    AudioPlayer.this.eaf = UserStatus.STOP;
                    AudioPlayer.this.aTB();
                }
                AudioPlayer.this.vz("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.eah.dge + " url = " + AudioPlayer.this.eah.mUrl);
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
            AudioPlayer.this.vy(str);
            AudioPlayer.this.aTB();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.vz("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aTI()) {
                    AudioPlayer.this.eaj = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.dgE != null) {
                        AudioPlayer.this.vz("onBufferingUpdate");
                        if (AudioPlayer.this.eae == PlayerStatus.PREPARED && AudioPlayer.this.eaf != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.vz("onWaiting");
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
    public void vy(String str) {
        if (this.dgE != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.dgE.h("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz(String str) {
        m(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, JSONObject jSONObject) {
        if (this.dgE != null) {
            this.dgE.h(str, jSONObject);
        }
    }
}
