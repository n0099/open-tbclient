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
/* loaded from: classes21.dex */
public class as extends i {
    private static final int ajq;
    private static int ajr;
    private com.baidu.tbadk.core.data.a agJ;
    private int ajs;
    private int ajt;
    private VideoImageNoPlayerLayout aju;
    private com.baidu.card.view.a ajv;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;
    private int minHeight;

    static {
        ajq = com.baidu.tbadk.a.d.bkA() ? 0 : UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
        ajr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    public as(Context context) {
        super(context);
        this.ajs = ajr;
        this.ajt = this.ajs / 2;
        this.minHeight = this.ajs / 3;
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.aju = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aju;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ajr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.mFrom)) {
                this.ajs = ajr - ajq;
            } else {
                this.ajs = ajr;
            }
            this.ajt = this.ajs / 2;
            this.minHeight = this.ajs / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agJ = aVar;
        if (this.agJ == null || this.agJ.bmn() == null || this.agJ.bmn().eLH == null || this.agJ.bmn().eLH.eGg) {
            this.aju.setVisibility(8);
            return;
        }
        this.aju.setVisibility(0);
        this.aju.H(aVar);
        ViewGroup.LayoutParams layoutParams = this.aju.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.aju.amV.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.agJ.bmn().eLH.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.agJ.bmn().eLH.videoInfo;
            if (videoInfo != null) {
                int i3 = (this.ajt / 9) * 16;
                int i4 = this.minHeight;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.ajs;
                layoutParams2.width = this.ajt;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * this.ajt);
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
            layoutParams.width = this.ajs;
            layoutParams2.width = this.ajs;
            layoutParams.height = ((this.ajs / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((this.ajs / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.aju.setLayoutParams(layoutParams);
            this.aju.amV.setLayoutParams(layoutParams2);
        }
        this.aju.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.as.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.agH != null) {
                    as.this.agH.a(as.this.agJ);
                }
            }
        });
        this.aju.setData(this.agJ);
        if (tE() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.aju.setOnCardSubClickListener(abVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.aju.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.agH = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.ajv = aVar;
        if (aVar != null) {
            ue();
        }
    }

    private void ue() {
        if (this.aju != null) {
            this.aju.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.as.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (as.this.ajv != null) {
                        as.this.ajv.a(as.this.agJ);
                    }
                }
            });
        }
    }
}
