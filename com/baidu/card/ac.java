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
    protected com.baidu.tbadk.core.data.a Xz;
    protected RoundCornerFrameLayout Zq;
    protected com.baidu.tieba.play.operableVideoView.a Zr;
    private BdUniqueId Zs;
    private a.b Zt;
    private String mFrom;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int Zm = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds88);
    private static final int SCREEN_WIDTH = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
    private static final int Zn = SCREEN_WIDTH - Zm;
    private static final int Zo = Zn / 2;
    private static final int Zp = Zn / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a ro();

    public ac(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.rk() != null) {
                    ac.this.rk().a(view, ac.this.Xz);
                }
            }
        };
        this.Zt = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                if (c0039a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.Xz.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                } else if (c0039a.getActionType() == 2) {
                    if (ac.this.Zr != null) {
                        ac.this.Zr.bTV();
                    }
                } else if (c0039a.getActionType() == 3) {
                    if (ac.this.Zr != null) {
                        ac.this.Zr.bTW();
                    }
                } else if (c0039a.getActionType() == 6) {
                    if (ac.this.Zr != null) {
                        return ac.this.Zr.onBackPress();
                    }
                } else if (c0039a.getActionType() == 7) {
                    if (ac.this.Zq != null) {
                        ac.this.Zq.aJ(((Boolean) c0039a.rD()).booleanValue());
                    }
                } else if (c0039a.getActionType() == 8 && ac.this.Zr != null && (c0039a.rD() instanceof Boolean)) {
                    return ac.this.Zr.kr(((Boolean) c0039a.rD()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, this.Zt);
        a(2, this.Zt);
        a(3, this.Zt);
        a(6, this.Zt);
        a(7, this.Zt);
        a(8, this.Zt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(d.g.video_seg_title);
            this.Zq = (RoundCornerFrameLayout) this.mRootView.findViewById(d.g.frame_video);
            this.Zr = ro();
            this.Zr.bSV().setBackgroundResource(d.C0277d.transparent);
            this.Zr.setUniqueId(this.Zs);
            this.Zr.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.Xz = aVar;
        if (this.Xz != null && this.Xz.WO() != null && this.Xz.WO().Zf() != null) {
            this.Zr.setData(aVar.WO());
            ViewGroup.LayoutParams layoutParams = this.Zq.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.Xz.WO().Zf().is_vertical.intValue() == 1) {
                com.baidu.tieba.play.v bTv = this.Zr.bTv();
                if (bTv != null) {
                    int i3 = (Zo / 9) * 16;
                    int i4 = Zp;
                    int videoWidth = bTv.getVideoWidth();
                    int videoHeight = bTv.getVideoHeight();
                    layoutParams.width = Zo;
                    boolean z2 = i != layoutParams.width;
                    if (videoWidth == 0 || videoHeight == 0) {
                        layoutParams.height = i3;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    } else {
                        int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Zo);
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
                layoutParams.width = Zn;
                layoutParams.height = (Zn / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                this.Zq.setLayoutParams(layoutParams);
            }
            au.a(this.mTitle, this.Xz.WO());
            if (rk() != null) {
                this.Zr.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Xz != null && this.Xz.WO() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.Xz.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            this.Zq.onChangeSkinType(i);
            this.Zq.setBackgroundColor(al.getColor(com.baidu.tbadk.util.e.get()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.Zr != null) {
            this.Zr.b(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a rC() {
        return this.Zr;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Zr.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Zr.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Zr == null) {
            return false;
        }
        return this.Zr.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.e.c) && ((com.baidu.tbadk.core.util.e.c) this.mContext).videoNeedPreload()) {
            this.Zr.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Zr.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Zq;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Xz == null || this.Xz.WO() == null) {
            return null;
        }
        return this.Xz.WO().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Zr != null) {
            this.Zr.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Zs = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Zr.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
