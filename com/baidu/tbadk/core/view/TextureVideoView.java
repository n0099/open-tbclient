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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
import java.io.IOException;
/* loaded from: classes.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    private int Cs;
    private int agA;
    private MediaPlayer agB;
    private int agC;
    private int agD;
    private MediaController agE;
    private MediaPlayer.OnCompletionListener agF;
    private MediaPlayer.OnPreparedListener agG;
    private int agH;
    private MediaPlayer.OnErrorListener agI;
    private int agJ;
    private boolean agK;
    private boolean agL;
    private boolean agM;
    private MediaPlayer.OnBufferingUpdateListener agN;
    private b agO;
    private boolean agP;
    private Surface agQ;
    private boolean agR;
    private boolean agS;
    private boolean agT;
    private boolean agU;
    private a agV;
    private boolean agW;
    private c agX;
    private String agY;
    private boolean agZ;
    private String agw;
    private String agx;
    private int agy;
    private int agz;
    private TextureView.SurfaceTextureListener aha;
    MediaPlayer.OnVideoSizeChangedListener ahb;
    MediaPlayer.OnPreparedListener ahc;
    private MediaPlayer.OnCompletionListener ahd;
    private MediaPlayer.OnErrorListener ahe;
    private MediaPlayer.OnBufferingUpdateListener ahf;
    private Runnable ahg;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long startTime;

    /* loaded from: classes.dex */
    public interface a {
        void wB();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    public TextureVideoView(Context context) {
        super(context);
        this.agz = 0;
        this.agA = 0;
        this.agB = null;
        this.agP = false;
        this.agR = false;
        this.agS = false;
        this.agT = false;
        this.agU = true;
        this.startTime = 0L;
        this.agW = false;
        this.agY = "1";
        this.agZ = false;
        this.aha = new z(this);
        this.ahb = new aa(this);
        this.ahc = new ab(this);
        this.ahd = new ac(this);
        this.ahe = new ad(this);
        this.ahf = new ae(this);
        this.ahg = new af(this);
        am(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        am(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agz = 0;
        this.agA = 0;
        this.agB = null;
        this.agP = false;
        this.agR = false;
        this.agS = false;
        this.agT = false;
        this.agU = true;
        this.startTime = 0L;
        this.agW = false;
        this.agY = "1";
        this.agZ = false;
        this.aha = new z(this);
        this.ahb = new aa(this);
        this.ahc = new ab(this);
        this.ahd = new ac(this);
        this.ahe = new ad(this);
        this.ahf = new ae(this);
        this.ahg = new af(this);
        am(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.agC, i);
        int defaultSize2 = getDefaultSize(this.agD, i2);
        if (this.agC > 0 && this.agD > 0) {
            if (this.agC * defaultSize2 > this.agD * defaultSize) {
                defaultSize2 = (this.agD * defaultSize) / this.agC;
            } else if (this.agC * defaultSize2 < this.agD * defaultSize) {
                defaultSize = (this.agC * defaultSize2) / this.agD;
            }
        }
        setMeasuredDimension(defaultSize, Math.max(defaultSize2, this.agy));
    }

    private void am(Context context) {
        this.agC = 0;
        this.agD = 0;
        this.agy = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds160);
        setSurfaceTextureListener(this.aha);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.agz = 0;
        this.agA = 0;
    }

    public void u(String str, int i) {
        this.agZ = false;
        this.agw = str;
        this.agx = com.baidu.tieba.play.m.gZ(str);
        this.agJ = 0;
        this.agS = true;
        ww();
        requestLayout();
        invalidate();
    }

    public void setVideoPathNoCache(String str) {
        this.agZ = true;
        this.agw = str;
        this.agx = str;
        this.agJ = 0;
        this.agS = true;
        ww();
        requestLayout();
        invalidate();
    }

    public boolean wu() {
        return com.baidu.tieba.play.m.ha(this.agw) != null;
    }

    public String getVideoPath() {
        return this.agx;
    }

    public void setAutoDownload(boolean z) {
        this.agU = z;
    }

    public void wv() {
        au.wK().w(this);
    }

    public void stopPlayback() {
        if (!this.agW) {
            this.agW = true;
            if (this.startTime > 0) {
                long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
                if (currentTimeMillis > 0) {
                    ay ayVar = new ay("c11244");
                    ayVar.g("obj_duration", currentTimeMillis);
                    ayVar.ab("obj_type", this.agY);
                    if (this.agX != null) {
                        this.agX.a(ayVar);
                    }
                    this.agY = "1";
                    TiebaStatic.log(ayVar);
                }
                this.startTime = 0L;
            }
            if (this.agB != null) {
                if (wA()) {
                    com.baidu.tieba.play.m.H(this.mContext, this.agw);
                }
                try {
                    this.agB.reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.agB != null) {
                    this.agB.release();
                }
                this.agB = null;
                this.agz = 0;
                this.agA = 0;
                au.wK().wM();
            }
            this.agW = false;
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ahg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww() {
        if (this.agx != null && !this.agx.isEmpty() && this.mSurfaceTexture != null && !this.agW) {
            stopPlayback();
            try {
                this.agB = new MediaPlayer();
                au.wK().wL();
                this.agB.setOnPreparedListener(this.ahc);
                this.agB.setOnVideoSizeChangedListener(this.ahb);
                this.Cs = -1;
                this.agB.setOnCompletionListener(this.ahd);
                this.agB.setOnErrorListener(this.ahe);
                this.agB.setOnBufferingUpdateListener(this.ahf);
                this.agH = 0;
                this.agB.setDataSource(this.agx);
                this.agB.setSurface(getSurface());
                this.agB.setAudioStreamType(3);
                this.agB.prepareAsync();
                this.agz = 1;
                wx();
            } catch (IOException e) {
                this.agz = -1;
                this.agA = -1;
                this.ahe.onError(this.agB, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.agz = -1;
                this.agA = -1;
                this.ahe.onError(this.agB, 1, 0);
            } catch (IllegalStateException e3) {
                this.agz = -1;
                this.agA = -1;
                this.ahe.onError(this.agB, 1, 0);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.agE != null) {
            this.agE.hide();
        }
        this.agE = mediaController;
        wx();
    }

    private void wx() {
        if (this.agB != null && this.agE != null) {
            this.agE.setMediaPlayer(this);
            this.agE.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.agE.setEnabled(wz());
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.agG = onPreparedListener;
    }

    public void setOnBufferUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.agN = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.agF = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.agI = onErrorListener;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (wz() && this.agE != null) {
            wy();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (wz() && this.agE != null) {
            wy();
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (wz() && z && this.agE != null) {
            if (i == 79 || i == 85) {
                if (this.agB.isPlaying()) {
                    pause();
                    this.agE.show();
                    return true;
                }
                start();
                this.agE.hide();
                return true;
            } else if (i == 126) {
                if (this.agB.isPlaying()) {
                    return true;
                }
                start();
                this.agE.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (this.agB.isPlaying()) {
                    pause();
                    this.agE.show();
                    return true;
                }
                return true;
            } else {
                wy();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void wy() {
        if (this.agE.isShowing()) {
            this.agE.hide();
        } else {
            this.agE.show();
        }
    }

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.agO = bVar;
    }

    private Surface getSurface() {
        if (this.agQ == null || this.agR) {
            this.agQ = new Surface(this.mSurfaceTexture);
            this.agR = false;
        }
        return this.agQ;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (wz()) {
            try {
                this.agB.start();
                this.agz = 3;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.agA = 3;
        this.startTime = System.currentTimeMillis();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (wz() && this.agB.isPlaying()) {
            this.agB.pause();
            this.agz = 4;
        }
        this.agA = 4;
        long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
        if (currentTimeMillis > 0) {
            ay ayVar = new ay("c11244");
            ayVar.g("obj_duration", currentTimeMillis);
            ayVar.ab("obj_type", this.agY);
            if (this.agX != null) {
                this.agX.a(ayVar);
            }
            TiebaStatic.log(ayVar);
            this.startTime = 0L;
        }
        this.agY = "1";
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (wz()) {
            if (this.Cs > 0) {
                return this.Cs;
            }
            try {
                this.Cs = this.agB.getDuration();
            } catch (Exception e) {
                BdLog.e(e);
            }
            return this.Cs;
        }
        this.Cs = -1;
        return this.Cs;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (wz()) {
            try {
                return this.agB.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (wz()) {
            this.agB.seekTo(i);
            this.agJ = 0;
            return;
        }
        this.agJ = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        try {
            if (wz()) {
                return this.agB.isPlaying();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.agB != null) {
            return this.agH;
        }
        return 0;
    }

    private boolean wz() {
        return (this.agB == null || this.agz == -1 || this.agz == 0 || this.agz == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.agK;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.agL;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.agM;
    }

    public void setEnableRefresh(boolean z) {
        this.agP = z;
    }

    public void setOnSurfaceAvailableListener(a aVar) {
        this.agV = aVar;
    }

    public void setVideoStatsData(c cVar) {
        this.agX = cVar;
    }

    /* loaded from: classes.dex */
    public static class c {
        public String ahi;
        public String ahj;
        public String ahk;
        public String ahl;
        public String mLocate;
        public String mSource;
        public String mUid;

        public ay a(ay ayVar) {
            if (ayVar != null) {
                if (!StringUtils.isNull(this.mLocate)) {
                    ayVar.ab("obj_locate", this.mLocate);
                }
                if (!StringUtils.isNull(this.ahi)) {
                    ayVar.ab("tid", this.ahi);
                }
                if (!StringUtils.isNull(this.ahj)) {
                    ayVar.ab("fid", this.ahj);
                }
                if (!StringUtils.isNull(this.mUid)) {
                    ayVar.ab("uid", this.mUid);
                }
                if (!StringUtils.isNull(this.mSource)) {
                    ayVar.ab("obj_source", this.mSource);
                }
                if (!StringUtils.isNull(this.ahk)) {
                    ayVar.ab("obj_param1", this.ahk);
                }
                if (!StringUtils.isNull(this.ahl)) {
                    ayVar.ab("obj_param2", this.ahl);
                }
            }
            return ayVar;
        }
    }

    public void setPlayMode(String str) {
        this.agY = str;
    }

    private boolean wA() {
        return (this.agx == null || this.agx.equals(this.agw)) ? false : true;
    }
}
