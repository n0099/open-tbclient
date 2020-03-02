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
    private CustomMessageListener akV;
    private d aov;
    private CustomMessageListener aow;
    private long aot = 0;
    private long aou = 0;
    private d.a ajF = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.5
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<e> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.aop.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aop.setType(0);
        this.aop.ajZ.setSelect(0);
        this.aop.ajZ.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bP(int i) {
                if (GiftPanelTabGalleryFragment.this.aoq != null) {
                    GiftPanelTabGalleryFragment.this.aoq.uU();
                }
            }
        });
        this.aop.akd.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aot = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aou = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        vc();
        vd();
        this.aov = new d(getPageContext(), this.aor.alJ);
        this.aov.a(this.ajF);
        this.aov.dv(this.aor.alI);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aow);
        MessageManager.getInstance().unRegisterListener(this.akV);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean uZ() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.v.a.zl().axC != null && com.baidu.live.v.a.zl().axC.acR != null) {
            String str = com.baidu.live.v.a.zl().axC.acR.acc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.rT()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean va() {
        g tE = this.aop.tE();
        if (tE == null) {
            return false;
        }
        if (b(tE) && !this.ajJ) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aor.aiM;
        if (tE.rX()) {
            if (tE.rT() == 6 && i < 3) {
                return false;
            }
            if (tE.rT() == 7 && i < 7) {
                return false;
            }
            if (tE.rT() == 8 && i < 13) {
                return false;
            }
            if (tE.rT() == 9 && i < 22) {
                return false;
            }
            if (tE.rT() == 10 && i < 29) {
                return false;
            }
            if (tE.rT() == 11 && i < 39) {
                return false;
            }
            if (tE.rT() == 12 && i < 47) {
                return false;
            }
        }
        int tH = this.aop.tH();
        if (a(tE, tH)) {
            if (tE.rF()) {
                if (this.aot <= 0 || this.aot < JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH) {
                    uV();
                    return false;
                }
                tE.ags = this.aop.tG();
                tE.ags.ahp = tE.rC();
                com.baidu.live.gift.b.b.uu().a(tE, tH, this.aor.mUserId, this.aor.mUserName, this.aor.mLiveId, this.aor.mRoomId, this.aor.mAppId, this.aor.alG, this.aor.otherParams);
                this.aot -= JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH;
                this.aop.z(this.aot);
                closeActivity();
            } else if (tE.rI()) {
                if (this.aou <= 0 || this.aou < JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.uu().a(tE, tH, this.aor.mUserId, this.aor.mUserName, this.aor.mLiveId, this.aor.mRoomId, this.aor.mAppId, this.aor.alG, this.aor.otherParams);
                this.aou -= JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH;
                this.aop.A(this.aou);
            } else if (this.aot <= 0 || this.aot < JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH) {
                uV();
                return false;
            } else {
                com.baidu.live.gift.b.b.uu().a(tE, tH, this.aor.mUserId, this.aor.mUserName, this.aor.mLiveId, this.aor.mRoomId, this.aor.mAppId, this.aor.alG, this.aor.otherParams);
                this.aot -= JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH;
                this.aop.z(this.aot);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void vb() {
        this.aov.dw(this.aor.alI);
        this.aop.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GiftPanelTabGalleryFragment.this.aov.ts();
            }
        });
    }

    private void vc() {
        this.aow = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.aop != null) {
                    GiftPanelTabGalleryFragment.this.aot = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.aou = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.aop.z(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.aop.A(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aow);
    }

    private void vd() {
        this.akV = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GiftPanelTabGalleryFragment.this.ajJ = true;
            }
        };
        MessageManager.getInstance().registerListener(this.akV);
    }
}
