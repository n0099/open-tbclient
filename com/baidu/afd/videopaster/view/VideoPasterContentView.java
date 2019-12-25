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
/* loaded from: classes5.dex */
public class VideoPasterContentView extends FrameLayout {
    private QuickVideoView Di;
    private n Dj;
    private VideoPasterOverlayView Ec;
    private TbImageView Ed;
    private TbImageView Ee;
    private j Ef;
    private a Eg;
    private boolean Eh;
    private i Ei;
    private boolean Ej;
    private int Ek;
    private long El;
    private boolean Em;
    private boolean En;
    private int Eo;
    private Runnable Ep;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes5.dex */
    public interface a {
        void kU();

        void onDetachedFromWindow();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.Eh = false;
        this.Ej = false;
        this.Ek = 100;
        this.mStartPosition = 0;
        this.Em = false;
        this.En = false;
        this.Eo = 0;
        this.Ep = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.gy().removeCallbacks(VideoPasterContentView.this.Ep);
                if (!VideoPasterContentView.this.Ej) {
                    boolean z = VideoPasterContentView.this.Di.getCurrentPosition() == 0 && VideoPasterContentView.this.Ek == 100;
                    if (VideoPasterContentView.this.Di.getCurrentPosition() > VideoPasterContentView.this.Ek) {
                        VideoPasterContentView.this.ld();
                    } else if (z) {
                        e.gy().postDelayed(VideoPasterContentView.this.Ep, 20L);
                    } else {
                        VideoPasterContentView.this.ld();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Ec = new VideoPasterOverlayView(getContext());
        this.Ed = new TbImageView(getContext());
        this.Ee = new TbImageView(getContext());
        this.Di = new QuickVideoView(getContext());
        this.Di.setBackgroundResource(R.color.black_alpha100);
        this.Dj = new n(getContext());
        this.Di.setPlayerReuseEnable(true);
        this.Di.setContinuePlayEnable(true);
        this.Di.setBusiness(this.Dj);
        this.Di.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Eo = gVar.getDuration();
                    if (VideoPasterContentView.this.Ec != null) {
                        VideoPasterContentView.this.Ec.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Di.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return false;
            }
        });
        this.Di.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                VideoPasterContentView.this.lf();
            }
        });
        this.Di.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                VideoPasterContentView.this.lf();
                return false;
            }
        });
        this.Di.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Ej = false;
                VideoPasterContentView.this.Ek = 100;
                e.gy().removeCallbacks(VideoPasterContentView.this.Ep);
            }
        });
        this.Ef = new j();
        this.Ef.setPlayer(this.Di);
        this.Ef.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void lg() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Ec.a(this.pasterData, z, z2);
            if (!this.Eh) {
                if (this.pasterData.kX() == 0) {
                    this.Ec.setCountDownNum(this.pasterData.Dy);
                    az(this.pasterData.Dy);
                } else if (this.pasterData.kX() == 1) {
                    this.Ec.setCountDownNum(this.pasterData.Dy);
                    az(this.pasterData.Dy);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.kX() == 0) {
                    removeAllViews();
                    addView(this.Ed);
                    addView(this.Ec.getRootView(), layoutParams);
                    this.Ed.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.gs().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.Ec != null) {
                                VideoPasterContentView.this.Ec.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Ed.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.kX() == 1) {
                    le();
                    removeAllViews();
                    addView(this.Di);
                    addView(this.Ee);
                    addView(this.Ec.getRootView(), layoutParams);
                    this.Ee.startLoad(this.pasterData.Dz, 10, false);
                    this.Di.setVideoPath(this.pasterData.videoUrl);
                    this.Di.start();
                    e.gy().removeCallbacks(this.Ep);
                    e.gy().postDelayed(this.Ep, 20L);
                }
                this.Eh = true;
                this.Em = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.kX() == 0) {
                if (this.Ei != null) {
                    this.Ei.pause();
                }
            } else if (this.pasterData.kX() == 1) {
                this.Ee.setVisibility(0);
                this.Di.stopPlayback();
                if (this.Ef != null) {
                    this.Ef.stop();
                }
                if (this.Ei != null) {
                    this.Ei.pause();
                }
                e.gy().removeCallbacks(this.Ep);
            }
            if (this.Ec != null) {
                this.Ec.stop();
            }
            this.Em = false;
            this.Ej = false;
        }
    }

    public void kJ() {
        if (this.pasterData != null && this.pasterData.kX() == 1 && this.Ee != null) {
            this.Ee.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        if (!this.Ej) {
            this.Ej = true;
            this.Ee.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.kX() == 0) {
                if (this.Ei != null) {
                    this.Ei.resume();
                }
            } else if (this.pasterData.kX() == 1) {
                this.Ee.setVisibility(0);
                this.Di.setVideoPath(this.pasterData.videoUrl);
                this.Di.start();
                if (this.Ef != null) {
                    this.Ef.start();
                }
                if (this.Ei != null) {
                    this.Ei.resume();
                }
                if (this.Eh) {
                    this.mStartPosition = x.cwN().GF(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Eo > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Ek = i;
                } else {
                    this.Ek = 100;
                }
                e.gy().removeCallbacks(this.Ep);
                e.gy().postDelayed(this.Ep, 20L);
            }
            if (this.Ec != null) {
                this.Ec.resume();
            }
            this.Em = true;
        }
    }

    private void az(int i) {
        if (this.Ei != null) {
            this.Ei.stop();
            this.Ei.a((i.a) null);
        }
        this.Ei = new i(i * 1000, 1000L);
        this.Ei.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.El = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Ec != null) {
                    VideoPasterContentView.this.Ec.setCountDownNum((int) VideoPasterContentView.this.El);
                }
                if (VideoPasterContentView.this.El == 0) {
                    VideoPasterContentView.this.lf();
                    VideoPasterContentView.this.Ei.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void q(long j) {
                VideoPasterContentView.this.lf();
            }
        });
        this.Ei.start();
        this.En = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Ec != null) {
            this.Ec.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.Eg = aVar;
    }

    public boolean kE() {
        return this.Eh;
    }

    public boolean kF() {
        return this.Em;
    }

    public void reset() {
        le();
        stop();
        this.Ec.reset();
        this.Eh = false;
        this.pasterData = null;
        this.El = 0L;
        this.Ej = false;
        this.Ek = 100;
        e.gy().removeCallbacks(this.Ep);
    }

    private void le() {
        if (this.pasterData != null && this.pasterData.kX() == 1) {
            x.cwN().remove(this.pasterData.videoUrl);
            if (this.Di != null && this.Di.getPlayer() != null) {
                this.Di.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf() {
        this.En = true;
        if (this.Eg != null) {
            this.Eg.kU();
        }
        removeAllViews();
        this.pasterData = null;
        this.El = 0L;
        this.Eh = false;
        this.Em = false;
        this.Ej = false;
        this.Ek = 100;
        e.gy().removeCallbacks(this.Ep);
    }

    public void au(int i) {
        if (this.Ec != null) {
            this.Ec.au(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Ei == null) {
            return 0;
        }
        return ((int) this.Ei.aPl()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Dy;
    }

    public void kM() {
        if (this.Ec != null) {
            this.Ec.kM();
        }
    }

    public void kN() {
        int i = 100;
        if (this.Ec != null) {
            this.Ec.kN();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Eh && this.pasterData.kX() == 1) {
            this.Ee.setVisibility(0);
            this.mStartPosition = x.cwN().GF(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Eo > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Ek = i;
            e.gy().removeCallbacks(this.Ep);
            e.gy().postDelayed(this.Ep, 20L);
        }
    }

    public boolean aW() {
        return this.En;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Eg != null) {
            this.Eg.onDetachedFromWindow();
        }
    }

    public boolean kO() {
        return this.Di != null && this.Di.isPlaying();
    }
}
