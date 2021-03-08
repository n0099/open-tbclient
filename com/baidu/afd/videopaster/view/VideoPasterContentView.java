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
    private VideoPasterOverlayView acW;
    private TbImageView acX;
    private TbImageView acY;
    private TbCyberVideoView acZ;
    private f ada;
    private a adb;
    private boolean adc;
    private j ade;
    private boolean adf;
    private int adg;
    private long adh;
    private boolean adi;
    private boolean adj;
    private int adk;
    private Runnable adl;
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
        this.adc = false;
        this.adf = false;
        this.adg = 100;
        this.mStartPosition = 0;
        this.adi = false;
        this.adj = false;
        this.adk = 0;
        this.adl = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mA().removeCallbacks(VideoPasterContentView.this.adl);
                if (!VideoPasterContentView.this.adf) {
                    boolean z = VideoPasterContentView.this.acZ.getCurrentPositionSync() == 0 && VideoPasterContentView.this.adg == 100;
                    if (VideoPasterContentView.this.acZ.getCurrentPositionSync() > VideoPasterContentView.this.adg) {
                        VideoPasterContentView.this.rA();
                    } else if (z) {
                        e.mA().postDelayed(VideoPasterContentView.this.adl, 20L);
                    } else {
                        VideoPasterContentView.this.rA();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.acW = new VideoPasterOverlayView(getContext());
        this.acX = new TbImageView(getContext());
        this.acY = new TbImageView(getContext());
        this.acZ = new TbCyberVideoView(getContext());
        this.acZ.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.acZ.setContinuePlayEnable(true);
        this.acZ.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.acZ != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.acZ.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.acZ.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.acZ.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.adk = VideoPasterContentView.this.acZ.getDuration();
                    if (VideoPasterContentView.this.acW != null) {
                        VideoPasterContentView.this.acW.d(VideoPasterContentView.this.acZ.getVideoWidth(), VideoPasterContentView.this.acZ.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.acZ.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.rC();
            }
        });
        this.acZ.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.rC();
                return false;
            }
        });
        this.acZ.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.adf = false;
                VideoPasterContentView.this.adg = 100;
                e.mA().removeCallbacks(VideoPasterContentView.this.adl);
            }
        });
        this.ada = new f();
        this.ada.setPlayer(this.acZ);
        this.ada.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void rD() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void c(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.acW.a(this.pasterData, z, z2);
            if (!this.adc) {
                if (this.pasterData.ru() == 0) {
                    this.acW.setCountDownNum(this.pasterData.acx);
                    bj(this.pasterData.acx);
                } else if (this.pasterData.ru() == 1) {
                    this.acW.setCountDownNum(this.pasterData.acx);
                    bj(this.pasterData.acx);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.ru() == 0) {
                    removeAllViews();
                    addView(this.acX);
                    addView(this.acW.getRootView(), layoutParams);
                    this.acX.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    d.mw().a(this.pasterData.picUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.acW != null) {
                                VideoPasterContentView.this.acW.d(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.acX.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.ru() == 1) {
                    rB();
                    removeAllViews();
                    addView(this.acZ.getView());
                    addView(this.acY);
                    addView(this.acW.getRootView(), layoutParams);
                    this.acY.startLoad(this.pasterData.acy, 10, false);
                    this.acZ.setVideoPath(this.pasterData.videoUrl);
                    this.acZ.start();
                    e.mA().removeCallbacks(this.adl);
                    e.mA().postDelayed(this.adl, 20L);
                }
                this.adc = true;
                this.adi = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.ru() == 0) {
                if (this.ade != null) {
                    this.ade.pause();
                }
            } else if (this.pasterData.ru() == 1) {
                this.acY.setVisibility(0);
                this.acZ.stopPlayback();
                if (this.ada != null) {
                    this.ada.stop();
                }
                if (this.ade != null) {
                    this.ade.pause();
                }
                e.mA().removeCallbacks(this.adl);
            }
            if (this.acW != null) {
                this.acW.stop();
            }
            this.adi = false;
            this.adf = false;
        }
    }

    public void rg() {
        if (this.pasterData != null && this.pasterData.ru() == 1 && this.acY != null) {
            this.acY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        if (!this.adf) {
            this.adf = true;
            this.acY.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.ru() == 0) {
                if (this.ade != null) {
                    this.ade.resume();
                }
            } else if (this.pasterData.ru() == 1) {
                this.acY.setVisibility(0);
                this.acZ.setVideoPath(this.pasterData.videoUrl);
                this.acZ.start();
                if (this.ada != null) {
                    this.ada.start();
                }
                if (this.ade != null) {
                    this.ade.resume();
                }
                if (this.adc) {
                    this.mStartPosition = n.dAv().QK(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.adk > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.adg = i;
                } else {
                    this.adg = 100;
                }
                e.mA().removeCallbacks(this.adl);
                e.mA().postDelayed(this.adl, 20L);
            }
            if (this.acW != null) {
                this.acW.resume();
            }
            this.adi = true;
        }
    }

    private void bj(int i) {
        if (this.ade != null) {
            this.ade.stop();
            this.ade.a((j.a) null);
        }
        this.ade = new j(i * 1000, 1000L);
        this.ade.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.j.a
            public void e(long j, long j2) {
                VideoPasterContentView.this.adh = (int) (j2 / 1000);
                if (VideoPasterContentView.this.acW != null) {
                    VideoPasterContentView.this.acW.setCountDownNum((int) VideoPasterContentView.this.adh);
                }
                if (VideoPasterContentView.this.adh == 0) {
                    VideoPasterContentView.this.rC();
                    VideoPasterContentView.this.ade.stop();
                }
            }

            @Override // com.baidu.tbadk.util.j.a
            public void N(long j) {
                VideoPasterContentView.this.rC();
            }
        });
        this.ade.start();
        this.adj = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.acW != null) {
            this.acW.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.adb = aVar;
    }

    public boolean rc() {
        return this.adc;
    }

    public boolean rd() {
        return this.adi;
    }

    public void reset() {
        rB();
        stop();
        this.acW.reset();
        this.adc = false;
        this.pasterData = null;
        this.adh = 0L;
        this.adf = false;
        this.adg = 100;
        e.mA().removeCallbacks(this.adl);
    }

    private void rB() {
        if (this.pasterData != null && this.pasterData.ru() == 1) {
            n.dAv().remove(this.pasterData.videoUrl);
            if (this.acZ != null) {
                this.acZ.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        this.adj = true;
        if (this.adb != null) {
            this.adb.rr();
        }
        removeAllViews();
        this.pasterData = null;
        this.adh = 0L;
        this.adc = false;
        this.adi = false;
        this.adf = false;
        this.adg = 100;
        e.mA().removeCallbacks(this.adl);
    }

    public void bf(int i) {
        if (this.acW != null) {
            this.acW.bf(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.ade == null) {
            return 0;
        }
        return ((int) this.ade.bFt()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.acx;
    }

    public void rj() {
        if (this.acW != null) {
            this.acW.rj();
        }
    }

    public void rk() {
        int i = 100;
        if (this.acW != null) {
            this.acW.rk();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.adc && this.pasterData.ru() == 1) {
            this.acY.setVisibility(0);
            this.mStartPosition = n.dAv().QK(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.adk > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.adg = i;
            e.mA().removeCallbacks(this.adl);
            e.mA().postDelayed(this.adl, 20L);
        }
    }

    public boolean isCompleted() {
        return this.adj;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.adb != null) {
            this.adb.onDetachedFromWindow();
        }
    }

    public boolean rl() {
        return this.acZ != null && this.acZ.isPlaying();
    }
}
