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
    private static DefaultSwanAppBgMusicPlayer cAA;
    private MediaPlayer cAB;
    private PlayerStatus cAC = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cAD;
    private a cAE;
    private c cAF;
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

    public static DefaultSwanAppBgMusicPlayer agP() {
        if (cAA == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cAA == null) {
                    cAA = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cAA;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cAD = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cAC != PlayerStatus.NONE) {
                    agQ().reset();
                }
                agQ().setDataSource(a2.mUrl);
                this.cAC = PlayerStatus.IDLE;
                this.cAD.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cAD.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        agQ().release();
        this.cAB = null;
        this.cAC = PlayerStatus.NONE;
        if (this.cAF != null) {
            this.cAF.removeMessages(0);
            this.cAF = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cAC == PlayerStatus.PREPARED) {
            requestAudioFocus();
            agQ().start();
            this.cAD.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cAF != null) {
                this.cAF.sendEmptyMessage(0);
            }
        } else if (this.cAC == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            agQ().prepareAsync();
            this.cAC = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cAD.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (agQ().isPlaying()) {
            agQ().pause();
            this.cAD.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cAF != null) {
                this.cAF.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cAC == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            agQ().stop();
            this.cAC = PlayerStatus.IDLE;
            this.cAD.onStateChanged(BgMusicPlayState.STOP);
            if (this.cAF != null) {
                this.cAF.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        agQ().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return agQ().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return agQ().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer agQ() {
        if (this.cAB == null) {
            this.cAB = new MediaPlayer();
            b bVar = new b();
            this.cAB.setOnPreparedListener(bVar);
            this.cAB.setOnCompletionListener(bVar);
            this.cAB.setOnErrorListener(bVar);
            this.cAB.setOnBufferingUpdateListener(bVar);
            this.cAB.setAudioStreamType(3);
            this.cAF = new c();
        }
        return this.cAB;
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
            DefaultSwanAppBgMusicPlayer.this.cAC = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cAD.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cAC = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cAD.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cAF != null) {
                DefaultSwanAppBgMusicPlayer.this.cAF.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.cAD.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cAC == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.agQ().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.agQ().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cAD.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.agQ().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.agQ().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cAD.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cAD.onGetPosition(currentPosition, ac(duration, currentPosition));
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
            if (this.cAE == null) {
                this.cAE = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cAE, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cAE != null) {
                this.mAudioManager.abandonAudioFocus(this.cAE);
                this.mAudioManager = null;
                this.cAE = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
