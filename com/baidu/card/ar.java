package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public abstract class ar extends b<AbsThreadDataSupport> implements com.baidu.tieba.play.e {
    private static final int agr = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ags = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agt = ags - agr;
    private static int agu = agt / 2;
    private static int agv = agt / 3;
    protected AbsThreadDataSupport adQ;
    protected com.baidu.tieba.play.operableVideoView.a agA;
    private BdUniqueId agB;
    private final View.OnClickListener agC;
    private a.b agD;
    private boolean agn;
    protected RoundCornerFrameLayout agz;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a rR();

    public ar(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.agn = false;
        this.agC = new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.adO != null) {
                    ar.this.adO.a(ar.this.adQ);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ar.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.rL() != null) {
                    ar.this.rL().a(view, ar.this.adQ);
                }
            }
        };
        this.agD = new a.b() { // from class: com.baidu.card.ar.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c0096a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(ar.this.mTitle, ar.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                } else if (c0096a.getActionType() == 2) {
                    if (ar.this.agA != null) {
                        ar.this.agA.bBh();
                    }
                } else if (c0096a.getActionType() == 3) {
                    if (ar.this.agA != null) {
                        ar.this.agA.cUq();
                    }
                } else if (c0096a.getActionType() == 6) {
                    if (ar.this.agA != null) {
                        return ar.this.agA.cZt();
                    }
                } else if (c0096a.getActionType() == 7) {
                    if (ar.this.agz != null) {
                        ar.this.agz.aN(((Boolean) c0096a.sm()).booleanValue());
                    }
                } else if (c0096a.getActionType() == 8 && ar.this.agA != null && (c0096a.sm() instanceof Boolean)) {
                    return ar.this.agA.ph(((Boolean) c0096a.sm()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        a(1, this.agD);
        a(2, this.agD);
        a(3, this.agD);
        a(6, this.agD);
        a(7, this.agD);
        a(8, this.agD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.agz = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            com.baidu.tbadk.a.b.a.e(this.agz, R.dimen.tbds28, R.dimen.tbds14);
            com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
            this.agA = rR();
            this.agA.cYJ().setBackgroundResource(R.color.transparent);
            this.agA.setUniqueId(this.agB);
            this.agA.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ags = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            agt = ags - agr;
            agu = agt / 2;
            agv = agt / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.adQ = absThreadDataSupport;
        if (this.adQ != null && this.adQ.aTN() != null && this.adQ.aTN().aWD() != null) {
            this.agA.setData(absThreadDataSupport.aTN());
            ViewGroup.LayoutParams layoutParams = this.agz.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.adQ.aTN().aWD().is_vertical.intValue() == 1) {
                int i3 = (agu / 9) * 16;
                int i4 = agv;
                int intValue = this.adQ.aTN().aWD().video_width.intValue();
                int intValue2 = this.adQ.aTN().aWD().video_height.intValue();
                layoutParams.width = agu;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.agA, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.agA, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * agu);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.agA, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.agA, i, i2);
                }
            } else {
                layoutParams.width = agt;
                layoutParams.height = (agt / 16) * 9;
                if (i2 == layoutParams.height && i == layoutParams.width) {
                    z2 = false;
                }
            }
            if (z2) {
                this.agz.setLayoutParams(layoutParams);
            }
            if (this.adQ.aTN().aYh()) {
                this.mTitle.setMaxLines(5);
                ax.a(this.mTitle, this.adQ.aTN(), agt, this.agn);
            } else {
                this.mTitle.setMaxLines(2);
                ax.a(this.mTitle, this.adQ.aTN(), 0, this.agn);
            }
            if (this.adO != null) {
                this.agA.ab(this.agC);
            }
            if (rL() != null) {
                this.agA.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.adO = aVar;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.adQ != null && this.adQ.aTN() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            this.agz.onChangeSkinType(i);
            this.agz.setBackgroundColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_bg_line_j));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.agA != null) {
            this.agA.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a sl() {
        return this.agA;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.agA.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.agA.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.agA == null) {
            return false;
        }
        return this.agA.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.b) && ((com.baidu.tbadk.core.util.f.b) this.mContext).videoNeedPreload()) {
            this.agA.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.agA.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.agz;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.adQ == null || this.adQ.aTN() == null) {
            return null;
        }
        return this.adQ.aTN().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.agA != null) {
            this.agA.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agB = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.agA.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn = z;
    }
}
