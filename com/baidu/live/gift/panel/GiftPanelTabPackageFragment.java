package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ap;
import com.baidu.live.data.bb;
import com.baidu.live.data.d;
import com.baidu.live.data.e;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class GiftPanelTabPackageFragment extends GiftPanelTabBaseFragment {
    private com.baidu.live.gift.c.a aoJ;
    private long aoK;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aoA.setType(1);
        this.aoA.akk.setSelect(1);
        this.aoA.akk.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bP(int i) {
                if (GiftPanelTabPackageFragment.this.aoB != null) {
                    GiftPanelTabPackageFragment.this.aoB.uZ();
                }
            }
        });
        this.aoA.ty();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        dQ();
        this.aoJ.uS();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean vf() {
        g tJ = this.aoA.tJ();
        if (tJ == null) {
            return false;
        }
        dQ();
        int tM = this.aoA.tM();
        if (!a(tJ, tM) || e(tJ)) {
            return true;
        }
        if (tJ.rK()) {
            tJ.agC = this.aoA.tL();
            tJ.agC.ahz = tJ.rH();
            com.baidu.live.gift.b.b.uz().a(tJ, tM, this.aoC.mUserId, this.aoC.mUserName, this.aoC.mLiveId, this.aoC.mRoomId, this.aoC.mAppId, this.aoC.alR, this.aoC.otherParams);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.uz().c(tJ, tM, this.aoC.mUserId, this.aoC.mUserName, this.aoC.mLiveId, this.aoC.mRoomId, this.aoC.mAppId, this.aoC.alR, this.aoC.otherParams);
        }
        String str = null;
        if (tJ.agC != null) {
            str = tJ.agC.st();
        }
        if (str == null) {
            str = "";
        }
        this.aoJ.c(tJ.rC(), tJ.agx.agD, this.aoC.mUserId, this.aoC.mLiveId, tM, tM > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void vg() {
        dQ();
        this.aoJ.uS();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.agx) != null && i > aVar.agE) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean ve() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aoK >= 400) {
            this.aoK = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aoJ != null) {
            this.aoJ.release();
        }
    }

    private void dQ() {
        if (this.aoJ == null) {
            this.aoJ = new com.baidu.live.gift.c.a();
            this.aoJ.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.2
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<d> arrayList2, ArrayList<e> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.aoA.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.aoA.ajN) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> sd = it.next().sd();
                            if (sd != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = sd.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().rC().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : sd) {
                                        if (gVar.rC().equals(str2)) {
                                            gVar.agx.agE = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.aoA.a(false, z, i);
                        } else {
                            GiftPanelTabPackageFragment.this.aoA.p(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0086a c0086a;
        g.a aVar = gVar.agx;
        if (aVar == null || (c0086a = aVar.agH) == null || c0086a.key != 10) {
            return false;
        }
        if (c0086a.agJ != null && c0086a.agJ.optInt("price") == 100) {
            vj();
        }
        return true;
    }

    private void vj() {
        bb[] bbVarArr;
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (apVar != null && apVar.adg != null && apVar.adg.aeH && apVar.adc != null && (bbVarArr = apVar.adc.adW) != null && bbVarArr.length > 0) {
            for (int i = 0; i < bbVarArr.length; i++) {
                if (bbVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, bbVarArr[i].id));
                    return;
                }
            }
        }
    }
}
