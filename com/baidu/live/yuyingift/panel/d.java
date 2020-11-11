package com.baidu.live.yuyingift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bn;
import com.baidu.live.data.cg;
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
    private com.baidu.live.yuyingift.c.c bRG;
    private long beF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bRB.setType(1);
        this.bRB.Ik();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        Jz();
        this.bRG.hy("gift_panel");
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean JP() {
        g Is = this.bRB.Is();
        if (Is == null) {
            return false;
        }
        Jz();
        int It = this.bRB.It();
        if (!a(Is, It) || e(Is)) {
            return true;
        }
        if (Is.Ga()) {
            Is.aUN = this.bRC != null ? this.bRC.HV() : null;
            if (Is.aUN == null) {
                return false;
            }
            Is.aUN.aVT = Is.FX();
            com.baidu.live.yuyingift.b.b.XE().a(Is, It, this.bRt.mUserId, this.bRt.mUserName, this.bRt.mLiveId, this.bRt.mRoomId, this.bRt.mAppId, this.bRt.bbt, this.bRt.otherParams, 0L, r.ah(XL().bSx));
            closeActivity();
        } else {
            com.baidu.live.yuyingift.b.b.XE().a(Is, It, this.bRt.mUserId, this.bRt.mUserName, this.bRt.mLiveId, this.bRt.mRoomId, this.bRt.mAppId, this.bRt.bbt, this.bRt.otherParams, 0L, System.currentTimeMillis(), r.ah(XL().bSx));
        }
        String str = null;
        if (Is.aUN != null) {
            str = Is.aUN.GK();
        }
        if (str == null) {
            str = "";
        }
        this.bRG.a(Is.FT(), Is.aUI.aUU, this.bRt.mUserId, this.bRt.mLiveId, It, It > 1 ? 1 : 0, str, r.ah(XL().bSx), System.currentTimeMillis());
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void JQ() {
        Jz();
        this.bRG.hy("gift_panel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b
    public boolean a(g gVar, int i) {
        g.b bVar;
        boolean a2 = super.a(gVar, i);
        if (a2 && (bVar = gVar.aUI) != null && i > bVar.aUV) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a2;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean JO() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.beF >= 400) {
            this.beF = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bRG != null) {
            this.bRG.release();
        }
    }

    private void Jz() {
        if (this.bRG == null) {
            this.bRG = new com.baidu.live.yuyingift.c.c();
            this.bRG.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.d.1
                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && d.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    d.this.bRB.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<h> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = d.this.bRB.aZo) != null) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> Gu = it.next().Gu();
                            if (Gu != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = Gu.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().FT().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : Gu) {
                                        if (gVar.FT().equals(str2)) {
                                            gVar.aUI.aUV = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            d.this.bRB.a(false, z, i);
                        } else {
                            d.this.bRB.A(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.b.a aVar;
        g.b bVar = gVar.aUI;
        if (bVar == null || (aVar = bVar.aUY) == null) {
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
        bn bnVar;
        cg[] cgVarArr;
        if (bVar.aUY.aUZ != null && bVar.aUY.aUZ.optInt("price") == 100 && (bnVar = com.baidu.live.aa.a.PQ().btT) != null && bnVar.aPA != null && bnVar.aPA.aRO && bnVar.aPx != null && (cgVarArr = bnVar.aPx.aQP) != null && cgVarArr.length > 0) {
            for (cg cgVar : cgVarArr) {
                if (cgVar.price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, cgVar.id));
                    return;
                }
            }
        }
    }

    private void f(g gVar) {
        g.b bVar;
        if (gVar != null && (bVar = gVar.aUI) != null && bVar.aUY != null && bVar.aUY.aUZ != null) {
            String optString = bVar.aUY.aUZ.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                nobleDetailInfo.url = optString;
                nobleDetailInfo.cardId = gVar.FT();
                nobleDetailInfo.expDuration = bVar.aUY.aUZ.optLong("experience_time");
                nobleDetailInfo.expireTimestamp = bVar.aUW;
                closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            }
        }
    }
}
