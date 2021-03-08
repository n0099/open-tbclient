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
    protected boolean bcC;
    private int bim;
    protected com.baidu.live.yuyingift.a.d cbF;
    private AlaGiftTabView.a cbG;
    public AlaGiftTabView cbO;
    protected e.a cbP;
    protected a.InterfaceC0244a cbQ;
    public TbPageContext mPageContext;
    protected int cbR = 0;
    protected long cbS = 0;
    private AlaGiftTabView.e cat = new AlaGiftTabView.e() { // from class: com.baidu.live.yuyingift.panel.b.3
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.e
        public void GF() {
            b.this.If();
        }
    };

    protected abstract void If();

    protected abstract boolean Zi();

    protected abstract boolean l(long j, int i);

    public static b a(a.InterfaceC0244a interfaceC0244a, int i) {
        switch (i) {
            case 0:
                c cVar = new c();
                cVar.cbQ = interfaceC0244a;
                return cVar;
            case 1:
                d dVar = new d();
                dVar.cbQ = interfaceC0244a;
                return dVar;
            default:
                return null;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(e.a aVar) {
        this.cbP = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.cbG = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.cbF = dVar;
    }

    public void cY(int i) {
        if (this.cbO != null) {
            this.cbO.cY(i);
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
        this.cbO = new AlaGiftTabView(getPageContext(), Ib(), Id(), this.cbF.otherParams);
        this.cbO.a(this.cbG);
        if (this.bim != 0) {
            this.cbO.cY(this.bim);
        }
        this.cbO.au(this.cbF.mLiveId, this.cbF.mRoomId);
        this.cbO.A(this.cbF.bdk, this.cbF.bdl);
        this.cbO.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.cbO.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.cbO.a(this.cat);
        this.cbO.bF(this.cbF.bbg);
        this.cbO.dh(this.cbF.bbe);
        this.bcC = this.cbF.bcC;
        this.cbO.bN(this.cbF.bcC);
        this.cbO.b(this.cbF.isNewUser, this.cbF.mLiveId, this.cbF.mRoomId, this.cbF.beL);
        this.cbO.bh(this.cbF.beP);
        this.cbO.cq(this.cbF.bdm);
        this.cbO.bP(this.cbF.bdy);
        this.cbO.cZ(this.cbF.beQ);
        this.cbO.bj(this.cbF.bbm);
        this.cbO.bQ(this.cbF.beS);
        this.cbO.a(new AlaGiftTabView.b() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.b
            public void j(g gVar) {
                if (gVar != null && b.this.cbF != null && b.this.Zg() > 0) {
                    com.baidu.live.yuyingift.b.b.Za().a(b.this.cbS, b.this.cbR + 1, gVar.DU(), b.this.cbF.mLiveId, s.al(b.this.Zf().ccU));
                    b.this.cbS = 0L;
                    b.this.cbR = 0;
                }
            }
        });
        return this.cbO.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.cbO.bM(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.cbO.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cbO != null) {
            this.cbO.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.cbG = null;
        this.cbP = null;
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.cbF.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Ib() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.cbO.bcG);
                    if (view.getId() == a.f.donate) {
                        b.this.Zh();
                    } else if (view.getId() == a.f.combo_btn && b.this.Ic()) {
                        if (!b.this.a(b.this.Zf())) {
                            b.this.cbO.YS();
                            return;
                        }
                        b.this.cbO.FT();
                        b.this.cbR++;
                        if (b.this.Zi()) {
                            b.this.l(b.this.cbS, b.this.cbR);
                        }
                        if (b.this.cbG != null) {
                            b.this.cbG.YK();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && b.this.Ic()) {
                        if (b.this.cbF.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.ae.a.Qm().Qs()) {
                            String str3 = com.baidu.live.ae.a.Qm().bCs.aRm.aSU.aTd;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.cbF.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.cbF.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.cbF.mLiveId, b.this.cbF.mRoomId, b.this.cbF.beL, b.this.cbF.otherParams);
                            b.this.closeActivity();
                            return;
                        }
                        String str4 = "";
                        if (view.getId() == a.f.current_recharge) {
                            str4 = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                            if (b.this.cbG != null) {
                                b.this.cbG.YN();
                                str = str4;
                            }
                            str = str4;
                        } else {
                            if (view.getId() == a.f.current_money) {
                                str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                            }
                            str = str4;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.cbF.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && b.this.Ic() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.d Zf() {
        if (this.cbQ == null) {
            return null;
        }
        return this.cbQ.YF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Zg() {
        GiftPanelSelectMicrophoneSendView.d Zf = Zf();
        if (Zf == null || Zf.ccU == null) {
            return 0;
        }
        return Zf.ccU.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        if (this.cbG != null) {
            this.cbG.YI();
        }
        if (Ic() && Zi()) {
            if (this.cbO.GA().DY()) {
                this.cbR = 0;
                this.cbS = System.currentTimeMillis();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501075, true));
            } else {
                this.cbS = 0L;
                this.cbR = 0;
            }
            if (l(this.cbS, this.cbR) && this.cbS != 0) {
                this.cbO.FU();
                this.cbO.bV(false);
                if (this.cbG != null) {
                    this.cbG.YJ();
                }
            }
        }
    }

    public void YQ() {
        if (this.cbO != null) {
            this.cbO.YS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(GiftPanelSelectMicrophoneSendView.d dVar) {
        if (dVar == null) {
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (dVar.ccU == null || dVar.ccU.size() == 0) {
            if (dVar.ccT != null && dVar.ccT.length > 0) {
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
    public boolean Ic() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Id() {
        return ("ala_tieba_android_consume".equals(this.cbF.beN) || StringUtils.isNull(this.cbF.beN) || this.cbF.beN.equals(com.baidu.live.yuyingift.b.b.Za().Fs())) ? false : true;
    }
}
