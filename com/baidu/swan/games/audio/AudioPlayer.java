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
/* loaded from: classes9.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a, com.baidu.swan.nalib.audio.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dkT;
    protected com.baidu.swan.apps.media.audio.b.a dlt;
    private com.baidu.swan.games.audio.b.c eeS;
    private int eeV;
    private String eeW;
    private a eeX;
    private boolean eeZ;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus eeQ = PlayerStatus.NONE;
    protected UserStatus eeR = UserStatus.OPEN;
    private d eeT = new d();
    private b eeU = new b();
    private float eeY = -1.0f;
    private TypedCallbackHandler efa = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes9.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.dkT = "";
        this.dkT = str;
    }

    public void pause() {
        this.eeR = UserStatus.PAUSE;
        aEe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEe() {
        if (aXB()) {
            this.eeS.pause();
        }
    }

    private void aXt() {
        wK(MissionEvent.MESSAGE_PAUSE);
        this.eeU.removeMessages(0);
    }

    public void W(float f) {
        try {
            wK("onSeeking");
            int i = (int) (1000.0f * f);
            if (aXB()) {
                if (i >= 0 && i <= getDuration()) {
                    this.eeS.seek(i);
                }
                this.eeY = -1.0f;
                return;
            }
            if (this.eeZ && this.eeQ == PlayerStatus.IDLE) {
                aXz();
            }
            this.eeY = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aXB()) {
                this.eeS.ib(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.eeR = UserStatus.STOP;
        if (aXB()) {
            this.eeS.stop();
        }
        aXu();
        wK(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aXu();
        this.eeZ = false;
        this.eeR = UserStatus.DESTROY;
        this.eeQ = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXu() {
        this.eeQ = PlayerStatus.IDLE;
        if (this.eeS != null) {
            this.eeS.destroy();
            this.eeS = null;
        }
        this.eeU.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.eeS != null) {
                return this.eeS.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aXB()) {
            return this.eeS.getCurrentTime();
        }
        return 0;
    }

    public int aXv() {
        return this.eeV;
    }

    public float getVolume() {
        if (this.eeT != null) {
            return this.eeT.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aXB()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.eeS.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aXw() {
        if (this.eeS == null || this.eeS.aXO()) {
            this.eeS = com.baidu.swan.games.audio.b.b.aXK().al(this.eeW, this.eeT.mLoop);
            registerListener();
        }
        return this.eeS;
    }

    protected void registerListener() {
        if (this.eeX == null) {
            this.eeX = new a();
        }
        this.eeS.setOnPreparedListener(this.eeX);
        this.eeS.setOnCompletionListener(this.eeX);
        this.eeS.setOnInfoListener(this.eeX);
        this.eeS.setOnErrorListener(this.eeX);
        this.eeS.a((MediaPlayer.OnSeekCompleteListener) this.eeX);
        this.eeS.a((MediaPlayer.OnBufferingUpdateListener) this.eeX);
        this.eeS.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String azX() {
        return this.dkT;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aDZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eeT.cGy;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aEa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fZ(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk != null && aMk.aMD() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aZL()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aXK().aXM().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.aEe();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void ga(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk != null && aMk.aMD()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk == null || !aMk.aMD()) {
            return null;
        }
        SwanAppActivity aMe = aMk.aMe();
        if (aMe == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c ajl = aMe.ajl();
        if (ajl instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) ajl).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.eeS != null) {
            aXu();
        }
        this.eeR = UserStatus.OPEN;
        this.eeT = dVar;
        this.eeV = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.aDG().aDm().ue(this.eeT.mUrl);
        this.eeQ = PlayerStatus.IDLE;
        wK("onWaiting");
        aXx();
    }

    private void aXx() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aXK = com.baidu.swan.games.audio.b.b.aXK();
                File file = new File(aXK.wQ(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.eeW = file.getAbsolutePath();
                    aXy();
                } else {
                    aXK.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cR(String str, String str2) {
                            AudioPlayer.this.eeW = str2;
                            AudioPlayer.this.aXy();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void aw(int i, String str) {
                            AudioPlayer.this.wJ(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.eeW = this.mDataSource;
                aXy();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        aXz();
    }

    private void aXz() {
        try {
            File file = new File(this.eeW);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aXK().wR(this.eeW);
                if (0 != this.mDuration) {
                    aXw().setSrc(this.eeW);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.eeW);
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
        wJ("10003");
    }

    public boolean aXA() {
        return (UserStatus.STOP == this.eeR || UserStatus.DESTROY == this.eeR) ? false : true;
    }

    public void play() {
        this.eeR = UserStatus.PLAY;
        if (this.eeZ) {
            try {
                if (!atv() && aXC()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.eeW);
                    }
                    if (this.eeQ == PlayerStatus.PREPARED) {
                        this.eeU.sendEmptyMessage(0);
                        aEh();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.eeW);
                        }
                        aXw().play();
                        wK("onPlay");
                    } else if (this.eeQ == PlayerStatus.IDLE) {
                        try {
                            aXw().setSrc(this.eeW);
                            this.eeQ = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            wJ(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aXB() {
        return this.eeS != null && this.eeQ == PlayerStatus.PREPARED;
    }

    private boolean aXC() throws JSONException {
        File file = new File(this.eeW);
        if (!file.exists() || file.isDirectory()) {
            wJ("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.eeT = dVar;
        if (this.dlt != null) {
            this.dlt.qp(this.eeT.dkZ);
        }
        aEh();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.dlt = aVar;
    }

    private boolean atv() {
        if (com.baidu.swan.apps.runtime.e.aMk() == null || !com.baidu.swan.apps.runtime.e.aMk().aMD()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c asT = ajs.asT();
        if (asT == null || !(asT instanceof j)) {
            return true;
        }
        return ((j) asT).atv();
    }

    private void aEh() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.eeT.toString());
        }
        setLooping(this.eeT.mLoop);
        setVolume(this.eeT.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aXt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aXK().aXM().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.eeQ == PlayerStatus.PREPARED) {
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
    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.eeQ = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.eeZ) {
                AudioPlayer.this.wK("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.eeW);
            }
            AudioPlayer.this.eeZ = true;
            if (UserStatus.PLAY == AudioPlayer.this.eeR) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.eeT.efd > 0.0f) {
                    AudioPlayer.this.aXw().seek(AudioPlayer.this.eeT.efd);
                } else if (AudioPlayer.this.eeY >= 0.0f) {
                    AudioPlayer.this.aXw().seek(AudioPlayer.this.eeY);
                    AudioPlayer.this.eeY = -1.0f;
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
                if (!AudioPlayer.this.eeT.mLoop) {
                    AudioPlayer.this.eeR = UserStatus.STOP;
                    AudioPlayer.this.aXu();
                }
                AudioPlayer.this.wK("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.eeT.dkT + " url = " + AudioPlayer.this.eeT.mUrl);
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
            AudioPlayer.this.wJ(str);
            AudioPlayer.this.aXu();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.wK("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aXB()) {
                    AudioPlayer.this.eeV = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.dlt != null) {
                        AudioPlayer.this.wK("onBufferingUpdate");
                        if (AudioPlayer.this.eeQ == PlayerStatus.PREPARED && AudioPlayer.this.eeR != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.wK("onWaiting");
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
    public void wJ(String str) {
        if (this.dlt != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.dlt.h("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wK(String str) {
        m(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, JSONObject jSONObject) {
        if (this.dlt != null) {
            this.dlt.h(str, jSONObject);
        }
    }
}
