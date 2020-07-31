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
/* loaded from: classes3.dex */
public class SwanVideoView extends FrameLayout {
    private int bGB;
    private boolean cuB;
    private int dBM;
    private boolean dBN;
    private MediaController dBO;
    private int dBP;
    private int dBQ;
    private boolean dBR;
    private boolean dBS;
    private RelativeLayout dBT;
    private ProgressBar dBU;
    private TextView dBV;
    private a dBW;
    private FrameLayout dBX;
    private com.baidu.swan.videoplayer.a.a dBY;
    MediaPlayer.OnPreparedListener dBZ;
    private MediaPlayer.OnCompletionListener dCa;
    private MediaPlayer.OnVideoSizeChangedListener dCb;
    private MediaPlayer.OnErrorListener dCc;
    private MediaPlayer.OnBufferingUpdateListener dCd;
    private MediaPlayer.OnSeekCompleteListener dCe;
    a.InterfaceC0480a dCf;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.dBO != null) {
            this.dBO.gW(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.bGB = 0;
        this.dBQ = -1;
        this.dBS = true;
        this.dBM = 0;
        this.dBZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dBW != null) {
                    SwanVideoView.this.dBW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dBN) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dCa = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dBN = false;
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onEnd();
                }
            }
        };
        this.dCb = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dBW != null) {
                        SwanVideoView.this.dBW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dBY != null) {
                        SwanVideoView.this.dBY.P(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dCc = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dBN = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.f(i, i2, null);
                }
                return SwanVideoView.this.dBY != null;
            }
        };
        this.dCd = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dBP = i;
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dBO != null) {
                    SwanVideoView.this.dBO.ko((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dCe = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onSeekEnd();
                }
            }
        };
        this.dCf = new a.InterfaceC0480a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aOl() == SwanVideoView.this.dBW && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar) {
            }
        };
        dE(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGB = 0;
        this.dBQ = -1;
        this.dBS = true;
        this.dBM = 0;
        this.dBZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dBW != null) {
                    SwanVideoView.this.dBW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dBN) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dCa = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dBN = false;
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onEnd();
                }
            }
        };
        this.dCb = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dBW != null) {
                        SwanVideoView.this.dBW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dBY != null) {
                        SwanVideoView.this.dBY.P(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dCc = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dBN = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.f(i, i2, null);
                }
                return SwanVideoView.this.dBY != null;
            }
        };
        this.dCd = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.dBP = i;
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.dBO != null) {
                    SwanVideoView.this.dBO.ko((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.dCe = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onSeekEnd();
                }
            }
        };
        this.dCf = new a.InterfaceC0480a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aOl() == SwanVideoView.this.dBW && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar) {
            }
        };
        dE(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGB = 0;
        this.dBQ = -1;
        this.dBS = true;
        this.dBM = 0;
        this.dBZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.dBW != null) {
                    SwanVideoView.this.dBW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.dBN) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dCa = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dBN = false;
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onEnd();
                }
            }
        };
        this.dCb = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.dBW != null) {
                        SwanVideoView.this.dBW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.dBY != null) {
                        SwanVideoView.this.dBY.P(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.dCc = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dBN = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.f(i2, i22, null);
                }
                return SwanVideoView.this.dBY != null;
            }
        };
        this.dCd = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.dBP = i2;
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.dBO != null) {
                    SwanVideoView.this.dBO.ko((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.dCe = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dBY != null) {
                    SwanVideoView.this.dBY.onSeekEnd();
                }
            }
        };
        this.dCf = new a.InterfaceC0480a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aOl() == SwanVideoView.this.dBW && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0480a
            public void a(a.b bVar) {
            }
        };
        dE(context);
    }

    private void dE(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dBX = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dBX.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dBX, layoutParams);
        this.dBO = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dBO.setVisibility(8);
        addView(this.dBO, layoutParams2);
        this.dBO.i(this);
        aOq();
        aOp();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            aOo();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aOo() {
        if (this.dBS) {
            if (this.dBO.getVisibility() != 0) {
                this.dBO.aOW();
            } else {
                this.dBO.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void aOp() {
        this.dBT = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dBT.setVisibility(8);
        addView(this.dBT, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dBU = new ProgressBar(getContext());
        this.dBU.setId(16908308);
        this.dBU.setMax(100);
        this.dBU.setProgress(10);
        this.dBU.setSecondaryProgress(100);
        this.dBT.addView(this.dBU, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dBV = new TextView(getContext());
        this.dBV.setTextColor(-1);
        this.dBV.setText(c.d.laoding);
        this.dBV.setGravity(1);
        this.dBT.addView(this.dBV, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.dBY = aVar;
        if (this.dBO != null) {
            this.dBO.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.bGB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.bGB != i) {
            this.bGB = i;
            if (this.dBO != null) {
                this.dBO.aOT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dBT.setVisibility(0);
        } else {
            this.dBT.setVisibility(8);
        }
    }

    private void aOq() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dBW != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.dBW.getView();
            this.dBW.b(this.dCf);
            this.dBW.release();
            this.dBW = null;
            this.dBX.removeView(view);
        }
        if (aVar != null) {
            this.dBW = aVar;
            aVar.setAspectRatio(this.dBM);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.dBW.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dBX.addView(view2);
            this.dBW.a(this.dCf);
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
                    this.dBN = false;
                    this.dCc.onError(this.mMediaPlayer, 1, 0);
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
            aOt();
            this.dBN = false;
        }
    }

    public void aOr() {
        try {
            this.mMediaPlayer = aOs();
            this.mMediaPlayer.setOnPreparedListener(this.dBZ);
            this.mMediaPlayer.setOnCompletionListener(this.dCa);
            this.mMediaPlayer.setOnErrorListener(this.dCc);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.dCd);
            this.mMediaPlayer.setOnSeekCompleteListener(this.dCe);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.dCb);
            this.dBP = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.dBN = false;
            this.dCc.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer aOs() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.dBR);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.dBR = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.dBR);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cuB = z;
            if (this.dBO != null && this.dBS) {
                this.dBO.setMute(this.cuB);
            }
        }
    }

    public boolean isMute() {
        return this.cuB;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dBS = z;
    }

    public void setInitPlayPosition(int i) {
        this.dBQ = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.dBQ);
            this.dBQ = -1;
        }
    }

    public void release() {
        aOt();
        this.dBN = false;
        if (this.dBW != null) {
            this.dBW.release();
        }
        if (this.dBO != null) {
            this.dBO.setToggleScreenListener(null);
            this.dBO.i(null);
            this.dBO = null;
        }
        if (this.dBY != null) {
            this.dBY = null;
        }
    }

    private void aOt() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.dBY != null) {
            this.dBY = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.bGB == -1 || this.bGB == 5) {
                if (this.bGB == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.dBY != null) {
                    if (this.bGB == 4) {
                        this.dBY.onResume();
                    } else {
                        this.dBY.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.dBN = true;
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
        this.dBN = false;
        if (this.dBY != null) {
            this.dBY.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.dBP;
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
        return (this.mMediaPlayer == null || this.bGB == -1 || this.bGB == 0 || this.bGB == 1) ? false : true;
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
                this.dBM = 0;
            } else if (i == 2) {
                this.dBM = 1;
            } else {
                this.dBM = 3;
            }
            if (this.dBW != null) {
                this.dBW.setAspectRatio(this.dBM);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.dBW != null) {
            return this.dBW.getBitmap();
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
        return this.dBY;
    }
}
