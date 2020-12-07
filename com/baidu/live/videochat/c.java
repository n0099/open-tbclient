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
public class c implements com.baidu.live.am.a {
    private w aFN;
    private AlaLiveRecorder bAP;
    private com.baidu.live.videochat.panel.c bKp;
    private com.baidu.live.am.b bKs;
    private com.baidu.live.videochat.d.a.a bKt;
    private TelephonyManager bKu;
    private FrameLayout bKv;
    private View bKw;
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
                    if (c.this.bKq != null) {
                        c.this.bKq.ds(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bKx = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                JSONObject a3 = com.baidu.live.videochat.d.d.a(c.this.aFN, aVar, com.baidu.live.videochat.d.d.bMa);
                if (c.this.bKq != null && c.this.bKq.b(a2, a3)) {
                    if (c.this.bKo != null) {
                        c.this.bKo.a(c.this.aFN, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, true));
                    }
                    if (c.this.bKp != null) {
                        c.this.bKp.hide();
                    }
                }
            }
        }
    };
    private b.a bKy = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void WT() {
            if (c.this.bKr != null && c.this.bKq != null) {
                c.this.bKr.c(c.this.mTbPageContext, h.gH(c.this.bKq.Uc()));
            }
        }
    };
    private b.InterfaceC0235b bKz = new b.InterfaceC0235b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0235b
        public void WU() {
            if (c.this.bKq != null) {
                c.this.bKq.ds(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bKA = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void WV() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.WR();
            c.this.WQ();
            if (i == com.baidu.live.videochat.d.c.bCi) {
                if (com.baidu.live.videochat.d.d.bMc.equals(com.baidu.live.videochat.d.d.af(c.this.bKq.XC()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_rejected));
                }
            } else if (i != com.baidu.live.videochat.d.c.bLP) {
                if (i == com.baidu.live.videochat.d.c.bLM || i == com.baidu.live.videochat.d.c.bLN) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
                } else if (i == com.baidu.live.videochat.d.c.bLO) {
                    if (z) {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_timeout));
                    } else {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_connected_timeout));
                    }
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_connected_fail));
                }
            }
            if (c.this.bKp != null && c.this.bKq != null) {
                c.this.bKp.fB(c.this.bKq.Uc());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            if (c.this.bKt != null && c.this.bKq != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bBy = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bMy;
                bVar.bBz = com.baidu.live.videochat.d.a.b.bMA;
                bVar.bBA = TbadkCoreApplication.getCurrentAccount();
                bVar.ext = c.this.bKq.XC();
                c.this.bKt.a(bVar);
            }
            if (c.this.bKp != null && c.this.bKq != null) {
                c.this.bKp.gK(c.this.bKq.Uc());
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
        public void WW() {
            if (c.this.aFN == null || c.this.aFN.mLiveInfo == null || !c.this.aFN.mLiveInfo.isPubShow) {
                if (c.this.bKo != null && c.this.bKq != null) {
                    c.this.bKo.ag(c.this.bKq.getPlayerView());
                }
            } else if (c.this.bKq == null || c.this.bKw == null || c.this.bKw != c.this.bKq.getPlayerView() || c.this.bKw.getParent() == null || c.this.bKw.getParent() != c.this.bKv) {
                if (c.this.bKw != null && c.this.bKw.getParent() != null) {
                    ((ViewGroup) c.this.bKw.getParent()).removeView(c.this.bKw);
                    c.this.bKw = null;
                }
                if (c.this.bAP != null && c.this.bAP.getPreview() != null && c.this.bKo != null && c.this.bKv != null) {
                    View preview = c.this.bAP.getPreview();
                    c.this.bKv.removeView(preview);
                    c.this.bKo.ag(preview);
                    c.this.bAP.startRecord();
                    c.this.bAP.startPush();
                }
                if (c.this.bKq != null && c.this.bKv != null) {
                    c.this.bKw = c.this.bKq.getPlayerView();
                    if (c.this.bKw != null) {
                        c.this.bKv.addView(c.this.bKw, 0, new FrameLayout.LayoutParams(-1, -1));
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
                c.this.bKq.ds(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void D(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            c.this.WP();
            c.this.WS();
            c.this.WQ();
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            }
            if (c.this.bKp != null && c.this.bKq != null) {
                c.this.bKp.gL(c.this.bKq.Uc());
            }
            if (c.this.bKt != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bBy = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bMz;
                bVar.bBA = TbadkCoreApplication.getCurrentAccount();
                c.this.bKt.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            if (cVar == null || c.this.bKs == null || !c.this.bKs.WI()) {
                c.this.bKq.XA();
                return;
            }
            c.this.bKs.WJ();
            c.this.aa(jSONObject);
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
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_FAIL).setContentExt(null, null, jSONObject));
        }
    };
    private com.baidu.live.videochat.d.a bKq = new com.baidu.live.videochat.d.g();
    private com.baidu.live.videochat.f.a bKo = new com.baidu.live.videochat.f.a(this.bKy, this.bKz);
    private com.baidu.live.videochat.c.b bKr = new com.baidu.live.videochat.c.b();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bKp = new com.baidu.live.videochat.panel.c(tbPageContext, this.bKx);
        this.bKt = new com.baidu.live.videochat.d.a.a(tbPageContext);
        be(tbPageContext.getPageActivity().getApplicationContext());
        this.bKq.init(tbPageContext.getPageActivity());
        this.bKq.a(this.bKA);
        if (this.bKr != null) {
            this.bKr.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void Rt() {
                    c.this.bKq.ds(false);
                    c.this.bKo.Yg();
                }
            });
        }
    }

    private void be(Context context) {
        this.bKu = (TelephonyManager) context.getSystemService("phone");
        if (this.bKu != null) {
            this.bKu.listen(this.byU, 32);
        }
    }

    @Override // com.baidu.live.am.a
    public void u(ViewGroup viewGroup) {
        this.bKp.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.am.a
    public void v(ViewGroup viewGroup) {
        this.bKo.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.am.a
    public void L(Object obj) {
        if (this.bKq != null && (obj instanceof AlaLiveRecorder)) {
            this.bAP = (AlaLiveRecorder) obj;
            this.bKq.a(this.bAP);
        }
    }

    @Override // com.baidu.live.am.a
    public void a(FrameLayout frameLayout) {
        this.bKv = frameLayout;
    }

    @Override // com.baidu.live.am.a
    public void s(w wVar) {
        this.aFN = wVar;
        if (this.bKq != null) {
            this.bKq.s(wVar);
        }
        if (this.bKr != null) {
            this.bKr.by(this.aFN.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.am.a
    public void WD() {
        String str = null;
        if (this.bKq.XB() != null) {
            str = String.valueOf(this.bKq.XB().aCp);
        }
        this.bKp.W(this.bKq.Uc(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aCu = UserPermission.VISITER;
        cVar.aCp = JavaTypesHelper.toLong(aVar.bNz, 0L);
        cVar.aCv = aVar.bNA;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bNy;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WP() {
        if (this.bKw != null && this.bKw.getParent() != null) {
            ((ViewGroup) this.bKw.getParent()).removeView(this.bKw);
            this.bKw = null;
        }
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.isPubShow && this.bKv != null && this.bAP != null) {
            View preview = this.bAP.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bKv) {
                    ((ViewGroup) preview.getParent()).removeView(this.bAP.getPreview());
                    this.bKv.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bKv.addView(preview, 0, layoutParams);
                }
            }
            this.bAP.startRecord();
            this.bAP.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        if (this.bKo != null) {
            this.bKo.Yg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WR() {
        if (this.bKr != null) {
            this.bKr.SX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WS() {
        if (this.bKr != null) {
            this.bKr.SY();
        }
    }

    @Override // com.baidu.live.am.a
    public boolean WE() {
        return this.bKq != null && (h.gH(this.bKq.Uc()) || h.gI(this.bKq.Uc()));
    }

    @Override // com.baidu.live.am.a
    public boolean Su() {
        if (this.bKq != null && (h.gH(this.bKq.Uc()) || h.gI(this.bKq.Uc()))) {
            if (this.bKr != null) {
                this.bKr.c(this.mTbPageContext, h.gH(this.bKq.Uc()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.am.a
    public void a(com.baidu.live.am.b bVar) {
        this.bKs = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(JSONObject jSONObject) {
        if (this.bKr != null && this.mTbPageContext != null) {
            if (this.bKp != null) {
                this.bKp.hide();
            }
            final com.baidu.live.videochat.d.e ad = com.baidu.live.videochat.d.d.ad(jSONObject);
            this.bKr.a(this.mTbPageContext.getPageActivity(), ad.portrait, ad.userName, new a.InterfaceC0231a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
                public void WX() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
                public void WY() {
                    if (c.this.bKs != null) {
                        c.this.bKs.WJ();
                    }
                    if (c.this.bKo != null) {
                        c.this.bKo.a(c.this.aFN, new com.baidu.live.videochat.f.c(ad.portrait, ad.userName, false));
                    }
                    c.this.bKq.ab(com.baidu.live.videochat.d.d.a(ad, c.this.aFN, com.baidu.live.videochat.d.d.bMb));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
                public void WZ() {
                    c.this.bKq.ac(com.baidu.live.videochat.d.d.a(ad, c.this.aFN, com.baidu.live.videochat.d.d.bMd));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
                public void SQ() {
                    c.this.bKq.ac(com.baidu.live.videochat.d.d.a(ad, c.this.aFN, com.baidu.live.videochat.d.d.bMc));
                }
            });
        }
    }

    @Override // com.baidu.live.am.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bKp != null) {
            return this.bKp.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.am.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bKu != null) {
            this.bKu.listen(this.byU, 0);
        }
        if (this.bKr != null) {
            this.bKr.onDestroy();
        }
        if (this.bKq != null) {
            this.bKq.onDestroy();
        }
        if (this.bKo != null) {
            this.bKo.onDestroy();
        }
        if (this.bKp != null) {
            this.bKp.onDestroy();
        }
        if (this.bKt != null) {
            this.bKt.onDestroy();
        }
    }

    @Override // com.baidu.live.am.a
    public void setMute(boolean z) {
        if (this.bKq != null) {
            this.bKq.setMute(z);
        }
    }

    @Override // com.baidu.live.am.a
    public void WF() {
        if (WE() && this.bKq != null) {
            this.bKq.ds(false);
        }
    }

    @Override // com.baidu.live.am.a
    public void WG() {
        if (this.bKq != null) {
            this.bKq.WG();
        }
    }

    @Override // com.baidu.live.am.a
    public void WH() {
        if (this.bKq != null) {
            this.bKq.WH();
        }
    }
}
