package com.baidu.swan.apps.adaptation.implementation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer cEw;
    private a cEA;
    private c cEB;
    private MediaPlayer cEx;
    private PlayerStatus cEy = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cEz;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer ahq() {
        if (cEw == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cEw == null) {
                    cEw = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cEw;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cEz = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cEy != PlayerStatus.NONE) {
                    ahr().reset();
                }
                ahr().setDataSource(a2.mUrl);
                this.cEy = PlayerStatus.IDLE;
                this.cEz.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cEz.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        ahr().release();
        this.cEx = null;
        this.cEy = PlayerStatus.NONE;
        if (this.cEB != null) {
            this.cEB.removeMessages(0);
            this.cEB = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cEy == PlayerStatus.PREPARED) {
            requestAudioFocus();
            ahr().start();
            this.cEz.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cEB != null) {
                this.cEB.sendEmptyMessage(0);
            }
        } else if (this.cEy == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            ahr().prepareAsync();
            this.cEy = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cEz.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (ahr().isPlaying()) {
            ahr().pause();
            this.cEz.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cEB != null) {
                this.cEB.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cEy == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            ahr().stop();
            this.cEy = PlayerStatus.IDLE;
            this.cEz.onStateChanged(BgMusicPlayState.STOP);
            if (this.cEB != null) {
                this.cEB.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        ahr().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return ahr().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return ahr().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ahr() {
        if (this.cEx == null) {
            this.cEx = new MediaPlayer();
            b bVar = new b();
            this.cEx.setOnPreparedListener(bVar);
            this.cEx.setOnCompletionListener(bVar);
            this.cEx.setOnErrorListener(bVar);
            this.cEx.setOnBufferingUpdateListener(bVar);
            this.cEx.setAudioStreamType(3);
            this.cEB = new c();
        }
        return this.cEx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.cEy = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cEz.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cEy = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cEz.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cEB != null) {
                DefaultSwanAppBgMusicPlayer.this.cEB.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.cEz.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cEy == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.ahr().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.ahr().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cEz.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.ahr().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.ahr().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cEz.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cEz.onGetPosition(currentPosition, Z(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int Z(int i, int i2) {
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
    /* loaded from: classes8.dex */
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
            if (this.cEA == null) {
                this.cEA = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cEA, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cEA != null) {
                this.mAudioManager.abandonAudioFocus(this.cEA);
                this.mAudioManager = null;
                this.cEA = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
