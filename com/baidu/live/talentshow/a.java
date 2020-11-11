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
    private w aES;
    private AlaLiveRecorder buC;
    private FrameLayout buD;
    private com.baidu.live.talentshow.components.enter.a buE;
    private TelephonyManager buF;
    private com.baidu.live.talentshow.d.a buG;
    private d buH;
    private com.baidu.live.talentshow.components.b.b buI;
    private com.baidu.live.talentshow.components.a.b buJ;
    private com.baidu.live.talentshow.components.selector.b buK;
    private com.baidu.live.talentshow.model.d buL;
    private View buM;
    private com.baidu.live.talentshow.components.a.b buN;
    private com.baidu.live.aj.a buO;
    private TbPageContext mPageContext;
    private b.a buP = new b.a() { // from class: com.baidu.live.talentshow.a.1
        @Override // com.baidu.live.talentshow.components.a.b.a
        public void PI() {
            if (a.this.buG != null) {
                a.this.buG.Se();
            }
        }

        @Override // com.baidu.live.talentshow.components.a.b.a
        public void PJ() {
        }
    };
    private com.baidu.live.talentshow.c.b buQ = new com.baidu.live.talentshow.c.b() { // from class: com.baidu.live.talentshow.a.3
        @Override // com.baidu.live.talentshow.c.b
        public void Z(List<com.baidu.live.talentshow.b.d> list) {
            a.this.buH.ac(a.this.Y(list));
        }

        @Override // com.baidu.live.talentshow.c.b
        public void v(int i, String str) {
            a.this.ik(str);
        }
    };
    private com.baidu.live.talentshow.c.a buR = new com.baidu.live.talentshow.c.a() { // from class: com.baidu.live.talentshow.a.4
        @Override // com.baidu.live.talentshow.c.a
        public void a(int i, String str, com.baidu.live.talentshow.b.d dVar) {
            if (i == 1) {
                a.this.a(dVar);
                return;
            }
            a.this.ik(str);
            a.this.QI();
        }

        @Override // com.baidu.live.talentshow.c.a
        public void w(int i, String str) {
            a.this.ik(str);
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
                    if (a.this.buG != null) {
                        a.this.buG.Se();
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.talentshow.components.enter.b buS = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.a.6
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (a.this.QG()) {
                a.this.QH();
            }
            com.baidu.live.talentshow.e.a.SH();
        }
    };
    private LiveBCMasterChatSelectorLayer.a buT = new LiveBCMasterChatSelectorLayer.a() { // from class: com.baidu.live.talentshow.a.7
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void QJ() {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a.this.QI();
            }
            com.baidu.live.talentshow.e.a.SG();
        }

        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void QK() {
        }
    };
    private LiveBCMasterChatSelectorLayer.b buU = new LiveBCMasterChatSelectorLayer.b() { // from class: com.baidu.live.talentshow.a.8
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.b
        public void b(com.baidu.live.talentshow.b.d dVar) {
            long j;
            long j2 = 0;
            if (dVar.status == 5) {
                a.this.ik(a.this.mPageContext.getString(a.h.talent_chat_queue_is_full));
                return;
            }
            if (a.this.buK != null) {
                if (a.this.buG != null) {
                    j = a.this.buG.fo(1);
                    j2 = a.this.buG.fo(2);
                } else {
                    j = 0;
                }
                a.this.buK.a(dVar, j, j2);
            }
            com.baidu.live.talentshow.e.a.SF();
        }
    };
    private a.InterfaceC0202a buV = new a.InterfaceC0202a() { // from class: com.baidu.live.talentshow.a.9
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0202a
        public void a(View view, int i, final long j) {
            if (a.this.buJ == null) {
                a.this.buJ = new com.baidu.live.talentshow.components.a.b();
            }
            String G = com.baidu.live.videochat.d.G(a.this.buG.aM(j), 16);
            Resources resources = a.this.mPageContext.getResources();
            int i2 = a.h.linkmic_close_confirm_with_user_name;
            Object[] objArr = new Object[1];
            if (G == null) {
                G = "";
            }
            objArr[0] = G;
            a.this.buJ.a(a.this.mPageContext, resources.getString(i2, objArr), new b.a() { // from class: com.baidu.live.talentshow.a.9.1
                @Override // com.baidu.live.talentshow.components.a.b.a
                public void PI() {
                    if (a.this.buG != null) {
                        a.this.buG.aL(j);
                    }
                }

                @Override // com.baidu.live.talentshow.components.a.b.a
                public void PJ() {
                }
            });
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0202a
        public void b(View view, boolean z) {
        }
    };
    private f buW = new f() { // from class: com.baidu.live.talentshow.a.10
        @Override // com.baidu.live.talentshow.d.f
        public void d(String str, JSONObject jSONObject) {
            a.this.c(str, jSONObject);
        }

        @Override // com.baidu.live.talentshow.d.f
        public void QL() {
            a.this.buI.d(a.this.buD);
            a.this.buI.Rp();
            if (a.this.buM != null) {
                a.this.buM.setEnabled(false);
            }
            if (a.this.buC != null && a.this.buC.getPreview() != null && a.this.buC.getPreview().getParent() != null) {
                ((ViewGroup) a.this.buC.getPreview().getParent()).removeView(a.this.buC.getPreview());
                a.this.buD.addView(a.this.buC.getPreview());
            }
            a.this.buI.a(a.this.buC.getPreview(), 0, 0L, true, false);
            a.this.buC.startRecord();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void aH(long j) {
            a.this.QI();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void c(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStopChatResult imUK=" + j + " index=" + i + " erroCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.byM && a.this.buI != null) {
                a.this.buI.fm(i);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void d(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStartChatResult imUK=" + j + " index=" + i + " errorCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.byF) {
                a.this.ik(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.byG) {
                a.this.ik(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.byL) {
                a.this.ik(a.this.mPageContext.getString(a.h.talent_invite_timeout));
                if (a.this.buI != null) {
                    a.this.buI.fm(i);
                }
            } else if (i2 == 0) {
                a.this.buI.a(i, j, true, true);
                a.this.QI();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void E(String str, int i) {
            if (i == com.baidu.live.talentshow.d.d.byH) {
                a.this.ik(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i == com.baidu.live.talentshow.d.d.byI) {
                a.this.ik(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i == com.baidu.live.talentshow.d.d.byK) {
                a.this.ik(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
            a.this.QI();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void il(String str) {
            if (a.this.buH != null) {
                if (a.this.buG.isFull()) {
                    a.this.buH.RI();
                    return;
                }
                a.this.buH.ac(a.this.Y(a.this.buH.RH()));
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void f(long j, int i) {
            View aK = a.this.buG.aK(j);
            BdLog.e("BCVideoChat blmsdk" + aK + "|imuk=" + j + "|index=" + i);
            if (aK != null) {
                a.this.buI.a(aK, i, j, true, false);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(com.baidu.live.talentshow.d.a.b bVar, int i) {
            if (i >= 15 && a.this.buI != null) {
                a.this.buI.fm(bVar.index);
                a.this.buG.aL(bVar.bzf.aBv);
                String string = a.this.mPageContext.getString(a.h.talent_close_chat);
                if (a.this.buH == null) {
                    a.this.mPageContext.showToast(string);
                    return;
                }
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.G(a.this.buH.aI(bVar.bzf.aBv), 16) + string);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void g(long j, int i) {
            if (a.this.buI != null) {
                a.this.buI.fm(i);
            }
            if (a.this.buH != null) {
                a.this.buH.RI();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void h(long j, int i) {
            if (a.this.buI != null) {
                a.this.buI.fm(i);
            }
            String string = a.this.mPageContext.getString(a.h.talent_close_chat);
            if (a.this.buH == null) {
                a.this.mPageContext.showToast(string);
            } else {
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.G(a.this.buH.aI(j), 16) + string);
            }
            if (a.this.buH != null) {
                a.this.buH.RI();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void fg(int i) {
            if (i >= 15 && a.this.buG != null) {
                a.this.buG.Se();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(c cVar) {
            if (a.this.buL != null) {
                a.this.buL.c(cVar);
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        com.baidu.live.alablmsdk.b.aZ(TbadkCoreApplication.getInst().isDebugMode());
        this.mPageContext = tbPageContext;
        this.buL = new com.baidu.live.talentshow.model.d(tbPageContext);
        this.buK = new com.baidu.live.talentshow.components.selector.b(tbPageContext);
        this.buK.a(this.buQ);
        this.buK.a(this.buR);
        this.buG = new g();
        this.buG.init(tbPageContext.getPageActivity());
        this.buG.a(this.buW);
        this.buI = new com.baidu.live.talentshow.components.b.b(tbPageContext.getPageActivity(), this.buV);
        this.buE = new com.baidu.live.talentshow.components.enter.a(tbPageContext, true);
        this.buE.a(this.buS);
        aA(tbPageContext.getPageActivity());
        BdLog.e("BCVideoChat  cuid=" + TbadkCoreApplication.getInst().getCuid() + " imUK=" + AccountManager.getUK(TbadkCoreApplication.getInst()));
    }

    @Override // com.baidu.live.aj.b
    public void L(Object obj) {
        if (this.buG != null && (obj instanceof AlaLiveRecorder)) {
            this.buG.a((AlaLiveRecorder) obj);
            this.buC = (AlaLiveRecorder) obj;
        }
    }

    @Override // com.baidu.live.aj.b
    public void setLiveShowData(w wVar) {
        this.aES = wVar;
        if (this.buK != null) {
            this.buK.t(this.aES);
        }
        if (this.buG != null && wVar != null) {
            this.buG.setLiveShowData(wVar);
        }
        if (this.buE != null && wVar != null) {
            this.buE.s(wVar);
        }
        BdLog.e("BCVideoChat liveID=" + wVar.mLiveInfo.live_id + " roomID=" + wVar.mLiveInfo.room_id + " pushUrl=" + wVar.mLiveInfo.getPushUrl());
    }

    @Override // com.baidu.live.aj.b
    public void U(JSONObject jSONObject) {
        jSONObject.optLong("uid");
        if (this.buE != null) {
            this.buE.fj(1);
        }
    }

    @Override // com.baidu.live.aj.b
    public void Y(View view) {
        this.buM = view;
    }

    @Override // com.baidu.live.aj.b
    public void QD() {
        if (this.buG != null) {
            this.buG.Se();
        }
    }

    @Override // com.baidu.live.aj.b
    public boolean QE() {
        if (this.buG != null) {
            return this.buG.Sc() || this.buG.Sd();
        }
        return false;
    }

    @Override // com.baidu.live.aj.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (QF()) {
            return true;
        }
        if (this.buJ != null) {
            this.buJ.onDestroy();
            this.buJ = null;
        }
        return false;
    }

    @Override // com.baidu.live.aj.b
    public void setMute(boolean z) {
        if (this.buG != null) {
            this.buG.setMute(z);
        }
    }

    @Override // com.baidu.live.aj.b
    public void onDestroy() {
        if (this.buJ != null) {
            this.buJ.onDestroy();
            this.buJ = null;
        }
        if (this.buF != null) {
            this.buF.listen(this.mPhoneStateListener, 0);
            this.buF = null;
        }
        if (this.buG != null) {
            this.buG.onDestroy();
            this.buG = null;
        }
        if (this.buK != null) {
            this.buK.onDestroy();
            this.buK = null;
        }
        if (this.buL != null) {
            this.buL.onDestroy();
            this.buL = null;
        }
    }

    @Override // com.baidu.live.aj.b
    public boolean QF() {
        if (this.buN == null) {
            this.buN = new com.baidu.live.talentshow.components.a.b();
        }
        boolean z = this.buN != null && (this.buG.Sc() || this.buG.Sd());
        if (z) {
            this.buN.a(this.mPageContext, this.mPageContext.getResources().getString(a.h.linkmic_close_confirm), this.buP);
        }
        return z;
    }

    @Override // com.baidu.live.aj.b
    public void a(com.baidu.live.aj.a aVar) {
        this.buO = aVar;
    }

    @Override // com.baidu.live.aj.b
    public void a(FrameLayout frameLayout) {
        this.buD = frameLayout;
    }

    @Override // com.baidu.live.aj.b
    public View getEnterView() {
        if (this.buE != null) {
            return this.buE.getEnterView();
        }
        return null;
    }

    private void aA(Context context) {
        this.buF = (TelephonyManager) context.getSystemService("phone");
        if (this.buF != null) {
            this.buF.listen(this.mPhoneStateListener, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QG() {
        if (this.buO == null) {
            return true;
        }
        return this.buO.QG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH() {
        if (this.buH == null) {
            this.buH = new d(this.mPageContext.getPageActivity());
            this.buH.a(this.buU);
            this.buH.a(this.buT);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.buH.QH();
        } else {
            this.buH.RG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.talentshow.b.d dVar) {
        if (dVar != null) {
            BdLog.e("BCVideoChat master controller: start chat " + dVar.nickName);
            com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
            bVar.uid = dVar.uid;
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.aBv = JavaTypesHelper.toLong(dVar.bye, 0L);
            cVar.cuid = dVar.cuid;
            cVar.aBB = dVar.uk;
            cVar.userName = dVar.nickName;
            cVar.appId = JavaTypesHelper.toLong(dVar.appid, 0L);
            cVar.appVersion = TbConfig.getVersion();
            bVar.bzf = cVar;
            int a2 = this.buG.a(bVar);
            if (a2 == -2) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_invite_others));
            } else if (a2 < 0) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, JSONObject jSONObject) {
        this.buI.fm(0);
        this.buI.Ro();
        if (this.buC != null && this.buC.getPreview() != null && this.buC.getPreview().getParent() != null) {
            ((ViewGroup) this.buC.getPreview().getParent()).removeView(this.buC.getPreview());
        }
        if (this.buC != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(this.buC.getPreview(), 0.0f);
            }
            this.buD.addView(this.buC.getPreview(), 0);
            this.buC.startRecord();
            if (this.buM != null) {
                this.buM.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QI() {
        long j;
        long j2 = 0;
        if (this.buK != null) {
            if (this.buG != null) {
                j = this.buG.fo(1);
                j2 = this.buG.fo(2);
            } else {
                j = 0;
            }
            this.buK.b(1, j, j2);
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
        if (list != null && !ListUtils.isEmpty(list) && this.buG != null) {
            for (com.baidu.live.talentshow.b.d dVar : list) {
                int aJ = this.buG.aJ(JavaTypesHelper.toLong(dVar.bye, 0L));
                BdLog.e("BCVideoChat chat user local state " + aJ + " isFull " + this.buG.isFull());
                if (aJ == -1) {
                    aJ = com.baidu.live.talentshow.d.d.byz;
                }
                if (this.buG.isFull() && aJ != com.baidu.live.talentshow.d.d.byD && aJ != com.baidu.live.talentshow.d.d.byC && list.size() > 2) {
                    aJ = 5;
                }
                dVar.status = aJ;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(String str) {
        if (this.mPageContext != null) {
            this.mPageContext.showToast(str);
        }
    }
}
