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
    private MediaPlayer bzL;
    private PlayerStatus bzM;
    private com.baidu.swan.apps.media.audio.service.a bzN;
    private boolean bzO;
    private a bzP;
    private c bzQ;
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
            this.bzN = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.bzM != PlayerStatus.NONE) {
                    Pt().reset();
                }
                Pt().setDataSource(a2.mUrl);
                this.bzM = PlayerStatus.IDLE;
                this.bzN.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bzN.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        Ec();
        Pt().release();
        this.bzL = null;
        this.bzM = PlayerStatus.NONE;
        if (this.bzQ != null) {
            this.bzQ.removeMessages(0);
            this.bzQ = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.bzM == PlayerStatus.PREPARED) {
            Eb();
            Pt().start();
            this.bzN.onStateChanged(BgMusicPlayState.PLAY);
            if (this.bzQ != null) {
                this.bzQ.sendEmptyMessage(0);
            }
        } else if (this.bzM == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Pt().prepareAsync();
            this.bzM = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bzN.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (Pt().isPlaying()) {
            Pt().pause();
            this.bzN.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.bzQ != null) {
                this.bzQ.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.bzM == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Pt().stop();
            this.bzM = PlayerStatus.IDLE;
            this.bzN.onStateChanged(BgMusicPlayState.STOP);
            if (this.bzQ != null) {
                this.bzQ.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        Pt().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return Pt().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return Pt().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Pt() {
        if (this.bzL == null) {
            this.bzL = new MediaPlayer();
            b bVar = new b();
            this.bzL.setOnPreparedListener(bVar);
            this.bzL.setOnCompletionListener(bVar);
            this.bzL.setOnErrorListener(bVar);
            this.bzL.setOnBufferingUpdateListener(bVar);
            this.bzL.setAudioStreamType(3);
            this.bzQ = new c();
        }
        return this.bzL;
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
            DefaultSwanAppBgMusicPlayer.this.bzM = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bzN.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.bzM = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.bzN.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.bzQ != null) {
                DefaultSwanAppBgMusicPlayer.this.bzQ.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.bzN.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.bzM == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.Pt().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.Pt().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.bzN.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.Pt().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.Pt().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.bzN.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.bzN.onGetPosition(currentPosition, Y(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int Y(int i, int i2) {
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
                            DefaultSwanAppBgMusicPlayer.this.Ec();
                            DefaultSwanAppBgMusicPlayer.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Eb() {
        if (!this.bzO) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.bzP == null) {
                this.bzP = new a();
            }
            this.bzO = this.mAudioManager.requestAudioFocus(this.bzP, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ec() {
        if (this.bzO) {
            if (this.mAudioManager != null && this.bzP != null) {
                this.mAudioManager.abandonAudioFocus(this.bzP);
                this.mAudioManager = null;
                this.bzP = null;
            }
            this.bzO = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
