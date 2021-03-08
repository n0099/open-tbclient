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
    private String djT;
    protected com.baidu.swan.apps.media.audio.b.a dkt;
    private com.baidu.swan.games.audio.b.c edO;
    private int edR;
    private String edS;
    private a edT;
    private boolean edV;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus edM = PlayerStatus.NONE;
    protected UserStatus edN = UserStatus.OPEN;
    private d edP = new d();
    private b edQ = new b();
    private float edU = -1.0f;
    private TypedCallbackHandler edW = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.djT = "";
        this.djT = str;
    }

    public void pause() {
        this.edN = UserStatus.PAUSE;
        aAM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAM() {
        if (aTX()) {
            this.edO.pause();
        }
    }

    private void aTP() {
        vZ(MissionEvent.MESSAGE_PAUSE);
        this.edQ.removeMessages(0);
    }

    public void ab(float f) {
        try {
            vZ("onSeeking");
            int i = (int) (1000.0f * f);
            if (aTX()) {
                if (i >= 0 && i <= getDuration()) {
                    this.edO.seek(i);
                }
                this.edU = -1.0f;
                return;
            }
            if (this.edV && this.edM == PlayerStatus.IDLE) {
                aTV();
            }
            this.edU = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aTX()) {
                this.edO.hZ(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.edN = UserStatus.STOP;
        if (aTX()) {
            this.edO.stop();
        }
        aTQ();
        vZ(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aTQ();
        this.edV = false;
        this.edN = UserStatus.DESTROY;
        this.edM = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTQ() {
        this.edM = PlayerStatus.IDLE;
        if (this.edO != null) {
            this.edO.destroy();
            this.edO = null;
        }
        this.edQ.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.edO != null) {
                return this.edO.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aTX()) {
            return this.edO.getCurrentTime();
        }
        return 0;
    }

    public int aTR() {
        return this.edR;
    }

    public float getVolume() {
        if (this.edP != null) {
            return this.edP.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aTX()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.edO.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aTS() {
        if (this.edO == null || this.edO.aUk()) {
            this.edO = com.baidu.swan.games.audio.b.b.aUg().ak(this.edS, this.edP.mLoop);
            registerListener();
        }
        return this.edO;
    }

    protected void registerListener() {
        if (this.edT == null) {
            this.edT = new a();
        }
        this.edO.setOnPreparedListener(this.edT);
        this.edO.setOnCompletionListener(this.edT);
        this.edO.setOnInfoListener(this.edT);
        this.edO.setOnErrorListener(this.edT);
        this.edO.a((MediaPlayer.OnSeekCompleteListener) this.edT);
        this.edO.a((MediaPlayer.OnBufferingUpdateListener) this.edT);
        this.edO.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String awF() {
        return this.djT;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAH() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.edP.cFI;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAI() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fX(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null && aIN.aJg() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aWh()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aUg().aUi().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.aAM();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fY(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null && aIN.aJg()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null || !aIN.aJg()) {
            return null;
        }
        SwanAppActivity aIH = aIN.aIH();
        if (aIH == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c afT = aIH.afT();
        if (afT instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) afT).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.edO != null) {
            aTQ();
        }
        this.edN = UserStatus.OPEN;
        this.edP = dVar;
        this.edR = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.aAo().azU().tt(this.edP.mUrl);
        this.edM = PlayerStatus.IDLE;
        vZ("onWaiting");
        aTT();
    }

    private void aTT() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aUg = com.baidu.swan.games.audio.b.b.aUg();
                File file = new File(aUg.wf(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.edS = file.getAbsolutePath();
                    aTU();
                } else {
                    aUg.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void cK(String str, String str2) {
                            AudioPlayer.this.edS = str2;
                            AudioPlayer.this.aTU();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void aB(int i, String str) {
                            AudioPlayer.this.vY(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.edS = this.mDataSource;
                aTU();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTU() {
        aTV();
    }

    private void aTV() {
        try {
            File file = new File(this.edS);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aUg().wg(this.edS);
                if (0 != this.mDuration) {
                    aTS().setSrc(this.edS);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.edS);
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
        vY("10003");
    }

    public boolean aTW() {
        return (UserStatus.STOP == this.edN || UserStatus.DESTROY == this.edN) ? false : true;
    }

    public void play() {
        this.edN = UserStatus.PLAY;
        if (this.edV) {
            try {
                if (!aqc() && aTY()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.edS);
                    }
                    if (this.edM == PlayerStatus.PREPARED) {
                        this.edQ.sendEmptyMessage(0);
                        aAP();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.edS);
                        }
                        aTS().play();
                        vZ("onPlay");
                    } else if (this.edM == PlayerStatus.IDLE) {
                        try {
                            aTS().setSrc(this.edS);
                            this.edM = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            vY(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aTX() {
        return this.edO != null && this.edM == PlayerStatus.PREPARED;
    }

    private boolean aTY() throws JSONException {
        File file = new File(this.edS);
        if (!file.exists() || file.isDirectory()) {
            vY("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.edP = dVar;
        if (this.dkt != null) {
            this.dkt.pD(this.edP.djZ);
        }
        aAP();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.dkt = aVar;
    }

    private boolean aqc() {
        if (com.baidu.swan.apps.runtime.e.aIN() == null || !com.baidu.swan.apps.runtime.e.aIN().aJg()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c apA = aga.apA();
        if (apA == null || !(apA instanceof j)) {
            return true;
        }
        return ((j) apA).aqc();
    }

    private void aAP() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.edP.toString());
        }
        setLooping(this.edP.mLoop);
        setVolume(this.edP.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aTP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aUg().aUi().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.edM == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.getCurrentPosition() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.getDuration() / 1000));
                    AudioPlayer.this.n("onTimeUpdate", jSONObject);
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
            AudioPlayer.this.edM = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.edV) {
                AudioPlayer.this.vZ("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.edS);
            }
            AudioPlayer.this.edV = true;
            if (UserStatus.PLAY == AudioPlayer.this.edN) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.edP.edZ > 0.0f) {
                    AudioPlayer.this.aTS().seek(AudioPlayer.this.edP.edZ);
                } else if (AudioPlayer.this.edU >= 0.0f) {
                    AudioPlayer.this.aTS().seek(AudioPlayer.this.edU);
                    AudioPlayer.this.edU = -1.0f;
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
                if (!AudioPlayer.this.edP.mLoop) {
                    AudioPlayer.this.edN = UserStatus.STOP;
                    AudioPlayer.this.aTQ();
                }
                AudioPlayer.this.vZ("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.edP.djT + " url = " + AudioPlayer.this.edP.mUrl);
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
            AudioPlayer.this.vY(str);
            AudioPlayer.this.aTQ();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.vZ("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aTX()) {
                    AudioPlayer.this.edR = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.dkt != null) {
                        AudioPlayer.this.vZ("onBufferingUpdate");
                        if (AudioPlayer.this.edM == PlayerStatus.PREPARED && AudioPlayer.this.edN != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.vZ("onWaiting");
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
    public void vY(String str) {
        if (this.dkt != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.dkt.i("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ(String str) {
        n(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, JSONObject jSONObject) {
        if (this.dkt != null) {
            this.dkt.i(str, jSONObject);
        }
    }
}
