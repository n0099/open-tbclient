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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.io.IOException;
/* loaded from: classes.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    private String acW;
    private int acX;
    private int acY;
    private MediaPlayer acZ;
    private MediaPlayer.OnErrorListener adA;
    private MediaPlayer.OnBufferingUpdateListener adB;
    private int ada;
    private int adb;
    private MediaController adc;
    private MediaPlayer.OnCompletionListener ade;
    private MediaPlayer.OnPreparedListener adf;
    private int adg;
    private MediaPlayer.OnErrorListener adh;
    private int adi;
    private boolean adj;
    private boolean adk;
    private boolean adl;
    private MediaPlayer.OnBufferingUpdateListener adm;
    private b adn;
    private boolean ado;
    private Surface adp;
    private boolean adq;
    private boolean adr;
    private boolean ads;
    private boolean adt;
    private a adu;
    private boolean adv;
    private TextureView.SurfaceTextureListener adw;
    MediaPlayer.OnVideoSizeChangedListener adx;
    MediaPlayer.OnPreparedListener ady;
    private MediaPlayer.OnCompletionListener adz;
    private SurfaceTexture mSurfaceTexture;
    private long startTime;
    private int zC;

    /* loaded from: classes.dex */
    public interface a {
        void vw();
    }

    /* loaded from: classes.dex */
    public interface b {
        void vx();
    }

    public TextureVideoView(Context context) {
        super(context);
        this.acX = 0;
        this.acY = 0;
        this.acZ = null;
        this.ado = false;
        this.adq = false;
        this.adr = false;
        this.ads = false;
        this.adt = true;
        this.startTime = 0L;
        this.adv = false;
        this.adw = new z(this);
        this.adx = new aa(this);
        this.ady = new ab(this);
        this.adz = new ac(this);
        this.adA = new ad(this);
        this.adB = new ae(this);
        ac(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        ac(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acX = 0;
        this.acY = 0;
        this.acZ = null;
        this.ado = false;
        this.adq = false;
        this.adr = false;
        this.ads = false;
        this.adt = true;
        this.startTime = 0L;
        this.adv = false;
        this.adw = new z(this);
        this.adx = new aa(this);
        this.ady = new ab(this);
        this.adz = new ac(this);
        this.adA = new ad(this);
        this.adB = new ae(this);
        ac(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.ada, i);
        int defaultSize2 = getDefaultSize(this.adb, i2);
        if (this.ada > 0 && this.adb > 0) {
            if (this.ada * defaultSize2 > this.adb * defaultSize) {
                defaultSize2 = (this.adb * defaultSize) / this.ada;
            } else if (this.ada * defaultSize2 < this.adb * defaultSize) {
                defaultSize = (this.ada * defaultSize2) / this.adb;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    private void ac(Context context) {
        this.ada = 0;
        this.adb = 0;
        setSurfaceTextureListener(this.adw);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.acX = 0;
        this.acY = 0;
    }

    public void u(String str, int i) {
        this.acW = v(str, i);
        this.adi = 0;
        this.adr = true;
        vs();
        requestLayout();
        invalidate();
    }

    public void setVideoPath(String str) {
        this.acW = str;
        this.adi = 0;
        this.adr = true;
        vs();
        requestLayout();
        invalidate();
    }

    private String v(String str, int i) {
        if (!this.adt) {
            this.ads = false;
            return str;
        } else if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL) == null) {
            this.ads = false;
            return str;
        } else {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
            if (runTask != null) {
                this.ads = true;
                return (String) runTask.getData();
            }
            if (i < 180) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_VIDEO_CACHE_DOWNLOAD, str));
            }
            this.ads = false;
            return str;
        }
    }

    public boolean vq() {
        return this.ads;
    }

    public String getVideoPath() {
        return this.acW;
    }

    public void setAutoDownload(boolean z) {
        this.adt = z;
    }

    public void vr() {
        at.vG().q(this);
        if (this.startTime > 0) {
            long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
            if (currentTimeMillis > 0) {
                ay ayVar = new ay("c11244");
                ayVar.g("obj_duration", currentTimeMillis);
                TiebaStatic.log(ayVar);
            }
            this.startTime = 0L;
        }
    }

    public void stopPlayback() {
        if (!this.adv) {
            this.adv = true;
            if (this.startTime > 0) {
                long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
                if (currentTimeMillis > 0) {
                    ay ayVar = new ay("c11244");
                    ayVar.g("obj_duration", currentTimeMillis);
                    TiebaStatic.log(ayVar);
                }
                this.startTime = 0L;
            }
            if (this.acZ != null) {
                this.acZ.reset();
                this.acZ.release();
                this.acZ = null;
                this.acX = 0;
                this.acY = 0;
                at.vG().vI();
            }
            this.adv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs() {
        if (this.acW != null && !this.acW.isEmpty() && this.mSurfaceTexture != null && !this.adv) {
            stopPlayback();
            try {
                this.acZ = new MediaPlayer();
                at.vG().vH();
                this.acZ.setOnPreparedListener(this.ady);
                this.acZ.setOnVideoSizeChangedListener(this.adx);
                this.zC = -1;
                this.acZ.setOnCompletionListener(this.adz);
                this.acZ.setOnErrorListener(this.adA);
                this.acZ.setOnBufferingUpdateListener(this.adB);
                this.adg = 0;
                this.acZ.setDataSource(this.acW);
                this.acZ.setSurface(getSurface());
                this.acZ.setAudioStreamType(3);
                this.acZ.prepareAsync();
                this.acX = 1;
                vt();
            } catch (IOException e) {
                this.acX = -1;
                this.acY = -1;
                this.adA.onError(this.acZ, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.acX = -1;
                this.acY = -1;
                this.adA.onError(this.acZ, 1, 0);
            } catch (IllegalStateException e3) {
                this.acX = -1;
                this.acY = -1;
                this.adA.onError(this.acZ, 1, 0);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.adc != null) {
            this.adc.hide();
        }
        this.adc = mediaController;
        vt();
    }

    private void vt() {
        if (this.acZ != null && this.adc != null) {
            this.adc.setMediaPlayer(this);
            this.adc.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.adc.setEnabled(vv());
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.adf = onPreparedListener;
    }

    public void setOnBufferUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.adm = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.ade = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.adh = onErrorListener;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (vv() && this.adc != null) {
            vu();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (vv() && this.adc != null) {
            vu();
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (vv() && z && this.adc != null) {
            if (i == 79 || i == 85) {
                if (this.acZ.isPlaying()) {
                    pause();
                    this.adc.show();
                    return true;
                }
                start();
                this.adc.hide();
                return true;
            } else if (i == 126) {
                if (this.acZ.isPlaying()) {
                    return true;
                }
                start();
                this.adc.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (this.acZ.isPlaying()) {
                    pause();
                    this.adc.show();
                    return true;
                }
                return true;
            } else {
                vu();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void vu() {
        if (this.adc.isShowing()) {
            this.adc.hide();
        } else {
            this.adc.show();
        }
    }

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.adn = bVar;
    }

    private Surface getSurface() {
        if (this.adp == null || this.adq) {
            this.adp = new Surface(this.mSurfaceTexture);
            this.adq = false;
        }
        return this.adp;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (vv()) {
            try {
                this.acZ.start();
                this.acX = 3;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.acY = 3;
        this.startTime = System.currentTimeMillis();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (vv() && this.acZ.isPlaying()) {
            this.acZ.pause();
            this.acX = 4;
        }
        this.acY = 4;
        long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
        if (currentTimeMillis > 0) {
            ay ayVar = new ay("c11244");
            ayVar.g("obj_duration", currentTimeMillis);
            TiebaStatic.log(ayVar);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (vv()) {
            if (this.zC > 0) {
                return this.zC;
            }
            try {
                this.zC = this.acZ.getDuration();
            } catch (Exception e) {
                BdLog.e(e);
            }
            return this.zC;
        }
        this.zC = -1;
        return this.zC;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (vv()) {
            return this.acZ.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (vv()) {
            this.acZ.seekTo(i);
            this.adi = 0;
            return;
        }
        this.adi = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return vv() && this.acZ.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.acZ != null) {
            return this.adg;
        }
        return 0;
    }

    private boolean vv() {
        return (this.acZ == null || this.acX == -1 || this.acX == 0 || this.acX == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.adj;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.adk;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.adl;
    }

    public void setEnableRefresh(boolean z) {
        this.ado = z;
    }

    public void setOnSurfaceAvailableListener(a aVar) {
        this.adu = aVar;
    }
}
