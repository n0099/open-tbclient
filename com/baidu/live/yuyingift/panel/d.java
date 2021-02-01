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
/* loaded from: classes11.dex */
public class d extends b {
    private com.baidu.live.yuyingift.c.d cav;
    private long caw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.can.setType(1);
        this.can.Gp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        initModel();
        this.cav.gN("gift_panel");
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g Gx = this.can.Gx();
        if (Gx == null) {
            return false;
        }
        initModel();
        int Gy = this.can.Gy();
        if (!a(Gx, Gy) || e(Gx)) {
            return true;
        }
        if (!a(Zc())) {
            return false;
        }
        if (Gx.Eb()) {
            Gx.aWe = this.cao != null ? this.cao.Ga() : null;
            if (Gx.aWe == null) {
                return false;
            }
            Gx.aWe.aXk = Gx.DX();
            com.baidu.live.yuyingift.b.b.YX().a(Gx, Gy, this.cae.mUserId, this.cae.mUserName, this.cae.mLiveId, this.cae.mRoomId, this.cae.mAppId, this.cae.bdj, this.cae.otherParams, 0L, s.al(Zc().cbt), 0L, 0);
            closeActivity();
        } else {
            com.baidu.live.yuyingift.b.b.YX().a(Gx, Gy, this.cae.mUserId, this.cae.mUserName, this.cae.mLiveId, this.cae.mRoomId, this.cae.mAppId, this.cae.bdj, this.cae.otherParams, 0L, System.currentTimeMillis(), s.al(Zc().cbt), 0L, 0);
        }
        String str = null;
        if (Gx.aWe != null) {
            str = Gx.aWe.EM();
        }
        if (str == null) {
            str = "";
        }
        this.cav.a(Gx.DR(), Gx.aVX.aWl, this.cae.mUserId, this.cae.mLiveId, Gy, Gy > 1 ? 1 : 0, str, s.al(Zc().cbt), System.currentTimeMillis(), Gx.DV() ? 1 : 0, j);
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void Ic() {
        initModel();
        this.cav.gN("gift_panel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b
    public boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aVX) != null && i > bVar.aWm) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Zf() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.caw >= 400) {
            this.caw = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cav != null) {
            this.cav.release();
        }
    }

    private void initModel() {
        if (this.cav == null) {
            this.cav = new com.baidu.live.yuyingift.c.d();
            this.cav.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.d.1
                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && d.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    d.this.can.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = d.this.can.baV) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> Ew = it.next().Ew();
                            if (Ew != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = Ew.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().DR().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : Ew) {
                                        if (gVar.DR().equals(str2)) {
                                            gVar.aVX.aWm = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            d.this.can.b(false, z, i);
                        } else {
                            d.this.can.E(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aVX;
        if (bVar == null || (aVar = bVar.aWp) == null) {
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
        if (bVar.aWp.aWq != null && bVar.aWp.aWq.optInt("price") == 100 && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && bvVar.aPP != null && bvVar.aPP.aSs && bvVar.aPM != null && (crVarArr = bvVar.aPM.aRr) != null && crVarArr.length > 0) {
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
        if (gVar != null && (bVar = gVar.aVX) != null && bVar.aWp != null && bVar.aWp.aWq != null) {
            String optString = bVar.aWp.aWq.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.DR();
                nobleDetailInfo.expDuration = bVar.aWp.aWq.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aWn;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            }
        }
    }
}
