package com.baidu.live.gift.panel;

import android.app.Instrumentation;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.fragment.ILazyLoadFragmentController;
import com.baidu.live.tbadk.core.fragment.LazyLoadFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
/* loaded from: classes2.dex */
public abstract class GiftPanelTabBaseFragment extends LazyLoadFragment {
    private AlaGiftTabView.c aib = new AlaGiftTabView.c() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.3
        @Override // com.baidu.live.gift.container.AlaGiftTabView.c
        public void sA() {
            GiftPanelTabBaseFragment.this.tL();
        }
    };
    protected AlaGiftTabView amc;
    protected c.a amd;
    protected d ame;

    protected abstract boolean tJ();

    protected abstract boolean tK();

    protected abstract void tL();

    public static GiftPanelTabBaseFragment bH(int i) {
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
        this.amd = aVar;
    }

    public void a(d dVar) {
        this.ame = dVar;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.amc = new AlaGiftTabView(getPageContext(), tG(), tI(), this.ame.otherParams);
        this.amc.R(this.ame.mLiveId, this.ame.mRoomId);
        this.amc.s(this.ame.aiu, this.ame.aiv);
        this.amc.y(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.amc.z(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.amc.a(this.aib);
        this.amc.az(this.ame.agF);
        this.amc.bB(this.ame.agD);
        this.amc.aB(this.ame.ahC);
        this.amc.b(this.ame.isNewUser, this.ame.mLiveId, this.ame.mRoomId, this.ame.ajy);
        this.amc.ba(this.ame.aiw);
        this.amc.aC(this.ame.aiG);
        this.amc.bu(this.ame.ajC);
        this.amc.an(this.ame.agK);
        return this.amc.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.amc.aA(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.amc.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.amc != null) {
            this.amc.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.amc.sl()) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            GiftPanelTabBaseFragment.this.amc.sn();
                            e.printStackTrace();
                        }
                    }
                });
                return true;
            } else if (view == this.amc.getRootView()) {
                return true;
            } else {
                closeActivity();
            }
        }
        return false;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.amc != null) {
            if (z) {
                Rect rect = new Rect();
                this.amc.getRootView().getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize -= UtilHelper.getStatusBarHeight();
                }
                this.amc.bx(dimensionPixelSize);
                this.amc.ahD.setVisibility(8);
                this.amc.so().setVisibility(0);
                return;
            }
            this.amc.ahD.setVisibility(0);
            this.amc.so().setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        if (this.amc.sl()) {
            this.amc.sn();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        if (this.ame.ajz == 2) {
            showToast(a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (this.ame.ajz == 1) {
            showToast(a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.qK();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tF() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.ame.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener tG() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.amc.ahH);
                    if (view.getId() == a.g.ala_gift_draw_hide_btn) {
                        GiftPanelTabBaseFragment.this.closeActivity();
                    } else if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.tH()) {
                        if (GiftPanelTabBaseFragment.this.tJ()) {
                            g ss = GiftPanelTabBaseFragment.this.amc.ss();
                            if (GiftPanelTabBaseFragment.this.tK() && ss.qN()) {
                                if (!ss.qL() || (ss.qL() && GiftPanelTabBaseFragment.this.amc.sv() == 1)) {
                                    GiftPanelTabBaseFragment.this.amc.rV();
                                    GiftPanelTabBaseFragment.this.amc.aI(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && GiftPanelTabBaseFragment.this.tH()) {
                        GiftPanelTabBaseFragment.this.amc.rU();
                        if (GiftPanelTabBaseFragment.this.tJ()) {
                            GiftPanelTabBaseFragment.this.tK();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.tH()) {
                        if (GiftPanelTabBaseFragment.this.ame.isNewUser && view.getId() == a.g.current_recharge && com.baidu.live.s.a.wR().wU()) {
                            String str3 = com.baidu.live.s.a.wR().atk.aaU.abK.abR;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.ame.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.ame.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.ame.mLiveId, GiftPanelTabBaseFragment.this.ame.mRoomId, GiftPanelTabBaseFragment.this.ame.ajy, GiftPanelTabBaseFragment.this.ame.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.ame.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.tH() && TbadkCoreApplication.getInst().isRegistedIntent(f.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean tI() {
        return ("ala_tieba_android_consume".equals(this.ame.ajA) || StringUtils.isNull(this.ame.ajA) || this.ame.ajA.equals(com.baidu.live.gift.b.b.ta().td())) ? false : true;
    }
}
