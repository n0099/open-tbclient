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
import com.baidu.live.data.ab;
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
public class a implements com.baidu.live.am.b {
    private ab aED;
    private AlaLiveRecorder bDg;
    private FrameLayout bDh;
    private com.baidu.live.talentshow.components.enter.a bDi;
    private TelephonyManager bDj;
    private com.baidu.live.talentshow.d.a bDk;
    private d bDl;
    private com.baidu.live.talentshow.components.b.b bDm;
    private com.baidu.live.talentshow.components.a.b bDn;
    private com.baidu.live.talentshow.components.selector.b bDo;
    private com.baidu.live.talentshow.model.d bDp;
    private View bDq;
    private com.baidu.live.talentshow.components.a.b bDr;
    private com.baidu.live.am.a bDs;
    private TbPageContext mPageContext;
    private b.a bDt = new b.a() { // from class: com.baidu.live.talentshow.a.1
        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Qd() {
            if (a.this.bDk != null) {
                a.this.bDk.SP();
            }
        }

        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Qe() {
        }
    };
    private com.baidu.live.talentshow.c.b bDu = new com.baidu.live.talentshow.c.b() { // from class: com.baidu.live.talentshow.a.4
        @Override // com.baidu.live.talentshow.c.b
        public void ad(List<com.baidu.live.talentshow.b.d> list) {
            a.this.bDl.ag(a.this.ac(list));
        }

        @Override // com.baidu.live.talentshow.c.b
        public void C(int i, String str) {
            a.this.hO(str);
        }
    };
    private com.baidu.live.talentshow.c.a bDv = new com.baidu.live.talentshow.c.a() { // from class: com.baidu.live.talentshow.a.5
        @Override // com.baidu.live.talentshow.c.a
        public void a(int i, String str, com.baidu.live.talentshow.b.d dVar) {
            if (i == 1) {
                a.this.a(dVar);
                return;
            }
            a.this.hO(str);
            a.this.Rt();
        }

        @Override // com.baidu.live.talentshow.c.a
        public void D(int i, String str) {
            a.this.hO(str);
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
                    if (a.this.bDk != null) {
                        a.this.bDk.SP();
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.talentshow.components.enter.b bDw = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.a.7
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (a.this.Rr()) {
                a.this.Rs();
            }
            com.baidu.live.talentshow.e.a.Ts();
        }
    };
    private LiveBCMasterChatSelectorLayer.a bDx = new LiveBCMasterChatSelectorLayer.a() { // from class: com.baidu.live.talentshow.a.8
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Ru() {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a.this.Rt();
            }
            com.baidu.live.talentshow.e.a.Tr();
        }

        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Rv() {
        }
    };
    private LiveBCMasterChatSelectorLayer.b bDy = new LiveBCMasterChatSelectorLayer.b() { // from class: com.baidu.live.talentshow.a.9
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.b
        public void b(com.baidu.live.talentshow.b.d dVar) {
            long j;
            long j2;
            if (dVar.status == 5) {
                a.this.hO(a.this.mPageContext.getString(a.h.talent_chat_queue_is_full));
                return;
            }
            if (a.this.bDo != null) {
                if (a.this.bDk != null) {
                    j2 = a.this.bDk.ei(1);
                    j = a.this.bDk.ei(2);
                } else {
                    j = 0;
                    j2 = 0;
                }
                a.this.bDo.a(dVar, j2, j);
            }
            com.baidu.live.talentshow.e.a.Tq();
        }
    };
    private a.InterfaceC0207a bDz = new a.InterfaceC0207a() { // from class: com.baidu.live.talentshow.a.10
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0207a
        public void a(View view, int i, final long j) {
            if (a.this.bDn == null) {
                a.this.bDn = new com.baidu.live.talentshow.components.a.b();
            }
            String K = com.baidu.live.videochat.d.K(a.this.bDk.bo(j), 16);
            Resources resources = a.this.mPageContext.getResources();
            int i2 = a.h.linkmic_close_confirm_with_user_name;
            Object[] objArr = new Object[1];
            if (K == null) {
                K = "";
            }
            objArr[0] = K;
            a.this.bDn.a(a.this.mPageContext, resources.getString(i2, objArr), new b.a() { // from class: com.baidu.live.talentshow.a.10.1
                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Qd() {
                    if (a.this.bDk != null) {
                        a.this.bDk.bn(j);
                    }
                }

                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Qe() {
                }
            });
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0207a
        public void b(View view, boolean z) {
        }
    };
    private f bDA = new f() { // from class: com.baidu.live.talentshow.a.11
        @Override // com.baidu.live.talentshow.d.f
        public void f(String str, JSONObject jSONObject) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
            a.this.e(str, jSONObject);
        }

        @Override // com.baidu.live.talentshow.d.f
        public void Rw() {
            a.this.bDm.d(a.this.bDh);
            a.this.bDm.Sb();
            if (a.this.bDq != null) {
                a.this.bDq.setEnabled(false);
            }
            if (a.this.bDg != null && a.this.bDg.getPreview() != null && a.this.bDg.getPreview().getParent() != null) {
                ((ViewGroup) a.this.bDg.getPreview().getParent()).removeView(a.this.bDg.getPreview());
                a.this.bDh.addView(a.this.bDg.getPreview());
            }
            a.this.bDm.a(a.this.bDg.getPreview(), 0, 0L, true, false);
            a.this.bDg.startRecord();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void bj(long j) {
            a.this.Rt();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void c(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStopChatResult imUK=" + j + " index=" + i + " erroCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bHt && a.this.bDm != null) {
                a.this.bDm.eg(i);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void d(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStartChatResult imUK=" + j + " index=" + i + " errorCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bHm) {
                a.this.hO(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bHn) {
                a.this.hO(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bHs) {
                a.this.hO(a.this.mPageContext.getString(a.h.talent_invite_timeout));
                if (a.this.bDm != null) {
                    a.this.bDm.eg(i);
                }
            } else if (i2 == 0) {
                a.this.bDm.a(i, j, true, true);
                a.this.Rt();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void e(long j, int i, int i2) {
            if (i2 == com.baidu.live.talentshow.d.d.bHo) {
                a.this.hO(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.bDm != null) {
                    a.this.bDm.eg(i);
                }
            } else if (i2 == com.baidu.live.talentshow.d.d.bHp) {
                a.this.hO(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bHr) {
                a.this.hO(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.bDm != null) {
                    a.this.bDm.eg(i);
                }
            }
            a.this.Rt();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void hP(String str) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            if (a.this.bDl != null) {
                if (a.this.bDk.isFull()) {
                    a.this.bDl.Su();
                    return;
                }
                a.this.bDl.ag(a.this.ac(a.this.bDl.St()));
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void g(long j, int i) {
            View bm = a.this.bDk.bm(j);
            BdLog.e("BCVideoChat blmsdk" + bm + "|imuk=" + j + "|index=" + i);
            if (bm != null) {
                a.this.bDm.a(bm, i, j, true, false);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(com.baidu.live.talentshow.d.a.b bVar, int i) {
            if (i >= 15 && a.this.bDm != null) {
                a.this.bDm.eg(bVar.index);
                a.this.bDk.bn(bVar.bHN.azK);
                String string = a.this.mPageContext.getString(a.h.talent_close_chat);
                if (a.this.bDl == null) {
                    a.this.mPageContext.showToast(string);
                    return;
                }
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.K(a.this.bDl.bk(bVar.bHN.azK), 16) + string);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void h(long j, int i) {
            if (a.this.bDm != null) {
                a.this.bDm.eg(i);
            }
            if (a.this.bDl != null) {
                a.this.bDl.Su();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void i(long j, int i) {
            if (a.this.bDm != null) {
                a.this.bDm.eg(i);
            }
            String string = a.this.mPageContext.getString(a.h.talent_close_chat);
            if (a.this.bDl == null) {
                a.this.mPageContext.showToast(string);
            } else {
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.K(a.this.bDl.bk(j), 16) + string);
            }
            if (a.this.bDl != null) {
                a.this.bDl.Su();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void ea(int i) {
            if (i >= 15 && a.this.bDk != null) {
                a.this.bDk.SP();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(c cVar) {
            if (a.this.bDp != null) {
                a.this.bDp.c(cVar);
            }
        }
    };
    private CustomMessageListener bDB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.talentshow.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                boolean booleanValue = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (a.this.bDk != null) {
                    if (booleanValue) {
                        a.this.bDk.onBackground();
                    } else {
                        a.this.bDk.onForeground();
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        com.baidu.live.alablmsdk.a.ba(TbadkCoreApplication.getInst().isDebugMode());
        this.mPageContext = tbPageContext;
        this.bDp = new com.baidu.live.talentshow.model.d(tbPageContext);
        this.bDo = new com.baidu.live.talentshow.components.selector.b(tbPageContext);
        this.bDo.a(this.bDu);
        this.bDo.a(this.bDv);
        this.bDk = new g();
        this.bDk.init(tbPageContext.getPageActivity());
        this.bDk.a(this.bDA);
        this.bDm = new com.baidu.live.talentshow.components.b.b(tbPageContext.getPageActivity(), this.bDz);
        this.bDi = new com.baidu.live.talentshow.components.enter.a(tbPageContext, true);
        this.bDi.a(this.bDw);
        bb(tbPageContext.getPageActivity());
        BdLog.e("BCVideoChat  cuid=" + TbadkCoreApplication.getInst().getCuid() + " imUK=" + AccountManager.getUK(TbadkCoreApplication.getInst()));
        MessageManager.getInstance().registerListener(this.bDB);
    }

    @Override // com.baidu.live.am.b
    public void J(Object obj) {
        if (this.bDk != null && (obj instanceof AlaLiveRecorder)) {
            this.bDk.a((AlaLiveRecorder) obj);
            this.bDg = (AlaLiveRecorder) obj;
        }
    }

    @Override // com.baidu.live.am.b
    public void setLiveShowData(ab abVar) {
        this.aED = abVar;
        if (this.bDo != null) {
            this.bDo.u(this.aED);
        }
        if (this.bDk != null && abVar != null) {
            this.bDk.setLiveShowData(abVar);
        }
        if (this.bDi != null && abVar != null) {
            this.bDi.t(abVar);
        }
        BdLog.e("BCVideoChat liveID=" + abVar.mLiveInfo.live_id + " roomID=" + abVar.mLiveInfo.room_id + " pushUrl=" + abVar.mLiveInfo.getPushUrl());
    }

    @Override // com.baidu.live.am.b
    public void ac(JSONObject jSONObject) {
        jSONObject.optLong("uid");
        if (this.bDi != null) {
            this.bDi.ed(1);
        }
    }

    @Override // com.baidu.live.am.b
    public void Y(View view) {
        this.bDq = view;
    }

    @Override // com.baidu.live.am.b
    public void Ro() {
        if (this.bDk != null) {
            this.bDk.SP();
        }
    }

    @Override // com.baidu.live.am.b
    public boolean Rp() {
        if (this.bDk != null) {
            return this.bDk.SN() || this.bDk.SO();
        }
        return false;
    }

    @Override // com.baidu.live.am.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Rq()) {
            return true;
        }
        if (this.bDn != null) {
            this.bDn.onDestroy();
            this.bDn = null;
        }
        return false;
    }

    @Override // com.baidu.live.am.b
    public void setMute(boolean z) {
        if (this.bDk != null) {
            this.bDk.setMute(z);
        }
    }

    @Override // com.baidu.live.am.b
    public void onDestroy() {
        if (this.bDn != null) {
            this.bDn.onDestroy();
            this.bDn = null;
        }
        if (this.bDj != null) {
            this.bDj.listen(this.mPhoneStateListener, 0);
            this.bDj = null;
        }
        if (this.bDk != null) {
            this.bDk.onDestroy();
            this.bDk = null;
        }
        if (this.bDo != null) {
            this.bDo.onDestroy();
            this.bDo = null;
        }
        if (this.bDp != null) {
            this.bDp.onDestroy();
            this.bDp = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bDB);
    }

    @Override // com.baidu.live.am.b
    public boolean Rq() {
        if (this.bDr == null) {
            this.bDr = new com.baidu.live.talentshow.components.a.b();
        }
        boolean z = this.bDr != null && (this.bDk.SN() || this.bDk.SO());
        if (z) {
            this.bDr.a(this.mPageContext, this.mPageContext.getResources().getString(a.h.linkmic_close_confirm), this.bDt);
        }
        return z;
    }

    @Override // com.baidu.live.am.b
    public void a(com.baidu.live.am.a aVar) {
        this.bDs = aVar;
    }

    @Override // com.baidu.live.am.b
    public void a(FrameLayout frameLayout) {
        this.bDh = frameLayout;
    }

    @Override // com.baidu.live.am.b
    public View getEnterView() {
        if (this.bDi != null) {
            return this.bDi.getEnterView();
        }
        return null;
    }

    private void bb(Context context) {
        this.bDj = (TelephonyManager) context.getSystemService("phone");
        if (this.bDj != null) {
            this.bDj.listen(this.mPhoneStateListener, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Rr() {
        if (this.bDs == null) {
            return true;
        }
        return this.bDs.Rr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rs() {
        if (this.bDl == null) {
            this.bDl = new d(this.mPageContext.getPageActivity());
            this.bDl.a(this.bDy);
            this.bDl.a(this.bDx);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bDl.Rs();
        } else {
            this.bDl.Ss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.talentshow.b.d dVar) {
        if (dVar != null) {
            BdLog.e("BCVideoChat master controller: start chat " + dVar.nickName);
            com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
            bVar.uid = dVar.uid;
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.azK = JavaTypesHelper.toLong(dVar.bGL, 0L);
            cVar.cuid = dVar.cuid;
            cVar.azQ = dVar.uk;
            cVar.userName = dVar.nickName;
            cVar.appId = JavaTypesHelper.toLong(dVar.appid, 0L);
            cVar.appVersion = TbConfig.getVersion();
            bVar.bHN = cVar;
            int a2 = this.bDk.a(bVar);
            if (a2 == -2) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_invite_others));
            } else if (a2 < 0) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, JSONObject jSONObject) {
        this.bDm.eg(0);
        this.bDm.Sa();
        if (this.bDg != null && this.bDg.getPreview() != null && this.bDg.getPreview().getParent() != null) {
            ((ViewGroup) this.bDg.getPreview().getParent()).removeView(this.bDg.getPreview());
        }
        if (this.bDg != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(this.bDg.getPreview(), 0.0f);
            }
            this.bDh.addView(this.bDg.getPreview(), 0);
            this.bDg.startRecord();
            if (this.bDq != null) {
                this.bDq.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rt() {
        long j;
        long j2;
        if (this.bDo != null) {
            if (this.bDk != null) {
                j2 = this.bDk.ei(1);
                j = this.bDk.ei(2);
            } else {
                j = 0;
                j2 = 0;
            }
            this.bDo.b(1, j2, j);
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
    public List<com.baidu.live.talentshow.b.d> ac(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null && !ListUtils.isEmpty(list) && this.bDk != null) {
            for (com.baidu.live.talentshow.b.d dVar : list) {
                int bl = this.bDk.bl(JavaTypesHelper.toLong(dVar.bGL, 0L));
                BdLog.e("BCVideoChat chat user local state " + bl + " isFull " + this.bDk.isFull());
                if (bl == -1) {
                    bl = com.baidu.live.talentshow.d.d.bHg;
                }
                if (this.bDk.isFull() && bl != com.baidu.live.talentshow.d.d.bHk && bl != com.baidu.live.talentshow.d.d.bHj && list.size() > 2) {
                    bl = 5;
                }
                dVar.status = bl;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(String str) {
        if (this.mPageContext != null) {
            this.mPageContext.showToast(str);
        }
    }
}
