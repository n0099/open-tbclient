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
/* loaded from: classes7.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cZa;
    protected com.baidu.swan.apps.media.audio.b.a cZz;
    private com.baidu.swan.games.audio.b.c dOX;
    private int dPa;
    private String dPb;
    private a dPc;
    private boolean dPe;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus dOV = PlayerStatus.NONE;
    protected UserStatus dOW = UserStatus.OPEN;
    private d dOY = new d();
    private b dOZ = new b();
    private float dPd = -1.0f;
    private TypedCallbackHandler dPf = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes7.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.cZa = "";
        this.cZa = str;
    }

    public void pause() {
        this.dOW = UserStatus.PAUSE;
        azE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azE() {
        if (aSc()) {
            this.dOX.pause();
        }
    }

    private void aRU() {
        we(MissionEvent.MESSAGE_PAUSE);
        this.dOZ.removeMessages(0);
    }

    public void U(float f) {
        try {
            we("onSeeking");
            int i = (int) (1000.0f * f);
            if (aSc()) {
                if (i >= 0 && i <= getDuration()) {
                    this.dOX.seek(i);
                }
                this.dPd = -1.0f;
                return;
            }
            if (this.dPe && this.dOV == PlayerStatus.IDLE) {
                aSa();
            }
            this.dPd = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aSc()) {
                this.dOX.hu(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.dOW = UserStatus.STOP;
        if (aSc()) {
            this.dOX.stop();
        }
        aRV();
        we(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aRV();
        this.dPe = false;
        this.dOW = UserStatus.DESTROY;
        this.dOV = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRV() {
        this.dOV = PlayerStatus.IDLE;
        if (this.dOX != null) {
            this.dOX.destroy();
            this.dOX = null;
        }
        this.dOZ.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.dOX != null) {
                return this.dOX.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aSc()) {
            return this.dOX.getCurrentTime();
        }
        return 0;
    }

    public int aRW() {
        return this.dPa;
    }

    public float getVolume() {
        if (this.dOY != null) {
            return this.dOY.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aSc()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.dOX.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aRX() {
        if (this.dOX == null || this.dOX.aSp()) {
            this.dOX = com.baidu.swan.games.audio.b.b.aSl().ak(this.dPb, this.dOY.mLoop);
            registerListener();
        }
        return this.dOX;
    }

    protected void registerListener() {
        if (this.dPc == null) {
            this.dPc = new a();
        }
        this.dOX.setOnPreparedListener(this.dPc);
        this.dOX.setOnCompletionListener(this.dPc);
        this.dOX.setOnInfoListener(this.dPc);
        this.dOX.setOnErrorListener(this.dPc);
        this.dOX.a((MediaPlayer.OnSeekCompleteListener) this.dPc);
        this.dOX.a((MediaPlayer.OnBufferingUpdateListener) this.dPc);
        this.dOX.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String avy() {
        return this.cZa;
    }

    @Override // com.baidu.swan.apps.media.a
    public String azz() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dOY.cuQ;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object azA() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fB(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null && aGM.aHf() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aUm()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aSl().aSn().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.azE();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fC(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null && aGM.aHf()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM == null || !aGM.aHf()) {
            return null;
        }
        SwanAppActivity aGG = aGM.aGG();
        if (aGG == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c aeX = aGG.aeX();
        if (aeX instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) aeX).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.dOX != null) {
            aRV();
        }
        this.dOW = UserStatus.OPEN;
        this.dOY = dVar;
        this.dPa = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.azg().ayM().tA(this.dOY.mUrl);
        this.dOV = PlayerStatus.IDLE;
        we("onWaiting");
        aRY();
    }

    private void aRY() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aSl = com.baidu.swan.games.audio.b.b.aSl();
                File file = new File(aSl.wk(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dPb = file.getAbsolutePath();
                    aRZ();
                } else {
                    aSl.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cL(String str, String str2) {
                            AudioPlayer.this.dPb = str2;
                            AudioPlayer.this.aRZ();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void au(int i, String str) {
                            AudioPlayer.this.wd(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dPb = this.mDataSource;
                aRZ();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRZ() {
        aSa();
    }

    private void aSa() {
        try {
            File file = new File(this.dPb);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aSl().wl(this.dPb);
                if (0 != this.mDuration) {
                    aRX().setSrc(this.dPb);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dPb);
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
        wd("10003");
    }

    public boolean aSb() {
        return (UserStatus.STOP == this.dOW || UserStatus.DESTROY == this.dOW) ? false : true;
    }

    public void play() {
        this.dOW = UserStatus.PLAY;
        if (this.dPe) {
            try {
                if (!aoV() && aSd()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dPb);
                    }
                    if (this.dOV == PlayerStatus.PREPARED) {
                        this.dOZ.sendEmptyMessage(0);
                        azH();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dPb);
                        }
                        aRX().play();
                        we("onPlay");
                    } else if (this.dOV == PlayerStatus.IDLE) {
                        try {
                            aRX().setSrc(this.dPb);
                            this.dOV = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            wd(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aSc() {
        return this.dOX != null && this.dOV == PlayerStatus.PREPARED;
    }

    private boolean aSd() throws JSONException {
        File file = new File(this.dPb);
        if (!file.exists() || file.isDirectory()) {
            wd("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.dOY = dVar;
        if (this.cZz != null) {
            this.cZz.pP(this.dOY.cZg);
        }
        azH();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cZz = aVar;
    }

    private boolean aoV() {
        if (com.baidu.swan.apps.runtime.e.aGM() == null || !com.baidu.swan.apps.runtime.e.aGM().aHf()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c aot = afe.aot();
        if (aot == null || !(aot instanceof j)) {
            return true;
        }
        return ((j) aot).aoV();
    }

    private void azH() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.dOY.toString());
        }
        setLooping(this.dOY.mLoop);
        setVolume(this.dOY.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aRU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aSl().aSn().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.dOV == PlayerStatus.PREPARED) {
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
    /* loaded from: classes7.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.dOV = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.dPe) {
                AudioPlayer.this.we("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dPb);
            }
            AudioPlayer.this.dPe = true;
            if (UserStatus.PLAY == AudioPlayer.this.dOW) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.dOY.dPi > 0.0f) {
                    AudioPlayer.this.aRX().seek(AudioPlayer.this.dOY.dPi);
                } else if (AudioPlayer.this.dPd >= 0.0f) {
                    AudioPlayer.this.aRX().seek(AudioPlayer.this.dPd);
                    AudioPlayer.this.dPd = -1.0f;
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
                if (!AudioPlayer.this.dOY.mLoop) {
                    AudioPlayer.this.dOW = UserStatus.STOP;
                    AudioPlayer.this.aRV();
                }
                AudioPlayer.this.we("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.dOY.cZa + " url = " + AudioPlayer.this.dOY.mUrl);
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
            AudioPlayer.this.wd(str);
            AudioPlayer.this.aRV();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.we("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aSc()) {
                    AudioPlayer.this.dPa = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cZz != null) {
                        AudioPlayer.this.we("onBufferingUpdate");
                        if (AudioPlayer.this.dOV == PlayerStatus.PREPARED && AudioPlayer.this.dOW != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.we("onWaiting");
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
    public void wd(String str) {
        if (this.cZz != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cZz.g("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(String str) {
        l(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, JSONObject jSONObject) {
        if (this.cZz != null) {
            this.cZz.g(str, jSONObject);
        }
    }
}
