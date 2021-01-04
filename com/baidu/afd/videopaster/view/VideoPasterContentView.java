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
    private VideoPasterOverlayView abH;
    private TbImageView abI;
    private TbImageView abJ;
    private TbCyberVideoView abK;
    private f abL;
    private a abM;
    private boolean abN;
    private i abO;
    private boolean abP;
    private int abQ;
    private long abR;
    private boolean abS;
    private boolean abT;
    private int abU;
    private Runnable abV;
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
        this.abN = false;
        this.abP = false;
        this.abQ = 100;
        this.mStartPosition = 0;
        this.abS = false;
        this.abT = false;
        this.abU = 0;
        this.abV = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mB().removeCallbacks(VideoPasterContentView.this.abV);
                if (!VideoPasterContentView.this.abP) {
                    boolean z = VideoPasterContentView.this.abK.getCurrentPositionSync() == 0 && VideoPasterContentView.this.abQ == 100;
                    if (VideoPasterContentView.this.abK.getCurrentPositionSync() > VideoPasterContentView.this.abQ) {
                        VideoPasterContentView.this.rC();
                    } else if (z) {
                        e.mB().postDelayed(VideoPasterContentView.this.abV, 20L);
                    } else {
                        VideoPasterContentView.this.rC();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.abH = new VideoPasterOverlayView(getContext());
        this.abI = new TbImageView(getContext());
        this.abJ = new TbImageView(getContext());
        this.abK = new TbCyberVideoView(getContext());
        this.abK.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.abK.setContinuePlayEnable(true);
        this.abK.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.abK != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.abK.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.abK.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.abK.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.abU = VideoPasterContentView.this.abK.getDuration();
                    if (VideoPasterContentView.this.abH != null) {
                        VideoPasterContentView.this.abH.d(VideoPasterContentView.this.abK.getVideoWidth(), VideoPasterContentView.this.abK.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.abK.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.rE();
            }
        });
        this.abK.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.rE();
                return false;
            }
        });
        this.abK.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.abP = false;
                VideoPasterContentView.this.abQ = 100;
                e.mB().removeCallbacks(VideoPasterContentView.this.abV);
            }
        });
        this.abL = new f();
        this.abL.setPlayer(this.abK);
        this.abL.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void rF() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void e(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.abH.a(this.pasterData, z, z2);
            if (!this.abN) {
                if (this.pasterData.rw() == 0) {
                    this.abH.setCountDownNum(this.pasterData.abg);
                    bi(this.pasterData.abg);
                } else if (this.pasterData.rw() == 1) {
                    this.abH.setCountDownNum(this.pasterData.abg);
                    bi(this.pasterData.abg);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rw() == 0) {
                    removeAllViews();
                    addView(this.abI);
                    addView(this.abH.getRootView(), layoutParams);
                    this.abI.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    d.mx().a(this.pasterData.picUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.abH != null) {
                                VideoPasterContentView.this.abH.d(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.abI.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rw() == 1) {
                    rD();
                    removeAllViews();
                    addView(this.abK.getView());
                    addView(this.abJ);
                    addView(this.abH.getRootView(), layoutParams);
                    this.abJ.startLoad(this.pasterData.abh, 10, false);
                    this.abK.setVideoPath(this.pasterData.videoUrl);
                    this.abK.start();
                    e.mB().removeCallbacks(this.abV);
                    e.mB().postDelayed(this.abV, 20L);
                }
                this.abN = true;
                this.abS = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rw() == 0) {
                if (this.abO != null) {
                    this.abO.pause();
                }
            } else if (this.pasterData.rw() == 1) {
                this.abJ.setVisibility(0);
                this.abK.stopPlayback();
                if (this.abL != null) {
                    this.abL.stop();
                }
                if (this.abO != null) {
                    this.abO.pause();
                }
                e.mB().removeCallbacks(this.abV);
            }
            if (this.abH != null) {
                this.abH.stop();
            }
            this.abS = false;
            this.abP = false;
        }
    }

    public void ri() {
        if (this.pasterData != null && this.pasterData.rw() == 1 && this.abJ != null) {
            this.abJ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        if (!this.abP) {
            this.abP = true;
            this.abJ.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rw() == 0) {
                if (this.abO != null) {
                    this.abO.resume();
                }
            } else if (this.pasterData.rw() == 1) {
                this.abJ.setVisibility(0);
                this.abK.setVideoPath(this.pasterData.videoUrl);
                this.abK.start();
                if (this.abL != null) {
                    this.abL.start();
                }
                if (this.abO != null) {
                    this.abO.resume();
                }
                if (this.abN) {
                    this.mStartPosition = n.dBP().QU(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.abU > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.abQ = i;
                } else {
                    this.abQ = 100;
                }
                e.mB().removeCallbacks(this.abV);
                e.mB().postDelayed(this.abV, 20L);
            }
            if (this.abH != null) {
                this.abH.resume();
            }
            this.abS = true;
        }
    }

    private void bi(int i) {
        if (this.abO != null) {
            this.abO.stop();
            this.abO.a((i.a) null);
        }
        this.abO = new i(i * 1000, 1000L);
        this.abO.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.i.a
            public void e(long j, long j2) {
                VideoPasterContentView.this.abR = (int) (j2 / 1000);
                if (VideoPasterContentView.this.abH != null) {
                    VideoPasterContentView.this.abH.setCountDownNum((int) VideoPasterContentView.this.abR);
                }
                if (VideoPasterContentView.this.abR == 0) {
                    VideoPasterContentView.this.rE();
                    VideoPasterContentView.this.abO.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void N(long j) {
                VideoPasterContentView.this.rE();
            }
        });
        this.abO.start();
        this.abT = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.abH != null) {
            this.abH.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.abM = aVar;
    }

    public boolean re() {
        return this.abN;
    }

    public boolean rf() {
        return this.abS;
    }

    public void reset() {
        rD();
        stop();
        this.abH.reset();
        this.abN = false;
        this.pasterData = null;
        this.abR = 0L;
        this.abP = false;
        this.abQ = 100;
        e.mB().removeCallbacks(this.abV);
    }

    private void rD() {
        if (this.pasterData != null && this.pasterData.rw() == 1) {
            n.dBP().remove(this.pasterData.videoUrl);
            if (this.abK != null) {
                this.abK.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE() {
        this.abT = true;
        if (this.abM != null) {
            this.abM.rt();
        }
        removeAllViews();
        this.pasterData = null;
        this.abR = 0L;
        this.abN = false;
        this.abS = false;
        this.abP = false;
        this.abQ = 100;
        e.mB().removeCallbacks(this.abV);
    }

    public void be(int i) {
        if (this.abH != null) {
            this.abH.be(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.abO == null) {
            return 0;
        }
        return ((int) this.abO.bIN()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.abg;
    }

    public void rl() {
        if (this.abH != null) {
            this.abH.rl();
        }
    }

    public void rm() {
        int i = 100;
        if (this.abH != null) {
            this.abH.rm();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.abN && this.pasterData.rw() == 1) {
            this.abJ.setVisibility(0);
            this.mStartPosition = n.dBP().QU(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.abU > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.abQ = i;
            e.mB().removeCallbacks(this.abV);
            e.mB().postDelayed(this.abV, 20L);
        }
    }

    public boolean isCompleted() {
        return this.abT;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.abM != null) {
            this.abM.onDetachedFromWindow();
        }
    }

    public boolean rn() {
        return this.abK != null && this.abK.isPlaying();
    }
}
