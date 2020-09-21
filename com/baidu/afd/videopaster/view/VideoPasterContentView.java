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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
import com.tencent.connect.common.Constants;
/* loaded from: classes20.dex */
public class VideoPasterContentView extends FrameLayout {
    private VideoPasterOverlayView ZE;
    private TbImageView ZF;
    private TbImageView ZG;
    private TbCyberVideoView ZH;
    private f ZI;
    private a ZJ;
    private boolean ZK;
    private j ZL;
    private boolean ZM;
    private int ZN;
    private long ZO;
    private boolean ZP;
    private boolean ZQ;
    private int ZR;
    private Runnable ZS;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes20.dex */
    public interface a {
        void onDetachedFromWindow();

        void rQ();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.ZK = false;
        this.ZM = false;
        this.ZN = 100;
        this.mStartPosition = 0;
        this.ZP = false;
        this.ZQ = false;
        this.ZR = 0;
        this.ZS = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mX().removeCallbacks(VideoPasterContentView.this.ZS);
                if (!VideoPasterContentView.this.ZM) {
                    boolean z = VideoPasterContentView.this.ZH.getCurrentPositionSync() == 0 && VideoPasterContentView.this.ZN == 100;
                    if (VideoPasterContentView.this.ZH.getCurrentPositionSync() > VideoPasterContentView.this.ZN) {
                        VideoPasterContentView.this.rZ();
                    } else if (z) {
                        e.mX().postDelayed(VideoPasterContentView.this.ZS, 20L);
                    } else {
                        VideoPasterContentView.this.rZ();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.ZE = new VideoPasterOverlayView(getContext());
        this.ZF = new TbImageView(getContext());
        this.ZG = new TbImageView(getContext());
        this.ZH = new TbCyberVideoView(getContext());
        this.ZH.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.ZH.setContinuePlayEnable(true);
        this.ZH.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.ZH != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.ZH.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.ZH.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.ZH.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.ZR = VideoPasterContentView.this.ZH.getDuration();
                    if (VideoPasterContentView.this.ZE != null) {
                        VideoPasterContentView.this.ZE.c(VideoPasterContentView.this.ZH.getVideoWidth(), VideoPasterContentView.this.ZH.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.ZH.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.sb();
            }
        });
        this.ZH.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.sb();
                return false;
            }
        });
        this.ZH.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.ZM = false;
                VideoPasterContentView.this.ZN = 100;
                e.mX().removeCallbacks(VideoPasterContentView.this.ZS);
            }
        });
        this.ZI = new f();
        this.ZI.setPlayer(this.ZH);
        this.ZI.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.ZE.a(this.pasterData, z, z2);
            if (!this.ZK) {
                if (this.pasterData.rT() == 0) {
                    this.ZE.setCountDownNum(this.pasterData.Ze);
                    be(this.pasterData.Ze);
                } else if (this.pasterData.rT() == 1) {
                    this.ZE.setCountDownNum(this.pasterData.Ze);
                    be(this.pasterData.Ze);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rT() == 0) {
                    removeAllViews();
                    addView(this.ZF);
                    addView(this.ZE.getRootView(), layoutParams);
                    this.ZF.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.mR().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.ZE != null) {
                                VideoPasterContentView.this.ZE.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.ZF.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rT() == 1) {
                    sa();
                    removeAllViews();
                    addView(this.ZH.getView());
                    addView(this.ZG);
                    addView(this.ZE.getRootView(), layoutParams);
                    this.ZG.startLoad(this.pasterData.Zf, 10, false);
                    this.ZH.setVideoPath(this.pasterData.videoUrl);
                    this.ZH.start();
                    e.mX().removeCallbacks(this.ZS);
                    e.mX().postDelayed(this.ZS, 20L);
                }
                this.ZK = true;
                this.ZP = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.ZL != null) {
                    this.ZL.pause();
                }
            } else if (this.pasterData.rT() == 1) {
                this.ZG.setVisibility(0);
                this.ZH.stopPlayback();
                if (this.ZI != null) {
                    this.ZI.stop();
                }
                if (this.ZL != null) {
                    this.ZL.pause();
                }
                e.mX().removeCallbacks(this.ZS);
            }
            if (this.ZE != null) {
                this.ZE.stop();
            }
            this.ZP = false;
            this.ZM = false;
        }
    }

    public void rF() {
        if (this.pasterData != null && this.pasterData.rT() == 1 && this.ZG != null) {
            this.ZG.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (!this.ZM) {
            this.ZM = true;
            this.ZG.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.ZL != null) {
                    this.ZL.resume();
                }
            } else if (this.pasterData.rT() == 1) {
                this.ZG.setVisibility(0);
                this.ZH.setVideoPath(this.pasterData.videoUrl);
                this.ZH.start();
                if (this.ZI != null) {
                    this.ZI.start();
                }
                if (this.ZL != null) {
                    this.ZL.resume();
                }
                if (this.ZK) {
                    this.mStartPosition = n.dnN().Pg(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.ZR > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.ZN = i;
                } else {
                    this.ZN = 100;
                }
                e.mX().removeCallbacks(this.ZS);
                e.mX().postDelayed(this.ZS, 20L);
            }
            if (this.ZE != null) {
                this.ZE.resume();
            }
            this.ZP = true;
        }
    }

    private void be(int i) {
        if (this.ZL != null) {
            this.ZL.stop();
            this.ZL.a((j.a) null);
        }
        this.ZL = new j(i * 1000, 1000L);
        this.ZL.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.j.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.ZO = (int) (j2 / 1000);
                if (VideoPasterContentView.this.ZE != null) {
                    VideoPasterContentView.this.ZE.setCountDownNum((int) VideoPasterContentView.this.ZO);
                }
                if (VideoPasterContentView.this.ZO == 0) {
                    VideoPasterContentView.this.sb();
                    VideoPasterContentView.this.ZL.stop();
                }
            }

            @Override // com.baidu.tbadk.util.j.a
            public void P(long j) {
                VideoPasterContentView.this.sb();
            }
        });
        this.ZL.start();
        this.ZQ = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.ZE != null) {
            this.ZE.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.ZJ = aVar;
    }

    public boolean rA() {
        return this.ZK;
    }

    public boolean rB() {
        return this.ZP;
    }

    public void reset() {
        sa();
        stop();
        this.ZE.reset();
        this.ZK = false;
        this.pasterData = null;
        this.ZO = 0L;
        this.ZM = false;
        this.ZN = 100;
        e.mX().removeCallbacks(this.ZS);
    }

    private void sa() {
        if (this.pasterData != null && this.pasterData.rT() == 1) {
            n.dnN().remove(this.pasterData.videoUrl);
            if (this.ZH != null) {
                this.ZH.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        this.ZQ = true;
        if (this.ZJ != null) {
            this.ZJ.rQ();
        }
        removeAllViews();
        this.pasterData = null;
        this.ZO = 0L;
        this.ZK = false;
        this.ZP = false;
        this.ZM = false;
        this.ZN = 100;
        e.mX().removeCallbacks(this.ZS);
    }

    public void aZ(int i) {
        if (this.ZE != null) {
            this.ZE.aZ(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.ZL == null) {
            return 0;
        }
        return ((int) this.ZL.bwy()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Ze;
    }

    public void rI() {
        if (this.ZE != null) {
            this.ZE.rI();
        }
    }

    public void rJ() {
        int i = 100;
        if (this.ZE != null) {
            this.ZE.rJ();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.ZK && this.pasterData.rT() == 1) {
            this.ZG.setVisibility(0);
            this.mStartPosition = n.dnN().Pg(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.ZR > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.ZN = i;
            e.mX().removeCallbacks(this.ZS);
            e.mX().postDelayed(this.ZS, 20L);
        }
    }

    public boolean ij() {
        return this.ZQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ZJ != null) {
            this.ZJ.onDetachedFromWindow();
        }
    }

    public boolean rK() {
        return this.ZH != null && this.ZH.isPlaying();
    }
}
