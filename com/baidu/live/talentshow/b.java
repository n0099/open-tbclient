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
import com.baidu.live.am.c;
import com.baidu.live.data.ab;
import com.baidu.live.data.bt;
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
import com.baidu.minivideo.arface.b;
/* loaded from: classes10.dex */
public class b implements c {
    private ab aED;
    private com.baidu.live.talentshow.components.enter.a bDF;
    private com.baidu.live.talentshow.a.b bDG;
    private com.baidu.live.talentshow.components.preview.b bDH;
    private d bDI;
    private e bDJ;
    private com.baidu.live.talentshow.a.c bDK;
    private com.baidu.live.talentshow.components.a.b bDL;
    private ViewGroup bDM;
    private f bDN;
    private com.baidu.live.talentshow.d.c bDO;
    private com.baidu.live.talentshow.components.b.b bDP;
    private c.a bDQ;
    private TelephonyManager bDS;
    private FrameLayout bDh;
    private com.baidu.live.talentshow.model.d bDp;
    private TbPageContext mPageContext;
    private boolean bDR = false;
    private a.InterfaceC0207a bDT = new a.InterfaceC0207a() { // from class: com.baidu.live.talentshow.b.1
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0207a
        public void a(View view, int i, long j) {
            BdLog.e("BLMRtcVideo AudienceLogic  index = " + i);
            b.this.Ry();
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0207a
        public void b(View view, boolean z) {
            if (b.this.bDO != null) {
                b.this.bDO.setMute(z);
            }
        }
    };
    private com.baidu.live.talentshow.components.enter.b bDU = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.b.8
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                return;
            }
            if (b.this.bDO.Ta()) {
                b.this.RB();
            } else if (!b.this.bDO.SZ()) {
                b.this.Rz();
            } else {
                b.this.RC();
            }
            com.baidu.live.talentshow.e.a.Tv();
        }
    };
    private d.a bDV = new d.a() { // from class: com.baidu.live.talentshow.b.9
        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void RQ() {
            b.this.bDH.Sd();
            if (b.this.bDJ != null && b.this.bDO.Ta()) {
                b.this.bDJ.SM();
            }
            com.baidu.live.talentshow.e.a.Tx();
        }

        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void onTimeout() {
            if (b.this.bDH != null) {
                b.this.bDH.Se();
            }
            if (b.this.bDI != null) {
                b.this.bDI.Sx();
            }
            b.this.RA();
            b.this.RF();
            b.this.mPageContext.showToast(a.h.talent_master_not_agree);
        }
    };
    private com.baidu.live.talentshow.components.preview.a bDW = new com.baidu.live.talentshow.components.preview.a() { // from class: com.baidu.live.talentshow.b.12
        @Override // com.baidu.live.talentshow.components.preview.a
        public void RR() {
            if (b.this.bDG.SE()) {
                b.this.bDH.Sd();
                b.this.bDJ.SL();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkapply_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        }
    };
    private com.baidu.live.talentshow.c.c bDX = new com.baidu.live.talentshow.c.c() { // from class: com.baidu.live.talentshow.b.13
        @Override // com.baidu.live.talentshow.c.c
        public void a(com.baidu.live.talentshow.b.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            b.this.bDH.Se();
            b.this.bDH.Sg();
            if (b.this.bDO != null) {
                b.this.bDO.SW();
            }
            if (b.this.aED.mLiveInfo != null && b.this.aED.mLiveInfo.videoBCEnterData != null) {
                b.this.aED.mLiveInfo.videoBCEnterData.audienceWaitTime = JavaTypesHelper.toInt(aVar.SJ(), 0);
                b.this.s(b.this.aED);
            }
            b.this.RF();
            b.this.mPageContext.showToast(a.h.talent_apply_chat_success);
        }

        @Override // com.baidu.live.talentshow.c.c
        public void E(int i, String str) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            b.this.bDH.Se();
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_apply_chat_fail);
            }
            b.this.mPageContext.showToast(str);
        }
    };
    private com.baidu.live.talentshow.c.d bDY = new com.baidu.live.talentshow.c.d() { // from class: com.baidu.live.talentshow.b.14
        @Override // com.baidu.live.talentshow.c.d
        public void RS() {
            if (b.this.bDO.Ta()) {
                if (b.this.bDH != null) {
                    b.this.bDH.Se();
                }
                if (b.this.bDI != null) {
                    b.this.bDI.stopTiming();
                    b.this.bDI.Sx();
                }
                if (b.this.bDO != null) {
                    b.this.bDO.SX();
                }
                b.this.mPageContext.showToast(a.h.talent_cancel_apply_success);
                b.this.RF();
            }
        }

        @Override // com.baidu.live.talentshow.c.d
        public void F(int i, String str) {
            if (b.this.bDH.Sf()) {
                b.this.bDH.Se();
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_cancel_apply_failure);
            }
            b.this.mPageContext.showToast(str);
            b.this.RF();
        }
    };
    private final com.baidu.live.talentshow.d.b bDZ = new com.baidu.live.talentshow.d.b() { // from class: com.baidu.live.talentshow.b.2
        @Override // com.baidu.live.talentshow.d.b
        public void eb(int i) {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_fail));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void RM() {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_success));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_SUCCESS).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void cW(boolean z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
            b.this.RK();
            if (b.this.bDQ != null) {
                b.this.bDQ.VL();
            }
            if (b.this.bDL != null) {
                b.this.bDL.RV();
            }
            b.this.RF();
            if (!z) {
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.talent_master_chat_disconnect));
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.alablmsdk.module.c cVar, int i) {
            if (b.this.bDI != null) {
                b.this.bDI.stopTiming();
                b.this.bDI.Sx();
            }
            b.this.a(cVar, i);
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.talentshow.b.c cVar) {
            if (b.this.bDp != null) {
                b.this.bDp.c(cVar);
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void RN() {
            if (b.this.bDL != null) {
                b.this.bDL.RU();
            }
            b.this.RF();
        }
    };
    private final PhoneStateListener bEa = new PhoneStateListener() { // from class: com.baidu.live.talentshow.b.4
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    b.this.RL();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private final CustomMessageTask.CustomRunnable bCw = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.talentshow.b.5
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable");
            if (b.this.bDO != null) {
                BdLog.e("BCVideoChat AudienceLogic showStatusRunnable " + b.this.bDO.Td());
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, Boolean.valueOf(b.this.bDO.Td()));
            }
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable false");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, false);
        }
    };
    private CustomMessageListener bEb = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP) { // from class: com.baidu.live.talentshow.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdLog.e("BCVideoChat AudienceLogic showHangupListener");
            if (b.this.bDO != null && b.this.bDO.Td()) {
                BdLog.e("BCVideoChat AudienceLogic showHangupListener true");
                b.this.Rz();
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            com.baidu.live.alablmsdk.a.ba(TbadkCoreApplication.getInst().isDebugMode());
            this.mPageContext = tbPageContext;
            this.bDG = new com.baidu.live.talentshow.a.b(tbPageContext.getPageActivity());
            this.bDK = new com.baidu.live.talentshow.a.c(tbPageContext);
            this.bDH = new com.baidu.live.talentshow.components.preview.b(tbPageContext);
            this.bDH.a(this.bDK);
            this.bDH.a(this.bDW);
            this.bDP = new com.baidu.live.talentshow.components.b.b(this.mPageContext.getPageActivity(), this.bDT);
            this.bDO = new com.baidu.live.talentshow.d.c(this.mPageContext.getPageActivity());
            this.bDO.a(this.bDP);
            this.bDO.a(this.bDZ);
            this.bDp = new com.baidu.live.talentshow.model.d(tbPageContext);
            this.bDJ = new com.baidu.live.talentshow.model.c(tbPageContext);
            this.bDJ.a(this.bDX);
            this.bDJ.a(this.bDY);
            this.bDF = new com.baidu.live.talentshow.components.enter.a(tbPageContext, false);
            this.bDF.a(this.bDU);
        }
    }

    private void bb(Context context) {
        this.bDS = (TelephonyManager) context.getSystemService("phone");
        if (this.bDS != null) {
            this.bDS.listen(this.bEa, 32);
        }
    }

    @Override // com.baidu.live.am.c
    public void r(ab abVar) {
        this.aED = abVar;
        this.bDH.setLiveShowData(abVar);
        this.bDJ.t(abVar);
        if (this.bDF != null) {
            this.bDF.t(abVar);
        }
        if (this.bDO != null) {
            this.bDO.t(abVar);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.bCw);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.bEb);
        bb(this.mPageContext.getPageActivity().getApplicationContext());
    }

    @Override // com.baidu.live.am.c
    public void a(f fVar) {
        this.bDN = fVar;
    }

    @Override // com.baidu.live.am.c
    public void b(FrameLayout frameLayout) {
        this.bDh = frameLayout;
        if (this.bDP != null) {
            this.bDP.d(frameLayout);
        }
    }

    @Override // com.baidu.live.am.c
    public void Rx() {
        if (this.bDF != null) {
            this.bDF.RW();
        }
        if (this.bDH != null) {
            this.bDH.Se();
            this.bDH.Sg();
        }
        if (this.bDI != null) {
            this.bDI.stopTiming();
            this.bDI.Sx();
        }
        if (this.bDL != null) {
            this.bDL.RU();
            this.bDL.RV();
        }
        RA();
        if (this.bDS != null) {
            this.bDS.listen(this.bEa, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bEb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ry() {
        if (this.bDL == null || this.bDO == null || !this.bDO.Td()) {
            return false;
        }
        BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
        Rz();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rz() {
        BdLog.e("BLMRtcVideo AudienceLogic showQuitCheckConfirmDialog");
        int i = a.h.linkmic_cancel_confirm;
        if (this.bDO.Td()) {
            i = a.h.linkmic_close_confirm;
        }
        this.bDL.a(this.mPageContext, this.mPageContext.getResources().getString(i), new b.a() { // from class: com.baidu.live.talentshow.b.7
            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Qd() {
                BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
                b.this.bDO.SS();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_cfm").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }

            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Qe() {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_can").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        });
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RA() {
        if (this.bDO != null) {
            if (this.bDJ != null && this.bDO.Ta()) {
                this.bDJ.SM();
            }
            this.bDO.SS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ab abVar) {
        if (this.bDI == null) {
            this.bDI = new d(this.mPageContext);
            this.bDI.a(this.bDV);
        }
        this.bDI.v(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RB() {
        if (this.bDI == null) {
            this.bDI = new d(this.mPageContext);
            this.bDI.a(this.bDV);
        }
        this.bDI.RB();
    }

    public void RC() {
        if (this.bDG.SE()) {
            if (bt.b(com.baidu.live.ae.a.Qm().bCs)) {
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    RE();
                    return;
                } else {
                    RD();
                    return;
                }
            }
            RH();
        }
    }

    private void RD() {
        if (this.bDR) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.bDR = true;
        if (ArSoCheckerManager.getInstance().getArSoStatusChecker() != null) {
            ArSoCheckerManager.getInstance().getArSoStatusChecker().checkArSoLoadStatus(this.mPageContext.getPageActivity(), new ArSoStatusCheckResultCallBack() { // from class: com.baidu.live.talentshow.b.10
                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onSuccess() {
                    b.this.bDR = false;
                    b.this.RG();
                }

                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onFail() {
                    b.this.bDR = false;
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    }
                }
            });
            return;
        }
        this.bDR = false;
        RE();
    }

    private void RE() {
        if (this.bDR) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.bDR = true;
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
                            b.this.bDR = false;
                            b.this.RG();
                            return;
                        }
                        b.this.bDR = false;
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RF() {
        if (this.bDF != null && this.bDO != null) {
            this.bDF.ee(this.bDO.SY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RG() {
        this.bDH.o(this.mPageContext.getPageActivity(), true);
    }

    private void RH() {
        this.bDH.o(this.mPageContext.getPageActivity(), false);
    }

    @Override // com.baidu.live.am.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bDI == null || !this.bDI.onKeyDown(i, keyEvent)) {
            if (this.bDO != null && this.bDO.Td()) {
                Ry();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.am.c
    public View getEnterView() {
        if (this.bDF != null) {
            return this.bDF.getEnterView();
        }
        return null;
    }

    @Override // com.baidu.live.am.c
    public void onStarted() {
        if (this.bDO != null) {
            this.bDO.onStarted();
        }
    }

    @Override // com.baidu.live.am.c
    public void onStopped() {
        if (this.bDO != null) {
            this.bDO.onStopped();
        }
    }

    @Override // com.baidu.live.am.c
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.live.am.c
    public void a(c.a aVar) {
        this.bDQ = aVar;
    }

    @Override // com.baidu.live.am.c
    public void onDestroy() {
        if (this.bDJ != null) {
            this.bDJ.onDestroy();
            this.bDJ = null;
        }
        if (this.bDp != null) {
            this.bDp.onDestroy();
            this.bDp = null;
        }
        if (this.bDH != null) {
            this.bDH.onDestroy();
            this.bDH = null;
        }
        if (this.bDO != null) {
            this.bDO.onDestroy();
            this.bDO = null;
        }
        if (this.bDL != null) {
            this.bDL.onDestroy();
        }
        if (this.bDS != null) {
            this.bDS.listen(this.bEa, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bEb);
    }

    @Override // com.baidu.live.am.c
    public boolean RI() {
        return Ry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.alablmsdk.module.c cVar, int i) {
        if (this.bDL == null) {
            this.bDL = new com.baidu.live.talentshow.components.a.b();
        }
        this.bDL.a(this.mPageContext.getPageActivity(), new a.InterfaceC0206a() { // from class: com.baidu.live.talentshow.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0206a
            public boolean RO() {
                AlaLiveRecorder SF;
                BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick |" + b.this.bDO + "|" + b.this.bDK);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.mPageContext.showToast(a.h.talent_net_error);
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick 网络不可用");
                    return false;
                }
                if (b.this.bDO != null && b.this.bDK != null) {
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick status=" + b.this.bDO.SY());
                    if (b.this.bDO.Tb() && (SF = b.this.bDK.SF()) != null) {
                        b.this.RJ();
                        b.this.bDO.b(SF);
                        b.this.bDO.SQ();
                        b.this.RF();
                        if (b.this.bDQ != null) {
                            b.this.bDQ.VK();
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0206a
            public void RP() {
                if (b.this.bDO != null) {
                    b.this.bDO.SR();
                }
                b.this.RF();
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_invite_timeout));
            }
        });
    }

    public void RJ() {
        BdLog.e("BCVideoChat AudienceLogic removeRTMPPlayer");
        if (this.bDN != null) {
            this.bDN.cM(false);
            if (this.bDN.getLivePlayer() != null && this.bDN.getLivePlayer().getParent() != null) {
                this.bDM = (ViewGroup) this.bDN.getLivePlayer().getParent();
                ((ViewGroup) this.bDN.getLivePlayer().getParent()).removeView(this.bDN.getLivePlayer());
            }
        }
    }

    public void RK() {
        BdLog.e("BCVideoChat AudienceLogic switchRTMPLive");
        this.bDK.stopPreview();
        this.bDK.SI();
        if (this.bDM != null && this.bDN != null && this.bDN.getLivePlayer() != null && this.bDN.getLivePlayer().getParent() == null) {
            this.bDM.addView(this.bDN.getLivePlayer(), new FrameLayout.LayoutParams(-1, -1));
            this.bDN.c(this.aED.mLiveInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RL() {
        if (this.bDO != null) {
            if (this.bDO.Ta()) {
                this.bDJ.SM();
            } else if (this.bDO.Tb()) {
                if (this.bDL != null) {
                    this.bDL.RU();
                }
                if (this.bDO != null) {
                    this.bDO.SR();
                }
                RF();
            } else {
                this.bDO.SS();
            }
        }
    }
}
