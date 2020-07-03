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
    private com.baidu.swan.games.audio.b.c cYo;
    private int cYr;
    private String cYs;
    private a cYt;
    private boolean cYv;
    protected com.baidu.swan.apps.media.audio.b.a coO;
    private String cop;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cYm = PlayerStatus.NONE;
    protected UserStatus cYn = UserStatus.OPEN;
    private d cYp = new d();
    private b cYq = new b();
    private float cYu = -1.0f;
    private TypedCallbackHandler cYw = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.cop = "";
        this.cop = str;
    }

    public void pause() {
        this.cYn = UserStatus.PAUSE;
        ajt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajt() {
        if (ayC()) {
            this.cYo.pause();
        }
    }

    private void ayu() {
        rg(MissionEvent.MESSAGE_PAUSE);
        this.cYq.removeMessages(0);
    }

    public void K(float f) {
        try {
            rg("onSeeking");
            int i = (int) (1000.0f * f);
            if (ayC()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cYo.seek(i);
                }
                this.cYu = -1.0f;
                return;
            }
            if (this.cYv && this.cYm == PlayerStatus.IDLE) {
                ayA();
            }
            this.cYu = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (ayC()) {
                this.cYo.fN(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cYn = UserStatus.STOP;
        if (ayC()) {
            this.cYo.stop();
        }
        ayv();
        rg(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        ayv();
        this.cYv = false;
        this.cYn = UserStatus.DESTROY;
        this.cYm = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayv() {
        this.cYm = PlayerStatus.IDLE;
        if (this.cYo != null) {
            this.cYo.destroy();
            this.cYo = null;
        }
        this.cYq.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cYo != null) {
                return this.cYo.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (ayC()) {
            return this.cYo.getCurrentTime();
        }
        return 0;
    }

    public int ayw() {
        return this.cYr;
    }

    public float getVolume() {
        if (this.cYp != null) {
            return this.cYp.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (ayC()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cYo.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c ayx() {
        if (this.cYo == null || this.cYo.ayP()) {
            this.cYo = com.baidu.swan.games.audio.b.b.ayL().aa(this.cYs, this.cYp.mLoop);
            registerListener();
        }
        return this.cYo;
    }

    protected void registerListener() {
        if (this.cYt == null) {
            this.cYt = new a();
        }
        this.cYo.setOnPreparedListener(this.cYt);
        this.cYo.setOnCompletionListener(this.cYt);
        this.cYo.setOnInfoListener(this.cYt);
        this.cYo.setOnErrorListener(this.cYt);
        this.cYo.a((MediaPlayer.OnSeekCompleteListener) this.cYt);
        this.cYo.a((MediaPlayer.OnBufferingUpdateListener) this.cYt);
        this.cYo.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String afE() {
        return this.cop;
    }

    @Override // com.baidu.swan.apps.media.a
    public String ajn() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cYp.bNv;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object ajo() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void ej(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null && apM.aqf() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aAM()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.ajt();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ek(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null && apM.aqf()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM == null || !apM.aqf()) {
            return null;
        }
        SwanAppActivity apG = apM.apG();
        if (apG == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c RG = apG.RG();
        if (RG instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) RG).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cYo != null) {
            ayv();
        }
        this.cYn = UserStatus.OPEN;
        this.cYp = dVar;
        this.cYr = 0;
        this.mDataSource = com.baidu.swan.apps.w.f.ajb().aiH().pg(this.cYp.mUrl);
        this.cYm = PlayerStatus.IDLE;
        rg("onWaiting");
        ayy();
    }

    private void ayy() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b ayL = com.baidu.swan.games.audio.b.b.ayL();
                File file = new File(ayL.rm(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cYs = file.getAbsolutePath();
                    ayz();
                } else {
                    ayL.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cg(String str, String str2) {
                            AudioPlayer.this.cYs = str2;
                            AudioPlayer.this.ayz();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ad(int i, String str) {
                            AudioPlayer.this.rf(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cYs = this.mDataSource;
                ayz();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayz() {
        ayA();
    }

    private void ayA() {
        try {
            File file = new File(this.cYs);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.ayL().rn(this.cYs);
                if (0 != this.mDuration) {
                    ayx().setSrc(this.cYs);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cYs);
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
        rf("10003");
    }

    public boolean ayB() {
        return (UserStatus.STOP == this.cYn || UserStatus.DESTROY == this.cYn) ? false : true;
    }

    public void play() {
        this.cYn = UserStatus.PLAY;
        if (this.cYv) {
            try {
                if (!aaA() && ayD()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cYs);
                    }
                    if (this.cYm == PlayerStatus.PREPARED) {
                        this.cYq.sendEmptyMessage(0);
                        ajw();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cYs);
                        }
                        ayx().play();
                        rg("onPlay");
                    } else if (this.cYm == PlayerStatus.IDLE) {
                        try {
                            ayx().setSrc(this.cYs);
                            this.cYm = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            rf(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean ayC() {
        return this.cYo != null && this.cYm == PlayerStatus.PREPARED;
    }

    private boolean ayD() throws JSONException {
        File file = new File(this.cYs);
        if (!file.exists() || file.isDirectory()) {
            rf("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cYp = dVar;
        if (this.coO != null) {
            this.coO.lI(this.cYp.cov);
        }
        ajw();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.coO = aVar;
    }

    private boolean aaA() {
        if (com.baidu.swan.apps.runtime.e.apM() == null || !com.baidu.swan.apps.runtime.e.apM().aqf()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b ZV = RN.ZV();
        if (ZV == null || !(ZV instanceof i)) {
            return true;
        }
        return ((i) ZV).aaA();
    }

    private void ajw() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cYp.toString());
        }
        setLooping(this.cYp.mLoop);
        setVolume(this.cYp.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        ayu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.ayL().ayN().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cYm == PlayerStatus.PREPARED) {
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
            AudioPlayer.this.cYm = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.cYv) {
                AudioPlayer.this.rg("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cYs);
            }
            AudioPlayer.this.cYv = true;
            if (UserStatus.PLAY == AudioPlayer.this.cYn) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cYp.cYz > 0.0f) {
                    AudioPlayer.this.ayx().seek(AudioPlayer.this.cYp.cYz);
                } else if (AudioPlayer.this.cYu >= 0.0f) {
                    AudioPlayer.this.ayx().seek(AudioPlayer.this.cYu);
                    AudioPlayer.this.cYu = -1.0f;
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
                if (!AudioPlayer.this.cYp.mLoop) {
                    AudioPlayer.this.cYn = UserStatus.STOP;
                    AudioPlayer.this.ayv();
                }
                AudioPlayer.this.rg("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cYp.cop + " url = " + AudioPlayer.this.cYp.mUrl);
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
            AudioPlayer.this.rf(str);
            AudioPlayer.this.ayv();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.rg("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.ayC()) {
                    AudioPlayer.this.cYr = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.coO != null) {
                        AudioPlayer.this.rg("onBufferingUpdate");
                        if (AudioPlayer.this.cYm == PlayerStatus.PREPARED && AudioPlayer.this.cYn != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.rg("onWaiting");
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
    public void rf(String str) {
        if (this.coO != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.coO.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.coO != null) {
            this.coO.e(str, jSONObject);
        }
    }
}
