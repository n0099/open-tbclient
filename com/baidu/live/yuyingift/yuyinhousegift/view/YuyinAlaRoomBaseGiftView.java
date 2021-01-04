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
/* loaded from: classes11.dex */
public abstract class YuyinAlaRoomBaseGiftView extends RelativeLayout {
    public c cae;
    protected int ccN;
    protected int[] ccO;
    protected boolean ccP;
    protected List<c> ccQ;
    protected int ccR;
    protected a ccS;
    private final int ccT;

    protected abstract void abC();

    protected abstract void abD();

    protected abstract void abE();

    public a getNowAnimal() {
        return this.ccS;
    }

    public YuyinAlaRoomBaseGiftView(Context context) {
        super(context);
        this.ccT = 10;
        init();
    }

    private void init() {
        this.ccO = new int[2];
        this.ccQ = new ArrayList();
    }

    public c getLastShowGift() {
        return this.cae;
    }

    private void a(c cVar, List<YuyinGiftItemView> list, boolean z) {
        if (cVar == null || ListUtils.isEmpty(list)) {
            this.ccP = false;
            abE();
            return;
        }
        this.cae = cVar;
        this.ccQ.clear();
        removeAllViews();
        for (YuyinGiftItemView yuyinGiftItemView : list) {
            yuyinGiftItemView.setAnimalCallback(new YuyinGiftItemView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView.1
                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void y(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        ArrayList arrayList = new ArrayList();
                        boolean z2 = false;
                        int i2 = 0;
                        for (int i3 = 0; i3 < YuyinAlaRoomBaseGiftView.this.getChildCount(); i3++) {
                            YuyinGiftItemView yuyinGiftItemView2 = (YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i3);
                            if (yuyinGiftItemView2.getWheatInfoData() != null) {
                                AlaWheatInfoData aY = d.aY(yuyinGiftItemView2.getWheatInfoData().uk, yuyinGiftItemView2.getWheatInfoData().userName);
                                if (aY != null) {
                                    yuyinGiftItemView2.setWheatInfoData(aY);
                                    if (aY.locationCenterX > 0.0f) {
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
                                    YuyinAlaRoomBaseGiftView.this.ccS = yuyinGiftItemView4.abG();
                                }
                                i++;
                            }
                        } else if (z2) {
                            while (i < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.ccS = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i)).abH();
                                i++;
                            }
                        } else {
                            YuyinAlaRoomBaseGiftView.this.removeAllViews();
                            YuyinAlaRoomBaseGiftView.this.ccQ.clear();
                            YuyinAlaRoomBaseGiftView.this.abA();
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void z(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.ccS = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).abH();
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
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        YuyinAlaRoomBaseGiftView.this.abD();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccQ)) {
                            YuyinAlaRoomBaseGiftView.this.abA();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.ccS = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).H(cVar2);
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
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        YuyinAlaRoomBaseGiftView.this.abD();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccQ)) {
                            YuyinAlaRoomBaseGiftView.this.abA();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.ccS = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).H(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void C(c cVar2) {
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        YuyinAlaRoomBaseGiftView.this.abD();
                        YuyinAlaRoomBaseGiftView.this.abA();
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void D(c cVar2) {
                    int i = 0;
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        YuyinAlaRoomBaseGiftView.this.abD();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccQ)) {
                            YuyinAlaRoomBaseGiftView.this.abA();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.ccS = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).J(cVar2);
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
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        YuyinAlaRoomBaseGiftView.this.abD();
                        if (!ListUtils.isEmpty(YuyinAlaRoomBaseGiftView.this.ccQ)) {
                            YuyinAlaRoomBaseGiftView.this.abA();
                            return;
                        }
                        while (true) {
                            int i2 = i;
                            if (i2 < YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                                YuyinAlaRoomBaseGiftView.this.ccS = ((YuyinGiftItemView) YuyinAlaRoomBaseGiftView.this.getChildAt(i2)).K(cVar2);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.a
                public void F(c cVar2) {
                    YuyinAlaRoomBaseGiftView.this.ccR++;
                    YuyinAlaRoomBaseGiftView.this.cae = cVar2;
                    if (YuyinAlaRoomBaseGiftView.this.ccR >= YuyinAlaRoomBaseGiftView.this.getChildCount()) {
                        YuyinAlaRoomBaseGiftView.this.ccR = 0;
                        YuyinAlaRoomBaseGiftView.this.abD();
                        YuyinAlaRoomBaseGiftView.this.abA();
                    }
                }
            });
            if (z) {
                this.ccS = yuyinGiftItemView.m(getStartLoc()[0], getStartLoc()[1]);
            } else {
                float[] a2 = a(yuyinGiftItemView);
                this.ccS = yuyinGiftItemView.b(this.cae, a2[0], a2[1]);
            }
            if (this.ccS != null) {
                this.ccS.cae = this.cae;
                addView(yuyinGiftItemView, 0, new RelativeLayout.LayoutParams(-2, -2));
            }
        }
        if (getChildCount() > 0) {
            abC();
            this.ccP = true;
            return;
        }
        this.ccP = false;
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
                AlaWheatInfoData aY = d.aY(wheatInfoData.uk, wheatInfoData.userName);
                if (aY != null) {
                    if (aY.locationCenterX > 0.0f) {
                        i++;
                    } else {
                        z = true;
                    }
                    yuyinGiftItemView.setWheatInfoData(aY);
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
            this.ccQ.clear();
            abA();
            return;
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            YuyinGiftItemView yuyinGiftItemView3 = (YuyinGiftItemView) getChildAt(i4);
            float[] a2 = a(yuyinGiftItemView3);
            if (cls == i.class) {
                this.ccS = yuyinGiftItemView3.a(this.cae, a2[0], a2[1]);
            } else if (cls == g.class) {
                this.ccS = yuyinGiftItemView3.b(this.cae, a2[0], a2[1]);
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
    public void abA() {
        if (ListUtils.isEmpty(this.ccQ)) {
            this.ccP = false;
            this.ccS = null;
            abE();
            return;
        }
        long j = 0;
        if (getChildCount() > 0) {
            j = ((YuyinGiftItemView) getChildAt(0)).getNowShowCount();
        }
        if (j >= 10 && this.ccQ.size() > 0) {
            c cVar = this.ccQ.get(0);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.ccQ.size()) {
                    break;
                }
                if (cVar != null && this.ccQ.get(i2) != null) {
                    cVar.beC += this.ccQ.get(i2).beC;
                }
                i = i2 + 1;
            }
            this.ccQ.clear();
            this.ccQ.add(cVar);
        }
        this.cae = this.ccQ.remove(0);
        if ((this.ccS instanceof com.baidu.live.yuyingift.yuyinhousegift.a.c) || (this.ccS instanceof e) || (this.ccS instanceof com.baidu.live.yuyingift.yuyinhousegift.a.d) || (this.ccS instanceof i) || (this.ccS instanceof g) || (this.ccS instanceof h)) {
            h(i.class);
        } else if ((this.ccS instanceof b) || (this.ccS instanceof f)) {
            h(g.class);
        } else {
            h(g.class);
        }
    }

    public void b(c cVar, List<YuyinGiftItemView> list, boolean z) {
        a(cVar, list, z);
    }

    public boolean abB() {
        return this.ccP;
    }

    protected int[] getStartLoc() {
        if (this.ccO[0] == 0) {
            this.ccO = BdUtilHelper.getScreenDimensions(getContext());
            int[] iArr = this.ccO;
            iArr[0] = iArr[0] / 2;
            int[] iArr2 = this.ccO;
            iArr2[1] = iArr2[1] - getGiftPanelHeight();
        }
        return this.ccO;
    }

    private int getGiftPanelHeight() {
        if (this.ccN <= 0) {
            this.ccN = getDataPagerHeight();
            this.ccN += getNobalHeight();
            this.ccN += getMicrophoneListHeight();
            this.ccN += getOffset();
        }
        return this.ccN;
    }

    public void q(c cVar) {
        this.ccQ.add(cVar);
        if (this.ccS == null) {
            abA();
        }
    }

    private int getOffset() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds266);
    }

    private int getMicrophoneListHeight() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds96);
    }

    private int getNobalHeight() {
        if (abF()) {
            return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
        }
        return 0;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private boolean abF() {
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return false;
        }
        return bqVar == null || bqVar.aRE == null || bqVar.aRE.aUn;
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
