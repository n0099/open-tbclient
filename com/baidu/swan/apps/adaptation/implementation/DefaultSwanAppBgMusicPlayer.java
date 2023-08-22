package com.baidu.swan.apps.adaptation.implementation;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import com.baidu.tieba.dy2;
import com.baidu.tieba.fv1;
import com.baidu.tieba.ji3;
import com.baidu.tieba.ky2;
import com.baidu.tieba.nr1;
import com.baidu.tieba.xo3;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DefaultSwanAppBgMusicPlayer implements fv1 {
    public static final boolean h = nr1.a;
    public static volatile DefaultSwanAppBgMusicPlayer i;
    public MediaPlayer a;
    public PlayerStatus b = PlayerStatus.NONE;
    public ky2 c;
    public AudioManager d;
    public boolean e;
    public b f;
    public d g;

    /* loaded from: classes4.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* loaded from: classes4.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.a;
                if (i == -2 || i == -1) {
                    if (DefaultSwanAppBgMusicPlayer.h) {
                        Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    DefaultSwanAppBgMusicPlayer.this.b();
                    DefaultSwanAppBgMusicPlayer.this.pause();
                }
            }
        }

        public b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            xo3.e0(new a(i));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.h) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.c.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.g != null) {
                DefaultSwanAppBgMusicPlayer.this.g.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.h) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.c.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (DefaultSwanAppBgMusicPlayer.h) {
                Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i + "%");
            }
            DefaultSwanAppBgMusicPlayer.this.c.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.b == PlayerStatus.PREPARED && (i * DefaultSwanAppBgMusicPlayer.this.k().getDuration()) / 100 <= DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition()) {
                DefaultSwanAppBgMusicPlayer.this.c.onStateChanged(BgMusicPlayState.LOADING);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (DefaultSwanAppBgMusicPlayer.h) {
                Log.d("AudioPlayerListener", "--onError -> what: " + i + " extra: " + i2);
            }
            ji3.b("audio", 2008, "--onError -> what: " + i + " extra: " + i2, -1, "");
            return true;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class d extends Handler {
        public final int a(int i, int i2) {
            if (i2 > i) {
                i2 = i;
            }
            if (i > 0) {
                return (int) ((((i2 * 100) * 1.0f) / i) + 0.5f);
            }
            return 0;
        }

        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.k().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.c.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.c.onGetPosition(currentPosition, a(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }
    }

    public static DefaultSwanAppBgMusicPlayer j() {
        if (i == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (i == null) {
                    i = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return i;
    }

    public final void b() {
        b bVar;
        if (!this.e) {
            return;
        }
        AudioManager audioManager = this.d;
        if (audioManager != null && (bVar = this.f) != null) {
            audioManager.abandonAudioFocus(bVar);
            this.d = null;
            this.f = null;
        }
        this.e = false;
        if (h) {
            Log.d("AudioPlayerListener", "   abandonAudioFocus");
        }
    }

    @Override // com.baidu.tieba.fv1
    public int getDuration() {
        return k().getDuration();
    }

    @Override // com.baidu.tieba.fv1
    public boolean isPlaying() {
        return k().isPlaying();
    }

    public final void l() {
        try {
            k().prepareAsync();
            this.b = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.c.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.tieba.fv1
    public void onRelease() {
        b();
        k().release();
        this.a = null;
        this.b = PlayerStatus.NONE;
        d dVar = this.g;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.g = null;
        }
    }

    @Override // com.baidu.tieba.fv1
    public void pause() {
        if (k().isPlaying()) {
            k().pause();
            this.c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.tieba.fv1
    public void play() {
        PlayerStatus playerStatus = this.b;
        if (playerStatus == PlayerStatus.PREPARED) {
            m();
            k().start();
            this.c.onStateChanged(BgMusicPlayState.PLAY);
            d dVar = this.g;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            l();
        }
    }

    @Override // com.baidu.tieba.fv1
    public void stop() {
        if (this.b == PlayerStatus.PREPARED) {
            if (h) {
                Log.d("AudioPlayerListener", "===stop");
            }
            k().stop();
            this.b = PlayerStatus.IDLE;
            this.c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.tieba.fv1
    public void seek(int i2) {
        k().seekTo(i2);
    }

    @Override // com.baidu.tieba.fv1
    public void a(String str, ky2 ky2Var) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c = ky2Var;
        try {
            dy2 b2 = dy2.b(new JSONObject(str), new dy2());
            str2 = b2.c;
            try {
                if (this.b != PlayerStatus.NONE) {
                    k().reset();
                }
                k().setDataSource(b2.c);
                this.b = PlayerStatus.IDLE;
                this.c.onGetCurrentSong(b2.c);
                play();
            } catch (IOException e) {
                e = e;
                ji3.b("audio", 1001, "audio src error, src is" + str2, -1, "");
                e.printStackTrace();
                this.c.onInvokeFailed();
            } catch (JSONException e2) {
                e = e2;
                ji3.b("audio", 1001, "audio src error, src is" + str2, -1, "");
                e.printStackTrace();
                this.c.onInvokeFailed();
            }
        } catch (IOException | JSONException e3) {
            e = e3;
            str2 = "";
        }
    }

    public final MediaPlayer k() {
        if (this.a == null) {
            this.a = new MediaPlayer();
            c cVar = new c();
            this.a.setOnPreparedListener(cVar);
            this.a.setOnCompletionListener(cVar);
            this.a.setOnErrorListener(cVar);
            this.a.setOnBufferingUpdateListener(cVar);
            this.a.setAudioStreamType(3);
            this.g = new d();
        }
        return this.a;
    }

    public final void m() {
        if (this.e) {
            return;
        }
        if (this.d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f == null) {
            this.f = new b();
        }
        boolean z = true;
        if (this.d.requestAudioFocus(this.f, 3, 1) != 1) {
            z = false;
        }
        this.e = z;
        if (h) {
            Log.d("AudioPlayerListener", "   requestAudioFocus");
        }
    }
}
