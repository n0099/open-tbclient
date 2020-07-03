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
/* loaded from: classes8.dex */
public class aq extends h {
    private static final int agA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int agB = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agC = agB;
    private static int agD = agC / 2;
    private static int agE = agC / 3;
    private AbsThreadDataSupport aea;
    private VideoImageNoPlayerLayout agF;
    private com.baidu.card.view.a agG;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public aq(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.agF = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            agB = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            agC = agB;
            agD = agC / 2;
            agE = agC / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aea = absThreadDataSupport;
        if (this.aea == null || this.aea.aPS() == null || this.aea.aPS().dNX == null || this.aea.aPS().dNX.dID) {
            this.agF.setVisibility(8);
            return;
        }
        this.agF.setVisibility(0);
        this.agF.D(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.agF.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.agF.ajL.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.aea.aPS().dNX.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.aea.aPS().dNX.videoInfo;
            if (videoInfo != null) {
                int i3 = (agD / 9) * 16;
                int i4 = agE;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = agC;
                layoutParams2.width = agD;
                boolean z2 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    layoutParams2.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                    }
                    z = z2;
                } else {
                    int i5 = (int) (((1.0f * intValue2) / intValue) * agD);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    layoutParams2.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                    }
                    z = z2;
                }
            } else {
                return;
            }
        } else {
            layoutParams.width = agC;
            layoutParams2.width = agC;
            layoutParams.height = ((agC / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((agC / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
        }
        if (z) {
            this.agF.setLayoutParams(layoutParams);
            this.agF.ajL.setLayoutParams(layoutParams2);
        }
        this.agF.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.aq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aq.this.adY != null) {
                    aq.this.adY.a(aq.this.aea);
                }
            }
        });
        this.agF.setData(this.aea);
        if (rJ() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.agF.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.agF.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.adY = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.agG = aVar;
        if (aVar != null) {
            si();
        }
    }

    private void si() {
        if (this.agF != null) {
            this.agF.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.aq.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (aq.this.agG != null) {
                        aq.this.agG.a(aq.this.aea);
                    }
                }
            });
        }
    }
}
