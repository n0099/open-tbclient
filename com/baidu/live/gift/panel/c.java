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
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes11.dex */
public abstract class c extends LazyLoadFragment {
    private static CustomMessageListener bft;
    private static long pkId = 0;
    protected boolean bbc;
    private AlaGiftTabView.e bbx = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void GC() {
            c.this.Ic();
        }
    };
    protected AlaGiftTabView.a beG;
    public AlaGiftTabView bgI;
    protected f.a bgJ;
    private int bgK;
    protected com.baidu.live.gift.a.e bgw;
    public TbPageContext mPageContext;

    protected abstract boolean Ib();

    protected abstract void Ic();

    /* renamed from: do  reason: not valid java name */
    public static c m19do(int i) {
        HJ();
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
        this.bgJ = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.beG = aVar;
    }

    public void a(com.baidu.live.gift.a.e eVar) {
        this.bgw = eVar;
    }

    public void cX(int i) {
        if (this.bgI != null) {
            this.bgI.cX(i);
        } else {
            this.bgK = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bgI = new AlaGiftTabView(getPageContext(), HY(), Ia(), this.bgw.otherParams);
        this.bgI.a(this.beG);
        if (this.bgK != 0) {
            this.bgI.cX(this.bgK);
        }
        this.bgI.au(this.bgw.mLiveId, this.bgw.mRoomId);
        this.bgI.A(this.bgw.bbK, this.bgw.bbL);
        this.bgI.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bgI.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bgI.a(this.bbx);
        this.bgI.bF(this.bgw.aZF);
        this.bgI.dg(this.bgw.aZD);
        this.bbc = this.bgw.bbc;
        this.bgI.bN(this.bgw.bbc);
        this.bgI.b(this.bgw.isNewUser, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.bdj);
        this.bgI.bh(this.bgw.bdn);
        this.bgI.cp(this.bgw.bbM);
        this.bgI.bP(this.bgw.bbY);
        this.bgI.cY(this.bgw.bdo);
        this.bgI.bj(this.bgw.aZL);
        this.bgI.bQ(this.bgw.bdq);
        return this.bgI.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        ViewCommonUtil.setForceDarkAllowed(view, false);
        this.bgI.bM(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bgI.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bgI != null) {
            this.bgI.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.beG = null;
        this.bgJ = null;
        MessageManager.getInstance().unRegisterListener(bft);
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
    public void HX() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bgw.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener HY() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bgI.bbg);
                    if (view.getId() == a.f.donate && c.this.HZ()) {
                        g Gx = c.this.bgI.Gx();
                        if (Gx.En() && c.pkId == 0 && com.baidu.live.gift.d.a.pkId == 0) {
                            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                        } else if (c.this.Ib() && Gx.Ec()) {
                            if (!Gx.Ea() || (Gx.Ea() && c.this.bgI.Gy() == 1)) {
                                c.this.bgI.FR();
                                c.this.bgI.bV(false);
                            }
                        }
                    } else if (view.getId() == a.f.combo_btn && c.this.HZ()) {
                        c.this.bgI.FQ();
                        c.this.Ib();
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && c.this.HZ()) {
                        if (c.this.bgw.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.ae.a.Qj().Qo()) {
                            String str3 = com.baidu.live.ae.a.Qj().bAS.aPM.aRu.aRD;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bgw.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bgw.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bgw.mLiveId, c.this.bgw.mRoomId, c.this.bgw.bdj, c.this.bgw.otherParams);
                            c.this.closeActivity();
                            return;
                        }
                        if (view.getId() == a.f.current_recharge) {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                        } else if (view.getId() != a.f.current_money) {
                            str = "";
                        } else {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bgw.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && c.this.HZ() && MessageManager.getInstance().findTask(2913219) != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Ia() {
        return ("ala_tieba_android_consume".equals(this.bgw.bdl) || StringUtils.isNull(this.bgw.bdl) || this.bgw.bdl.equals(com.baidu.live.gift.c.b.Hr().Fp())) ? false : true;
    }

    private static void HJ() {
        bft = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(bft);
    }
}
