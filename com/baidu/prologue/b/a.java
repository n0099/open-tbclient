package com.baidu.prologue.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.baidu.prologue.a.c.h;
import java.io.FileInputStream;
/* loaded from: classes9.dex */
public class a {
    private InterfaceC0278a bLR;
    private b bLd;
    private SurfaceView bMa;
    private int bMb;
    private AudioManager mAudioManager;
    private Context mContext;
    private MediaPlayer mMediaPlayer = new MediaPlayer();
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.prologue.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0278a {
        void ga(int i);
    }

    public a(@NonNull Context context) {
        this.bMb = -1;
        this.mContext = context;
        this.bMb = 1;
        this.bMa = new SurfaceView(this.mContext);
        this.bMa.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.prologue.b.a.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (a.this.mMediaPlayer != null) {
                    a.this.mMediaPlayer.setDisplay(surfaceHolder);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
    }

    public void a(InterfaceC0278a interfaceC0278a) {
        this.bLR = interfaceC0278a;
    }

    public void a(@NonNull b bVar) {
        this.bLd = bVar;
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.prologue.b.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                a.this.bMb = 3;
                a.this.bLd.onPrepared();
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.prologue.b.a.3
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                a.this.bLd.onSeekComplete();
            }
        });
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.prologue.b.a.4
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            @SuppressLint({"NewApi"})
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                try {
                    a.this.mMediaPlayer.setVideoScalingMode(2);
                    a.this.bLd.onVideoSizeChanged(i, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.prologue.b.a.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.abandonAudioFocus();
                a.this.bMb = 7;
                a.this.bLd.onCompletion();
            }
        });
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.prologue.b.a.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                a.this.bLd.onBufferingUpdate(i);
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.prologue.b.a.7
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return a.this.bLd.onError(i, i2);
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.prologue.b.a.8
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return a.this.bLd.T(i, i2);
            }
        });
    }

    public void u(@NonNull ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
        this.mViewGroup.addView(this.bMa, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(@NonNull c cVar) {
        a(cVar, false);
    }

    @SuppressLint({"NewApi"})
    public void a(@NonNull c cVar, @NonNull boolean z) {
        if (this.bMb != 1) {
            if (com.baidu.prologue.a.b.a.bKi.get().UU()) {
                throw new IllegalStateException();
            }
            return;
        }
        try {
            if (cVar.KE == 1) {
                String str = "";
                if (z) {
                    str = h.p(cVar.mFile);
                }
                if (z && !str.equals(cVar.bMe)) {
                    boolean equals = str.equals("");
                    if (this.bLR != null) {
                        this.bLR.ga(equals ? 1 : 2);
                        return;
                    }
                    return;
                }
                this.mMediaPlayer.setDataSource(new FileInputStream(cVar.mFile).getFD(), 0L, cVar.mFile.length());
                this.mMediaPlayer.setVideoScalingMode(2);
            } else {
                this.mMediaPlayer.setDataSource(cVar.bMd);
                this.mMediaPlayer.setVideoScalingMode(2);
            }
            this.bMb = 2;
        } catch (Exception e) {
            this.bMb = -1;
            if (this.bLR != null) {
                this.bLR.ga(3);
            }
            e.printStackTrace();
        }
    }

    public void prepareAsync() {
        if (this.bMb == 2 || this.bMb == 6) {
            this.mMediaPlayer.prepareAsync();
        } else if (com.baidu.prologue.a.b.a.bKi.get().UU()) {
            throw new IllegalStateException();
        }
    }

    public void start() {
        if (this.bMb == 5 || this.bMb == 4 || this.bMb == 3 || this.bMb == 7) {
            VW();
            this.mMediaPlayer.start();
            this.bMb = 4;
        } else if (com.baidu.prologue.a.b.a.bKi.get().UU()) {
            throw new IllegalStateException();
        }
    }

    public void pause() {
        if (this.bMb == 5 || this.bMb == 4) {
            this.mMediaPlayer.pause();
            this.bMb = 5;
        } else if (com.baidu.prologue.a.b.a.bKi.get().UU()) {
            throw new IllegalStateException();
        }
    }

    public void setMute(boolean z) {
        if (z) {
            this.mMediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            this.mMediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    public void release() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public boolean VD() {
        return this.bMb == 5 || this.bMb == 4;
    }

    private boolean VW() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (this.mAudioManager == null) {
                return false;
            }
        }
        return this.mAudioManager.requestAudioFocus(null, 3, 2) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null) {
            this.mAudioManager.abandonAudioFocus(null);
            this.mAudioManager = null;
        }
    }
}
