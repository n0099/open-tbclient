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
/* loaded from: classes25.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer cAw;
    private a cAA;
    private c cAB;
    private MediaPlayer cAx;
    private PlayerStatus cAy = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cAz;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer ajA() {
        if (cAw == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cAw == null) {
                    cAw = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cAw;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cAz = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cAy != PlayerStatus.NONE) {
                    ajB().reset();
                }
                ajB().setDataSource(a2.mUrl);
                this.cAy = PlayerStatus.IDLE;
                this.cAz.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cAz.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        ajB().release();
        this.cAx = null;
        this.cAy = PlayerStatus.NONE;
        if (this.cAB != null) {
            this.cAB.removeMessages(0);
            this.cAB = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cAy == PlayerStatus.PREPARED) {
            requestAudioFocus();
            ajB().start();
            this.cAz.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cAB != null) {
                this.cAB.sendEmptyMessage(0);
            }
        } else if (this.cAy == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            ajB().prepareAsync();
            this.cAy = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cAz.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (ajB().isPlaying()) {
            ajB().pause();
            this.cAz.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cAB != null) {
                this.cAB.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cAy == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            ajB().stop();
            this.cAy = PlayerStatus.IDLE;
            this.cAz.onStateChanged(BgMusicPlayState.STOP);
            if (this.cAB != null) {
                this.cAB.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        ajB().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return ajB().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return ajB().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ajB() {
        if (this.cAx == null) {
            this.cAx = new MediaPlayer();
            b bVar = new b();
            this.cAx.setOnPreparedListener(bVar);
            this.cAx.setOnCompletionListener(bVar);
            this.cAx.setOnErrorListener(bVar);
            this.cAx.setOnBufferingUpdateListener(bVar);
            this.cAx.setAudioStreamType(3);
            this.cAB = new c();
        }
        return this.cAx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.cAy = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cAz.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cAy = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cAz.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cAB != null) {
                DefaultSwanAppBgMusicPlayer.this.cAB.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.cAz.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cAy == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.ajB().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.ajB().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cAz.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.ajB().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.ajB().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cAz.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cAz.onGetPosition(currentPosition, ah(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int ah(int i, int i2) {
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
    /* loaded from: classes25.dex */
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
            if (this.cAA == null) {
                this.cAA = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cAA, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cAA != null) {
                this.mAudioManager.abandonAudioFocus(this.cAA);
                this.mAudioManager = null;
                this.cAA = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
