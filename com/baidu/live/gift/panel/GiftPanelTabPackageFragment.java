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
    private long aoA;
    private com.baidu.live.gift.c.a aoz;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aoq.setType(1);
        this.aoq.aka.setSelect(1);
        this.aoq.aka.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bP(int i) {
                if (GiftPanelTabPackageFragment.this.aor != null) {
                    GiftPanelTabPackageFragment.this.aor.uU();
                }
            }
        });
        this.aoq.tt();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        dQ();
        this.aoz.uN();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean va() {
        g tE = this.aoq.tE();
        if (tE == null) {
            return false;
        }
        dQ();
        int tH = this.aoq.tH();
        if (!a(tE, tH) || e(tE)) {
            return true;
        }
        if (tE.rF()) {
            tE.ags = this.aoq.tG();
            tE.ags.ahp = tE.rC();
            com.baidu.live.gift.b.b.uu().a(tE, tH, this.aos.mUserId, this.aos.mUserName, this.aos.mLiveId, this.aos.mRoomId, this.aos.mAppId, this.aos.alH, this.aos.otherParams);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.uu().c(tE, tH, this.aos.mUserId, this.aos.mUserName, this.aos.mLiveId, this.aos.mRoomId, this.aos.mAppId, this.aos.alH, this.aos.otherParams);
        }
        String str = null;
        if (tE.ags != null) {
            str = tE.ags.so();
        }
        if (str == null) {
            str = "";
        }
        this.aoz.c(tE.rx(), tE.agn.agt, this.aos.mUserId, this.aos.mLiveId, tH, tH > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void vb() {
        dQ();
        this.aoz.uN();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.agn) != null && i > aVar.agu) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean uZ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aoA >= 400) {
            this.aoA = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aoz != null) {
            this.aoz.release();
        }
    }

    private void dQ() {
        if (this.aoz == null) {
            this.aoz = new com.baidu.live.gift.c.a();
            this.aoz.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.2
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<d> arrayList2, ArrayList<e> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.aoq.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.aoq.ajD) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> rY = it.next().rY();
                            if (rY != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = rY.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().rx().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : rY) {
                                        if (gVar.rx().equals(str2)) {
                                            gVar.agn.agu = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.aoq.a(false, z, i);
                        } else {
                            GiftPanelTabPackageFragment.this.aoq.p(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0086a c0086a;
        g.a aVar = gVar.agn;
        if (aVar == null || (c0086a = aVar.agx) == null || c0086a.key != 10) {
            return false;
        }
        if (c0086a.agz != null && c0086a.agz.optInt("price") == 100) {
            ve();
        }
        return true;
    }

    private void ve() {
        bb[] bbVarArr;
        ap apVar = com.baidu.live.v.a.zl().axD;
        if (apVar != null && apVar.acV != null && apVar.acV.aex && apVar.acS != null && (bbVarArr = apVar.acS.adM) != null && bbVarArr.length > 0) {
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
