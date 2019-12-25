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
/* loaded from: classes5.dex */
public class ak extends h {
    private static final int LX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int LY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int LZ = LY;
    private static int Ma = LZ / 2;
    private static int Mb = LZ / 3;
    private com.baidu.tbadk.core.data.a JB;
    private VideoImageNoPlayerLayout Mc;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public ak(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.Mc = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.Mc;
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
            LY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            LZ = LY;
            Ma = LZ / 2;
            Mb = LZ / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.JB = aVar;
        if (this.JB == null || this.JB.axx() == null || this.JB.axx().cPD == null || this.JB.axx().cPD.cKv) {
            this.Mc.setVisibility(8);
            return;
        }
        this.Mc.setVisibility(0);
        this.Mc.A(aVar);
        ViewGroup.LayoutParams layoutParams = this.Mc.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.Mc.Oz.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
            layoutParams.width = LZ;
            layoutParams.height = ((LZ / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.width = LZ;
            layoutParams2.height = ((LZ / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
            if (z2) {
            }
            this.Mc.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.this.Jz.a(ak.this.JB);
                }
            });
            this.Mc.setData(this.JB);
            if (mE() == null) {
            }
        }
        if (this.JB.axx().cPD.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.JB.axx().cPD.videoInfo;
            if (videoInfo != null) {
                int i3 = (Ma / 9) * 16;
                int i4 = Mb;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = LZ;
                layoutParams2.width = Ma;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * Ma);
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
            layoutParams.width = LZ;
            layoutParams2.width = LZ;
            layoutParams.height = ((LZ / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((LZ / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
        }
        if (z2) {
            this.Mc.setLayoutParams(layoutParams);
            this.Mc.Oz.setLayoutParams(layoutParams2);
        }
        this.Mc.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ak.this.Jz.a(ak.this.JB);
            }
        });
        this.Mc.setData(this.JB);
        if (mE() == null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.Mc.setOnCardSubClickListener(zVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.Mc.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.Jz = aVar;
    }
}
