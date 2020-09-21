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
/* loaded from: classes25.dex */
public class SwanVideoView extends FrameLayout {
    private int bOf;
    private boolean cEp;
    private int dNe;
    private boolean dNf;
    private MediaController dNg;
    private int dNh;
    private int dNi;
    private boolean dNj;
    private boolean dNk;
    private RelativeLayout dNl;
    private ProgressBar dNm;
    private TextView dNn;
    private a dNo;
    private FrameLayout dNp;
    private com.baidu.swan.videoplayer.a.a dNq;
    MediaPlayer.OnPreparedListener dNr;
    private MediaPlayer.OnCompletionListener dNs;
    private MediaPlayer.OnVideoSizeChangedListener dNt;
    private MediaPlayer.OnErrorListener dNu;
    private MediaPlayer.OnBufferingUpdateListener dNv;
    private MediaPlayer.OnSeekCompleteListener dNw;
    a.InterfaceC0521a dNx;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.dNg != null) {
            this.dNg.hp(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.bOf = 0;
        this.dNi = -1;
        this.dNk = true;
        this.dNe = 0;
        this.dNr = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dNo != null) {
                    SwanVideoView.this.dNo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dNf) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dNs = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dNf = false;
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onEnd();
                }
            }
        };
        this.dNt = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dNo != null) {
                        SwanVideoView.this.dNo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dNq != null) {
                        SwanVideoView.this.dNq.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dNu = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dNf = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onError(i, i2, null);
                }
                return SwanVideoView.this.dNq != null;
            }
        };
        this.dNv = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dNh = i;
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dNg != null) {
                    SwanVideoView.this.dNg.mF((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dNw = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onSeekEnd();
                }
            }
        };
        this.dNx = new a.InterfaceC0521a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aXv() == SwanVideoView.this.dNo && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar) {
            }
        };
        dJ(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOf = 0;
        this.dNi = -1;
        this.dNk = true;
        this.dNe = 0;
        this.dNr = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dNo != null) {
                    SwanVideoView.this.dNo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dNf) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dNs = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dNf = false;
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onEnd();
                }
            }
        };
        this.dNt = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dNo != null) {
                        SwanVideoView.this.dNo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dNq != null) {
                        SwanVideoView.this.dNq.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dNu = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dNf = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onError(i, i2, null);
                }
                return SwanVideoView.this.dNq != null;
            }
        };
        this.dNv = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dNh = i;
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dNg != null) {
                    SwanVideoView.this.dNg.mF((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dNw = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onSeekEnd();
                }
            }
        };
        this.dNx = new a.InterfaceC0521a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aXv() == SwanVideoView.this.dNo && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar) {
            }
        };
        dJ(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOf = 0;
        this.dNi = -1;
        this.dNk = true;
        this.dNe = 0;
        this.dNr = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dNo != null) {
                    SwanVideoView.this.dNo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dNf) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dNs = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dNf = false;
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onEnd();
                }
            }
        };
        this.dNt = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dNo != null) {
                        SwanVideoView.this.dNo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dNq != null) {
                        SwanVideoView.this.dNq.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dNu = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dNf = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onError(i2, i22, null);
                }
                return SwanVideoView.this.dNq != null;
            }
        };
        this.dNv = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.dNh = i2;
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.dNg != null) {
                    SwanVideoView.this.dNg.mF((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.dNw = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dNq != null) {
                    SwanVideoView.this.dNq.onSeekEnd();
                }
            }
        };
        this.dNx = new a.InterfaceC0521a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aXv() == SwanVideoView.this.dNo && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0521a
            public void a(a.b bVar) {
            }
        };
        dJ(context);
    }

    private void dJ(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dNp = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dNp.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dNp, layoutParams);
        this.dNg = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dNg.setVisibility(8);
        addView(this.dNg, layoutParams2);
        this.dNg.i(this);
        aXA();
        aXz();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            aXy();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aXy() {
        if (this.dNk) {
            if (this.dNg.getVisibility() != 0) {
                this.dNg.aYg();
            } else {
                this.dNg.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void aXz() {
        this.dNl = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dNl.setVisibility(8);
        addView(this.dNl, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dNm = new ProgressBar(getContext());
        this.dNm.setId(16908308);
        this.dNm.setMax(100);
        this.dNm.setProgress(10);
        this.dNm.setSecondaryProgress(100);
        this.dNl.addView(this.dNm, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dNn = new TextView(getContext());
        this.dNn.setTextColor(-1);
        this.dNn.setText(c.d.laoding);
        this.dNn.setGravity(1);
        this.dNl.addView(this.dNn, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.dNq = aVar;
        if (this.dNg != null) {
            this.dNg.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.bOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.bOf != i) {
            this.bOf = i;
            if (this.dNg != null) {
                this.dNg.aYd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dNl.setVisibility(0);
        } else {
            this.dNl.setVisibility(8);
        }
    }

    private void aXA() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dNo != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.dNo.getView();
            this.dNo.b(this.dNx);
            this.dNo.release();
            this.dNo = null;
            this.dNp.removeView(view);
        }
        if (aVar != null) {
            this.dNo = aVar;
            aVar.setAspectRatio(this.dNe);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.dNo.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dNp.addView(view2);
            this.dNo.a(this.dNx);
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
                    this.dNf = false;
                    this.dNu.onError(this.mMediaPlayer, 1, 0);
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
            aXD();
            this.dNf = false;
        }
    }

    public void aXB() {
        try {
            this.mMediaPlayer = aXC();
            this.mMediaPlayer.setOnPreparedListener(this.dNr);
            this.mMediaPlayer.setOnCompletionListener(this.dNs);
            this.mMediaPlayer.setOnErrorListener(this.dNu);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.dNv);
            this.mMediaPlayer.setOnSeekCompleteListener(this.dNw);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.dNt);
            this.dNh = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.dNf = false;
            this.dNu.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer aXC() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.dNj);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.dNj = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.dNj);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cEp = z;
            if (this.dNg != null && this.dNk) {
                this.dNg.setMute(this.cEp);
            }
        }
    }

    public boolean isMute() {
        return this.cEp;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dNk = z;
    }

    public void setInitPlayPosition(int i) {
        this.dNi = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.dNi);
            this.dNi = -1;
        }
    }

    public void release() {
        aXD();
        this.dNf = false;
        if (this.dNo != null) {
            this.dNo.release();
        }
        if (this.dNg != null) {
            this.dNg.setToggleScreenListener(null);
            this.dNg.i(null);
            this.dNg = null;
        }
        if (this.dNq != null) {
            this.dNq = null;
        }
    }

    private void aXD() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.dNq != null) {
            this.dNq = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.bOf == -1 || this.bOf == 5) {
                if (this.bOf == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.dNq != null) {
                    if (this.bOf == 4) {
                        this.dNq.onResume();
                    } else {
                        this.dNq.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.dNf = true;
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
        this.dNf = false;
        if (this.dNq != null) {
            this.dNq.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.dNh;
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
        return (this.mMediaPlayer == null || this.bOf == -1 || this.bOf == 0 || this.bOf == 1) ? false : true;
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
                this.dNe = 0;
            } else if (i == 2) {
                this.dNe = 1;
            } else {
                this.dNe = 3;
            }
            if (this.dNo != null) {
                this.dNo.setAspectRatio(this.dNe);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.dNo != null) {
            return this.dNo.getBitmap();
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
        return this.dNq;
    }
}
