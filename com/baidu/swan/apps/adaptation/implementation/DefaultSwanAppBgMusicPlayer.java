package com.baidu.swan.apps.adaptation.implementation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer cgP;
    private MediaPlayer cgQ;
    private PlayerStatus cgR = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cgS;
    private a cgT;
    private c cgU;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer acG() {
        if (cgP == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cgP == null) {
                    cgP = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cgP;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cgS = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cgR != PlayerStatus.NONE) {
                    acH().reset();
                }
                acH().setDataSource(a2.mUrl);
                this.cgR = PlayerStatus.IDLE;
                this.cgS.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cgS.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        acH().release();
        this.cgQ = null;
        this.cgR = PlayerStatus.NONE;
        if (this.cgU != null) {
            this.cgU.removeMessages(0);
            this.cgU = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cgR == PlayerStatus.PREPARED) {
            requestAudioFocus();
            acH().start();
            this.cgS.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cgU != null) {
                this.cgU.sendEmptyMessage(0);
            }
        } else if (this.cgR == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            acH().prepareAsync();
            this.cgR = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cgS.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (acH().isPlaying()) {
            acH().pause();
            this.cgS.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cgU != null) {
                this.cgU.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cgR == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            acH().stop();
            this.cgR = PlayerStatus.IDLE;
            this.cgS.onStateChanged(BgMusicPlayState.STOP);
            if (this.cgU != null) {
                this.cgU.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        acH().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return acH().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return acH().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer acH() {
        if (this.cgQ == null) {
            this.cgQ = new MediaPlayer();
            b bVar = new b();
            this.cgQ.setOnPreparedListener(bVar);
            this.cgQ.setOnCompletionListener(bVar);
            this.cgQ.setOnErrorListener(bVar);
            this.cgQ.setOnBufferingUpdateListener(bVar);
            this.cgQ.setAudioStreamType(3);
            this.cgU = new c();
        }
        return this.cgQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.cgR = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cgS.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cgR = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cgS.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cgU != null) {
                DefaultSwanAppBgMusicPlayer.this.cgU.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onError -> what: " + i + " extra: " + i2);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i + "%");
            }
            DefaultSwanAppBgMusicPlayer.this.cgS.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cgR == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.acH().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.acH().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cgS.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.acH().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.acH().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cgS.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cgS.onGetPosition(currentPosition, ae(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int ae(int i, int i2) {
            if (i2 > i) {
                i2 = i;
            }
            if (i > 0) {
                return (int) ((((i2 * 100) * 1.0f) / i) + 0.5f);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.adaptation.implementation.DefaultSwanAppBgMusicPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            DefaultSwanAppBgMusicPlayer.this.abandonAudioFocus();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void requestAudioFocus() {
        if (!this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cgT == null) {
                this.cgT = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cgT, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cgT != null) {
                this.mAudioManager.abandonAudioFocus(this.cgT);
                this.mAudioManager = null;
                this.cgT = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
