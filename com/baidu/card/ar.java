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
    private static final int ahB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ahC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahD = ahC;
    private static int ahE = ahD / 2;
    private static int ahF = ahD / 3;
    private AbsThreadDataSupport aeY;
    private VideoImageNoPlayerLayout ahG;
    private com.baidu.card.view.a ahH;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public ar(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.ahG = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.ahG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahD = ahC;
            ahE = ahD / 2;
            ahF = ahD / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aeY = absThreadDataSupport;
        if (this.aeY == null || this.aeY.bce() == null || this.aeY.bce().edI == null || this.aeY.bce().edI.dYl) {
            this.ahG.setVisibility(8);
            return;
        }
        this.ahG.setVisibility(0);
        this.ahG.F(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.ahG.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.ahG.akX.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.aeY.bce().edI.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.aeY.bce().edI.videoInfo;
            if (videoInfo != null) {
                int i3 = (ahE / 9) * 16;
                int i4 = ahF;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = ahD;
                layoutParams2.width = ahE;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * ahE);
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
            layoutParams.width = ahD;
            layoutParams2.width = ahD;
            layoutParams.height = ((ahD / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((ahD / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.ahG.setLayoutParams(layoutParams);
            this.ahG.akX.setLayoutParams(layoutParams2);
        }
        this.ahG.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.aeW != null) {
                    ar.this.aeW.a(ar.this.aeY);
                }
            }
        });
        this.ahG.setData(this.aeY);
        if (tw() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.ahG.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ahG.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.aeW = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.ahH = aVar;
        if (aVar != null) {
            tV();
        }
    }

    private void tV() {
        if (this.ahG != null) {
            this.ahG.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ar.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (ar.this.ahH != null) {
                        ar.this.ahH.a(ar.this.aeY);
                    }
                }
            });
        }
    }
}
