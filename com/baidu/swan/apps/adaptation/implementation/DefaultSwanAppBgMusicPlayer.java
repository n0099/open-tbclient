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
/* loaded from: classes9.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer cFm;
    private MediaPlayer cFn;
    private PlayerStatus cFo = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cFp;
    private a cFq;
    private c cFr;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer akI() {
        if (cFm == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cFm == null) {
                    cFm = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cFm;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cFp = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cFo != PlayerStatus.NONE) {
                    akJ().reset();
                }
                akJ().setDataSource(a2.mUrl);
                this.cFo = PlayerStatus.IDLE;
                this.cFp.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cFp.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        akJ().release();
        this.cFn = null;
        this.cFo = PlayerStatus.NONE;
        if (this.cFr != null) {
            this.cFr.removeMessages(0);
            this.cFr = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cFo == PlayerStatus.PREPARED) {
            requestAudioFocus();
            akJ().start();
            this.cFp.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cFr != null) {
                this.cFr.sendEmptyMessage(0);
            }
        } else if (this.cFo == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            akJ().prepareAsync();
            this.cFo = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cFp.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (akJ().isPlaying()) {
            akJ().pause();
            this.cFp.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cFr != null) {
                this.cFr.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cFo == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            akJ().stop();
            this.cFo = PlayerStatus.IDLE;
            this.cFp.onStateChanged(BgMusicPlayState.STOP);
            if (this.cFr != null) {
                this.cFr.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        akJ().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return akJ().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return akJ().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer akJ() {
        if (this.cFn == null) {
            this.cFn = new MediaPlayer();
            b bVar = new b();
            this.cFn.setOnPreparedListener(bVar);
            this.cFn.setOnCompletionListener(bVar);
            this.cFn.setOnErrorListener(bVar);
            this.cFn.setOnBufferingUpdateListener(bVar);
            this.cFn.setAudioStreamType(3);
            this.cFr = new c();
        }
        return this.cFn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.cFo = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cFp.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cFo = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cFp.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cFr != null) {
                DefaultSwanAppBgMusicPlayer.this.cFr.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.cFp.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cFo == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.akJ().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.akJ().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cFp.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.akJ().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.akJ().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cFp.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cFp.onGetPosition(currentPosition, ac(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int ac(int i, int i2) {
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
    /* loaded from: classes9.dex */
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
            if (this.cFq == null) {
                this.cFq = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cFq, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cFq != null) {
                this.mAudioManager.abandonAudioFocus(this.cFq);
                this.mAudioManager = null;
                this.cFq = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
