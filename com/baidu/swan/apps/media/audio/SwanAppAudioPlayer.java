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
    private String bAL;
    private c bBi;
    private com.baidu.swan.apps.media.audio.b.a bBj;
    private a bBm;
    private boolean bbA;
    private MediaPlayer bbx;
    private AudioManager mAudioManager;
    private com.baidu.swan.apps.media.audio.b bBh = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus bBk = PlayerStatus.NONE;
    private UserStatus bBl = UserStatus.OPEN;
    private boolean bBn = false;

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
        this.bAL = "";
        this.bAL = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        zg();
        HG().start();
        if (this.bBi != null) {
            this.bBi.sendEmptyMessage(0);
        }
        if (this.bBj != null) {
            this.bBj.jb("onPlay");
        }
        Xl();
        if (this.bBh.bAO > 0) {
            seekTo(this.bBh.bAO);
        }
        if (OU()) {
            Xj();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.bBl = UserStatus.PAUSE;
        Xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xj() {
        if (HG().isPlaying()) {
            HG().pause();
            if (this.bBj != null) {
                this.bBj.jb(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.bBi != null) {
                this.bBi.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.bBk == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            HG().seekTo((int) (i * 1000));
            if (this.bBj != null) {
                this.bBj.jb("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        HG().setLooping(z);
    }

    public void stop() {
        this.bBl = UserStatus.STOP;
        if (this.bBk == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            HG().stop();
            this.bBk = PlayerStatus.IDLE;
            if (this.bBi != null) {
                this.bBi.removeMessages(0);
            }
            if (this.bBj != null) {
                this.bBj.jb(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.bBl = UserStatus.DESTROY;
        zh();
        HG().release();
        this.bBk = PlayerStatus.NONE;
        this.bbx = null;
        if (this.bBi != null) {
            this.bBi.removeMessages(0);
            this.bBi = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer HG() {
        if (this.bbx == null) {
            this.bbx = new MediaPlayer();
            b bVar = new b();
            this.bbx.setOnPreparedListener(bVar);
            this.bbx.setOnCompletionListener(bVar);
            this.bbx.setOnInfoListener(bVar);
            this.bbx.setOnErrorListener(bVar);
            this.bbx.setOnSeekCompleteListener(bVar);
            this.bbx.setOnBufferingUpdateListener(bVar);
            this.bBi = new c();
        }
        return this.bbx;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xd() {
        return this.bAL;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xe() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.bBh.bcw;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xf() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e acI = e.acI();
        if (acI != null && acI.acZ()) {
            if (!z) {
                Xj();
            } else if (this.bBl == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cS(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            Xj();
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
        e acI = e.acI();
        if (acI != null && acI.acZ()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b Xk() {
        return this.bBh;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.bBl = UserStatus.OPEN;
        this.bBh = bVar;
        if (this.bBh.bAQ != null) {
            try {
                this.bBj = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bBh.bAQ));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        HG().reset();
        b(callbackHandler, this.bBh.mUrl);
    }

    private void b(CallbackHandler callbackHandler, String str) {
        String str2;
        try {
            e acI = e.acI();
            if (acI == null) {
                str2 = str;
            } else if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
                str2 = l.mf(str);
            } else {
                str2 = com.baidu.swan.apps.storage.b.d(str, acI);
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String agW = y.agW();
                if (!TextUtils.isEmpty(agW) && y.mM(str2)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + agW);
                    }
                    hashMap.put("Referer", agW);
                }
                String QW = com.baidu.swan.apps.core.k.d.Qz().QW();
                if (!TextUtils.isEmpty(QW)) {
                    hashMap.put("User-Agent", QW);
                }
                HG().setDataSource(AppRuntime.getAppContext(), Uri.parse(str2), hashMap);
                this.bBk = PlayerStatus.IDLE;
                if (this.bBj != null) {
                    this.bBj.jb("onCanplay");
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.bBj != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10002");
                } else {
                    jSONObject.optString(TiebaInitialize.LogFields.ERROR_CODE, "10003");
                }
                this.bBj.jb("onError");
            }
        }
    }

    public void a(CallbackHandler callbackHandler) {
        if (this.bBn) {
            HG().reset();
            b(callbackHandler, this.bBh.mUrl);
            this.bBn = false;
        }
        play();
    }

    public void play() {
        this.bBl = UserStatus.PLAY;
        if (!OU()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            zg();
            if (this.bBk == PlayerStatus.PREPARED) {
                HG().start();
                if (this.bBi != null) {
                    this.bBi.sendEmptyMessage(0);
                }
                if (this.bBj != null) {
                    this.bBj.jb("onPlay");
                }
            } else if (this.bBk == PlayerStatus.IDLE) {
                HG().prepareAsync();
                this.bBk = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        if (!TextUtils.equals(bVar.mUrl, this.bBh.mUrl)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.bBn = true;
        }
        this.bBh = bVar;
        if (this.bBj != null) {
            this.bBj.ja(this.bBh.bAQ);
        }
        Xl();
    }

    private boolean OU() {
        if (e.acI() == null || !e.acI().acZ()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e GH = f.WV().GH();
        if (GH == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.b Oq = GH.Oq();
        if (Oq == null || !(Oq instanceof i)) {
            return true;
        }
        return ((i) Oq).OU();
    }

    private void Xl() {
        setLooping(this.bBh.mLoop);
        setVolume(this.bBh.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        HG().setVolume(f, f);
    }

    private void zg() {
        if (!OW() && !this.bbA) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bBm == null) {
                this.bBm = new a();
            }
            this.bbA = this.mAudioManager.requestAudioFocus(this.bBm, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        if (this.bbA) {
            if (this.mAudioManager != null && this.bBm != null) {
                this.mAudioManager.abandonAudioFocus(this.bBm);
                this.mAudioManager = null;
                this.bBm = null;
            }
            this.bbA = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OW() {
        e acI = e.acI();
        boolean booleanValue = acI != null ? acI.acY().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.HG().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.HG().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.bBj != null) {
                        SwanAppAudioPlayer.this.bBj.d("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.bBk = PlayerStatus.PREPARED;
            SwanAppAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.HG().isLooping()) {
                SwanAppAudioPlayer.this.bBl = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.bBk = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.bBj != null) {
                SwanAppAudioPlayer.this.bBj.jb("onEnded");
            }
            SwanAppAudioPlayer.this.bBi.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.bBj != null) {
                SwanAppAudioPlayer.this.bBj.d("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.bBj != null) {
                SwanAppAudioPlayer.this.bBj.jb("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.bBk == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.HG().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.HG().getCurrentPosition() && SwanAppAudioPlayer.this.bBj != null) {
                SwanAppAudioPlayer.this.bBj.jb("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.OW()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.zh();
                                SwanAppAudioPlayer.this.Xj();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.zh();
                                SwanAppAudioPlayer.this.Xj();
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
