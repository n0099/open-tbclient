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
    protected com.baidu.swan.apps.media.audio.b.a aBE;
    private String aBc;
    private com.baidu.swan.games.audio.b.c beH;
    private int beK;
    private String beL;
    private a beM;
    private boolean beO;
    private String mDataSource;
    protected PlayerStatus beF = PlayerStatus.NONE;
    protected UserStatus beG = UserStatus.OPEN;
    private d beI = new d();
    private b beJ = new b();
    private float beN = -1.0f;
    private TypedCallbackHandler beP = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.aBc = "";
        this.aBc = str;
    }

    public void pause() {
        this.beG = UserStatus.PAUSE;
        GU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        try {
            QR().pause();
            iN("onPause");
            this.beJ.removeMessages(0);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void ah(float f) {
        try {
            iN("onSeeking");
            int i = (int) (1000.0f * f);
            if (this.beF == PlayerStatus.PREPARED) {
                if (i >= 0 && i <= getDuration()) {
                    QR().seek(i);
                }
                this.beN = -1.0f;
                return;
            }
            if (this.beO && this.beF == PlayerStatus.IDLE) {
                QU();
            }
            this.beN = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.beH != null && this.beF == PlayerStatus.PREPARED) {
                QR().cM(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.beG = UserStatus.STOP;
            if (this.beF == PlayerStatus.PREPARED) {
                QR().stop();
                QP();
                iN("onStop");
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        QP();
        this.beO = false;
        this.beG = UserStatus.DESTROY;
        this.beF = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QP() {
        try {
            this.beF = PlayerStatus.IDLE;
            if (this.beH != null) {
                this.beH.destroy();
                this.beH = null;
            }
            this.beJ.removeMessages(0);
            com.baidu.swan.apps.media.b.b(this);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public int getDuration() {
        try {
            if (this.beF == PlayerStatus.PREPARED) {
                return QR().getDuration();
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
            return QR().getCurrentTime();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public boolean isPaused() {
        try {
            return QR().isPaused();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int QQ() {
        return this.beK;
    }

    public float getVolume() {
        if (this.beI != null) {
            return this.beI.aBn;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.beH != null && this.beF == PlayerStatus.PREPARED) {
                if (f > 1.0f) {
                    f = 1.0f;
                } else if (f < 0.0f) {
                    f = 0.0f;
                }
                QR().setVolume(f);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public com.baidu.swan.games.audio.b.c QR() {
        if (this.beH == null || this.beH.Rb()) {
            this.beH = com.baidu.swan.games.audio.b.b.Rd().y(this.beL, this.beI.mLoop);
            registerListener();
        }
        return this.beH;
    }

    protected void registerListener() {
        if (this.beM == null) {
            this.beM = new a();
        }
        this.beH.setOnPreparedListener(this.beM);
        this.beH.setOnCompletionListener(this.beM);
        this.beH.setOnInfoListener(this.beM);
        this.beH.setOnErrorListener(this.beM);
        this.beH.a((MediaPlayer.OnSeekCompleteListener) this.beM);
        this.beH.a((MediaPlayer.OnBufferingUpdateListener) this.beM);
    }

    @Override // com.baidu.swan.apps.media.a
    public String GM() {
        return this.aBc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GN() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.beI.aBd;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null && Md.Mp() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.RL()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioPlayer.this.GU();
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
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null && Md.Mp()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null || !Md.Mp()) {
            return null;
        }
        Activity activity = Md.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vE = ((SwanAppActivity) activity).vE();
            if (vE instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vE).getV8Engine();
            }
            return null;
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.beH != null) {
            QP();
        }
        this.beG = UserStatus.OPEN;
        this.beI = dVar;
        this.beK = 0;
        String str = this.beI.mUrl;
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.beP)) {
                str = com.baidu.swan.games.f.g.jx(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, Md);
            }
        }
        this.mDataSource = str;
        this.beF = PlayerStatus.IDLE;
        iN("onWaiting");
        QS();
    }

    private void QS() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b Rd = com.baidu.swan.games.audio.b.b.Rd();
                File file = new File(Rd.iS(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.beL = file.getAbsolutePath();
                    QT();
                } else {
                    Rd.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aQ(String str, String str2) {
                            AudioPlayer.this.beL = str2;
                            AudioPlayer.this.QT();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void t(int i, String str) {
                            AudioPlayer.this.iM(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.beL = this.mDataSource;
                QT();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QT() {
        QU();
    }

    private void QU() {
        try {
            QR().setSrc(this.beL);
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "set data source fail");
                e.printStackTrace();
            }
            iM("10003");
        }
    }

    public void play() {
        this.beG = UserStatus.PLAY;
        if (this.beO) {
            try {
                if (!AR() && QV()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.beF == PlayerStatus.PREPARED) {
                        com.baidu.swan.apps.media.b.a(this);
                        this.beJ.sendEmptyMessage(0);
                        GY();
                        QR().play();
                        iN("onPlay");
                    } else if (this.beF == PlayerStatus.IDLE) {
                        try {
                            QR().setSrc(this.beL);
                            this.beF = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            iM(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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

    private boolean QV() throws JSONException {
        File file = new File(this.beL);
        if (!file.exists() || file.isDirectory()) {
            iM("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "Audio Update : " + dVar);
        }
        this.beI = dVar;
        if (this.aBE != null) {
            this.aBE.fn(this.beI.aBi);
        }
        GY();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.aBE = aVar;
    }

    private boolean AR() {
        if (com.baidu.swan.apps.ae.b.Md() == null || !com.baidu.swan.apps.ae.b.Md().Mp()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Ar = vJ.Ar();
        if (Ar == null || !(Ar instanceof h)) {
            return true;
        }
        return ((h) Ar).AR();
    }

    private void GY() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.beI.toString());
        }
        setLooping(this.beI.mLoop);
        setVolume(this.beI.aBn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.beF == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.QR().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(AudioPlayer.this.QR().getDuration() / 1000));
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
            AudioPlayer.this.beF = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.beO) {
                AudioPlayer.this.iN("onCanplay");
            }
            AudioPlayer.this.beO = true;
            if (UserStatus.PLAY == AudioPlayer.this.beG) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.beI.beR > 0.0f) {
                    AudioPlayer.this.QR().seek(AudioPlayer.this.beI.beR);
                } else if (AudioPlayer.this.beN >= 0.0f) {
                    AudioPlayer.this.QR().seek(AudioPlayer.this.beN);
                    AudioPlayer.this.beN = -1.0f;
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
                if (!AudioPlayer.this.beI.mLoop) {
                    AudioPlayer.this.beG = UserStatus.STOP;
                    AudioPlayer.this.QP();
                    com.baidu.swan.apps.media.b.b(AudioPlayer.this);
                }
                AudioPlayer.this.iN("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.beI.aBc + " url = " + AudioPlayer.this.beI.mUrl);
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
            AudioPlayer.this.iM(str);
            AudioPlayer.this.QP();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.iN("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.beF == PlayerStatus.PREPARED) {
                    AudioPlayer.this.beK = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.aBE != null) {
                        AudioPlayer.this.iN("onBufferingUpdate");
                        if (AudioPlayer.this.beF == PlayerStatus.PREPARED && AudioPlayer.this.beG != UserStatus.STOP && (AudioPlayer.this.QR().getDuration() * i) / 100 <= AudioPlayer.this.QR().getCurrentTime()) {
                            AudioPlayer.this.iN("onWaiting");
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
    public void iM(String str) {
        if (this.aBE != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.aBE.f("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iN(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.aBE != null) {
            this.aBE.f(str, jSONObject);
        }
    }
}
