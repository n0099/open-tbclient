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
    private static DefaultSwanAppBgMusicPlayer cpp;
    private MediaPlayer cpq;
    private PlayerStatus cpr = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cps;
    private a cpt;
    private c cpv;
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

    public static DefaultSwanAppBgMusicPlayer aeA() {
        if (cpp == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (cpp == null) {
                    cpp = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return cpp;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cps = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cpr != PlayerStatus.NONE) {
                    aeB().reset();
                }
                aeB().setDataSource(a2.mUrl);
                this.cpr = PlayerStatus.IDLE;
                this.cps.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cps.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        aeB().release();
        this.cpq = null;
        this.cpr = PlayerStatus.NONE;
        if (this.cpv != null) {
            this.cpv.removeMessages(0);
            this.cpv = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.cpr == PlayerStatus.PREPARED) {
            requestAudioFocus();
            aeB().start();
            this.cps.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cpv != null) {
                this.cpv.sendEmptyMessage(0);
            }
        } else if (this.cpr == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            aeB().prepareAsync();
            this.cpr = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cps.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (aeB().isPlaying()) {
            aeB().pause();
            this.cps.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cpv != null) {
                this.cpv.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.cpr == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            aeB().stop();
            this.cpr = PlayerStatus.IDLE;
            this.cps.onStateChanged(BgMusicPlayState.STOP);
            if (this.cpv != null) {
                this.cpv.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        aeB().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return aeB().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return aeB().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer aeB() {
        if (this.cpq == null) {
            this.cpq = new MediaPlayer();
            b bVar = new b();
            this.cpq.setOnPreparedListener(bVar);
            this.cpq.setOnCompletionListener(bVar);
            this.cpq.setOnErrorListener(bVar);
            this.cpq.setOnBufferingUpdateListener(bVar);
            this.cpq.setAudioStreamType(3);
            this.cpv = new c();
        }
        return this.cpq;
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
            DefaultSwanAppBgMusicPlayer.this.cpr = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cps.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.cpr = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.cps.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.cpv != null) {
                DefaultSwanAppBgMusicPlayer.this.cpv.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.cps.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.cpr == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.aeB().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.aeB().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.cps.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = DefaultSwanAppBgMusicPlayer.this.aeB().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.aeB().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.cps.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.cps.onGetPosition(currentPosition, af(duration, currentPosition));
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
            if (this.cpt == null) {
                this.cpt = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.cpt, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.cpt != null) {
                this.mAudioManager.abandonAudioFocus(this.cpt);
                this.mAudioManager = null;
                this.cpt = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
