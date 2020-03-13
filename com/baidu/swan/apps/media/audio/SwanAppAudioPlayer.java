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
    private String bAA;
    private c bAX;
    private com.baidu.swan.apps.media.audio.b.a bAY;
    private a bBb;
    private MediaPlayer bbk;
    private boolean bbn;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bAW = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bAZ = PlayerStatus.NONE;
    private UserStatus bBa = UserStatus.OPEN;
    private boolean bBc = false;

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
        this.bAA = "";
        this.bAA = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        HC();
        HB().start();
        if (this.bAX != null) {
            this.bAX.sendEmptyMessage(0);
        }
        if (this.bAY != null) {
            this.bAY.jc("onPlay");
        }
        Xi();
        if (this.bAW.bAD > 0) {
            seekTo(this.bAW.bAD);
        }
        if (OR()) {
            Xg();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bBa = UserStatus.PAUSE;
        Xg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xg() {
        if (HB().isPlaying()) {
            HB().pause();
            if (this.bAY != null) {
                this.bAY.jc(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bAX != null) {
                this.bAX.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bAZ == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            HB().seekTo((int) (i * 1000));
            if (this.bAY != null) {
                this.bAY.jc("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        HB().setLooping(z);
    }

    public void stop() {
        this.bBa = UserStatus.STOP;
        if (this.bAZ == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            HB().stop();
            this.bAZ = PlayerStatus.IDLE;
            if (this.bAX != null) {
                this.bAX.removeMessages(0);
            }
            if (this.bAY != null) {
                this.bAY.jc(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bBa = UserStatus.DESTROY;
        HD();
        HB().release();
        this.bAZ = PlayerStatus.NONE;
        this.bbk = null;
        if (this.bAX != null) {
            this.bAX.removeMessages(0);
            this.bAX = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer HB() {
        if (this.bbk == null) {
            this.bbk = new MediaPlayer();
            b bVar = new b();
            this.bbk.setOnPreparedListener(bVar);
            this.bbk.setOnCompletionListener(bVar);
            this.bbk.setOnInfoListener(bVar);
            this.bbk.setOnErrorListener(bVar);
            this.bbk.setOnSeekCompleteListener(bVar);
            this.bbk.setOnBufferingUpdateListener(bVar);
            this.bAX = new c();
        }
        return this.bbk;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bAA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bAW.bcj;
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
            } else if (this.bBa == UserStatus.PLAY) {
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
        return this.bAW;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bBa = UserStatus.OPEN;
        this.bAW = bVar;
        if (this.bAW.bAF != null) {
            try {
                this.bAY = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bAW.bAF));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        HB().reset();
        b(callbackHandler, this.bAW.mUrl);
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
                this.bAZ = PlayerStatus.IDLE;
                if (this.bAY != null) {
                    this.bAY.jc("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bAY != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bAY.jc("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bBc) {
            HB().reset();
            b(callbackHandler, this.bAW.mUrl);
            this.bBc = false;
        }
        play();
    }

    public void play() {
        this.bBa = UserStatus.PLAY;
        if (!OR()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            HC();
            if (this.bAZ == PlayerStatus.PREPARED) {
                HB().start();
                if (this.bAX != null) {
                    this.bAX.sendEmptyMessage(0);
                }
                if (this.bAY != null) {
                    this.bAY.jc("onPlay");
                }
            } else if (this.bAZ == PlayerStatus.IDLE) {
                HB().prepareAsync();
                this.bAZ = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bAW.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bBc = true;
        }
        this.bAW = bVar;
        if (this.bAY != null) {
            this.bAY.jb(this.bAW.bAF);
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
        setLooping(this.bAW.mLoop);
        setVolume(this.bAW.mVolume);
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
        if (!OT() && !this.bbn) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bBb == null) {
                this.bBb = new a();
            }
            this.bbn = this.mAudioManager.requestAudioFocus(this.bBb, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (this.bbn) {
            if (this.mAudioManager != null && this.bBb != null) {
                this.mAudioManager.abandonAudioFocus(this.bBb);
                this.mAudioManager = null;
                this.bBb = null;
            }
            this.bbn = false;
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
                    if (SwanAppAudioPlayer.this.bAY != null) {
                        SwanAppAudioPlayer.this.bAY.d("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.bAZ = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.HB().isLooping()) {
                SwanAppAudioPlayer.this.bBa = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bAZ = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bAY != null) {
                SwanAppAudioPlayer.this.bAY.jc("onEnded");
            }
            SwanAppAudioPlayer.this.bAX.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.bAY != null) {
                SwanAppAudioPlayer.this.bAY.d("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bAY != null) {
                SwanAppAudioPlayer.this.bAY.jc("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bAZ == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.HB().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.HB().getCurrentPosition() && SwanAppAudioPlayer.this.bAY != null) {
                SwanAppAudioPlayer.this.bAY.jc("onWaiting");
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
