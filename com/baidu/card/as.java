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
    private static final int aio = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int aiq = aip;
    private static int air = aiq / 2;
    private static int ais = aiq / 3;
    private AbsThreadDataSupport afI;
    private VideoImageNoPlayerLayout ait;
    private com.baidu.card.view.a aiu;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.ait = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.ait;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            aiq = aip;
            air = aiq / 2;
            ais = aiq / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.afI = absThreadDataSupport;
        if (this.afI == null || this.afI.bjZ() == null || this.afI.bjZ().eGn == null || this.afI.bjZ().eGn.eAQ) {
            this.ait.setVisibility(8);
            return;
        }
        this.ait.setVisibility(0);
        this.ait.H(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.ait.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.ait.alQ.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.afI.bjZ().eGn.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.afI.bjZ().eGn.videoInfo;
            if (videoInfo != null) {
                int i3 = (air / 9) * 16;
                int i4 = ais;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = aiq;
                layoutParams2.width = air;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * air);
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
            layoutParams.width = aiq;
            layoutParams2.width = aiq;
            layoutParams.height = ((aiq / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((aiq / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.ait.setLayoutParams(layoutParams);
            this.ait.alQ.setLayoutParams(layoutParams2);
        }
        this.ait.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.as.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.afG != null) {
                    as.this.afG.a(as.this.afI);
                }
            }
        });
        this.ait.setData(this.afI);
        if (tB() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<AbsThreadDataSupport> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.ait.setOnCardSubClickListener(abVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ait.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.afG = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.aiu = aVar;
        if (aVar != null) {
            ub();
        }
    }

    private void ub() {
        if (this.ait != null) {
            this.ait.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.as.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (as.this.aiu != null) {
                        as.this.aiu.a(as.this.afI);
                    }
                }
            });
        }
    }
}
