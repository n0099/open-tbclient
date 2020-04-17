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
    private com.baidu.live.gift.c.a aHd;
    private long aHe;

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aGT.setType(1);
        this.aGT.xY();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        zq();
        this.aHd.zn();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zD() {
        g yg = this.aGT.yg();
        if (yg == null) {
            return false;
        }
        zq();
        int yh = this.aGT.yh();
        if (!a(yg, yh) || e(yg)) {
            return true;
        }
        if (yg.wd()) {
            yg.ayS = this.aGU != null ? this.aGU.xL() : null;
            if (yg.ayS == null) {
                return false;
            }
            yg.ayS.azT = yg.wa();
            com.baidu.live.gift.b.b.yT().a(yg, yh, this.aGV.mUserId, this.aGV.mUserName, this.aGV.mLiveId, this.aGV.mRoomId, this.aGV.mAppId, this.aGV.aEh, this.aGV.otherParams, 0L);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.yT().a(yg, yh, this.aGV.mUserId, this.aGV.mUserName, this.aGV.mLiveId, this.aGV.mRoomId, this.aGV.mAppId, this.aGV.aEh, this.aGV.otherParams, 0L, System.currentTimeMillis());
        }
        String str = null;
        if (yg.ayS != null) {
            str = yg.ayS.wM();
        }
        if (str == null) {
            str = "";
        }
        this.aHd.c(yg.vV(), yg.ayN.ayT, this.aGV.mUserId, this.aGV.mLiveId, yh, yh > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void zE() {
        zq();
        this.aHd.zn();
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.ayN) != null && i > aVar.ayU) {
            showToast("赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zC() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aHe >= 400) {
            this.aHe = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aHd != null) {
            this.aHd.release();
        }
    }

    private void zq() {
        if (this.aHd == null) {
            this.aHd = new com.baidu.live.gift.c.a();
            this.aHd.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.GiftPanelTabPackageFragment.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<d> arrayList2, ArrayList<e> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && GiftPanelTabPackageFragment.this.mVisible) {
                        GiftPanelTabPackageFragment.this.showToast(str);
                    }
                    GiftPanelTabPackageFragment.this.aGT.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = GiftPanelTabPackageFragment.this.aGT.aCt) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> ww = it.next().ww();
                            if (ww != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = ww.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().vV().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : ww) {
                                        if (gVar.vV().equals(str2)) {
                                            gVar.ayN.ayU = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            GiftPanelTabPackageFragment.this.aGT.a(false, z, i);
                        } else {
                            GiftPanelTabPackageFragment.this.aGT.v(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0112a c0112a;
        g.a aVar = gVar.ayN;
        if (aVar == null || (c0112a = aVar.ayX) == null || c0112a.key != 10) {
            return false;
        }
        if (c0112a.ayZ != null && c0112a.ayZ.optInt("price") == 100) {
            zH();
        }
        return true;
    }

    private void zH() {
        be[] beVarArr;
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (asVar != null && asVar.avx != null && asVar.avx.awX && asVar.avu != null && (beVarArr = asVar.avu.awn) != null && beVarArr.length > 0) {
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
