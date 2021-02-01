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
    protected boolean bbc;
    private int bgK;
    protected com.baidu.live.yuyingift.a.d cae;
    private AlaGiftTabView.a caf;
    public AlaGiftTabView can;
    protected e.a cao;
    protected a.InterfaceC0238a cap;
    public TbPageContext mPageContext;
    protected int caq = 0;
    protected long car = 0;
    private AlaGiftTabView.e bYT = new AlaGiftTabView.e() { // from class: com.baidu.live.yuyingift.panel.b.3
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.e
        public void GC() {
            b.this.Ic();
        }
    };

    protected abstract void Ic();

    protected abstract boolean Zf();

    protected abstract boolean l(long j, int i);

    public static b a(a.InterfaceC0238a interfaceC0238a, int i) {
        switch (i) {
            case 0:
                c cVar = new c();
                cVar.cap = interfaceC0238a;
                return cVar;
            case 1:
                d dVar = new d();
                dVar.cap = interfaceC0238a;
                return dVar;
            default:
                return null;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(e.a aVar) {
        this.cao = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.caf = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.cae = dVar;
    }

    public void cX(int i) {
        if (this.can != null) {
            this.can.cX(i);
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
        this.can = new AlaGiftTabView(getPageContext(), HY(), Ia(), this.cae.otherParams);
        this.can.a(this.caf);
        if (this.bgK != 0) {
            this.can.cX(this.bgK);
        }
        this.can.au(this.cae.mLiveId, this.cae.mRoomId);
        this.can.A(this.cae.bbK, this.cae.bbL);
        this.can.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.can.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.can.a(this.bYT);
        this.can.bF(this.cae.aZF);
        this.can.dg(this.cae.aZD);
        this.bbc = this.cae.bbc;
        this.can.bN(this.cae.bbc);
        this.can.b(this.cae.isNewUser, this.cae.mLiveId, this.cae.mRoomId, this.cae.bdj);
        this.can.bh(this.cae.bdn);
        this.can.cp(this.cae.bbM);
        this.can.bP(this.cae.bbY);
        this.can.cY(this.cae.bdo);
        this.can.bj(this.cae.aZL);
        this.can.bQ(this.cae.bdq);
        this.can.a(new AlaGiftTabView.b() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.b
            public void j(g gVar) {
                if (gVar != null && b.this.cae != null && b.this.Zd() > 0) {
                    com.baidu.live.yuyingift.b.b.YX().a(b.this.car, b.this.caq + 1, gVar.DR(), b.this.cae.mLiveId, s.al(b.this.Zc().cbt));
                    b.this.car = 0L;
                    b.this.caq = 0;
                }
            }
        });
        return this.can.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.can.bM(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.can.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.can != null) {
            this.can.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.caf = null;
        this.cao = null;
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
    public void HX() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.cae.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener HY() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.can.bbg);
                    if (view.getId() == a.f.donate) {
                        b.this.Ze();
                    } else if (view.getId() == a.f.combo_btn && b.this.HZ()) {
                        if (!b.this.a(b.this.Zc())) {
                            b.this.can.YP();
                            return;
                        }
                        b.this.can.FQ();
                        b.this.caq++;
                        if (b.this.Zf()) {
                            b.this.l(b.this.car, b.this.caq);
                        }
                        if (b.this.caf != null) {
                            b.this.caf.YH();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && b.this.HZ()) {
                        if (b.this.cae.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.ae.a.Qj().Qp()) {
                            String str3 = com.baidu.live.ae.a.Qj().bAS.aPM.aRu.aRD;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.cae.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.cae.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.cae.mLiveId, b.this.cae.mRoomId, b.this.cae.bdj, b.this.cae.otherParams);
                            b.this.closeActivity();
                            return;
                        }
                        String str4 = "";
                        if (view.getId() == a.f.current_recharge) {
                            str4 = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                            if (b.this.caf != null) {
                                b.this.caf.YK();
                                str = str4;
                            }
                            str = str4;
                        } else {
                            if (view.getId() == a.f.current_money) {
                                str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                            }
                            str = str4;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.cae.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && b.this.HZ() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.d Zc() {
        if (this.cap == null) {
            return null;
        }
        return this.cap.YC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Zd() {
        GiftPanelSelectMicrophoneSendView.d Zc = Zc();
        if (Zc == null || Zc.cbt == null) {
            return 0;
        }
        return Zc.cbt.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ze() {
        if (this.caf != null) {
            this.caf.YF();
        }
        if (HZ() && Zf()) {
            if (this.can.Gx().DV()) {
                this.caq = 0;
                this.car = System.currentTimeMillis();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501075, true));
            } else {
                this.car = 0L;
                this.caq = 0;
            }
            if (l(this.car, this.caq) && this.car != 0) {
                this.can.FR();
                this.can.bV(false);
                if (this.caf != null) {
                    this.caf.YG();
                }
            }
        }
    }

    public void YN() {
        if (this.can != null) {
            this.can.YP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(GiftPanelSelectMicrophoneSendView.d dVar) {
        if (dVar == null) {
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (dVar.cbt == null || dVar.cbt.size() == 0) {
            if (dVar.cbr != null && dVar.cbr.length > 0) {
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
    public boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Ia() {
        return ("ala_tieba_android_consume".equals(this.cae.bdl) || StringUtils.isNull(this.cae.bdl) || this.cae.bdl.equals(com.baidu.live.yuyingift.b.b.YX().Fp())) ? false : true;
    }
}
