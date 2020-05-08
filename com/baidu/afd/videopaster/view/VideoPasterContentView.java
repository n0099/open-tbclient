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
    private VideoPasterOverlayView XU;
    private TbImageView XV;
    private TbImageView XW;
    private j XX;
    private a XY;
    private boolean XZ;
    private QuickVideoView Xe;
    private n Xf;
    private i Ya;
    private boolean Yb;
    private int Yc;
    private long Yd;
    private boolean Ye;
    private boolean Yf;
    private int Yg;
    private Runnable Yh;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes8.dex */
    public interface a {
        void onDetachedFromWindow();

        void pO();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.XZ = false;
        this.Yb = false;
        this.Yc = 100;
        this.mStartPosition = 0;
        this.Ye = false;
        this.Yf = false;
        this.Yg = 0;
        this.Yh = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.lb().removeCallbacks(VideoPasterContentView.this.Yh);
                if (!VideoPasterContentView.this.Yb) {
                    boolean z = VideoPasterContentView.this.Xe.getCurrentPosition() == 0 && VideoPasterContentView.this.Yc == 100;
                    if (VideoPasterContentView.this.Xe.getCurrentPosition() > VideoPasterContentView.this.Yc) {
                        VideoPasterContentView.this.pX();
                    } else if (z) {
                        e.lb().postDelayed(VideoPasterContentView.this.Yh, 20L);
                    } else {
                        VideoPasterContentView.this.pX();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.XU = new VideoPasterOverlayView(getContext());
        this.XV = new TbImageView(getContext());
        this.XW = new TbImageView(getContext());
        this.Xe = new QuickVideoView(getContext());
        this.Xe.setBackgroundResource(R.color.black_alpha100);
        this.Xf = new n(getContext());
        this.Xe.setContinuePlayEnable(true);
        this.Xe.setBusiness(this.Xf);
        this.Xe.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Yg = gVar.getDuration();
                    if (VideoPasterContentView.this.XU != null) {
                        VideoPasterContentView.this.XU.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Xe.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return false;
            }
        });
        this.Xe.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                VideoPasterContentView.this.pZ();
            }
        });
        this.Xe.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                VideoPasterContentView.this.pZ();
                return false;
            }
        });
        this.Xe.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Yb = false;
                VideoPasterContentView.this.Yc = 100;
                e.lb().removeCallbacks(VideoPasterContentView.this.Yh);
            }
        });
        this.XX = new j();
        this.XX.setPlayer(this.Xe);
        this.XX.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void qa() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.XU.a(this.pasterData, z, z2);
            if (!this.XZ) {
                if (this.pasterData.pR() == 0) {
                    this.XU.setCountDownNum(this.pasterData.Xu);
                    aO(this.pasterData.Xu);
                } else if (this.pasterData.pR() == 1) {
                    this.XU.setCountDownNum(this.pasterData.Xu);
                    aO(this.pasterData.Xu);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.pR() == 0) {
                    removeAllViews();
                    addView(this.XV);
                    addView(this.XU.getRootView(), layoutParams);
                    this.XV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.kV().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.XU != null) {
                                VideoPasterContentView.this.XU.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.XV.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.pR() == 1) {
                    pY();
                    removeAllViews();
                    addView(this.Xe);
                    addView(this.XW);
                    addView(this.XU.getRootView(), layoutParams);
                    this.XW.startLoad(this.pasterData.Xv, 10, false);
                    this.Xe.setVideoPath(this.pasterData.videoUrl);
                    this.Xe.start();
                    e.lb().removeCallbacks(this.Yh);
                    e.lb().postDelayed(this.Yh, 20L);
                }
                this.XZ = true;
                this.Ye = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.pR() == 0) {
                if (this.Ya != null) {
                    this.Ya.pause();
                }
            } else if (this.pasterData.pR() == 1) {
                this.XW.setVisibility(0);
                this.Xe.stopPlayback();
                if (this.XX != null) {
                    this.XX.stop();
                }
                if (this.Ya != null) {
                    this.Ya.pause();
                }
                e.lb().removeCallbacks(this.Yh);
            }
            if (this.XU != null) {
                this.XU.stop();
            }
            this.Ye = false;
            this.Yb = false;
        }
    }

    public void pD() {
        if (this.pasterData != null && this.pasterData.pR() == 1 && this.XW != null) {
            this.XW.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX() {
        if (!this.Yb) {
            this.Yb = true;
            this.XW.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.pR() == 0) {
                if (this.Ya != null) {
                    this.Ya.resume();
                }
            } else if (this.pasterData.pR() == 1) {
                this.XW.setVisibility(0);
                this.Xe.setVideoPath(this.pasterData.videoUrl);
                this.Xe.start();
                if (this.XX != null) {
                    this.XX.start();
                }
                if (this.Ya != null) {
                    this.Ya.resume();
                }
                if (this.XZ) {
                    this.mStartPosition = x.cKo().IO(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Yg > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Yc = i;
                } else {
                    this.Yc = 100;
                }
                e.lb().removeCallbacks(this.Yh);
                e.lb().postDelayed(this.Yh, 20L);
            }
            if (this.XU != null) {
                this.XU.resume();
            }
            this.Ye = true;
        }
    }

    private void aO(int i) {
        if (this.Ya != null) {
            this.Ya.stop();
            this.Ya.a((i.a) null);
        }
        this.Ya = new i(i * 1000, 1000L);
        this.Ya.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Yd = (int) (j2 / 1000);
                if (VideoPasterContentView.this.XU != null) {
                    VideoPasterContentView.this.XU.setCountDownNum((int) VideoPasterContentView.this.Yd);
                }
                if (VideoPasterContentView.this.Yd == 0) {
                    VideoPasterContentView.this.pZ();
                    VideoPasterContentView.this.Ya.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void P(long j) {
                VideoPasterContentView.this.pZ();
            }
        });
        this.Ya.start();
        this.Yf = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.XU != null) {
            this.XU.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.XY = aVar;
    }

    public boolean py() {
        return this.XZ;
    }

    public boolean pz() {
        return this.Ye;
    }

    public void reset() {
        pY();
        stop();
        this.XU.reset();
        this.XZ = false;
        this.pasterData = null;
        this.Yd = 0L;
        this.Yb = false;
        this.Yc = 100;
        e.lb().removeCallbacks(this.Yh);
    }

    private void pY() {
        if (this.pasterData != null && this.pasterData.pR() == 1) {
            x.cKo().remove(this.pasterData.videoUrl);
            if (this.Xe != null && this.Xe.getPlayer() != null) {
                this.Xe.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ() {
        this.Yf = true;
        if (this.XY != null) {
            this.XY.pO();
        }
        removeAllViews();
        this.pasterData = null;
        this.Yd = 0L;
        this.XZ = false;
        this.Ye = false;
        this.Yb = false;
        this.Yc = 100;
        e.lb().removeCallbacks(this.Yh);
    }

    public void aJ(int i) {
        if (this.XU != null) {
            this.XU.aJ(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Ya == null) {
            return 0;
        }
        return ((int) this.Ya.baj()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Xu;
    }

    public void pG() {
        if (this.XU != null) {
            this.XU.pG();
        }
    }

    public void pH() {
        int i = 100;
        if (this.XU != null) {
            this.XU.pH();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.XZ && this.pasterData.pR() == 1) {
            this.XW.setVisibility(0);
            this.mStartPosition = x.cKo().IO(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Yg > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Yc = i;
            e.lb().removeCallbacks(this.Yh);
            e.lb().postDelayed(this.Yh, 20L);
        }
    }

    public boolean gt() {
        return this.Yf;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.XY != null) {
            this.XY.onDetachedFromWindow();
        }
    }

    public boolean pI() {
        return this.Xe != null && this.Xe.isPlaying();
    }
}
