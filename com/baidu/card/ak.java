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
    private static final int afq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int afr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int afs = afr;
    private static int aft = afs / 2;
    private static int afu = afs / 3;
    private com.baidu.tbadk.core.data.a ada;
    private VideoImageNoPlayerLayout afv;
    private com.baidu.card.view.a afw;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public ak(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.afv = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afv;
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
            afr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            afs = afr;
            aft = afs / 2;
            afu = afs / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ada = aVar;
        if (this.ada == null || this.ada.aIw() == null || this.ada.aIw().dto == null || this.ada.aIw().dto.doe) {
            this.afv.setVisibility(8);
            return;
        }
        this.afv.setVisibility(0);
        this.afv.A(aVar);
        ViewGroup.LayoutParams layoutParams = this.afv.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.afv.ahI.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
            layoutParams.width = afs;
            layoutParams.height = ((afs / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.width = afs;
            layoutParams2.height = ((afs / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
            if (z2) {
            }
            this.afv.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ak.this.acY != null) {
                        ak.this.acY.a(ak.this.ada);
                    }
                }
            });
            this.afv.setData(this.ada);
            if (rl() == null) {
            }
        }
        if (this.ada.aIw().dto.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.ada.aIw().dto.videoInfo;
            if (videoInfo != null) {
                int i3 = (aft / 9) * 16;
                int i4 = afu;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = afs;
                layoutParams2.width = aft;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * aft);
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
            layoutParams.width = afs;
            layoutParams2.width = afs;
            layoutParams.height = ((afs / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((afs / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
        }
        if (z2) {
            this.afv.setLayoutParams(layoutParams);
            this.afv.ahI.setLayoutParams(layoutParams2);
        }
        this.afv.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ak.this.acY != null) {
                    ak.this.acY.a(ak.this.ada);
                }
            }
        });
        this.afv.setData(this.ada);
        if (rl() == null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.afv.setOnCardSubClickListener(zVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.afv.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.acY = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.afw = aVar;
        if (aVar != null) {
            rH();
        }
    }

    private void rH() {
        if (this.afv != null) {
            this.afv.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.ak.2
                @Override // com.baidu.card.view.a
                public void a(com.baidu.tbadk.core.data.a aVar) {
                    if (ak.this.afw != null) {
                        ak.this.afw.a(ak.this.ada);
                    }
                }
            });
        }
    }
}
