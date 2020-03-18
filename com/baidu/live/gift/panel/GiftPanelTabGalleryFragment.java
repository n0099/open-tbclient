package com.baidu.live.gift.panel;

import android.content.DialogInterface;
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
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GiftPanelTabGalleryFragment extends GiftPanelTabBaseFragment {
    private CustomMessageListener alg;
    private d aoG;
    private CustomMessageListener aoH;
    private long aoE = 0;
    private long aoF = 0;
    private d.a ajQ = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.5
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<e> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.aoA.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aoA.setType(0);
        this.aoA.akk.setSelect(0);
        this.aoA.akk.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bP(int i) {
                if (GiftPanelTabGalleryFragment.this.aoB != null) {
                    GiftPanelTabGalleryFragment.this.aoB.uZ();
                }
            }
        });
        this.aoA.ako.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aoE = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aoF = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        vh();
        vi();
        this.aoG = new d(getPageContext(), this.aoC.alU);
        this.aoG.a(this.ajQ);
        this.aoG.du(this.aoC.alT);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aoH);
        MessageManager.getInstance().unRegisterListener(this.alg);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean ve() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.v.a.zs().axR != null && com.baidu.live.v.a.zs().axR.adb != null) {
            String str = com.baidu.live.v.a.zs().axR.adb.aco;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.rY()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean vf() {
        g tJ = this.aoA.tJ();
        if (tJ == null) {
            return false;
        }
        if (b(tJ) && !this.ajU) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aoC.aiW;
        if (tJ.sc()) {
            if (tJ.rY() == 6 && i < 3) {
                return false;
            }
            if (tJ.rY() == 7 && i < 7) {
                return false;
            }
            if (tJ.rY() == 8 && i < 13) {
                return false;
            }
            if (tJ.rY() == 9 && i < 22) {
                return false;
            }
            if (tJ.rY() == 10 && i < 29) {
                return false;
            }
            if (tJ.rY() == 11 && i < 39) {
                return false;
            }
            if (tJ.rY() == 12 && i < 47) {
                return false;
            }
        }
        int tM = this.aoA.tM();
        if (a(tJ, tM)) {
            if (tJ.rK()) {
                if (this.aoE <= 0 || this.aoE < JavaTypesHelper.toLong(tJ.getPrice(), 0L) * tM) {
                    va();
                    return false;
                }
                tJ.agC = this.aoA.tL();
                tJ.agC.ahz = tJ.rH();
                com.baidu.live.gift.b.b.uz().a(tJ, tM, this.aoC.mUserId, this.aoC.mUserName, this.aoC.mLiveId, this.aoC.mRoomId, this.aoC.mAppId, this.aoC.alR, this.aoC.otherParams);
                this.aoE -= JavaTypesHelper.toLong(tJ.getPrice(), 0L) * tM;
                this.aoA.z(this.aoE);
                closeActivity();
            } else if (tJ.rN()) {
                if (this.aoF <= 0 || this.aoF < JavaTypesHelper.toLong(tJ.getPrice(), 0L) * tM) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.uz().a(tJ, tM, this.aoC.mUserId, this.aoC.mUserName, this.aoC.mLiveId, this.aoC.mRoomId, this.aoC.mAppId, this.aoC.alR, this.aoC.otherParams);
                this.aoF -= JavaTypesHelper.toLong(tJ.getPrice(), 0L) * tM;
                this.aoA.A(this.aoF);
            } else if (this.aoE <= 0 || this.aoE < JavaTypesHelper.toLong(tJ.getPrice(), 0L) * tM) {
                va();
                return false;
            } else {
                com.baidu.live.gift.b.b.uz().a(tJ, tM, this.aoC.mUserId, this.aoC.mUserName, this.aoC.mLiveId, this.aoC.mRoomId, this.aoC.mAppId, this.aoC.alR, this.aoC.otherParams);
                this.aoE -= JavaTypesHelper.toLong(tJ.getPrice(), 0L) * tM;
                this.aoA.z(this.aoE);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void vg() {
        this.aoG.dv(this.aoC.alT);
        this.aoA.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GiftPanelTabGalleryFragment.this.aoG.tx();
            }
        });
    }

    private void vh() {
        this.aoH = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.aoA != null) {
                    GiftPanelTabGalleryFragment.this.aoE = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.aoF = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.aoA.z(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.aoA.A(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aoH);
    }

    private void vi() {
        this.alg = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GiftPanelTabGalleryFragment.this.ajU = true;
            }
        };
        MessageManager.getInstance().registerListener(this.alg);
    }
}
