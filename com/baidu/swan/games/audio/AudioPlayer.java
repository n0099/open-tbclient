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
    private String aUO;
    protected com.baidu.swan.apps.media.audio.b.a aVr;
    private com.baidu.swan.games.audio.b.c bxZ;
    private int byc;
    private String byd;
    private a bye;
    private boolean byg;
    private String mDataSource;
    protected PlayerStatus bxX = PlayerStatus.NONE;
    protected UserStatus bxY = UserStatus.OPEN;
    private d bya = new d();
    private b byb = new b();
    private float byf = -1.0f;
    private TypedCallbackHandler byh = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.aUO = "";
        this.aUO = str;
    }

    public void pause() {
        this.bxY = UserStatus.PAUSE;
        LS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LS() {
        try {
            VL().pause();
            js("onPause");
            this.byb.removeMessages(0);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void W(float f) {
        try {
            js("onSeeking");
            int i = (int) (1000.0f * f);
            if (this.bxX == PlayerStatus.PREPARED) {
                if (i >= 0 && i <= getDuration()) {
                    VL().seek(i);
                }
                this.byf = -1.0f;
                return;
            }
            if (this.byg && this.bxX == PlayerStatus.IDLE) {
                VO();
            }
            this.byf = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.bxZ != null && this.bxX == PlayerStatus.PREPARED) {
                VL().dd(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.bxY = UserStatus.STOP;
            if (this.bxX == PlayerStatus.PREPARED) {
                VL().stop();
                VJ();
                js("onStop");
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        VJ();
        this.byg = false;
        this.bxY = UserStatus.DESTROY;
        this.bxX = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VJ() {
        try {
            this.bxX = PlayerStatus.IDLE;
            if (this.bxZ != null) {
                this.bxZ.destroy();
                this.bxZ = null;
            }
            this.byb.removeMessages(0);
            com.baidu.swan.apps.media.b.b(this);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public int getDuration() {
        try {
            if (this.bxX == PlayerStatus.PREPARED) {
                return VL().getDuration();
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
            return VL().getCurrentTime();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public boolean isPaused() {
        try {
            return VL().isPaused();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int VK() {
        return this.byc;
    }

    public float getVolume() {
        if (this.bya != null) {
            return this.bya.aVa;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.bxZ != null && this.bxX == PlayerStatus.PREPARED) {
                if (f > 1.0f) {
                    f = 1.0f;
                } else if (f < 0.0f) {
                    f = 0.0f;
                }
                VL().setVolume(f);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public com.baidu.swan.games.audio.b.c VL() {
        if (this.bxZ == null || this.bxZ.VV()) {
            this.bxZ = com.baidu.swan.games.audio.b.b.VX().B(this.byd, this.bya.aUY);
            registerListener();
        }
        return this.bxZ;
    }

    protected void registerListener() {
        if (this.bye == null) {
            this.bye = new a();
        }
        this.bxZ.setOnPreparedListener(this.bye);
        this.bxZ.setOnCompletionListener(this.bye);
        this.bxZ.setOnInfoListener(this.bye);
        this.bxZ.setOnErrorListener(this.bye);
        this.bxZ.a((MediaPlayer.OnSeekCompleteListener) this.bye);
        this.bxZ.a((MediaPlayer.OnBufferingUpdateListener) this.bye);
    }

    @Override // com.baidu.swan.apps.media.a
    public String LK() {
        return this.aUO;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bya.aUP;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null && QZ.Rl() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.WG()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioPlayer.this.LS();
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null && QZ.Rl()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null || !QZ.Rl()) {
            return null;
        }
        Activity activity = QZ.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d AC = ((SwanAppActivity) activity).AC();
            if (AC instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AC).getV8Engine();
            }
            return null;
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.bxZ != null) {
            VJ();
        }
        this.bxY = UserStatus.OPEN;
        this.bya = dVar;
        this.byc = 0;
        String str = this.bya.mUrl;
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.byh)) {
                str = com.baidu.swan.games.f.g.kb(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, QZ);
            }
        }
        this.mDataSource = str;
        this.bxX = PlayerStatus.IDLE;
        js("onWaiting");
        VM();
    }

    private void VM() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b VX = com.baidu.swan.games.audio.b.b.VX();
                File file = new File(VX.jx(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.byd = file.getAbsolutePath();
                    VN();
                } else {
                    VX.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aX(String str, String str2) {
                            AudioPlayer.this.byd = str2;
                            AudioPlayer.this.VN();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void x(int i, String str) {
                            AudioPlayer.this.jr(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.byd = this.mDataSource;
                VN();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VN() {
        VO();
    }

    private void VO() {
        try {
            VL().setSrc(this.byd);
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "set data source fail");
                e.printStackTrace();
            }
            jr("10003");
        }
    }

    public void play() {
        this.bxY = UserStatus.PLAY;
        if (this.byg) {
            try {
                if (!FQ() && VP()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.bxX == PlayerStatus.PREPARED) {
                        com.baidu.swan.apps.media.b.a(this);
                        this.byb.sendEmptyMessage(0);
                        LW();
                        VL().play();
                        js("onPlay");
                    } else if (this.bxX == PlayerStatus.IDLE) {
                        try {
                            VL().setSrc(this.byd);
                            this.bxX = PlayerStatus.PREPARING;
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SwanAppAudioPlayer", "set data source fail");
                                e.printStackTrace();
                            }
                            jr(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
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

    private boolean VP() throws JSONException {
        File file = new File(this.byd);
        if (!file.exists() || file.isDirectory()) {
            jr("10003");
            return false;
        }
        return true;
    }

    public void b(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "Audio Update : " + dVar);
        }
        this.bya = dVar;
        if (this.aVr != null) {
            this.aVr.fV(this.bya.aUU);
        }
        LW();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.aVr = aVar;
    }

    private boolean FQ() {
        if (com.baidu.swan.apps.ae.b.QZ() == null || !com.baidu.swan.apps.ae.b.QZ().Rl()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Fq = AH.Fq();
        if (Fq == null || !(Fq instanceof h)) {
            return true;
        }
        return ((h) Fq).FQ();
    }

    private void LW() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.bya.toString());
        }
        setLooping(this.bya.aUY);
        setVolume(this.bya.aVa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.bxX == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.VL().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.VL().getDuration() / 1000));
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
            AudioPlayer.this.bxX = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.byg) {
                AudioPlayer.this.js("onCanplay");
            }
            AudioPlayer.this.byg = true;
            if (UserStatus.PLAY == AudioPlayer.this.bxY) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.bya.byj > 0.0f) {
                    AudioPlayer.this.VL().seek(AudioPlayer.this.bya.byj);
                } else if (AudioPlayer.this.byf >= 0.0f) {
                    AudioPlayer.this.VL().seek(AudioPlayer.this.byf);
                    AudioPlayer.this.byf = -1.0f;
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
                if (!AudioPlayer.this.bya.aUY) {
                    AudioPlayer.this.bxY = UserStatus.STOP;
                    AudioPlayer.this.VJ();
                    com.baidu.swan.apps.media.b.b(AudioPlayer.this);
                }
                AudioPlayer.this.js("onEnded");
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.bya.aUO + " url = " + AudioPlayer.this.bya.mUrl);
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
            AudioPlayer.this.jr(str);
            AudioPlayer.this.VJ();
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "onSeekComplete");
            }
            AudioPlayer.this.js("onSeeked");
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (AudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", "onBufferUpdate : " + i + "%");
                }
                if (AudioPlayer.this.bxX == PlayerStatus.PREPARED) {
                    AudioPlayer.this.byc = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.aVr != null) {
                        AudioPlayer.this.js("onBufferingUpdate");
                        if (AudioPlayer.this.bxX == PlayerStatus.PREPARED && AudioPlayer.this.bxY != UserStatus.STOP && (AudioPlayer.this.VL().getDuration() * i) / 100 <= AudioPlayer.this.VL().getCurrentTime()) {
                            AudioPlayer.this.js("onWaiting");
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
    public void jr(String str) {
        if (this.aVr != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.aVr.f("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.aVr != null) {
            this.aVr.f(str, jSONObject);
        }
    }
}
