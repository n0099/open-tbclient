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
    private MediaPlayer bbk;
    private PlayerStatus bbl;
    private com.baidu.swan.apps.media.audio.service.a bbm;
    private boolean bbn;
    private a bbo;
    private c bbp;
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
            this.bbm = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bbl != PlayerStatus.NONE) {
                    HB().reset();
                }
                HB().setDataSource(a2.mUrl);
                this.bbl = PlayerStatus.IDLE;
                this.bbm.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bbm.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        HD();
        HB().release();
        this.bbk = null;
        this.bbl = PlayerStatus.NONE;
        if (this.bbp != null) {
            this.bbp.removeMessages(0);
            this.bbp = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.bbl == PlayerStatus.PREPARED) {
            HC();
            HB().start();
            this.bbm.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bbp != null) {
                this.bbp.sendEmptyMessage(0);
            }
        } else if (this.bbl == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            HB().prepareAsync();
            this.bbl = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bbm.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (HB().isPlaying()) {
            HB().pause();
            this.bbm.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bbp != null) {
                this.bbp.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.bbl == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            HB().stop();
            this.bbl = PlayerStatus.IDLE;
            this.bbm.onStateChanged(BgMusicPlayState.STOP);
            if (this.bbp != null) {
                this.bbp.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        HB().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return HB().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return HB().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer HB() {
        if (this.bbk == null) {
            this.bbk = new MediaPlayer();
            b bVar = new b();
            this.bbk.setOnPreparedListener(bVar);
            this.bbk.setOnCompletionListener(bVar);
            this.bbk.setOnErrorListener(bVar);
            this.bbk.setOnBufferingUpdateListener(bVar);
            this.bbk.setAudioStreamType(3);
            this.bbp = new c();
        }
        return this.bbk;
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
            DefaultSwanAppBgMusicPlayer.this.bbl = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bbm.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bbl = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bbm.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bbp != null) {
                DefaultSwanAppBgMusicPlayer.this.bbp.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bbm.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bbl == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.HB().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.HB().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bbm.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.HB().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.HB().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bbm.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bbm.onGetPosition(currentPosition, W(duration, currentPosition));
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
                            DefaultSwanAppBgMusicPlayer.this.HD();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void HC() {
        if (!this.bbn) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bbo == null) {
                this.bbo = new a();
            }
            this.bbn = this.mAudioManager.requestAudioFocus(this.bbo, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (this.bbn) {
            if (this.mAudioManager != null && this.bbo != null) {
                this.mAudioManager.abandonAudioFocus(this.bbo);
                this.mAudioManager = null;
                this.bbo = null;
            }
            this.bbn = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
