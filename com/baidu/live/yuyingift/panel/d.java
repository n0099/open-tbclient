package com.baidu.live.yuyingift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bo;
import com.baidu.live.data.ci;
import com.baidu.live.data.j;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends b {
    private com.baidu.live.yuyingift.c.c bVg;
    private long bgS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bVb.setType(1);
        this.bVb.Js();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        KR();
        this.bVg.hQ("gift_panel");
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Lh() {
        g JA = this.bVb.JA();
        if (JA == null) {
            return false;
        }
        KR();
        int JB = this.bVb.JB();
        if (!a(JA, JB) || e(JA)) {
            return true;
        }
        if (JA.Hf()) {
            JA.aWg = this.bVc != null ? this.bVc.Jd() : null;
            if (JA.aWg == null) {
                return false;
            }
            JA.aWg.aXn = JA.Hb();
            com.baidu.live.yuyingift.b.b.Zu().a(JA, JB, this.bUT.mUserId, this.bUT.mUserName, this.bUT.mLiveId, this.bUT.mRoomId, this.bUT.mAppId, this.bUT.bdh, this.bUT.otherParams, 0L, r.aj(ZB().bVX));
            closeActivity();
        } else {
            com.baidu.live.yuyingift.b.b.Zu().a(JA, JB, this.bUT.mUserId, this.bUT.mUserName, this.bUT.mLiveId, this.bUT.mRoomId, this.bUT.mAppId, this.bUT.bdh, this.bUT.otherParams, 0L, System.currentTimeMillis(), r.aj(ZB().bVX));
        }
        String str = null;
        if (JA.aWg != null) {
            str = JA.aWg.HQ();
        }
        if (str == null) {
            str = "";
        }
        this.bVg.a(JA.GX(), JA.aVZ.aWn, this.bUT.mUserId, this.bUT.mLiveId, JB, JB > 1 ? 1 : 0, str, r.aj(ZB().bVX), System.currentTimeMillis());
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void Li() {
        KR();
        this.bVg.hQ("gift_panel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b
    public boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aVZ) != null && i > bVar.aWo) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Lg() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bgS >= 400) {
            this.bgS = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bVg != null) {
            this.bVg.release();
        }
    }

    private void KR() {
        if (this.bVg == null) {
            this.bVg = new com.baidu.live.yuyingift.c.c();
            this.bVg.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.d.1
                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && d.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    d.this.bVb.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = d.this.bVb.baV) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> HA = it.next().HA();
                            if (HA != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = HA.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().GX().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : HA) {
                                        if (gVar.GX().equals(str2)) {
                                            gVar.aVZ.aWo = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            d.this.bVb.a(false, z, i);
                        } else {
                            d.this.bVb.C(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aVZ;
        if (bVar == null || (aVar = bVar.aWr) == null) {
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
        bo boVar;
        ci[] ciVarArr;
        if (bVar.aWr.aWs != null && bVar.aWr.aWs.optInt("price") == 100 && (boVar = com.baidu.live.ae.a.RB().bxq) != null && boVar.aQP != null && boVar.aQP.aTf && boVar.aQM != null && (ciVarArr = boVar.aQM.aSg) != null && ciVarArr.length > 0) {
            for (ci ciVar : ciVarArr) {
                if (ciVar.price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, ciVar.id));
                    return;
                }
            }
        }
    }

    private void f(g gVar) {
        g.b bVar;
        if (gVar != null && (bVar = gVar.aVZ) != null && bVar.aWr != null && bVar.aWr.aWs != null) {
            String optString = bVar.aWr.aWs.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.GX();
                nobleDetailInfo.expDuration = bVar.aWr.aWs.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aWp;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            }
        }
    }
}
