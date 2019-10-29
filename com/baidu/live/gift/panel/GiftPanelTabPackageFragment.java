package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.af;
import com.baidu.live.data.ao;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class GiftPanelTabPackageFragment extends GiftPanelTabBaseFragment {
    private com.baidu.live.gift.c.a adS;
    private long adT;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.adJ.setType(1);
        this.adJ.ZE.setSelect(1);
        this.adJ.ZE.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bu(int i) {
                if (GiftPanelTabPackageFragment.this.adK != null) {
                    GiftPanelTabPackageFragment.this.adK.rx();
                }
            }
        });
        this.adJ.qj();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        dv();
        this.adS.ro();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rD() {
        g qt = this.adJ.qt();
        if (qt == null) {
            return false;
        }
        dv();
        int qv = this.adJ.qv();
        if (!a(qt, qv) || c(qt)) {
            return true;
        }
        if (qt.pk()) {
            qt.WJ = this.adJ.qu();
            qt.WJ.Xn = qt.ph();
            com.baidu.live.gift.b.b.rc().b(qt, qv, this.adL.mUserId, this.adL.mUserName, this.adL.mLiveId, this.adL.abd, this.adL.mAppId, this.adL.abe, this.adL.otherParams);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.rc().a(qt, qv, this.adL.mUserId, this.adL.mUserName, this.adL.mLiveId, this.adL.abd, this.adL.mAppId, this.adL.abe, this.adL.otherParams);
        }
        String str = null;
        if (qt.WJ != null) {
            str = qt.WJ.pD();
        }
        if (str == null) {
            str = "";
        }
        this.adS.a(qt.pc(), qt.WH.WK, this.adL.mUserId, this.adL.mLiveId, qv, qv > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void rE() {
        dv();
        this.adS.ro();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.WH) != null && i > aVar.WL) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rC() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.adT >= 400) {
            this.adT = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.adS != null) {
            this.adS.release();
        }
    }

    private void dv() {
        if (this.adS == null) {
            this.adS = new com.baidu.live.gift.c.a();
            this.adS.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.2
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3) {
                    super.a(z, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.adJ.a(true, arrayList, arrayList2, arrayList3, z);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.adJ.Ze) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> pt = it.next().pt();
                            if (pt != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = pt.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().pc().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : pt) {
                                        if (gVar.pc().equals(str2)) {
                                            gVar.WH.WL = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.adJ.e(false, true);
                        } else {
                            GiftPanelTabPackageFragment.this.adJ.l(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean c(g gVar) {
        g.a.C0065a c0065a;
        g.a aVar = gVar.WH;
        if (aVar == null || (c0065a = aVar.WO) == null || c0065a.key != 10) {
            return false;
        }
        if (c0065a.WQ != null && c0065a.WQ.optInt("price") == 100) {
            rG();
        }
        return true;
    }

    private void rG() {
        ao[] aoVarArr;
        af afVar = com.baidu.live.l.a.uA().akM;
        if (afVar != null && afVar.Uh != null && afVar.Uh.Vk && afVar.Ue != null && (aoVarArr = afVar.Ue.UJ) != null && aoVarArr.length > 0) {
            for (int i = 0; i < aoVarArr.length; i++) {
                if (aoVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, new Integer(i)));
                    return;
                }
            }
        }
    }
}
