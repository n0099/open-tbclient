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
/* loaded from: classes7.dex */
public abstract class c extends LazyLoadFragment {
    private AlaGiftTabView.d aRJ = new AlaGiftTabView.d() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.d
        public void Gf() {
            c.this.Hy();
        }
    };
    protected boolean aRs;
    protected com.baidu.live.gift.a.d aVJ;
    private AlaGiftTabView.a aVK;
    public AlaGiftTabView aVW;
    protected f.a aVX;
    private int aVY;
    public TbPageContext mPageContext;

    protected abstract boolean Hw();

    protected abstract boolean Hx();

    protected abstract void Hy();

    public static c ep(int i) {
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
        this.aVX = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.aVK = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.aVJ = dVar;
    }

    public void ea(int i) {
        if (this.aVW != null) {
            this.aVW.ea(i);
        } else {
            this.aVY = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aVW = new AlaGiftTabView(getPageContext(), Ht(), Hv(), this.aVJ.otherParams);
        this.aVW.a(this.aVK);
        if (this.aVY != 0) {
            this.aVW.ea(this.aVY);
        }
        this.aVW.ap(this.aVJ.mLiveId, this.aVJ.mRoomId);
        this.aVW.x(this.aVJ.aRW, this.aVJ.aRX);
        this.aVW.ac(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aVW.ad(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aVW.a(this.aRJ);
        this.aVW.bn(this.aVJ.aPZ);
        this.aVW.ei(this.aVJ.aPX);
        this.aRs = this.aVJ.aRs;
        this.aVW.bv(this.aVJ.aRs);
        this.aVW.b(this.aVJ.isNewUser, this.aVJ.mLiveId, this.aVJ.mRoomId, this.aVJ.aTc);
        this.aVW.aW(this.aVJ.aTg);
        this.aVW.dx(this.aVJ.aRY);
        this.aVW.bx(this.aVJ.aSj);
        this.aVW.eb(this.aVJ.aTh);
        this.aVW.aY(this.aVJ.aQg);
        this.aVW.by(this.aVJ.aTj);
        return this.aVW.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aVW.bu(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aVW.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aVW != null) {
            this.aVW.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.aVK = null;
        this.aVX = null;
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
    public void Hs() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aVJ.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Ht() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.aVW.aRv);
                    if (view.getId() == a.g.donate && c.this.Hu()) {
                        if (c.this.Hw()) {
                            g Ga = c.this.aVW.Ga();
                            if (c.this.Hx() && Ga.DZ()) {
                                if (!Ga.DX() || (Ga.DX() && c.this.aVW.Gb() == 1)) {
                                    c.this.aVW.Fv();
                                    c.this.aVW.bD(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && c.this.Hu()) {
                        c.this.aVW.Fu();
                        if (c.this.Hw()) {
                            c.this.Hx();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && c.this.Hu()) {
                        if (c.this.aVJ.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.w.a.Nk().Nn()) {
                            String str3 = com.baidu.live.w.a.Nk().bka.aJy.aKu.aKB;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.aVJ.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.aVJ.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.aVJ.mLiveId, c.this.aVJ.mRoomId, c.this.aVJ.aTc, c.this.aVJ.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.aVJ.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && c.this.Hu() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hu() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Hv() {
        return ("ala_tieba_android_consume".equals(this.aVJ.aTe) || StringUtils.isNull(this.aVJ.aTe) || this.aVJ.aTe.equals(com.baidu.live.gift.b.b.GM().EW())) ? false : true;
    }
}
