package com.baidu.swan.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.f;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cUQ;
    private c cVo;
    private com.baidu.swan.apps.media.audio.b.a cVp;
    private a cVs;
    private MediaPlayer cpq;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b cVn = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cVq = PlayerStatus.NONE;
    private UserStatus cVr = UserStatus.OPEN;
    private boolean cVt = false;

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
        this.cUQ = "";
        this.cUQ = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        aeB().start();
        if (this.cVo != null) {
            this.cVo.sendEmptyMessage(0);
        }
        if (this.cVp != null) {
            this.cVp.pI("onPlay");
        }
        axP();
        if (this.cVn.cUU > 0) {
            seekTo(this.cVn.cUU);
        }
        if (and()) {
            axM();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.cVr = UserStatus.PAUSE;
        axM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axM() {
        if (aeB().isPlaying()) {
            aeB().pause();
            if (this.cVp != null) {
                this.cVp.pI(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cVo != null) {
                this.cVo.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cVq == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            aeB().seekTo((int) (i * 1000));
            if (this.cVp != null) {
                this.cVp.pI("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        aeB().setLooping(z);
    }

    public void stop() {
        this.cVr = UserStatus.STOP;
        if (this.cVq == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            aeB().stop();
            this.cVq = PlayerStatus.IDLE;
            if (this.cVo != null) {
                this.cVo.removeMessages(0);
            }
            if (this.cVp != null) {
                this.cVp.pI(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.cVr = UserStatus.DESTROY;
        abandonAudioFocus();
        aeB().release();
        this.cVq = PlayerStatus.NONE;
        this.cpq = null;
        if (this.cVo != null) {
            this.cVo.removeMessages(0);
            this.cVo = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer aeB() {
        if (this.cpq == null) {
            this.cpq = new MediaPlayer();
            b bVar = new b();
            this.cpq.setOnPreparedListener(bVar);
            this.cpq.setOnCompletionListener(bVar);
            this.cpq.setOnInfoListener(bVar);
            this.cpq.setOnErrorListener(bVar);
            this.cpq.setOnSeekCompleteListener(bVar);
            this.cpq.setOnBufferingUpdateListener(bVar);
            this.cVo = new c();
        }
        return this.cpq;
    }

    @Override // com.baidu.swan.apps.media.a
    public String atG() {
        return this.cUQ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String axH() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVn.cqC;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object axI() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fp(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aEU = e.aEU();
        if (aEU != null && aEU.aFn()) {
            if (!z) {
                axM();
            } else if (this.cVr == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fq(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            axM();
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
        e aEU = e.aEU();
        if (aEU != null && aEU.aFn()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b axN() {
        return this.cVn;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.cVr = UserStatus.OPEN;
        this.cVn = bVar;
        if (this.cVn.cUW != null) {
            try {
                this.cVp = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cVn.cUW));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        aeB().reset();
        setDataSource(this.cVn.mUrl);
        axO();
    }

    private void setDataSource(String str) {
        try {
            String tr = f.axo().awU().tr(str);
            if (!TextUtils.isEmpty(tr)) {
                HashMap hashMap = new HashMap();
                String aKi = ab.aKi();
                if (!TextUtils.isEmpty(aKi) && ab.ub(tr)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aKi);
                    }
                    hashMap.put("Referer", aKi);
                }
                String apG = com.baidu.swan.apps.core.turbo.d.aph().apG();
                if (!TextUtils.isEmpty(apG)) {
                    hashMap.put("User-Agent", apG);
                }
                aeB().setDataSource(AppRuntime.getAppContext(), Uri.parse(tr), hashMap);
                this.cVq = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cVp != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.cVp.pI("onError");
            }
        }
    }

    private void axO() {
        if (this.cVt) {
            aeB().reset();
            setDataSource(this.cVn.mUrl);
            this.cVt = false;
        }
        aeB().prepareAsync();
        this.cVq = PlayerStatus.PREPARING;
    }

    public void play() {
        this.cVr = UserStatus.PLAY;
        if (!and()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.cVq == PlayerStatus.PREPARED) {
                aeB().start();
                if (this.cVo != null) {
                    this.cVo.sendEmptyMessage(0);
                }
                if (this.cVp != null) {
                    this.cVp.pI("onPlay");
                }
            } else if (this.cVq == PlayerStatus.IDLE) {
                aeB().prepareAsync();
                this.cVq = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cVn.mUrl;
        this.cVn = bVar;
        if (this.cVp != null) {
            this.cVp.pH(this.cVn.cUW);
        }
        axP();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.cVt = true;
            axO();
        }
    }

    private boolean and() {
        if (e.aEU() == null || !e.aEU().aFn()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f adm = f.axo().adm();
        if (adm == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c amB = adm.amB();
        if (amB == null || !(amB instanceof j)) {
            return true;
        }
        return ((j) amB).and();
    }

    private void axP() {
        setLooping(this.cVn.mLoop);
        setVolume(this.cVn.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        aeB().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!anf() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cVs == null) {
                this.cVs = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cVs, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cVs != null) {
                this.mAudioManager.abandonAudioFocus(this.cVs);
                this.mAudioManager = null;
                this.cVs = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anf() {
        e aEU = e.aEU();
        boolean booleanValue = aEU != null ? aEU.aFm().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.aeB().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.aeB().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.cVp != null) {
                        SwanAppAudioPlayer.this.cVp.e("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.cVq = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cVp != null) {
                SwanAppAudioPlayer.this.cVp.pI("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.cVr) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.aeB().isLooping()) {
                SwanAppAudioPlayer.this.cVr = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cVq = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cVp != null) {
                SwanAppAudioPlayer.this.cVp.pI("onEnded");
            }
            SwanAppAudioPlayer.this.cVo.removeMessages(0);
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
                jSONObject.putOpt("errCode", str);
            } catch (JSONException e) {
                if (SwanAppAudioPlayer.DEBUG) {
                    Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                }
            }
            if (SwanAppAudioPlayer.this.cVp != null) {
                SwanAppAudioPlayer.this.cVp.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cVp != null) {
                SwanAppAudioPlayer.this.cVp.pI("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cVq == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.aeB().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.aeB().getCurrentPosition() && SwanAppAudioPlayer.this.cVp != null) {
                SwanAppAudioPlayer.this.cVp.pI("onWaiting");
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
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.anf()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.axM();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.axM();
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
