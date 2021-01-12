package com.baidu.live.yuyingift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bq;
import com.baidu.live.data.ck;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class d extends b {
    private com.baidu.live.yuyingift.c.d bWt;
    private long bWu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bWl.setType(1);
        this.bWl.EZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        initModel();
        this.bWt.gp("gift_panel");
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g Fh = this.bWl.Fh();
        if (Fh == null) {
            return false;
        }
        initModel();
        int Fi = this.bWl.Fi();
        if (!a(Fh, Fi) || e(Fh)) {
            return true;
        }
        if (Fh.CL()) {
            Fh.aSZ = this.bWm != null ? this.bWm.EK() : null;
            if (Fh.aSZ == null) {
                return false;
            }
            Fh.aSZ.aUf = Fh.CH();
            com.baidu.live.yuyingift.b.b.Xh().a(Fh, Fi, this.bWc.mUserId, this.bWc.mUserName, this.bWc.mLiveId, this.bWc.mRoomId, this.bWc.mAppId, this.bWc.bac, this.bWc.otherParams, 0L, s.ak(Xm().bXq), 0L, 0);
            closeActivity();
        } else {
            com.baidu.live.yuyingift.b.b.Xh().a(Fh, Fi, this.bWc.mUserId, this.bWc.mUserName, this.bWc.mLiveId, this.bWc.mRoomId, this.bWc.mAppId, this.bWc.bac, this.bWc.otherParams, 0L, System.currentTimeMillis(), s.ak(Xm().bXq), 0L, 0);
        }
        String str = null;
        if (Fh.aSZ != null) {
            str = Fh.aSZ.Dw();
        }
        if (str == null) {
            str = "";
        }
        this.bWt.a(Fh.CC(), Fh.aSS.aTg, this.bWc.mUserId, this.bWc.mLiveId, Fi, Fi > 1 ? 1 : 0, str, s.ak(Xm().bXq), System.currentTimeMillis(), Fh.CF() ? 1 : 0, j);
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void GM() {
        initModel();
        this.bWt.gp("gift_panel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b
    public boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aSS) != null && i > bVar.aTh) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Xp() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bWu >= 400) {
            this.bWu = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bWt != null) {
            this.bWt.release();
        }
    }

    private void initModel() {
        if (this.bWt == null) {
            this.bWt = new com.baidu.live.yuyingift.c.d();
            this.bWt.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.d.1
                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && d.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    d.this.bWl.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = d.this.bWl.aXO) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> Dg = it.next().Dg();
                            if (Dg != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = Dg.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().CC().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : Dg) {
                                        if (gVar.CC().equals(str2)) {
                                            gVar.aSS.aTh = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            d.this.bWl.b(false, z, i);
                        } else {
                            d.this.bWl.D(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aSS;
        if (bVar == null || (aVar = bVar.aTk) == null) {
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
        bq bqVar;
        ck[] ckVarArr;
        if (bVar.aTk.aTl != null && bVar.aTk.aTl.optInt("price") == 100 && (bqVar = com.baidu.live.af.a.OJ().bxp) != null && bqVar.aMR != null && bqVar.aMR.aPq && bqVar.aMO != null && (ckVarArr = bqVar.aMO.aOo) != null && ckVarArr.length > 0) {
            for (ck ckVar : ckVarArr) {
                if (ckVar.price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, ckVar.id));
                    return;
                }
            }
        }
    }

    private void f(g gVar) {
        g.b bVar;
        if (gVar != null && (bVar = gVar.aSS) != null && bVar.aTk != null && bVar.aTk.aTl != null) {
            String optString = bVar.aTk.aTl.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.CC();
                nobleDetailInfo.expDuration = bVar.aTk.aTl.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aTi;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            }
        }
    }
}
