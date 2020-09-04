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
    private static DefaultSwanAppBgMusicPlayer bSB;
    private MediaPlayer bSC;
    private PlayerStatus bSD = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a bSE;
    private a bSF;
    private c bSG;
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
        if (bSB == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (bSB == null) {
                    bSB = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return bSB;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bSE = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bSD != PlayerStatus.NONE) {
                    Zm().reset();
                }
                Zm().setDataSource(a2.mUrl);
                this.bSD = PlayerStatus.IDLE;
                this.bSE.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bSE.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        Zm().release();
        this.bSC = null;
        this.bSD = PlayerStatus.NONE;
        if (this.bSG != null) {
            this.bSG.removeMessages(0);
            this.bSG = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.bSD == PlayerStatus.PREPARED) {
            requestAudioFocus();
            Zm().start();
            this.bSE.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bSG != null) {
                this.bSG.sendEmptyMessage(0);
            }
        } else if (this.bSD == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Zm().prepareAsync();
            this.bSD = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bSE.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (Zm().isPlaying()) {
            Zm().pause();
            this.bSE.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bSG != null) {
                this.bSG.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.bSD == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Zm().stop();
            this.bSD = PlayerStatus.IDLE;
            this.bSE.onStateChanged(BgMusicPlayState.STOP);
            if (this.bSG != null) {
                this.bSG.removeMessages(0);
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
        if (this.bSC == null) {
            this.bSC = new MediaPlayer();
            b bVar = new b();
            this.bSC.setOnPreparedListener(bVar);
            this.bSC.setOnCompletionListener(bVar);
            this.bSC.setOnErrorListener(bVar);
            this.bSC.setOnBufferingUpdateListener(bVar);
            this.bSC.setAudioStreamType(3);
            this.bSG = new c();
        }
        return this.bSC;
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
            DefaultSwanAppBgMusicPlayer.this.bSD = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bSE.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bSD = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bSE.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bSG != null) {
                DefaultSwanAppBgMusicPlayer.this.bSG.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bSE.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bSD == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.Zm().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.Zm().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bSE.onStateChanged(BgMusicPlayState.LOADING);
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
                DefaultSwanAppBgMusicPlayer.this.bSE.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bSE.onGetPosition(currentPosition, af(duration, currentPosition));
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
            if (this.bSF == null) {
                this.bSF = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.bSF, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.bSF != null) {
                this.mAudioManager.abandonAudioFocus(this.bSF);
                this.mAudioManager = null;
                this.bSF = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
