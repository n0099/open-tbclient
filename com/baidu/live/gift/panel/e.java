package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ax;
import com.baidu.live.data.bj;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends c {
    private com.baidu.live.gift.c.a aMS;
    private long aMT;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aMJ.setType(1);
        this.aMJ.zn();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        AC();
        this.aMS.fj("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean AS() {
        g zv = this.aMJ.zv();
        if (zv == null) {
            return false;
        }
        AC();
        int zw = this.aMJ.zw();
        if (!a(zv, zw) || e(zv)) {
            return true;
        }
        if (zv.xt()) {
            zv.aEq = this.aMK != null ? this.aMK.yX() : null;
            if (zv.aEq == null) {
                return false;
            }
            zv.aEq.aFr = zv.xq();
            com.baidu.live.gift.b.b.Ah().a(zv, zw, this.aMw.mUserId, this.aMw.mUserName, this.aMw.mLiveId, this.aMw.mRoomId, this.aMw.mAppId, this.aMw.aJO, this.aMw.otherParams, 0L);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.Ah().a(zv, zw, this.aMw.mUserId, this.aMw.mUserName, this.aMw.mLiveId, this.aMw.mRoomId, this.aMw.mAppId, this.aMw.aJO, this.aMw.otherParams, 0L, System.currentTimeMillis());
        }
        String str = null;
        if (zv.aEq != null) {
            str = zv.aEq.yc();
        }
        if (str == null) {
            str = "";
        }
        this.aMS.d(zv.xl(), zv.aEl.aEr, this.aMw.mUserId, this.aMw.mLiveId, zw, zw > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void AT() {
        AC();
        this.aMS.fj("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.aEl) != null && i > aVar.aEs) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean AR() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aMT >= 400) {
            this.aMT = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aMS != null) {
            this.aMS.release();
        }
    }

    private void AC() {
        if (this.aMS == null) {
            this.aMS = new com.baidu.live.gift.c.a();
            this.aMS.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.aMJ.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.aMJ.aHY) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> xM = it.next().xM();
                            if (xM != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = xM.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().xl().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : xM) {
                                        if (gVar.xl().equals(str2)) {
                                            gVar.aEl.aEs = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.aMJ.a(false, z, i);
                        } else {
                            e.this.aMJ.z(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0164a c0164a;
        g.a aVar = gVar.aEl;
        if (aVar == null || (c0164a = aVar.aEv) == null || c0164a.key != 10) {
            return false;
        }
        if (c0164a.aEx != null && c0164a.aEx.optInt("price") == 100) {
            AW();
        }
        return true;
    }

    private void AW() {
        bj[] bjVarArr;
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && axVar.aAL != null && axVar.aAL.aCs && axVar.aAI != null && (bjVarArr = axVar.aAI.aBC) != null && bjVarArr.length > 0) {
            for (int i = 0; i < bjVarArr.length; i++) {
                if (bjVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, bjVarArr[i].id));
                    return;
                }
            }
        }
    }
}
