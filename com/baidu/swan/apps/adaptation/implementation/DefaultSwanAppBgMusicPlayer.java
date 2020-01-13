package com.baidu.swan.apps.adaptation.implementation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aWX;
    private PlayerStatus aWY;
    private com.baidu.swan.apps.media.audio.service.a aWZ;
    private boolean aXa;
    private a aXb;
    private c aXc;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.aWZ = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.aWY != PlayerStatus.NONE) {
                    Fk().reset();
                }
                Fk().setDataSource(a2.mUrl);
                this.aWY = PlayerStatus.IDLE;
                this.aWZ.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.aWZ.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        Fm();
        Fk().release();
        this.aWX = null;
        this.aWY = PlayerStatus.NONE;
        if (this.aXc != null) {
            this.aXc.removeMessages(0);
            this.aXc = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.aWY == PlayerStatus.PREPARED) {
            Fl();
            Fk().start();
            this.aWZ.onStateChanged(BgMusicPlayState.PLAY);
            if (this.aXc != null) {
                this.aXc.sendEmptyMessage(0);
            }
        } else if (this.aWY == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Fk().prepareAsync();
            this.aWY = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.aWZ.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (Fk().isPlaying()) {
            Fk().pause();
            this.aWZ.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.aXc != null) {
                this.aXc.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.aWY == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Fk().stop();
            this.aWY = PlayerStatus.IDLE;
            this.aWZ.onStateChanged(BgMusicPlayState.STOP);
            if (this.aXc != null) {
                this.aXc.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        Fk().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return Fk().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return Fk().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Fk() {
        if (this.aWX == null) {
            this.aWX = new MediaPlayer();
            b bVar = new b();
            this.aWX.setOnPreparedListener(bVar);
            this.aWX.setOnCompletionListener(bVar);
            this.aWX.setOnErrorListener(bVar);
            this.aWX.setOnBufferingUpdateListener(bVar);
            this.aWX.setAudioStreamType(3);
            this.aXc = new c();
        }
        return this.aWX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.aWY = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.aWZ.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.aWY = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.aWZ.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.aXc != null) {
                DefaultSwanAppBgMusicPlayer.this.aXc.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.aWZ.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.aWY == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.Fk().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.Fk().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.aWZ.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.Fk().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.Fk().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.aWZ.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.aWZ.onGetPosition(currentPosition, W(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int W(int i, int i2) {
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
    /* loaded from: classes10.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.adaptation.implementation.DefaultSwanAppBgMusicPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            DefaultSwanAppBgMusicPlayer.this.Fm();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Fl() {
        if (!this.aXa) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aXb == null) {
                this.aXb = new a();
            }
            this.aXa = this.mAudioManager.requestAudioFocus(this.aXb, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (this.aXa) {
            if (this.mAudioManager != null && this.aXb != null) {
                this.mAudioManager.abandonAudioFocus(this.aXb);
                this.mAudioManager = null;
                this.aXb = null;
            }
            this.aXa = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
