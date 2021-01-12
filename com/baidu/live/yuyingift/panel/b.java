package com.baidu.live.yuyingift.panel;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.g;
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
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.container.AlaGiftTabView;
import com.baidu.live.yuyingift.panel.a;
import com.baidu.live.yuyingift.panel.e;
import com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView;
/* loaded from: classes10.dex */
public abstract class b extends LazyLoadFragment {
    protected boolean aXV;
    protected com.baidu.live.yuyingift.a.d bWc;
    private AlaGiftTabView.a bWd;
    public AlaGiftTabView bWl;
    protected e.a bWm;
    protected a.InterfaceC0237a bWn;
    private int bdA;
    public TbPageContext mPageContext;
    protected int bWo = 0;
    protected long bWp = 0;
    private AlaGiftTabView.e bUR = new AlaGiftTabView.e() { // from class: com.baidu.live.yuyingift.panel.b.3
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.e
        public void Fm() {
            b.this.GM();
        }
    };

    protected abstract void GM();

    protected abstract boolean Xp();

    protected abstract boolean l(long j, int i);

    public static b a(a.InterfaceC0237a interfaceC0237a, int i) {
        switch (i) {
            case 0:
                c cVar = new c();
                cVar.bWn = interfaceC0237a;
                return cVar;
            case 1:
                d dVar = new d();
                dVar.bWn = interfaceC0237a;
                return dVar;
            default:
                return null;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(e.a aVar) {
        this.bWm = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bWd = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.bWc = dVar;
    }

    public void cS(int i) {
        if (this.bWl != null) {
            this.bWl.cS(i);
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
        this.bWl = new AlaGiftTabView(getPageContext(), GI(), GK(), this.bWc.otherParams);
        this.bWl.a(this.bWd);
        if (this.bdA != 0) {
            this.bWl.cS(this.bdA);
        }
        this.bWl.au(this.bWc.mLiveId, this.bWc.mRoomId);
        this.bWl.A(this.bWc.aYD, this.bWc.aYE);
        this.bWl.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bWl.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bWl.a(this.bUR);
        this.bWl.bA(this.bWc.aWz);
        this.bWl.db(this.bWc.aWx);
        this.aXV = this.bWc.aXV;
        this.bWl.bI(this.bWc.aXV);
        this.bWl.b(this.bWc.isNewUser, this.bWc.mLiveId, this.bWc.mRoomId, this.bWc.bac);
        this.bWl.bf(this.bWc.bag);
        this.bWl.cm(this.bWc.aYF);
        this.bWl.bK(this.bWc.aYR);
        this.bWl.cT(this.bWc.bah);
        this.bWl.bh(this.bWc.aWF);
        this.bWl.bL(this.bWc.baj);
        this.bWl.a(new AlaGiftTabView.b() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.b
            public void j(g gVar) {
                if (gVar != null && b.this.bWc != null && b.this.Xn() > 0) {
                    com.baidu.live.yuyingift.b.b.Xh().a(b.this.bWp, b.this.bWo + 1, gVar.CC(), b.this.bWc.mLiveId, s.ak(b.this.Xm().bXq));
                    b.this.bWp = 0L;
                    b.this.bWo = 0;
                }
            }
        });
        return this.bWl.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bWl.bH(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bWl.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bWl != null) {
            this.bWl.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bWd = null;
        this.bWm = null;
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bWc.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener GI() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.bWl.aXZ);
                    if (view.getId() == a.f.donate) {
                        b.this.Xo();
                    } else if (view.getId() == a.f.combo_btn && b.this.GJ()) {
                        if (!b.this.a(b.this.Xm())) {
                            b.this.bWl.WZ();
                            return;
                        }
                        b.this.bWl.EA();
                        b.this.bWo++;
                        if (b.this.Xp()) {
                            b.this.l(b.this.bWp, b.this.bWo);
                        }
                        if (b.this.bWd != null) {
                            b.this.bWd.WR();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && b.this.GJ()) {
                        if (b.this.bWc.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.af.a.OJ().OO()) {
                            String str3 = com.baidu.live.af.a.OJ().bxp.aMO.aOr.aOB;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.bWc.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.bWc.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.bWc.mLiveId, b.this.bWc.mRoomId, b.this.bWc.bac, b.this.bWc.otherParams);
                            b.this.closeActivity();
                            return;
                        }
                        String str4 = "";
                        if (view.getId() == a.f.current_recharge) {
                            str4 = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                            if (b.this.bWd != null) {
                                b.this.bWd.WU();
                                str = str4;
                            }
                            str = str4;
                        } else {
                            if (view.getId() == a.f.current_money) {
                                str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                            }
                            str = str4;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.bWc.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && b.this.GJ() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.d Xm() {
        if (this.bWn == null) {
            return null;
        }
        return this.bWn.WM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Xn() {
        GiftPanelSelectMicrophoneSendView.d Xm = Xm();
        if (Xm == null || Xm.bXq == null) {
            return 0;
        }
        return Xm.bXq.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xo() {
        if (this.bWd != null) {
            this.bWd.WP();
        }
        if (GJ() && Xp() && a(Xm())) {
            if (this.bWl.Fh().CF()) {
                this.bWo = 0;
                this.bWp = System.currentTimeMillis();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501075, true));
            } else {
                this.bWp = 0L;
                this.bWo = 0;
            }
            if (l(this.bWp, this.bWo) && this.bWp != 0) {
                this.bWl.EB();
                this.bWl.bQ(false);
                if (this.bWd != null) {
                    this.bWd.WQ();
                }
            }
        }
    }

    public void WX() {
        if (this.bWl != null) {
            this.bWl.WZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(GiftPanelSelectMicrophoneSendView.d dVar) {
        if (dVar == null) {
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (dVar.bXq == null || dVar.bXq.size() == 0) {
            if (dVar.bXp != null && dVar.bXp.length > 0) {
                this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_wheat_offline);
                return false;
            }
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else {
            return true;
        }
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
        return ("ala_tieba_android_consume".equals(this.bWc.bae) || StringUtils.isNull(this.bWc.bae) || this.bWc.bae.equals(com.baidu.live.yuyingift.b.b.Xh().DZ())) ? false : true;
    }
}
