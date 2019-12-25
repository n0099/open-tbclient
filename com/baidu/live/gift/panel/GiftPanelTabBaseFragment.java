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
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.panel.c;
import com.baidu.live.q.a;
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
    private AlaGiftTabView.c ahs = new AlaGiftTabView.c() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.3
        @Override // com.baidu.live.gift.container.AlaGiftTabView.c
        public void sk() {
            GiftPanelTabBaseFragment.this.tu();
        }
    };
    protected AlaGiftTabView alp;
    protected c.a alq;
    protected com.baidu.live.gift.a.c alr;

    protected abstract boolean ts();

    protected abstract boolean tt();

    protected abstract void tu();

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
        this.alq = aVar;
    }

    public void a(com.baidu.live.gift.a.c cVar) {
        this.alr = cVar;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.alp = new AlaGiftTabView(getPageContext(), tp(), tr(), this.alr.otherParams);
        this.alp.S(this.alr.mLiveId, this.alr.aiN);
        this.alp.o(this.alr.ahK, this.alr.ahL);
        this.alp.y(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.alp.z(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.alp.a(this.ahs);
        this.alp.ax(this.alr.afV);
        this.alp.bB(this.alr.afT);
        this.alp.az(this.alr.agT);
        this.alp.b(this.alr.isNewUser, this.alr.mLiveId, this.alr.aiN, this.alr.aiO);
        this.alp.ba(this.alr.ahM);
        this.alp.aA(this.alr.ahX);
        this.alp.bu(this.alr.aiS);
        this.alp.an(this.alr.aga);
        return this.alp.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.alp.ay(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.alp.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.alp != null) {
            this.alp.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.alp.rV()) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            GiftPanelTabBaseFragment.this.alp.rX();
                            e.printStackTrace();
                        }
                    }
                });
                return true;
            } else if (view == this.alp.getRootView()) {
                return true;
            } else {
                closeActivity();
            }
        }
        return false;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.alp != null) {
            if (z) {
                Rect rect = new Rect();
                this.alp.getRootView().getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize -= UtilHelper.getStatusBarHeight();
                }
                this.alp.bx(dimensionPixelSize);
                this.alp.agU.setVisibility(8);
                this.alp.rY().setVisibility(0);
                return;
            }
            this.alp.agU.setVisibility(0);
            this.alp.rY().setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        if (this.alp.rV()) {
            this.alp.rX();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        if (this.alr.aiP == 2) {
            showToast(a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (this.alr.aiP == 1) {
            showToast(a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.qD();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.alr.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener tp() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.alp.agY);
                    if (view.getId() == a.g.ala_gift_draw_hide_btn) {
                        GiftPanelTabBaseFragment.this.closeActivity();
                    } else if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.tq()) {
                        if (GiftPanelTabBaseFragment.this.ts()) {
                            g sc = GiftPanelTabBaseFragment.this.alp.sc();
                            if (GiftPanelTabBaseFragment.this.tt() && sc.qG()) {
                                if (!sc.qE() || (sc.qE() && GiftPanelTabBaseFragment.this.alp.sf() == 1)) {
                                    GiftPanelTabBaseFragment.this.alp.rI();
                                    GiftPanelTabBaseFragment.this.alp.aG(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && GiftPanelTabBaseFragment.this.tq()) {
                        GiftPanelTabBaseFragment.this.alp.rH();
                        if (GiftPanelTabBaseFragment.this.ts()) {
                            GiftPanelTabBaseFragment.this.tt();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.tq()) {
                        if (GiftPanelTabBaseFragment.this.alr.isNewUser && view.getId() == a.g.current_recharge && com.baidu.live.r.a.wA().wD()) {
                            String str3 = com.baidu.live.r.a.wA().asy.aaH.abz.abG;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.alr.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.alr.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.alr.mLiveId, GiftPanelTabBaseFragment.this.alr.aiN, GiftPanelTabBaseFragment.this.alr.aiO, GiftPanelTabBaseFragment.this.alr.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.alr.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.tq() && TbadkCoreApplication.getInst().isRegistedIntent(f.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tq() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean tr() {
        return ("ala_tieba_android_consume".equals(this.alr.aiQ) || StringUtils.isNull(this.alr.aiQ) || this.alr.aiQ.equals(com.baidu.live.gift.b.b.sK().sN())) ? false : true;
    }
}
