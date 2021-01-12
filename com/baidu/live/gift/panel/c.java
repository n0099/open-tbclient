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
/* loaded from: classes10.dex */
public abstract class c extends LazyLoadFragment {
    private static CustomMessageListener bck;
    private static long pkId = 0;
    protected boolean aXV;
    private AlaGiftTabView.e aYq = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void Fm() {
            c.this.GM();
        }
    };
    protected AlaGiftTabView.a bbz;
    private int bdA;
    protected com.baidu.live.gift.a.e bdm;
    public AlaGiftTabView bdy;
    protected f.a bdz;
    public TbPageContext mPageContext;

    protected abstract boolean GL();

    protected abstract void GM();

    public static c dj(int i) {
        Gt();
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
        this.bdz = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bbz = aVar;
    }

    public void a(com.baidu.live.gift.a.e eVar) {
        this.bdm = eVar;
    }

    public void cS(int i) {
        if (this.bdy != null) {
            this.bdy.cS(i);
        } else {
            this.bdA = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bdy = new AlaGiftTabView(getPageContext(), GI(), GK(), this.bdm.otherParams);
        this.bdy.a(this.bbz);
        if (this.bdA != 0) {
            this.bdy.cS(this.bdA);
        }
        this.bdy.au(this.bdm.mLiveId, this.bdm.mRoomId);
        this.bdy.A(this.bdm.aYD, this.bdm.aYE);
        this.bdy.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bdy.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bdy.a(this.aYq);
        this.bdy.bA(this.bdm.aWz);
        this.bdy.db(this.bdm.aWx);
        this.aXV = this.bdm.aXV;
        this.bdy.bI(this.bdm.aXV);
        this.bdy.b(this.bdm.isNewUser, this.bdm.mLiveId, this.bdm.mRoomId, this.bdm.bac);
        this.bdy.bf(this.bdm.bag);
        this.bdy.cm(this.bdm.aYF);
        this.bdy.bK(this.bdm.aYR);
        this.bdy.cT(this.bdm.bah);
        this.bdy.bh(this.bdm.aWF);
        this.bdy.bL(this.bdm.baj);
        return this.bdy.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bdy.bH(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bdy.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bdy != null) {
            this.bdy.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bbz = null;
        this.bdz = null;
        MessageManager.getInstance().unRegisterListener(bck);
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
    public void GH() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bdm.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener GI() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bdy.aXZ);
                    if (view.getId() == a.f.donate && c.this.GJ()) {
                        g Fh = c.this.bdy.Fh();
                        if (Fh.CX() && c.pkId == 0 && com.baidu.live.gift.d.a.pkId == 0) {
                            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                        } else if (c.this.GL() && Fh.CM()) {
                            if (!Fh.CK() || (Fh.CK() && c.this.bdy.Fi() == 1)) {
                                c.this.bdy.EB();
                                c.this.bdy.bQ(false);
                            }
                        }
                    } else if (view.getId() == a.f.combo_btn && c.this.GJ()) {
                        c.this.bdy.EA();
                        c.this.GL();
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && c.this.GJ()) {
                        if (c.this.bdm.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.af.a.OJ().ON()) {
                            String str3 = com.baidu.live.af.a.OJ().bxp.aMO.aOr.aOB;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bdm.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bdm.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bdm.mLiveId, c.this.bdm.mRoomId, c.this.bdm.bac, c.this.bdm.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bdm.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && c.this.GJ() && MessageManager.getInstance().findTask(2913219) != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean GK() {
        return ("ala_tieba_android_consume".equals(this.bdm.bae) || StringUtils.isNull(this.bdm.bae) || this.bdm.bae.equals(com.baidu.live.gift.c.b.Gb().DZ())) ? false : true;
    }

    private static void Gt() {
        bck = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(bck);
    }
}
