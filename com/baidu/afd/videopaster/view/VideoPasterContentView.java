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
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
import com.tencent.connect.common.Constants;
/* loaded from: classes15.dex */
public class VideoPasterContentView extends FrameLayout {
    private Runnable ZA;
    private VideoPasterOverlayView Zm;
    private TbImageView Zn;
    private TbImageView Zo;
    private TbCyberVideoView Zp;
    private f Zq;
    private a Zr;
    private boolean Zs;
    private i Zt;
    private boolean Zu;
    private int Zv;
    private long Zw;
    private boolean Zx;
    private boolean Zy;
    private int Zz;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes15.dex */
    public interface a {
        void onDetachedFromWindow();

        void rL();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.Zs = false;
        this.Zu = false;
        this.Zv = 100;
        this.mStartPosition = 0;
        this.Zx = false;
        this.Zy = false;
        this.Zz = 0;
        this.ZA = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mS().removeCallbacks(VideoPasterContentView.this.ZA);
                if (!VideoPasterContentView.this.Zu) {
                    boolean z = VideoPasterContentView.this.Zp.getCurrentPositionSync() == 0 && VideoPasterContentView.this.Zv == 100;
                    if (VideoPasterContentView.this.Zp.getCurrentPositionSync() > VideoPasterContentView.this.Zv) {
                        VideoPasterContentView.this.rU();
                    } else if (z) {
                        e.mS().postDelayed(VideoPasterContentView.this.ZA, 20L);
                    } else {
                        VideoPasterContentView.this.rU();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Zm = new VideoPasterOverlayView(getContext());
        this.Zn = new TbImageView(getContext());
        this.Zo = new TbImageView(getContext());
        this.Zp = new TbCyberVideoView(getContext());
        this.Zp.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.Zp.setContinuePlayEnable(true);
        this.Zp.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.Zp != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.Zp.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.Zp.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.Zp.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.Zz = VideoPasterContentView.this.Zp.getDuration();
                    if (VideoPasterContentView.this.Zm != null) {
                        VideoPasterContentView.this.Zm.c(VideoPasterContentView.this.Zp.getVideoWidth(), VideoPasterContentView.this.Zp.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Zp.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.rW();
            }
        });
        this.Zp.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.rW();
                return false;
            }
        });
        this.Zp.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Zu = false;
                VideoPasterContentView.this.Zv = 100;
                e.mS().removeCallbacks(VideoPasterContentView.this.ZA);
            }
        });
        this.Zq = new f();
        this.Zq.setPlayer(this.Zp);
        this.Zq.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void rX() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Zm.a(this.pasterData, z, z2);
            if (!this.Zs) {
                if (this.pasterData.rO() == 0) {
                    this.Zm.setCountDownNum(this.pasterData.YL);
                    ba(this.pasterData.YL);
                } else if (this.pasterData.rO() == 1) {
                    this.Zm.setCountDownNum(this.pasterData.YL);
                    ba(this.pasterData.YL);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rO() == 0) {
                    removeAllViews();
                    addView(this.Zn);
                    addView(this.Zm.getRootView(), layoutParams);
                    this.Zn.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.mM().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.Zm != null) {
                                VideoPasterContentView.this.Zm.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Zn.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rO() == 1) {
                    rV();
                    removeAllViews();
                    addView(this.Zp.getView());
                    addView(this.Zo);
                    addView(this.Zm.getRootView(), layoutParams);
                    this.Zo.startLoad(this.pasterData.YM, 10, false);
                    this.Zp.setVideoPath(this.pasterData.videoUrl);
                    this.Zp.start();
                    e.mS().removeCallbacks(this.ZA);
                    e.mS().postDelayed(this.ZA, 20L);
                }
                this.Zs = true;
                this.Zx = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rO() == 0) {
                if (this.Zt != null) {
                    this.Zt.pause();
                }
            } else if (this.pasterData.rO() == 1) {
                this.Zo.setVisibility(0);
                this.Zp.stopPlayback();
                if (this.Zq != null) {
                    this.Zq.stop();
                }
                if (this.Zt != null) {
                    this.Zt.pause();
                }
                e.mS().removeCallbacks(this.ZA);
            }
            if (this.Zm != null) {
                this.Zm.stop();
            }
            this.Zx = false;
            this.Zu = false;
        }
    }

    public void rA() {
        if (this.pasterData != null && this.pasterData.rO() == 1 && this.Zo != null) {
            this.Zo.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU() {
        if (!this.Zu) {
            this.Zu = true;
            this.Zo.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rO() == 0) {
                if (this.Zt != null) {
                    this.Zt.resume();
                }
            } else if (this.pasterData.rO() == 1) {
                this.Zo.setVisibility(0);
                this.Zp.setVideoPath(this.pasterData.videoUrl);
                this.Zp.start();
                if (this.Zq != null) {
                    this.Zq.start();
                }
                if (this.Zt != null) {
                    this.Zt.resume();
                }
                if (this.Zs) {
                    this.mStartPosition = n.dkg().OF(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Zz > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Zv = i;
                } else {
                    this.Zv = 100;
                }
                e.mS().removeCallbacks(this.ZA);
                e.mS().postDelayed(this.ZA, 20L);
            }
            if (this.Zm != null) {
                this.Zm.resume();
            }
            this.Zx = true;
        }
    }

    private void ba(int i) {
        if (this.Zt != null) {
            this.Zt.stop();
            this.Zt.a((i.a) null);
        }
        this.Zt = new i(i * 1000, 1000L);
        this.Zt.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Zw = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Zm != null) {
                    VideoPasterContentView.this.Zm.setCountDownNum((int) VideoPasterContentView.this.Zw);
                }
                if (VideoPasterContentView.this.Zw == 0) {
                    VideoPasterContentView.this.rW();
                    VideoPasterContentView.this.Zt.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void P(long j) {
                VideoPasterContentView.this.rW();
            }
        });
        this.Zt.start();
        this.Zy = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Zm != null) {
            this.Zm.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.Zr = aVar;
    }

    public boolean rv() {
        return this.Zs;
    }

    public boolean rw() {
        return this.Zx;
    }

    public void reset() {
        rV();
        stop();
        this.Zm.reset();
        this.Zs = false;
        this.pasterData = null;
        this.Zw = 0L;
        this.Zu = false;
        this.Zv = 100;
        e.mS().removeCallbacks(this.ZA);
    }

    private void rV() {
        if (this.pasterData != null && this.pasterData.rO() == 1) {
            n.dkg().remove(this.pasterData.videoUrl);
            if (this.Zp != null) {
                this.Zp.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW() {
        this.Zy = true;
        if (this.Zr != null) {
            this.Zr.rL();
        }
        removeAllViews();
        this.pasterData = null;
        this.Zw = 0L;
        this.Zs = false;
        this.Zx = false;
        this.Zu = false;
        this.Zv = 100;
        e.mS().removeCallbacks(this.ZA);
    }

    public void aV(int i) {
        if (this.Zm != null) {
            this.Zm.aV(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Zt == null) {
            return 0;
        }
        return ((int) this.Zt.bvp()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.YL;
    }

    public void rD() {
        if (this.Zm != null) {
            this.Zm.rD();
        }
    }

    public void rE() {
        int i = 100;
        if (this.Zm != null) {
            this.Zm.rE();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Zs && this.pasterData.rO() == 1) {
            this.Zo.setVisibility(0);
            this.mStartPosition = n.dkg().OF(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Zz > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Zv = i;
            e.mS().removeCallbacks(this.ZA);
            e.mS().postDelayed(this.ZA, 20L);
        }
    }

    public boolean ij() {
        return this.Zy;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Zr != null) {
            this.Zr.onDetachedFromWindow();
        }
    }

    public boolean rF() {
        return this.Zp != null && this.Zp.isPlaying();
    }
}
