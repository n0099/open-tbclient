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
    private static DefaultSwanAppBgMusicPlayer cCW;
    private MediaPlayer cCX;
    private PlayerStatus cCY = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cCZ;
    private a cDa;
    private c cDb;
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

    public static DefaultSwanAppBgMusicPlayer ahn() {
        if (cCW == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cCW == null) {
                    cCW = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cCW;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cCZ = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cCY != PlayerStatus.NONE) {
                    aho().reset();
                }
                aho().setDataSource(a2.mUrl);
                this.cCY = PlayerStatus.IDLE;
                this.cCZ.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cCZ.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        aho().release();
        this.cCX = null;
        this.cCY = PlayerStatus.NONE;
        if (this.cDb != null) {
            this.cDb.removeMessages(0);
            this.cDb = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cCY == PlayerStatus.PREPARED) {
            requestAudioFocus();
            aho().start();
            this.cCZ.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cDb != null) {
                this.cDb.sendEmptyMessage(0);
            }
        } else if (this.cCY == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            aho().prepareAsync();
            this.cCY = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cCZ.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (aho().isPlaying()) {
            aho().pause();
            this.cCZ.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cDb != null) {
                this.cDb.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cCY == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            aho().stop();
            this.cCY = PlayerStatus.IDLE;
            this.cCZ.onStateChanged(BgMusicPlayState.STOP);
            if (this.cDb != null) {
                this.cDb.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        aho().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return aho().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return aho().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer aho() {
        if (this.cCX == null) {
            this.cCX = new MediaPlayer();
            b bVar = new b();
            this.cCX.setOnPreparedListener(bVar);
            this.cCX.setOnCompletionListener(bVar);
            this.cCX.setOnErrorListener(bVar);
            this.cCX.setOnBufferingUpdateListener(bVar);
            this.cCX.setAudioStreamType(3);
            this.cDb = new c();
        }
        return this.cCX;
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
            DefaultSwanAppBgMusicPlayer.this.cCY = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cCZ.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cCY = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cCZ.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cDb != null) {
                DefaultSwanAppBgMusicPlayer.this.cDb.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.cCZ.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cCY == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.aho().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.aho().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cCZ.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.aho().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.aho().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cCZ.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cCZ.onGetPosition(currentPosition, Z(duration, currentPosition));
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
            if (this.cDa == null) {
                this.cDa = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cDa, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cDa != null) {
                this.mAudioManager.abandonAudioFocus(this.cDa);
                this.mAudioManager = null;
                this.cDa = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
