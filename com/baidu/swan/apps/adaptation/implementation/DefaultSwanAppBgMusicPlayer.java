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
/* loaded from: classes9.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aWf;
    private PlayerStatus aWg;
    private com.baidu.swan.apps.media.audio.service.a aWh;
    private boolean aWi;
    private a aWj;
    private c aWk;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.aWh = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.aWg != PlayerStatus.NONE) {
                    EO().reset();
                }
                EO().setDataSource(a2.mUrl);
                this.aWg = PlayerStatus.IDLE;
                this.aWh.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.aWh.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        EQ();
        EO().release();
        this.aWf = null;
        this.aWg = PlayerStatus.NONE;
        if (this.aWk != null) {
            this.aWk.removeMessages(0);
            this.aWk = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.aWg == PlayerStatus.PREPARED) {
            EP();
            EO().start();
            this.aWh.onStateChanged(BgMusicPlayState.PLAY);
            if (this.aWk != null) {
                this.aWk.sendEmptyMessage(0);
            }
        } else if (this.aWg == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            EO().prepareAsync();
            this.aWg = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.aWh.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (EO().isPlaying()) {
            EO().pause();
            this.aWh.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.aWk != null) {
                this.aWk.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.aWg == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            EO().stop();
            this.aWg = PlayerStatus.IDLE;
            this.aWh.onStateChanged(BgMusicPlayState.STOP);
            if (this.aWk != null) {
                this.aWk.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        EO().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return EO().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return EO().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer EO() {
        if (this.aWf == null) {
            this.aWf = new MediaPlayer();
            b bVar = new b();
            this.aWf.setOnPreparedListener(bVar);
            this.aWf.setOnCompletionListener(bVar);
            this.aWf.setOnErrorListener(bVar);
            this.aWf.setOnBufferingUpdateListener(bVar);
            this.aWf.setAudioStreamType(3);
            this.aWk = new c();
        }
        return this.aWf;
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
            DefaultSwanAppBgMusicPlayer.this.aWg = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.aWh.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.aWg = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.aWh.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.aWk != null) {
                DefaultSwanAppBgMusicPlayer.this.aWk.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.aWh.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.aWg == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.EO().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.EO().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.aWh.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.EO().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.EO().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.aWh.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.aWh.onGetPosition(currentPosition, S(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int S(int i, int i2) {
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
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.adaptation.implementation.DefaultSwanAppBgMusicPlayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            DefaultSwanAppBgMusicPlayer.this.EQ();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void EP() {
        if (!this.aWi) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.aWj == null) {
                this.aWj = new a();
            }
            this.aWi = this.mAudioManager.requestAudioFocus(this.aWj, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        if (this.aWi) {
            if (this.mAudioManager != null && this.aWj != null) {
                this.mAudioManager.abandonAudioFocus(this.aWj);
                this.mAudioManager = null;
                this.aWj = null;
            }
            this.aWi = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
