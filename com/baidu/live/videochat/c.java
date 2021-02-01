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
/* loaded from: classes11.dex */
public class c implements com.baidu.live.al.a {
    private ab aDd;
    private AlaLiveRecorder bEw;
    private com.baidu.live.videochat.panel.c bOa;
    private com.baidu.live.al.b bOd;
    private com.baidu.live.videochat.d.a.a bOe;
    private TelephonyManager bOf;
    private FrameLayout bOg;
    private View bOh;
    private TbPageContext mTbPageContext;
    private PhoneStateListener bCA = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bOb != null) {
                        c.this.bOb.dz(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bOi = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                JSONObject a3 = com.baidu.live.videochat.d.d.a(c.this.aDd, aVar, com.baidu.live.videochat.d.d.bPM);
                if (c.this.bOb != null && c.this.bOb.b(a2, a3)) {
                    if (c.this.bNZ != null) {
                        c.this.bNZ.a(c.this.aDd, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, aVar.userId, true));
                    }
                    if (c.this.bOa != null) {
                        c.this.bOa.hide();
                    }
                    if (c.this.bOd != null) {
                        c.this.bOd.VF();
                    }
                }
            }
        }
    };
    private b.a bOj = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void VQ() {
            if (c.this.bOc != null && c.this.bOb != null) {
                c.this.bOc.a(c.this.mTbPageContext, h.ff(c.this.bOb.SV()));
            }
        }
    };
    private b.InterfaceC0226b bOk = new b.InterfaceC0226b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0226b
        public void VR() {
            if (c.this.bOb != null) {
                c.this.bOb.dz(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bOl = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void VS() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.VO();
            c.this.VN();
            if (c.this.bOd != null) {
                c.this.bOd.VG();
            }
            if (i == com.baidu.live.videochat.d.c.bFS) {
                if (com.baidu.live.videochat.d.d.bPO.equals(com.baidu.live.videochat.d.d.ap(c.this.bOb.Wz()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_rejected));
                }
            } else if (i == com.baidu.live.videochat.d.c.bPB) {
                Log.d("bugbye", "bugbye");
            } else if (i == com.baidu.live.videochat.d.c.bPy || i == com.baidu.live.videochat.d.c.bPz) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            } else if (i == com.baidu.live.videochat.d.c.bPA) {
                if (z) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_connected_timeout));
                }
            } else if (i == com.baidu.live.videochat.d.c.bFQ) {
                if (c.this.bOe != null && c.this.bOb != null) {
                    com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                    bVar.bFf = c.this.bOb.WA();
                    bVar.action = com.baidu.live.videochat.d.a.b.bQq;
                    bVar.bFh = TbadkCoreApplication.getCurrentAccount();
                    c.this.bOe.a(bVar);
                }
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            } else {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_connected_fail));
            }
            if (c.this.bOa != null && c.this.bOb != null) {
                c.this.bOa.ea(c.this.bOb.SV());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            if (c.this.bOe != null && c.this.bOb != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bFf = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bQp;
                bVar.bFg = com.baidu.live.videochat.d.a.b.bQr;
                bVar.bFh = TbadkCoreApplication.getCurrentAccount();
                bVar.bFk = c.this.bOb.Wz();
                c.this.bOe.a(bVar);
            }
            if (c.this.bOa != null && c.this.bOb != null) {
                c.this.bOa.fi(c.this.bOb.SV());
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
        public void VT() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            if (c.this.aDd == null || c.this.aDd.mLiveInfo == null || !c.this.aDd.mLiveInfo.isPubShow) {
                if (c.this.bNZ != null && c.this.bOb != null) {
                    c.this.bNZ.ag(c.this.bOb.MS());
                }
            } else if (c.this.bOb == null || c.this.bOh == null || c.this.bOh != c.this.bOb.MS() || c.this.bOh.getParent() == null || c.this.bOh.getParent() != c.this.bOg) {
                if (c.this.bOh != null && c.this.bOh.getParent() != null) {
                    ((ViewGroup) c.this.bOh.getParent()).removeView(c.this.bOh);
                    c.this.bOh = null;
                }
                if (c.this.bEw != null && c.this.bEw.getPreview() != null && c.this.bNZ != null && c.this.bOg != null) {
                    View preview = c.this.bEw.getPreview();
                    c.this.bOg.removeView(preview);
                    c.this.bNZ.ag(preview);
                    c.this.bEw.startRecord();
                    c.this.bEw.startPush();
                }
                if (c.this.bOb != null && c.this.bOg != null) {
                    c.this.bOh = c.this.bOb.MS();
                    if (c.this.bOh != null) {
                        c.this.bOg.addView(c.this.bOh, 0, new FrameLayout.LayoutParams(-1, -1));
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
                c.this.bOb.dz(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void D(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
            c.this.VM();
            c.this.VP();
            c.this.VN();
            if (c.this.bOd != null) {
                c.this.bOd.VG();
            }
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            }
            if (c.this.bOa != null && c.this.bOb != null) {
                c.this.bOa.fj(c.this.bOb.SV());
            }
            if (c.this.bOe != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bFf = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bQq;
                bVar.bFh = TbadkCoreApplication.getCurrentAccount();
                c.this.bOe.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            if (cVar == null || c.this.bOd == null || !c.this.bOd.VD()) {
                c.this.bOb.Wx();
                return;
            }
            c.this.bOd.VE();
            c.this.ak(jSONObject);
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
    private com.baidu.live.videochat.d.a bOb = new com.baidu.live.videochat.d.g();
    private com.baidu.live.videochat.f.a bNZ = new com.baidu.live.videochat.f.a(this.bOj, this.bOk);
    private com.baidu.live.videochat.c.b bOc = new com.baidu.live.videochat.c.b();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bOa = new com.baidu.live.videochat.panel.c(tbPageContext, this.bOi);
        this.bOe = new com.baidu.live.videochat.d.a.a(tbPageContext);
        bc(tbPageContext.getPageActivity().getApplicationContext());
        this.bOb.init(tbPageContext.getPageActivity());
        this.bOb.a(this.bOl);
        if (this.bOc != null) {
            this.bOc.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void Qa() {
                    c.this.bOb.dz(false);
                    c.this.bNZ.Xe();
                }
            });
        }
    }

    private void bc(Context context) {
        this.bOf = (TelephonyManager) context.getSystemService("phone");
        if (this.bOf != null) {
            this.bOf.listen(this.bCA, 32);
        }
    }

    @Override // com.baidu.live.al.a
    public void v(ViewGroup viewGroup) {
        this.bOa.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.al.a
    public void w(ViewGroup viewGroup) {
        this.bNZ.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.al.a
    public void H(Object obj) {
        if (this.bOb != null && (obj instanceof AlaLiveRecorder)) {
            this.bEw = (AlaLiveRecorder) obj;
            this.bOb.a(this.bEw);
        }
    }

    @Override // com.baidu.live.al.a
    public void a(FrameLayout frameLayout) {
        this.bOg = frameLayout;
    }

    @Override // com.baidu.live.al.a
    public void t(ab abVar) {
        this.aDd = abVar;
        if (this.bOb != null) {
            this.bOb.t(abVar);
        }
        if (this.bOc != null) {
            this.bOc.bC(this.aDd.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.al.a
    public void Vx() {
        String str = null;
        if (this.bOb.Wy() != null) {
            str = String.valueOf(this.bOb.Wy().ayk);
        }
        this.bOa.ad(this.bOb.SV(), str);
    }

    @Override // com.baidu.live.al.a
    public void VC() {
        com.baidu.live.alablmsdk.a.b.a.ba(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.ayp = UserPermission.VISITER;
        cVar.ayk = JavaTypesHelper.toLong(aVar.bRq, 0L);
        cVar.ayq = aVar.bRr;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bRp;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VM() {
        if (this.bOh != null && this.bOh.getParent() != null) {
            ((ViewGroup) this.bOh.getParent()).removeView(this.bOh);
            this.bOh = null;
        }
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.isPubShow && this.bOg != null && this.bEw != null) {
            View preview = this.bEw.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bOg) {
                    ((ViewGroup) preview.getParent()).removeView(this.bEw.getPreview());
                    this.bOg.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bOg.addView(preview, 0, layoutParams);
                }
            }
            this.bEw.startRecord();
            this.bEw.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VN() {
        if (this.bNZ != null) {
            this.bNZ.Xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VO() {
        if (this.bOc != null) {
            this.bOc.RR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VP() {
        if (this.bOc != null) {
            this.bOc.RS();
        }
    }

    @Override // com.baidu.live.al.a
    public boolean Vy() {
        return this.bOb != null && (h.ff(this.bOb.SV()) || h.fg(this.bOb.SV()));
    }

    @Override // com.baidu.live.al.a
    public boolean Rn() {
        if (this.bOb != null && (h.ff(this.bOb.SV()) || h.fg(this.bOb.SV()))) {
            if (this.bOc != null) {
                this.bOc.a(this.mTbPageContext, h.ff(this.bOb.SV()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.al.a
    public void a(com.baidu.live.al.b bVar) {
        this.bOd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(JSONObject jSONObject) {
        if (this.bOc != null && this.mTbPageContext != null) {
            if (this.bOa != null) {
                this.bOa.hide();
            }
            final com.baidu.live.videochat.d.e an = com.baidu.live.videochat.d.d.an(jSONObject);
            this.bOc.a(this.mTbPageContext.getPageActivity(), an.portrait, an.userName, new a.InterfaceC0222a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void VU() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void VV() {
                    if (c.this.bOd != null) {
                        c.this.bOd.VE();
                    }
                    if (c.this.bNZ != null) {
                        c.this.bNZ.a(c.this.aDd, new com.baidu.live.videochat.f.c(an.portrait, an.userName, an.userId, false));
                        if (c.this.bOd != null) {
                            c.this.bOd.VF();
                        }
                    }
                    c.this.bOb.al(com.baidu.live.videochat.d.d.a(an, c.this.aDd, com.baidu.live.videochat.d.d.bPN));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void VW() {
                    c.this.bOb.am(com.baidu.live.videochat.d.d.a(an, c.this.aDd, com.baidu.live.videochat.d.d.bPP));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void RM() {
                    c.this.bOb.am(com.baidu.live.videochat.d.d.a(an, c.this.aDd, com.baidu.live.videochat.d.d.bPO));
                }
            });
        }
    }

    @Override // com.baidu.live.al.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bOa != null) {
            return this.bOa.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.al.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bOf != null) {
            this.bOf.listen(this.bCA, 0);
        }
        if (this.bOc != null) {
            this.bOc.onDestroy();
        }
        if (this.bOb != null) {
            this.bOb.onDestroy();
        }
        if (this.bNZ != null) {
            this.bNZ.onDestroy();
        }
        if (this.bOa != null) {
            this.bOa.onDestroy();
        }
        if (this.bOe != null) {
            this.bOe.onDestroy();
        }
    }

    @Override // com.baidu.live.al.a
    public void setMute(boolean z) {
        if (this.bOb != null) {
            this.bOb.setMute(z);
        }
    }

    @Override // com.baidu.live.al.a
    public void Vz() {
        if (Vy() && this.bOb != null) {
            this.bOb.dz(false);
        }
    }

    @Override // com.baidu.live.al.a
    public void VA() {
        if (this.bOb != null) {
            this.bOb.VA();
        }
    }

    @Override // com.baidu.live.al.a
    public void VB() {
        if (this.bOb != null) {
            this.bOb.VB();
        }
    }

    @Override // com.baidu.live.al.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (Vy()) {
            this.bNZ.onKeyboardVisibilityChanged(z);
        }
    }
}
