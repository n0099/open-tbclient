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
import com.baidu.live.gift.container.d;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends c {
    private CustomMessageListener aJa;
    private com.baidu.live.gift.container.d aMP;
    private CustomMessageListener aMQ;
    private long aMN = 0;
    private long aMO = 0;
    private d.a aIb = new d.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.aMJ.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aMJ.setType(0);
        this.aMJ.aIt.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aMN = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aMO = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        AU();
        AV();
        this.aMP = new com.baidu.live.gift.container.d(getPageContext(), this.aMw.aJR);
        this.aMP.a(this.aIb);
        this.aMP.eX(this.aMw.aJQ);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aMQ);
        MessageManager.getInstance().unRegisterListener(this.aJa);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean AR() {
        return true;
    }

    private boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAH != null) {
            String str = com.baidu.live.v.a.Ge().aYP.aAH.azT;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.xH()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean AS() {
        com.baidu.live.gift.g zv = this.aMJ.zv();
        if (zv == null) {
            return false;
        }
        if (b(zv) && !this.aIf) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aMw.aGQ;
        if (zv.xL()) {
            if (zv.xH() == 6 && i < 3) {
                return false;
            }
            if (zv.xH() == 7 && i < 7) {
                return false;
            }
            if (zv.xH() == 8 && i < 13) {
                return false;
            }
            if (zv.xH() == 9 && i < 22) {
                return false;
            }
            if (zv.xH() == 10 && i < 29) {
                return false;
            }
            if (zv.xH() == 11 && i < 39) {
                return false;
            }
            if (zv.xH() == 12 && i < 47) {
                return false;
            }
        }
        int zw = this.aMJ.zw();
        if (a(zv, zw)) {
            if (zv.xt()) {
                if (this.aMN <= 0 || this.aMN < JavaTypesHelper.toLong(zv.getPrice(), 0L) * zw) {
                    AN();
                    return false;
                }
                zv.aEq = this.aMK != null ? this.aMK.yX() : null;
                if (zv.aEq == null) {
                    return false;
                }
                zv.aEq.aFr = zv.xq();
                com.baidu.live.gift.b.b.Ah().a(zv, zw, this.aMw.mUserId, this.aMw.mUserName, this.aMw.mLiveId, this.aMw.mRoomId, this.aMw.mAppId, this.aMw.aJO, this.aMw.otherParams, 0L);
                this.aMN -= JavaTypesHelper.toLong(zv.getPrice(), 0L) * zw;
                this.aMJ.ab(this.aMN);
                closeActivity();
            } else if (zv.xw()) {
                if (this.aMO <= 0 || this.aMO < JavaTypesHelper.toLong(zv.getPrice(), 0L) * zw) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.Ah().a(zv, zw, this.aMw.mUserId, this.aMw.mUserName, this.aMw.mLiveId, this.aMw.mRoomId, this.aMw.mAppId, this.aMw.aJO, this.aMw.otherParams, 0L);
                this.aMO -= JavaTypesHelper.toLong(zv.getPrice(), 0L) * zw;
                this.aMJ.ac(this.aMO);
            } else if (this.aMN <= 0 || this.aMN < JavaTypesHelper.toLong(zv.getPrice(), 0L) * zw) {
                AN();
                return false;
            } else {
                com.baidu.live.gift.b.b.Ah().a(zv, zw, this.aMw.mUserId, this.aMw.mUserName, this.aMw.mLiveId, this.aMw.mRoomId, this.aMw.mAppId, this.aMw.aJO, this.aMw.otherParams, 0L);
                this.aMN -= JavaTypesHelper.toLong(zv.getPrice(), 0L) * zw;
                this.aMJ.ab(this.aMN);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void AT() {
        this.aMP.eY(this.aMw.aJQ);
    }

    private void AU() {
        this.aMQ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aMJ != null) {
                    d.this.aMN = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.aMO = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.aMJ.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.aMJ.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMQ);
    }

    private void AV() {
        this.aJa = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aIf = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aJa);
    }
}
