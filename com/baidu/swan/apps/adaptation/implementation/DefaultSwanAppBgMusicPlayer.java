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
/* loaded from: classes7.dex */
public class DefaultSwanAppBgMusicPlayer implements com.baidu.swan.apps.adaptation.a.k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static DefaultSwanAppBgMusicPlayer ctC;
    private MediaPlayer ctD;
    private PlayerStatus ctE = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a ctF;
    private a ctG;
    private c ctH;
    private AudioManager mAudioManager;
    private boolean mHasAudioFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public static DefaultSwanAppBgMusicPlayer ags() {
        if (ctC == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (ctC == null) {
                    ctC = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return ctC;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.ctF = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.ctE != PlayerStatus.NONE) {
                    agt().reset();
                }
                agt().setDataSource(a2.mUrl);
                this.ctE = PlayerStatus.IDLE;
                this.ctF.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.ctF.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void onRelease() {
        abandonAudioFocus();
        agt().release();
        this.ctD = null;
        this.ctE = PlayerStatus.NONE;
        if (this.ctH != null) {
            this.ctH.removeMessages(0);
            this.ctH = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void play() {
        if (this.ctE == PlayerStatus.PREPARED) {
            requestAudioFocus();
            agt().start();
            this.ctF.onStateChanged(BgMusicPlayState.PLAY);
            if (this.ctH != null) {
                this.ctH.sendEmptyMessage(0);
            }
        } else if (this.ctE == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            agt().prepareAsync();
            this.ctE = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.ctF.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void pause() {
        if (agt().isPlaying()) {
            agt().pause();
            this.ctF.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.ctH != null) {
                this.ctH.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void stop() {
        if (this.ctE == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            agt().stop();
            this.ctE = PlayerStatus.IDLE;
            this.ctF.onStateChanged(BgMusicPlayState.STOP);
            if (this.ctH != null) {
                this.ctH.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void seek(int i) {
        agt().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int getDuration() {
        return agt().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean isPlaying() {
        return agt().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer agt() {
        if (this.ctD == null) {
            this.ctD = new MediaPlayer();
            b bVar = new b();
            this.ctD.setOnPreparedListener(bVar);
            this.ctD.setOnCompletionListener(bVar);
            this.ctD.setOnErrorListener(bVar);
            this.ctD.setOnBufferingUpdateListener(bVar);
            this.ctD.setAudioStreamType(3);
            this.ctH = new c();
        }
        return this.ctD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.ctE = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.ctF.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.ctE = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.ctF.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.ctH != null) {
                DefaultSwanAppBgMusicPlayer.this.ctH.removeMessages(0);
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
            DefaultSwanAppBgMusicPlayer.this.ctF.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.ctE == PlayerStatus.PREPARED && (DefaultSwanAppBgMusicPlayer.this.agt().getDuration() * i) / 100 <= DefaultSwanAppBgMusicPlayer.this.agt().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.ctF.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.agt().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.agt().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.ctF.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.ctF.onGetPosition(currentPosition, af(duration, currentPosition));
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
    /* loaded from: classes7.dex */
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
            if (this.ctG == null) {
                this.ctG = new a();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.ctG, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            if (this.mAudioManager != null && this.ctG != null) {
                this.mAudioManager.abandonAudioFocus(this.ctG);
                this.mAudioManager = null;
                this.ctG = null;
            }
            this.mHasAudioFocus = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
