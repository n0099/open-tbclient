package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.be;
import com.baidu.live.data.br;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends c {
    private com.baidu.live.gift.c.a aWh;
    private long aWi;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aVY.setType(1);
        this.aVY.FS();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        Hh();
        this.aWh.gK("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hx() {
        g Ga = this.aVY.Ga();
        if (Ga == null) {
            return false;
        }
        Hh();
        int Gb = this.aVY.Gb();
        if (!a(Ga, Gb) || e(Ga)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Ga.DY()) {
            Ga.aNu = this.aVZ != null ? this.aVZ.FC() : null;
            if (Ga.aNu == null) {
                return false;
            }
            Ga.aNu.aOv = Ga.DV();
            com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVL.mUserId, this.aVL.mUserName, this.aVL.mLiveId, this.aVL.mRoomId, this.aVL.mAppId, this.aVL.aTe, this.aVL.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVL.mUserId, this.aVL.mUserName, this.aVL.mLiveId, this.aVL.mRoomId, this.aVL.mAppId, this.aVL.aTe, this.aVL.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Ga.aNu != null) {
            str = Ga.aNu.EH();
        }
        if (str == null) {
            str = "";
        }
        this.aWh.a(Ga.DR(), Ga.DS(), Ga.aNp.aNv, this.aVL.mUserId, this.aVL.mLiveId, Gb, Gb > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Hy() {
        Hh();
        this.aWh.gK("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.aNp) != null && i > aVar.aNw) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aWi >= 1000) {
            this.aWi = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aWh != null) {
            this.aWh.release();
        }
    }

    private void Hh() {
        if (this.aWh == null) {
            this.aWh = new com.baidu.live.gift.c.a();
            this.aWh.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.aVY.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.aVY.aRn) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> Er = it.next().Er();
                            if (Er != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = Er.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().DR().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : Er) {
                                        if (gVar.DR().equals(str2)) {
                                            gVar.aNp.aNw = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.aVY.a(false, z, i);
                        } else {
                            e.this.aVY.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0173a c0173a;
        g.a aVar = gVar.aNp;
        if (aVar == null || (c0173a = aVar.aNz) == null || c0173a.key != 10) {
            return false;
        }
        if (c0173a.aNB != null && c0173a.aNB.optInt("price") == 100) {
            HB();
        }
        return true;
    }

    private void HB() {
        br[] brVarArr;
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar != null && beVar.aJD != null && beVar.aJD.aLp && beVar.aJA != null && (brVarArr = beVar.aJA.aKt) != null && brVarArr.length > 0) {
            for (int i = 0; i < brVarArr.length; i++) {
                if (brVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, brVarArr[i].id));
                    return;
                }
            }
        }
    }
}
