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
    private CustomMessageListener akW;
    private d aow;
    private CustomMessageListener aox;
    private long aou = 0;
    private long aov = 0;
    private d.a ajG = new d.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.5
        @Override // com.baidu.live.gift.container.d.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<e> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftPanelTabGalleryFragment.this.showToast(str);
            }
            GiftPanelTabGalleryFragment.this.aoq.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
        }
    };

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aoq.setType(0);
        this.aoq.aka.setSelect(0);
        this.aoq.aka.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.1
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void bP(int i) {
                if (GiftPanelTabGalleryFragment.this.aor != null) {
                    GiftPanelTabGalleryFragment.this.aor.uU();
                }
            }
        });
        this.aoq.ake.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aou = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aov = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        vc();
        vd();
        this.aow = new d(getPageContext(), this.aos.alK);
        this.aow.a(this.ajG);
        this.aow.dv(this.aos.alJ);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aox);
        MessageManager.getInstance().unRegisterListener(this.akW);
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean uZ() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.v.a.zl().axD != null && com.baidu.live.v.a.zl().axD.acR != null) {
            String str = com.baidu.live.v.a.zl().axD.acR.acc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.rT()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected boolean va() {
        g tE = this.aoq.tE();
        if (tE == null) {
            return false;
        }
        if (b(tE) && !this.ajK) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aos.aiM;
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
        int tH = this.aoq.tH();
        if (a(tE, tH)) {
            if (tE.rF()) {
                if (this.aou <= 0 || this.aou < JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH) {
                    uV();
                    return false;
                }
                tE.ags = this.aoq.tG();
                tE.ags.ahp = tE.rC();
                com.baidu.live.gift.b.b.uu().a(tE, tH, this.aos.mUserId, this.aos.mUserName, this.aos.mLiveId, this.aos.mRoomId, this.aos.mAppId, this.aos.alH, this.aos.otherParams);
                this.aou -= JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH;
                this.aoq.z(this.aou);
                closeActivity();
            } else if (tE.rI()) {
                if (this.aov <= 0 || this.aov < JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.uu().a(tE, tH, this.aos.mUserId, this.aos.mUserName, this.aos.mLiveId, this.aos.mRoomId, this.aos.mAppId, this.aos.alH, this.aos.otherParams);
                this.aov -= JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH;
                this.aoq.A(this.aov);
            } else if (this.aou <= 0 || this.aou < JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH) {
                uV();
                return false;
            } else {
                com.baidu.live.gift.b.b.uu().a(tE, tH, this.aos.mUserId, this.aos.mUserName, this.aos.mLiveId, this.aos.mRoomId, this.aos.mAppId, this.aos.alH, this.aos.otherParams);
                this.aou -= JavaTypesHelper.toLong(tE.getPrice(), 0L) * tH;
                this.aoq.z(this.aou);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.GiftPanelTabBaseFragment
    protected void vb() {
        this.aow.dw(this.aos.alJ);
        this.aoq.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GiftPanelTabGalleryFragment.this.aow.ts();
            }
        });
    }

    private void vc() {
        this.aox = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabGalleryFragment.this.aoq != null) {
                    GiftPanelTabGalleryFragment.this.aou = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    GiftPanelTabGalleryFragment.this.aov = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    GiftPanelTabGalleryFragment.this.aoq.z(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    GiftPanelTabGalleryFragment.this.aoq.A(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aox);
    }

    private void vd() {
        this.akW = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.GiftPanelTabGalleryFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GiftPanelTabGalleryFragment.this.ajK = true;
            }
        };
        MessageManager.getInstance().registerListener(this.akW);
    }
}
