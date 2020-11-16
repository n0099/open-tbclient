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
/* loaded from: classes6.dex */
public class SwanVideoView extends FrameLayout {
    private int chm;
    private boolean ddd;
    private int elM;
    private boolean elN;
    private MediaController elO;
    private int elP;
    private int elQ;
    private boolean elR;
    private boolean elS;
    private RelativeLayout elT;
    private ProgressBar elU;
    private TextView elV;
    private a elW;
    private FrameLayout elX;
    private com.baidu.swan.videoplayer.a.a elY;
    MediaPlayer.OnPreparedListener elZ;
    private MediaPlayer.OnCompletionListener ema;
    private MediaPlayer.OnVideoSizeChangedListener emb;
    private MediaPlayer.OnErrorListener emc;
    private MediaPlayer.OnBufferingUpdateListener emd;
    private MediaPlayer.OnSeekCompleteListener eme;
    a.InterfaceC0562a emf;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.elO != null) {
            this.elO.ij(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.chm = 0;
        this.elQ = -1;
        this.elS = true;
        this.elM = 0;
        this.elZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.elW != null) {
                    SwanVideoView.this.elW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.elN) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.ema = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.elN = false;
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onEnd();
                }
            }
        };
        this.emb = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.elW != null) {
                        SwanVideoView.this.elW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.elY != null) {
                        SwanVideoView.this.elY.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.emc = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.elN = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onError(i, i2, null);
                }
                return SwanVideoView.this.elY != null;
            }
        };
        this.emd = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.elP = i;
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.elO != null) {
                    SwanVideoView.this.elO.nt((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eme = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onSeekEnd();
                }
            }
        };
        this.emf = new a.InterfaceC0562a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bdP() == SwanVideoView.this.elW && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.chm = 0;
        this.elQ = -1;
        this.elS = true;
        this.elM = 0;
        this.elZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.elW != null) {
                    SwanVideoView.this.elW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.elN) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.ema = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.elN = false;
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onEnd();
                }
            }
        };
        this.emb = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.elW != null) {
                        SwanVideoView.this.elW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.elY != null) {
                        SwanVideoView.this.elY.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.emc = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.elN = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onError(i, i2, null);
                }
                return SwanVideoView.this.elY != null;
            }
        };
        this.emd = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.elP = i;
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.elO != null) {
                    SwanVideoView.this.elO.nt((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eme = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onSeekEnd();
                }
            }
        };
        this.emf = new a.InterfaceC0562a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bdP() == SwanVideoView.this.elW && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.chm = 0;
        this.elQ = -1;
        this.elS = true;
        this.elM = 0;
        this.elZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.elW != null) {
                    SwanVideoView.this.elW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.elN) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.ema = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.elN = false;
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onEnd();
                }
            }
        };
        this.emb = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.elW != null) {
                        SwanVideoView.this.elW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.elY != null) {
                        SwanVideoView.this.elY.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.emc = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.elN = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onError(i2, i22, null);
                }
                return SwanVideoView.this.elY != null;
            }
        };
        this.emd = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.elP = i2;
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.elO != null) {
                    SwanVideoView.this.elO.nt((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.eme = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.elY != null) {
                    SwanVideoView.this.elY.onSeekEnd();
                }
            }
        };
        this.emf = new a.InterfaceC0562a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bdP() == SwanVideoView.this.elW && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0562a
            public void a(a.b bVar) {
            }
        };
        dP(context);
    }

    private void dP(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.elX = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.elX.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.elX, layoutParams);
        this.elO = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.elO.setVisibility(8);
        addView(this.elO, layoutParams2);
        this.elO.i(this);
        bdU();
        bdT();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bdS();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bdS() {
        if (this.elS) {
            if (this.elO.getVisibility() != 0) {
                this.elO.beA();
            } else {
                this.elO.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bdT() {
        this.elT = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.elT.setVisibility(8);
        addView(this.elT, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.elU = new ProgressBar(getContext());
        this.elU.setId(16908308);
        this.elU.setMax(100);
        this.elU.setProgress(10);
        this.elU.setSecondaryProgress(100);
        this.elT.addView(this.elU, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.elV = new TextView(getContext());
        this.elV.setTextColor(-1);
        this.elV.setText(c.d.laoding);
        this.elV.setGravity(1);
        this.elT.addView(this.elV, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.elY = aVar;
        if (this.elO != null) {
            this.elO.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.chm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.chm != i) {
            this.chm = i;
            if (this.elO != null) {
                this.elO.bex();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.elT.setVisibility(0);
        } else {
            this.elT.setVisibility(8);
        }
    }

    private void bdU() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.elW != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.elW.getView();
            this.elW.b(this.emf);
            this.elW.release();
            this.elW = null;
            this.elX.removeView(view);
        }
        if (aVar != null) {
            this.elW = aVar;
            aVar.setAspectRatio(this.elM);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.elW.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.elX.addView(view2);
            this.elW.a(this.emf);
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
                    this.elN = false;
                    this.emc.onError(this.mMediaPlayer, 1, 0);
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
            bdX();
            this.elN = false;
        }
    }

    public void bdV() {
        try {
            this.mMediaPlayer = bdW();
            this.mMediaPlayer.setOnPreparedListener(this.elZ);
            this.mMediaPlayer.setOnCompletionListener(this.ema);
            this.mMediaPlayer.setOnErrorListener(this.emc);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.emd);
            this.mMediaPlayer.setOnSeekCompleteListener(this.eme);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.emb);
            this.elP = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.elN = false;
            this.emc.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bdW() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.elR);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.elR = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.elR);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.ddd = z;
            if (this.elO != null && this.elS) {
                this.elO.setMute(this.ddd);
            }
        }
    }

    public boolean isMute() {
        return this.ddd;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.elS = z;
    }

    public void setInitPlayPosition(int i) {
        this.elQ = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.elQ);
            this.elQ = -1;
        }
    }

    public void release() {
        bdX();
        this.elN = false;
        if (this.elW != null) {
            this.elW.release();
        }
        if (this.elO != null) {
            this.elO.setToggleScreenListener(null);
            this.elO.i(null);
            this.elO = null;
        }
        if (this.elY != null) {
            this.elY = null;
        }
    }

    private void bdX() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.elY != null) {
            this.elY = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.chm == -1 || this.chm == 5) {
                if (this.chm == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.elY != null) {
                    if (this.chm == 4) {
                        this.elY.onResume();
                    } else {
                        this.elY.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.elN = true;
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
        this.elN = false;
        if (this.elY != null) {
            this.elY.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.elP;
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
        return (this.mMediaPlayer == null || this.chm == -1 || this.chm == 0 || this.chm == 1) ? false : true;
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
                this.elM = 0;
            } else if (i == 2) {
                this.elM = 1;
            } else {
                this.elM = 3;
            }
            if (this.elW != null) {
                this.elW.setAspectRatio(this.elM);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.elW != null) {
            return this.elW.getBitmap();
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
        return this.elY;
    }
}
