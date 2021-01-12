package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bq;
import com.baidu.live.data.ck;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.b.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class e extends c {
    private com.baidu.live.gift.d.a bdH;
    private com.baidu.live.gift.b.c bdI;

    public boolean gt(String str) {
        GiftPanelPackageFragmentView FU;
        if (this.bdI == null || (FU = this.bdI.FU()) == null || FU.getVisibility() != 0) {
            return false;
        }
        this.bdI.gj(str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bdy.setType(1);
        this.bdy.EZ();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        initModel();
        this.bdH.gp("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean GL() {
        g Fh = this.bdy.Fh();
        if (Fh == null) {
            return false;
        }
        initModel();
        int Fi = this.bdy.Fi();
        if (!a(Fh, Fi)) {
            return false;
        }
        if (e(Fh) || g(Fh)) {
            return true;
        }
        F(Fh.CC(), Fh.aSS.aTh - Fi);
        long currentTimeMillis = System.currentTimeMillis();
        if (Fh.CL()) {
            Fh.aSZ = this.bdz != null ? this.bdz.EK() : null;
            if (Fh.aSZ == null) {
                return false;
            }
            Fh.aSZ.aUf = Fh.CH();
            com.baidu.live.gift.c.b.Gb().a(Fh, Fi, this.bdm.mUserId, this.bdm.mUserName, this.bdm.mLiveId, this.bdm.mRoomId, this.bdm.mAppId, this.bdm.bac, this.bdm.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.c.b.Gb().a(Fh, Fi, this.bdm.mUserId, this.bdm.mUserName, this.bdm.mLiveId, this.bdm.mRoomId, this.bdm.mAppId, this.bdm.bac, this.bdm.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Fh.aSZ != null) {
            str = Fh.aSZ.Dw();
        }
        if (str == null) {
            str = "";
        }
        ac.b(Fh.CC(), Fh.aSS.aTg, this.bdm.mUserId, this.bdm.mLiveId, Fi, Fi > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void GM() {
        initModel();
        this.bdH.gp("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if ((gVar instanceof aa) && ((aa) gVar).DU()) {
            return true;
        }
        if (!a2 || (bVar = gVar.aSS) == null || i <= bVar.aTh) {
            return a2;
        }
        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bdH != null) {
            this.bdH.release();
        }
        if (this.bdI != null) {
            this.bdI.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initModel() {
        if (this.bdH == null) {
            this.bdH = new com.baidu.live.gift.d.a();
            this.bdH.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, List<k> list, int i2) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3, list, i2);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bdy.a(true, arrayList, arrayList2, arrayList3, z, i);
                    if (e.this.bbz != null) {
                        e.this.bbz.cP(com.baidu.live.d.xf().getInt("gift_package_list_flag", 0));
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    super.a(z, i, str, str2, i2);
                    if (z && ListUtils.isEmpty(com.baidu.live.gift.c.b.Gb().bbT)) {
                        e.this.F(str2, i2);
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void b(boolean z, String str, String str2, String str3, String str4, int i) {
                    super.b(z, str, str2, str3, str4, i);
                    if (z) {
                        e.this.initModel();
                        e.this.bdH.gp("gift_panel");
                    }
                    if (e.this.bdI != null) {
                        e.this.bdI.a(z, str, str2, str3, str4, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, int i) {
        ArrayList<h> arrayList;
        if (this.bdy != null && !TextUtils.isEmpty(str) && (arrayList = this.bdy.aXO) != null) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                List<g> Dg = it.next().Dg();
                if (Dg != null) {
                    if (i == 0) {
                        Iterator<g> it2 = Dg.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().CC().equals(str)) {
                                it2.remove();
                            }
                        }
                    } else {
                        for (g gVar : Dg) {
                            if (gVar.CC().equals(str)) {
                                gVar.aSS.aTh = i;
                            }
                        }
                    }
                }
            }
            if (i == 0) {
                this.bdy.a(true, new ArrayList<>(this.bdy.aXO), new ArrayList<>(this.bdy.aXP), new ArrayList<>(this.bdy.aXQ), true, 0);
            } else {
                this.bdy.D(str, i);
            }
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
            case 12:
                b(bVar);
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
        }
    }

    private void b(g.b bVar) {
        if (bVar.aTk != null && bVar.aTk.aTl != null) {
            String optString = bVar.aTk.aTl.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                if (this.bdm != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("live_id", this.bdm.mLiveId);
                    hashMap.put("room_id", this.bdm.mRoomId);
                    hashMap.put("scene_from", q.Ef());
                    hashMap.put("platform", "2");
                    hashMap.put("subapp_type", TbConfig.getSubappType());
                    hashMap.put(HttpRequest.SUBAPP_VERSION, Integer.valueOf(TbConfig.getSubappVersionCode()));
                    hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
                    hashMap.put("net_type", String.valueOf(BdNetTypeUtil.netType()));
                    hashMap.put("_client_type", "2");
                    optString = WebviewHelper.addQueryParams(optString, hashMap);
                }
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.url = optString;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
            }
        }
    }

    private boolean g(g gVar) {
        if ((gVar instanceof aa) && ((aa) gVar).DU()) {
            if (this.bdI == null) {
                this.bdI = new com.baidu.live.gift.b.c(this.mPageContext.getPageActivity());
                this.bdI.b(this.bbz);
                this.bdI.a(new c.a() { // from class: com.baidu.live.gift.panel.e.2
                    @Override // com.baidu.live.gift.b.c.a
                    public void onBack(String str) {
                        GiftPanelPackageFragmentView FU = e.this.bdI.FU();
                        if (FU != null) {
                            FU.reset();
                            FU.setVisibility(8);
                        }
                        if (e.this.bdy != null) {
                            e.this.bdy.bJ(true);
                            if (!TextUtils.isEmpty(str)) {
                                e.this.bdy.cW(Integer.parseInt(str));
                            }
                        }
                    }

                    @Override // com.baidu.live.gift.b.c.a
                    public void c(String str, String str2, int i, String str3) {
                        e.this.initModel();
                        e.this.bdH.b(e.this.bdm != null ? e.this.bdm.mLiveId : "", str, str2, i, str3);
                    }
                });
            }
            GiftPanelPackageFragmentView FU = this.bdI.FU();
            if ((this.bdy.getRootView() instanceof ViewGroup) && ((ViewGroup) this.bdy.getRootView()).indexOfChild(FU) < 0) {
                ((ViewGroup) this.bdy.getRootView()).addView(FU, new ViewGroup.LayoutParams(-1, -1));
            }
            FU.setVisibility(0);
            FU.setData((aa) gVar);
            if (this.bdy != null) {
                this.bdy.bJ(false);
            }
            if (this.bbz != null) {
                this.bbz.g("", "", true);
            }
            return true;
        }
        return false;
    }
}
