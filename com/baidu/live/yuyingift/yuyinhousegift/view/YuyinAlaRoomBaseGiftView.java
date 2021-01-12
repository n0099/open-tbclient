package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.bq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.yuyinhousegift.a.a;
import com.baidu.live.yuyingift.yuyinhousegift.a.b;
import com.baidu.live.yuyingift.yuyinhousegift.a.e;
import com.baidu.live.yuyingift.yuyinhousegift.a.f;
import com.baidu.live.yuyingift.yuyinhousegift.a.g;
import com.baidu.live.yuyingift.yuyinhousegift.a.h;
import com.baidu.live.yuyingift.yuyinhousegift.a.i;
import com.baidu.live.yuyingift.yuyinhousegift.d;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class YuyinAlaRoomBaseGiftView extends RelativeLayout {
    public c bVs;
    protected int bXZ;
    protected int[] bYa;
    protected boolean bYb;
    protected List<c> bYc;
    protected int bYd;
    protected a bYe;
    private final int bYf;

    protected abstract void XK();

    protected abstract void XL();

    protected abstract void XM();

    public a getNowAnimal() {
        return this.bYe;
    }

    public YuyinAlaRoomBaseGiftView(Context context) {
        super(context);
        this.bYf = 10;
        init();
    }

    private void init() {
        this.bYa = new int[2];
        this.bYc = new ArrayList();
    }

    public c getLastShowGift() {
        return this.bVs;
    }

    private void a(c cVar, List<YuyinGiftItemView> list, boolean z) {
        if (cVar == null || ListUtils.isEmpty(list)) {
            this.bYb = false;
            XM();
            return;
        }
        this.bVs = cVar;
        this.bYc.clear();
        removeAllViews();
        for (YuyinGiftItemView yuyinGiftItemView : list) {
            yuyinGiftItemView.setAnimalCallback(new YuyinGiftItemView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView.1
                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void y(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        ArrayList arrayList = new ArrayList();
                        boolean z2 = false;
                        int i2 = 0;
                        for (int i3 = 0; i3 < YuyinAlaRoomBaseGiftView.this.getChildCount(); i3++) {
                            YuyinGiftItemView yuyinGiftItemView2 = (YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i3);
                            if (yuyinGiftItemView2.getWheatInfoData() != null) {
                                AlaWheatInfoData aX = d.aX(yuyinGiftItemView2.getWheatInfoData().uk, yuyinGiftItemView2.getWheatInfoData().userName);
                                if (aX != null) {
                                    yuyinGiftItemView2.setWheatInfoData(aX);
                                    if (aX.locationCenterX > 0.0f) {
                                        i2++;
                                    } else {
                                        z2 = true;
                                    }
                                } else {
                                    arrayList.add(yuyinGiftItemView2);
                                }
                            } else {
                                arrayList.add(yuyinGiftItemView2);
                            }
                        }
                        if (i2 > 0) {
                            for (int i4 = 0; i4 < YuyinAlaRoomBaseGiftView.this.getChildCount(); i4++) {
                                YuyinGiftItemView yuyinGiftItemView3 = (YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i4);
                                if (yuyinGiftItemView3.getWheatInfoData().locationCenterX == 0.0f) {
                                    arrayList.add(yuyinGiftItemView3);
                                }
                            }
                        }
                        YuyinAlaRoomBaseGiftView.this.at(arrayList);
                        if (i2 > 0) {
                            while (i < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinGiftItemView yuyinGiftItemView4 = (YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i);
                                if (yuyinGiftItemView4.getWheatInfoData() != null && yuyinGiftItemView4.getWheatInfoData().locationCenterX > 0.0f) {
                                    YuyinAlaRoomBaseGiftView.this.bYe = yuyinGiftItemView4.XO();
                                }
                                i++;
                            }
                        } else if (z2) {
                            while (i < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.bYe = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i)).XP();
                                i++;
                            }
                        } else {
                            YuyinAlaRoomBaseGiftView.this.removeAllViews();
                            YuyinAlaRoomBaseGiftView.this.bYc.clear();
                            YuyinAlaRoomBaseGiftView.this.XI();
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void z(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.bYe = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).XP();
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void A(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        YuyinAlaRoomBaseGiftView.this.XL();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.bYc)) {
                            YuyinAlaRoomBaseGiftView.this.XI();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.bYe = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).H(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void B(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        YuyinAlaRoomBaseGiftView.this.XL();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.bYc)) {
                            YuyinAlaRoomBaseGiftView.this.XI();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.bYe = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).H(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void C(c cVar2) {
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        YuyinAlaRoomBaseGiftView.this.XL();
                        YuyinAlaRoomBaseGiftView.this.XI();
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void D(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        YuyinAlaRoomBaseGiftView.this.XL();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.bYc)) {
                            YuyinAlaRoomBaseGiftView.this.XI();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.bYe = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).J(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void E(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        YuyinAlaRoomBaseGiftView.this.XL();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.bYc)) {
                            YuyinAlaRoomBaseGiftView.this.XI();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.bYe = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).K(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void F(c cVar2) {
                    YuyinAlaRoomBaseGiftView.this.bYd++;
                    YuyinAlaRoomBaseGiftView.this.bVs = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.bYd >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.bYd = 0;
                        YuyinAlaRoomBaseGiftView.this.XL();
                        YuyinAlaRoomBaseGiftView.this.XI();
                    }
                }
            });
            if (z) {
                this.bYe = yuyinGiftItemView.n(getStartLoc()[0], getStartLoc()[1]);
            } else {
                float[] a2 = a(yuyinGiftItemView);
                this.bYe = yuyinGiftItemView.b(this.bVs, a2[0], a2[1]);
            }
            if (this.bYe != null) {
                this.bYe.bVs = this.bVs;
                addView(yuyinGiftItemView, 0, new RelativeLayout.LayoutParams(-2, -2));
            }
        }
        if (getChildCount() > 0) {
            XK();
            this.bYb = true;
            return;
        }
        this.bYb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(List<View> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    removeView(list.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void h(Class<? extends a> cls) {
        List<View> arrayList = new ArrayList<>();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            YuyinGiftItemView yuyinGiftItemView = (YuyinGiftItemView) getChildAt(i2);
            AlaWheatInfoData wheatInfoData = yuyinGiftItemView.getWheatInfoData();
            if (wheatInfoData != null) {
                AlaWheatInfoData aX = d.aX(wheatInfoData.uk, wheatInfoData.userName);
                if (aX != null) {
                    if (aX.locationCenterX > 0.0f) {
                        i++;
                    } else {
                        z = true;
                    }
                    yuyinGiftItemView.setWheatInfoData(aX);
                } else {
                    arrayList.add(getChildAt(i2));
                }
            }
        }
        if (i > 0) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                YuyinGiftItemView yuyinGiftItemView2 = (YuyinGiftItemView) getChildAt(i3);
                if (yuyinGiftItemView2.getWheatInfoData().locationCenterX == 0.0f) {
                    arrayList.add(yuyinGiftItemView2);
                }
            }
        }
        at(arrayList);
        if (i == 0 && !z) {
            removeAllViews();
            this.bYc.clear();
            XI();
            return;
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            YuyinGiftItemView yuyinGiftItemView3 = (YuyinGiftItemView) getChildAt(i4);
            float[] a2 = a(yuyinGiftItemView3);
            if (cls == i.class) {
                this.bYe = yuyinGiftItemView3.a(this.bVs, a2[0], a2[1]);
            } else if (cls == g.class) {
                this.bYe = yuyinGiftItemView3.b(this.bVs, a2[0], a2[1]);
            }
        }
    }

    private float[] a(YuyinGiftItemView yuyinGiftItemView) {
        if (yuyinGiftItemView == null || yuyinGiftItemView.getWheatInfoData() == null) {
            return new float[]{0.0f, 0.0f};
        }
        return yuyinGiftItemView.getWheatInfoData().locationCenterX == 0.0f ? new float[]{getStartLoc()[0], getStartLoc()[1]} : new float[]{yuyinGiftItemView.getWheatInfoData().locationCenterX, yuyinGiftItemView.getWheatInfoData().locationCenterY};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XI() {
        if (ListUtils.isEmpty(this.bYc)) {
            this.bYb = false;
            this.bYe = null;
            XM();
            return;
        }
        long j = 0;
        if (getChildCount() > 0) {
            j = ((YuyinGiftItemView) getChildAt(0)).getNowShowCount();
        }
        if (j >= 10 && this.bYc.size() > 0) {
            c cVar = this.bYc.get(0);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.bYc.size()) {
                    break;
                }
                if (cVar != null && this.bYc.get(i2) != null) {
                    cVar.aZM += this.bYc.get(i2).aZM;
                }
                i = i2 + 1;
            }
            this.bYc.clear();
            this.bYc.add(cVar);
        }
        this.bVs = this.bYc.remove(0);
        if ((this.bYe instanceof com.baidu.live.yuyingift.yuyinhousegift.a.c) || (this.bYe instanceof e) || (this.bYe instanceof com.baidu.live.yuyingift.yuyinhousegift.a.d) || (this.bYe instanceof i) || (this.bYe instanceof g) || (this.bYe instanceof h)) {
            h(i.class);
        } else if ((this.bYe instanceof b) || (this.bYe instanceof f)) {
            h(g.class);
        } else {
            h(g.class);
        }
    }

    public void b(c cVar, List<YuyinGiftItemView> list, boolean z) {
        a(cVar, list, z);
    }

    public boolean XJ() {
        return this.bYb;
    }

    protected int[] getStartLoc() {
        if (this.bYa[0] == 0) {
            this.bYa = BdUtilHelper.getScreenDimensions(getContext());
            int[] iArr = this.bYa;
            iArr[0] = iArr[0] / 2;
            int[] iArr2 = this.bYa;
            iArr2[1] = iArr2[1] - getGiftPanelHeight();
        }
        return this.bYa;
    }

    private int getGiftPanelHeight() {
        if (this.bXZ <= 0) {
            this.bXZ = getDataPagerHeight();
            this.bXZ += getNobalHeight();
            this.bXZ += getMicrophoneListHeight();
            this.bXZ += getOffset();
        }
        return this.bXZ;
    }

    public void q(c cVar) {
        this.bYc.add(cVar);
        if (this.bYe == null) {
            XI();
        }
    }

    private int getOffset() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds266);
    }

    private int getMicrophoneListHeight() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds96);
    }

    private int getNobalHeight() {
        if (XN()) {
            return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
        }
        return 0;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private boolean XN() {
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return false;
        }
        return bqVar == null || bqVar.aMR == null || bqVar.aMR.aPA;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((YuyinGiftItemView) getChildAt(i)).cancel();
        }
        removeAllViews();
    }

    public void onDestory() {
        onDetachedFromWindow();
    }
}
