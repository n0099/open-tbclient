package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
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
import androidx.core.view.ViewCompat;
import com.baidu.swan.videoplayer.a;
import com.baidu.swan.videoplayer.c;
import com.baidu.swan.videoplayer.widget.MediaController;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes14.dex */
public class SwanVideoView extends FrameLayout {
    private boolean bbh;
    private int cqj;
    private int exI;
    private boolean exJ;
    private MediaController exK;
    private int exL;
    private int exM;
    private boolean exN;
    private RelativeLayout exO;
    private ProgressBar exP;
    private TextView exQ;
    private a exR;
    private FrameLayout exS;
    private com.baidu.swan.videoplayer.a.a exT;
    MediaPlayer.OnPreparedListener exU;
    private MediaPlayer.OnCompletionListener exV;
    private MediaPlayer.OnVideoSizeChangedListener exW;
    private MediaPlayer.OnErrorListener exX;
    private MediaPlayer.OnBufferingUpdateListener exY;
    private MediaPlayer.OnSeekCompleteListener exZ;
    a.InterfaceC0548a eya;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private boolean mMute;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.exK != null) {
            this.exK.iP(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.cqj = 0;
        this.exM = -1;
        this.exN = true;
        this.exI = 0;
        this.exU = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.exR != null) {
                    SwanVideoView.this.exR.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.exJ) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.exV = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.exJ = false;
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onEnd();
                }
            }
        };
        this.exW = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.exR != null) {
                        SwanVideoView.this.exR.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.exT != null) {
                        SwanVideoView.this.exT.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.exX = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.exJ = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onError(i, i2, null);
                }
                return SwanVideoView.this.exT != null;
            }
        };
        this.exY = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.exL = i;
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.exK != null) {
                    SwanVideoView.this.exK.mu((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.exZ = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onSeekEnd();
                }
            }
        };
        this.eya = new a.InterfaceC0548a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bfy() == SwanVideoView.this.exR && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar) {
            }
        };
        eM(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqj = 0;
        this.exM = -1;
        this.exN = true;
        this.exI = 0;
        this.exU = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.exR != null) {
                    SwanVideoView.this.exR.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.exJ) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.exV = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.exJ = false;
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onEnd();
                }
            }
        };
        this.exW = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.exR != null) {
                        SwanVideoView.this.exR.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.exT != null) {
                        SwanVideoView.this.exT.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.exX = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.exJ = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onError(i, i2, null);
                }
                return SwanVideoView.this.exT != null;
            }
        };
        this.exY = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.exL = i;
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.exK != null) {
                    SwanVideoView.this.exK.mu((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.exZ = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onSeekEnd();
                }
            }
        };
        this.eya = new a.InterfaceC0548a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bfy() == SwanVideoView.this.exR && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar) {
            }
        };
        eM(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqj = 0;
        this.exM = -1;
        this.exN = true;
        this.exI = 0;
        this.exU = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.exR != null) {
                    SwanVideoView.this.exR.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.exJ) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.exV = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.exJ = false;
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onEnd();
                }
            }
        };
        this.exW = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.exR != null) {
                        SwanVideoView.this.exR.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.exT != null) {
                        SwanVideoView.this.exT.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.exX = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + "," + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.exJ = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onError(i2, i22, null);
                }
                return SwanVideoView.this.exT != null;
            }
        };
        this.exY = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.exL = i2;
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.exK != null) {
                    SwanVideoView.this.exK.mu((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.exZ = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.exT != null) {
                    SwanVideoView.this.exT.onSeekEnd();
                }
            }
        };
        this.eya = new a.InterfaceC0548a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bfy() == SwanVideoView.this.exR && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0548a
            public void a(a.b bVar) {
            }
        };
        eM(context);
    }

    private void eM(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.exS = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.exS.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.exS, layoutParams);
        this.exK = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.exK.setVisibility(8);
        addView(this.exK, layoutParams2);
        this.exK.i(this);
        bfD();
        bfC();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bfB();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bfB() {
        if (this.exN) {
            if (this.exK.getVisibility() != 0) {
                this.exK.bgi();
            } else {
                this.exK.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bfC() {
        this.exO = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.exO.setVisibility(8);
        addView(this.exO, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.exP = new ProgressBar(getContext());
        this.exP.setId(16908308);
        this.exP.setMax(100);
        this.exP.setProgress(10);
        this.exP.setSecondaryProgress(100);
        this.exO.addView(this.exP, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.exQ = new TextView(getContext());
        this.exQ.setTextColor(-1);
        this.exQ.setText(c.d.laoding);
        this.exQ.setGravity(1);
        this.exO.addView(this.exQ, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.exT = aVar;
        if (this.exK != null) {
            this.exK.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.cqj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.cqj != i) {
            this.cqj = i;
            if (this.exK != null) {
                this.exK.bgf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.exO.setVisibility(0);
        } else {
            this.exO.setVisibility(8);
        }
    }

    private void bfD() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.exR != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.exR.getView();
            this.exR.b(this.eya);
            this.exR.release();
            this.exR = null;
            this.exS.removeView(view);
        }
        if (aVar != null) {
            this.exR = aVar;
            aVar.setAspectRatio(this.exI);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.exR.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.exS.addView(view2);
            this.exR.a(this.eya);
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
                    this.exJ = false;
                    this.exX.onError(this.mMediaPlayer, 1, 0);
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
            bfG();
            this.exJ = false;
        }
    }

    public void bfE() {
        try {
            this.mMediaPlayer = bfF();
            this.mMediaPlayer.setOnPreparedListener(this.exU);
            this.mMediaPlayer.setOnCompletionListener(this.exV);
            this.mMediaPlayer.setOnErrorListener(this.exX);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.exY);
            this.mMediaPlayer.setOnSeekCompleteListener(this.exZ);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.exW);
            this.exL = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.exJ = false;
            this.exX.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bfF() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.bbh);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.bbh = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.bbh);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.mMute = z;
            if (this.exK != null && this.exN) {
                this.exK.setMute(this.mMute);
            }
        }
    }

    public boolean isMute() {
        return this.mMute;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.exN = z;
    }

    public void setInitPlayPosition(int i) {
        this.exM = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.exM);
            this.exM = -1;
        }
    }

    public void release() {
        bfG();
        this.exJ = false;
        if (this.exR != null) {
            this.exR.release();
        }
        if (this.exK != null) {
            this.exK.setToggleScreenListener(null);
            this.exK.i(null);
            this.exK = null;
        }
        if (this.exT != null) {
            this.exT = null;
        }
    }

    private void bfG() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.exT != null) {
            this.exT = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.cqj == -1 || this.cqj == 5) {
                if (this.cqj == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.exT != null) {
                    if (this.cqj == 4) {
                        this.exT.onResume();
                    } else {
                        this.exT.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.exJ = true;
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
        this.exJ = false;
        if (this.exT != null) {
            this.exT.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.exL;
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
        return (this.mMediaPlayer == null || this.cqj == -1 || this.cqj == 0 || this.cqj == 1) ? false : true;
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
                this.exI = 0;
            } else if (i == 2) {
                this.exI = 1;
            } else {
                this.exI = 3;
            }
            if (this.exR != null) {
                this.exR.setAspectRatio(this.exI);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.exR != null) {
            return this.exR.getBitmap();
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
        return this.exT;
    }
}
