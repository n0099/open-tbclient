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
/* loaded from: classes21.dex */
public class as extends i {
    private static final int ain = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int aio = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int aip = aio;
    private static int aiq = aip / 2;
    private static int air = aip / 3;
    private AbsThreadDataSupport afH;
    private VideoImageNoPlayerLayout ais;
    private com.baidu.card.view.a ait;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.ais = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.ais;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            aio = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            aip = aio;
            aiq = aip / 2;
            air = aip / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.afH = absThreadDataSupport;
        if (this.afH == null || this.afH.bfG() == null || this.afH.bfG().erY == null || this.afH.bfG().erY.emx) {
            this.ais.setVisibility(8);
            return;
        }
        this.ais.setVisibility(0);
        this.ais.H(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.ais.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.ais.alP.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.afH.bfG().erY.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.afH.bfG().erY.videoInfo;
            if (videoInfo != null) {
                int i3 = (aiq / 9) * 16;
                int i4 = air;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = aip;
                layoutParams2.width = aiq;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * aiq);
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
            layoutParams.width = aip;
            layoutParams2.width = aip;
            layoutParams.height = ((aip / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((aip / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.ais.setLayoutParams(layoutParams);
            this.ais.alP.setLayoutParams(layoutParams2);
        }
        this.ais.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.as.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.afF != null) {
                    as.this.afF.a(as.this.afH);
                }
            }
        });
        this.ais.setData(this.afH);
        if (tB() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.ais.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ais.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.afF = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.ait = aVar;
        if (aVar != null) {
            ub();
        }
    }

    private void ub() {
        if (this.ais != null) {
            this.ais.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.as.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (as.this.ait != null) {
                        as.this.ait.a(as.this.afH);
                    }
                }
            });
        }
    }
}
