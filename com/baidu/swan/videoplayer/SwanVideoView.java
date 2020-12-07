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
import java.io.IOException;
import java.util.Map;
/* loaded from: classes6.dex */
public class SwanVideoView extends FrameLayout {
    private boolean bel;
    private int cnU;
    private boolean dkd;
    private int esO;
    private boolean esP;
    private MediaController esQ;
    private int esR;
    private int esS;
    private boolean esT;
    private RelativeLayout esU;
    private ProgressBar esV;
    private TextView esW;
    private a esX;
    private FrameLayout esY;
    private com.baidu.swan.videoplayer.a.a esZ;
    MediaPlayer.OnPreparedListener eta;
    private MediaPlayer.OnCompletionListener etb;
    private MediaPlayer.OnVideoSizeChangedListener etd;
    private MediaPlayer.OnErrorListener ete;
    private MediaPlayer.OnBufferingUpdateListener etf;
    private MediaPlayer.OnSeekCompleteListener etg;
    a.InterfaceC0574a eth;
    private Context mAppContext;
    private Map<String, String> mHeaders;
    private boolean mIsLandscape;
    private MediaPlayer mMediaPlayer;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        if (this.esQ != null) {
            this.esQ.iy(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.cnU = 0;
        this.esS = -1;
        this.esT = true;
        this.esO = 0;
        this.eta = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.esX != null) {
                    SwanVideoView.this.esX.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.esP) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.etb = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.esP = false;
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onEnd();
                }
            }
        };
        this.etd = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.esX != null) {
                        SwanVideoView.this.esX.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.esZ != null) {
                        SwanVideoView.this.esZ.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.ete = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.esP = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onError(i, i2, null);
                }
                return SwanVideoView.this.esZ != null;
            }
        };
        this.etf = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.esR = i;
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.esQ != null) {
                    SwanVideoView.this.esQ.nR((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.etg = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onSeekEnd();
                }
            }
        };
        this.eth = new a.InterfaceC0574a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bgU() == SwanVideoView.this.esX && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar) {
            }
        };
        eu(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnU = 0;
        this.esS = -1;
        this.esT = true;
        this.esO = 0;
        this.eta = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.esX != null) {
                    SwanVideoView.this.esX.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.esP) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.etb = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.esP = false;
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onEnd();
                }
            }
        };
        this.etd = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.esX != null) {
                        SwanVideoView.this.esX.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.esZ != null) {
                        SwanVideoView.this.esZ.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.ete = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.esP = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onError(i, i2, null);
                }
                return SwanVideoView.this.esZ != null;
            }
        };
        this.etf = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.esR = i;
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.esQ != null) {
                    SwanVideoView.this.esQ.nR((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.etg = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onSeekEnd();
                }
            }
        };
        this.eth = new a.InterfaceC0574a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bgU() == SwanVideoView.this.esX && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar) {
            }
        };
        eu(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cnU = 0;
        this.esS = -1;
        this.esT = true;
        this.esO = 0;
        this.eta = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.esX != null) {
                    SwanVideoView.this.esX.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.esP) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.etb = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.esP = false;
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onEnd();
                }
            }
        };
        this.etd = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.esX != null) {
                        SwanVideoView.this.esX.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.esZ != null) {
                        SwanVideoView.this.esZ.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.ete = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + "," + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.esP = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onError(i2, i22, null);
                }
                return SwanVideoView.this.esZ != null;
            }
        };
        this.etf = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.esR = i2;
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.esQ != null) {
                    SwanVideoView.this.esQ.nR((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.etg = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.esZ != null) {
                    SwanVideoView.this.esZ.onSeekEnd();
                }
            }
        };
        this.eth = new a.InterfaceC0574a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bgU() == SwanVideoView.this.esX && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0574a
            public void a(a.b bVar) {
            }
        };
        eu(context);
    }

    private void eu(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.esY = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.esY.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.esY, layoutParams);
        this.esQ = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.esQ.setVisibility(8);
        addView(this.esQ, layoutParams2);
        this.esQ.i(this);
        bgZ();
        bgY();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bgX();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bgX() {
        if (this.esT) {
            if (this.esQ.getVisibility() != 0) {
                this.esQ.bhF();
            } else {
                this.esQ.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bgY() {
        this.esU = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.esU.setVisibility(8);
        addView(this.esU, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.esV = new ProgressBar(getContext());
        this.esV.setId(16908308);
        this.esV.setMax(100);
        this.esV.setProgress(10);
        this.esV.setSecondaryProgress(100);
        this.esU.addView(this.esV, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.esW = new TextView(getContext());
        this.esW.setTextColor(-1);
        this.esW.setText(c.d.laoding);
        this.esW.setGravity(1);
        this.esU.addView(this.esW, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.esZ = aVar;
        if (this.esQ != null) {
            this.esQ.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.cnU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.cnU != i) {
            this.cnU = i;
            if (this.esQ != null) {
                this.esQ.bhC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.esU.setVisibility(0);
        } else {
            this.esU.setVisibility(8);
        }
    }

    private void bgZ() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.esX != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.esX.getView();
            this.esX.b(this.eth);
            this.esX.release();
            this.esX = null;
            this.esY.removeView(view);
        }
        if (aVar != null) {
            this.esX = aVar;
            aVar.setAspectRatio(this.esO);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.esX.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.esY.addView(view2);
            this.esX.a(this.eth);
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
                    this.esP = false;
                    this.ete.onError(this.mMediaPlayer, 1, 0);
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
            bhc();
            this.esP = false;
        }
    }

    public void bha() {
        try {
            this.mMediaPlayer = bhb();
            this.mMediaPlayer.setOnPreparedListener(this.eta);
            this.mMediaPlayer.setOnCompletionListener(this.etb);
            this.mMediaPlayer.setOnErrorListener(this.ete);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.etf);
            this.mMediaPlayer.setOnSeekCompleteListener(this.etg);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.etd);
            this.esR = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.esP = false;
            this.ete.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bhb() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.bel);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.bel = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.bel);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.dkd = z;
            if (this.esQ != null && this.esT) {
                this.esQ.setMute(this.dkd);
            }
        }
    }

    public boolean isMute() {
        return this.dkd;
    }

    public void setVolume(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.esT = z;
    }

    public void setInitPlayPosition(int i) {
        this.esS = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.esS);
            this.esS = -1;
        }
    }

    public void release() {
        bhc();
        this.esP = false;
        if (this.esX != null) {
            this.esX.release();
        }
        if (this.esQ != null) {
            this.esQ.setToggleScreenListener(null);
            this.esQ.i(null);
            this.esQ = null;
        }
        if (this.esZ != null) {
            this.esZ = null;
        }
    }

    private void bhc() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.esZ != null) {
            this.esZ = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.cnU == -1 || this.cnU == 5) {
                if (this.cnU == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.esZ != null) {
                    if (this.cnU == 4) {
                        this.esZ.onResume();
                    } else {
                        this.esZ.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.esP = true;
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
        this.esP = false;
        if (this.esZ != null) {
            this.esZ.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.esR;
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
        return (this.mMediaPlayer == null || this.cnU == -1 || this.cnU == 0 || this.cnU == 1) ? false : true;
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
                this.esO = 0;
            } else if (i == 2) {
                this.esO = 1;
            } else {
                this.esO = 3;
            }
            if (this.esX != null) {
                this.esX.setAspectRatio(this.esO);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.esX != null) {
            return this.esX.getBitmap();
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
        return this.esZ;
    }
}
