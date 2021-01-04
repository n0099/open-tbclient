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
import com.baidu.live.talentshow.model.d;
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
/* loaded from: classes11.dex */
public class b implements c {
    private x aGe;
    private FrameLayout bCN;
    private d bCV;
    private com.baidu.live.talentshow.components.enter.a bDl;
    private com.baidu.live.talentshow.a.b bDm;
    private com.baidu.live.talentshow.components.preview.b bDn;
    private com.baidu.live.talentshow.components.waitpanel.d bDo;
    private e bDp;
    private com.baidu.live.talentshow.a.c bDq;
    private com.baidu.live.talentshow.components.a.b bDr;
    private ViewGroup bDs;
    private f bDt;
    private com.baidu.live.talentshow.d.c bDu;
    private com.baidu.live.talentshow.components.b.b bDv;
    private c.a bDw;
    private TelephonyManager bDy;
    private TbPageContext mPageContext;
    private boolean bDx = false;
    private a.InterfaceC0208a bDz = new a.InterfaceC0208a() { // from class: com.baidu.live.talentshow.b.1
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0208a
        public void a(View view, int i, long j) {
            BdLog.e("BLMRtcVideo AudienceLogic  index = " + i);
            b.this.TG();
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0208a
        public void b(View view, boolean z) {
            if (b.this.bDu != null) {
                b.this.bDu.setMute(z);
            }
        }
    };
    private com.baidu.live.talentshow.components.enter.b bDA = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.b.8
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                return;
            }
            if (b.this.bDu.Vj()) {
                b.this.TJ();
            } else if (!b.this.bDu.Vi()) {
                b.this.TH();
            } else {
                b.this.TK();
            }
            com.baidu.live.talentshow.e.a.VE();
        }
    };
    private d.a bDB = new d.a() { // from class: com.baidu.live.talentshow.b.9
        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void TY() {
            b.this.bDn.Ul();
            if (b.this.bDp != null && b.this.bDu.Vj()) {
                b.this.bDp.UV();
            }
            com.baidu.live.talentshow.e.a.VG();
        }

        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void onTimeout() {
            if (b.this.bDn != null) {
                b.this.bDn.Um();
            }
            if (b.this.bDo != null) {
                b.this.bDo.UF();
            }
            b.this.TI();
            b.this.TN();
            b.this.mPageContext.showToast(a.h.talent_master_not_agree);
        }
    };
    private com.baidu.live.talentshow.components.preview.a bDC = new com.baidu.live.talentshow.components.preview.a() { // from class: com.baidu.live.talentshow.b.12
        @Override // com.baidu.live.talentshow.components.preview.a
        public void TZ() {
            if (b.this.bDm.UM()) {
                b.this.bDn.Ul();
                b.this.bDp.UU();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkapply_clk").setContentExt(null, "popup", null));
            }
        }
    };
    private com.baidu.live.talentshow.c.c bDD = new com.baidu.live.talentshow.c.c() { // from class: com.baidu.live.talentshow.b.13
        @Override // com.baidu.live.talentshow.c.c
        public void a(com.baidu.live.talentshow.b.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS).setContentExt(null, "popup", null));
            b.this.bDn.Um();
            b.this.bDn.Uo();
            if (b.this.bDu != null) {
                b.this.bDu.Vf();
            }
            if (b.this.aGe.mLiveInfo != null && b.this.aGe.mLiveInfo.videoBCEnterData != null) {
                b.this.aGe.mLiveInfo.videoBCEnterData.audienceWaitTime = JavaTypesHelper.toInt(aVar.US(), 0);
                b.this.s(b.this.aGe);
            }
            b.this.TN();
            b.this.mPageContext.showToast(a.h.talent_apply_chat_success);
        }

        @Override // com.baidu.live.talentshow.c.c
        public void z(int i, String str) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL).setContentExt(null, "popup", null));
            b.this.bDn.Um();
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_apply_chat_fail);
            }
            b.this.mPageContext.showToast(str);
        }
    };
    private com.baidu.live.talentshow.c.d bDE = new com.baidu.live.talentshow.c.d() { // from class: com.baidu.live.talentshow.b.14
        @Override // com.baidu.live.talentshow.c.d
        public void Ua() {
            if (b.this.bDu.Vj()) {
                if (b.this.bDn != null) {
                    b.this.bDn.Um();
                }
                if (b.this.bDo != null) {
                    b.this.bDo.stopTiming();
                    b.this.bDo.UF();
                }
                if (b.this.bDu != null) {
                    b.this.bDu.Vg();
                }
                b.this.mPageContext.showToast(a.h.talent_cancel_apply_success);
                b.this.TN();
            }
        }

        @Override // com.baidu.live.talentshow.c.d
        public void A(int i, String str) {
            if (b.this.bDn.Un()) {
                b.this.bDn.Um();
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_cancel_apply_failure);
            }
            b.this.mPageContext.showToast(str);
            b.this.TN();
        }
    };
    private final com.baidu.live.talentshow.d.b bDF = new com.baidu.live.talentshow.d.b() { // from class: com.baidu.live.talentshow.b.2
        @Override // com.baidu.live.talentshow.d.b
        public void fC(int i) {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_fail));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void TU() {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_success));
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_SUCCESS).setContentExt(null, "popup", null));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void cS(boolean z) {
            b.this.TS();
            if (b.this.bDw != null) {
                b.this.bDw.XR();
            }
            if (b.this.bDr != null) {
                b.this.bDr.Ud();
            }
            b.this.TN();
            if (!z) {
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.talent_master_chat_disconnect));
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.alablmsdk.module.c cVar, int i) {
            if (b.this.bDo != null) {
                b.this.bDo.stopTiming();
                b.this.bDo.UF();
            }
            b.this.a(cVar, i);
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.talentshow.b.c cVar) {
            if (b.this.bCV != null) {
                b.this.bCV.c(cVar);
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void TV() {
            if (b.this.bDr != null) {
                b.this.bDr.Uc();
            }
            b.this.TN();
        }
    };
    private final PhoneStateListener bDG = new PhoneStateListener() { // from class: com.baidu.live.talentshow.b.4
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    b.this.TT();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private final CustomMessageTask.CustomRunnable bCf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.talentshow.b.5
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable");
            if (b.this.bDu != null) {
                BdLog.e("BCVideoChat AudienceLogic showStatusRunnable " + b.this.bDu.Vm());
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, Boolean.valueOf(b.this.bDu.Vm()));
            }
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable false");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, false);
        }
    };
    private CustomMessageListener bDH = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP) { // from class: com.baidu.live.talentshow.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdLog.e("BCVideoChat AudienceLogic showHangupListener");
            if (b.this.bDu != null && b.this.bDu.Vm()) {
                BdLog.e("BCVideoChat AudienceLogic showHangupListener true");
                b.this.TH();
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            com.baidu.live.alablmsdk.a.be(TbadkCoreApplication.getInst().isDebugMode());
            this.mPageContext = tbPageContext;
            this.bDm = new com.baidu.live.talentshow.a.b(tbPageContext.getPageActivity());
            this.bDq = new com.baidu.live.talentshow.a.c(tbPageContext);
            this.bDn = new com.baidu.live.talentshow.components.preview.b(tbPageContext);
            this.bDn.a(this.bDq);
            this.bDn.a(this.bDC);
            this.bDv = new com.baidu.live.talentshow.components.b.b(this.mPageContext.getPageActivity(), this.bDz);
            this.bDu = new com.baidu.live.talentshow.d.c(this.mPageContext.getPageActivity());
            this.bDu.a(this.bDv);
            this.bDu.a(this.bDF);
            this.bCV = new com.baidu.live.talentshow.model.d(tbPageContext);
            this.bDp = new com.baidu.live.talentshow.model.c(tbPageContext);
            this.bDp.a(this.bDD);
            this.bDp.a(this.bDE);
            this.bDl = new com.baidu.live.talentshow.components.enter.a(tbPageContext, false);
            this.bDl.a(this.bDA);
        }
    }

    private void bd(Context context) {
        this.bDy = (TelephonyManager) context.getSystemService("phone");
        if (this.bDy != null) {
            this.bDy.listen(this.bDG, 32);
        }
    }

    @Override // com.baidu.live.ao.c
    public void r(x xVar) {
        this.aGe = xVar;
        this.bDn.setLiveShowData(xVar);
        this.bDp.t(xVar);
        if (this.bDl != null) {
            this.bDl.t(xVar);
        }
        if (this.bDu != null) {
            this.bDu.t(xVar);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.bCf);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.bDH);
        bd(this.mPageContext.getPageActivity().getApplicationContext());
    }

    @Override // com.baidu.live.ao.c
    public void a(f fVar) {
        this.bDt = fVar;
    }

    @Override // com.baidu.live.ao.c
    public void b(FrameLayout frameLayout) {
        this.bCN = frameLayout;
        if (this.bDv != null) {
            this.bDv.d(frameLayout);
        }
    }

    @Override // com.baidu.live.ao.c
    public void TF() {
        if (this.bDl != null) {
            this.bDl.Ue();
        }
        if (this.bDn != null) {
            this.bDn.Um();
            this.bDn.Uo();
        }
        if (this.bDo != null) {
            this.bDo.stopTiming();
            this.bDo.UF();
        }
        if (this.bDr != null) {
            this.bDr.Uc();
            this.bDr.Ud();
        }
        TI();
        if (this.bDy != null) {
            this.bDy.listen(this.bDG, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bDH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TG() {
        if (this.bDr == null || this.bDu == null || !this.bDu.Vm()) {
            return false;
        }
        BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
        TH();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TH() {
        BdLog.e("BLMRtcVideo AudienceLogic showQuitCheckConfirmDialog");
        int i = a.h.linkmic_cancel_confirm;
        if (this.bDu.Vm()) {
            i = a.h.linkmic_close_confirm;
        }
        this.bDr.a(this.mPageContext, this.mPageContext.getResources().getString(i), new b.a() { // from class: com.baidu.live.talentshow.b.7
            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Sw() {
                BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
                b.this.bDu.Vb();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_cfm").setContentExt(null, "popup", null));
            }

            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Sx() {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_can").setContentExt(null, "popup", null));
            }
        });
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW).setContentExt(null, "popup", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        if (this.bDu != null) {
            if (this.bDp != null && this.bDu.Vj()) {
                this.bDp.UV();
            }
            this.bDu.Vb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(x xVar) {
        if (this.bDo == null) {
            this.bDo = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.bDo.a(this.bDB);
        }
        this.bDo.v(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TJ() {
        if (this.bDo == null) {
            this.bDo = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.bDo.a(this.bDB);
        }
        this.bDo.TJ();
    }

    public void TK() {
        if (this.bDm.UM()) {
            if (bo.b(com.baidu.live.af.a.SE().bCb)) {
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    TM();
                    return;
                } else {
                    TL();
                    return;
                }
            }
            TP();
        }
    }

    private void TL() {
        if (this.bDx) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.bDx = true;
        if (ArSoCheckerManager.getInstance().getArSoStatusChecker() != null) {
            ArSoCheckerManager.getInstance().getArSoStatusChecker().checkArSoLoadStatus(this.mPageContext.getPageActivity(), new ArSoStatusCheckResultCallBack() { // from class: com.baidu.live.talentshow.b.10
                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onSuccess() {
                    b.this.bDx = false;
                    b.this.TO();
                }

                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onFail() {
                    b.this.bDx = false;
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    }
                }
            });
            return;
        }
        this.bDx = false;
        TM();
    }

    private void TM() {
        if (this.bDx) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.bDx = true;
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
                            b.this.bDx = false;
                            b.this.TO();
                            return;
                        }
                        b.this.bDx = false;
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TN() {
        if (this.bDl != null && this.bDu != null) {
            this.bDl.fF(this.bDu.Vh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TO() {
        this.bDn.n(this.mPageContext.getPageActivity(), true);
    }

    private void TP() {
        this.bDn.n(this.mPageContext.getPageActivity(), false);
    }

    @Override // com.baidu.live.ao.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bDo == null || !this.bDo.onKeyDown(i, keyEvent)) {
            if (this.bDu != null && this.bDu.Vm()) {
                TG();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.ao.c
    public View getEnterView() {
        if (this.bDl != null) {
            return this.bDl.getEnterView();
        }
        return null;
    }

    @Override // com.baidu.live.ao.c
    public void onStarted() {
        if (this.bDu != null) {
            this.bDu.onStarted();
        }
    }

    @Override // com.baidu.live.ao.c
    public void onStopped() {
        if (this.bDu != null) {
            this.bDu.onStopped();
        }
    }

    @Override // com.baidu.live.ao.c
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.live.ao.c
    public void a(c.a aVar) {
        this.bDw = aVar;
    }

    @Override // com.baidu.live.ao.c
    public void onDestroy() {
        if (this.bDp != null) {
            this.bDp.onDestroy();
            this.bDp = null;
        }
        if (this.bCV != null) {
            this.bCV.onDestroy();
            this.bCV = null;
        }
        if (this.bDn != null) {
            this.bDn.onDestroy();
            this.bDn = null;
        }
        if (this.bDu != null) {
            this.bDu.onDestroy();
            this.bDu = null;
        }
        if (this.bDr != null) {
            this.bDr.onDestroy();
        }
        if (this.bDy != null) {
            this.bDy.listen(this.bDG, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bDH);
    }

    @Override // com.baidu.live.ao.c
    public boolean TQ() {
        return TG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.alablmsdk.module.c cVar, int i) {
        if (this.bDr == null) {
            this.bDr = new com.baidu.live.talentshow.components.a.b();
        }
        this.bDr.a(this.mPageContext.getPageActivity(), new a.InterfaceC0207a() { // from class: com.baidu.live.talentshow.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0207a
            public boolean TW() {
                AlaLiveRecorder UN;
                BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick |" + b.this.bDu + "|" + b.this.bDq);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.mPageContext.showToast(a.h.talent_net_error);
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick 网络不可用");
                    return false;
                }
                if (b.this.bDu != null && b.this.bDq != null) {
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick status=" + b.this.bDu.Vh());
                    if (b.this.bDu.Vk() && (UN = b.this.bDq.UN()) != null) {
                        b.this.TR();
                        b.this.bDu.b(UN);
                        b.this.bDu.UZ();
                        b.this.TN();
                        if (b.this.bDw != null) {
                            b.this.bDw.XQ();
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0207a
            public void TX() {
                if (b.this.bDu != null) {
                    b.this.bDu.Va();
                }
                b.this.TN();
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_invite_timeout));
            }
        });
    }

    public void TR() {
        BdLog.e("BCVideoChat AudienceLogic removeRTMPPlayer");
        if (this.bDt != null) {
            this.bDt.cH(false);
            if (this.bDt.getLivePlayer() != null && this.bDt.getLivePlayer().getParent() != null) {
                this.bDs = (ViewGroup) this.bDt.getLivePlayer().getParent();
                ((ViewGroup) this.bDt.getLivePlayer().getParent()).removeView(this.bDt.getLivePlayer());
            }
        }
    }

    public void TS() {
        BdLog.e("BCVideoChat AudienceLogic switchRTMPLive");
        this.bDq.UR();
        this.bDq.UQ();
        if (this.bDs != null && this.bDt != null && this.bDt.getLivePlayer() != null && this.bDt.getLivePlayer().getParent() == null) {
            this.bDs.addView(this.bDt.getLivePlayer(), new FrameLayout.LayoutParams(-1, -1));
            this.bDt.c(this.aGe.mLiveInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TT() {
        if (this.bDu != null) {
            if (this.bDu.Vj()) {
                this.bDp.UV();
            } else if (this.bDu.Vk()) {
                if (this.bDr != null) {
                    this.bDr.Uc();
                }
                if (this.bDu != null) {
                    this.bDu.Va();
                }
                TN();
            } else {
                this.bDu.Vb();
            }
        }
    }
}
