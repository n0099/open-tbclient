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
    private boolean csx;
    private int dvU;
    private boolean dvV;
    private MediaController dvW;
    private int dvX;
    private int dvY;
    private boolean dvZ;
    private boolean dwa;
    private RelativeLayout dwb;
    private ProgressBar dwc;
    private TextView dwd;
    private a dwe;
    private FrameLayout dwf;
    private com.baidu.swan.videoplayer.a.a dwg;
    MediaPlayer.OnPreparedListener dwh;
    private MediaPlayer.OnCompletionListener dwi;
    private MediaPlayer.OnVideoSizeChangedListener dwj;
    private MediaPlayer.OnErrorListener dwk;
    private MediaPlayer.OnBufferingUpdateListener dwl;
    private MediaPlayer.OnSeekCompleteListener dwm;
    a.InterfaceC0468a dwn;
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
        if (this.dvW != null) {
            this.dvW.gB(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.dvY = -1;
        this.dwa = true;
        this.dvU = 0;
        this.dwh = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dwe != null) {
                    SwanVideoView.this.dwe.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dvV) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dwi = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dvV = false;
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onEnd();
                }
            }
        };
        this.dwj = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dwe != null) {
                        SwanVideoView.this.dwe.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dwg != null) {
                        SwanVideoView.this.dwg.P(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dwk = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dvV = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.f(i, i2, null);
                }
                return SwanVideoView.this.dwg != null;
            }
        };
        this.dwl = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dvX = i;
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dvW != null) {
                    SwanVideoView.this.dvW.jV((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dwm = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onSeekEnd();
                }
            }
        };
        this.dwn = new a.InterfaceC0468a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aKx() == SwanVideoView.this.dwe && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar) {
            }
        };
        dA(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.dvY = -1;
        this.dwa = true;
        this.dvU = 0;
        this.dwh = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dwe != null) {
                    SwanVideoView.this.dwe.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dvV) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dwi = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dvV = false;
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onEnd();
                }
            }
        };
        this.dwj = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dwe != null) {
                        SwanVideoView.this.dwe.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dwg != null) {
                        SwanVideoView.this.dwg.P(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dwk = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dvV = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.f(i, i2, null);
                }
                return SwanVideoView.this.dwg != null;
            }
        };
        this.dwl = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dvX = i;
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dvW != null) {
                    SwanVideoView.this.dvW.jV((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dwm = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onSeekEnd();
                }
            }
        };
        this.dwn = new a.InterfaceC0468a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aKx() == SwanVideoView.this.dwe && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar) {
            }
        };
        dA(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.dvY = -1;
        this.dwa = true;
        this.dvU = 0;
        this.dwh = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dwe != null) {
                    SwanVideoView.this.dwe.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dvV) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dwi = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dvV = false;
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onEnd();
                }
            }
        };
        this.dwj = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dwe != null) {
                        SwanVideoView.this.dwe.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dwg != null) {
                        SwanVideoView.this.dwg.P(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dwk = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dvV = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.f(i2, i22, null);
                }
                return SwanVideoView.this.dwg != null;
            }
        };
        this.dwl = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.dvX = i2;
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.dvW != null) {
                    SwanVideoView.this.dvW.jV((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.dwm = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dwg != null) {
                    SwanVideoView.this.dwg.onSeekEnd();
                }
            }
        };
        this.dwn = new a.InterfaceC0468a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aKx() == SwanVideoView.this.dwe && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0468a
            public void a(a.b bVar) {
            }
        };
        dA(context);
    }

    private void dA(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dwf = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dwf.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dwf, layoutParams);
        this.dvW = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dvW.setVisibility(8);
        addView(this.dvW, layoutParams2);
        this.dvW.i(this);
        aKC();
        aKB();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            aKA();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aKA() {
        if (this.dwa) {
            if (this.dvW.getVisibility() != 0) {
                this.dvW.aLi();
            } else {
                this.dvW.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void aKB() {
        this.dwb = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dwb.setVisibility(8);
        addView(this.dwb, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dwc = new ProgressBar(getContext());
        this.dwc.setId(16908308);
        this.dwc.setMax(100);
        this.dwc.setProgress(10);
        this.dwc.setSecondaryProgress(100);
        this.dwb.addView(this.dwc, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dwd = new TextView(getContext());
        this.dwd.setTextColor(-1);
        this.dwd.setText(c.d.laoding);
        this.dwd.setGravity(1);
        this.dwb.addView(this.dwd, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.dwg = aVar;
        if (this.dvW != null) {
            this.dvW.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.dvW != null) {
                this.dvW.aLf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dwb.setVisibility(0);
        } else {
            this.dwb.setVisibility(8);
        }
    }

    private void aKC() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dwe != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.dwe.getView();
            this.dwe.b(this.dwn);
            this.dwe.release();
            this.dwe = null;
            this.dwf.removeView(view);
        }
        if (aVar != null) {
            this.dwe = aVar;
            aVar.setAspectRatio(this.dvU);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.dwe.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dwf.addView(view2);
            this.dwe.a(this.dwn);
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
                    this.dvV = false;
                    this.dwk.onError(this.mMediaPlayer, 1, 0);
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
            aKF();
            this.dvV = false;
        }
    }

    public void aKD() {
        try {
            this.mMediaPlayer = aKE();
            this.mMediaPlayer.setOnPreparedListener(this.dwh);
            this.mMediaPlayer.setOnCompletionListener(this.dwi);
            this.mMediaPlayer.setOnErrorListener(this.dwk);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.dwl);
            this.mMediaPlayer.setOnSeekCompleteListener(this.dwm);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.dwj);
            this.dvX = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.dvV = false;
            this.dwk.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer aKE() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.dvZ);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.dvZ = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.dvZ);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.csx = z;
            if (this.dvW != null && this.dwa) {
                this.dvW.setMute(this.csx);
            }
        }
    }

    public boolean isMute() {
        return this.csx;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dwa = z;
    }

    public void setInitPlayPosition(int i) {
        this.dvY = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.dvY);
            this.dvY = -1;
        }
    }

    public void release() {
        aKF();
        this.dvV = false;
        if (this.dwe != null) {
            this.dwe.release();
        }
        if (this.dvW != null) {
            this.dvW.setToggleScreenListener(null);
            this.dvW.i(null);
            this.dvW = null;
        }
        if (this.dwg != null) {
            this.dwg = null;
        }
    }

    private void aKF() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.dwg != null) {
            this.dwg = null;
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
                if (this.dwg != null) {
                    if (this.mCurrentState == 4) {
                        this.dwg.onResume();
                    } else {
                        this.dwg.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.dvV = true;
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
        this.dvV = false;
        if (this.dwg != null) {
            this.dwg.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.dvX;
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
                this.dvU = 0;
            } else if (i == 2) {
                this.dvU = 1;
            } else {
                this.dvU = 3;
            }
            if (this.dwe != null) {
                this.dwe.setAspectRatio(this.dvU);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.dwe != null) {
            return this.dwe.getBitmap();
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
        return this.dwg;
    }
}
