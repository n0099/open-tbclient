package com.baidu.live.videochat;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.videochat.c.a;
import com.baidu.live.videochat.c.b;
import com.baidu.live.videochat.d.h;
import com.baidu.live.videochat.f.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements com.baidu.live.al.a {
    private ab aED;
    private AlaLiveRecorder bFW;
    private com.baidu.live.videochat.panel.c bPA;
    private com.baidu.live.al.b bPD;
    private com.baidu.live.videochat.d.a.a bPE;
    private TelephonyManager bPF;
    private FrameLayout bPG;
    private View bPH;
    private TbPageContext mTbPageContext;
    private PhoneStateListener bEa = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bPB != null) {
                        c.this.bPB.dz(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bPI = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                JSONObject a3 = com.baidu.live.videochat.d.d.a(c.this.aED, aVar, com.baidu.live.videochat.d.d.bRm);
                if (c.this.bPB != null && c.this.bPB.b(a2, a3)) {
                    if (c.this.bPz != null) {
                        c.this.bPz.a(c.this.aED, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, aVar.userId, true));
                    }
                    if (c.this.bPA != null) {
                        c.this.bPA.hide();
                    }
                    if (c.this.bPD != null) {
                        c.this.bPD.VI();
                    }
                }
            }
        }
    };
    private b.a bPJ = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void VT() {
            if (c.this.bPC != null && c.this.bPB != null) {
                c.this.bPC.a(c.this.mTbPageContext, h.fg(c.this.bPB.SY()));
            }
        }
    };
    private b.InterfaceC0232b bPK = new b.InterfaceC0232b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0232b
        public void VU() {
            if (c.this.bPB != null) {
                c.this.bPB.dz(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bPL = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void VV() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.VR();
            c.this.VQ();
            if (c.this.bPD != null) {
                c.this.bPD.VJ();
            }
            if (i == com.baidu.live.videochat.d.c.bHs) {
                if (com.baidu.live.videochat.d.d.bRo.equals(com.baidu.live.videochat.d.d.ar(c.this.bPB.WC()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_rejected));
                }
            } else if (i == com.baidu.live.videochat.d.c.bRb) {
                Log.d("bugbye", "bugbye");
            } else if (i == com.baidu.live.videochat.d.c.bQY || i == com.baidu.live.videochat.d.c.bQZ) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            } else if (i == com.baidu.live.videochat.d.c.bRa) {
                if (z) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_connected_timeout));
                }
            } else if (i == com.baidu.live.videochat.d.c.bHq) {
                if (c.this.bPE != null && c.this.bPB != null) {
                    com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                    bVar.bGF = c.this.bPB.WD();
                    bVar.action = com.baidu.live.videochat.d.a.b.bRQ;
                    bVar.bGH = TbadkCoreApplication.getCurrentAccount();
                    c.this.bPE.a(bVar);
                }
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            } else {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_connected_fail));
            }
            if (c.this.bPA != null && c.this.bPB != null) {
                c.this.bPA.eb(c.this.bPB.SY());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            if (c.this.bPE != null && c.this.bPB != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bGF = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bRP;
                bVar.bGG = com.baidu.live.videochat.d.a.b.bRR;
                bVar.bGH = TbadkCoreApplication.getCurrentAccount();
                bVar.bGK = c.this.bPB.WC();
                c.this.bPE.a(bVar);
            }
            if (c.this.bPA != null && c.this.bPB != null) {
                c.this.bPA.fj(c.this.bPB.SY());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("chat_room_id", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_SUCCESS).setContentExt(null, null, jSONObject));
        }

        @Override // com.baidu.live.videochat.d.f
        public void VW() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            if (c.this.aED == null || c.this.aED.mLiveInfo == null || !c.this.aED.mLiveInfo.isPubShow) {
                if (c.this.bPz != null && c.this.bPB != null) {
                    c.this.bPz.ag(c.this.bPB.MV());
                }
            } else if (c.this.bPB == null || c.this.bPH == null || c.this.bPH != c.this.bPB.MV() || c.this.bPH.getParent() == null || c.this.bPH.getParent() != c.this.bPG) {
                if (c.this.bPH != null && c.this.bPH.getParent() != null) {
                    ((ViewGroup) c.this.bPH.getParent()).removeView(c.this.bPH);
                    c.this.bPH = null;
                }
                if (c.this.bFW != null && c.this.bFW.getPreview() != null && c.this.bPz != null && c.this.bPG != null) {
                    View preview = c.this.bFW.getPreview();
                    c.this.bPG.removeView(preview);
                    c.this.bPz.ag(preview);
                    c.this.bFW.startRecord();
                    c.this.bFW.startPush();
                }
                if (c.this.bPB != null && c.this.bPG != null) {
                    c.this.bPH = c.this.bPB.MV();
                    if (c.this.bPH != null) {
                        c.this.bPG.addView(c.this.bPH, 0, new FrameLayout.LayoutParams(-1, -1));
                    }
                }
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void q(int i, boolean z) {
            BdLog.e("blmsdk:onChatStreamLeavedForSeconds sec=" + i + " isCurrentUserNetErr:" + z);
            if (10 == i && !z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_other_network_error));
            } else if (30 == i) {
                c.this.bPB.dz(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void D(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
            c.this.VP();
            c.this.VS();
            c.this.VQ();
            if (c.this.bPD != null) {
                c.this.bPD.VJ();
            }
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            }
            if (c.this.bPA != null && c.this.bPB != null) {
                c.this.bPA.fk(c.this.bPB.SY());
            }
            if (c.this.bPE != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bGF = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bRQ;
                bVar.bGH = TbadkCoreApplication.getCurrentAccount();
                c.this.bPE.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            if (cVar == null || c.this.bPD == null || !c.this.bPD.VG()) {
                c.this.bPB.WA();
                return;
            }
            c.this.bPD.VH();
            c.this.am(jSONObject);
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(int i, boolean z, int i2, String str, String str2, String str3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("error_code", Integer.valueOf(i));
                jSONObject.putOpt("is_sender", Integer.valueOf(z ? 1 : 0));
                jSONObject.putOpt("rtc_status", Integer.valueOf(i2));
                jSONObject.putOpt("rtc_msg", str);
                jSONObject.putOpt("chat_room_id", str2);
                jSONObject.putOpt("ext_info", str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_FAIL).setContentExt(null, null, jSONObject));
        }
    };
    private com.baidu.live.videochat.d.a bPB = new com.baidu.live.videochat.d.g();
    private com.baidu.live.videochat.f.a bPz = new com.baidu.live.videochat.f.a(this.bPJ, this.bPK);
    private com.baidu.live.videochat.c.b bPC = new com.baidu.live.videochat.c.b();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bPA = new com.baidu.live.videochat.panel.c(tbPageContext, this.bPI);
        this.bPE = new com.baidu.live.videochat.d.a.a(tbPageContext);
        bb(tbPageContext.getPageActivity().getApplicationContext());
        this.bPB.init(tbPageContext.getPageActivity());
        this.bPB.a(this.bPL);
        if (this.bPC != null) {
            this.bPC.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void Qd() {
                    c.this.bPB.dz(false);
                    c.this.bPz.Xh();
                }
            });
        }
    }

    private void bb(Context context) {
        this.bPF = (TelephonyManager) context.getSystemService("phone");
        if (this.bPF != null) {
            this.bPF.listen(this.bEa, 32);
        }
    }

    @Override // com.baidu.live.al.a
    public void v(ViewGroup viewGroup) {
        this.bPA.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.al.a
    public void w(ViewGroup viewGroup) {
        this.bPz.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.al.a
    public void J(Object obj) {
        if (this.bPB != null && (obj instanceof AlaLiveRecorder)) {
            this.bFW = (AlaLiveRecorder) obj;
            this.bPB.a(this.bFW);
        }
    }

    @Override // com.baidu.live.al.a
    public void a(FrameLayout frameLayout) {
        this.bPG = frameLayout;
    }

    @Override // com.baidu.live.al.a
    public void t(ab abVar) {
        this.aED = abVar;
        if (this.bPB != null) {
            this.bPB.t(abVar);
        }
        if (this.bPC != null) {
            this.bPC.bC(this.aED.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.al.a
    public void VA() {
        String str = null;
        if (this.bPB.WB() != null) {
            str = String.valueOf(this.bPB.WB().azK);
        }
        this.bPA.ad(this.bPB.SY(), str);
    }

    @Override // com.baidu.live.al.a
    public void VF() {
        com.baidu.live.alablmsdk.a.b.a.ba(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.azP = UserPermission.VISITER;
        cVar.azK = JavaTypesHelper.toLong(aVar.bSQ, 0L);
        cVar.azQ = aVar.bSR;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bSP;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VP() {
        if (this.bPH != null && this.bPH.getParent() != null) {
            ((ViewGroup) this.bPH.getParent()).removeView(this.bPH);
            this.bPH = null;
        }
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.mLiveInfo.isPubShow && this.bPG != null && this.bFW != null) {
            View preview = this.bFW.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bPG) {
                    ((ViewGroup) preview.getParent()).removeView(this.bFW.getPreview());
                    this.bPG.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bPG.addView(preview, 0, layoutParams);
                }
            }
            this.bFW.startRecord();
            this.bFW.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VQ() {
        if (this.bPz != null) {
            this.bPz.Xh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.bPC != null) {
            this.bPC.RU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VS() {
        if (this.bPC != null) {
            this.bPC.RV();
        }
    }

    @Override // com.baidu.live.al.a
    public boolean VB() {
        return this.bPB != null && (h.fg(this.bPB.SY()) || h.fh(this.bPB.SY()));
    }

    @Override // com.baidu.live.al.a
    public boolean Rq() {
        if (this.bPB != null && (h.fg(this.bPB.SY()) || h.fh(this.bPB.SY()))) {
            if (this.bPC != null) {
                this.bPC.a(this.mTbPageContext, h.fg(this.bPB.SY()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.al.a
    public void a(com.baidu.live.al.b bVar) {
        this.bPD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(JSONObject jSONObject) {
        if (this.bPC != null && this.mTbPageContext != null) {
            if (this.bPA != null) {
                this.bPA.hide();
            }
            final com.baidu.live.videochat.d.e ap = com.baidu.live.videochat.d.d.ap(jSONObject);
            this.bPC.a(this.mTbPageContext.getPageActivity(), ap.portrait, ap.userName, new a.InterfaceC0228a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
                public void VX() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
                public void VY() {
                    if (c.this.bPD != null) {
                        c.this.bPD.VH();
                    }
                    if (c.this.bPz != null) {
                        c.this.bPz.a(c.this.aED, new com.baidu.live.videochat.f.c(ap.portrait, ap.userName, ap.userId, false));
                        if (c.this.bPD != null) {
                            c.this.bPD.VI();
                        }
                    }
                    c.this.bPB.an(com.baidu.live.videochat.d.d.a(ap, c.this.aED, com.baidu.live.videochat.d.d.bRn));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
                public void VZ() {
                    c.this.bPB.ao(com.baidu.live.videochat.d.d.a(ap, c.this.aED, com.baidu.live.videochat.d.d.bRp));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
                public void RP() {
                    c.this.bPB.ao(com.baidu.live.videochat.d.d.a(ap, c.this.aED, com.baidu.live.videochat.d.d.bRo));
                }
            });
        }
    }

    @Override // com.baidu.live.al.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bPA != null) {
            return this.bPA.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.al.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bPF != null) {
            this.bPF.listen(this.bEa, 0);
        }
        if (this.bPC != null) {
            this.bPC.onDestroy();
        }
        if (this.bPB != null) {
            this.bPB.onDestroy();
        }
        if (this.bPz != null) {
            this.bPz.onDestroy();
        }
        if (this.bPA != null) {
            this.bPA.onDestroy();
        }
        if (this.bPE != null) {
            this.bPE.onDestroy();
        }
    }

    @Override // com.baidu.live.al.a
    public void setMute(boolean z) {
        if (this.bPB != null) {
            this.bPB.setMute(z);
        }
    }

    @Override // com.baidu.live.al.a
    public void VC() {
        if (VB() && this.bPB != null) {
            this.bPB.dz(false);
        }
    }

    @Override // com.baidu.live.al.a
    public void VD() {
        if (this.bPB != null) {
            this.bPB.VD();
        }
    }

    @Override // com.baidu.live.al.a
    public void VE() {
        if (this.bPB != null) {
            this.bPB.VE();
        }
    }

    @Override // com.baidu.live.al.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (VB()) {
            this.bPz.onKeyboardVisibilityChanged(z);
        }
    }
}
