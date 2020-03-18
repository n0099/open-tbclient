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
    protected boolean ajU;
    private AlaGiftTabView.c akt = new AlaGiftTabView.c() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.3
        @Override // com.baidu.live.gift.container.AlaGiftTabView.c
        public void tR() {
            GiftPanelTabBaseFragment.this.vg();
        }
    };
    protected AlaGiftTabView aoA;
    protected c.a aoB;
    protected d aoC;

    protected abstract boolean ve();

    protected abstract boolean vf();

    protected abstract void vg();

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
        this.aoB = aVar;
    }

    public void a(d dVar) {
        this.aoC = dVar;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aoA = new AlaGiftTabView(getPageContext(), vb(), vd(), this.aoC.otherParams);
        this.aoA.V(this.aoC.mLiveId, this.aoC.mRoomId);
        this.aoA.t(this.aoC.akL, this.aoC.akM);
        this.aoA.z(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aoA.A(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aoA.a(this.akt);
        this.aoA.aC(this.aoC.aiY);
        this.aoA.bI(this.aoC.aiW);
        this.ajU = this.aoC.ajU;
        this.aoA.aE(this.aoC.ajU);
        this.aoA.b(this.aoC.isNewUser, this.aoC.mLiveId, this.aoC.mRoomId, this.aoC.alR);
        this.aoA.bh(this.aoC.akN);
        this.aoA.aF(this.aoC.akX);
        this.aoA.bB(this.aoC.alV);
        this.aoA.aq(this.aoC.ajd);
        return this.aoA.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aoA.aD(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aoA.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aoA != null) {
            this.aoA.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aoA.tC()) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            GiftPanelTabBaseFragment.this.aoA.tE();
                            e.printStackTrace();
                        }
                    }
                });
                return true;
            } else if (view == this.aoA.getRootView()) {
                return true;
            } else {
                closeActivity();
            }
        }
        return false;
    }

    public void e(boolean z, boolean z2) {
        if (this.aoA != null) {
            if (z) {
                Rect rect = new Rect();
                this.aoA.getRootView().getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize -= UtilHelper.getStatusBarHeight();
                }
                this.aoA.bE(dimensionPixelSize);
                this.aoA.ajV.setVisibility(8);
                if (!z2) {
                    this.aoA.tF().setVisibility(0);
                    return;
                }
                return;
            }
            this.aoA.ajV.setVisibility(0);
            this.aoA.tF().setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        if (this.aoA.tC()) {
            this.aoA.tE();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        if (this.aoC.alS == 2) {
            showToast(a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (this.aoC.alS == 1) {
            showToast(a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.rI();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void va() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aoC.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : "send", true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        getActivity().finish();
    }

    private View.OnClickListener vb() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.GiftPanelTabBaseFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(GiftPanelTabBaseFragment.this.getActivity(), GiftPanelTabBaseFragment.this.aoA.ajZ);
                    if (view.getId() == a.g.ala_gift_draw_hide_btn) {
                        GiftPanelTabBaseFragment.this.closeActivity();
                    } else if (view.getId() == a.g.donate && GiftPanelTabBaseFragment.this.vc()) {
                        if (GiftPanelTabBaseFragment.this.ve()) {
                            g tJ = GiftPanelTabBaseFragment.this.aoA.tJ();
                            if (GiftPanelTabBaseFragment.this.vf() && tJ.rL()) {
                                if (!tJ.rJ() || (tJ.rJ() && GiftPanelTabBaseFragment.this.aoA.tM() == 1)) {
                                    GiftPanelTabBaseFragment.this.aoA.tl();
                                    GiftPanelTabBaseFragment.this.aoA.aL(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && GiftPanelTabBaseFragment.this.vc()) {
                        GiftPanelTabBaseFragment.this.aoA.tk();
                        if (GiftPanelTabBaseFragment.this.ve()) {
                            GiftPanelTabBaseFragment.this.vf();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && GiftPanelTabBaseFragment.this.vc()) {
                        if (GiftPanelTabBaseFragment.this.aoC.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.zs().zv()) {
                            String str3 = com.baidu.live.v.a.zs().axR.adc.adZ.aeg;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + GiftPanelTabBaseFragment.this.aoC.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + GiftPanelTabBaseFragment.this.aoC.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(GiftPanelTabBaseFragment.this.aoC.mLiveId, GiftPanelTabBaseFragment.this.aoC.mRoomId, GiftPanelTabBaseFragment.this.aoC.alR, GiftPanelTabBaseFragment.this.aoC.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity(), 0L, GiftPanelTabBaseFragment.this.aoC.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && GiftPanelTabBaseFragment.this.vc() && TbadkCoreApplication.getInst().isRegistedIntent(f.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(GiftPanelTabBaseFragment.this.getPageContext().getPageActivity())));
                        GiftPanelTabBaseFragment.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vc() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(getActivity());
        return false;
    }

    private boolean vd() {
        return ("ala_tieba_android_consume".equals(this.aoC.alT) || StringUtils.isNull(this.aoC.alT) || this.aoC.alT.equals(com.baidu.live.gift.b.b.uz().sI())) ? false : true;
    }
}
