package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.f.e;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public class VideoPasterContentView extends FrameLayout {
    private VideoPasterOverlayView abA;
    private TbImageView abB;
    private TbImageView abC;
    private TbCyberVideoView abD;
    private f abE;
    private a abF;
    private boolean abG;
    private j abH;
    private boolean abI;
    private int abJ;
    private long abK;
    private boolean abL;
    private boolean abM;
    private int abN;
    private Runnable abO;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes.dex */
    public interface a {
        void onDetachedFromWindow();

        void rr();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.abG = false;
        this.abI = false;
        this.abJ = 100;
        this.mStartPosition = 0;
        this.abL = false;
        this.abM = false;
        this.abN = 0;
        this.abO = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mA().removeCallbacks(VideoPasterContentView.this.abO);
                if (!VideoPasterContentView.this.abI) {
                    boolean z = VideoPasterContentView.this.abD.getCurrentPositionSync() == 0 && VideoPasterContentView.this.abJ == 100;
                    if (VideoPasterContentView.this.abD.getCurrentPositionSync() > VideoPasterContentView.this.abJ) {
                        VideoPasterContentView.this.rA();
                    } else if (z) {
                        e.mA().postDelayed(VideoPasterContentView.this.abO, 20L);
                    } else {
                        VideoPasterContentView.this.rA();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.abA = new VideoPasterOverlayView(getContext());
        this.abB = new TbImageView(getContext());
        this.abC = new TbImageView(getContext());
        this.abD = new TbCyberVideoView(getContext());
        this.abD.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.abD.setContinuePlayEnable(true);
        this.abD.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.abD != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.abD.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.abD.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.abD.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.abN = VideoPasterContentView.this.abD.getDuration();
                    if (VideoPasterContentView.this.abA != null) {
                        VideoPasterContentView.this.abA.d(VideoPasterContentView.this.abD.getVideoWidth(), VideoPasterContentView.this.abD.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.abD.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.rC();
            }
        });
        this.abD.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.rC();
                return false;
            }
        });
        this.abD.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.abI = false;
                VideoPasterContentView.this.abJ = 100;
                e.mA().removeCallbacks(VideoPasterContentView.this.abO);
            }
        });
        this.abE = new f();
        this.abE.setPlayer(this.abD);
        this.abE.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void rD() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void e(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.abA.a(this.pasterData, z, z2);
            if (!this.abG) {
                if (this.pasterData.ru() == 0) {
                    this.abA.setCountDownNum(this.pasterData.aaZ);
                    bi(this.pasterData.aaZ);
                } else if (this.pasterData.ru() == 1) {
                    this.abA.setCountDownNum(this.pasterData.aaZ);
                    bi(this.pasterData.aaZ);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.ru() == 0) {
                    removeAllViews();
                    addView(this.abB);
                    addView(this.abA.getRootView(), layoutParams);
                    this.abB.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    d.mw().a(this.pasterData.picUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.abA != null) {
                                VideoPasterContentView.this.abA.d(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.abB.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.ru() == 1) {
                    rB();
                    removeAllViews();
                    addView(this.abD.getView());
                    addView(this.abC);
                    addView(this.abA.getRootView(), layoutParams);
                    this.abC.startLoad(this.pasterData.aba, 10, false);
                    this.abD.setVideoPath(this.pasterData.videoUrl);
                    this.abD.start();
                    e.mA().removeCallbacks(this.abO);
                    e.mA().postDelayed(this.abO, 20L);
                }
                this.abG = true;
                this.abL = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.ru() == 0) {
                if (this.abH != null) {
                    this.abH.pause();
                }
            } else if (this.pasterData.ru() == 1) {
                this.abC.setVisibility(0);
                this.abD.stopPlayback();
                if (this.abE != null) {
                    this.abE.stop();
                }
                if (this.abH != null) {
                    this.abH.pause();
                }
                e.mA().removeCallbacks(this.abO);
            }
            if (this.abA != null) {
                this.abA.stop();
            }
            this.abL = false;
            this.abI = false;
        }
    }

    public void rg() {
        if (this.pasterData != null && this.pasterData.ru() == 1 && this.abC != null) {
            this.abC.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        if (!this.abI) {
            this.abI = true;
            this.abC.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.ru() == 0) {
                if (this.abH != null) {
                    this.abH.resume();
                }
            } else if (this.pasterData.ru() == 1) {
                this.abC.setVisibility(0);
                this.abD.setVideoPath(this.pasterData.videoUrl);
                this.abD.start();
                if (this.abE != null) {
                    this.abE.start();
                }
                if (this.abH != null) {
                    this.abH.resume();
                }
                if (this.abG) {
                    this.mStartPosition = n.dAg().QD(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.abN > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.abJ = i;
                } else {
                    this.abJ = 100;
                }
                e.mA().removeCallbacks(this.abO);
                e.mA().postDelayed(this.abO, 20L);
            }
            if (this.abA != null) {
                this.abA.resume();
            }
            this.abL = true;
        }
    }

    private void bi(int i) {
        if (this.abH != null) {
            this.abH.stop();
            this.abH.a((j.a) null);
        }
        this.abH = new j(i * 1000, 1000L);
        this.abH.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.j.a
            public void e(long j, long j2) {
                VideoPasterContentView.this.abK = (int) (j2 / 1000);
                if (VideoPasterContentView.this.abA != null) {
                    VideoPasterContentView.this.abA.setCountDownNum((int) VideoPasterContentView.this.abK);
                }
                if (VideoPasterContentView.this.abK == 0) {
                    VideoPasterContentView.this.rC();
                    VideoPasterContentView.this.abH.stop();
                }
            }

            @Override // com.baidu.tbadk.util.j.a
            public void N(long j) {
                VideoPasterContentView.this.rC();
            }
        });
        this.abH.start();
        this.abM = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.abA != null) {
            this.abA.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.abF = aVar;
    }

    public boolean rc() {
        return this.abG;
    }

    public boolean rd() {
        return this.abL;
    }

    public void reset() {
        rB();
        stop();
        this.abA.reset();
        this.abG = false;
        this.pasterData = null;
        this.abK = 0L;
        this.abI = false;
        this.abJ = 100;
        e.mA().removeCallbacks(this.abO);
    }

    private void rB() {
        if (this.pasterData != null && this.pasterData.ru() == 1) {
            n.dAg().remove(this.pasterData.videoUrl);
            if (this.abD != null) {
                this.abD.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        this.abM = true;
        if (this.abF != null) {
            this.abF.rr();
        }
        removeAllViews();
        this.pasterData = null;
        this.abK = 0L;
        this.abG = false;
        this.abL = false;
        this.abI = false;
        this.abJ = 100;
        e.mA().removeCallbacks(this.abO);
    }

    public void be(int i) {
        if (this.abA != null) {
            this.abA.be(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.abH == null) {
            return 0;
        }
        return ((int) this.abH.bFp()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.aaZ;
    }

    public void rj() {
        if (this.abA != null) {
            this.abA.rj();
        }
    }

    public void rk() {
        int i = 100;
        if (this.abA != null) {
            this.abA.rk();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.abG && this.pasterData.ru() == 1) {
            this.abC.setVisibility(0);
            this.mStartPosition = n.dAg().QD(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.abN > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.abJ = i;
            e.mA().removeCallbacks(this.abO);
            e.mA().postDelayed(this.abO, 20L);
        }
    }

    public boolean isCompleted() {
        return this.abM;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.abF != null) {
            this.abF.onDetachedFromWindow();
        }
    }

    public boolean rl() {
        return this.abD != null && this.abD.isPlaying();
    }
}
