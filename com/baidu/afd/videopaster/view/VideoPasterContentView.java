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
    private QuickVideoView TC;
    private n TD;
    private j UB;
    private a UC;
    private boolean UD;
    private g UE;
    private boolean UF;
    private int UG;
    private long UH;
    private boolean UI;
    private boolean UJ;
    private int UK;
    private Runnable UL;
    private VideoPasterOverlayView Ux;
    private TbImageView Uy;
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
        this.UD = false;
        this.UF = false;
        this.UG = 100;
        this.mStartPosition = 0;
        this.UI = false;
        this.UJ = false;
        this.UK = 0;
        this.UL = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.jH().removeCallbacks(VideoPasterContentView.this.UL);
                if (!VideoPasterContentView.this.UF) {
                    boolean z = VideoPasterContentView.this.TC.getCurrentPosition() == 0 && VideoPasterContentView.this.UG == 100;
                    if (VideoPasterContentView.this.TC.getCurrentPosition() > VideoPasterContentView.this.UG) {
                        VideoPasterContentView.this.qB();
                    } else if (z) {
                        e.jH().postDelayed(VideoPasterContentView.this.UL, 20L);
                    } else {
                        VideoPasterContentView.this.qB();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Ux = new VideoPasterOverlayView(getContext());
        this.Uy = new TbImageView(getContext());
        this.Uz = new TbImageView(getContext());
        this.TC = new QuickVideoView(getContext());
        this.TC.setBackgroundResource(d.C0236d.black_alpha100);
        this.TD = new n(getContext());
        this.TC.setPlayerReuseEnable(true);
        this.TC.setContinuePlayEnable(true);
        this.TC.setBusiness(this.TD);
        this.TC.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.UK = gVar.getDuration();
                    if (VideoPasterContentView.this.Ux != null) {
                        VideoPasterContentView.this.Ux.b(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.TC.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.TC.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.qD();
            }
        });
        this.TC.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.qD();
                return false;
            }
        });
        this.TC.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.UF = false;
                VideoPasterContentView.this.UG = 100;
                e.jH().removeCallbacks(VideoPasterContentView.this.UL);
            }
        });
        this.UB = new j();
        this.UB.setPlayer(this.TC);
        this.UB.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Ux.a(this.pasterData, z, z2);
            if (!this.UD) {
                if (this.pasterData.qu() == 0) {
                    this.Ux.setCountDownNum(this.pasterData.TW);
                    bp(this.pasterData.TW);
                } else if (this.pasterData.qu() == 1) {
                    this.Ux.setCountDownNum(this.pasterData.TW);
                    bp(this.pasterData.TW);
                }
                this.mFrom = str;
                if (this.pasterData.qu() == 0) {
                    removeAllViews();
                    addView(this.Uy);
                    addView(this.Ux.getRootView());
                    this.Uy.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.jB().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.oy() != null && VideoPasterContentView.this.Ux != null) {
                                VideoPasterContentView.this.Ux.b(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Uy.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.qu() == 1) {
                    qC();
                    removeAllViews();
                    addView(this.TC);
                    addView(this.Uz);
                    addView(this.Ux.getRootView());
                    this.Uz.startLoad(this.pasterData.TX, 10, false);
                    this.TC.setVideoPath(this.pasterData.videoUrl);
                    this.TC.start();
                    e.jH().removeCallbacks(this.UL);
                    e.jH().postDelayed(this.UL, 20L);
                }
                this.UD = true;
                this.UI = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.qu() == 0) {
                if (this.UE != null) {
                    this.UE.pause();
                }
            } else if (this.pasterData.qu() == 1) {
                this.Uz.setVisibility(0);
                this.TC.stopPlayback();
                if (this.UB != null) {
                    this.UB.stop();
                }
                if (this.UE != null) {
                    this.UE.pause();
                }
                e.jH().removeCallbacks(this.UL);
            }
            if (this.Ux != null) {
                this.Ux.stop();
            }
            this.UI = false;
            this.UF = false;
        }
    }

    public void qg() {
        if (this.pasterData != null && this.pasterData.qu() == 1 && this.Uz != null) {
            this.Uz.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB() {
        if (!this.UF) {
            this.UF = true;
            this.Uz.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.qu() == 0) {
                if (this.UE != null) {
                    this.UE.resume();
                }
            } else if (this.pasterData.qu() == 1) {
                this.Uz.setVisibility(0);
                this.TC.setVideoPath(this.pasterData.videoUrl);
                this.TC.start();
                if (this.UB != null) {
                    this.UB.start();
                }
                if (this.UE != null) {
                    this.UE.resume();
                }
                if (this.UD) {
                    this.mStartPosition = y.bTS().AU(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.UK > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.UG = i;
                } else {
                    this.UG = 100;
                }
                e.jH().removeCallbacks(this.UL);
                e.jH().postDelayed(this.UL, 20L);
            }
            if (this.Ux != null) {
                this.Ux.resume();
            }
            this.UI = true;
        }
    }

    private void bp(int i) {
        if (this.UE != null) {
            this.UE.stop();
            this.UE.a((g.a) null);
        }
        this.UE = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.UE.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.UH = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Ux != null) {
                    VideoPasterContentView.this.Ux.setCountDownNum((int) VideoPasterContentView.this.UH);
                }
                if (VideoPasterContentView.this.UH == 0) {
                    VideoPasterContentView.this.qD();
                    VideoPasterContentView.this.UE.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void s(long j) {
                VideoPasterContentView.this.qD();
            }
        });
        this.UE.start();
        this.UJ = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Ux != null) {
            this.Ux.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.UC = aVar;
    }

    public boolean qb() {
        return this.UD;
    }

    public boolean qc() {
        return this.UI;
    }

    public void reset() {
        qC();
        stop();
        this.Ux.reset();
        this.UD = false;
        this.pasterData = null;
        this.UH = 0L;
        this.UF = false;
        this.UG = 100;
        e.jH().removeCallbacks(this.UL);
    }

    private void qC() {
        if (this.pasterData != null && this.pasterData.qu() == 1) {
            y.bTS().remove(this.pasterData.videoUrl);
            if (this.TC != null && this.TC.getPlayer() != null) {
                this.TC.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD() {
        this.UJ = true;
        if (this.UC != null) {
            this.UC.qr();
        }
        removeAllViews();
        this.pasterData = null;
        this.UH = 0L;
        this.UD = false;
        this.UI = false;
        this.UF = false;
        this.UG = 100;
        e.jH().removeCallbacks(this.UL);
    }

    public void bk(int i) {
        if (this.Ux != null) {
            this.Ux.bk(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.UE == null) {
            return 0;
        }
        return ((int) this.UE.apT()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.TW;
    }

    public void qj() {
        if (this.Ux != null) {
            this.Ux.qj();
        }
    }

    public void qk() {
        int i = 100;
        if (this.Ux != null) {
            this.Ux.qk();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.UD && this.pasterData.qu() == 1) {
            this.Uz.setVisibility(0);
            this.mStartPosition = y.bTS().AU(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.UK > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.UG = i;
            e.jH().removeCallbacks(this.UL);
            e.jH().postDelayed(this.UL, 20L);
        }
    }

    public boolean isCompleted() {
        return this.UJ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.UC != null) {
            this.UC.onDetachedFromWindow();
        }
    }

    public boolean ql() {
        return this.TC != null && this.TC.isPlaying();
    }
}
