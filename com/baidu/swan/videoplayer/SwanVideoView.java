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
/* loaded from: classes15.dex */
public class SwanVideoView extends FrameLayout {
    private boolean ben;
    private a eAa;
    private FrameLayout eAb;
    private com.baidu.swan.videoplayer.a.a eAc;
    MediaPlayer.OnPreparedListener eAd;
    private MediaPlayer.OnCompletionListener eAe;
    private MediaPlayer.OnVideoSizeChangedListener eAf;
    private MediaPlayer.OnErrorListener eAg;
    private MediaPlayer.OnBufferingUpdateListener eAh;
    private MediaPlayer.OnSeekCompleteListener eAi;
    a.InterfaceC0545a eAj;
    private int ezQ;
    private int ezR;
    private boolean ezS;
    private MediaController ezT;
    private int ezU;
    private int ezV;
    private boolean ezW;
    private RelativeLayout ezX;
    private ProgressBar ezY;
    private TextView ezZ;
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
        if (this.ezT != null) {
            this.ezT.iR(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.ezR = 0;
        this.ezV = -1;
        this.ezW = true;
        this.ezQ = 0;
        this.eAd = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eAa != null) {
                    SwanVideoView.this.eAa.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.ezS) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eAe = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.ezS = false;
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onEnd();
                }
            }
        };
        this.eAf = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eAa != null) {
                        SwanVideoView.this.eAa.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eAc != null) {
                        SwanVideoView.this.eAc.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eAg = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.ezS = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onError(i, i2, null);
                }
                return SwanVideoView.this.eAc != null;
            }
        };
        this.eAh = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.ezU = i;
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.ezT != null) {
                    SwanVideoView.this.ezT.mx((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eAi = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onSeekEnd();
                }
            }
        };
        this.eAj = new a.InterfaceC0545a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bfL() == SwanVideoView.this.eAa && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar) {
            }
        };
        eL(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezR = 0;
        this.ezV = -1;
        this.ezW = true;
        this.ezQ = 0;
        this.eAd = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eAa != null) {
                    SwanVideoView.this.eAa.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.ezS) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eAe = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.ezS = false;
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onEnd();
                }
            }
        };
        this.eAf = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eAa != null) {
                        SwanVideoView.this.eAa.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eAc != null) {
                        SwanVideoView.this.eAc.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eAg = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.ezS = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onError(i, i2, null);
                }
                return SwanVideoView.this.eAc != null;
            }
        };
        this.eAh = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.ezU = i;
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.ezT != null) {
                    SwanVideoView.this.ezT.mx((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eAi = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onSeekEnd();
                }
            }
        };
        this.eAj = new a.InterfaceC0545a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bfL() == SwanVideoView.this.eAa && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar) {
            }
        };
        eL(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ezR = 0;
        this.ezV = -1;
        this.ezW = true;
        this.ezQ = 0;
        this.eAd = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eAa != null) {
                    SwanVideoView.this.eAa.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.ezS) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eAe = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.ezS = false;
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onEnd();
                }
            }
        };
        this.eAf = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eAa != null) {
                        SwanVideoView.this.eAa.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eAc != null) {
                        SwanVideoView.this.eAc.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eAg = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + "," + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.ezS = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onError(i2, i22, null);
                }
                return SwanVideoView.this.eAc != null;
            }
        };
        this.eAh = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.ezU = i2;
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.ezT != null) {
                    SwanVideoView.this.ezT.mx((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.eAi = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eAc != null) {
                    SwanVideoView.this.eAc.onSeekEnd();
                }
            }
        };
        this.eAj = new a.InterfaceC0545a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bfL() == SwanVideoView.this.eAa && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0545a
            public void a(a.b bVar) {
            }
        };
        eL(context);
    }

    private void eL(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eAb = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eAb.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eAb, layoutParams);
        this.ezT = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.ezT.setVisibility(8);
        addView(this.ezT, layoutParams2);
        this.ezT.i(this);
        bfQ();
        bfP();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bfO();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bfO() {
        if (this.ezW) {
            if (this.ezT.getVisibility() != 0) {
                this.ezT.bgv();
            } else {
                this.ezT.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bfP() {
        this.ezX = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ezX.setVisibility(8);
        addView(this.ezX, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.ezY = new ProgressBar(getContext());
        this.ezY.setId(16908308);
        this.ezY.setMax(100);
        this.ezY.setProgress(10);
        this.ezY.setSecondaryProgress(100);
        this.ezX.addView(this.ezY, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.ezZ = new TextView(getContext());
        this.ezZ.setTextColor(-1);
        this.ezZ.setText(c.d.laoding);
        this.ezZ.setGravity(1);
        this.ezX.addView(this.ezZ, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.eAc = aVar;
        if (this.ezT != null) {
            this.ezT.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.ezR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.ezR != i) {
            this.ezR = i;
            if (this.ezT != null) {
                this.ezT.bgs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.ezX.setVisibility(0);
        } else {
            this.ezX.setVisibility(8);
        }
    }

    private void bfQ() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eAa != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.eAa.getView();
            this.eAa.b(this.eAj);
            this.eAa.release();
            this.eAa = null;
            this.eAb.removeView(view);
        }
        if (aVar != null) {
            this.eAa = aVar;
            aVar.setAspectRatio(this.ezQ);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.eAa.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eAb.addView(view2);
            this.eAa.a(this.eAj);
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
                    this.ezS = false;
                    this.eAg.onError(this.mMediaPlayer, 1, 0);
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
            bfT();
            this.ezS = false;
        }
    }

    public void bfR() {
        try {
            this.mMediaPlayer = bfS();
            this.mMediaPlayer.setOnPreparedListener(this.eAd);
            this.mMediaPlayer.setOnCompletionListener(this.eAe);
            this.mMediaPlayer.setOnErrorListener(this.eAg);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.eAh);
            this.mMediaPlayer.setOnSeekCompleteListener(this.eAi);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.eAf);
            this.ezU = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.ezS = false;
            this.eAg.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bfS() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.ben);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.ben = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.ben);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.mMute = z;
            if (this.ezT != null && this.ezW) {
                this.ezT.setMute(this.mMute);
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
        this.ezW = z;
    }

    public void setInitPlayPosition(int i) {
        this.ezV = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.ezV);
            this.ezV = -1;
        }
    }

    public void release() {
        bfT();
        this.ezS = false;
        if (this.eAa != null) {
            this.eAa.release();
        }
        if (this.ezT != null) {
            this.ezT.setToggleScreenListener(null);
            this.ezT.i(null);
            this.ezT = null;
        }
        if (this.eAc != null) {
            this.eAc = null;
        }
    }

    private void bfT() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.eAc != null) {
            this.eAc = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.ezR == -1 || this.ezR == 5) {
                if (this.ezR == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.eAc != null) {
                    if (this.ezR == 4) {
                        this.eAc.onResume();
                    } else {
                        this.eAc.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.ezS = true;
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
        this.ezS = false;
        if (this.eAc != null) {
            this.eAc.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.ezU;
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
        return (this.mMediaPlayer == null || this.ezR == -1 || this.ezR == 0 || this.ezR == 1) ? false : true;
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
                this.ezQ = 0;
            } else if (i == 2) {
                this.ezQ = 1;
            } else {
                this.ezQ = 3;
            }
            if (this.eAa != null) {
                this.eAa.setAspectRatio(this.ezQ);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.eAa != null) {
            return this.eAa.getBitmap();
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
        return this.eAc;
    }
}
