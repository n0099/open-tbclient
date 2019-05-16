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
    protected com.baidu.tbadk.core.data.a Vq;
    protected RoundCornerFrameLayout Xi;
    protected com.baidu.tieba.play.operableVideoView.a Xj;
    private BdUniqueId Xk;
    private a.b Xl;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int Xe = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int SCREEN_WIDTH = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
    private static int Xf = SCREEN_WIDTH - Xe;
    private static int Xg = Xf / 2;
    private static int Xh = Xf / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a qj();

    public ac(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.qf() != null) {
                    ac.this.qf().a(view, ac.this.Vq);
                }
            }
        };
        this.Xl = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.Vq.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0038a.getActionType() == 2) {
                    if (ac.this.Xj != null) {
                        ac.this.Xj.cbW();
                    }
                } else if (c0038a.getActionType() == 3) {
                    if (ac.this.Xj != null) {
                        ac.this.Xj.cbX();
                    }
                } else if (c0038a.getActionType() == 6) {
                    if (ac.this.Xj != null) {
                        return ac.this.Xj.onBackPress();
                    }
                } else if (c0038a.getActionType() == 7) {
                    if (ac.this.Xi != null) {
                        ac.this.Xi.aB(((Boolean) c0038a.qy()).booleanValue());
                    }
                } else if (c0038a.getActionType() == 8 && ac.this.Xj != null && (c0038a.qy() instanceof Boolean)) {
                    return ac.this.Xj.lh(((Boolean) c0038a.qy()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qe() {
        a(1, this.Xl);
        a(2, this.Xl);
        a(3, this.Xl);
        a(6, this.Xl);
        a(7, this.Xl);
        a(8, this.Xl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.Xi = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.Xj = qj();
            this.Xj.caV().setBackgroundResource(R.color.transparent);
            this.Xj.setUniqueId(this.Xk);
            this.Xj.setFrom(this.mFrom);
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
            Xf = SCREEN_WIDTH - Xe;
            Xg = Xf / 2;
            Xh = Xf / 3;
            this.mLastScreenWidth = af;
        }
        this.Vq = aVar;
        if (this.Vq != null && this.Vq.abv() != null && this.Vq.abv().adM() != null) {
            this.Xj.setData(aVar.abv());
            ViewGroup.LayoutParams layoutParams = this.Xi.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.Vq.abv().adM().is_vertical.intValue() == 1) {
                com.baidu.tieba.play.v cbw = this.Xj.cbw();
                if (cbw != null) {
                    int i3 = (Xg / 9) * 16;
                    int i4 = Xh;
                    int videoWidth = cbw.getVideoWidth();
                    int videoHeight = cbw.getVideoHeight();
                    layoutParams.width = Xg;
                    boolean z2 = i != layoutParams.width;
                    if (videoWidth == 0 || videoHeight == 0) {
                        layoutParams.height = i3;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    } else {
                        int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Xg);
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
                layoutParams.width = Xf;
                layoutParams.height = (Xf / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                this.Xi.setLayoutParams(layoutParams);
            }
            au.a(this.mTitle, this.Vq.abv());
            if (qf() != null) {
                this.Xj.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Vq != null && this.Vq.abv() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.Vq.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.Xi.onChangeSkinType(i);
            this.Xi.setBackgroundColor(al.getColor(com.baidu.tbadk.util.e.get()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.Xj != null) {
            this.Xj.b(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a qx() {
        return this.Xj;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Xj.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Xj.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Xj == null) {
            return false;
        }
        return this.Xj.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.e.c) && ((com.baidu.tbadk.core.util.e.c) this.mContext).videoNeedPreload()) {
            this.Xj.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Xj.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Xi;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Vq == null || this.Vq.abv() == null) {
            return null;
        }
        return this.Vq.abv().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Xj != null) {
            this.Xj.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Xk = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Xj.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
