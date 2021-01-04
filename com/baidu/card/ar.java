package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.a;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class ar extends h {
    private static final int ahx = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
    private static int ahy = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private com.baidu.tbadk.core.data.a ahi;
    private int akb;
    private int akc;
    private VideoImageNoPlayerLayout akd;
    private com.baidu.card.view.a ake;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;
    private int minHeight;

    public ar(Context context) {
        super(context);
        this.akb = ahy;
        this.akc = this.akb / 2;
        this.minHeight = this.akb / 3;
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.akd = new VideoImageNoPlayerLayout(context);
        c(true);
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.akd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahy = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.mFrom)) {
                this.akb = ahy - ahx;
            } else {
                this.akb = ahy;
            }
            this.akc = this.akb / 2;
            this.minHeight = this.akb / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ahi = aVar;
        if (this.ahi == null || this.ahi.boO() == null || this.ahi.boO().eVB == null || this.ahi.boO().eVB.ePW) {
            this.akd.setVisibility(8);
            return;
        }
        this.akd.setVisibility(0);
        this.akd.D(aVar);
        ViewGroup.LayoutParams layoutParams = this.akd.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.akd.anA.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.ahi.boO().eVB.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.ahi.boO().eVB.videoInfo;
            if (videoInfo != null) {
                int i3 = (this.akc / 9) * 16;
                int i4 = this.minHeight;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.akb;
                layoutParams2.width = this.akc;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    layoutParams2.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.b.a(layoutParams, layoutParams2, i, i2, z);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.b.a(layoutParams, layoutParams2, i, i2, z);
                } else {
                    int i5 = (int) (((1.0f * intValue2) / intValue) * this.akc);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    layoutParams2.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.b.a(layoutParams, layoutParams2, i, i2, z);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.b.a(layoutParams, layoutParams2, i, i2, z);
                }
            } else {
                return;
            }
        } else {
            layoutParams.width = this.akb;
            layoutParams2.width = this.akb;
            layoutParams.height = ((this.akb / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((this.akb / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.akd.setLayoutParams(layoutParams);
            this.akd.anA.setLayoutParams(layoutParams2);
        }
        this.akd.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.ahg != null) {
                    ar.this.ahg.a(ar.this.ahi);
                }
            }
        });
        this.akd.setData(this.ahi);
        if (tc() != null) {
        }
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.akd.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.akd.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a.InterfaceC0089a interfaceC0089a) {
        this.ahg = interfaceC0089a;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.ake = aVar;
        if (aVar != null) {
            tD();
        }
    }

    private void tD() {
        if (this.akd != null) {
            this.akd.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ar.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ar.this.ake != null) {
                        ar.this.ake.a(ar.this.ahi);
                    }
                }
            });
        }
    }
}
