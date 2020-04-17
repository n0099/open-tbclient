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
    private String bYS;
    protected com.baidu.swan.apps.media.audio.b.a bZq;
    private com.baidu.swan.games.audio.b.c cIR;
    private int cIU;
    private String cIV;
    private a cIW;
    private boolean cIY;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cIP = PlayerStatus.NONE;
    protected UserStatus cIQ = UserStatus.OPEN;
    private d cIS = new d();
    private b cIT = new b();
    private float cIX = -1.0f;
    private TypedCallbackHandler cIZ = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.bYS = "";
        this.bYS = str;
    }

    public void pause() {
        this.cIQ = UserStatus.PAUSE;
        afa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afa() {
        if (atJ()) {
            this.cIR.pause();
        }
    }

    private void atB() {
        py(MissionEvent.MESSAGE_PAUSE);
        this.cIT.removeMessages(0);
    }

    public void J(float f) {
        try {
            py("onSeeking");
            int i = (int) (1000.0f * f);
            if (atJ()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cIR.seek(i);
                }
                this.cIX = -1.0f;
                return;
            }
            if (this.cIY && this.cIP == PlayerStatus.IDLE) {
                atH();
            }
            this.cIX = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (atJ()) {
                this.cIR.fx(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cIQ = UserStatus.STOP;
        if (atJ()) {
            this.cIR.stop();
        }
        atC();
        py(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        atC();
        this.cIY = false;
        this.cIQ = UserStatus.DESTROY;
        this.cIP = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atC() {
        this.cIP = PlayerStatus.IDLE;
        if (this.cIR != null) {
            this.cIR.destroy();
            this.cIR = null;
        }
        this.cIT.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cIR != null) {
                return this.cIR.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (atJ()) {
            return this.cIR.getCurrentTime();
        }
        return 0;
    }

    public int atD() {
        return this.cIU;
    }

    public float getVolume() {
        if (this.cIS != null) {
            return this.cIS.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (atJ()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cIR.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c atE() {
        if (this.cIR == null || this.cIR.atW()) {
            this.cIR = com.baidu.swan.games.audio.b.b.atS().L(this.cIV, this.cIS.mLoop);
            registerListener();
        }
        return this.cIR;
    }

    protected void registerListener() {
        if (this.cIW == null) {
            this.cIW = new a();
        }
        this.cIR.setOnPreparedListener(this.cIW);
        this.cIR.setOnCompletionListener(this.cIW);
        this.cIR.setOnInfoListener(this.cIW);
        this.cIR.setOnErrorListener(this.cIW);
        this.cIR.a((MediaPlayer.OnSeekCompleteListener) this.cIW);
        this.cIR.a((MediaPlayer.OnBufferingUpdateListener) this.cIW);
        this.cIR.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return this.bYS;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeU() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cIS.bAK;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeV() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null && akN.ale() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.avR()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.atS().atU().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.afa();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null && akN.ale()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN == null || !akN.ale()) {
            return null;
        }
        SwanAppActivity akJ = akN.akJ();
        if (akJ == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c On = akJ.On();
        if (On instanceof com.baidu.swan.games.i.b) {
            return ((com.baidu.swan.games.i.b) On).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cIR != null) {
            atC();
        }
        this.cIQ = UserStatus.OPEN;
        this.cIS = dVar;
        this.cIU = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.aeK().aer().ns(this.cIS.mUrl);
        this.cIP = PlayerStatus.IDLE;
        py("onWaiting");
        atF();
    }

    private void atF() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b atS = com.baidu.swan.games.audio.b.b.atS();
                File file = new File(atS.pE(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cIV = file.getAbsolutePath();
                    atG();
                } else {
                    atS.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void bK(String str, String str2) {
                            AudioPlayer.this.cIV = str2;
                            AudioPlayer.this.atG();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void X(int i, String str) {
                            AudioPlayer.this.px(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cIV = this.mDataSource;
                atG();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atG() {
        atH();
    }

    private void atH() {
        try {
            File file = new File(this.cIV);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.atS().pF(this.cIV);
                if (0 != this.mDuration) {
                    atE().setSrc(this.cIV);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cIV);
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
        px("10003");
    }

    public boolean atI() {
        return (UserStatus.STOP == this.cIQ || UserStatus.DESTROY == this.cIQ) ? false : true;
    }

    public void play() {
        this.cIQ = UserStatus.PLAY;
        if (this.cIY) {
            try {
                if (!WJ() && atK()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cIV);
                    }
                    if (this.cIP == PlayerStatus.PREPARED) {
                        this.cIT.sendEmptyMessage(0);
                        afc();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cIV);
                        }
                        atE().play();
                        py("onPlay");
                    } else if (this.cIP == PlayerStatus.IDLE) {
                        try {
                            atE().setSrc(this.cIV);
                            this.cIP = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            px(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean atJ() {
        return this.cIR != null && this.cIP == PlayerStatus.PREPARED;
    }

    private boolean atK() throws JSONException {
        File file = new File(this.cIV);
        if (!file.exists() || file.isDirectory()) {
            px("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cIS = dVar;
        if (this.bZq != null) {
            this.bZq.kn(this.cIS.bYX);
        }
        afc();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bZq = aVar;
    }

    private boolean WJ() {
        if (com.baidu.swan.apps.runtime.e.akN() == null || !com.baidu.swan.apps.runtime.e.akN().ale()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b We = Ou.We();
        if (We == null || !(We instanceof i)) {
            return true;
        }
        return ((i) We).WJ();
    }

    private void afc() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cIS.toString());
        }
        setLooping(this.cIS.mLoop);
        setVolume(this.cIS.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        atB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.atS().atU().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cIP == PlayerStatus.PREPARED) {
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
    /* loaded from: classes11.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.cIP = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cIY) {
                AudioPlayer.this.py("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cIV);
            }
            AudioPlayer.this.cIY = true;
            if (UserStatus.PLAY == AudioPlayer.this.cIQ) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cIS.cJc > 0.0f) {
                    AudioPlayer.this.atE().seek(AudioPlayer.this.cIS.cJc);
                } else if (AudioPlayer.this.cIX >= 0.0f) {
                    AudioPlayer.this.atE().seek(AudioPlayer.this.cIX);
                    AudioPlayer.this.cIX = -1.0f;
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
                if (!AudioPlayer.this.cIS.mLoop) {
                    AudioPlayer.this.cIQ = UserStatus.STOP;
                    AudioPlayer.this.atC();
                }
                AudioPlayer.this.py("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cIS.bYS + " url = " + AudioPlayer.this.cIS.mUrl);
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
            AudioPlayer.this.px(str);
            AudioPlayer.this.atC();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.py("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.atJ()) {
                    AudioPlayer.this.cIU = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bZq != null) {
                        AudioPlayer.this.py("onBufferingUpdate");
                        if (AudioPlayer.this.cIP == PlayerStatus.PREPARED && AudioPlayer.this.cIQ != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.py("onWaiting");
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
    public void px(String str) {
        if (this.bZq != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bZq.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.bZq != null) {
            this.bZq.e(str, jSONObject);
        }
    }
}
