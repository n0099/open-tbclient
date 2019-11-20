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
    private AlaGiftTabView.c Zu = new AlaGiftTabView.c() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.c
        public void qA() {
            GiftPanelTabBaseFragment.this.rF();
        }
    };
    protected AlaGiftTabView adr;
    protected c.a ads;
    protected e adt;

    protected abstract boolean rD();

    protected abstract boolean rE();

    protected abstract void rF();

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
        this.ads = aVar;
    }

    public void a(e eVar) {
        this.adt = eVar;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.adr = new AlaGiftTabView(getPageContext(), rA(), rC(), this.adt.otherParams);
        this.adr.n(this.adt.ZM, this.adt.ZN);
        this.adr.w(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.adr.x(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.adr.a(this.Zu);
        this.adr.ak(this.adt.XV);
        this.adr.bo(this.adt.XT);
        this.adr.am(this.adt.YV);
        this.adr.b(this.adt.isNewUser, this.adt.mLiveId, this.adt.aaK, this.adt.aaL);
        this.adr.aP(this.adt.ZP);
        return this.adr.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.adr.al(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.adr.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.adr != null) {
            this.adr.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.adr.qn()) {
                this.adr.qp();
                return true;
            } else if (view == this.adr.getRootView()) {
                return true;
            } else {
                closeActivity();
            }
        }
        return false;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.adr != null) {
            if (z) {
                Rect rect = new Rect();
                this.adr.getRootView().getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize -= UtilHelper.getStatusBarHeight();
                }
                this.adr.bk(dimensionPixelSize);
                this.adr.qq().setVisibility(0);
                return;
            }
            this.adr.qq().setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        if (this.adr.qn()) {
            this.adr.qp();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        if (this.adt.aaM == 2) {
            showToast(a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (this.adt.aaM == 1) {
            showToast(a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.pi();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rz() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.adt.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener rA() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.adr.Zb);
                    if (view.getId() == a.g.ala_gift_draw_hide_btn) {
                        GiftPanelTabBaseFragment.this.closeActivity();
                    } else if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.rB()) {
                        if (GiftPanelTabBaseFragment.this.rD()) {
                            GiftPanelTabBaseFragment.this.rE();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.rB()) {
                        if (GiftPanelTabBaseFragment.this.adt.isNewUser && view.getId() == a.g.current_recharge && com.baidu.live.l.a.uB().uF()) {
                            String str3 = com.baidu.live.l.a.uB().aku.TK.Ur.Uw;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.adt.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.adt.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.adt.mLiveId, GiftPanelTabBaseFragment.this.adt.aaK, GiftPanelTabBaseFragment.this.adt.aaL, GiftPanelTabBaseFragment.this.adt.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.adt.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.rB()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new d(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rB() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean rC() {
        return ("ala_tieba_android_consume".equals(this.adt.aaN) || StringUtils.isNull(this.adt.aaN) || this.adt.aaN.equals(com.baidu.live.gift.b.b.rd().rg())) ? false : true;
    }
}
