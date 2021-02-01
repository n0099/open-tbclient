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
    private static final int agv = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
    private static int agw = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private com.baidu.tbadk.core.data.a agj;
    private int aiY;
    private int aiZ;
    private VideoImageNoPlayerLayout aja;
    private com.baidu.card.view.a ajb;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;
    private int minHeight;

    public ar(Context context) {
        super(context);
        this.aiY = agw;
        this.aiZ = this.aiY / 2;
        this.minHeight = this.aiY / 3;
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.aja = new VideoImageNoPlayerLayout(context);
        c(true);
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.aja;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            agw = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.mFrom)) {
                this.aiY = agw - agv;
            } else {
                this.aiY = agw;
            }
            this.aiZ = this.aiY / 2;
            this.minHeight = this.aiY / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agj = aVar;
        if (this.agj == null || this.agj.bln() == null || this.agj.bln().eTc == null || this.agj.bln().eTc.eNx) {
            this.aja.setVisibility(8);
            return;
        }
        this.aja.setVisibility(0);
        this.aja.C(aVar);
        ViewGroup.LayoutParams layoutParams = this.aja.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.aja.amz.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.agj.bln().eTc.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.agj.bln().eTc.videoInfo;
            if (videoInfo != null) {
                int i3 = (this.aiZ / 9) * 16;
                int i4 = this.minHeight;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.aiY;
                layoutParams2.width = this.aiZ;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * this.aiZ);
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
            layoutParams.width = this.aiY;
            layoutParams2.width = this.aiY;
            layoutParams.height = ((this.aiY / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((this.aiY / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.aja.setLayoutParams(layoutParams);
            this.aja.amz.setLayoutParams(layoutParams2);
        }
        this.aja.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.agh != null) {
                    ar.this.agh.a(ar.this.agj);
                }
            }
        });
        this.aja.setData(this.agj);
        if (sO() != null) {
        }
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.aja.setOnCardSubClickListener(abVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.aja.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agh = interfaceC0088a;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.ajb = aVar;
        if (aVar != null) {
            tp();
        }
    }

    private void tp() {
        if (this.aja != null) {
            this.aja.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ar.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ar.this.ajb != null) {
                        ar.this.ajb.a(ar.this.agj);
                    }
                }
            });
        }
    }
}
