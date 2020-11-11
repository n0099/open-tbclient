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
    private MediaPlayer cvp;
    private String daK;
    private c dbi;
    private com.baidu.swan.apps.media.audio.b.a dbj;
    private a dbm;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b dbh = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus dbk = PlayerStatus.NONE;
    private UserStatus dbl = UserStatus.OPEN;
    private boolean dbn = false;

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
        this.daK = "";
        this.daK = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        ahb().start();
        if (this.dbi != null) {
            this.dbi.sendEmptyMessage(0);
        }
        if (this.dbj != null) {
            this.dbj.pW("onPlay");
        }
        aAp();
        if (this.dbh.daO > 0) {
            seekTo(this.dbh.daO);
        }
        if (apE()) {
            aAm();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.dbl = UserStatus.PAUSE;
        aAm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAm() {
        if (ahb().isPlaying()) {
            ahb().pause();
            if (this.dbj != null) {
                this.dbj.pW(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.dbi != null) {
                this.dbi.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.dbk == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            ahb().seekTo((int) (i * 1000));
            if (this.dbj != null) {
                this.dbj.pW("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        ahb().setLooping(z);
    }

    public void stop() {
        this.dbl = UserStatus.STOP;
        if (this.dbk == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            ahb().stop();
            this.dbk = PlayerStatus.IDLE;
            if (this.dbi != null) {
                this.dbi.removeMessages(0);
            }
            if (this.dbj != null) {
                this.dbj.pW(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.dbl = UserStatus.DESTROY;
        abandonAudioFocus();
        ahb().release();
        this.dbk = PlayerStatus.NONE;
        this.cvp = null;
        if (this.dbi != null) {
            this.dbi.removeMessages(0);
            this.dbi = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ahb() {
        if (this.cvp == null) {
            this.cvp = new MediaPlayer();
            b bVar = new b();
            this.cvp.setOnPreparedListener(bVar);
            this.cvp.setOnCompletionListener(bVar);
            this.cvp.setOnInfoListener(bVar);
            this.cvp.setOnErrorListener(bVar);
            this.cvp.setOnSeekCompleteListener(bVar);
            this.cvp.setOnBufferingUpdateListener(bVar);
            this.dbi = new c();
        }
        return this.cvp;
    }

    @Override // com.baidu.swan.apps.media.a
    public String awg() {
        return this.daK;
    }

    @Override // com.baidu.swan.apps.media.a
    public String aAh() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dbh.cwA;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aAi() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fy(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aHu = e.aHu();
        if (aHu != null && aHu.aHN()) {
            if (!z) {
                aAm();
            } else if (this.dbl == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fz(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            aAm();
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
        e aHu = e.aHu();
        if (aHu != null && aHu.aHN()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b aAn() {
        return this.dbh;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.dbl = UserStatus.OPEN;
        this.dbh = bVar;
        if (this.dbh.daQ != null) {
            try {
                this.dbj = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dbh.daQ));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        ahb().reset();
        setDataSource(this.dbh.mUrl);
        aAo();
    }

    private void setDataSource(String str) {
        try {
            String tF = f.azO().azu().tF(str);
            if (!TextUtils.isEmpty(tF)) {
                HashMap hashMap = new HashMap();
                String aMI = ab.aMI();
                if (!TextUtils.isEmpty(aMI) && ab.up(tF)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aMI);
                    }
                    hashMap.put("Referer", aMI);
                }
                String asg = com.baidu.swan.apps.core.turbo.d.arI().asg();
                if (!TextUtils.isEmpty(asg)) {
                    hashMap.put("User-Agent", asg);
                }
                ahb().setDataSource(AppRuntime.getAppContext(), Uri.parse(tF), hashMap);
                this.dbk = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.dbj != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.dbj.pW("onError");
            }
        }
    }

    private void aAo() {
        if (this.dbn) {
            ahb().reset();
            setDataSource(this.dbh.mUrl);
            this.dbn = false;
        }
        ahb().prepareAsync();
        this.dbk = PlayerStatus.PREPARING;
    }

    public void play() {
        this.dbl = UserStatus.PLAY;
        if (!apE()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.dbk == PlayerStatus.PREPARED) {
                ahb().start();
                if (this.dbi != null) {
                    this.dbi.sendEmptyMessage(0);
                }
                if (this.dbj != null) {
                    this.dbj.pW("onPlay");
                }
            } else if (this.dbk == PlayerStatus.IDLE) {
                ahb().prepareAsync();
                this.dbk = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.dbh.mUrl;
        this.dbh = bVar;
        if (this.dbj != null) {
            this.dbj.pV(this.dbh.daQ);
        }
        aAp();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.dbn = true;
            aAo();
        }
    }

    private boolean apE() {
        if (e.aHu() == null || !e.aHu().aHN()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afM = f.azO().afM();
        if (afM == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c apb = afM.apb();
        if (apb == null || !(apb instanceof j)) {
            return true;
        }
        return ((j) apb).apE();
    }

    private void aAp() {
        setLooping(this.dbh.mLoop);
        setVolume(this.dbh.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        ahb().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!apG() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dbm == null) {
                this.dbm = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.dbm, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.dbm != null) {
                this.mAudioManager.abandonAudioFocus(this.dbm);
                this.mAudioManager = null;
                this.dbm = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apG() {
        e aHu = e.aHu();
        boolean booleanValue = aHu != null ? aHu.aHM().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.ahb().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.ahb().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.dbj != null) {
                        SwanAppAudioPlayer.this.dbj.g("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.dbk = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dbj != null) {
                SwanAppAudioPlayer.this.dbj.pW("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.dbl) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.ahb().isLooping()) {
                SwanAppAudioPlayer.this.dbl = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.dbk = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.dbj != null) {
                SwanAppAudioPlayer.this.dbj.pW("onEnded");
            }
            SwanAppAudioPlayer.this.dbi.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.dbj != null) {
                SwanAppAudioPlayer.this.dbj.g("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.dbj != null) {
                SwanAppAudioPlayer.this.dbj.pW("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.dbk == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.ahb().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.ahb().getCurrentPosition() && SwanAppAudioPlayer.this.dbj != null) {
                SwanAppAudioPlayer.this.dbj.pW("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.apG()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAm();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.aAm();
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
