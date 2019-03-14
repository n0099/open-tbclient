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
    protected com.baidu.tbadk.core.data.a Xy;
    protected RoundCornerFrameLayout Zp;
    protected com.baidu.tieba.play.operableVideoView.a Zq;
    private BdUniqueId Zr;
    private a.b Zs;
    private String mFrom;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int Zl = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds88);
    private static final int SCREEN_WIDTH = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
    private static final int Zm = SCREEN_WIDTH - Zl;
    private static final int Zn = Zm / 2;
    private static final int Zo = Zm / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a ro();

    public ac(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.rk() != null) {
                    ac.this.rk().a(view, ac.this.Xy);
                }
            }
        };
        this.Zs = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                if (c0039a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.Xy.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                } else if (c0039a.getActionType() == 2) {
                    if (ac.this.Zq != null) {
                        ac.this.Zq.bTZ();
                    }
                } else if (c0039a.getActionType() == 3) {
                    if (ac.this.Zq != null) {
                        ac.this.Zq.bUa();
                    }
                } else if (c0039a.getActionType() == 6) {
                    if (ac.this.Zq != null) {
                        return ac.this.Zq.onBackPress();
                    }
                } else if (c0039a.getActionType() == 7) {
                    if (ac.this.Zp != null) {
                        ac.this.Zp.aJ(((Boolean) c0039a.rD()).booleanValue());
                    }
                } else if (c0039a.getActionType() == 8 && ac.this.Zq != null && (c0039a.rD() instanceof Boolean)) {
                    return ac.this.Zq.kr(((Boolean) c0039a.rD()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, this.Zs);
        a(2, this.Zs);
        a(3, this.Zs);
        a(6, this.Zs);
        a(7, this.Zs);
        a(8, this.Zs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(d.g.video_seg_title);
            this.Zp = (RoundCornerFrameLayout) this.mRootView.findViewById(d.g.frame_video);
            this.Zq = ro();
            this.Zq.bSZ().setBackgroundResource(d.C0277d.transparent);
            this.Zq.setUniqueId(this.Zr);
            this.Zq.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.Xy = aVar;
        if (this.Xy != null && this.Xy.WR() != null && this.Xy.WR().Zi() != null) {
            this.Zq.setData(aVar.WR());
            ViewGroup.LayoutParams layoutParams = this.Zp.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.Xy.WR().Zi().is_vertical.intValue() == 1) {
                com.baidu.tieba.play.v bTz = this.Zq.bTz();
                if (bTz != null) {
                    int i3 = (Zn / 9) * 16;
                    int i4 = Zo;
                    int videoWidth = bTz.getVideoWidth();
                    int videoHeight = bTz.getVideoHeight();
                    layoutParams.width = Zn;
                    boolean z2 = i != layoutParams.width;
                    if (videoWidth == 0 || videoHeight == 0) {
                        layoutParams.height = i3;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    } else {
                        int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Zn);
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
                layoutParams.width = Zm;
                layoutParams.height = (Zm / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                this.Zp.setLayoutParams(layoutParams);
            }
            au.a(this.mTitle, this.Xy.WR());
            if (rk() != null) {
                this.Zq.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Xy != null && this.Xy.WR() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.Xy.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            this.Zp.onChangeSkinType(i);
            this.Zp.setBackgroundColor(al.getColor(com.baidu.tbadk.util.e.get()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.Zq != null) {
            this.Zq.b(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a rC() {
        return this.Zq;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Zq.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Zq.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Zq == null) {
            return false;
        }
        return this.Zq.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.e.c) && ((com.baidu.tbadk.core.util.e.c) this.mContext).videoNeedPreload()) {
            this.Zq.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Zq.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Zp;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Xy == null || this.Xy.WR() == null) {
            return null;
        }
        return this.Xy.WR().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Zq != null) {
            this.Zq.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Zr = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Zq.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
