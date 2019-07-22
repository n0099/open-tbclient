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
    private QuickVideoView RG;
    private n RH;
    private VideoPasterOverlayView SC;
    private TbImageView SD;
    private TbImageView SE;
    private j SF;
    private a SG;
    private boolean SH;
    private g SJ;
    private boolean SK;
    private int SL;
    private long SM;
    private boolean SO;
    private boolean SQ;
    private int SR;
    private Runnable SS;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes3.dex */
    public interface a {
        void onDetachedFromWindow();

        void pH();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.SH = false;
        this.SK = false;
        this.SL = 100;
        this.mStartPosition = 0;
        this.SO = false;
        this.SQ = false;
        this.SR = 0;
        this.SS = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.iK().removeCallbacks(VideoPasterContentView.this.SS);
                if (!VideoPasterContentView.this.SK) {
                    boolean z = VideoPasterContentView.this.RG.getCurrentPosition() == 0 && VideoPasterContentView.this.SL == 100;
                    if (VideoPasterContentView.this.RG.getCurrentPosition() > VideoPasterContentView.this.SL) {
                        VideoPasterContentView.this.pR();
                    } else if (z) {
                        e.iK().postDelayed(VideoPasterContentView.this.SS, 20L);
                    } else {
                        VideoPasterContentView.this.pR();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.SC = new VideoPasterOverlayView(getContext());
        this.SD = new TbImageView(getContext());
        this.SE = new TbImageView(getContext());
        this.RG = new QuickVideoView(getContext());
        this.RG.setBackgroundResource(R.color.black_alpha100);
        this.RH = new n(getContext());
        this.RG.setPlayerReuseEnable(true);
        this.RG.setContinuePlayEnable(true);
        this.RG.setBusiness(this.RH);
        this.RG.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.SR = gVar.getDuration();
                    if (VideoPasterContentView.this.SC != null) {
                        VideoPasterContentView.this.SC.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.RG.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.RG.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.pT();
            }
        });
        this.RG.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.pT();
                return false;
            }
        });
        this.RG.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.SK = false;
                VideoPasterContentView.this.SL = 100;
                e.iK().removeCallbacks(VideoPasterContentView.this.SS);
            }
        });
        this.SF = new j();
        this.SF.setPlayer(this.RG);
        this.SF.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void pU() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.SC.a(this.pasterData, z, z2);
            if (!this.SH) {
                if (this.pasterData.pK() == 0) {
                    this.SC.setCountDownNum(this.pasterData.Sb);
                    bh(this.pasterData.Sb);
                } else if (this.pasterData.pK() == 1) {
                    this.SC.setCountDownNum(this.pasterData.Sb);
                    bh(this.pasterData.Sb);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.pK() == 0) {
                    removeAllViews();
                    addView(this.SD);
                    addView(this.SC.getRootView(), layoutParams);
                    this.SD.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.iE().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.nK() != null && VideoPasterContentView.this.SC != null) {
                                VideoPasterContentView.this.SC.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.SD.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.pK() == 1) {
                    pS();
                    removeAllViews();
                    addView(this.RG);
                    addView(this.SE);
                    addView(this.SC.getRootView(), layoutParams);
                    this.SE.startLoad(this.pasterData.Sc, 10, false);
                    this.RG.setVideoPath(this.pasterData.videoUrl);
                    this.RG.start();
                    e.iK().removeCallbacks(this.SS);
                    e.iK().postDelayed(this.SS, 20L);
                }
                this.SH = true;
                this.SO = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.pK() == 0) {
                if (this.SJ != null) {
                    this.SJ.pause();
                }
            } else if (this.pasterData.pK() == 1) {
                this.SE.setVisibility(0);
                this.RG.ceg();
                if (this.SF != null) {
                    this.SF.stop();
                }
                if (this.SJ != null) {
                    this.SJ.pause();
                }
                e.iK().removeCallbacks(this.SS);
            }
            if (this.SC != null) {
                this.SC.stop();
            }
            this.SO = false;
            this.SK = false;
        }
    }

    public void pw() {
        if (this.pasterData != null && this.pasterData.pK() == 1 && this.SE != null) {
            this.SE.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR() {
        if (!this.SK) {
            this.SK = true;
            this.SE.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.pK() == 0) {
                if (this.SJ != null) {
                    this.SJ.resume();
                }
            } else if (this.pasterData.pK() == 1) {
                this.SE.setVisibility(0);
                this.RG.setVideoPath(this.pasterData.videoUrl);
                this.RG.start();
                if (this.SF != null) {
                    this.SF.start();
                }
                if (this.SJ != null) {
                    this.SJ.resume();
                }
                if (this.SH) {
                    this.mStartPosition = y.ceM().CZ(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.SR > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.SL = i;
                } else {
                    this.SL = 100;
                }
                e.iK().removeCallbacks(this.SS);
                e.iK().postDelayed(this.SS, 20L);
            }
            if (this.SC != null) {
                this.SC.resume();
            }
            this.SO = true;
        }
    }

    private void bh(int i) {
        if (this.SJ != null) {
            this.SJ.stop();
            this.SJ.a((g.a) null);
        }
        this.SJ = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.SJ.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.SM = (int) (j2 / 1000);
                if (VideoPasterContentView.this.SC != null) {
                    VideoPasterContentView.this.SC.setCountDownNum((int) VideoPasterContentView.this.SM);
                }
                if (VideoPasterContentView.this.SM == 0) {
                    VideoPasterContentView.this.pT();
                    VideoPasterContentView.this.SJ.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void q(long j) {
                VideoPasterContentView.this.pT();
            }
        });
        this.SJ.start();
        this.SQ = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.SC != null) {
            this.SC.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.SG = aVar;
    }

    public boolean pr() {
        return this.SH;
    }

    public boolean ps() {
        return this.SO;
    }

    public void reset() {
        pS();
        stop();
        this.SC.reset();
        this.SH = false;
        this.pasterData = null;
        this.SM = 0L;
        this.SK = false;
        this.SL = 100;
        e.iK().removeCallbacks(this.SS);
    }

    private void pS() {
        if (this.pasterData != null && this.pasterData.pK() == 1) {
            y.ceM().remove(this.pasterData.videoUrl);
            if (this.RG != null && this.RG.getPlayer() != null) {
                this.RG.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT() {
        this.SQ = true;
        if (this.SG != null) {
            this.SG.pH();
        }
        removeAllViews();
        this.pasterData = null;
        this.SM = 0L;
        this.SH = false;
        this.SO = false;
        this.SK = false;
        this.SL = 100;
        e.iK().removeCallbacks(this.SS);
    }

    public void bc(int i) {
        if (this.SC != null) {
            this.SC.bc(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.SJ == null) {
            return 0;
        }
        return ((int) this.SJ.awd()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Sb;
    }

    public void pz() {
        if (this.SC != null) {
            this.SC.pz();
        }
    }

    public void pA() {
        int i = 100;
        if (this.SC != null) {
            this.SC.pA();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.SH && this.pasterData.pK() == 1) {
            this.SE.setVisibility(0);
            this.mStartPosition = y.ceM().CZ(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.SR > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.SL = i;
            e.iK().removeCallbacks(this.SS);
            e.iK().postDelayed(this.SS, 20L);
        }
    }

    public boolean bh() {
        return this.SQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.SG != null) {
            this.SG.onDetachedFromWindow();
        }
    }

    public boolean pB() {
        return this.RG != null && this.RG.isPlaying();
    }
}
