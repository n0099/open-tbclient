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
/* loaded from: classes11.dex */
public abstract class c extends LazyLoadFragment {
    private static CustomMessageListener bhb;
    private static long pkId = 0;
    protected boolean bcJ;
    private AlaGiftTabView.e bde = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void Jh() {
            c.this.KH();
        }
    };
    protected AlaGiftTabView.a bgp;
    protected com.baidu.live.gift.a.e bie;
    public AlaGiftTabView bir;
    protected f.a bis;
    private int bit;
    public TbPageContext mPageContext;

    protected abstract boolean KG();

    protected abstract void KH();

    public static c eP(int i) {
        Ko();
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
        this.bis = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bgp = aVar;
    }

    public void a(com.baidu.live.gift.a.e eVar) {
        this.bie = eVar;
    }

    public void ey(int i) {
        if (this.bir != null) {
            this.bir.ey(i);
        } else {
            this.bit = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bir = new AlaGiftTabView(getPageContext(), KD(), KF(), this.bie.otherParams);
        this.bir.a(this.bgp);
        if (this.bit != 0) {
            this.bir.ey(this.bit);
        }
        this.bir.av(this.bie.mLiveId, this.bie.mRoomId);
        this.bir.A(this.bie.bdr, this.bie.bds);
        this.bir.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bir.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bir.a(this.bde);
        this.bir.bE(this.bie.bbn);
        this.bir.eH(this.bie.bbl);
        this.bcJ = this.bie.bcJ;
        this.bir.bM(this.bie.bcJ);
        this.bir.b(this.bie.isNewUser, this.bie.mLiveId, this.bie.mRoomId, this.bie.beS);
        this.bir.bj(this.bie.beW);
        this.bir.dS(this.bie.bdt);
        this.bir.bO(this.bie.bdF);
        this.bir.ez(this.bie.beX);
        this.bir.bl(this.bie.bbt);
        this.bir.bP(this.bie.beZ);
        return this.bir.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bir.bL(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bir.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bir != null) {
            this.bir.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bgp = null;
        this.bis = null;
        MessageManager.getInstance().unRegisterListener(bhb);
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
    public void KC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bie.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener KD() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bir.bcN);
                    if (view.getId() == a.f.donate && c.this.KE()) {
                        g Jc = c.this.bir.Jc();
                        if (Jc.GS() && c.pkId == 0 && com.baidu.live.gift.d.a.pkId == 0) {
                            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                        } else if (c.this.KG() && Jc.GH()) {
                            if (!Jc.GF() || (Jc.GF() && c.this.bir.Jd() == 1)) {
                                c.this.bir.Iw();
                                c.this.bir.bU(false);
                            }
                        }
                    } else if (view.getId() == a.f.combo_btn && c.this.KE()) {
                        c.this.bir.Iv();
                        c.this.KG();
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && c.this.KE()) {
                        if (c.this.bie.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.af.a.SE().SI()) {
                            String str3 = com.baidu.live.af.a.SE().bCb.aRB.aTe.aTo;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bie.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bie.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bie.mLiveId, c.this.bie.mRoomId, c.this.bie.beS, c.this.bie.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bie.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && c.this.KE() && MessageManager.getInstance().findTask(2913219) != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KE() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean KF() {
        return ("ala_tieba_android_consume".equals(this.bie.beU) || StringUtils.isNull(this.bie.beU) || this.bie.beU.equals(com.baidu.live.gift.c.b.JW().HU())) ? false : true;
    }

    private static void Ko() {
        bhb = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(bhb);
    }
}
