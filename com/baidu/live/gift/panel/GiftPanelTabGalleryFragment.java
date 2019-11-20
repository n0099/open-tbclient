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
    private d adx;
    private CustomMessageListener ady;
    private long adv = 0;
    private long adw = 0;
    private d.a YP = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.4
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.adr.a(z, arrayList, arrayList2, arrayList3, true);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.adr.setType(0);
        this.adr.Zm.setSelect(0);
        this.adr.Zm.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bu(int i) {
                if (GiftPanelTabGalleryFragment.this.ads != null) {
                    GiftPanelTabGalleryFragment.this.ads.ry();
                }
            }
        });
        this.adr.Zq.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.adv = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.adw = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        rG();
        this.adx = new d(getPageContext(), this.adt.aaO);
        this.adx.a(this.YP);
        this.adx.cq(this.adt.aaN);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ady);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rD() {
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean rE() {
        g qu = this.adr.qu();
        if (qu == null) {
            return false;
        }
        int i = this.adt.XT;
        if (qu.ps()) {
            if (qu.pp() == 6 && i < 3) {
                return false;
            }
            if (qu.pp() == 7 && i < 7) {
                return false;
            }
            if (qu.pp() == 8 && i < 13) {
                return false;
            }
            if (qu.pp() == 9 && i < 22) {
                return false;
            }
            if (qu.pp() == 10 && i < 29) {
                return false;
            }
            if (qu.pp() == 11 && i < 39) {
                return false;
            }
            if (qu.pp() == 12 && i < 47) {
                return false;
            }
        }
        int qw = this.adr.qw();
        if (a(qu, qw)) {
            if (qu.pk()) {
                if (this.adv <= 0 || this.adv < JavaTypesHelper.toLong(qu.getPrice(), 0L) * qw) {
                    rz();
                    return false;
                }
                qu.Wq = this.adr.qv();
                qu.Wq.WV = qu.ph();
                com.baidu.live.gift.b.b.rd().b(qu, qw, this.adt.mUserId, this.adt.mUserName, this.adt.mLiveId, this.adt.aaK, this.adt.mAppId, this.adt.aaL, this.adt.otherParams);
                this.adv -= JavaTypesHelper.toLong(qu.getPrice(), 0L) * qw;
                this.adr.w(this.adv);
                closeActivity();
            } else if (qu.pm()) {
                if (this.adw <= 0 || this.adw < JavaTypesHelper.toLong(qu.getPrice(), 0L) * qw) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.rd().b(qu, qw, this.adt.mUserId, this.adt.mUserName, this.adt.mLiveId, this.adt.aaK, this.adt.mAppId, this.adt.aaL, this.adt.otherParams);
                this.adw -= JavaTypesHelper.toLong(qu.getPrice(), 0L) * qw;
                this.adr.x(this.adw);
            } else if (this.adv <= 0 || this.adv < JavaTypesHelper.toLong(qu.getPrice(), 0L) * qw) {
                rz();
                return false;
            } else {
                com.baidu.live.gift.b.b.rd().b(qu, qw, this.adt.mUserId, this.adt.mUserName, this.adt.mLiveId, this.adt.aaK, this.adt.mAppId, this.adt.aaL, this.adt.otherParams);
                this.adv -= JavaTypesHelper.toLong(qu.getPrice(), 0L) * qw;
                this.adr.w(this.adv);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void rF() {
        this.adx.cr(this.adt.aaN);
        this.adr.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GiftPanelTabGalleryFragment.this.adx.qj();
            }
        });
    }

    private void rG() {
        this.ady = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.adr != null) {
                    GiftPanelTabGalleryFragment.this.adv = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.adw = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.adr.w(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.adr.x(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ady);
    }
}
