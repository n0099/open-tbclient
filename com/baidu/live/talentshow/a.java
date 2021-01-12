package com.baidu.live.talentshow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.ao.b {
    private x aBr;
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
    private com.baidu.live.ao.a bym;
    private TbPageContext mPageContext;
    private b.a byn = new b.a() { // from class: com.baidu.live.talentshow.a.1
        @Override // com.baidu.live.talentshow.components.a.b.a
        public void OB() {
            if (a.this.bye != null) {
                a.this.bye.Rd();
            }
        }

        @Override // com.baidu.live.talentshow.components.a.b.a
        public void OC() {
        }
    };
    private com.baidu.live.talentshow.c.b byo = new com.baidu.live.talentshow.c.b() { // from class: com.baidu.live.talentshow.a.4
        @Override // com.baidu.live.talentshow.c.b
        public void ac(List<com.baidu.live.talentshow.b.d> list) {
            a.this.byf.af(a.this.ab(list));
        }

        @Override // com.baidu.live.talentshow.c.b
        public void y(int i, String str) {
            a.this.hm(str);
        }
    };
    private com.baidu.live.talentshow.c.a byp = new com.baidu.live.talentshow.c.a() { // from class: com.baidu.live.talentshow.a.5
        @Override // com.baidu.live.talentshow.c.a
        public void a(int i, String str, com.baidu.live.talentshow.b.d dVar) {
            if (i == 1) {
                a.this.a(dVar);
                return;
            }
            a.this.hm(str);
            a.this.PG();
        }

        @Override // com.baidu.live.talentshow.c.a
        public void z(int i, String str) {
            a.this.hm(str);
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
                        a.this.bye.Rd();
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
            if (a.this.PE()) {
                a.this.PF();
            }
            com.baidu.live.talentshow.e.a.RI();
        }
    };
    private LiveBCMasterChatSelectorLayer.a byr = new LiveBCMasterChatSelectorLayer.a() { // from class: com.baidu.live.talentshow.a.8
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void PH() {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a.this.PG();
            }
            com.baidu.live.talentshow.e.a.RH();
        }

        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void PI() {
        }
    };
    private LiveBCMasterChatSelectorLayer.b bys = new LiveBCMasterChatSelectorLayer.b() { // from class: com.baidu.live.talentshow.a.9
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.b
        public void b(com.baidu.live.talentshow.b.d dVar) {
            long j;
            long j2;
            if (dVar.status == 5) {
                a.this.hm(a.this.mPageContext.getString(a.h.talent_chat_queue_is_full));
                return;
            }
            if (a.this.byi != null) {
                if (a.this.bye != null) {
                    j2 = a.this.bye.ed(1);
                    j = a.this.bye.ed(2);
                } else {
                    j = 0;
                    j2 = 0;
                }
                a.this.byi.a(dVar, j2, j);
            }
            com.baidu.live.talentshow.e.a.RG();
        }
    };
    private a.InterfaceC0199a byt = new a.InterfaceC0199a() { // from class: com.baidu.live.talentshow.a.10
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0199a
        public void a(View view, int i, final long j) {
            if (a.this.byh == null) {
                a.this.byh = new com.baidu.live.talentshow.components.a.b();
            }
            String J = com.baidu.live.videochat.d.J(a.this.bye.bk(j), 16);
            Resources resources = a.this.mPageContext.getResources();
            int i2 = a.h.linkmic_close_confirm_with_user_name;
            Object[] objArr = new Object[1];
            if (J == null) {
                J = "";
            }
            objArr[0] = J;
            a.this.byh.a(a.this.mPageContext, resources.getString(i2, objArr), new b.a() { // from class: com.baidu.live.talentshow.a.10.1
                @Override // com.baidu.live.talentshow.components.a.b.a
                public void OB() {
                    if (a.this.bye != null) {
                        a.this.bye.bj(j);
                    }
                }

                @Override // com.baidu.live.talentshow.components.a.b.a
                public void OC() {
                }
            });
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0199a
        public void b(View view, boolean z) {
        }
    };
    private f byu = new f() { // from class: com.baidu.live.talentshow.a.11
        @Override // com.baidu.live.talentshow.d.f
        public void e(String str, JSONObject jSONObject) {
            a.this.d(str, jSONObject);
        }

        @Override // com.baidu.live.talentshow.d.f
        public void PJ() {
            a.this.byg.d(a.this.byb);
            a.this.byg.Qo();
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
            a.this.PG();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void c(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStopChatResult imUK=" + j + " index=" + i + " erroCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bCk && a.this.byg != null) {
                a.this.byg.eb(i);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void d(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStartChatResult imUK=" + j + " index=" + i + " errorCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bCd) {
                a.this.hm(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bCe) {
                a.this.hm(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bCj) {
                a.this.hm(a.this.mPageContext.getString(a.h.talent_invite_timeout));
                if (a.this.byg != null) {
                    a.this.byg.eb(i);
                }
            } else if (i2 == 0) {
                a.this.byg.a(i, j, true, true);
                a.this.PG();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void e(long j, int i, int i2) {
            if (i2 == com.baidu.live.talentshow.d.d.bCf) {
                a.this.hm(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.byg != null) {
                    a.this.byg.eb(i);
                }
            } else if (i2 == com.baidu.live.talentshow.d.d.bCg) {
                a.this.hm(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bCi) {
                a.this.hm(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.byg != null) {
                    a.this.byg.eb(i);
                }
            }
            a.this.PG();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void hn(String str) {
            if (a.this.byf != null) {
                if (a.this.bye.isFull()) {
                    a.this.byf.QH();
                    return;
                }
                a.this.byf.af(a.this.ab(a.this.byf.QG()));
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void g(long j, int i) {
            View bi = a.this.bye.bi(j);
            BdLog.e("BCVideoChat blmsdk" + bi + "|imuk=" + j + "|index=" + i);
            if (bi != null) {
                a.this.byg.a(bi, i, j, true, false);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(com.baidu.live.talentshow.d.a.b bVar, int i) {
            if (i >= 15 && a.this.byg != null) {
                a.this.byg.eb(bVar.index);
                a.this.bye.bj(bVar.bCD.axT);
                String string = a.this.mPageContext.getString(a.h.talent_close_chat);
                if (a.this.byf == null) {
                    a.this.mPageContext.showToast(string);
                    return;
                }
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.J(a.this.byf.bg(bVar.bCD.axT), 16) + string);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void h(long j, int i) {
            if (a.this.byg != null) {
                a.this.byg.eb(i);
            }
            if (a.this.byf != null) {
                a.this.byf.QH();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void i(long j, int i) {
            if (a.this.byg != null) {
                a.this.byg.eb(i);
            }
            String string = a.this.mPageContext.getString(a.h.talent_close_chat);
            if (a.this.byf == null) {
                a.this.mPageContext.showToast(string);
            } else {
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.J(a.this.byf.bg(j), 16) + string);
            }
            if (a.this.byf != null) {
                a.this.byf.QH();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void dV(int i) {
            if (i >= 15 && a.this.bye != null) {
                a.this.bye.Rd();
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
                        a.this.bye.Re();
                    } else {
                        a.this.bye.Rf();
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        com.baidu.live.alablmsdk.a.ba(TbadkCoreApplication.getInst().isDebugMode());
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
        bc(tbPageContext.getPageActivity());
        BdLog.e("BCVideoChat  cuid=" + TbadkCoreApplication.getInst().getCuid() + " imUK=" + AccountManager.getUK(TbadkCoreApplication.getInst()));
        MessageManager.getInstance().registerListener(this.byv);
    }

    @Override // com.baidu.live.ao.b
    public void H(Object obj) {
        if (this.bye != null && (obj instanceof AlaLiveRecorder)) {
            this.bye.a((AlaLiveRecorder) obj);
            this.bya = (AlaLiveRecorder) obj;
        }
    }

    @Override // com.baidu.live.ao.b
    public void setLiveShowData(x xVar) {
        this.aBr = xVar;
        if (this.byi != null) {
            this.byi.u(this.aBr);
        }
        if (this.bye != null && xVar != null) {
            this.bye.setLiveShowData(xVar);
        }
        if (this.byc != null && xVar != null) {
            this.byc.t(xVar);
        }
        BdLog.e("BCVideoChat liveID=" + xVar.mLiveInfo.live_id + " roomID=" + xVar.mLiveInfo.room_id + " pushUrl=" + xVar.mLiveInfo.getPushUrl());
    }

    @Override // com.baidu.live.ao.b
    public void Y(JSONObject jSONObject) {
        jSONObject.optLong("uid");
        if (this.byc != null) {
            this.byc.dY(1);
        }
    }

    @Override // com.baidu.live.ao.b
    public void Y(View view) {
        this.byk = view;
    }

    @Override // com.baidu.live.ao.b
    public void PB() {
        if (this.bye != null) {
            this.bye.Rd();
        }
    }

    @Override // com.baidu.live.ao.b
    public boolean PC() {
        if (this.bye != null) {
            return this.bye.Rb() || this.bye.Rc();
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (PD()) {
            return true;
        }
        if (this.byh != null) {
            this.byh.onDestroy();
            this.byh = null;
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public void setMute(boolean z) {
        if (this.bye != null) {
            this.bye.setMute(z);
        }
    }

    @Override // com.baidu.live.ao.b
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

    @Override // com.baidu.live.ao.b
    public boolean PD() {
        if (this.byl == null) {
            this.byl = new com.baidu.live.talentshow.components.a.b();
        }
        boolean z = this.byl != null && (this.bye.Rb() || this.bye.Rc());
        if (z) {
            this.byl.a(this.mPageContext, this.mPageContext.getResources().getString(a.h.linkmic_close_confirm), this.byn);
        }
        return z;
    }

    @Override // com.baidu.live.ao.b
    public void a(com.baidu.live.ao.a aVar) {
        this.bym = aVar;
    }

    @Override // com.baidu.live.ao.b
    public void a(FrameLayout frameLayout) {
        this.byb = frameLayout;
    }

    @Override // com.baidu.live.ao.b
    public View getEnterView() {
        if (this.byc != null) {
            return this.byc.getEnterView();
        }
        return null;
    }

    private void bc(Context context) {
        this.byd = (TelephonyManager) context.getSystemService("phone");
        if (this.byd != null) {
            this.byd.listen(this.mPhoneStateListener, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PE() {
        if (this.bym == null) {
            return true;
        }
        return this.bym.PE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        if (this.byf == null) {
            this.byf = new d(this.mPageContext.getPageActivity());
            this.byf.a(this.bys);
            this.byf.a(this.byr);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.byf.PF();
        } else {
            this.byf.QF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.talentshow.b.d dVar) {
        if (dVar != null) {
            BdLog.e("BCVideoChat master controller: start chat " + dVar.nickName);
            com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
            bVar.uid = dVar.uid;
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.axT = JavaTypesHelper.toLong(dVar.bBF, 0L);
            cVar.cuid = dVar.cuid;
            cVar.axZ = dVar.uk;
            cVar.userName = dVar.nickName;
            cVar.appId = JavaTypesHelper.toLong(dVar.appid, 0L);
            cVar.appVersion = TbConfig.getVersion();
            bVar.bCD = cVar;
            int a2 = this.bye.a(bVar);
            if (a2 == -2) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_invite_others));
            } else if (a2 < 0) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, JSONObject jSONObject) {
        this.byg.eb(0);
        this.byg.Qn();
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
    public void PG() {
        long j;
        long j2;
        if (this.byi != null) {
            if (this.bye != null) {
                j2 = this.bye.ed(1);
                j = this.bye.ed(2);
            } else {
                j = 0;
                j2 = 0;
            }
            this.byi.b(1, j2, j);
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
    public List<com.baidu.live.talentshow.b.d> ab(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null && !ListUtils.isEmpty(list) && this.bye != null) {
            for (com.baidu.live.talentshow.b.d dVar : list) {
                int bh = this.bye.bh(JavaTypesHelper.toLong(dVar.bBF, 0L));
                BdLog.e("BCVideoChat chat user local state " + bh + " isFull " + this.bye.isFull());
                if (bh == -1) {
                    bh = com.baidu.live.talentshow.d.d.bBX;
                }
                if (this.bye.isFull() && bh != com.baidu.live.talentshow.d.d.bCb && bh != com.baidu.live.talentshow.d.d.bCa && list.size() > 2) {
                    bh = 5;
                }
                dVar.status = bh;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hm(String str) {
        if (this.mPageContext != null) {
            this.mPageContext.showToast(str);
        }
    }
}
