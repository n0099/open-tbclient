package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ao;
import com.baidu.live.data.az;
import com.baidu.live.data.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class GiftPanelTabPackageFragment extends GiftPanelTabBaseFragment {
    private com.baidu.live.gift.c.a aml;
    private long amm;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.amc.setType(1);
        this.amc.ahS.setSelect(1);
        this.amc.ahS.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bI(int i) {
                if (GiftPanelTabPackageFragment.this.amd != null) {
                    GiftPanelTabPackageFragment.this.amd.tE();
                }
            }
        });
        this.amc.sh();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        dP();
        this.aml.tv();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean tK() {
        g ss = this.amc.ss();
        if (ss == null) {
            return false;
        }
        dP();
        int sv = this.amc.sv();
        if (!a(ss, sv) || d(ss)) {
            return true;
        }
        if (ss.qM()) {
            ss.ael = this.amc.su();
            ss.ael.afi = ss.qJ();
            com.baidu.live.gift.b.b.ta().b(ss, sv, this.ame.mUserId, this.ame.mUserName, this.ame.mLiveId, this.ame.mRoomId, this.ame.mAppId, this.ame.ajy, this.ame.otherParams);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.ta().a(ss, sv, this.ame.mUserId, this.ame.mUserName, this.ame.mLiveId, this.ame.mRoomId, this.ame.mAppId, this.ame.ajy, this.ame.otherParams);
        }
        String str = null;
        if (ss.ael != null) {
            str = ss.ael.rn();
        }
        if (str == null) {
            str = "";
        }
        this.aml.a(ss.qE(), ss.aeg.aem, this.ame.mUserId, this.ame.mLiveId, sv, sv > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void tL() {
        dP();
        this.aml.tv();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.aeg) != null && i > aVar.aen) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean tJ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.amm >= 400) {
            this.amm = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aml != null) {
            this.aml.release();
        }
    }

    private void dP() {
        if (this.aml == null) {
            this.aml = new com.baidu.live.gift.c.a();
            this.aml.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.2
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<d> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.amc.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.amc.aht) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> qX = it.next().qX();
                            if (qX != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = qX.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().qE().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : qX) {
                                        if (gVar.qE().equals(str2)) {
                                            gVar.aeg.aen = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.amc.a(false, z, i);
                        } else {
                            GiftPanelTabPackageFragment.this.amc.p(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean d(g gVar) {
        g.a.C0079a c0079a;
        g.a aVar = gVar.aeg;
        if (aVar == null || (c0079a = aVar.aeq) == null || c0079a.key != 10) {
            return false;
        }
        if (c0079a.aes != null && c0079a.aes.optInt("price") == 100) {
            tN();
        }
        return true;
    }

    private void tN() {
        az[] azVarArr;
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (aoVar != null && aoVar.aaX != null && aoVar.aaX.acv && aoVar.aaU != null && (azVarArr = aoVar.aaU.abH) != null && azVarArr.length > 0) {
            for (int i = 0; i < azVarArr.length; i++) {
                if (azVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, azVarArr[i].id));
                    return;
                }
            }
        }
    }
}
