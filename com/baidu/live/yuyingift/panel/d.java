package com.baidu.live.yuyingift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bv;
import com.baidu.live.data.cr;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
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
    private com.baidu.live.yuyingift.c.d cbW;
    private long cbX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.cbO.setType(1);
        this.cbO.Gs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        initModel();
        this.cbW.gT("gift_panel");
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g GA = this.cbO.GA();
        if (GA == null) {
            return false;
        }
        initModel();
        int GB = this.cbO.GB();
        if (!a(GA, GB) || e(GA)) {
            return true;
        }
        if (!a(Zf())) {
            return false;
        }
        if (GA.Ee()) {
            GA.aXE = this.cbP != null ? this.cbP.Gd() : null;
            if (GA.aXE == null) {
                return false;
            }
            GA.aXE.aYK = GA.Ea();
            com.baidu.live.yuyingift.b.b.Za().a(GA, GB, this.cbF.mUserId, this.cbF.mUserName, this.cbF.mLiveId, this.cbF.mRoomId, this.cbF.mAppId, this.cbF.beL, this.cbF.otherParams, 0L, s.al(Zf().ccU), 0L, 0);
            closeActivity();
        } else {
            com.baidu.live.yuyingift.b.b.Za().a(GA, GB, this.cbF.mUserId, this.cbF.mUserName, this.cbF.mLiveId, this.cbF.mRoomId, this.cbF.mAppId, this.cbF.beL, this.cbF.otherParams, 0L, System.currentTimeMillis(), s.al(Zf().ccU), 0L, 0);
        }
        String str = null;
        if (GA.aXE != null) {
            str = GA.aXE.EP();
        }
        if (str == null) {
            str = "";
        }
        this.cbW.a(GA.DU(), GA.aXx.aXL, this.cbF.mUserId, this.cbF.mLiveId, GB, GB > 1 ? 1 : 0, str, s.al(Zf().ccU), System.currentTimeMillis(), GA.DY() ? 1 : 0, j);
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void If() {
        initModel();
        this.cbW.gT("gift_panel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b
    public boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aXx) != null && i > bVar.aXM) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Zi() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cbX >= 400) {
            this.cbX = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cbW != null) {
            this.cbW.release();
        }
    }

    private void initModel() {
        if (this.cbW == null) {
            this.cbW = new com.baidu.live.yuyingift.c.d();
            this.cbW.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.d.1
                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && d.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    d.this.cbO.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = d.this.cbO.bcv) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> Ez = it.next().Ez();
                            if (Ez != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = Ez.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().DU().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : Ez) {
                                        if (gVar.DU().equals(str2)) {
                                            gVar.aXx.aXM = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            d.this.cbO.b(false, z, i);
                        } else {
                            d.this.cbO.E(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aXx;
        if (bVar == null || (aVar = bVar.aXP) == null) {
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
        bv bvVar;
        cr[] crVarArr;
        if (bVar.aXP.aXQ != null && bVar.aXP.aXQ.optInt("price") == 100 && (bvVar = com.baidu.live.ae.a.Qm().bCs) != null && bvVar.aRp != null && bvVar.aRp.aTS && bvVar.aRm != null && (crVarArr = bvVar.aRm.aSR) != null && crVarArr.length > 0) {
            for (cr crVar : crVarArr) {
                if (crVar.price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, crVar.id));
                    return;
                }
            }
        }
    }

    private void f(g gVar) {
        g.b bVar;
        if (gVar != null && (bVar = gVar.aXx) != null && bVar.aXP != null && bVar.aXP.aXQ != null) {
            String optString = bVar.aXP.aXQ.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.DU();
                nobleDetailInfo.expDuration = bVar.aXP.aXQ.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aXN;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            }
        }
    }
}
