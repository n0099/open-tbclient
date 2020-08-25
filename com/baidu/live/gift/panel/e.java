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
    private com.baidu.live.gift.c.a aWf;
    private long aWg;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aVW.setType(1);
        this.aVW.FS();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        Hh();
        this.aWf.gJ("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hx() {
        g Ga = this.aVW.Ga();
        if (Ga == null) {
            return false;
        }
        Hh();
        int Gb = this.aVW.Gb();
        if (!a(Ga, Gb) || e(Ga)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Ga.DY()) {
            Ga.aNs = this.aVX != null ? this.aVX.FC() : null;
            if (Ga.aNs == null) {
                return false;
            }
            Ga.aNs.aOt = Ga.DV();
            com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVJ.mUserId, this.aVJ.mUserName, this.aVJ.mLiveId, this.aVJ.mRoomId, this.aVJ.mAppId, this.aVJ.aTc, this.aVJ.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVJ.mUserId, this.aVJ.mUserName, this.aVJ.mLiveId, this.aVJ.mRoomId, this.aVJ.mAppId, this.aVJ.aTc, this.aVJ.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Ga.aNs != null) {
            str = Ga.aNs.EH();
        }
        if (str == null) {
            str = "";
        }
        this.aWf.a(Ga.DR(), Ga.DS(), Ga.aNn.aNt, this.aVJ.mUserId, this.aVJ.mLiveId, Gb, Gb > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Hy() {
        Hh();
        this.aWf.gJ("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.aNn) != null && i > aVar.aNu) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aWg >= 1000) {
            this.aWg = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aWf != null) {
            this.aWf.release();
        }
    }

    private void Hh() {
        if (this.aWf == null) {
            this.aWf = new com.baidu.live.gift.c.a();
            this.aWf.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.aVW.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.aVW.aRl) != null) {
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
                                            gVar.aNn.aNu = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.aVW.a(false, z, i);
                        } else {
                            e.this.aVW.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0173a c0173a;
        g.a aVar = gVar.aNn;
        if (aVar == null || (c0173a = aVar.aNx) == null || c0173a.key != 10) {
            return false;
        }
        if (c0173a.aNz != null && c0173a.aNz.optInt("price") == 100) {
            HB();
        }
        return true;
    }

    private void HB() {
        br[] brVarArr;
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar != null && beVar.aJB != null && beVar.aJB.aLn && beVar.aJy != null && (brVarArr = beVar.aJy.aKr) != null && brVarArr.length > 0) {
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
