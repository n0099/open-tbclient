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
    private VideoPasterOverlayView BW;
    private TbImageView BX;
    private TbImageView BY;
    private j BZ;
    private QuickVideoView Be;
    private n Bf;
    private a Ca;
    private boolean Cb;
    private g Cc;
    private boolean Cd;
    private int Ce;
    private long Cf;
    private boolean Cg;
    private boolean Ch;
    private int Ci;
    private Runnable Cj;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes3.dex */
    public interface a {
        void kD();

        void onDetachedFromWindow();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.Cb = false;
        this.Cd = false;
        this.Ce = 100;
        this.mStartPosition = 0;
        this.Cg = false;
        this.Ch = false;
        this.Ci = 0;
        this.Cj = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.fZ().removeCallbacks(VideoPasterContentView.this.Cj);
                if (!VideoPasterContentView.this.Cd) {
                    boolean z = VideoPasterContentView.this.Be.getCurrentPosition() == 0 && VideoPasterContentView.this.Ce == 100;
                    if (VideoPasterContentView.this.Be.getCurrentPosition() > VideoPasterContentView.this.Ce) {
                        VideoPasterContentView.this.kM();
                    } else if (z) {
                        e.fZ().postDelayed(VideoPasterContentView.this.Cj, 20L);
                    } else {
                        VideoPasterContentView.this.kM();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.BW = new VideoPasterOverlayView(getContext());
        this.BX = new TbImageView(getContext());
        this.BY = new TbImageView(getContext());
        this.Be = new QuickVideoView(getContext());
        this.Be.setBackgroundResource(R.color.black_alpha100);
        this.Bf = new n(getContext());
        this.Be.setPlayerReuseEnable(true);
        this.Be.setContinuePlayEnable(true);
        this.Be.setBusiness(this.Bf);
        this.Be.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Ci = gVar.getDuration();
                    if (VideoPasterContentView.this.BW != null) {
                        VideoPasterContentView.this.BW.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Be.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.Be.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.kO();
            }
        });
        this.Be.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.kO();
                return false;
            }
        });
        this.Be.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Cd = false;
                VideoPasterContentView.this.Ce = 100;
                e.fZ().removeCallbacks(VideoPasterContentView.this.Cj);
            }
        });
        this.BZ = new j();
        this.BZ.setPlayer(this.Be);
        this.BZ.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void kP() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.BW.a(this.pasterData, z, z2);
            if (!this.Cb) {
                if (this.pasterData.kG() == 0) {
                    this.BW.setCountDownNum(this.pasterData.Bv);
                    aw(this.pasterData.Bv);
                } else if (this.pasterData.kG() == 1) {
                    this.BW.setCountDownNum(this.pasterData.Bv);
                    aw(this.pasterData.Bv);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.kG() == 0) {
                    removeAllViews();
                    addView(this.BX);
                    addView(this.BW.getRootView(), layoutParams);
                    this.BX.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.fT().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.BW != null) {
                                VideoPasterContentView.this.BW.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.BX.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.kG() == 1) {
                    kN();
                    removeAllViews();
                    addView(this.Be);
                    addView(this.BY);
                    addView(this.BW.getRootView(), layoutParams);
                    this.BY.startLoad(this.pasterData.Bw, 10, false);
                    this.Be.setVideoPath(this.pasterData.videoUrl);
                    this.Be.start();
                    e.fZ().removeCallbacks(this.Cj);
                    e.fZ().postDelayed(this.Cj, 20L);
                }
                this.Cb = true;
                this.Cg = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.kG() == 0) {
                if (this.Cc != null) {
                    this.Cc.pause();
                }
            } else if (this.pasterData.kG() == 1) {
                this.BY.setVisibility(0);
                this.Be.stopPlayback();
                if (this.BZ != null) {
                    this.BZ.stop();
                }
                if (this.Cc != null) {
                    this.Cc.pause();
                }
                e.fZ().removeCallbacks(this.Cj);
            }
            if (this.BW != null) {
                this.BW.stop();
            }
            this.Cg = false;
            this.Cd = false;
        }
    }

    public void ks() {
        if (this.pasterData != null && this.pasterData.kG() == 1 && this.BY != null) {
            this.BY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM() {
        if (!this.Cd) {
            this.Cd = true;
            this.BY.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.kG() == 0) {
                if (this.Cc != null) {
                    this.Cc.resume();
                }
            } else if (this.pasterData.kG() == 1) {
                this.BY.setVisibility(0);
                this.Be.setVideoPath(this.pasterData.videoUrl);
                this.Be.start();
                if (this.BZ != null) {
                    this.BZ.start();
                }
                if (this.Cc != null) {
                    this.Cc.resume();
                }
                if (this.Cb) {
                    this.mStartPosition = y.ccT().BS(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Ci > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Ce = i;
                } else {
                    this.Ce = 100;
                }
                e.fZ().removeCallbacks(this.Cj);
                e.fZ().postDelayed(this.Cj, 20L);
            }
            if (this.BW != null) {
                this.BW.resume();
            }
            this.Cg = true;
        }
    }

    private void aw(int i) {
        if (this.Cc != null) {
            this.Cc.stop();
            this.Cc.a((g.a) null);
        }
        this.Cc = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.Cc.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Cf = (int) (j2 / 1000);
                if (VideoPasterContentView.this.BW != null) {
                    VideoPasterContentView.this.BW.setCountDownNum((int) VideoPasterContentView.this.Cf);
                }
                if (VideoPasterContentView.this.Cf == 0) {
                    VideoPasterContentView.this.kO();
                    VideoPasterContentView.this.Cc.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void p(long j) {
                VideoPasterContentView.this.kO();
            }
        });
        this.Cc.start();
        this.Ch = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.BW != null) {
            this.BW.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.Ca = aVar;
    }

    public boolean kn() {
        return this.Cb;
    }

    public boolean ko() {
        return this.Cg;
    }

    public void reset() {
        kN();
        stop();
        this.BW.reset();
        this.Cb = false;
        this.pasterData = null;
        this.Cf = 0L;
        this.Cd = false;
        this.Ce = 100;
        e.fZ().removeCallbacks(this.Cj);
    }

    private void kN() {
        if (this.pasterData != null && this.pasterData.kG() == 1) {
            y.ccT().remove(this.pasterData.videoUrl);
            if (this.Be != null && this.Be.getPlayer() != null) {
                this.Be.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO() {
        this.Ch = true;
        if (this.Ca != null) {
            this.Ca.kD();
        }
        removeAllViews();
        this.pasterData = null;
        this.Cf = 0L;
        this.Cb = false;
        this.Cg = false;
        this.Cd = false;
        this.Ce = 100;
        e.fZ().removeCallbacks(this.Cj);
    }

    public void ar(int i) {
        if (this.BW != null) {
            this.BW.ar(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Cc == null) {
            return 0;
        }
        return ((int) this.Cc.axw()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Bv;
    }

    public void kv() {
        if (this.BW != null) {
            this.BW.kv();
        }
    }

    public void kw() {
        int i = 100;
        if (this.BW != null) {
            this.BW.kw();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Cb && this.pasterData.kG() == 1) {
            this.BY.setVisibility(0);
            this.mStartPosition = y.ccT().BS(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Ci > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Ce = i;
            e.fZ().removeCallbacks(this.Cj);
            e.fZ().postDelayed(this.Cj, 20L);
        }
    }

    public boolean aK() {
        return this.Ch;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Ca != null) {
            this.Ca.onDetachedFromWindow();
        }
    }

    public boolean kx() {
        return this.Be != null && this.Be.isPlaying();
    }
}
