package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes4.dex */
public abstract class c extends LazyLoadFragment {
    protected boolean aMf;
    private AlaGiftTabView.d aMw = new AlaGiftTabView.d() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.d
        public void AC() {
            c.this.BV();
        }
    };
    public AlaGiftTabView aQI;
    protected f.a aQJ;
    private int aQK;
    protected com.baidu.live.gift.a.d aQv;
    private AlaGiftTabView.a aQw;
    public TbPageContext mPageContext;

    protected abstract boolean BT();

    protected abstract boolean BU();

    protected abstract void BV();

    public static c cz(int i) {
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
        this.aQJ = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.aQw = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.aQv = dVar;
    }

    public void cl(int i) {
        if (this.aQI != null) {
            this.aQI.cl(i);
        } else {
            this.aQK = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aQI = new AlaGiftTabView(getPageContext(), BQ(), BS(), this.aQv.otherParams);
        this.aQI.a(this.aQw);
        if (this.aQK != 0) {
            this.aQI.cl(this.aQK);
        }
        this.aQI.al(this.aQv.mLiveId, this.aQv.mRoomId);
        this.aQI.u(this.aQv.aMJ, this.aQv.aMK);
        this.aQI.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aQI.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aQI.a(this.aMw);
        this.aQI.bi(this.aQv.aKM);
        this.aQI.ct(this.aQv.aKK);
        this.aMf = this.aQv.aMf;
        this.aQI.bq(this.aQv.aMf);
        this.aQI.b(this.aQv.isNewUser, this.aQv.mLiveId, this.aQv.mRoomId, this.aQv.aNP);
        this.aQI.aR(this.aQv.aNT);
        this.aQI.bL(this.aQv.aML);
        this.aQI.bs(this.aQv.aMW);
        this.aQI.cm(this.aQv.aNU);
        this.aQI.aT(this.aQv.aKT);
        this.aQI.bt(this.aQv.aNW);
        return this.aQI.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aQI.bp(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aQI.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aQI != null) {
            this.aQI.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.aQw = null;
        this.aQJ = null;
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
    public void BP() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aQv.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener BQ() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.aQI.aMi);
                    if (view.getId() == a.g.donate && c.this.BR()) {
                        if (c.this.BT()) {
                            g Ax = c.this.aQI.Ax();
                            if (c.this.BU() && Ax.yw()) {
                                if (!Ax.yu() || (Ax.yu() && c.this.aQI.Ay() == 1)) {
                                    c.this.aQI.zS();
                                    c.this.aQI.by(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && c.this.BR()) {
                        c.this.aQI.zR();
                        if (c.this.BT()) {
                            c.this.BU();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && c.this.BR()) {
                        if (c.this.aQv.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.Hs().Hv()) {
                            String str3 = com.baidu.live.v.a.Hs().beo.aEo.aFk.aFr;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.aQv.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.aQv.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.aQv.mLiveId, c.this.aQv.mRoomId, c.this.aQv.aNP, c.this.aQv.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.aQv.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && c.this.BR() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BR() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean BS() {
        return ("ala_tieba_android_consume".equals(this.aQv.aNR) || StringUtils.isNull(this.aQv.aNR) || this.aQv.aNR.equals(com.baidu.live.gift.b.b.Bj().zt())) ? false : true;
    }
}
