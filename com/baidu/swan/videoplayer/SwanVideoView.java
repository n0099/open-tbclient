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
    private boolean cYP;
    private int cdn;
    private int ehC;
    private boolean ehD;
    private MediaController ehE;
    private int ehF;
    private int ehG;
    private boolean ehH;
    private boolean ehI;
    private RelativeLayout ehJ;
    private ProgressBar ehK;
    private TextView ehL;
    private a ehM;
    private FrameLayout ehN;
    private com.baidu.swan.videoplayer.a.a ehO;
    MediaPlayer.OnPreparedListener ehP;
    private MediaPlayer.OnCompletionListener ehQ;
    private MediaPlayer.OnVideoSizeChangedListener ehR;
    private MediaPlayer.OnErrorListener ehS;
    private MediaPlayer.OnBufferingUpdateListener ehT;
    private MediaPlayer.OnSeekCompleteListener ehU;
    a.InterfaceC0552a ehV;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.ehE != null) {
            this.ehE.hX(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.cdn = 0;
        this.ehG = -1;
        this.ehI = true;
        this.ehC = 0;
        this.ehP = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.ehM != null) {
                    SwanVideoView.this.ehM.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.ehD) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.ehQ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.ehD = false;
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onEnd();
                }
            }
        };
        this.ehR = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.ehM != null) {
                        SwanVideoView.this.ehM.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.ehO != null) {
                        SwanVideoView.this.ehO.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.ehS = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.ehD = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onError(i, i2, null);
                }
                return SwanVideoView.this.ehO != null;
            }
        };
        this.ehT = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.ehF = i;
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.ehE != null) {
                    SwanVideoView.this.ehE.nn((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.ehU = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onSeekEnd();
                }
            }
        };
        this.ehV = new a.InterfaceC0552a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bbW() == SwanVideoView.this.ehM && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdn = 0;
        this.ehG = -1;
        this.ehI = true;
        this.ehC = 0;
        this.ehP = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.ehM != null) {
                    SwanVideoView.this.ehM.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.ehD) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.ehQ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.ehD = false;
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onEnd();
                }
            }
        };
        this.ehR = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.ehM != null) {
                        SwanVideoView.this.ehM.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.ehO != null) {
                        SwanVideoView.this.ehO.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.ehS = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.ehD = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onError(i, i2, null);
                }
                return SwanVideoView.this.ehO != null;
            }
        };
        this.ehT = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.ehF = i;
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.ehE != null) {
                    SwanVideoView.this.ehE.nn((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.ehU = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onSeekEnd();
                }
            }
        };
        this.ehV = new a.InterfaceC0552a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bbW() == SwanVideoView.this.ehM && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdn = 0;
        this.ehG = -1;
        this.ehI = true;
        this.ehC = 0;
        this.ehP = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.ehM != null) {
                    SwanVideoView.this.ehM.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.ehD) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.ehQ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.ehD = false;
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onEnd();
                }
            }
        };
        this.ehR = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.ehM != null) {
                        SwanVideoView.this.ehM.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.ehO != null) {
                        SwanVideoView.this.ehO.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.ehS = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.ehD = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onError(i2, i22, null);
                }
                return SwanVideoView.this.ehO != null;
            }
        };
        this.ehT = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.ehF = i2;
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.ehE != null) {
                    SwanVideoView.this.ehE.nn((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.ehU = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.ehO != null) {
                    SwanVideoView.this.ehO.onSeekEnd();
                }
            }
        };
        this.ehV = new a.InterfaceC0552a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bbW() == SwanVideoView.this.ehM && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0552a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    private void dP(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.ehN = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ehN.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.ehN, layoutParams);
        this.ehE = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.ehE.setVisibility(8);
        addView(this.ehE, layoutParams2);
        this.ehE.i(this);
        bcb();
        bca();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bbZ();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bbZ() {
        if (this.ehI) {
            if (this.ehE.getVisibility() != 0) {
                this.ehE.bcH();
            } else {
                this.ehE.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bca() {
        this.ehJ = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ehJ.setVisibility(8);
        addView(this.ehJ, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.ehK = new ProgressBar(getContext());
        this.ehK.setId(16908308);
        this.ehK.setMax(100);
        this.ehK.setProgress(10);
        this.ehK.setSecondaryProgress(100);
        this.ehJ.addView(this.ehK, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.ehL = new TextView(getContext());
        this.ehL.setTextColor(-1);
        this.ehL.setText(c.d.laoding);
        this.ehL.setGravity(1);
        this.ehJ.addView(this.ehL, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.ehO = aVar;
        if (this.ehE != null) {
            this.ehE.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.cdn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.cdn != i) {
            this.cdn = i;
            if (this.ehE != null) {
                this.ehE.bcE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.ehJ.setVisibility(0);
        } else {
            this.ehJ.setVisibility(8);
        }
    }

    private void bcb() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.ehM != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.ehM.getView();
            this.ehM.b(this.ehV);
            this.ehM.release();
            this.ehM = null;
            this.ehN.removeView(view);
        }
        if (aVar != null) {
            this.ehM = aVar;
            aVar.setAspectRatio(this.ehC);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.ehM.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.ehN.addView(view2);
            this.ehM.a(this.ehV);
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
                    this.ehD = false;
                    this.ehS.onError(this.mMediaPlayer, 1, 0);
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
            bce();
            this.ehD = false;
        }
    }

    public void bcc() {
        try {
            this.mMediaPlayer = bcd();
            this.mMediaPlayer.setOnPreparedListener(this.ehP);
            this.mMediaPlayer.setOnCompletionListener(this.ehQ);
            this.mMediaPlayer.setOnErrorListener(this.ehS);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.ehT);
            this.mMediaPlayer.setOnSeekCompleteListener(this.ehU);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.ehR);
            this.ehF = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.ehD = false;
            this.ehS.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bcd() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.ehH);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.ehH = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.ehH);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cYP = z;
            if (this.ehE != null && this.ehI) {
                this.ehE.setMute(this.cYP);
            }
        }
    }

    public boolean isMute() {
        return this.cYP;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.ehI = z;
    }

    public void setInitPlayPosition(int i) {
        this.ehG = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.ehG);
            this.ehG = -1;
        }
    }

    public void release() {
        bce();
        this.ehD = false;
        if (this.ehM != null) {
            this.ehM.release();
        }
        if (this.ehE != null) {
            this.ehE.setToggleScreenListener(null);
            this.ehE.i(null);
            this.ehE = null;
        }
        if (this.ehO != null) {
            this.ehO = null;
        }
    }

    private void bce() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.ehO != null) {
            this.ehO = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.cdn == -1 || this.cdn == 5) {
                if (this.cdn == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.ehO != null) {
                    if (this.cdn == 4) {
                        this.ehO.onResume();
                    } else {
                        this.ehO.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.ehD = true;
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
        this.ehD = false;
        if (this.ehO != null) {
            this.ehO.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.ehF;
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
        return (this.mMediaPlayer == null || this.cdn == -1 || this.cdn == 0 || this.cdn == 1) ? false : true;
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
                this.ehC = 0;
            } else if (i == 2) {
                this.ehC = 1;
            } else {
                this.ehC = 3;
            }
            if (this.ehM != null) {
                this.ehM.setAspectRatio(this.ehC);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.ehM != null) {
            return this.ehM.getBitmap();
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
        return this.ehO;
    }
}
