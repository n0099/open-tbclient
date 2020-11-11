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
    private w aES;
    private FrameLayout buD;
    private d buL;
    private com.baidu.live.talentshow.components.enter.a bva;
    private com.baidu.live.talentshow.a.b bvb;
    private com.baidu.live.talentshow.components.preview.b bvc;
    private com.baidu.live.talentshow.components.waitpanel.d bvd;
    private e bve;
    private com.baidu.live.talentshow.a.c bvf;
    private com.baidu.live.talentshow.components.a.b bvg;
    private ViewGroup bvh;
    private f bvi;
    private com.baidu.live.talentshow.d.c bvj;
    private com.baidu.live.talentshow.components.b.b bvk;
    private c.a bvl;
    private TelephonyManager bvn;
    private TbPageContext mPageContext;
    private boolean bvm = false;
    private a.InterfaceC0202a bvo = new a.InterfaceC0202a() { // from class: com.baidu.live.talentshow.b.1
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0202a
        public void a(View view, int i, long j) {
            BdLog.e("BLMRtcVideo AudienceLogic  index = " + i);
            b.this.QN();
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0202a
        public void b(View view, boolean z) {
            if (b.this.bvj != null) {
                b.this.bvj.setMute(z);
            }
        }
    };
    private com.baidu.live.talentshow.components.enter.b bvp = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.b.7
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                return;
            }
            if (b.this.bvj.Sp()) {
                b.this.QQ();
            } else if (!b.this.bvj.So()) {
                b.this.QO();
            } else {
                b.this.QR();
            }
            com.baidu.live.talentshow.e.a.SK();
        }
    };
    private d.a bvq = new d.a() { // from class: com.baidu.live.talentshow.b.8
        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void Rc() {
            b.this.bvc.Rr();
            if (b.this.bve != null && b.this.bvj.Sp()) {
                b.this.bve.Sb();
            }
            com.baidu.live.talentshow.e.a.SM();
        }

        @Override // com.baidu.live.talentshow.components.waitpanel.d.a
        public void KR() {
            if (b.this.bvc != null) {
                b.this.bvc.Rs();
            }
            if (b.this.bvd != null) {
                b.this.bvd.RL();
            }
            b.this.QP();
            b.this.QT();
            b.this.mPageContext.showToast(a.h.talent_master_not_agree);
        }
    };
    private com.baidu.live.talentshow.components.preview.a bvr = new com.baidu.live.talentshow.components.preview.a() { // from class: com.baidu.live.talentshow.b.10
        @Override // com.baidu.live.talentshow.components.preview.a
        public void Rd() {
            if (b.this.bvb.RS()) {
                b.this.bvc.Rr();
                b.this.bve.Sa();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkapply_clk").setContentExt(null, "popup", null));
            }
        }
    };
    private com.baidu.live.talentshow.c.c bvs = new com.baidu.live.talentshow.c.c() { // from class: com.baidu.live.talentshow.b.11
        @Override // com.baidu.live.talentshow.c.c
        public void a(com.baidu.live.talentshow.b.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS).setContentExt(null, "popup", null));
            b.this.bvc.Rs();
            b.this.bvc.Ru();
            if (b.this.bvj != null) {
                b.this.bvj.Sl();
            }
            if (b.this.aES.mLiveInfo != null && b.this.aES.mLiveInfo.videoBCEnterData != null) {
                b.this.aES.mLiveInfo.videoBCEnterData.audienceWaitTime = JavaTypesHelper.toInt(aVar.RY(), 0);
                b.this.r(b.this.aES);
            }
            b.this.QT();
            b.this.mPageContext.showToast(a.h.talent_apply_chat_success);
        }

        @Override // com.baidu.live.talentshow.c.c
        public void x(int i, String str) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL).setContentExt(null, "popup", null));
            b.this.bvc.Rs();
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_apply_chat_fail);
            }
            b.this.mPageContext.showToast(str);
        }
    };
    private com.baidu.live.talentshow.c.d bvt = new com.baidu.live.talentshow.c.d() { // from class: com.baidu.live.talentshow.b.12
        @Override // com.baidu.live.talentshow.c.d
        public void Re() {
            if (b.this.bvj.Sp()) {
                if (b.this.bvc != null) {
                    b.this.bvc.Rs();
                }
                if (b.this.bvd != null) {
                    b.this.bvd.stopTiming();
                    b.this.bvd.RL();
                }
                if (b.this.bvj != null) {
                    b.this.bvj.Sm();
                }
                b.this.mPageContext.showToast(a.h.talent_cancel_apply_success);
                b.this.QT();
            }
        }

        @Override // com.baidu.live.talentshow.c.d
        public void y(int i, String str) {
            if (b.this.bvc.Rt()) {
                b.this.bvc.Rs();
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.mPageContext.getString(a.h.talent_cancel_apply_failure);
            }
            b.this.mPageContext.showToast(str);
            b.this.QT();
        }
    };
    private final com.baidu.live.talentshow.d.b bvu = new com.baidu.live.talentshow.d.b() { // from class: com.baidu.live.talentshow.b.13
        @Override // com.baidu.live.talentshow.d.b
        public void fh(int i) {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_fail));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void Rf() {
            b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_success));
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_SUCCESS).setContentExt(null, "popup", null));
        }

        @Override // com.baidu.live.talentshow.d.b
        public void cz(boolean z) {
            b.this.QY();
            if (b.this.bvl != null) {
                b.this.bvl.US();
            }
            if (b.this.bvg != null) {
                b.this.bvg.Rj();
            }
            b.this.QT();
            if (!z) {
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.talent_master_chat_disconnect));
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.alablmsdk.module.c cVar, int i) {
            if (b.this.bvd != null) {
                b.this.bvd.stopTiming();
                b.this.bvd.RL();
            }
            b.this.a(cVar, i);
        }

        @Override // com.baidu.live.talentshow.d.b
        public void b(com.baidu.live.talentshow.b.c cVar) {
            if (b.this.buL != null) {
                b.this.buL.c(cVar);
            }
        }

        @Override // com.baidu.live.talentshow.d.b
        public void Rg() {
            if (b.this.bvg != null) {
                b.this.bvg.Ri();
            }
            b.this.QT();
        }
    };
    private final PhoneStateListener bvv = new PhoneStateListener() { // from class: com.baidu.live.talentshow.b.3
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    b.this.QZ();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private final CustomMessageTask.CustomRunnable btX = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.talentshow.b.4
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable");
            if (b.this.bvj != null) {
                BdLog.e("BCVideoChat AudienceLogic showStatusRunnable " + b.this.bvj.Ss());
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, Boolean.valueOf(b.this.bvj.Ss()));
            }
            BdLog.e("BCVideoChat AudienceLogic showStatusRunnable false");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, false);
        }
    };
    private CustomMessageListener bvw = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP) { // from class: com.baidu.live.talentshow.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdLog.e("BCVideoChat AudienceLogic showHangupListener");
            if (b.this.bvj != null && b.this.bvj.Ss()) {
                BdLog.e("BCVideoChat AudienceLogic showHangupListener true");
                b.this.QO();
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            com.baidu.live.alablmsdk.b.aZ(TbadkCoreApplication.getInst().isDebugMode());
            this.mPageContext = tbPageContext;
            this.bvb = new com.baidu.live.talentshow.a.b(tbPageContext.getPageActivity());
            this.bvf = new com.baidu.live.talentshow.a.c(tbPageContext);
            this.bvc = new com.baidu.live.talentshow.components.preview.b(tbPageContext);
            this.bvc.a(this.bvf);
            this.bvc.a(this.bvr);
            this.bvk = new com.baidu.live.talentshow.components.b.b(this.mPageContext.getPageActivity(), this.bvo);
            this.bvj = new com.baidu.live.talentshow.d.c(this.mPageContext.getPageActivity());
            this.bvj.a(this.bvk);
            this.bvj.a(this.bvu);
            this.buL = new com.baidu.live.talentshow.model.d(tbPageContext);
            this.bve = new com.baidu.live.talentshow.model.c(tbPageContext);
            this.bve.a(this.bvs);
            this.bve.a(this.bvt);
            this.bva = new com.baidu.live.talentshow.components.enter.a(tbPageContext, false);
            this.bva.a(this.bvp);
        }
    }

    private void aA(Context context) {
        this.bvn = (TelephonyManager) context.getSystemService("phone");
        if (this.bvn != null) {
            this.bvn.listen(this.bvv, 32);
        }
    }

    @Override // com.baidu.live.aj.c
    public void q(w wVar) {
        this.aES = wVar;
        this.bvc.setLiveShowData(wVar);
        this.bve.s(wVar);
        if (this.bva != null) {
            this.bva.s(wVar);
        }
        if (this.bvj != null) {
            this.bvj.s(wVar);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.btX);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.bvw);
        aA(this.mPageContext.getPageActivity().getApplicationContext());
    }

    @Override // com.baidu.live.aj.c
    public void a(f fVar) {
        this.bvi = fVar;
    }

    @Override // com.baidu.live.aj.c
    public void b(FrameLayout frameLayout) {
        this.buD = frameLayout;
        if (this.bvk != null) {
            this.bvk.d(frameLayout);
        }
    }

    @Override // com.baidu.live.aj.c
    public void QM() {
        if (this.bva != null) {
            this.bva.Rk();
        }
        if (this.bvc != null) {
            this.bvc.Rs();
            this.bvc.Ru();
        }
        if (this.bvd != null) {
            this.bvd.stopTiming();
            this.bvd.RL();
        }
        if (this.bvg != null) {
            this.bvg.Ri();
            this.bvg.Rj();
        }
        QP();
        if (this.bvn != null) {
            this.bvn.listen(this.bvv, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bvw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QN() {
        if (this.bvg == null || this.bvj == null || !this.bvj.Ss()) {
            return false;
        }
        BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
        QO();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QO() {
        BdLog.e("BLMRtcVideo AudienceLogic showQuitCheckConfirmDialog");
        int i = a.h.linkmic_cancel_confirm;
        if (this.bvj.Ss()) {
            i = a.h.linkmic_close_confirm;
        }
        this.bvg.a(this.mPageContext, this.mPageContext.getResources().getString(i), new b.a() { // from class: com.baidu.live.talentshow.b.6
            @Override // com.baidu.live.talentshow.components.a.b.a
            public void PI() {
                BdLog.e("BLMRtcVideo AudienceLogic showHangupHint");
                b.this.bvj.Sh();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_cfm").setContentExt(null, "popup", null));
            }

            @Override // com.baidu.live.talentshow.components.a.b.a
            public void PJ() {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "linkclose_can").setContentExt(null, "popup", null));
            }
        });
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW).setContentExt(null, "popup", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QP() {
        if (this.bvj != null) {
            if (this.bve != null && this.bvj.Sp()) {
                this.bve.Sb();
            }
            this.bvj.Sh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(w wVar) {
        if (this.bvd == null) {
            this.bvd = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.bvd.a(this.bvq);
        }
        this.bvd.u(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QQ() {
        if (this.bvd == null) {
            this.bvd = new com.baidu.live.talentshow.components.waitpanel.d(this.mPageContext);
            this.bvd.a(this.bvq);
        }
        this.bvd.QQ();
    }

    public void QR() {
        if (this.bvb.RS()) {
            if (bl.b(com.baidu.live.aa.a.PQ().btT)) {
                QS();
            } else {
                QV();
            }
        }
    }

    private void QS() {
        if (this.bvm) {
            this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            return;
        }
        this.bvm = true;
        if (ArSoCheckerManager.getInstance().getArSoStatusChecker() != null) {
            ArSoCheckerManager.getInstance().getArSoStatusChecker().checkArSoLoadStatus(this.mPageContext.getPageActivity(), new ArSoStatusCheckResultCallBack() { // from class: com.baidu.live.talentshow.b.9
                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onSuccess() {
                    b.this.bvm = false;
                    b.this.QU();
                }

                @Override // com.baidu.live.tbadk.ar.interfaces.ArSoStatusCheckResultCallBack
                public void onFail() {
                    b.this.bvm = false;
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        b.this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    }
                }
            });
        } else {
            this.bvm = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QT() {
        if (this.bva != null && this.bvj != null) {
            this.bva.fk(this.bvj.Sn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QU() {
        this.bvc.j(this.mPageContext.getPageActivity(), true);
    }

    private void QV() {
        this.bvc.j(this.mPageContext.getPageActivity(), false);
    }

    @Override // com.baidu.live.aj.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bvd == null || !this.bvd.onKeyDown(i, keyEvent)) {
            if (this.bvj != null && this.bvj.Ss()) {
                QN();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.aj.c
    public View getEnterView() {
        if (this.bva != null) {
            return this.bva.getEnterView();
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
        this.bvl = aVar;
    }

    @Override // com.baidu.live.aj.c
    public void onDestroy() {
        if (this.bve != null) {
            this.bve.onDestroy();
            this.bve = null;
        }
        if (this.buL != null) {
            this.buL.onDestroy();
            this.buL = null;
        }
        if (this.bvc != null) {
            this.bvc.onDestroy();
            this.bvc = null;
        }
        if (this.bvj != null) {
            this.bvj.onDestroy();
            this.bvj = null;
        }
        if (this.bvg != null) {
            this.bvg.onDestroy();
        }
        if (this.bvn != null) {
            this.bvn.listen(this.bvv, 0);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT);
        MessageManager.getInstance().unRegisterListener(this.bvw);
    }

    @Override // com.baidu.live.aj.c
    public boolean QW() {
        return QN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.alablmsdk.module.c cVar, int i) {
        if (this.bvg == null) {
            this.bvg = new com.baidu.live.talentshow.components.a.b();
        }
        this.bvg.a(this.mPageContext.getPageActivity(), new a.InterfaceC0201a() { // from class: com.baidu.live.talentshow.b.2
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0201a
            public boolean Ra() {
                AlaLiveRecorder RT;
                BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick |" + b.this.bvj + "|" + b.this.bvf);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.mPageContext.showToast(a.h.talent_net_error);
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick 网络不可用");
                    return false;
                }
                if (b.this.bvj != null && b.this.bvf != null) {
                    BdLog.e("BCVideoChat AudienceLogic onReceiveChatInvited onConfirmClick status=" + b.this.bvj.Sn());
                    if (b.this.bvj.Sq() && (RT = b.this.bvf.RT()) != null) {
                        b.this.QX();
                        b.this.bvj.b(RT);
                        b.this.bvj.Sf();
                        b.this.QT();
                        if (b.this.bvl != null) {
                            b.this.bvl.UR();
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0201a
            public void Rb() {
                if (b.this.bvj != null) {
                    b.this.bvj.Sg();
                }
                b.this.QT();
                b.this.mPageContext.showToast(b.this.mPageContext.getPageActivity().getString(a.h.live_bc_video_chat_invite_timeout));
            }
        });
    }

    public void QX() {
        BdLog.e("BCVideoChat AudienceLogic removeRTMPPlayer");
        if (this.bvi != null) {
            this.bvi.co(false);
            if (this.bvi.getLivePlayer() != null && this.bvi.getLivePlayer().getParent() != null) {
                this.bvh = (ViewGroup) this.bvi.getLivePlayer().getParent();
                ((ViewGroup) this.bvi.getLivePlayer().getParent()).removeView(this.bvi.getLivePlayer());
            }
        }
    }

    public void QY() {
        BdLog.e("BCVideoChat AudienceLogic switchRTMPLive");
        this.bvf.RX();
        this.bvf.RW();
        if (this.bvh != null && this.bvi != null && this.bvi.getLivePlayer() != null && this.bvi.getLivePlayer().getParent() == null) {
            this.bvh.addView(this.bvi.getLivePlayer(), new FrameLayout.LayoutParams(-1, -1));
            this.bvi.c(this.aES.mLiveInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QZ() {
        if (this.bvj != null) {
            if (this.bvj.Sp()) {
                this.bve.Sb();
            } else if (this.bvj.Sq()) {
                if (this.bvg != null) {
                    this.bvg.Ri();
                }
                if (this.bvj != null) {
                    this.bvj.Sg();
                }
                QT();
            } else {
                this.bvj.Sh();
            }
        }
    }
}
