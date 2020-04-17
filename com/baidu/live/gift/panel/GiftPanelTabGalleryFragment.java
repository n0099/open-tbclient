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
    private CustomMessageListener aDv;
    private d aHa;
    private CustomMessageListener aHb;
    private long aGY = 0;
    private long aGZ = 0;
    private d.a aCw = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<e> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.aGT.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aGT.setType(0);
        this.aGT.aCO.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aGY = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aGZ = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        zF();
        zG();
        this.aHa = new d(getPageContext(), this.aGV.aEk);
        this.aHa.a(this.aCw);
        this.aHa.en(this.aGV.aEj);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aHb);
        MessageManager.getInstance().unRegisterListener(this.aDv);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zC() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.v.a.Eo().aRw != null && com.baidu.live.v.a.Eo().aRw.avt != null) {
            String str = com.baidu.live.v.a.Eo().aRw.avt.auJ;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.wr()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean zD() {
        g yg = this.aGT.yg();
        if (yg == null) {
            return false;
        }
        if (b(yg) && !this.aCA) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aGV.aBp;
        if (yg.wv()) {
            if (yg.wr() == 6 && i < 3) {
                return false;
            }
            if (yg.wr() == 7 && i < 7) {
                return false;
            }
            if (yg.wr() == 8 && i < 13) {
                return false;
            }
            if (yg.wr() == 9 && i < 22) {
                return false;
            }
            if (yg.wr() == 10 && i < 29) {
                return false;
            }
            if (yg.wr() == 11 && i < 39) {
                return false;
            }
            if (yg.wr() == 12 && i < 47) {
                return false;
            }
        }
        int yh = this.aGT.yh();
        if (a(yg, yh)) {
            if (yg.wd()) {
                if (this.aGY <= 0 || this.aGY < JavaTypesHelper.toLong(yg.getPrice(), 0L) * yh) {
                    zy();
                    return false;
                }
                yg.ayS = this.aGU != null ? this.aGU.xL() : null;
                if (yg.ayS == null) {
                    return false;
                }
                yg.ayS.azT = yg.wa();
                com.baidu.live.gift.b.b.yT().a(yg, yh, this.aGV.mUserId, this.aGV.mUserName, this.aGV.mLiveId, this.aGV.mRoomId, this.aGV.mAppId, this.aGV.aEh, this.aGV.otherParams, 0L);
                this.aGY -= JavaTypesHelper.toLong(yg.getPrice(), 0L) * yh;
                this.aGT.X(this.aGY);
                closeActivity();
            } else if (yg.wg()) {
                if (this.aGZ <= 0 || this.aGZ < JavaTypesHelper.toLong(yg.getPrice(), 0L) * yh) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.yT().a(yg, yh, this.aGV.mUserId, this.aGV.mUserName, this.aGV.mLiveId, this.aGV.mRoomId, this.aGV.mAppId, this.aGV.aEh, this.aGV.otherParams, 0L);
                this.aGZ -= JavaTypesHelper.toLong(yg.getPrice(), 0L) * yh;
                this.aGT.Y(this.aGZ);
            } else if (this.aGY <= 0 || this.aGY < JavaTypesHelper.toLong(yg.getPrice(), 0L) * yh) {
                zy();
                return false;
            } else {
                com.baidu.live.gift.b.b.yT().a(yg, yh, this.aGV.mUserId, this.aGV.mUserName, this.aGV.mLiveId, this.aGV.mRoomId, this.aGV.mAppId, this.aGV.aEh, this.aGV.otherParams, 0L);
                this.aGY -= JavaTypesHelper.toLong(yg.getPrice(), 0L) * yh;
                this.aGT.X(this.aGY);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void zE() {
        this.aHa.eo(this.aGV.aEj);
    }

    private void zF() {
        this.aHb = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.aGT != null) {
                    GiftPanelTabGalleryFragment.this.aGY = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.aGZ = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.aGT.X(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.aGT.Y(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aHb);
    }

    private void zG() {
        this.aDv = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GiftPanelTabGalleryFragment.this.aCA = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aDv);
    }
}
