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
    protected com.baidu.swan.apps.media.audio.b.a aUZ;
    private String aUw;
    private com.baidu.swan.games.audio.b.c bxi;
    private int bxl;
    private String bxm;
    private a bxn;
    private boolean bxp;
    private String mDataSource;
    protected PlayerStatus bxg = PlayerStatus.NONE;
    protected UserStatus bxh = UserStatus.OPEN;
    private d bxj = new d();
    private b bxk = new b();
    private float bxo = -1.0f;
    private TypedCallbackHandler bxq = new TypedCallbackHandler() { // from class: com.baidu.swan.games.audio.AudioPlayer.1
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
        this.aUw = "";
        this.aUw = str;
    }

    public void pause() {
        this.bxh = UserStatus.PAUSE;
        LT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LT() {
        try {
            VJ().pause();
            js("onPause");
            this.bxk.removeMessages(0);
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
            if (this.bxg == PlayerStatus.PREPARED) {
                if (i >= 0 && i <= getDuration()) {
                    VJ().seek(i);
                }
                this.bxo = -1.0f;
                return;
            }
            if (this.bxp && this.bxg == PlayerStatus.IDLE) {
                VM();
            }
            this.bxo = i;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setLooping(boolean z) {
        try {
            if (this.bxi != null && this.bxg == PlayerStatus.PREPARED) {
                VJ().dd(z);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.bxh = UserStatus.STOP;
            if (this.bxg == PlayerStatus.PREPARED) {
                VJ().stop();
                VH();
                js("onStop");
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        VH();
        this.bxp = false;
        this.bxh = UserStatus.DESTROY;
        this.bxg = PlayerStatus.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VH() {
        try {
            this.bxg = PlayerStatus.IDLE;
            if (this.bxi != null) {
                this.bxi.destroy();
                this.bxi = null;
            }
            this.bxk.removeMessages(0);
            com.baidu.swan.apps.media.b.b(this);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public int getDuration() {
        try {
            if (this.bxg == PlayerStatus.PREPARED) {
                return VJ().getDuration();
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
            return VJ().getCurrentTime();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public boolean isPaused() {
        try {
            return VJ().isPaused();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int VI() {
        return this.bxl;
    }

    public float getVolume() {
        if (this.bxj != null) {
            return this.bxj.aUI;
        }
        return 1.0f;
    }

    private void setVolume(float f) {
        try {
            if (this.bxi != null && this.bxg == PlayerStatus.PREPARED) {
                if (f > 1.0f) {
                    f = 1.0f;
                } else if (f < 0.0f) {
                    f = 0.0f;
                }
                VJ().setVolume(f);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public com.baidu.swan.games.audio.b.c VJ() {
        if (this.bxi == null || this.bxi.VT()) {
            this.bxi = com.baidu.swan.games.audio.b.b.VV().B(this.bxm, this.bxj.aUG);
            registerListener();
        }
        return this.bxi;
    }

    protected void registerListener() {
        if (this.bxn == null) {
            this.bxn = new a();
        }
        this.bxi.setOnPreparedListener(this.bxn);
        this.bxi.setOnCompletionListener(this.bxn);
        this.bxi.setOnInfoListener(this.bxn);
        this.bxi.setOnErrorListener(this.bxn);
        this.bxi.a((MediaPlayer.OnSeekCompleteListener) this.bxn);
        this.bxi.a((MediaPlayer.OnBufferingUpdateListener) this.bxn);
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return this.aUw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LM() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bxj.aUx;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LN() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && Ra.Rn() && !z && (v8Engine = getV8Engine()) != null && !v8Engine.WE()) {
            v8Engine.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.AudioPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioPlayer.this.LT();
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
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && Ra.Rn()) {
            release();
        }
    }

    private com.baidu.swan.games.e.a getV8Engine() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null || !Ra.Rn()) {
            return null;
        }
        Activity activity = Ra.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d AD = ((SwanAppActivity) activity).AD();
            if (AD instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AD).getV8Engine();
            }
            return null;
        }
        return null;
    }

    public void a(d dVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "AudioPlayer open");
        }
        if (this.bxi != null) {
            VH();
        }
        this.bxh = UserStatus.OPEN;
        this.bxj = dVar;
        this.bxl = 0;
        String str = this.bxj.mUrl;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            if (UnitedSchemeUtility.isInvokedFromSwanGame(this.bxq)) {
                str = com.baidu.swan.games.f.g.kb(str);
            } else {
                str = com.baidu.swan.apps.storage.b.b(str, Ra);
            }
        }
        this.mDataSource = str;
        this.bxg = PlayerStatus.IDLE;
        js("onWaiting");
        VK();
    }

    private void VK() {
        try {
            if (this.mDataSource.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.swan.games.audio.b.b VV = com.baidu.swan.games.audio.b.b.VV();
                File file = new File(VV.jx(this.mDataSource));
                if (file.exists() && !file.isDirectory()) {
                    this.bxm = file.getAbsolutePath();
                    VL();
                } else {
                    VV.a(this.mDataSource, new com.baidu.swan.games.audio.a.a() { // from class: com.baidu.swan.games.audio.AudioPlayer.3
                        @Override // com.baidu.swan.games.audio.a.a
                        public void aX(String str, String str2) {
                            AudioPlayer.this.bxm = str2;
                            AudioPlayer.this.VL();
                        }

                        @Override // com.baidu.swan.games.audio.a.a
                        public void w(int i, String str) {
                            AudioPlayer.this.jr(!SwanAppNetworkUtils.isNetworkConnected(null) ? "10003" : "10002");
                        }
                    });
                }
            } else {
                this.bxm = this.mDataSource;
                VL();
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VL() {
        VM();
    }

    private void VM() {
        try {
            VJ().setSrc(this.bxm);
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "set data source fail");
                e.printStackTrace();
            }
            jr("10003");
        }
    }

    public void play() {
        this.bxh = UserStatus.PLAY;
        if (this.bxp) {
            try {
                if (!FR() && VN()) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "play");
                    }
                    if (this.bxg == PlayerStatus.PREPARED) {
                        com.baidu.swan.apps.media.b.a(this);
                        this.bxk.sendEmptyMessage(0);
                        LX();
                        VJ().play();
                        js("onPlay");
                    } else if (this.bxg == PlayerStatus.IDLE) {
                        try {
                            VJ().setSrc(this.bxm);
                            this.bxg = PlayerStatus.PREPARING;
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

    private boolean VN() throws JSONException {
        File file = new File(this.bxm);
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
        this.bxj = dVar;
        if (this.aUZ != null) {
            this.aUZ.fV(this.bxj.aUC);
        }
        LX();
    }

    public void a(com.baidu.swan.apps.media.audio.b.a aVar) {
        this.aUZ = aVar;
    }

    private boolean FR() {
        if (com.baidu.swan.apps.ae.b.Ra() == null || !com.baidu.swan.apps.ae.b.Ra().Rn()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Fr = AI.Fr();
        if (Fr == null || !(Fr instanceof h)) {
            return true;
        }
        return ((h) Fr).FR();
    }

    private void LX() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "update AudioPlayer params : " + this.bxj.toString());
        }
        setLooping(this.bxj.aUG);
        setVolume(this.bxj.aUI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && AudioPlayer.this.bxg == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(AudioPlayer.this.VJ().getCurrentTime() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(AudioPlayer.this.VJ().getDuration() / 1000));
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
            AudioPlayer.this.bxg = PlayerStatus.PREPARED;
            if (!AudioPlayer.this.bxp) {
                AudioPlayer.this.js("onCanplay");
            }
            AudioPlayer.this.bxp = true;
            if (UserStatus.PLAY == AudioPlayer.this.bxh) {
                AudioPlayer.this.play();
            }
            try {
                if (AudioPlayer.this.bxj.bxs > 0.0f) {
                    AudioPlayer.this.VJ().seek(AudioPlayer.this.bxj.bxs);
                } else if (AudioPlayer.this.bxo >= 0.0f) {
                    AudioPlayer.this.VJ().seek(AudioPlayer.this.bxo);
                    AudioPlayer.this.bxo = -1.0f;
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
                if (!AudioPlayer.this.bxj.aUG) {
                    AudioPlayer.this.bxh = UserStatus.STOP;
                    AudioPlayer.this.VH();
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
                Log.e("SwanAppAudioPlayer", "Audio Error = " + i + "playerId = " + AudioPlayer.this.bxj.aUw + " url = " + AudioPlayer.this.bxj.mUrl);
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
            AudioPlayer.this.VH();
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
                if (AudioPlayer.this.bxg == PlayerStatus.PREPARED) {
                    AudioPlayer.this.bxl = (AudioPlayer.this.getDuration() * i) / 100;
                    if (AudioPlayer.this.aUZ != null) {
                        AudioPlayer.this.js("onBufferingUpdate");
                        if (AudioPlayer.this.bxg == PlayerStatus.PREPARED && AudioPlayer.this.bxh != UserStatus.STOP && (AudioPlayer.this.VJ().getDuration() * i) / 100 <= AudioPlayer.this.VJ().getCurrentTime()) {
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
        if (this.aUZ != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            this.aUZ.f("onError", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(String str) {
        j(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        if (this.aUZ != null) {
            this.aUZ.f(str, jSONObject);
        }
    }
}
