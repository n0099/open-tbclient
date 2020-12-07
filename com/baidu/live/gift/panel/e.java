package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bo;
import com.baidu.live.data.ci;
import com.baidu.live.data.j;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.b.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends c {
    private com.baidu.live.gift.d.a bgR;
    private long bgS;
    private com.baidu.live.gift.b.c bgT;

    public boolean hT(String str) {
        GiftPanelPackageFragmentView Kn;
        if (this.bgT == null || (Kn = this.bgT.Kn()) == null || Kn.getVisibility() != 0) {
            return false;
        }
        this.bgT.hK(str);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bgI.setType(1);
        this.bgI.Js();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        KR();
        this.bgR.hQ("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Lh() {
        g JA = this.bgI.JA();
        if (JA == null) {
            return false;
        }
        KR();
        int JB = this.bgI.JB();
        if (!a(JA, JB) || e(JA) || g(JA)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (JA.Hf()) {
            JA.aWg = this.bgJ != null ? this.bgJ.Jd() : null;
            if (JA.aWg == null) {
                return false;
            }
            JA.aWg.aXn = JA.Hb();
            com.baidu.live.gift.c.b.Kv().a(JA, JB, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdh, this.bgw.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.c.b.Kv().a(JA, JB, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdh, this.bgw.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (JA.aWg != null) {
            str = JA.aWg.HQ();
        }
        if (str == null) {
            str = "";
        }
        this.bgR.a(JA.GX(), JA.GY(), JA.aVZ.aWn, this.bgw.mUserId, this.bgw.mLiveId, JB, JB > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Li() {
        KR();
        this.bgR.hQ("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if ((gVar instanceof aa) && ((aa) gVar).Io()) {
            return true;
        }
        if (!a2 || (bVar = gVar.aVZ) == null || i <= bVar.aWo) {
            return a2;
        }
        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Lg() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bgS >= 1000) {
            this.bgS = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bgR != null) {
            this.bgR.release();
        }
        if (this.bgT != null) {
            this.bgT.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KR() {
        if (this.bgR == null) {
            this.bgR = new com.baidu.live.gift.d.a();
            this.bgR.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, List<j> list, int i2) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3, list, i2);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.bgI.a(true, arrayList, arrayList2, arrayList3, z, i);
                    if (e.this.beF != null) {
                        e.this.beF.ex(com.baidu.live.d.BM().getInt("gift_package_list_flag", 0));
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.bgI.baV) != null) {
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
                            e.this.bgI.a(false, z, i);
                        } else {
                            e.this.bgI.C(str2, i2);
                        }
                    }
                }

                @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                public void b(boolean z, String str, String str2, String str3, String str4, int i) {
                    super.b(z, str, str2, str3, str4, i);
                    if (z) {
                        e.this.KR();
                        e.this.bgR.hQ("gift_panel");
                    }
                    if (e.this.bgT != null) {
                        e.this.bgT.a(z, str, str2, str3, str4, i);
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
        }
    }

    private boolean g(g gVar) {
        if ((gVar instanceof aa) && ((aa) gVar).Io()) {
            if (this.bgT == null) {
                this.bgT = new com.baidu.live.gift.b.c(this.mPageContext.getPageActivity());
                this.bgT.b(this.beF);
                this.bgT.a(new c.a() { // from class: com.baidu.live.gift.panel.e.2
                    @Override // com.baidu.live.gift.b.c.a
                    public void onBack(String str) {
                        GiftPanelPackageFragmentView Kn = e.this.bgT.Kn();
                        if (Kn != null) {
                            Kn.reset();
                            Kn.setVisibility(8);
                        }
                        if (e.this.bgI != null) {
                            e.this.bgI.bP(true);
                            if (!TextUtils.isEmpty(str)) {
                                e.this.bgI.eE(Integer.parseInt(str));
                            }
                        }
                    }

                    @Override // com.baidu.live.gift.b.c.a
                    public void c(String str, String str2, int i, String str3) {
                        e.this.KR();
                        e.this.bgR.b(e.this.bgw != null ? e.this.bgw.mLiveId : "", str, str2, i, str3);
                    }
                });
            }
            GiftPanelPackageFragmentView Kn = this.bgT.Kn();
            if ((this.bgI.getRootView() instanceof ViewGroup) && ((ViewGroup) this.bgI.getRootView()).indexOfChild(Kn) < 0) {
                ((ViewGroup) this.bgI.getRootView()).addView(Kn, new ViewGroup.LayoutParams(-1, -1));
            }
            Kn.setVisibility(0);
            Kn.setData((aa) gVar);
            if (this.bgI != null) {
                this.bgI.bP(false);
            }
            if (this.beF != null) {
                this.beF.f("", "", true);
            }
            return true;
        }
        return false;
    }
}
