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
/* loaded from: classes6.dex */
public class ak extends h {
    private static final int Mc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int Me = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int Mf = Me;
    private static int Mg = Mf / 2;
    private static int Mh = Mf / 3;
    private com.baidu.tbadk.core.data.a JH;
    private VideoImageNoPlayerLayout Mi;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public ak(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.Mi = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.Mi;
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
            Me = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            Mf = Me;
            Mg = Mf / 2;
            Mh = Mf / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.JH = aVar;
        if (this.JH == null || this.JH.axQ() == null || this.JH.axQ().cPN == null || this.JH.axQ().cPN.cKG) {
            this.Mi.setVisibility(8);
            return;
        }
        this.Mi.setVisibility(0);
        this.Mi.A(aVar);
        ViewGroup.LayoutParams layoutParams = this.Mi.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.Mi.OD.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
            layoutParams.width = Mf;
            layoutParams.height = ((Mf / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.width = Mf;
            layoutParams2.height = ((Mf / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
            if (z2) {
            }
            this.Mi.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.this.JF.a(ak.this.JH);
                }
            });
            this.Mi.setData(this.JH);
            if (mE() == null) {
            }
        }
        if (this.JH.axQ().cPN.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.JH.axQ().cPN.videoInfo;
            if (videoInfo != null) {
                int i3 = (Mg / 9) * 16;
                int i4 = Mh;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = Mf;
                layoutParams2.width = Mg;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * Mg);
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
            layoutParams.width = Mf;
            layoutParams2.width = Mf;
            layoutParams.height = ((Mf / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((Mf / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
        }
        if (z2) {
            this.Mi.setLayoutParams(layoutParams);
            this.Mi.OD.setLayoutParams(layoutParams2);
        }
        this.Mi.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ak.this.JF.a(ak.this.JH);
            }
        });
        this.Mi.setData(this.JH);
        if (mE() == null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.Mi.setOnCardSubClickListener(zVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.Mi.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.JF = aVar;
    }
}
