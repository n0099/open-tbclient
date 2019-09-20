package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.g.e;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes3.dex */
public class VideoPasterContentView extends FrameLayout {
    private QuickVideoView RF;
    private n RG;
    private VideoPasterOverlayView SB;
    private TbImageView SC;
    private TbImageView SD;
    private j SE;
    private a SF;
    private boolean SG;
    private g SH;
    private boolean SJ;
    private int SK;
    private long SL;
    private boolean SM;
    private boolean SO;
    private int SQ;
    private Runnable SR;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes3.dex */
    public interface a {
        void onDetachedFromWindow();

        void pI();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.SG = false;
        this.SJ = false;
        this.SK = 100;
        this.mStartPosition = 0;
        this.SM = false;
        this.SO = false;
        this.SQ = 0;
        this.SR = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.iK().removeCallbacks(VideoPasterContentView.this.SR);
                if (!VideoPasterContentView.this.SJ) {
                    boolean z = VideoPasterContentView.this.RF.getCurrentPosition() == 0 && VideoPasterContentView.this.SK == 100;
                    if (VideoPasterContentView.this.RF.getCurrentPosition() > VideoPasterContentView.this.SK) {
                        VideoPasterContentView.this.pS();
                    } else if (z) {
                        e.iK().postDelayed(VideoPasterContentView.this.SR, 20L);
                    } else {
                        VideoPasterContentView.this.pS();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.SB = new VideoPasterOverlayView(getContext());
        this.SC = new TbImageView(getContext());
        this.SD = new TbImageView(getContext());
        this.RF = new QuickVideoView(getContext());
        this.RF.setBackgroundResource(R.color.black_alpha100);
        this.RG = new n(getContext());
        this.RF.setPlayerReuseEnable(true);
        this.RF.setContinuePlayEnable(true);
        this.RF.setBusiness(this.RG);
        this.RF.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        if (TbSingleton.getInstance().isVideoCardMute()) {
                            gVar.setVolume(0.0f, 0.0f);
                        } else {
                            gVar.setVolume(1.0f, 1.0f);
                        }
                    } else {
                        gVar.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.SQ = gVar.getDuration();
                    if (VideoPasterContentView.this.SB != null) {
                        VideoPasterContentView.this.SB.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.RF.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.RF.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.pU();
            }
        });
        this.RF.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.pU();
                return false;
            }
        });
        this.RF.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.SJ = false;
                VideoPasterContentView.this.SK = 100;
                e.iK().removeCallbacks(VideoPasterContentView.this.SR);
            }
        });
        this.SE = new j();
        this.SE.setPlayer(this.RF);
        this.SE.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void pV() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.SB.a(this.pasterData, z, z2);
            if (!this.SG) {
                if (this.pasterData.pL() == 0) {
                    this.SB.setCountDownNum(this.pasterData.Sa);
                    bh(this.pasterData.Sa);
                } else if (this.pasterData.pL() == 1) {
                    this.SB.setCountDownNum(this.pasterData.Sa);
                    bh(this.pasterData.Sa);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.pL() == 0) {
                    removeAllViews();
                    addView(this.SC);
                    addView(this.SB.getRootView(), layoutParams);
                    this.SC.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.iE().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.nK() != null && VideoPasterContentView.this.SB != null) {
                                VideoPasterContentView.this.SB.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.SC.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.pL() == 1) {
                    pT();
                    removeAllViews();
                    addView(this.RF);
                    addView(this.SD);
                    addView(this.SB.getRootView(), layoutParams);
                    this.SD.startLoad(this.pasterData.Sb, 10, false);
                    this.RF.setVideoPath(this.pasterData.videoUrl);
                    this.RF.start();
                    e.iK().removeCallbacks(this.SR);
                    e.iK().postDelayed(this.SR, 20L);
                }
                this.SG = true;
                this.SM = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.pL() == 0) {
                if (this.SH != null) {
                    this.SH.pause();
                }
            } else if (this.pasterData.pL() == 1) {
                this.SD.setVisibility(0);
                this.RF.stopPlayback();
                if (this.SE != null) {
                    this.SE.stop();
                }
                if (this.SH != null) {
                    this.SH.pause();
                }
                e.iK().removeCallbacks(this.SR);
            }
            if (this.SB != null) {
                this.SB.stop();
            }
            this.SM = false;
            this.SJ = false;
        }
    }

    public void px() {
        if (this.pasterData != null && this.pasterData.pL() == 1 && this.SD != null) {
            this.SD.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (!this.SJ) {
            this.SJ = true;
            this.SD.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.pL() == 0) {
                if (this.SH != null) {
                    this.SH.resume();
                }
            } else if (this.pasterData.pL() == 1) {
                this.SD.setVisibility(0);
                this.RF.setVideoPath(this.pasterData.videoUrl);
                this.RF.start();
                if (this.SE != null) {
                    this.SE.start();
                }
                if (this.SH != null) {
                    this.SH.resume();
                }
                if (this.SG) {
                    this.mStartPosition = y.cfS().Dz(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.SQ > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.SK = i;
                } else {
                    this.SK = 100;
                }
                e.iK().removeCallbacks(this.SR);
                e.iK().postDelayed(this.SR, 20L);
            }
            if (this.SB != null) {
                this.SB.resume();
            }
            this.SM = true;
        }
    }

    private void bh(int i) {
        if (this.SH != null) {
            this.SH.stop();
            this.SH.a((g.a) null);
        }
        this.SH = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.SH.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.SL = (int) (j2 / 1000);
                if (VideoPasterContentView.this.SB != null) {
                    VideoPasterContentView.this.SB.setCountDownNum((int) VideoPasterContentView.this.SL);
                }
                if (VideoPasterContentView.this.SL == 0) {
                    VideoPasterContentView.this.pU();
                    VideoPasterContentView.this.SH.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void q(long j) {
                VideoPasterContentView.this.pU();
            }
        });
        this.SH.start();
        this.SO = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.SB != null) {
            this.SB.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.SF = aVar;
    }

    public boolean ps() {
        return this.SG;
    }

    public boolean pt() {
        return this.SM;
    }

    public void reset() {
        pT();
        stop();
        this.SB.reset();
        this.SG = false;
        this.pasterData = null;
        this.SL = 0L;
        this.SJ = false;
        this.SK = 100;
        e.iK().removeCallbacks(this.SR);
    }

    private void pT() {
        if (this.pasterData != null && this.pasterData.pL() == 1) {
            y.cfS().remove(this.pasterData.videoUrl);
            if (this.RF != null && this.RF.getPlayer() != null) {
                this.RF.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU() {
        this.SO = true;
        if (this.SF != null) {
            this.SF.pI();
        }
        removeAllViews();
        this.pasterData = null;
        this.SL = 0L;
        this.SG = false;
        this.SM = false;
        this.SJ = false;
        this.SK = 100;
        e.iK().removeCallbacks(this.SR);
    }

    public void bc(int i) {
        if (this.SB != null) {
            this.SB.bc(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.SH == null) {
            return 0;
        }
        return ((int) this.SH.awr()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Sa;
    }

    public void pA() {
        if (this.SB != null) {
            this.SB.pA();
        }
    }

    public void pB() {
        int i = 100;
        if (this.SB != null) {
            this.SB.pB();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.SG && this.pasterData.pL() == 1) {
            this.SD.setVisibility(0);
            this.mStartPosition = y.cfS().Dz(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.SQ > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.SK = i;
            e.iK().removeCallbacks(this.SR);
            e.iK().postDelayed(this.SR, 20L);
        }
    }

    public boolean bh() {
        return this.SO;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.SF != null) {
            this.SF.onDetachedFromWindow();
        }
    }

    public boolean pC() {
        return this.RF != null && this.RF.isPlaying();
    }
}
