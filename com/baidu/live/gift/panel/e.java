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
/* loaded from: classes11.dex */
public class e extends c {
    private com.baidu.live.gift.d.a biA;
    private com.baidu.live.gift.b.c biB;

    public boolean hE(String str) {
        GiftPanelPackageFragmentView JP;
        if (this.biB == null || (JP = this.biB.JP()) == null || JP.getVisibility() != 0) {
            return false;
        }
        this.biB.hv(str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bir.setType(1);
        this.bir.IU();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        initModel();
        this.biA.hB("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean KG() {
        g Jc = this.bir.Jc();
        if (Jc == null) {
            return false;
        }
        initModel();
        int Jd = this.bir.Jd();
        if (!a(Jc, Jd)) {
            return false;
        }
        if (e(Jc) || g(Jc)) {
            return true;
        }
        F(Jc.Gx(), Jc.aXF.aXU - Jd);
        long currentTimeMillis = System.currentTimeMillis();
        if (Jc.GG()) {
            Jc.aXM = this.bis != null ? this.bis.IF() : null;
            if (Jc.aXM == null) {
                return false;
            }
            Jc.aXM.aYS = Jc.GC();
            com.baidu.live.gift.c.b.JW().a(Jc, Jd, this.bie.mUserId, this.bie.mUserName, this.bie.mLiveId, this.bie.mRoomId, this.bie.mAppId, this.bie.beS, this.bie.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.c.b.JW().a(Jc, Jd, this.bie.mUserId, this.bie.mUserName, this.bie.mLiveId, this.bie.mRoomId, this.bie.mAppId, this.bie.beS, this.bie.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Jc.aXM != null) {
            str = Jc.aXM.Hr();
        }
        if (str == null) {
            str = "";
        }
        ac.b(Jc.Gx(), Jc.aXF.aXT, this.bie.mUserId, this.bie.mLiveId, Jd, Jd > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void KH() {
        initModel();
        this.biA.hB("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if ((gVar instanceof aa) && ((aa) gVar).HP()) {
            return true;
        }
        if (!a2 || (bVar = gVar.aXF) == null || i <= bVar.aXU) {
            return a2;
        }
        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.biA != null) {
            this.biA.release();
        }
        if (this.biB != null) {
            this.biB.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initModel() {
        if (this.biA == null) {
            this.biA = new com.baidu.live.gift.d.a();
            this.biA.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, List<k> list, int i2) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3, list, i2);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bir.a(true, arrayList, arrayList2, arrayList3, z, i);
                    if (e.this.bgp != null) {
                        e.this.bgp.ev(com.baidu.live.d.Ba().getInt("gift_package_list_flag", 0));
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    super.a(z, i, str, str2, i2);
                    if (z && ListUtils.isEmpty(com.baidu.live.gift.c.b.JW().bgK)) {
                        e.this.F(str2, i2);
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void b(boolean z, String str, String str2, String str3, String str4, int i) {
                    super.b(z, str, str2, str3, str4, i);
                    if (z) {
                        e.this.initModel();
                        e.this.biA.hB("gift_panel");
                    }
                    if (e.this.biB != null) {
                        e.this.biB.a(z, str, str2, str3, str4, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, int i) {
        ArrayList<h> arrayList;
        if (this.bir != null && !TextUtils.isEmpty(str) && (arrayList = this.bir.bcC) != null) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                List<g> Hb = it.next().Hb();
                if (Hb != null) {
                    if (i == 0) {
                        Iterator<g> it2 = Hb.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().Gx().equals(str)) {
                                it2.remove();
                            }
                        }
                    } else {
                        for (g gVar : Hb) {
                            if (gVar.Gx().equals(str)) {
                                gVar.aXF.aXU = i;
                            }
                        }
                    }
                }
            }
            if (i == 0) {
                this.bir.a(true, new ArrayList<>(this.bir.bcC), new ArrayList<>(this.bir.bcD), new ArrayList<>(this.bir.bcE), true, 0);
            } else {
                this.bir.D(str, i);
            }
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
        }
    }

    private void b(g.b bVar) {
        if (bVar.aXX != null && bVar.aXX.aXY != null) {
            String optString = bVar.aXX.aXY.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                if (this.bie != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("live_id", this.bie.mLiveId);
                    hashMap.put("room_id", this.bie.mRoomId);
                    hashMap.put("scene_from", q.Ia());
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
        if ((gVar instanceof aa) && ((aa) gVar).HP()) {
            if (this.biB == null) {
                this.biB = new com.baidu.live.gift.b.c(this.mPageContext.getPageActivity());
                this.biB.b(this.bgp);
                this.biB.a(new c.a() { // from class: com.baidu.live.gift.panel.e.2
                    @Override // com.baidu.live.gift.b.c.a
                    public void onBack(String str) {
                        GiftPanelPackageFragmentView JP = e.this.biB.JP();
                        if (JP != null) {
                            JP.reset();
                            JP.setVisibility(8);
                        }
                        if (e.this.bir != null) {
                            e.this.bir.bN(true);
                            if (!TextUtils.isEmpty(str)) {
                                e.this.bir.eC(Integer.parseInt(str));
                            }
                        }
                    }

                    @Override // com.baidu.live.gift.b.c.a
                    public void c(String str, String str2, int i, String str3) {
                        e.this.initModel();
                        e.this.biA.b(e.this.bie != null ? e.this.bie.mLiveId : "", str, str2, i, str3);
                    }
                });
            }
            GiftPanelPackageFragmentView JP = this.biB.JP();
            if ((this.bir.getRootView() instanceof ViewGroup) && ((ViewGroup) this.bir.getRootView()).indexOfChild(JP) < 0) {
                ((ViewGroup) this.bir.getRootView()).addView(JP, new ViewGroup.LayoutParams(-1, -1));
            }
            JP.setVisibility(0);
            JP.setData((aa) gVar);
            if (this.bir != null) {
                this.bir.bN(false);
            }
            if (this.bgp != null) {
                this.bgp.g("", "", true);
            }
            return true;
        }
        return false;
    }
}
