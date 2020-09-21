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
    private static CustomMessageListener aXf;
    private static long pkId = 0;
    private AlaGiftTabView.e aTO = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void GF() {
            c.this.HZ();
        }
    };
    protected boolean aTx;
    protected com.baidu.live.gift.a.d aYe;
    private AlaGiftTabView.a aYf;
    public AlaGiftTabView aYs;
    protected f.a aYt;
    private int aYu;
    public TbPageContext mPageContext;

    protected abstract boolean HX();

    protected abstract boolean HY();

    protected abstract void HZ();

    public static c et(int i) {
        HF();
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
        this.aYt = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.aYf = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.aYe = dVar;
    }

    public void ee(int i) {
        if (this.aYs != null) {
            this.aYs.ee(i);
        } else {
            this.aYu = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.aYs = new AlaGiftTabView(getPageContext(), HU(), HW(), this.aYe.otherParams);
        this.aYs.a(this.aYf);
        if (this.aYu != 0) {
            this.aYs.ee(this.aYu);
        }
        this.aYs.ap(this.aYe.mLiveId, this.aYe.mRoomId);
        this.aYs.x(this.aYe.aUb, this.aYe.aUc);
        this.aYs.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.aYs.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.aYs.a(this.aTO);
        this.aYs.bo(this.aYe.aSd);
        this.aYs.em(this.aYe.aSb);
        this.aTx = this.aYe.aTx;
        this.aYs.bw(this.aYe.aTx);
        this.aYs.b(this.aYe.isNewUser, this.aYe.mLiveId, this.aYe.mRoomId, this.aYe.aVs);
        this.aYs.aW(this.aYe.aVw);
        this.aYs.dB(this.aYe.aUd);
        this.aYs.by(this.aYe.aUo);
        this.aYs.ef(this.aYe.aVx);
        this.aYs.aY(this.aYe.aSj);
        this.aYs.bz(this.aYe.aVz);
        return this.aYs.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.aYs.bv(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.aYs.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.aYs != null) {
            this.aYs.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.aYf = null;
        this.aYt = null;
        MessageManager.getInstance().unRegisterListener(aXf);
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
    public void HT() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.aYe.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener HU() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.aYs.aTA);
                    if (view.getId() == a.g.donate && c.this.HV()) {
                        if (c.this.HX()) {
                            g GA = c.this.aYs.GA();
                            if (GA.EA() && c.pkId == 0 && com.baidu.live.gift.c.a.pkId == 0) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                            } else if (c.this.HY() && GA.Ep()) {
                                if (!GA.En() || (GA.En() && c.this.aYs.GB() == 1)) {
                                    c.this.aYs.FV();
                                    c.this.aYs.bE(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.g.combo_btn && c.this.HV()) {
                        c.this.aYs.FU();
                        if (c.this.HX()) {
                            c.this.HY();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && c.this.HV()) {
                        if (c.this.aYe.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.x.a.NN().NQ()) {
                            String str3 = com.baidu.live.x.a.NN().bmW.aKQ.aMb.aMi;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.aYe.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.aYe.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.aYe.mLiveId, c.this.aYe.mRoomId, c.this.aYe.aVs, c.this.aYe.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.aYe.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && c.this.HV() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HV() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean HW() {
        return ("ala_tieba_android_consume".equals(this.aYe.aVu) || StringUtils.isNull(this.aYe.aVu) || this.aYe.aVu.equals(com.baidu.live.gift.b.b.Hn().Ft())) ? false : true;
    }

    private static void HF() {
        aXf = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(aXf);
    }
}
