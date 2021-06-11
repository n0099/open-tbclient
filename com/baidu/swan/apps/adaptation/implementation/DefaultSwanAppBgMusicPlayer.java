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
import d.a.l0.a.k;
import d.a.l0.a.p.d.s;
import d.a.l0.a.v2.q0;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DefaultSwanAppBgMusicPlayer implements s {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10421h = k.f46875a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile DefaultSwanAppBgMusicPlayer f10422i;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f10423a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f10424b = PlayerStatus.NONE;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.i1.c.f.a f10425c;

    /* renamed from: d  reason: collision with root package name */
    public AudioManager f10426d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10427e;

    /* renamed from: f  reason: collision with root package name */
    public b f10428f;

    /* renamed from: g  reason: collision with root package name */
    public d f10429g;

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
            public final /* synthetic */ int f10431e;

            public a(int i2) {
                this.f10431e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f10431e;
                if (i2 == -2 || i2 == -1) {
                    if (DefaultSwanAppBgMusicPlayer.f10421h) {
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
            if (DefaultSwanAppBgMusicPlayer.f10421h) {
                Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i2 + "%");
            }
            DefaultSwanAppBgMusicPlayer.this.f10425c.onGetDownloadProgress(i2);
            if (DefaultSwanAppBgMusicPlayer.this.f10424b != PlayerStatus.PREPARED || (i2 * DefaultSwanAppBgMusicPlayer.this.k().getDuration()) / 100 > DefaultSwanAppBgMusicPlayer.this.k().getCurrentPosition()) {
                return;
            }
            DefaultSwanAppBgMusicPlayer.this.f10425c.onStateChanged(BgMusicPlayState.LOADING);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f10421h) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            DefaultSwanAppBgMusicPlayer.this.f10424b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f10425c.onStateChanged(BgMusicPlayState.END);
            if (DefaultSwanAppBgMusicPlayer.this.f10429g != null) {
                DefaultSwanAppBgMusicPlayer.this.f10429g.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (DefaultSwanAppBgMusicPlayer.f10421h) {
                Log.d("AudioPlayerListener", "--onError -> what: " + i2 + " extra: " + i3);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (DefaultSwanAppBgMusicPlayer.f10421h) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            DefaultSwanAppBgMusicPlayer.this.f10424b = PlayerStatus.PREPARED;
            DefaultSwanAppBgMusicPlayer.this.f10425c.onStateChanged(BgMusicPlayState.READY);
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
                DefaultSwanAppBgMusicPlayer.this.f10425c.onGetDuration(duration);
                DefaultSwanAppBgMusicPlayer.this.f10425c.onGetPosition(currentPosition, a(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }
    }

    public static DefaultSwanAppBgMusicPlayer j() {
        if (f10422i == null) {
            synchronized (DefaultSwanAppBgMusicPlayer.class) {
                if (f10422i == null) {
                    f10422i = new DefaultSwanAppBgMusicPlayer();
                }
            }
        }
        return f10422i;
    }

    @Override // d.a.l0.a.p.d.s
    public void a(String str, d.a.l0.a.i1.c.f.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10425c = aVar;
        try {
            d.a.l0.a.i1.c.a b2 = d.a.l0.a.i1.c.a.b(new JSONObject(str), new d.a.l0.a.i1.c.a());
            if (this.f10424b != PlayerStatus.NONE) {
                k().reset();
            }
            k().setDataSource(b2.f46388c);
            this.f10424b = PlayerStatus.IDLE;
            this.f10425c.onGetCurrentSong(b2.f46388c);
            play();
        } catch (IOException | JSONException e2) {
            e2.printStackTrace();
            this.f10425c.onInvokeFailed();
        }
    }

    public final void b() {
        b bVar;
        if (this.f10427e) {
            AudioManager audioManager = this.f10426d;
            if (audioManager != null && (bVar = this.f10428f) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f10426d = null;
                this.f10428f = null;
            }
            this.f10427e = false;
            if (f10421h) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.l0.a.p.d.s
    public int getDuration() {
        return k().getDuration();
    }

    @Override // d.a.l0.a.p.d.s
    public boolean isPlaying() {
        return k().isPlaying();
    }

    public final MediaPlayer k() {
        if (this.f10423a == null) {
            this.f10423a = new MediaPlayer();
            c cVar = new c();
            this.f10423a.setOnPreparedListener(cVar);
            this.f10423a.setOnCompletionListener(cVar);
            this.f10423a.setOnErrorListener(cVar);
            this.f10423a.setOnBufferingUpdateListener(cVar);
            this.f10423a.setAudioStreamType(3);
            this.f10429g = new d();
        }
        return this.f10423a;
    }

    public final void l() {
        try {
            k().prepareAsync();
            this.f10424b = PlayerStatus.PREPARING;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            this.f10425c.onInvokeFailed();
            onRelease();
        }
    }

    public final void m() {
        if (this.f10427e) {
            return;
        }
        if (this.f10426d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.f10426d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f10428f == null) {
            this.f10428f = new b();
        }
        this.f10427e = this.f10426d.requestAudioFocus(this.f10428f, 3, 1) == 1;
        if (f10421h) {
            Log.d("AudioPlayerListener", "   requestAudioFocus");
        }
    }

    @Override // d.a.l0.a.p.d.s
    public void onRelease() {
        b();
        k().release();
        this.f10423a = null;
        this.f10424b = PlayerStatus.NONE;
        d dVar = this.f10429g;
        if (dVar != null) {
            dVar.removeMessages(0);
            this.f10429g = null;
        }
    }

    @Override // d.a.l0.a.p.d.s
    public void pause() {
        if (k().isPlaying()) {
            k().pause();
            this.f10425c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.f10429g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // d.a.l0.a.p.d.s
    public void play() {
        PlayerStatus playerStatus = this.f10424b;
        if (playerStatus == PlayerStatus.PREPARED) {
            m();
            k().start();
            this.f10425c.onStateChanged(BgMusicPlayState.PLAY);
            d dVar = this.f10429g;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
        } else if (playerStatus == PlayerStatus.IDLE) {
            l();
        }
    }

    @Override // d.a.l0.a.p.d.s
    public void seek(int i2) {
        k().seekTo(i2);
    }

    @Override // d.a.l0.a.p.d.s
    public void stop() {
        if (this.f10424b == PlayerStatus.PREPARED) {
            if (f10421h) {
                Log.d("AudioPlayerListener", "===stop");
            }
            k().stop();
            this.f10424b = PlayerStatus.IDLE;
            this.f10425c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.f10429g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
