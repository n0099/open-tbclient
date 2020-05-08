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
    private String bYY;
    protected com.baidu.swan.apps.media.audio.b.a bZw;
    private com.baidu.swan.games.audio.b.c cIX;
    private int cJa;
    private String cJb;
    private a cJc;
    private boolean cJe;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cIV = PlayerStatus.NONE;
    protected UserStatus cIW = UserStatus.OPEN;
    private d cIY = new d();
    private b cIZ = new b();
    private float cJd = -1.0f;
    private TypedCallbackHandler cJf = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.bYY = "";
        this.bYY = str;
    }

    public void pause() {
        this.cIW = UserStatus.PAUSE;
        aeZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeZ() {
        if (atJ()) {
            this.cIX.pause();
        }
    }

    private void atB() {
        py(MissionEvent.MESSAGE_PAUSE);
        this.cIZ.removeMessages(0);
    }

    public void J(float f) {
        try {
            py("onSeeking");
            int i = (int) (1000.0f * f);
            if (atJ()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cIX.seek(i);
                }
                this.cJd = -1.0f;
                return;
            }
            if (this.cJe && this.cIV == PlayerStatus.IDLE) {
                atH();
            }
            this.cJd = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (atJ()) {
                this.cIX.fx(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cIW = UserStatus.STOP;
        if (atJ()) {
            this.cIX.stop();
        }
        atC();
        py(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        atC();
        this.cJe = false;
        this.cIW = UserStatus.DESTROY;
        this.cIV = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atC() {
        this.cIV = PlayerStatus.IDLE;
        if (this.cIX != null) {
            this.cIX.destroy();
            this.cIX = null;
        }
        this.cIZ.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cIX != null) {
                return this.cIX.getDuration();
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
            return this.cIX.getCurrentTime();
        }
        return 0;
    }

    public int atD() {
        return this.cJa;
    }

    public float getVolume() {
        if (this.cIY != null) {
            return this.cIY.mVolume;
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
                this.cIX.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c atE() {
        if (this.cIX == null || this.cIX.atW()) {
            this.cIX = com.baidu.swan.games.audio.b.b.atS().L(this.cJb, this.cIY.mLoop);
            registerListener();
        }
        return this.cIX;
    }

    protected void registerListener() {
        if (this.cJc == null) {
            this.cJc = new a();
        }
        this.cIX.setOnPreparedListener(this.cJc);
        this.cIX.setOnCompletionListener(this.cJc);
        this.cIX.setOnInfoListener(this.cJc);
        this.cIX.setOnErrorListener(this.cJc);
        this.cIX.a((MediaPlayer.OnSeekCompleteListener) this.cJc);
        this.cIX.a((MediaPlayer.OnBufferingUpdateListener) this.cJc);
        this.cIX.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeS() {
        return this.bYY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cIY.bAP;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeU() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null && akM.ald() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.avR()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.atS().atU().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.aeZ();
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
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null && akM.ald()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM == null || !akM.ald()) {
            return null;
        }
        SwanAppActivity akI = akM.akI();
        if (akI == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c Om = akI.Om();
        if (Om instanceof com.baidu.swan.games.i.b) {
            return ((com.baidu.swan.games.i.b) Om).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cIX != null) {
            atC();
        }
        this.cIW = UserStatus.OPEN;
        this.cIY = dVar;
        this.cJa = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.aeJ().aeq().ns(this.cIY.mUrl);
        this.cIV = PlayerStatus.IDLE;
        py("onWaiting");
        atF();
    }

    private void atF() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b atS = com.baidu.swan.games.audio.b.b.atS();
                File file = new File(atS.pE(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cJb = file.getAbsolutePath();
                    atG();
                } else {
                    atS.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void bK(String str, String str2) {
                            AudioPlayer.this.cJb = str2;
                            AudioPlayer.this.atG();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void X(int i, String str) {
                            AudioPlayer.this.px(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cJb = this.mDataSource;
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
            File file = new File(this.cJb);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.atS().pF(this.cJb);
                if (0 != this.mDuration) {
                    atE().setSrc(this.cJb);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cJb);
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
        return (UserStatus.STOP == this.cIW || UserStatus.DESTROY == this.cIW) ? false : true;
    }

    public void play() {
        this.cIW = UserStatus.PLAY;
        if (this.cJe) {
            try {
                if (!WI() && atK()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cJb);
                    }
                    if (this.cIV == PlayerStatus.PREPARED) {
                        this.cIZ.sendEmptyMessage(0);
                        afb();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cJb);
                        }
                        atE().play();
                        py("onPlay");
                    } else if (this.cIV == PlayerStatus.IDLE) {
                        try {
                            atE().setSrc(this.cJb);
                            this.cIV = PlayerStatus.PREPARING;
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
        return this.cIX != null && this.cIV == PlayerStatus.PREPARED;
    }

    private boolean atK() throws JSONException {
        File file = new File(this.cJb);
        if (!file.exists() || file.isDirectory()) {
            px("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cIY = dVar;
        if (this.bZw != null) {
            this.bZw.kn(this.cIY.bZd);
        }
        afb();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bZw = aVar;
    }

    private boolean WI() {
        if (com.baidu.swan.apps.runtime.e.akM() == null || !com.baidu.swan.apps.runtime.e.akM().ald()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Wd = Ot.Wd();
        if (Wd == null || !(Wd instanceof i)) {
            return true;
        }
        return ((i) Wd).WI();
    }

    private void afb() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cIY.toString());
        }
        setLooping(this.cIY.mLoop);
        setVolume(this.cIY.mVolume);
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
            if (message.what == 0 && AudioPlayer.this.cIV == PlayerStatus.PREPARED) {
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
            AudioPlayer.this.cIV = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cJe) {
                AudioPlayer.this.py("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cJb);
            }
            AudioPlayer.this.cJe = true;
            if (UserStatus.PLAY == AudioPlayer.this.cIW) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cIY.cJi > 0.0f) {
                    AudioPlayer.this.atE().seek(AudioPlayer.this.cIY.cJi);
                } else if (AudioPlayer.this.cJd >= 0.0f) {
                    AudioPlayer.this.atE().seek(AudioPlayer.this.cJd);
                    AudioPlayer.this.cJd = -1.0f;
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
                if (!AudioPlayer.this.cIY.mLoop) {
                    AudioPlayer.this.cIW = UserStatus.STOP;
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cIY.bYY + " url = " + AudioPlayer.this.cIY.mUrl);
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
                    AudioPlayer.this.cJa = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bZw != null) {
                        AudioPlayer.this.py("onBufferingUpdate");
                        if (AudioPlayer.this.cIV == PlayerStatus.PREPARED && AudioPlayer.this.cIW != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
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
        if (this.bZw != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bZw.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.bZw != null) {
            this.bZw.e(str, jSONObject);
        }
    }
}
