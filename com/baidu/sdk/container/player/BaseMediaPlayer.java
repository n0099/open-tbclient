package com.baidu.sdk.container.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import d.b.c0.a.i.e;
import d.b.c0.a.k.b;
import d.b.c0.a.k.f;
/* loaded from: classes2.dex */
public class BaseMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f11215e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f11216f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f11217g;

    /* renamed from: h  reason: collision with root package name */
    public e f11218h;
    public State i;
    public b j = b.i();

    /* loaded from: classes2.dex */
    public enum State {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        PLAYBACKCOMPLETED,
        END,
        ERROR
    }

    public BaseMediaPlayer(Context context) {
        e();
    }

    public int a() {
        MediaPlayer mediaPlayer;
        State state = this.i;
        if ((state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f11215e) != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int b() {
        MediaPlayer mediaPlayer;
        State state = this.i;
        if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f11215e) != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public int c() {
        MediaPlayer mediaPlayer;
        if (this.i == State.ERROR || (mediaPlayer = this.f11215e) == null) {
            return 0;
        }
        return mediaPlayer.getVideoHeight();
    }

    public int d() {
        MediaPlayer mediaPlayer;
        if (this.i == State.ERROR || (mediaPlayer = this.f11215e) == null) {
            return 0;
        }
        return mediaPlayer.getVideoWidth();
    }

    public final void e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f11215e = mediaPlayer;
        this.i = State.IDLE;
        mediaPlayer.setAudioStreamType(3);
        this.f11215e.setOnPreparedListener(this);
        this.f11215e.setOnCompletionListener(this);
        this.f11215e.setOnErrorListener(this);
        this.f11215e.setOnInfoListener(this);
        this.f11215e.setOnSeekCompleteListener(this);
    }

    public final void f(int i) {
        e eVar = this.f11218h;
        if (eVar != null) {
            eVar.playStateChanged(i);
        }
    }

    public void g() {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "pause=" + this.i);
        if (this.f11215e != null) {
            State state = this.i;
            if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                this.f11215e.pause();
                this.i = State.PAUSED;
            }
        }
    }

    public final void h() {
        this.f11215e.prepareAsync();
        this.i = State.PREPARING;
    }

    public void i() {
        MediaPlayer mediaPlayer = this.f11215e;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.i = State.END;
            this.f11215e.setOnSeekCompleteListener(null);
            this.f11215e.setOnInfoListener(null);
            this.f11215e.setOnErrorListener(null);
            this.f11215e.setOnPreparedListener(null);
            this.f11215e.setOnCompletionListener(null);
        }
    }

    public void j() {
        MediaPlayer mediaPlayer = this.f11215e;
        if (mediaPlayer != null) {
            this.i = State.IDLE;
            mediaPlayer.reset();
        }
    }

    public void k(int i) {
        State state = this.i;
        if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
            b bVar = this.j;
            bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "seekto不合法，mCurState=" + this.i);
            return;
        }
        MediaPlayer mediaPlayer = this.f11215e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(i);
            } catch (Exception e2) {
                b bVar2 = this.j;
                bVar2.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "seekTo异常" + e2.getMessage());
            }
        }
    }

    public void l(SurfaceHolder surfaceHolder) {
        this.f11217g = surfaceHolder;
        MediaPlayer mediaPlayer = this.f11215e;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
            this.f11215e.setScreenOnWhilePlaying(true);
        }
    }

    public void m(e eVar) {
        this.f11218h = eVar;
    }

    public void n(boolean z) {
        MediaPlayer mediaPlayer = this.f11215e;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    public void o(Surface surface) {
        this.f11216f = surface;
        MediaPlayer mediaPlayer = this.f11215e;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "onCompletion" + this.i);
        this.i = State.PLAYBACKCOMPLETED;
        f(256);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "onError" + this.i);
        this.i = State.ERROR;
        f(257);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            f(260);
            return false;
        } else if (i == 701) {
            f(PlayerEvent.PLAY_LOADING_START);
            return false;
        } else if (i != 702) {
            return false;
        } else {
            f(PlayerEvent.PLAY_LOADING_END);
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.i = State.PREPARED;
        f(258);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Log.e(com.baidu.mobads.container.widget.player.AdVideoView.TAG, "onSeekComplete");
        f(259);
    }

    public void p(String str) {
        MediaPlayer mediaPlayer = this.f11215e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(str);
                this.i = State.INITIALIZED;
                h();
            } catch (Exception e2) {
                b bVar = this.j;
                bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "setVideoPath异常" + e2.getMessage());
            }
        }
    }

    public void q(float f2, float f3) {
        MediaPlayer mediaPlayer;
        if (this.i == State.ERROR || (mediaPlayer = this.f11215e) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public void r(Context context, int i) {
        if (this.f11215e == null || context == null || !f.a(context, "android.permission.WAKE_LOCK")) {
            return;
        }
        this.f11215e.setWakeMode(context.getApplicationContext(), i);
    }

    public void s() {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "start=" + this.i);
        if (this.f11215e != null) {
            State state = this.i;
            if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f11215e.start();
                this.i = State.STARTED;
            }
        }
    }

    public void t() {
        if (this.f11215e != null) {
            State state = this.i;
            if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f11215e.stop();
                this.i = State.STOPPED;
            }
        }
    }
}
