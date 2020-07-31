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
    protected com.baidu.swan.apps.media.audio.b.a cqT;
    private String cqu;
    private com.baidu.swan.games.audio.b.c ddY;
    private int deb;
    private String dec;
    private a ded;
    private boolean def;
    private String mDataSource;
    private long mDuration;
    protected PlayerStatus ddW = PlayerStatus.NONE;
    protected UserStatus ddX = UserStatus.OPEN;
    private d ddZ = new d();
    private b dea = new b();
    private float dee = -1.0f;
    private TypedCallbackHandler deg = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.cqu = "";
        this.cqu = str;
    }

    public void pause() {
        this.ddX = UserStatus.PAUSE;
        akJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        if (aCh()) {
            this.ddY.pause();
        }
    }

    private void aBZ() {
        se(MissionEvent.MESSAGE_PAUSE);
        this.dea.removeMessages(0);
    }

    public void K(float f) {
        try {
            se("onSeeking");
            int i = (int) (1000.0f * f);
            if (aCh()) {
                if (i >= 0 && i <= getDuration()) {
                    this.ddY.seek(i);
                }
                this.dee = -1.0f;
                return;
            }
            if (this.def && this.ddW == PlayerStatus.IDLE) {
                aCf();
            }
            this.dee = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (aCh()) {
                this.ddY.ge(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.ddX = UserStatus.STOP;
        if (aCh()) {
            this.ddY.stop();
        }
        aCa();
        se(MissionEvent.MESSAGE_STOP);
    }

    public void release() {
        aCa();
        this.def = false;
        this.ddX = UserStatus.DESTROY;
        this.ddW = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCa() {
        this.ddW = PlayerStatus.IDLE;
        if (this.ddY != null) {
            this.ddY.destroy();
            this.ddY = null;
        }
        this.dea.removeMessages(0);
    }

    public long getDuration() {
        try {
            if (0 == this.mDuration && this.ddY != null) {
                return this.ddY.getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this.mDuration;
    }

    public int getCurrentPosition() {
        if (aCh()) {
            return this.ddY.getCurrentTime();
        }
        return 0;
    }

    public int aCb() {
        return this.deb;
    }

    public float getVolume() {
        if (this.ddZ != null) {
            return this.ddZ.mVolume;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        if (aCh()) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            try {
                this.ddY.setVolume(f);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public com.baidu.swan.games.audio.b.c aCc() {
        if (this.ddY == null || this.ddY.aCu()) {
            this.ddY = com.baidu.swan.games.audio.b.b.aCq().Z(this.dec, this.ddZ.mLoop);
            registerListener();
        }
        return this.ddY;
    }

    protected void registerListener() {
        if (this.ded == null) {
            this.ded = new a();
        }
        this.ddY.setOnPreparedListener(this.ded);
        this.ddY.setOnCompletionListener(this.ded);
        this.ddY.setOnInfoListener(this.ded);
        this.ddY.setOnErrorListener(this.ded);
        this.ddY.a((MediaPlayer.OnSeekCompleteListener) this.ded);
        this.ddY.a((MediaPlayer.OnBufferingUpdateListener) this.ded);
        this.ddY.a(this);
    }

    @Override // com.baidu.swan.apps.media.a
    public String agP() {
        return this.cqu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String akD() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.ddZ.bOl;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object akE() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void er(boolean z) {
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null && arv.arO() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.aEr()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.audio.b.b.aCq().aCs().post(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.akJ();
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void es(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null && arv.arO()) {
            release();
        }
    }

    private com.baidu.swan.games.f.a getV8Engine() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv == null || !arv.arO()) {
            return null;
        }
        SwanAppActivity arp = arv.arp();
        if (arp == null) {
            return null;
        }
        com.baidu.swan.apps.framework.c RV = arp.RV();
        if (RV instanceof com.baidu.swan.games.j.b) {
            return ((com.baidu.swan.games.j.b) RV).getV8Engine();
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.ddY != null) {
            aCa();
        }
        this.ddX = UserStatus.OPEN;
        this.ddZ = dVar;
        this.deb = 0;
        this.mDataSource = com.baidu.swan.apps.v.f.akr().ajX().pR(this.ddZ.mUrl);
        this.ddW = PlayerStatus.IDLE;
        se("onWaiting");
        aCd();
    }

    private void aCd() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b aCq = com.baidu.swan.games.audio.b.b.aCq();
                File file = new File(aCq.sk(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.dec = file.getAbsolutePath();
                    aCe();
                } else {
                    aCq.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void ch(String str, String str2) {
                            AudioPlayer.this.dec = str2;
                            AudioPlayer.this.aCe();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void ae(int i, String str) {
                            AudioPlayer.this.sd(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.dec = this.mDataSource;
                aCe();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCe() {
        aCf();
    }

    private void aCf() {
        try {
            File file = new File(this.dec);
            if (file.exists() && !file.isDirectory()) {
                this.mDuration = com.baidu.swan.games.audio.b.b.aCq().sl(this.dec);
                if (0 != this.mDuration) {
                    aCc().setSrc(this.dec);
                    if (DEBUG) {
                        Log.e("SwanAppAudioPlayer", "setSrc path: " + this.dec);
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
        sd("10003");
    }

    public boolean aCg() {
        return (UserStatus.STOP == this.ddX || UserStatus.DESTROY == this.ddX) ? false : true;
    }

    public void play() {
        this.ddX = UserStatus.PLAY;
        if (this.def) {
            try {
                if (!abC() && aCi()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play music first: " + this.dec);
                    }
                    if (this.ddW == PlayerStatus.PREPARED) {
                        this.dea.sendEmptyMessage(0);
                        akM();
                        if (DEBUG) {
                            Log.d("SwanAppAudioPlayer", "play music: " + this.dec);
                        }
                        aCc().play();
                        se("onPlay");
                    } else if (this.ddW == PlayerStatus.IDLE) {
                        try {
                            aCc().setSrc(this.dec);
                            this.ddW = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            sd(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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
    public boolean aCh() {
        return this.ddY != null && this.ddW == PlayerStatus.PREPARED;
    }

    private boolean aCi() throws JSONException {
        File file = new File(this.dec);
        if (!file.exists() || file.isDirectory()) {
            sd("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        this.ddZ = dVar;
        if (this.cqT != null) {
            this.cqT.mj(this.ddZ.cqA);
        }
        akM();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.cqT = aVar;
    }

    private boolean abC() {
        if (com.baidu.swan.apps.runtime.e.arv() == null || !com.baidu.swan.apps.runtime.e.arv().arO()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
        if (aaZ == null || !(aaZ instanceof j)) {
            return true;
        }
        return ((j) aaZ).abC();
    }

    private void akM() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.ddZ.toString());
        }
        setLooping(this.ddZ.mLoop);
        setVolume(this.ddZ.mVolume);
    }

    @Override // com.baidu.swan.nalib.audio.c
    public void onPause() {
        aBZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends Handler {
        public b() {
            super(com.baidu.swan.games.audio.b.b.aCq().aCs().getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.ddW == PlayerStatus.PREPARED) {
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
    /* loaded from: classes7.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.ddW = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.def) {
                AudioPlayer.this.se("onCanplay");
            }
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "prepare 2 path: " + AudioPlayer.this.dec);
            }
            AudioPlayer.this.def = true;
            if (UserStatus.PLAY == AudioPlayer.this.ddX) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.ddZ.dej > 0.0f) {
                    AudioPlayer.this.aCc().seek(AudioPlayer.this.ddZ.dej);
                } else if (AudioPlayer.this.dee >= 0.0f) {
                    AudioPlayer.this.aCc().seek(AudioPlayer.this.dee);
                    AudioPlayer.this.dee = -1.0f;
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
                if (!AudioPlayer.this.ddZ.mLoop) {
                    AudioPlayer.this.ddX = UserStatus.STOP;
                    AudioPlayer.this.aCa();
                }
                AudioPlayer.this.se("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.ddZ.cqu + " url = " + AudioPlayer.this.ddZ.mUrl);
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
            AudioPlayer.this.sd(str);
            AudioPlayer.this.aCa();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.se("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aCh()) {
                    AudioPlayer.this.deb = (((int) AudioPlayer.this.getDuration()) * i) / 100;
                    if (AudioPlayer.this.cqT != null) {
                        AudioPlayer.this.se("onBufferingUpdate");
                        if (AudioPlayer.this.ddW == PlayerStatus.PREPARED && AudioPlayer.this.ddX != UserStatus.STOP && (i * AudioPlayer.this.getDuration()) / 100 <= AudioPlayer.this.getCurrentPosition()) {
                            AudioPlayer.this.se("onWaiting");
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
    public void sd(String str) {
        if (this.cqT != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.cqT.e("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.cqT != null) {
            this.cqT.e(str, jSONObject);
        }
    }
}
