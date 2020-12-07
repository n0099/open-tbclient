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
    private VideoPasterOverlayView aaW;
    private TbImageView aaX;
    private TbImageView aaY;
    private TbCyberVideoView aaZ;
    private f aba;
    private a abb;
    private boolean abd;
    private j abe;
    private boolean abf;
    private int abg;
    private long abh;
    private boolean abi;
    private boolean abj;
    private int abk;
    private Runnable abl;
    private String mFrom;
    private int mStartPosition;
    private com.baidu.afd.videopaster.data.a pasterData;

    /* loaded from: classes21.dex */
    public interface a {
        void onDetachedFromWindow();

        void rS();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.abd = false;
        this.abf = false;
        this.abg = 100;
        this.mStartPosition = 0;
        this.abi = false;
        this.abj = false;
        this.abk = 0;
        this.abl = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mY().removeCallbacks(VideoPasterContentView.this.abl);
                if (!VideoPasterContentView.this.abf) {
                    boolean z = VideoPasterContentView.this.aaZ.getCurrentPositionSync() == 0 && VideoPasterContentView.this.abg == 100;
                    if (VideoPasterContentView.this.aaZ.getCurrentPositionSync() > VideoPasterContentView.this.abg) {
                        VideoPasterContentView.this.sb();
                    } else if (z) {
                        e.mY().postDelayed(VideoPasterContentView.this.abl, 20L);
                    } else {
                        VideoPasterContentView.this.sb();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.aaW = new VideoPasterOverlayView(getContext());
        this.aaX = new TbImageView(getContext());
        this.aaY = new TbImageView(getContext());
        this.aaZ = new TbCyberVideoView(getContext());
        this.aaZ.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.aaZ.setContinuePlayEnable(true);
        this.aaZ.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.aaZ != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.aaZ.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.aaZ.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.aaZ.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.abk = VideoPasterContentView.this.aaZ.getDuration();
                    if (VideoPasterContentView.this.aaW != null) {
                        VideoPasterContentView.this.aaW.d(VideoPasterContentView.this.aaZ.getVideoWidth(), VideoPasterContentView.this.aaZ.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.aaZ.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.sd();
            }
        });
        this.aaZ.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.sd();
                return false;
            }
        });
        this.aaZ.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.abf = false;
                VideoPasterContentView.this.abg = 100;
                e.mY().removeCallbacks(VideoPasterContentView.this.abl);
            }
        });
        this.aba = new f();
        this.aba.setPlayer(this.aaZ);
        this.aba.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void se() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.aaW.a(this.pasterData, z, z2);
            if (!this.abd) {
                if (this.pasterData.rV() == 0) {
                    this.aaW.setCountDownNum(this.pasterData.aaw);
                    bi(this.pasterData.aaw);
                } else if (this.pasterData.rV() == 1) {
                    this.aaW.setCountDownNum(this.pasterData.aaw);
                    bi(this.pasterData.aaw);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rV() == 0) {
                    removeAllViews();
                    addView(this.aaX);
                    addView(this.aaW.getRootView(), layoutParams);
                    this.aaX.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.mS().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.aaW != null) {
                                VideoPasterContentView.this.aaW.d(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.aaX.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rV() == 1) {
                    sc();
                    removeAllViews();
                    addView(this.aaZ.getView());
                    addView(this.aaY);
                    addView(this.aaW.getRootView(), layoutParams);
                    this.aaY.startLoad(this.pasterData.aax, 10, false);
                    this.aaZ.setVideoPath(this.pasterData.videoUrl);
                    this.aaZ.start();
                    e.mY().removeCallbacks(this.abl);
                    e.mY().postDelayed(this.abl, 20L);
                }
                this.abd = true;
                this.abi = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rV() == 0) {
                if (this.abe != null) {
                    this.abe.pause();
                }
            } else if (this.pasterData.rV() == 1) {
                this.aaY.setVisibility(0);
                this.aaZ.stopPlayback();
                if (this.aba != null) {
                    this.aba.stop();
                }
                if (this.abe != null) {
                    this.abe.pause();
                }
                e.mY().removeCallbacks(this.abl);
            }
            if (this.aaW != null) {
                this.aaW.stop();
            }
            this.abi = false;
            this.abf = false;
        }
    }

    public void rH() {
        if (this.pasterData != null && this.pasterData.rV() == 1 && this.aaY != null) {
            this.aaY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        if (!this.abf) {
            this.abf = true;
            this.aaY.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rV() == 0) {
                if (this.abe != null) {
                    this.abe.resume();
                }
            } else if (this.pasterData.rV() == 1) {
                this.aaY.setVisibility(0);
                this.aaZ.setVideoPath(this.pasterData.videoUrl);
                this.aaZ.start();
                if (this.aba != null) {
                    this.aba.start();
                }
                if (this.abe != null) {
                    this.abe.resume();
                }
                if (this.abd) {
                    this.mStartPosition = n.dBZ().Ro(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.abk > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.abg = i;
                } else {
                    this.abg = 100;
                }
                e.mY().removeCallbacks(this.abl);
                e.mY().postDelayed(this.abl, 20L);
            }
            if (this.aaW != null) {
                this.aaW.resume();
            }
            this.abi = true;
        }
    }

    private void bi(int i) {
        if (this.abe != null) {
            this.abe.stop();
            this.abe.a((j.a) null);
        }
        this.abe = new j(i * 1000, 1000L);
        this.abe.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.j.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.abh = (int) (j2 / 1000);
                if (VideoPasterContentView.this.aaW != null) {
                    VideoPasterContentView.this.aaW.setCountDownNum((int) VideoPasterContentView.this.abh);
                }
                if (VideoPasterContentView.this.abh == 0) {
                    VideoPasterContentView.this.sd();
                    VideoPasterContentView.this.abe.stop();
                }
            }

            @Override // com.baidu.tbadk.util.j.a
            public void N(long j) {
                VideoPasterContentView.this.sd();
            }
        });
        this.abe.start();
        this.abj = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.aaW != null) {
            this.aaW.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.abb = aVar;
    }

    public boolean rC() {
        return this.abd;
    }

    public boolean rD() {
        return this.abi;
    }

    public void reset() {
        sc();
        stop();
        this.aaW.reset();
        this.abd = false;
        this.pasterData = null;
        this.abh = 0L;
        this.abf = false;
        this.abg = 100;
        e.mY().removeCallbacks(this.abl);
    }

    private void sc() {
        if (this.pasterData != null && this.pasterData.rV() == 1) {
            n.dBZ().remove(this.pasterData.videoUrl);
            if (this.aaZ != null) {
                this.aaZ.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sd() {
        this.abj = true;
        if (this.abb != null) {
            this.abb.rS();
        }
        removeAllViews();
        this.pasterData = null;
        this.abh = 0L;
        this.abd = false;
        this.abi = false;
        this.abf = false;
        this.abg = 100;
        e.mY().removeCallbacks(this.abl);
    }

    public void bd(int i) {
        if (this.aaW != null) {
            this.aaW.bd(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.abe == null) {
            return 0;
        }
        return ((int) this.abe.bGu()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.aaw;
    }

    public void rK() {
        if (this.aaW != null) {
            this.aaW.rK();
        }
    }

    public void rL() {
        int i = 100;
        if (this.aaW != null) {
            this.aaW.rL();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.abd && this.pasterData.rV() == 1) {
            this.aaY.setVisibility(0);
            this.mStartPosition = n.dBZ().Ro(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.abk > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.abg = i;
            e.mY().removeCallbacks(this.abl);
            e.mY().postDelayed(this.abl, 20L);
        }
    }

    public boolean ik() {
        return this.abj;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.abb != null) {
            this.abb.onDetachedFromWindow();
        }
    }

    public boolean rM() {
        return this.aaZ != null && this.aaZ.isPlaying();
    }
}
