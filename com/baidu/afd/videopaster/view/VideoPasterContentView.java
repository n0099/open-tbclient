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
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes3.dex */
public class VideoPasterContentView extends FrameLayout {
    private QuickVideoView TD;
    private n TF;
    private TbImageView UB;
    private j UC;
    private a UD;
    private boolean UE;
    private g UF;
    private boolean UG;
    private int UH;
    private long UI;
    private boolean UJ;
    private boolean UK;
    private int UL;
    private Runnable UM;
    private VideoPasterOverlayView Uy;
    private TbImageView Uz;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes3.dex */
    public interface a {
        void onDetachedFromWindow();

        void qr();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.UE = false;
        this.UG = false;
        this.UH = 100;
        this.mStartPosition = 0;
        this.UJ = false;
        this.UK = false;
        this.UL = 0;
        this.UM = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.jH().removeCallbacks(VideoPasterContentView.this.UM);
                if (!VideoPasterContentView.this.UG) {
                    boolean z = VideoPasterContentView.this.TD.getCurrentPosition() == 0 && VideoPasterContentView.this.UH == 100;
                    if (VideoPasterContentView.this.TD.getCurrentPosition() > VideoPasterContentView.this.UH) {
                        VideoPasterContentView.this.qB();
                    } else if (z) {
                        e.jH().postDelayed(VideoPasterContentView.this.UM, 20L);
                    } else {
                        VideoPasterContentView.this.qB();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Uy = new VideoPasterOverlayView(getContext());
        this.Uz = new TbImageView(getContext());
        this.UB = new TbImageView(getContext());
        this.TD = new QuickVideoView(getContext());
        this.TD.setBackgroundResource(d.C0277d.black_alpha100);
        this.TF = new n(getContext());
        this.TD.setPlayerReuseEnable(true);
        this.TD.setContinuePlayEnable(true);
        this.TD.setBusiness(this.TF);
        this.TD.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.UL = gVar.getDuration();
                    if (VideoPasterContentView.this.Uy != null) {
                        VideoPasterContentView.this.Uy.b(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.TD.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.TD.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.qD();
            }
        });
        this.TD.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.qD();
                return false;
            }
        });
        this.TD.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.UG = false;
                VideoPasterContentView.this.UH = 100;
                e.jH().removeCallbacks(VideoPasterContentView.this.UM);
            }
        });
        this.UC = new j();
        this.UC.setPlayer(this.TD);
        this.UC.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Uy.a(this.pasterData, z, z2);
            if (!this.UE) {
                if (this.pasterData.qu() == 0) {
                    this.Uy.setCountDownNum(this.pasterData.TX);
                    bo(this.pasterData.TX);
                } else if (this.pasterData.qu() == 1) {
                    this.Uy.setCountDownNum(this.pasterData.TX);
                    bo(this.pasterData.TX);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.qu() == 0) {
                    removeAllViews();
                    addView(this.Uz);
                    addView(this.Uy.getRootView(), layoutParams);
                    this.Uz.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.jB().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.oy() != null && VideoPasterContentView.this.Uy != null) {
                                VideoPasterContentView.this.Uy.b(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Uz.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.qu() == 1) {
                    qC();
                    removeAllViews();
                    addView(this.TD);
                    addView(this.UB);
                    addView(this.Uy.getRootView(), layoutParams);
                    this.UB.startLoad(this.pasterData.TY, 10, false);
                    this.TD.setVideoPath(this.pasterData.videoUrl);
                    this.TD.start();
                    e.jH().removeCallbacks(this.UM);
                    e.jH().postDelayed(this.UM, 20L);
                }
                this.UE = true;
                this.UJ = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.qu() == 0) {
                if (this.UF != null) {
                    this.UF.pause();
                }
            } else if (this.pasterData.qu() == 1) {
                this.UB.setVisibility(0);
                this.TD.stopPlayback();
                if (this.UC != null) {
                    this.UC.stop();
                }
                if (this.UF != null) {
                    this.UF.pause();
                }
                e.jH().removeCallbacks(this.UM);
            }
            if (this.Uy != null) {
                this.Uy.stop();
            }
            this.UJ = false;
            this.UG = false;
        }
    }

    public void qg() {
        if (this.pasterData != null && this.pasterData.qu() == 1 && this.UB != null) {
            this.UB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB() {
        if (!this.UG) {
            this.UG = true;
            this.UB.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.qu() == 0) {
                if (this.UF != null) {
                    this.UF.resume();
                }
            } else if (this.pasterData.qu() == 1) {
                this.UB.setVisibility(0);
                this.TD.setVideoPath(this.pasterData.videoUrl);
                this.TD.start();
                if (this.UC != null) {
                    this.UC.start();
                }
                if (this.UF != null) {
                    this.UF.resume();
                }
                if (this.UE) {
                    this.mStartPosition = y.bTR().AS(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.UL > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.UH = i;
                } else {
                    this.UH = 100;
                }
                e.jH().removeCallbacks(this.UM);
                e.jH().postDelayed(this.UM, 20L);
            }
            if (this.Uy != null) {
                this.Uy.resume();
            }
            this.UJ = true;
        }
    }

    private void bo(int i) {
        if (this.UF != null) {
            this.UF.stop();
            this.UF.a((g.a) null);
        }
        this.UF = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.UF.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.UI = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Uy != null) {
                    VideoPasterContentView.this.Uy.setCountDownNum((int) VideoPasterContentView.this.UI);
                }
                if (VideoPasterContentView.this.UI == 0) {
                    VideoPasterContentView.this.qD();
                    VideoPasterContentView.this.UF.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void s(long j) {
                VideoPasterContentView.this.qD();
            }
        });
        this.UF.start();
        this.UK = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Uy != null) {
            this.Uy.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.UD = aVar;
    }

    public boolean qb() {
        return this.UE;
    }

    public boolean qc() {
        return this.UJ;
    }

    public void reset() {
        qC();
        stop();
        this.Uy.reset();
        this.UE = false;
        this.pasterData = null;
        this.UI = 0L;
        this.UG = false;
        this.UH = 100;
        e.jH().removeCallbacks(this.UM);
    }

    private void qC() {
        if (this.pasterData != null && this.pasterData.qu() == 1) {
            y.bTR().remove(this.pasterData.videoUrl);
            if (this.TD != null && this.TD.getPlayer() != null) {
                this.TD.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD() {
        this.UK = true;
        if (this.UD != null) {
            this.UD.qr();
        }
        removeAllViews();
        this.pasterData = null;
        this.UI = 0L;
        this.UE = false;
        this.UJ = false;
        this.UG = false;
        this.UH = 100;
        e.jH().removeCallbacks(this.UM);
    }

    public void bj(int i) {
        if (this.Uy != null) {
            this.Uy.bj(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.UF == null) {
            return 0;
        }
        return ((int) this.UF.apQ()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.TX;
    }

    public void qj() {
        if (this.Uy != null) {
            this.Uy.qj();
        }
    }

    public void qk() {
        int i = 100;
        if (this.Uy != null) {
            this.Uy.qk();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.UE && this.pasterData.qu() == 1) {
            this.UB.setVisibility(0);
            this.mStartPosition = y.bTR().AS(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.UL > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.UH = i;
            e.jH().removeCallbacks(this.UM);
            e.jH().postDelayed(this.UM, 20L);
        }
    }

    public boolean isCompleted() {
        return this.UK;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.UD != null) {
            this.UD.onDetachedFromWindow();
        }
    }

    public boolean ql() {
        return this.TD != null && this.TD.isPlaying();
    }
}
