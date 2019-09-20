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
import java.io.File;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aBA;
    protected com.baidu.swan.apps.media.audio.b.a aCc;
    private com.baidu.swan.games.audio.b.c bfg;
    private int bfj;
    private String bfk;
    private a bfl;
    private boolean bfn;
    private String mDataSource;
    protected PlayerStatus bfe = PlayerStatus.NONE;
    protected UserStatus bff = UserStatus.OPEN;
    private d bfh = new d();
    private b bfi = new b();
    private float bfm = -1.0f;
    private TypedCallbackHandler bfo = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.aBA = "";
        this.aBA = str;
    }

    public void pause() {
        this.bff = UserStatus.PAUSE;
        GY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY() {
        try {
            QV().pause();
            iP("onPause");
            this.bfi.removeMessages(0);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void ah(float f) {
        try {
            iP("onSeeking");
            int i = (int) (1000.0f * f);
            if (this.bfe == PlayerStatus.PREPARED) {
                if (i >= 0 && i <= getDuration()) {
                    QV().seek(i);
                }
                this.bfm = -1.0f;
                return;
            }
            if (this.bfn && this.bfe == PlayerStatus.IDLE) {
                QY();
            }
            this.bfm = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.bfg != null && this.bfe == PlayerStatus.PREPARED) {
                QV().cM(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.bff = UserStatus.STOP;
            if (this.bfe == PlayerStatus.PREPARED) {
                QV().stop();
                QT();
                iP("onStop");
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        QT();
        this.bfn = false;
        this.bff = UserStatus.DESTROY;
        this.bfe = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QT() {
        try {
            this.bfe = PlayerStatus.IDLE;
            if (this.bfg != null) {
                this.bfg.destroy();
                this.bfg = null;
            }
            this.bfi.removeMessages(0);
            com.baidu.swan.apps.media.b.b(this);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public int getDuration() {
        try {
            if (this.bfe == PlayerStatus.PREPARED) {
                return QV().getDuration();
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
            return QV().getCurrentTime();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public boolean isPaused() {
        try {
            return QV().isPaused();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int QU() {
        return this.bfj;
    }

    public float getVolume() {
        if (this.bfh != null) {
            return this.bfh.aBL;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.bfg != null && this.bfe == PlayerStatus.PREPARED) {
                if (f > 1.0f) {
                    f = 1.0f;
                } else if (f < 0.0f) {
                    f = 0.0f;
                }
                QV().setVolume(f);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public com.baidu.swan.games.audio.b.c QV() {
        if (this.bfg == null || this.bfg.Rf()) {
            this.bfg = com.baidu.swan.games.audio.b.b.Rh().y(this.bfk, this.bfh.mLoop);
            registerListener();
        }
        return this.bfg;
    }

    protected void registerListener() {
        if (this.bfl == null) {
            this.bfl = new a();
        }
        this.bfg.setOnPreparedListener(this.bfl);
        this.bfg.setOnCompletionListener(this.bfl);
        this.bfg.setOnInfoListener(this.bfl);
        this.bfg.setOnErrorListener(this.bfl);
        this.bfg.a((MediaPlayer.OnSeekCompleteListener) this.bfl);
        this.bfg.a((MediaPlayer.OnBufferingUpdateListener) this.bfl);
    }

    @Override // com.baidu.swan.apps.media.a
    public String GQ() {
        return this.aBA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GR() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bfh.aBB;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GS() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null && Mh.Mt() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.RP()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioPlayer.this.GY();
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null && Mh.Mt()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null || !Mh.Mt()) {
            return null;
        }
        Activity activity = Mh.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vI = ((SwanAppActivity) activity).vI();
            if (vI instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vI).getV8Engine();
            }
            return null;
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.bfg != null) {
            QT();
        }
        this.bff = UserStatus.OPEN;
        this.bfh = dVar;
        this.bfj = 0;
        String str = this.bfh.mUrl;
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.bfo)) {
                str = com.baidu.swan.games.f.g.jz(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, Mh);
            }
        }
        this.mDataSource = str;
        this.bfe = PlayerStatus.IDLE;
        iP("onWaiting");
        QW();
    }

    private void QW() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b Rh = com.baidu.swan.games.audio.b.b.Rh();
                File file = new File(Rh.iU(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.bfk = file.getAbsolutePath();
                    QX();
                } else {
                    Rh.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aQ(String str, String str2) {
                            AudioPlayer.this.bfk = str2;
                            AudioPlayer.this.QX();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void t(int i, String str) {
                            AudioPlayer.this.iO(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.bfk = this.mDataSource;
                QX();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QX() {
        QY();
    }

    private void QY() {
        try {
            QV().setSrc(this.bfk);
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "set data source fail");
                e.printStackTrace();
            }
            iO("10003");
        }
    }

    public void play() {
        this.bff = UserStatus.PLAY;
        if (this.bfn) {
            try {
                if (!AV() && QZ()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.bfe == PlayerStatus.PREPARED) {
                        com.baidu.swan.apps.media.b.a(this);
                        this.bfi.sendEmptyMessage(0);
                        Hc();
                        QV().play();
                        iP("onPlay");
                    } else if (this.bfe == PlayerStatus.IDLE) {
                        try {
                            QV().setSrc(this.bfk);
                            this.bfe = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            iO(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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

    private boolean QZ() throws JSONException {
        File file = new File(this.bfk);
        if (!file.exists() || file.isDirectory()) {
            iO("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "Audio Update : " + dVar);
        }
        this.bfh = dVar;
        if (this.aCc != null) {
            this.aCc.fp(this.bfh.aBG);
        }
        Hc();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.aCc = aVar;
    }

    private boolean AV() {
        if (com.baidu.swan.apps.ae.b.Mh() == null || !com.baidu.swan.apps.ae.b.Mh().Mt()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Av = vN.Av();
        if (Av == null || !(Av instanceof h)) {
            return true;
        }
        return ((h) Av).AV();
    }

    private void Hc() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.bfh.toString());
        }
        setLooping(this.bfh.mLoop);
        setVolume(this.bfh.aBL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.bfe == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.QV().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.QV().getDuration() / 1000));
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
            AudioPlayer.this.bfe = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.bfn) {
                AudioPlayer.this.iP("onCanplay");
            }
            AudioPlayer.this.bfn = true;
            if (UserStatus.PLAY == AudioPlayer.this.bff) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.bfh.bfq > 0.0f) {
                    AudioPlayer.this.QV().seek(AudioPlayer.this.bfh.bfq);
                } else if (AudioPlayer.this.bfm >= 0.0f) {
                    AudioPlayer.this.QV().seek(AudioPlayer.this.bfm);
                    AudioPlayer.this.bfm = -1.0f;
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
                if (!AudioPlayer.this.bfh.mLoop) {
                    AudioPlayer.this.bff = UserStatus.STOP;
                    AudioPlayer.this.QT();
                    com.baidu.swan.apps.media.b.b(AudioPlayer.this);
                }
                AudioPlayer.this.iP("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.bfh.aBA + " url = " + AudioPlayer.this.bfh.mUrl);
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
            AudioPlayer.this.iO(str);
            AudioPlayer.this.QT();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.iP("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.bfe == PlayerStatus.PREPARED) {
                    AudioPlayer.this.bfj = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.aCc != null) {
                        AudioPlayer.this.iP("onBufferingUpdate");
                        if (AudioPlayer.this.bfe == PlayerStatus.PREPARED && AudioPlayer.this.bff != UserStatus.STOP && (AudioPlayer.this.QV().getDuration() * i) / 100 <= AudioPlayer.this.QV().getCurrentTime()) {
                            AudioPlayer.this.iP("onWaiting");
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
    public void iO(String str) {
        if (this.aCc != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.aCc.f("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.aCc != null) {
            this.aCc.f(str, jSONObject);
        }
    }
}
