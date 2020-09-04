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
    private CustomMessageListener aSr;
    private com.baidu.live.gift.container.e aWe;
    private CustomMessageListener aWf;
    private long aWc = 0;
    private long aWd = 0;
    private e.a aRq = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, t tVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.aVY.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.aVY.b(tVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aVY.setType(0);
        this.aVY.aRI.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aWc = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aWd = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Hz();
        HA();
        this.aWe = new com.baidu.live.gift.container.e(getPageContext(), this.aVL.aTh);
        this.aWe.a(this.aRq);
        this.aWe.gy(this.aVL.aTg);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aWf);
        MessageManager.getInstance().unRegisterListener(this.aSr);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hw() {
        return true;
    }

    private boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.w.a.Nk().bkd != null && com.baidu.live.w.a.Nk().bkd.aJz != null) {
            String str = com.baidu.live.w.a.Nk().bkd.aJz.aIL;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Em()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Hx() {
        com.baidu.live.gift.g Ga = this.aVY.Ga();
        if (Ga == null) {
            return false;
        }
        if (b(Ga) && !this.aRu) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aVL.aPZ;
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
        int Gb = this.aVY.Gb();
        if (a(Ga, Gb)) {
            if (Ga.DY()) {
                if (this.aWc <= 0 || this.aWc < JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb) {
                    Hs();
                    return false;
                }
                Ga.aNu = this.aVZ != null ? this.aVZ.FC() : null;
                if (Ga.aNu == null) {
                    return false;
                }
                Ga.aNu.aOv = Ga.DV();
                com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVL.mUserId, this.aVL.mUserName, this.aVL.mLiveId, this.aVL.mRoomId, this.aVL.mAppId, this.aVL.aTe, this.aVL.otherParams, 0L);
                this.aWc -= JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb;
                this.aVY.ac(this.aWc);
                closeActivity();
            } else if (Ga.Eb()) {
                if (this.aWd <= 0 || this.aWd < JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVL.mUserId, this.aVL.mUserName, this.aVL.mLiveId, this.aVL.mRoomId, this.aVL.mAppId, this.aVL.aTe, this.aVL.otherParams, 0L);
                this.aWd -= JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb;
                this.aVY.ad(this.aWd);
            } else if (this.aWc <= 0 || this.aWc < JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb) {
                Hs();
                return false;
            } else {
                com.baidu.live.gift.b.b.GM().a(Ga, Gb, this.aVL.mUserId, this.aVL.mUserName, this.aVL.mLiveId, this.aVL.mRoomId, this.aVL.mAppId, this.aVL.aTe, this.aVL.otherParams, 0L);
                this.aWc -= JavaTypesHelper.toLong(Ga.getPrice(), 0L) * Gb;
                this.aVY.ac(this.aWc);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Hy() {
        this.aWe.gz(this.aVL.aTg);
    }

    private void Hz() {
        this.aWf = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aVY != null) {
                    d.this.aWc = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.aWd = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.aVY.ac(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.aVY.ad(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aWf);
    }

    private void HA() {
        this.aSr = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aRu = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aSr);
    }
}
