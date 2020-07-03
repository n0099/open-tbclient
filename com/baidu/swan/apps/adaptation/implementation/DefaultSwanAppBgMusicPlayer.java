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
    private static DefaultSwanAppBgMusicPlayer bMi;
    private MediaPlayer bMj;
    private PlayerStatus bMk = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a bMl;
    private boolean bMm;
    private a bMn;
    private c bMo;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer SQ() {
        if (bMi == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (bMi == null) {
                    bMi = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return bMi;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bMl = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bMk != PlayerStatus.NONE) {
                    SR().reset();
                }
                SR().setDataSource(a2.mUrl);
                this.bMk = PlayerStatus.IDLE;
                this.bMl.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bMl.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void onRelease() {
        GA();
        SR().release();
        this.bMj = null;
        this.bMk = PlayerStatus.NONE;
        if (this.bMo != null) {
            this.bMo.removeMessages(0);
            this.bMo = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void play() {
        if (this.bMk == PlayerStatus.PREPARED) {
            Gz();
            SR().start();
            this.bMl.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bMo != null) {
                this.bMo.sendEmptyMessage(0);
            }
        } else if (this.bMk == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            SR().prepareAsync();
            this.bMk = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bMl.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void pause() {
        if (SR().isPlaying()) {
            SR().pause();
            this.bMl.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bMo != null) {
                this.bMo.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void stop() {
        if (this.bMk == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            SR().stop();
            this.bMk = PlayerStatus.IDLE;
            this.bMl.onStateChanged(BgMusicPlayState.STOP);
            if (this.bMo != null) {
                this.bMo.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void seek(int i) {
        SR().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int getDuration() {
        return SR().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean isPlaying() {
        return SR().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer SR() {
        if (this.bMj == null) {
            this.bMj = new MediaPlayer();
            b bVar = new b();
            this.bMj.setOnPreparedListener(bVar);
            this.bMj.setOnCompletionListener(bVar);
            this.bMj.setOnErrorListener(bVar);
            this.bMj.setOnBufferingUpdateListener(bVar);
            this.bMj.setAudioStreamType(3);
            this.bMo = new c();
        }
        return this.bMj;
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
            DefaultSwanAppBgMusicPlayer.this.bMk = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bMl.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bMk = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bMl.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bMo != null) {
                DefaultSwanAppBgMusicPlayer.this.bMo.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bMl.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bMk == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.SR().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.SR().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bMl.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.SR().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.SR().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bMl.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bMl.onGetPosition(currentPosition, ad(duration, currentPosition));
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
                            DefaultSwanAppBgMusicPlayer.this.GA();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Gz() {
        if (!this.bMm) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bMn == null) {
                this.bMn = new a();
            }
            this.bMm = this.mAudioManager.requestAudioFocus(this.bMn, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GA() {
        if (this.bMm) {
            if (this.mAudioManager != null && this.bMn != null) {
                this.mAudioManager.abandonAudioFocus(this.bMn);
                this.mAudioManager = null;
                this.bMn = null;
            }
            this.bMm = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
