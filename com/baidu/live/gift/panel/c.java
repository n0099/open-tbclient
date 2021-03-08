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
/* loaded from: classes10.dex */
public abstract class c extends LazyLoadFragment {
    private static CustomMessageListener bgU;
    private static long pkId = 0;
    protected boolean bcC;
    private AlaGiftTabView.e bcX = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void GF() {
            c.this.If();
        }
    };
    protected AlaGiftTabView.a bgi;
    protected com.baidu.live.gift.a.e bhW;
    public AlaGiftTabView bik;
    protected f.a bil;
    private int bim;
    public TbPageContext mPageContext;

    protected abstract boolean Ie();

    protected abstract void If();

    public static c dp(int i) {
        HM();
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
        this.bil = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bgi = aVar;
    }

    public void a(com.baidu.live.gift.a.e eVar) {
        this.bhW = eVar;
    }

    public void cY(int i) {
        if (this.bik != null) {
            this.bik.cY(i);
        } else {
            this.bim = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bik = new AlaGiftTabView(getPageContext(), Ib(), Id(), this.bhW.otherParams);
        this.bik.a(this.bgi);
        if (this.bim != 0) {
            this.bik.cY(this.bim);
        }
        this.bik.au(this.bhW.mLiveId, this.bhW.mRoomId);
        this.bik.A(this.bhW.bdk, this.bhW.bdl);
        this.bik.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bik.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bik.a(this.bcX);
        this.bik.bF(this.bhW.bbg);
        this.bik.dh(this.bhW.bbe);
        this.bcC = this.bhW.bcC;
        this.bik.bN(this.bhW.bcC);
        this.bik.b(this.bhW.isNewUser, this.bhW.mLiveId, this.bhW.mRoomId, this.bhW.beL);
        this.bik.bh(this.bhW.beP);
        this.bik.cq(this.bhW.bdm);
        this.bik.bP(this.bhW.bdy);
        this.bik.cZ(this.bhW.beQ);
        this.bik.bj(this.bhW.bbm);
        this.bik.bQ(this.bhW.beS);
        return this.bik.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        ViewCommonUtil.setForceDarkAllowed(view, false);
        this.bik.bM(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bik.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bik != null) {
            this.bik.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bgi = null;
        this.bil = null;
        MessageManager.getInstance().unRegisterListener(bgU);
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
    public void Ia() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bhW.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Ib() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bik.bcG);
                    if (view.getId() == a.f.donate && c.this.Ic()) {
                        g GA = c.this.bik.GA();
                        if (GA.Eq() && c.pkId == 0 && com.baidu.live.gift.d.a.pkId == 0) {
                            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                        } else if (c.this.Ie() && GA.Ef()) {
                            if (!GA.Ed() || (GA.Ed() && c.this.bik.GB() == 1)) {
                                c.this.bik.FU();
                                c.this.bik.bV(false);
                            }
                        }
                    } else if (view.getId() == a.f.combo_btn && c.this.Ic()) {
                        c.this.bik.FT();
                        c.this.Ie();
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && c.this.Ic()) {
                        if (c.this.bhW.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.ae.a.Qm().Qr()) {
                            String str3 = com.baidu.live.ae.a.Qm().bCs.aRm.aSU.aTd;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bhW.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bhW.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bhW.mLiveId, c.this.bhW.mRoomId, c.this.bhW.beL, c.this.bhW.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bhW.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && c.this.Ic() && MessageManager.getInstance().findTask(2913219) != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ic() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Id() {
        return ("ala_tieba_android_consume".equals(this.bhW.beN) || StringUtils.isNull(this.bhW.beN) || this.bhW.beN.equals(com.baidu.live.gift.c.b.Hu().Fs())) ? false : true;
    }

    private static void HM() {
        bgU = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(bgU);
    }
}
