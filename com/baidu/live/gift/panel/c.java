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
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public abstract class c extends LazyLoadFragment {
    protected boolean aIf;
    private AlaGiftTabView.d aIw = new AlaGiftTabView.d() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.d
        public void zA() {
            c.this.AT();
        }
    };
    public AlaGiftTabView aMJ;
    protected f.a aMK;
    private int aML;
    protected com.baidu.live.gift.a.d aMw;
    private AlaGiftTabView.a aMx;
    public TbPageContext mPageContext;

    protected abstract boolean AR();

    protected abstract boolean AS();

    protected abstract void AT();

    public static c cn(int i) {
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
        this.aMK = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.aMx = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.aMw = dVar;
    }

    public void bZ(int i) {
        if (this.aMJ != null) {
            this.aMJ.bZ(i);
        } else {
            this.aML = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aMJ = new AlaGiftTabView(getPageContext(), AO(), AQ(), this.aMw.otherParams);
        this.aMJ.a(this.aMx);
        if (this.aML != 0) {
            this.aMJ.bZ(this.aML);
        }
        this.aMJ.al(this.aMw.mLiveId, this.aMw.mRoomId);
        this.aMJ.s(this.aMw.aIJ, this.aMw.aIK);
        this.aMJ.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aMJ.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aMJ.a(this.aIw);
        this.aMJ.bf(this.aMw.aGS);
        this.aMJ.ch(this.aMw.aGQ);
        this.aIf = this.aMw.aIf;
        this.aMJ.bn(this.aMw.aIf);
        this.aMJ.b(this.aMw.isNewUser, this.aMw.mLiveId, this.aMw.mRoomId, this.aMw.aJO);
        this.aMJ.aO(this.aMw.aJS);
        this.aMJ.bD(this.aMw.aIL);
        this.aMJ.bp(this.aMw.aIU);
        this.aMJ.ca(this.aMw.aJT);
        this.aMJ.aQ(this.aMw.aGZ);
        this.aMJ.bq(this.aMw.aJV);
        return this.aMJ.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aMJ.bm(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aMJ.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aMJ != null) {
            this.aMJ.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.aMx = null;
        this.aMK = null;
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
    public void AN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aMw.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener AO() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.aMJ.aIi);
                    if (view.getId() == a.g.donate && c.this.AP()) {
                        if (c.this.AR()) {
                            g zv = c.this.aMJ.zv();
                            if (c.this.AS() && zv.xu()) {
                                if (!zv.xs() || (zv.xs() && c.this.aMJ.zw() == 1)) {
                                    c.this.aMJ.yQ();
                                    c.this.aMJ.bv(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && c.this.AP()) {
                        c.this.aMJ.yP();
                        if (c.this.AR()) {
                            c.this.AS();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && c.this.AP()) {
                        if (c.this.aMw.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.v.a.Ge().Gh()) {
                            String str3 = com.baidu.live.v.a.Ge().aYP.aAI.aBF.aBM;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.aMw.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.aMw.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.aMw.mLiveId, c.this.aMw.mRoomId, c.this.aMw.aJO, c.this.aMw.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.aMw.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && c.this.AP() && TbadkCoreApplication.getInst().isRegistedIntent(com.baidu.live.c.f.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.f(c.this.getPageContext().getPageActivity())));
                        c.this.closeActivity();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean AQ() {
        return ("ala_tieba_android_consume".equals(this.aMw.aJQ) || StringUtils.isNull(this.aMw.aJQ) || this.aMw.aJQ.equals(com.baidu.live.gift.b.b.Ah().yr())) ? false : true;
    }
}
