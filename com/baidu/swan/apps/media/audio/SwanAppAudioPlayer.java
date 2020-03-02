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
    private c bAW;
    private com.baidu.swan.apps.media.audio.b.a bAX;
    private String bAz;
    private a bBa;
    private MediaPlayer bbj;
    private boolean bbm;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bAV = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bAY = PlayerStatus.NONE;
    private UserStatus bAZ = UserStatus.OPEN;
    private boolean bBb = false;

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
        this.bAz = "";
        this.bAz = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        HC();
        HB().start();
        if (this.bAW != null) {
            this.bAW.sendEmptyMessage(0);
        }
        if (this.bAX != null) {
            this.bAX.jc("onPlay");
        }
        Xi();
        if (this.bAV.bAC > 0) {
            seekTo(this.bAV.bAC);
        }
        if (OR()) {
            Xg();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bAZ = UserStatus.PAUSE;
        Xg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xg() {
        if (HB().isPlaying()) {
            HB().pause();
            if (this.bAX != null) {
                this.bAX.jc(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bAW != null) {
                this.bAW.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bAY == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            HB().seekTo((int) (i * 1000));
            if (this.bAX != null) {
                this.bAX.jc("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        HB().setLooping(z);
    }

    public void stop() {
        this.bAZ = UserStatus.STOP;
        if (this.bAY == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            HB().stop();
            this.bAY = PlayerStatus.IDLE;
            if (this.bAW != null) {
                this.bAW.removeMessages(0);
            }
            if (this.bAX != null) {
                this.bAX.jc(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bAZ = UserStatus.DESTROY;
        HD();
        HB().release();
        this.bAY = PlayerStatus.NONE;
        this.bbj = null;
        if (this.bAW != null) {
            this.bAW.removeMessages(0);
            this.bAW = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer HB() {
        if (this.bbj == null) {
            this.bbj = new MediaPlayer();
            b bVar = new b();
            this.bbj.setOnPreparedListener(bVar);
            this.bbj.setOnCompletionListener(bVar);
            this.bbj.setOnInfoListener(bVar);
            this.bbj.setOnErrorListener(bVar);
            this.bbj.setOnSeekCompleteListener(bVar);
            this.bbj.setOnBufferingUpdateListener(bVar);
            this.bAW = new c();
        }
        return this.bbj;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bAz;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bAV.bci;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e acF = e.acF();
        if (acF != null && acF.acW()) {
            if (!z) {
                Xg();
            } else if (this.bAZ == UserStatus.PLAY) {
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
            Xg();
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
        e acF = e.acF();
        if (acF != null && acF.acW()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Xh() {
        return this.bAV;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bAZ = UserStatus.OPEN;
        this.bAV = bVar;
        if (this.bAV.bAE != null) {
            try {
                this.bAX = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bAV.bAE));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        HB().reset();
        b(callbackHandler, this.bAV.mUrl);
    }

    private void b(CallbackHandler callbackHandler, String str) {
        String str2;
        try {
            e acF = e.acF();
            if (acF == null) {
                str2 = str;
            } else if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                str2 = l.mg(str);
            } else {
                str2 = com.baidu.swan.apps.storage.b.d(str, acF);
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String agT = y.agT();
                if (!TextUtils.isEmpty(agT) && y.mN(str2)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + agT);
                    }
                    hashMap.put("Referer", agT);
                }
                String QT = com.baidu.swan.apps.core.k.d.Qw().QT();
                if (!TextUtils.isEmpty(QT)) {
                    hashMap.put("User-Agent", QT);
                }
                HB().setDataSource(AppRuntime.getAppContext(), Uri.parse(str2), hashMap);
                this.bAY = PlayerStatus.IDLE;
                if (this.bAX != null) {
                    this.bAX.jc("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bAX != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bAX.jc("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bBb) {
            HB().reset();
            b(callbackHandler, this.bAV.mUrl);
            this.bBb = false;
        }
        play();
    }

    public void play() {
        this.bAZ = UserStatus.PLAY;
        if (!OR()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            HC();
            if (this.bAY == PlayerStatus.PREPARED) {
                HB().start();
                if (this.bAW != null) {
                    this.bAW.sendEmptyMessage(0);
                }
                if (this.bAX != null) {
                    this.bAX.jc("onPlay");
                }
            } else if (this.bAY == PlayerStatus.IDLE) {
                HB().prepareAsync();
                this.bAY = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bAV.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bBb = true;
        }
        this.bAV = bVar;
        if (this.bAX != null) {
            this.bAX.jb(this.bAV.bAE);
        }
        Xi();
    }

    private boolean OR() {
        if (e.acF() == null || !e.acF().acW()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e GC = f.WS().GC();
        if (GC == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b On = GC.On();
        if (On == null || !(On instanceof i)) {
            return true;
        }
        return ((i) On).OR();
    }

    private void Xi() {
        setLooping(this.bAV.mLoop);
        setVolume(this.bAV.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        HB().setVolume(f, f);
    }

    private void HC() {
        if (!OT() && !this.bbm) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bBa == null) {
                this.bBa = new a();
            }
            this.bbm = this.mAudioManager.requestAudioFocus(this.bBa, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (this.bbm) {
            if (this.mAudioManager != null && this.bBa != null) {
                this.mAudioManager.abandonAudioFocus(this.bBa);
                this.mAudioManager = null;
                this.bBa = null;
            }
            this.bbm = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OT() {
        e acF = e.acF();
        boolean booleanValue = acF != null ? acF.acV().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.HB().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.HB().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.bAX != null) {
                        SwanAppAudioPlayer.this.bAX.d("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.bAY = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.HB().isLooping()) {
                SwanAppAudioPlayer.this.bAZ = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bAY = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bAX != null) {
                SwanAppAudioPlayer.this.bAX.jc("onEnded");
            }
            SwanAppAudioPlayer.this.bAW.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.bAX != null) {
                SwanAppAudioPlayer.this.bAX.d("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bAX != null) {
                SwanAppAudioPlayer.this.bAX.jc("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bAY == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.HB().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.HB().getCurrentPosition() && SwanAppAudioPlayer.this.bAX != null) {
                SwanAppAudioPlayer.this.bAX.jc("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.OT()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.HD();
                                SwanAppAudioPlayer.this.Xg();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.HD();
                                SwanAppAudioPlayer.this.Xg();
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
