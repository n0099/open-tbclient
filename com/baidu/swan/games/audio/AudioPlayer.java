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
    protected com.baidu.swan.apps.media.audio.b.a cyJ;
    private String cyk;
    private com.baidu.swan.games.audio.b.c doh;
    private int dok;
    private String dol;
    private a dom;
    private boolean doo;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus dof = PlayerStatus.NONE;
    protected UserStatus dog = UserStatus.OPEN;
    private d doi = new d();
    private b doj = new b();
    private float don = -1.0f;
    private TypedCallbackHandler dop = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.cyk = "";
        this.cyk = str;
    }

    public void pause() {
        this.dog = UserStatus.PAUSE;
        asx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asx() {
        if (aKW()) {
            this.doh.pause();
        }
    }

    private void aKO() {
        uw(MissionEvent.MESSAGE_PAUSE);
        this.doj.removeMessages(0);
    }

    public void P(float f) {
        try {
            uw("onSeeking");
            int i = (int) (1000.0f * f);
            if (aKW()) {
                if (i >= 0 && i <= getDuration()) {
                    this.doh.seek(i);
                }
                this.don = -1.0f;
                return;
            }
            if (this.doo && this.dof == PlayerStatus.IDLE) {
                aKU();
            }
            this.don = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aKW()) {
                this.doh.gA(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dog = UserStatus.STOP;
        if (aKW()) {
            this.doh.stop();
        }
        aKP();
        uw(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aKP();
        this.doo = false;
        this.dog = UserStatus.DESTROY;
        this.dof = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKP() {
        this.dof = PlayerStatus.IDLE;
        if (this.doh != null) {
            this.doh.destroy();
            this.doh = null;
        }
        this.doj.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.doh != null) {
                return this.doh.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aKW()) {
            return this.doh.getCurrentTime();
        }
        return 0;
    }

    public int aKQ() {
        return this.dok;
    }

    public float getVolume() {
        if (this.doi != null) {
            return this.doi.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aKW()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.doh.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aKR() {
        if (this.doh == null || this.doh.aLj()) {
            this.doh = com.baidu.swan.games.audio.b.b.aLf().ae(this.dol, this.doi.mLoop);
            registerListener();
        }
        return this.doh;
    }

    protected void registerListener() {
        if (this.dom == null) {
            this.dom = new a();
        }
        this.doh.setOnPreparedListener(this.dom);
        this.doh.setOnCompletionListener(this.dom);
        this.doh.setOnInfoListener(this.dom);
        this.doh.setOnErrorListener(this.dom);
        this.doh.a((MediaPlayer.OnSeekCompleteListener) this.dom);
        this.doh.a((MediaPlayer.OnBufferingUpdateListener) this.dom);
        this.doh.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cyk;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.doi.bTJ;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eH(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null && azI.aAb() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aNg()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aLf().aLh().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.asx();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null && azI.aAb()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI == null || !azI.aAb()) {
            return null;
        }
        SwanAppActivity azC = azI.azC();
        if (azC == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c XQ = azC.XQ();
        if (XQ instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) XQ).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.doh != null) {
            aKP();
        }
        this.dog = UserStatus.OPEN;
        this.doi = dVar;
        this.dok = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.arY().arE().rR(this.doi.mUrl);
        this.dof = PlayerStatus.IDLE;
        uw("onWaiting");
        aKS();
    }

    private void aKS() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aLf = com.baidu.swan.games.audio.b.b.aLf();
                File file = new File(aLf.uC(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dol = file.getAbsolutePath();
                    aKT();
                } else {
                    aLf.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cA(String str, String str2) {
                            AudioPlayer.this.dol = str2;
                            AudioPlayer.this.aKT();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ac(int i, String str) {
                            AudioPlayer.this.uv(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dol = this.mDataSource;
                aKT();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKT() {
        aKU();
    }

    private void aKU() {
        try {
            File file = new File(this.dol);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aLf().uD(this.dol);
                if (0 != this.mDuration) {
                    aKR().setSrc(this.dol);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dol);
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
        uv("10003");
    }

    public boolean aKV() {
        return (UserStatus.STOP == this.dog || UserStatus.DESTROY == this.dog) ? false : true;
    }

    public void play() {
        this.dog = UserStatus.PLAY;
        if (this.doo) {
            try {
                if (!ahO() && aKX()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dol);
                    }
                    if (this.dof == PlayerStatus.PREPARED) {
                        this.doj.sendEmptyMessage(0);
                        asA();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dol);
                        }
                        aKR().play();
                        uw("onPlay");
                    } else if (this.dof == PlayerStatus.IDLE) {
                        try {
                            aKR().setSrc(this.dol);
                            this.dof = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            uv(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aKW() {
        return this.doh != null && this.dof == PlayerStatus.PREPARED;
    }

    private boolean aKX() throws JSONException {
        File file = new File(this.dol);
        if (!file.exists() || file.isDirectory()) {
            uv("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.doi = dVar;
        if (this.cyJ != null) {
            this.cyJ.oh(this.doi.cyq);
        }
        asA();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cyJ = aVar;
    }

    private boolean ahO() {
        if (com.baidu.swan.apps.runtime.e.azI() == null || !com.baidu.swan.apps.runtime.e.azI().aAb()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c ahm = XX.ahm();
        if (ahm == null || !(ahm instanceof j)) {
            return true;
        }
        return ((j) ahm).ahO();
    }

    private void asA() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.doi.toString());
        }
        setLooping(this.doi.mLoop);
        setVolume(this.doi.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aKO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aLf().aLh().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.dof == PlayerStatus.PREPARED) {
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
    /* loaded from: classes8.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.dof = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.doo) {
                AudioPlayer.this.uw("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dol);
            }
            AudioPlayer.this.doo = true;
            if (UserStatus.PLAY == AudioPlayer.this.dog) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.doi.dos > 0.0f) {
                    AudioPlayer.this.aKR().seek(AudioPlayer.this.doi.dos);
                } else if (AudioPlayer.this.don >= 0.0f) {
                    AudioPlayer.this.aKR().seek(AudioPlayer.this.don);
                    AudioPlayer.this.don = -1.0f;
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
                if (!AudioPlayer.this.doi.mLoop) {
                    AudioPlayer.this.dog = UserStatus.STOP;
                    AudioPlayer.this.aKP();
                }
                AudioPlayer.this.uw("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.doi.cyk + " url = " + AudioPlayer.this.doi.mUrl);
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
            AudioPlayer.this.uv(str);
            AudioPlayer.this.aKP();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.uw("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aKW()) {
                    AudioPlayer.this.dok = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cyJ != null) {
                        AudioPlayer.this.uw("onBufferingUpdate");
                        if (AudioPlayer.this.dof == PlayerStatus.PREPARED && AudioPlayer.this.dog != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.uw("onWaiting");
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
    public void uv(String str) {
        if (this.cyJ != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cyJ.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.cyJ != null) {
            this.cyJ.e(str, jSONObject);
        }
    }
}
