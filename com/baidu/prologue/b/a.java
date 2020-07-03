package com.baidu.prologue.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.baidu.prologue.a.c.g;
import java.io.FileInputStream;
/* loaded from: classes6.dex */
public class a {
    private InterfaceC0254a bFT;
    private b bFg;
    private SurfaceView bGc;
    private AudioManager mAudioManager;
    private Context mContext;
    private int mCurrentState;
    private MediaPlayer mMediaPlayer = new MediaPlayer();
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.prologue.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0254a {
        void ee(int i);
    }

    public a(@NonNull Context context) {
        this.mCurrentState = -1;
        this.mContext = context;
        this.mCurrentState = 1;
        this.bGc = new SurfaceView(this.mContext);
        this.bGc.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.prologue.b.a.1
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

    public void a(InterfaceC0254a interfaceC0254a) {
        this.bFT = interfaceC0254a;
    }

    public void a(@NonNull b bVar) {
        this.bFg = bVar;
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.prologue.b.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                a.this.mCurrentState = 3;
                a.this.bFg.onPrepared();
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.prologue.b.a.3
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                a.this.bFg.onSeekComplete();
            }
        });
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.prologue.b.a.4
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            @SuppressLint({"NewApi"})
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                try {
                    a.this.mMediaPlayer.setVideoScalingMode(2);
                    a.this.bFg.P(i, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.prologue.b.a.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.GA();
                a.this.mCurrentState = 7;
                a.this.bFg.onCompletion();
            }
        });
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.prologue.b.a.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                a.this.bFg.onBufferingUpdate(i);
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.prologue.b.a.7
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return a.this.bFg.onError(i, i2);
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.prologue.b.a.8
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return a.this.bFg.Q(i, i2);
            }
        });
    }

    public void s(@NonNull ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
        this.mViewGroup.addView(this.bGc, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(@NonNull c cVar) {
        a(cVar, false);
    }

    @SuppressLint({"NewApi"})
    public void a(@NonNull c cVar, @NonNull boolean z) {
        if (this.mCurrentState != 1) {
            if (com.baidu.prologue.a.b.a.bEl.get().OJ()) {
                throw new IllegalStateException();
            }
            return;
        }
        try {
            if (cVar.Ka == 1) {
                String str = "";
                if (z) {
                    str = g.o(cVar.mFile);
                }
                if (z && !str.equals(cVar.bGf)) {
                    boolean equals = str.equals("");
                    if (this.bFT != null) {
                        this.bFT.ee(equals ? 1 : 2);
                        return;
                    }
                    return;
                }
                this.mMediaPlayer.setDataSource(new FileInputStream(cVar.mFile).getFD(), 0L, cVar.mFile.length());
                this.mMediaPlayer.setVideoScalingMode(2);
            } else {
                this.mMediaPlayer.setDataSource(cVar.bGe);
                this.mMediaPlayer.setVideoScalingMode(2);
            }
            this.mCurrentState = 2;
        } catch (Exception e) {
            this.mCurrentState = -1;
            if (this.bFT != null) {
                this.bFT.ee(3);
            }
            e.printStackTrace();
        }
    }

    public void prepareAsync() {
        if (this.mCurrentState == 2 || this.mCurrentState == 6) {
            this.mMediaPlayer.prepareAsync();
        } else if (com.baidu.prologue.a.b.a.bEl.get().OJ()) {
            throw new IllegalStateException();
        }
    }

    public void start() {
        if (this.mCurrentState == 5 || this.mCurrentState == 4 || this.mCurrentState == 3 || this.mCurrentState == 7) {
            PM();
            this.mMediaPlayer.start();
            this.mCurrentState = 4;
        } else if (com.baidu.prologue.a.b.a.bEl.get().OJ()) {
            throw new IllegalStateException();
        }
    }

    public void pause() {
        if (this.mCurrentState == 5 || this.mCurrentState == 4) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 5;
        } else if (com.baidu.prologue.a.b.a.bEl.get().OJ()) {
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

    public boolean Ps() {
        return this.mCurrentState == 5 || this.mCurrentState == 4;
    }

    private boolean PM() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (this.mAudioManager == null) {
                return false;
            }
        }
        return this.mAudioManager.requestAudioFocus(null, 3, 2) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GA() {
        if (this.mAudioManager != null) {
            this.mAudioManager.abandonAudioFocus(null);
            this.mAudioManager = null;
        }
    }
}
