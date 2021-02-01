package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bv;
import com.baidu.live.data.cr;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
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
/* loaded from: classes11.dex */
public class e extends c {
    private com.baidu.live.gift.d.a bgR;
    private com.baidu.live.gift.b.c bgS;

    public boolean gQ(String str) {
        GiftPanelPackageFragmentView Hk;
        if (this.bgS == null || (Hk = this.bgS.Hk()) == null || Hk.getVisibility() != 0) {
            return false;
        }
        this.bgS.gH(str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bgI.setType(1);
        this.bgI.Gp();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        initModel();
        this.bgR.gN("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Ib() {
        g Gx = this.bgI.Gx();
        if (Gx == null) {
            return false;
        }
        initModel();
        int Gy = this.bgI.Gy();
        if (!a(Gx, Gy)) {
            return false;
        }
        if (e(Gx) || g(Gx)) {
            return true;
        }
        G(Gx.DR(), Gx.aVX.aWm - Gy);
        long currentTimeMillis = System.currentTimeMillis();
        if (Gx.Eb()) {
            Gx.aWe = this.bgJ != null ? this.bgJ.Ga() : null;
            if (Gx.aWe == null) {
                return false;
            }
            Gx.aWe.aXk = Gx.DX();
            com.baidu.live.gift.c.b.Hr().a(Gx, Gy, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdj, this.bgw.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.c.b.Hr().a(Gx, Gy, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdj, this.bgw.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Gx.aWe != null) {
            str = Gx.aWe.EM();
        }
        if (str == null) {
            str = "";
        }
        ac.b(Gx.DR(), Gx.aVX.aWl, this.bgw.mUserId, this.bgw.mLiveId, Gy, Gy > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Ic() {
        initModel();
        this.bgR.gN("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if ((gVar instanceof aa) && ((aa) gVar).Fk()) {
            return true;
        }
        if (!a2 || (bVar = gVar.aVX) == null || i <= bVar.aWm) {
            return a2;
        }
        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bgR != null) {
            this.bgR.release();
        }
        if (this.bgS != null) {
            this.bgS.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initModel() {
        if (this.bgR == null) {
            this.bgR = new com.baidu.live.gift.d.a();
            this.bgR.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, List<l> list, int i2) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3, list, i2);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bgI.a(true, arrayList, arrayList2, arrayList3, z, i);
                    if (e.this.beG != null) {
                        e.this.beG.cU(com.baidu.live.d.xc().getInt("gift_package_list_flag", 0));
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    super.a(z, i, str, str2, i2);
                    if (z && ListUtils.isEmpty(com.baidu.live.gift.c.b.Hr().bfa)) {
                        e.this.G(str2, i2);
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void b(boolean z, String str, String str2, String str3, String str4, int i) {
                    super.b(z, str, str2, str3, str4, i);
                    if (z) {
                        e.this.initModel();
                        e.this.bgR.gN("gift_panel");
                    }
                    if (e.this.bgS != null) {
                        e.this.bgS.a(z, str, str2, str3, str4, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, int i) {
        ArrayList<h> arrayList;
        if (this.bgI != null && !TextUtils.isEmpty(str) && (arrayList = this.bgI.baV) != null) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                List<g> Ew = it.next().Ew();
                if (Ew != null) {
                    if (i == 0) {
                        Iterator<g> it2 = Ew.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().DR().equals(str)) {
                                it2.remove();
                            }
                        }
                    } else {
                        for (g gVar : Ew) {
                            if (gVar.DR().equals(str)) {
                                gVar.aVX.aWm = i;
                            }
                        }
                    }
                }
            }
            if (i == 0) {
                this.bgI.a(true, new ArrayList<>(this.bgI.baV), new ArrayList<>(this.bgI.baW), new ArrayList<>(this.bgI.baX), true, 0);
            } else {
                this.bgI.E(str, i);
            }
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
            case 12:
                b(bVar);
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
        }
    }

    private void b(g.b bVar) {
        if (bVar.aWp != null && bVar.aWp.aWq != null) {
            String optString = bVar.aWp.aWq.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                if (this.bgw != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("live_id", this.bgw.mLiveId);
                    hashMap.put("room_id", this.bgw.mRoomId);
                    hashMap.put("scene_from", q.Fv());
                    hashMap.put("platform", "2");
                    hashMap.put("subapp_type", TbConfig.getSubappType());
                    hashMap.put(HttpRequest.SUBAPP_VERSION, Integer.valueOf(TbConfig.getSubappVersionCode()));
                    hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
                    hashMap.put("net_type", String.valueOf(BdNetTypeUtil.netType()));
                    hashMap.put("_client_type", "2");
                    optString = WebviewHelper.addQueryParams(optString, hashMap);
                }
                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                cVar.url = optString;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
            }
        }
    }

    private boolean g(g gVar) {
        if ((gVar instanceof aa) && ((aa) gVar).Fk()) {
            if (this.bgS == null) {
                this.bgS = new com.baidu.live.gift.b.c(this.mPageContext.getPageActivity());
                this.bgS.b(this.beG);
                this.bgS.a(new c.a() { // from class: com.baidu.live.gift.panel.e.2
                    @Override // com.baidu.live.gift.b.c.a
                    public void onBack(String str) {
                        GiftPanelPackageFragmentView Hk = e.this.bgS.Hk();
                        if (Hk != null) {
                            Hk.reset();
                            Hk.setVisibility(8);
                        }
                        if (e.this.bgI != null) {
                            e.this.bgI.bO(true);
                            if (!TextUtils.isEmpty(str)) {
                                e.this.bgI.db(Integer.parseInt(str));
                            }
                        }
                    }

                    @Override // com.baidu.live.gift.b.c.a
                    public void c(String str, String str2, int i, String str3) {
                        e.this.initModel();
                        e.this.bgR.b(e.this.bgw != null ? e.this.bgw.mLiveId : "", str, str2, i, str3);
                    }
                });
            }
            GiftPanelPackageFragmentView Hk = this.bgS.Hk();
            if ((this.bgI.getRootView() instanceof ViewGroup) && ((ViewGroup) this.bgI.getRootView()).indexOfChild(Hk) < 0) {
                ((ViewGroup) this.bgI.getRootView()).addView(Hk, new ViewGroup.LayoutParams(-1, -1));
            }
            Hk.setVisibility(0);
            Hk.setData((aa) gVar);
            if (this.bgI != null) {
                this.bgI.bO(false);
            }
            if (this.beG != null) {
                this.beG.g("", "", true);
            }
            return true;
        }
        return false;
    }
}
