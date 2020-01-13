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
/* loaded from: classes10.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aWX;
    private boolean aXa;
    private c bwN;
    private com.baidu.swan.apps.media.audio.b.a bwO;
    private a bwR;
    private String bwp;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bwM = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bwP = PlayerStatus.NONE;
    private UserStatus bwQ = UserStatus.OPEN;
    private boolean bwS = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.bwp = "";
        this.bwp = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        Fl();
        Fk().start();
        if (this.bwN != null) {
            this.bwN.sendEmptyMessage(0);
        }
        if (this.bwO != null) {
            this.bwO.iN("onPlay");
        }
        US();
        if (this.bwM.bws > 0) {
            seekTo(this.bwM.bws);
        }
        if (MB()) {
            UQ();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bwQ = UserStatus.PAUSE;
        UQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UQ() {
        if (Fk().isPlaying()) {
            Fk().pause();
            if (this.bwO != null) {
                this.bwO.iN(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bwN != null) {
                this.bwN.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bwP == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            Fk().seekTo((int) (i * 1000));
            if (this.bwO != null) {
                this.bwO.iN("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        Fk().setLooping(z);
    }

    public void stop() {
        this.bwQ = UserStatus.STOP;
        if (this.bwP == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            Fk().stop();
            this.bwP = PlayerStatus.IDLE;
            if (this.bwN != null) {
                this.bwN.removeMessages(0);
            }
            if (this.bwO != null) {
                this.bwO.iN(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bwQ = UserStatus.DESTROY;
        Fm();
        Fk().release();
        this.bwP = PlayerStatus.NONE;
        this.aWX = null;
        if (this.bwN != null) {
            this.bwN.removeMessages(0);
            this.bwN = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Fk() {
        if (this.aWX == null) {
            this.aWX = new MediaPlayer();
            b bVar = new b();
            this.aWX.setOnPreparedListener(bVar);
            this.aWX.setOnCompletionListener(bVar);
            this.aWX.setOnInfoListener(bVar);
            this.aWX.setOnErrorListener(bVar);
            this.aWX.setOnSeekCompleteListener(bVar);
            this.aWX.setOnBufferingUpdateListener(bVar);
            this.bwN = new c();
        }
        return this.aWX;
    }

    @Override // com.baidu.swan.apps.media.a
    public String UK() {
        return this.bwp;
    }

    @Override // com.baidu.swan.apps.media.a
    public String UL() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bwM.aXX;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object UM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cJ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aap = e.aap();
        if (aap != null && aap.aaG()) {
            if (!z) {
                UQ();
            } else if (this.bwQ == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cK(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            UQ();
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
        e aap = e.aap();
        if (aap != null && aap.aaG()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b UR() {
        return this.bwM;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bwQ = UserStatus.OPEN;
        this.bwM = bVar;
        if (this.bwM.bwu != null) {
            try {
                this.bwO = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bwM.bwu));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        Fk().reset();
        b(callbackHandler, this.bwM.mUrl);
    }

    private void b(CallbackHandler callbackHandler, String str) {
        String str2;
        try {
            e aap = e.aap();
            if (aap == null) {
                str2 = str;
            } else if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                str2 = l.lR(str);
            } else {
                str2 = com.baidu.swan.apps.storage.b.d(str, aap);
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String aeD = y.aeD();
                if (!TextUtils.isEmpty(aeD) && y.my(str2)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aeD);
                    }
                    hashMap.put("Referer", aeD);
                }
                String OD = com.baidu.swan.apps.core.k.d.Og().OD();
                if (!TextUtils.isEmpty(OD)) {
                    hashMap.put("User-Agent", OD);
                }
                Fk().setDataSource(AppRuntime.getAppContext(), Uri.parse(str2), hashMap);
                this.bwP = PlayerStatus.IDLE;
                if (this.bwO != null) {
                    this.bwO.iN("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bwO != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bwO.iN("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bwS) {
            Fk().reset();
            b(callbackHandler, this.bwM.mUrl);
            this.bwS = false;
        }
        play();
    }

    public void play() {
        this.bwQ = UserStatus.PLAY;
        if (!MB()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            Fl();
            if (this.bwP == PlayerStatus.PREPARED) {
                Fk().start();
                if (this.bwN != null) {
                    this.bwN.sendEmptyMessage(0);
                }
                if (this.bwO != null) {
                    this.bwO.iN("onPlay");
                }
            } else if (this.bwP == PlayerStatus.IDLE) {
                Fk().prepareAsync();
                this.bwP = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bwM.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bwS = true;
        }
        this.bwM = bVar;
        if (this.bwO != null) {
            this.bwO.iM(this.bwM.bwu);
        }
        US();
    }

    private boolean MB() {
        if (e.aap() == null || !e.aap().aaG()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e El = f.UC().El();
        if (El == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b LX = El.LX();
        if (LX == null || !(LX instanceof i)) {
            return true;
        }
        return ((i) LX).MB();
    }

    private void US() {
        setLooping(this.bwM.bwy);
        setVolume(this.bwM.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        Fk().setVolume(f, f);
    }

    private void Fl() {
        if (!MD() && !this.aXa) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bwR == null) {
                this.bwR = new a();
            }
            this.aXa = this.mAudioManager.requestAudioFocus(this.bwR, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (this.aXa) {
            if (this.mAudioManager != null && this.bwR != null) {
                this.mAudioManager.abandonAudioFocus(this.bwR);
                this.mAudioManager = null;
                this.bwR = null;
            }
            this.aXa = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MD() {
        e aap = e.aap();
        boolean booleanValue = aap != null ? aap.aaF().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.Fk().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.Fk().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.bwO != null) {
                        SwanAppAudioPlayer.this.bwO.d("onTimeUpdate", jSONObject);
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
    /* loaded from: classes10.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.bwP = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.Fk().isLooping()) {
                SwanAppAudioPlayer.this.bwQ = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bwP = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bwO != null) {
                SwanAppAudioPlayer.this.bwO.iN("onEnded");
            }
            SwanAppAudioPlayer.this.bwN.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.bwO != null) {
                SwanAppAudioPlayer.this.bwO.d("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bwO != null) {
                SwanAppAudioPlayer.this.bwO.iN("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bwP == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.Fk().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.Fk().getCurrentPosition() && SwanAppAudioPlayer.this.bwO != null) {
                SwanAppAudioPlayer.this.bwO.iN("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.MD()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.Fm();
                                SwanAppAudioPlayer.this.UQ();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.Fm();
                                SwanAppAudioPlayer.this.UQ();
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
