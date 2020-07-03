package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bb;
import com.baidu.live.data.bo;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends c {
    private com.baidu.live.gift.c.a aPy;
    private long aPz;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aPp.setType(1);
        this.aPp.zN();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        Bc();
        this.aPy.fp("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Bs() {
        g zV = this.aPp.zV();
        if (zV == null) {
            return false;
        }
        Bc();
        int zW = this.aPp.zW();
        if (!a(zV, zW) || e(zV)) {
            return true;
        }
        if (zV.xT()) {
            zV.aGM = this.aPq != null ? this.aPq.zx() : null;
            if (zV.aGM == null) {
                return false;
            }
            zV.aGM.aHN = zV.xQ();
            com.baidu.live.gift.b.b.AH().a(zV, zW, this.aPc.mUserId, this.aPc.mUserName, this.aPc.mLiveId, this.aPc.mRoomId, this.aPc.mAppId, this.aPc.aMu, this.aPc.otherParams, 0L);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.AH().a(zV, zW, this.aPc.mUserId, this.aPc.mUserName, this.aPc.mLiveId, this.aPc.mRoomId, this.aPc.mAppId, this.aPc.aMu, this.aPc.otherParams, 0L, System.currentTimeMillis());
        }
        String str = null;
        if (zV.aGM != null) {
            str = zV.aGM.yC();
        }
        if (str == null) {
            str = "";
        }
        this.aPy.d(zV.xM(), zV.aGH.aGN, this.aPc.mUserId, this.aPc.mLiveId, zW, zW > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Bt() {
        Bc();
        this.aPy.fp("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.aGH) != null && i > aVar.aGO) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Br() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aPz >= 400) {
            this.aPz = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aPy != null) {
            this.aPy.release();
        }
    }

    private void Bc() {
        if (this.aPy == null) {
            this.aPy = new com.baidu.live.gift.c.a();
            this.aPy.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.aPp.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.aPp.aKC) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> ym = it.next().ym();
                            if (ym != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = ym.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().xM().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : ym) {
                                        if (gVar.xM().equals(str2)) {
                                            gVar.aGH.aGO = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.aPp.a(false, z, i);
                        } else {
                            e.this.aPp.z(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0166a c0166a;
        g.a aVar = gVar.aGH;
        if (aVar == null || (c0166a = aVar.aGR) == null || c0166a.key != 10) {
            return false;
        }
        if (c0166a.aGT != null && c0166a.aGT.optInt("price") == 100) {
            Bw();
        }
        return true;
    }

    private void Bw() {
        bo[] boVarArr;
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar != null && bbVar.aCW != null && bbVar.aCW.aEJ && bbVar.aCT != null && (boVarArr = bbVar.aCT.aDN) != null && boVarArr.length > 0) {
            for (int i = 0; i < boVarArr.length; i++) {
                if (boVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, boVarArr[i].id));
                    return;
                }
            }
        }
    }
}
