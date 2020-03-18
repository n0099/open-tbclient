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
    private static final int MC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ME = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int MF = ME;
    private static int MG = MF / 2;
    private static int MH = MF / 3;
    private com.baidu.tbadk.core.data.a Kc;
    private VideoImageNoPlayerLayout MI;
    private com.baidu.card.view.a MJ;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public ak(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.MI = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.MI;
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
            ME = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            MF = ME;
            MG = MF / 2;
            MH = MF / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.Kc = aVar;
        if (this.Kc == null || this.Kc.aAj() == null || this.Kc.aAj().cUe == null || this.Kc.aAj().cUe.cOY) {
            this.MI.setVisibility(8);
            return;
        }
        this.MI.setVisibility(0);
        this.MI.A(aVar);
        ViewGroup.LayoutParams layoutParams = this.MI.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.MI.Ph.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
            layoutParams.width = MF;
            layoutParams.height = ((MF / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.width = MF;
            layoutParams2.height = ((MF / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
            if (z2) {
            }
            this.MI.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ak.this.Ka != null) {
                        ak.this.Ka.a(ak.this.Kc);
                    }
                }
            });
            this.MI.setData(this.Kc);
            if (mT() == null) {
            }
        }
        if (this.Kc.aAj().cUe.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.Kc.aAj().cUe.videoInfo;
            if (videoInfo != null) {
                int i3 = (MG / 9) * 16;
                int i4 = MH;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = MF;
                layoutParams2.width = MG;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * MG);
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
            layoutParams.width = MF;
            layoutParams2.width = MF;
            layoutParams.height = ((MF / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((MF / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
        }
        if (z2) {
            this.MI.setLayoutParams(layoutParams);
            this.MI.Ph.setLayoutParams(layoutParams2);
        }
        this.MI.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ak.this.Ka != null) {
                    ak.this.Ka.a(ak.this.Kc);
                }
            }
        });
        this.MI.setData(this.Kc);
        if (mT() == null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.MI.setOnCardSubClickListener(zVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.MI.onChangeSkinType(tbPageContext, i);
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
        this.MJ = aVar;
        if (aVar != null) {
            no();
        }
    }

    private void no() {
        if (this.MI != null) {
            this.MI.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ak.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ak.this.MJ != null) {
                        ak.this.MJ.a(ak.this.Kc);
                    }
                }
            });
        }
    }
}
