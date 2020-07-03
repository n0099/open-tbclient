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
/* loaded from: classes3.dex */
public class d extends c {
    private CustomMessageListener aLG;
    private com.baidu.live.gift.container.e aPv;
    private CustomMessageListener aPw;
    private long aPt = 0;
    private long aPu = 0;
    private e.a aKF = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, s sVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.aPp.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.aPp.b(sVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aPp.setType(0);
        this.aPp.aKX.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aPt = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aPu = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Bu();
        Bv();
        this.aPv = new com.baidu.live.gift.container.e(getPageContext(), this.aPc.aMx);
        this.aPv.a(this.aKF);
        this.aPv.fd(this.aPc.aMw);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aPw);
        MessageManager.getInstance().unRegisterListener(this.aLG);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Br() {
        return true;
    }

    private boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.v.a.Hm().bdV != null && com.baidu.live.v.a.Hm().bdV.aCS != null) {
            String str = com.baidu.live.v.a.Hm().bdV.aCS.aCe;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.yh()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Bs() {
        com.baidu.live.gift.g zV = this.aPp.zV();
        if (zV == null) {
            return false;
        }
        if (b(zV) && !this.aKJ) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aPc.aJo;
        if (zV.yl()) {
            if (zV.yh() == 6 && i < 3) {
                return false;
            }
            if (zV.yh() == 7 && i < 7) {
                return false;
            }
            if (zV.yh() == 8 && i < 13) {
                return false;
            }
            if (zV.yh() == 9 && i < 22) {
                return false;
            }
            if (zV.yh() == 10 && i < 29) {
                return false;
            }
            if (zV.yh() == 11 && i < 39) {
                return false;
            }
            if (zV.yh() == 12 && i < 47) {
                return false;
            }
        }
        int zW = this.aPp.zW();
        if (a(zV, zW)) {
            if (zV.xT()) {
                if (this.aPt <= 0 || this.aPt < JavaTypesHelper.toLong(zV.getPrice(), 0L) * zW) {
                    Bn();
                    return false;
                }
                zV.aGM = this.aPq != null ? this.aPq.zx() : null;
                if (zV.aGM == null) {
                    return false;
                }
                zV.aGM.aHN = zV.xQ();
                com.baidu.live.gift.b.b.AH().a(zV, zW, this.aPc.mUserId, this.aPc.mUserName, this.aPc.mLiveId, this.aPc.mRoomId, this.aPc.mAppId, this.aPc.aMu, this.aPc.otherParams, 0L);
                this.aPt -= JavaTypesHelper.toLong(zV.getPrice(), 0L) * zW;
                this.aPp.ab(this.aPt);
                closeActivity();
            } else if (zV.xW()) {
                if (this.aPu <= 0 || this.aPu < JavaTypesHelper.toLong(zV.getPrice(), 0L) * zW) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.AH().a(zV, zW, this.aPc.mUserId, this.aPc.mUserName, this.aPc.mLiveId, this.aPc.mRoomId, this.aPc.mAppId, this.aPc.aMu, this.aPc.otherParams, 0L);
                this.aPu -= JavaTypesHelper.toLong(zV.getPrice(), 0L) * zW;
                this.aPp.ac(this.aPu);
            } else if (this.aPt <= 0 || this.aPt < JavaTypesHelper.toLong(zV.getPrice(), 0L) * zW) {
                Bn();
                return false;
            } else {
                com.baidu.live.gift.b.b.AH().a(zV, zW, this.aPc.mUserId, this.aPc.mUserName, this.aPc.mLiveId, this.aPc.mRoomId, this.aPc.mAppId, this.aPc.aMu, this.aPc.otherParams, 0L);
                this.aPt -= JavaTypesHelper.toLong(zV.getPrice(), 0L) * zW;
                this.aPp.ab(this.aPt);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Bt() {
        this.aPv.fe(this.aPc.aMw);
    }

    private void Bu() {
        this.aPw = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aPp != null) {
                    d.this.aPt = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.aPu = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.aPp.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.aPp.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aPw);
    }

    private void Bv() {
        this.aLG = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aKJ = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aLG);
    }
}
