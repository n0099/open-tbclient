package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.videoplayer.a;
import com.baidu.swan.videoplayer.c;
import com.baidu.swan.videoplayer.widget.MediaController;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes9.dex */
public class SwanVideoView extends FrameLayout {
    private int bMb;
    private boolean cCl;
    private int dKX;
    private boolean dKY;
    private MediaController dKZ;
    private int dLa;
    private int dLb;
    private boolean dLc;
    private boolean dLd;
    private RelativeLayout dLe;
    private ProgressBar dLf;
    private TextView dLg;
    private a dLh;
    private FrameLayout dLi;
    private com.baidu.swan.videoplayer.a.a dLj;
    MediaPlayer.OnPreparedListener dLk;
    private MediaPlayer.OnCompletionListener dLl;
    private MediaPlayer.OnVideoSizeChangedListener dLm;
    private MediaPlayer.OnErrorListener dLn;
    private MediaPlayer.OnBufferingUpdateListener dLo;
    private MediaPlayer.OnSeekCompleteListener dLp;
    a.InterfaceC0526a dLq;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.dKZ != null) {
            this.dKZ.hq(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.bMb = 0;
        this.dLb = -1;
        this.dLd = true;
        this.dKX = 0;
        this.dLk = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dLh != null) {
                    SwanVideoView.this.dLh.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dKY) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dLl = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dKY = false;
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onEnd();
                }
            }
        };
        this.dLm = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dLh != null) {
                        SwanVideoView.this.dLh.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dLj != null) {
                        SwanVideoView.this.dLj.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dLn = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dKY = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onError(i, i2, null);
                }
                return SwanVideoView.this.dLj != null;
            }
        };
        this.dLo = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dLa = i;
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dKZ != null) {
                    SwanVideoView.this.dKZ.mu((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dLp = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onSeekEnd();
                }
            }
        };
        this.dLq = new a.InterfaceC0526a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aWJ() == SwanVideoView.this.dLh && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar) {
            }
        };
        dK(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMb = 0;
        this.dLb = -1;
        this.dLd = true;
        this.dKX = 0;
        this.dLk = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dLh != null) {
                    SwanVideoView.this.dLh.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dKY) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dLl = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dKY = false;
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onEnd();
                }
            }
        };
        this.dLm = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dLh != null) {
                        SwanVideoView.this.dLh.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dLj != null) {
                        SwanVideoView.this.dLj.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dLn = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dKY = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onError(i, i2, null);
                }
                return SwanVideoView.this.dLj != null;
            }
        };
        this.dLo = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dLa = i;
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dKZ != null) {
                    SwanVideoView.this.dKZ.mu((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dLp = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onSeekEnd();
                }
            }
        };
        this.dLq = new a.InterfaceC0526a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aWJ() == SwanVideoView.this.dLh && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar) {
            }
        };
        dK(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMb = 0;
        this.dLb = -1;
        this.dLd = true;
        this.dKX = 0;
        this.dLk = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dLh != null) {
                    SwanVideoView.this.dLh.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dKY) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dLl = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dKY = false;
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onEnd();
                }
            }
        };
        this.dLm = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dLh != null) {
                        SwanVideoView.this.dLh.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dLj != null) {
                        SwanVideoView.this.dLj.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dLn = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dKY = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onError(i2, i22, null);
                }
                return SwanVideoView.this.dLj != null;
            }
        };
        this.dLo = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.dLa = i2;
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.dKZ != null) {
                    SwanVideoView.this.dKZ.mu((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.dLp = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLj != null) {
                    SwanVideoView.this.dLj.onSeekEnd();
                }
            }
        };
        this.dLq = new a.InterfaceC0526a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aWJ() == SwanVideoView.this.dLh && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar) {
            }
        };
        dK(context);
    }

    private void dK(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dLi = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dLi.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dLi, layoutParams);
        this.dKZ = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dKZ.setVisibility(8);
        addView(this.dKZ, layoutParams2);
        this.dKZ.i(this);
        aWO();
        aWN();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            aWM();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aWM() {
        if (this.dLd) {
            if (this.dKZ.getVisibility() != 0) {
                this.dKZ.aXu();
            } else {
                this.dKZ.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void aWN() {
        this.dLe = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dLe.setVisibility(8);
        addView(this.dLe, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dLf = new ProgressBar(getContext());
        this.dLf.setId(16908308);
        this.dLf.setMax(100);
        this.dLf.setProgress(10);
        this.dLf.setSecondaryProgress(100);
        this.dLe.addView(this.dLf, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dLg = new TextView(getContext());
        this.dLg.setTextColor(-1);
        this.dLg.setText(c.d.laoding);
        this.dLg.setGravity(1);
        this.dLe.addView(this.dLg, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.dLj = aVar;
        if (this.dKZ != null) {
            this.dKZ.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.bMb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.bMb != i) {
            this.bMb = i;
            if (this.dKZ != null) {
                this.dKZ.aXr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dLe.setVisibility(0);
        } else {
            this.dLe.setVisibility(8);
        }
    }

    private void aWO() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dLh != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.dLh.getView();
            this.dLh.b(this.dLq);
            this.dLh.release();
            this.dLh = null;
            this.dLi.removeView(view);
        }
        if (aVar != null) {
            this.dLh = aVar;
            aVar.setAspectRatio(this.dKX);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.dLh.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dLi.addView(view2);
            this.dLh.a(this.dLq);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        if (this.mUri != null) {
            if (this.mMediaPlayer != null) {
                try {
                    this.mMediaPlayer.setDataSource(this.mAppContext, this.mUri, this.mHeaders);
                    this.mMediaPlayer.prepareAsync();
                    setCacheViewVisibility(true);
                    setCurrentState(1);
                } catch (IOException e) {
                    setCurrentState(-1);
                    this.dKY = false;
                    this.dLn.onError(this.mMediaPlayer, 1, 0);
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
            aWR();
            this.dKY = false;
        }
    }

    public void aWP() {
        try {
            this.mMediaPlayer = aWQ();
            this.mMediaPlayer.setOnPreparedListener(this.dLk);
            this.mMediaPlayer.setOnCompletionListener(this.dLl);
            this.mMediaPlayer.setOnErrorListener(this.dLn);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.dLo);
            this.mMediaPlayer.setOnSeekCompleteListener(this.dLp);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.dLm);
            this.dLa = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.dKY = false;
            this.dLn.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer aWQ() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.dLc);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.dLc = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.dLc);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cCl = z;
            if (this.dKZ != null && this.dLd) {
                this.dKZ.setMute(this.cCl);
            }
        }
    }

    public boolean isMute() {
        return this.cCl;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dLd = z;
    }

    public void setInitPlayPosition(int i) {
        this.dLb = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.dLb);
            this.dLb = -1;
        }
    }

    public void release() {
        aWR();
        this.dKY = false;
        if (this.dLh != null) {
            this.dLh.release();
        }
        if (this.dKZ != null) {
            this.dKZ.setToggleScreenListener(null);
            this.dKZ.i(null);
            this.dKZ = null;
        }
        if (this.dLj != null) {
            this.dLj = null;
        }
    }

    private void aWR() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.dLj != null) {
            this.dLj = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.bMb == -1 || this.bMb == 5) {
                if (this.bMb == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.dLj != null) {
                    if (this.bMb == 4) {
                        this.dLj.onResume();
                    } else {
                        this.dLj.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.dKY = true;
        }
    }

    private void restart() {
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDataSource(this.mAppContext, this.mUri, this.mHeaders);
            this.mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            setCurrentState(4);
        }
        this.dKY = false;
        if (this.dLj != null) {
            this.dLj.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.dLa;
        }
        return 0;
    }

    public String getCurrentPlayingUrl() {
        if (this.mUri != null) {
            return this.mUri.toString();
        }
        return null;
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.mMediaPlayer.getDuration()) {
                i = this.mMediaPlayer.getDuration() - 1000;
            }
            this.mMediaPlayer.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.bMb == -1 || this.bMb == 0 || this.bMb == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.mMediaPlayer.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.mMediaPlayer.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.dKX = 0;
            } else if (i == 2) {
                this.dKX = 1;
            } else {
                this.dKX = 3;
            }
            if (this.dLh != null) {
                this.dLh.setAspectRatio(this.dKX);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.dLh != null) {
            return this.dLh.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaPlayer mediaPlayer, a.b bVar) {
        if (mediaPlayer != null) {
            if (bVar == null) {
                mediaPlayer.setDisplay(null);
            } else {
                bVar.b(mediaPlayer);
            }
        }
    }

    public com.baidu.swan.videoplayer.a.a getVideoPlayerCallback() {
        return this.dLj;
    }
}
