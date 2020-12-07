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
    private static CustomMessageListener bfs;
    private static long pkId = 0;
    protected boolean bbc;
    private AlaGiftTabView.e bbw = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void JF() {
            c.this.Li();
        }
    };
    protected AlaGiftTabView.a beF;
    public AlaGiftTabView bgI;
    protected f.a bgJ;
    private int bgK;
    protected com.baidu.live.gift.a.d bgw;
    public TbPageContext mPageContext;

    protected abstract boolean Lg();

    protected abstract boolean Lh();

    protected abstract void Li();

    public static c eR(int i) {
        KN();
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
        this.beF = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.bgw = dVar;
    }

    public void eA(int i) {
        if (this.bgI != null) {
            this.bgI.eA(i);
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
        this.bgI = new AlaGiftTabView(getPageContext(), Ld(), Lf(), this.bgw.otherParams);
        this.bgI.a(this.beF);
        if (this.bgK != 0) {
            this.bgI.eA(this.bgK);
        }
        this.bgI.ax(this.bgw.mLiveId, this.bgw.mRoomId);
        this.bgI.A(this.bgw.bbJ, this.bgw.bbK);
        this.bgI.aO(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bgI.aP(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bgI.a(this.bbw);
        this.bgI.bG(this.bgw.aZG);
        this.bgI.eJ(this.bgw.aZE);
        this.bbc = this.bgw.bbc;
        this.bgI.bO(this.bgw.bbc);
        this.bgI.b(this.bgw.isNewUser, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.bdh);
        this.bgI.bm(this.bgw.bdl);
        this.bgI.dV(this.bgw.bbL);
        this.bgI.bQ(this.bgw.bbX);
        this.bgI.eB(this.bgw.bdm);
        this.bgI.bo(this.bgw.aZM);
        this.bgI.bR(this.bgw.bdo);
        return this.bgI.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bgI.bN(this.mVisible);
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
        this.beF = null;
        this.bgJ = null;
        MessageManager.getInstance().unRegisterListener(bfs);
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
    public void Lc() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bgw.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Ld() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bgI.bbf);
                    if (view.getId() == a.f.donate && c.this.Le()) {
                        if (c.this.Lg()) {
                            g JA = c.this.bgI.JA();
                            if (JA.Hr() && c.pkId == 0 && com.baidu.live.gift.d.a.pkId == 0) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                            } else if (c.this.Lh() && JA.Hg()) {
                                if (!JA.He() || (JA.He() && c.this.bgI.JB() == 1)) {
                                    c.this.bgI.IV();
                                    c.this.bgI.bW(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.f.combo_btn && c.this.Le()) {
                        c.this.bgI.IU();
                        if (c.this.Lg()) {
                            c.this.Lh();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && c.this.Le()) {
                        if (c.this.bgw.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.ae.a.RB().RF()) {
                            String str3 = com.baidu.live.ae.a.RB().bxq.aQM.aSj.aSq;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bgw.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bgw.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bgw.mLiveId, c.this.bgw.mRoomId, c.this.bgw.bdh, c.this.bgw.otherParams);
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
                    } else if (view.getId() == a.f.current_flower && c.this.Le() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Le() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Lf() {
        return ("ala_tieba_android_consume".equals(this.bgw.bdj) || StringUtils.isNull(this.bgw.bdj) || this.bgw.bdj.equals(com.baidu.live.gift.c.b.Kv().It())) ? false : true;
    }

    private static void KN() {
        bfs = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(bfs);
    }
}
