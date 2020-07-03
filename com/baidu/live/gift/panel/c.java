package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.panel.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.fragment.ILazyLoadFragmentController;
import com.baidu.live.tbadk.core.fragment.LazyLoadFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes3.dex */
public abstract class c extends LazyLoadFragment {
    protected boolean aKJ;
    private AlaGiftTabView.d aLa = new AlaGiftTabView.d() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.d
        public void Aa() {
            c.this.Bt();
        }
    };
    protected com.baidu.live.gift.a.d aPc;
    private AlaGiftTabView.a aPd;
    public AlaGiftTabView aPp;
    protected f.a aPq;
    private int aPr;
    public TbPageContext mPageContext;

    protected abstract boolean Br();

    protected abstract boolean Bs();

    protected abstract void Bt();

    public static c ct(int i) {
        switch (i) {
            case 0:
                return new d();
            case 1:
                return new e();
            default:
                return null;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(f.a aVar) {
        this.aPq = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.aPd = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.aPc = dVar;
    }

    public void cf(int i) {
        if (this.aPp != null) {
            this.aPp.cf(i);
        } else {
            this.aPr = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aPp = new AlaGiftTabView(getPageContext(), Bo(), Bq(), this.aPc.otherParams);
        this.aPp.a(this.aPd);
        if (this.aPr != 0) {
            this.aPp.cf(this.aPr);
        }
        this.aPp.am(this.aPc.mLiveId, this.aPc.mRoomId);
        this.aPp.u(this.aPc.aLn, this.aPc.aLo);
        this.aPp.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aPp.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aPp.a(this.aLa);
        this.aPp.bf(this.aPc.aJq);
        this.aPp.cn(this.aPc.aJo);
        this.aKJ = this.aPc.aKJ;
        this.aPp.bn(this.aPc.aKJ);
        this.aPp.b(this.aPc.isNewUser, this.aPc.mLiveId, this.aPc.mRoomId, this.aPc.aMu);
        this.aPp.aP(this.aPc.aMy);
        this.aPp.bJ(this.aPc.aLp);
        this.aPp.bp(this.aPc.aLA);
        this.aPp.cg(this.aPc.aMz);
        this.aPp.aR(this.aPc.aJx);
        this.aPp.bq(this.aPc.aMB);
        return this.aPp.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aPp.bm(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aPp.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aPp != null) {
            this.aPp.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.aPd = null;
        this.aPq = null;
    }

    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(g gVar, int i) {
        if (gVar == null || i <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aPc.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Bo() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.aPp.aKM);
                    if (view.getId() == a.g.donate && c.this.Bp()) {
                        if (c.this.Br()) {
                            g zV = c.this.aPp.zV();
                            if (c.this.Bs() && zV.xU()) {
                                if (!zV.xS() || (zV.xS() && c.this.aPp.zW() == 1)) {
                                    c.this.aPp.zq();
                                    c.this.aPp.bv(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && c.this.Bp()) {
                        c.this.aPp.zp();
                        if (c.this.Br()) {
                            c.this.Bs();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && c.this.Bp()) {
                        if (c.this.aPc.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.Hm().Hp()) {
                            String str3 = com.baidu.live.v.a.Hm().bdV.aCT.aDQ.aDX;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.aPc.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.aPc.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.aPc.mLiveId, c.this.aPc.mRoomId, c.this.aPc.aMu, c.this.aPc.otherParams);
                            c.this.closeActivity();
                            return;
                        }
                        if (view.getId() == a.g.current_recharge) {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                        } else if (view.getId() != a.g.current_money) {
                            str = "";
                        } else {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.aPc.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && c.this.Bp() && TbadkCoreApplication.getInst().isRegistedIntent(com.baidu.live.c.g.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.g(c.this.getPageContext().getPageActivity())));
                        c.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Bq() {
        return ("ala_tieba_android_consume".equals(this.aPc.aMw) || StringUtils.isNull(this.aPc.aMw) || this.aPc.aMw.equals(com.baidu.live.gift.b.b.AH().yR())) ? false : true;
    }
}
