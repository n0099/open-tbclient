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
    private static final int aft = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int afu = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int afv = afu;
    private static int afw = afv / 2;
    private static int afx = afv / 3;
    private com.baidu.tbadk.core.data.a ade;
    private VideoImageNoPlayerLayout afy;
    private com.baidu.card.view.a afz;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public ak(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.afy = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afy;
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
    public void B(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            afu = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            afv = afu;
            afw = afv / 2;
            afx = afv / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ade = aVar;
        if (this.ade == null || this.ade.aIu() == null || this.ade.aIu().dtt == null || this.ade.aIu().dtt.doi) {
            this.afy.setVisibility(8);
            return;
        }
        this.afy.setVisibility(0);
        this.afy.B(aVar);
        ViewGroup.LayoutParams layoutParams = this.afy.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.afy.ahL.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
            layoutParams.width = afv;
            layoutParams.height = ((afv / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.width = afv;
            layoutParams2.height = ((afv / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
            if (z2) {
            }
            this.afy.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ak.this.adb != null) {
                        ak.this.adb.a(ak.this.ade);
                    }
                }
            });
            this.afy.setData(this.ade);
            if (rl() == null) {
            }
        }
        if (this.ade.aIu().dtt.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.ade.aIu().dtt.videoInfo;
            if (videoInfo != null) {
                int i3 = (afw / 9) * 16;
                int i4 = afx;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = afv;
                layoutParams2.width = afw;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * afw);
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
            layoutParams.width = afv;
            layoutParams2.width = afv;
            layoutParams.height = ((afv / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((afv / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
        }
        if (z2) {
            this.afy.setLayoutParams(layoutParams);
            this.afy.ahL.setLayoutParams(layoutParams2);
        }
        this.afy.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ak.this.adb != null) {
                    ak.this.adb.a(ak.this.ade);
                }
            }
        });
        this.afy.setData(this.ade);
        if (rl() == null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.afy.setOnCardSubClickListener(zVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.afy.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.adb = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.afz = aVar;
        if (aVar != null) {
            rH();
        }
    }

    private void rH() {
        if (this.afy != null) {
            this.afy.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ak.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ak.this.afz != null) {
                        ak.this.afz.a(ak.this.ade);
                    }
                }
            });
        }
    }
}
