package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.c.f;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.panel.c;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.fragment.ILazyLoadFragmentController;
import com.baidu.live.tbadk.core.fragment.LazyLoadFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public abstract class GiftPanelTabBaseFragment extends LazyLoadFragment {
    protected boolean aCA;
    private AlaGiftTabView.d aCR = new AlaGiftTabView.d() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.d
        public void yl() {
            GiftPanelTabBaseFragment.this.zE();
        }
    };
    private AlaGiftTabView.a aGJ;
    public AlaGiftTabView aGT;
    protected c.a aGU;
    protected d aGV;
    private int aGW;

    protected abstract boolean zC();

    protected abstract boolean zD();

    protected abstract void zE();

    public static GiftPanelTabBaseFragment ce(int i) {
        switch (i) {
            case 0:
                return new GiftPanelTabGalleryFragment();
            case 1:
                return new GiftPanelTabPackageFragment();
            default:
                return null;
        }
    }

    public void a(c.a aVar) {
        this.aGU = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.aGJ = aVar;
    }

    public void b(d dVar) {
        this.aGV = dVar;
    }

    public void bQ(int i) {
        if (this.aGT != null) {
            this.aGT.bQ(i);
        } else {
            this.aGW = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aGT = new AlaGiftTabView(getPageContext(), zz(), zB(), this.aGV.otherParams);
        this.aGT.a(this.aGJ);
        if (this.aGW != 0) {
            this.aGT.bQ(this.aGW);
        }
        this.aGT.Z(this.aGV.mLiveId, this.aGV.mRoomId);
        this.aGT.s(this.aGV.aDe, this.aGV.aDf);
        this.aGT.X(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aGT.Y(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aGT.a(this.aCR);
        this.aGT.ba(this.aGV.aBr);
        this.aGT.bY(this.aGV.aBp);
        this.aCA = this.aGV.aCA;
        this.aGT.bg(this.aGV.aCA);
        this.aGT.b(this.aGV.isNewUser, this.aGV.mLiveId, this.aGV.mRoomId, this.aGV.aEh);
        this.aGT.aM(this.aGV.aEl);
        this.aGT.bu(this.aGV.aDg);
        this.aGT.bi(this.aGV.aDp);
        this.aGT.bR(this.aGV.aEm);
        this.aGT.aO(this.aGV.aBw);
        return this.aGT.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aGT.bf(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aGT.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.aGT.bh(isPrimary());
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aGT != null) {
            this.aGT.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.aGJ = null;
        this.aGU = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aGV.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener zz() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.aGT.aCD);
                    if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.zA()) {
                        if (GiftPanelTabBaseFragment.this.zC()) {
                            g yg = GiftPanelTabBaseFragment.this.aGT.yg();
                            if (GiftPanelTabBaseFragment.this.zD() && yg.we()) {
                                if (!yg.wc() || (yg.wc() && GiftPanelTabBaseFragment.this.aGT.yh() == 1)) {
                                    GiftPanelTabBaseFragment.this.aGT.xE();
                                    GiftPanelTabBaseFragment.this.aGT.bn(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && GiftPanelTabBaseFragment.this.zA()) {
                        GiftPanelTabBaseFragment.this.aGT.xD();
                        if (GiftPanelTabBaseFragment.this.zC()) {
                            GiftPanelTabBaseFragment.this.zD();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.zA()) {
                        if (GiftPanelTabBaseFragment.this.aGV.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.Eo().Er()) {
                            String str3 = com.baidu.live.v.a.Eo().aRw.avu.awq.aww;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.aGV.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.aGV.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.aGV.mLiveId, GiftPanelTabBaseFragment.this.aGV.mRoomId, GiftPanelTabBaseFragment.this.aGV.aEh, GiftPanelTabBaseFragment.this.aGV.otherParams);
                            GiftPanelTabBaseFragment.this.closeActivity();
                            return;
                        }
                        if (view.getId() == a.g.current_recharge) {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                        } else if (view.getId() != a.g.current_money) {
                            str = "";
                        } else {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.aGV.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.zA() && TbadkCoreApplication.getInst().isRegistedIntent(f.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean zB() {
        return ("ala_tieba_android_consume".equals(this.aGV.aEj) || StringUtils.isNull(this.aGV.aEj) || this.aGV.aEj.equals(com.baidu.live.gift.b.b.yT().xb())) ? false : true;
    }
}
