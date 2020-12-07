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
    private AlaGiftTabView.d bTR = new AlaGiftTabView.d() { // from class: com.baidu.live.yuyingift.panel.b.2
        @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.d
        public void JF() {
            b.this.Li();
        }
    };
    protected com.baidu.live.yuyingift.a.d bUT;
    private AlaGiftTabView.a bUU;
    public AlaGiftTabView bVb;
    protected e.a bVc;
    protected boolean bbc;
    private int bgK;
    public TbPageContext mPageContext;

    protected abstract boolean Lg();

    protected abstract boolean Lh();

    protected abstract void Li();

    public static b gU(int i) {
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
        this.bVc = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bUU = aVar;
    }

    public void a(com.baidu.live.yuyingift.a.d dVar) {
        this.bUT = dVar;
    }

    public void eA(int i) {
        if (this.bVb != null) {
            this.bVb.eA(i);
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
        this.bVb = new AlaGiftTabView(getPageContext(), Ld(), Lf(), this.bUT.otherParams);
        this.bVb.a(this.bUU);
        if (this.bgK != 0) {
            this.bVb.eA(this.bgK);
        }
        this.bVb.ax(this.bUT.mLiveId, this.bUT.mRoomId);
        this.bVb.A(this.bUT.bbJ, this.bUT.bbK);
        this.bVb.aO(TbadkCoreApplication.getInst().currentAccountTdouNum);
        this.bVb.aP(TbadkCoreApplication.getInst().currentAccountFlowerNum);
        this.bVb.a(this.bTR);
        this.bVb.bG(this.bUT.aZG);
        this.bVb.eJ(this.bUT.aZE);
        this.bbc = this.bUT.bbc;
        this.bVb.bO(this.bUT.bbc);
        this.bVb.b(this.bUT.isNewUser, this.bUT.mLiveId, this.bUT.mRoomId, this.bUT.bdh);
        this.bVb.bm(this.bUT.bdl);
        this.bVb.dV(this.bUT.bbL);
        this.bVb.bQ(this.bUT.bbX);
        this.bVb.eB(this.bUT.bdm);
        this.bVb.bo(this.bUT.aZM);
        this.bVb.bR(this.bUT.bdo);
        return this.bVb.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        this.bVb.bN(this.mVisible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        this.bVb.onVisibilityChanged(z);
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected ILazyLoadFragmentController createController() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bVb != null) {
            this.bVb.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        this.bUU = null;
        this.bVc = null;
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, this.bUT.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "giving" : UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        this.mPageContext.getPageActivity().finish();
    }

    private View.OnClickListener Ld() {
        return new View.OnClickListener() { // from class: com.baidu.live.yuyingift.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                if (view != null) {
                    BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), b.this.bVb.bbf);
                    if (view.getId() == a.f.donate) {
                        b.this.ZD();
                    } else if (view.getId() == a.f.combo_btn && b.this.Le() && b.this.a(b.this.ZB())) {
                        b.this.bVb.IU();
                        if (b.this.Lg()) {
                            b.this.Lh();
                        }
                    } else if ((view.getId() == a.f.current_money || view.getId() == a.f.current_recharge) && b.this.Le()) {
                        if (b.this.bUT.isNewUser && view.getId() == a.f.current_recharge && !TbadkCoreApplication.getInst().isMobileBaidu() && com.baidu.live.ae.a.RB().RG()) {
                            String str3 = com.baidu.live.ae.a.RB().bxq.aQM.aSj.aSq;
                            if (str3.contains("?")) {
                                str2 = str3 + "&liveId=" + b.this.bUT.mLiveId;
                            } else {
                                str2 = str3 + "?liveId=" + b.this.bUT.mLiveId;
                            }
                            BrowserHelper.startInternalWebActivity(b.this.getPageContext().getPageActivity(), str2);
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePanelEntryLog(b.this.bUT.mLiveId, b.this.bUT.mRoomId, b.this.bUT.bdh, b.this.bUT.otherParams);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(b.this.getPageContext().getPageActivity(), 0L, b.this.bUT.otherParams, true, str, false)));
                    } else if (view.getId() == a.f.current_flower && b.this.Le() && MessageManager.getInstance().findTask(2913219) != null) {
                        b.this.closeActivity();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftPanelSelectMicrophoneSendView.i ZB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501048, a.InterfaceC0246a.class);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return ((a.InterfaceC0246a) runTask.getData()).Zp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ZC() {
        GiftPanelSelectMicrophoneSendView.i ZB = ZB();
        if (ZB == null || ZB.bVX == null) {
            return 0;
        }
        return ZB.bVX.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZD() {
        if (Le() && Lg() && a(ZB())) {
            g JA = this.bVb.JA();
            if (Lh() && JA.Hg()) {
                if (!JA.He() || (JA.He() && this.bVb.JB() == 1)) {
                    this.bVb.IV();
                    this.bVb.bW(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(GiftPanelSelectMicrophoneSendView.i iVar) {
        if (iVar == null) {
            this.mPageContext.showToast(a.h.yuyin_ala_gift_hint_notchoose_wheats);
            return false;
        } else if (iVar.bVX == null || iVar.bVX.size() == 0) {
            if (iVar.bVW != null && iVar.bVW.length > 0) {
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
    public boolean Le() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        return false;
    }

    private boolean Lf() {
        return ("ala_tieba_android_consume".equals(this.bUT.bdj) || StringUtils.isNull(this.bUT.bdj) || this.bUT.bdj.equals(com.baidu.live.yuyingift.b.b.Zu().It())) ? false : true;
    }
}
