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
/* loaded from: classes11.dex */
public class c implements com.baidu.live.an.a {
    private x aGe;
    private AlaLiveRecorder bFC;
    private com.baidu.live.videochat.panel.c bPc;
    private com.baidu.live.an.b bPf;
    private com.baidu.live.videochat.d.a.a bPg;
    private TelephonyManager bPh;
    private FrameLayout bPi;
    private View bPj;
    private TbPageContext mTbPageContext;
    private PhoneStateListener bDG = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bPd != null) {
                        c.this.bPd.dv(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bPk = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                JSONObject a3 = com.baidu.live.videochat.d.d.a(c.this.aGe, aVar, com.baidu.live.videochat.d.d.bQN);
                if (c.this.bPd != null && c.this.bPd.b(a2, a3)) {
                    if (c.this.bPb != null) {
                        c.this.bPb.a(c.this.aGe, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, aVar.userId, true));
                    }
                    if (c.this.bPc != null) {
                        c.this.bPc.hide();
                    }
                    if (c.this.bPf != null) {
                        c.this.bPf.XP();
                    }
                }
            }
        }
    };
    private b.a bPl = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void Ya() {
            if (c.this.bPe != null && c.this.bPd != null) {
                c.this.bPe.a(c.this.mTbPageContext, h.gI(c.this.bPd.Vh()));
            }
        }
    };
    private b.InterfaceC0233b bPm = new b.InterfaceC0233b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0233b
        public void Yb() {
            if (c.this.bPd != null) {
                c.this.bPd.dv(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bPn = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void Yc() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.XY();
            c.this.XX();
            if (c.this.bPf != null) {
                c.this.bPf.XQ();
            }
            if (i == com.baidu.live.videochat.d.c.bGV) {
                if (com.baidu.live.videochat.d.d.bQP.equals(com.baidu.live.videochat.d.d.an(c.this.bPd.YJ()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_rejected));
                }
            } else if (i != com.baidu.live.videochat.d.c.bQC) {
                if (i == com.baidu.live.videochat.d.c.bQz || i == com.baidu.live.videochat.d.c.bQA) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
                } else if (i == com.baidu.live.videochat.d.c.bQB) {
                    if (z) {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_timeout));
                    } else {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_connected_timeout));
                    }
                } else if (i == com.baidu.live.videochat.d.c.bGT) {
                    if (c.this.bPg != null && c.this.bPd != null) {
                        com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                        bVar.bGl = c.this.bPd.YK();
                        bVar.action = com.baidu.live.videochat.d.a.b.bRm;
                        bVar.bGn = TbadkCoreApplication.getCurrentAccount();
                        c.this.bPg.a(bVar);
                    }
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_connected_fail));
                }
            }
            if (c.this.bPc != null && c.this.bPd != null) {
                c.this.bPc.fC(c.this.bPd.Vh());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            if (c.this.bPg != null && c.this.bPd != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bGl = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bRl;
                bVar.bGm = com.baidu.live.videochat.d.a.b.bRn;
                bVar.bGn = TbadkCoreApplication.getCurrentAccount();
                bVar.bGq = c.this.bPd.YJ();
                c.this.bPg.a(bVar);
            }
            if (c.this.bPc != null && c.this.bPd != null) {
                c.this.bPc.gL(c.this.bPd.Vh());
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
        public void Yd() {
            if (c.this.aGe == null || c.this.aGe.mLiveInfo == null || !c.this.aGe.mLiveInfo.isPubShow) {
                if (c.this.bPb != null && c.this.bPd != null) {
                    c.this.bPb.ag(c.this.bPd.Pp());
                }
            } else if (c.this.bPd == null || c.this.bPj == null || c.this.bPj != c.this.bPd.Pp() || c.this.bPj.getParent() == null || c.this.bPj.getParent() != c.this.bPi) {
                if (c.this.bPj != null && c.this.bPj.getParent() != null) {
                    ((ViewGroup) c.this.bPj.getParent()).removeView(c.this.bPj);
                    c.this.bPj = null;
                }
                if (c.this.bFC != null && c.this.bFC.getPreview() != null && c.this.bPb != null && c.this.bPi != null) {
                    View preview = c.this.bFC.getPreview();
                    c.this.bPi.removeView(preview);
                    c.this.bPb.ag(preview);
                    c.this.bFC.startRecord();
                    c.this.bFC.startPush();
                }
                if (c.this.bPd != null && c.this.bPi != null) {
                    c.this.bPj = c.this.bPd.Pp();
                    if (c.this.bPj != null) {
                        c.this.bPi.addView(c.this.bPj, 0, new FrameLayout.LayoutParams(-1, -1));
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
                c.this.bPd.dv(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void D(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            c.this.XW();
            c.this.XZ();
            c.this.XX();
            if (c.this.bPf != null) {
                c.this.bPf.XQ();
            }
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            }
            if (c.this.bPc != null && c.this.bPd != null) {
                c.this.bPc.gM(c.this.bPd.Vh());
            }
            if (c.this.bPg != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bGl = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bRm;
                bVar.bGn = TbadkCoreApplication.getCurrentAccount();
                c.this.bPg.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            if (cVar == null || c.this.bPf == null || !c.this.bPf.XN()) {
                c.this.bPd.YH();
                return;
            }
            c.this.bPf.XO();
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
    private com.baidu.live.videochat.d.a bPd = new com.baidu.live.videochat.d.g();
    private com.baidu.live.videochat.f.a bPb = new com.baidu.live.videochat.f.a(this.bPl, this.bPm);
    private com.baidu.live.videochat.c.b bPe = new com.baidu.live.videochat.c.b();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bPc = new com.baidu.live.videochat.panel.c(tbPageContext, this.bPk);
        this.bPg = new com.baidu.live.videochat.d.a.a(tbPageContext);
        bd(tbPageContext.getPageActivity().getApplicationContext());
        this.bPd.init(tbPageContext.getPageActivity());
        this.bPd.a(this.bPn);
        if (this.bPe != null) {
            this.bPe.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void Sw() {
                    c.this.bPd.dv(false);
                    c.this.bPb.Zo();
                }
            });
        }
    }

    private void bd(Context context) {
        this.bPh = (TelephonyManager) context.getSystemService("phone");
        if (this.bPh != null) {
            this.bPh.listen(this.bDG, 32);
        }
    }

    @Override // com.baidu.live.an.a
    public void x(ViewGroup viewGroup) {
        this.bPc.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.an.a
    public void y(ViewGroup viewGroup) {
        this.bPb.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.an.a
    public void H(Object obj) {
        if (this.bPd != null && (obj instanceof AlaLiveRecorder)) {
            this.bFC = (AlaLiveRecorder) obj;
            this.bPd.a(this.bFC);
        }
    }

    @Override // com.baidu.live.an.a
    public void a(FrameLayout frameLayout) {
        this.bPi = frameLayout;
    }

    @Override // com.baidu.live.an.a
    public void t(x xVar) {
        this.aGe = xVar;
        if (this.bPd != null) {
            this.bPd.t(xVar);
        }
        if (this.bPe != null) {
            this.bPe.by(this.aGe.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.an.a
    public void XI() {
        String str = null;
        if (this.bPd.YI() != null) {
            str = String.valueOf(this.bPd.YI().aCG);
        }
        this.bPc.Y(this.bPd.Vh(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aCL = UserPermission.VISITER;
        cVar.aCG = JavaTypesHelper.toLong(aVar.bSm, 0L);
        cVar.aCM = aVar.bSn;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bSl;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XW() {
        if (this.bPj != null && this.bPj.getParent() != null) {
            ((ViewGroup) this.bPj.getParent()).removeView(this.bPj);
            this.bPj = null;
        }
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.isPubShow && this.bPi != null && this.bFC != null) {
            View preview = this.bFC.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bPi) {
                    ((ViewGroup) preview.getParent()).removeView(this.bFC.getPreview());
                    this.bPi.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bPi.addView(preview, 0, layoutParams);
                }
            }
            this.bFC.startRecord();
            this.bFC.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XX() {
        if (this.bPb != null) {
            this.bPb.Zo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XY() {
        if (this.bPe != null) {
            this.bPe.Uc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XZ() {
        if (this.bPe != null) {
            this.bPe.Ud();
        }
    }

    @Override // com.baidu.live.an.a
    public boolean XJ() {
        return this.bPd != null && (h.gI(this.bPd.Vh()) || h.gJ(this.bPd.Vh()));
    }

    @Override // com.baidu.live.an.a
    public boolean Ty() {
        if (this.bPd != null && (h.gI(this.bPd.Vh()) || h.gJ(this.bPd.Vh()))) {
            if (this.bPe != null) {
                this.bPe.a(this.mTbPageContext, h.gI(this.bPd.Vh()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.an.a
    public void a(com.baidu.live.an.b bVar) {
        this.bPf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(JSONObject jSONObject) {
        if (this.bPe != null && this.mTbPageContext != null) {
            if (this.bPc != null) {
                this.bPc.hide();
            }
            final com.baidu.live.videochat.d.e al = com.baidu.live.videochat.d.d.al(jSONObject);
            this.bPe.a(this.mTbPageContext.getPageActivity(), al.portrait, al.userName, new a.InterfaceC0229a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
                public void Ye() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
                public void Yf() {
                    if (c.this.bPf != null) {
                        c.this.bPf.XO();
                    }
                    if (c.this.bPb != null) {
                        c.this.bPb.a(c.this.aGe, new com.baidu.live.videochat.f.c(al.portrait, al.userName, al.userId, false));
                        if (c.this.bPf != null) {
                            c.this.bPf.XP();
                        }
                    }
                    c.this.bPd.aj(com.baidu.live.videochat.d.d.a(al, c.this.aGe, com.baidu.live.videochat.d.d.bQO));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
                public void Yg() {
                    c.this.bPd.ak(com.baidu.live.videochat.d.d.a(al, c.this.aGe, com.baidu.live.videochat.d.d.bQQ));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
                public void TX() {
                    c.this.bPd.ak(com.baidu.live.videochat.d.d.a(al, c.this.aGe, com.baidu.live.videochat.d.d.bQP));
                }
            });
        }
    }

    @Override // com.baidu.live.an.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bPc != null) {
            return this.bPc.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.an.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bPh != null) {
            this.bPh.listen(this.bDG, 0);
        }
        if (this.bPe != null) {
            this.bPe.onDestroy();
        }
        if (this.bPd != null) {
            this.bPd.onDestroy();
        }
        if (this.bPb != null) {
            this.bPb.onDestroy();
        }
        if (this.bPc != null) {
            this.bPc.onDestroy();
        }
        if (this.bPg != null) {
            this.bPg.onDestroy();
        }
    }

    @Override // com.baidu.live.an.a
    public void setMute(boolean z) {
        if (this.bPd != null) {
            this.bPd.setMute(z);
        }
    }

    @Override // com.baidu.live.an.a
    public void XK() {
        if (XJ() && this.bPd != null) {
            this.bPd.dv(false);
        }
    }

    @Override // com.baidu.live.an.a
    public void XL() {
        if (this.bPd != null) {
            this.bPd.XL();
        }
    }

    @Override // com.baidu.live.an.a
    public void XM() {
        if (this.bPd != null) {
            this.bPd.XM();
        }
    }

    @Override // com.baidu.live.an.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (XJ()) {
            this.bPb.onKeyboardVisibilityChanged(z);
        }
    }
}
