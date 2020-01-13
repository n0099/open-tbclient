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
/* loaded from: classes6.dex */
public class VideoPasterContentView extends FrameLayout {
    private QuickVideoView Dn;
    private n Do;
    private VideoPasterOverlayView Eh;
    private TbImageView Ei;
    private TbImageView Ej;
    private j Ek;
    private a El;
    private boolean Em;
    private i En;
    private boolean Eo;
    private int Ep;
    private long Eq;
    private boolean Er;
    private boolean Es;
    private int Et;
    private Runnable Eu;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes6.dex */
    public interface a {
        void kV();

        void onDetachedFromWindow();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.Em = false;
        this.Eo = false;
        this.Ep = 100;
        this.mStartPosition = 0;
        this.Er = false;
        this.Es = false;
        this.Et = 0;
        this.Eu = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.gx().removeCallbacks(VideoPasterContentView.this.Eu);
                if (!VideoPasterContentView.this.Eo) {
                    boolean z = VideoPasterContentView.this.Dn.getCurrentPosition() == 0 && VideoPasterContentView.this.Ep == 100;
                    if (VideoPasterContentView.this.Dn.getCurrentPosition() > VideoPasterContentView.this.Ep) {
                        VideoPasterContentView.this.le();
                    } else if (z) {
                        e.gx().postDelayed(VideoPasterContentView.this.Eu, 20L);
                    } else {
                        VideoPasterContentView.this.le();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Eh = new VideoPasterOverlayView(getContext());
        this.Ei = new TbImageView(getContext());
        this.Ej = new TbImageView(getContext());
        this.Dn = new QuickVideoView(getContext());
        this.Dn.setBackgroundResource(R.color.black_alpha100);
        this.Do = new n(getContext());
        this.Dn.setPlayerReuseEnable(true);
        this.Dn.setContinuePlayEnable(true);
        this.Dn.setBusiness(this.Do);
        this.Dn.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.Et = gVar.getDuration();
                    if (VideoPasterContentView.this.Eh != null) {
                        VideoPasterContentView.this.Eh.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Dn.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return false;
            }
        });
        this.Dn.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                VideoPasterContentView.this.lg();
            }
        });
        this.Dn.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                VideoPasterContentView.this.lg();
                return false;
            }
        });
        this.Dn.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Eo = false;
                VideoPasterContentView.this.Ep = 100;
                e.gx().removeCallbacks(VideoPasterContentView.this.Eu);
            }
        });
        this.Ek = new j();
        this.Ek.setPlayer(this.Dn);
        this.Ek.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void lh() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Eh.a(this.pasterData, z, z2);
            if (!this.Em) {
                if (this.pasterData.kY() == 0) {
                    this.Eh.setCountDownNum(this.pasterData.DE);
                    az(this.pasterData.DE);
                } else if (this.pasterData.kY() == 1) {
                    this.Eh.setCountDownNum(this.pasterData.DE);
                    az(this.pasterData.DE);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.kY() == 0) {
                    removeAllViews();
                    addView(this.Ei);
                    addView(this.Eh.getRootView(), layoutParams);
                    this.Ei.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.gr().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.Eh != null) {
                                VideoPasterContentView.this.Eh.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Ei.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.kY() == 1) {
                    lf();
                    removeAllViews();
                    addView(this.Dn);
                    addView(this.Ej);
                    addView(this.Eh.getRootView(), layoutParams);
                    this.Ej.startLoad(this.pasterData.DG, 10, false);
                    this.Dn.setVideoPath(this.pasterData.videoUrl);
                    this.Dn.start();
                    e.gx().removeCallbacks(this.Eu);
                    e.gx().postDelayed(this.Eu, 20L);
                }
                this.Em = true;
                this.Er = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.kY() == 0) {
                if (this.En != null) {
                    this.En.pause();
                }
            } else if (this.pasterData.kY() == 1) {
                this.Ej.setVisibility(0);
                this.Dn.stopPlayback();
                if (this.Ek != null) {
                    this.Ek.stop();
                }
                if (this.En != null) {
                    this.En.pause();
                }
                e.gx().removeCallbacks(this.Eu);
            }
            if (this.Eh != null) {
                this.Eh.stop();
            }
            this.Er = false;
            this.Eo = false;
        }
    }

    public void kK() {
        if (this.pasterData != null && this.pasterData.kY() == 1 && this.Ej != null) {
            this.Ej.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        if (!this.Eo) {
            this.Eo = true;
            this.Ej.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.kY() == 0) {
                if (this.En != null) {
                    this.En.resume();
                }
            } else if (this.pasterData.kY() == 1) {
                this.Ej.setVisibility(0);
                this.Dn.setVideoPath(this.pasterData.videoUrl);
                this.Dn.start();
                if (this.Ek != null) {
                    this.Ek.start();
                }
                if (this.En != null) {
                    this.En.resume();
                }
                if (this.Em) {
                    this.mStartPosition = x.cxU().GP(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Et > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Ep = i;
                } else {
                    this.Ep = 100;
                }
                e.gx().removeCallbacks(this.Eu);
                e.gx().postDelayed(this.Eu, 20L);
            }
            if (this.Eh != null) {
                this.Eh.resume();
            }
            this.Er = true;
        }
    }

    private void az(int i) {
        if (this.En != null) {
            this.En.stop();
            this.En.a((i.a) null);
        }
        this.En = new i(i * 1000, 1000L);
        this.En.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Eq = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Eh != null) {
                    VideoPasterContentView.this.Eh.setCountDownNum((int) VideoPasterContentView.this.Eq);
                }
                if (VideoPasterContentView.this.Eq == 0) {
                    VideoPasterContentView.this.lg();
                    VideoPasterContentView.this.En.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void q(long j) {
                VideoPasterContentView.this.lg();
            }
        });
        this.En.start();
        this.Es = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Eh != null) {
            this.Eh.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.El = aVar;
    }

    public boolean kF() {
        return this.Em;
    }

    public boolean kG() {
        return this.Er;
    }

    public void reset() {
        lf();
        stop();
        this.Eh.reset();
        this.Em = false;
        this.pasterData = null;
        this.Eq = 0L;
        this.Eo = false;
        this.Ep = 100;
        e.gx().removeCallbacks(this.Eu);
    }

    private void lf() {
        if (this.pasterData != null && this.pasterData.kY() == 1) {
            x.cxU().remove(this.pasterData.videoUrl);
            if (this.Dn != null && this.Dn.getPlayer() != null) {
                this.Dn.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg() {
        this.Es = true;
        if (this.El != null) {
            this.El.kV();
        }
        removeAllViews();
        this.pasterData = null;
        this.Eq = 0L;
        this.Em = false;
        this.Er = false;
        this.Eo = false;
        this.Ep = 100;
        e.gx().removeCallbacks(this.Eu);
    }

    public void au(int i) {
        if (this.Eh != null) {
            this.Eh.au(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.En == null) {
            return 0;
        }
        return ((int) this.En.aPE()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.DE;
    }

    public void kN() {
        if (this.Eh != null) {
            this.Eh.kN();
        }
    }

    public void kO() {
        int i = 100;
        if (this.Eh != null) {
            this.Eh.kO();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Em && this.pasterData.kY() == 1) {
            this.Ej.setVisibility(0);
            this.mStartPosition = x.cxU().GP(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Et > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Ep = i;
            e.gx().removeCallbacks(this.Eu);
            e.gx().postDelayed(this.Eu, 20L);
        }
    }

    public boolean aW() {
        return this.Es;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.El != null) {
            this.El.onDetachedFromWindow();
        }
    }

    public boolean kP() {
        return this.Dn != null && this.Dn.isPlaying();
    }
}
