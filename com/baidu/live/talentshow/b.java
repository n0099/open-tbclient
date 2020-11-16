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
import com.baidu.live.aj.c;
import com.baidu.live.data.bl;
import com.baidu.live.data.w;
import com.baidu.live.s.f;
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
/* loaded from: classes4.dex */
public class b implements c {
    private w aDh;
    private FrameLayout bsQ;
    private d bsY;
    private TelephonyManager btB;
    private com.baidu.live.talentshow.components.enter.a bto;
    private com.baidu.live.talentshow.a.b btp;
    private com.baidu.live.talentshow.components.preview.b btq;
    private com.baidu.live.talentshow.components.waitpanel.d btr;
    private e bts;
    private com.baidu.live.talentshow.a.c btt;
    private com.baidu.live.talentshow.components.a.b btu;
    private ViewGroup btv;
    private f btw;
    private com.baidu.live.talentshow.d.c btx;
    private com.baidu.live.talentshow.components.b.b bty;
    private c.a btz;
    private TbPageContext mPageContext;
    private boolean btA = false;
    private a.InterfaceC0200a btC = new a.InterfaceC0200a() { // from class: com.baidu.live.talentshow.b.1
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0200a
        public void a(View view, int i, long j) {
            BdLog.e("BLMRtcVideo AudienceLogic  index = " + i);
            b.this.Qe();
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0200a
        public void b(View view, boolean z) {
            if (b.this.btx != null) {
                b.this.btx.setMute(z);
            }
        }
    };
    private com.baidu.live.talentshow.components.enter.b btD = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.b.7
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                return;
            }
            if (b.this.btx.RG()) {
                b.this.Qh();
            } else if (!b.this.btx.RF()) {
                b.this.Qf();
            } else {
                b.this.Qi();
            }
            com.baidu.live.talentshow.e.a.Sb();
        }
    };
    private d.a btE = new d.a() { // from class: com.baidu.live.talentshow.b.8
        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void Qt() {
            b.this.btq.QI();
            if (b.this.bts != null && b.this.btx.RG()) {
                b.this.bts.Rs();
            }
            com.baidu.live.talentshow.e.a.Sd();
        }

        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void Ki() {
            if (b.this.btq != null) {
                b.this.btq.QJ();
            }
            if (b.this.btr != null) {
                b.this.btr.Rc();
            }
            b.this.Qg();
            b.this.Qk();
            b.this.mPageContext.showToast(a.h.talent_master_not_agree);
        }
    };
    private com.baidu.live.talentshow.components.preview.a btF = new com.baidu.live.talentshow.components.preview.a() { // from class: com.baidu.live.talentshow.b.10
        @Override // com.baidu.live.talentshow.components.preview.a
        public void Qu() {
            if (b.this.btp.Rj()) {
                b.this.btq.QI();
                b.this.bts.Rr();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkapply_clk").setContentExt(null, "popup", null));
            }
        }
    };
    private com.baidu.live.talentshow.c.c btG = new com.baidu.live.talentshow.c.c() { // from class: com.baidu.live.talentshow.b.11
        @Override // com.baidu.live.talentshow.c.c
        public void a(com.baidu.live.talentshow.b.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS).setContentExt(null, "popup", null));
            b.this.btq.QJ();
            b.this.btq.QL();
            if (b.this.btx != null) {
                b.this.btx.RC();
            }
            if (b.this.aDh.mLiveInfo != null && b.this.aDh.mLiveInfo.videoBCEnterData != null) {
                b.this.aDh.mLiveInfo.videoBCEnterData.audienceWaitTime = JavaTypesHelper.toInt(aVar.Rp(), 0);
                b.this.r(b.this.aDh);
            }
            b.this.Qk();
            b.this.mPageContext.showToast(a.h.talent_apply_chat_success);
        }

        @Override // com.baidu.live.talentshow.c.c
        public void x(int i, String str) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL).setContentExt(null, "popup", null));
            b.this.btq.QJ();
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_apply_chat_fail);
            }
            b.this.mPageContext.showToast(str);
        }
    };
    private com.baidu.live.talentshow.c.d btH = new com.baidu.live.talentshow.c.d() { // from class: com.baidu.live.talentshow.b.12
        @Override // com.baidu.live.talentshow.c.d
        public void Qv() {
            if (b.this.btx.RG()) {
                if (b.this.btq != null) {
                    b.this.btq.QJ();
                }
                if (b.this.btr != null) {
                    b.this.btr.stopTiming();
                    b.this.btr.Rc();
                }
                if (b.this.btx != null) {
                    b.this.btx.RD();
                }
                b.this.mPageContext.showToast(a.h.talent_cancel_apply_success);
                b.this.Qk();
            }
        }

        @Override // com.baidu.live.talentshow.c.d
        public void y(int i, String str) {
            if (b.this.btq.QK()) {
                b.this.btq.QJ();
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_cancel_apply_failure);
            }
            b.this.mPageContext.showToast(str);
            b.this.Qk();
        }
    };
    private final com.baidu.live.talentshow.d.b btI = new com.baidu.live.talentshow.d.b() { // from class: com.baidu.live.talentshow.b.13
        @Override // com.baidu.live.talentshow.d.b
        public void fd(int i) {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_fail));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void Qw() {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_success));
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_SUCCESS).setContentExt(null, "popup", null));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void cB(boolean z) {
            b.this.Qp();
            if (b.this.btz != null) {
                b.this.btz.Uj();
            }
            if (b.this.btu != null) {
                b.this.btu.QA();
            }
            b.this.Qk();
            if (!z) {
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.talent_master_chat_disconnect));
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.alablmsdk.module.c cVar, int i) {
            if (b.this.btr != null) {
                b.this.btr.stopTiming();
                b.this.btr.Rc();
            }
            b.this.a(cVar, i);
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.talentshow.b.c cVar) {
            if (b.this.bsY != null) {
                b.this.bsY.c(cVar);
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void Qx() {
            if (b.this.btu != null) {
                b.this.btu.Qz();
            }
            b.this.Qk();
        }
    };
    private final PhoneStateListener btJ = new PhoneStateListener() { // from class: com.baidu.live.talentshow.b.3
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    b.this.Qq();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private final CustomMessageTask.CustomRunnable bsl = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.talentshow.b.4
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable");
            if (b.this.btx != null) {
                BdLog.e("BCVideoChat AudienceLogic showStatusRunnable " + b.this.btx.RJ());
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, Boolean.valueOf(b.this.btx.RJ()));
            }
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable false");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, false);
        }
    };
    private CustomMessageListener btK = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP) { // from class: com.baidu.live.talentshow.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdLog.e("BCVideoChat AudienceLogic showHangupListener");
            if (b.this.btx != null && b.this.btx.RJ()) {
                BdLog.e("BCVideoChat AudienceLogic showHangupListener true");
                b.this.Qf();
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            com.baidu.live.alablmsdk.b.bb(TbadkCoreApplication.getInst().isDebugMode());
            this.mPageContext = tbPageContext;
            this.btp = new com.baidu.live.talentshow.a.b(tbPageContext.getPageActivity());
            this.btt = new com.baidu.live.talentshow.a.c(tbPageContext);
            this.btq = new com.baidu.live.talentshow.components.preview.b(tbPageContext);
            this.btq.a(this.btt);
            this.btq.a(this.btF);
            this.bty = new com.baidu.live.talentshow.components.b.b(this.mPageContext.getPageActivity(), this.btC);
            this.btx = new com.baidu.live.talentshow.d.c(this.mPageContext.getPageActivity());
            this.btx.a(this.bty);
            this.btx.a(this.btI);
            this.bsY = new com.baidu.live.talentshow.model.d(tbPageContext);
            this.bts = new com.baidu.live.talentshow.model.c(tbPageContext);
            this.bts.a(this.btG);
            this.bts.a(this.btH);
            this.bto = new com.baidu.live.talentshow.components.enter.a(tbPageContext, false);
            this.bto.a(this.btD);
        }
    }

    private void aA(Context context) {
        this.btB = (TelephonyManager) context.getSystemService("phone");
        if (this.btB != null) {
            this.btB.listen(this.btJ, 32);
        }
    }

    @Override // com.baidu.live.aj.c
    public void q(w wVar) {
        this.aDh = wVar;
        this.btq.setLiveShowData(wVar);
        this.bts.s(wVar);
        if (this.bto != null) {
            this.bto.s(wVar);
        }
        if (this.btx != null) {
            this.btx.s(wVar);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.bsl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.btK);
        aA(this.mPageContext.getPageActivity().getApplicationContext());
    }

    @Override // com.baidu.live.aj.c
    public void a(f fVar) {
        this.btw = fVar;
    }

    @Override // com.baidu.live.aj.c
    public void b(FrameLayout frameLayout) {
        this.bsQ = frameLayout;
        if (this.bty != null) {
            this.bty.d(frameLayout);
        }
    }

    @Override // com.baidu.live.aj.c
    public void Qd() {
        if (this.bto != null) {
            this.bto.QB();
        }
        if (this.btq != null) {
            this.btq.QJ();
            this.btq.QL();
        }
        if (this.btr != null) {
            this.btr.stopTiming();
            this.btr.Rc();
        }
        if (this.btu != null) {
            this.btu.Qz();
            this.btu.QA();
        }
        Qg();
        if (this.btB != null) {
            this.btB.listen(this.btJ, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.btK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qe() {
        if (this.btu == null || this.btx == null || !this.btx.RJ()) {
            return false;
        }
        BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
        Qf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qf() {
        BdLog.e("BLMRtcVideo AudienceLogic showQuitCheckConfirmDialog");
        int i = a.h.linkmic_cancel_confirm;
        if (this.btx.RJ()) {
            i = a.h.linkmic_close_confirm;
        }
        this.btu.a(this.mPageContext, this.mPageContext.getResources().getString(i), new b.a() { // from class: com.baidu.live.talentshow.b.6
            @Override // com.baidu.live.talentshow.components.a.b.a
            public void OZ() {
                BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
                b.this.btx.Ry();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_cfm").setContentExt(null, "popup", null));
            }

            @Override // com.baidu.live.talentshow.components.a.b.a
            public void Pa() {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_can").setContentExt(null, "popup", null));
            }
        });
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW).setContentExt(null, "popup", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qg() {
        if (this.btx != null) {
            if (this.bts != null && this.btx.RG()) {
                this.bts.Rs();
            }
            this.btx.Ry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(w wVar) {
        if (this.btr == null) {
            this.btr = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.btr.a(this.btE);
        }
        this.btr.u(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        if (this.btr == null) {
            this.btr = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.btr.a(this.btE);
        }
        this.btr.Qh();
    }

    public void Qi() {
        if (this.btp.Rj()) {
            if (bl.b(com.baidu.live.aa.a.Ph().bsh)) {
                Qj();
            } else {
                Qm();
            }
        }
    }

    private void Qj() {
        if (this.btA) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.btA = true;
        if (ArSoCheckerManager.getInstance().getArSoStatusChecker() != null) {
            ArSoCheckerManager.getInstance().getArSoStatusChecker().checkArSoLoadStatus(this.mPageContext.getPageActivity(), new ArSoStatusCheckResultCallBack() { // from class: com.baidu.live.talentshow.b.9
                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onSuccess() {
                    b.this.btA = false;
                    b.this.Ql();
                }

                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onFail() {
                    b.this.btA = false;
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    }
                }
            });
        } else {
            this.btA = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qk() {
        if (this.bto != null && this.btx != null) {
            this.bto.fg(this.btx.RE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql() {
        this.btq.i(this.mPageContext.getPageActivity(), true);
    }

    private void Qm() {
        this.btq.i(this.mPageContext.getPageActivity(), false);
    }

    @Override // com.baidu.live.aj.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.btr == null || !this.btr.onKeyDown(i, keyEvent)) {
            if (this.btx != null && this.btx.RJ()) {
                Qe();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.aj.c
    public View getEnterView() {
        if (this.bto != null) {
            return this.bto.getEnterView();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public void onStarted() {
    }

    @Override // com.baidu.live.aj.c
    public void onStopped() {
    }

    @Override // com.baidu.live.aj.c
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.live.aj.c
    public void a(c.a aVar) {
        this.btz = aVar;
    }

    @Override // com.baidu.live.aj.c
    public void onDestroy() {
        if (this.bts != null) {
            this.bts.onDestroy();
            this.bts = null;
        }
        if (this.bsY != null) {
            this.bsY.onDestroy();
            this.bsY = null;
        }
        if (this.btq != null) {
            this.btq.onDestroy();
            this.btq = null;
        }
        if (this.btx != null) {
            this.btx.onDestroy();
            this.btx = null;
        }
        if (this.btu != null) {
            this.btu.onDestroy();
        }
        if (this.btB != null) {
            this.btB.listen(this.btJ, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.btK);
    }

    @Override // com.baidu.live.aj.c
    public boolean Qn() {
        return Qe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.alablmsdk.module.c cVar, int i) {
        if (this.btu == null) {
            this.btu = new com.baidu.live.talentshow.components.a.b();
        }
        this.btu.a(this.mPageContext.getPageActivity(), new a.InterfaceC0199a() { // from class: com.baidu.live.talentshow.b.2
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0199a
            public boolean Qr() {
                AlaLiveRecorder Rk;
                BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick |" + b.this.btx + "|" + b.this.btt);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.mPageContext.showToast(a.h.talent_net_error);
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick 网络不可用");
                    return false;
                }
                if (b.this.btx != null && b.this.btt != null) {
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick status=" + b.this.btx.RE());
                    if (b.this.btx.RH() && (Rk = b.this.btt.Rk()) != null) {
                        b.this.Qo();
                        b.this.btx.b(Rk);
                        b.this.btx.Rw();
                        b.this.Qk();
                        if (b.this.btz != null) {
                            b.this.btz.Ui();
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0199a
            public void Qs() {
                if (b.this.btx != null) {
                    b.this.btx.Rx();
                }
                b.this.Qk();
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_invite_timeout));
            }
        });
    }

    public void Qo() {
        BdLog.e("BCVideoChat AudienceLogic removeRTMPPlayer");
        if (this.btw != null) {
            this.btw.cq(false);
            if (this.btw.getLivePlayer() != null && this.btw.getLivePlayer().getParent() != null) {
                this.btv = (ViewGroup) this.btw.getLivePlayer().getParent();
                ((ViewGroup) this.btw.getLivePlayer().getParent()).removeView(this.btw.getLivePlayer());
            }
        }
    }

    public void Qp() {
        BdLog.e("BCVideoChat AudienceLogic switchRTMPLive");
        this.btt.Ro();
        this.btt.Rn();
        if (this.btv != null && this.btw != null && this.btw.getLivePlayer() != null && this.btw.getLivePlayer().getParent() == null) {
            this.btv.addView(this.btw.getLivePlayer(), new FrameLayout.LayoutParams(-1, -1));
            this.btw.c(this.aDh.mLiveInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qq() {
        if (this.btx != null) {
            if (this.btx.RG()) {
                this.bts.Rs();
            } else if (this.btx.RH()) {
                if (this.btu != null) {
                    this.btu.Qz();
                }
                if (this.btx != null) {
                    this.btx.Rx();
                }
                Qk();
            } else {
                this.btx.Ry();
            }
        }
    }
}
