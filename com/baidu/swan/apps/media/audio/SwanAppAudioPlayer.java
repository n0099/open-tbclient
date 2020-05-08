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
    private String bYY;
    private c bZv;
    private com.baidu.swan.apps.media.audio.b.a bZw;
    private a bZz;
    private MediaPlayer bzQ;
    private boolean bzT;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bZu = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bZx = PlayerStatus.NONE;
    private UserStatus bZy = UserStatus.OPEN;
    private boolean bZA = false;

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
        this.bYY = "";
        this.bYY = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Ea();
        Ps().start();
        if (this.bZv != null) {
            this.bZv.sendEmptyMessage(0);
        }
        if (this.bZw != null) {
            this.bZw.ko("onPlay");
        }
        afb();
        if (this.bZu.bZb > 0) {
            seekTo(this.bZu.bZb);
        }
        if (WI()) {
            aeZ();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bZy = UserStatus.PAUSE;
        aeZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeZ() {
        if (Ps().isPlaying()) {
            Ps().pause();
            if (this.bZw != null) {
                this.bZw.ko(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bZv != null) {
                this.bZv.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bZx == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Ps().seekTo((int) (i * 1000));
            if (this.bZw != null) {
                this.bZw.ko("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Ps().setLooping(z);
    }

    public void stop() {
        this.bZy = UserStatus.STOP;
        if (this.bZx == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Ps().stop();
            this.bZx = PlayerStatus.IDLE;
            if (this.bZv != null) {
                this.bZv.removeMessages(0);
            }
            if (this.bZw != null) {
                this.bZw.ko(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bZy = UserStatus.DESTROY;
        Eb();
        Ps().release();
        this.bZx = PlayerStatus.NONE;
        this.bzQ = null;
        if (this.bZv != null) {
            this.bZv.removeMessages(0);
            this.bZv = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Ps() {
        if (this.bzQ == null) {
            this.bzQ = new MediaPlayer();
            b bVar = new b();
            this.bzQ.setOnPreparedListener(bVar);
            this.bzQ.setOnCompletionListener(bVar);
            this.bzQ.setOnInfoListener(bVar);
            this.bzQ.setOnErrorListener(bVar);
            this.bzQ.setOnSeekCompleteListener(bVar);
            this.bzQ.setOnBufferingUpdateListener(bVar);
            this.bZv = new c();
        }
        return this.bzQ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeS() {
        return this.bYY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bZu.bAP;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeU() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e akM = e.akM();
        if (akM != null && akM.ald()) {
            if (!z) {
                aeZ();
            } else if (this.bZy == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            aeZ();
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
        e akM = e.akM();
        if (akM != null && akM.ald()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b afa() {
        return this.bZu;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bZy = UserStatus.OPEN;
        this.bZu = bVar;
        if (this.bZu.bZd != null) {
            try {
                this.bZw = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bZu.bZd));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Ps().reset();
        b(callbackHandler, this.bZu.mUrl);
    }

    private void b(CallbackHandler callbackHandler, String str) {
        String str2;
        try {
            e akM = e.akM();
            if (akM == null) {
                str2 = str;
            } else if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                str2 = l.ns(str);
            } else {
                str2 = com.baidu.swan.apps.storage.b.d(str, akM);
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String apc = y.apc();
                if (!TextUtils.isEmpty(apc) && y.nZ(str2)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + apc);
                    }
                    hashMap.put("Referer", apc);
                }
                String YK = com.baidu.swan.apps.core.k.d.Yn().YK();
                if (!TextUtils.isEmpty(YK)) {
                    hashMap.put("User-Agent", YK);
                }
                Ps().setDataSource(AppRuntime.getAppContext(), Uri.parse(str2), hashMap);
                this.bZx = PlayerStatus.IDLE;
                if (this.bZw != null) {
                    this.bZw.ko("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bZw != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bZw.ko("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bZA) {
            Ps().reset();
            b(callbackHandler, this.bZu.mUrl);
            this.bZA = false;
        }
        play();
    }

    public void play() {
        this.bZy = UserStatus.PLAY;
        if (!WI()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Ea();
            if (this.bZx == PlayerStatus.PREPARED) {
                Ps().start();
                if (this.bZv != null) {
                    this.bZv.sendEmptyMessage(0);
                }
                if (this.bZw != null) {
                    this.bZw.ko("onPlay");
                }
            } else if (this.bZx == PlayerStatus.IDLE) {
                Ps().prepareAsync();
                this.bZx = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bZu.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bZA = true;
        }
        this.bZu = bVar;
        if (this.bZw != null) {
            this.bZw.kn(this.bZu.bZd);
        }
        afb();
    }

    private boolean WI() {
        if (e.akM() == null || !e.akM().ald()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e Ot = f.aeJ().Ot();
        if (Ot == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Wd = Ot.Wd();
        if (Wd == null || !(Wd instanceof i)) {
            return true;
        }
        return ((i) Wd).WI();
    }

    private void afb() {
        setLooping(this.bZu.mLoop);
        setVolume(this.bZu.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        Ps().setVolume(f, f);
    }

    private void Ea() {
        if (!WK() && !this.bzT) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bZz == null) {
                this.bZz = new a();
            }
            this.bzT = this.mAudioManager.requestAudioFocus(this.bZz, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eb() {
        if (this.bzT) {
            if (this.mAudioManager != null && this.bZz != null) {
                this.mAudioManager.abandonAudioFocus(this.bZz);
                this.mAudioManager = null;
                this.bZz = null;
            }
            this.bzT = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WK() {
        e akM = e.akM();
        boolean booleanValue = akM != null ? akM.alc().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Ps().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.Ps().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.bZw != null) {
                        SwanAppAudioPlayer.this.bZw.e("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.bZx = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Ps().isLooping()) {
                SwanAppAudioPlayer.this.bZy = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bZx = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bZw != null) {
                SwanAppAudioPlayer.this.bZw.ko("onEnded");
            }
            SwanAppAudioPlayer.this.bZv.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.bZw != null) {
                SwanAppAudioPlayer.this.bZw.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bZw != null) {
                SwanAppAudioPlayer.this.bZw.ko("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bZx == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Ps().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Ps().getCurrentPosition() && SwanAppAudioPlayer.this.bZw != null) {
                SwanAppAudioPlayer.this.bZw.ko("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.WK()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.Eb();
                                SwanAppAudioPlayer.this.aeZ();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.Eb();
                                SwanAppAudioPlayer.this.aeZ();
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
