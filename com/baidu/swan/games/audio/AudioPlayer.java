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
    private com.baidu.swan.games.audio.b.e aZS;
    private b aZT;
    private int aZU;
    private String aZV;
    private a aZW;
    private int aZX;
    private boolean aZY;
    protected com.baidu.swan.apps.media.audio.b.a azZ;
    private String azw;
    private String mDataSource;
    protected PlayerStatus aZQ = PlayerStatus.NONE;
    protected UserStatus aZR = UserStatus.OPEN;
    private com.baidu.swan.apps.media.audio.b azX = new com.baidu.swan.apps.media.audio.b();
    private TypedCallbackHandler aZZ = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.azw = "";
        this.azw = str;
    }

    protected void start() {
        com.baidu.swan.apps.media.b.a(this);
        try {
            if (this.aZT == null) {
                this.aZT = new b();
            }
            this.aZT.sendEmptyMessage(0);
            if (this.azZ != null) {
                this.azZ.eZ("onPlay");
            }
            Es();
            if (this.azX.azB > 0 && this.azX.azB * 1000 <= getDuration()) {
                Nh().seek((int) (this.azX.azB * 1000));
            } else if (this.aZX > 0 && this.aZX * 1000 <= getDuration()) {
                Nh().seek((int) (this.aZX * 1000));
                this.aZX = 0;
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
        this.aZR = UserStatus.PAUSE;
        Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        try {
            if (!Nh().isPaused() && this.azZ != null) {
                this.azZ.eZ("onPause");
            }
            Nh().pause();
            if (this.aZT != null) {
                this.aZT.removeMessages(0);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void seekTo(int i) {
        try {
            if (this.azZ != null) {
                this.azZ.eZ("onSeeking");
            }
            if (this.aZQ == PlayerStatus.PREPARED) {
                if (i > 0 && i * 1000 <= getDuration()) {
                    Nh().seek((int) (i * 1000));
                }
                this.aZX = 0;
                return;
            }
            this.aZX = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.aZS != null && this.aZQ == PlayerStatus.PREPARED) {
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
            this.aZR = UserStatus.STOP;
            if (this.aZQ == PlayerStatus.PREPARED) {
                Nh().stop();
                Nf();
                if (this.azZ != null) {
                    this.azZ.eZ("onStop");
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
        this.aZR = UserStatus.DESTROY;
        this.aZQ = PlayerStatus.NONE;
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nf() {
        try {
            this.aZQ = PlayerStatus.IDLE;
            if (this.aZS != null) {
                this.aZS.destroy();
                this.aZS = null;
            }
            if (this.aZT != null) {
                this.aZT.removeMessages(0);
                this.aZT = null;
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
            if (this.aZQ == PlayerStatus.PREPARED) {
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
        return this.aZU;
    }

    public float getVolume() {
        if (this.azX != null) {
            return this.azX.azI;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.aZS != null && this.aZQ == PlayerStatus.PREPARED) {
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
        if (this.aZS == null || this.aZS.Np()) {
            this.aZS = com.baidu.swan.games.audio.b.b.Nr().ia(this.aZV);
            this.aZS.ct(this.azX.mLoop);
            this.aZS.setVolume(this.azX.azI);
            registerListener();
        }
        return this.aZS;
    }

    protected void registerListener() {
        if (this.aZW == null) {
            this.aZW = new a();
        }
        this.aZS.setOnPreparedListener(this.aZW);
        this.aZS.setOnCompletionListener(this.aZW);
        this.aZS.setOnInfoListener(this.aZW);
        this.aZS.setOnErrorListener(this.aZW);
        this.aZS.setOnSeekCompleteListener(this.aZW);
        this.aZS.setOnBufferingUpdateListener(this.aZW);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.azw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eh() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.azX.azx;
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
            } else if (this.aZR == UserStatus.PLAY) {
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
        if (this.aZS != null) {
            Nf();
        }
        this.aZR = UserStatus.OPEN;
        this.azX = bVar;
        this.aZU = 0;
        String str = this.azX.mUrl;
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.aZZ)) {
                str = g.iG(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, IV);
            }
        }
        this.mDataSource = str;
        this.aZQ = PlayerStatus.IDLE;
        if (this.azZ != null) {
            this.azZ.eZ("onWaiting");
        }
        Ni();
    }

    private void Ni() {
        try {
            com.baidu.swan.games.audio.b.b Nr = com.baidu.swan.games.audio.b.b.Nr();
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                File file = new File(Nr.hZ(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.aZV = file.getAbsolutePath();
                    Nj();
                } else {
                    Nr.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aN(String str, String str2) {
                            AudioPlayer.this.aZV = str2;
                            AudioPlayer.this.Nj();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void s(int i, String str) {
                            if (AudioPlayer.this.azZ != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                                        jSONObject.putOpt("errCode", "10002");
                                    } else {
                                        jSONObject.putOpt("errCode", LivenessStat.TYPE_STRING_DEFAULT);
                                    }
                                    AudioPlayer.this.azZ.f("onError", jSONObject);
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
                this.aZV = this.mDataSource;
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
        this.aZY = true;
        com.baidu.swan.games.audio.b.b.Nr().Ns().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                if (UserStatus.PLAY == AudioPlayer.this.aZR) {
                    AudioPlayer.this.play();
                }
                if (AudioPlayer.this.azZ != null) {
                    AudioPlayer.this.azZ.eZ("onCanplay");
                }
            }
        }, 50L);
    }

    public void play() {
        this.aZR = UserStatus.PLAY;
        if (this.aZY) {
            try {
                if (!zk()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.aZQ == PlayerStatus.PREPARED) {
                        Nh().play();
                        if (this.aZT != null) {
                            this.aZT.sendEmptyMessage(0);
                        }
                        if (this.azZ != null) {
                            this.azZ.eZ("onPlay");
                        }
                    } else if (this.aZQ == PlayerStatus.IDLE) {
                        try {
                            Nh().setSrc(this.aZV);
                            this.aZQ = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            try {
                                if (this.azZ != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
                                        jSONObject.putOpt("errCode", "10002");
                                    } else {
                                        jSONObject.putOpt("errCode", "10003");
                                    }
                                    this.azZ.f("onError", jSONObject);
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
        this.azX = bVar;
        if (this.azZ != null) {
            this.azZ.eY(this.azX.azD);
        }
        Es();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.azZ = aVar;
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
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.azX.toString());
        }
        setLooping(this.azX.mLoop);
        setVolume(this.azX.azI);
        if (Ep() > 0 || !this.azX.azH) {
            setVolume(this.azX.azI);
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
            if (message.what == 0 && AudioPlayer.this.aZQ == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.Nh().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(AudioPlayer.this.Nh().getDuration() / 1000));
                    if (AudioPlayer.this.azZ != null) {
                        AudioPlayer.this.azZ.f("onTimeUpdate", jSONObject);
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
            AudioPlayer.this.aZQ = PlayerStatus.PREPARED;
            AudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "comCompletion");
            }
            try {
                if (!AudioPlayer.this.azX.mLoop) {
                    AudioPlayer.this.aZR = UserStatus.STOP;
                    AudioPlayer.this.Nf();
                    com.baidu.swan.apps.media.b.b(AudioPlayer.this);
                }
                if (AudioPlayer.this.azZ != null) {
                    AudioPlayer.this.azZ.eZ("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.azX.azw + " url = " + AudioPlayer.this.azX.mUrl);
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
            if (AudioPlayer.this.azZ != null) {
                AudioPlayer.this.azZ.f("onError", jSONObject);
            }
            AudioPlayer.this.Nf();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            if (AudioPlayer.this.azZ != null) {
                AudioPlayer.this.azZ.eZ("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aZQ == PlayerStatus.PREPARED) {
                    AudioPlayer.this.aZU = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.azZ != null) {
                        AudioPlayer.this.azZ.eZ("onBufferingUpdate");
                        if (AudioPlayer.this.aZQ == PlayerStatus.PREPARED && AudioPlayer.this.aZR != UserStatus.STOP && (AudioPlayer.this.Nh().getDuration() * i) / 100 <= AudioPlayer.this.Nh().getCurrentTime()) {
                            AudioPlayer.this.azZ.eZ("onWaiting");
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
