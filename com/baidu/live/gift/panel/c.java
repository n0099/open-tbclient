package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
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
    private static CustomMessageListener bbL;
    private static long pkId = 0;
    protected boolean aYd;
    private AlaGiftTabView.e aYu = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void HW() {
            c.this.Jp();
        }
    };
    protected com.baidu.live.gift.a.d bcM;
    private AlaGiftTabView.a bcN;
    public AlaGiftTabView bda;
    protected f.a bdb;
    private int bdc;
    public TbPageContext mPageContext;

    protected abstract boolean Jn();

    protected abstract boolean Jo();

    protected abstract void Jp();

    public static c ez(int i) {
        IV();
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
        this.bdb = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bcN = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.bcM = dVar;
    }

    public void ek(int i) {
        if (this.bda != null) {
            this.bda.ek(i);
        } else {
            this.bdc = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bda = new AlaGiftTabView(getPageContext(), Jk(), Jm(), this.bcM.otherParams);
        this.bda.a(this.bcN);
        if (this.bdc != 0) {
            this.bda.ek(this.bdc);
        }
        this.bda.at(this.bcM.mLiveId, this.bcM.mRoomId);
        this.bda.x(this.bcM.aYH, this.bcM.aYI);
        this.bda.ae(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bda.af(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bda.a(this.aYu);
        this.bda.bu(this.bcM.aWJ);
        this.bda.es(this.bcM.aWH);
        this.aYd = this.bcM.aYd;
        this.bda.bC(this.bcM.aYd);
        this.bda.b(this.bcM.isNewUser, this.bcM.mLiveId, this.bcM.mRoomId, this.bcM.baa);
        this.bda.bb(this.bcM.bae);
        this.bda.dG(this.bcM.aYJ);
        this.bda.bE(this.bcM.aYU);
        this.bda.el(this.bcM.baf);
        this.bda.bd(this.bcM.aWP);
        this.bda.bF(this.bcM.bah);
        return this.bda.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bda.bB(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bda.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bda != null) {
            this.bda.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bcN = null;
        this.bdb = null;
        MessageManager.getInstance().unRegisterListener(bbL);
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
    public void Jj() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bcM.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Jk() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bda.aYg);
                    if (view.getId() == a.g.donate && c.this.Jl()) {
                        if (c.this.Jn()) {
                            g HR = c.this.bda.HR();
                            if (HR.FL() && c.pkId == 0 && com.baidu.live.gift.c.a.pkId == 0) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                            } else if (c.this.Jo() && HR.FA()) {
                                if (!HR.Fy() || (HR.Fy() && c.this.bda.HS() == 1)) {
                                    c.this.bda.Hn();
                                    c.this.bda.bK(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && c.this.Jl()) {
                        c.this.bda.Hm();
                        if (c.this.Jn()) {
                            c.this.Jo();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && c.this.Jl()) {
                        if (c.this.bcM.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.z.a.Pq().Pt()) {
                            String str3 = com.baidu.live.z.a.Pq().bsy.aOA.aPQ.aPX;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bcM.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bcM.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bcM.mLiveId, c.this.bcM.mRoomId, c.this.bcM.baa, c.this.bcM.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bcM.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && c.this.Jl() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Jm() {
        return ("ala_tieba_android_consume".equals(this.bcM.bac) || StringUtils.isNull(this.bcM.bac) || this.bcM.bac.equals(com.baidu.live.gift.b.b.ID().GK())) ? false : true;
    }

    private static void IV() {
        bbL = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Long)) {
                    long unused = c.pkId = 0L;
                } else if (((Long) customResponsedMessage.getData()).longValue() != -1) {
                    long unused2 = c.pkId = ((Long) customResponsedMessage.getData()).longValue();
                } else {
                    long unused3 = c.pkId = 0L;
                }
            }
        };
        MessageManager.getInstance().registerListener(bbL);
    }
}
