package com.baidu.live.gift.panel;

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
import com.baidu.live.data.g;
import com.baidu.live.data.s;
import com.baidu.live.gift.container.e;
import com.baidu.live.gift.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d extends c {
    private CustomMessageListener aNc;
    private com.baidu.live.gift.container.e aQO;
    private CustomMessageListener aQP;
    private long aQM = 0;
    private long aQN = 0;
    private e.a aMb = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, s sVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.aQI.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.aQI.b(sVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aQI.setType(0);
        this.aQI.aMt.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aQM = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aQN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        BW();
        BX();
        this.aQO = new com.baidu.live.gift.container.e(getPageContext(), this.aQv.aNS);
        this.aQO.a(this.aMb);
        this.aQO.fc(this.aQv.aNR);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aQP);
        MessageManager.getInstance().unRegisterListener(this.aNc);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean BT() {
        return true;
    }

    private boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.v.a.Hs().beo != null && com.baidu.live.v.a.Hs().beo.aEn != null) {
            String str = com.baidu.live.v.a.Hs().beo.aEn.aDz;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.yJ()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean BU() {
        com.baidu.live.gift.g Ax = this.aQI.Ax();
        if (Ax == null) {
            return false;
        }
        if (b(Ax) && !this.aMf) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aQv.aKK;
        if (Ax.yN()) {
            if (Ax.yJ() == 6 && i < 3) {
                return false;
            }
            if (Ax.yJ() == 7 && i < 7) {
                return false;
            }
            if (Ax.yJ() == 8 && i < 13) {
                return false;
            }
            if (Ax.yJ() == 9 && i < 22) {
                return false;
            }
            if (Ax.yJ() == 10 && i < 29) {
                return false;
            }
            if (Ax.yJ() == 11 && i < 39) {
                return false;
            }
            if (Ax.yJ() == 12 && i < 47) {
                return false;
            }
        }
        int Ay = this.aQI.Ay();
        if (a(Ax, Ay)) {
            if (Ax.yv()) {
                if (this.aQM <= 0 || this.aQM < JavaTypesHelper.toLong(Ax.getPrice(), 0L) * Ay) {
                    BP();
                    return false;
                }
                Ax.aIh = this.aQJ != null ? this.aQJ.zZ() : null;
                if (Ax.aIh == null) {
                    return false;
                }
                Ax.aIh.aJi = Ax.ys();
                com.baidu.live.gift.b.b.Bj().a(Ax, Ay, this.aQv.mUserId, this.aQv.mUserName, this.aQv.mLiveId, this.aQv.mRoomId, this.aQv.mAppId, this.aQv.aNP, this.aQv.otherParams, 0L);
                this.aQM -= JavaTypesHelper.toLong(Ax.getPrice(), 0L) * Ay;
                this.aQI.ab(this.aQM);
                closeActivity();
            } else if (Ax.yy()) {
                if (this.aQN <= 0 || this.aQN < JavaTypesHelper.toLong(Ax.getPrice(), 0L) * Ay) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.Bj().a(Ax, Ay, this.aQv.mUserId, this.aQv.mUserName, this.aQv.mLiveId, this.aQv.mRoomId, this.aQv.mAppId, this.aQv.aNP, this.aQv.otherParams, 0L);
                this.aQN -= JavaTypesHelper.toLong(Ax.getPrice(), 0L) * Ay;
                this.aQI.ac(this.aQN);
            } else if (this.aQM <= 0 || this.aQM < JavaTypesHelper.toLong(Ax.getPrice(), 0L) * Ay) {
                BP();
                return false;
            } else {
                com.baidu.live.gift.b.b.Bj().a(Ax, Ay, this.aQv.mUserId, this.aQv.mUserName, this.aQv.mLiveId, this.aQv.mRoomId, this.aQv.mAppId, this.aQv.aNP, this.aQv.otherParams, 0L);
                this.aQM -= JavaTypesHelper.toLong(Ax.getPrice(), 0L) * Ay;
                this.aQI.ab(this.aQM);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void BV() {
        this.aQO.fd(this.aQv.aNR);
    }

    private void BW() {
        this.aQP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aQI != null) {
                    d.this.aQM = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.aQN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.aQI.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.aQI.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aQP);
    }

    private void BX() {
        this.aNc = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aMf = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aNc);
    }
}
