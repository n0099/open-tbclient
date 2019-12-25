package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ak;
import com.baidu.live.data.av;
import com.baidu.live.data.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class GiftPanelTabPackageFragment extends GiftPanelTabBaseFragment {
    private com.baidu.live.gift.c.a aly;
    private long alz;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.alp.setType(1);
        this.alp.ahj.setSelect(1);
        this.alp.ahj.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bI(int i) {
                if (GiftPanelTabPackageFragment.this.alq != null) {
                    GiftPanelTabPackageFragment.this.alq.tm();
                }
            }
        });
        this.alp.rR();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        dP();
        this.aly.td();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean tt() {
        g sc = this.alp.sc();
        if (sc == null) {
            return false;
        }
        dP();
        int sf = this.alp.sf();
        if (!a(sc, sf) || d(sc)) {
            return true;
        }
        if (sc.qF()) {
            sc.adW = this.alp.se();
            sc.adW.aez = sc.qC();
            com.baidu.live.gift.b.b.sK().b(sc, sf, this.alr.mUserId, this.alr.mUserName, this.alr.mLiveId, this.alr.aiN, this.alr.mAppId, this.alr.aiO, this.alr.otherParams);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.sK().a(sc, sf, this.alr.mUserId, this.alr.mUserName, this.alr.mLiveId, this.alr.aiN, this.alr.mAppId, this.alr.aiO, this.alr.otherParams);
        }
        String str = null;
        if (sc.adW != null) {
            str = sc.adW.rb();
        }
        if (str == null) {
            str = "";
        }
        this.aly.a(sc.qx(), sc.adR.adX, this.alr.mUserId, this.alr.mLiveId, sf, sf > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void tu() {
        dP();
        this.aly.td();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.adR) != null && i > aVar.adY) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean ts() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.alz >= 400) {
            this.alz = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aly != null) {
            this.aly.release();
        }
    }

    private void dP() {
        if (this.aly == null) {
            this.aly = new com.baidu.live.gift.c.a();
            this.aly.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.2
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<d> arrayList3) {
                    super.a(z, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.alp.a(true, arrayList, arrayList2, arrayList3, z);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.alp.agK) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> qQ = it.next().qQ();
                            if (qQ != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = qQ.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().qx().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : qQ) {
                                        if (gVar.qx().equals(str2)) {
                                            gVar.adR.adY = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.alp.e(false, z);
                        } else {
                            GiftPanelTabPackageFragment.this.alp.p(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean d(g gVar) {
        g.a.C0079a c0079a;
        g.a aVar = gVar.adR;
        if (aVar == null || (c0079a = aVar.aeb) == null || c0079a.key != 10) {
            return false;
        }
        if (c0079a.aed != null && c0079a.aed.optInt("price") == 100) {
            tw();
        }
        return true;
    }

    private void tw() {
        av[] avVarArr;
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (akVar != null && akVar.aaK != null && akVar.aaK.ach && akVar.aaH != null && (avVarArr = akVar.aaH.abw) != null && avVarArr.length > 0) {
            for (int i = 0; i < avVarArr.length; i++) {
                if (avVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, avVarArr[i].id));
                    return;
                }
            }
        }
    }
}
