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
    private String bAL;
    protected com.baidu.swan.apps.media.audio.b.a bBj;
    private com.baidu.swan.games.audio.b.c cjW;
    private int cjZ;
    private String cka;
    private a ckb;
    private boolean ckd;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus cjU = PlayerStatus.NONE;
    protected UserStatus cjV = UserStatus.OPEN;
    private d cjX = new d();
    private b cjY = new b();
    private float ckc = -1.0f;
    private TypedCallbackHandler cke = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.bAL = "";
        this.bAL = str;
    }

    public void pause() {
        this.cjV = UserStatus.PAUSE;
        Xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xj() {
        if (alv()) {
            this.cjW.pause();
        }
    }

    private void aln() {
        ok(MissionEvent.MESSAGE_PAUSE);
        this.cjY.removeMessages(0);
    }

    public void Z(float f) {
        try {
            ok("onSeeking");
            int i = (int) (1000.0f * f);
            if (alv()) {
                if (i >= 0 && i <= getDuration()) {
                    this.cjW.seek(i);
                }
                this.ckc = -1.0f;
                return;
            }
            if (this.ckd && this.cjU == PlayerStatus.IDLE) {
                alt();
            }
            this.ckc = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (alv()) {
                this.cjW.eA(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.cjV = UserStatus.STOP;
        if (alv()) {
            this.cjW.stop();
        }
        alo();
        ok(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        alo();
        this.ckd = false;
        this.cjV = UserStatus.DESTROY;
        this.cjU = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alo() {
        this.cjU = PlayerStatus.IDLE;
        if (this.cjW != null) {
            this.cjW.destroy();
            this.cjW = null;
        }
        this.cjY.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.cjW != null) {
                return this.cjW.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (alv()) {
            return this.cjW.getCurrentTime();
        }
        return 0;
    }

    public int alp() {
        return this.cjZ;
    }

    public float getVolume() {
        if (this.cjX != null) {
            return this.cjX.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (alv()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.cjW.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c alq() {
        if (this.cjW == null || this.cjW.alI()) {
            this.cjW = com.baidu.swan.games.audio.b.b.alE().G(this.cka, this.cjX.mLoop);
            registerListener();
        }
        return this.cjW;
    }

    protected void registerListener() {
        if (this.ckb == null) {
            this.ckb = new a();
        }
        this.cjW.setOnPreparedListener(this.ckb);
        this.cjW.setOnCompletionListener(this.ckb);
        this.cjW.setOnInfoListener(this.ckb);
        this.cjW.setOnErrorListener(this.ckb);
        this.cjW.a((MediaPlayer.OnSeekCompleteListener) this.ckb);
        this.cjW.a((MediaPlayer.OnBufferingUpdateListener) this.ckb);
        this.cjW.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xd() {
        return this.bAL;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xe() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cjX.bcw;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xf() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null && acI.acZ() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.anE()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.alE().alG().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.Xj();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cS(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null && acI.acZ()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI == null || !acI.acZ()) {
            return null;
        }
        SwanAppActivity acE = acI.acE();
        if (acE == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c GA = acE.GA();
        if (GA instanceof com.baidu.swan.games.i.b) {
            return ((com.baidu.swan.games.i.b) GA).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.cjW != null) {
            alo();
        }
        this.cjV = UserStatus.OPEN;
        this.cjX = dVar;
        this.cjZ = 0;
        this.mDataSource = com.baidu.swan.apps.y.f.WV().WC().mf(this.cjX.mUrl);
        this.cjU = PlayerStatus.IDLE;
        ok("onWaiting");
        alr();
    }

    private void alr() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b alE = com.baidu.swan.games.audio.b.b.alE();
                File file = new File(alE.or(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.cka = file.getAbsolutePath();
                    als();
                } else {
                    alE.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void bz(String str, String str2) {
                            AudioPlayer.this.cka = str2;
                            AudioPlayer.this.als();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void G(int i, String str) {
                            AudioPlayer.this.oj(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.cka = this.mDataSource;
                als();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void als() {
        alt();
    }

    private void alt() {
        try {
            File file = new File(this.cka);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.alE().os(this.cka);
                if (0 != this.mDuration) {
                    alq().setSrc(this.cka);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.cka);
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
        oj("10003");
    }

    public boolean alu() {
        return (UserStatus.STOP == this.cjV || UserStatus.DESTROY == this.cjV) ? false : true;
    }

    public void play() {
        this.cjV = UserStatus.PLAY;
        if (this.ckd) {
            try {
                if (!OU() && alw()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.cka);
                    }
                    if (this.cjU == PlayerStatus.PREPARED) {
                        this.cjY.sendEmptyMessage(0);
                        Xl();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.cka);
                        }
                        alq().play();
                        ok("onPlay");
                    } else if (this.cjU == PlayerStatus.IDLE) {
                        try {
                            alq().setSrc(this.cka);
                            this.cjU = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            oj(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean alv() {
        return this.cjW != null && this.cjU == PlayerStatus.PREPARED;
    }

    private boolean alw() throws JSONException {
        File file = new File(this.cka);
        if (!file.exists() || file.isDirectory()) {
            oj("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.cjX = dVar;
        if (this.bBj != null) {
            this.bBj.ja(this.cjX.bAQ);
        }
        Xl();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.bBj = aVar;
    }

    private boolean OU() {
        if (com.baidu.swan.apps.runtime.e.acI() == null || !com.baidu.swan.apps.runtime.e.acI().acZ()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Oq = GH.Oq();
        if (Oq == null || !(Oq instanceof i)) {
            return true;
        }
        return ((i) Oq).OU();
    }

    private void Xl() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.cjX.toString());
        }
        setLooping(this.cjX.mLoop);
        setVolume(this.cjX.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aln();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.alE().alG().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.cjU == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.getCurrentPosition() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.getDuration() / 1000));
                    AudioPlayer.this.i("onTimeUpdate", jSONObject);
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
            AudioPlayer.this.cjU = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.ckd) {
                AudioPlayer.this.ok("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.cka);
            }
            AudioPlayer.this.ckd = true;
            if (UserStatus.PLAY == AudioPlayer.this.cjV) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.cjX.ckh > 0.0f) {
                    AudioPlayer.this.alq().seek(AudioPlayer.this.cjX.ckh);
                } else if (AudioPlayer.this.ckc >= 0.0f) {
                    AudioPlayer.this.alq().seek(AudioPlayer.this.ckc);
                    AudioPlayer.this.ckc = -1.0f;
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
                if (!AudioPlayer.this.cjX.mLoop) {
                    AudioPlayer.this.cjV = UserStatus.STOP;
                    AudioPlayer.this.alo();
                }
                AudioPlayer.this.ok("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.cjX.bAL + " url = " + AudioPlayer.this.cjX.mUrl);
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
            AudioPlayer.this.oj(str);
            AudioPlayer.this.alo();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.ok("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.alv()) {
                    AudioPlayer.this.cjZ = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.bBj != null) {
                        AudioPlayer.this.ok("onBufferingUpdate");
                        if (AudioPlayer.this.cjU == PlayerStatus.PREPARED && AudioPlayer.this.cjV != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.ok("onWaiting");
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
    public void oj(String str) {
        if (this.bBj != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.bBj.d("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(String str) {
        i(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, JSONObject jSONObject) {
        if (this.bBj != null) {
            this.bBj.d(str, jSONObject);
        }
    }
}
