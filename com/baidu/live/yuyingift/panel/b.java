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
/* loaded from: classes11.dex */
public abstract class b extends LazyLoadFragment {
    protected boolean bcJ;
    private int bit;
    protected com.baidu.live.yuyingift.a.d caO;
    private AlaGiftTabView.a caP;
    public AlaGiftTabView caX;
    protected e.a caY;
    protected a.InterfaceC0246a caZ;
    public TbPageContext mPageContext;
    protected int cba = 0;
    protected long cbb = 0;
    private AlaGiftTabView.e bZD = new AlaGiftTabView.e() { // from class: com.baidu.live.yuyingift.panel.b.3
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.e
        public void Jh() {
            b.this.KH();
        }
    };

    protected abstract void KH();

    protected abstract boolean abi();

    protected abstract boolean l(long j, int i);

    public static b a(a.InterfaceC0246a interfaceC0246a, int i) {
        switch (i) {
            case 0:
                c cVar = new c();
                cVar.caZ = interfaceC0246a;
                return cVar;
            case 1:
                d dVar = new d();
                dVar.caZ = interfaceC0246a;
                return dVar;
            default:
                return null;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(e.a aVar) {
        this.caY = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.caP = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.caO = dVar;
    }

    public void ey(int i) {
        if (this.caX != null) {
            this.caX.ey(i);
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
        this.caX = new AlaGiftTabView(getPageContext(), KD(), KF(), this.caO.otherParams);
        this.caX.a(this.caP);
        if (this.bit != 0) {
            this.caX.ey(this.bit);
        }
        this.caX.av(this.caO.mLiveId, this.caO.mRoomId);
        this.caX.A(this.caO.bdr, this.caO.bds);
        this.caX.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.caX.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.caX.a(this.bZD);
        this.caX.bE(this.caO.bbn);
        this.caX.eH(this.caO.bbl);
        this.bcJ = this.caO.bcJ;
        this.caX.bM(this.caO.bcJ);
        this.caX.b(this.caO.isNewUser, this.caO.mLiveId, this.caO.mRoomId, this.caO.beS);
        this.caX.bj(this.caO.beW);
        this.caX.dS(this.caO.bdt);
        this.caX.bO(this.caO.bdF);
        this.caX.ez(this.caO.beX);
        this.caX.bl(this.caO.bbt);
        this.caX.bP(this.caO.beZ);
        this.caX.a(new AlaGiftTabView.b() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.b
            public void j(g gVar) {
                if (gVar != null && b.this.caO != null && b.this.abg() > 0) {
                    com.baidu.live.yuyingift.b.b.aba().a(b.this.cbb, b.this.cba + 1, gVar.Gx(), b.this.caO.mLiveId, s.ak(b.this.abf().ccd));
                    b.this.cbb = 0L;
                    b.this.cba = 0;
                }
            }
        });
        return this.caX.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.caX.bL(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.caX.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.caX != null) {
            this.caX.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.caP = null;
        this.caY = null;
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.caO.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener KD() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.caX.bcN);
                    if (view.getId() == a.f.donate) {
                        b.this.abh();
                    } else if (view.getId() == a.f.combo_btn && b.this.KE()) {
                        if (!b.this.a(b.this.abf())) {
                            b.this.caX.aaS();
                            return;
                        }
                        b.this.caX.Iv();
                        b.this.cba++;
                        if (b.this.abi()) {
                            b.this.l(b.this.cbb, b.this.cba);
                        }
                        if (b.this.caP != null) {
                            b.this.caP.aaK();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && b.this.KE()) {
                        if (b.this.caO.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.af.a.SE().SJ()) {
                            String str3 = com.baidu.live.af.a.SE().bCb.aRB.aTe.aTo;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.caO.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.caO.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.caO.mLiveId, b.this.caO.mRoomId, b.this.caO.beS, b.this.caO.otherParams);
                            b.this.closeActivity();
                            return;
                        }
                        String str4 = "";
                        if (view.getId() == a.f.current_recharge) {
                            str4 = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                            if (b.this.caP != null) {
                                b.this.caP.aaN();
                                str = str4;
                            }
                            str = str4;
                        } else {
                            if (view.getId() == a.f.current_money) {
                                str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                            }
                            str = str4;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.caO.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && b.this.KE() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.d abf() {
        if (this.caZ == null) {
            return null;
        }
        return this.caZ.aaF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int abg() {
        GiftPanelSelectMicrophoneSendView.d abf = abf();
        if (abf == null || abf.ccd == null) {
            return 0;
        }
        return abf.ccd.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abh() {
        if (this.caP != null) {
            this.caP.aaI();
        }
        if (KE() && abi() && a(abf())) {
            if (this.caX.Jc().GA()) {
                this.cba = 0;
                this.cbb = System.currentTimeMillis();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501075, true));
            } else {
                this.cbb = 0L;
                this.cba = 0;
            }
            if (l(this.cbb, this.cba) && this.cbb != 0) {
                this.caX.Iw();
                this.caX.bU(false);
                if (this.caP != null) {
                    this.caP.aaJ();
                }
            }
        }
    }

    public void aaQ() {
        if (this.caX != null) {
            this.caX.aaS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(GiftPanelSelectMicrophoneSendView.d dVar) {
        if (dVar == null) {
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (dVar.ccd == null || dVar.ccd.size() == 0) {
            if (dVar.ccc != null && dVar.ccc.length > 0) {
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
    public boolean KE() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean KF() {
        return ("ala_tieba_android_consume".equals(this.caO.beU) || StringUtils.isNull(this.caO.beU) || this.caO.beU.equals(com.baidu.live.yuyingift.b.b.aba().HU())) ? false : true;
    }
}
