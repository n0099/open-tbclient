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
    private static final int agG = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
    private static int agH = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private com.baidu.tbadk.core.data.a agr;
    private int ajk;
    private int ajl;
    private VideoImageNoPlayerLayout ajm;
    private com.baidu.card.view.a ajn;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;
    private int minHeight;

    public ar(Context context) {
        super(context);
        this.ajk = agH;
        this.ajl = this.ajk / 2;
        this.minHeight = this.ajk / 3;
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.ajm = new VideoImageNoPlayerLayout(context);
        c(true);
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.ajm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            agH = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.mFrom)) {
                this.ajk = agH - agG;
            } else {
                this.ajk = agH;
            }
            this.ajl = this.ajk / 2;
            this.minHeight = this.ajk / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agr = aVar;
        if (this.agr == null || this.agr.bkV() == null || this.agr.bkV().eQQ == null || this.agr.bkV().eQQ.eLl) {
            this.ajm.setVisibility(8);
            return;
        }
        this.ajm.setVisibility(0);
        this.ajm.C(aVar);
        ViewGroup.LayoutParams layoutParams = this.ajm.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.ajm.amJ.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.agr.bkV().eQQ.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.agr.bkV().eQQ.videoInfo;
            if (videoInfo != null) {
                int i3 = (this.ajl / 9) * 16;
                int i4 = this.minHeight;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.ajk;
                layoutParams2.width = this.ajl;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * this.ajl);
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
            layoutParams.width = this.ajk;
            layoutParams2.width = this.ajk;
            layoutParams.height = ((this.ajk / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((this.ajk / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.ajm.setLayoutParams(layoutParams);
            this.ajm.amJ.setLayoutParams(layoutParams2);
        }
        this.ajm.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.agp != null) {
                    ar.this.agp.a(ar.this.agr);
                }
            }
        });
        this.ajm.setData(this.agr);
        if (sR() != null) {
        }
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.ajm.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ajm.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agp = interfaceC0088a;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.ajn = aVar;
        if (aVar != null) {
            ts();
        }
    }

    private void ts() {
        if (this.ajm != null) {
            this.ajm.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ar.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ar.this.ajn != null) {
                        ar.this.ajn.a(ar.this.agr);
                    }
                }
            });
        }
    }
}
