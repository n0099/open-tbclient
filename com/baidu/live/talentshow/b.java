package com.baidu.live.talentshow;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.an.c;
import com.baidu.live.data.bm;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.c.e;
import com.baidu.live.talentshow.components.a.a;
import com.baidu.live.talentshow.components.a.b;
import com.baidu.live.talentshow.components.b.a;
import com.baidu.live.talentshow.components.waitpanel.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ar.ArSoCheckerManager;
import com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.f;
/* loaded from: classes4.dex */
public class b implements c {
    private w aFN;
    private com.baidu.live.talentshow.a.b byA;
    private com.baidu.live.talentshow.components.preview.b byB;
    private d byC;
    private e byD;
    private com.baidu.live.talentshow.a.c byE;
    private com.baidu.live.talentshow.components.a.b byF;
    private ViewGroup byG;
    private f byH;
    private com.baidu.live.talentshow.d.c byI;
    private com.baidu.live.talentshow.components.b.b byJ;
    private c.a byK;
    private TelephonyManager byM;
    private FrameLayout byb;
    private com.baidu.live.talentshow.model.d byj;
    private com.baidu.live.talentshow.components.enter.a byz;
    private TbPageContext mPageContext;
    private boolean byL = false;
    private a.InterfaceC0210a byN = new a.InterfaceC0210a() { // from class: com.baidu.live.talentshow.b.1
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0210a
        public void a(View view, int i, long j) {
            BdLog.e("BLMRtcVideo AudienceLogic  index = " + i);
            b.this.SC();
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0210a
        public void b(View view, boolean z) {
            if (b.this.byI != null) {
                b.this.byI.setMute(z);
            }
        }
    };
    private com.baidu.live.talentshow.components.enter.b byO = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.b.7
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                return;
            }
            if (b.this.byI.Ue()) {
                b.this.SF();
            } else if (!b.this.byI.Ud()) {
                b.this.SD();
            } else {
                b.this.SG();
            }
            com.baidu.live.talentshow.e.a.Uz();
        }
    };
    private d.a byP = new d.a() { // from class: com.baidu.live.talentshow.b.8
        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void SR() {
            b.this.byB.Tg();
            if (b.this.byD != null && b.this.byI.Ue()) {
                b.this.byD.TQ();
            }
            com.baidu.live.talentshow.e.a.UB();
        }

        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void Mk() {
            if (b.this.byB != null) {
                b.this.byB.Th();
            }
            if (b.this.byC != null) {
                b.this.byC.TA();
            }
            b.this.SE();
            b.this.SI();
            b.this.mPageContext.showToast(a.h.talent_master_not_agree);
        }
    };
    private com.baidu.live.talentshow.components.preview.a byQ = new com.baidu.live.talentshow.components.preview.a() { // from class: com.baidu.live.talentshow.b.10
        @Override // com.baidu.live.talentshow.components.preview.a
        public void SS() {
            if (b.this.byA.TH()) {
                b.this.byB.Tg();
                b.this.byD.TP();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkapply_clk").setContentExt(null, "popup", null));
            }
        }
    };
    private com.baidu.live.talentshow.c.c byR = new com.baidu.live.talentshow.c.c() { // from class: com.baidu.live.talentshow.b.11
        @Override // com.baidu.live.talentshow.c.c
        public void a(com.baidu.live.talentshow.b.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS).setContentExt(null, "popup", null));
            b.this.byB.Th();
            b.this.byB.Tj();
            if (b.this.byI != null) {
                b.this.byI.Ua();
            }
            if (b.this.aFN.mLiveInfo != null && b.this.aFN.mLiveInfo.videoBCEnterData != null) {
                b.this.aFN.mLiveInfo.videoBCEnterData.audienceWaitTime = JavaTypesHelper.toInt(aVar.TN(), 0);
                b.this.r(b.this.aFN);
            }
            b.this.SI();
            b.this.mPageContext.showToast(a.h.talent_apply_chat_success);
        }

        @Override // com.baidu.live.talentshow.c.c
        public void x(int i, String str) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL).setContentExt(null, "popup", null));
            b.this.byB.Th();
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_apply_chat_fail);
            }
            b.this.mPageContext.showToast(str);
        }
    };
    private com.baidu.live.talentshow.c.d byS = new com.baidu.live.talentshow.c.d() { // from class: com.baidu.live.talentshow.b.12
        @Override // com.baidu.live.talentshow.c.d
        public void ST() {
            if (b.this.byI.Ue()) {
                if (b.this.byB != null) {
                    b.this.byB.Th();
                }
                if (b.this.byC != null) {
                    b.this.byC.stopTiming();
                    b.this.byC.TA();
                }
                if (b.this.byI != null) {
                    b.this.byI.Ub();
                }
                b.this.mPageContext.showToast(a.h.talent_cancel_apply_success);
                b.this.SI();
            }
        }

        @Override // com.baidu.live.talentshow.c.d
        public void y(int i, String str) {
            if (b.this.byB.Ti()) {
                b.this.byB.Th();
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_cancel_apply_failure);
            }
            b.this.mPageContext.showToast(str);
            b.this.SI();
        }
    };
    private final com.baidu.live.talentshow.d.b byT = new com.baidu.live.talentshow.d.b() { // from class: com.baidu.live.talentshow.b.13
        @Override // com.baidu.live.talentshow.d.b
        public void fB(int i) {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_fail));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void SU() {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_success));
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_SUCCESS).setContentExt(null, "popup", null));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void cP(boolean z) {
            b.this.SN();
            if (b.this.byK != null) {
                b.this.byK.WL();
            }
            if (b.this.byF != null) {
                b.this.byF.SY();
            }
            b.this.SI();
            if (!z) {
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.talent_master_chat_disconnect));
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.alablmsdk.module.c cVar, int i) {
            if (b.this.byC != null) {
                b.this.byC.stopTiming();
                b.this.byC.TA();
            }
            b.this.a(cVar, i);
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.talentshow.b.c cVar) {
            if (b.this.byj != null) {
                b.this.byj.c(cVar);
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void SV() {
            if (b.this.byF != null) {
                b.this.byF.SX();
            }
            b.this.SI();
        }
    };
    private final PhoneStateListener byU = new PhoneStateListener() { // from class: com.baidu.live.talentshow.b.3
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    b.this.SO();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private final CustomMessageTask.CustomRunnable bxu = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.talentshow.b.4
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable");
            if (b.this.byI != null) {
                BdLog.e("BCVideoChat AudienceLogic showStatusRunnable " + b.this.byI.Uh());
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, Boolean.valueOf(b.this.byI.Uh()));
            }
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable false");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, false);
        }
    };
    private CustomMessageListener byV = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP) { // from class: com.baidu.live.talentshow.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdLog.e("BCVideoChat AudienceLogic showHangupListener");
            if (b.this.byI != null && b.this.byI.Uh()) {
                BdLog.e("BCVideoChat AudienceLogic showHangupListener true");
                b.this.SD();
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            com.baidu.live.alablmsdk.a.bh(TbadkCoreApplication.getInst().isDebugMode());
            this.mPageContext = tbPageContext;
            this.byA = new com.baidu.live.talentshow.a.b(tbPageContext.getPageActivity());
            this.byE = new com.baidu.live.talentshow.a.c(tbPageContext);
            this.byB = new com.baidu.live.talentshow.components.preview.b(tbPageContext);
            this.byB.a(this.byE);
            this.byB.a(this.byQ);
            this.byJ = new com.baidu.live.talentshow.components.b.b(this.mPageContext.getPageActivity(), this.byN);
            this.byI = new com.baidu.live.talentshow.d.c(this.mPageContext.getPageActivity());
            this.byI.a(this.byJ);
            this.byI.a(this.byT);
            this.byj = new com.baidu.live.talentshow.model.d(tbPageContext);
            this.byD = new com.baidu.live.talentshow.model.c(tbPageContext);
            this.byD.a(this.byR);
            this.byD.a(this.byS);
            this.byz = new com.baidu.live.talentshow.components.enter.a(tbPageContext, false);
            this.byz.a(this.byO);
        }
    }

    private void be(Context context) {
        this.byM = (TelephonyManager) context.getSystemService("phone");
        if (this.byM != null) {
            this.byM.listen(this.byU, 32);
        }
    }

    @Override // com.baidu.live.an.c
    public void q(w wVar) {
        this.aFN = wVar;
        this.byB.setLiveShowData(wVar);
        this.byD.s(wVar);
        if (this.byz != null) {
            this.byz.s(wVar);
        }
        if (this.byI != null) {
            this.byI.s(wVar);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.bxu);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.byV);
        be(this.mPageContext.getPageActivity().getApplicationContext());
    }

    @Override // com.baidu.live.an.c
    public void a(f fVar) {
        this.byH = fVar;
    }

    @Override // com.baidu.live.an.c
    public void b(FrameLayout frameLayout) {
        this.byb = frameLayout;
        if (this.byJ != null) {
            this.byJ.d(frameLayout);
        }
    }

    @Override // com.baidu.live.an.c
    public void SB() {
        if (this.byz != null) {
            this.byz.SZ();
        }
        if (this.byB != null) {
            this.byB.Th();
            this.byB.Tj();
        }
        if (this.byC != null) {
            this.byC.stopTiming();
            this.byC.TA();
        }
        if (this.byF != null) {
            this.byF.SX();
            this.byF.SY();
        }
        SE();
        if (this.byM != null) {
            this.byM.listen(this.byU, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.byV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SC() {
        if (this.byF == null || this.byI == null || !this.byI.Uh()) {
            return false;
        }
        BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
        SD();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SD() {
        BdLog.e("BLMRtcVideo AudienceLogic showQuitCheckConfirmDialog");
        int i = a.h.linkmic_cancel_confirm;
        if (this.byI.Uh()) {
            i = a.h.linkmic_close_confirm;
        }
        this.byF.a(this.mPageContext, this.mPageContext.getResources().getString(i), new b.a() { // from class: com.baidu.live.talentshow.b.6
            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Rt() {
                BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
                b.this.byI.TW();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_cfm").setContentExt(null, "popup", null));
            }

            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Ru() {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_can").setContentExt(null, "popup", null));
            }
        });
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW).setContentExt(null, "popup", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SE() {
        if (this.byI != null) {
            if (this.byD != null && this.byI.Ue()) {
                this.byD.TQ();
            }
            this.byI.TW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(w wVar) {
        if (this.byC == null) {
            this.byC = new d(this.mPageContext);
            this.byC.a(this.byP);
        }
        this.byC.u(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SF() {
        if (this.byC == null) {
            this.byC = new d(this.mPageContext);
            this.byC.a(this.byP);
        }
        this.byC.SF();
    }

    public void SG() {
        if (this.byA.TH()) {
            if (bm.b(com.baidu.live.ae.a.RB().bxq)) {
                SH();
            } else {
                SK();
            }
        }
    }

    private void SH() {
        if (this.byL) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.byL = true;
        if (ArSoCheckerManager.getInstance().getArSoStatusChecker() != null) {
            ArSoCheckerManager.getInstance().getArSoStatusChecker().checkArSoLoadStatus(this.mPageContext.getPageActivity(), new ArSoStatusCheckResultCallBack() { // from class: com.baidu.live.talentshow.b.9
                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onSuccess() {
                    b.this.byL = false;
                    b.this.SJ();
                }

                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onFail() {
                    b.this.byL = false;
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    }
                }
            });
        } else {
            this.byL = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SI() {
        if (this.byz != null && this.byI != null) {
            this.byz.fE(this.byI.Uc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        this.byB.n(this.mPageContext.getPageActivity(), true);
    }

    private void SK() {
        this.byB.n(this.mPageContext.getPageActivity(), false);
    }

    @Override // com.baidu.live.an.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.byC == null || !this.byC.onKeyDown(i, keyEvent)) {
            if (this.byI != null && this.byI.Uh()) {
                SC();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.an.c
    public View getEnterView() {
        if (this.byz != null) {
            return this.byz.getEnterView();
        }
        return null;
    }

    @Override // com.baidu.live.an.c
    public void onStarted() {
        if (this.byI != null) {
            this.byI.onStarted();
        }
    }

    @Override // com.baidu.live.an.c
    public void onStopped() {
        if (this.byI != null) {
            this.byI.onStopped();
        }
    }

    @Override // com.baidu.live.an.c
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.live.an.c
    public void a(c.a aVar) {
        this.byK = aVar;
    }

    @Override // com.baidu.live.an.c
    public void onDestroy() {
        if (this.byD != null) {
            this.byD.onDestroy();
            this.byD = null;
        }
        if (this.byj != null) {
            this.byj.onDestroy();
            this.byj = null;
        }
        if (this.byB != null) {
            this.byB.onDestroy();
            this.byB = null;
        }
        if (this.byI != null) {
            this.byI.onDestroy();
            this.byI = null;
        }
        if (this.byF != null) {
            this.byF.onDestroy();
        }
        if (this.byM != null) {
            this.byM.listen(this.byU, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.byV);
    }

    @Override // com.baidu.live.an.c
    public boolean SL() {
        return SC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.alablmsdk.module.c cVar, int i) {
        if (this.byF == null) {
            this.byF = new com.baidu.live.talentshow.components.a.b();
        }
        this.byF.a(this.mPageContext.getPageActivity(), new a.InterfaceC0209a() { // from class: com.baidu.live.talentshow.b.2
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0209a
            public boolean SP() {
                AlaLiveRecorder TI;
                BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick |" + b.this.byI + "|" + b.this.byE);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.mPageContext.showToast(a.h.talent_net_error);
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick 网络不可用");
                    return false;
                }
                if (b.this.byI != null && b.this.byE != null) {
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick status=" + b.this.byI.Uc());
                    if (b.this.byI.Uf() && (TI = b.this.byE.TI()) != null) {
                        b.this.SM();
                        b.this.byI.b(TI);
                        b.this.byI.TU();
                        b.this.SI();
                        if (b.this.byK != null) {
                            b.this.byK.WK();
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0209a
            public void SQ() {
                if (b.this.byI != null) {
                    b.this.byI.TV();
                }
                b.this.SI();
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_invite_timeout));
            }
        });
    }

    public void SM() {
        BdLog.e("BCVideoChat AudienceLogic removeRTMPPlayer");
        if (this.byH != null) {
            this.byH.cE(false);
            if (this.byH.getLivePlayer() != null && this.byH.getLivePlayer().getParent() != null) {
                this.byG = (ViewGroup) this.byH.getLivePlayer().getParent();
                ((ViewGroup) this.byH.getLivePlayer().getParent()).removeView(this.byH.getLivePlayer());
            }
        }
    }

    public void SN() {
        BdLog.e("BCVideoChat AudienceLogic switchRTMPLive");
        this.byE.TM();
        this.byE.TL();
        if (this.byG != null && this.byH != null && this.byH.getLivePlayer() != null && this.byH.getLivePlayer().getParent() == null) {
            this.byG.addView(this.byH.getLivePlayer(), new FrameLayout.LayoutParams(-1, -1));
            this.byH.c(this.aFN.mLiveInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SO() {
        if (this.byI != null) {
            if (this.byI.Ue()) {
                this.byD.TQ();
            } else if (this.byI.Uf()) {
                if (this.byF != null) {
                    this.byF.SX();
                }
                if (this.byI != null) {
                    this.byI.TV();
                }
                SI();
            } else {
                this.byI.TW();
            }
        }
    }
}
