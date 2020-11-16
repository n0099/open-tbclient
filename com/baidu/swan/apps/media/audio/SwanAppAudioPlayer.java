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
/* loaded from: classes7.dex */
public class SwanAppAudioPlayer implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cZC;
    private String cZa;
    private c cZy;
    private com.baidu.swan.apps.media.audio.b.a cZz;
    private MediaPlayer ctD;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;
    private com.baidu.swan.apps.media.audio.b cZx = new com.baidu.swan.apps.media.audio.b();
    private PlayerStatus cZA = PlayerStatus.NONE;
    private UserStatus cZB = UserStatus.OPEN;
    private boolean cZD = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum UserStatus {
        OPEN,
        PLAY,
        PAUSE,
        STOP,
        DESTROY
    }

    public SwanAppAudioPlayer(String str) {
        this.cZa = "";
        this.cZa = str;
        com.baidu.swan.apps.media.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===start");
        }
        requestAudioFocus();
        agt().start();
        if (this.cZy != null) {
            this.cZy.sendEmptyMessage(0);
        }
        if (this.cZz != null) {
            this.cZz.pQ("onPlay");
        }
        azH();
        if (this.cZx.cZe > 0) {
            seekTo(this.cZx.cZe);
        }
        if (aoV()) {
            azE();
        }
    }

    public void pause() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===pause");
        }
        this.cZB = UserStatus.PAUSE;
        azE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azE() {
        if (agt().isPlaying()) {
            agt().pause();
            if (this.cZz != null) {
                this.cZz.pQ(MissionEvent.MESSAGE_PAUSE);
            }
            if (this.cZy != null) {
                this.cZy.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.cZA == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            agt().seekTo((int) (i * 1000));
            if (this.cZz != null) {
                this.cZz.pQ("onSeeking");
            }
        }
    }

    private void setLooping(boolean z) {
        agt().setLooping(z);
    }

    public void stop() {
        this.cZB = UserStatus.STOP;
        if (this.cZA == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===stop");
            }
            agt().stop();
            this.cZA = PlayerStatus.IDLE;
            if (this.cZy != null) {
                this.cZy.removeMessages(0);
            }
            if (this.cZz != null) {
                this.cZz.pQ(MissionEvent.MESSAGE_STOP);
            }
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===release");
        }
        this.cZB = UserStatus.DESTROY;
        abandonAudioFocus();
        agt().release();
        this.cZA = PlayerStatus.NONE;
        this.ctD = null;
        if (this.cZy != null) {
            this.cZy.removeMessages(0);
            this.cZy = null;
        }
        com.baidu.swan.apps.media.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer agt() {
        if (this.ctD == null) {
            this.ctD = new MediaPlayer();
            b bVar = new b();
            this.ctD.setOnPreparedListener(bVar);
            this.ctD.setOnCompletionListener(bVar);
            this.ctD.setOnInfoListener(bVar);
            this.ctD.setOnErrorListener(bVar);
            this.ctD.setOnSeekCompleteListener(bVar);
            this.ctD.setOnBufferingUpdateListener(bVar);
            this.cZy = new c();
        }
        return this.ctD;
    }

    @Override // com.baidu.swan.apps.media.a
    public String avy() {
        return this.cZa;
    }

    @Override // com.baidu.swan.apps.media.a
    public String azz() {
        return null;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cZx.cuQ;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object azA() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void fB(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
        }
        e aGM = e.aGM();
        if (aGM != null && aGM.aHf()) {
            if (!z) {
                azE();
            } else if (this.cZB == UserStatus.PLAY) {
                play();
            }
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void fC(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
        }
        if (!z) {
            azE();
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
        e aGM = e.aGM();
        if (aGM != null && aGM.aHf()) {
            release();
        }
    }

    public com.baidu.swan.apps.media.audio.b azF() {
        return this.cZx;
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===openPlayer");
        }
        this.cZB = UserStatus.OPEN;
        this.cZx = bVar;
        if (this.cZx.cZg != null) {
            try {
                this.cZz = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cZx.cZg));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        agt().reset();
        setDataSource(this.cZx.mUrl);
        azG();
    }

    private void setDataSource(String str) {
        try {
            String tA = f.azg().ayM().tA(str);
            if (!TextUtils.isEmpty(tA)) {
                HashMap hashMap = new HashMap();
                String aMa = ab.aMa();
                if (!TextUtils.isEmpty(aMa) && ab.uk(tA)) {
                    if (DEBUG) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + aMa);
                    }
                    hashMap.put("Referer", aMa);
                }
                String ary = com.baidu.swan.apps.core.turbo.d.ara().ary();
                if (!TextUtils.isEmpty(ary)) {
                    hashMap.put("User-Agent", ary);
                }
                agt().setDataSource(AppRuntime.getAppContext(), Uri.parse(tA), hashMap);
                this.cZA = PlayerStatus.IDLE;
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanAppAudioPlayer", "set data source fail");
            }
            if (this.cZz != null) {
                JSONObject jSONObject = new JSONObject();
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString("errCode", "10002");
                } else {
                    jSONObject.optString("errCode", "10003");
                }
                this.cZz.pQ("onError");
            }
        }
    }

    private void azG() {
        if (this.cZD) {
            agt().reset();
            setDataSource(this.cZx.mUrl);
            this.cZD = false;
        }
        agt().prepareAsync();
        this.cZA = PlayerStatus.PREPARING;
    }

    public void play() {
        this.cZB = UserStatus.PLAY;
        if (!aoV()) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            requestAudioFocus();
            if (this.cZA == PlayerStatus.PREPARED) {
                agt().start();
                if (this.cZy != null) {
                    this.cZy.sendEmptyMessage(0);
                }
                if (this.cZz != null) {
                    this.cZz.pQ("onPlay");
                }
            } else if (this.cZA == PlayerStatus.IDLE) {
                agt().prepareAsync();
                this.cZA = PlayerStatus.PREPARING;
            }
        }
    }

    public void a(com.baidu.swan.apps.media.audio.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
        }
        String str = this.cZx.mUrl;
        this.cZx = bVar;
        if (this.cZz != null) {
            this.cZz.pP(this.cZx.cZg);
        }
        azH();
        if (!TextUtils.equals(bVar.mUrl, str)) {
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.mUrl);
            }
            this.cZD = true;
            azG();
        }
    }

    private boolean aoV() {
        if (e.aGM() == null || !e.aGM().aHf()) {
            return false;
        }
        com.baidu.swan.apps.core.d.f afe = f.azg().afe();
        if (afe == null) {
            return true;
        }
        com.baidu.swan.apps.core.d.c aot = afe.aot();
        if (aot == null || !(aot instanceof j)) {
            return true;
        }
        return ((j) aot).aoV();
    }

    private void azH() {
        setLooping(this.cZx.mLoop);
        setVolume(this.cZx.mVolume);
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        agt().setVolume(f, f);
    }

    private void requestAudioFocus() {
        if (!aoX() && !this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cZC == null) {
                this.cZC = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cZC, 3, 1) == 1;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cZC != null) {
                this.mAudioManager.abandonAudioFocus(this.cZC);
                this.mAudioManager = null;
                this.cZC = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoX() {
        e aGM = e.aGM();
        boolean booleanValue = aGM != null ? aGM.aHe().b("key_audio_is_mix_with_other", (Boolean) false).booleanValue() : false;
        if (DEBUG) {
            Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(SwanAppAudioPlayer.this.agt().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(SwanAppAudioPlayer.this.agt().getDuration() / 1000));
                    if (SwanAppAudioPlayer.this.cZz != null) {
                        SwanAppAudioPlayer.this.cZz.g("onTimeUpdate", jSONObject);
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
    /* loaded from: classes7.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onPrepared");
            }
            SwanAppAudioPlayer.this.cZA = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cZz != null) {
                SwanAppAudioPlayer.this.cZz.pQ("onCanplay");
            }
            if (UserStatus.PLAY == SwanAppAudioPlayer.this.cZB) {
                SwanAppAudioPlayer.this.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onCompletion");
            }
            if (!SwanAppAudioPlayer.this.agt().isLooping()) {
                SwanAppAudioPlayer.this.cZB = UserStatus.STOP;
            }
            SwanAppAudioPlayer.this.cZA = PlayerStatus.PREPARED;
            if (SwanAppAudioPlayer.this.cZz != null) {
                SwanAppAudioPlayer.this.cZz.pQ("onEnded");
            }
            SwanAppAudioPlayer.this.cZy.removeMessages(0);
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
            if (SwanAppAudioPlayer.this.cZz != null) {
                SwanAppAudioPlayer.this.cZz.g("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onSeekComplete");
            }
            if (SwanAppAudioPlayer.this.cZz != null) {
                SwanAppAudioPlayer.this.cZz.pQ("onSeeked");
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppAudioPlayer.DEBUG) {
                Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
            }
            if (SwanAppAudioPlayer.this.cZA == PlayerStatus.PREPARED && (SwanAppAudioPlayer.this.agt().getDuration() * i) / 100 <= SwanAppAudioPlayer.this.agt().getCurrentPosition() && SwanAppAudioPlayer.this.cZz != null) {
                SwanAppAudioPlayer.this.cZz.pQ("onWaiting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SwanAppAudioPlayer.this.aoX()) {
                        switch (i) {
                            case -2:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.azE();
                                return;
                            case -1:
                                if (SwanAppAudioPlayer.DEBUG) {
                                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                                }
                                SwanAppAudioPlayer.this.abandonAudioFocus();
                                SwanAppAudioPlayer.this.azE();
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
