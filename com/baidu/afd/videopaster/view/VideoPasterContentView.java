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
    private VideoPasterOverlayView Zk;
    private TbImageView Zl;
    private TbImageView Zm;
    private TbCyberVideoView Zn;
    private f Zo;
    private a Zp;
    private boolean Zq;
    private i Zr;
    private boolean Zs;
    private int Zt;
    private long Zu;
    private boolean Zv;
    private boolean Zw;
    private int Zx;
    private Runnable Zy;
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
        this.Zq = false;
        this.Zs = false;
        this.Zt = 100;
        this.mStartPosition = 0;
        this.Zv = false;
        this.Zw = false;
        this.Zx = 0;
        this.Zy = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mS().removeCallbacks(VideoPasterContentView.this.Zy);
                if (!VideoPasterContentView.this.Zs) {
                    boolean z = VideoPasterContentView.this.Zn.getCurrentPositionSync() == 0 && VideoPasterContentView.this.Zt == 100;
                    if (VideoPasterContentView.this.Zn.getCurrentPositionSync() > VideoPasterContentView.this.Zt) {
                        VideoPasterContentView.this.rU();
                    } else if (z) {
                        e.mS().postDelayed(VideoPasterContentView.this.Zy, 20L);
                    } else {
                        VideoPasterContentView.this.rU();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.Zk = new VideoPasterOverlayView(getContext());
        this.Zl = new TbImageView(getContext());
        this.Zm = new TbImageView(getContext());
        this.Zn = new TbCyberVideoView(getContext());
        this.Zn.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.Zn.setContinuePlayEnable(true);
        this.Zn.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.Zn != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.Zn.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.Zn.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.Zn.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.Zx = VideoPasterContentView.this.Zn.getDuration();
                    if (VideoPasterContentView.this.Zk != null) {
                        VideoPasterContentView.this.Zk.c(VideoPasterContentView.this.Zn.getVideoWidth(), VideoPasterContentView.this.Zn.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.Zn.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.rW();
            }
        });
        this.Zn.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.rW();
                return false;
            }
        });
        this.Zn.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.Zs = false;
                VideoPasterContentView.this.Zt = 100;
                e.mS().removeCallbacks(VideoPasterContentView.this.Zy);
            }
        });
        this.Zo = new f();
        this.Zo.setPlayer(this.Zn);
        this.Zo.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void rX() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.Zk.a(this.pasterData, z, z2);
            if (!this.Zq) {
                if (this.pasterData.rO() == 0) {
                    this.Zk.setCountDownNum(this.pasterData.YJ);
                    ba(this.pasterData.YJ);
                } else if (this.pasterData.rO() == 1) {
                    this.Zk.setCountDownNum(this.pasterData.YJ);
                    ba(this.pasterData.YJ);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rO() == 0) {
                    removeAllViews();
                    addView(this.Zl);
                    addView(this.Zk.getRootView(), layoutParams);
                    this.Zl.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.mM().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.Zk != null) {
                                VideoPasterContentView.this.Zk.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.Zl.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rO() == 1) {
                    rV();
                    removeAllViews();
                    addView(this.Zn.getView());
                    addView(this.Zm);
                    addView(this.Zk.getRootView(), layoutParams);
                    this.Zm.startLoad(this.pasterData.YK, 10, false);
                    this.Zn.setVideoPath(this.pasterData.videoUrl);
                    this.Zn.start();
                    e.mS().removeCallbacks(this.Zy);
                    e.mS().postDelayed(this.Zy, 20L);
                }
                this.Zq = true;
                this.Zv = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rO() == 0) {
                if (this.Zr != null) {
                    this.Zr.pause();
                }
            } else if (this.pasterData.rO() == 1) {
                this.Zm.setVisibility(0);
                this.Zn.stopPlayback();
                if (this.Zo != null) {
                    this.Zo.stop();
                }
                if (this.Zr != null) {
                    this.Zr.pause();
                }
                e.mS().removeCallbacks(this.Zy);
            }
            if (this.Zk != null) {
                this.Zk.stop();
            }
            this.Zv = false;
            this.Zs = false;
        }
    }

    public void rA() {
        if (this.pasterData != null && this.pasterData.rO() == 1 && this.Zm != null) {
            this.Zm.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU() {
        if (!this.Zs) {
            this.Zs = true;
            this.Zm.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rO() == 0) {
                if (this.Zr != null) {
                    this.Zr.resume();
                }
            } else if (this.pasterData.rO() == 1) {
                this.Zm.setVisibility(0);
                this.Zn.setVideoPath(this.pasterData.videoUrl);
                this.Zn.start();
                if (this.Zo != null) {
                    this.Zo.start();
                }
                if (this.Zr != null) {
                    this.Zr.resume();
                }
                if (this.Zq) {
                    this.mStartPosition = n.dkd().OE(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.Zx > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.Zt = i;
                } else {
                    this.Zt = 100;
                }
                e.mS().removeCallbacks(this.Zy);
                e.mS().postDelayed(this.Zy, 20L);
            }
            if (this.Zk != null) {
                this.Zk.resume();
            }
            this.Zv = true;
        }
    }

    private void ba(int i) {
        if (this.Zr != null) {
            this.Zr.stop();
            this.Zr.a((i.a) null);
        }
        this.Zr = new i(i * 1000, 1000L);
        this.Zr.a(new i.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.i.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.Zu = (int) (j2 / 1000);
                if (VideoPasterContentView.this.Zk != null) {
                    VideoPasterContentView.this.Zk.setCountDownNum((int) VideoPasterContentView.this.Zu);
                }
                if (VideoPasterContentView.this.Zu == 0) {
                    VideoPasterContentView.this.rW();
                    VideoPasterContentView.this.Zr.stop();
                }
            }

            @Override // com.baidu.tbadk.util.i.a
            public void P(long j) {
                VideoPasterContentView.this.rW();
            }
        });
        this.Zr.start();
        this.Zw = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.Zk != null) {
            this.Zk.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.Zp = aVar;
    }

    public boolean rv() {
        return this.Zq;
    }

    public boolean rw() {
        return this.Zv;
    }

    public void reset() {
        rV();
        stop();
        this.Zk.reset();
        this.Zq = false;
        this.pasterData = null;
        this.Zu = 0L;
        this.Zs = false;
        this.Zt = 100;
        e.mS().removeCallbacks(this.Zy);
    }

    private void rV() {
        if (this.pasterData != null && this.pasterData.rO() == 1) {
            n.dkd().remove(this.pasterData.videoUrl);
            if (this.Zn != null) {
                this.Zn.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW() {
        this.Zw = true;
        if (this.Zp != null) {
            this.Zp.rL();
        }
        removeAllViews();
        this.pasterData = null;
        this.Zu = 0L;
        this.Zq = false;
        this.Zv = false;
        this.Zs = false;
        this.Zt = 100;
        e.mS().removeCallbacks(this.Zy);
    }

    public void aV(int i) {
        if (this.Zk != null) {
            this.Zk.aV(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.Zr == null) {
            return 0;
        }
        return ((int) this.Zr.bvo()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.YJ;
    }

    public void rD() {
        if (this.Zk != null) {
            this.Zk.rD();
        }
    }

    public void rE() {
        int i = 100;
        if (this.Zk != null) {
            this.Zk.rE();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.Zq && this.pasterData.rO() == 1) {
            this.Zm.setVisibility(0);
            this.mStartPosition = n.dkd().OE(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.Zx > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.Zt = i;
            e.mS().removeCallbacks(this.Zy);
            e.mS().postDelayed(this.Zy, 20L);
        }
    }

    public boolean ij() {
        return this.Zw;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Zp != null) {
            this.Zp.onDetachedFromWindow();
        }
    }

    public boolean rF() {
        return this.Zn != null && this.Zn.isPlaying();
    }
}
