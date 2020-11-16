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
import com.baidu.live.yuyingift.container.AlaGiftTabView;
import com.baidu.live.yuyingift.panel.a;
import com.baidu.live.yuyingift.panel.e;
import com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView;
/* loaded from: classes4.dex */
public abstract class b extends LazyLoadFragment {
    protected boolean aXK;
    private AlaGiftTabView.d bOH = new AlaGiftTabView.d() { // from class: com.baidu.live.yuyingift.panel.b.2
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.d
        public void HO() {
            b.this.Jh();
        }
    };
    protected com.baidu.live.yuyingift.a.d bPJ;
    private AlaGiftTabView.a bPK;
    public AlaGiftTabView bPR;
    protected e.a bPS;
    private int bcK;
    public TbPageContext mPageContext;

    protected abstract boolean Jf();

    protected abstract boolean Jg();

    protected abstract void Jh();

    public static b gw(int i) {
        switch (i) {
            case 0:
                return new c();
            case 1:
                return new d();
            default:
                return null;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(e.a aVar) {
        this.bPS = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bPK = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.bPJ = dVar;
    }

    public void eg(int i) {
        if (this.bPR != null) {
            this.bPR.eg(i);
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
        this.bPR = new AlaGiftTabView(getPageContext(), Jc(), Je(), this.bPJ.otherParams);
        this.bPR.a(this.bPK);
        if (this.bcK != 0) {
            this.bPR.eg(this.bcK);
        }
        this.bPR.at(this.bPJ.mLiveId, this.bPJ.mRoomId);
        this.bPR.x(this.bPJ.aYo, this.bPJ.aYp);
        this.bPR.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bPR.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bPR.a(this.bOH);
        this.bPR.bx(this.bPJ.aWq);
        this.bPR.eo(this.bPJ.aWo);
        this.aXK = this.bPJ.aXK;
        this.bPR.bF(this.bPJ.aXK);
        this.bPR.b(this.bPJ.isNewUser, this.bPJ.mLiveId, this.bPJ.mRoomId, this.bPJ.aZH);
        this.bPR.be(this.bPJ.aZL);
        this.bPR.dC(this.bPJ.aYq);
        this.bPR.bH(this.bPJ.aYB);
        this.bPR.eh(this.bPJ.aZM);
        this.bPR.bg(this.bPJ.aWw);
        this.bPR.bI(this.bPJ.aZO);
        return this.bPR.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bPR.bE(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bPR.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bPR != null) {
            this.bPR.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bPK = null;
        this.bPS = null;
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bPJ.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Jc() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.bPR.aXN);
                    if (view.getId() == a.f.donate) {
                        b.this.Xe();
                    } else if (view.getId() == a.f.combo_btn && b.this.Jd() && b.this.a(b.this.Xc())) {
                        b.this.bPR.He();
                        if (b.this.Jf()) {
                            b.this.Jg();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && b.this.Jd()) {
                        if (b.this.bPJ.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.aa.a.Ph().Pm()) {
                            String str3 = com.baidu.live.aa.a.Ph().bsh.aNM.aPh.aPo;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.bPJ.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.bPJ.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.bPJ.mLiveId, b.this.bPJ.mRoomId, b.this.bPJ.aZH, b.this.bPJ.otherParams);
                            b.this.closeActivity();
                            return;
                        }
                        if (view.getId() == a.f.current_recharge) {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                        } else if (view.getId() != a.f.current_money) {
                            str = "";
                        } else {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.bPJ.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && b.this.Jd() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.i Xc() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501048, a.InterfaceC0237a.class);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return ((a.InterfaceC0237a) runTask.getData()).WQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Xd() {
        GiftPanelSelectMicrophoneSendView.i Xc = Xc();
        if (Xc == null || Xc.bQN == null) {
            return 0;
        }
        return Xc.bQN.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xe() {
        if (Jd() && Jf() && a(Xc())) {
            g HJ = this.bPR.HJ();
            if (Jg() && HJ.Fs()) {
                if (!HJ.Fq() || (HJ.Fq() && this.bPR.HK() == 1)) {
                    this.bPR.Hf();
                    this.bPR.bN(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(GiftPanelSelectMicrophoneSendView.i iVar) {
        if (iVar == null) {
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (iVar.bQN == null || iVar.bQN.size() == 0) {
            if (iVar.bQM != null && iVar.bQM.length > 0) {
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
    public boolean Jd() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Je() {
        return ("ala_tieba_android_consume".equals(this.bPJ.aZJ) || StringUtils.isNull(this.bPJ.aZJ) || this.bPJ.aZJ.equals(com.baidu.live.yuyingift.b.b.WV().GC())) ? false : true;
    }
}
