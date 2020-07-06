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
    private QuickVideoView XX;
    private n XY;
    private VideoPasterOverlayView YO;
    private TbImageView YP;
    private TbImageView YQ;
    private j YR;
    private a YS;
    private boolean YT;
    private i YU;
    private boolean YV;
    private int YW;
    private long YX;
    private boolean YY;
    private boolean YZ;
    private int Za;
    private Runnable Zb;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes8.dex */
    public interface a {
        void onDetachedFromWindow();

        void ql();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.YT = false;
        this.YV = false;
        this.YW = 100;
        this.mStartPosition = 0;
        this.YY = false;
        this.YZ = false;
        this.Za = 0;
        this.Zb = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.lt().removeCallbacks(VideoPasterContentView.this.Zb);
                if (!VideoPasterContentView.this.YV) {
                    boolean z = VideoPasterContentView.this.XX.getCurrentPosition() == 0 && VideoPasterContentView.this.YW == 100;
                    if (VideoPasterContentView.this.XX.getCurrentPosition() > VideoPasterContentView.this.YW) {
                        VideoPasterContentView.this.qu();
                    } else if (z) {
                        e.lt().postDelayed(VideoPasterContentView.this.Zb, 20L);
                    } else {
                        VideoPasterContentView.this.qu();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.YO = new VideoPasterOverlayView(getContext());
        this.YP = new TbImageView(getContext());
        this.YQ = new TbImageView(getContext());
        this.XX = new QuickVideoView(getContext());
        this.XX.setBackgroundResource(R.color.black_alpha100);
        this.XY = new n(getContext());
        this.XX.setContinuePlayEnable(true);
        this.XX.setBusiness(this.XY);
        this.XX.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Za = gVar.getDuration();
                    if (VideoPasterContentView.this.YO != null) {
                        VideoPasterContentView.this.YO.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.XX.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return false;
            }
        });
        this.XX.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                VideoPasterContentView.this.qw();
            }
        });
        this.XX.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                VideoPasterContentView.this.qw();
                return false;
            }
        });
        this.XX.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.YV = false;
                VideoPasterContentView.this.YW = 100;
                e.lt().removeCallbacks(VideoPasterContentView.this.Zb);
            }
        });
        this.YR = new j();
        this.YR.setPlayer(this.XX);
        this.YR.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void qx() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.YO.a(this.pasterData, z, z2);
            if (!this.YT) {
                if (this.pasterData.qo() == 0) {
                    this.YO.setCountDownNum(this.pasterData.Yo);
                    aV(this.pasterData.Yo);
                } else if (this.pasterData.qo() == 1) {
                    this.YO.setCountDownNum(this.pasterData.Yo);
                    aV(this.pasterData.Yo);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.qo() == 0) {
                    removeAllViews();
                    addView(this.YP);
                    addView(this.YO.getRootView(), layoutParams);
                    this.YP.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.ln().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.YO != null) {
                                VideoPasterContentView.this.YO.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.YP.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.qo() == 1) {
                    qv();
                    removeAllViews();
                    addView(this.XX);
                    addView(this.YQ);
                    addView(this.YO.getRootView(), layoutParams);
                    this.YQ.startLoad(this.pasterData.Yp, 10, false);
                    this.XX.setVideoPath(this.pasterData.videoUrl);
                    this.XX.start();
                    e.lt().removeCallbacks(this.Zb);
                    e.lt().postDelayed(this.Zb, 20L);
                }
                this.YT = true;
                this.YY = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.qo() == 0) {
                if (this.YU != null) {
                    this.YU.pause();
                }
            } else if (this.pasterData.qo() == 1) {
                this.YQ.setVisibility(0);
                this.XX.stopPlayback();
                if (this.YR != null) {
                    this.YR.stop();
                }
                if (this.YU != null) {
                    this.YU.pause();
                }
                e.lt().removeCallbacks(this.Zb);
            }
            if (this.YO != null) {
                this.YO.stop();
            }
            this.YY = false;
            this.YV = false;
        }
    }

    public void qa() {
        if (this.pasterData != null && this.pasterData.qo() == 1 && this.YQ != null) {
            this.YQ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu() {
        if (!this.YV) {
            this.YV = true;
            this.YQ.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.qo() == 0) {
                if (this.YU != null) {
                    this.YU.resume();
                }
            } else if (this.pasterData.qo() == 1) {
                this.YQ.setVisibility(0);
                this.XX.setVideoPath(this.pasterData.videoUrl);
                this.XX.start();
                if (this.YR != null) {
                    this.YR.start();
                }
                if (this.YU != null) {
                    this.YU.resume();
                }
                if (this.YT) {
                    this.mStartPosition = x.cVW().Lc(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Za > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.YW = i;
                } else {
                    this.YW = 100;
                }
                e.lt().removeCallbacks(this.Zb);
                e.lt().postDelayed(this.Zb, 20L);
            }
            if (this.YO != null) {
                this.YO.resume();
            }
            this.YY = true;
        }
    }

    private void aV(int i) {
        if (this.YU != null) {
            this.YU.stop();
            this.YU.a((i.a) null);
        }
        this.YU = new i(i * 1000, 1000L);
        this.YU.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.YX = (int) (j2 / 1000);
                if (VideoPasterContentView.this.YO != null) {
                    VideoPasterContentView.this.YO.setCountDownNum((int) VideoPasterContentView.this.YX);
                }
                if (VideoPasterContentView.this.YX == 0) {
                    VideoPasterContentView.this.qw();
                    VideoPasterContentView.this.YU.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void P(long j) {
                VideoPasterContentView.this.qw();
            }
        });
        this.YU.start();
        this.YZ = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.YO != null) {
            this.YO.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.YS = aVar;
    }

    public boolean pV() {
        return this.YT;
    }

    public boolean pW() {
        return this.YY;
    }

    public void reset() {
        qv();
        stop();
        this.YO.reset();
        this.YT = false;
        this.pasterData = null;
        this.YX = 0L;
        this.YV = false;
        this.YW = 100;
        e.lt().removeCallbacks(this.Zb);
    }

    private void qv() {
        if (this.pasterData != null && this.pasterData.qo() == 1) {
            x.cVW().remove(this.pasterData.videoUrl);
            if (this.XX != null && this.XX.getPlayer() != null) {
                this.XX.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qw() {
        this.YZ = true;
        if (this.YS != null) {
            this.YS.ql();
        }
        removeAllViews();
        this.pasterData = null;
        this.YX = 0L;
        this.YT = false;
        this.YY = false;
        this.YV = false;
        this.YW = 100;
        e.lt().removeCallbacks(this.Zb);
    }

    public void aQ(int i) {
        if (this.YO != null) {
            this.YO.aQ(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.YU == null) {
            return 0;
        }
        return ((int) this.YU.biI()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Yo;
    }

    public void qd() {
        if (this.YO != null) {
            this.YO.qd();
        }
    }

    public void qe() {
        int i = 100;
        if (this.YO != null) {
            this.YO.qe();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.YT && this.pasterData.qo() == 1) {
            this.YQ.setVisibility(0);
            this.mStartPosition = x.cVW().Lc(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Za > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.YW = i;
            e.lt().removeCallbacks(this.Zb);
            e.lt().postDelayed(this.Zb, 20L);
        }
    }

    public boolean gJ() {
        return this.YZ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.YS != null) {
            this.YS.onDetachedFromWindow();
        }
    }

    public boolean qf() {
        return this.XX != null && this.XX.isPlaying();
    }
}
