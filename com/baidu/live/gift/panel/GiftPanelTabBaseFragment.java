package com.baidu.live.gift.panel;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.d;
import com.baidu.live.gift.a.e;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.panel.c;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.fragment.ILazyLoadFragmentController;
import com.baidu.live.tbadk.core.fragment.LazyLoadFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
/* loaded from: classes6.dex */
public abstract class GiftPanelTabBaseFragment extends LazyLoadFragment {
    private AlaGiftTabView.c ZM = new AlaGiftTabView.c() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.c
        public void qz() {
            GiftPanelTabBaseFragment.this.rE();
        }
    };
    protected AlaGiftTabView adJ;
    protected c.a adK;
    protected e adL;

    protected abstract boolean rC();

    protected abstract boolean rD();

    protected abstract void rE();

    public static GiftPanelTabBaseFragment bt(int i) {
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
        this.adK = aVar;
    }

    public void a(e eVar) {
        this.adL = eVar;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.adJ = new AlaGiftTabView(getPageContext(), rz(), rB(), this.adL.otherParams);
        this.adJ.p(this.adL.aae, this.adL.aaf);
        this.adJ.x(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.adJ.y(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.adJ.a(this.ZM);
        this.adJ.ak(this.adL.Yn);
        this.adJ.bo(this.adL.Yl);
        this.adJ.am(this.adL.Zn);
        this.adJ.b(this.adL.isNewUser, this.adL.mLiveId, this.adL.abd, this.adL.abe);
        this.adJ.aP(this.adL.aah);
        return this.adJ.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.adJ.al(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.adJ.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.adJ != null) {
            this.adJ.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.adJ.qm()) {
                this.adJ.qo();
                return true;
            } else if (view == this.adJ.getRootView()) {
                return true;
            } else {
                closeActivity();
            }
        }
        return false;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.adJ != null) {
            if (z) {
                Rect rect = new Rect();
                this.adJ.getRootView().getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize -= UtilHelper.getStatusBarHeight();
                }
                this.adJ.bk(dimensionPixelSize);
                this.adJ.qp().setVisibility(0);
                return;
            }
            this.adJ.qp().setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        if (this.adJ.qm()) {
            this.adJ.qo();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        if (this.adL.abf == 2) {
            showToast(a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (this.adL.abf == 1) {
            showToast(a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.pi();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ry() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.adL.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener rz() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.adJ.Zt);
                    if (view.getId() == a.g.ala_gift_draw_hide_btn) {
                        GiftPanelTabBaseFragment.this.closeActivity();
                    } else if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.rA()) {
                        if (GiftPanelTabBaseFragment.this.rC()) {
                            GiftPanelTabBaseFragment.this.rD();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.rA()) {
                        if (GiftPanelTabBaseFragment.this.adL.isNewUser && view.getId() == a.g.current_recharge && com.baidu.live.l.a.uA().uE()) {
                            String str3 = com.baidu.live.l.a.uA().akM.Ue.UM.US;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.adL.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.adL.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.adL.mLiveId, GiftPanelTabBaseFragment.this.adL.abd, GiftPanelTabBaseFragment.this.adL.abe, GiftPanelTabBaseFragment.this.adL.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.adL.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.rA()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new d(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean rB() {
        return ("ala_tieba_android_consume".equals(this.adL.abg) || StringUtils.isNull(this.adL.abg) || this.adL.abg.equals(com.baidu.live.gift.b.b.rc().rf())) ? false : true;
    }
}
