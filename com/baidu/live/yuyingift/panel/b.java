package com.baidu.live.yuyingift.panel;

import android.os.Bundle;
import android.text.TextUtils;
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
    protected boolean aYd;
    private AlaGiftTabView.d bKJ = new AlaGiftTabView.d() { // from class: com.baidu.live.yuyingift.panel.b.2
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.d
        public void HW() {
            b.this.Jp();
        }
    };
    protected com.baidu.live.yuyingift.a.d bLL;
    private AlaGiftTabView.a bLM;
    public AlaGiftTabView bLT;
    protected e.a bLU;
    private int bdc;
    public TbPageContext mPageContext;

    protected abstract boolean Jn();

    protected abstract boolean Jo();

    protected abstract void Jp();

    public static b gq(int i) {
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
        this.bLU = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bLM = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.bLL = dVar;
    }

    public void ek(int i) {
        if (this.bLT != null) {
            this.bLT.ek(i);
        } else {
            this.bdc = i;
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected boolean lazy() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected View genRootView() {
        this.bLT = new AlaGiftTabView(getPageContext(), Jk(), Jm(), this.bLL.otherParams);
        this.bLT.a(this.bLM);
        if (this.bdc != 0) {
            this.bLT.ek(this.bdc);
        }
        this.bLT.at(this.bLL.mLiveId, this.bLL.mRoomId);
        this.bLT.x(this.bLL.aYH, this.bLL.aYI);
        this.bLT.ae(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bLT.af(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bLT.a(this.bKJ);
        this.bLT.bu(this.bLL.aWJ);
        this.bLT.es(this.bLL.aWH);
        this.aYd = this.bLL.aYd;
        this.bLT.bC(this.bLL.aYd);
        this.bLT.b(this.bLL.isNewUser, this.bLL.mLiveId, this.bLL.mRoomId, this.bLL.baa);
        this.bLT.bb(this.bLL.bae);
        this.bLT.dG(this.bLL.aYJ);
        this.bLT.bE(this.bLL.aYU);
        this.bLT.el(this.bLL.baf);
        this.bLT.bd(this.bLL.aWP);
        this.bLT.bF(this.bLL.bah);
        return this.bLT.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bLT.bB(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bLT.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bLT != null) {
            this.bLT.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bLM = null;
        this.bLU = null;
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
    public void Jj() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bLL.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Jk() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.bLT.aYg);
                    if (view.getId() == a.g.donate) {
                        b.this.Vo();
                    } else if (view.getId() == a.g.combo_btn && b.this.Jl() && b.this.a(b.this.Vm())) {
                        b.this.bLT.Hm();
                        if (b.this.Jn()) {
                            b.this.Jo();
                        }
                    } else if ((view.getId() == a.g.current_money || view.getId() == a.g.current_recharge) && b.this.Jl()) {
                        if (b.this.bLL.isNewUser && view.getId() == a.g.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.z.a.Pq().Pu()) {
                            String str3 = com.baidu.live.z.a.Pq().bsy.aOA.aPQ.aPX;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.bLL.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.bLL.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.bLL.mLiveId, b.this.bLL.mRoomId, b.this.bLL.baa, b.this.bLL.otherParams);
                            b.this.closeActivity();
                            return;
                        }
                        if (view.getId() == a.g.current_recharge) {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_one" : "recharge";
                        } else if (view.getId() != a.g.current_money) {
                            str = "";
                        } else {
                            str = TbadkCoreApplication.getInst().isHaokan() ? "gift_two" : "tdou";
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.bLL.otherParams, true, str, false)));
                    } else if (view.getId() == a.g.current_flower && b.this.Jl() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.i Vm() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501048, a.InterfaceC0227a.class);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return ((a.InterfaceC0227a) runTask.getData()).Va();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Vn() {
        GiftPanelSelectMicrophoneSendView.i Vm = Vm();
        if (Vm == null || Vm.bMO == null) {
            return 0;
        }
        return Vm.bMO.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        if (Jl() && Jn() && a(Vm())) {
            g HR = this.bLT.HR();
            if (Jo() && HR.FA()) {
                if (!HR.Fy() || (HR.Fy() && this.bLT.HS() == 1)) {
                    this.bLT.Hn();
                    this.bLT.bK(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(GiftPanelSelectMicrophoneSendView.i iVar) {
        if (iVar == null) {
            this.mPageContext.showToast(a.i.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (iVar.bMO == null || iVar.bMO.size() == 0) {
            if (!TextUtils.isEmpty(iVar.bMN)) {
                this.mPageContext.showToast(a.i.yuyin_ala_gift_hint_wheat_offline);
                return false;
            }
            this.mPageContext.showToast(a.i.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Jm() {
        return ("ala_tieba_android_consume".equals(this.bLL.bac) || StringUtils.isNull(this.bLL.bac) || this.bLL.bac.equals(com.baidu.live.yuyingift.b.b.Vf().GK())) ? false : true;
    }
}
