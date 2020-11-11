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
    protected boolean aZv;
    private AlaGiftTabView.d bQr = new AlaGiftTabView.d() { // from class: com.baidu.live.yuyingift.panel.b.2
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.d
        public void Ix() {
            b.this.JQ();
        }
    };
    public AlaGiftTabView bRB;
    protected e.a bRC;
    protected com.baidu.live.yuyingift.a.d bRt;
    private AlaGiftTabView.a bRu;
    private int bex;
    public TbPageContext mPageContext;

    protected abstract boolean JO();

    protected abstract boolean JP();

    protected abstract void JQ();

    public static b gA(int i) {
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
        this.bRC = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bRu = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.bRt = dVar;
    }

    public void ek(int i) {
        if (this.bRB != null) {
            this.bRB.ek(i);
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
        this.bRB = new AlaGiftTabView(getPageContext(), JL(), JN(), this.bRt.otherParams);
        this.bRB.a(this.bRu);
        if (this.bex != 0) {
            this.bRB.ek(this.bex);
        }
        this.bRB.au(this.bRt.mLiveId, this.bRt.mRoomId);
        this.bRB.x(this.bRt.aZZ, this.bRt.baa);
        this.bRB.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bRB.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bRB.a(this.bQr);
        this.bRB.bv(this.bRt.aYb);
        this.bRB.es(this.bRt.aXZ);
        this.aZv = this.bRt.aZv;
        this.bRB.bD(this.bRt.aZv);
        this.bRB.b(this.bRt.isNewUser, this.bRt.mLiveId, this.bRt.mRoomId, this.bRt.bbt);
        this.bRB.bc(this.bRt.bbx);
        this.bRB.dG(this.bRt.bab);
        this.bRB.bF(this.bRt.bam);
        this.bRB.el(this.bRt.bby);
        this.bRB.be(this.bRt.aYh);
        this.bRB.bG(this.bRt.bbA);
        return this.bRB.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bRB.bC(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bRB.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bRB != null) {
            this.bRB.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bRu = null;
        this.bRC = null;
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bRt.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener JL() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.bRB.aZy);
                    if (view.getId() == a.f.donate) {
                        b.this.XN();
                    } else if (view.getId() == a.f.combo_btn && b.this.JM() && b.this.a(b.this.XL())) {
                        b.this.bRB.HN();
                        if (b.this.JO()) {
                            b.this.JP();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && b.this.JM()) {
                        if (b.this.bRt.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.aa.a.PQ().PV()) {
                            String str3 = com.baidu.live.aa.a.PQ().btT.aPx.aQS.aQZ;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.bRt.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.bRt.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.bRt.mLiveId, b.this.bRt.mRoomId, b.this.bRt.bbt, b.this.bRt.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.bRt.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && b.this.JM() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.i XL() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501048, a.InterfaceC0239a.class);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return ((a.InterfaceC0239a) runTask.getData()).Xz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int XM() {
        GiftPanelSelectMicrophoneSendView.i XL = XL();
        if (XL == null || XL.bSx == null) {
            return 0;
        }
        return XL.bSx.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XN() {
        if (JM() && JO() && a(XL())) {
            g Is = this.bRB.Is();
            if (JP() && Is.Gb()) {
                if (!Is.FZ() || (Is.FZ() && this.bRB.It() == 1)) {
                    this.bRB.HO();
                    this.bRB.bL(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(GiftPanelSelectMicrophoneSendView.i iVar) {
        if (iVar == null) {
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (iVar.bSx == null || iVar.bSx.size() == 0) {
            if (iVar.bSw != null && iVar.bSw.length > 0) {
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
    public boolean JM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean JN() {
        return ("ala_tieba_android_consume".equals(this.bRt.bbv) || StringUtils.isNull(this.bRt.bbv) || this.bRt.bbv.equals(com.baidu.live.yuyingift.b.b.XE().Hl())) ? false : true;
    }
}
