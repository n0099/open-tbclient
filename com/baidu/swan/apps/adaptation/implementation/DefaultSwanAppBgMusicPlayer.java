package com.baidu.swan.apps.adaptation.implementation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer bMX;
    private MediaPlayer bMY;
    private PlayerStatus bMZ = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a bNa;
    private boolean bNb;
    private a bNc;
    private c bNd;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer Tl() {
        if (bMX == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (bMX == null) {
                    bMX = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return bMX;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bNa = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bMZ != PlayerStatus.NONE) {
                    Tm().reset();
                }
                Tm().setDataSource(a2.mUrl);
                this.bMZ = PlayerStatus.IDLE;
                this.bNa.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bNa.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void onRelease() {
        Gv();
        Tm().release();
        this.bMY = null;
        this.bMZ = PlayerStatus.NONE;
        if (this.bNd != null) {
            this.bNd.removeMessages(0);
            this.bNd = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void play() {
        if (this.bMZ == PlayerStatus.PREPARED) {
            Gu();
            Tm().start();
            this.bNa.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bNd != null) {
                this.bNd.sendEmptyMessage(0);
            }
        } else if (this.bMZ == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Tm().prepareAsync();
            this.bMZ = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bNa.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void pause() {
        if (Tm().isPlaying()) {
            Tm().pause();
            this.bNa.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bNd != null) {
                this.bNd.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void stop() {
        if (this.bMZ == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Tm().stop();
            this.bMZ = PlayerStatus.IDLE;
            this.bNa.onStateChanged(BgMusicPlayState.STOP);
            if (this.bNd != null) {
                this.bNd.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void seek(int i) {
        Tm().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int getDuration() {
        return Tm().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean isPlaying() {
        return Tm().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Tm() {
        if (this.bMY == null) {
            this.bMY = new MediaPlayer();
            b bVar = new b();
            this.bMY.setOnPreparedListener(bVar);
            this.bMY.setOnCompletionListener(bVar);
            this.bMY.setOnErrorListener(bVar);
            this.bMY.setOnBufferingUpdateListener(bVar);
            this.bMY.setAudioStreamType(3);
            this.bNd = new c();
        }
        return this.bMY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.bMZ = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bNa.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bMZ = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bNa.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bNd != null) {
                DefaultSwanAppBgMusicPlayer.this.bNd.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bNa.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bMZ == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.Tm().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.Tm().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bNa.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.Tm().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.Tm().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bNa.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bNa.onGetPosition(currentPosition, ad(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int ad(int i, int i2) {
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
    /* loaded from: classes7.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.adaptation.implementation.DefaultSwanAppBgMusicPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            DefaultSwanAppBgMusicPlayer.this.Gv();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Gu() {
        if (!this.bNb) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bNc == null) {
                this.bNc = new a();
            }
            this.bNb = this.mAudioManager.requestAudioFocus(this.bNc, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv() {
        if (this.bNb) {
            if (this.mAudioManager != null && this.bNc != null) {
                this.mAudioManager.abandonAudioFocus(this.bNc);
                this.mAudioManager = null;
                this.bNc = null;
            }
            this.bNb = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
