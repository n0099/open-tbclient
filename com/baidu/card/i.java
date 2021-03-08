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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.FakeVideoContainer;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tbadk.core.data.a> {
    private static final int ahN = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int ahO = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahP = ahO - ahN;
    private static int ahQ = ahP / 2;
    private static int ahR = ahP / 3;
    protected com.baidu.tbadk.core.data.a ahB;
    protected RoundCornerFrameLayout ahS;
    protected FakeVideoContainer ahT;
    private BdUniqueId ahU;
    private boolean ahV;
    private a.b ahW;
    private int mLastScreenWidth;
    protected View mRootView;
    protected TextView mTitle;

    public i(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ahV = false;
        this.ahW = new a.b() { // from class: com.baidu.card.i.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.getActionType() == 7 && i.this.ahS != null) {
                    i.this.ahS.aN(((Boolean) c0095a.tr()).booleanValue());
                    return false;
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(7, this.ahW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.ahS = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.ahT = new FakeVideoContainer(this.mContext);
            this.ahT.setBackgroundResource(R.color.transparent);
            this.ahS.addView(this.ahT);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahO = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahP = ahO - ahN;
            ahQ = ahP / 2;
            ahR = ahP / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ahB = aVar;
        if (this.ahB != null && this.ahB.blp() != null && this.ahB.blp().boj() != null) {
            this.ahT.setData(aVar.blp());
            final ViewGroup.LayoutParams layoutParams = this.ahS.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.ahB.blp().boj().is_vertical.intValue() == 1) {
                int i3 = (ahQ / 9) * 16;
                int i4 = ahR;
                int intValue = this.ahB.blp().boj().video_width.intValue();
                int intValue2 = this.ahB.blp().boj().video_height.intValue();
                layoutParams.width = ahQ;
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
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ahQ);
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
                layoutParams.width = ahP;
                layoutParams.height = (ahP / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.ahB.blp().boj().is_vertical.intValue() == 1) {
                    this.ahS.setLayoutParams(layoutParams);
                } else {
                    this.ahS.post(new Runnable() { // from class: com.baidu.card.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = i.this.mRootView.getWidth();
                            layoutParams.height = (i.this.mRootView.getWidth() / 16) * 9;
                            i.this.ahS.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.ahB.blp().bpQ()) {
                this.mTitle.setMaxLines(5);
                az.a(this.mTitle, this.ahB.blp(), ahP, this.ahV);
            } else {
                this.mTitle.setMaxLines(2);
                az.a(this.mTitle, this.ahB.blp(), 0, this.ahV);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            az.a(this.ahS, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahB != null && this.ahB.blp() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.ahB.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.ahS.onChangeSkinType(i);
            this.ahS.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209));
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahU = bdUniqueId;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }
}
