package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bj;
import com.baidu.live.data.bz;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends c {
    private com.baidu.live.gift.c.a aYB;
    private long aYC;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aYs.setType(1);
        this.aYs.Gs();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        HI();
        this.aYB.gV("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean HY() {
        g GA = this.aYs.GA();
        if (GA == null) {
            return false;
        }
        HI();
        int GB = this.aYs.GB();
        if (!a(GA, GB) || e(GA)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (GA.Eo()) {
            GA.aPo = this.aYt != null ? this.aYt.Gc() : null;
            if (GA.aPo == null) {
                return false;
            }
            GA.aPo.aQu = GA.El();
            com.baidu.live.gift.b.b.Hn().a(GA, GB, this.aYe.mUserId, this.aYe.mUserName, this.aYe.mLiveId, this.aYe.mRoomId, this.aYe.mAppId, this.aYe.aVs, this.aYe.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.Hn().a(GA, GB, this.aYe.mUserId, this.aYe.mUserName, this.aYe.mLiveId, this.aYe.mRoomId, this.aYe.mAppId, this.aYe.aVs, this.aYe.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (GA.aPo != null) {
            str = GA.aPo.EY();
        }
        if (str == null) {
            str = "";
        }
        this.aYB.a(GA.Eh(), GA.Ei(), GA.aPi.aPu, this.aYe.mUserId, this.aYe.mLiveId, GB, GB > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void HZ() {
        HI();
        this.aYB.gV("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a = super.a(gVar, i);
        if (a && (bVar = gVar.aPi) != null && i > bVar.aPv) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean HX() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aYC >= 1000) {
            this.aYC = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aYB != null) {
            this.aYB.release();
        }
    }

    private void HI() {
        if (this.aYB == null) {
            this.aYB = new com.baidu.live.gift.c.a();
            this.aYB.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.aYs.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.aYs.aTq) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> EI = it.next().EI();
                            if (EI != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = EI.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().Eh().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : EI) {
                                        if (gVar.Eh().equals(str2)) {
                                            gVar.aPi.aPv = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.aYs.a(false, z, i);
                        } else {
                            e.this.aYs.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aPi;
        if (bVar == null || (aVar = bVar.aPy) == null || aVar.key != 10) {
            return false;
        }
        if (aVar.aPz != null && aVar.aPz.optInt("price") == 100) {
            Id();
        }
        return true;
    }

    private void Id() {
        bz[] bzVarArr;
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar != null && bjVar.aKT != null && bjVar.aKT.aMX && bjVar.aKQ != null && (bzVarArr = bjVar.aKQ.aLY) != null && bzVarArr.length > 0) {
            for (int i = 0; i < bzVarArr.length; i++) {
                if (bzVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, bzVarArr[i].id));
                    return;
                }
            }
        }
    }
}
