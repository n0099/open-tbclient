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
    private QuickVideoView Rp;
    private n Rq;
    private VideoPasterOverlayView Sl;
    private TbImageView Sm;
    private TbImageView Sn;
    private j So;
    private a Sp;
    private boolean Sq;
    private g Sr;
    private boolean Ss;
    private int St;
    private long Su;
    private boolean Sv;
    private boolean Sw;
    private int Sx;
    private Runnable Sy;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes3.dex */
    public interface a {
        void onDetachedFromWindow();

        void pm();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.Sq = false;
        this.Ss = false;
        this.St = 100;
        this.mStartPosition = 0;
        this.Sv = false;
        this.Sw = false;
        this.Sx = 0;
        this.Sy = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.iB().removeCallbacks(VideoPasterContentView.this.Sy);
                if (!VideoPasterContentView.this.Ss) {
                    boolean z = VideoPasterContentView.this.Rp.getCurrentPosition() == 0 && VideoPasterContentView.this.St == 100;
                    if (VideoPasterContentView.this.Rp.getCurrentPosition() > VideoPasterContentView.this.St) {
                        VideoPasterContentView.this.pw();
                    } else if (z) {
                        e.iB().postDelayed(VideoPasterContentView.this.Sy, 20L);
                    } else {
                        VideoPasterContentView.this.pw();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Sl = new VideoPasterOverlayView(getContext());
        this.Sm = new TbImageView(getContext());
        this.Sn = new TbImageView(getContext());
        this.Rp = new QuickVideoView(getContext());
        this.Rp.setBackgroundResource(R.color.black_alpha100);
        this.Rq = new n(getContext());
        this.Rp.setPlayerReuseEnable(true);
        this.Rp.setContinuePlayEnable(true);
        this.Rp.setBusiness(this.Rq);
        this.Rp.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Sx = gVar.getDuration();
                    if (VideoPasterContentView.this.Sl != null) {
                        VideoPasterContentView.this.Sl.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Rp.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.Rp.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.py();
            }
        });
        this.Rp.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.py();
                return false;
            }
        });
        this.Rp.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Ss = false;
                VideoPasterContentView.this.St = 100;
                e.iB().removeCallbacks(VideoPasterContentView.this.Sy);
            }
        });
        this.So = new j();
        this.So.setPlayer(this.Rp);
        this.So.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void pz() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Sl.a(this.pasterData, z, z2);
            if (!this.Sq) {
                if (this.pasterData.pp() == 0) {
                    this.Sl.setCountDownNum(this.pasterData.RH);
                    bh(this.pasterData.RH);
                } else if (this.pasterData.pp() == 1) {
                    this.Sl.setCountDownNum(this.pasterData.RH);
                    bh(this.pasterData.RH);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.pp() == 0) {
                    removeAllViews();
                    addView(this.Sm);
                    addView(this.Sl.getRootView(), layoutParams);
                    this.Sm.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.iv().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.ns() != null && VideoPasterContentView.this.Sl != null) {
                                VideoPasterContentView.this.Sl.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Sm.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.pp() == 1) {
                    px();
                    removeAllViews();
                    addView(this.Rp);
                    addView(this.Sn);
                    addView(this.Sl.getRootView(), layoutParams);
                    this.Sn.startLoad(this.pasterData.RI, 10, false);
                    this.Rp.setVideoPath(this.pasterData.videoUrl);
                    this.Rp.start();
                    e.iB().removeCallbacks(this.Sy);
                    e.iB().postDelayed(this.Sy, 20L);
                }
                this.Sq = true;
                this.Sv = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.pp() == 0) {
                if (this.Sr != null) {
                    this.Sr.pause();
                }
            } else if (this.pasterData.pp() == 1) {
                this.Sn.setVisibility(0);
                this.Rp.stopPlayback();
                if (this.So != null) {
                    this.So.stop();
                }
                if (this.Sr != null) {
                    this.Sr.pause();
                }
                e.iB().removeCallbacks(this.Sy);
            }
            if (this.Sl != null) {
                this.Sl.stop();
            }
            this.Sv = false;
            this.Ss = false;
        }
    }

    public void pb() {
        if (this.pasterData != null && this.pasterData.pp() == 1 && this.Sn != null) {
            this.Sn.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        if (!this.Ss) {
            this.Ss = true;
            this.Sn.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.pp() == 0) {
                if (this.Sr != null) {
                    this.Sr.resume();
                }
            } else if (this.pasterData.pp() == 1) {
                this.Sn.setVisibility(0);
                this.Rp.setVideoPath(this.pasterData.videoUrl);
                this.Rp.start();
                if (this.So != null) {
                    this.So.start();
                }
                if (this.Sr != null) {
                    this.Sr.resume();
                }
                if (this.Sq) {
                    this.mStartPosition = y.cbV().Ck(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Sx > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.St = i;
                } else {
                    this.St = 100;
                }
                e.iB().removeCallbacks(this.Sy);
                e.iB().postDelayed(this.Sy, 20L);
            }
            if (this.Sl != null) {
                this.Sl.resume();
            }
            this.Sv = true;
        }
    }

    private void bh(int i) {
        if (this.Sr != null) {
            this.Sr.stop();
            this.Sr.a((g.a) null);
        }
        this.Sr = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.Sr.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Su = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Sl != null) {
                    VideoPasterContentView.this.Sl.setCountDownNum((int) VideoPasterContentView.this.Su);
                }
                if (VideoPasterContentView.this.Su == 0) {
                    VideoPasterContentView.this.py();
                    VideoPasterContentView.this.Sr.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void q(long j) {
                VideoPasterContentView.this.py();
            }
        });
        this.Sr.start();
        this.Sw = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Sl != null) {
            this.Sl.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.Sp = aVar;
    }

    public boolean oW() {
        return this.Sq;
    }

    public boolean oX() {
        return this.Sv;
    }

    public void reset() {
        px();
        stop();
        this.Sl.reset();
        this.Sq = false;
        this.pasterData = null;
        this.Su = 0L;
        this.Ss = false;
        this.St = 100;
        e.iB().removeCallbacks(this.Sy);
    }

    private void px() {
        if (this.pasterData != null && this.pasterData.pp() == 1) {
            y.cbV().remove(this.pasterData.videoUrl);
            if (this.Rp != null && this.Rp.getPlayer() != null) {
                this.Rp.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py() {
        this.Sw = true;
        if (this.Sp != null) {
            this.Sp.pm();
        }
        removeAllViews();
        this.pasterData = null;
        this.Su = 0L;
        this.Sq = false;
        this.Sv = false;
        this.Ss = false;
        this.St = 100;
        e.iB().removeCallbacks(this.Sy);
    }

    public void bc(int i) {
        if (this.Sl != null) {
            this.Sl.bc(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Sr == null) {
            return 0;
        }
        return ((int) this.Sr.auU()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.RH;
    }

    public void pe() {
        if (this.Sl != null) {
            this.Sl.pe();
        }
    }

    public void pf() {
        int i = 100;
        if (this.Sl != null) {
            this.Sl.pf();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Sq && this.pasterData.pp() == 1) {
            this.Sn.setVisibility(0);
            this.mStartPosition = y.cbV().Ck(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Sx > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.St = i;
            e.iB().removeCallbacks(this.Sy);
            e.iB().postDelayed(this.Sy, 20L);
        }
    }

    public boolean isCompleted() {
        return this.Sw;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Sp != null) {
            this.Sp.onDetachedFromWindow();
        }
    }

    public boolean pg() {
        return this.Rp != null && this.Rp.isPlaying();
    }
}
