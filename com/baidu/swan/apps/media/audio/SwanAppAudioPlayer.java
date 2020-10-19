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
    private c cMS;
    private com.baidu.swan.apps.media.audio.b.a cMT;
    private a cMW;
    private String cMu;
    private MediaPlayer cgQ;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b cMR = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cMU = PlayerStatus.NONE;
    private UserStatus cMV = UserStatus.OPEN;
    private boolean cMX = false;

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
        this.cMu = "";
        this.cMu = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        acH().start();
        if (this.cMS != null) {
            this.cMS.sendEmptyMessage(0);
        }
        if (this.cMT != null) {
            this.cMT.pp("onPlay");
        }
        avV();
        if (this.cMR.cMy > 0) {
            seekTo(this.cMR.cMy);
        }
        if (alj()) {
            avS();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.cMV = UserStatus.PAUSE;
        avS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avS() {
        if (acH().isPlaying()) {
            acH().pause();
            if (this.cMT != null) {
                this.cMT.pp(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cMS != null) {
                this.cMS.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cMU == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            acH().seekTo((int) (i * 1000));
            if (this.cMT != null) {
                this.cMT.pp("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        acH().setLooping(z);
    }

    public void stop() {
        this.cMV = UserStatus.STOP;
        if (this.cMU == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            acH().stop();
            this.cMU = PlayerStatus.IDLE;
            if (this.cMS != null) {
                this.cMS.removeMessages(0);
            }
            if (this.cMT != null) {
                this.cMT.pp(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.cMV = UserStatus.DESTROY;
        abandonAudioFocus();
        acH().release();
        this.cMU = PlayerStatus.NONE;
        this.cgQ = null;
        if (this.cMS != null) {
            this.cMS.removeMessages(0);
            this.cMS = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer acH() {
        if (this.cgQ == null) {
            this.cgQ = new MediaPlayer();
            b bVar = new b();
            this.cgQ.setOnPreparedListener(bVar);
            this.cgQ.setOnCompletionListener(bVar);
            this.cgQ.setOnInfoListener(bVar);
            this.cgQ.setOnErrorListener(bVar);
            this.cgQ.setOnSeekCompleteListener(bVar);
            this.cgQ.setOnBufferingUpdateListener(bVar);
            this.cMS = new c();
        }
        return this.cgQ;
    }

    @Override // com.baidu.swan.apps.media.a
    public String arL() {
        return this.cMu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String avN() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cMR.cib;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object avO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fc(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aDa = e.aDa();
        if (aDa != null && aDa.aDt()) {
            if (!z) {
                avS();
            } else if (this.cMV == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fd(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            avS();
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
        e aDa = e.aDa();
        if (aDa != null && aDa.aDt()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b avT() {
        return this.cMR;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.cMV = UserStatus.OPEN;
        this.cMR = bVar;
        if (this.cMR.cMA != null) {
            try {
                this.cMT = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cMR.cMA));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        acH().reset();
        setDataSource(this.cMR.mUrl);
        avU();
    }

    private void setDataSource(String str) {
        try {
            String sY = f.avu().ava().sY(str);
            if (!TextUtils.isEmpty(sY)) {
                HashMap hashMap = new HashMap();
                String aIo = ab.aIo();
                if (!TextUtils.isEmpty(aIo) && ab.tI(sY)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aIo);
                    }
                    hashMap.put("Referer", aIo);
                }
                String anL = com.baidu.swan.apps.core.turbo.d.ann().anL();
                if (!TextUtils.isEmpty(anL)) {
                    hashMap.put("User-Agent", anL);
                }
                acH().setDataSource(AppRuntime.getAppContext(), Uri.parse(sY), hashMap);
                this.cMU = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cMT != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.cMT.pp("onError");
            }
        }
    }

    private void avU() {
        if (this.cMX) {
            acH().reset();
            setDataSource(this.cMR.mUrl);
            this.cMX = false;
        }
        acH().prepareAsync();
        this.cMU = PlayerStatus.PREPARING;
    }

    public void play() {
        this.cMV = UserStatus.PLAY;
        if (!alj()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.cMU == PlayerStatus.PREPARED) {
                acH().start();
                if (this.cMS != null) {
                    this.cMS.sendEmptyMessage(0);
                }
                if (this.cMT != null) {
                    this.cMT.pp("onPlay");
                }
            } else if (this.cMU == PlayerStatus.IDLE) {
                acH().prepareAsync();
                this.cMU = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cMR.mUrl;
        this.cMR = bVar;
        if (this.cMT != null) {
            this.cMT.po(this.cMR.cMA);
        }
        avV();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.cMX = true;
            avU();
        }
    }

    private boolean alj() {
        if (e.aDa() == null || !e.aDa().aDt()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f abs = f.avu().abs();
        if (abs == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c akH = abs.akH();
        if (akH == null || !(akH instanceof j)) {
            return true;
        }
        return ((j) akH).alj();
    }

    private void avV() {
        setLooping(this.cMR.mLoop);
        setVolume(this.cMR.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        acH().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!all() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cMW == null) {
                this.cMW = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cMW, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cMW != null) {
                this.mAudioManager.abandonAudioFocus(this.cMW);
                this.mAudioManager = null;
                this.cMW = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean all() {
        e aDa = e.aDa();
        boolean booleanValue = aDa != null ? aDa.aDs().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
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
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.acH().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.acH().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.cMT != null) {
                        SwanAppAudioPlayer.this.cMT.e("onTimeUpdate", jSONObject);
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
            SwanAppAudioPlayer.this.cMU = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cMT != null) {
                SwanAppAudioPlayer.this.cMT.pp("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.cMV) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.acH().isLooping()) {
                SwanAppAudioPlayer.this.cMV = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cMU = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cMT != null) {
                SwanAppAudioPlayer.this.cMT.pp("onEnded");
            }
            SwanAppAudioPlayer.this.cMS.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.cMT != null) {
                SwanAppAudioPlayer.this.cMT.e("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cMT != null) {
                SwanAppAudioPlayer.this.cMT.pp("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cMU == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.acH().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.acH().getCurrentPosition() && SwanAppAudioPlayer.this.cMT != null) {
                SwanAppAudioPlayer.this.cMT.pp("onWaiting");
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
                    if (!SwanAppAudioPlayer.this.all()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.avS();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.avS();
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
