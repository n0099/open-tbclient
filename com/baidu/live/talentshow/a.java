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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.an.b {
    private w aFN;
    private AlaLiveRecorder bya;
    private FrameLayout byb;
    private com.baidu.live.talentshow.components.enter.a byc;
    private TelephonyManager byd;
    private com.baidu.live.talentshow.d.a bye;
    private d byf;
    private com.baidu.live.talentshow.components.b.b byg;
    private com.baidu.live.talentshow.components.a.b byh;
    private com.baidu.live.talentshow.components.selector.b byi;
    private com.baidu.live.talentshow.model.d byj;
    private View byk;
    private com.baidu.live.talentshow.components.a.b byl;
    private com.baidu.live.an.a bym;
    private TbPageContext mPageContext;
    private b.a byn = new b.a() { // from class: com.baidu.live.talentshow.a.1
        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Rt() {
            if (a.this.bye != null) {
                a.this.bye.TT();
            }
        }

        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Ru() {
        }
    };
    private com.baidu.live.talentshow.c.b byo = new com.baidu.live.talentshow.c.b() { // from class: com.baidu.live.talentshow.a.4
        @Override // com.baidu.live.talentshow.c.b
        public void ab(List<com.baidu.live.talentshow.b.d> list) {
            a.this.byf.ae(a.this.aa(list));
        }

        @Override // com.baidu.live.talentshow.c.b
        public void v(int i, String str) {
            a.this.iI(str);
        }
    };
    private com.baidu.live.talentshow.c.a byp = new com.baidu.live.talentshow.c.a() { // from class: com.baidu.live.talentshow.a.5
        @Override // com.baidu.live.talentshow.c.a
        public void a(int i, String str, com.baidu.live.talentshow.b.d dVar) {
            if (i == 1) {
                a.this.a(dVar);
                return;
            }
            a.this.iI(str);
            a.this.Sx();
        }

        @Override // com.baidu.live.talentshow.c.a
        public void w(int i, String str) {
            a.this.iI(str);
        }
    };
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() { // from class: com.baidu.live.talentshow.a.6
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                    BdLog.e("PhoneCallManager 电话响铃");
                    break;
                case 2:
                    BdLog.e("PhoneCallManager 电话接听 关闭连麦");
                    if (a.this.bye != null) {
                        a.this.bye.TT();
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.talentshow.components.enter.b byq = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.a.7
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (a.this.Sv()) {
                a.this.Sw();
            }
            com.baidu.live.talentshow.e.a.Uw();
        }
    };
    private LiveBCMasterChatSelectorLayer.a byr = new LiveBCMasterChatSelectorLayer.a() { // from class: com.baidu.live.talentshow.a.8
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Sy() {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a.this.Sx();
            }
            com.baidu.live.talentshow.e.a.Uv();
        }

        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Sz() {
        }
    };
    private LiveBCMasterChatSelectorLayer.b bys = new LiveBCMasterChatSelectorLayer.b() { // from class: com.baidu.live.talentshow.a.9
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.b
        public void b(com.baidu.live.talentshow.b.d dVar) {
            long j;
            long j2 = 0;
            if (dVar.status == 5) {
                a.this.iI(a.this.mPageContext.getString(a.h.talent_chat_queue_is_full));
                return;
            }
            if (a.this.byi != null) {
                if (a.this.bye != null) {
                    j = a.this.bye.fI(1);
                    j2 = a.this.bye.fI(2);
                } else {
                    j = 0;
                }
                a.this.byi.a(dVar, j, j2);
            }
            com.baidu.live.talentshow.e.a.Uu();
        }
    };
    private a.InterfaceC0210a byt = new a.InterfaceC0210a() { // from class: com.baidu.live.talentshow.a.10
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0210a
        public void a(View view, int i, final long j) {
            if (a.this.byh == null) {
                a.this.byh = new com.baidu.live.talentshow.components.a.b();
            }
            String H = com.baidu.live.videochat.d.H(a.this.bye.bk(j), 16);
            Resources resources = a.this.mPageContext.getResources();
            int i2 = a.h.linkmic_close_confirm_with_user_name;
            Object[] objArr = new Object[1];
            if (H == null) {
                H = "";
            }
            objArr[0] = H;
            a.this.byh.a(a.this.mPageContext, resources.getString(i2, objArr), new b.a() { // from class: com.baidu.live.talentshow.a.10.1
                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Rt() {
                    if (a.this.bye != null) {
                        a.this.bye.bj(j);
                    }
                }

                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Ru() {
                }
            });
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0210a
        public void b(View view, boolean z) {
        }
    };
    private f byu = new f() { // from class: com.baidu.live.talentshow.a.11
        @Override // com.baidu.live.talentshow.d.f
        public void d(String str, JSONObject jSONObject) {
            a.this.c(str, jSONObject);
        }

        @Override // com.baidu.live.talentshow.d.f
        public void SA() {
            a.this.byg.d(a.this.byb);
            a.this.byg.Te();
            if (a.this.byk != null) {
                a.this.byk.setEnabled(false);
            }
            if (a.this.bya != null && a.this.bya.getPreview() != null && a.this.bya.getPreview().getParent() != null) {
                ((ViewGroup) a.this.bya.getPreview().getParent()).removeView(a.this.bya.getPreview());
                a.this.byb.addView(a.this.bya.getPreview());
            }
            a.this.byg.a(a.this.bya.getPreview(), 0, 0L, true, false);
            a.this.bya.startRecord();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void bf(long j) {
            a.this.Sx();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void c(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStopChatResult imUK=" + j + " index=" + i + " erroCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bCj && a.this.byg != null) {
                a.this.byg.fG(i);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void d(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStartChatResult imUK=" + j + " index=" + i + " errorCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bCc) {
                a.this.iI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bCd) {
                a.this.iI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bCi) {
                a.this.iI(a.this.mPageContext.getString(a.h.talent_invite_timeout));
                if (a.this.byg != null) {
                    a.this.byg.fG(i);
                }
            } else if (i2 == 0) {
                a.this.byg.a(i, j, true, true);
                a.this.Sx();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void e(long j, int i, int i2) {
            if (i2 == com.baidu.live.talentshow.d.d.bCe) {
                a.this.iI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.byg != null) {
                    a.this.byg.fG(i);
                }
            } else if (i2 == com.baidu.live.talentshow.d.d.bCf) {
                a.this.iI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bCh) {
                a.this.iI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.byg != null) {
                    a.this.byg.fG(i);
                }
            }
            a.this.Sx();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void iJ(String str) {
            if (a.this.byf != null) {
                if (a.this.bye.isFull()) {
                    a.this.byf.Tx();
                    return;
                }
                a.this.byf.ae(a.this.aa(a.this.byf.Tw()));
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void f(long j, int i) {
            View bi = a.this.bye.bi(j);
            BdLog.e("BCVideoChat blmsdk" + bi + "|imuk=" + j + "|index=" + i);
            if (bi != null) {
                a.this.byg.a(bi, i, j, true, false);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(com.baidu.live.talentshow.d.a.b bVar, int i) {
            if (i >= 15 && a.this.byg != null) {
                a.this.byg.fG(bVar.index);
                a.this.bye.bj(bVar.bCC.aCp);
                String string = a.this.mPageContext.getString(a.h.talent_close_chat);
                if (a.this.byf == null) {
                    a.this.mPageContext.showToast(string);
                    return;
                }
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.H(a.this.byf.bg(bVar.bCC.aCp), 16) + string);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void g(long j, int i) {
            if (a.this.byg != null) {
                a.this.byg.fG(i);
            }
            if (a.this.byf != null) {
                a.this.byf.Tx();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void h(long j, int i) {
            if (a.this.byg != null) {
                a.this.byg.fG(i);
            }
            String string = a.this.mPageContext.getString(a.h.talent_close_chat);
            if (a.this.byf == null) {
                a.this.mPageContext.showToast(string);
            } else {
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.H(a.this.byf.bg(j), 16) + string);
            }
            if (a.this.byf != null) {
                a.this.byf.Tx();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void fA(int i) {
            if (i >= 15 && a.this.bye != null) {
                a.this.bye.TT();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(c cVar) {
            if (a.this.byj != null) {
                a.this.byj.c(cVar);
            }
        }
    };
    private CustomMessageListener byv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.talentshow.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                boolean booleanValue = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (a.this.bye != null) {
                    if (booleanValue) {
                        a.this.bye.onBackground();
                    } else {
                        a.this.bye.onForeground();
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        com.baidu.live.alablmsdk.a.bh(TbadkCoreApplication.getInst().isDebugMode());
        this.mPageContext = tbPageContext;
        this.byj = new com.baidu.live.talentshow.model.d(tbPageContext);
        this.byi = new com.baidu.live.talentshow.components.selector.b(tbPageContext);
        this.byi.a(this.byo);
        this.byi.a(this.byp);
        this.bye = new g();
        this.bye.init(tbPageContext.getPageActivity());
        this.bye.a(this.byu);
        this.byg = new com.baidu.live.talentshow.components.b.b(tbPageContext.getPageActivity(), this.byt);
        this.byc = new com.baidu.live.talentshow.components.enter.a(tbPageContext, true);
        this.byc.a(this.byq);
        be(tbPageContext.getPageActivity());
        BdLog.e("BCVideoChat  cuid=" + TbadkCoreApplication.getInst().getCuid() + " imUK=" + AccountManager.getUK(TbadkCoreApplication.getInst()));
        MessageManager.getInstance().registerListener(this.byv);
    }

    @Override // com.baidu.live.an.b
    public void L(Object obj) {
        if (this.bye != null && (obj instanceof AlaLiveRecorder)) {
            this.bye.a((AlaLiveRecorder) obj);
            this.bya = (AlaLiveRecorder) obj;
        }
    }

    @Override // com.baidu.live.an.b
    public void setLiveShowData(w wVar) {
        this.aFN = wVar;
        if (this.byi != null) {
            this.byi.t(this.aFN);
        }
        if (this.bye != null && wVar != null) {
            this.bye.setLiveShowData(wVar);
        }
        if (this.byc != null && wVar != null) {
            this.byc.s(wVar);
        }
        BdLog.e("BCVideoChat liveID=" + wVar.mLiveInfo.live_id + " roomID=" + wVar.mLiveInfo.room_id + " pushUrl=" + wVar.mLiveInfo.getPushUrl());
    }

    @Override // com.baidu.live.an.b
    public void Q(JSONObject jSONObject) {
        jSONObject.optLong("uid");
        if (this.byc != null) {
            this.byc.fD(1);
        }
    }

    @Override // com.baidu.live.an.b
    public void Y(View view) {
        this.byk = view;
    }

    @Override // com.baidu.live.an.b
    public void Ss() {
        if (this.bye != null) {
            this.bye.TT();
        }
    }

    @Override // com.baidu.live.an.b
    public boolean St() {
        if (this.bye != null) {
            return this.bye.TR() || this.bye.TS();
        }
        return false;
    }

    @Override // com.baidu.live.an.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Su()) {
            return true;
        }
        if (this.byh != null) {
            this.byh.onDestroy();
            this.byh = null;
        }
        return false;
    }

    @Override // com.baidu.live.an.b
    public void setMute(boolean z) {
        if (this.bye != null) {
            this.bye.setMute(z);
        }
    }

    @Override // com.baidu.live.an.b
    public void onDestroy() {
        if (this.byh != null) {
            this.byh.onDestroy();
            this.byh = null;
        }
        if (this.byd != null) {
            this.byd.listen(this.mPhoneStateListener, 0);
            this.byd = null;
        }
        if (this.bye != null) {
            this.bye.onDestroy();
            this.bye = null;
        }
        if (this.byi != null) {
            this.byi.onDestroy();
            this.byi = null;
        }
        if (this.byj != null) {
            this.byj.onDestroy();
            this.byj = null;
        }
        MessageManager.getInstance().unRegisterListener(this.byv);
    }

    @Override // com.baidu.live.an.b
    public boolean Su() {
        if (this.byl == null) {
            this.byl = new com.baidu.live.talentshow.components.a.b();
        }
        boolean z = this.byl != null && (this.bye.TR() || this.bye.TS());
        if (z) {
            this.byl.a(this.mPageContext, this.mPageContext.getResources().getString(a.h.linkmic_close_confirm), this.byn);
        }
        return z;
    }

    @Override // com.baidu.live.an.b
    public void a(com.baidu.live.an.a aVar) {
        this.bym = aVar;
    }

    @Override // com.baidu.live.an.b
    public void a(FrameLayout frameLayout) {
        this.byb = frameLayout;
    }

    @Override // com.baidu.live.an.b
    public View getEnterView() {
        if (this.byc != null) {
            return this.byc.getEnterView();
        }
        return null;
    }

    private void be(Context context) {
        this.byd = (TelephonyManager) context.getSystemService("phone");
        if (this.byd != null) {
            this.byd.listen(this.mPhoneStateListener, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sv() {
        if (this.bym == null) {
            return true;
        }
        return this.bym.Sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw() {
        if (this.byf == null) {
            this.byf = new d(this.mPageContext.getPageActivity());
            this.byf.a(this.bys);
            this.byf.a(this.byr);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.byf.Sw();
        } else {
            this.byf.Tv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.talentshow.b.d dVar) {
        if (dVar != null) {
            BdLog.e("BCVideoChat master controller: start chat " + dVar.nickName);
            com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
            bVar.uid = dVar.uid;
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.aCp = JavaTypesHelper.toLong(dVar.bBD, 0L);
            cVar.cuid = dVar.cuid;
            cVar.aCv = dVar.uk;
            cVar.userName = dVar.nickName;
            cVar.appId = JavaTypesHelper.toLong(dVar.appid, 0L);
            cVar.appVersion = TbConfig.getVersion();
            bVar.bCC = cVar;
            int a2 = this.bye.a(bVar);
            if (a2 == -2) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_invite_others));
            } else if (a2 < 0) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, JSONObject jSONObject) {
        this.byg.fG(0);
        this.byg.Td();
        if (this.bya != null && this.bya.getPreview() != null && this.bya.getPreview().getParent() != null) {
            ((ViewGroup) this.bya.getPreview().getParent()).removeView(this.bya.getPreview());
        }
        if (this.bya != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(this.bya.getPreview(), 0.0f);
            }
            this.byb.addView(this.bya.getPreview(), 0);
            this.bya.startRecord();
            if (this.byk != null) {
                this.byk.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sx() {
        long j;
        long j2 = 0;
        if (this.byi != null) {
            if (this.bye != null) {
                j = this.bye.fI(1);
                j2 = this.bye.fI(2);
            } else {
                j = 0;
            }
            this.byi.b(1, j, j2);
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
    public List<com.baidu.live.talentshow.b.d> aa(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null && !ListUtils.isEmpty(list) && this.bye != null) {
            for (com.baidu.live.talentshow.b.d dVar : list) {
                int bh = this.bye.bh(JavaTypesHelper.toLong(dVar.bBD, 0L));
                BdLog.e("BCVideoChat chat user local state " + bh + " isFull " + this.bye.isFull());
                if (bh == -1) {
                    bh = com.baidu.live.talentshow.d.d.bBW;
                }
                if (this.bye.isFull() && bh != com.baidu.live.talentshow.d.d.bCa && bh != com.baidu.live.talentshow.d.d.bBZ && list.size() > 2) {
                    bh = 5;
                }
                dVar.status = bh;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI(String str) {
        if (this.mPageContext != null) {
            this.mPageContext.showToast(str);
        }
    }
}
