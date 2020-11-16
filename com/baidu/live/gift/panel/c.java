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
    private static CustomMessageListener bbt;
    private static long pkId = 0;
    protected boolean aXK;
    private AlaGiftTabView.e aYb = new AlaGiftTabView.e() { // from class: com.baidu.live.gift.panel.c.2
        @Override // com.baidu.live.gift.container.AlaGiftTabView.e
        public void HO() {
            c.this.Jh();
        }
    };
    public AlaGiftTabView bcI;
    protected f.a bcJ;
    private int bcK;
    protected com.baidu.live.gift.a.d bcu;
    private AlaGiftTabView.a bcv;
    public TbPageContext mPageContext;

    protected abstract boolean Jf();

    protected abstract boolean Jg();

    protected abstract void Jh();

    public static c ev(int i) {
        IN();
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
        this.bcJ = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bcv = aVar;
    }

    public void a(com.baidu.live.gift.a.d dVar) {
        this.bcu = dVar;
    }

    public void eg(int i) {
        if (this.bcI != null) {
            this.bcI.eg(i);
        } else {
            this.bcK = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bcI = new AlaGiftTabView(getPageContext(), Jc(), Je(), this.bcu.otherParams);
        this.bcI.a(this.bcv);
        if (this.bcK != 0) {
            this.bcI.eg(this.bcK);
        }
        this.bcI.at(this.bcu.mLiveId, this.bcu.mRoomId);
        this.bcI.x(this.bcu.aYo, this.bcu.aYp);
        this.bcI.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bcI.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bcI.a(this.aYb);
        this.bcI.bx(this.bcu.aWq);
        this.bcI.eo(this.bcu.aWo);
        this.aXK = this.bcu.aXK;
        this.bcI.bF(this.bcu.aXK);
        this.bcI.b(this.bcu.isNewUser, this.bcu.mLiveId, this.bcu.mRoomId, this.bcu.aZH);
        this.bcI.be(this.bcu.aZL);
        this.bcI.dC(this.bcu.aYq);
        this.bcI.bH(this.bcu.aYB);
        this.bcI.eh(this.bcu.aZM);
        this.bcI.bg(this.bcu.aWw);
        this.bcI.bI(this.bcu.aZO);
        return this.bcI.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bcI.bE(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bcI.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bcI != null) {
            this.bcI.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bcv = null;
        this.bcJ = null;
        MessageManager.getInstance().unRegisterListener(bbt);
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
    public void Jb() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bcu.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Jc() {
        return new View.OnClickListener() { // from class: com.baidu.live.gift.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), c.this.bcI.aXN);
                    if (view.getId() == a.f.donate && c.this.Jd()) {
                        if (c.this.Jf()) {
                            g HJ = c.this.bcI.HJ();
                            if (HJ.FD() && c.pkId == 0 && com.baidu.live.gift.c.a.pkId == 0) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "主播没有在PK中", 0);
                            } else if (c.this.Jg() && HJ.Fs()) {
                                if (!HJ.Fq() || (HJ.Fq() && c.this.bcI.HK() == 1)) {
                                    c.this.bcI.Hf();
                                    c.this.bcI.bN(false);
                                }
                            }
                        }
                    } else if (view.getId() == a.f.combo_btn && c.this.Jd()) {
                        c.this.bcI.He();
                        if (c.this.Jf()) {
                            c.this.Jg();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && c.this.Jd()) {
                        if (c.this.bcu.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.aa.a.Ph().Pl()) {
                            String str3 = com.baidu.live.aa.a.Ph().bsh.aNM.aPh.aPo;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + c.this.bcu.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + c.this.bcu.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(c.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(c.this.bcu.mLiveId, c.this.bcu.mRoomId, c.this.bcu.aZH, c.this.bcu.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.getPageContext().getPageActivity(), 0L, c.this.bcu.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && c.this.Jd() && MessageManager.getInstance().findTask(2913219) != null) {
                        c.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jd() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Je() {
        return ("ala_tieba_android_consume".equals(this.bcu.aZJ) || StringUtils.isNull(this.bcu.aZJ) || this.bcu.aZJ.equals(com.baidu.live.gift.b.b.Iv().GC())) ? false : true;
    }

    private static void IN() {
        bbt = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.panel.c.3
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
        MessageManager.getInstance().registerListener(bbt);
    }
}
