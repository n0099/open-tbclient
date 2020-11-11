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
    private int ciY;
    private boolean deM;
    private boolean enA;
    private boolean enB;
    private RelativeLayout enC;
    private ProgressBar enD;
    private TextView enE;
    private a enF;
    private FrameLayout enG;
    private com.baidu.swan.videoplayer.a.a enH;
    MediaPlayer.OnPreparedListener enI;
    private MediaPlayer.OnCompletionListener enJ;
    private MediaPlayer.OnVideoSizeChangedListener enK;
    private MediaPlayer.OnErrorListener enL;
    private MediaPlayer.OnBufferingUpdateListener enM;
    private MediaPlayer.OnSeekCompleteListener enN;
    a.InterfaceC0564a enO;
    private int enu;
    private boolean enw;
    private MediaController enx;
    private int eny;
    private int enz;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.enx != null) {
            this.enx.ig(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.ciY = 0;
        this.enz = -1;
        this.enB = true;
        this.enu = 0;
        this.enI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.enF != null) {
                    SwanVideoView.this.enF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.enw) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.enJ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.enw = false;
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onEnd();
                }
            }
        };
        this.enK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.enF != null) {
                        SwanVideoView.this.enF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.enH != null) {
                        SwanVideoView.this.enH.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.enL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.enw = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onError(i, i2, null);
                }
                return SwanVideoView.this.enH != null;
            }
        };
        this.enM = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.eny = i;
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.enx != null) {
                    SwanVideoView.this.enx.nx((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.enN = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onSeekEnd();
                }
            }
        };
        this.enO = new a.InterfaceC0564a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bew() == SwanVideoView.this.enF && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ciY = 0;
        this.enz = -1;
        this.enB = true;
        this.enu = 0;
        this.enI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.enF != null) {
                    SwanVideoView.this.enF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.enw) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.enJ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.enw = false;
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onEnd();
                }
            }
        };
        this.enK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.enF != null) {
                        SwanVideoView.this.enF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.enH != null) {
                        SwanVideoView.this.enH.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.enL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.enw = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onError(i, i2, null);
                }
                return SwanVideoView.this.enH != null;
            }
        };
        this.enM = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.eny = i;
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.enx != null) {
                    SwanVideoView.this.enx.nx((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.enN = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onSeekEnd();
                }
            }
        };
        this.enO = new a.InterfaceC0564a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bew() == SwanVideoView.this.enF && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ciY = 0;
        this.enz = -1;
        this.enB = true;
        this.enu = 0;
        this.enI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.enF != null) {
                    SwanVideoView.this.enF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.enw) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.enJ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.enw = false;
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onEnd();
                }
            }
        };
        this.enK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.enF != null) {
                        SwanVideoView.this.enF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.enH != null) {
                        SwanVideoView.this.enH.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.enL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.enw = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onError(i2, i22, null);
                }
                return SwanVideoView.this.enH != null;
            }
        };
        this.enM = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.eny = i2;
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.enx != null) {
                    SwanVideoView.this.enx.nx((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.enN = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.enH != null) {
                    SwanVideoView.this.enH.onSeekEnd();
                }
            }
        };
        this.enO = new a.InterfaceC0564a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bew() == SwanVideoView.this.enF && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0564a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    private void dP(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.enG = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.enG.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.enG, layoutParams);
        this.enx = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.enx.setVisibility(8);
        addView(this.enx, layoutParams2);
        this.enx.i(this);
        beB();
        beA();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bez();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bez() {
        if (this.enB) {
            if (this.enx.getVisibility() != 0) {
                this.enx.bfh();
            } else {
                this.enx.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void beA() {
        this.enC = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.enC.setVisibility(8);
        addView(this.enC, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.enD = new ProgressBar(getContext());
        this.enD.setId(16908308);
        this.enD.setMax(100);
        this.enD.setProgress(10);
        this.enD.setSecondaryProgress(100);
        this.enC.addView(this.enD, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.enE = new TextView(getContext());
        this.enE.setTextColor(-1);
        this.enE.setText(c.d.laoding);
        this.enE.setGravity(1);
        this.enC.addView(this.enE, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.enH = aVar;
        if (this.enx != null) {
            this.enx.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.ciY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.ciY != i) {
            this.ciY = i;
            if (this.enx != null) {
                this.enx.bfe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.enC.setVisibility(0);
        } else {
            this.enC.setVisibility(8);
        }
    }

    private void beB() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.enF != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.enF.getView();
            this.enF.b(this.enO);
            this.enF.release();
            this.enF = null;
            this.enG.removeView(view);
        }
        if (aVar != null) {
            this.enF = aVar;
            aVar.setAspectRatio(this.enu);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.enF.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.enG.addView(view2);
            this.enF.a(this.enO);
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
                    this.enw = false;
                    this.enL.onError(this.mMediaPlayer, 1, 0);
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
            beE();
            this.enw = false;
        }
    }

    public void beC() {
        try {
            this.mMediaPlayer = beD();
            this.mMediaPlayer.setOnPreparedListener(this.enI);
            this.mMediaPlayer.setOnCompletionListener(this.enJ);
            this.mMediaPlayer.setOnErrorListener(this.enL);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.enM);
            this.mMediaPlayer.setOnSeekCompleteListener(this.enN);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.enK);
            this.eny = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.enw = false;
            this.enL.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer beD() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.enA);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.enA = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.enA);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.deM = z;
            if (this.enx != null && this.enB) {
                this.enx.setMute(this.deM);
            }
        }
    }

    public boolean isMute() {
        return this.deM;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.enB = z;
    }

    public void setInitPlayPosition(int i) {
        this.enz = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.enz);
            this.enz = -1;
        }
    }

    public void release() {
        beE();
        this.enw = false;
        if (this.enF != null) {
            this.enF.release();
        }
        if (this.enx != null) {
            this.enx.setToggleScreenListener(null);
            this.enx.i(null);
            this.enx = null;
        }
        if (this.enH != null) {
            this.enH = null;
        }
    }

    private void beE() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.enH != null) {
            this.enH = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.ciY == -1 || this.ciY == 5) {
                if (this.ciY == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.enH != null) {
                    if (this.ciY == 4) {
                        this.enH.onResume();
                    } else {
                        this.enH.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.enw = true;
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
        this.enw = false;
        if (this.enH != null) {
            this.enH.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.eny;
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
        return (this.mMediaPlayer == null || this.ciY == -1 || this.ciY == 0 || this.ciY == 1) ? false : true;
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
                this.enu = 0;
            } else if (i == 2) {
                this.enu = 1;
            } else {
                this.enu = 3;
            }
            if (this.enF != null) {
                this.enF.setAspectRatio(this.enu);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.enF != null) {
            return this.enF.getBitmap();
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
        return this.enH;
    }
}
