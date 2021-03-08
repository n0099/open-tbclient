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
/* loaded from: classes10.dex */
public class e extends c {
    private com.baidu.live.gift.d.a bit;
    private com.baidu.live.gift.b.c biu;

    public boolean gW(String str) {
        GiftPanelPackageFragmentView Hn;
        if (this.biu == null || (Hn = this.biu.Hn()) == null || Hn.getVisibility() != 0) {
            return false;
        }
        this.biu.gN(str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bik.setType(1);
        this.bik.Gs();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        initModel();
        this.bit.gT("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Ie() {
        g GA = this.bik.GA();
        if (GA == null) {
            return false;
        }
        initModel();
        int GB = this.bik.GB();
        if (!a(GA, GB)) {
            return false;
        }
        if (e(GA) || g(GA)) {
            return true;
        }
        G(GA.DU(), GA.aXx.aXM - GB);
        long currentTimeMillis = System.currentTimeMillis();
        if (GA.Ee()) {
            GA.aXE = this.bil != null ? this.bil.Gd() : null;
            if (GA.aXE == null) {
                return false;
            }
            GA.aXE.aYK = GA.Ea();
            com.baidu.live.gift.c.b.Hu().a(GA, GB, this.bhW.mUserId, this.bhW.mUserName, this.bhW.mLiveId, this.bhW.mRoomId, this.bhW.mAppId, this.bhW.beL, this.bhW.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.c.b.Hu().a(GA, GB, this.bhW.mUserId, this.bhW.mUserName, this.bhW.mLiveId, this.bhW.mRoomId, this.bhW.mAppId, this.bhW.beL, this.bhW.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (GA.aXE != null) {
            str = GA.aXE.EP();
        }
        if (str == null) {
            str = "";
        }
        ac.b(GA.DU(), GA.aXx.aXL, this.bhW.mUserId, this.bhW.mLiveId, GB, GB > 1 ? 1 : 0, str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void If() {
        initModel();
        this.bit.gT("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if ((gVar instanceof aa) && ((aa) gVar).Fn()) {
            return true;
        }
        if (!a2 || (bVar = gVar.aXx) == null || i <= bVar.aXM) {
            return a2;
        }
        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bit != null) {
            this.bit.release();
        }
        if (this.biu != null) {
            this.biu.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initModel() {
        if (this.bit == null) {
            this.bit = new com.baidu.live.gift.d.a();
            this.bit.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, List<l> list, int i2) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3, list, i2);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bik.a(true, arrayList, arrayList2, arrayList3, z, i);
                    if (e.this.bgi != null) {
                        e.this.bgi.cV(com.baidu.live.d.xf().getInt("gift_package_list_flag", 0));
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    super.a(z, i, str, str2, i2);
                    if (z && ListUtils.isEmpty(com.baidu.live.gift.c.b.Hu().bgD)) {
                        e.this.G(str2, i2);
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void b(boolean z, String str, String str2, String str3, String str4, int i) {
                    super.b(z, str, str2, str3, str4, i);
                    if (z) {
                        e.this.initModel();
                        e.this.bit.gT("gift_panel");
                    }
                    if (e.this.biu != null) {
                        e.this.biu.a(z, str, str2, str3, str4, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, int i) {
        ArrayList<h> arrayList;
        if (this.bik != null && !TextUtils.isEmpty(str) && (arrayList = this.bik.bcv) != null) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                List<g> Ez = it.next().Ez();
                if (Ez != null) {
                    if (i == 0) {
                        Iterator<g> it2 = Ez.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().DU().equals(str)) {
                                it2.remove();
                            }
                        }
                    } else {
                        for (g gVar : Ez) {
                            if (gVar.DU().equals(str)) {
                                gVar.aXx.aXM = i;
                            }
                        }
                    }
                }
            }
            if (i == 0) {
                this.bik.a(true, new ArrayList<>(this.bik.bcv), new ArrayList<>(this.bik.bcw), new ArrayList<>(this.bik.bcx), true, 0);
            } else {
                this.bik.E(str, i);
            }
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
        }
    }

    private void b(g.b bVar) {
        if (bVar.aXP != null && bVar.aXP.aXQ != null) {
            String optString = bVar.aXP.aXQ.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                if (this.bhW != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("live_id", this.bhW.mLiveId);
                    hashMap.put("room_id", this.bhW.mRoomId);
                    hashMap.put("scene_from", q.Fy());
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
        if ((gVar instanceof aa) && ((aa) gVar).Fn()) {
            if (this.biu == null) {
                this.biu = new com.baidu.live.gift.b.c(this.mPageContext.getPageActivity());
                this.biu.b(this.bgi);
                this.biu.a(new c.a() { // from class: com.baidu.live.gift.panel.e.2
                    @Override // com.baidu.live.gift.b.c.a
                    public void onBack(String str) {
                        GiftPanelPackageFragmentView Hn = e.this.biu.Hn();
                        if (Hn != null) {
                            Hn.reset();
                            Hn.setVisibility(8);
                        }
                        if (e.this.bik != null) {
                            e.this.bik.bO(true);
                            if (!TextUtils.isEmpty(str)) {
                                e.this.bik.dc(Integer.parseInt(str));
                            }
                        }
                    }

                    @Override // com.baidu.live.gift.b.c.a
                    public void c(String str, String str2, int i, String str3) {
                        e.this.initModel();
                        e.this.bit.b(e.this.bhW != null ? e.this.bhW.mLiveId : "", str, str2, i, str3);
                    }
                });
            }
            GiftPanelPackageFragmentView Hn = this.biu.Hn();
            if ((this.bik.getRootView() instanceof ViewGroup) && ((ViewGroup) this.bik.getRootView()).indexOfChild(Hn) < 0) {
                ((ViewGroup) this.bik.getRootView()).addView(Hn, new ViewGroup.LayoutParams(-1, -1));
            }
            Hn.setVisibility(0);
            Hn.setData((aa) gVar);
            if (this.bik != null) {
                this.bik.bO(false);
            }
            if (this.bgi != null) {
                this.bgi.g("", "", true);
            }
            return true;
        }
        return false;
    }
}
