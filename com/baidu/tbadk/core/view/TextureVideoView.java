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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.io.IOException;
/* loaded from: classes.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    private int Ae;
    private String adH;
    private int adI;
    private int adJ;
    private MediaPlayer adK;
    private int adL;
    private int adM;
    private MediaController adN;
    private MediaPlayer.OnCompletionListener adO;
    private MediaPlayer.OnPreparedListener adP;
    private int adQ;
    private MediaPlayer.OnErrorListener adR;
    private int adS;
    private boolean adT;
    private boolean adU;
    private boolean adV;
    private MediaPlayer.OnBufferingUpdateListener adW;
    private b adX;
    private boolean adY;
    private Surface adZ;
    private boolean aea;
    private boolean aeb;
    private boolean aec;
    private boolean aed;
    private a aee;
    private boolean aef;
    private c aeg;
    private String aeh;
    private TextureView.SurfaceTextureListener aei;
    MediaPlayer.OnVideoSizeChangedListener aej;
    MediaPlayer.OnPreparedListener aek;
    private MediaPlayer.OnCompletionListener ael;
    private MediaPlayer.OnErrorListener aem;
    private MediaPlayer.OnBufferingUpdateListener aen;
    private SurfaceTexture mSurfaceTexture;
    private long startTime;

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
        this.adI = 0;
        this.adJ = 0;
        this.adK = null;
        this.adY = false;
        this.aea = false;
        this.aeb = false;
        this.aec = false;
        this.aed = true;
        this.startTime = 0L;
        this.aef = false;
        this.aeh = "1";
        this.aei = new z(this);
        this.aej = new aa(this);
        this.aek = new ab(this);
        this.ael = new ac(this);
        this.aem = new ad(this);
        this.aen = new ae(this);
        ac(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        ac(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adI = 0;
        this.adJ = 0;
        this.adK = null;
        this.adY = false;
        this.aea = false;
        this.aeb = false;
        this.aec = false;
        this.aed = true;
        this.startTime = 0L;
        this.aef = false;
        this.aeh = "1";
        this.aei = new z(this);
        this.aej = new aa(this);
        this.aek = new ab(this);
        this.ael = new ac(this);
        this.aem = new ad(this);
        this.aen = new ae(this);
        ac(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.adL, i);
        int defaultSize2 = getDefaultSize(this.adM, i2);
        if (this.adL > 0 && this.adM > 0) {
            if (this.adL * defaultSize2 > this.adM * defaultSize) {
                defaultSize2 = (this.adM * defaultSize) / this.adL;
            } else if (this.adL * defaultSize2 < this.adM * defaultSize) {
                defaultSize = (this.adL * defaultSize2) / this.adM;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    private void ac(Context context) {
        this.adL = 0;
        this.adM = 0;
        setSurfaceTextureListener(this.aei);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.adI = 0;
        this.adJ = 0;
    }

    public void u(String str, int i) {
        this.adH = v(str, i);
        this.adS = 0;
        this.aeb = true;
        vs();
        requestLayout();
        invalidate();
    }

    public void setVideoPath(String str) {
        this.adH = str;
        this.adS = 0;
        this.aeb = true;
        vs();
        requestLayout();
        invalidate();
    }

    private String v(String str, int i) {
        if (!this.aed) {
            this.aec = false;
            return str;
        } else if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL) == null) {
            this.aec = false;
            return str;
        } else {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
            if (runTask != null) {
                this.aec = true;
                return (String) runTask.getData();
            }
            if (i < 180) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_VIDEO_CACHE_DOWNLOAD, str));
            }
            this.aec = false;
            return str;
        }
    }

    public boolean vq() {
        return this.aec;
    }

    public String getVideoPath() {
        return this.adH;
    }

    public void setAutoDownload(boolean z) {
        this.aed = z;
    }

    public void vr() {
        at.vG().s(this);
    }

    public void stopPlayback() {
        if (!this.aef) {
            this.aef = true;
            if (this.startTime > 0) {
                long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
                if (currentTimeMillis > 0) {
                    ay ayVar = new ay("c11244");
                    ayVar.g("obj_duration", currentTimeMillis);
                    ayVar.ab("obj_type", this.aeh);
                    if (this.aeg != null) {
                        this.aeg.a(ayVar);
                    }
                    this.aeh = "1";
                    TiebaStatic.log(ayVar);
                }
                this.startTime = 0L;
            }
            if (this.adK != null) {
                this.adK.reset();
                if (this.adK != null) {
                    this.adK.release();
                }
                this.adK = null;
                this.adI = 0;
                this.adJ = 0;
                at.vG().vI();
            }
            this.aef = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs() {
        if (this.adH != null && !this.adH.isEmpty() && this.mSurfaceTexture != null && !this.aef) {
            stopPlayback();
            try {
                this.adK = new MediaPlayer();
                at.vG().vH();
                this.adK.setOnPreparedListener(this.aek);
                this.adK.setOnVideoSizeChangedListener(this.aej);
                this.Ae = -1;
                this.adK.setOnCompletionListener(this.ael);
                this.adK.setOnErrorListener(this.aem);
                this.adK.setOnBufferingUpdateListener(this.aen);
                this.adQ = 0;
                this.adK.setDataSource(this.adH);
                this.adK.setSurface(getSurface());
                this.adK.setAudioStreamType(3);
                this.adK.prepareAsync();
                this.adI = 1;
                vt();
            } catch (IOException e) {
                this.adI = -1;
                this.adJ = -1;
                this.aem.onError(this.adK, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.adI = -1;
                this.adJ = -1;
                this.aem.onError(this.adK, 1, 0);
            } catch (IllegalStateException e3) {
                this.adI = -1;
                this.adJ = -1;
                this.aem.onError(this.adK, 1, 0);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.adN != null) {
            this.adN.hide();
        }
        this.adN = mediaController;
        vt();
    }

    private void vt() {
        if (this.adK != null && this.adN != null) {
            this.adN.setMediaPlayer(this);
            this.adN.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.adN.setEnabled(vv());
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.adP = onPreparedListener;
    }

    public void setOnBufferUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.adW = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.adO = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.adR = onErrorListener;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (vv() && this.adN != null) {
            vu();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (vv() && this.adN != null) {
            vu();
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (vv() && z && this.adN != null) {
            if (i == 79 || i == 85) {
                if (this.adK.isPlaying()) {
                    pause();
                    this.adN.show();
                    return true;
                }
                start();
                this.adN.hide();
                return true;
            } else if (i == 126) {
                if (this.adK.isPlaying()) {
                    return true;
                }
                start();
                this.adN.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (this.adK.isPlaying()) {
                    pause();
                    this.adN.show();
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
        if (this.adN.isShowing()) {
            this.adN.hide();
        } else {
            this.adN.show();
        }
    }

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.adX = bVar;
    }

    private Surface getSurface() {
        if (this.adZ == null || this.aea) {
            this.adZ = new Surface(this.mSurfaceTexture);
            this.aea = false;
        }
        return this.adZ;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (vv()) {
            try {
                this.adK.start();
                this.adI = 3;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.adJ = 3;
        this.startTime = System.currentTimeMillis();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (vv() && this.adK.isPlaying()) {
            this.adK.pause();
            this.adI = 4;
        }
        this.adJ = 4;
        long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
        if (currentTimeMillis > 0) {
            ay ayVar = new ay("c11244");
            ayVar.g("obj_duration", currentTimeMillis);
            ayVar.ab("obj_type", this.aeh);
            if (this.aeg != null) {
                this.aeg.a(ayVar);
            }
            TiebaStatic.log(ayVar);
            this.startTime = 0L;
        }
        this.aeh = "1";
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (vv()) {
            if (this.Ae > 0) {
                return this.Ae;
            }
            try {
                this.Ae = this.adK.getDuration();
            } catch (Exception e) {
                BdLog.e(e);
            }
            return this.Ae;
        }
        this.Ae = -1;
        return this.Ae;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (vv()) {
            try {
                return this.adK.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (vv()) {
            this.adK.seekTo(i);
            this.adS = 0;
            return;
        }
        this.adS = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        try {
            if (vv()) {
                return this.adK.isPlaying();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.adK != null) {
            return this.adQ;
        }
        return 0;
    }

    private boolean vv() {
        return (this.adK == null || this.adI == -1 || this.adI == 0 || this.adI == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.adT;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.adU;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.adV;
    }

    public void setEnableRefresh(boolean z) {
        this.adY = z;
    }

    public void setOnSurfaceAvailableListener(a aVar) {
        this.aee = aVar;
    }

    public void setVideoStatsData(c cVar) {
        this.aeg = cVar;
    }

    /* loaded from: classes.dex */
    public static class c {
        public String aep;
        public String aeq;
        public String mLocate;

        public ay a(ay ayVar) {
            if (ayVar != null) {
                if (!StringUtils.isNull(this.mLocate)) {
                    ayVar.ab("obj_locate", this.mLocate);
                }
                if (!StringUtils.isNull(this.aep)) {
                    ayVar.ab("tid", this.aep);
                }
                if (!StringUtils.isNull(this.aeq)) {
                    ayVar.ab("fid", this.aeq);
                }
            }
            return ayVar;
        }
    }

    public void setPlayMode(String str) {
        this.aeh = str;
    }
}
