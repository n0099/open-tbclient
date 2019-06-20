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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class ac extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.f {
    protected com.baidu.tbadk.core.data.a Vp;
    protected RoundCornerFrameLayout Xh;
    protected com.baidu.tieba.play.operableVideoView.a Xi;
    private BdUniqueId Xj;
    private a.b Xk;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int Xd = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int SCREEN_WIDTH = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
    private static int Xe = SCREEN_WIDTH - Xd;
    private static int Xf = Xe / 2;
    private static int Xg = Xe / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a qj();

    public ac(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.qf() != null) {
                    ac.this.qf().a(view, ac.this.Vp);
                }
            }
        };
        this.Xk = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.Vp.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0038a.getActionType() == 2) {
                    if (ac.this.Xi != null) {
                        ac.this.Xi.cca();
                    }
                } else if (c0038a.getActionType() == 3) {
                    if (ac.this.Xi != null) {
                        ac.this.Xi.ccb();
                    }
                } else if (c0038a.getActionType() == 6) {
                    if (ac.this.Xi != null) {
                        return ac.this.Xi.onBackPress();
                    }
                } else if (c0038a.getActionType() == 7) {
                    if (ac.this.Xh != null) {
                        ac.this.Xh.aB(((Boolean) c0038a.qy()).booleanValue());
                    }
                } else if (c0038a.getActionType() == 8 && ac.this.Xi != null && (c0038a.qy() instanceof Boolean)) {
                    return ac.this.Xi.li(((Boolean) c0038a.qy()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qe() {
        a(1, this.Xk);
        a(2, this.Xk);
        a(3, this.Xk);
        a(6, this.Xk);
        a(7, this.Xk);
        a(8, this.Xk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.Xh = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.Xi = qj();
            this.Xi.caZ().setBackgroundResource(R.color.transparent);
            this.Xi.setUniqueId(this.Xj);
            this.Xi.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        if (af != this.mLastScreenWidth) {
            SCREEN_WIDTH = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
            Xe = SCREEN_WIDTH - Xd;
            Xf = Xe / 2;
            Xg = Xe / 3;
            this.mLastScreenWidth = af;
        }
        this.Vp = aVar;
        if (this.Vp != null && this.Vp.abv() != null && this.Vp.abv().adM() != null) {
            this.Xi.setData(aVar.abv());
            ViewGroup.LayoutParams layoutParams = this.Xh.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.Vp.abv().adM().is_vertical.intValue() == 1) {
                com.baidu.tieba.play.v cbA = this.Xi.cbA();
                if (cbA != null) {
                    int i3 = (Xf / 9) * 16;
                    int i4 = Xg;
                    int videoWidth = cbA.getVideoWidth();
                    int videoHeight = cbA.getVideoHeight();
                    layoutParams.width = Xf;
                    boolean z2 = i != layoutParams.width;
                    if (videoWidth == 0 || videoHeight == 0) {
                        layoutParams.height = i3;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    } else {
                        int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Xf);
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
                layoutParams.width = Xe;
                layoutParams.height = (Xe / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                this.Xh.setLayoutParams(layoutParams);
            }
            au.a(this.mTitle, this.Vp.abv());
            if (qf() != null) {
                this.Xi.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Vp != null && this.Vp.abv() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.Vp.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.Xh.onChangeSkinType(i);
            this.Xh.setBackgroundColor(al.getColor(com.baidu.tbadk.util.e.get()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.Xi != null) {
            this.Xi.b(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a qx() {
        return this.Xi;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Xi.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Xi.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Xi == null) {
            return false;
        }
        return this.Xi.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.e.c) && ((com.baidu.tbadk.core.util.e.c) this.mContext).videoNeedPreload()) {
            this.Xi.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Xi.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Xh;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Vp == null || this.Vp.abv() == null) {
            return null;
        }
        return this.Vp.abv().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Xi != null) {
            this.Xi.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Xj = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Xi.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
