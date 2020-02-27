package com.baidu.swan.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.h.l;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c bAV;
    private com.baidu.swan.apps.media.audio.b.a bAW;
    private a bAZ;
    private String bAy;
    private MediaPlayer bbi;
    private boolean bbl;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bAU = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bAX = PlayerStatus.NONE;
    private UserStatus bAY = UserStatus.OPEN;
    private boolean bBa = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.bAy = "";
        this.bAy = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        HA();
        Hz().start();
        if (this.bAV != null) {
            this.bAV.sendEmptyMessage(0);
        }
        if (this.bAW != null) {
            this.bAW.jc("onPlay");
        }
        Xg();
        if (this.bAU.bAB > 0) {
            seekTo(this.bAU.bAB);
        }
        if (OP()) {
            Xe();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bAY = UserStatus.PAUSE;
        Xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xe() {
        if (Hz().isPlaying()) {
            Hz().pause();
            if (this.bAW != null) {
                this.bAW.jc(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bAV != null) {
                this.bAV.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bAX == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Hz().seekTo((int) (i * 1000));
            if (this.bAW != null) {
                this.bAW.jc("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Hz().setLooping(z);
    }

    public void stop() {
        this.bAY = UserStatus.STOP;
        if (this.bAX == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Hz().stop();
            this.bAX = PlayerStatus.IDLE;
            if (this.bAV != null) {
                this.bAV.removeMessages(0);
            }
            if (this.bAW != null) {
                this.bAW.jc(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bAY = UserStatus.DESTROY;
        HB();
        Hz().release();
        this.bAX = PlayerStatus.NONE;
        this.bbi = null;
        if (this.bAV != null) {
            this.bAV.removeMessages(0);
            this.bAV = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Hz() {
        if (this.bbi == null) {
            this.bbi = new MediaPlayer();
            b bVar = new b();
            this.bbi.setOnPreparedListener(bVar);
            this.bbi.setOnCompletionListener(bVar);
            this.bbi.setOnInfoListener(bVar);
            this.bbi.setOnErrorListener(bVar);
            this.bbi.setOnSeekCompleteListener(bVar);
            this.bbi.setOnBufferingUpdateListener(bVar);
            this.bAV = new c();
        }
        return this.bbi;
    }

    @Override // com.baidu.swan.apps.media.a
    public String WY() {
        return this.bAy;
    }

    @Override // com.baidu.swan.apps.media.a
    public String WZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bAU.bch;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e acD = e.acD();
        if (acD != null && acD.acU()) {
            if (!z) {
                Xe();
            } else if (this.bAY == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            Xe();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onDestroy");
        }
        e acD = e.acD();
        if (acD != null && acD.acU()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Xf() {
        return this.bAU;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bAY = UserStatus.OPEN;
        this.bAU = bVar;
        if (this.bAU.bAD != null) {
            try {
                this.bAW = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bAU.bAD));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Hz().reset();
        b(callbackHandler, this.bAU.mUrl);
    }

    private void b(CallbackHandler callbackHandler, String str) {
        String str2;
        try {
            e acD = e.acD();
            if (acD == null) {
                str2 = str;
            } else if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                str2 = l.mg(str);
            } else {
                str2 = com.baidu.swan.apps.storage.b.d(str, acD);
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String agR = y.agR();
                if (!TextUtils.isEmpty(agR) && y.mN(str2)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + agR);
                    }
                    hashMap.put("Referer", agR);
                }
                String QR = com.baidu.swan.apps.core.k.d.Qu().QR();
                if (!TextUtils.isEmpty(QR)) {
                    hashMap.put("User-Agent", QR);
                }
                Hz().setDataSource(AppRuntime.getAppContext(), Uri.parse(str2), hashMap);
                this.bAX = PlayerStatus.IDLE;
                if (this.bAW != null) {
                    this.bAW.jc("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bAW != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bAW.jc("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bBa) {
            Hz().reset();
            b(callbackHandler, this.bAU.mUrl);
            this.bBa = false;
        }
        play();
    }

    public void play() {
        this.bAY = UserStatus.PLAY;
        if (!OP()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            HA();
            if (this.bAX == PlayerStatus.PREPARED) {
                Hz().start();
                if (this.bAV != null) {
                    this.bAV.sendEmptyMessage(0);
                }
                if (this.bAW != null) {
                    this.bAW.jc("onPlay");
                }
            } else if (this.bAX == PlayerStatus.IDLE) {
                Hz().prepareAsync();
                this.bAX = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bAU.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bBa = true;
        }
        this.bAU = bVar;
        if (this.bAW != null) {
            this.bAW.jb(this.bAU.bAD);
        }
        Xg();
    }

    private boolean OP() {
        if (e.acD() == null || !e.acD().acU()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e GA = f.WQ().GA();
        if (GA == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Ol = GA.Ol();
        if (Ol == null || !(Ol instanceof i)) {
            return true;
        }
        return ((i) Ol).OP();
    }

    private void Xg() {
        setLooping(this.bAU.mLoop);
        setVolume(this.bAU.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        Hz().setVolume(f, f);
    }

    private void HA() {
        if (!OR() && !this.bbl) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bAZ == null) {
                this.bAZ = new a();
            }
            this.bbl = this.mAudioManager.requestAudioFocus(this.bAZ, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.bbl) {
            if (this.mAudioManager != null && this.bAZ != null) {
                this.mAudioManager.abandonAudioFocus(this.bAZ);
                this.mAudioManager = null;
                this.bAZ = null;
            }
            this.bbl = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OR() {
        e acD = e.acD();
        boolean booleanValue = acD != null ? acD.acT().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Hz().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.Hz().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.bAW != null) {
                        SwanAppAudioPlayer.this.bAW.d("onTimeUpdate", jSONObject);
                    }
                } catch (JSONException e) {
                    if (SwanAppAudioPlayer.DEBUG) {
                        e.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.bAX = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Hz().isLooping()) {
                SwanAppAudioPlayer.this.bAY = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bAX = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bAW != null) {
                SwanAppAudioPlayer.this.bAW.jc("onEnded");
            }
            SwanAppAudioPlayer.this.bAV.removeMessages(0);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--oninfo -> what: " + i + " ,extra: " + i2);
                return false;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onError -> what: " + i + " extra: " + i2);
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
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(TiebaInitialize.LogFields.ERROR_CODE, str);
            } catch (JSONException e) {
                if (SwanAppAudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            if (SwanAppAudioPlayer.this.bAW != null) {
                SwanAppAudioPlayer.this.bAW.d("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bAW != null) {
                SwanAppAudioPlayer.this.bAW.jc("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bAX == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Hz().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Hz().getCurrentPosition() && SwanAppAudioPlayer.this.bAW != null) {
                SwanAppAudioPlayer.this.bAW.jc("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.OR()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.HB();
                                SwanAppAudioPlayer.this.Xe();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.HB();
                                SwanAppAudioPlayer.this.Xe();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }
}
