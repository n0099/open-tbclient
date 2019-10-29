package com.baidu.live.gift.panel;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.container.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class GiftPanelTabGalleryFragment extends GiftPanelTabBaseFragment {
    private d adP;
    private CustomMessageListener adQ;
    private long adN = 0;
    private long adO = 0;
    private d.a Zh = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.4
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.adJ.a(z, arrayList, arrayList2, arrayList3, true);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.adJ.setType(0);
        this.adJ.ZE.setSelect(0);
        this.adJ.ZE.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bu(int i) {
                if (GiftPanelTabGalleryFragment.this.adK != null) {
                    GiftPanelTabGalleryFragment.this.adK.rx();
                }
            }
        });
        this.adJ.ZI.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.adN = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.adO = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        rF();
        this.adP = new d(getPageContext(), this.adL.abh);
        this.adP.a(this.Zh);
        this.adP.cq(this.adL.abg);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.adQ);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rC() {
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rD() {
        g qt = this.adJ.qt();
        if (qt == null) {
            return false;
        }
        int i = this.adL.Yl;
        if (qt.ps()) {
            if (qt.pp() == 6 && i < 3) {
                return false;
            }
            if (qt.pp() == 7 && i < 7) {
                return false;
            }
            if (qt.pp() == 8 && i < 13) {
                return false;
            }
            if (qt.pp() == 9 && i < 22) {
                return false;
            }
            if (qt.pp() == 10 && i < 29) {
                return false;
            }
            if (qt.pp() == 11 && i < 39) {
                return false;
            }
            if (qt.pp() == 12 && i < 47) {
                return false;
            }
        }
        int qv = this.adJ.qv();
        if (a(qt, qv)) {
            if (qt.pk()) {
                if (this.adN <= 0 || this.adN < JavaTypesHelper.toLong(qt.getPrice(), 0L) * qv) {
                    ry();
                    return false;
                }
                qt.WJ = this.adJ.qu();
                qt.WJ.Xn = qt.ph();
                com.baidu.live.gift.b.b.rc().b(qt, qv, this.adL.mUserId, this.adL.mUserName, this.adL.mLiveId, this.adL.abd, this.adL.mAppId, this.adL.abe, this.adL.otherParams);
                this.adN -= JavaTypesHelper.toLong(qt.getPrice(), 0L) * qv;
                this.adJ.x(this.adN);
                closeActivity();
            } else if (qt.pm()) {
                if (this.adO <= 0 || this.adO < JavaTypesHelper.toLong(qt.getPrice(), 0L) * qv) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.rc().b(qt, qv, this.adL.mUserId, this.adL.mUserName, this.adL.mLiveId, this.adL.abd, this.adL.mAppId, this.adL.abe, this.adL.otherParams);
                this.adO -= JavaTypesHelper.toLong(qt.getPrice(), 0L) * qv;
                this.adJ.y(this.adO);
            } else if (this.adN <= 0 || this.adN < JavaTypesHelper.toLong(qt.getPrice(), 0L) * qv) {
                ry();
                return false;
            } else {
                com.baidu.live.gift.b.b.rc().b(qt, qv, this.adL.mUserId, this.adL.mUserName, this.adL.mLiveId, this.adL.abd, this.adL.mAppId, this.adL.abe, this.adL.otherParams);
                this.adN -= JavaTypesHelper.toLong(qt.getPrice(), 0L) * qv;
                this.adJ.x(this.adN);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void rE() {
        this.adP.cr(this.adL.abg);
        this.adJ.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GiftPanelTabGalleryFragment.this.adP.qi();
            }
        });
    }

    private void rF() {
        this.adQ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.adJ != null) {
                    GiftPanelTabGalleryFragment.this.adN = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.adO = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.adJ.x(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.adJ.y(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adQ);
    }
}
