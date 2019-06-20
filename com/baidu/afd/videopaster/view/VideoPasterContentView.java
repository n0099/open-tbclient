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
    private QuickVideoView Ro;
    private n Rp;
    private VideoPasterOverlayView Sk;
    private TbImageView Sl;
    private TbImageView Sm;
    private j Sn;
    private a So;
    private boolean Sp;
    private g Sq;
    private boolean Sr;
    private int Ss;
    private long St;
    private boolean Su;
    private boolean Sv;
    private int Sw;
    private Runnable Sx;
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
        this.Sp = false;
        this.Sr = false;
        this.Ss = 100;
        this.mStartPosition = 0;
        this.Su = false;
        this.Sv = false;
        this.Sw = 0;
        this.Sx = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.iB().removeCallbacks(VideoPasterContentView.this.Sx);
                if (!VideoPasterContentView.this.Sr) {
                    boolean z = VideoPasterContentView.this.Ro.getCurrentPosition() == 0 && VideoPasterContentView.this.Ss == 100;
                    if (VideoPasterContentView.this.Ro.getCurrentPosition() > VideoPasterContentView.this.Ss) {
                        VideoPasterContentView.this.pw();
                    } else if (z) {
                        e.iB().postDelayed(VideoPasterContentView.this.Sx, 20L);
                    } else {
                        VideoPasterContentView.this.pw();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Sk = new VideoPasterOverlayView(getContext());
        this.Sl = new TbImageView(getContext());
        this.Sm = new TbImageView(getContext());
        this.Ro = new QuickVideoView(getContext());
        this.Ro.setBackgroundResource(R.color.black_alpha100);
        this.Rp = new n(getContext());
        this.Ro.setPlayerReuseEnable(true);
        this.Ro.setContinuePlayEnable(true);
        this.Ro.setBusiness(this.Rp);
        this.Ro.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Sw = gVar.getDuration();
                    if (VideoPasterContentView.this.Sk != null) {
                        VideoPasterContentView.this.Sk.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Ro.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.Ro.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.py();
            }
        });
        this.Ro.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.py();
                return false;
            }
        });
        this.Ro.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Sr = false;
                VideoPasterContentView.this.Ss = 100;
                e.iB().removeCallbacks(VideoPasterContentView.this.Sx);
            }
        });
        this.Sn = new j();
        this.Sn.setPlayer(this.Ro);
        this.Sn.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void pz() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Sk.a(this.pasterData, z, z2);
            if (!this.Sp) {
                if (this.pasterData.pp() == 0) {
                    this.Sk.setCountDownNum(this.pasterData.RG);
                    bh(this.pasterData.RG);
                } else if (this.pasterData.pp() == 1) {
                    this.Sk.setCountDownNum(this.pasterData.RG);
                    bh(this.pasterData.RG);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.pp() == 0) {
                    removeAllViews();
                    addView(this.Sl);
                    addView(this.Sk.getRootView(), layoutParams);
                    this.Sl.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.iv().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.ns() != null && VideoPasterContentView.this.Sk != null) {
                                VideoPasterContentView.this.Sk.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Sl.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.pp() == 1) {
                    px();
                    removeAllViews();
                    addView(this.Ro);
                    addView(this.Sm);
                    addView(this.Sk.getRootView(), layoutParams);
                    this.Sm.startLoad(this.pasterData.RH, 10, false);
                    this.Ro.setVideoPath(this.pasterData.videoUrl);
                    this.Ro.start();
                    e.iB().removeCallbacks(this.Sx);
                    e.iB().postDelayed(this.Sx, 20L);
                }
                this.Sp = true;
                this.Su = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.pp() == 0) {
                if (this.Sq != null) {
                    this.Sq.pause();
                }
            } else if (this.pasterData.pp() == 1) {
                this.Sm.setVisibility(0);
                this.Ro.stopPlayback();
                if (this.Sn != null) {
                    this.Sn.stop();
                }
                if (this.Sq != null) {
                    this.Sq.pause();
                }
                e.iB().removeCallbacks(this.Sx);
            }
            if (this.Sk != null) {
                this.Sk.stop();
            }
            this.Su = false;
            this.Sr = false;
        }
    }

    public void pb() {
        if (this.pasterData != null && this.pasterData.pp() == 1 && this.Sm != null) {
            this.Sm.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        if (!this.Sr) {
            this.Sr = true;
            this.Sm.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.pp() == 0) {
                if (this.Sq != null) {
                    this.Sq.resume();
                }
            } else if (this.pasterData.pp() == 1) {
                this.Sm.setVisibility(0);
                this.Ro.setVideoPath(this.pasterData.videoUrl);
                this.Ro.start();
                if (this.Sn != null) {
                    this.Sn.start();
                }
                if (this.Sq != null) {
                    this.Sq.resume();
                }
                if (this.Sp) {
                    this.mStartPosition = y.cbW().Cm(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Sw > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Ss = i;
                } else {
                    this.Ss = 100;
                }
                e.iB().removeCallbacks(this.Sx);
                e.iB().postDelayed(this.Sx, 20L);
            }
            if (this.Sk != null) {
                this.Sk.resume();
            }
            this.Su = true;
        }
    }

    private void bh(int i) {
        if (this.Sq != null) {
            this.Sq.stop();
            this.Sq.a((g.a) null);
        }
        this.Sq = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.Sq.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.St = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Sk != null) {
                    VideoPasterContentView.this.Sk.setCountDownNum((int) VideoPasterContentView.this.St);
                }
                if (VideoPasterContentView.this.St == 0) {
                    VideoPasterContentView.this.py();
                    VideoPasterContentView.this.Sq.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void q(long j) {
                VideoPasterContentView.this.py();
            }
        });
        this.Sq.start();
        this.Sv = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Sk != null) {
            this.Sk.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.So = aVar;
    }

    public boolean oW() {
        return this.Sp;
    }

    public boolean oX() {
        return this.Su;
    }

    public void reset() {
        px();
        stop();
        this.Sk.reset();
        this.Sp = false;
        this.pasterData = null;
        this.St = 0L;
        this.Sr = false;
        this.Ss = 100;
        e.iB().removeCallbacks(this.Sx);
    }

    private void px() {
        if (this.pasterData != null && this.pasterData.pp() == 1) {
            y.cbW().remove(this.pasterData.videoUrl);
            if (this.Ro != null && this.Ro.getPlayer() != null) {
                this.Ro.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py() {
        this.Sv = true;
        if (this.So != null) {
            this.So.pm();
        }
        removeAllViews();
        this.pasterData = null;
        this.St = 0L;
        this.Sp = false;
        this.Su = false;
        this.Sr = false;
        this.Ss = 100;
        e.iB().removeCallbacks(this.Sx);
    }

    public void bc(int i) {
        if (this.Sk != null) {
            this.Sk.bc(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Sq == null) {
            return 0;
        }
        return ((int) this.Sq.auU()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.RG;
    }

    public void pe() {
        if (this.Sk != null) {
            this.Sk.pe();
        }
    }

    public void pf() {
        int i = 100;
        if (this.Sk != null) {
            this.Sk.pf();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Sp && this.pasterData.pp() == 1) {
            this.Sm.setVisibility(0);
            this.mStartPosition = y.cbW().Cm(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Sw > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Ss = i;
            e.iB().removeCallbacks(this.Sx);
            e.iB().postDelayed(this.Sx, 20L);
        }
    }

    public boolean isCompleted() {
        return this.Sv;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.So != null) {
            this.So.onDetachedFromWindow();
        }
    }

    public boolean pg() {
        return this.Ro != null && this.Ro.isPlaying();
    }
}
