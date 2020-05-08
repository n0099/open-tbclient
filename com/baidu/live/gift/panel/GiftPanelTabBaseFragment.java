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
    protected boolean aCG;
    private AlaGiftTabView.d aCX = new AlaGiftTabView.d() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.d
        public void yk() {
            GiftPanelTabBaseFragment.this.zD();
        }
    };
    private AlaGiftTabView.a aGP;
    public AlaGiftTabView aGZ;
    protected c.a aHa;
    protected d aHb;
    private int aHc;

    protected abstract boolean zB();

    protected abstract boolean zC();

    protected abstract void zD();

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
        this.aHa = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.aGP = aVar;
    }

    public void b(d dVar) {
        this.aHb = dVar;
    }

    public void bQ(int i) {
        if (this.aGZ != null) {
            this.aGZ.bQ(i);
        } else {
            this.aHc = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aGZ = new AlaGiftTabView(getPageContext(), zy(), zA(), this.aHb.otherParams);
        this.aGZ.a(this.aGP);
        if (this.aHc != 0) {
            this.aGZ.bQ(this.aHc);
        }
        this.aGZ.Z(this.aHb.mLiveId, this.aHb.mRoomId);
        this.aGZ.s(this.aHb.aDk, this.aHb.aDl);
        this.aGZ.X(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aGZ.Y(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aGZ.a(this.aCX);
        this.aGZ.ba(this.aHb.aBx);
        this.aGZ.bY(this.aHb.aBv);
        this.aCG = this.aHb.aCG;
        this.aGZ.bg(this.aHb.aCG);
        this.aGZ.b(this.aHb.isNewUser, this.aHb.mLiveId, this.aHb.mRoomId, this.aHb.aEn);
        this.aGZ.aM(this.aHb.aEr);
        this.aGZ.bu(this.aHb.aDm);
        this.aGZ.bi(this.aHb.aDv);
        this.aGZ.bR(this.aHb.aEs);
        this.aGZ.aO(this.aHb.aBC);
        return this.aGZ.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aGZ.bf(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aGZ.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.aGZ.bh(isPrimary());
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aGZ != null) {
            this.aGZ.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.aGP = null;
        this.aHa = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aHb.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener zy() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.aGZ.aCJ);
                    if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.zz()) {
                        if (GiftPanelTabBaseFragment.this.zB()) {
                            g yf = GiftPanelTabBaseFragment.this.aGZ.yf();
                            if (GiftPanelTabBaseFragment.this.zC() && yf.wd()) {
                                if (!yf.wb() || (yf.wb() && GiftPanelTabBaseFragment.this.aGZ.yg() == 1)) {
                                    GiftPanelTabBaseFragment.this.aGZ.xD();
                                    GiftPanelTabBaseFragment.this.aGZ.bn(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && GiftPanelTabBaseFragment.this.zz()) {
                        GiftPanelTabBaseFragment.this.aGZ.xC();
                        if (GiftPanelTabBaseFragment.this.zB()) {
                            GiftPanelTabBaseFragment.this.zC();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.zz()) {
                        if (GiftPanelTabBaseFragment.this.aHb.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.En().Eq()) {
                            String str3 = com.baidu.live.v.a.En().aRB.avA.aww.awC;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.aHb.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.aHb.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.aHb.mLiveId, GiftPanelTabBaseFragment.this.aHb.mRoomId, GiftPanelTabBaseFragment.this.aHb.aEn, GiftPanelTabBaseFragment.this.aHb.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.aHb.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.zz() && TbadkCoreApplication.getInst().isRegistedIntent(f.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zz() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean zA() {
        return ("ala_tieba_android_consume".equals(this.aHb.aEp) || StringUtils.isNull(this.aHb.aEp) || this.aHb.aEp.equals(com.baidu.live.gift.b.b.yS().xa())) ? false : true;
    }
}
