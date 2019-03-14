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
    private com.baidu.swan.games.audio.b.e aZO;
    private b aZP;
    private int aZQ;
    private String aZR;
    private a aZS;
    private int aZT;
    private boolean aZU;
    protected com.baidu.swan.apps.media.audio.b.a azV;
    private String azs;
    private String mDataSource;
    protected PlayerStatus aZM = PlayerStatus.NONE;
    protected UserStatus aZN = UserStatus.OPEN;
    private com.baidu.swan.apps.media.audio.b azT = new com.baidu.swan.apps.media.audio.b();
    private TypedCallbackHandler aZV = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.azs = "";
        this.azs = str;
    }

    protected void start() {
        com.baidu.swan.apps.media.b.a(this);
        try {
            if (this.aZP == null) {
                this.aZP = new b();
            }
            this.aZP.sendEmptyMessage(0);
            if (this.azV != null) {
                this.azV.eY("onPlay");
            }
            Eu();
            if (this.azT.azx > 0 && this.azT.azx * 1000 <= getDuration()) {
                Nj().seek((int) (this.azT.azx * 1000));
            } else if (this.aZT > 0 && this.aZT * 1000 <= getDuration()) {
                Nj().seek((int) (this.aZT * 1000));
                this.aZT = 0;
            }
            if (zl()) {
                Eq();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        this.aZN = UserStatus.PAUSE;
        Eq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        try {
            if (!Nj().isPaused() && this.azV != null) {
                this.azV.eY("onPause");
            }
            Nj().pause();
            if (this.aZP != null) {
                this.aZP.removeMessages(0);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void seekTo(int i) {
        try {
            if (this.azV != null) {
                this.azV.eY("onSeeking");
            }
            if (this.aZM == PlayerStatus.PREPARED) {
                if (i > 0 && i * 1000 <= getDuration()) {
                    Nj().seek((int) (i * 1000));
                }
                this.aZT = 0;
                return;
            }
            this.aZT = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.aZO != null && this.aZM == PlayerStatus.PREPARED) {
                Nj().ct(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.aZN = UserStatus.STOP;
            if (this.aZM == PlayerStatus.PREPARED) {
                Nj().stop();
                Nh();
                if (this.azV != null) {
                    this.azV.eY("onStop");
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        Nh();
        this.aZN = UserStatus.DESTROY;
        this.aZM = PlayerStatus.NONE;
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        try {
            this.aZM = PlayerStatus.IDLE;
            if (this.aZO != null) {
                this.aZO.destroy();
                this.aZO = null;
            }
            if (this.aZP != null) {
                this.aZP.removeMessages(0);
                this.aZP = null;
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private int Er() {
        int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "System Volume is : " + streamVolume);
        }
        return streamVolume;
    }

    public int getDuration() {
        try {
            if (this.aZM == PlayerStatus.PREPARED) {
                return Nj().getDuration();
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
            return Nj().getCurrentTime();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public boolean isPaused() {
        try {
            return Nj().isPaused();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int Ni() {
        return this.aZQ;
    }

    public float getVolume() {
        if (this.azT != null) {
            return this.azT.azE;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.aZO != null && this.aZM == PlayerStatus.PREPARED) {
                if (f > 1.0f) {
                    f = 1.0f;
                } else if (f < 0.0f) {
                    f = 0.0f;
                }
                Nj().setVolume(f);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public com.baidu.swan.games.audio.b.e Nj() {
        if (this.aZO == null || this.aZO.Nr()) {
            this.aZO = com.baidu.swan.games.audio.b.b.Nt().hZ(this.aZR);
            this.aZO.ct(this.azT.mLoop);
            this.aZO.setVolume(this.azT.azE);
            registerListener();
        }
        return this.aZO;
    }

    protected void registerListener() {
        if (this.aZS == null) {
            this.aZS = new a();
        }
        this.aZO.setOnPreparedListener(this.aZS);
        this.aZO.setOnCompletionListener(this.aZS);
        this.aZO.setOnInfoListener(this.aZS);
        this.aZO.setOnErrorListener(this.aZS);
        this.aZO.setOnSeekCompleteListener(this.aZS);
        this.aZO.setOnBufferingUpdateListener(this.aZS);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ei() {
        return this.azs;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ej() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.azT.azt;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ek() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bk(boolean z) {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.Jj()) {
            if (!z) {
                com.baidu.swan.games.e.a v8Engine = getV8Engine();
                if (v8Engine != null && !v8Engine.NZ()) {
                    v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioPlayer.this.Eq();
                        }
                    });
                }
            } else if (this.aZN == UserStatus.PLAY) {
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
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.Jj()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX == null || !IX.Jj()) {
            return null;
        }
        Activity activity = IX.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d uu = ((SwanAppActivity) activity).uu();
            if (uu instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) uu).getV8Engine();
            }
            return null;
        }
        return null;
    }

    public void b(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.aZO != null) {
            Nh();
        }
        this.aZN = UserStatus.OPEN;
        this.azT = bVar;
        this.aZQ = 0;
        String str = this.azT.mUrl;
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.aZV)) {
                str = g.iF(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, IX);
            }
        }
        this.mDataSource = str;
        this.aZM = PlayerStatus.IDLE;
        if (this.azV != null) {
            this.azV.eY("onWaiting");
        }
        Nk();
    }

    private void Nk() {
        try {
            com.baidu.swan.games.audio.b.b Nt = com.baidu.swan.games.audio.b.b.Nt();
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                File file = new File(Nt.hY(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.aZR = file.getAbsolutePath();
                    Nl();
                } else {
                    Nt.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aN(String str, String str2) {
                            AudioPlayer.this.aZR = str2;
                            AudioPlayer.this.Nl();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void s(int i, String str) {
                            if (AudioPlayer.this.azV != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                                        jSONObject.putOpt("errCode", "10002");
                                    } else {
                                        jSONObject.putOpt("errCode", LivenessStat.TYPE_STRING_DEFAULT);
                                    }
                                    AudioPlayer.this.azV.f("onError", jSONObject);
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
                this.aZR = this.mDataSource;
                Nl();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nl() {
        this.aZU = true;
        com.baidu.swan.games.audio.b.b.Nt().Nu().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                if (UserStatus.PLAY == AudioPlayer.this.aZN) {
                    AudioPlayer.this.play();
                }
                if (AudioPlayer.this.azV != null) {
                    AudioPlayer.this.azV.eY("onCanplay");
                }
            }
        }, 50L);
    }

    public void play() {
        this.aZN = UserStatus.PLAY;
        if (this.aZU) {
            try {
                if (!zl()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.aZM == PlayerStatus.PREPARED) {
                        Nj().play();
                        if (this.aZP != null) {
                            this.aZP.sendEmptyMessage(0);
                        }
                        if (this.azV != null) {
                            this.azV.eY("onPlay");
                        }
                    } else if (this.aZM == PlayerStatus.IDLE) {
                        try {
                            Nj().setSrc(this.aZR);
                            this.aZM = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            try {
                                if (this.azV != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
                                        jSONObject.putOpt("errCode", "10002");
                                    } else {
                                        jSONObject.putOpt("errCode", "10003");
                                    }
                                    this.azV.f("onError", jSONObject);
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
        this.azT = bVar;
        if (this.azV != null) {
            this.azV.eX(this.azT.azz);
        }
        Eu();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.azV = aVar;
    }

    private boolean zl() {
        if (com.baidu.swan.apps.ae.b.IX() == null || !com.baidu.swan.apps.ae.b.IX().Jj()) {
            return false;
        }
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            return true;
        }
        com.baidu.swan.apps.core.c.b yO = uz.yO();
        if (yO == null || !(yO instanceof h)) {
            return true;
        }
        return ((h) yO).zl();
    }

    private void Eu() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.azT.toString());
        }
        setLooping(this.azT.mLoop);
        setVolume(this.azT.azE);
        if (Er() > 0 || !this.azT.azD) {
            setVolume(this.azT.azE);
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
            if (message.what == 0 && AudioPlayer.this.aZM == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.Nj().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Long.valueOf(AudioPlayer.this.Nj().getDuration() / 1000));
                    if (AudioPlayer.this.azV != null) {
                        AudioPlayer.this.azV.f("onTimeUpdate", jSONObject);
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
            AudioPlayer.this.aZM = PlayerStatus.PREPARED;
            AudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "comCompletion");
            }
            try {
                if (!AudioPlayer.this.azT.mLoop) {
                    AudioPlayer.this.aZN = UserStatus.STOP;
                    AudioPlayer.this.Nh();
                    com.baidu.swan.apps.media.b.b(AudioPlayer.this);
                }
                if (AudioPlayer.this.azV != null) {
                    AudioPlayer.this.azV.eY("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.azT.azs + " url = " + AudioPlayer.this.azT.mUrl);
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
            if (AudioPlayer.this.azV != null) {
                AudioPlayer.this.azV.f("onError", jSONObject);
            }
            AudioPlayer.this.Nh();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            if (AudioPlayer.this.azV != null) {
                AudioPlayer.this.azV.eY("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.aZM == PlayerStatus.PREPARED) {
                    AudioPlayer.this.aZQ = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.azV != null) {
                        AudioPlayer.this.azV.eY("onBufferingUpdate");
                        if (AudioPlayer.this.aZM == PlayerStatus.PREPARED && AudioPlayer.this.aZN != UserStatus.STOP && (AudioPlayer.this.Nj().getDuration() * i) / 100 <= AudioPlayer.this.Nj().getCurrentTime()) {
                            AudioPlayer.this.azV.eY("onWaiting");
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
