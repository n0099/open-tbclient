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
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.ao.c;
import com.baidu.live.data.bo;
import com.baidu.live.data.x;
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
import com.baidu.live.v.f;
import com.baidu.minivideo.arface.b;
/* loaded from: classes10.dex */
public class b implements c {
    private x aBr;
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
    private a.InterfaceC0199a byN = new a.InterfaceC0199a() { // from class: com.baidu.live.talentshow.b.1
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0199a
        public void a(View view, int i, long j) {
            BdLog.e("BLMRtcVideo AudienceLogic  index = " + i);
            b.this.PL();
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0199a
        public void b(View view, boolean z) {
            if (b.this.byI != null) {
                b.this.byI.setMute(z);
            }
        }
    };
    private com.baidu.live.talentshow.components.enter.b byO = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.b.8
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                return;
            }
            if (b.this.byI.Rq()) {
                b.this.PO();
            } else if (!b.this.byI.Rp()) {
                b.this.PM();
            } else {
                b.this.PP();
            }
            com.baidu.live.talentshow.e.a.RL();
        }
    };
    private d.a byP = new d.a() { // from class: com.baidu.live.talentshow.b.9
        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void Qd() {
            b.this.byB.Qq();
            if (b.this.byD != null && b.this.byI.Rq()) {
                b.this.byD.Ra();
            }
            com.baidu.live.talentshow.e.a.RN();
        }

        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void onTimeout() {
            if (b.this.byB != null) {
                b.this.byB.Qr();
            }
            if (b.this.byC != null) {
                b.this.byC.QK();
            }
            b.this.PN();
            b.this.PS();
            b.this.mPageContext.showToast(a.h.talent_master_not_agree);
        }
    };
    private com.baidu.live.talentshow.components.preview.a byQ = new com.baidu.live.talentshow.components.preview.a() { // from class: com.baidu.live.talentshow.b.12
        @Override // com.baidu.live.talentshow.components.preview.a
        public void Qe() {
            if (b.this.byA.QR()) {
                b.this.byB.Qq();
                b.this.byD.QZ();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkapply_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        }
    };
    private com.baidu.live.talentshow.c.c byR = new com.baidu.live.talentshow.c.c() { // from class: com.baidu.live.talentshow.b.13
        @Override // com.baidu.live.talentshow.c.c
        public void a(com.baidu.live.talentshow.b.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            b.this.byB.Qr();
            b.this.byB.Qt();
            if (b.this.byI != null) {
                b.this.byI.Rm();
            }
            if (b.this.aBr.mLiveInfo != null && b.this.aBr.mLiveInfo.videoBCEnterData != null) {
                b.this.aBr.mLiveInfo.videoBCEnterData.audienceWaitTime = JavaTypesHelper.toInt(aVar.QX(), 0);
                b.this.s(b.this.aBr);
            }
            b.this.PS();
            b.this.mPageContext.showToast(a.h.talent_apply_chat_success);
        }

        @Override // com.baidu.live.talentshow.c.c
        public void A(int i, String str) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            b.this.byB.Qr();
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_apply_chat_fail);
            }
            b.this.mPageContext.showToast(str);
        }
    };
    private com.baidu.live.talentshow.c.d byS = new com.baidu.live.talentshow.c.d() { // from class: com.baidu.live.talentshow.b.14
        @Override // com.baidu.live.talentshow.c.d
        public void Qf() {
            if (b.this.byI.Rq()) {
                if (b.this.byB != null) {
                    b.this.byB.Qr();
                }
                if (b.this.byC != null) {
                    b.this.byC.stopTiming();
                    b.this.byC.QK();
                }
                if (b.this.byI != null) {
                    b.this.byI.Rn();
                }
                b.this.mPageContext.showToast(a.h.talent_cancel_apply_success);
                b.this.PS();
            }
        }

        @Override // com.baidu.live.talentshow.c.d
        public void B(int i, String str) {
            if (b.this.byB.Qs()) {
                b.this.byB.Qr();
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_cancel_apply_failure);
            }
            b.this.mPageContext.showToast(str);
            b.this.PS();
        }
    };
    private final com.baidu.live.talentshow.d.b byT = new com.baidu.live.talentshow.d.b() { // from class: com.baidu.live.talentshow.b.2
        @Override // com.baidu.live.talentshow.d.b
        public void dW(int i) {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_fail));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void PZ() {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_success));
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_SUCCESS).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void cO(boolean z) {
            b.this.PX();
            if (b.this.byK != null) {
                b.this.byK.TZ();
            }
            if (b.this.byF != null) {
                b.this.byF.Qi();
            }
            b.this.PS();
            if (!z) {
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.talent_master_chat_disconnect));
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.alablmsdk.module.c cVar, int i) {
            if (b.this.byC != null) {
                b.this.byC.stopTiming();
                b.this.byC.QK();
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
        public void Qa() {
            if (b.this.byF != null) {
                b.this.byF.Qh();
            }
            b.this.PS();
        }
    };
    private final PhoneStateListener byU = new PhoneStateListener() { // from class: com.baidu.live.talentshow.b.4
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    b.this.PY();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private final CustomMessageTask.CustomRunnable bxt = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.talentshow.b.5
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable");
            if (b.this.byI != null) {
                BdLog.e("BCVideoChat AudienceLogic showStatusRunnable " + b.this.byI.Rt());
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, Boolean.valueOf(b.this.byI.Rt()));
            }
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable false");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, false);
        }
    };
    private CustomMessageListener byV = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP) { // from class: com.baidu.live.talentshow.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdLog.e("BCVideoChat AudienceLogic showHangupListener");
            if (b.this.byI != null && b.this.byI.Rt()) {
                BdLog.e("BCVideoChat AudienceLogic showHangupListener true");
                b.this.PM();
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            com.baidu.live.alablmsdk.a.ba(TbadkCoreApplication.getInst().isDebugMode());
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

    private void bc(Context context) {
        this.byM = (TelephonyManager) context.getSystemService("phone");
        if (this.byM != null) {
            this.byM.listen(this.byU, 32);
        }
    }

    @Override // com.baidu.live.ao.c
    public void r(x xVar) {
        this.aBr = xVar;
        this.byB.setLiveShowData(xVar);
        this.byD.t(xVar);
        if (this.byz != null) {
            this.byz.t(xVar);
        }
        if (this.byI != null) {
            this.byI.t(xVar);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.bxt);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.byV);
        bc(this.mPageContext.getPageActivity().getApplicationContext());
    }

    @Override // com.baidu.live.ao.c
    public void a(f fVar) {
        this.byH = fVar;
    }

    @Override // com.baidu.live.ao.c
    public void b(FrameLayout frameLayout) {
        this.byb = frameLayout;
        if (this.byJ != null) {
            this.byJ.d(frameLayout);
        }
    }

    @Override // com.baidu.live.ao.c
    public void PK() {
        if (this.byz != null) {
            this.byz.Qj();
        }
        if (this.byB != null) {
            this.byB.Qr();
            this.byB.Qt();
        }
        if (this.byC != null) {
            this.byC.stopTiming();
            this.byC.QK();
        }
        if (this.byF != null) {
            this.byF.Qh();
            this.byF.Qi();
        }
        PN();
        if (this.byM != null) {
            this.byM.listen(this.byU, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.byV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PL() {
        if (this.byF == null || this.byI == null || !this.byI.Rt()) {
            return false;
        }
        BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
        PM();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PM() {
        BdLog.e("BLMRtcVideo AudienceLogic showQuitCheckConfirmDialog");
        int i = a.h.linkmic_cancel_confirm;
        if (this.byI.Rt()) {
            i = a.h.linkmic_close_confirm;
        }
        this.byF.a(this.mPageContext, this.mPageContext.getResources().getString(i), new b.a() { // from class: com.baidu.live.talentshow.b.7
            @Override // com.baidu.live.talentshow.components.a.b.a
            public void OB() {
                BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
                b.this.byI.Ri();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_cfm").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }

            @Override // com.baidu.live.talentshow.components.a.b.a
            public void OC() {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_can").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        });
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PN() {
        if (this.byI != null) {
            if (this.byD != null && this.byI.Rq()) {
                this.byD.Ra();
            }
            this.byI.Ri();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(x xVar) {
        if (this.byC == null) {
            this.byC = new d(this.mPageContext);
            this.byC.a(this.byP);
        }
        this.byC.v(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PO() {
        if (this.byC == null) {
            this.byC = new d(this.mPageContext);
            this.byC.a(this.byP);
        }
        this.byC.PO();
    }

    public void PP() {
        if (this.byA.QR()) {
            if (bo.b(com.baidu.live.af.a.OJ().bxp)) {
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    PR();
                    return;
                } else {
                    PQ();
                    return;
                }
            }
            PU();
        }
    }

    private void PQ() {
        if (this.byL) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.byL = true;
        if (ArSoCheckerManager.getInstance().getArSoStatusChecker() != null) {
            ArSoCheckerManager.getInstance().getArSoStatusChecker().checkArSoLoadStatus(this.mPageContext.getPageActivity(), new ArSoStatusCheckResultCallBack() { // from class: com.baidu.live.talentshow.b.10
                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onSuccess() {
                    b.this.byL = false;
                    b.this.PT();
                }

                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onFail() {
                    b.this.byL = false;
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    }
                }
            });
            return;
        }
        this.byL = false;
        PR();
    }

    private void PR() {
        if (this.byL) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.byL = true;
        com.baidu.minivideo.arface.b.a(new b.a() { // from class: com.baidu.live.talentshow.b.11
            @Override // com.baidu.minivideo.arface.b.a
            public void onProgress(int i, int i2) {
            }

            @Override // com.baidu.minivideo.arface.b.a
            public void onResult(final boolean z, String str) {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.talentshow.b.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            b.this.byL = false;
                            b.this.PT();
                            return;
                        }
                        b.this.byL = false;
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PS() {
        if (this.byz != null && this.byI != null) {
            this.byz.dZ(this.byI.Ro());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PT() {
        this.byB.n(this.mPageContext.getPageActivity(), true);
    }

    private void PU() {
        this.byB.n(this.mPageContext.getPageActivity(), false);
    }

    @Override // com.baidu.live.ao.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.byC == null || !this.byC.onKeyDown(i, keyEvent)) {
            if (this.byI != null && this.byI.Rt()) {
                PL();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.ao.c
    public View getEnterView() {
        if (this.byz != null) {
            return this.byz.getEnterView();
        }
        return null;
    }

    @Override // com.baidu.live.ao.c
    public void onStarted() {
        if (this.byI != null) {
            this.byI.onStarted();
        }
    }

    @Override // com.baidu.live.ao.c
    public void onStopped() {
        if (this.byI != null) {
            this.byI.onStopped();
        }
    }

    @Override // com.baidu.live.ao.c
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.live.ao.c
    public void a(c.a aVar) {
        this.byK = aVar;
    }

    @Override // com.baidu.live.ao.c
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

    @Override // com.baidu.live.ao.c
    public boolean PV() {
        return PL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.alablmsdk.module.c cVar, int i) {
        if (this.byF == null) {
            this.byF = new com.baidu.live.talentshow.components.a.b();
        }
        this.byF.a(this.mPageContext.getPageActivity(), new a.InterfaceC0198a() { // from class: com.baidu.live.talentshow.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0198a
            public boolean Qb() {
                AlaLiveRecorder QS;
                BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick |" + b.this.byI + "|" + b.this.byE);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.mPageContext.showToast(a.h.talent_net_error);
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick 网络不可用");
                    return false;
                }
                if (b.this.byI != null && b.this.byE != null) {
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick status=" + b.this.byI.Ro());
                    if (b.this.byI.Rr() && (QS = b.this.byE.QS()) != null) {
                        b.this.PW();
                        b.this.byI.b(QS);
                        b.this.byI.Rg();
                        b.this.PS();
                        if (b.this.byK != null) {
                            b.this.byK.TY();
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0198a
            public void Qc() {
                if (b.this.byI != null) {
                    b.this.byI.Rh();
                }
                b.this.PS();
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_invite_timeout));
            }
        });
    }

    public void PW() {
        BdLog.e("BCVideoChat AudienceLogic removeRTMPPlayer");
        if (this.byH != null) {
            this.byH.cD(false);
            if (this.byH.getLivePlayer() != null && this.byH.getLivePlayer().getParent() != null) {
                this.byG = (ViewGroup) this.byH.getLivePlayer().getParent();
                ((ViewGroup) this.byH.getLivePlayer().getParent()).removeView(this.byH.getLivePlayer());
            }
        }
    }

    public void PX() {
        BdLog.e("BCVideoChat AudienceLogic switchRTMPLive");
        this.byE.QW();
        this.byE.QV();
        if (this.byG != null && this.byH != null && this.byH.getLivePlayer() != null && this.byH.getLivePlayer().getParent() == null) {
            this.byG.addView(this.byH.getLivePlayer(), new FrameLayout.LayoutParams(-1, -1));
            this.byH.c(this.aBr.mLiveInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PY() {
        if (this.byI != null) {
            if (this.byI.Rq()) {
                this.byD.Ra();
            } else if (this.byI.Rr()) {
                if (this.byF != null) {
                    this.byF.Qh();
                }
                if (this.byI != null) {
                    this.byI.Rh();
                }
                PS();
            } else {
                this.byI.Ri();
            }
        }
    }
}
