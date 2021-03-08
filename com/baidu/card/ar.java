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
    private static final int ahN = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
    private static int ahO = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private com.baidu.tbadk.core.data.a ahB;
    private int akq;
    private int akr;
    private VideoImageNoPlayerLayout aks;
    private com.baidu.card.view.a akt;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;
    private int minHeight;

    public ar(Context context) {
        super(context);
        this.akq = ahO;
        this.akr = this.akq / 2;
        this.minHeight = this.akq / 3;
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.aks = new VideoImageNoPlayerLayout(context);
        c(true);
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.aks;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahO = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.mFrom)) {
                this.akq = ahO - ahN;
            } else {
                this.akq = ahO;
            }
            this.akr = this.akq / 2;
            this.minHeight = this.akq / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ahB = aVar;
        if (this.ahB == null || this.ahB.blp() == null || this.ahB.blp().eUD == null || this.ahB.blp().eUD.eOY) {
            this.aks.setVisibility(8);
            return;
        }
        this.aks.setVisibility(0);
        this.aks.E(aVar);
        ViewGroup.LayoutParams layoutParams = this.aks.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.aks.anR.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.ahB.blp().eUD.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.ahB.blp().eUD.videoInfo;
            if (videoInfo != null) {
                int i3 = (this.akr / 9) * 16;
                int i4 = this.minHeight;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.akq;
                layoutParams2.width = this.akr;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * this.akr);
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
            layoutParams.width = this.akq;
            layoutParams2.width = this.akq;
            layoutParams.height = ((this.akq / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((this.akq / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.aks.setLayoutParams(layoutParams);
            this.aks.anR.setLayoutParams(layoutParams2);
        }
        this.aks.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.ahz != null) {
                    ar.this.ahz.a(ar.this.ahB);
                }
            }
        });
        this.aks.setData(this.ahB);
        if (sO() != null) {
        }
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.aks.setOnCardSubClickListener(abVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.aks.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.ahz = interfaceC0094a;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.akt = aVar;
        if (aVar != null) {
            tp();
        }
    }

    private void tp() {
        if (this.aks != null) {
            this.aks.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ar.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ar.this.akt != null) {
                        ar.this.akt.a(ar.this.ahB);
                    }
                }
            });
        }
    }
}
