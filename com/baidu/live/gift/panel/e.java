package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bn;
import com.baidu.live.data.cg;
import com.baidu.live.data.j;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends c {
    private com.baidu.live.gift.c.a bcR;
    private long bcS;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bcI.setType(1);
        this.bcI.HB();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        IQ();
        this.bcR.hs("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jg() {
        g HJ = this.bcI.HJ();
        if (HJ == null) {
            return false;
        }
        IQ();
        int HK = this.bcI.HK();
        if (!a(HJ, HK) || e(HJ)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (HJ.Fr()) {
            HJ.aTc = this.bcJ != null ? this.bcJ.Hm() : null;
            if (HJ.aTc == null) {
                return false;
            }
            HJ.aTc.aUi = HJ.Fo();
            com.baidu.live.gift.b.b.Iv().a(HJ, HK, this.bcu.mUserId, this.bcu.mUserName, this.bcu.mLiveId, this.bcu.mRoomId, this.bcu.mAppId, this.bcu.aZH, this.bcu.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.Iv().a(HJ, HK, this.bcu.mUserId, this.bcu.mUserName, this.bcu.mLiveId, this.bcu.mRoomId, this.bcu.mAppId, this.bcu.aZH, this.bcu.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (HJ.aTc != null) {
            str = HJ.aTc.Gb();
        }
        if (str == null) {
            str = "";
        }
        this.bcR.a(HJ.Fk(), HJ.Fl(), HJ.aSX.aTj, this.bcu.mUserId, this.bcu.mLiveId, HK, HK > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Jh() {
        IQ();
        this.bcR.hs("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aSX) != null && i > bVar.aTk) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jf() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bcS >= 1000) {
            this.bcS = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bcR != null) {
            this.bcR.release();
        }
    }

    private void IQ() {
        if (this.bcR == null) {
            this.bcR = new com.baidu.live.gift.c.a();
            this.bcR.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bcI.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.bcI.aXD) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> FL = it.next().FL();
                            if (FL != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = FL.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().Fk().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : FL) {
                                        if (gVar.Fk().equals(str2)) {
                                            gVar.aSX.aTk = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.bcI.a(false, z, i);
                        } else {
                            e.this.bcI.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aSX;
        if (bVar == null || (aVar = bVar.aTn) == null) {
            return false;
        }
        switch (aVar.key) {
            case 10:
                a(bVar);
                return true;
            case 11:
                f(gVar);
                return true;
            default:
                return false;
        }
    }

    private void a(g.b bVar) {
        bn bnVar;
        cg[] cgVarArr;
        if (bVar.aTn.aTo != null && bVar.aTn.aTo.optInt("price") == 100 && (bnVar = com.baidu.live.aa.a.Ph().bsh) != null && bnVar.aNP != null && bnVar.aNP.aQd && bnVar.aNM != null && (cgVarArr = bnVar.aNM.aPe) != null && cgVarArr.length > 0) {
            for (cg cgVar : cgVarArr) {
                if (cgVar.price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, cgVar.id));
                    return;
                }
            }
        }
    }

    private void f(g gVar) {
        g.b bVar;
        if (gVar != null && (bVar = gVar.aSX) != null && bVar.aTn != null && bVar.aTn.aTo != null) {
            String optString = bVar.aTn.aTo.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.Fk();
                nobleDetailInfo.expDuration = bVar.aTn.aTo.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aTl;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
        }
    }
}
