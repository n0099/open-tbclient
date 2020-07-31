package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.f.e;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
/* loaded from: classes15.dex */
public class VideoPasterContentView extends FrameLayout {
    private VideoPasterOverlayView YE;
    private TbImageView YF;
    private TbImageView YG;
    private TbCyberVideoView YH;
    private f YI;
    private a YJ;
    private boolean YK;
    private i YL;
    private boolean YM;
    private int YN;
    private long YO;
    private boolean YP;
    private boolean YQ;
    private int YR;
    private Runnable YS;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes15.dex */
    public interface a {
        void onDetachedFromWindow();

        void qm();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.YK = false;
        this.YM = false;
        this.YN = 100;
        this.mStartPosition = 0;
        this.YP = false;
        this.YQ = false;
        this.YR = 0;
        this.YS = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.lt().removeCallbacks(VideoPasterContentView.this.YS);
                if (!VideoPasterContentView.this.YM) {
                    boolean z = VideoPasterContentView.this.YH.getCurrentPositionSync() == 0 && VideoPasterContentView.this.YN == 100;
                    if (VideoPasterContentView.this.YH.getCurrentPositionSync() > VideoPasterContentView.this.YN) {
                        VideoPasterContentView.this.qv();
                    } else if (z) {
                        e.lt().postDelayed(VideoPasterContentView.this.YS, 20L);
                    } else {
                        VideoPasterContentView.this.qv();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.YE = new VideoPasterOverlayView(getContext());
        this.YF = new TbImageView(getContext());
        this.YG = new TbImageView(getContext());
        this.YH = new TbCyberVideoView(getContext());
        setBackgroundResource(R.color.black_alpha100);
        this.YH.setContinuePlayEnable(true);
        this.YH.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.YH != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.YH.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.YH.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.YH.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.YR = VideoPasterContentView.this.YH.getDuration();
                    if (VideoPasterContentView.this.YE != null) {
                        VideoPasterContentView.this.YE.c(VideoPasterContentView.this.YH.getVideoWidth(), VideoPasterContentView.this.YH.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.YH.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.qx();
            }
        });
        this.YH.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.qx();
                return false;
            }
        });
        this.YH.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.YM = false;
                VideoPasterContentView.this.YN = 100;
                e.lt().removeCallbacks(VideoPasterContentView.this.YS);
            }
        });
        this.YI = new f();
        this.YI.setPlayer(this.YH);
        this.YI.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void qy() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.YE.a(this.pasterData, z, z2);
            if (!this.YK) {
                if (this.pasterData.qp() == 0) {
                    this.YE.setCountDownNum(this.pasterData.Ye);
                    aX(this.pasterData.Ye);
                } else if (this.pasterData.qp() == 1) {
                    this.YE.setCountDownNum(this.pasterData.Ye);
                    aX(this.pasterData.Ye);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.qp() == 0) {
                    removeAllViews();
                    addView(this.YF);
                    addView(this.YE.getRootView(), layoutParams);
                    this.YF.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.ln().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.YE != null) {
                                VideoPasterContentView.this.YE.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.YF.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.qp() == 1) {
                    qw();
                    removeAllViews();
                    addView(this.YH.getView());
                    addView(this.YG);
                    addView(this.YE.getRootView(), layoutParams);
                    this.YG.startLoad(this.pasterData.Yf, 10, false);
                    this.YH.setVideoPath(this.pasterData.videoUrl);
                    this.YH.start();
                    e.lt().removeCallbacks(this.YS);
                    e.lt().postDelayed(this.YS, 20L);
                }
                this.YK = true;
                this.YP = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.qp() == 0) {
                if (this.YL != null) {
                    this.YL.pause();
                }
            } else if (this.pasterData.qp() == 1) {
                this.YG.setVisibility(0);
                this.YH.stopPlayback();
                if (this.YI != null) {
                    this.YI.stop();
                }
                if (this.YL != null) {
                    this.YL.pause();
                }
                e.lt().removeCallbacks(this.YS);
            }
            if (this.YE != null) {
                this.YE.stop();
            }
            this.YP = false;
            this.YM = false;
        }
    }

    public void qb() {
        if (this.pasterData != null && this.pasterData.qp() == 1 && this.YG != null) {
            this.YG.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv() {
        if (!this.YM) {
            this.YM = true;
            this.YG.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.qp() == 0) {
                if (this.YL != null) {
                    this.YL.resume();
                }
            } else if (this.pasterData.qp() == 1) {
                this.YG.setVisibility(0);
                this.YH.setVideoPath(this.pasterData.videoUrl);
                this.YH.start();
                if (this.YI != null) {
                    this.YI.start();
                }
                if (this.YL != null) {
                    this.YL.resume();
                }
                if (this.YK) {
                    this.mStartPosition = n.cZa().LL(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.YR > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.YN = i;
                } else {
                    this.YN = 100;
                }
                e.lt().removeCallbacks(this.YS);
                e.lt().postDelayed(this.YS, 20L);
            }
            if (this.YE != null) {
                this.YE.resume();
            }
            this.YP = true;
        }
    }

    private void aX(int i) {
        if (this.YL != null) {
            this.YL.stop();
            this.YL.a((i.a) null);
        }
        this.YL = new i(i * 1000, 1000L);
        this.YL.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.YO = (int) (j2 / 1000);
                if (VideoPasterContentView.this.YE != null) {
                    VideoPasterContentView.this.YE.setCountDownNum((int) VideoPasterContentView.this.YO);
                }
                if (VideoPasterContentView.this.YO == 0) {
                    VideoPasterContentView.this.qx();
                    VideoPasterContentView.this.YL.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void P(long j) {
                VideoPasterContentView.this.qx();
            }
        });
        this.YL.start();
        this.YQ = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.YE != null) {
            this.YE.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.YJ = aVar;
    }

    public boolean pW() {
        return this.YK;
    }

    public boolean pX() {
        return this.YP;
    }

    public void reset() {
        qw();
        stop();
        this.YE.reset();
        this.YK = false;
        this.pasterData = null;
        this.YO = 0L;
        this.YM = false;
        this.YN = 100;
        e.lt().removeCallbacks(this.YS);
    }

    private void qw() {
        if (this.pasterData != null && this.pasterData.qp() == 1) {
            n.cZa().remove(this.pasterData.videoUrl);
            if (this.YH != null) {
                this.YH.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qx() {
        this.YQ = true;
        if (this.YJ != null) {
            this.YJ.qm();
        }
        removeAllViews();
        this.pasterData = null;
        this.YO = 0L;
        this.YK = false;
        this.YP = false;
        this.YM = false;
        this.YN = 100;
        e.lt().removeCallbacks(this.YS);
    }

    public void aS(int i) {
        if (this.YE != null) {
            this.YE.aS(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.YL == null) {
            return 0;
        }
        return ((int) this.YL.bmB()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Ye;
    }

    public void qe() {
        if (this.YE != null) {
            this.YE.qe();
        }
    }

    public void qf() {
        int i = 100;
        if (this.YE != null) {
            this.YE.qf();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.YK && this.pasterData.qp() == 1) {
            this.YG.setVisibility(0);
            this.mStartPosition = n.cZa().LL(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.YR > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.YN = i;
            e.lt().removeCallbacks(this.YS);
            e.lt().postDelayed(this.YS, 20L);
        }
    }

    public boolean gJ() {
        return this.YQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.YJ != null) {
            this.YJ.onDetachedFromWindow();
        }
    }

    public boolean qg() {
        return this.YH != null && this.YH.isPlaying();
    }
}
