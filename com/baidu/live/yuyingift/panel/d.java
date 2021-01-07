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
/* loaded from: classes11.dex */
public class d extends b {
    private com.baidu.live.yuyingift.c.d cbf;
    private long cbg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.caX.setType(1);
        this.caX.IU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        initModel();
        this.cbf.hB("gift_panel");
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g Jc = this.caX.Jc();
        if (Jc == null) {
            return false;
        }
        initModel();
        int Jd = this.caX.Jd();
        if (!a(Jc, Jd) || e(Jc)) {
            return true;
        }
        if (Jc.GG()) {
            Jc.aXM = this.caY != null ? this.caY.IF() : null;
            if (Jc.aXM == null) {
                return false;
            }
            Jc.aXM.aYS = Jc.GC();
            com.baidu.live.yuyingift.b.b.aba().a(Jc, Jd, this.caO.mUserId, this.caO.mUserName, this.caO.mLiveId, this.caO.mRoomId, this.caO.mAppId, this.caO.beS, this.caO.otherParams, 0L, s.ak(abf().ccd), 0L, 0);
            closeActivity();
        } else {
            com.baidu.live.yuyingift.b.b.aba().a(Jc, Jd, this.caO.mUserId, this.caO.mUserName, this.caO.mLiveId, this.caO.mRoomId, this.caO.mAppId, this.caO.beS, this.caO.otherParams, 0L, System.currentTimeMillis(), s.ak(abf().ccd), 0L, 0);
        }
        String str = null;
        if (Jc.aXM != null) {
            str = Jc.aXM.Hr();
        }
        if (str == null) {
            str = "";
        }
        this.cbf.a(Jc.Gx(), Jc.aXF.aXT, this.caO.mUserId, this.caO.mLiveId, Jd, Jd > 1 ? 1 : 0, str, s.ak(abf().ccd), System.currentTimeMillis(), Jc.GA() ? 1 : 0, j);
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void KH() {
        initModel();
        this.cbf.hB("gift_panel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b
    public boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aXF) != null && i > bVar.aXU) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean abi() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cbg >= 400) {
            this.cbg = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cbf != null) {
            this.cbf.release();
        }
    }

    private void initModel() {
        if (this.cbf == null) {
            this.cbf = new com.baidu.live.yuyingift.c.d();
            this.cbf.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.d.1
                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && d.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    d.this.caX.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = d.this.caX.bcC) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> Hb = it.next().Hb();
                            if (Hb != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = Hb.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().Gx().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : Hb) {
                                        if (gVar.Gx().equals(str2)) {
                                            gVar.aXF.aXU = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            d.this.caX.b(false, z, i);
                        } else {
                            d.this.caX.D(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aXF;
        if (bVar == null || (aVar = bVar.aXX) == null) {
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
        if (bVar.aXX.aXY != null && bVar.aXX.aXY.optInt("price") == 100 && (bqVar = com.baidu.live.af.a.SE().bCb) != null && bqVar.aRE != null && bqVar.aRE.aUd && bqVar.aRB != null && (ckVarArr = bqVar.aRB.aTb) != null && ckVarArr.length > 0) {
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
        if (gVar != null && (bVar = gVar.aXF) != null && bVar.aXX != null && bVar.aXX.aXY != null) {
            String optString = bVar.aXX.aXY.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.Gx();
                nobleDetailInfo.expDuration = bVar.aXX.aXY.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aXV;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            }
        }
    }
}
