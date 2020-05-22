package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.b;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class al extends h {
    private static final int afP = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int afQ = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int afR = afQ;
    private static int afS = afR / 2;
    private static int afT = afR / 3;
    private AbsThreadDataSupport adw;
    private VideoImageNoPlayerLayout afU;
    private com.baidu.card.view.a afV;
    private Context mContext;
    private String mFrom;
    private int mLastScreenWidth;
    private int mSkinType;

    public al(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mSkinType = 3;
        this.mContext = context;
        this.afU = new VideoImageNoPlayerLayout(context);
        b((Boolean) true);
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afU;
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
    @Override // com.baidu.card.n
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            afQ = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            afR = afQ;
            afS = afR / 2;
            afT = afR / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.adw = absThreadDataSupport;
        if (this.adw == null || this.adw.aOi() == null || this.adw.aOi().dHm == null || this.adw.aOi().dHm.dCi) {
            this.afU.setVisibility(8);
            return;
        }
        this.afU.setVisibility(0);
        this.afU.D(absThreadDataSupport);
        ViewGroup.LayoutParams layoutParams = this.afU.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.afU.aip.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
            layoutParams.width = afR;
            layoutParams.height = ((afR / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.width = afR;
            layoutParams2.height = ((afR / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
            if (z2) {
            }
            this.afU.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.al.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (al.this.adu != null) {
                        al.this.adu.a(al.this.adw);
                    }
                }
            });
            this.afU.setData(this.adw);
            if (rs() == null) {
            }
        }
        if (this.adw.aOi().dHm.videoInfo.is_vertical.intValue() == 1) {
            VideoInfo videoInfo = this.adw.aOi().dHm.videoInfo;
            if (videoInfo != null) {
                int i3 = (afS / 9) * 16;
                int i4 = afT;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = afR;
                layoutParams2.width = afS;
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
                    int i5 = (int) (((1.0f * intValue2) / intValue) * afS);
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
            layoutParams.width = afR;
            layoutParams2.width = afR;
            layoutParams.height = ((afR / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            layoutParams2.height = ((afR / 16) * 9) - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
            if (i2 == layoutParams.height) {
            }
        }
        if (z2) {
            this.afU.setLayoutParams(layoutParams);
            this.afU.aip.setLayoutParams(layoutParams2);
        }
        this.afU.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.al.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.adu != null) {
                    al.this.adu.a(al.this.adw);
                }
            }
        });
        this.afU.setData(this.adw);
        if (rs() == null) {
        }
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.afU.setOnCardSubClickListener(aaVar);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.afU.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(b.a aVar) {
        this.adu = aVar;
    }

    public void setVideoAreaClickListener(com.baidu.card.view.a aVar) {
        this.afV = aVar;
        if (aVar != null) {
            rQ();
        }
    }

    private void rQ() {
        if (this.afU != null) {
            this.afU.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.card.al.2
                @Override // com.baidu.card.view.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (al.this.afV != null) {
                        al.this.afV.a(al.this.adw);
                    }
                }
            });
        }
    }
}
