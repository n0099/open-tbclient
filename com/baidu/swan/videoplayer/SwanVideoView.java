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
/* loaded from: classes12.dex */
public class SwanVideoView extends FrameLayout {
    private int bUO;
    private boolean cQt;
    private int dZf;
    private boolean dZg;
    private MediaController dZh;
    private int dZi;
    private int dZj;
    private boolean dZk;
    private boolean dZl;
    private RelativeLayout dZm;
    private ProgressBar dZn;
    private TextView dZo;
    private a dZp;
    private FrameLayout dZq;
    private com.baidu.swan.videoplayer.a.a dZr;
    MediaPlayer.OnPreparedListener dZs;
    private MediaPlayer.OnCompletionListener dZt;
    private MediaPlayer.OnVideoSizeChangedListener dZu;
    private MediaPlayer.OnErrorListener dZv;
    private MediaPlayer.OnBufferingUpdateListener dZw;
    private MediaPlayer.OnSeekCompleteListener dZx;
    a.InterfaceC0538a dZy;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.dZh != null) {
            this.dZh.hK(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.bUO = 0;
        this.dZj = -1;
        this.dZl = true;
        this.dZf = 0;
        this.dZs = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dZp != null) {
                    SwanVideoView.this.dZp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dZg) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dZt = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dZg = false;
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onEnd();
                }
            }
        };
        this.dZu = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dZp != null) {
                        SwanVideoView.this.dZp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dZr != null) {
                        SwanVideoView.this.dZr.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dZv = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dZg = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onError(i, i2, null);
                }
                return SwanVideoView.this.dZr != null;
            }
        };
        this.dZw = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dZi = i;
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dZh != null) {
                    SwanVideoView.this.dZh.nc((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dZx = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onSeekEnd();
                }
            }
        };
        this.dZy = new a.InterfaceC0538a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bad() == SwanVideoView.this.dZp && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUO = 0;
        this.dZj = -1;
        this.dZl = true;
        this.dZf = 0;
        this.dZs = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dZp != null) {
                    SwanVideoView.this.dZp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dZg) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dZt = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dZg = false;
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onEnd();
                }
            }
        };
        this.dZu = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dZp != null) {
                        SwanVideoView.this.dZp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dZr != null) {
                        SwanVideoView.this.dZr.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dZv = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dZg = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onError(i, i2, null);
                }
                return SwanVideoView.this.dZr != null;
            }
        };
        this.dZw = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dZi = i;
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dZh != null) {
                    SwanVideoView.this.dZh.nc((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dZx = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onSeekEnd();
                }
            }
        };
        this.dZy = new a.InterfaceC0538a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bad() == SwanVideoView.this.dZp && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUO = 0;
        this.dZj = -1;
        this.dZl = true;
        this.dZf = 0;
        this.dZs = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dZp != null) {
                    SwanVideoView.this.dZp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dZg) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dZt = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dZg = false;
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onEnd();
                }
            }
        };
        this.dZu = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dZp != null) {
                        SwanVideoView.this.dZp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dZr != null) {
                        SwanVideoView.this.dZr.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dZv = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dZg = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onError(i2, i22, null);
                }
                return SwanVideoView.this.dZr != null;
            }
        };
        this.dZw = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.dZi = i2;
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.dZh != null) {
                    SwanVideoView.this.dZh.nc((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.dZx = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dZr != null) {
                    SwanVideoView.this.dZr.onSeekEnd();
                }
            }
        };
        this.dZy = new a.InterfaceC0538a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bad() == SwanVideoView.this.dZp && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0538a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    private void dP(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dZq = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dZq.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dZq, layoutParams);
        this.dZh = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dZh.setVisibility(8);
        addView(this.dZh, layoutParams2);
        this.dZh.i(this);
        bai();
        bah();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bag();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bag() {
        if (this.dZl) {
            if (this.dZh.getVisibility() != 0) {
                this.dZh.baO();
            } else {
                this.dZh.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bah() {
        this.dZm = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dZm.setVisibility(8);
        addView(this.dZm, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dZn = new ProgressBar(getContext());
        this.dZn.setId(16908308);
        this.dZn.setMax(100);
        this.dZn.setProgress(10);
        this.dZn.setSecondaryProgress(100);
        this.dZm.addView(this.dZn, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dZo = new TextView(getContext());
        this.dZo.setTextColor(-1);
        this.dZo.setText(c.d.laoding);
        this.dZo.setGravity(1);
        this.dZm.addView(this.dZo, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.dZr = aVar;
        if (this.dZh != null) {
            this.dZh.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.bUO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.bUO != i) {
            this.bUO = i;
            if (this.dZh != null) {
                this.dZh.baL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dZm.setVisibility(0);
        } else {
            this.dZm.setVisibility(8);
        }
    }

    private void bai() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dZp != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.dZp.getView();
            this.dZp.b(this.dZy);
            this.dZp.release();
            this.dZp = null;
            this.dZq.removeView(view);
        }
        if (aVar != null) {
            this.dZp = aVar;
            aVar.setAspectRatio(this.dZf);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.dZp.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dZq.addView(view2);
            this.dZp.a(this.dZy);
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
                    this.dZg = false;
                    this.dZv.onError(this.mMediaPlayer, 1, 0);
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
            bal();
            this.dZg = false;
        }
    }

    public void baj() {
        try {
            this.mMediaPlayer = bak();
            this.mMediaPlayer.setOnPreparedListener(this.dZs);
            this.mMediaPlayer.setOnCompletionListener(this.dZt);
            this.mMediaPlayer.setOnErrorListener(this.dZv);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.dZw);
            this.mMediaPlayer.setOnSeekCompleteListener(this.dZx);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.dZu);
            this.dZi = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.dZg = false;
            this.dZv.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bak() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.dZk);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.dZk = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.dZk);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cQt = z;
            if (this.dZh != null && this.dZl) {
                this.dZh.setMute(this.cQt);
            }
        }
    }

    public boolean isMute() {
        return this.cQt;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dZl = z;
    }

    public void setInitPlayPosition(int i) {
        this.dZj = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.dZj);
            this.dZj = -1;
        }
    }

    public void release() {
        bal();
        this.dZg = false;
        if (this.dZp != null) {
            this.dZp.release();
        }
        if (this.dZh != null) {
            this.dZh.setToggleScreenListener(null);
            this.dZh.i(null);
            this.dZh = null;
        }
        if (this.dZr != null) {
            this.dZr = null;
        }
    }

    private void bal() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.dZr != null) {
            this.dZr = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.bUO == -1 || this.bUO == 5) {
                if (this.bUO == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.dZr != null) {
                    if (this.bUO == 4) {
                        this.dZr.onResume();
                    } else {
                        this.dZr.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.dZg = true;
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
        this.dZg = false;
        if (this.dZr != null) {
            this.dZr.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.dZi;
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
        return (this.mMediaPlayer == null || this.bUO == -1 || this.bUO == 0 || this.bUO == 1) ? false : true;
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
                this.dZf = 0;
            } else if (i == 2) {
                this.dZf = 1;
            } else {
                this.dZf = 3;
            }
            if (this.dZp != null) {
                this.dZp.setAspectRatio(this.dZf);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.dZp != null) {
            return this.dZp.getBitmap();
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
        return this.dZr;
    }
}
