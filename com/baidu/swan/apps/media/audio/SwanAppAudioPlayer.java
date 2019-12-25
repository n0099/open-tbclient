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
/* loaded from: classes9.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aWf;
    private boolean aWi;
    private String bvC;
    private c bwa;
    private com.baidu.swan.apps.media.audio.b.a bwb;
    private a bwe;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bvZ = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bwc = PlayerStatus.NONE;
    private UserStatus bwd = UserStatus.OPEN;
    private boolean bwf = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.bvC = "";
        this.bvC = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        EP();
        EO().start();
        if (this.bwa != null) {
            this.bwa.sendEmptyMessage(0);
        }
        if (this.bwb != null) {
            this.bwb.iK("onPlay");
        }
        Uv();
        if (this.bvZ.bvF > 0) {
            seekTo(this.bvZ.bvF);
        }
        if (Mf()) {
            Ut();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bwd = UserStatus.PAUSE;
        Ut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ut() {
        if (EO().isPlaying()) {
            EO().pause();
            if (this.bwb != null) {
                this.bwb.iK(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bwa != null) {
                this.bwa.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bwc == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            EO().seekTo((int) (i * 1000));
            if (this.bwb != null) {
                this.bwb.iK("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        EO().setLooping(z);
    }

    public void stop() {
        this.bwd = UserStatus.STOP;
        if (this.bwc == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            EO().stop();
            this.bwc = PlayerStatus.IDLE;
            if (this.bwa != null) {
                this.bwa.removeMessages(0);
            }
            if (this.bwb != null) {
                this.bwb.iK(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bwd = UserStatus.DESTROY;
        EQ();
        EO().release();
        this.bwc = PlayerStatus.NONE;
        this.aWf = null;
        if (this.bwa != null) {
            this.bwa.removeMessages(0);
            this.bwa = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer EO() {
        if (this.aWf == null) {
            this.aWf = new MediaPlayer();
            b bVar = new b();
            this.aWf.setOnPreparedListener(bVar);
            this.aWf.setOnCompletionListener(bVar);
            this.aWf.setOnInfoListener(bVar);
            this.aWf.setOnErrorListener(bVar);
            this.aWf.setOnSeekCompleteListener(bVar);
            this.aWf.setOnBufferingUpdateListener(bVar);
            this.bwa = new c();
        }
        return this.aWf;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Un() {
        return this.bvC;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Uo() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bvZ.aXf;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Up() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cE(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e ZS = e.ZS();
        if (ZS != null && ZS.aaj()) {
            if (!z) {
                Ut();
            } else if (this.bwd == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cF(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            Ut();
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
        e ZS = e.ZS();
        if (ZS != null && ZS.aaj()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Uu() {
        return this.bvZ;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bwd = UserStatus.OPEN;
        this.bvZ = bVar;
        if (this.bvZ.bvH != null) {
            try {
                this.bwb = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bvZ.bvH));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        EO().reset();
        b(callbackHandler, this.bvZ.mUrl);
    }

    private void b(CallbackHandler callbackHandler, String str) {
        String str2;
        try {
            e ZS = e.ZS();
            if (ZS == null) {
                str2 = str;
            } else if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                str2 = l.lO(str);
            } else {
                str2 = com.baidu.swan.apps.storage.b.d(str, ZS);
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String aek = y.aek();
                if (!TextUtils.isEmpty(aek) && y.mv(str2)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aek);
                    }
                    hashMap.put("Referer", aek);
                }
                String Oh = com.baidu.swan.apps.core.k.d.NK().Oh();
                if (!TextUtils.isEmpty(Oh)) {
                    hashMap.put("User-Agent", Oh);
                }
                EO().setDataSource(AppRuntime.getAppContext(), Uri.parse(str2), hashMap);
                this.bwc = PlayerStatus.IDLE;
                if (this.bwb != null) {
                    this.bwb.iK("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bwb != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bwb.iK("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bwf) {
            EO().reset();
            b(callbackHandler, this.bvZ.mUrl);
            this.bwf = false;
        }
        play();
    }

    public void play() {
        this.bwd = UserStatus.PLAY;
        if (!Mf()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            EP();
            if (this.bwc == PlayerStatus.PREPARED) {
                EO().start();
                if (this.bwa != null) {
                    this.bwa.sendEmptyMessage(0);
                }
                if (this.bwb != null) {
                    this.bwb.iK("onPlay");
                }
            } else if (this.bwc == PlayerStatus.IDLE) {
                EO().prepareAsync();
                this.bwc = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bvZ.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bwf = true;
        }
        this.bvZ = bVar;
        if (this.bwb != null) {
            this.bwb.iJ(this.bvZ.bvH);
        }
        Uv();
    }

    private boolean Mf() {
        if (e.ZS() == null || !e.ZS().aaj()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e DP = f.Uf().DP();
        if (DP == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b LB = DP.LB();
        if (LB == null || !(LB instanceof i)) {
            return true;
        }
        return ((i) LB).Mf();
    }

    private void Uv() {
        setLooping(this.bvZ.bvL);
        setVolume(this.bvZ.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        EO().setVolume(f, f);
    }

    private void EP() {
        if (!Mh() && !this.aWi) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bwe == null) {
                this.bwe = new a();
            }
            this.aWi = this.mAudioManager.requestAudioFocus(this.bwe, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        if (this.aWi) {
            if (this.mAudioManager != null && this.bwe != null) {
                this.mAudioManager.abandonAudioFocus(this.bwe);
                this.mAudioManager = null;
                this.bwe = null;
            }
            this.aWi = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Mh() {
        e ZS = e.ZS();
        boolean booleanValue = ZS != null ? ZS.aai().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.EO().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.EO().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.bwb != null) {
                        SwanAppAudioPlayer.this.bwb.d("onTimeUpdate", jSONObject);
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
    /* loaded from: classes9.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.bwc = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.EO().isLooping()) {
                SwanAppAudioPlayer.this.bwd = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bwc = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bwb != null) {
                SwanAppAudioPlayer.this.bwb.iK("onEnded");
            }
            SwanAppAudioPlayer.this.bwa.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.bwb != null) {
                SwanAppAudioPlayer.this.bwb.d("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bwb != null) {
                SwanAppAudioPlayer.this.bwb.iK("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bwc == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.EO().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.EO().getCurrentPosition() && SwanAppAudioPlayer.this.bwb != null) {
                SwanAppAudioPlayer.this.bwb.iK("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.Mh()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.EQ();
                                SwanAppAudioPlayer.this.Ut();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.EQ();
                                SwanAppAudioPlayer.this.Ut();
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
