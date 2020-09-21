package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.b;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
import tbclient.VideoInfo;
/* loaded from: classes20.dex */
public class as extends i {
    private static final int ahV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ahW = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahX = ahW;
    private static int ahY = ahX / 2;
    private static int ahZ = ahX / 3;
    private AbsThreadDataSupport afq;
    private VideoImageNoPlayerLayout aia;
    private com.baidu.card.view.a aib;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.aia = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aia;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahW = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahX = ahW;
            ahY = ahX / 2;
            ahZ = ahX / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.afq = absThreadDataSupport;
        if (this.afq == null || this.afq.bcY() == null || this.afq.bcY().efS == null || this.afq.bcY().efS.eav) {
            this.aia.setVisibility(8);
            return;
        }
        this.aia.setVisibility(0);
        this.aia.G(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.aia.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.aia.alx.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.afq.bcY().efS.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.afq.bcY().efS.videoInfo;
            if (videoInfo != null) {
                int i3 = (ahY / 9) * 16;
                int i4 = ahZ;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = ahX;
                layoutParams2.width = ahY;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    layoutParams2.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, layoutParams2, i, i2, z);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, layoutParams2, i, i2, z);
                } else {
                    int i5 = (int) (((1.0f * intValue2) / intValue) * ahY);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    layoutParams2.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, layoutParams2, i, i2, z);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, layoutParams2, i, i2, z);
                }
            } else {
                return;
            }
        } else {
            layoutParams.width = ahX;
            layoutParams2.width = ahX;
            layoutParams.height = ((ahX / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((ahX / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.aia.setLayoutParams(layoutParams);
            this.aia.alx.setLayoutParams(layoutParams2);
        }
        this.aia.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.as.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.afo != null) {
                    as.this.afo.a(as.this.afq);
                }
            }
        });
        this.aia.setData(this.afq);
        if (tB() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.aia.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.aia.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.afo = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.aib = aVar;
        if (aVar != null) {
            ub();
        }
    }

    private void ub() {
        if (this.aia != null) {
            this.aia.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.as.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (as.this.aib != null) {
                        as.this.aib.a(as.this.afq);
                    }
                }
            });
        }
    }
}
