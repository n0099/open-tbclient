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
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.container.e;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class c extends b {
    private CustomMessageListener aYZ;
    private com.baidu.live.yuyingift.container.e bWr;
    private CustomMessageListener bdF;
    private long bdC = 0;
    private long bdD = 0;
    private e.a bUL = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.bWl.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.bWl.b(aaVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bWl.setType(0);
        this.bWl.bUQ.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.bdC = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bdD = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        GO();
        GP();
        this.bWr = new com.baidu.live.yuyingift.container.e(getPageContext(), this.bWc.baf);
        this.bWr.a(this.bUL);
        this.bWr.gc(this.bWc.bae);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bdF);
        MessageManager.getInstance().unRegisterListener(this.aYZ);
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Xp() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.af.a.OJ().bxp != null && com.baidu.live.af.a.OJ().bxp.aMN != null) {
            String str = com.baidu.live.af.a.OJ().bxp.aMN.aMe;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Da()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g Fh = this.bWl.Fh();
        if (Fh == null) {
            return false;
        }
        if (b(Fh) && !this.aXV) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i2 = this.bWc.aWx;
        if (Fh.Df()) {
            if (Fh.Da() == 6 && i2 < 3) {
                return false;
            }
            if (Fh.Da() == 7 && i2 < 7) {
                return false;
            }
            if (Fh.Da() == 8 && i2 < 13) {
                return false;
            }
            if (Fh.Da() == 9 && i2 < 22) {
                return false;
            }
            if (Fh.Da() == 10 && i2 < 29) {
                return false;
            }
            if (Fh.Da() == 11 && i2 < 39) {
                return false;
            }
            if (Fh.Da() == 12 && i2 < 47) {
                return false;
            }
        }
        int Fi = this.bWl.Fi();
        if (a(Fh, Fi)) {
            long j2 = JavaTypesHelper.toLong(Fh.getPrice(), 0L) * Fi * Xn();
            if (Fh.CL()) {
                if (this.bdC <= 0 || this.bdC < j2) {
                    GH();
                    return false;
                }
                Fh.aSZ = this.bWm != null ? this.bWm.EK() : null;
                if (Fh.aSZ == null) {
                    return false;
                }
                Fh.aSZ.aUf = Fh.CH();
                com.baidu.live.yuyingift.b.b.Xh().a(Fh, Fi, this.bWc.mUserId, this.bWc.mUserName, this.bWc.mLiveId, this.bWc.mRoomId, this.bWc.mAppId, this.bWc.bac, this.bWc.otherParams, 0L, s.ak(Xm().bXq), this.bWp, this.bWo);
                this.bdC -= j2;
                this.bWl.aN(this.bdC);
                closeActivity();
            } else if (Fh.CO()) {
                if (this.bdD <= 0 || this.bdD < j2) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.Xh().a(Fh, Fi, this.bWc.mUserId, this.bWc.mUserName, this.bWc.mLiveId, this.bWc.mRoomId, this.bWc.mAppId, this.bWc.bac, this.bWc.otherParams, 0L, s.ak(Xm().bXq), this.bWp, this.bWo);
                this.bdD -= j2;
                this.bWl.aO(this.bdD);
            } else if (this.bdC <= 0 || this.bdC < j2) {
                GH();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.Xh().a(Fh, Fi, this.bWc.mUserId, this.bWc.mUserName, this.bWc.mLiveId, this.bWc.mRoomId, this.bWc.mAppId, this.bWc.bac, this.bWc.otherParams, 0L, s.ak(Xm().bXq), this.bWp, this.bWo);
                this.bdC -= j2;
                this.bWl.aN(this.bdC);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void GM() {
        this.bWr.gd(this.bWc.bae);
    }

    private void GO() {
        this.bdF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.bWl != null) {
                    c.this.bdC = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.bdD = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.bWl.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.bWl.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdF);
    }

    private void GP() {
        this.aYZ = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.aXV = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aYZ);
    }
}
