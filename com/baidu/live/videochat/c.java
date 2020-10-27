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
import com.baidu.live.data.w;
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
public class c implements com.baidu.live.ah.a {
    private w aEc;
    private com.baidu.live.videochat.panel.c bAG;
    private com.baidu.live.ah.b bAJ;
    private TelephonyManager bAL;
    private AlaLiveRecorder bAM;
    private FrameLayout bAN;
    private View bAO;
    private TbPageContext mTbPageContext;
    private PhoneStateListener bAP = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bAH != null) {
                        c.this.bAH.cV(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bAQ = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                String a3 = com.baidu.live.videochat.d.d.a(c.this.aEc, aVar, com.baidu.live.videochat.d.d.bCL);
                if (c.this.bAH != null && c.this.bAH.b(a2, a3)) {
                    if (c.this.bAF != null) {
                        c.this.bAF.a(c.this.aEc, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, true));
                    }
                    if (c.this.bAG != null) {
                        c.this.bAG.hide();
                    }
                }
            }
        }
    };
    private b.a bAR = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void Ss() {
            if (c.this.bAI != null && c.this.bAH != null) {
                c.this.bAI.c(c.this.mTbPageContext, h.gb(c.this.bAH.Ta()));
            }
        }
    };
    private b.InterfaceC0216b bAS = new b.InterfaceC0216b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0216b
        public void St() {
            if (c.this.bAH != null) {
                c.this.bAH.cV(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bAT = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void Su() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.Sq();
            c.this.Sp();
            if (i == com.baidu.live.videochat.d.c.bCw) {
                if (com.baidu.live.videochat.d.d.bCN.equals(com.baidu.live.videochat.d.d.ad(c.this.bAH.Tj()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.i.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.i.video_chat_rejected));
                }
            } else if (i != com.baidu.live.videochat.d.c.bCA) {
                if (i == com.baidu.live.videochat.d.c.bCx || i == com.baidu.live.videochat.d.c.bCy) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_closed));
                } else if (i == com.baidu.live.videochat.d.c.bCz) {
                    if (z) {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_timeout));
                    } else {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_connected_timeout));
                    }
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.i.video_chat_connected_fail));
                }
            }
            if (c.this.bAG != null && c.this.bAH != null) {
                c.this.bAG.ge(c.this.bAH.Ta());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void B(String str, boolean z) {
            if (c.this.bAK != null && c.this.bAH != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bDs = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bDp;
                bVar.bDt = com.baidu.live.videochat.d.a.b.bDr;
                bVar.bDu = TbadkCoreApplication.getCurrentAccount();
                bVar.ext = c.this.bAH.Tj();
                c.this.bAK.a(bVar);
            }
            if (c.this.bAG != null && c.this.bAH != null) {
                c.this.bAG.gf(c.this.bAH.Ta());
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
        public void Sv() {
            if (c.this.aEc == null || c.this.aEc.mLiveInfo == null || !c.this.aEc.mLiveInfo.isPubShow) {
                if (c.this.bAF != null && c.this.bAH != null) {
                    c.this.bAF.ac(c.this.bAH.getPlayerView());
                }
            } else if (c.this.bAH == null || c.this.bAO == null || c.this.bAO != c.this.bAH.getPlayerView() || c.this.bAO.getParent() == null || c.this.bAO.getParent() != c.this.bAN) {
                if (c.this.bAO != null && c.this.bAO.getParent() != null) {
                    ((ViewGroup) c.this.bAO.getParent()).removeView(c.this.bAO);
                    c.this.bAO = null;
                }
                if (c.this.bAM != null && c.this.bAM.getPreview() != null && c.this.bAF != null && c.this.bAN != null) {
                    View preview = c.this.bAM.getPreview();
                    c.this.bAN.removeView(preview);
                    c.this.bAF.ac(preview);
                    c.this.bAM.startRecord();
                    c.this.bAM.startPush();
                }
                if (c.this.bAH != null && c.this.bAN != null) {
                    c.this.bAO = c.this.bAH.getPlayerView();
                    if (c.this.bAO != null) {
                        c.this.bAN.addView(c.this.bAO, 0, new FrameLayout.LayoutParams(-1, -1));
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
                c.this.bAH.cV(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            c.this.So();
            c.this.Sr();
            c.this.Sp();
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.i.video_chat_closed));
            }
            if (c.this.bAG != null && c.this.bAH != null) {
                c.this.bAG.gg(c.this.bAH.Ta());
            }
            if (c.this.bAK != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bDs = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bDq;
                bVar.bDu = TbadkCoreApplication.getCurrentAccount();
                c.this.bAK.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, String str) {
            if (cVar == null || c.this.bAJ == null || !c.this.bAJ.Si()) {
                c.this.bAH.Th();
                return;
            }
            c.this.bAJ.Sj();
            c.this.iq(str);
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
    private com.baidu.live.videochat.d.a bAH = new g();
    private com.baidu.live.videochat.f.a bAF = new com.baidu.live.videochat.f.a(this.bAR, this.bAS);
    private com.baidu.live.videochat.c.b bAI = new com.baidu.live.videochat.c.b();
    private com.baidu.live.videochat.d.a.a bAK = new com.baidu.live.videochat.d.a.a();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bAG = new com.baidu.live.videochat.panel.c(tbPageContext, this.bAQ);
        aI(tbPageContext.getPageActivity().getApplicationContext());
        this.bAH.init(tbPageContext.getPageActivity());
        this.bAH.a(this.bAT);
        if (this.bAI != null) {
            this.bAI.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void Pi() {
                    c.this.bAH.cV(false);
                    c.this.bAF.TP();
                }
            });
        }
    }

    private void aI(Context context) {
        this.bAL = (TelephonyManager) context.getSystemService("phone");
        if (this.bAL != null) {
            this.bAL.listen(this.bAP, 32);
        }
    }

    @Override // com.baidu.live.ah.a
    public void w(ViewGroup viewGroup) {
        this.bAG.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ah.a
    public void x(ViewGroup viewGroup) {
        this.bAF.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ah.a
    public void L(Object obj) {
        if (this.bAH != null && (obj instanceof AlaLiveRecorder)) {
            this.bAM = (AlaLiveRecorder) obj;
            this.bAH.a(this.bAM);
        }
    }

    @Override // com.baidu.live.ah.a
    public void a(FrameLayout frameLayout) {
        this.bAN = frameLayout;
    }

    @Override // com.baidu.live.ah.a
    public void r(w wVar) {
        this.aEc = wVar;
        if (this.bAH != null) {
            this.bAH.r(wVar);
        }
        if (this.bAI != null) {
            this.bAI.aE(this.aEc.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.ah.a
    public void Se() {
        String str = null;
        if (this.bAH.Ti() != null) {
            str = String.valueOf(this.bAH.Ti().aBi);
        }
        this.bAG.S(this.bAH.Ta(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aBp = UserPermission.VISITER;
        cVar.aBi = JavaTypesHelper.toLong(aVar.bEv, 0L);
        cVar.aBq = aVar.bEw;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bEu;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void So() {
        if (this.bAO != null && this.bAO.getParent() != null) {
            ((ViewGroup) this.bAO.getParent()).removeView(this.bAO);
            this.bAO = null;
        }
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.isPubShow && this.bAN != null && this.bAM != null) {
            View preview = this.bAM.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bAN) {
                    ((ViewGroup) preview.getParent()).removeView(this.bAM.getPreview());
                    this.bAN.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bAN.addView(preview, 0, layoutParams);
                }
            }
            this.bAM.startRecord();
            this.bAM.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sp() {
        if (this.bAF != null) {
            this.bAF.TP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sq() {
        if (this.bAI != null) {
            this.bAI.Tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sr() {
        if (this.bAI != null) {
            this.bAI.Tg();
        }
    }

    @Override // com.baidu.live.ah.a
    public boolean Sf() {
        return this.bAH != null && (h.gb(this.bAH.Ta()) || h.gc(this.bAH.Ta()));
    }

    @Override // com.baidu.live.ah.a
    public boolean Sg() {
        if (this.bAH != null && (h.gb(this.bAH.Ta()) || h.gc(this.bAH.Ta()))) {
            if (this.bAI != null) {
                this.bAI.c(this.mTbPageContext, h.gb(this.bAH.Ta()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.ah.a
    public void a(com.baidu.live.ah.b bVar) {
        this.bAJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq(String str) {
        if (this.bAI != null && this.mTbPageContext != null) {
            if (this.bAG != null) {
                this.bAG.hide();
            }
            final com.baidu.live.videochat.d.e iv = com.baidu.live.videochat.d.d.iv(str);
            this.bAI.a(this.mTbPageContext.getPageActivity(), iv.portrait, iv.userName, new a.InterfaceC0212a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
                public void Sw() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
                public void Sx() {
                    if (c.this.bAJ != null) {
                        c.this.bAJ.Sj();
                    }
                    if (c.this.bAF != null) {
                        c.this.bAF.a(c.this.aEc, new com.baidu.live.videochat.f.c(iv.portrait, iv.userName, false));
                    }
                    c.this.bAH.aa(com.baidu.live.videochat.d.d.a(iv, c.this.aEc, com.baidu.live.videochat.d.d.bCM));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
                public void Sy() {
                    c.this.bAH.ab(com.baidu.live.videochat.d.d.a(iv, c.this.aEc, com.baidu.live.videochat.d.d.bCO));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
                public void Sz() {
                    c.this.bAH.ab(com.baidu.live.videochat.d.d.a(iv, c.this.aEc, com.baidu.live.videochat.d.d.bCN));
                }
            });
        }
    }

    @Override // com.baidu.live.ah.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bAG != null) {
            return this.bAG.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.ah.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bAL != null) {
            this.bAL.listen(this.bAP, 0);
        }
        if (this.bAI != null) {
            this.bAI.onDestroy();
        }
        if (this.bAH != null) {
            this.bAH.onDestroy();
        }
        if (this.bAF != null) {
            this.bAF.onDestroy();
        }
        if (this.bAG != null) {
            this.bAG.onDestroy();
        }
        if (this.bAK != null) {
            this.bAK.onDestroy();
        }
    }

    @Override // com.baidu.live.ah.a
    public void setMute(boolean z) {
        if (this.bAH != null) {
            this.bAH.setMute(z);
        }
    }

    @Override // com.baidu.live.ah.a
    public void Sh() {
        if (Sf() && this.bAH != null) {
            this.bAH.cV(false);
        }
    }
}
