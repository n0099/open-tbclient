package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.b;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import tbclient.VideoInfo;
/* loaded from: classes20.dex */
public class as extends i {
    private static final int air;
    private static int ais;
    private com.baidu.tbadk.core.data.a afN;
    private int ait;
    private int aiu;
    private VideoImageNoPlayerLayout aiv;
    private com.baidu.card.view.a aiw;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;
    private int minHeight;

    static {
        air = com.baidu.tbadk.a.d.bhw() ? 0 : UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
        ais = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    public as(Context context) {
        super(context);
        this.ait = ais;
        this.aiu = this.ait / 2;
        this.minHeight = this.ait / 3;
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.aiv = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aiv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ais = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.mFrom)) {
                this.ait = ais - air;
            } else {
                this.ait = ais;
            }
            this.aiu = this.ait / 2;
            this.minHeight = this.ait / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.afN = aVar;
        if (this.afN == null || this.afN.bjd() == null || this.afN.bjd().eEF == null || this.afN.bjd().eEF.ezh) {
            this.aiv.setVisibility(8);
            return;
        }
        this.aiv.setVisibility(0);
        this.aiv.H(aVar);
        ViewGroup.LayoutParams layoutParams = this.aiv.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.aiv.alW.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.afN.bjd().eEF.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.afN.bjd().eEF.videoInfo;
            if (videoInfo != null) {
                int i3 = (this.aiu / 9) * 16;
                int i4 = this.minHeight;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.ait;
                layoutParams2.width = this.aiu;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * this.aiu);
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
            layoutParams.width = this.ait;
            layoutParams2.width = this.ait;
            layoutParams.height = ((this.ait / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((this.ait / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.aiv.setLayoutParams(layoutParams);
            this.aiv.alW.setLayoutParams(layoutParams2);
        }
        this.aiv.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.as.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.afL != null) {
                    as.this.afL.a(as.this.afN);
                }
            }
        });
        this.aiv.setData(this.afN);
        if (tB() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.aiv.setOnCardSubClickListener(abVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.aiv.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.afL = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.aiw = aVar;
        if (aVar != null) {
            ub();
        }
    }

    private void ub() {
        if (this.aiv != null) {
            this.aiv.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.as.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (as.this.aiw != null) {
                        as.this.aiw.a(as.this.afN);
                    }
                }
            });
        }
    }
}
