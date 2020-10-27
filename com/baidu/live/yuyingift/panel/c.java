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
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.data.y;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.container.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends b {
    private CustomMessageListener aZc;
    private com.baidu.live.yuyingift.container.e bLW;
    private CustomMessageListener bdh;
    private long bde = 0;
    private long bdf = 0;
    private e.a bKD = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.bLT.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.bLT.b(yVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bLT.setType(0);
        this.bLT.bKI.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.bde = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bdf = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Jr();
        Js();
        this.bLW = new com.baidu.live.yuyingift.container.e(getPageContext(), this.bLL.bad);
        this.bLW.a(this.bKD);
        this.bLW.hh(this.bLL.bac);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bdh);
        MessageManager.getInstance().unRegisterListener(this.aZc);
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Jn() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.z.a.Pq().bsy != null && com.baidu.live.z.a.Pq().bsy.aOz != null) {
            String str = com.baidu.live.z.a.Pq().bsy.aOz.aNL;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.FO()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Jo() {
        g HR = this.bLT.HR();
        if (HR == null) {
            return false;
        }
        if (b(HR) && !this.aYd) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bLL.aWH;
        if (HR.FS()) {
            if (HR.FO() == 6 && i < 3) {
                return false;
            }
            if (HR.FO() == 7 && i < 7) {
                return false;
            }
            if (HR.FO() == 8 && i < 13) {
                return false;
            }
            if (HR.FO() == 9 && i < 22) {
                return false;
            }
            if (HR.FO() == 10 && i < 29) {
                return false;
            }
            if (HR.FO() == 11 && i < 39) {
                return false;
            }
            if (HR.FO() == 12 && i < 47) {
                return false;
            }
        }
        int HS = this.bLT.HS();
        if (a(HR, HS)) {
            if (HR.Fz()) {
                if (this.bde <= 0 || this.bde < JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) {
                    Jj();
                    return false;
                }
                HR.aTv = this.bLU != null ? this.bLU.Hu() : null;
                if (HR.aTv == null) {
                    return false;
                }
                HR.aTv.aUB = HR.Fw();
                com.baidu.live.yuyingift.b.b.Vf().a(HR, HS, this.bLL.mUserId, this.bLL.mUserName, this.bLL.mLiveId, this.bLL.mRoomId, this.bLL.mAppId, this.bLL.baa, this.bLL.otherParams, 0L, r.ac(Vm().bMO));
                this.bde -= (JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) * Vn();
                this.bLT.ae(this.bde);
                closeActivity();
            } else if (HR.FC()) {
                if (this.bdf <= 0 || this.bdf < JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS * Vn()) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.Vf().a(HR, HS, this.bLL.mUserId, this.bLL.mUserName, this.bLL.mLiveId, this.bLL.mRoomId, this.bLL.mAppId, this.bLL.baa, this.bLL.otherParams, 0L, r.ac(Vm().bMO));
                this.bdf -= (JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) * Vn();
                this.bLT.af(this.bdf);
            } else if (this.bde <= 0 || this.bde < JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) {
                Jj();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.Vf().a(HR, HS, this.bLL.mUserId, this.bLL.mUserName, this.bLL.mLiveId, this.bLL.mRoomId, this.bLL.mAppId, this.bLL.baa, this.bLL.otherParams, 0L, r.ac(Vm().bMO));
                this.bde -= (JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) * Vn();
                this.bLT.ae(this.bde);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void Jp() {
        this.bLW.hi(this.bLL.bac);
    }

    private void Jr() {
        this.bdh = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.bLT != null) {
                    c.this.bde = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.bdf = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.bLT.ae(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.bLT.af(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdh);
    }

    private void Js() {
        this.aZc = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.aYd = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aZc);
    }
}
