package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bm;
import com.baidu.live.data.ce;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends c {
    private com.baidu.live.gift.c.a bdj;
    private long bdk;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bda.setType(1);
        this.bda.HJ();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        IY();
        this.bdj.hr("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jo() {
        g HR = this.bda.HR();
        if (HR == null) {
            return false;
        }
        IY();
        int HS = this.bda.HS();
        if (!a(HR, HS) || e(HR)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (HR.Fz()) {
            HR.aTv = this.bdb != null ? this.bdb.Hu() : null;
            if (HR.aTv == null) {
                return false;
            }
            HR.aTv.aUB = HR.Fw();
            com.baidu.live.gift.b.b.ID().a(HR, HS, this.bcM.mUserId, this.bcM.mUserName, this.bcM.mLiveId, this.bcM.mRoomId, this.bcM.mAppId, this.bcM.baa, this.bcM.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.ID().a(HR, HS, this.bcM.mUserId, this.bcM.mUserName, this.bcM.mLiveId, this.bcM.mRoomId, this.bcM.mAppId, this.bcM.baa, this.bcM.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (HR.aTv != null) {
            str = HR.aTv.Gj();
        }
        if (str == null) {
            str = "";
        }
        this.bdj.a(HR.Fs(), HR.Ft(), HR.aTp.aTB, this.bcM.mUserId, this.bcM.mLiveId, HS, HS > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Jp() {
        IY();
        this.bdj.hr("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aTp) != null && i > bVar.aTC) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bdk >= 1000) {
            this.bdk = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bdj != null) {
            this.bdj.release();
        }
    }

    private void IY() {
        if (this.bdj == null) {
            this.bdj = new com.baidu.live.gift.c.a();
            this.bdj.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bda.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.bda.aXW) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> FT = it.next().FT();
                            if (FT != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = FT.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().Fs().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : FT) {
                                        if (gVar.Fs().equals(str2)) {
                                            gVar.aTp.aTC = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.bda.a(false, z, i);
                        } else {
                            e.this.bda.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aTp;
        if (bVar == null || (aVar = bVar.aTF) == null || aVar.key != 10) {
            return false;
        }
        if (aVar.aTG != null && aVar.aTG.optInt("price") == 100) {
            Jt();
        }
        return true;
    }

    private void Jt() {
        ce[] ceVarArr;
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && bmVar.aOD != null && bmVar.aOD.aQM && bmVar.aOA != null && (ceVarArr = bmVar.aOA.aPN) != null && ceVarArr.length > 0) {
            for (int i = 0; i < ceVarArr.length; i++) {
                if (ceVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, ceVarArr[i].id));
                    return;
                }
            }
        }
    }
}
