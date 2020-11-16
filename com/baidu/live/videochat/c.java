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
    private w aDh;
    private com.baidu.live.videochat.panel.c bFg;
    private com.baidu.live.ai.b bFj;
    private com.baidu.live.videochat.d.a.a bFk;
    private TelephonyManager bFl;
    private FrameLayout bFm;
    private View bFn;
    private AlaLiveRecorder bvF;
    private TbPageContext mTbPageContext;
    private PhoneStateListener btJ = new PhoneStateListener() { // from class: com.baidu.live.videochat.c.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (c.this.bFh != null) {
                        c.this.bFh.de(false);
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.videochat.panel.a bFo = new com.baidu.live.videochat.panel.a() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.panel.a
        public void b(com.baidu.live.videochat.panel.a.a aVar) {
            if (aVar != null) {
                com.baidu.live.alablmsdk.module.c a2 = c.this.a(aVar);
                JSONObject a3 = com.baidu.live.videochat.d.d.a(c.this.aDh, aVar, com.baidu.live.videochat.d.d.bGS);
                if (c.this.bFh != null && c.this.bFh.b(a2, a3)) {
                    if (c.this.bFf != null) {
                        c.this.bFf.a(c.this.aDh, new com.baidu.live.videochat.f.c(aVar.portrait, aVar.userName, true));
                    }
                    if (c.this.bFg != null) {
                        c.this.bFg.hide();
                    }
                }
            }
        }
    };
    private b.a bFp = new b.a() { // from class: com.baidu.live.videochat.c.4
        @Override // com.baidu.live.videochat.f.b.a
        public void Ur() {
            if (c.this.bFi != null && c.this.bFh != null) {
                c.this.bFi.c(c.this.mTbPageContext, h.gi(c.this.bFh.RE()));
            }
        }
    };
    private b.InterfaceC0226b bFq = new b.InterfaceC0226b() { // from class: com.baidu.live.videochat.c.5
        @Override // com.baidu.live.videochat.f.b.InterfaceC0226b
        public void Us() {
            if (c.this.bFh != null) {
                c.this.bFh.de(true);
            }
        }
    };
    private com.baidu.live.videochat.d.f bFr = new com.baidu.live.videochat.d.f() { // from class: com.baidu.live.videochat.c.6
        @Override // com.baidu.live.videochat.d.f
        public void Ut() {
        }

        @Override // com.baidu.live.videochat.d.f
        public void p(int i, boolean z) {
            BdLog.e("Connect Fail errorCode=" + i + "|isSender=" + z);
            c.this.Up();
            c.this.Uo();
            if (i == com.baidu.live.videochat.d.c.bxa) {
                if (com.baidu.live.videochat.d.d.bGU.equals(com.baidu.live.videochat.d.d.ad(c.this.bFh.Vc()).type)) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_timeout));
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_rejected));
                }
            } else if (i != com.baidu.live.videochat.d.c.bGH) {
                if (i == com.baidu.live.videochat.d.c.bGE || i == com.baidu.live.videochat.d.c.bGF) {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
                } else if (i == com.baidu.live.videochat.d.c.bGG) {
                    if (z) {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_timeout));
                    } else {
                        c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_connected_timeout));
                    }
                } else {
                    c.this.mTbPageContext.showToast(c.this.mTbPageContext.getResources().getString(a.h.video_chat_connected_fail));
                }
            }
            if (c.this.bFg != null && c.this.bFh != null) {
                c.this.bFg.fd(c.this.bFh.RE());
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void B(String str, boolean z) {
            if (c.this.bFk != null && c.this.bFh != null && !z) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bwo = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bHq;
                bVar.bwp = com.baidu.live.videochat.d.a.b.bHs;
                bVar.bwq = TbadkCoreApplication.getCurrentAccount();
                bVar.ext = c.this.bFh.Vc();
                c.this.bFk.a(bVar);
            }
            if (c.this.bFg != null && c.this.bFh != null) {
                c.this.bFg.gl(c.this.bFh.RE());
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
        public void Uu() {
            if (c.this.aDh == null || c.this.aDh.mLiveInfo == null || !c.this.aDh.mLiveInfo.isPubShow) {
                if (c.this.bFf != null && c.this.bFh != null) {
                    c.this.bFf.ag(c.this.bFh.getPlayerView());
                }
            } else if (c.this.bFh == null || c.this.bFn == null || c.this.bFn != c.this.bFh.getPlayerView() || c.this.bFn.getParent() == null || c.this.bFn.getParent() != c.this.bFm) {
                if (c.this.bFn != null && c.this.bFn.getParent() != null) {
                    ((ViewGroup) c.this.bFn.getParent()).removeView(c.this.bFn);
                    c.this.bFn = null;
                }
                if (c.this.bvF != null && c.this.bvF.getPreview() != null && c.this.bFf != null && c.this.bFm != null) {
                    View preview = c.this.bvF.getPreview();
                    c.this.bFm.removeView(preview);
                    c.this.bFf.ag(preview);
                    c.this.bvF.startRecord();
                    c.this.bvF.startPush();
                }
                if (c.this.bFh != null && c.this.bFm != null) {
                    c.this.bFn = c.this.bFh.getPlayerView();
                    if (c.this.bFn != null) {
                        c.this.bFm.addView(c.this.bFn, 0, new FrameLayout.LayoutParams(-1, -1));
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
                c.this.bFh.de(false);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void C(String str, boolean z) {
            BdLog.e("blmsdk:onChatDisConnected isCloseBySelf=" + z);
            c.this.Un();
            c.this.Uq();
            c.this.Uo();
            if (!z) {
                c.this.mTbPageContext.showToast(c.this.mTbPageContext.getString(a.h.video_chat_closed));
            }
            if (c.this.bFg != null && c.this.bFh != null) {
                c.this.bFg.gm(c.this.bFh.RE());
            }
            if (c.this.bFk != null) {
                com.baidu.live.videochat.d.a.b bVar = new com.baidu.live.videochat.d.a.b();
                bVar.bwo = str;
                bVar.action = com.baidu.live.videochat.d.a.b.bHr;
                bVar.bwq = TbadkCoreApplication.getCurrentAccount();
                c.this.bFk.a(bVar);
            }
        }

        @Override // com.baidu.live.videochat.d.f
        public void a(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            if (cVar == null || c.this.bFj == null || !c.this.bFj.Ug()) {
                c.this.bFh.Va();
                return;
            }
            c.this.bFj.Uh();
            c.this.Y(jSONObject);
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
    private com.baidu.live.videochat.d.a bFh = new com.baidu.live.videochat.d.g();
    private com.baidu.live.videochat.f.a bFf = new com.baidu.live.videochat.f.a(this.bFp, this.bFq);
    private com.baidu.live.videochat.c.b bFi = new com.baidu.live.videochat.c.b();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bFg = new com.baidu.live.videochat.panel.c(tbPageContext, this.bFo);
        this.bFk = new com.baidu.live.videochat.d.a.a(tbPageContext);
        aA(tbPageContext.getPageActivity().getApplicationContext());
        this.bFh.init(tbPageContext.getPageActivity());
        this.bFh.a(this.bFr);
        if (this.bFi != null) {
            this.bFi.a(new b.a() { // from class: com.baidu.live.videochat.c.2
                @Override // com.baidu.live.videochat.c.b.a
                public void OZ() {
                    c.this.bFh.de(false);
                    c.this.bFf.VG();
                }
            });
        }
    }

    private void aA(Context context) {
        this.bFl = (TelephonyManager) context.getSystemService("phone");
        if (this.bFl != null) {
            this.bFl.listen(this.btJ, 32);
        }
    }

    @Override // com.baidu.live.ai.a
    public void u(ViewGroup viewGroup) {
        this.bFg.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ai.a
    public void v(ViewGroup viewGroup) {
        this.bFf.a(this.mTbPageContext, viewGroup);
    }

    @Override // com.baidu.live.ai.a
    public void L(Object obj) {
        if (this.bFh != null && (obj instanceof AlaLiveRecorder)) {
            this.bvF = (AlaLiveRecorder) obj;
            this.bFh.a(this.bvF);
        }
    }

    @Override // com.baidu.live.ai.a
    public void a(FrameLayout frameLayout) {
        this.bFm = frameLayout;
    }

    @Override // com.baidu.live.ai.a
    public void s(w wVar) {
        this.aDh = wVar;
        if (this.bFh != null) {
            this.bFh.s(wVar);
        }
        if (this.bFi != null) {
            this.bFi.ba(this.aDh.mLiveInfo.videoBBChatData.acceptWindowTime);
        }
    }

    @Override // com.baidu.live.ai.a
    public void Ud() {
        String str = null;
        if (this.bFh.Vb() != null) {
            str = String.valueOf(this.bFh.Vb().azK);
        }
        this.bFg.W(this.bFh.RE(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.alablmsdk.module.c a(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.azP = UserPermission.VISITER;
        cVar.azK = JavaTypesHelper.toLong(aVar.bIr, 0L);
        cVar.azQ = aVar.bIs;
        cVar.userName = aVar.userName;
        cVar.appId = JavaTypesHelper.toLong(aVar.appId, 0L);
        cVar.appVersion = aVar.bIq;
        cVar.cuid = aVar.cuid;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Un() {
        if (this.bFn != null && this.bFn.getParent() != null) {
            ((ViewGroup) this.bFn.getParent()).removeView(this.bFn);
            this.bFn = null;
        }
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.isPubShow && this.bFm != null && this.bvF != null) {
            View preview = this.bvF.getPreview();
            if (preview != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (preview.getParent() != null && preview.getParent() != this.bFm) {
                    ((ViewGroup) preview.getParent()).removeView(this.bvF.getPreview());
                    this.bFm.addView(preview, 0, layoutParams);
                } else if (preview.getParent() == null) {
                    this.bFm.addView(preview, 0, layoutParams);
                }
            }
            this.bvF.startRecord();
            this.bvF.startPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo() {
        if (this.bFf != null) {
            this.bFf.VG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Up() {
        if (this.bFi != null) {
            this.bFi.Qz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        if (this.bFi != null) {
            this.bFi.QA();
        }
    }

    @Override // com.baidu.live.ai.a
    public boolean Ue() {
        return this.bFh != null && (h.gi(this.bFh.RE()) || h.gj(this.bFh.RE()));
    }

    @Override // com.baidu.live.ai.a
    public boolean PW() {
        if (this.bFh != null && (h.gi(this.bFh.RE()) || h.gj(this.bFh.RE()))) {
            if (this.bFi != null) {
                this.bFi.c(this.mTbPageContext, h.gi(this.bFh.RE()));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.ai.a
    public void a(com.baidu.live.ai.b bVar) {
        this.bFj = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(JSONObject jSONObject) {
        if (this.bFi != null && this.mTbPageContext != null) {
            if (this.bFg != null) {
                this.bFg.hide();
            }
            final com.baidu.live.videochat.d.e ab = com.baidu.live.videochat.d.d.ab(jSONObject);
            this.bFi.a(this.mTbPageContext.getPageActivity(), ab.portrait, ab.userName, new a.InterfaceC0222a() { // from class: com.baidu.live.videochat.c.7
                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void Uv() {
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void Uw() {
                    if (c.this.bFj != null) {
                        c.this.bFj.Uh();
                    }
                    if (c.this.bFf != null) {
                        c.this.bFf.a(c.this.aDh, new com.baidu.live.videochat.f.c(ab.portrait, ab.userName, false));
                    }
                    c.this.bFh.Z(com.baidu.live.videochat.d.d.a(ab, c.this.aDh, com.baidu.live.videochat.d.d.bGT));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void Ux() {
                    c.this.bFh.aa(com.baidu.live.videochat.d.d.a(ab, c.this.aDh, com.baidu.live.videochat.d.d.bGV));
                }

                @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
                public void Qs() {
                    c.this.bFh.aa(com.baidu.live.videochat.d.d.a(ab, c.this.aDh, com.baidu.live.videochat.d.d.bGU));
                }
            });
        }
    }

    @Override // com.baidu.live.ai.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bFg != null) {
            return this.bFg.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.live.ai.a
    public void onDestroy() {
        this.mTbPageContext = null;
        if (this.bFl != null) {
            this.bFl.listen(this.btJ, 0);
        }
        if (this.bFi != null) {
            this.bFi.onDestroy();
        }
        if (this.bFh != null) {
            this.bFh.onDestroy();
        }
        if (this.bFf != null) {
            this.bFf.onDestroy();
        }
        if (this.bFg != null) {
            this.bFg.onDestroy();
        }
        if (this.bFk != null) {
            this.bFk.onDestroy();
        }
    }

    @Override // com.baidu.live.ai.a
    public void setMute(boolean z) {
        if (this.bFh != null) {
            this.bFh.setMute(z);
        }
    }

    @Override // com.baidu.live.ai.a
    public void Uf() {
        if (Ue() && this.bFh != null) {
            this.bFh.de(false);
        }
    }
}
