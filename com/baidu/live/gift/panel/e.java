package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bc;
import com.baidu.live.data.bp;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends c {
    private com.baidu.live.gift.c.a aQR;
    private long aQS;

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aQI.setType(1);
        this.aQI.Ap();
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        BE();
        this.aQR.fo("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean BU() {
        g Ax = this.aQI.Ax();
        if (Ax == null) {
            return false;
        }
        BE();
        int Ay = this.aQI.Ay();
        if (!a(Ax, Ay) || e(Ax)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Ax.yv()) {
            Ax.aIh = this.aQJ != null ? this.aQJ.zZ() : null;
            if (Ax.aIh == null) {
                return false;
            }
            Ax.aIh.aJi = Ax.ys();
            com.baidu.live.gift.b.b.Bj().a(Ax, Ay, this.aQv.mUserId, this.aQv.mUserName, this.aQv.mLiveId, this.aQv.mRoomId, this.aQv.mAppId, this.aQv.aNP, this.aQv.otherParams, 0L, currentTimeMillis);
            closeActivity();
        } else {
            com.baidu.live.gift.b.b.Bj().a(Ax, Ay, this.aQv.mUserId, this.aQv.mUserName, this.aQv.mLiveId, this.aQv.mRoomId, this.aQv.mAppId, this.aQv.aNP, this.aQv.otherParams, 0L, currentTimeMillis);
        }
        String str = null;
        if (Ax.aIh != null) {
            str = Ax.aIh.ze();
        }
        if (str == null) {
            str = "";
        }
        this.aQR.a(Ax.yo(), Ax.yp(), Ax.aIc.aIi, this.aQv.mUserId, this.aQv.mLiveId, Ay, Ay > 1 ? 1 : 0, str, currentTimeMillis);
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void BV() {
        BE();
        this.aQR.fo("gift_panel");
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean a(g gVar, int i) {
        g.a aVar;
        boolean a = super.a(gVar, i);
        if (a && (aVar = gVar.aIc) != null && i > aVar.aIj) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "赠送失败，达到最高发送礼物上限");
            return false;
        }
        return a;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean BT() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aQS >= 1000) {
            this.aQS = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aQR != null) {
            this.aQR.release();
        }
    }

    private void BE() {
        if (this.aQR == null) {
            this.aQR = new com.baidu.live.gift.c.a();
            this.aQR.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.e.1
                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3) {
                    super.a(z, i, str, arrayList, arrayList2, arrayList3);
                    if (!z && !TextUtils.isEmpty(str) && e.this.mVisible) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                    }
                    e.this.aQI.a(true, arrayList, arrayList2, arrayList3, z, i);
                }

                @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
                public void a(boolean z, int i, String str, String str2, int i2) {
                    ArrayList<i> arrayList;
                    super.a(z, i, str, str2, i2);
                    if (z && !TextUtils.isEmpty(str2) && (arrayList = e.this.aQI.aLY) != null) {
                        Iterator<i> it = arrayList.iterator();
                        while (it.hasNext()) {
                            List<g> yO = it.next().yO();
                            if (yO != null) {
                                if (i2 == 0) {
                                    Iterator<g> it2 = yO.iterator();
                                    while (it2.hasNext()) {
                                        if (it2.next().yo().equals(str2)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    for (g gVar : yO) {
                                        if (gVar.yo().equals(str2)) {
                                            gVar.aIc.aIj = i2;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            e.this.aQI.a(false, z, i);
                        } else {
                            e.this.aQI.z(str2, i2);
                        }
                    }
                }
            });
        }
    }

    private boolean e(g gVar) {
        g.a.C0165a c0165a;
        g.a aVar = gVar.aIc;
        if (aVar == null || (c0165a = aVar.aIm) == null || c0165a.key != 10) {
            return false;
        }
        if (c0165a.aIo != null && c0165a.aIo.optInt("price") == 100) {
            BY();
        }
        return true;
    }

    private void BY() {
        bp[] bpVarArr;
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar != null && bcVar.aEr != null && bcVar.aEr.aGd && bcVar.aEo != null && (bpVarArr = bcVar.aEo.aFh) != null && bpVarArr.length > 0) {
            for (int i = 0; i < bpVarArr.length; i++) {
                if (bpVarArr[i].price == 100) {
                    closeActivity();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913121, bpVarArr[i].id));
                    return;
                }
            }
        }
    }
}
