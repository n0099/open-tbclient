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
    protected RoundCornerFrameLayout ahC;
    protected FakeVideoContainer ahD;
    private BdUniqueId ahE;
    private boolean ahF;
    private a.b ahG;
    protected com.baidu.tbadk.core.data.a ahi;
    private int mLastScreenWidth;
    protected View mRootView;
    protected TextView mTitle;
    private static final int ahx = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int ahy = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahz = ahy - ahx;
    private static int ahA = ahz / 2;
    private static int ahB = ahz / 3;

    public i(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ahF = false;
        this.ahG = new a.b() { // from class: com.baidu.card.i.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                if (c0090a.getActionType() == 7 && i.this.ahC != null) {
                    i.this.ahC.aN(((Boolean) c0090a.tF()).booleanValue());
                    return false;
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
        a(7, this.ahG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.ahC = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.ahD = new FakeVideoContainer(this.mContext);
            this.ahD.setBackgroundResource(R.color.transparent);
            this.ahC.addView(this.ahD);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahy = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahz = ahy - ahx;
            ahA = ahz / 2;
            ahB = ahz / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ahi = aVar;
        if (this.ahi != null && this.ahi.boO() != null && this.ahi.boO().brH() != null) {
            this.ahD.setData(aVar.boO());
            final ViewGroup.LayoutParams layoutParams = this.ahC.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.ahi.boO().brH().is_vertical.intValue() == 1) {
                int i3 = (ahA / 9) * 16;
                int i4 = ahB;
                int intValue = this.ahi.boO().brH().video_width.intValue();
                int intValue2 = this.ahi.boO().brH().video_height.intValue();
                layoutParams.width = ahA;
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
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ahA);
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
                layoutParams.width = ahz;
                layoutParams.height = (ahz / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.ahi.boO().brH().is_vertical.intValue() == 1) {
                    this.ahC.setLayoutParams(layoutParams);
                } else {
                    this.ahC.post(new Runnable() { // from class: com.baidu.card.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = i.this.mRootView.getWidth();
                            layoutParams.height = (i.this.mRootView.getWidth() / 16) * 9;
                            i.this.ahC.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.ahi.boO().btp()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.ahi.boO(), ahz, this.ahF);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.ahi.boO(), 0, this.ahF);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            ay.a(this.ahC, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahi != null && this.ahi.boO() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.ahC.onChangeSkinType(i);
            this.ahC.setBackgroundColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0209));
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahE = bdUniqueId;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }
}
