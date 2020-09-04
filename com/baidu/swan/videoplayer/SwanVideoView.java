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
    private int bMf;
    private boolean cCp;
    private int dLb;
    private boolean dLc;
    private MediaController dLd;
    private int dLe;
    private int dLf;
    private boolean dLg;
    private boolean dLh;
    private RelativeLayout dLi;
    private ProgressBar dLj;
    private TextView dLk;
    private a dLl;
    private FrameLayout dLm;
    private com.baidu.swan.videoplayer.a.a dLn;
    MediaPlayer.OnPreparedListener dLo;
    private MediaPlayer.OnCompletionListener dLp;
    private MediaPlayer.OnVideoSizeChangedListener dLq;
    private MediaPlayer.OnErrorListener dLr;
    private MediaPlayer.OnBufferingUpdateListener dLs;
    private MediaPlayer.OnSeekCompleteListener dLt;
    a.InterfaceC0526a dLu;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.dLd != null) {
            this.dLd.hr(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.bMf = 0;
        this.dLf = -1;
        this.dLh = true;
        this.dLb = 0;
        this.dLo = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dLl != null) {
                    SwanVideoView.this.dLl.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dLc) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dLp = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dLc = false;
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onEnd();
                }
            }
        };
        this.dLq = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dLl != null) {
                        SwanVideoView.this.dLl.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dLn != null) {
                        SwanVideoView.this.dLn.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dLr = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dLc = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onError(i, i2, null);
                }
                return SwanVideoView.this.dLn != null;
            }
        };
        this.dLs = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dLe = i;
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dLd != null) {
                    SwanVideoView.this.dLd.mu((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dLt = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onSeekEnd();
                }
            }
        };
        this.dLu = new a.InterfaceC0526a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aWJ() == SwanVideoView.this.dLl && SwanVideoView.this.mMediaPlayer != null) {
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
        this.bMf = 0;
        this.dLf = -1;
        this.dLh = true;
        this.dLb = 0;
        this.dLo = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dLl != null) {
                    SwanVideoView.this.dLl.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dLc) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dLp = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dLc = false;
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onEnd();
                }
            }
        };
        this.dLq = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dLl != null) {
                        SwanVideoView.this.dLl.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dLn != null) {
                        SwanVideoView.this.dLn.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dLr = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dLc = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onError(i, i2, null);
                }
                return SwanVideoView.this.dLn != null;
            }
        };
        this.dLs = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dLe = i;
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dLd != null) {
                    SwanVideoView.this.dLd.mu((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dLt = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onSeekEnd();
                }
            }
        };
        this.dLu = new a.InterfaceC0526a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aWJ() == SwanVideoView.this.dLl && SwanVideoView.this.mMediaPlayer != null) {
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
        this.bMf = 0;
        this.dLf = -1;
        this.dLh = true;
        this.dLb = 0;
        this.dLo = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dLl != null) {
                    SwanVideoView.this.dLl.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dLc) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dLp = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dLc = false;
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onEnd();
                }
            }
        };
        this.dLq = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dLl != null) {
                        SwanVideoView.this.dLl.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dLn != null) {
                        SwanVideoView.this.dLn.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dLr = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dLc = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onError(i2, i22, null);
                }
                return SwanVideoView.this.dLn != null;
            }
        };
        this.dLs = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.dLe = i2;
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.dLd != null) {
                    SwanVideoView.this.dLd.mu((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.dLt = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dLn != null) {
                    SwanVideoView.this.dLn.onSeekEnd();
                }
            }
        };
        this.dLu = new a.InterfaceC0526a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0526a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aWJ() == SwanVideoView.this.dLl && SwanVideoView.this.mMediaPlayer != null) {
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
        this.dLm = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dLm.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dLm, layoutParams);
        this.dLd = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dLd.setVisibility(8);
        addView(this.dLd, layoutParams2);
        this.dLd.i(this);
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
        if (this.dLh) {
            if (this.dLd.getVisibility() != 0) {
                this.dLd.aXu();
            } else {
                this.dLd.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void aWN() {
        this.dLi = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dLi.setVisibility(8);
        addView(this.dLi, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dLj = new ProgressBar(getContext());
        this.dLj.setId(16908308);
        this.dLj.setMax(100);
        this.dLj.setProgress(10);
        this.dLj.setSecondaryProgress(100);
        this.dLi.addView(this.dLj, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dLk = new TextView(getContext());
        this.dLk.setTextColor(-1);
        this.dLk.setText(c.d.laoding);
        this.dLk.setGravity(1);
        this.dLi.addView(this.dLk, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.dLn = aVar;
        if (this.dLd != null) {
            this.dLd.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.bMf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.bMf != i) {
            this.bMf = i;
            if (this.dLd != null) {
                this.dLd.aXr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dLi.setVisibility(0);
        } else {
            this.dLi.setVisibility(8);
        }
    }

    private void aWO() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dLl != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.dLl.getView();
            this.dLl.b(this.dLu);
            this.dLl.release();
            this.dLl = null;
            this.dLm.removeView(view);
        }
        if (aVar != null) {
            this.dLl = aVar;
            aVar.setAspectRatio(this.dLb);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.dLl.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dLm.addView(view2);
            this.dLl.a(this.dLu);
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
                    this.dLc = false;
                    this.dLr.onError(this.mMediaPlayer, 1, 0);
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
            this.dLc = false;
        }
    }

    public void aWP() {
        try {
            this.mMediaPlayer = aWQ();
            this.mMediaPlayer.setOnPreparedListener(this.dLo);
            this.mMediaPlayer.setOnCompletionListener(this.dLp);
            this.mMediaPlayer.setOnErrorListener(this.dLr);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.dLs);
            this.mMediaPlayer.setOnSeekCompleteListener(this.dLt);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.dLq);
            this.dLe = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.dLc = false;
            this.dLr.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer aWQ() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.dLg);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.dLg = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.dLg);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cCp = z;
            if (this.dLd != null && this.dLh) {
                this.dLd.setMute(this.cCp);
            }
        }
    }

    public boolean isMute() {
        return this.cCp;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dLh = z;
    }

    public void setInitPlayPosition(int i) {
        this.dLf = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.dLf);
            this.dLf = -1;
        }
    }

    public void release() {
        aWR();
        this.dLc = false;
        if (this.dLl != null) {
            this.dLl.release();
        }
        if (this.dLd != null) {
            this.dLd.setToggleScreenListener(null);
            this.dLd.i(null);
            this.dLd = null;
        }
        if (this.dLn != null) {
            this.dLn = null;
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
        if (this.dLn != null) {
            this.dLn = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.bMf == -1 || this.bMf == 5) {
                if (this.bMf == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.dLn != null) {
                    if (this.bMf == 4) {
                        this.dLn.onResume();
                    } else {
                        this.dLn.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.dLc = true;
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
        this.dLc = false;
        if (this.dLn != null) {
            this.dLn.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.dLe;
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
        return (this.mMediaPlayer == null || this.bMf == -1 || this.bMf == 0 || this.bMf == 1) ? false : true;
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
                this.dLb = 0;
            } else if (i == 2) {
                this.dLb = 1;
            } else {
                this.dLb = 3;
            }
            if (this.dLl != null) {
                this.dLl.setAspectRatio(this.dLb);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.dLl != null) {
            return this.dLl.getBitmap();
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
        return this.dLn;
    }
}
