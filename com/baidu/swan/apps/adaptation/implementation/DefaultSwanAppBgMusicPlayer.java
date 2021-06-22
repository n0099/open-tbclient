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
import d.a.m0.a.k;
import d.a.m0.a.p.d.s;
import d.a.m0.a.v2.q0;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DefaultSwanAppBgMusicPlayer implements s {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10503h = k.f46983a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile DefaultSwanAppBgMusicPlayer f10504i;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f10505a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f10506b = PlayerStatus.NONE;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.i1.c.f.a f10507c;

    /* renamed from: d  reason: collision with root package name */
    public AudioManager f10508d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10509e;

    /* renamed from: f  reason: collision with root package name */
    public b f10510f;

    /* renamed from: g  reason: collision with root package name */
    public d f10511g;

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
            public final /* synthetic */ int f10513e;

            public a(int i2) {
                this.f10513e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f10513e;
                if (i2 == -2 || i2 == -1) {
                    if (DefaultSwanAppBgMusicPlayer.f10503h) {
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
            q0.b0(new a(i2));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            if (DefaultSwanAppBgMusicPlayer.f10503h) {
                Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i2 + "%");
            }
            DefaultSwanAppBgMusicPlayer.this.f10507c.onGetDownloadProgress(i2);
            if (DefaultSwanAppBgMusicPlayer.this.f10506b != PlayerStatus.PREPARED || (i2 * DefaultSwanAppBgMusicPlayer.this.k().getDuration()) / 100 > DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition()) {
                return;
            }
            DefaultSwanAppBgMusicPlayer.this.f10507c.onStateChanged(BgMusicPlayState.LOADING);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f10503h) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.f10506b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f10507c.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.f10511g != null) {
                DefaultSwanAppBgMusicPlayer.this.f10511g.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (DefaultSwanAppBgMusicPlayer.f10503h) {
                Log.d("AudioPlayerListener", "--onError -> what: " + i2 + " extra: " + i3);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f10503h) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.f10506b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f10507c.onStateChanged(BgMusicPlayState.READY);
            DefaultSwanAppBgMusicPlayer.this.play();
        }
    }

    @SuppressLint({"HandlerLeak"})
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
                DefaultSwanAppBgMusicPlayer.this.f10507c.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.f10507c.onGetPosition(currentPosition, a(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }
    }

    public static DefaultSwanAppBgMusicPlayer j() {
        if (f10504i == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (f10504i == null) {
                    f10504i = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return f10504i;
    }

    @Override // d.a.m0.a.p.d.s
    public void a(String str, d.a.m0.a.i1.c.f.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10507c = aVar;
        try {
            d.a.m0.a.i1.c.a b2 = d.a.m0.a.i1.c.a.b(new JSONObject(str), new d.a.m0.a.i1.c.a());
            if (this.f10506b != PlayerStatus.NONE) {
                k().reset();
            }
            k().setDataSource(b2.f46496c);
            this.f10506b = PlayerStatus.IDLE;
            this.f10507c.onGetCurrentSong(b2.f46496c);
            play();
        } catch (IOException | JSONException e2) {
            e2.printStackTrace();
            this.f10507c.onInvokeFailed();
        }
    }

    public final void b() {
        b bVar;
        if (this.f10509e) {
            AudioManager audioManager = this.f10508d;
            if (audioManager != null && (bVar = this.f10510f) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f10508d = null;
                this.f10510f = null;
            }
            this.f10509e = false;
            if (f10503h) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.m0.a.p.d.s
    public int getDuration() {
        return k().getDuration();
    }

    @Override // d.a.m0.a.p.d.s
    public boolean isPlaying() {
        return k().isPlaying();
    }

    public final MediaPlayer k() {
        if (this.f10505a == null) {
            this.f10505a = new MediaPlayer();
            c cVar = new c();
            this.f10505a.setOnPreparedListener(cVar);
            this.f10505a.setOnCompletionListener(cVar);
            this.f10505a.setOnErrorListener(cVar);
            this.f10505a.setOnBufferingUpdateListener(cVar);
            this.f10505a.setAudioStreamType(3);
            this.f10511g = new d();
        }
        return this.f10505a;
    }

    public final void l() {
        try {
            k().prepareAsync();
            this.f10506b = PlayerStatus.PREPARING;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            this.f10507c.onInvokeFailed();
            onRelease();
        }
    }

    public final void m() {
        if (this.f10509e) {
            return;
        }
        if (this.f10508d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.f10508d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f10510f == null) {
            this.f10510f = new b();
        }
        this.f10509e = this.f10508d.requestAudioFocus(this.f10510f, 3, 1) == 1;
        if (f10503h) {
            Log.d("AudioPlayerListener", "   requestAudioFocus");
        }
    }

    @Override // d.a.m0.a.p.d.s
    public void onRelease() {
        b();
        k().release();
        this.f10505a = null;
        this.f10506b = PlayerStatus.NONE;
        d dVar = this.f10511g;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f10511g = null;
        }
    }

    @Override // d.a.m0.a.p.d.s
    public void pause() {
        if (k().isPlaying()) {
            k().pause();
            this.f10507c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.f10511g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // d.a.m0.a.p.d.s
    public void play() {
        PlayerStatus playerStatus = this.f10506b;
        if (playerStatus == PlayerStatus.PREPARED) {
            m();
            k().start();
            this.f10507c.onStateChanged(BgMusicPlayState.PLAY);
            d dVar = this.f10511g;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            l();
        }
    }

    @Override // d.a.m0.a.p.d.s
    public void seek(int i2) {
        k().seekTo(i2);
    }

    @Override // d.a.m0.a.p.d.s
    public void stop() {
        if (this.f10506b == PlayerStatus.PREPARED) {
            if (f10503h) {
                Log.d("AudioPlayerListener", "===stop");
            }
            k().stop();
            this.f10506b = PlayerStatus.IDLE;
            this.f10507c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.f10511g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
