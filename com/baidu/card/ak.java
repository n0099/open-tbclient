package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.b;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class ak extends h {
    private static final int MA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int MC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ME = MC;
    private static int MF = ME / 2;
    private static int MG = ME / 3;
    private com.baidu.tbadk.core.data.a Kc;
    private VideoImageNoPlayerLayout MH;
    private com.baidu.card.view.a MI;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public ak(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.MH = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.MH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bc, code lost:
        if (r4 == r5.width) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x017e, code lost:
        if (r4 == r5.width) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0180, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    @Override // com.baidu.card.m
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            MC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ME = MC;
            MF = ME / 2;
            MG = ME / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.Kc = aVar;
        if (this.Kc == null || this.Kc.aAg() == null || this.Kc.aAg().cTQ == null || this.Kc.aAg().cTQ.cOK) {
            this.MH.setVisibility(8);
            return;
        }
        this.MH.setVisibility(0);
        this.MH.A(aVar);
        ViewGroup.LayoutParams layoutParams = this.MH.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.MH.Pg.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
            layoutParams.width = ME;
            layoutParams.height = ((ME / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.width = ME;
            layoutParams2.height = ((ME / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
            if (z2) {
            }
            this.MH.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ak.this.Ka != null) {
                        ak.this.Ka.a(ak.this.Kc);
                    }
                }
            });
            this.MH.setData(this.Kc);
            if (mT() == null) {
            }
        }
        if (this.Kc.aAg().cTQ.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.Kc.aAg().cTQ.videoInfo;
            if (videoInfo != null) {
                int i3 = (MF / 9) * 16;
                int i4 = MG;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = ME;
                layoutParams2.width = MF;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    layoutParams2.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = z;
                    }
                    z = z3;
                    z2 = z;
                } else {
                    int i5 = (int) (((1.0f * intValue2) / intValue) * MF);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    layoutParams2.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = z;
                    }
                    z = z3;
                    z2 = z;
                }
            } else {
                return;
            }
        } else {
            layoutParams.width = ME;
            layoutParams2.width = ME;
            layoutParams.height = ((ME / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((ME / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
        }
        if (z2) {
            this.MH.setLayoutParams(layoutParams);
            this.MH.Pg.setLayoutParams(layoutParams2);
        }
        this.MH.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ak.this.Ka != null) {
                    ak.this.Ka.a(ak.this.Kc);
                }
            }
        });
        this.MH.setData(this.Kc);
        if (mT() == null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.MH.setOnCardSubClickListener(zVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.MH.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.Ka = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.MI = aVar;
        if (aVar != null) {
            no();
        }
    }

    private void no() {
        if (this.MH != null) {
            this.MH.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ak.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ak.this.MI != null) {
                        ak.this.MI.a(ak.this.Kc);
                    }
                }
            });
        }
    }
}
