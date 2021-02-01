package com.baidu.live.yuyingift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.container.e;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c extends b {
    private CustomMessageListener bch;
    private CustomMessageListener bgP;
    private com.baidu.live.yuyingift.container.e cat;
    private long bgM = 0;
    private long bgN = 0;
    private e.a bYN = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.can.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.can.b(aeVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.can.setType(0);
        this.can.bYS.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Ie();
        If();
        this.cat = new com.baidu.live.yuyingift.container.e(getPageContext(), this.cae.bdm);
        this.cat.a(this.bYN);
        this.cat.gA(this.cae.bdl);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bgP);
        MessageManager.getInstance().unRegisterListener(this.bch);
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Zf() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPL != null) {
            String str = com.baidu.live.ae.a.Qj().bAS.aPL.aPc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Eq()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g Gx = this.can.Gx();
        if (Gx == null || !a(Zc())) {
            return false;
        }
        if (b(Gx) && !this.bbc) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i2 = this.cae.aZD;
        if (Gx.Ev()) {
            if (Gx.Eq() == 6 && i2 < 3) {
                return false;
            }
            if (Gx.Eq() == 7 && i2 < 7) {
                return false;
            }
            if (Gx.Eq() == 8 && i2 < 13) {
                return false;
            }
            if (Gx.Eq() == 9 && i2 < 22) {
                return false;
            }
            if (Gx.Eq() == 10 && i2 < 29) {
                return false;
            }
            if (Gx.Eq() == 11 && i2 < 39) {
                return false;
            }
            if (Gx.Eq() == 12 && i2 < 47) {
                return false;
            }
        }
        int Gy = this.can.Gy();
        if (a(Gx, Gy)) {
            long j2 = JavaTypesHelper.toLong(Gx.getPrice(), 0L) * Gy * Zd();
            if (Gx.Eb()) {
                if (this.bgM <= 0 || this.bgM < j2) {
                    HX();
                    return false;
                }
                Gx.aWe = this.cao != null ? this.cao.Ga() : null;
                if (Gx.aWe == null) {
                    return false;
                }
                Gx.aWe.aXk = Gx.DX();
                com.baidu.live.yuyingift.b.b.YX().a(Gx, Gy, this.cae.mUserId, this.cae.mUserName, this.cae.mLiveId, this.cae.mRoomId, this.cae.mAppId, this.cae.bdj, this.cae.otherParams, 0L, s.al(Zc().cbt), this.car, this.caq);
                this.bgM -= j2;
                this.can.aQ(this.bgM);
                closeActivity();
            } else if (Gx.Ee()) {
                if (this.bgN <= 0 || this.bgN < j2) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.YX().a(Gx, Gy, this.cae.mUserId, this.cae.mUserName, this.cae.mLiveId, this.cae.mRoomId, this.cae.mAppId, this.cae.bdj, this.cae.otherParams, 0L, s.al(Zc().cbt), this.car, this.caq);
                this.bgN -= j2;
                this.can.aR(this.bgN);
            } else if (this.bgM <= 0 || this.bgM < j2) {
                HX();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.YX().a(Gx, Gy, this.cae.mUserId, this.cae.mUserName, this.cae.mLiveId, this.cae.mRoomId, this.cae.mAppId, this.cae.bdj, this.cae.otherParams, 0L, s.al(Zc().cbt), this.car, this.caq);
                this.bgM -= j2;
                this.can.aQ(this.bgM);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void Ic() {
        this.cat.gB(this.cae.bdl);
    }

    private void Ie() {
        this.bgP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.can != null) {
                    c.this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.can.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.can.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgP);
    }

    private void If() {
        this.bch = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bbc = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bch);
    }
}
