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
    private com.baidu.live.gift.c.a beE;
    private long beF;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bev.setType(1);
        this.bev.Ik();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        Jz();
        this.beE.hy("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean JP() {
        g Is = this.bev.Is();
        if (Is == null) {
            return false;
        }
        Jz();
        int It = this.bev.It();
        if (!a(Is, It) || e(Is)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Is.Ga()) {
            Is.aUN = this.bew != null ? this.bew.HV() : null;
            if (Is.aUN == null) {
                return false;
            }
            Is.aUN.aVT = Is.FX();
            com.baidu.live.gift.b.b.Je().a(Is, It, this.bef.mUserId, this.bef.mUserName, this.bef.mLiveId, this.bef.mRoomId, this.bef.mAppId, this.bef.bbt, this.bef.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.Je().a(Is, It, this.bef.mUserId, this.bef.mUserName, this.bef.mLiveId, this.bef.mRoomId, this.bef.mAppId, this.bef.bbt, this.bef.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Is.aUN != null) {
            str = Is.aUN.GK();
        }
        if (str == null) {
            str = "";
        }
        this.beE.a(Is.FT(), Is.FU(), Is.aUI.aUU, this.bef.mUserId, this.bef.mLiveId, It, It > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void JQ() {
        Jz();
        this.beE.hy("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aUI) != null && i > bVar.aUV) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean JO() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.beF >= 1000) {
            this.beF = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.beE != null) {
            this.beE.release();
        }
    }

    private void Jz() {
        if (this.beE == null) {
            this.beE = new com.baidu.live.gift.c.a();
            this.beE.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bev.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.bev.aZo) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> Gu = it.next().Gu();
                            if (Gu != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = Gu.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().FT().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : Gu) {
                                        if (gVar.FT().equals(str2)) {
                                            gVar.aUI.aUV = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.bev.a(false, z, i);
                        } else {
                            e.this.bev.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aUI;
        if (bVar == null || (aVar = bVar.aUY) == null) {
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
        if (bVar.aUY.aUZ != null && bVar.aUY.aUZ.optInt("price") == 100 && (bnVar = com.baidu.live.aa.a.PQ().btT) != null && bnVar.aPA != null && bnVar.aPA.aRO && bnVar.aPx != null && (cgVarArr = bnVar.aPx.aQP) != null && cgVarArr.length > 0) {
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
        if (gVar != null && (bVar = gVar.aUI) != null && bVar.aUY != null && bVar.aUY.aUZ != null) {
            String optString = bVar.aUY.aUZ.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.FT();
                nobleDetailInfo.expDuration = bVar.aUY.aUZ.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aUW;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
        }
    }
}
