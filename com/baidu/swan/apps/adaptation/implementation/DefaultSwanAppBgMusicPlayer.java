package com.baidu.swan.apps.adaptation.implementation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import d.b.g0.a.i2.k0;
import d.b.g0.a.p.c.k;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DefaultSwanAppBgMusicPlayer implements k {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11889h = d.b.g0.a.k.f45050a;
    public static DefaultSwanAppBgMusicPlayer i;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f11890a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f11891b = PlayerStatus.NONE;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.b1.c.f.a f11892c;

    /* renamed from: d  reason: collision with root package name */
    public AudioManager f11893d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11894e;

    /* renamed from: f  reason: collision with root package name */
    public b f11895f;

    /* renamed from: g  reason: collision with root package name */
    public d f11896g;

    /* loaded from: classes3.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* loaded from: classes3.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f11898e;

            public a(int i) {
                this.f11898e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.f11898e;
                if (i == -2 || i == -1) {
                    if (DefaultSwanAppBgMusicPlayer.f11889h) {
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
            k0.X(new a(i));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (DefaultSwanAppBgMusicPlayer.f11889h) {
                Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i + "%");
            }
            DefaultSwanAppBgMusicPlayer.this.f11892c.onGetDownloadProgress(i);
            if (DefaultSwanAppBgMusicPlayer.this.f11891b != PlayerStatus.PREPARED || (i * DefaultSwanAppBgMusicPlayer.this.k().getDuration()) / 100 > DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition()) {
                return;
            }
            DefaultSwanAppBgMusicPlayer.this.f11892c.onStateChanged(BgMusicPlayState.LOADING);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f11889h) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.f11891b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f11892c.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.f11896g != null) {
                DefaultSwanAppBgMusicPlayer.this.f11896g.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (DefaultSwanAppBgMusicPlayer.f11889h) {
                Log.d("AudioPlayerListener", "--onError -> what: " + i + " extra: " + i2);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f11889h) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.f11891b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f11892c.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends Handler {
        public d() {
        }

        public final int a(int i, int i2) {
            if (i2 > i) {
                i2 = i;
            }
            if (i > 0) {
                return (int) ((((i2 * 100) * 1.0f) / i) + 0.5f);
            }
            return 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.k().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.f11892c.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.f11892c.onGetPosition(currentPosition, a(duration, currentPosition));
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

    @Override // d.b.g0.a.p.c.k
    public void a(String str, d.b.g0.a.b1.c.f.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11892c = aVar;
        try {
            d.b.g0.a.b1.c.a b2 = d.b.g0.a.b1.c.a.b(new JSONObject(str), new d.b.g0.a.b1.c.a());
            if (this.f11891b != PlayerStatus.NONE) {
                k().reset();
            }
            k().setDataSource(b2.f43279c);
            this.f11891b = PlayerStatus.IDLE;
            this.f11892c.onGetCurrentSong(b2.f43279c);
            play();
        } catch (IOException | JSONException e2) {
            e2.printStackTrace();
            this.f11892c.onInvokeFailed();
        }
    }

    public final void b() {
        b bVar;
        if (this.f11894e) {
            AudioManager audioManager = this.f11893d;
            if (audioManager != null && (bVar = this.f11895f) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f11893d = null;
                this.f11895f = null;
            }
            this.f11894e = false;
            if (f11889h) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.b.g0.a.p.c.k
    public int getDuration() {
        return k().getDuration();
    }

    @Override // d.b.g0.a.p.c.k
    public boolean isPlaying() {
        return k().isPlaying();
    }

    public final MediaPlayer k() {
        if (this.f11890a == null) {
            this.f11890a = new MediaPlayer();
            c cVar = new c();
            this.f11890a.setOnPreparedListener(cVar);
            this.f11890a.setOnCompletionListener(cVar);
            this.f11890a.setOnErrorListener(cVar);
            this.f11890a.setOnBufferingUpdateListener(cVar);
            this.f11890a.setAudioStreamType(3);
            this.f11896g = new d();
        }
        return this.f11890a;
    }

    public final void l() {
        try {
            k().prepareAsync();
            this.f11891b = PlayerStatus.PREPARING;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            this.f11892c.onInvokeFailed();
            onRelease();
        }
    }

    public final void m() {
        if (this.f11894e) {
            return;
        }
        if (this.f11893d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.f11893d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f11895f == null) {
            this.f11895f = new b();
        }
        this.f11894e = this.f11893d.requestAudioFocus(this.f11895f, 3, 1) == 1;
        if (f11889h) {
            Log.d("AudioPlayerListener", "   requestAudioFocus");
        }
    }

    @Override // d.b.g0.a.p.c.k
    public void onRelease() {
        b();
        k().release();
        this.f11890a = null;
        this.f11891b = PlayerStatus.NONE;
        d dVar = this.f11896g;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f11896g = null;
        }
    }

    @Override // d.b.g0.a.p.c.k
    public void pause() {
        if (k().isPlaying()) {
            k().pause();
            this.f11892c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.f11896g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // d.b.g0.a.p.c.k
    public void play() {
        PlayerStatus playerStatus = this.f11891b;
        if (playerStatus == PlayerStatus.PREPARED) {
            m();
            k().start();
            this.f11892c.onStateChanged(BgMusicPlayState.PLAY);
            d dVar = this.f11896g;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            l();
        }
    }

    @Override // d.b.g0.a.p.c.k
    public void seek(int i2) {
        k().seekTo(i2);
    }

    @Override // d.b.g0.a.p.c.k
    public void stop() {
        if (this.f11891b == PlayerStatus.PREPARED) {
            if (f11889h) {
                Log.d("AudioPlayerListener", "===stop");
            }
            k().stop();
            this.f11891b = PlayerStatus.IDLE;
            this.f11892c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.f11896g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
