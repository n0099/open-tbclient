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
    private QuickVideoView TF;
    private n TG;
    private TbImageView UB;
    private TbImageView UC;
    private j UD;
    private a UE;
    private boolean UF;
    private g UG;
    private boolean UH;
    private int UI;
    private long UJ;
    private boolean UK;
    private boolean UL;
    private int UM;
    private Runnable UN;
    private VideoPasterOverlayView Uz;
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
        this.UF = false;
        this.UH = false;
        this.UI = 100;
        this.mStartPosition = 0;
        this.UK = false;
        this.UL = false;
        this.UM = 0;
        this.UN = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.jH().removeCallbacks(VideoPasterContentView.this.UN);
                if (!VideoPasterContentView.this.UH) {
                    boolean z = VideoPasterContentView.this.TF.getCurrentPosition() == 0 && VideoPasterContentView.this.UI == 100;
                    if (VideoPasterContentView.this.TF.getCurrentPosition() > VideoPasterContentView.this.UI) {
                        VideoPasterContentView.this.qB();
                    } else if (z) {
                        e.jH().postDelayed(VideoPasterContentView.this.UN, 20L);
                    } else {
                        VideoPasterContentView.this.qB();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Uz = new VideoPasterOverlayView(getContext());
        this.UB = new TbImageView(getContext());
        this.UC = new TbImageView(getContext());
        this.TF = new QuickVideoView(getContext());
        this.TF.setBackgroundResource(d.C0277d.black_alpha100);
        this.TG = new n(getContext());
        this.TF.setPlayerReuseEnable(true);
        this.TF.setContinuePlayEnable(true);
        this.TF.setBusiness(this.TG);
        this.TF.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.UM = gVar.getDuration();
                    if (VideoPasterContentView.this.Uz != null) {
                        VideoPasterContentView.this.Uz.b(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.TF.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.TF.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.qD();
            }
        });
        this.TF.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.qD();
                return false;
            }
        });
        this.TF.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.UH = false;
                VideoPasterContentView.this.UI = 100;
                e.jH().removeCallbacks(VideoPasterContentView.this.UN);
            }
        });
        this.UD = new j();
        this.UD.setPlayer(this.TF);
        this.UD.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Uz.a(this.pasterData, z, z2);
            if (!this.UF) {
                if (this.pasterData.qu() == 0) {
                    this.Uz.setCountDownNum(this.pasterData.TY);
                    bo(this.pasterData.TY);
                } else if (this.pasterData.qu() == 1) {
                    this.Uz.setCountDownNum(this.pasterData.TY);
                    bo(this.pasterData.TY);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.qu() == 0) {
                    removeAllViews();
                    addView(this.UB);
                    addView(this.Uz.getRootView(), layoutParams);
                    this.UB.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.jB().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.oy() != null && VideoPasterContentView.this.Uz != null) {
                                VideoPasterContentView.this.Uz.b(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.UB.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.qu() == 1) {
                    qC();
                    removeAllViews();
                    addView(this.TF);
                    addView(this.UC);
                    addView(this.Uz.getRootView(), layoutParams);
                    this.UC.startLoad(this.pasterData.TZ, 10, false);
                    this.TF.setVideoPath(this.pasterData.videoUrl);
                    this.TF.start();
                    e.jH().removeCallbacks(this.UN);
                    e.jH().postDelayed(this.UN, 20L);
                }
                this.UF = true;
                this.UK = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.qu() == 0) {
                if (this.UG != null) {
                    this.UG.pause();
                }
            } else if (this.pasterData.qu() == 1) {
                this.UC.setVisibility(0);
                this.TF.stopPlayback();
                if (this.UD != null) {
                    this.UD.stop();
                }
                if (this.UG != null) {
                    this.UG.pause();
                }
                e.jH().removeCallbacks(this.UN);
            }
            if (this.Uz != null) {
                this.Uz.stop();
            }
            this.UK = false;
            this.UH = false;
        }
    }

    public void qg() {
        if (this.pasterData != null && this.pasterData.qu() == 1 && this.UC != null) {
            this.UC.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB() {
        if (!this.UH) {
            this.UH = true;
            this.UC.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.qu() == 0) {
                if (this.UG != null) {
                    this.UG.resume();
                }
            } else if (this.pasterData.qu() == 1) {
                this.UC.setVisibility(0);
                this.TF.setVideoPath(this.pasterData.videoUrl);
                this.TF.start();
                if (this.UD != null) {
                    this.UD.start();
                }
                if (this.UG != null) {
                    this.UG.resume();
                }
                if (this.UF) {
                    this.mStartPosition = y.bTR().AS(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.UM > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.UI = i;
                } else {
                    this.UI = 100;
                }
                e.jH().removeCallbacks(this.UN);
                e.jH().postDelayed(this.UN, 20L);
            }
            if (this.Uz != null) {
                this.Uz.resume();
            }
            this.UK = true;
        }
    }

    private void bo(int i) {
        if (this.UG != null) {
            this.UG.stop();
            this.UG.a((g.a) null);
        }
        this.UG = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.UG.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.UJ = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Uz != null) {
                    VideoPasterContentView.this.Uz.setCountDownNum((int) VideoPasterContentView.this.UJ);
                }
                if (VideoPasterContentView.this.UJ == 0) {
                    VideoPasterContentView.this.qD();
                    VideoPasterContentView.this.UG.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void s(long j) {
                VideoPasterContentView.this.qD();
            }
        });
        this.UG.start();
        this.UL = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Uz != null) {
            this.Uz.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.UE = aVar;
    }

    public boolean qb() {
        return this.UF;
    }

    public boolean qc() {
        return this.UK;
    }

    public void reset() {
        qC();
        stop();
        this.Uz.reset();
        this.UF = false;
        this.pasterData = null;
        this.UJ = 0L;
        this.UH = false;
        this.UI = 100;
        e.jH().removeCallbacks(this.UN);
    }

    private void qC() {
        if (this.pasterData != null && this.pasterData.qu() == 1) {
            y.bTR().remove(this.pasterData.videoUrl);
            if (this.TF != null && this.TF.getPlayer() != null) {
                this.TF.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD() {
        this.UL = true;
        if (this.UE != null) {
            this.UE.qr();
        }
        removeAllViews();
        this.pasterData = null;
        this.UJ = 0L;
        this.UF = false;
        this.UK = false;
        this.UH = false;
        this.UI = 100;
        e.jH().removeCallbacks(this.UN);
    }

    public void bj(int i) {
        if (this.Uz != null) {
            this.Uz.bj(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.UG == null) {
            return 0;
        }
        return ((int) this.UG.apQ()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.TY;
    }

    public void qj() {
        if (this.Uz != null) {
            this.Uz.qj();
        }
    }

    public void qk() {
        int i = 100;
        if (this.Uz != null) {
            this.Uz.qk();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.UF && this.pasterData.qu() == 1) {
            this.UC.setVisibility(0);
            this.mStartPosition = y.bTR().AS(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.UM > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.UI = i;
            e.jH().removeCallbacks(this.UN);
            e.jH().postDelayed(this.UN, 20L);
        }
    }

    public boolean isCompleted() {
        return this.UL;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.UE != null) {
            this.UE.onDetachedFromWindow();
        }
    }

    public boolean ql() {
        return this.TF != null && this.TF.isPlaying();
    }
}
