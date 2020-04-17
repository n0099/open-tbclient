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
    private VideoPasterOverlayView XR;
    private TbImageView XS;
    private TbImageView XT;
    private j XU;
    private a XV;
    private boolean XW;
    private i XX;
    private boolean XY;
    private int XZ;
    private QuickVideoView Xb;
    private n Xc;
    private long Ya;
    private boolean Yb;
    private boolean Yc;
    private int Yd;
    private Runnable Ye;
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
        this.XW = false;
        this.XY = false;
        this.XZ = 100;
        this.mStartPosition = 0;
        this.Yb = false;
        this.Yc = false;
        this.Yd = 0;
        this.Ye = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.lb().removeCallbacks(VideoPasterContentView.this.Ye);
                if (!VideoPasterContentView.this.XY) {
                    boolean z = VideoPasterContentView.this.Xb.getCurrentPosition() == 0 && VideoPasterContentView.this.XZ == 100;
                    if (VideoPasterContentView.this.Xb.getCurrentPosition() > VideoPasterContentView.this.XZ) {
                        VideoPasterContentView.this.pX();
                    } else if (z) {
                        e.lb().postDelayed(VideoPasterContentView.this.Ye, 20L);
                    } else {
                        VideoPasterContentView.this.pX();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.XR = new VideoPasterOverlayView(getContext());
        this.XS = new TbImageView(getContext());
        this.XT = new TbImageView(getContext());
        this.Xb = new QuickVideoView(getContext());
        this.Xb.setBackgroundResource(R.color.black_alpha100);
        this.Xc = new n(getContext());
        this.Xb.setContinuePlayEnable(true);
        this.Xb.setBusiness(this.Xc);
        this.Xb.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Yd = gVar.getDuration();
                    if (VideoPasterContentView.this.XR != null) {
                        VideoPasterContentView.this.XR.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Xb.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return false;
            }
        });
        this.Xb.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                VideoPasterContentView.this.pZ();
            }
        });
        this.Xb.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                VideoPasterContentView.this.pZ();
                return false;
            }
        });
        this.Xb.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.XY = false;
                VideoPasterContentView.this.XZ = 100;
                e.lb().removeCallbacks(VideoPasterContentView.this.Ye);
            }
        });
        this.XU = new j();
        this.XU.setPlayer(this.Xb);
        this.XU.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void qa() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.XR.a(this.pasterData, z, z2);
            if (!this.XW) {
                if (this.pasterData.pR() == 0) {
                    this.XR.setCountDownNum(this.pasterData.Xr);
                    aO(this.pasterData.Xr);
                } else if (this.pasterData.pR() == 1) {
                    this.XR.setCountDownNum(this.pasterData.Xr);
                    aO(this.pasterData.Xr);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.pR() == 0) {
                    removeAllViews();
                    addView(this.XS);
                    addView(this.XR.getRootView(), layoutParams);
                    this.XS.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.kV().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.XR != null) {
                                VideoPasterContentView.this.XR.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.XS.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.pR() == 1) {
                    pY();
                    removeAllViews();
                    addView(this.Xb);
                    addView(this.XT);
                    addView(this.XR.getRootView(), layoutParams);
                    this.XT.startLoad(this.pasterData.Xs, 10, false);
                    this.Xb.setVideoPath(this.pasterData.videoUrl);
                    this.Xb.start();
                    e.lb().removeCallbacks(this.Ye);
                    e.lb().postDelayed(this.Ye, 20L);
                }
                this.XW = true;
                this.Yb = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.pR() == 0) {
                if (this.XX != null) {
                    this.XX.pause();
                }
            } else if (this.pasterData.pR() == 1) {
                this.XT.setVisibility(0);
                this.Xb.stopPlayback();
                if (this.XU != null) {
                    this.XU.stop();
                }
                if (this.XX != null) {
                    this.XX.pause();
                }
                e.lb().removeCallbacks(this.Ye);
            }
            if (this.XR != null) {
                this.XR.stop();
            }
            this.Yb = false;
            this.XY = false;
        }
    }

    public void pD() {
        if (this.pasterData != null && this.pasterData.pR() == 1 && this.XT != null) {
            this.XT.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX() {
        if (!this.XY) {
            this.XY = true;
            this.XT.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.pR() == 0) {
                if (this.XX != null) {
                    this.XX.resume();
                }
            } else if (this.pasterData.pR() == 1) {
                this.XT.setVisibility(0);
                this.Xb.setVideoPath(this.pasterData.videoUrl);
                this.Xb.start();
                if (this.XU != null) {
                    this.XU.start();
                }
                if (this.XX != null) {
                    this.XX.resume();
                }
                if (this.XW) {
                    this.mStartPosition = x.cKr().IL(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Yd > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.XZ = i;
                } else {
                    this.XZ = 100;
                }
                e.lb().removeCallbacks(this.Ye);
                e.lb().postDelayed(this.Ye, 20L);
            }
            if (this.XR != null) {
                this.XR.resume();
            }
            this.Yb = true;
        }
    }

    private void aO(int i) {
        if (this.XX != null) {
            this.XX.stop();
            this.XX.a((i.a) null);
        }
        this.XX = new i(i * 1000, 1000L);
        this.XX.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Ya = (int) (j2 / 1000);
                if (VideoPasterContentView.this.XR != null) {
                    VideoPasterContentView.this.XR.setCountDownNum((int) VideoPasterContentView.this.Ya);
                }
                if (VideoPasterContentView.this.Ya == 0) {
                    VideoPasterContentView.this.pZ();
                    VideoPasterContentView.this.XX.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void P(long j) {
                VideoPasterContentView.this.pZ();
            }
        });
        this.XX.start();
        this.Yc = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.XR != null) {
            this.XR.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.XV = aVar;
    }

    public boolean py() {
        return this.XW;
    }

    public boolean pz() {
        return this.Yb;
    }

    public void reset() {
        pY();
        stop();
        this.XR.reset();
        this.XW = false;
        this.pasterData = null;
        this.Ya = 0L;
        this.XY = false;
        this.XZ = 100;
        e.lb().removeCallbacks(this.Ye);
    }

    private void pY() {
        if (this.pasterData != null && this.pasterData.pR() == 1) {
            x.cKr().remove(this.pasterData.videoUrl);
            if (this.Xb != null && this.Xb.getPlayer() != null) {
                this.Xb.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ() {
        this.Yc = true;
        if (this.XV != null) {
            this.XV.pO();
        }
        removeAllViews();
        this.pasterData = null;
        this.Ya = 0L;
        this.XW = false;
        this.Yb = false;
        this.XY = false;
        this.XZ = 100;
        e.lb().removeCallbacks(this.Ye);
    }

    public void aJ(int i) {
        if (this.XR != null) {
            this.XR.aJ(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.XX == null) {
            return 0;
        }
        return ((int) this.XX.bal()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Xr;
    }

    public void pG() {
        if (this.XR != null) {
            this.XR.pG();
        }
    }

    public void pH() {
        int i = 100;
        if (this.XR != null) {
            this.XR.pH();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.XW && this.pasterData.pR() == 1) {
            this.XT.setVisibility(0);
            this.mStartPosition = x.cKr().IL(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Yd > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.XZ = i;
            e.lb().removeCallbacks(this.Ye);
            e.lb().postDelayed(this.Ye, 20L);
        }
    }

    public boolean gt() {
        return this.Yc;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.XV != null) {
            this.XV.onDetachedFromWindow();
        }
    }

    public boolean pI() {
        return this.Xb != null && this.Xb.isPlaying();
    }
}
