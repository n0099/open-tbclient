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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.FakeVideoContainer;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tbadk.core.data.a> {
    private static final int agG = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int agH = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agI = agH - agG;
    private static int agJ = agI / 2;
    private static int agK = agI / 3;
    protected RoundCornerFrameLayout agL;
    protected FakeVideoContainer agM;
    private BdUniqueId agN;
    private boolean agO;
    private a.b agP;
    protected com.baidu.tbadk.core.data.a agr;
    private int mLastScreenWidth;
    protected View mRootView;
    protected TextView mTitle;

    public i(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.agO = false;
        this.agP = new a.b() { // from class: com.baidu.card.i.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (c0089a.getActionType() == 7 && i.this.agL != null) {
                    i.this.agL.aN(((Boolean) c0089a.tu()).booleanValue());
                    return false;
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        a(7, this.agP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.agL = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.agM = new FakeVideoContainer(this.mContext);
            this.agM.setBackgroundResource(R.color.transparent);
            this.agL.addView(this.agM);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            agH = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            agI = agH - agG;
            agJ = agI / 2;
            agK = agI / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agr = aVar;
        if (this.agr != null && this.agr.bkV() != null && this.agr.bkV().bnO() != null) {
            this.agM.setData(aVar.bkV());
            final ViewGroup.LayoutParams layoutParams = this.agL.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.agr.bkV().bnO().is_vertical.intValue() == 1) {
                int i3 = (agJ / 9) * 16;
                int i4 = agK;
                int intValue = this.agr.bkV().bnO().video_width.intValue();
                int intValue2 = this.agr.bkV().bnO().video_height.intValue();
                layoutParams.width = agJ;
                boolean z4 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * agJ);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
                }
            } else {
                layoutParams.width = agI;
                layoutParams.height = (agI / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.agr.bkV().bnO().is_vertical.intValue() == 1) {
                    this.agL.setLayoutParams(layoutParams);
                } else {
                    this.agL.post(new Runnable() { // from class: com.baidu.card.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = i.this.mRootView.getWidth();
                            layoutParams.height = (i.this.mRootView.getWidth() / 16) * 9;
                            i.this.agL.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.agr.bkV().bpw()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.agr.bkV(), agI, this.agO);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.agr.bkV(), 0, this.agO);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            ay.a(this.agL, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agr != null && this.agr.bkV() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.agL.onChangeSkinType(i);
            this.agL.setBackgroundColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0209));
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agN = bdUniqueId;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }
}
