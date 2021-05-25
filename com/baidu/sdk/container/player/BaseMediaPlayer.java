package com.baidu.sdk.container.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import d.a.f0.a.i.e;
import d.a.f0.a.k.b;
import d.a.f0.a.k.f;
/* loaded from: classes2.dex */
public class BaseMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f9963e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f9964f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f9965g;

    /* renamed from: h  reason: collision with root package name */
    public e f9966h;

    /* renamed from: i  reason: collision with root package name */
    public State f9967i;
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
        State state = this.f9967i;
        if ((state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f9963e) != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int b() {
        MediaPlayer mediaPlayer;
        State state = this.f9967i;
        if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f9963e) != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public int c() {
        MediaPlayer mediaPlayer;
        if (this.f9967i == State.ERROR || (mediaPlayer = this.f9963e) == null) {
            return 0;
        }
        return mediaPlayer.getVideoHeight();
    }

    public int d() {
        MediaPlayer mediaPlayer;
        if (this.f9967i == State.ERROR || (mediaPlayer = this.f9963e) == null) {
            return 0;
        }
        return mediaPlayer.getVideoWidth();
    }

    public final void e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f9963e = mediaPlayer;
        this.f9967i = State.IDLE;
        mediaPlayer.setAudioStreamType(3);
        this.f9963e.setOnPreparedListener(this);
        this.f9963e.setOnCompletionListener(this);
        this.f9963e.setOnErrorListener(this);
        this.f9963e.setOnInfoListener(this);
        this.f9963e.setOnSeekCompleteListener(this);
    }

    public final void f(int i2) {
        e eVar = this.f9966h;
        if (eVar != null) {
            eVar.playStateChanged(i2);
        }
    }

    public void g() {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "pause=" + this.f9967i);
        if (this.f9963e != null) {
            State state = this.f9967i;
            if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                this.f9963e.pause();
                this.f9967i = State.PAUSED;
            }
        }
    }

    public final void h() {
        this.f9963e.prepareAsync();
        this.f9967i = State.PREPARING;
    }

    public void i() {
        MediaPlayer mediaPlayer = this.f9963e;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f9967i = State.END;
            this.f9963e.setOnSeekCompleteListener(null);
            this.f9963e.setOnInfoListener(null);
            this.f9963e.setOnErrorListener(null);
            this.f9963e.setOnPreparedListener(null);
            this.f9963e.setOnCompletionListener(null);
        }
    }

    public void j() {
        MediaPlayer mediaPlayer = this.f9963e;
        if (mediaPlayer != null) {
            this.f9967i = State.IDLE;
            mediaPlayer.reset();
        }
    }

    public void k(int i2) {
        State state = this.f9967i;
        if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
            b bVar = this.j;
            bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "seekto不合法，mCurState=" + this.f9967i);
            return;
        }
        MediaPlayer mediaPlayer = this.f9963e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(i2);
            } catch (Exception e2) {
                b bVar2 = this.j;
                bVar2.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "seekTo异常" + e2.getMessage());
            }
        }
    }

    public void l(SurfaceHolder surfaceHolder) {
        this.f9965g = surfaceHolder;
        MediaPlayer mediaPlayer = this.f9963e;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
            this.f9963e.setScreenOnWhilePlaying(true);
        }
    }

    public void m(e eVar) {
        this.f9966h = eVar;
    }

    public void n(boolean z) {
        MediaPlayer mediaPlayer = this.f9963e;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    public void o(Surface surface) {
        this.f9964f = surface;
        MediaPlayer mediaPlayer = this.f9963e;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "onCompletion" + this.f9967i);
        this.f9967i = State.PLAYBACKCOMPLETED;
        f(256);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "onError" + this.f9967i);
        this.f9967i = State.ERROR;
        f(257);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 == 3) {
            f(260);
            return false;
        } else if (i2 == 701) {
            f(PlayerEvent.PLAY_LOADING_START);
            return false;
        } else if (i2 != 702) {
            return false;
        } else {
            f(PlayerEvent.PLAY_LOADING_END);
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f9967i = State.PREPARED;
        f(258);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Log.e(com.baidu.mobads.container.widget.player.AdVideoView.TAG, "onSeekComplete");
        f(259);
    }

    public void p(String str) {
        MediaPlayer mediaPlayer = this.f9963e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(str);
                this.f9967i = State.INITIALIZED;
                h();
            } catch (Exception e2) {
                b bVar = this.j;
                bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "setVideoPath异常" + e2.getMessage());
            }
        }
    }

    public void q(float f2, float f3) {
        MediaPlayer mediaPlayer;
        if (this.f9967i == State.ERROR || (mediaPlayer = this.f9963e) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public void r(Context context, int i2) {
        if (this.f9963e == null || context == null || !f.a(context, "android.permission.WAKE_LOCK")) {
            return;
        }
        this.f9963e.setWakeMode(context.getApplicationContext(), i2);
    }

    public void s() {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "start=" + this.f9967i);
        if (this.f9963e != null) {
            State state = this.f9967i;
            if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f9963e.start();
                this.f9967i = State.STARTED;
            }
        }
    }

    public void t() {
        if (this.f9963e != null) {
            State state = this.f9967i;
            if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f9963e.stop();
                this.f9967i = State.STOPPED;
            }
        }
    }
}
