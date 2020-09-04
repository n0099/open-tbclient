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
    protected com.baidu.swan.apps.media.audio.b.a cyN;
    private String cyo;
    private com.baidu.swan.games.audio.b.c dol;
    private int doo;
    private String dop;
    private a doq;
    private boolean dos;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus doj = PlayerStatus.NONE;
    protected UserStatus dok = UserStatus.OPEN;
    private d dom = new d();
    private b don = new b();
    private float dor = -1.0f;
    private TypedCallbackHandler dot = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.cyo = "";
        this.cyo = str;
    }

    public void pause() {
        this.dok = UserStatus.PAUSE;
        asx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asx() {
        if (aKW()) {
            this.dol.pause();
        }
    }

    private void aKO() {
        ux(MissionEvent.MESSAGE_PAUSE);
        this.don.removeMessages(0);
    }

    public void P(float f) {
        try {
            ux("onSeeking");
            int i = (int) (1000.0f * f);
            if (aKW()) {
                if (i >= 0 && i <= getDuration()) {
                    this.dol.seek(i);
                }
                this.dor = -1.0f;
                return;
            }
            if (this.dos && this.doj == PlayerStatus.IDLE) {
                aKU();
            }
            this.dor = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aKW()) {
                this.dol.gB(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dok = UserStatus.STOP;
        if (aKW()) {
            this.dol.stop();
        }
        aKP();
        ux(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aKP();
        this.dos = false;
        this.dok = UserStatus.DESTROY;
        this.doj = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKP() {
        this.doj = PlayerStatus.IDLE;
        if (this.dol != null) {
            this.dol.destroy();
            this.dol = null;
        }
        this.don.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.dol != null) {
                return this.dol.getDuration();
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
            return this.dol.getCurrentTime();
        }
        return 0;
    }

    public int aKQ() {
        return this.doo;
    }

    public float getVolume() {
        if (this.dom != null) {
            return this.dom.mVolume;
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
                this.dol.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aKR() {
        if (this.dol == null || this.dol.aLj()) {
            this.dol = com.baidu.swan.games.audio.b.b.aLf().ae(this.dop, this.dom.mLoop);
            registerListener();
        }
        return this.dol;
    }

    protected void registerListener() {
        if (this.doq == null) {
            this.doq = new a();
        }
        this.dol.setOnPreparedListener(this.doq);
        this.dol.setOnCompletionListener(this.doq);
        this.dol.setOnInfoListener(this.doq);
        this.dol.setOnErrorListener(this.doq);
        this.dol.a((MediaPlayer.OnSeekCompleteListener) this.doq);
        this.dol.a((MediaPlayer.OnBufferingUpdateListener) this.doq);
        this.dol.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String aop() {
        return this.cyo;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ass() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dom.bTN;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ast() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void eI(boolean z) {
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
    public void eJ(boolean z) {
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
        if (this.dol != null) {
            aKP();
        }
        this.dok = UserStatus.OPEN;
        this.dom = dVar;
        this.doo = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.arY().arE().rS(this.dom.mUrl);
        this.doj = PlayerStatus.IDLE;
        ux("onWaiting");
        aKS();
    }

    private void aKS() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aLf = com.baidu.swan.games.audio.b.b.aLf();
                File file = new File(aLf.uD(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dop = file.getAbsolutePath();
                    aKT();
                } else {
                    aLf.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cA(String str, String str2) {
                            AudioPlayer.this.dop = str2;
                            AudioPlayer.this.aKT();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ac(int i, String str) {
                            AudioPlayer.this.uw(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dop = this.mDataSource;
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
            File file = new File(this.dop);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aLf().uE(this.dop);
                if (0 != this.mDuration) {
                    aKR().setSrc(this.dop);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dop);
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
        uw("10003");
    }

    public boolean aKV() {
        return (UserStatus.STOP == this.dok || UserStatus.DESTROY == this.dok) ? false : true;
    }

    public void play() {
        this.dok = UserStatus.PLAY;
        if (this.dos) {
            try {
                if (!ahO() && aKX()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dop);
                    }
                    if (this.doj == PlayerStatus.PREPARED) {
                        this.don.sendEmptyMessage(0);
                        asA();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dop);
                        }
                        aKR().play();
                        ux("onPlay");
                    } else if (this.doj == PlayerStatus.IDLE) {
                        try {
                            aKR().setSrc(this.dop);
                            this.doj = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            uw(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
        return this.dol != null && this.doj == PlayerStatus.PREPARED;
    }

    private boolean aKX() throws JSONException {
        File file = new File(this.dop);
        if (!file.exists() || file.isDirectory()) {
            uw("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.dom = dVar;
        if (this.cyN != null) {
            this.cyN.oi(this.dom.cyu);
        }
        asA();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cyN = aVar;
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
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.dom.toString());
        }
        setLooping(this.dom.mLoop);
        setVolume(this.dom.mVolume);
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
            if (message.what == 0 && AudioPlayer.this.doj == PlayerStatus.PREPARED) {
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
            AudioPlayer.this.doj = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.dos) {
                AudioPlayer.this.ux("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dop);
            }
            AudioPlayer.this.dos = true;
            if (UserStatus.PLAY == AudioPlayer.this.dok) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.dom.dow > 0.0f) {
                    AudioPlayer.this.aKR().seek(AudioPlayer.this.dom.dow);
                } else if (AudioPlayer.this.dor >= 0.0f) {
                    AudioPlayer.this.aKR().seek(AudioPlayer.this.dor);
                    AudioPlayer.this.dor = -1.0f;
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
                if (!AudioPlayer.this.dom.mLoop) {
                    AudioPlayer.this.dok = UserStatus.STOP;
                    AudioPlayer.this.aKP();
                }
                AudioPlayer.this.ux("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.dom.cyo + " url = " + AudioPlayer.this.dom.mUrl);
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
            AudioPlayer.this.uw(str);
            AudioPlayer.this.aKP();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.ux("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aKW()) {
                    AudioPlayer.this.doo = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cyN != null) {
                        AudioPlayer.this.ux("onBufferingUpdate");
                        if (AudioPlayer.this.doj == PlayerStatus.PREPARED && AudioPlayer.this.dok != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.ux("onWaiting");
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
    public void uw(String str) {
        if (this.cyN != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cyN.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.cyN != null) {
            this.cyN.e(str, jSONObject);
        }
    }
}
