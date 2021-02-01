package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.bv;
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
/* loaded from: classes11.dex */
public abstract class YuyinAlaRoomBaseGiftView extends RelativeLayout {
    public c bZu;
    protected int ccc;
    protected int[] ccd;
    protected boolean cce;
    protected List<c> ccf;
    protected int ccg;
    protected a cch;
    private final int cci;

    protected abstract void ZA();

    protected abstract void ZB();

    protected abstract void ZC();

    public a getNowAnimal() {
        return this.cch;
    }

    public YuyinAlaRoomBaseGiftView(Context context) {
        super(context);
        this.cci = 10;
        init();
    }

    private void init() {
        this.ccd = new int[2];
        this.ccf = new ArrayList();
    }

    public c getLastShowGift() {
        return this.bZu;
    }

    private void a(c cVar, List<YuyinGiftItemView> list, boolean z) {
        if (cVar == null || ListUtils.isEmpty(list)) {
            this.cce = false;
            ZC();
            return;
        }
        this.bZu = cVar;
        this.ccf.clear();
        removeAllViews();
        for (YuyinGiftItemView yuyinGiftItemView : list) {
            yuyinGiftItemView.setAnimalCallback(new YuyinGiftItemView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView.1
                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void y(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        ArrayList arrayList = new ArrayList();
                        boolean z2 = false;
                        int i2 = 0;
                        for (int i3 = 0; i3 < YuyinAlaRoomBaseGiftView.this.getChildCount(); i3++) {
                            YuyinGiftItemView yuyinGiftItemView2 = (YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i3);
                            if (yuyinGiftItemView2.getWheatInfoData() != null) {
                                AlaWheatInfoData aW = d.aW(yuyinGiftItemView2.getWheatInfoData().uk, yuyinGiftItemView2.getWheatInfoData().userName);
                                if (aW != null) {
                                    yuyinGiftItemView2.setWheatInfoData(aW);
                                    if (aW.locationCenterX > 0.0f) {
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
                        YuyinAlaRoomBaseGiftView.this.au(arrayList);
                        if (i2 > 0) {
                            while (i < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinGiftItemView yuyinGiftItemView4 = (YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i);
                                if (yuyinGiftItemView4.getWheatInfoData() != null && yuyinGiftItemView4.getWheatInfoData().locationCenterX > 0.0f) {
                                    YuyinAlaRoomBaseGiftView.this.cch = yuyinGiftItemView4.ZE();
                                }
                                i++;
                            }
                        } else if (z2) {
                            while (i < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.cch = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i)).ZF();
                                i++;
                            }
                        } else {
                            YuyinAlaRoomBaseGiftView.this.removeAllViews();
                            YuyinAlaRoomBaseGiftView.this.ccf.clear();
                            YuyinAlaRoomBaseGiftView.this.Zy();
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void z(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.cch = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).ZF();
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
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        YuyinAlaRoomBaseGiftView.this.ZB();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccf)) {
                            YuyinAlaRoomBaseGiftView.this.Zy();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.cch = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).H(cVar2);
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
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        YuyinAlaRoomBaseGiftView.this.ZB();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccf)) {
                            YuyinAlaRoomBaseGiftView.this.Zy();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.cch = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).H(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void C(c cVar2) {
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        YuyinAlaRoomBaseGiftView.this.ZB();
                        YuyinAlaRoomBaseGiftView.this.Zy();
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void D(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        YuyinAlaRoomBaseGiftView.this.ZB();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccf)) {
                            YuyinAlaRoomBaseGiftView.this.Zy();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.cch = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).J(cVar2);
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
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        YuyinAlaRoomBaseGiftView.this.ZB();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccf)) {
                            YuyinAlaRoomBaseGiftView.this.Zy();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.cch = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).K(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void F(c cVar2) {
                    YuyinAlaRoomBaseGiftView.this.ccg++;
                    YuyinAlaRoomBaseGiftView.this.bZu = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccg >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccg = 0;
                        YuyinAlaRoomBaseGiftView.this.ZB();
                        YuyinAlaRoomBaseGiftView.this.Zy();
                    }
                }
            });
            if (z) {
                this.cch = yuyinGiftItemView.n(getStartLoc()[0], getStartLoc()[1]);
            } else {
                float[] a2 = a(yuyinGiftItemView);
                this.cch = yuyinGiftItemView.b(this.bZu, a2[0], a2[1]);
            }
            if (this.cch != null) {
                this.cch.bZu = this.bZu;
                addView(yuyinGiftItemView, 0, new RelativeLayout.LayoutParams(-2, -2));
            }
        }
        if (getChildCount() > 0) {
            ZA();
            this.cce = true;
            return;
        }
        this.cce = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(List<View> list) {
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
                AlaWheatInfoData aW = d.aW(wheatInfoData.uk, wheatInfoData.userName);
                if (aW != null) {
                    if (aW.locationCenterX > 0.0f) {
                        i++;
                    } else {
                        z = true;
                    }
                    yuyinGiftItemView.setWheatInfoData(aW);
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
        au(arrayList);
        if (i == 0 && !z) {
            removeAllViews();
            this.ccf.clear();
            Zy();
            return;
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            YuyinGiftItemView yuyinGiftItemView3 = (YuyinGiftItemView) getChildAt(i4);
            float[] a2 = a(yuyinGiftItemView3);
            if (cls == i.class) {
                this.cch = yuyinGiftItemView3.a(this.bZu, a2[0], a2[1]);
            } else if (cls == g.class) {
                this.cch = yuyinGiftItemView3.b(this.bZu, a2[0], a2[1]);
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
    public void Zy() {
        if (ListUtils.isEmpty(this.ccf)) {
            this.cce = false;
            this.cch = null;
            ZC();
            return;
        }
        long j = 0;
        if (getChildCount() > 0) {
            j = ((YuyinGiftItemView) getChildAt(0)).getNowShowCount();
        }
        if (j >= 10 && this.ccf.size() > 0) {
            c cVar = this.ccf.get(0);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.ccf.size()) {
                    break;
                }
                if (cVar != null && this.ccf.get(i2) != null) {
                    cVar.bcT += this.ccf.get(i2).bcT;
                }
                i = i2 + 1;
            }
            this.ccf.clear();
            this.ccf.add(cVar);
        }
        this.bZu = this.ccf.remove(0);
        if ((this.cch instanceof com.baidu.live.yuyingift.yuyinhousegift.a.c) || (this.cch instanceof e) || (this.cch instanceof com.baidu.live.yuyingift.yuyinhousegift.a.d) || (this.cch instanceof i) || (this.cch instanceof g) || (this.cch instanceof h)) {
            h(i.class);
        } else if ((this.cch instanceof b) || (this.cch instanceof f)) {
            h(g.class);
        } else {
            h(g.class);
        }
    }

    public void b(c cVar, List<YuyinGiftItemView> list, boolean z) {
        a(cVar, list, z);
    }

    public boolean Zz() {
        return this.cce;
    }

    protected int[] getStartLoc() {
        if (this.ccd[0] == 0) {
            this.ccd = BdUtilHelper.getScreenDimensions(getContext());
            int[] iArr = this.ccd;
            iArr[0] = iArr[0] / 2;
            int[] iArr2 = this.ccd;
            iArr2[1] = iArr2[1] - getGiftPanelHeight();
        }
        return this.ccd;
    }

    private int getGiftPanelHeight() {
        if (this.ccc <= 0) {
            this.ccc = getDataPagerHeight();
            this.ccc += getNobalHeight();
            this.ccc += getMicrophoneListHeight();
            this.ccc += getOffset();
        }
        return this.ccc;
    }

    public void q(c cVar) {
        this.ccf.add(cVar);
        if (this.cch == null) {
            Zy();
        }
    }

    private int getOffset() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds266);
    }

    private int getMicrophoneListHeight() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds96);
    }

    private int getNobalHeight() {
        if (ZD()) {
            return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
        }
        return 0;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private boolean ZD() {
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return false;
        }
        return bvVar == null || bvVar.aPP == null || bvVar.aPP.aSC;
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
