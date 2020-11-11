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
import com.baidu.live.videochat.d.h;
import com.baidu.live.videochat.f.b;
import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.ai.a {
    private w aES;
    private com.baidu.live.videochat.panel.c bGR;
    private com.baidu.live.ai.b bGU;
    private com.baidu.live.videochat.d.a.a bGV;
    private TelephonyManager bGW;
    private FrameLayout bGX;
    private View bGY;
    private AlaLiveRecorder bxq;
    private TbPageContext mTbPageContext;
    private PhoneStateListener bvv = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bGS != null) {
                        c.this.bGS.dc(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bGZ = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                JSONObject a3 = com.baidu.live.videochat.d.d.a(c.this.aES, aVar, com.baidu.live.videochat.d.d.bID);
                if (c.this.bGS != null && c.this.bGS.b(a2, a3)) {
                    if (c.this.bGQ != null) {
                        c.this.bGQ.a(c.this.aES, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, true));
                    }
                    if (c.this.bGR != null) {
                        c.this.bGR.hide();
                    }
                }
            }
        }
    };
    private b.a bHa = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void Va() {
            if (c.this.bGT != null && c.this.bGS != null) {
                c.this.bGT.c(c.this.mTbPageContext, h.gm(c.this.bGS.Sn()));
            }
        }
    };
    private b.InterfaceC0228b bHb = new b.InterfaceC0228b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0228b
        public void Vb() {
            if (c.this.bGS != null) {
                c.this.bGS.dc(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bHc = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void Vc() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.UY();
            c.this.UX();
            if (i == com.baidu.live.videochat.d.c.byL) {
                if (com.baidu.live.videochat.d.d.bIF.equals(com.baidu.live.videochat.d.d.aj(c.this.bGS.VL()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_rejected));
                }
            } else if (i != com.baidu.live.videochat.d.c.bIs) {
                if (i == com.baidu.live.videochat.d.c.bIp || i == com.baidu.live.videochat.d.c.bIq) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
                } else if (i == com.baidu.live.videochat.d.c.bIr) {
                    if (z) {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_timeout));
                    } else {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_connected_timeout));
                    }
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_connected_fail));
                }
            }
            if (c.this.bGR != null && c.this.bGS != null) {
                c.this.bGR.fh(c.this.bGS.Sn());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void B(String str, boolean z) {
            if (c.this.bGV != null && c.this.bGS != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bxZ = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bJb;
                bVar.bya = com.baidu.live.videochat.d.a.b.bJd;
                bVar.byb = TbadkCoreApplication.getCurrentAccount();
                bVar.ext = c.this.bGS.VL();
                c.this.bGV.a(bVar);
            }
            if (c.this.bGR != null && c.this.bGS != null) {
                c.this.bGR.gq(c.this.bGS.Sn());
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
        public void Vd() {
            if (c.this.aES == null || c.this.aES.mLiveInfo == null || !c.this.aES.mLiveInfo.isPubShow) {
                if (c.this.bGQ != null && c.this.bGS != null) {
                    c.this.bGQ.ag(c.this.bGS.getPlayerView());
                }
            } else if (c.this.bGS == null || c.this.bGY == null || c.this.bGY != c.this.bGS.getPlayerView() || c.this.bGY.getParent() == null || c.this.bGY.getParent() != c.this.bGX) {
                if (c.this.bGY != null && c.this.bGY.getParent() != null) {
                    ((ViewGroup) c.this.bGY.getParent()).removeView(c.this.bGY);
                    c.this.bGY = null;
                }
                if (c.this.bxq != null && c.this.bxq.getPreview() != null && c.this.bGQ != null && c.this.bGX != null) {
                    View preview = c.this.bxq.getPreview();
                    c.this.bGX.removeView(preview);
                    c.this.bGQ.ag(preview);
                    c.this.bxq.startRecord();
                    c.this.bxq.startPush();
                }
                if (c.this.bGS != null && c.this.bGX != null) {
                    c.this.bGY = c.this.bGS.getPlayerView();
                    if (c.this.bGY != null) {
                        c.this.bGX.addView(c.this.bGY, 0, new FrameLayout.LayoutParams(-1, -1));
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
                c.this.bGS.dc(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            c.this.UW();
            c.this.UZ();
            c.this.UX();
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            }
            if (c.this.bGR != null && c.this.bGS != null) {
                c.this.bGR.gr(c.this.bGS.Sn());
            }
            if (c.this.bGV != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bxZ = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bJc;
                bVar.byb = TbadkCoreApplication.getCurrentAccount();
                c.this.bGV.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            if (cVar == null || c.this.bGU == null || !c.this.bGU.UP()) {
                c.this.bGS.VJ();
                return;
            }
            c.this.bGU.UQ();
            c.this.ae(jSONObject);
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
    private com.baidu.live.videochat.d.a bGS = new com.baidu.live.videochat.d.g();
    private com.baidu.live.videochat.f.a bGQ = new com.baidu.live.videochat.f.a(this.bHa, this.bHb);
    private com.baidu.live.videochat.c.b bGT = new com.baidu.live.videochat.c.b();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bGR = new com.baidu.live.videochat.panel.c(tbPageContext, this.bGZ);
        this.bGV = new com.baidu.live.videochat.d.a.a(tbPageContext);
        aA(tbPageContext.getPageActivity().getApplicationContext());
        this.bGS.init(tbPageContext.getPageActivity());
        this.bGS.a(this.bHc);
        if (this.bGT != null) {
            this.bGT.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void PI() {
                    c.this.bGS.dc(false);
                    c.this.bGQ.Wp();
                }
            });
        }
    }

    private void aA(Context context) {
        this.bGW = (TelephonyManager) context.getSystemService("phone");
        if (this.bGW != null) {
            this.bGW.listen(this.bvv, 32);
        }
    }

    @Override // com.baidu.live.ai.a
    public void y(ViewGroup viewGroup) {
        this.bGR.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ai.a
    public void z(ViewGroup viewGroup) {
        this.bGQ.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ai.a
    public void L(Object obj) {
        if (this.bGS != null && (obj instanceof AlaLiveRecorder)) {
            this.bxq = (AlaLiveRecorder) obj;
            this.bGS.a(this.bxq);
        }
    }

    @Override // com.baidu.live.ai.a
    public void a(FrameLayout frameLayout) {
        this.bGX = frameLayout;
    }

    @Override // com.baidu.live.ai.a
    public void s(w wVar) {
        this.aES = wVar;
        if (this.bGS != null) {
            this.bGS.s(wVar);
        }
        if (this.bGT != null) {
            this.bGT.ba(this.aES.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.ai.a
    public void UM() {
        String str = null;
        if (this.bGS.VK() != null) {
            str = String.valueOf(this.bGS.VK().aBv);
        }
        this.bGR.W(this.bGS.Sn(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aBA = UserPermission.VISITER;
        cVar.aBv = JavaTypesHelper.toLong(aVar.bKc, 0L);
        cVar.aBB = aVar.bKd;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bKb;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UW() {
        if (this.bGY != null && this.bGY.getParent() != null) {
            ((ViewGroup) this.bGY.getParent()).removeView(this.bGY);
            this.bGY = null;
        }
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.mLiveInfo.isPubShow && this.bGX != null && this.bxq != null) {
            View preview = this.bxq.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bGX) {
                    ((ViewGroup) preview.getParent()).removeView(this.bxq.getPreview());
                    this.bGX.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bGX.addView(preview, 0, layoutParams);
                }
            }
            this.bxq.startRecord();
            this.bxq.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UX() {
        if (this.bGQ != null) {
            this.bGQ.Wp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UY() {
        if (this.bGT != null) {
            this.bGT.Ri();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UZ() {
        if (this.bGT != null) {
            this.bGT.Rj();
        }
    }

    @Override // com.baidu.live.ai.a
    public boolean UN() {
        return this.bGS != null && (h.gm(this.bGS.Sn()) || h.gn(this.bGS.Sn()));
    }

    @Override // com.baidu.live.ai.a
    public boolean QF() {
        if (this.bGS != null && (h.gm(this.bGS.Sn()) || h.gn(this.bGS.Sn()))) {
            if (this.bGT != null) {
                this.bGT.c(this.mTbPageContext, h.gm(this.bGS.Sn()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.ai.a
    public void a(com.baidu.live.ai.b bVar) {
        this.bGU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(JSONObject jSONObject) {
        if (this.bGT != null && this.mTbPageContext != null) {
            if (this.bGR != null) {
                this.bGR.hide();
            }
            final com.baidu.live.videochat.d.e ah = com.baidu.live.videochat.d.d.ah(jSONObject);
            this.bGT.a(this.mTbPageContext.getPageActivity(), ah.portrait, ah.userName, new a.InterfaceC0224a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
                public void Ve() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
                public void Vf() {
                    if (c.this.bGU != null) {
                        c.this.bGU.UQ();
                    }
                    if (c.this.bGQ != null) {
                        c.this.bGQ.a(c.this.aES, new com.baidu.live.videochat.f.c(ah.portrait, ah.userName, false));
                    }
                    c.this.bGS.af(com.baidu.live.videochat.d.d.a(ah, c.this.aES, com.baidu.live.videochat.d.d.bIE));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
                public void Vg() {
                    c.this.bGS.ag(com.baidu.live.videochat.d.d.a(ah, c.this.aES, com.baidu.live.videochat.d.d.bIG));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
                public void Rb() {
                    c.this.bGS.ag(com.baidu.live.videochat.d.d.a(ah, c.this.aES, com.baidu.live.videochat.d.d.bIF));
                }
            });
        }
    }

    @Override // com.baidu.live.ai.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bGR != null) {
            return this.bGR.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.ai.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bGW != null) {
            this.bGW.listen(this.bvv, 0);
        }
        if (this.bGT != null) {
            this.bGT.onDestroy();
        }
        if (this.bGS != null) {
            this.bGS.onDestroy();
        }
        if (this.bGQ != null) {
            this.bGQ.onDestroy();
        }
        if (this.bGR != null) {
            this.bGR.onDestroy();
        }
        if (this.bGV != null) {
            this.bGV.onDestroy();
        }
    }

    @Override // com.baidu.live.ai.a
    public void setMute(boolean z) {
        if (this.bGS != null) {
            this.bGS.setMute(z);
        }
    }

    @Override // com.baidu.live.ai.a
    public void UO() {
        if (UN() && this.bGS != null) {
            this.bGS.dc(false);
        }
    }
}
