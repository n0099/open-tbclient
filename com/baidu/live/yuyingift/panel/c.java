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
/* loaded from: classes10.dex */
public class c extends b {
    private CustomMessageListener bdH;
    private CustomMessageListener bir;
    private com.baidu.live.yuyingift.container.e cbU;
    private long bio = 0;
    private long bip = 0;
    private e.a can = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.cbO.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.cbO.b(aeVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.cbO.setType(0);
        this.cbO.cas.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.bio = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bip = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Ih();
        Ii();
        this.cbU = new com.baidu.live.yuyingift.container.e(getPageContext(), this.cbF.beO);
        this.cbU.a(this.can);
        this.cbU.gG(this.cbF.beN);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bir);
        MessageManager.getInstance().unRegisterListener(this.bdH);
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Zi() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.ae.a.Qm().bCs != null && com.baidu.live.ae.a.Qm().bCs.aRl != null) {
            String str = com.baidu.live.ae.a.Qm().bCs.aRl.aQC;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Et()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g GA = this.cbO.GA();
        if (GA == null || !a(Zf())) {
            return false;
        }
        if (b(GA) && !this.bcC) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i2 = this.cbF.bbe;
        if (GA.Ey()) {
            if (GA.Et() == 6 && i2 < 3) {
                return false;
            }
            if (GA.Et() == 7 && i2 < 7) {
                return false;
            }
            if (GA.Et() == 8 && i2 < 13) {
                return false;
            }
            if (GA.Et() == 9 && i2 < 22) {
                return false;
            }
            if (GA.Et() == 10 && i2 < 29) {
                return false;
            }
            if (GA.Et() == 11 && i2 < 39) {
                return false;
            }
            if (GA.Et() == 12 && i2 < 47) {
                return false;
            }
        }
        int GB = this.cbO.GB();
        if (a(GA, GB)) {
            long j2 = JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB * Zg();
            if (GA.Ee()) {
                if (this.bio <= 0 || this.bio < j2) {
                    Ia();
                    return false;
                }
                GA.aXE = this.cbP != null ? this.cbP.Gd() : null;
                if (GA.aXE == null) {
                    return false;
                }
                GA.aXE.aYK = GA.Ea();
                com.baidu.live.yuyingift.b.b.Za().a(GA, GB, this.cbF.mUserId, this.cbF.mUserName, this.cbF.mLiveId, this.cbF.mRoomId, this.cbF.mAppId, this.cbF.beL, this.cbF.otherParams, 0L, s.al(Zf().ccU), this.cbS, this.cbR);
                this.bio -= j2;
                this.cbO.aQ(this.bio);
                closeActivity();
            } else if (GA.Eh()) {
                if (this.bip <= 0 || this.bip < j2) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.Za().a(GA, GB, this.cbF.mUserId, this.cbF.mUserName, this.cbF.mLiveId, this.cbF.mRoomId, this.cbF.mAppId, this.cbF.beL, this.cbF.otherParams, 0L, s.al(Zf().ccU), this.cbS, this.cbR);
                this.bip -= j2;
                this.cbO.aR(this.bip);
            } else if (this.bio <= 0 || this.bio < j2) {
                Ia();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.Za().a(GA, GB, this.cbF.mUserId, this.cbF.mUserName, this.cbF.mLiveId, this.cbF.mRoomId, this.cbF.mAppId, this.cbF.beL, this.cbF.otherParams, 0L, s.al(Zf().ccU), this.cbS, this.cbR);
                this.bio -= j2;
                this.cbO.aQ(this.bio);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void If() {
        this.cbU.gH(this.cbF.beN);
    }

    private void Ih() {
        this.bir = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.cbO != null) {
                    c.this.bio = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.bip = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.cbO.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.cbO.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bir);
    }

    private void Ii() {
        this.bdH = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bcC = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bdH);
    }
}
