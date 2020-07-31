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
public class aq extends h {
    private static final int agr = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ags = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agt = ags;
    private static int agu = agt / 2;
    private static int agv = agt / 3;
    private AbsThreadDataSupport adQ;
    private VideoImageNoPlayerLayout agw;
    private com.baidu.card.view.a agx;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public aq(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.agw = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ags = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            agt = ags;
            agu = agt / 2;
            agv = agt / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.adQ = absThreadDataSupport;
        if (this.adQ == null || this.adQ.aTN() == null || this.adQ.aTN().dUi == null || this.adQ.aTN().dUi.dOO) {
            this.agw.setVisibility(8);
            return;
        }
        this.agw.setVisibility(0);
        this.agw.D(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.agw.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.agw.ajG.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (this.adQ.aTN().dUi.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.adQ.aTN().dUi.videoInfo;
            if (videoInfo != null) {
                int i3 = (agu / 9) * 16;
                int i4 = agv;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = agt;
                layoutParams2.width = agu;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * agu);
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
            layoutParams.width = agt;
            layoutParams2.width = agt;
            layoutParams.height = ((agt / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((agt / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height && i == layoutParams.width) {
                z2 = false;
            }
        }
        if (z2) {
            this.agw.setLayoutParams(layoutParams);
            this.agw.ajG.setLayoutParams(layoutParams2);
        }
        this.agw.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.aq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aq.this.adO != null) {
                    aq.this.adO.a(aq.this.adQ);
                }
            }
        });
        this.agw.setData(this.adQ);
        if (rL() != null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.agw.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.agw.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.adO = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.agx = aVar;
        if (aVar != null) {
            sk();
        }
    }

    private void sk() {
        if (this.agw != null) {
            this.agw.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.aq.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (aq.this.agx != null) {
                        aq.this.agx.a(aq.this.adQ);
                    }
                }
            });
        }
    }
}
