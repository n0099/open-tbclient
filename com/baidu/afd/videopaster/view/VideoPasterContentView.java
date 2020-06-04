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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
/* loaded from: classes8.dex */
public class VideoPasterContentView extends FrameLayout {
    private QuickVideoView Xt;
    private n Xu;
    private VideoPasterOverlayView Yk;
    private TbImageView Yl;
    private TbImageView Ym;
    private j Yn;
    private a Yo;
    private boolean Yp;
    private i Yq;
    private boolean Yr;
    private int Ys;
    private long Yt;
    private boolean Yu;
    private boolean Yv;
    private int Yw;
    private Runnable Yx;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes8.dex */
    public interface a {
        void onDetachedFromWindow();

        void pU();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.Yp = false;
        this.Yr = false;
        this.Ys = 100;
        this.mStartPosition = 0;
        this.Yu = false;
        this.Yv = false;
        this.Yw = 0;
        this.Yx = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.ld().removeCallbacks(VideoPasterContentView.this.Yx);
                if (!VideoPasterContentView.this.Yr) {
                    boolean z = VideoPasterContentView.this.Xt.getCurrentPosition() == 0 && VideoPasterContentView.this.Ys == 100;
                    if (VideoPasterContentView.this.Xt.getCurrentPosition() > VideoPasterContentView.this.Ys) {
                        VideoPasterContentView.this.qd();
                    } else if (z) {
                        e.ld().postDelayed(VideoPasterContentView.this.Yx, 20L);
                    } else {
                        VideoPasterContentView.this.qd();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Yk = new VideoPasterOverlayView(getContext());
        this.Yl = new TbImageView(getContext());
        this.Ym = new TbImageView(getContext());
        this.Xt = new QuickVideoView(getContext());
        this.Xt.setBackgroundResource(R.color.black_alpha100);
        this.Xu = new n(getContext());
        this.Xt.setContinuePlayEnable(true);
        this.Xt.setBusiness(this.Xu);
        this.Xt.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
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
                    VideoPasterContentView.this.Yw = gVar.getDuration();
                    if (VideoPasterContentView.this.Yk != null) {
                        VideoPasterContentView.this.Yk.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Xt.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return false;
            }
        });
        this.Xt.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                VideoPasterContentView.this.qf();
            }
        });
        this.Xt.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                VideoPasterContentView.this.qf();
                return false;
            }
        });
        this.Xt.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Yr = false;
                VideoPasterContentView.this.Ys = 100;
                e.ld().removeCallbacks(VideoPasterContentView.this.Yx);
            }
        });
        this.Yn = new j();
        this.Yn.setPlayer(this.Xt);
        this.Yn.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void qg() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Yk.a(this.pasterData, z, z2);
            if (!this.Yp) {
                if (this.pasterData.pX() == 0) {
                    this.Yk.setCountDownNum(this.pasterData.XJ);
                    aP(this.pasterData.XJ);
                } else if (this.pasterData.pX() == 1) {
                    this.Yk.setCountDownNum(this.pasterData.XJ);
                    aP(this.pasterData.XJ);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.pX() == 0) {
                    removeAllViews();
                    addView(this.Yl);
                    addView(this.Yk.getRootView(), layoutParams);
                    this.Yl.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.kX().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.Yk != null) {
                                VideoPasterContentView.this.Yk.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Yl.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.pX() == 1) {
                    qe();
                    removeAllViews();
                    addView(this.Xt);
                    addView(this.Ym);
                    addView(this.Yk.getRootView(), layoutParams);
                    this.Ym.startLoad(this.pasterData.XK, 10, false);
                    this.Xt.setVideoPath(this.pasterData.videoUrl);
                    this.Xt.start();
                    e.ld().removeCallbacks(this.Yx);
                    e.ld().postDelayed(this.Yx, 20L);
                }
                this.Yp = true;
                this.Yu = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.pX() == 0) {
                if (this.Yq != null) {
                    this.Yq.pause();
                }
            } else if (this.pasterData.pX() == 1) {
                this.Ym.setVisibility(0);
                this.Xt.stopPlayback();
                if (this.Yn != null) {
                    this.Yn.stop();
                }
                if (this.Yq != null) {
                    this.Yq.pause();
                }
                e.ld().removeCallbacks(this.Yx);
            }
            if (this.Yk != null) {
                this.Yk.stop();
            }
            this.Yu = false;
            this.Yr = false;
        }
    }

    public void pJ() {
        if (this.pasterData != null && this.pasterData.pX() == 1 && this.Ym != null) {
            this.Ym.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        if (!this.Yr) {
            this.Yr = true;
            this.Ym.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.pX() == 0) {
                if (this.Yq != null) {
                    this.Yq.resume();
                }
            } else if (this.pasterData.pX() == 1) {
                this.Ym.setVisibility(0);
                this.Xt.setVideoPath(this.pasterData.videoUrl);
                this.Xt.start();
                if (this.Yn != null) {
                    this.Yn.start();
                }
                if (this.Yq != null) {
                    this.Yq.resume();
                }
                if (this.Yp) {
                    this.mStartPosition = x.cRE().KB(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Yw > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Ys = i;
                } else {
                    this.Ys = 100;
                }
                e.ld().removeCallbacks(this.Yx);
                e.ld().postDelayed(this.Yx, 20L);
            }
            if (this.Yk != null) {
                this.Yk.resume();
            }
            this.Yu = true;
        }
    }

    private void aP(int i) {
        if (this.Yq != null) {
            this.Yq.stop();
            this.Yq.a((i.a) null);
        }
        this.Yq = new i(i * 1000, 1000L);
        this.Yq.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Yt = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Yk != null) {
                    VideoPasterContentView.this.Yk.setCountDownNum((int) VideoPasterContentView.this.Yt);
                }
                if (VideoPasterContentView.this.Yt == 0) {
                    VideoPasterContentView.this.qf();
                    VideoPasterContentView.this.Yq.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void P(long j) {
                VideoPasterContentView.this.qf();
            }
        });
        this.Yq.start();
        this.Yv = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Yk != null) {
            this.Yk.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.Yo = aVar;
    }

    public boolean pE() {
        return this.Yp;
    }

    public boolean pF() {
        return this.Yu;
    }

    public void reset() {
        qe();
        stop();
        this.Yk.reset();
        this.Yp = false;
        this.pasterData = null;
        this.Yt = 0L;
        this.Yr = false;
        this.Ys = 100;
        e.ld().removeCallbacks(this.Yx);
    }

    private void qe() {
        if (this.pasterData != null && this.pasterData.pX() == 1) {
            x.cRE().remove(this.pasterData.videoUrl);
            if (this.Xt != null && this.Xt.getPlayer() != null) {
                this.Xt.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf() {
        this.Yv = true;
        if (this.Yo != null) {
            this.Yo.pU();
        }
        removeAllViews();
        this.pasterData = null;
        this.Yt = 0L;
        this.Yp = false;
        this.Yu = false;
        this.Yr = false;
        this.Ys = 100;
        e.ld().removeCallbacks(this.Yx);
    }

    public void aK(int i) {
        if (this.Yk != null) {
            this.Yk.aK(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Yq == null) {
            return 0;
        }
        return ((int) this.Yq.bgu()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.XJ;
    }

    public void pM() {
        if (this.Yk != null) {
            this.Yk.pM();
        }
    }

    public void pN() {
        int i = 100;
        if (this.Yk != null) {
            this.Yk.pN();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Yp && this.pasterData.pX() == 1) {
            this.Ym.setVisibility(0);
            this.mStartPosition = x.cRE().KB(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Yw > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Ys = i;
            e.ld().removeCallbacks(this.Yx);
            e.ld().postDelayed(this.Yx, 20L);
        }
    }

    public boolean gt() {
        return this.Yv;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Yo != null) {
            this.Yo.onDetachedFromWindow();
        }
    }

    public boolean pO() {
        return this.Xt != null && this.Xt.isPlaying();
    }
}
