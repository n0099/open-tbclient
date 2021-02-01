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
import com.baidu.live.u.f;
import com.baidu.minivideo.arface.b;
/* loaded from: classes11.dex */
public class b implements c {
    private ab aDd;
    private FrameLayout bBH;
    private d bBP;
    private com.baidu.live.talentshow.components.enter.a bCf;
    private com.baidu.live.talentshow.a.b bCg;
    private com.baidu.live.talentshow.components.preview.b bCh;
    private com.baidu.live.talentshow.components.waitpanel.d bCi;
    private e bCj;
    private com.baidu.live.talentshow.a.c bCk;
    private com.baidu.live.talentshow.components.a.b bCl;
    private ViewGroup bCm;
    private f bCn;
    private com.baidu.live.talentshow.d.c bCo;
    private com.baidu.live.talentshow.components.b.b bCp;
    private c.a bCq;
    private TelephonyManager bCs;
    private TbPageContext mPageContext;
    private boolean bCr = false;
    private a.InterfaceC0201a bCt = new a.InterfaceC0201a() { // from class: com.baidu.live.talentshow.b.1
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0201a
        public void a(View view, int i, long j) {
            BdLog.e("BLMRtcVideo AudienceLogic  index = " + i);
            b.this.Rv();
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0201a
        public void b(View view, boolean z) {
            if (b.this.bCo != null) {
                b.this.bCo.setMute(z);
            }
        }
    };
    private com.baidu.live.talentshow.components.enter.b bCu = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.b.8
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                return;
            }
            if (b.this.bCo.SX()) {
                b.this.Ry();
            } else if (!b.this.bCo.SW()) {
                b.this.Rw();
            } else {
                b.this.Rz();
            }
            com.baidu.live.talentshow.e.a.Ts();
        }
    };
    private d.a bCv = new d.a() { // from class: com.baidu.live.talentshow.b.9
        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void RN() {
            b.this.bCh.Sa();
            if (b.this.bCj != null && b.this.bCo.SX()) {
                b.this.bCj.SJ();
            }
            com.baidu.live.talentshow.e.a.Tu();
        }

        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void onTimeout() {
            if (b.this.bCh != null) {
                b.this.bCh.Sb();
            }
            if (b.this.bCi != null) {
                b.this.bCi.Su();
            }
            b.this.Rx();
            b.this.RC();
            b.this.mPageContext.showToast(a.h.talent_master_not_agree);
        }
    };
    private com.baidu.live.talentshow.components.preview.a bCw = new com.baidu.live.talentshow.components.preview.a() { // from class: com.baidu.live.talentshow.b.12
        @Override // com.baidu.live.talentshow.components.preview.a
        public void RO() {
            if (b.this.bCg.SB()) {
                b.this.bCh.Sa();
                b.this.bCj.SI();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkapply_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        }
    };
    private com.baidu.live.talentshow.c.c bCx = new com.baidu.live.talentshow.c.c() { // from class: com.baidu.live.talentshow.b.13
        @Override // com.baidu.live.talentshow.c.c
        public void a(com.baidu.live.talentshow.b.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            b.this.bCh.Sb();
            b.this.bCh.Sd();
            if (b.this.bCo != null) {
                b.this.bCo.ST();
            }
            if (b.this.aDd.mLiveInfo != null && b.this.aDd.mLiveInfo.videoBCEnterData != null) {
                b.this.aDd.mLiveInfo.videoBCEnterData.audienceWaitTime = JavaTypesHelper.toInt(aVar.SG(), 0);
                b.this.s(b.this.aDd);
            }
            b.this.RC();
            b.this.mPageContext.showToast(a.h.talent_apply_chat_success);
        }

        @Override // com.baidu.live.talentshow.c.c
        public void E(int i, String str) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            b.this.bCh.Sb();
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_apply_chat_fail);
            }
            b.this.mPageContext.showToast(str);
        }
    };
    private com.baidu.live.talentshow.c.d bCy = new com.baidu.live.talentshow.c.d() { // from class: com.baidu.live.talentshow.b.14
        @Override // com.baidu.live.talentshow.c.d
        public void RP() {
            if (b.this.bCo.SX()) {
                if (b.this.bCh != null) {
                    b.this.bCh.Sb();
                }
                if (b.this.bCi != null) {
                    b.this.bCi.stopTiming();
                    b.this.bCi.Su();
                }
                if (b.this.bCo != null) {
                    b.this.bCo.SU();
                }
                b.this.mPageContext.showToast(a.h.talent_cancel_apply_success);
                b.this.RC();
            }
        }

        @Override // com.baidu.live.talentshow.c.d
        public void F(int i, String str) {
            if (b.this.bCh.Sc()) {
                b.this.bCh.Sb();
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_cancel_apply_failure);
            }
            b.this.mPageContext.showToast(str);
            b.this.RC();
        }
    };
    private final com.baidu.live.talentshow.d.b bCz = new com.baidu.live.talentshow.d.b() { // from class: com.baidu.live.talentshow.b.2
        @Override // com.baidu.live.talentshow.d.b
        public void ea(int i) {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_fail));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void RJ() {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_success));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_SUCCESS).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void cW(boolean z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
            b.this.RH();
            if (b.this.bCq != null) {
                b.this.bCq.VI();
            }
            if (b.this.bCl != null) {
                b.this.bCl.RS();
            }
            b.this.RC();
            if (!z) {
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.talent_master_chat_disconnect));
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.alablmsdk.module.c cVar, int i) {
            if (b.this.bCi != null) {
                b.this.bCi.stopTiming();
                b.this.bCi.Su();
            }
            b.this.a(cVar, i);
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.talentshow.b.c cVar) {
            if (b.this.bBP != null) {
                b.this.bBP.c(cVar);
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void RK() {
            if (b.this.bCl != null) {
                b.this.bCl.RR();
            }
            b.this.RC();
        }
    };
    private final PhoneStateListener bCA = new PhoneStateListener() { // from class: com.baidu.live.talentshow.b.4
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    b.this.RI();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private final CustomMessageTask.CustomRunnable bAW = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.talentshow.b.5
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable");
            if (b.this.bCo != null) {
                BdLog.e("BCVideoChat AudienceLogic showStatusRunnable " + b.this.bCo.Ta());
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, Boolean.valueOf(b.this.bCo.Ta()));
            }
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable false");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, false);
        }
    };
    private CustomMessageListener bCB = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP) { // from class: com.baidu.live.talentshow.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdLog.e("BCVideoChat AudienceLogic showHangupListener");
            if (b.this.bCo != null && b.this.bCo.Ta()) {
                BdLog.e("BCVideoChat AudienceLogic showHangupListener true");
                b.this.Rw();
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            com.baidu.live.alablmsdk.a.ba(TbadkCoreApplication.getInst().isDebugMode());
            this.mPageContext = tbPageContext;
            this.bCg = new com.baidu.live.talentshow.a.b(tbPageContext.getPageActivity());
            this.bCk = new com.baidu.live.talentshow.a.c(tbPageContext);
            this.bCh = new com.baidu.live.talentshow.components.preview.b(tbPageContext);
            this.bCh.a(this.bCk);
            this.bCh.a(this.bCw);
            this.bCp = new com.baidu.live.talentshow.components.b.b(this.mPageContext.getPageActivity(), this.bCt);
            this.bCo = new com.baidu.live.talentshow.d.c(this.mPageContext.getPageActivity());
            this.bCo.a(this.bCp);
            this.bCo.a(this.bCz);
            this.bBP = new com.baidu.live.talentshow.model.d(tbPageContext);
            this.bCj = new com.baidu.live.talentshow.model.c(tbPageContext);
            this.bCj.a(this.bCx);
            this.bCj.a(this.bCy);
            this.bCf = new com.baidu.live.talentshow.components.enter.a(tbPageContext, false);
            this.bCf.a(this.bCu);
        }
    }

    private void bc(Context context) {
        this.bCs = (TelephonyManager) context.getSystemService("phone");
        if (this.bCs != null) {
            this.bCs.listen(this.bCA, 32);
        }
    }

    @Override // com.baidu.live.am.c
    public void r(ab abVar) {
        this.aDd = abVar;
        this.bCh.setLiveShowData(abVar);
        this.bCj.t(abVar);
        if (this.bCf != null) {
            this.bCf.t(abVar);
        }
        if (this.bCo != null) {
            this.bCo.t(abVar);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.bAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.bCB);
        bc(this.mPageContext.getPageActivity().getApplicationContext());
    }

    @Override // com.baidu.live.am.c
    public void a(f fVar) {
        this.bCn = fVar;
    }

    @Override // com.baidu.live.am.c
    public void b(FrameLayout frameLayout) {
        this.bBH = frameLayout;
        if (this.bCp != null) {
            this.bCp.d(frameLayout);
        }
    }

    @Override // com.baidu.live.am.c
    public void Ru() {
        if (this.bCf != null) {
            this.bCf.RT();
        }
        if (this.bCh != null) {
            this.bCh.Sb();
            this.bCh.Sd();
        }
        if (this.bCi != null) {
            this.bCi.stopTiming();
            this.bCi.Su();
        }
        if (this.bCl != null) {
            this.bCl.RR();
            this.bCl.RS();
        }
        Rx();
        if (this.bCs != null) {
            this.bCs.listen(this.bCA, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bCB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Rv() {
        if (this.bCl == null || this.bCo == null || !this.bCo.Ta()) {
            return false;
        }
        BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
        Rw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rw() {
        BdLog.e("BLMRtcVideo AudienceLogic showQuitCheckConfirmDialog");
        int i = a.h.linkmic_cancel_confirm;
        if (this.bCo.Ta()) {
            i = a.h.linkmic_close_confirm;
        }
        this.bCl.a(this.mPageContext, this.mPageContext.getResources().getString(i), new b.a() { // from class: com.baidu.live.talentshow.b.7
            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Qa() {
                BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
                b.this.bCo.SP();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_cfm").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }

            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Qb() {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_can").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        });
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rx() {
        if (this.bCo != null) {
            if (this.bCj != null && this.bCo.SX()) {
                this.bCj.SJ();
            }
            this.bCo.SP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ab abVar) {
        if (this.bCi == null) {
            this.bCi = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.bCi.a(this.bCv);
        }
        this.bCi.v(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ry() {
        if (this.bCi == null) {
            this.bCi = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.bCi.a(this.bCv);
        }
        this.bCi.Ry();
    }

    public void Rz() {
        if (this.bCg.SB()) {
            if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    RB();
                    return;
                } else {
                    RA();
                    return;
                }
            }
            RE();
        }
    }

    private void RA() {
        if (this.bCr) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.bCr = true;
        if (ArSoCheckerManager.getInstance().getArSoStatusChecker() != null) {
            ArSoCheckerManager.getInstance().getArSoStatusChecker().checkArSoLoadStatus(this.mPageContext.getPageActivity(), new ArSoStatusCheckResultCallBack() { // from class: com.baidu.live.talentshow.b.10
                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onSuccess() {
                    b.this.bCr = false;
                    b.this.RD();
                }

                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onFail() {
                    b.this.bCr = false;
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    }
                }
            });
            return;
        }
        this.bCr = false;
        RB();
    }

    private void RB() {
        if (this.bCr) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.bCr = true;
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
                            b.this.bCr = false;
                            b.this.RD();
                            return;
                        }
                        b.this.bCr = false;
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RC() {
        if (this.bCf != null && this.bCo != null) {
            this.bCf.ed(this.bCo.SV());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RD() {
        this.bCh.o(this.mPageContext.getPageActivity(), true);
    }

    private void RE() {
        this.bCh.o(this.mPageContext.getPageActivity(), false);
    }

    @Override // com.baidu.live.am.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bCi == null || !this.bCi.onKeyDown(i, keyEvent)) {
            if (this.bCo != null && this.bCo.Ta()) {
                Rv();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.am.c
    public View getEnterView() {
        if (this.bCf != null) {
            return this.bCf.getEnterView();
        }
        return null;
    }

    @Override // com.baidu.live.am.c
    public void onStarted() {
        if (this.bCo != null) {
            this.bCo.onStarted();
        }
    }

    @Override // com.baidu.live.am.c
    public void onStopped() {
        if (this.bCo != null) {
            this.bCo.onStopped();
        }
    }

    @Override // com.baidu.live.am.c
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.live.am.c
    public void a(c.a aVar) {
        this.bCq = aVar;
    }

    @Override // com.baidu.live.am.c
    public void onDestroy() {
        if (this.bCj != null) {
            this.bCj.onDestroy();
            this.bCj = null;
        }
        if (this.bBP != null) {
            this.bBP.onDestroy();
            this.bBP = null;
        }
        if (this.bCh != null) {
            this.bCh.onDestroy();
            this.bCh = null;
        }
        if (this.bCo != null) {
            this.bCo.onDestroy();
            this.bCo = null;
        }
        if (this.bCl != null) {
            this.bCl.onDestroy();
        }
        if (this.bCs != null) {
            this.bCs.listen(this.bCA, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bCB);
    }

    @Override // com.baidu.live.am.c
    public boolean RF() {
        return Rv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.alablmsdk.module.c cVar, int i) {
        if (this.bCl == null) {
            this.bCl = new com.baidu.live.talentshow.components.a.b();
        }
        this.bCl.a(this.mPageContext.getPageActivity(), new a.InterfaceC0200a() { // from class: com.baidu.live.talentshow.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0200a
            public boolean RL() {
                AlaLiveRecorder SC;
                BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick |" + b.this.bCo + "|" + b.this.bCk);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.mPageContext.showToast(a.h.talent_net_error);
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick 网络不可用");
                    return false;
                }
                if (b.this.bCo != null && b.this.bCk != null) {
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick status=" + b.this.bCo.SV());
                    if (b.this.bCo.SY() && (SC = b.this.bCk.SC()) != null) {
                        b.this.RG();
                        b.this.bCo.b(SC);
                        b.this.bCo.SN();
                        b.this.RC();
                        if (b.this.bCq != null) {
                            b.this.bCq.VH();
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0200a
            public void RM() {
                if (b.this.bCo != null) {
                    b.this.bCo.SO();
                }
                b.this.RC();
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_invite_timeout));
            }
        });
    }

    public void RG() {
        BdLog.e("BCVideoChat AudienceLogic removeRTMPPlayer");
        if (this.bCn != null) {
            this.bCn.cM(false);
            if (this.bCn.getLivePlayer() != null && this.bCn.getLivePlayer().getParent() != null) {
                this.bCm = (ViewGroup) this.bCn.getLivePlayer().getParent();
                ((ViewGroup) this.bCn.getLivePlayer().getParent()).removeView(this.bCn.getLivePlayer());
            }
        }
    }

    public void RH() {
        BdLog.e("BCVideoChat AudienceLogic switchRTMPLive");
        this.bCk.stopPreview();
        this.bCk.SF();
        if (this.bCm != null && this.bCn != null && this.bCn.getLivePlayer() != null && this.bCn.getLivePlayer().getParent() == null) {
            this.bCm.addView(this.bCn.getLivePlayer(), new FrameLayout.LayoutParams(-1, -1));
            this.bCn.c(this.aDd.mLiveInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RI() {
        if (this.bCo != null) {
            if (this.bCo.SX()) {
                this.bCj.SJ();
            } else if (this.bCo.SY()) {
                if (this.bCl != null) {
                    this.bCl.RR();
                }
                if (this.bCo != null) {
                    this.bCo.SO();
                }
                RC();
            } else {
                this.bCo.SP();
            }
        }
    }
}
