package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.as;
import com.baidu.live.data.be;
import com.baidu.live.data.d;
import com.baidu.live.data.e;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class GiftPanelTabPackageFragment extends GiftPanelTabBaseFragment {
    private com.baidu.live.gift.c.a aHj;
    private long aHk;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aGZ.setType(1);
        this.aGZ.xX();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        zp();
        this.aHj.zm();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zC() {
        g yf = this.aGZ.yf();
        if (yf == null) {
            return false;
        }
        zp();
        int yg = this.aGZ.yg();
        if (!a(yf, yg) || e(yf)) {
            return true;
        }
        if (yf.wc()) {
            yf.ayY = this.aHa != null ? this.aHa.xK() : null;
            if (yf.ayY == null) {
                return false;
            }
            yf.ayY.azZ = yf.vZ();
            com.baidu.live.gift.b.b.yS().a(yf, yg, this.aHb.mUserId, this.aHb.mUserName, this.aHb.mLiveId, this.aHb.mRoomId, this.aHb.mAppId, this.aHb.aEn, this.aHb.otherParams, 0L);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.yS().a(yf, yg, this.aHb.mUserId, this.aHb.mUserName, this.aHb.mLiveId, this.aHb.mRoomId, this.aHb.mAppId, this.aHb.aEn, this.aHb.otherParams, 0L, System.currentTimeMillis());
        }
        String str = null;
        if (yf.ayY != null) {
            str = yf.ayY.wL();
        }
        if (str == null) {
            str = "";
        }
        this.aHj.c(yf.vU(), yf.ayT.ayZ, this.aHb.mUserId, this.aHb.mLiveId, yg, yg > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void zD() {
        zp();
        this.aHj.zm();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.ayT) != null && i > aVar.aza) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zB() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aHk >= 400) {
            this.aHk = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aHj != null) {
            this.aHj.release();
        }
    }

    private void zp() {
        if (this.aHj == null) {
            this.aHj = new com.baidu.live.gift.c.a();
            this.aHj.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<d> arrayList2, ArrayList<e> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.aGZ.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.aGZ.aCz) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> wv = it.next().wv();
                            if (wv != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = wv.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().vU().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : wv) {
                                        if (gVar.vU().equals(str2)) {
                                            gVar.ayT.aza = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.aGZ.a(false, z, i);
                        } else {
                            GiftPanelTabPackageFragment.this.aGZ.v(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0133a c0133a;
        g.a aVar = gVar.ayT;
        if (aVar == null || (c0133a = aVar.azd) == null || c0133a.key != 10) {
            return false;
        }
        if (c0133a.azf != null && c0133a.azf.optInt("price") == 100) {
            zG();
        }
        return true;
    }

    private void zG() {
        be[] beVarArr;
        as asVar = com.baidu.live.v.a.En().aRB;
        if (asVar != null && asVar.avD != null && asVar.avD.axd && asVar.avA != null && (beVarArr = asVar.avA.awt) != null && beVarArr.length > 0) {
            for (int i = 0; i < beVarArr.length; i++) {
                if (beVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, beVarArr[i].id));
                    return;
                }
            }
        }
    }
}
