package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import java.io.IOException;
/* loaded from: classes.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl, com.baidu.adp.newwidget.a.i {
    private int Jn;
    private int agM;
    private int agN;
    private String agO;
    private int agP;
    private int agQ;
    private MediaPlayer agR;
    private int agS;
    private int agT;
    private MediaController agU;
    private MediaPlayer.OnCompletionListener agV;
    private MediaPlayer.OnPreparedListener agW;
    private int agX;
    private MediaPlayer.OnErrorListener agY;
    private int agZ;
    private boolean aha;
    private boolean ahb;
    private boolean ahc;
    private MediaPlayer.OnBufferingUpdateListener ahd;
    private a ahe;
    private boolean ahf;
    private Surface ahg;
    private boolean ahh;
    private boolean ahi;
    private TextureView.SurfaceTextureListener ahj;
    MediaPlayer.OnVideoSizeChangedListener ahk;
    MediaPlayer.OnPreparedListener ahl;
    private MediaPlayer.OnCompletionListener ahm;
    private MediaPlayer.OnErrorListener ahn;
    private MediaPlayer.OnBufferingUpdateListener aho;
    private SurfaceTexture mSurfaceTexture;

    /* loaded from: classes.dex */
    public interface a {
        void xF();
    }

    public TextureVideoView(Context context) {
        super(context);
        this.agP = 0;
        this.agQ = 0;
        this.agR = null;
        this.ahf = false;
        this.ahh = false;
        this.ahi = false;
        this.ahj = new x(this);
        this.ahk = new y(this);
        this.ahl = new z(this);
        this.ahm = new aa(this);
        this.ahn = new ab(this);
        this.aho = new ac(this);
        ae(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        ae(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agP = 0;
        this.agQ = 0;
        this.agR = null;
        this.ahf = false;
        this.ahh = false;
        this.ahi = false;
        this.ahj = new x(this);
        this.ahk = new y(this);
        this.ahl = new z(this);
        this.ahm = new aa(this);
        this.ahn = new ab(this);
        this.aho = new ac(this);
        ae(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.agS, i);
        int defaultSize2 = getDefaultSize(this.agT, i2);
        if (this.agS > 0 && this.agT > 0) {
            if (this.agS * defaultSize2 > this.agT * defaultSize) {
                defaultSize2 = (this.agT * defaultSize) / this.agS;
            } else if (this.agS * defaultSize2 < this.agT * defaultSize) {
                defaultSize = (this.agS * defaultSize2) / this.agT;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    private void ae(Context context) {
        this.agS = 0;
        this.agT = 0;
        this.agM = context.getResources().getDimensionPixelSize(t.e.ds240);
        this.agN = context.getResources().getDimensionPixelSize(t.e.ds60);
        setSurfaceTextureListener(this.ahj);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.agP = 0;
        this.agQ = 0;
    }

    public void setVideoPath(String str) {
        this.agO = str;
        this.agZ = 0;
        this.ahi = true;
        xA();
        requestLayout();
        invalidate();
    }

    public void dT(String str) {
        this.agO = str;
        this.agZ = 0;
    }

    public void stopPlayback() {
        if (this.agR != null) {
            ar.xN().a(this.agR);
            this.agR = null;
            this.agP = 0;
            this.agQ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xA() {
        if (this.agO != null && !this.agO.isEmpty() && this.mSurfaceTexture != null) {
            aC(false);
            try {
                this.agR = new MediaPlayer();
                this.agR.setOnPreparedListener(this.ahl);
                this.agR.setOnVideoSizeChangedListener(this.ahk);
                this.Jn = -1;
                this.agR.setOnCompletionListener(this.ahm);
                this.agR.setOnErrorListener(this.ahn);
                this.agR.setOnBufferingUpdateListener(this.aho);
                this.agX = 0;
                this.agR.setDataSource(this.agO);
                this.agR.setSurface(getSurface());
                this.agR.setAudioStreamType(3);
                this.agR.prepareAsync();
                this.agP = 1;
                xB();
            } catch (IOException e) {
                this.agP = -1;
                this.agQ = -1;
                this.ahn.onError(this.agR, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.agP = -1;
                this.agQ = -1;
                this.ahn.onError(this.agR, 1, 0);
            } catch (IllegalStateException e3) {
                this.agP = -1;
                this.agQ = -1;
                this.ahn.onError(this.agR, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.agU != null) {
            this.agU.hide();
        }
        this.agU = mediaController;
        xB();
    }

    private void xB() {
        if (this.agR != null && this.agU != null) {
            this.agU.setMediaPlayer(this);
            this.agU.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.agU.setEnabled(xE());
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.agW = onPreparedListener;
    }

    public void setOnBufferUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.ahd = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.agV = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.agY = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(boolean z) {
        if (this.agR != null) {
            this.agR.reset();
            this.agR.release();
            this.agR = null;
            this.agP = 0;
            if (z) {
                this.agQ = 0;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (xE() && this.agU != null) {
            xC();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (xE() && this.agU != null) {
            xC();
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (xE() && z && this.agU != null) {
            if (i == 79 || i == 85) {
                if (this.agR.isPlaying()) {
                    pause();
                    this.agU.show();
                    return true;
                }
                start();
                this.agU.hide();
                return true;
            } else if (i == 126) {
                if (this.agR.isPlaying()) {
                    return true;
                }
                start();
                this.agU.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (this.agR.isPlaying()) {
                    pause();
                    this.agU.show();
                    return true;
                }
                return true;
            } else {
                xC();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void xC() {
        if (this.agU.isShowing()) {
            this.agU.hide();
        } else {
            this.agU.show();
        }
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.ahe = aVar;
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        if (this.ahf && com.baidu.adp.lib.util.i.jg()) {
            if (xD()) {
                if (!isPlaying() && !StringUtils.isNull(this.agO)) {
                    xA();
                    requestLayout();
                    invalidate();
                    return;
                }
                return;
            }
            stopPlayback();
        }
    }

    public boolean xD() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = iArr[1];
        if (i > 0) {
            int measuredHeight = getMeasuredHeight();
            int i2 = i - this.agM;
            if (i2 > 0 && i2 < measuredHeight + this.agN) {
                return true;
            }
        }
        return false;
    }

    private Surface getSurface() {
        if (this.ahg == null || this.ahh) {
            this.ahg = new Surface(this.mSurfaceTexture);
            this.ahh = false;
        }
        return this.ahg;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (xE()) {
            this.agR.start();
            this.agP = 3;
        }
        this.agQ = 3;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (xE() && this.agR.isPlaying()) {
            this.agR.pause();
            this.agP = 4;
        }
        this.agQ = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (xE()) {
            if (this.Jn > 0) {
                return this.Jn;
            }
            this.Jn = this.agR.getDuration();
            return this.Jn;
        }
        this.Jn = -1;
        return this.Jn;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (xE()) {
            return this.agR.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (xE()) {
            this.agR.seekTo(i);
            this.agZ = 0;
            return;
        }
        this.agZ = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return xE() && this.agR.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.agR != null) {
            return this.agX;
        }
        return 0;
    }

    private boolean xE() {
        return (this.agR == null || this.agP == -1 || this.agP == 0 || this.agP == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.aha;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.ahb;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.ahc;
    }

    public void setEnableRefresh(boolean z) {
        this.ahf = z;
    }
}
