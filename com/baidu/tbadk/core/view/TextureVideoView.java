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
import java.io.IOException;
/* loaded from: classes.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    private String acB;
    private int acC;
    private int acD;
    private MediaPlayer acE;
    private int acF;
    private int acG;
    private MediaController acH;
    private MediaPlayer.OnCompletionListener acI;
    private MediaPlayer.OnPreparedListener acJ;
    private int acK;
    private MediaPlayer.OnErrorListener acL;
    private int acM;
    private boolean acN;
    private boolean acO;
    private boolean acP;
    private MediaPlayer.OnBufferingUpdateListener acQ;
    private b acR;
    private boolean acS;
    private Surface acT;
    private boolean acU;
    private boolean acV;
    private a acW;
    private TextureView.SurfaceTextureListener acX;
    MediaPlayer.OnVideoSizeChangedListener acY;
    MediaPlayer.OnPreparedListener acZ;
    private MediaPlayer.OnCompletionListener ada;
    private MediaPlayer.OnErrorListener adb;
    private MediaPlayer.OnBufferingUpdateListener adc;
    private SurfaceTexture mSurfaceTexture;
    private int zD;

    /* loaded from: classes.dex */
    public interface a {
        void vu();
    }

    /* loaded from: classes.dex */
    public interface b {
        void vv();
    }

    public TextureVideoView(Context context) {
        super(context);
        this.acC = 0;
        this.acD = 0;
        this.acE = null;
        this.acS = false;
        this.acU = false;
        this.acV = false;
        this.acX = new z(this);
        this.acY = new aa(this);
        this.acZ = new ab(this);
        this.ada = new ac(this);
        this.adb = new ad(this);
        this.adc = new ae(this);
        ad(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        ad(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acC = 0;
        this.acD = 0;
        this.acE = null;
        this.acS = false;
        this.acU = false;
        this.acV = false;
        this.acX = new z(this);
        this.acY = new aa(this);
        this.acZ = new ab(this);
        this.ada = new ac(this);
        this.adb = new ad(this);
        this.adc = new ae(this);
        ad(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.acF, i);
        int defaultSize2 = getDefaultSize(this.acG, i2);
        if (this.acF > 0 && this.acG > 0) {
            if (this.acF * defaultSize2 > this.acG * defaultSize) {
                defaultSize2 = (this.acG * defaultSize) / this.acF;
            } else if (this.acF * defaultSize2 < this.acG * defaultSize) {
                defaultSize = (this.acF * defaultSize2) / this.acG;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    private void ad(Context context) {
        this.acF = 0;
        this.acG = 0;
        setSurfaceTextureListener(this.acX);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.acC = 0;
        this.acD = 0;
    }

    public void setVideoPath(String str) {
        this.acB = str;
        this.acM = 0;
        this.acV = true;
        vq();
        requestLayout();
        invalidate();
    }

    public String getVideoPath() {
        return this.acB;
    }

    public void stopPlayback() {
        if (this.acE != null) {
            at.vE().a(this.acE);
            this.acE = null;
            this.acC = 0;
            this.acD = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq() {
        if (this.acB != null && !this.acB.isEmpty() && this.mSurfaceTexture != null) {
            aH(false);
            try {
                this.acE = new MediaPlayer();
                at.vE().vF();
                this.acE.setOnPreparedListener(this.acZ);
                this.acE.setOnVideoSizeChangedListener(this.acY);
                this.zD = -1;
                this.acE.setOnCompletionListener(this.ada);
                this.acE.setOnErrorListener(this.adb);
                this.acE.setOnBufferingUpdateListener(this.adc);
                this.acK = 0;
                this.acE.setDataSource(this.acB);
                this.acE.setSurface(getSurface());
                this.acE.setAudioStreamType(3);
                this.acE.prepareAsync();
                this.acC = 1;
                vr();
            } catch (IOException e) {
                this.acC = -1;
                this.acD = -1;
                this.adb.onError(this.acE, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.acC = -1;
                this.acD = -1;
                this.adb.onError(this.acE, 1, 0);
            } catch (IllegalStateException e3) {
                this.acC = -1;
                this.acD = -1;
                this.adb.onError(this.acE, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.acH != null) {
            this.acH.hide();
        }
        this.acH = mediaController;
        vr();
    }

    private void vr() {
        if (this.acE != null && this.acH != null) {
            this.acH.setMediaPlayer(this);
            this.acH.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.acH.setEnabled(vt());
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.acJ = onPreparedListener;
    }

    public void setOnBufferUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.acQ = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.acI = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.acL = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        if (this.acE != null) {
            this.acE.reset();
            this.acE.release();
            this.acE = null;
            at.vE().vG();
            this.acC = 0;
            if (z) {
                this.acD = 0;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (vt() && this.acH != null) {
            vs();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (vt() && this.acH != null) {
            vs();
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (vt() && z && this.acH != null) {
            if (i == 79 || i == 85) {
                if (this.acE.isPlaying()) {
                    pause();
                    this.acH.show();
                    return true;
                }
                start();
                this.acH.hide();
                return true;
            } else if (i == 126) {
                if (this.acE.isPlaying()) {
                    return true;
                }
                start();
                this.acH.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (this.acE.isPlaying()) {
                    pause();
                    this.acH.show();
                    return true;
                }
                return true;
            } else {
                vs();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void vs() {
        if (this.acH.isShowing()) {
            this.acH.hide();
        } else {
            this.acH.show();
        }
    }

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.acR = bVar;
    }

    private Surface getSurface() {
        if (this.acT == null || this.acU) {
            this.acT = new Surface(this.mSurfaceTexture);
            this.acU = false;
        }
        return this.acT;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (vt()) {
            this.acE.start();
            this.acC = 3;
        }
        this.acD = 3;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (vt() && this.acE.isPlaying()) {
            this.acE.pause();
            this.acC = 4;
        }
        this.acD = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (vt()) {
            if (this.zD > 0) {
                return this.zD;
            }
            this.zD = this.acE.getDuration();
            return this.zD;
        }
        this.zD = -1;
        return this.zD;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (vt()) {
            return this.acE.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (vt()) {
            this.acE.seekTo(i);
            this.acM = 0;
            return;
        }
        this.acM = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return vt() && this.acE.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.acE != null) {
            return this.acK;
        }
        return 0;
    }

    private boolean vt() {
        return (this.acE == null || this.acC == -1 || this.acC == 0 || this.acC == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.acN;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.acO;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.acP;
    }

    public void setEnableRefresh(boolean z) {
        this.acS = z;
    }

    public void setOnSurfaceAvailableListener(a aVar) {
        this.acW = aVar;
    }
}
