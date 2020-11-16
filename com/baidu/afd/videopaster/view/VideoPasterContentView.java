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
    private VideoPasterOverlayView aaa;
    private TbImageView aab;
    private TbImageView aac;
    private TbCyberVideoView aae;
    private f aaf;
    private a aag;
    private boolean aah;
    private j aai;
    private boolean aaj;
    private int aak;
    private long aal;
    private boolean aam;
    private boolean aan;
    private int aao;
    private Runnable aap;
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
        this.aah = false;
        this.aaj = false;
        this.aak = 100;
        this.mStartPosition = 0;
        this.aam = false;
        this.aan = false;
        this.aao = 0;
        this.aap = new Runnable() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.7
            @Override // java.lang.Runnable
            public void run() {
                e.mY().removeCallbacks(VideoPasterContentView.this.aap);
                if (!VideoPasterContentView.this.aaj) {
                    boolean z = VideoPasterContentView.this.aae.getCurrentPositionSync() == 0 && VideoPasterContentView.this.aak == 100;
                    if (VideoPasterContentView.this.aae.getCurrentPositionSync() > VideoPasterContentView.this.aak) {
                        VideoPasterContentView.this.rZ();
                    } else if (z) {
                        e.mY().postDelayed(VideoPasterContentView.this.aap, 20L);
                    } else {
                        VideoPasterContentView.this.rZ();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.aaa = new VideoPasterOverlayView(getContext());
        this.aab = new TbImageView(getContext());
        this.aac = new TbImageView(getContext());
        this.aae = new TbCyberVideoView(getContext());
        this.aae.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.aae.setContinuePlayEnable(true);
        this.aae.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (VideoPasterContentView.this.aae != null) {
                    if (!TextUtils.equals(VideoPasterContentView.this.mFrom, "NEWINDEX")) {
                        VideoPasterContentView.this.aae.setVolume(1.0f, 1.0f);
                    } else if (TbSingleton.getInstance().isVideoCardMute()) {
                        VideoPasterContentView.this.aae.setVolume(0.0f, 0.0f);
                    } else {
                        VideoPasterContentView.this.aae.setVolume(1.0f, 1.0f);
                    }
                    VideoPasterContentView.this.aao = VideoPasterContentView.this.aae.getDuration();
                    if (VideoPasterContentView.this.aaa != null) {
                        VideoPasterContentView.this.aaa.c(VideoPasterContentView.this.aae.getVideoWidth(), VideoPasterContentView.this.aae.getVideoHeight(), VideoPasterContentView.this.mFrom);
                    }
                }
            }
        });
        this.aae.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                VideoPasterContentView.this.sb();
            }
        });
        this.aae.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                VideoPasterContentView.this.sb();
                return false;
            }
        });
        this.aae.setOnSurfaceDestroyedListener(new TbCyberVideoView.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.4
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                VideoPasterContentView.this.aaj = false;
                VideoPasterContentView.this.aak = 100;
                e.mY().removeCallbacks(VideoPasterContentView.this.aap);
            }
        });
        this.aaf = new f();
        this.aaf.setPlayer(this.aae);
        this.aaf.a(new f.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.5
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
            }
        });
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void b(boolean z, boolean z2, String str) {
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty()) {
            this.aaa.a(this.pasterData, z, z2);
            if (!this.aah) {
                if (this.pasterData.rT() == 0) {
                    this.aaa.setCountDownNum(this.pasterData.ZA);
                    be(this.pasterData.ZA);
                } else if (this.pasterData.rT() == 1) {
                    this.aaa.setCountDownNum(this.pasterData.ZA);
                    be(this.pasterData.ZA);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mFrom = str;
                if (this.pasterData.rT() == 0) {
                    removeAllViews();
                    addView(this.aab);
                    addView(this.aaa.getRootView(), layoutParams);
                    this.aab.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    c.mS().a(this.pasterData.picUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            super.onLoaded((AnonymousClass6) aVar, str2, i);
                            if (aVar != null && aVar.getRawBitmap() != null && VideoPasterContentView.this.aaa != null) {
                                VideoPasterContentView.this.aaa.c(aVar.getWidth(), aVar.getHeight(), VideoPasterContentView.this.mFrom);
                            }
                        }
                    }, null);
                    this.aab.startLoad(this.pasterData.picUrl, 10, false);
                } else if (this.pasterData.rT() == 1) {
                    sa();
                    removeAllViews();
                    addView(this.aae.getView());
                    addView(this.aac);
                    addView(this.aaa.getRootView(), layoutParams);
                    this.aac.startLoad(this.pasterData.ZB, 10, false);
                    this.aae.setVideoPath(this.pasterData.videoUrl);
                    this.aae.start();
                    e.mY().removeCallbacks(this.aap);
                    e.mY().postDelayed(this.aap, 20L);
                }
                this.aah = true;
                this.aam = true;
            }
        }
    }

    public void stop() {
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.aai != null) {
                    this.aai.pause();
                }
            } else if (this.pasterData.rT() == 1) {
                this.aac.setVisibility(0);
                this.aae.stopPlayback();
                if (this.aaf != null) {
                    this.aaf.stop();
                }
                if (this.aai != null) {
                    this.aai.pause();
                }
                e.mY().removeCallbacks(this.aap);
            }
            if (this.aaa != null) {
                this.aaa.stop();
            }
            this.aam = false;
            this.aaj = false;
        }
    }

    public void rF() {
        if (this.pasterData != null && this.pasterData.rT() == 1 && this.aac != null) {
            this.aac.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (!this.aaj) {
            this.aaj = true;
            this.aac.setVisibility(8);
        }
    }

    public void resume() {
        int i = 100;
        if (this.pasterData != null) {
            if (this.pasterData.rT() == 0) {
                if (this.aai != null) {
                    this.aai.resume();
                }
            } else if (this.pasterData.rT() == 1) {
                this.aac.setVisibility(0);
                this.aae.setVideoPath(this.pasterData.videoUrl);
                this.aae.start();
                if (this.aaf != null) {
                    this.aaf.start();
                }
                if (this.aai != null) {
                    this.aai.resume();
                }
                if (this.aah) {
                    this.mStartPosition = n.dwH().Qf(this.pasterData.videoUrl);
                    if (this.mStartPosition > 100 && this.aao > this.mStartPosition) {
                        i = this.mStartPosition;
                    }
                    this.aak = i;
                } else {
                    this.aak = 100;
                }
                e.mY().removeCallbacks(this.aap);
                e.mY().postDelayed(this.aap, 20L);
            }
            if (this.aaa != null) {
                this.aaa.resume();
            }
            this.aam = true;
        }
    }

    private void be(int i) {
        if (this.aai != null) {
            this.aai.stop();
            this.aai.a((j.a) null);
        }
        this.aai = new j(i * 1000, 1000L);
        this.aai.a(new j.a() { // from class: com.baidu.afd.videopaster.view.VideoPasterContentView.8
            @Override // com.baidu.tbadk.util.j.a
            public void b(long j, long j2) {
                VideoPasterContentView.this.aal = (int) (j2 / 1000);
                if (VideoPasterContentView.this.aaa != null) {
                    VideoPasterContentView.this.aaa.setCountDownNum((int) VideoPasterContentView.this.aal);
                }
                if (VideoPasterContentView.this.aal == 0) {
                    VideoPasterContentView.this.sb();
                    VideoPasterContentView.this.aai.stop();
                }
            }

            @Override // com.baidu.tbadk.util.j.a
            public void P(long j) {
                VideoPasterContentView.this.sb();
            }
        });
        this.aai.start();
        this.aan = false;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.a aVar) {
        if (this.aaa != null) {
            this.aaa.setOverlayViewCallback(aVar);
        }
    }

    public void setContentViewCallback(a aVar) {
        this.aag = aVar;
    }

    public boolean rA() {
        return this.aah;
    }

    public boolean rB() {
        return this.aam;
    }

    public void reset() {
        sa();
        stop();
        this.aaa.reset();
        this.aah = false;
        this.pasterData = null;
        this.aal = 0L;
        this.aaj = false;
        this.aak = 100;
        e.mY().removeCallbacks(this.aap);
    }

    private void sa() {
        if (this.pasterData != null && this.pasterData.rT() == 1) {
            n.dwH().remove(this.pasterData.videoUrl);
            if (this.aae != null) {
                this.aae.seekTo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        this.aan = true;
        if (this.aag != null) {
            this.aag.rQ();
        }
        removeAllViews();
        this.pasterData = null;
        this.aal = 0L;
        this.aah = false;
        this.aam = false;
        this.aaj = false;
        this.aak = 100;
        e.mY().removeCallbacks(this.aap);
    }

    public void aZ(int i) {
        if (this.aaa != null) {
            this.aaa.aZ(i);
        }
    }

    public void setData(com.baidu.afd.videopaster.data.a aVar) {
        this.pasterData = aVar;
    }

    public int getCurDuration() {
        if (this.pasterData == null || this.aai == null) {
            return 0;
        }
        return ((int) this.aai.bCT()) / 1000;
    }

    public int getTotalDuration() {
        if (this.pasterData == null) {
            return -1;
        }
        return this.pasterData.ZA;
    }

    public void rI() {
        if (this.aaa != null) {
            this.aaa.rI();
        }
    }

    public void rJ() {
        int i = 100;
        if (this.aaa != null) {
            this.aaa.rJ();
        }
        if (this.pasterData != null && this.pasterData.isValid() && !this.pasterData.isEmpty() && this.aah && this.pasterData.rT() == 1) {
            this.aac.setVisibility(0);
            this.mStartPosition = n.dwH().Qf(this.pasterData.videoUrl);
            if (this.mStartPosition > 100 && this.aao > this.mStartPosition) {
                i = this.mStartPosition;
            }
            this.aak = i;
            e.mY().removeCallbacks(this.aap);
            e.mY().postDelayed(this.aap, 20L);
        }
    }

    public boolean ik() {
        return this.aan;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aag != null) {
            this.aag.onDetachedFromWindow();
        }
    }

    public boolean rK() {
        return this.aae != null && this.aae.isPlaying();
    }
}
