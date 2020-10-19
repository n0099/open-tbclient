package com.baidu.live.videochat;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.videochat.c.a;
import com.baidu.live.videochat.c.b;
import com.baidu.live.videochat.d.g;
import com.baidu.live.videochat.d.h;
import com.baidu.live.videochat.f.b;
import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.ae.a {
    private u aDU;
    private com.baidu.live.videochat.panel.c bxK;
    private com.baidu.live.ae.b bxN;
    private TelephonyManager bxP;
    private AlaLiveRecorder bxQ;
    private FrameLayout bxR;
    private View bxS;
    private TbPageContext mTbPageContext;
    private PhoneStateListener bxT = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bxL != null) {
                        c.this.bxL.cP(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bxU = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                String a3 = com.baidu.live.videochat.d.d.a(c.this.aDU, aVar, com.baidu.live.videochat.d.d.bzP);
                if (c.this.bxL != null && c.this.bxL.b(a2, a3)) {
                    if (c.this.bxJ != null) {
                        c.this.bxJ.a(c.this.aDU, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, true));
                    }
                    if (c.this.bxK != null) {
                        c.this.bxK.hide();
                    }
                }
            }
        }
    };
    private b.a bxV = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void Rs() {
            if (c.this.bxM != null && c.this.bxL != null) {
                c.this.bxM.c(c.this.mTbPageContext, h.fW(c.this.bxL.Sa()));
            }
        }
    };
    private b.InterfaceC0210b bxW = new b.InterfaceC0210b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0210b
        public void Rt() {
            if (c.this.bxL != null) {
                c.this.bxL.cP(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bxX = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void Ru() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.Rq();
            c.this.Rp();
            if (i == com.baidu.live.videochat.d.c.bzA) {
                if (com.baidu.live.videochat.d.d.bzR.equals(com.baidu.live.videochat.d.d.ab(c.this.bxL.Sj()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.i.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.i.video_chat_rejected));
                }
            } else if (i != com.baidu.live.videochat.d.c.bzE) {
                if (i == com.baidu.live.videochat.d.c.bzB || i == com.baidu.live.videochat.d.c.bzC) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_closed));
                } else if (i == com.baidu.live.videochat.d.c.bzD) {
                    if (z) {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_timeout));
                    } else {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_connected_timeout));
                    }
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.i.video_chat_connected_fail));
                }
            }
            if (c.this.bxK != null && c.this.bxL != null) {
                c.this.bxK.fZ(c.this.bxL.Sa());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void A(String str, boolean z) {
            if (c.this.bxO != null && c.this.bxL != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bAw = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bAt;
                bVar.bAx = com.baidu.live.videochat.d.a.b.bAv;
                bVar.bAy = TbadkCoreApplication.getCurrentAccount();
                bVar.ext = c.this.bxL.Sj();
                c.this.bxO.a(bVar);
            }
            if (c.this.bxK != null && c.this.bxL != null) {
                c.this.bxK.ga(c.this.bxL.Sa());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("chat_room_id", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_SUCCESS).setContentExt(null, null, jSONObject));
        }

        @Override // com.baidu.live.videochat.d.f
        public void Rv() {
            if (c.this.aDU == null || c.this.aDU.mLiveInfo == null || !c.this.aDU.mLiveInfo.isPubShow) {
                if (c.this.bxJ != null && c.this.bxL != null) {
                    c.this.bxJ.ac(c.this.bxL.getPlayerView());
                }
            } else if (c.this.bxL == null || c.this.bxS == null || c.this.bxS != c.this.bxL.getPlayerView() || c.this.bxS.getParent() == null || c.this.bxS.getParent() != c.this.bxR) {
                if (c.this.bxS != null && c.this.bxS.getParent() != null) {
                    ((ViewGroup) c.this.bxS.getParent()).removeView(c.this.bxS);
                    c.this.bxS = null;
                }
                if (c.this.bxQ != null && c.this.bxQ.getPreview() != null && c.this.bxJ != null && c.this.bxR != null) {
                    View preview = c.this.bxQ.getPreview();
                    c.this.bxR.removeView(preview);
                    c.this.bxJ.ac(preview);
                    c.this.bxQ.startRecord();
                    c.this.bxQ.startPush();
                }
                if (c.this.bxL != null && c.this.bxR != null) {
                    c.this.bxS = c.this.bxL.getPlayerView();
                    if (c.this.bxS != null) {
                        c.this.bxR.addView(c.this.bxS, 0, new FrameLayout.LayoutParams(-1, -1));
                    }
                }
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void q(int i, boolean z) {
            BdLog.e("blmsdk:onChatStreamLeavedForSeconds sec=" + i + " isCurrentUserNetErr:" + z);
            if (10 == i && !z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_other_network_error));
            } else if (30 == i) {
                c.this.bxL.cP(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void B(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            c.this.Ro();
            c.this.Rr();
            c.this.Rp();
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_closed));
            }
            if (c.this.bxK != null && c.this.bxL != null) {
                c.this.bxK.gb(c.this.bxL.Sa());
            }
            if (c.this.bxO != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bAw = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bAu;
                bVar.bAy = TbadkCoreApplication.getCurrentAccount();
                c.this.bxO.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, String str) {
            if (cVar == null || c.this.bxN == null || !c.this.bxN.Ri()) {
                c.this.bxL.Sh();
                return;
            }
            c.this.bxN.Rj();
            c.this.m23if(str);
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
                jSONObject.putOpt(UgcConstant.EXT_INFO, str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_FAIL).setContentExt(null, null, jSONObject));
        }
    };
    private com.baidu.live.videochat.d.a bxL = new g();
    private com.baidu.live.videochat.f.a bxJ = new com.baidu.live.videochat.f.a(this.bxV, this.bxW);
    private com.baidu.live.videochat.c.b bxM = new com.baidu.live.videochat.c.b();
    private com.baidu.live.videochat.d.a.a bxO = new com.baidu.live.videochat.d.a.a();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bxK = new com.baidu.live.videochat.panel.c(tbPageContext, this.bxU);
        aI(tbPageContext.getPageActivity().getApplicationContext());
        this.bxL.init(tbPageContext.getPageActivity());
        this.bxL.a(this.bxX);
        if (this.bxM != null) {
            this.bxM.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void OK() {
                    c.this.bxL.cP(false);
                    c.this.bxJ.SQ();
                }
            });
        }
    }

    private void aI(Context context) {
        this.bxP = (TelephonyManager) context.getSystemService("phone");
        if (this.bxP != null) {
            this.bxP.listen(this.bxT, 32);
        }
    }

    @Override // com.baidu.live.ae.a
    public void w(ViewGroup viewGroup) {
        this.bxK.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ae.a
    public void x(ViewGroup viewGroup) {
        this.bxJ.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ae.a
    public void L(Object obj) {
        if (this.bxL != null && (obj instanceof AlaLiveRecorder)) {
            this.bxQ = (AlaLiveRecorder) obj;
            this.bxL.a(this.bxQ);
        }
    }

    @Override // com.baidu.live.ae.a
    public void a(FrameLayout frameLayout) {
        this.bxR = frameLayout;
    }

    @Override // com.baidu.live.ae.a
    public void s(u uVar) {
        this.aDU = uVar;
        if (this.bxL != null) {
            this.bxL.s(uVar);
        }
        if (this.bxM != null) {
            this.bxM.aC(this.aDU.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.ae.a
    public void Re() {
        String str = null;
        if (this.bxL.Si() != null) {
            str = String.valueOf(this.bxL.Si().aBd);
        }
        this.bxK.Q(this.bxL.Sa(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aBk = UserPermission.VISITER;
        cVar.aBd = JavaTypesHelper.toLong(aVar.bBz, 0L);
        cVar.aBl = aVar.bBA;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bBy;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ro() {
        if (this.bxS != null && this.bxS.getParent() != null) {
            ((ViewGroup) this.bxS.getParent()).removeView(this.bxS);
            this.bxS = null;
        }
        if (this.aDU != null && this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.isPubShow && this.bxR != null && this.bxQ != null) {
            View preview = this.bxQ.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bxR) {
                    ((ViewGroup) preview.getParent()).removeView(this.bxQ.getPreview());
                    this.bxR.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bxR.addView(preview, 0, layoutParams);
                }
            }
            this.bxQ.startRecord();
            this.bxQ.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rp() {
        if (this.bxJ != null) {
            this.bxJ.SQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rq() {
        if (this.bxM != null) {
            this.bxM.Sf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rr() {
        if (this.bxM != null) {
            this.bxM.Sg();
        }
    }

    @Override // com.baidu.live.ae.a
    public boolean Rf() {
        return this.bxL != null && (h.fW(this.bxL.Sa()) || h.fX(this.bxL.Sa()));
    }

    @Override // com.baidu.live.ae.a
    public boolean Rg() {
        if (this.bxL != null && (h.fW(this.bxL.Sa()) || h.fX(this.bxL.Sa()))) {
            if (this.bxM != null) {
                this.bxM.c(this.mTbPageContext, h.fW(this.bxL.Sa()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.ae.a
    public void a(com.baidu.live.ae.b bVar) {
        this.bxN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m23if(String str) {
        if (this.bxM != null && this.mTbPageContext != null) {
            if (this.bxK != null) {
                this.bxK.hide();
            }
            final com.baidu.live.videochat.d.e ik = com.baidu.live.videochat.d.d.ik(str);
            this.bxM.a(this.mTbPageContext.getPageActivity(), ik.portrait, ik.userName, new a.InterfaceC0206a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
                public void Rw() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
                public void Rx() {
                    if (c.this.bxN != null) {
                        c.this.bxN.Rj();
                    }
                    if (c.this.bxJ != null) {
                        c.this.bxJ.a(c.this.aDU, new com.baidu.live.videochat.f.c(ik.portrait, ik.userName, false));
                    }
                    c.this.bxL.Y(com.baidu.live.videochat.d.d.a(ik, c.this.aDU, com.baidu.live.videochat.d.d.bzQ));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
                public void Ry() {
                    c.this.bxL.Z(com.baidu.live.videochat.d.d.a(ik, c.this.aDU, com.baidu.live.videochat.d.d.bzS));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
                public void Rz() {
                    c.this.bxL.Z(com.baidu.live.videochat.d.d.a(ik, c.this.aDU, com.baidu.live.videochat.d.d.bzR));
                }
            });
        }
    }

    @Override // com.baidu.live.ae.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bxK != null) {
            return this.bxK.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.ae.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bxP != null) {
            this.bxP.listen(this.bxT, 0);
        }
        if (this.bxM != null) {
            this.bxM.onDestroy();
        }
        if (this.bxL != null) {
            this.bxL.onDestroy();
        }
        if (this.bxJ != null) {
            this.bxJ.onDestroy();
        }
        if (this.bxK != null) {
            this.bxK.onDestroy();
        }
        if (this.bxO != null) {
            this.bxO.onDestroy();
        }
    }

    @Override // com.baidu.live.ae.a
    public void setMute(boolean z) {
        if (this.bxL != null) {
            this.bxL.setMute(z);
        }
    }

    @Override // com.baidu.live.ae.a
    public void Rh() {
        if (Rf() && this.bxL != null) {
            this.bxL.cP(false);
        }
    }
}
