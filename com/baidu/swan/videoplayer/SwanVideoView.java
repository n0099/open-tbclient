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
/* loaded from: classes3.dex */
public class SwanVideoView extends FrameLayout {
    private boolean bfX;
    private int cvb;
    private int eCA;
    private boolean eCB;
    private RelativeLayout eCC;
    private ProgressBar eCD;
    private TextView eCE;
    private a eCF;
    private FrameLayout eCG;
    private com.baidu.swan.videoplayer.a.a eCH;
    MediaPlayer.OnPreparedListener eCI;
    private MediaPlayer.OnCompletionListener eCJ;
    private MediaPlayer.OnVideoSizeChangedListener eCK;
    private MediaPlayer.OnErrorListener eCL;
    private MediaPlayer.OnBufferingUpdateListener eCM;
    private MediaPlayer.OnSeekCompleteListener eCN;
    a.InterfaceC0565a eCO;
    private int eCw;
    private boolean eCx;
    private MediaController eCy;
    private int eCz;
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
        if (this.eCy != null) {
            this.eCy.iT(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.cvb = 0;
        this.eCA = -1;
        this.eCB = true;
        this.eCw = 0;
        this.eCI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eCF != null) {
                    SwanVideoView.this.eCF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.eCx) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eCJ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eCx = false;
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onEnd();
                }
            }
        };
        this.eCK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eCF != null) {
                        SwanVideoView.this.eCF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eCH != null) {
                        SwanVideoView.this.eCH.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eCL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eCx = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onError(i, i2, null);
                }
                return SwanVideoView.this.eCH != null;
            }
        };
        this.eCM = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.eCz = i;
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.eCy != null) {
                    SwanVideoView.this.eCy.oa((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eCN = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onSeekEnd();
                }
            }
        };
        this.eCO = new a.InterfaceC0565a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bjs() == SwanVideoView.this.eCF && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar) {
            }
        };
        eN(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvb = 0;
        this.eCA = -1;
        this.eCB = true;
        this.eCw = 0;
        this.eCI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eCF != null) {
                    SwanVideoView.this.eCF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.eCx) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eCJ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eCx = false;
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onEnd();
                }
            }
        };
        this.eCK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eCF != null) {
                        SwanVideoView.this.eCF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eCH != null) {
                        SwanVideoView.this.eCH.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eCL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eCx = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onError(i, i2, null);
                }
                return SwanVideoView.this.eCH != null;
            }
        };
        this.eCM = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.eCz = i;
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.eCy != null) {
                    SwanVideoView.this.eCy.oa((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eCN = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onSeekEnd();
                }
            }
        };
        this.eCO = new a.InterfaceC0565a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bjs() == SwanVideoView.this.eCF && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar) {
            }
        };
        eN(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvb = 0;
        this.eCA = -1;
        this.eCB = true;
        this.eCw = 0;
        this.eCI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eCF != null) {
                    SwanVideoView.this.eCF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.eCx) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eCJ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eCx = false;
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onEnd();
                }
            }
        };
        this.eCK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eCF != null) {
                        SwanVideoView.this.eCF.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eCH != null) {
                        SwanVideoView.this.eCH.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eCL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + "," + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eCx = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onError(i2, i22, null);
                }
                return SwanVideoView.this.eCH != null;
            }
        };
        this.eCM = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.eCz = i2;
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.eCy != null) {
                    SwanVideoView.this.eCy.oa((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.eCN = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eCH != null) {
                    SwanVideoView.this.eCH.onSeekEnd();
                }
            }
        };
        this.eCO = new a.InterfaceC0565a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bjs() == SwanVideoView.this.eCF && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0565a
            public void a(a.b bVar) {
            }
        };
        eN(context);
    }

    private void eN(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eCG = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eCG.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eCG, layoutParams);
        this.eCy = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eCy.setVisibility(8);
        addView(this.eCy, layoutParams2);
        this.eCy.i(this);
        bjx();
        bjw();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bjv();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bjv() {
        if (this.eCB) {
            if (this.eCy.getVisibility() != 0) {
                this.eCy.bkc();
            } else {
                this.eCy.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bjw() {
        this.eCC = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eCC.setVisibility(8);
        addView(this.eCC, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eCD = new ProgressBar(getContext());
        this.eCD.setId(16908308);
        this.eCD.setMax(100);
        this.eCD.setProgress(10);
        this.eCD.setSecondaryProgress(100);
        this.eCC.addView(this.eCD, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eCE = new TextView(getContext());
        this.eCE.setTextColor(-1);
        this.eCE.setText(c.d.laoding);
        this.eCE.setGravity(1);
        this.eCC.addView(this.eCE, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.eCH = aVar;
        if (this.eCy != null) {
            this.eCy.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.cvb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.cvb != i) {
            this.cvb = i;
            if (this.eCy != null) {
                this.eCy.bjZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eCC.setVisibility(0);
        } else {
            this.eCC.setVisibility(8);
        }
    }

    private void bjx() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eCF != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.eCF.getView();
            this.eCF.b(this.eCO);
            this.eCF.release();
            this.eCF = null;
            this.eCG.removeView(view);
        }
        if (aVar != null) {
            this.eCF = aVar;
            aVar.setAspectRatio(this.eCw);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.eCF.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eCG.addView(view2);
            this.eCF.a(this.eCO);
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
                    this.eCx = false;
                    this.eCL.onError(this.mMediaPlayer, 1, 0);
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
            bjA();
            this.eCx = false;
        }
    }

    public void bjy() {
        try {
            this.mMediaPlayer = bjz();
            this.mMediaPlayer.setOnPreparedListener(this.eCI);
            this.mMediaPlayer.setOnCompletionListener(this.eCJ);
            this.mMediaPlayer.setOnErrorListener(this.eCL);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.eCM);
            this.mMediaPlayer.setOnSeekCompleteListener(this.eCN);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.eCK);
            this.eCz = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.eCx = false;
            this.eCL.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bjz() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.bfX);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.bfX = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.bfX);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.mMute = z;
            if (this.eCy != null && this.eCB) {
                this.eCy.setMute(this.mMute);
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
        this.eCB = z;
    }

    public void setInitPlayPosition(int i) {
        this.eCA = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.eCA);
            this.eCA = -1;
        }
    }

    public void release() {
        bjA();
        this.eCx = false;
        if (this.eCF != null) {
            this.eCF.release();
        }
        if (this.eCy != null) {
            this.eCy.setToggleScreenListener(null);
            this.eCy.i(null);
            this.eCy = null;
        }
        if (this.eCH != null) {
            this.eCH = null;
        }
    }

    private void bjA() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.eCH != null) {
            this.eCH = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.cvb == -1 || this.cvb == 5) {
                if (this.cvb == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.eCH != null) {
                    if (this.cvb == 4) {
                        this.eCH.onResume();
                    } else {
                        this.eCH.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.eCx = true;
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
        this.eCx = false;
        if (this.eCH != null) {
            this.eCH.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.eCz;
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
        return (this.mMediaPlayer == null || this.cvb == -1 || this.cvb == 0 || this.cvb == 1) ? false : true;
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
                this.eCw = 0;
            } else if (i == 2) {
                this.eCw = 1;
            } else {
                this.eCw = 3;
            }
            if (this.eCF != null) {
                this.eCF.setAspectRatio(this.eCw);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.eCF != null) {
            return this.eCF.getBitmap();
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
        return this.eCH;
    }
}
