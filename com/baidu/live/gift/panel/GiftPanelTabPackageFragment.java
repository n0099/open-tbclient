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
    private com.baidu.live.gift.c.a adA;
    private long adB;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.adr.setType(1);
        this.adr.Zm.setSelect(1);
        this.adr.Zm.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bu(int i) {
                if (GiftPanelTabPackageFragment.this.ads != null) {
                    GiftPanelTabPackageFragment.this.ads.ry();
                }
            }
        });
        this.adr.qk();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        dv();
        this.adA.rp();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rE() {
        g qu = this.adr.qu();
        if (qu == null) {
            return false;
        }
        dv();
        int qw = this.adr.qw();
        if (!a(qu, qw) || c(qu)) {
            return true;
        }
        if (qu.pk()) {
            qu.Wq = this.adr.qv();
            qu.Wq.WV = qu.ph();
            com.baidu.live.gift.b.b.rd().b(qu, qw, this.adt.mUserId, this.adt.mUserName, this.adt.mLiveId, this.adt.aaK, this.adt.mAppId, this.adt.aaL, this.adt.otherParams);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.rd().a(qu, qw, this.adt.mUserId, this.adt.mUserName, this.adt.mLiveId, this.adt.aaK, this.adt.mAppId, this.adt.aaL, this.adt.otherParams);
        }
        String str = null;
        if (qu.Wq != null) {
            str = qu.Wq.pD();
        }
        if (str == null) {
            str = "";
        }
        this.adA.a(qu.pc(), qu.Wo.Wr, this.adt.mUserId, this.adt.mLiveId, qw, qw > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void rF() {
        dv();
        this.adA.rp();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.Wo) != null && i > aVar.Ws) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rD() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.adB >= 400) {
            this.adB = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.adA != null) {
            this.adA.release();
        }
    }

    private void dv() {
        if (this.adA == null) {
            this.adA = new com.baidu.live.gift.c.a();
            this.adA.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.2
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3) {
                    super.a(z, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.adr.a(true, arrayList, arrayList2, arrayList3, z);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.adr.YM) != null) {
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
                                            gVar.Wo.Ws = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.adr.e(false, true);
                        } else {
                            GiftPanelTabPackageFragment.this.adr.l(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean c(g gVar) {
        g.a.C0065a c0065a;
        g.a aVar = gVar.Wo;
        if (aVar == null || (c0065a = aVar.Wv) == null || c0065a.key != 10) {
            return false;
        }
        if (c0065a.Wx != null && c0065a.Wx.optInt("price") == 100) {
            rH();
        }
        return true;
    }

    private void rH() {
        ao[] aoVarArr;
        af afVar = com.baidu.live.l.a.uB().aku;
        if (afVar != null && afVar.TO != null && afVar.TO.UR && afVar.TK != null && (aoVarArr = afVar.TK.Uo) != null && aoVarArr.length > 0) {
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
