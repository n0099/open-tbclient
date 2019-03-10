package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class ac extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.f {
    protected com.baidu.tbadk.core.data.a Xx;
    protected RoundCornerFrameLayout Zo;
    protected com.baidu.tieba.play.operableVideoView.a Zp;
    private BdUniqueId Zq;
    private a.b Zr;
    private String mFrom;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int Zk = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds88);
    private static final int SCREEN_WIDTH = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
    private static final int Zl = SCREEN_WIDTH - Zk;
    private static final int Zm = Zl / 2;
    private static final int Zn = Zl / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a ro();

    public ac(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.rk() != null) {
                    ac.this.rk().a(view, ac.this.Xx);
                }
            }
        };
        this.Zr = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0037a c0037a) {
                if (c0037a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.Xx.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                } else if (c0037a.getActionType() == 2) {
                    if (ac.this.Zp != null) {
                        ac.this.Zp.bTX();
                    }
                } else if (c0037a.getActionType() == 3) {
                    if (ac.this.Zp != null) {
                        ac.this.Zp.bTY();
                    }
                } else if (c0037a.getActionType() == 6) {
                    if (ac.this.Zp != null) {
                        return ac.this.Zp.onBackPress();
                    }
                } else if (c0037a.getActionType() == 7) {
                    if (ac.this.Zo != null) {
                        ac.this.Zo.aJ(((Boolean) c0037a.rD()).booleanValue());
                    }
                } else if (c0037a.getActionType() == 8 && ac.this.Zp != null && (c0037a.rD() instanceof Boolean)) {
                    return ac.this.Zp.kr(((Boolean) c0037a.rD()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, this.Zr);
        a(2, this.Zr);
        a(3, this.Zr);
        a(6, this.Zr);
        a(7, this.Zr);
        a(8, this.Zr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(d.g.video_seg_title);
            this.Zo = (RoundCornerFrameLayout) this.mRootView.findViewById(d.g.frame_video);
            this.Zp = ro();
            this.Zp.bSX().setBackgroundResource(d.C0236d.transparent);
            this.Zp.setUniqueId(this.Zq);
            this.Zp.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.Xx = aVar;
        if (this.Xx != null && this.Xx.WR() != null && this.Xx.WR().Zi() != null) {
            this.Zp.setData(aVar.WR());
            ViewGroup.LayoutParams layoutParams = this.Zo.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.Xx.WR().Zi().is_vertical.intValue() == 1) {
                com.baidu.tieba.play.v bTx = this.Zp.bTx();
                if (bTx != null) {
                    int i3 = (Zm / 9) * 16;
                    int i4 = Zn;
                    int videoWidth = bTx.getVideoWidth();
                    int videoHeight = bTx.getVideoHeight();
                    layoutParams.width = Zm;
                    boolean z2 = i != layoutParams.width;
                    if (videoWidth == 0 || videoHeight == 0) {
                        layoutParams.height = i3;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    } else {
                        int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Zm);
                        if (i5 >= i4) {
                            i4 = i5 > i3 ? i3 : i5;
                        }
                        layoutParams.height = i4;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    }
                } else {
                    return;
                }
            } else {
                layoutParams.width = Zl;
                layoutParams.height = (Zl / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                this.Zo.setLayoutParams(layoutParams);
            }
            au.a(this.mTitle, this.Xx.WR());
            if (rk() != null) {
                this.Zp.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Xx != null && this.Xx.WR() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.Xx.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            this.Zo.onChangeSkinType(i);
            this.Zo.setBackgroundColor(al.getColor(com.baidu.tbadk.util.e.get()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.Zp != null) {
            this.Zp.b(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a rC() {
        return this.Zp;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Zp.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Zp.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Zp == null) {
            return false;
        }
        return this.Zp.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.e.c) && ((com.baidu.tbadk.core.util.e.c) this.mContext).videoNeedPreload()) {
            this.Zp.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Zp.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Zo;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Xx == null || this.Xx.WR() == null) {
            return null;
        }
        return this.Xx.WR().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Zp != null) {
            this.Zp.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Zq = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Zp.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
