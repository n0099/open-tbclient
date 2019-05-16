package com.baidu.swan.games.audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.ubc.UBC;
import java.io.File;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.media.audio.b.a aAW;
    private String aAu;
    private com.baidu.swan.games.audio.b.c bdT;
    private int bdW;
    private String bdX;
    private a bdY;
    private boolean bea;
    private String mDataSource;
    protected PlayerStatus bdR = PlayerStatus.NONE;
    protected UserStatus bdS = UserStatus.OPEN;
    private d bdU = new d();
    private b bdV = new b();
    private float bdZ = -1.0f;
    private TypedCallbackHandler beb = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
    /* loaded from: classes2.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayer(String str) {
        this.aAu = "";
        this.aAu = str;
    }

    public void pause() {
        this.bdS = UserStatus.PAUSE;
        Gk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk() {
        try {
            PZ().pause();
            iH("onPause");
            this.bdV.removeMessages(0);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void ah(float f) {
        try {
            iH("onSeeking");
            int i = (int) (1000.0f * f);
            if (this.bdR == PlayerStatus.PREPARED) {
                if (i >= 0 && i <= getDuration()) {
                    PZ().seek(i);
                }
                this.bdZ = -1.0f;
                return;
            }
            if (this.bea && this.bdR == PlayerStatus.IDLE) {
                Qc();
            }
            this.bdZ = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.bdT != null && this.bdR == PlayerStatus.PREPARED) {
                PZ().cJ(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.bdS = UserStatus.STOP;
            if (this.bdR == PlayerStatus.PREPARED) {
                PZ().stop();
                PX();
                iH("onStop");
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        PX();
        this.bea = false;
        this.bdS = UserStatus.DESTROY;
        this.bdR = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PX() {
        try {
            this.bdR = PlayerStatus.IDLE;
            if (this.bdT != null) {
                this.bdT.destroy();
                this.bdT = null;
            }
            this.bdV.removeMessages(0);
            com.baidu.swan.apps.media.b.b(this);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public int getDuration() {
        try {
            if (this.bdR == PlayerStatus.PREPARED) {
                return PZ().getDuration();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int getCurrentPosition() {
        try {
            return PZ().getCurrentTime();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public boolean isPaused() {
        try {
            return PZ().isPaused();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int PY() {
        return this.bdW;
    }

    public float getVolume() {
        if (this.bdU != null) {
            return this.bdU.aAF;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.bdT != null && this.bdR == PlayerStatus.PREPARED) {
                if (f > 1.0f) {
                    f = 1.0f;
                } else if (f < 0.0f) {
                    f = 0.0f;
                }
                PZ().setVolume(f);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public com.baidu.swan.games.audio.b.c PZ() {
        if (this.bdT == null || this.bdT.Qj()) {
            this.bdT = com.baidu.swan.games.audio.b.b.Ql().x(this.bdX, this.bdU.mLoop);
            registerListener();
        }
        return this.bdT;
    }

    protected void registerListener() {
        if (this.bdY == null) {
            this.bdY = new a();
        }
        this.bdT.setOnPreparedListener(this.bdY);
        this.bdT.setOnCompletionListener(this.bdY);
        this.bdT.setOnInfoListener(this.bdY);
        this.bdT.setOnErrorListener(this.bdY);
        this.bdT.setOnSeekCompleteListener(this.bdY);
        this.bdT.setOnBufferingUpdateListener(this.bdY);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gc() {
        return this.aAu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gd() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bdU.aAv;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ge() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bt(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && Lq.LC() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.QS()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioPlayer.this.Gk();
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bu(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && Lq.LC()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null || !Lq.LC()) {
            return null;
        }
        Activity activity = Lq.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vd = ((SwanAppActivity) activity).vd();
            if (vd instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vd).getV8Engine();
            }
            return null;
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.bdT != null) {
            PX();
        }
        this.bdS = UserStatus.OPEN;
        this.bdU = dVar;
        this.bdW = 0;
        String str = this.bdU.mUrl;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.beb)) {
                str = com.baidu.swan.games.f.g.jq(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, Lq);
            }
        }
        this.mDataSource = str;
        this.bdR = PlayerStatus.IDLE;
        iH("onWaiting");
        Qa();
    }

    private void Qa() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b Ql = com.baidu.swan.games.audio.b.b.Ql();
                File file = new File(Ql.iM(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.bdX = file.getAbsolutePath();
                    Qb();
                } else {
                    Ql.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aQ(String str, String str2) {
                            AudioPlayer.this.bdX = str2;
                            AudioPlayer.this.Qb();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void t(int i, String str) {
                            AudioPlayer.this.iG(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.bdX = this.mDataSource;
                Qb();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qb() {
        Qc();
    }

    private void Qc() {
        try {
            PZ().setSrc(this.bdX);
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "set data source fail");
                e.printStackTrace();
            }
            iG("10003");
        }
    }

    public void play() {
        this.bdS = UserStatus.PLAY;
        if (this.bea) {
            try {
                if (!Ak() && Qd()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.bdR == PlayerStatus.PREPARED) {
                        com.baidu.swan.apps.media.b.a(this);
                        this.bdV.sendEmptyMessage(0);
                        Go();
                        PZ().play();
                        iH("onPlay");
                    } else if (this.bdR == PlayerStatus.IDLE) {
                        try {
                            PZ().setSrc(this.bdX);
                            this.bdR = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            iG(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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

    private boolean Qd() throws JSONException {
        File file = new File(this.bdX);
        if (!file.exists() || file.isDirectory()) {
            iG("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "Audio Update : " + dVar);
        }
        this.bdU = dVar;
        if (this.aAW != null) {
            this.aAW.fj(this.bdU.aAA);
        }
        Go();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.aAW = aVar;
    }

    private boolean Ak() {
        if (com.baidu.swan.apps.ae.b.Lq() == null || !com.baidu.swan.apps.ae.b.Lq().LC()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b zK = vi.zK();
        if (zK == null || !(zK instanceof h)) {
            return true;
        }
        return ((h) zK).Ak();
    }

    private void Go() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.bdU.toString());
        }
        setLooping(this.bdU.mLoop);
        setVolume(this.bdU.aAF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.bdR == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.PZ().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(AudioPlayer.this.PZ().getDuration() / 1000));
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
    /* loaded from: classes2.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onPrepared");
            }
            AudioPlayer.this.bdR = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.bea) {
                AudioPlayer.this.iH("onCanplay");
            }
            AudioPlayer.this.bea = true;
            if (UserStatus.PLAY == AudioPlayer.this.bdS) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.bdU.bed > 0.0f) {
                    AudioPlayer.this.PZ().seek(AudioPlayer.this.bdU.bed);
                } else if (AudioPlayer.this.bdZ >= 0.0f) {
                    AudioPlayer.this.PZ().seek(AudioPlayer.this.bdZ);
                    AudioPlayer.this.bdZ = -1.0f;
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
                if (!AudioPlayer.this.bdU.mLoop) {
                    AudioPlayer.this.bdS = UserStatus.STOP;
                    AudioPlayer.this.PX();
                    com.baidu.swan.apps.media.b.b(AudioPlayer.this);
                }
                AudioPlayer.this.iH("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.bdU.aAu + " url = " + AudioPlayer.this.bdU.mUrl);
            }
            switch (i) {
                case 1:
                    str = LivenessStat.TYPE_STRING_DEFAULT;
                    break;
                case 100:
                    str = "10001";
                    break;
                default:
                    str = LivenessStat.TYPE_STRING_DEFAULT;
                    break;
            }
            if (i2 == -1007) {
                str = "10004";
            }
            AudioPlayer.this.iG(str);
            AudioPlayer.this.PX();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.iH("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.bdR == PlayerStatus.PREPARED) {
                    AudioPlayer.this.bdW = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.aAW != null) {
                        AudioPlayer.this.iH("onBufferingUpdate");
                        if (AudioPlayer.this.bdR == PlayerStatus.PREPARED && AudioPlayer.this.bdS != UserStatus.STOP && (AudioPlayer.this.PZ().getDuration() * i) / 100 <= AudioPlayer.this.PZ().getCurrentTime()) {
                            AudioPlayer.this.iH("onWaiting");
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
    public void iG(String str) {
        if (this.aAW != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.aAW.f("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.aAW != null) {
            this.aAW.f(str, jSONObject);
        }
    }
}
