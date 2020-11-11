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
    private VideoPasterOverlayView ZV;
    private TbImageView ZW;
    private TbImageView ZX;
    private TbCyberVideoView ZY;
    private f ZZ;
    private a aaa;
    private boolean aab;
    private j aac;
    private boolean aae;
    private int aaf;
    private long aag;
    private boolean aah;
    private boolean aai;
    private int aaj;
    private Runnable aak;
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
        this.aab = false;
        this.aae = false;
        this.aaf = 100;
        this.mStartPosition = 0;
        this.aah = false;
        this.aai = false;
        this.aaj = 0;
        this.aak = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mY().removeCallbacks(VideoPasterContentView.this.aak);
                if (!VideoPasterContentView.this.aae) {
                    boolean z = VideoPasterContentView.this.ZY.getCurrentPositionSync() == 0 && VideoPasterContentView.this.aaf == 100;
                    if (VideoPasterContentView.this.ZY.getCurrentPositionSync() > VideoPasterContentView.this.aaf) {
                        VideoPasterContentView.this.rZ();
                    } else if (z) {
                        e.mY().postDelayed(VideoPasterContentView.this.aak, 20L);
                    } else {
                        VideoPasterContentView.this.rZ();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.ZV = new VideoPasterOverlayView(getContext());
        this.ZW = new TbImageView(getContext());
        this.ZX = new TbImageView(getContext());
        this.ZY = new TbCyberVideoView(getContext());
        this.ZY.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.ZY.setContinuePlayEnable(true);
        this.ZY.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.ZY != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.ZY.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.ZY.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.ZY.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.aaj = VideoPasterContentView.this.ZY.getDuration();
                    if (VideoPasterContentView.this.ZV != null) {
                        VideoPasterContentView.this.ZV.d(VideoPasterContentView.this.ZY.getVideoWidth(), VideoPasterContentView.this.ZY.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.ZY.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.sb();
            }
        });
        this.ZY.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.sb();
                return false;
            }
        });
        this.ZY.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.aae = false;
                VideoPasterContentView.this.aaf = 100;
                e.mY().removeCallbacks(VideoPasterContentView.this.aak);
            }
        });
        this.ZZ = new f();
        this.ZZ.setPlayer(this.ZY);
        this.ZZ.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.ZV.a(this.pasterData, z, z2);
            if (!this.aab) {
                if (this.pasterData.rT() == 0) {
                    this.ZV.setCountDownNum(this.pasterData.Zv);
                    be(this.pasterData.Zv);
                } else if (this.pasterData.rT() == 1) {
                    this.ZV.setCountDownNum(this.pasterData.Zv);
                    be(this.pasterData.Zv);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rT() == 0) {
                    removeAllViews();
                    addView(this.ZW);
                    addView(this.ZV.getRootView(), layoutParams);
                    this.ZW.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.mS().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.ZV != null) {
                                VideoPasterContentView.this.ZV.d(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.ZW.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rT() == 1) {
                    sa();
                    removeAllViews();
                    addView(this.ZY.getView());
                    addView(this.ZX);
                    addView(this.ZV.getRootView(), layoutParams);
                    this.ZX.startLoad(this.pasterData.Zw, 10, false);
                    this.ZY.setVideoPath(this.pasterData.videoUrl);
                    this.ZY.start();
                    e.mY().removeCallbacks(this.aak);
                    e.mY().postDelayed(this.aak, 20L);
                }
                this.aab = true;
                this.aah = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.aac != null) {
                    this.aac.pause();
                }
            } else if (this.pasterData.rT() == 1) {
                this.ZX.setVisibility(0);
                this.ZY.stopPlayback();
                if (this.ZZ != null) {
                    this.ZZ.stop();
                }
                if (this.aac != null) {
                    this.aac.pause();
                }
                e.mY().removeCallbacks(this.aak);
            }
            if (this.ZV != null) {
                this.ZV.stop();
            }
            this.aah = false;
            this.aae = false;
        }
    }

    public void rF() {
        if (this.pasterData != null && this.pasterData.rT() == 1 && this.ZX != null) {
            this.ZX.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (!this.aae) {
            this.aae = true;
            this.ZX.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.aac != null) {
                    this.aac.resume();
                }
            } else if (this.pasterData.rT() == 1) {
                this.ZX.setVisibility(0);
                this.ZY.setVideoPath(this.pasterData.videoUrl);
                this.ZY.start();
                if (this.ZZ != null) {
                    this.ZZ.start();
                }
                if (this.aac != null) {
                    this.aac.resume();
                }
                if (this.aab) {
                    this.mStartPosition = n.dxh().QK(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.aaj > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.aaf = i;
                } else {
                    this.aaf = 100;
                }
                e.mY().removeCallbacks(this.aak);
                e.mY().postDelayed(this.aak, 20L);
            }
            if (this.ZV != null) {
                this.ZV.resume();
            }
            this.aah = true;
        }
    }

    private void be(int i) {
        if (this.aac != null) {
            this.aac.stop();
            this.aac.a((j.a) null);
        }
        this.aac = new j(i * 1000, 1000L);
        this.aac.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.j.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.aag = (int) (j2 / 1000);
                if (VideoPasterContentView.this.ZV != null) {
                    VideoPasterContentView.this.ZV.setCountDownNum((int) VideoPasterContentView.this.aag);
                }
                if (VideoPasterContentView.this.aag == 0) {
                    VideoPasterContentView.this.sb();
                    VideoPasterContentView.this.aac.stop();
                }
            }

            @Override // com.baidu.tbadk.util.j.a
            public void P(long j) {
                VideoPasterContentView.this.sb();
            }
        });
        this.aac.start();
        this.aai = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.ZV != null) {
            this.ZV.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.aaa = aVar;
    }

    public boolean rA() {
        return this.aab;
    }

    public boolean rB() {
        return this.aah;
    }

    public void reset() {
        sa();
        stop();
        this.ZV.reset();
        this.aab = false;
        this.pasterData = null;
        this.aag = 0L;
        this.aae = false;
        this.aaf = 100;
        e.mY().removeCallbacks(this.aak);
    }

    private void sa() {
        if (this.pasterData != null && this.pasterData.rT() == 1) {
            n.dxh().remove(this.pasterData.videoUrl);
            if (this.ZY != null) {
                this.ZY.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        this.aai = true;
        if (this.aaa != null) {
            this.aaa.rQ();
        }
        removeAllViews();
        this.pasterData = null;
        this.aag = 0L;
        this.aab = false;
        this.aah = false;
        this.aae = false;
        this.aaf = 100;
        e.mY().removeCallbacks(this.aak);
    }

    public void aZ(int i) {
        if (this.ZV != null) {
            this.ZV.aZ(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.aac == null) {
            return 0;
        }
        return ((int) this.aac.bDA()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.Zv;
    }

    public void rI() {
        if (this.ZV != null) {
            this.ZV.rI();
        }
    }

    public void rJ() {
        int i = 100;
        if (this.ZV != null) {
            this.ZV.rJ();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.aab && this.pasterData.rT() == 1) {
            this.ZX.setVisibility(0);
            this.mStartPosition = n.dxh().QK(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.aaj > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.aaf = i;
            e.mY().removeCallbacks(this.aak);
            e.mY().postDelayed(this.aak, 20L);
        }
    }

    public boolean ik() {
        return this.aai;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aaa != null) {
            this.aaa.onDetachedFromWindow();
        }
    }

    public boolean rK() {
        return this.ZY != null && this.ZY.isPlaying();
    }
}
