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
    private com.baidu.swan.games.audio.b.c cTE;
    private int cTH;
    private String cTI;
    private a cTJ;
    private boolean cTL;
    private String cjA;
    protected com.baidu.swan.apps.media.audio.b.a cjZ;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cTC = PlayerStatus.NONE;
    protected UserStatus cTD = UserStatus.OPEN;
    private d cTF = new d();
    private b cTG = new b();
    private float cTK = -1.0f;
    private TypedCallbackHandler cTM = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.cjA = "";
        this.cjA = str;
    }

    public void pause() {
        this.cTD = UserStatus.PAUSE;
        ain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ain() {
        if (axw()) {
            this.cTE.pause();
        }
    }

    private void axo() {
        qY(MissionEvent.MESSAGE_PAUSE);
        this.cTG.removeMessages(0);
    }

    public void I(float f) {
        try {
            qY("onSeeking");
            int i = (int) (1000.0f * f);
            if (axw()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cTE.seek(i);
                }
                this.cTK = -1.0f;
                return;
            }
            if (this.cTL && this.cTC == PlayerStatus.IDLE) {
                axu();
            }
            this.cTK = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (axw()) {
                this.cTE.fI(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cTD = UserStatus.STOP;
        if (axw()) {
            this.cTE.stop();
        }
        axp();
        qY(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        axp();
        this.cTL = false;
        this.cTD = UserStatus.DESTROY;
        this.cTC = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axp() {
        this.cTC = PlayerStatus.IDLE;
        if (this.cTE != null) {
            this.cTE.destroy();
            this.cTE = null;
        }
        this.cTG.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cTE != null) {
                return this.cTE.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (axw()) {
            return this.cTE.getCurrentTime();
        }
        return 0;
    }

    public int axq() {
        return this.cTH;
    }

    public float getVolume() {
        if (this.cTF != null) {
            return this.cTF.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (axw()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cTE.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c axr() {
        if (this.cTE == null || this.cTE.axJ()) {
            this.cTE = com.baidu.swan.games.audio.b.b.axF().Y(this.cTI, this.cTF.mLoop);
            registerListener();
        }
        return this.cTE;
    }

    protected void registerListener() {
        if (this.cTJ == null) {
            this.cTJ = new a();
        }
        this.cTE.setOnPreparedListener(this.cTJ);
        this.cTE.setOnCompletionListener(this.cTJ);
        this.cTE.setOnInfoListener(this.cTJ);
        this.cTE.setOnErrorListener(this.cTJ);
        this.cTE.a((MediaPlayer.OnSeekCompleteListener) this.cTJ);
        this.cTE.a((MediaPlayer.OnBufferingUpdateListener) this.cTJ);
        this.cTE.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String aey() {
        return this.cjA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aih() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cTF.bIH;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aii() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ee(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null && aoF.aoY() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.azG()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.axF().axH().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.ain();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ef(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null && aoF.aoY()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF == null || !aoF.aoY()) {
            return null;
        }
        SwanAppActivity aoz = aoF.aoz();
        if (aoz == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c QA = aoz.QA();
        if (QA instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) QA).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cTE != null) {
            axp();
        }
        this.cTD = UserStatus.OPEN;
        this.cTF = dVar;
        this.cTH = 0;
        this.mDataSource = com.baidu.swan.apps.w.f.ahV().ahB().oY(this.cTF.mUrl);
        this.cTC = PlayerStatus.IDLE;
        qY("onWaiting");
        axs();
    }

    private void axs() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b axF = com.baidu.swan.games.audio.b.b.axF();
                File file = new File(axF.re(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cTI = file.getAbsolutePath();
                    axt();
                } else {
                    axF.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void ce(String str, String str2) {
                            AudioPlayer.this.cTI = str2;
                            AudioPlayer.this.axt();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ab(int i, String str) {
                            AudioPlayer.this.qX(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cTI = this.mDataSource;
                axt();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axt() {
        axu();
    }

    private void axu() {
        try {
            File file = new File(this.cTI);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.axF().rf(this.cTI);
                if (0 != this.mDuration) {
                    axr().setSrc(this.cTI);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cTI);
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
        qX("10003");
    }

    public boolean axv() {
        return (UserStatus.STOP == this.cTD || UserStatus.DESTROY == this.cTD) ? false : true;
    }

    public void play() {
        this.cTD = UserStatus.PLAY;
        if (this.cTL) {
            try {
                if (!Zu() && axx()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cTI);
                    }
                    if (this.cTC == PlayerStatus.PREPARED) {
                        this.cTG.sendEmptyMessage(0);
                        aiq();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cTI);
                        }
                        axr().play();
                        qY("onPlay");
                    } else if (this.cTC == PlayerStatus.IDLE) {
                        try {
                            axr().setSrc(this.cTI);
                            this.cTC = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            qX(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean axw() {
        return this.cTE != null && this.cTC == PlayerStatus.PREPARED;
    }

    private boolean axx() throws JSONException {
        File file = new File(this.cTI);
        if (!file.exists() || file.isDirectory()) {
            qX("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cTF = dVar;
        if (this.cjZ != null) {
            this.cjZ.lA(this.cTF.cjG);
        }
        aiq();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cjZ = aVar;
    }

    private boolean Zu() {
        if (com.baidu.swan.apps.runtime.e.aoF() == null || !com.baidu.swan.apps.runtime.e.aoF().aoY()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b YP = QH.YP();
        if (YP == null || !(YP instanceof i)) {
            return true;
        }
        return ((i) YP).Zu();
    }

    private void aiq() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cTF.toString());
        }
        setLooping(this.cTF.mLoop);
        setVolume(this.cTF.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        axo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.axF().axH().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cTC == PlayerStatus.PREPARED) {
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
            AudioPlayer.this.cTC = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cTL) {
                AudioPlayer.this.qY("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cTI);
            }
            AudioPlayer.this.cTL = true;
            if (UserStatus.PLAY == AudioPlayer.this.cTD) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cTF.cTP > 0.0f) {
                    AudioPlayer.this.axr().seek(AudioPlayer.this.cTF.cTP);
                } else if (AudioPlayer.this.cTK >= 0.0f) {
                    AudioPlayer.this.axr().seek(AudioPlayer.this.cTK);
                    AudioPlayer.this.cTK = -1.0f;
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
                if (!AudioPlayer.this.cTF.mLoop) {
                    AudioPlayer.this.cTD = UserStatus.STOP;
                    AudioPlayer.this.axp();
                }
                AudioPlayer.this.qY("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cTF.cjA + " url = " + AudioPlayer.this.cTF.mUrl);
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
            AudioPlayer.this.qX(str);
            AudioPlayer.this.axp();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.qY("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.axw()) {
                    AudioPlayer.this.cTH = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cjZ != null) {
                        AudioPlayer.this.qY("onBufferingUpdate");
                        if (AudioPlayer.this.cTC == PlayerStatus.PREPARED && AudioPlayer.this.cTD != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.qY("onWaiting");
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
    public void qX(String str) {
        if (this.cjZ != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cjZ.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.cjZ != null) {
            this.cjZ.e(str, jSONObject);
        }
    }
}
