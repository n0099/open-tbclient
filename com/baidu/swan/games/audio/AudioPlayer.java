package com.baidu.swan.games.audio;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.c.h;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.games.f.g;
import com.baidu.ubc.UBC;
import java.io.File;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.audio.b.e aZR;
    private b aZS;
    private int aZT;
    private String aZU;
    private a aZV;
    private int aZW;
    private boolean aZX;
    protected com.baidu.swan.apps.media.audio.b.a azY;
    private String azv;
    private String mDataSource;
    protected PlayerStatus aZP = PlayerStatus.NONE;
    protected UserStatus aZQ = UserStatus.OPEN;
    private com.baidu.swan.apps.media.audio.b azW = new com.baidu.swan.apps.media.audio.b();
    private TypedCallbackHandler aZY = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.azv = "";
        this.azv = str;
    }

    protected void start() {
        com.baidu.swan.apps.media.b.a(this);
        try {
            if (this.aZS == null) {
                this.aZS = new b();
            }
            this.aZS.sendEmptyMessage(0);
            if (this.azY != null) {
                this.azY.eZ("onPlay");
            }
            Es();
            if (this.azW.azA > 0 && this.azW.azA * 1000 <= getDuration()) {
                Nh().seek((int) (this.azW.azA * 1000));
            } else if (this.aZW > 0 && this.aZW * 1000 <= getDuration()) {
                Nh().seek((int) (this.aZW * 1000));
                this.aZW = 0;
            }
            if (zk()) {
                Eo();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        this.aZQ = UserStatus.PAUSE;
        Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        try {
            if (!Nh().isPaused() && this.azY != null) {
                this.azY.eZ("onPause");
            }
            Nh().pause();
            if (this.aZS != null) {
                this.aZS.removeMessages(0);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void seekTo(int i) {
        try {
            if (this.azY != null) {
                this.azY.eZ("onSeeking");
            }
            if (this.aZP == PlayerStatus.PREPARED) {
                if (i > 0 && i * 1000 <= getDuration()) {
                    Nh().seek((int) (i * 1000));
                }
                this.aZW = 0;
                return;
            }
            this.aZW = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.aZR != null && this.aZP == PlayerStatus.PREPARED) {
                Nh().ct(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.aZQ = UserStatus.STOP;
            if (this.aZP == PlayerStatus.PREPARED) {
                Nh().stop();
                Nf();
                if (this.azY != null) {
                    this.azY.eZ("onStop");
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        Nf();
        this.aZQ = UserStatus.DESTROY;
        this.aZP = PlayerStatus.NONE;
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nf() {
        try {
            this.aZP = PlayerStatus.IDLE;
            if (this.aZR != null) {
                this.aZR.destroy();
                this.aZR = null;
            }
            if (this.aZS != null) {
                this.aZS.removeMessages(0);
                this.aZS = null;
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private int Ep() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "System Volume is : " + streamVolume);
        }
        return streamVolume;
    }

    public int getDuration() {
        try {
            if (this.aZP == PlayerStatus.PREPARED) {
                return Nh().getDuration();
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
            return Nh().getCurrentTime();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public boolean isPaused() {
        try {
            return Nh().isPaused();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int Ng() {
        return this.aZT;
    }

    public float getVolume() {
        if (this.azW != null) {
            return this.azW.azH;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.aZR != null && this.aZP == PlayerStatus.PREPARED) {
                if (f > 1.0f) {
                    f = 1.0f;
                } else if (f < 0.0f) {
                    f = 0.0f;
                }
                Nh().setVolume(f);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public com.baidu.swan.games.audio.b.e Nh() {
        if (this.aZR == null || this.aZR.Np()) {
            this.aZR = com.baidu.swan.games.audio.b.b.Nr().ia(this.aZU);
            this.aZR.ct(this.azW.mLoop);
            this.aZR.setVolume(this.azW.azH);
            registerListener();
        }
        return this.aZR;
    }

    protected void registerListener() {
        if (this.aZV == null) {
            this.aZV = new a();
        }
        this.aZR.setOnPreparedListener(this.aZV);
        this.aZR.setOnCompletionListener(this.aZV);
        this.aZR.setOnInfoListener(this.aZV);
        this.aZR.setOnErrorListener(this.aZV);
        this.aZR.setOnSeekCompleteListener(this.aZV);
        this.aZR.setOnBufferingUpdateListener(this.aZV);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.azv;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eh() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.azW.azw;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ei() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bk(boolean z) {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && IV.Jh()) {
            if (!z) {
                com.baidu.swan.games.e.a v8Engine = getV8Engine();
                if (v8Engine != null && !v8Engine.NX()) {
                    v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.Eo();
                        }
                    });
                }
            } else if (this.aZQ == UserStatus.PLAY) {
                com.baidu.swan.apps.console.c.d("SwanAppAudioPlayer", "not play in games");
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bl(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && IV.Jh()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV == null || !IV.Jh()) {
            return null;
        }
        Activity activity = IV.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d ut = ((SwanAppActivity) activity).ut();
            if (ut instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) ut).getV8Engine();
            }
            return null;
        }
        return null;
    }

    public void b(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.aZR != null) {
            Nf();
        }
        this.aZQ = UserStatus.OPEN;
        this.azW = bVar;
        this.aZT = 0;
        String str = this.azW.mUrl;
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.aZY)) {
                str = g.iG(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, IV);
            }
        }
        this.mDataSource = str;
        this.aZP = PlayerStatus.IDLE;
        if (this.azY != null) {
            this.azY.eZ("onWaiting");
        }
        Ni();
    }

    private void Ni() {
        try {
            com.baidu.swan.games.audio.b.b Nr = com.baidu.swan.games.audio.b.b.Nr();
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                File file = new File(Nr.hZ(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.aZU = file.getAbsolutePath();
                    Nj();
                } else {
                    Nr.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aN(String str, String str2) {
                            AudioPlayer.this.aZU = str2;
                            AudioPlayer.this.Nj();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void s(int i, String str) {
                            if (AudioPlayer.this.azY != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                                        jSONObject.putOpt("errCode", "10002");
                                    } else {
                                        jSONObject.putOpt("errCode", LivenessStat.TYPE_STRING_DEFAULT);
                                    }
                                    AudioPlayer.this.azY.f("onError", jSONObject);
                                } catch (Exception e) {
                                    if (AudioPlayer.DEBUG) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
                }
            } else {
                this.aZU = this.mDataSource;
                Nj();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nj() {
        this.aZX = true;
        com.baidu.swan.games.audio.b.b.Nr().Ns().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                if (UserStatus.PLAY == AudioPlayer.this.aZQ) {
                    AudioPlayer.this.play();
                }
                if (AudioPlayer.this.azY != null) {
                    AudioPlayer.this.azY.eZ("onCanplay");
                }
            }
        }, 50L);
    }

    public void play() {
        this.aZQ = UserStatus.PLAY;
        if (this.aZX) {
            try {
                if (!zk()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.aZP == PlayerStatus.PREPARED) {
                        Nh().play();
                        if (this.aZS != null) {
                            this.aZS.sendEmptyMessage(0);
                        }
                        if (this.azY != null) {
                            this.azY.eZ("onPlay");
                        }
                    } else if (this.aZP == PlayerStatus.IDLE) {
                        try {
                            Nh().setSrc(this.aZU);
                            this.aZP = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            try {
                                if (this.azY != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
                                        jSONObject.putOpt("errCode", "10002");
                                    } else {
                                        jSONObject.putOpt("errCode", "10003");
                                    }
                                    this.azY.f("onError", jSONObject);
                                }
                            } catch (Exception e2) {
                                if (DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "set data source fail And un know  " + e2.getMessage());
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "Audio Update : " + bVar);
        }
        this.azW = bVar;
        if (this.azY != null) {
            this.azY.eY(this.azW.azC);
        }
        Es();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.azY = aVar;
    }

    private boolean zk() {
        if (com.baidu.swan.apps.ae.b.IV() == null || !com.baidu.swan.apps.ae.b.IV().Jh()) {
            return false;
        }
        com.baidu.swan.apps.core.c.e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy == null) {
            return true;
        }
        com.baidu.swan.apps.core.c.b yN = uy.yN();
        if (yN == null || !(yN instanceof h)) {
            return true;
        }
        return ((h) yN).zk();
    }

    private void Es() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.azW.toString());
        }
        setLooping(this.azW.mLoop);
        setVolume(this.azW.azH);
        if (Ep() > 0 || !this.azW.azG) {
            setVolume(this.azW.azH);
        } else {
            setVolume(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.aZP == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.Nh().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(AudioPlayer.this.Nh().getDuration() / 1000));
                    if (AudioPlayer.this.azY != null) {
                        AudioPlayer.this.azY.f("onTimeUpdate", jSONObject);
                    }
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
            AudioPlayer.this.aZP = PlayerStatus.PREPARED;
            AudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "comCompletion");
            }
            try {
                if (!AudioPlayer.this.azW.mLoop) {
                    AudioPlayer.this.aZQ = UserStatus.STOP;
                    AudioPlayer.this.Nf();
                    com.baidu.swan.apps.media.b.b(AudioPlayer.this);
                }
                if (AudioPlayer.this.azY != null) {
                    AudioPlayer.this.azY.eZ("onEnded");
                }
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.azW.azv + " url = " + AudioPlayer.this.azW.mUrl);
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
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            if (AudioPlayer.this.azY != null) {
                AudioPlayer.this.azY.f("onError", jSONObject);
            }
            AudioPlayer.this.Nf();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            if (AudioPlayer.this.azY != null) {
                AudioPlayer.this.azY.eZ("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aZP == PlayerStatus.PREPARED) {
                    AudioPlayer.this.aZT = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.azY != null) {
                        AudioPlayer.this.azY.eZ("onBufferingUpdate");
                        if (AudioPlayer.this.aZP == PlayerStatus.PREPARED && AudioPlayer.this.aZQ != UserStatus.STOP && (AudioPlayer.this.Nh().getDuration() * i) / 100 <= AudioPlayer.this.Nh().getCurrentTime()) {
                            AudioPlayer.this.azY.eZ("onWaiting");
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
}
