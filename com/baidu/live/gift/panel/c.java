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
    private static CustomMessageListener bas;
    private static long pkId = 0;
    protected boolean aWI;
    private AlaGiftTabView.e aWZ = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void HB() {
            c.this.IW();
        }
    };
    public AlaGiftTabView bbM;
    protected f.a bbN;
    private int bbO;
    protected com.baidu.live.gift.a.d bby;
    private AlaGiftTabView.a bbz;
    public TbPageContext mPageContext;

    protected abstract boolean IU();

    protected abstract boolean IV();

    protected abstract void IW();

    public static c ey(int i) {
        IC();
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
        this.bbN = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bbz = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.bby = dVar;
    }

    public void ej(int i) {
        if (this.bbM != null) {
            this.bbM.ej(i);
        } else {
            this.bbO = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bbM = new AlaGiftTabView(getPageContext(), IR(), IT(), this.bby.otherParams);
        this.bbM.a(this.bbz);
        if (this.bbO != 0) {
            this.bbM.ej(this.bbO);
        }
        this.bbM.ar(this.bby.mLiveId, this.bby.mRoomId);
        this.bbM.x(this.bby.aXm, this.bby.aXn);
        this.bbM.ad(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bbM.ae(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bbM.a(this.aWZ);
        this.bbM.bs(this.bby.aVo);
        this.bbM.er(this.bby.aVm);
        this.aWI = this.bby.aWI;
        this.bbM.bA(this.bby.aWI);
        this.bbM.b(this.bby.isNewUser, this.bby.mLiveId, this.bby.mRoomId, this.bby.aYD);
        this.bbM.ba(this.bby.aYH);
        this.bbM.dG(this.bby.aXo);
        this.bbM.bC(this.bby.aXz);
        this.bbM.ek(this.bby.aYI);
        this.bbM.bc(this.bby.aVu);
        this.bbM.bD(this.bby.aYK);
        return this.bbM.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bbM.bz(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bbM.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bbM != null) {
            this.bbM.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bbz = null;
        this.bbN = null;
        MessageManager.getInstance().unRegisterListener(bas);
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
    public void IQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bby.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener IR() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bbM.aWL);
                    if (view.getId() == a.g.donate && c.this.IS()) {
                        if (c.this.IU()) {
                            g Hw = c.this.bbM.Hw();
                            if (Hw.Fw() && c.pkId == 0 && com.baidu.live.gift.c.a.pkId == 0) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                            } else if (c.this.IV() && Hw.Fl()) {
                                if (!Hw.Fj() || (Hw.Fj() && c.this.bbM.Hx() == 1)) {
                                    c.this.bbM.GR();
                                    c.this.bbM.bI(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && c.this.IS()) {
                        c.this.bbM.GQ();
                        if (c.this.IU()) {
                            c.this.IV();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && c.this.IS()) {
                        if (c.this.bby.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.x.a.OS().OV()) {
                            String str3 = com.baidu.live.x.a.OS().bqJ.aNV.aPg.aPn;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bby.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bby.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bby.mLiveId, c.this.bby.mRoomId, c.this.bby.aYD, c.this.bby.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bby.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && c.this.IS() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IS() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean IT() {
        return ("ala_tieba_android_consume".equals(this.bby.aYF) || StringUtils.isNull(this.bby.aYF) || this.bby.aYF.equals(com.baidu.live.gift.b.b.Ik().Gp())) ? false : true;
    }

    private static void IC() {
        bas = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() == null) {
                    long unused = c.pkId = 0L;
                } else if (((Long) customResponsedMessage.getData()).longValue() != -1) {
                    long unused2 = c.pkId = ((Long) customResponsedMessage.getData()).longValue();
                } else {
                    long unused3 = c.pkId = 0L;
                }
            }
        };
        MessageManager.getInstance().registerListener(bas);
    }
}
