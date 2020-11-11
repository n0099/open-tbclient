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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer cvo;
    private MediaPlayer cvp;
    private PlayerStatus cvq = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cvr;
    private a cvs;
    private c cvt;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer aha() {
        if (cvo == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cvo == null) {
                    cvo = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cvo;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cvr = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cvq != PlayerStatus.NONE) {
                    ahb().reset();
                }
                ahb().setDataSource(a2.mUrl);
                this.cvq = PlayerStatus.IDLE;
                this.cvr.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cvr.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        ahb().release();
        this.cvp = null;
        this.cvq = PlayerStatus.NONE;
        if (this.cvt != null) {
            this.cvt.removeMessages(0);
            this.cvt = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cvq == PlayerStatus.PREPARED) {
            requestAudioFocus();
            ahb().start();
            this.cvr.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cvt != null) {
                this.cvt.sendEmptyMessage(0);
            }
        } else if (this.cvq == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            ahb().prepareAsync();
            this.cvq = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cvr.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (ahb().isPlaying()) {
            ahb().pause();
            this.cvr.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cvt != null) {
                this.cvt.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cvq == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            ahb().stop();
            this.cvq = PlayerStatus.IDLE;
            this.cvr.onStateChanged(BgMusicPlayState.STOP);
            if (this.cvt != null) {
                this.cvt.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        ahb().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return ahb().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return ahb().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer ahb() {
        if (this.cvp == null) {
            this.cvp = new MediaPlayer();
            b bVar = new b();
            this.cvp.setOnPreparedListener(bVar);
            this.cvp.setOnCompletionListener(bVar);
            this.cvp.setOnErrorListener(bVar);
            this.cvp.setOnBufferingUpdateListener(bVar);
            this.cvp.setAudioStreamType(3);
            this.cvt = new c();
        }
        return this.cvp;
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
            DefaultSwanAppBgMusicPlayer.this.cvq = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cvr.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cvq = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cvr.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cvt != null) {
                DefaultSwanAppBgMusicPlayer.this.cvt.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.cvr.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cvq == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.ahb().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.ahb().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cvr.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.ahb().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.ahb().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cvr.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cvr.onGetPosition(currentPosition, af(duration, currentPosition));
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
    /* loaded from: classes10.dex */
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
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cvs == null) {
                this.cvs = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cvs, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cvs != null) {
                this.mAudioManager.abandonAudioFocus(this.cvs);
                this.mAudioManager = null;
                this.cvs = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
