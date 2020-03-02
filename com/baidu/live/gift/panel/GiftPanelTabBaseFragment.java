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
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.fragment.ILazyLoadFragmentController;
import com.baidu.live.tbadk.core.fragment.LazyLoadFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public abstract class GiftPanelTabBaseFragment extends LazyLoadFragment {
    protected boolean ajJ;
    private AlaGiftTabView.c aki = new AlaGiftTabView.c() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.3
        @Override // com.baidu.live.gift.container.AlaGiftTabView.c
        public void tM() {
            GiftPanelTabBaseFragment.this.vb();
        }
    };
    protected AlaGiftTabView aop;
    protected c.a aoq;
    protected d aor;

    protected abstract boolean uZ();

    protected abstract boolean va();

    protected abstract void vb();

    public static GiftPanelTabBaseFragment bO(int i) {
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
        this.aoq = aVar;
    }

    public void a(d dVar) {
        this.aor = dVar;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aop = new AlaGiftTabView(getPageContext(), uW(), uY(), this.aor.otherParams);
        this.aop.W(this.aor.mLiveId, this.aor.mRoomId);
        this.aop.t(this.aor.akA, this.aor.akB);
        this.aop.z(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aop.A(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aop.a(this.aki);
        this.aop.aC(this.aor.aiO);
        this.aop.bI(this.aor.aiM);
        this.ajJ = this.aor.ajJ;
        this.aop.aE(this.aor.ajJ);
        this.aop.b(this.aor.isNewUser, this.aor.mLiveId, this.aor.mRoomId, this.aor.alG);
        this.aop.bh(this.aor.akC);
        this.aop.aF(this.aor.akM);
        this.aop.bB(this.aor.alK);
        this.aop.aq(this.aor.aiT);
        return this.aop.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aop.aD(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aop.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aop != null) {
            this.aop.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aop.tx()) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            GiftPanelTabBaseFragment.this.aop.tz();
                            e.printStackTrace();
                        }
                    }
                });
                return true;
            } else if (view == this.aop.getRootView()) {
                return true;
            } else {
                closeActivity();
            }
        }
        return false;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.aop != null) {
            if (z) {
                Rect rect = new Rect();
                this.aop.getRootView().getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize -= UtilHelper.getStatusBarHeight();
                }
                this.aop.bE(dimensionPixelSize);
                this.aop.ajK.setVisibility(8);
                this.aop.tA().setVisibility(0);
                return;
            }
            this.aop.ajK.setVisibility(0);
            this.aop.tA().setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        if (this.aop.tx()) {
            this.aop.tz();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        if (this.aor.alH == 2) {
            showToast(a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (this.aor.alH == 1) {
            showToast(a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.rD();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aor.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener uW() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.aop.ajO);
                    if (view.getId() == a.g.ala_gift_draw_hide_btn) {
                        GiftPanelTabBaseFragment.this.closeActivity();
                    } else if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.uX()) {
                        if (GiftPanelTabBaseFragment.this.uZ()) {
                            g tE = GiftPanelTabBaseFragment.this.aop.tE();
                            if (GiftPanelTabBaseFragment.this.va() && tE.rG()) {
                                if (!tE.rE() || (tE.rE() && GiftPanelTabBaseFragment.this.aop.tH() == 1)) {
                                    GiftPanelTabBaseFragment.this.aop.tg();
                                    GiftPanelTabBaseFragment.this.aop.aL(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && GiftPanelTabBaseFragment.this.uX()) {
                        GiftPanelTabBaseFragment.this.aop.tf();
                        if (GiftPanelTabBaseFragment.this.uZ()) {
                            GiftPanelTabBaseFragment.this.va();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.uX()) {
                        if (GiftPanelTabBaseFragment.this.aor.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.zl().zo()) {
                            String str3 = com.baidu.live.v.a.zl().axC.acS.adP.adW;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.aor.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.aor.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.aor.mLiveId, GiftPanelTabBaseFragment.this.aor.mRoomId, GiftPanelTabBaseFragment.this.aor.alG, GiftPanelTabBaseFragment.this.aor.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.aor.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.uX() && TbadkCoreApplication.getInst().isRegistedIntent(f.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uX() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean uY() {
        return ("ala_tieba_android_consume".equals(this.aor.alI) || StringUtils.isNull(this.aor.alI) || this.aor.alI.equals(com.baidu.live.gift.b.b.uu().sD())) ? false : true;
    }
}
