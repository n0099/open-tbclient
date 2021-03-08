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
    private boolean bfQ;
    private TextView eBA;
    private a eBB;
    private FrameLayout eBC;
    private com.baidu.swan.videoplayer.a.a eBD;
    MediaPlayer.OnPreparedListener eBE;
    private MediaPlayer.OnCompletionListener eBF;
    private MediaPlayer.OnVideoSizeChangedListener eBG;
    private MediaPlayer.OnErrorListener eBH;
    private MediaPlayer.OnBufferingUpdateListener eBI;
    private MediaPlayer.OnSeekCompleteListener eBJ;
    a.InterfaceC0551a eBK;
    private int eBr;
    private int eBs;
    private boolean eBt;
    private MediaController eBu;
    private int eBv;
    private int eBw;
    private boolean eBx;
    private RelativeLayout eBy;
    private ProgressBar eBz;
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
        if (this.eBu != null) {
            this.eBu.iR(z);
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.eBs = 0;
        this.eBw = -1;
        this.eBx = true;
        this.eBr = 0;
        this.eBE = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eBB != null) {
                    SwanVideoView.this.eBB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.eBt) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eBF = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eBt = false;
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onEnd();
                }
            }
        };
        this.eBG = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eBB != null) {
                        SwanVideoView.this.eBB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eBD != null) {
                        SwanVideoView.this.eBD.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eBH = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eBt = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onError(i, i2, null);
                }
                return SwanVideoView.this.eBD != null;
            }
        };
        this.eBI = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.eBv = i;
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.eBu != null) {
                    SwanVideoView.this.eBu.my((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eBJ = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onSeekEnd();
                }
            }
        };
        this.eBK = new a.InterfaceC0551a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bfN() == SwanVideoView.this.eBB && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar) {
            }
        };
        eK(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eBs = 0;
        this.eBw = -1;
        this.eBx = true;
        this.eBr = 0;
        this.eBE = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eBB != null) {
                    SwanVideoView.this.eBB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.eBt) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eBF = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eBt = false;
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onEnd();
                }
            }
        };
        this.eBG = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eBB != null) {
                        SwanVideoView.this.eBB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eBD != null) {
                        SwanVideoView.this.eBD.onVideoSizeChanged(i, i2);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eBH = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eBt = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onError(i, i2, null);
                }
                return SwanVideoView.this.eBD != null;
            }
        };
        this.eBI = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                SwanVideoView.this.eBv = i;
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onBufferingUpdate(i);
                }
                if (SwanVideoView.this.eBu != null) {
                    SwanVideoView.this.eBu.my((SwanVideoView.this.getDuration() * i) / 100);
                }
            }
        };
        this.eBJ = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onSeekEnd();
                }
            }
        };
        this.eBK = new a.InterfaceC0551a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bfN() == SwanVideoView.this.eBB && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar) {
            }
        };
        eK(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBs = 0;
        this.eBw = -1;
        this.eBx = true;
        this.eBr = 0;
        this.eBE = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.eBB != null) {
                    SwanVideoView.this.eBB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                }
                if (SwanVideoView.this.eBt) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eBF = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eBt = false;
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onEnd();
                }
            }
        };
        this.eBG = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                SwanVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                SwanVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0) {
                    if (SwanVideoView.this.eBB != null) {
                        SwanVideoView.this.eBB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    }
                    if (SwanVideoView.this.eBD != null) {
                        SwanVideoView.this.eBD.onVideoSizeChanged(i2, i22);
                    }
                    SwanVideoView.this.requestLayout();
                }
            }
        };
        this.eBH = new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + "," + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eBt = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onError(i2, i22, null);
                }
                return SwanVideoView.this.eBD != null;
            }
        };
        this.eBI = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                SwanVideoView.this.eBv = i2;
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onBufferingUpdate(i2);
                }
                if (SwanVideoView.this.eBu != null) {
                    SwanVideoView.this.eBu.my((SwanVideoView.this.getDuration() * i2) / 100);
                }
            }
        };
        this.eBJ = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.SwanVideoView.6
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eBD != null) {
                    SwanVideoView.this.eBD.onSeekEnd();
                }
            }
        };
        this.eBK = new a.InterfaceC0551a() { // from class: com.baidu.swan.videoplayer.SwanVideoView.7
            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bfN() == SwanVideoView.this.eBB && SwanVideoView.this.mMediaPlayer != null) {
                    SwanVideoView.this.a(SwanVideoView.this.mMediaPlayer, bVar);
                }
            }

            @Override // com.baidu.swan.videoplayer.a.InterfaceC0551a
            public void a(a.b bVar) {
            }
        };
        eK(context);
    }

    private void eK(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eBC = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eBC.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eBC, layoutParams);
        this.eBu = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eBu.setVisibility(8);
        addView(this.eBu, layoutParams2);
        this.eBu.i(this);
        bfS();
        bfR();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            bfQ();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bfQ() {
        if (this.eBx) {
            if (this.eBu.getVisibility() != 0) {
                this.eBu.bgx();
            } else {
                this.eBu.hide();
            }
        }
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    private void bfR() {
        this.eBy = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eBy.setVisibility(8);
        addView(this.eBy, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eBz = new ProgressBar(getContext());
        this.eBz.setId(16908308);
        this.eBz.setMax(100);
        this.eBz.setProgress(10);
        this.eBz.setSecondaryProgress(100);
        this.eBy.addView(this.eBz, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eBA = new TextView(getContext());
        this.eBA.setTextColor(-1);
        this.eBA.setText(c.d.laoding);
        this.eBA.setGravity(1);
        this.eBy.addView(this.eBA, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.swan.videoplayer.a.a aVar) {
        this.eBD = aVar;
        if (this.eBu != null) {
            this.eBu.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.eBs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.eBs != i) {
            this.eBs = i;
            if (this.eBu != null) {
                this.eBu.bgu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eBy.setVisibility(0);
        } else {
            this.eBy.setVisibility(8);
        }
    }

    private void bfS() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eBB != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.eBB.getView();
            this.eBB.b(this.eBK);
            this.eBB.release();
            this.eBB = null;
            this.eBC.removeView(view);
        }
        if (aVar != null) {
            this.eBB = aVar;
            aVar.setAspectRatio(this.eBr);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            View view2 = this.eBB.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eBC.addView(view2);
            this.eBB.a(this.eBK);
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
                    this.eBt = false;
                    this.eBH.onError(this.mMediaPlayer, 1, 0);
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
            bfV();
            this.eBt = false;
        }
    }

    public void bfT() {
        try {
            this.mMediaPlayer = bfU();
            this.mMediaPlayer.setOnPreparedListener(this.eBE);
            this.mMediaPlayer.setOnCompletionListener(this.eBF);
            this.mMediaPlayer.setOnErrorListener(this.eBH);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.eBI);
            this.mMediaPlayer.setOnSeekCompleteListener(this.eBJ);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.eBG);
            this.eBv = 0;
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException e) {
            setCurrentState(-1);
            this.eBt = false;
            this.eBH.onError(this.mMediaPlayer, 1, 0);
        }
    }

    public MediaPlayer bfU() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.bfQ);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public void setLooping(boolean z) {
        this.bfQ = z;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(this.bfQ);
        }
    }

    public void setMuted(boolean z) {
        if (this.mMediaPlayer != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.mMute = z;
            if (this.eBu != null && this.eBx) {
                this.eBu.setMute(this.mMute);
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
        this.eBx = z;
    }

    public void setInitPlayPosition(int i) {
        this.eBw = i;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(this.eBw);
            this.eBw = -1;
        }
    }

    public void release() {
        bfV();
        this.eBt = false;
        if (this.eBB != null) {
            this.eBB.release();
        }
        if (this.eBu != null) {
            this.eBu.setToggleScreenListener(null);
            this.eBu.i(null);
            this.eBu = null;
        }
        if (this.eBD != null) {
            this.eBD = null;
        }
    }

    private void bfV() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDisplay(null);
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setCurrentState(0);
        }
        if (this.eBD != null) {
            this.eBD = null;
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            if (this.eBs == -1 || this.eBs == 5) {
                if (this.eBs == 5) {
                    this.mMediaPlayer.stop();
                }
                restart();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                if (this.eBD != null) {
                    if (this.eBs == 4) {
                        this.eBD.onResume();
                    } else {
                        this.eBD.onStart();
                    }
                }
                this.mMediaPlayer.start();
                setCurrentState(3);
            }
            this.eBt = true;
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
        this.eBt = false;
        if (this.eBD != null) {
            this.eBD.onPause();
        }
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.eBv;
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
        return (this.mMediaPlayer == null || this.eBs == -1 || this.eBs == 0 || this.eBs == 1) ? false : true;
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
                this.eBr = 0;
            } else if (i == 2) {
                this.eBr = 1;
            } else {
                this.eBr = 3;
            }
            if (this.eBB != null) {
                this.eBB.setAspectRatio(this.eBr);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public Bitmap getBitmap() {
        if (this.eBB != null) {
            return this.eBB.getBitmap();
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
        return this.eBD;
    }
}
