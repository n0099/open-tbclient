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
/* loaded from: classes11.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer bbi;
    private PlayerStatus bbj;
    private com.baidu.swan.apps.media.audio.service.a bbk;
    private boolean bbl;
    private a bbm;
    private c bbn;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bbk = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bbj != PlayerStatus.NONE) {
                    Hz().reset();
                }
                Hz().setDataSource(a2.mUrl);
                this.bbj = PlayerStatus.IDLE;
                this.bbk.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bbk.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        HB();
        Hz().release();
        this.bbi = null;
        this.bbj = PlayerStatus.NONE;
        if (this.bbn != null) {
            this.bbn.removeMessages(0);
            this.bbn = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.bbj == PlayerStatus.PREPARED) {
            HA();
            Hz().start();
            this.bbk.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bbn != null) {
                this.bbn.sendEmptyMessage(0);
            }
        } else if (this.bbj == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Hz().prepareAsync();
            this.bbj = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bbk.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (Hz().isPlaying()) {
            Hz().pause();
            this.bbk.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bbn != null) {
                this.bbn.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.bbj == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Hz().stop();
            this.bbj = PlayerStatus.IDLE;
            this.bbk.onStateChanged(BgMusicPlayState.STOP);
            if (this.bbn != null) {
                this.bbn.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        Hz().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return Hz().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return Hz().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Hz() {
        if (this.bbi == null) {
            this.bbi = new MediaPlayer();
            b bVar = new b();
            this.bbi.setOnPreparedListener(bVar);
            this.bbi.setOnCompletionListener(bVar);
            this.bbi.setOnErrorListener(bVar);
            this.bbi.setOnBufferingUpdateListener(bVar);
            this.bbi.setAudioStreamType(3);
            this.bbn = new c();
        }
        return this.bbi;
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
            DefaultSwanAppBgMusicPlayer.this.bbj = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bbk.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bbj = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bbk.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bbn != null) {
                DefaultSwanAppBgMusicPlayer.this.bbn.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bbk.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bbj == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.Hz().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.Hz().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bbk.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.Hz().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.Hz().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bbk.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bbk.onGetPosition(currentPosition, W(duration, currentPosition));
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
    /* loaded from: classes11.dex */
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
                            DefaultSwanAppBgMusicPlayer.this.HB();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void HA() {
        if (!this.bbl) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bbm == null) {
                this.bbm = new a();
            }
            this.bbl = this.mAudioManager.requestAudioFocus(this.bbm, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.bbl) {
            if (this.mAudioManager != null && this.bbm != null) {
                this.mAudioManager.abandonAudioFocus(this.bbm);
                this.mAudioManager = null;
                this.bbm = null;
            }
            this.bbl = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
