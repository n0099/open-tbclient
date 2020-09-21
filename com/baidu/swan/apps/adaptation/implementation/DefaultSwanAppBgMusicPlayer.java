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
/* loaded from: classes3.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer bUB;
    private MediaPlayer bUC;
    private PlayerStatus bUD = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a bUE;
    private a bUF;
    private c bUG;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer ZU() {
        if (bUB == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (bUB == null) {
                    bUB = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return bUB;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bUE = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bUD != PlayerStatus.NONE) {
                    ZV().reset();
                }
                ZV().setDataSource(a2.mUrl);
                this.bUD = PlayerStatus.IDLE;
                this.bUE.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bUE.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        ZV().release();
        this.bUC = null;
        this.bUD = PlayerStatus.NONE;
        if (this.bUG != null) {
            this.bUG.removeMessages(0);
            this.bUG = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.bUD == PlayerStatus.PREPARED) {
            requestAudioFocus();
            ZV().start();
            this.bUE.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bUG != null) {
                this.bUG.sendEmptyMessage(0);
            }
        } else if (this.bUD == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            ZV().prepareAsync();
            this.bUD = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bUE.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (ZV().isPlaying()) {
            ZV().pause();
            this.bUE.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bUG != null) {
                this.bUG.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.bUD == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            ZV().stop();
            this.bUD = PlayerStatus.IDLE;
            this.bUE.onStateChanged(BgMusicPlayState.STOP);
            if (this.bUG != null) {
                this.bUG.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        ZV().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return ZV().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return ZV().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ZV() {
        if (this.bUC == null) {
            this.bUC = new MediaPlayer();
            b bVar = new b();
            this.bUC.setOnPreparedListener(bVar);
            this.bUC.setOnCompletionListener(bVar);
            this.bUC.setOnErrorListener(bVar);
            this.bUC.setOnBufferingUpdateListener(bVar);
            this.bUC.setAudioStreamType(3);
            this.bUG = new c();
        }
        return this.bUC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.bUD = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bUE.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bUD = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bUE.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bUG != null) {
                DefaultSwanAppBgMusicPlayer.this.bUG.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bUE.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bUD == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.ZV().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.ZV().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bUE.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.ZV().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.ZV().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bUE.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bUE.onGetPosition(currentPosition, af(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int af(int i, int i2) {
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
    /* loaded from: classes3.dex */
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
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bUF == null) {
                this.bUF = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.bUF, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.bUF != null) {
                this.mAudioManager.abandonAudioFocus(this.bUF);
                this.mAudioManager = null;
                this.bUF = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
