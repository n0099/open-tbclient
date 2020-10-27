package com.baidu.live.yuyingift.panel;

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
import com.baidu.live.utils.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends b {
    private com.baidu.live.yuyingift.c.c bLY;
    private long bdk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bLT.setType(1);
        this.bLT.HJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        IY();
        this.bLY.hr("gift_panel");
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Jo() {
        g HR = this.bLT.HR();
        if (HR == null) {
            return false;
        }
        IY();
        int HS = this.bLT.HS();
        if (!a(HR, HS) || e(HR)) {
            return true;
        }
        if (HR.Fz()) {
            HR.aTv = this.bLU != null ? this.bLU.Hu() : null;
            if (HR.aTv == null) {
                return false;
            }
            HR.aTv.aUB = HR.Fw();
            com.baidu.live.yuyingift.b.b.Vf().a(HR, HS, this.bLL.mUserId, this.bLL.mUserName, this.bLL.mLiveId, this.bLL.mRoomId, this.bLL.mAppId, this.bLL.baa, this.bLL.otherParams, 0L, r.ac(Vm().bMO));
            closeActivity();
        } else {
            com.baidu.live.yuyingift.b.b.Vf().a(HR, HS, this.bLL.mUserId, this.bLL.mUserName, this.bLL.mLiveId, this.bLL.mRoomId, this.bLL.mAppId, this.bLL.baa, this.bLL.otherParams, 0L, System.currentTimeMillis(), r.ac(Vm().bMO));
        }
        String str = null;
        if (HR.aTv != null) {
            str = HR.aTv.Gj();
        }
        if (str == null) {
            str = "";
        }
        this.bLY.a(HR.Fs(), HR.aTp.aTB, this.bLL.mUserId, this.bLL.mLiveId, HS, HS > 1 ? 1 : 0, str, r.ac(Vm().bMO), System.currentTimeMillis());
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void Jp() {
        IY();
        this.bLY.hr("gift_panel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b
    public boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aTp) != null && i > bVar.aTC) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Jn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bdk >= 400) {
            this.bdk = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bLY != null) {
            this.bLY.release();
        }
    }

    private void IY() {
        if (this.bLY == null) {
            this.bLY = new com.baidu.live.yuyingift.c.c();
            this.bLY.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.d.1
                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && d.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    d.this.bLT.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = d.this.bLT.aXW) != null) {
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
                            d.this.bLT.a(false, z, i);
                        } else {
                            d.this.bLT.A(str2, i2);
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
