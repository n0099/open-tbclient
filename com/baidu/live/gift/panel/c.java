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
    private static CustomMessageListener bde;
    private static long pkId = 0;
    private AlaGiftTabView.e aZM = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void Ix() {
            c.this.JQ();
        }
    };
    protected boolean aZv;
    protected com.baidu.live.gift.a.d bef;
    private AlaGiftTabView.a beh;
    public AlaGiftTabView bev;
    protected f.a bew;
    private int bex;
    public TbPageContext mPageContext;

    protected abstract boolean JO();

    protected abstract boolean JP();

    protected abstract void JQ();

    public static c ez(int i) {
        Jw();
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
        this.bew = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.beh = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.bef = dVar;
    }

    public void ek(int i) {
        if (this.bev != null) {
            this.bev.ek(i);
        } else {
            this.bex = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bev = new AlaGiftTabView(getPageContext(), JL(), JN(), this.bef.otherParams);
        this.bev.a(this.beh);
        if (this.bex != 0) {
            this.bev.ek(this.bex);
        }
        this.bev.au(this.bef.mLiveId, this.bef.mRoomId);
        this.bev.x(this.bef.aZZ, this.bef.baa);
        this.bev.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bev.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bev.a(this.aZM);
        this.bev.bv(this.bef.aYb);
        this.bev.es(this.bef.aXZ);
        this.aZv = this.bef.aZv;
        this.bev.bD(this.bef.aZv);
        this.bev.b(this.bef.isNewUser, this.bef.mLiveId, this.bef.mRoomId, this.bef.bbt);
        this.bev.bc(this.bef.bbx);
        this.bev.dG(this.bef.bab);
        this.bev.bF(this.bef.bam);
        this.bev.el(this.bef.bby);
        this.bev.be(this.bef.aYh);
        this.bev.bG(this.bef.bbA);
        return this.bev.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bev.bC(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bev.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bev != null) {
            this.bev.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.beh = null;
        this.bew = null;
        MessageManager.getInstance().unRegisterListener(bde);
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
    public void JK() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bef.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener JL() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bev.aZy);
                    if (view.getId() == a.f.donate && c.this.JM()) {
                        if (c.this.JO()) {
                            g Is = c.this.bev.Is();
                            if (Is.Gm() && c.pkId == 0 && com.baidu.live.gift.c.a.pkId == 0) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                            } else if (c.this.JP() && Is.Gb()) {
                                if (!Is.FZ() || (Is.FZ() && c.this.bev.It() == 1)) {
                                    c.this.bev.HO();
                                    c.this.bev.bL(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.f.combo_btn && c.this.JM()) {
                        c.this.bev.HN();
                        if (c.this.JO()) {
                            c.this.JP();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && c.this.JM()) {
                        if (c.this.bef.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.aa.a.PQ().PU()) {
                            String str3 = com.baidu.live.aa.a.PQ().btT.aPx.aQS.aQZ;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bef.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bef.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bef.mLiveId, c.this.bef.mRoomId, c.this.bef.bbt, c.this.bef.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bef.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && c.this.JM() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean JN() {
        return ("ala_tieba_android_consume".equals(this.bef.bbv) || StringUtils.isNull(this.bef.bbv) || this.bef.bbv.equals(com.baidu.live.gift.b.b.Je().Hl())) ? false : true;
    }

    private static void Jw() {
        bde = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(bde);
    }
}
