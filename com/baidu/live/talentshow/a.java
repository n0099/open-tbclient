package com.baidu.live.talentshow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.b.c;
import com.baidu.live.talentshow.components.a.b;
import com.baidu.live.talentshow.components.b.a;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.talentshow.components.selector.d;
import com.baidu.live.talentshow.d.f;
import com.baidu.live.talentshow.d.g;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.aj.b {
    private w aDh;
    private AlaLiveRecorder bsP;
    private FrameLayout bsQ;
    private com.baidu.live.talentshow.components.enter.a bsR;
    private TelephonyManager bsS;
    private com.baidu.live.talentshow.d.a bsT;
    private d bsU;
    private com.baidu.live.talentshow.components.b.b bsV;
    private com.baidu.live.talentshow.components.a.b bsW;
    private com.baidu.live.talentshow.components.selector.b bsX;
    private com.baidu.live.talentshow.model.d bsY;
    private View bsZ;
    private com.baidu.live.talentshow.components.a.b bta;
    private com.baidu.live.aj.a btb;
    private TbPageContext mPageContext;
    private b.a btc = new b.a() { // from class: com.baidu.live.talentshow.a.1
        @Override // com.baidu.live.talentshow.components.a.b.a
        public void OZ() {
            if (a.this.bsT != null) {
                a.this.bsT.Rv();
            }
        }

        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Pa() {
        }
    };
    private com.baidu.live.talentshow.c.b btd = new com.baidu.live.talentshow.c.b() { // from class: com.baidu.live.talentshow.a.3
        @Override // com.baidu.live.talentshow.c.b
        public void Z(List<com.baidu.live.talentshow.b.d> list) {
            a.this.bsU.ac(a.this.Y(list));
        }

        @Override // com.baidu.live.talentshow.c.b
        public void v(int i, String str) {
            a.this.ie(str);
        }
    };
    private com.baidu.live.talentshow.c.a bte = new com.baidu.live.talentshow.c.a() { // from class: com.baidu.live.talentshow.a.4
        @Override // com.baidu.live.talentshow.c.a
        public void a(int i, String str, com.baidu.live.talentshow.b.d dVar) {
            if (i == 1) {
                a.this.a(dVar);
                return;
            }
            a.this.ie(str);
            a.this.PZ();
        }

        @Override // com.baidu.live.talentshow.c.a
        public void w(int i, String str) {
            a.this.ie(str);
        }
    };
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() { // from class: com.baidu.live.talentshow.a.5
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (a.this.bsT != null) {
                        a.this.bsT.Rv();
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.talentshow.components.enter.b btf = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.a.6
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (a.this.PX()) {
                a.this.PY();
            }
            com.baidu.live.talentshow.e.a.RY();
        }
    };
    private LiveBCMasterChatSelectorLayer.a btg = new LiveBCMasterChatSelectorLayer.a() { // from class: com.baidu.live.talentshow.a.7
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Qa() {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a.this.PZ();
            }
            com.baidu.live.talentshow.e.a.RX();
        }

        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Qb() {
        }
    };
    private LiveBCMasterChatSelectorLayer.b bth = new LiveBCMasterChatSelectorLayer.b() { // from class: com.baidu.live.talentshow.a.8
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.b
        public void b(com.baidu.live.talentshow.b.d dVar) {
            long j;
            long j2 = 0;
            if (dVar.status == 5) {
                a.this.ie(a.this.mPageContext.getString(a.h.talent_chat_queue_is_full));
                return;
            }
            if (a.this.bsX != null) {
                if (a.this.bsT != null) {
                    j = a.this.bsT.fk(1);
                    j2 = a.this.bsT.fk(2);
                } else {
                    j = 0;
                }
                a.this.bsX.a(dVar, j, j2);
            }
            com.baidu.live.talentshow.e.a.RW();
        }
    };
    private a.InterfaceC0200a bti = new a.InterfaceC0200a() { // from class: com.baidu.live.talentshow.a.9
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0200a
        public void a(View view, int i, final long j) {
            if (a.this.bsW == null) {
                a.this.bsW = new com.baidu.live.talentshow.components.a.b();
            }
            String G = com.baidu.live.videochat.d.G(a.this.bsT.aM(j), 16);
            Resources resources = a.this.mPageContext.getResources();
            int i2 = a.h.linkmic_close_confirm_with_user_name;
            Object[] objArr = new Object[1];
            if (G == null) {
                G = "";
            }
            objArr[0] = G;
            a.this.bsW.a(a.this.mPageContext, resources.getString(i2, objArr), new b.a() { // from class: com.baidu.live.talentshow.a.9.1
                @Override // com.baidu.live.talentshow.components.a.b.a
                public void OZ() {
                    if (a.this.bsT != null) {
                        a.this.bsT.aL(j);
                    }
                }

                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Pa() {
                }
            });
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0200a
        public void b(View view, boolean z) {
        }
    };
    private f btj = new f() { // from class: com.baidu.live.talentshow.a.10
        @Override // com.baidu.live.talentshow.d.f
        public void d(String str, JSONObject jSONObject) {
            a.this.c(str, jSONObject);
        }

        @Override // com.baidu.live.talentshow.d.f
        public void Qc() {
            a.this.bsV.d(a.this.bsQ);
            a.this.bsV.QG();
            if (a.this.bsZ != null) {
                a.this.bsZ.setEnabled(false);
            }
            if (a.this.bsP != null && a.this.bsP.getPreview() != null && a.this.bsP.getPreview().getParent() != null) {
                ((ViewGroup) a.this.bsP.getPreview().getParent()).removeView(a.this.bsP.getPreview());
                a.this.bsQ.addView(a.this.bsP.getPreview());
            }
            a.this.bsV.a(a.this.bsP.getPreview(), 0, 0L, true, false);
            a.this.bsP.startRecord();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void aH(long j) {
            a.this.PZ();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void c(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStopChatResult imUK=" + j + " index=" + i + " erroCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bxb && a.this.bsV != null) {
                a.this.bsV.fi(i);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void d(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStartChatResult imUK=" + j + " index=" + i + " errorCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bwU) {
                a.this.ie(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bwV) {
                a.this.ie(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bxa) {
                a.this.ie(a.this.mPageContext.getString(a.h.talent_invite_timeout));
                if (a.this.bsV != null) {
                    a.this.bsV.fi(i);
                }
            } else if (i2 == 0) {
                a.this.bsV.a(i, j, true, true);
                a.this.PZ();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void E(String str, int i) {
            if (i == com.baidu.live.talentshow.d.d.bwW) {
                a.this.ie(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i == com.baidu.live.talentshow.d.d.bwX) {
                a.this.ie(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i == com.baidu.live.talentshow.d.d.bwZ) {
                a.this.ie(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
            a.this.PZ();
        }

        @Override // com.baidu.live.talentshow.d.f
        /* renamed from: if  reason: not valid java name */
        public void mo22if(String str) {
            if (a.this.bsU != null) {
                if (a.this.bsT.isFull()) {
                    a.this.bsU.QZ();
                    return;
                }
                a.this.bsU.ac(a.this.Y(a.this.bsU.QY()));
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void f(long j, int i) {
            View aK = a.this.bsT.aK(j);
            BdLog.e("BCVideoChat blmsdk" + aK + "|imuk=" + j + "|index=" + i);
            if (aK != null) {
                a.this.bsV.a(aK, i, j, true, false);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(com.baidu.live.talentshow.d.a.b bVar, int i) {
            if (i >= 15 && a.this.bsV != null) {
                a.this.bsV.fi(bVar.index);
                a.this.bsT.aL(bVar.bxu.azK);
                String string = a.this.mPageContext.getString(a.h.talent_close_chat);
                if (a.this.bsU == null) {
                    a.this.mPageContext.showToast(string);
                    return;
                }
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.G(a.this.bsU.aI(bVar.bxu.azK), 16) + string);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void g(long j, int i) {
            if (a.this.bsV != null) {
                a.this.bsV.fi(i);
            }
            if (a.this.bsU != null) {
                a.this.bsU.QZ();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void h(long j, int i) {
            if (a.this.bsV != null) {
                a.this.bsV.fi(i);
            }
            String string = a.this.mPageContext.getString(a.h.talent_close_chat);
            if (a.this.bsU == null) {
                a.this.mPageContext.showToast(string);
            } else {
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.G(a.this.bsU.aI(j), 16) + string);
            }
            if (a.this.bsU != null) {
                a.this.bsU.QZ();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void fc(int i) {
            if (i >= 15 && a.this.bsT != null) {
                a.this.bsT.Rv();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(c cVar) {
            if (a.this.bsY != null) {
                a.this.bsY.c(cVar);
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        com.baidu.live.alablmsdk.b.bb(TbadkCoreApplication.getInst().isDebugMode());
        this.mPageContext = tbPageContext;
        this.bsY = new com.baidu.live.talentshow.model.d(tbPageContext);
        this.bsX = new com.baidu.live.talentshow.components.selector.b(tbPageContext);
        this.bsX.a(this.btd);
        this.bsX.a(this.bte);
        this.bsT = new g();
        this.bsT.init(tbPageContext.getPageActivity());
        this.bsT.a(this.btj);
        this.bsV = new com.baidu.live.talentshow.components.b.b(tbPageContext.getPageActivity(), this.bti);
        this.bsR = new com.baidu.live.talentshow.components.enter.a(tbPageContext, true);
        this.bsR.a(this.btf);
        aA(tbPageContext.getPageActivity());
        BdLog.e("BCVideoChat  cuid=" + TbadkCoreApplication.getInst().getCuid() + " imUK=" + AccountManager.getUK(TbadkCoreApplication.getInst()));
    }

    @Override // com.baidu.live.aj.b
    public void L(Object obj) {
        if (this.bsT != null && (obj instanceof AlaLiveRecorder)) {
            this.bsT.a((AlaLiveRecorder) obj);
            this.bsP = (AlaLiveRecorder) obj;
        }
    }

    @Override // com.baidu.live.aj.b
    public void setLiveShowData(w wVar) {
        this.aDh = wVar;
        if (this.bsX != null) {
            this.bsX.t(this.aDh);
        }
        if (this.bsT != null && wVar != null) {
            this.bsT.setLiveShowData(wVar);
        }
        if (this.bsR != null && wVar != null) {
            this.bsR.s(wVar);
        }
        BdLog.e("BCVideoChat liveID=" + wVar.mLiveInfo.live_id + " roomID=" + wVar.mLiveInfo.room_id + " pushUrl=" + wVar.mLiveInfo.getPushUrl());
    }

    @Override // com.baidu.live.aj.b
    public void O(JSONObject jSONObject) {
        jSONObject.optLong("uid");
        if (this.bsR != null) {
            this.bsR.ff(1);
        }
    }

    @Override // com.baidu.live.aj.b
    public void Y(View view) {
        this.bsZ = view;
    }

    @Override // com.baidu.live.aj.b
    public void PU() {
        if (this.bsT != null) {
            this.bsT.Rv();
        }
    }

    @Override // com.baidu.live.aj.b
    public boolean PV() {
        if (this.bsT != null) {
            return this.bsT.Rt() || this.bsT.Ru();
        }
        return false;
    }

    @Override // com.baidu.live.aj.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (PW()) {
            return true;
        }
        if (this.bsW != null) {
            this.bsW.onDestroy();
            this.bsW = null;
        }
        return false;
    }

    @Override // com.baidu.live.aj.b
    public void setMute(boolean z) {
        if (this.bsT != null) {
            this.bsT.setMute(z);
        }
    }

    @Override // com.baidu.live.aj.b
    public void onDestroy() {
        if (this.bsW != null) {
            this.bsW.onDestroy();
            this.bsW = null;
        }
        if (this.bsS != null) {
            this.bsS.listen(this.mPhoneStateListener, 0);
            this.bsS = null;
        }
        if (this.bsT != null) {
            this.bsT.onDestroy();
            this.bsT = null;
        }
        if (this.bsX != null) {
            this.bsX.onDestroy();
            this.bsX = null;
        }
        if (this.bsY != null) {
            this.bsY.onDestroy();
            this.bsY = null;
        }
    }

    @Override // com.baidu.live.aj.b
    public boolean PW() {
        if (this.bta == null) {
            this.bta = new com.baidu.live.talentshow.components.a.b();
        }
        boolean z = this.bta != null && (this.bsT.Rt() || this.bsT.Ru());
        if (z) {
            this.bta.a(this.mPageContext, this.mPageContext.getResources().getString(a.h.linkmic_close_confirm), this.btc);
        }
        return z;
    }

    @Override // com.baidu.live.aj.b
    public void a(com.baidu.live.aj.a aVar) {
        this.btb = aVar;
    }

    @Override // com.baidu.live.aj.b
    public void a(FrameLayout frameLayout) {
        this.bsQ = frameLayout;
    }

    @Override // com.baidu.live.aj.b
    public View getEnterView() {
        if (this.bsR != null) {
            return this.bsR.getEnterView();
        }
        return null;
    }

    private void aA(Context context) {
        this.bsS = (TelephonyManager) context.getSystemService("phone");
        if (this.bsS != null) {
            this.bsS.listen(this.mPhoneStateListener, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PX() {
        if (this.btb == null) {
            return true;
        }
        return this.btb.PX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PY() {
        if (this.bsU == null) {
            this.bsU = new d(this.mPageContext.getPageActivity());
            this.bsU.a(this.bth);
            this.bsU.a(this.btg);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bsU.PY();
        } else {
            this.bsU.QX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.talentshow.b.d dVar) {
        if (dVar != null) {
            BdLog.e("BCVideoChat master controller: start chat " + dVar.nickName);
            com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
            bVar.uid = dVar.uid;
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.azK = JavaTypesHelper.toLong(dVar.bwt, 0L);
            cVar.cuid = dVar.cuid;
            cVar.azQ = dVar.uk;
            cVar.userName = dVar.nickName;
            cVar.appId = JavaTypesHelper.toLong(dVar.appid, 0L);
            cVar.appVersion = TbConfig.getVersion();
            bVar.bxu = cVar;
            int a2 = this.bsT.a(bVar);
            if (a2 == -2) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_invite_others));
            } else if (a2 < 0) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, JSONObject jSONObject) {
        this.bsV.fi(0);
        this.bsV.QF();
        if (this.bsP != null && this.bsP.getPreview() != null && this.bsP.getPreview().getParent() != null) {
            ((ViewGroup) this.bsP.getPreview().getParent()).removeView(this.bsP.getPreview());
        }
        if (this.bsP != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(this.bsP.getPreview(), 0.0f);
            }
            this.bsQ.addView(this.bsP.getPreview(), 0);
            this.bsP.startRecord();
            if (this.bsZ != null) {
                this.bsZ.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PZ() {
        long j;
        long j2 = 0;
        if (this.bsX != null) {
            if (this.bsT != null) {
                j = this.bsT.fk(1);
                j2 = this.bsT.fk(2);
            } else {
                j = 0;
            }
            this.bsX.b(1, j, j2);
        }
    }

    @RequiresApi(api = 21)
    private void n(View view, final float f) {
        if (view != null) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.baidu.live.talentshow.a.2
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    Rect rect = new Rect();
                    view2.getGlobalVisibleRect(rect);
                    outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.talentshow.b.d> Y(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null && !ListUtils.isEmpty(list) && this.bsT != null) {
            for (com.baidu.live.talentshow.b.d dVar : list) {
                int aJ = this.bsT.aJ(JavaTypesHelper.toLong(dVar.bwt, 0L));
                BdLog.e("BCVideoChat chat user local state " + aJ + " isFull " + this.bsT.isFull());
                if (aJ == -1) {
                    aJ = com.baidu.live.talentshow.d.d.bwO;
                }
                if (this.bsT.isFull() && aJ != com.baidu.live.talentshow.d.d.bwS && aJ != com.baidu.live.talentshow.d.d.bwR && list.size() > 2) {
                    aJ = 5;
                }
                dVar.status = aJ;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(String str) {
        if (this.mPageContext != null) {
            this.mPageContext.showToast(str);
        }
    }
}
