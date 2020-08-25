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
/* loaded from: classes8.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer bSx;
    private com.baidu.swan.apps.media.audio.service.a bSA;
    private a bSB;
    private c bSC;
    private MediaPlayer bSy;
    private PlayerStatus bSz = PlayerStatus.NONE;
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

    public static DefaultSwanAppBgMusicPlayer Zl() {
        if (bSx == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (bSx == null) {
                    bSx = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return bSx;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bSA = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bSz != PlayerStatus.NONE) {
                    Zm().reset();
                }
                Zm().setDataSource(a2.mUrl);
                this.bSz = PlayerStatus.IDLE;
                this.bSA.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bSA.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        Zm().release();
        this.bSy = null;
        this.bSz = PlayerStatus.NONE;
        if (this.bSC != null) {
            this.bSC.removeMessages(0);
            this.bSC = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.bSz == PlayerStatus.PREPARED) {
            requestAudioFocus();
            Zm().start();
            this.bSA.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bSC != null) {
                this.bSC.sendEmptyMessage(0);
            }
        } else if (this.bSz == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Zm().prepareAsync();
            this.bSz = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bSA.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (Zm().isPlaying()) {
            Zm().pause();
            this.bSA.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bSC != null) {
                this.bSC.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.bSz == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Zm().stop();
            this.bSz = PlayerStatus.IDLE;
            this.bSA.onStateChanged(BgMusicPlayState.STOP);
            if (this.bSC != null) {
                this.bSC.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        Zm().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return Zm().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return Zm().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Zm() {
        if (this.bSy == null) {
            this.bSy = new MediaPlayer();
            b bVar = new b();
            this.bSy.setOnPreparedListener(bVar);
            this.bSy.setOnCompletionListener(bVar);
            this.bSy.setOnErrorListener(bVar);
            this.bSy.setOnBufferingUpdateListener(bVar);
            this.bSy.setAudioStreamType(3);
            this.bSC = new c();
        }
        return this.bSy;
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
            DefaultSwanAppBgMusicPlayer.this.bSz = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bSA.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bSz = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bSA.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bSC != null) {
                DefaultSwanAppBgMusicPlayer.this.bSC.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bSA.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bSz == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.Zm().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.Zm().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bSA.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.Zm().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.Zm().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bSA.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bSA.onGetPosition(currentPosition, af(duration, currentPosition));
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
            if (this.bSB == null) {
                this.bSB = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.bSB, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.bSB != null) {
                this.mAudioManager.abandonAudioFocus(this.bSB);
                this.mAudioManager = null;
                this.bSB = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
