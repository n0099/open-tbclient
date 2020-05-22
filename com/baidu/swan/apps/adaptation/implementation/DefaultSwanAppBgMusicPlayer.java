package com.baidu.swan.apps.adaptation.implementation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer bHu;
    private c bHA;
    private MediaPlayer bHv;
    private PlayerStatus bHw = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a bHx;
    private boolean bHy;
    private a bHz;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer RK() {
        if (bHu == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (bHu == null) {
                    bHu = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return bHu;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bHx = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bHw != PlayerStatus.NONE) {
                    RL().reset();
                }
                RL().setDataSource(a2.mUrl);
                this.bHw = PlayerStatus.IDLE;
                this.bHx.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bHx.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void onRelease() {
        FR();
        RL().release();
        this.bHv = null;
        this.bHw = PlayerStatus.NONE;
        if (this.bHA != null) {
            this.bHA.removeMessages(0);
            this.bHA = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void play() {
        if (this.bHw == PlayerStatus.PREPARED) {
            FQ();
            RL().start();
            this.bHx.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bHA != null) {
                this.bHA.sendEmptyMessage(0);
            }
        } else if (this.bHw == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            RL().prepareAsync();
            this.bHw = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bHx.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void pause() {
        if (RL().isPlaying()) {
            RL().pause();
            this.bHx.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bHA != null) {
                this.bHA.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void stop() {
        if (this.bHw == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            RL().stop();
            this.bHw = PlayerStatus.IDLE;
            this.bHx.onStateChanged(BgMusicPlayState.STOP);
            if (this.bHA != null) {
                this.bHA.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void seek(int i) {
        RL().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int getDuration() {
        return RL().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean isPlaying() {
        return RL().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer RL() {
        if (this.bHv == null) {
            this.bHv = new MediaPlayer();
            b bVar = new b();
            this.bHv.setOnPreparedListener(bVar);
            this.bHv.setOnCompletionListener(bVar);
            this.bHv.setOnErrorListener(bVar);
            this.bHv.setOnBufferingUpdateListener(bVar);
            this.bHv.setAudioStreamType(3);
            this.bHA = new c();
        }
        return this.bHv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.bHw = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bHx.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bHw = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bHx.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bHA != null) {
                DefaultSwanAppBgMusicPlayer.this.bHA.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bHx.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bHw == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.RL().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.RL().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bHx.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.RL().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.RL().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bHx.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bHx.onGetPosition(currentPosition, ab(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int ab(int i, int i2) {
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
    /* loaded from: classes11.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.adaptation.implementation.DefaultSwanAppBgMusicPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            DefaultSwanAppBgMusicPlayer.this.FR();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void FQ() {
        if (!this.bHy) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bHz == null) {
                this.bHz = new a();
            }
            this.bHy = this.mAudioManager.requestAudioFocus(this.bHz, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR() {
        if (this.bHy) {
            if (this.mAudioManager != null && this.bHz != null) {
                this.mAudioManager.abandonAudioFocus(this.bHz);
                this.mAudioManager = null;
                this.bHz = null;
            }
            this.bHy = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
