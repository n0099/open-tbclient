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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes19.dex */
public class a {
    private b chZ;
    private InterfaceC0317a ciO;
    private SurfaceView ciX;
    private int ciY;
    private AudioManager mAudioManager;
    private Context mContext;
    private MediaPlayer mMediaPlayer = new MediaPlayer();
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.prologue.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0317a {
        void gY(int i);
    }

    public a(@NonNull Context context) {
        this.ciY = -1;
        this.mContext = context;
        this.ciY = 1;
        this.ciX = new SurfaceView(this.mContext);
        this.ciX.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.prologue.b.a.1
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

    public void a(InterfaceC0317a interfaceC0317a) {
        this.ciO = interfaceC0317a;
    }

    public void a(@NonNull b bVar) {
        this.chZ = bVar;
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.prologue.b.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                a.this.ciY = 3;
                a.this.chZ.onPrepared();
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.prologue.b.a.3
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                a.this.chZ.onSeekComplete();
            }
        });
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.prologue.b.a.4
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            @SuppressLint({"NewApi"})
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                try {
                    a.this.mMediaPlayer.setVideoScalingMode(2);
                    a.this.chZ.onVideoSizeChanged(i, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.prologue.b.a.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.abandonAudioFocus();
                a.this.ciY = 7;
                a.this.chZ.onCompletion();
            }
        });
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.prologue.b.a.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                a.this.chZ.onBufferingUpdate(i);
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.prologue.b.a.7
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return a.this.chZ.onError(i, i2);
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.prologue.b.a.8
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return a.this.chZ.U(i, i2);
            }
        });
    }

    public void C(@NonNull ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
        this.mViewGroup.addView(this.ciX, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(@NonNull c cVar) {
        a(cVar, false);
    }

    @SuppressLint({"NewApi"})
    public void a(@NonNull c cVar, @NonNull boolean z) {
        if (this.ciY != 1) {
            if (com.baidu.prologue.a.b.a.che.get().abT()) {
                throw new IllegalStateException();
            }
            return;
        }
        try {
            if (cVar.Lc == 1) {
                String str = "";
                if (z) {
                    str = h.t(cVar.mFile);
                }
                if (z && !str.equals(cVar.cjb)) {
                    boolean equals = str.equals("");
                    if (this.ciO != null) {
                        this.ciO.gY(equals ? 1 : 2);
                        return;
                    }
                    return;
                }
                this.mMediaPlayer.setDataSource(new FileInputStream(cVar.mFile).getFD(), 0L, cVar.mFile.length());
                this.mMediaPlayer.setVideoScalingMode(2);
            } else {
                this.mMediaPlayer.setDataSource(cVar.cja);
                this.mMediaPlayer.setVideoScalingMode(2);
            }
            this.ciY = 2;
        } catch (Exception e) {
            this.ciY = -1;
            if (this.ciO != null) {
                this.ciO.gY(3);
            }
            e.printStackTrace();
        }
    }

    public void prepareAsync() {
        if (this.ciY == 2 || this.ciY == 6) {
            this.mMediaPlayer.prepareAsync();
        } else if (com.baidu.prologue.a.b.a.che.get().abT()) {
            throw new IllegalStateException();
        }
    }

    public void start() {
        if (this.ciY == 5 || this.ciY == 4 || this.ciY == 3 || this.ciY == 7) {
            acU();
            this.mMediaPlayer.start();
            this.ciY = 4;
        } else if (com.baidu.prologue.a.b.a.che.get().abT()) {
            throw new IllegalStateException();
        }
    }

    public void pause() {
        if (this.ciY == 5 || this.ciY == 4) {
            this.mMediaPlayer.pause();
            this.ciY = 5;
        } else if (com.baidu.prologue.a.b.a.che.get().abT()) {
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

    public boolean acC() {
        return this.ciY == 5 || this.ciY == 4;
    }

    private boolean acU() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
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
