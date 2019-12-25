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
import com.baidu.live.gift.i;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GiftPanelTabGalleryFragment extends GiftPanelTabBaseFragment {
    private d alv;
    private CustomMessageListener alw;
    private long alt = 0;
    private long alu = 0;
    private d.a agN = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.4
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<com.baidu.live.data.d> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.alp.a(z, arrayList, arrayList2, arrayList3, i == 0);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.alp.setType(0);
        this.alp.ahj.setSelect(0);
        this.alp.ahj.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bI(int i) {
                if (GiftPanelTabGalleryFragment.this.alq != null) {
                    GiftPanelTabGalleryFragment.this.alq.tm();
                }
            }
        });
        this.alp.ahn.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.alt = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.alu = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        tv();
        this.alv = new d(getPageContext(), this.alr.aiR);
        this.alv.a(this.agN);
        this.alv.di(this.alr.aiQ);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.alw);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean ts() {
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean tt() {
        g sc = this.alp.sc();
        if (sc == null) {
            return false;
        }
        int i = this.alr.afT;
        if (sc.qP()) {
            if (sc.qL() == 6 && i < 3) {
                return false;
            }
            if (sc.qL() == 7 && i < 7) {
                return false;
            }
            if (sc.qL() == 8 && i < 13) {
                return false;
            }
            if (sc.qL() == 9 && i < 22) {
                return false;
            }
            if (sc.qL() == 10 && i < 29) {
                return false;
            }
            if (sc.qL() == 11 && i < 39) {
                return false;
            }
            if (sc.qL() == 12 && i < 47) {
                return false;
            }
        }
        int sf = this.alp.sf();
        if (a(sc, sf)) {
            if (sc.qF()) {
                if (this.alt <= 0 || this.alt < JavaTypesHelper.toLong(sc.getPrice(), 0L) * sf) {
                    tn();
                    return false;
                }
                sc.adW = this.alp.se();
                sc.adW.aez = sc.qC();
                com.baidu.live.gift.b.b.sK().b(sc, sf, this.alr.mUserId, this.alr.mUserName, this.alr.mLiveId, this.alr.aiN, this.alr.mAppId, this.alr.aiO, this.alr.otherParams);
                this.alt -= JavaTypesHelper.toLong(sc.getPrice(), 0L) * sf;
                this.alp.y(this.alt);
                closeActivity();
            } else if (sc.qI()) {
                if (this.alu <= 0 || this.alu < JavaTypesHelper.toLong(sc.getPrice(), 0L) * sf) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.sK().b(sc, sf, this.alr.mUserId, this.alr.mUserName, this.alr.mLiveId, this.alr.aiN, this.alr.mAppId, this.alr.aiO, this.alr.otherParams);
                this.alu -= JavaTypesHelper.toLong(sc.getPrice(), 0L) * sf;
                this.alp.z(this.alu);
            } else if (this.alt <= 0 || this.alt < JavaTypesHelper.toLong(sc.getPrice(), 0L) * sf) {
                tn();
                return false;
            } else {
                com.baidu.live.gift.b.b.sK().b(sc, sf, this.alr.mUserId, this.alr.mUserName, this.alr.mLiveId, this.alr.aiN, this.alr.mAppId, this.alr.aiO, this.alr.otherParams);
                this.alt -= JavaTypesHelper.toLong(sc.getPrice(), 0L) * sf;
                this.alp.y(this.alt);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void tu() {
        this.alv.dj(this.alr.aiQ);
        this.alp.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GiftPanelTabGalleryFragment.this.alv.rQ();
            }
        });
    }

    private void tv() {
        this.alw = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.alp != null) {
                    GiftPanelTabGalleryFragment.this.alt = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.alu = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.alp.y(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.alp.z(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alw);
    }
}
