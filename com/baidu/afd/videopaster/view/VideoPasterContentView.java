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
    private QuickVideoView AC;
    private n AD;
    private a BA;
    private boolean BB;
    private g BC;
    private boolean BD;
    private int BE;
    private long BF;
    private boolean BG;
    private boolean BH;
    private int BI;
    private Runnable BJ;
    private VideoPasterOverlayView Bw;
    private TbImageView Bx;
    private TbImageView By;
    private j Bz;
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
        this.BB = false;
        this.BD = false;
        this.BE = 100;
        this.mStartPosition = 0;
        this.BG = false;
        this.BH = false;
        this.BI = 0;
        this.BJ = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // java.lang.Runnable
            public void run() {
                e.fZ().removeCallbacks(VideoPasterContentView.this.BJ);
                if (!VideoPasterContentView.this.BD) {
                    boolean z = VideoPasterContentView.this.AC.getCurrentPosition() == 0 && VideoPasterContentView.this.BE == 100;
                    if (VideoPasterContentView.this.AC.getCurrentPosition() > VideoPasterContentView.this.BE) {
                        VideoPasterContentView.this.kM();
                    } else if (z) {
                        e.fZ().postDelayed(VideoPasterContentView.this.BJ, 20L);
                    } else {
                        VideoPasterContentView.this.kM();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Bw = new VideoPasterOverlayView(getContext());
        this.Bx = new TbImageView(getContext());
        this.By = new TbImageView(getContext());
        this.AC = new QuickVideoView(getContext());
        this.AC.setBackgroundResource(R.color.black_alpha100);
        this.AD = new n(getContext());
        this.AC.setPlayerReuseEnable(true);
        this.AC.setContinuePlayEnable(true);
        this.AC.setBusiness(this.AD);
        this.AC.setOnPreparedListener(new g.f() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
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
                    VideoPasterContentView.this.BI = gVar.getDuration();
                    if (VideoPasterContentView.this.Bw != null) {
                        VideoPasterContentView.this.Bw.c(gVar.getVideoWidth(), gVar.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.AC.setOnOutInfoListener(new g.e() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                return false;
            }
        });
        this.AC.setOnCompletionListener(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                VideoPasterContentView.this.kO();
            }
        });
        this.AC.setOnErrorListener(new g.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                VideoPasterContentView.this.kO();
                return false;
            }
        });
        this.AC.setOnSurfaceDestroyedListener(new QuickVideoView.b() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.BD = false;
                VideoPasterContentView.this.BE = 100;
                e.fZ().removeCallbacks(VideoPasterContentView.this.BJ);
            }
        });
        this.Bz = new j();
        this.Bz.setPlayer(this.AC);
        this.Bz.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
            @Override // com.baidu.tieba.play.j.a
            public void kP() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Bw.a(this.pasterData, z, z2);
            if (!this.BB) {
                if (this.pasterData.kG() == 0) {
                    this.Bw.setCountDownNum(this.pasterData.AV);
                    aw(this.pasterData.AV);
                } else if (this.pasterData.kG() == 1) {
                    this.Bw.setCountDownNum(this.pasterData.AV);
                    aw(this.pasterData.AV);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.kG() == 0) {
                    removeAllViews();
                    addView(this.Bx);
                    addView(this.Bw.getRootView(), layoutParams);
                    this.Bx.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.fT().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass7) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.Bw != null) {
                                VideoPasterContentView.this.Bw.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Bx.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.kG() == 1) {
                    kN();
                    removeAllViews();
                    addView(this.AC);
                    addView(this.By);
                    addView(this.Bw.getRootView(), layoutParams);
                    this.By.startLoad(this.pasterData.AW, 10, false);
                    this.AC.setVideoPath(this.pasterData.videoUrl);
                    this.AC.start();
                    e.fZ().removeCallbacks(this.BJ);
                    e.fZ().postDelayed(this.BJ, 20L);
                }
                this.BB = true;
                this.BG = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.kG() == 0) {
                if (this.BC != null) {
                    this.BC.pause();
                }
            } else if (this.pasterData.kG() == 1) {
                this.By.setVisibility(0);
                this.AC.stopPlayback();
                if (this.Bz != null) {
                    this.Bz.stop();
                }
                if (this.BC != null) {
                    this.BC.pause();
                }
                e.fZ().removeCallbacks(this.BJ);
            }
            if (this.Bw != null) {
                this.Bw.stop();
            }
            this.BG = false;
            this.BD = false;
        }
    }

    public void ks() {
        if (this.pasterData != null && this.pasterData.kG() == 1 && this.By != null) {
            this.By.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM() {
        if (!this.BD) {
            this.BD = true;
            this.By.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.kG() == 0) {
                if (this.BC != null) {
                    this.BC.resume();
                }
            } else if (this.pasterData.kG() == 1) {
                this.By.setVisibility(0);
                this.AC.setVideoPath(this.pasterData.videoUrl);
                this.AC.start();
                if (this.Bz != null) {
                    this.Bz.start();
                }
                if (this.BC != null) {
                    this.BC.resume();
                }
                if (this.BB) {
                    this.mStartPosition = y.ccR().BS(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.BI > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.BE = i;
                } else {
                    this.BE = 100;
                }
                e.fZ().removeCallbacks(this.BJ);
                e.fZ().postDelayed(this.BJ, 20L);
            }
            if (this.Bw != null) {
                this.Bw.resume();
            }
            this.BG = true;
        }
    }

    private void aw(int i) {
        if (this.BC != null) {
            this.BC.stop();
            this.BC.a((g.a) null);
        }
        this.BC = new com.baidu.tbadk.util.g(i * 1000, 1000L);
        this.BC.a(new g.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.9
            @Override // com.baidu.tbadk.util.g.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.BF = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Bw != null) {
                    VideoPasterContentView.this.Bw.setCountDownNum((int) VideoPasterContentView.this.BF);
                }
                if (VideoPasterContentView.this.BF == 0) {
                    VideoPasterContentView.this.kO();
                    VideoPasterContentView.this.BC.stop();
                }
            }

            @Override // com.baidu.tbadk.util.g.a
            public void o(long j) {
                VideoPasterContentView.this.kO();
            }
        });
        this.BC.start();
        this.BH = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Bw != null) {
            this.Bw.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.BA = aVar;
    }

    public boolean kn() {
        return this.BB;
    }

    public boolean ko() {
        return this.BG;
    }

    public void reset() {
        kN();
        stop();
        this.Bw.reset();
        this.BB = false;
        this.pasterData = null;
        this.BF = 0L;
        this.BD = false;
        this.BE = 100;
        e.fZ().removeCallbacks(this.BJ);
    }

    private void kN() {
        if (this.pasterData != null && this.pasterData.kG() == 1) {
            y.ccR().remove(this.pasterData.videoUrl);
            if (this.AC != null && this.AC.getPlayer() != null) {
                this.AC.getPlayer().seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO() {
        this.BH = true;
        if (this.BA != null) {
            this.BA.kD();
        }
        removeAllViews();
        this.pasterData = null;
        this.BF = 0L;
        this.BB = false;
        this.BG = false;
        this.BD = false;
        this.BE = 100;
        e.fZ().removeCallbacks(this.BJ);
    }

    public void ar(int i) {
        if (this.Bw != null) {
            this.Bw.ar(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.BC == null) {
            return 0;
        }
        return ((int) this.BC.axu()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.AV;
    }

    public void kv() {
        if (this.Bw != null) {
            this.Bw.kv();
        }
    }

    public void kw() {
        int i = 100;
        if (this.Bw != null) {
            this.Bw.kw();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.BB && this.pasterData.kG() == 1) {
            this.By.setVisibility(0);
            this.mStartPosition = y.ccR().BS(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.BI > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.BE = i;
            e.fZ().removeCallbacks(this.BJ);
            e.fZ().postDelayed(this.BJ, 20L);
        }
    }

    public boolean aK() {
        return this.BH;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.BA != null) {
            this.BA.onDetachedFromWindow();
        }
    }

    public boolean kx() {
        return this.AC != null && this.AC.isPlaying();
    }
}
