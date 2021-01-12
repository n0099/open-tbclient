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
import com.baidu.live.data.x;
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
public class c implements com.baidu.live.an.a {
    private x aBr;
    private AlaLiveRecorder bAQ;
    private com.baidu.live.videochat.panel.c bKq;
    private com.baidu.live.an.b bKt;
    private com.baidu.live.videochat.d.a.a bKu;
    private TelephonyManager bKv;
    private FrameLayout bKw;
    private View bKx;
    private TbPageContext mTbPageContext;
    private PhoneStateListener byU = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bKr != null) {
                        c.this.bKr.dr(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bKy = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                JSONObject a3 = com.baidu.live.videochat.d.d.a(c.this.aBr, aVar, com.baidu.live.videochat.d.d.bMb);
                if (c.this.bKr != null && c.this.bKr.b(a2, a3)) {
                    if (c.this.bKp != null) {
                        c.this.bKp.a(c.this.aBr, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, aVar.userId, true));
                    }
                    if (c.this.bKq != null) {
                        c.this.bKq.hide();
                    }
                    if (c.this.bKt != null) {
                        c.this.bKt.TW();
                    }
                }
            }
        }
    };
    private b.a bKz = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void Uh() {
            if (c.this.bKs != null && c.this.bKr != null) {
                c.this.bKs.a(c.this.mTbPageContext, h.fb(c.this.bKr.Ro()));
            }
        }
    };
    private b.InterfaceC0224b bKA = new b.InterfaceC0224b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0224b
        public void Ui() {
            if (c.this.bKr != null) {
                c.this.bKr.dr(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bKB = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void Uj() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.Uf();
            c.this.Ue();
            if (c.this.bKt != null) {
                c.this.bKt.TX();
            }
            if (i == com.baidu.live.videochat.d.c.bCj) {
                if (com.baidu.live.videochat.d.d.bMd.equals(com.baidu.live.videochat.d.d.an(c.this.bKr.UQ()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_rejected));
                }
            } else if (i != com.baidu.live.videochat.d.c.bLQ) {
                if (i == com.baidu.live.videochat.d.c.bLN || i == com.baidu.live.videochat.d.c.bLO) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
                } else if (i == com.baidu.live.videochat.d.c.bLP) {
                    if (z) {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_timeout));
                    } else {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_connected_timeout));
                    }
                } else if (i == com.baidu.live.videochat.d.c.bCh) {
                    if (c.this.bKu != null && c.this.bKr != null) {
                        com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                        bVar.bBz = c.this.bKr.UR();
                        bVar.action = com.baidu.live.videochat.d.a.b.bMA;
                        bVar.bBB = TbadkCoreApplication.getCurrentAccount();
                        c.this.bKu.a(bVar);
                    }
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_connected_fail));
                }
            }
            if (c.this.bKq != null && c.this.bKr != null) {
                c.this.bKq.dW(c.this.bKr.Ro());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            if (c.this.bKu != null && c.this.bKr != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bBz = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bMz;
                bVar.bBA = com.baidu.live.videochat.d.a.b.bMB;
                bVar.bBB = TbadkCoreApplication.getCurrentAccount();
                bVar.bBE = c.this.bKr.UQ();
                c.this.bKu.a(bVar);
            }
            if (c.this.bKq != null && c.this.bKr != null) {
                c.this.bKq.fe(c.this.bKr.Ro());
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
        public void Uk() {
            if (c.this.aBr == null || c.this.aBr.mLiveInfo == null || !c.this.aBr.mLiveInfo.isPubShow) {
                if (c.this.bKp != null && c.this.bKr != null) {
                    c.this.bKp.ag(c.this.bKr.Lu());
                }
            } else if (c.this.bKr == null || c.this.bKx == null || c.this.bKx != c.this.bKr.Lu() || c.this.bKx.getParent() == null || c.this.bKx.getParent() != c.this.bKw) {
                if (c.this.bKx != null && c.this.bKx.getParent() != null) {
                    ((ViewGroup) c.this.bKx.getParent()).removeView(c.this.bKx);
                    c.this.bKx = null;
                }
                if (c.this.bAQ != null && c.this.bAQ.getPreview() != null && c.this.bKp != null && c.this.bKw != null) {
                    View preview = c.this.bAQ.getPreview();
                    c.this.bKw.removeView(preview);
                    c.this.bKp.ag(preview);
                    c.this.bAQ.startRecord();
                    c.this.bAQ.startPush();
                }
                if (c.this.bKr != null && c.this.bKw != null) {
                    c.this.bKx = c.this.bKr.Lu();
                    if (c.this.bKx != null) {
                        c.this.bKw.addView(c.this.bKx, 0, new FrameLayout.LayoutParams(-1, -1));
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
                c.this.bKr.dr(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void D(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            c.this.Ud();
            c.this.Ug();
            c.this.Ue();
            if (c.this.bKt != null) {
                c.this.bKt.TX();
            }
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            }
            if (c.this.bKq != null && c.this.bKr != null) {
                c.this.bKq.ff(c.this.bKr.Ro());
            }
            if (c.this.bKu != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bBz = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bMA;
                bVar.bBB = TbadkCoreApplication.getCurrentAccount();
                c.this.bKu.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            if (cVar == null || c.this.bKt == null || !c.this.bKt.TU()) {
                c.this.bKr.UO();
                return;
            }
            c.this.bKt.TV();
            c.this.ai(jSONObject);
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
    private com.baidu.live.videochat.d.a bKr = new com.baidu.live.videochat.d.g();
    private com.baidu.live.videochat.f.a bKp = new com.baidu.live.videochat.f.a(this.bKz, this.bKA);
    private com.baidu.live.videochat.c.b bKs = new com.baidu.live.videochat.c.b();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bKq = new com.baidu.live.videochat.panel.c(tbPageContext, this.bKy);
        this.bKu = new com.baidu.live.videochat.d.a.a(tbPageContext);
        bc(tbPageContext.getPageActivity().getApplicationContext());
        this.bKr.init(tbPageContext.getPageActivity());
        this.bKr.a(this.bKB);
        if (this.bKs != null) {
            this.bKs.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void OB() {
                    c.this.bKr.dr(false);
                    c.this.bKp.Vv();
                }
            });
        }
    }

    private void bc(Context context) {
        this.bKv = (TelephonyManager) context.getSystemService("phone");
        if (this.bKv != null) {
            this.bKv.listen(this.byU, 32);
        }
    }

    @Override // com.baidu.live.an.a
    public void x(ViewGroup viewGroup) {
        this.bKq.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.an.a
    public void y(ViewGroup viewGroup) {
        this.bKp.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.an.a
    public void H(Object obj) {
        if (this.bKr != null && (obj instanceof AlaLiveRecorder)) {
            this.bAQ = (AlaLiveRecorder) obj;
            this.bKr.a(this.bAQ);
        }
    }

    @Override // com.baidu.live.an.a
    public void a(FrameLayout frameLayout) {
        this.bKw = frameLayout;
    }

    @Override // com.baidu.live.an.a
    public void t(x xVar) {
        this.aBr = xVar;
        if (this.bKr != null) {
            this.bKr.t(xVar);
        }
        if (this.bKs != null) {
            this.bKs.by(this.aBr.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.an.a
    public void TP() {
        String str = null;
        if (this.bKr.UP() != null) {
            str = String.valueOf(this.bKr.UP().axT);
        }
        this.bKq.Z(this.bKr.Ro(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.axY = UserPermission.VISITER;
        cVar.axT = JavaTypesHelper.toLong(aVar.bNA, 0L);
        cVar.axZ = aVar.bNB;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bNz;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ud() {
        if (this.bKx != null && this.bKx.getParent() != null) {
            ((ViewGroup) this.bKx.getParent()).removeView(this.bKx);
            this.bKx = null;
        }
        if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.isPubShow && this.bKw != null && this.bAQ != null) {
            View preview = this.bAQ.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bKw) {
                    ((ViewGroup) preview.getParent()).removeView(this.bAQ.getPreview());
                    this.bKw.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bKw.addView(preview, 0, layoutParams);
                }
            }
            this.bAQ.startRecord();
            this.bAQ.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ue() {
        if (this.bKp != null) {
            this.bKp.Vv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uf() {
        if (this.bKs != null) {
            this.bKs.Qh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ug() {
        if (this.bKs != null) {
            this.bKs.Qi();
        }
    }

    @Override // com.baidu.live.an.a
    public boolean TQ() {
        return this.bKr != null && (h.fb(this.bKr.Ro()) || h.fc(this.bKr.Ro()));
    }

    @Override // com.baidu.live.an.a
    public boolean PD() {
        if (this.bKr != null && (h.fb(this.bKr.Ro()) || h.fc(this.bKr.Ro()))) {
            if (this.bKs != null) {
                this.bKs.a(this.mTbPageContext, h.fb(this.bKr.Ro()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.an.a
    public void a(com.baidu.live.an.b bVar) {
        this.bKt = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(JSONObject jSONObject) {
        if (this.bKs != null && this.mTbPageContext != null) {
            if (this.bKq != null) {
                this.bKq.hide();
            }
            final com.baidu.live.videochat.d.e al = com.baidu.live.videochat.d.d.al(jSONObject);
            this.bKs.a(this.mTbPageContext.getPageActivity(), al.portrait, al.userName, new a.InterfaceC0220a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
                public void Ul() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
                public void Um() {
                    if (c.this.bKt != null) {
                        c.this.bKt.TV();
                    }
                    if (c.this.bKp != null) {
                        c.this.bKp.a(c.this.aBr, new com.baidu.live.videochat.f.c(al.portrait, al.userName, al.userId, false));
                        if (c.this.bKt != null) {
                            c.this.bKt.TW();
                        }
                    }
                    c.this.bKr.aj(com.baidu.live.videochat.d.d.a(al, c.this.aBr, com.baidu.live.videochat.d.d.bMc));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
                public void Un() {
                    c.this.bKr.ak(com.baidu.live.videochat.d.d.a(al, c.this.aBr, com.baidu.live.videochat.d.d.bMe));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
                public void Qc() {
                    c.this.bKr.ak(com.baidu.live.videochat.d.d.a(al, c.this.aBr, com.baidu.live.videochat.d.d.bMd));
                }
            });
        }
    }

    @Override // com.baidu.live.an.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bKq != null) {
            return this.bKq.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.an.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bKv != null) {
            this.bKv.listen(this.byU, 0);
        }
        if (this.bKs != null) {
            this.bKs.onDestroy();
        }
        if (this.bKr != null) {
            this.bKr.onDestroy();
        }
        if (this.bKp != null) {
            this.bKp.onDestroy();
        }
        if (this.bKq != null) {
            this.bKq.onDestroy();
        }
        if (this.bKu != null) {
            this.bKu.onDestroy();
        }
    }

    @Override // com.baidu.live.an.a
    public void setMute(boolean z) {
        if (this.bKr != null) {
            this.bKr.setMute(z);
        }
    }

    @Override // com.baidu.live.an.a
    public void TR() {
        if (TQ() && this.bKr != null) {
            this.bKr.dr(false);
        }
    }

    @Override // com.baidu.live.an.a
    public void TS() {
        if (this.bKr != null) {
            this.bKr.TS();
        }
    }

    @Override // com.baidu.live.an.a
    public void TT() {
        if (this.bKr != null) {
            this.bKr.TT();
        }
    }

    @Override // com.baidu.live.an.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (TQ()) {
            this.bKp.onKeyboardVisibilityChanged(z);
        }
    }
}
