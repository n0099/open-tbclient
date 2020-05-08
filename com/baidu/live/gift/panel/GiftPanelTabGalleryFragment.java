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
import com.baidu.live.data.e;
import com.baidu.live.gift.container.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GiftPanelTabGalleryFragment extends GiftPanelTabBaseFragment {
    private CustomMessageListener aDB;
    private d aHg;
    private CustomMessageListener aHh;
    private long aHe = 0;
    private long aHf = 0;
    private d.a aCC = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<e> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.aGZ.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aGZ.setType(0);
        this.aGZ.aCU.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aHe = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aHf = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        zE();
        zF();
        this.aHg = new d(getPageContext(), this.aHb.aEq);
        this.aHg.a(this.aCC);
        this.aHg.en(this.aHb.aEp);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aHh);
        MessageManager.getInstance().unRegisterListener(this.aDB);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zB() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.v.a.En().aRB != null && com.baidu.live.v.a.En().aRB.avz != null) {
            String str = com.baidu.live.v.a.En().aRB.avz.auP;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.wq()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zC() {
        g yf = this.aGZ.yf();
        if (yf == null) {
            return false;
        }
        if (b(yf) && !this.aCG) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aHb.aBv;
        if (yf.wu()) {
            if (yf.wq() == 6 && i < 3) {
                return false;
            }
            if (yf.wq() == 7 && i < 7) {
                return false;
            }
            if (yf.wq() == 8 && i < 13) {
                return false;
            }
            if (yf.wq() == 9 && i < 22) {
                return false;
            }
            if (yf.wq() == 10 && i < 29) {
                return false;
            }
            if (yf.wq() == 11 && i < 39) {
                return false;
            }
            if (yf.wq() == 12 && i < 47) {
                return false;
            }
        }
        int yg = this.aGZ.yg();
        if (a(yf, yg)) {
            if (yf.wc()) {
                if (this.aHe <= 0 || this.aHe < JavaTypesHelper.toLong(yf.getPrice(), 0L) * yg) {
                    zx();
                    return false;
                }
                yf.ayY = this.aHa != null ? this.aHa.xK() : null;
                if (yf.ayY == null) {
                    return false;
                }
                yf.ayY.azZ = yf.vZ();
                com.baidu.live.gift.b.b.yS().a(yf, yg, this.aHb.mUserId, this.aHb.mUserName, this.aHb.mLiveId, this.aHb.mRoomId, this.aHb.mAppId, this.aHb.aEn, this.aHb.otherParams, 0L);
                this.aHe -= JavaTypesHelper.toLong(yf.getPrice(), 0L) * yg;
                this.aGZ.X(this.aHe);
                closeActivity();
            } else if (yf.wf()) {
                if (this.aHf <= 0 || this.aHf < JavaTypesHelper.toLong(yf.getPrice(), 0L) * yg) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.yS().a(yf, yg, this.aHb.mUserId, this.aHb.mUserName, this.aHb.mLiveId, this.aHb.mRoomId, this.aHb.mAppId, this.aHb.aEn, this.aHb.otherParams, 0L);
                this.aHf -= JavaTypesHelper.toLong(yf.getPrice(), 0L) * yg;
                this.aGZ.Y(this.aHf);
            } else if (this.aHe <= 0 || this.aHe < JavaTypesHelper.toLong(yf.getPrice(), 0L) * yg) {
                zx();
                return false;
            } else {
                com.baidu.live.gift.b.b.yS().a(yf, yg, this.aHb.mUserId, this.aHb.mUserName, this.aHb.mLiveId, this.aHb.mRoomId, this.aHb.mAppId, this.aHb.aEn, this.aHb.otherParams, 0L);
                this.aHe -= JavaTypesHelper.toLong(yf.getPrice(), 0L) * yg;
                this.aGZ.X(this.aHe);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void zD() {
        this.aHg.eo(this.aHb.aEp);
    }

    private void zE() {
        this.aHh = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.aGZ != null) {
                    GiftPanelTabGalleryFragment.this.aHe = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.aHf = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.aGZ.X(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.aGZ.Y(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aHh);
    }

    private void zF() {
        this.aDB = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GiftPanelTabGalleryFragment.this.aCG = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aDB);
    }
}
