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
/* loaded from: classes15.dex */
public class ar extends h {
    private AbsThreadDataSupport aeW;
    private VideoImageNoPlayerLayout ahE;
    private com.baidu.card.view.a ahF;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;
    private static final int ahz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ahA = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahB = ahA;
    private static int ahC = ahB / 2;
    private static int ahD = ahB / 3;

    public ar(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.ahE = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.ahE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahA = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahB = ahA;
            ahC = ahB / 2;
            ahD = ahB / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aeW = absThreadDataSupport;
        if (this.aeW == null || this.aeW.bce() == null || this.aeW.bce().edE == null || this.aeW.bce().edE.dYh) {
            this.ahE.setVisibility(8);
            return;
        }
        this.ahE.setVisibility(0);
        this.ahE.F(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.ahE.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.ahE.akV.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.aeW.bce().edE.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.aeW.bce().edE.videoInfo;
            if (videoInfo != null) {
                int i3 = (ahC / 9) * 16;
                int i4 = ahD;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = ahB;
                layoutParams2.width = ahC;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * ahC);
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
            layoutParams.width = ahB;
            layoutParams2.width = ahB;
            layoutParams.height = ((ahB / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((ahB / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.ahE.setLayoutParams(layoutParams);
            this.ahE.akV.setLayoutParams(layoutParams2);
        }
        this.ahE.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.aeU != null) {
                    ar.this.aeU.a(ar.this.aeW);
                }
            }
        });
        this.ahE.setData(this.aeW);
        if (tw() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.ahE.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ahE.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.aeU = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.ahF = aVar;
        if (aVar != null) {
            tV();
        }
    }

    private void tV() {
        if (this.ahE != null) {
            this.ahE.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ar.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (ar.this.ahF != null) {
                        ar.this.ahF.a(ar.this.aeW);
                    }
                }
            });
        }
    }
}
