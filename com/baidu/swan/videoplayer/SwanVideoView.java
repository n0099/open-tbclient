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
/* loaded from: classes11.dex */
public class SwanVideoView extends FrameLayout {
    private boolean cnK;
    private MediaPlayer.OnBufferingUpdateListener drA;
    private MediaPlayer.OnSeekCompleteListener drB;
    a.InterfaceC0462a drC;
    private int dri;
    private boolean drj;
    private MediaController drk;
    private int drl;
    private int drm;
    private boolean drn;
    private boolean dro;
    private RelativeLayout drp;
    private ProgressBar drq;
    private TextView drr;
    private a drt;
    private FrameLayout dru;
    private com.baidu.swan.videoplayer.a.a drv;
    MediaPlayer.OnPreparedListener drw;
    private MediaPlayer.OnCompletionListener drx;
    private MediaPlayer.OnVideoSizeChangedListener dry;
    private MediaPlayer.OnErrorListener drz;
    private Context mAppContext;
    private int mCurrentState;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.drk != null) {
            this.drk.gw(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.drm = -1;
        this.dro = true;
        this.dri = 0;
        this.drw = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.drt != null) {
                    SwanVideoView.this.drt.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.drj) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.drx = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.drj = false;
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onEnd();
                }
            }
        };
        this.dry = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.drt != null) {
                        SwanVideoView.this.drt.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.drv != null) {
                        SwanVideoView.this.drv.N(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.drz = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.drj = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.f(i, i2, null);
                }
                return SwanVideoView.this.drv != null;
            }
        };
        this.drA = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.drl = i;
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.jI((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.drB = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onSeekEnd();
                }
            }
        };
        this.drC = new a.InterfaceC0462a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aJr() == SwanVideoView.this.drt && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar) {
            }
        };
        dz(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.drm = -1;
        this.dro = true;
        this.dri = 0;
        this.drw = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.drt != null) {
                    SwanVideoView.this.drt.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.drj) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.drx = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.drj = false;
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onEnd();
                }
            }
        };
        this.dry = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.drt != null) {
                        SwanVideoView.this.drt.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.drv != null) {
                        SwanVideoView.this.drv.N(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.drz = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.drj = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.f(i, i2, null);
                }
                return SwanVideoView.this.drv != null;
            }
        };
        this.drA = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.drl = i;
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.jI((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.drB = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onSeekEnd();
                }
            }
        };
        this.drC = new a.InterfaceC0462a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aJr() == SwanVideoView.this.drt && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar) {
            }
        };
        dz(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.drm = -1;
        this.dro = true;
        this.dri = 0;
        this.drw = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.drt != null) {
                    SwanVideoView.this.drt.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.drj) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.drx = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.drj = false;
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onEnd();
                }
            }
        };
        this.dry = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.drt != null) {
                        SwanVideoView.this.drt.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.drv != null) {
                        SwanVideoView.this.drv.N(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.drz = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.drj = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.f(i2, i22, null);
                }
                return SwanVideoView.this.drv != null;
            }
        };
        this.drA = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.drl = i2;
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.jI((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.drB = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drv != null) {
                    SwanVideoView.this.drv.onSeekEnd();
                }
            }
        };
        this.drC = new a.InterfaceC0462a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aJr() == SwanVideoView.this.drt && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0462a
            public void a(a.b bVar) {
            }
        };
        dz(context);
    }

    private void dz(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dru = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dru.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dru, layoutParams);
        this.drk = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.drk.setVisibility(8);
        addView(this.drk, layoutParams2);
        this.drk.i(this);
        aJw();
        aJv();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            aJu();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aJu() {
        if (this.dro) {
            if (this.drk.getVisibility() != 0) {
                this.drk.aKc();
            } else {
                this.drk.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void aJv() {
        this.drp = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.drp.setVisibility(8);
        addView(this.drp, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.drq = new ProgressBar(getContext());
        this.drq.setId(16908308);
        this.drq.setMax(100);
        this.drq.setProgress(10);
        this.drq.setSecondaryProgress(100);
        this.drp.addView(this.drq, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.drr = new TextView(getContext());
        this.drr.setTextColor(-1);
        this.drr.setText(c.d.laoding);
        this.drr.setGravity(1);
        this.drp.addView(this.drr, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.drv = aVar;
        if (this.drk != null) {
            this.drk.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.drk != null) {
                this.drk.aJZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.drp.setVisibility(0);
        } else {
            this.drp.setVisibility(8);
        }
    }

    private void aJw() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.drt != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.drt.getView();
            this.drt.b(this.drC);
            this.drt.release();
            this.drt = null;
            this.dru.removeView(view);
        }
        if (aVar != null) {
            this.drt = aVar;
            aVar.setAspectRatio(this.dri);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.drt.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dru.addView(view2);
            this.drt.a(this.drC);
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
                    this.drj = false;
                    this.drz.onError(this.mMediaPlayer, 1, 0);
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
            aJz();
            this.drj = false;
        }
    }

    public void aJx() {
        try {
            this.mMediaPlayer = aJy();
            this.mMediaPlayer.setOnPreparedListener(this.drw);
            this.mMediaPlayer.setOnCompletionListener(this.drx);
            this.mMediaPlayer.setOnErrorListener(this.drz);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.drA);
            this.mMediaPlayer.setOnSeekCompleteListener(this.drB);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.dry);
            this.drl = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.drj = false;
            this.drz.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer aJy() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.drn);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.drn = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.drn);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cnK = z;
            if (this.drk != null && this.dro) {
                this.drk.setMute(this.cnK);
            }
        }
    }

    public boolean isMute() {
        return this.cnK;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dro = z;
    }

    public void setInitPlayPosition(int i) {
        this.drm = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.drm);
            this.drm = -1;
        }
    }

    public void release() {
        aJz();
        this.drj = false;
        if (this.drt != null) {
            this.drt.release();
        }
        if (this.drk != null) {
            this.drk.setToggleScreenListener(null);
            this.drk.i(null);
            this.drk = null;
        }
        if (this.drv != null) {
            this.drv = null;
        }
    }

    private void aJz() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.drv != null) {
            this.drv = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.drv != null) {
                    if (this.mCurrentState == 4) {
                        this.drv.onResume();
                    } else {
                        this.drv.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.drj = true;
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
        this.drj = false;
        if (this.drv != null) {
            this.drv.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.drl;
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
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
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
                this.dri = 0;
            } else if (i == 2) {
                this.dri = 1;
            } else {
                this.dri = 3;
            }
            if (this.drt != null) {
                this.drt.setAspectRatio(this.dri);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.drt != null) {
            return this.drt.getBitmap();
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
        return this.drv;
    }
}
