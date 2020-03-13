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
    protected boolean ajK;
    private AlaGiftTabView.c akj = new AlaGiftTabView.c() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.3
        @Override // com.baidu.live.gift.container.AlaGiftTabView.c
        public void tM() {
            GiftPanelTabBaseFragment.this.vb();
        }
    };
    protected AlaGiftTabView aoq;
    protected c.a aor;
    protected d aos;

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
        this.aor = aVar;
    }

    public void a(d dVar) {
        this.aos = dVar;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aoq = new AlaGiftTabView(getPageContext(), uW(), uY(), this.aos.otherParams);
        this.aoq.W(this.aos.mLiveId, this.aos.mRoomId);
        this.aoq.t(this.aos.akB, this.aos.akC);
        this.aoq.z(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aoq.A(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aoq.a(this.akj);
        this.aoq.aC(this.aos.aiO);
        this.aoq.bI(this.aos.aiM);
        this.ajK = this.aos.ajK;
        this.aoq.aE(this.aos.ajK);
        this.aoq.b(this.aos.isNewUser, this.aos.mLiveId, this.aos.mRoomId, this.aos.alH);
        this.aoq.bh(this.aos.akD);
        this.aoq.aF(this.aos.akN);
        this.aoq.bB(this.aos.alL);
        this.aoq.aq(this.aos.aiT);
        return this.aoq.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aoq.aD(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aoq.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aoq != null) {
            this.aoq.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aoq.tx()) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            GiftPanelTabBaseFragment.this.aoq.tz();
                            e.printStackTrace();
                        }
                    }
                });
                return true;
            } else if (view == this.aoq.getRootView()) {
                return true;
            } else {
                closeActivity();
            }
        }
        return false;
    }

    public void e(boolean z, boolean z2) {
        if (this.aoq != null) {
            if (z) {
                Rect rect = new Rect();
                this.aoq.getRootView().getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize -= UtilHelper.getStatusBarHeight();
                }
                this.aoq.bE(dimensionPixelSize);
                this.aoq.ajL.setVisibility(8);
                if (!z2) {
                    this.aoq.tA().setVisibility(0);
                    return;
                }
                return;
            }
            this.aoq.ajL.setVisibility(0);
            this.aoq.tA().setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        if (this.aoq.tx()) {
            this.aoq.tz();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        if (this.aos.alI == 2) {
            showToast(a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (this.aos.alI == 1) {
            showToast(a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.rD();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aos.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
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
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.aoq.ajP);
                    if (view.getId() == a.g.ala_gift_draw_hide_btn) {
                        GiftPanelTabBaseFragment.this.closeActivity();
                    } else if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.uX()) {
                        if (GiftPanelTabBaseFragment.this.uZ()) {
                            g tE = GiftPanelTabBaseFragment.this.aoq.tE();
                            if (GiftPanelTabBaseFragment.this.va() && tE.rG()) {
                                if (!tE.rE() || (tE.rE() && GiftPanelTabBaseFragment.this.aoq.tH() == 1)) {
                                    GiftPanelTabBaseFragment.this.aoq.tg();
                                    GiftPanelTabBaseFragment.this.aoq.aL(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && GiftPanelTabBaseFragment.this.uX()) {
                        GiftPanelTabBaseFragment.this.aoq.tf();
                        if (GiftPanelTabBaseFragment.this.uZ()) {
                            GiftPanelTabBaseFragment.this.va();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.uX()) {
                        if (GiftPanelTabBaseFragment.this.aos.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.zl().zo()) {
                            String str3 = com.baidu.live.v.a.zl().axD.acS.adP.adW;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.aos.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.aos.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.aos.mLiveId, GiftPanelTabBaseFragment.this.aos.mRoomId, GiftPanelTabBaseFragment.this.aos.alH, GiftPanelTabBaseFragment.this.aos.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.aos.otherParams, true, str, false)));
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
        return ("ala_tieba_android_consume".equals(this.aos.alJ) || StringUtils.isNull(this.aos.alJ) || this.aos.alJ.equals(com.baidu.live.gift.b.b.uu().sD())) ? false : true;
    }
}
