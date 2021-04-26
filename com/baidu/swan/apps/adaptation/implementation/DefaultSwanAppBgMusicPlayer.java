package com.baidu.swan.apps.adaptation.implementation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import d.a.h0.a.i2.k0;
import d.a.h0.a.p.c.k;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public class DefaultSwanAppBgMusicPlayer implements k {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11386h = d.a.h0.a.k.f43101a;

    /* renamed from: i  reason: collision with root package name */
    public static DefaultSwanAppBgMusicPlayer f11387i;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f11388a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f11389b = PlayerStatus.NONE;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.b1.c.f.a f11390c;

    /* renamed from: d  reason: collision with root package name */
    public AudioManager f11391d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11392e;

    /* renamed from: f  reason: collision with root package name */
    public b f11393f;

    /* renamed from: g  reason: collision with root package name */
    public d f11394g;

    /* loaded from: classes2.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    /* loaded from: classes2.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f11396e;

            public a(int i2) {
                this.f11396e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f11396e;
                if (i2 == -2 || i2 == -1) {
                    if (DefaultSwanAppBgMusicPlayer.f11386h) {
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
        public void onAudioFocusChange(int i2) {
            k0.X(new a(i2));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            if (DefaultSwanAppBgMusicPlayer.f11386h) {
                Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i2 + "%");
            }
            DefaultSwanAppBgMusicPlayer.this.f11390c.onGetDownloadProgress(i2);
            if (DefaultSwanAppBgMusicPlayer.this.f11389b != PlayerStatus.PREPARED || (i2 * DefaultSwanAppBgMusicPlayer.this.k().getDuration()) / 100 > DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition()) {
                return;
            }
            DefaultSwanAppBgMusicPlayer.this.f11390c.onStateChanged(BgMusicPlayState.LOADING);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f11386h) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.f11389b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f11390c.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.f11394g != null) {
                DefaultSwanAppBgMusicPlayer.this.f11394g.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (DefaultSwanAppBgMusicPlayer.f11386h) {
                Log.d("AudioPlayerListener", "--onError -> what: " + i2 + " extra: " + i3);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f11386h) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.f11389b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f11390c.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }
    }

    /* loaded from: classes2.dex */
    public class d extends Handler {
        public d() {
        }

        public final int a(int i2, int i3) {
            if (i3 > i2) {
                i3 = i2;
            }
            if (i2 > 0) {
                return (int) ((((i3 * 100) * 1.0f) / i2) + 0.5f);
            }
            return 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = DefaultSwanAppBgMusicPlayer.this.k().getDuration();
                int currentPosition = DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition();
                DefaultSwanAppBgMusicPlayer.this.f11390c.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.f11390c.onGetPosition(currentPosition, a(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }
    }

    public static DefaultSwanAppBgMusicPlayer j() {
        if (f11387i == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (f11387i == null) {
                    f11387i = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return f11387i;
    }

    @Override // d.a.h0.a.p.c.k
    public void a(String str, d.a.h0.a.b1.c.f.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11390c = aVar;
        try {
            d.a.h0.a.b1.c.a b2 = d.a.h0.a.b1.c.a.b(new JSONObject(str), new d.a.h0.a.b1.c.a());
            if (this.f11389b != PlayerStatus.NONE) {
                k().reset();
            }
            k().setDataSource(b2.f41271c);
            this.f11389b = PlayerStatus.IDLE;
            this.f11390c.onGetCurrentSong(b2.f41271c);
            play();
        } catch (IOException | JSONException e2) {
            e2.printStackTrace();
            this.f11390c.onInvokeFailed();
        }
    }

    public final void b() {
        b bVar;
        if (this.f11392e) {
            AudioManager audioManager = this.f11391d;
            if (audioManager != null && (bVar = this.f11393f) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f11391d = null;
                this.f11393f = null;
            }
            this.f11392e = false;
            if (f11386h) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.h0.a.p.c.k
    public int getDuration() {
        return k().getDuration();
    }

    @Override // d.a.h0.a.p.c.k
    public boolean isPlaying() {
        return k().isPlaying();
    }

    public final MediaPlayer k() {
        if (this.f11388a == null) {
            this.f11388a = new MediaPlayer();
            c cVar = new c();
            this.f11388a.setOnPreparedListener(cVar);
            this.f11388a.setOnCompletionListener(cVar);
            this.f11388a.setOnErrorListener(cVar);
            this.f11388a.setOnBufferingUpdateListener(cVar);
            this.f11388a.setAudioStreamType(3);
            this.f11394g = new d();
        }
        return this.f11388a;
    }

    public final void l() {
        try {
            k().prepareAsync();
            this.f11389b = PlayerStatus.PREPARING;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            this.f11390c.onInvokeFailed();
            onRelease();
        }
    }

    public final void m() {
        if (this.f11392e) {
            return;
        }
        if (this.f11391d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f11391d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f11393f == null) {
            this.f11393f = new b();
        }
        this.f11392e = this.f11391d.requestAudioFocus(this.f11393f, 3, 1) == 1;
        if (f11386h) {
            Log.d("AudioPlayerListener", "   requestAudioFocus");
        }
    }

    @Override // d.a.h0.a.p.c.k
    public void onRelease() {
        b();
        k().release();
        this.f11388a = null;
        this.f11389b = PlayerStatus.NONE;
        d dVar = this.f11394g;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f11394g = null;
        }
    }

    @Override // d.a.h0.a.p.c.k
    public void pause() {
        if (k().isPlaying()) {
            k().pause();
            this.f11390c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.f11394g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // d.a.h0.a.p.c.k
    public void play() {
        PlayerStatus playerStatus = this.f11389b;
        if (playerStatus == PlayerStatus.PREPARED) {
            m();
            k().start();
            this.f11390c.onStateChanged(BgMusicPlayState.PLAY);
            d dVar = this.f11394g;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            l();
        }
    }

    @Override // d.a.h0.a.p.c.k
    public void seek(int i2) {
        k().seekTo(i2);
    }

    @Override // d.a.h0.a.p.c.k
    public void stop() {
        if (this.f11389b == PlayerStatus.PREPARED) {
            if (f11386h) {
                Log.d("AudioPlayerListener", "===stop");
            }
            k().stop();
            this.f11389b = PlayerStatus.IDLE;
            this.f11390c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.f11394g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
