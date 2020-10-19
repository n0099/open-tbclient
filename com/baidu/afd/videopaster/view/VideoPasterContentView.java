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
/* loaded from: classes21.dex */
public class VideoPasterContentView extends FrameLayout {
    private VideoPasterOverlayView ZU;
    private TbImageView ZV;
    private TbImageView ZW;
    private TbCyberVideoView ZX;
    private f ZY;
    private a ZZ;
    private boolean aaa;
    private j aab;
    private boolean aac;
    private int aae;
    private long aaf;
    private boolean aag;
    private boolean aah;
    private int aai;
    private Runnable aaj;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes21.dex */
    public interface a {
        void onDetachedFromWindow();

        void rQ();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.aaa = false;
        this.aac = false;
        this.aae = 100;
        this.mStartPosition = 0;
        this.aag = false;
        this.aah = false;
        this.aai = 0;
        this.aaj = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mY().removeCallbacks(VideoPasterContentView.this.aaj);
                if (!VideoPasterContentView.this.aac) {
                    boolean z = VideoPasterContentView.this.ZX.getCurrentPositionSync() == 0 && VideoPasterContentView.this.aae == 100;
                    if (VideoPasterContentView.this.ZX.getCurrentPositionSync() > VideoPasterContentView.this.aae) {
                        VideoPasterContentView.this.rZ();
                    } else if (z) {
                        e.mY().postDelayed(VideoPasterContentView.this.aaj, 20L);
                    } else {
                        VideoPasterContentView.this.rZ();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.ZU = new VideoPasterOverlayView(getContext());
        this.ZV = new TbImageView(getContext());
        this.ZW = new TbImageView(getContext());
        this.ZX = new TbCyberVideoView(getContext());
        this.ZX.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.ZX.setContinuePlayEnable(true);
        this.ZX.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.ZX != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.ZX.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.ZX.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.ZX.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.aai = VideoPasterContentView.this.ZX.getDuration();
                    if (VideoPasterContentView.this.ZU != null) {
                        VideoPasterContentView.this.ZU.c(VideoPasterContentView.this.ZX.getVideoWidth(), VideoPasterContentView.this.ZX.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.ZX.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.sb();
            }
        });
        this.ZX.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.sb();
                return false;
            }
        });
        this.ZX.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.aac = false;
                VideoPasterContentView.this.aae = 100;
                e.mY().removeCallbacks(VideoPasterContentView.this.aaj);
            }
        });
        this.ZY = new f();
        this.ZY.setPlayer(this.ZX);
        this.ZY.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.ZU.a(this.pasterData, z, z2);
            if (!this.aaa) {
                if (this.pasterData.rT() == 0) {
                    this.ZU.setCountDownNum(this.pasterData.Zu);
                    be(this.pasterData.Zu);
                } else if (this.pasterData.rT() == 1) {
                    this.ZU.setCountDownNum(this.pasterData.Zu);
                    be(this.pasterData.Zu);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rT() == 0) {
                    removeAllViews();
                    addView(this.ZV);
                    addView(this.ZU.getRootView(), layoutParams);
                    this.ZV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.mS().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.ZU != null) {
                                VideoPasterContentView.this.ZU.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.ZV.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rT() == 1) {
                    sa();
                    removeAllViews();
                    addView(this.ZX.getView());
                    addView(this.ZW);
                    addView(this.ZU.getRootView(), layoutParams);
                    this.ZW.startLoad(this.pasterData.Zv, 10, false);
                    this.ZX.setVideoPath(this.pasterData.videoUrl);
                    this.ZX.start();
                    e.mY().removeCallbacks(this.aaj);
                    e.mY().postDelayed(this.aaj, 20L);
                }
                this.aaa = true;
                this.aag = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.aab != null) {
                    this.aab.pause();
                }
            } else if (this.pasterData.rT() == 1) {
                this.ZW.setVisibility(0);
                this.ZX.stopPlayback();
                if (this.ZY != null) {
                    this.ZY.stop();
                }
                if (this.aab != null) {
                    this.aab.pause();
                }
                e.mY().removeCallbacks(this.aaj);
            }
            if (this.ZU != null) {
                this.ZU.stop();
            }
            this.aag = false;
            this.aac = false;
        }
    }

    public void rF() {
        if (this.pasterData != null && this.pasterData.rT() == 1 && this.ZW != null) {
            this.ZW.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (!this.aac) {
            this.aac = true;
            this.ZW.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.aab != null) {
                    this.aab.resume();
                }
            } else if (this.pasterData.rT() == 1) {
                this.ZW.setVisibility(0);
                this.ZX.setVideoPath(this.pasterData.videoUrl);
                this.ZX.start();
                if (this.ZY != null) {
                    this.ZY.start();
                }
                if (this.aab != null) {
                    this.aab.resume();
                }
                if (this.aaa) {
                    this.mStartPosition = n.dry().PV(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.aai > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.aae = i;
                } else {
                    this.aae = 100;
                }
                e.mY().removeCallbacks(this.aaj);
                e.mY().postDelayed(this.aaj, 20L);
            }
            if (this.ZU != null) {
                this.ZU.resume();
            }
            this.aag = true;
        }
    }

    private void be(int i) {
        if (this.aab != null) {
            this.aab.stop();
            this.aab.a((j.a) null);
        }
        this.aab = new j(i * 1000, 1000L);
        this.aab.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.j.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.aaf = (int) (j2 / 1000);
                if (VideoPasterContentView.this.ZU != null) {
                    VideoPasterContentView.this.ZU.setCountDownNum((int) VideoPasterContentView.this.aaf);
                }
                if (VideoPasterContentView.this.aaf == 0) {
                    VideoPasterContentView.this.sb();
                    VideoPasterContentView.this.aab.stop();
                }
            }

            @Override // com.baidu.tbadk.util.j.a
            public void P(long j) {
                VideoPasterContentView.this.sb();
            }
        });
        this.aab.start();
        this.aah = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.ZU != null) {
            this.ZU.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.ZZ = aVar;
    }

    public boolean rA() {
        return this.aaa;
    }

    public boolean rB() {
        return this.aag;
    }

    public void reset() {
        sa();
        stop();
        this.ZU.reset();
        this.aaa = false;
        this.pasterData = null;
        this.aaf = 0L;
        this.aac = false;
        this.aae = 100;
        e.mY().removeCallbacks(this.aaj);
    }

    private void sa() {
        if (this.pasterData != null && this.pasterData.rT() == 1) {
            n.dry().remove(this.pasterData.videoUrl);
            if (this.ZX != null) {
                this.ZX.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        this.aah = true;
        if (this.ZZ != null) {
            this.ZZ.rQ();
        }
        removeAllViews();
        this.pasterData = null;
        this.aaf = 0L;
        this.aaa = false;
        this.aag = false;
        this.aac = false;
        this.aae = 100;
        e.mY().removeCallbacks(this.aaj);
    }

    public void aZ(int i) {
        if (this.ZU != null) {
            this.ZU.aZ(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.aab == null) {
            return 0;
        }
        return ((int) this.aab.bzi()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Zu;
    }

    public void rI() {
        if (this.ZU != null) {
            this.ZU.rI();
        }
    }

    public void rJ() {
        int i = 100;
        if (this.ZU != null) {
            this.ZU.rJ();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.aaa && this.pasterData.rT() == 1) {
            this.ZW.setVisibility(0);
            this.mStartPosition = n.dry().PV(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.aai > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.aae = i;
            e.mY().removeCallbacks(this.aaj);
            e.mY().postDelayed(this.aaj, 20L);
        }
    }

    public boolean ik() {
        return this.aah;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ZZ != null) {
            this.ZZ.onDetachedFromWindow();
        }
    }

    public boolean rK() {
        return this.ZX != null && this.ZX.isPlaying();
    }
}
