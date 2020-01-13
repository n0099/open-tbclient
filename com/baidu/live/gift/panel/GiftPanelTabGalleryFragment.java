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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GiftPanelTabGalleryFragment extends GiftPanelTabBaseFragment {
    private d ami;
    private CustomMessageListener amj;
    private long amg = 0;
    private long amh = 0;
    private d.a ahw = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.4
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<com.baidu.live.data.d> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.amc.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.amc.setType(0);
        this.amc.ahS.setSelect(0);
        this.amc.ahS.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bI(int i) {
                if (GiftPanelTabGalleryFragment.this.amd != null) {
                    GiftPanelTabGalleryFragment.this.amd.tE();
                }
            }
        });
        this.amc.ahW.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.amg = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.amh = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        tM();
        this.ami = new d(getPageContext(), this.ame.ajB);
        this.ami.a(this.ahw);
        this.ami.dk(this.ame.ajA);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.amj);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean tJ() {
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean tK() {
        g ss = this.amc.ss();
        if (ss == null) {
            return false;
        }
        int i = this.ame.agD;
        if (ss.qW()) {
            if (ss.qS() == 6 && i < 3) {
                return false;
            }
            if (ss.qS() == 7 && i < 7) {
                return false;
            }
            if (ss.qS() == 8 && i < 13) {
                return false;
            }
            if (ss.qS() == 9 && i < 22) {
                return false;
            }
            if (ss.qS() == 10 && i < 29) {
                return false;
            }
            if (ss.qS() == 11 && i < 39) {
                return false;
            }
            if (ss.qS() == 12 && i < 47) {
                return false;
            }
        }
        int sv = this.amc.sv();
        if (a(ss, sv)) {
            if (ss.qM()) {
                if (this.amg <= 0 || this.amg < JavaTypesHelper.toLong(ss.getPrice(), 0L) * sv) {
                    tF();
                    return false;
                }
                ss.ael = this.amc.su();
                ss.ael.afi = ss.qJ();
                com.baidu.live.gift.b.b.ta().b(ss, sv, this.ame.mUserId, this.ame.mUserName, this.ame.mLiveId, this.ame.mRoomId, this.ame.mAppId, this.ame.ajy, this.ame.otherParams);
                this.amg -= JavaTypesHelper.toLong(ss.getPrice(), 0L) * sv;
                this.amc.y(this.amg);
                closeActivity();
            } else if (ss.qP()) {
                if (this.amh <= 0 || this.amh < JavaTypesHelper.toLong(ss.getPrice(), 0L) * sv) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.ta().b(ss, sv, this.ame.mUserId, this.ame.mUserName, this.ame.mLiveId, this.ame.mRoomId, this.ame.mAppId, this.ame.ajy, this.ame.otherParams);
                this.amh -= JavaTypesHelper.toLong(ss.getPrice(), 0L) * sv;
                this.amc.z(this.amh);
            } else if (this.amg <= 0 || this.amg < JavaTypesHelper.toLong(ss.getPrice(), 0L) * sv) {
                tF();
                return false;
            } else {
                com.baidu.live.gift.b.b.ta().b(ss, sv, this.ame.mUserId, this.ame.mUserName, this.ame.mLiveId, this.ame.mRoomId, this.ame.mAppId, this.ame.ajy, this.ame.otherParams);
                this.amg -= JavaTypesHelper.toLong(ss.getPrice(), 0L) * sv;
                this.amc.y(this.amg);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void tL() {
        this.ami.dl(this.ame.ajA);
        this.amc.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GiftPanelTabGalleryFragment.this.ami.sg();
            }
        });
    }

    private void tM() {
        this.amj = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.amc != null) {
                    GiftPanelTabGalleryFragment.this.amg = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.amh = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.amc.y(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.amc.z(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.amj);
    }
}
