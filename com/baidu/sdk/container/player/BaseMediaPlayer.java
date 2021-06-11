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
    public MediaPlayer f10025e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f10026f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f10027g;

    /* renamed from: h  reason: collision with root package name */
    public e f10028h;

    /* renamed from: i  reason: collision with root package name */
    public State f10029i;
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
        State state = this.f10029i;
        if ((state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f10025e) != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int b() {
        MediaPlayer mediaPlayer;
        State state = this.f10029i;
        if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f10025e) != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public int c() {
        MediaPlayer mediaPlayer;
        if (this.f10029i == State.ERROR || (mediaPlayer = this.f10025e) == null) {
            return 0;
        }
        return mediaPlayer.getVideoHeight();
    }

    public int d() {
        MediaPlayer mediaPlayer;
        if (this.f10029i == State.ERROR || (mediaPlayer = this.f10025e) == null) {
            return 0;
        }
        return mediaPlayer.getVideoWidth();
    }

    public final void e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f10025e = mediaPlayer;
        this.f10029i = State.IDLE;
        mediaPlayer.setAudioStreamType(3);
        this.f10025e.setOnPreparedListener(this);
        this.f10025e.setOnCompletionListener(this);
        this.f10025e.setOnErrorListener(this);
        this.f10025e.setOnInfoListener(this);
        this.f10025e.setOnSeekCompleteListener(this);
    }

    public final void f(int i2) {
        e eVar = this.f10028h;
        if (eVar != null) {
            eVar.playStateChanged(i2);
        }
    }

    public void g() {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "pause=" + this.f10029i);
        if (this.f10025e != null) {
            State state = this.f10029i;
            if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                this.f10025e.pause();
                this.f10029i = State.PAUSED;
            }
        }
    }

    public final void h() {
        this.f10025e.prepareAsync();
        this.f10029i = State.PREPARING;
    }

    public void i() {
        MediaPlayer mediaPlayer = this.f10025e;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f10029i = State.END;
            this.f10025e.setOnSeekCompleteListener(null);
            this.f10025e.setOnInfoListener(null);
            this.f10025e.setOnErrorListener(null);
            this.f10025e.setOnPreparedListener(null);
            this.f10025e.setOnCompletionListener(null);
        }
    }

    public void j() {
        MediaPlayer mediaPlayer = this.f10025e;
        if (mediaPlayer != null) {
            this.f10029i = State.IDLE;
            mediaPlayer.reset();
        }
    }

    public void k(int i2) {
        State state = this.f10029i;
        if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
            b bVar = this.j;
            bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "seekto不合法，mCurState=" + this.f10029i);
            return;
        }
        MediaPlayer mediaPlayer = this.f10025e;
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
        this.f10027g = surfaceHolder;
        MediaPlayer mediaPlayer = this.f10025e;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
            this.f10025e.setScreenOnWhilePlaying(true);
        }
    }

    public void m(e eVar) {
        this.f10028h = eVar;
    }

    public void n(boolean z) {
        MediaPlayer mediaPlayer = this.f10025e;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    public void o(Surface surface) {
        this.f10026f = surface;
        MediaPlayer mediaPlayer = this.f10025e;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "onCompletion" + this.f10029i);
        this.f10029i = State.PLAYBACKCOMPLETED;
        f(256);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "onError" + this.f10029i);
        this.f10029i = State.ERROR;
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
        this.f10029i = State.PREPARED;
        f(258);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Log.e(com.baidu.mobads.container.widget.player.AdVideoView.TAG, "onSeekComplete");
        f(259);
    }

    public void p(String str) {
        MediaPlayer mediaPlayer = this.f10025e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(str);
                this.f10029i = State.INITIALIZED;
                h();
            } catch (Exception e2) {
                b bVar = this.j;
                bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "setVideoPath异常" + e2.getMessage());
            }
        }
    }

    public void q(float f2, float f3) {
        MediaPlayer mediaPlayer;
        if (this.f10029i == State.ERROR || (mediaPlayer = this.f10025e) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public void r(Context context, int i2) {
        if (this.f10025e == null || context == null || !f.a(context, "android.permission.WAKE_LOCK")) {
            return;
        }
        this.f10025e.setWakeMode(context.getApplicationContext(), i2);
    }

    public void s() {
        b bVar = this.j;
        bVar.j(com.baidu.mobads.container.widget.player.BaseMediaPlayer.TAG, "start=" + this.f10029i);
        if (this.f10025e != null) {
            State state = this.f10029i;
            if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f10025e.start();
                this.f10029i = State.STARTED;
            }
        }
    }

    public void t() {
        if (this.f10025e != null) {
            State state = this.f10029i;
            if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f10025e.stop();
                this.f10029i = State.STOPPED;
            }
        }
    }
}
