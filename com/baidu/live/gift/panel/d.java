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
import com.baidu.live.data.t;
import com.baidu.live.gift.container.e;
import com.baidu.live.gift.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d extends c {
    private CustomMessageListener aSp;
    private com.baidu.live.gift.container.e aWc;
    private CustomMessageListener aWd;
    private long aWa = 0;
    private long aWb = 0;
    private e.a aRo = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, t tVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.aVW.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.aVW.b(tVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aVW.setType(0);
        this.aVW.aRG.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aWa = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aWb = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Hz();
        HA();
        this.aWc = new com.baidu.live.gift.container.e(getPageContext(), this.aVJ.aTf);
        this.aWc.a(this.aRo);
        this.aWc.gx(this.aVJ.aTe);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aWd);
        MessageManager.getInstance().unRegisterListener(this.aSp);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hw() {
        return true;
    }

    private boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.w.a.Nk().bka != null && com.baidu.live.w.a.Nk().bka.aJx != null) {
            String str = com.baidu.live.w.a.Nk().bka.aJx.aIJ;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Em()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hx() {
        com.baidu.live.gift.g Ga = this.aVW.Ga();
        if (Ga == null) {
            return false;
        }
        if (b(Ga) && !this.aRs) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aVJ.aPX;
        if (Ga.Eq()) {
            if (Ga.Em() == 6 && i < 3) {
                return false;
            }
            if (Ga.Em() == 7 && i < 7) {
                return false;
            }
            if (Ga.Em() == 8 && i < 13) {
                return false;
            }
            if (Ga.Em() == 9 && i < 22) {
                return false;
            }
            if (Ga.Em() == 10 && i < 29) {
                return false;
            }
            if (Ga.Em() == 11 && i < 39) {
                return false;
            }
            if (Ga.Em() == 12 && i < 47) {
                return false;
            }
        }
        int Gb = this.aVW.Gb();
        if (a(Ga, Gb)) {
            if (Ga.DY()) {
                if (this.aWa <= 0 || this.aWa < JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb) {
                    Hs();
                    return false;
                }
                Ga.aNs = this.aVX != null ? this.aVX.FC() : null;
                if (Ga.aNs == null) {
                    return false;
                }
                Ga.aNs.aOt = Ga.DV();
                com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVJ.mUserId, this.aVJ.mUserName, this.aVJ.mLiveId, this.aVJ.mRoomId, this.aVJ.mAppId, this.aVJ.aTc, this.aVJ.otherParams, 0L);
                this.aWa -= JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb;
                this.aVW.ac(this.aWa);
                closeActivity();
            } else if (Ga.Eb()) {
                if (this.aWb <= 0 || this.aWb < JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVJ.mUserId, this.aVJ.mUserName, this.aVJ.mLiveId, this.aVJ.mRoomId, this.aVJ.mAppId, this.aVJ.aTc, this.aVJ.otherParams, 0L);
                this.aWb -= JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb;
                this.aVW.ad(this.aWb);
            } else if (this.aWa <= 0 || this.aWa < JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb) {
                Hs();
                return false;
            } else {
                com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVJ.mUserId, this.aVJ.mUserName, this.aVJ.mLiveId, this.aVJ.mRoomId, this.aVJ.mAppId, this.aVJ.aTc, this.aVJ.otherParams, 0L);
                this.aWa -= JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb;
                this.aVW.ac(this.aWa);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Hy() {
        this.aWc.gy(this.aVJ.aTe);
    }

    private void Hz() {
        this.aWd = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aVW != null) {
                    d.this.aWa = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.aWb = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.aVW.ac(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.aVW.ad(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aWd);
    }

    private void HA() {
        this.aSp = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aRs = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aSp);
    }
}
