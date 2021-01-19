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
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public class VideoPasterContentView extends FrameLayout {
    private VideoPasterOverlayView abF;
    private TbImageView abG;
    private TbImageView abH;
    private TbCyberVideoView abI;
    private f abJ;
    private a abK;
    private boolean abL;
    private i abM;
    private boolean abN;
    private int abO;
    private long abP;
    private boolean abQ;
    private boolean abR;
    private int abS;
    private Runnable abT;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes.dex */
    public interface a {
        void onDetachedFromWindow();

        void rt();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.abL = false;
        this.abN = false;
        this.abO = 100;
        this.mStartPosition = 0;
        this.abQ = false;
        this.abR = false;
        this.abS = 0;
        this.abT = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mB().removeCallbacks(VideoPasterContentView.this.abT);
                if (!VideoPasterContentView.this.abN) {
                    boolean z = VideoPasterContentView.this.abI.getCurrentPositionSync() == 0 && VideoPasterContentView.this.abO == 100;
                    if (VideoPasterContentView.this.abI.getCurrentPositionSync() > VideoPasterContentView.this.abO) {
                        VideoPasterContentView.this.rC();
                    } else if (z) {
                        e.mB().postDelayed(VideoPasterContentView.this.abT, 20L);
                    } else {
                        VideoPasterContentView.this.rC();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.abF = new VideoPasterOverlayView(getContext());
        this.abG = new TbImageView(getContext());
        this.abH = new TbImageView(getContext());
        this.abI = new TbCyberVideoView(getContext());
        this.abI.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.abI.setContinuePlayEnable(true);
        this.abI.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.abI != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.abI.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.abI.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.abI.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.abS = VideoPasterContentView.this.abI.getDuration();
                    if (VideoPasterContentView.this.abF != null) {
                        VideoPasterContentView.this.abF.d(VideoPasterContentView.this.abI.getVideoWidth(), VideoPasterContentView.this.abI.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.abI.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.rE();
            }
        });
        this.abI.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.rE();
                return false;
            }
        });
        this.abI.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.abN = false;
                VideoPasterContentView.this.abO = 100;
                e.mB().removeCallbacks(VideoPasterContentView.this.abT);
            }
        });
        this.abJ = new f();
        this.abJ.setPlayer(this.abI);
        this.abJ.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void rF() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void e(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.abF.a(this.pasterData, z, z2);
            if (!this.abL) {
                if (this.pasterData.rw() == 0) {
                    this.abF.setCountDownNum(this.pasterData.abe);
                    bi(this.pasterData.abe);
                } else if (this.pasterData.rw() == 1) {
                    this.abF.setCountDownNum(this.pasterData.abe);
                    bi(this.pasterData.abe);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rw() == 0) {
                    removeAllViews();
                    addView(this.abG);
                    addView(this.abF.getRootView(), layoutParams);
                    this.abG.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    d.mx().a(this.pasterData.picUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.abF != null) {
                                VideoPasterContentView.this.abF.d(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.abG.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rw() == 1) {
                    rD();
                    removeAllViews();
                    addView(this.abI.getView());
                    addView(this.abH);
                    addView(this.abF.getRootView(), layoutParams);
                    this.abH.startLoad(this.pasterData.abf, 10, false);
                    this.abI.setVideoPath(this.pasterData.videoUrl);
                    this.abI.start();
                    e.mB().removeCallbacks(this.abT);
                    e.mB().postDelayed(this.abT, 20L);
                }
                this.abL = true;
                this.abQ = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rw() == 0) {
                if (this.abM != null) {
                    this.abM.pause();
                }
            } else if (this.pasterData.rw() == 1) {
                this.abH.setVisibility(0);
                this.abI.stopPlayback();
                if (this.abJ != null) {
                    this.abJ.stop();
                }
                if (this.abM != null) {
                    this.abM.pause();
                }
                e.mB().removeCallbacks(this.abT);
            }
            if (this.abF != null) {
                this.abF.stop();
            }
            this.abQ = false;
            this.abN = false;
        }
    }

    public void ri() {
        if (this.pasterData != null && this.pasterData.rw() == 1 && this.abH != null) {
            this.abH.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        if (!this.abN) {
            this.abN = true;
            this.abH.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rw() == 0) {
                if (this.abM != null) {
                    this.abM.resume();
                }
            } else if (this.pasterData.rw() == 1) {
                this.abH.setVisibility(0);
                this.abI.setVideoPath(this.pasterData.videoUrl);
                this.abI.start();
                if (this.abJ != null) {
                    this.abJ.start();
                }
                if (this.abM != null) {
                    this.abM.resume();
                }
                if (this.abL) {
                    this.mStartPosition = n.dxY().PM(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.abS > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.abO = i;
                } else {
                    this.abO = 100;
                }
                e.mB().removeCallbacks(this.abT);
                e.mB().postDelayed(this.abT, 20L);
            }
            if (this.abF != null) {
                this.abF.resume();
            }
            this.abQ = true;
        }
    }

    private void bi(int i) {
        if (this.abM != null) {
            this.abM.stop();
            this.abM.a((i.a) null);
        }
        this.abM = new i(i * 1000, 1000L);
        this.abM.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.i.a
            public void e(long j, long j2) {
                VideoPasterContentView.this.abP = (int) (j2 / 1000);
                if (VideoPasterContentView.this.abF != null) {
                    VideoPasterContentView.this.abF.setCountDownNum((int) VideoPasterContentView.this.abP);
                }
                if (VideoPasterContentView.this.abP == 0) {
                    VideoPasterContentView.this.rE();
                    VideoPasterContentView.this.abM.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void N(long j) {
                VideoPasterContentView.this.rE();
            }
        });
        this.abM.start();
        this.abR = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.abF != null) {
            this.abF.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.abK = aVar;
    }

    public boolean re() {
        return this.abL;
    }

    public boolean rf() {
        return this.abQ;
    }

    public void reset() {
        rD();
        stop();
        this.abF.reset();
        this.abL = false;
        this.pasterData = null;
        this.abP = 0L;
        this.abN = false;
        this.abO = 100;
        e.mB().removeCallbacks(this.abT);
    }

    private void rD() {
        if (this.pasterData != null && this.pasterData.rw() == 1) {
            n.dxY().remove(this.pasterData.videoUrl);
            if (this.abI != null) {
                this.abI.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE() {
        this.abR = true;
        if (this.abK != null) {
            this.abK.rt();
        }
        removeAllViews();
        this.pasterData = null;
        this.abP = 0L;
        this.abL = false;
        this.abQ = false;
        this.abN = false;
        this.abO = 100;
        e.mB().removeCallbacks(this.abT);
    }

    public void be(int i) {
        if (this.abF != null) {
            this.abF.be(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.abM == null) {
            return 0;
        }
        return ((int) this.abM.bEW()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.abe;
    }

    public void rl() {
        if (this.abF != null) {
            this.abF.rl();
        }
    }

    public void rm() {
        int i = 100;
        if (this.abF != null) {
            this.abF.rm();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.abL && this.pasterData.rw() == 1) {
            this.abH.setVisibility(0);
            this.mStartPosition = n.dxY().PM(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.abS > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.abO = i;
            e.mB().removeCallbacks(this.abT);
            e.mB().postDelayed(this.abT, 20L);
        }
    }

    public boolean isCompleted() {
        return this.abR;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.abK != null) {
            this.abK.onDetachedFromWindow();
        }
    }

    public boolean rn() {
        return this.abI != null && this.abI.isPlaying();
    }
}
