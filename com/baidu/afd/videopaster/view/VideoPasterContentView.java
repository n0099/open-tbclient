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
    private QuickVideoView DI;
    private n DJ;
    private VideoPasterOverlayView EA;
    private TbImageView EB;
    private TbImageView ED;
    private j EE;
    private a EF;
    private boolean EG;
    private i EH;
    private boolean EI;
    private int EJ;
    private long EK;
    private boolean EL;
    private boolean EM;
    private int EN;
    private Runnable EO;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes8.dex */
    public interface a {
        void lk();

        void onDetachedFromWindow();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.EG = false;
        this.EI = false;
        this.EJ = 100;
        this.mStartPosition = 0;
        this.EL = false;
        this.EM = false;
        this.EN = 0;
        this.EO = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.gx().removeCallbacks(VideoPasterContentView.this.EO);
                if (!VideoPasterContentView.this.EI) {
                    boolean z = VideoPasterContentView.this.DI.getCurrentPosition() == 0 && VideoPasterContentView.this.EJ == 100;
                    if (VideoPasterContentView.this.DI.getCurrentPosition() > VideoPasterContentView.this.EJ) {
                        VideoPasterContentView.this.lt();
                    } else if (z) {
                        e.gx().postDelayed(VideoPasterContentView.this.EO, 20L);
                    } else {
                        VideoPasterContentView.this.lt();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.EA = new VideoPasterOverlayView(getContext());
        this.EB = new TbImageView(getContext());
        this.ED = new TbImageView(getContext());
        this.DI = new QuickVideoView(getContext());
        this.DI.setBackgroundResource(R.color.black_alpha100);
        this.DJ = new n(getContext());
        this.DI.setPlayerReuseEnable(true);
        this.DI.setContinuePlayEnable(true);
        this.DI.setBusiness(this.DJ);
        this.DI.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.EN = gVar.getDuration();
                    if (VideoPasterContentView.this.EA != null) {
                        VideoPasterContentView.this.EA.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.DI.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return false;
            }
        });
        this.DI.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                VideoPasterContentView.this.lv();
            }
        });
        this.DI.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                VideoPasterContentView.this.lv();
                return false;
            }
        });
        this.DI.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.EI = false;
                VideoPasterContentView.this.EJ = 100;
                e.gx().removeCallbacks(VideoPasterContentView.this.EO);
            }
        });
        this.EE = new j();
        this.EE.setPlayer(this.DI);
        this.EE.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.EA.a(this.pasterData, z, z2);
            if (!this.EG) {
                if (this.pasterData.ln() == 0) {
                    this.EA.setCountDownNum(this.pasterData.Ea);
                    aC(this.pasterData.Ea);
                } else if (this.pasterData.ln() == 1) {
                    this.EA.setCountDownNum(this.pasterData.Ea);
                    aC(this.pasterData.Ea);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.ln() == 0) {
                    removeAllViews();
                    addView(this.EB);
                    addView(this.EA.getRootView(), layoutParams);
                    this.EB.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.gr().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.EA != null) {
                                VideoPasterContentView.this.EA.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.EB.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.ln() == 1) {
                    lu();
                    removeAllViews();
                    addView(this.DI);
                    addView(this.ED);
                    addView(this.EA.getRootView(), layoutParams);
                    this.ED.startLoad(this.pasterData.Eb, 10, false);
                    this.DI.setVideoPath(this.pasterData.videoUrl);
                    this.DI.start();
                    e.gx().removeCallbacks(this.EO);
                    e.gx().postDelayed(this.EO, 20L);
                }
                this.EG = true;
                this.EL = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.ln() == 0) {
                if (this.EH != null) {
                    this.EH.pause();
                }
            } else if (this.pasterData.ln() == 1) {
                this.ED.setVisibility(0);
                this.DI.stopPlayback();
                if (this.EE != null) {
                    this.EE.stop();
                }
                if (this.EH != null) {
                    this.EH.pause();
                }
                e.gx().removeCallbacks(this.EO);
            }
            if (this.EA != null) {
                this.EA.stop();
            }
            this.EL = false;
            this.EI = false;
        }
    }

    public void kZ() {
        if (this.pasterData != null && this.pasterData.ln() == 1 && this.ED != null) {
            this.ED.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        if (!this.EI) {
            this.EI = true;
            this.ED.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.ln() == 0) {
                if (this.EH != null) {
                    this.EH.resume();
                }
            } else if (this.pasterData.ln() == 1) {
                this.ED.setVisibility(0);
                this.DI.setVideoPath(this.pasterData.videoUrl);
                this.DI.start();
                if (this.EE != null) {
                    this.EE.start();
                }
                if (this.EH != null) {
                    this.EH.resume();
                }
                if (this.EG) {
                    this.mStartPosition = x.czM().He(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.EN > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.EJ = i;
                } else {
                    this.EJ = 100;
                }
                e.gx().removeCallbacks(this.EO);
                e.gx().postDelayed(this.EO, 20L);
            }
            if (this.EA != null) {
                this.EA.resume();
            }
            this.EL = true;
        }
    }

    private void aC(int i) {
        if (this.EH != null) {
            this.EH.stop();
            this.EH.a((i.a) null);
        }
        this.EH = new i(i * 1000, 1000L);
        this.EH.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.EK = (int) (j2 / 1000);
                if (VideoPasterContentView.this.EA != null) {
                    VideoPasterContentView.this.EA.setCountDownNum((int) VideoPasterContentView.this.EK);
                }
                if (VideoPasterContentView.this.EK == 0) {
                    VideoPasterContentView.this.lv();
                    VideoPasterContentView.this.EH.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void r(long j) {
                VideoPasterContentView.this.lv();
            }
        });
        this.EH.start();
        this.EM = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.EA != null) {
            this.EA.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.EF = aVar;
    }

    public boolean kU() {
        return this.EG;
    }

    public boolean kV() {
        return this.EL;
    }

    public void reset() {
        lu();
        stop();
        this.EA.reset();
        this.EG = false;
        this.pasterData = null;
        this.EK = 0L;
        this.EI = false;
        this.EJ = 100;
        e.gx().removeCallbacks(this.EO);
    }

    private void lu() {
        if (this.pasterData != null && this.pasterData.ln() == 1) {
            x.czM().remove(this.pasterData.videoUrl);
            if (this.DI != null && this.DI.getPlayer() != null) {
                this.DI.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv() {
        this.EM = true;
        if (this.EF != null) {
            this.EF.lk();
        }
        removeAllViews();
        this.pasterData = null;
        this.EK = 0L;
        this.EG = false;
        this.EL = false;
        this.EI = false;
        this.EJ = 100;
        e.gx().removeCallbacks(this.EO);
    }

    public void ax(int i) {
        if (this.EA != null) {
            this.EA.ax(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.EH == null) {
            return 0;
        }
        return ((int) this.EH.aSc()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Ea;
    }

    public void lc() {
        if (this.EA != null) {
            this.EA.lc();
        }
    }

    public void ld() {
        int i = 100;
        if (this.EA != null) {
            this.EA.ld();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.EG && this.pasterData.ln() == 1) {
            this.ED.setVisibility(0);
            this.mStartPosition = x.czM().He(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.EN > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.EJ = i;
            e.gx().removeCallbacks(this.EO);
            e.gx().postDelayed(this.EO, 20L);
        }
    }

    public boolean aW() {
        return this.EM;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.EF != null) {
            this.EF.onDetachedFromWindow();
        }
    }

    public boolean le() {
        return this.DI != null && this.DI.isPlaying();
    }
}
