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
    private com.baidu.live.gift.c.a bbV;
    private long bbW;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bbM.setType(1);
        this.bbM.Ho();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        IF();
        this.bbV.hj("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean IV() {
        g Hw = this.bbM.Hw();
        if (Hw == null) {
            return false;
        }
        IF();
        int Hx = this.bbM.Hx();
        if (!a(Hw, Hx) || e(Hw)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Hw.Fk()) {
            Hw.aSz = this.bbN != null ? this.bbN.GY() : null;
            if (Hw.aSz == null) {
                return false;
            }
            Hw.aSz.aTF = Hw.Fh();
            com.baidu.live.gift.b.b.Ik().a(Hw, Hx, this.bby.mUserId, this.bby.mUserName, this.bby.mLiveId, this.bby.mRoomId, this.bby.mAppId, this.bby.aYD, this.bby.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.Ik().a(Hw, Hx, this.bby.mUserId, this.bby.mUserName, this.bby.mLiveId, this.bby.mRoomId, this.bby.mAppId, this.bby.aYD, this.bby.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Hw.aSz != null) {
            str = Hw.aSz.FU();
        }
        if (str == null) {
            str = "";
        }
        this.bbV.a(Hw.Fd(), Hw.Fe(), Hw.aSt.aSF, this.bby.mUserId, this.bby.mLiveId, Hx, Hx > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void IW() {
        IF();
        this.bbV.hj("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aSt) != null && i > bVar.aSG) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean IU() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bbW >= 1000) {
            this.bbW = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bbV != null) {
            this.bbV.release();
        }
    }

    private void IF() {
        if (this.bbV == null) {
            this.bbV = new com.baidu.live.gift.c.a();
            this.bbV.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bbM.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.bbM.aWB) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> FE = it.next().FE();
                            if (FE != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = FE.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().Fd().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : FE) {
                                        if (gVar.Fd().equals(str2)) {
                                            gVar.aSt.aSG = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.bbM.a(false, z, i);
                        } else {
                            e.this.bbM.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aSt;
        if (bVar == null || (aVar = bVar.aSJ) == null || aVar.key != 10) {
            return false;
        }
        if (aVar.aSK != null && aVar.aSK.optInt("price") == 100) {
            Ja();
        }
        return true;
    }

    private void Ja() {
        bz[] bzVarArr;
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && bjVar.aNY != null && bjVar.aNY.aQc && bjVar.aNV != null && (bzVarArr = bjVar.aNV.aPd) != null && bzVarArr.length > 0) {
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
