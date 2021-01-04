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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.ao.b {
    private x aGe;
    private AlaLiveRecorder bCM;
    private FrameLayout bCN;
    private com.baidu.live.talentshow.components.enter.a bCO;
    private TelephonyManager bCP;
    private com.baidu.live.talentshow.d.a bCQ;
    private d bCR;
    private com.baidu.live.talentshow.components.b.b bCS;
    private com.baidu.live.talentshow.components.a.b bCT;
    private com.baidu.live.talentshow.components.selector.b bCU;
    private com.baidu.live.talentshow.model.d bCV;
    private View bCW;
    private com.baidu.live.talentshow.components.a.b bCX;
    private com.baidu.live.ao.a bCY;
    private TbPageContext mPageContext;
    private b.a bCZ = new b.a() { // from class: com.baidu.live.talentshow.a.1
        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Sw() {
            if (a.this.bCQ != null) {
                a.this.bCQ.UY();
            }
        }

        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Sx() {
        }
    };
    private com.baidu.live.talentshow.c.b bDa = new com.baidu.live.talentshow.c.b() { // from class: com.baidu.live.talentshow.a.4
        @Override // com.baidu.live.talentshow.c.b
        public void ac(List<com.baidu.live.talentshow.b.d> list) {
            a.this.bCR.af(a.this.ab(list));
        }

        @Override // com.baidu.live.talentshow.c.b
        public void x(int i, String str) {
            a.this.ix(str);
        }
    };
    private com.baidu.live.talentshow.c.a bDb = new com.baidu.live.talentshow.c.a() { // from class: com.baidu.live.talentshow.a.5
        @Override // com.baidu.live.talentshow.c.a
        public void a(int i, String str, com.baidu.live.talentshow.b.d dVar) {
            if (i == 1) {
                a.this.a(dVar);
                return;
            }
            a.this.ix(str);
            a.this.TB();
        }

        @Override // com.baidu.live.talentshow.c.a
        public void y(int i, String str) {
            a.this.ix(str);
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
                    if (a.this.bCQ != null) {
                        a.this.bCQ.UY();
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.talentshow.components.enter.b bDc = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.a.7
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (a.this.Tz()) {
                a.this.TA();
            }
            com.baidu.live.talentshow.e.a.VB();
        }
    };
    private LiveBCMasterChatSelectorLayer.a bDd = new LiveBCMasterChatSelectorLayer.a() { // from class: com.baidu.live.talentshow.a.8
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void TC() {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a.this.TB();
            }
            com.baidu.live.talentshow.e.a.VA();
        }

        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void TD() {
        }
    };
    private LiveBCMasterChatSelectorLayer.b bDe = new LiveBCMasterChatSelectorLayer.b() { // from class: com.baidu.live.talentshow.a.9
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.b
        public void b(com.baidu.live.talentshow.b.d dVar) {
            long j;
            long j2;
            if (dVar.status == 5) {
                a.this.ix(a.this.mPageContext.getString(a.h.talent_chat_queue_is_full));
                return;
            }
            if (a.this.bCU != null) {
                if (a.this.bCQ != null) {
                    j2 = a.this.bCQ.fJ(1);
                    j = a.this.bCQ.fJ(2);
                } else {
                    j = 0;
                    j2 = 0;
                }
                a.this.bCU.a(dVar, j2, j);
            }
            com.baidu.live.talentshow.e.a.Vz();
        }
    };
    private a.InterfaceC0208a bDf = new a.InterfaceC0208a() { // from class: com.baidu.live.talentshow.a.10
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0208a
        public void a(View view, int i, final long j) {
            if (a.this.bCT == null) {
                a.this.bCT = new com.baidu.live.talentshow.components.a.b();
            }
            String J = com.baidu.live.videochat.d.J(a.this.bCQ.bk(j), 16);
            Resources resources = a.this.mPageContext.getResources();
            int i2 = a.h.linkmic_close_confirm_with_user_name;
            Object[] objArr = new Object[1];
            if (J == null) {
                J = "";
            }
            objArr[0] = J;
            a.this.bCT.a(a.this.mPageContext, resources.getString(i2, objArr), new b.a() { // from class: com.baidu.live.talentshow.a.10.1
                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Sw() {
                    if (a.this.bCQ != null) {
                        a.this.bCQ.bj(j);
                    }
                }

                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Sx() {
                }
            });
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0208a
        public void b(View view, boolean z) {
        }
    };
    private f bDg = new f() { // from class: com.baidu.live.talentshow.a.11
        @Override // com.baidu.live.talentshow.d.f
        public void e(String str, JSONObject jSONObject) {
            a.this.d(str, jSONObject);
        }

        @Override // com.baidu.live.talentshow.d.f
        public void TE() {
            a.this.bCS.d(a.this.bCN);
            a.this.bCS.Uj();
            if (a.this.bCW != null) {
                a.this.bCW.setEnabled(false);
            }
            if (a.this.bCM != null && a.this.bCM.getPreview() != null && a.this.bCM.getPreview().getParent() != null) {
                ((ViewGroup) a.this.bCM.getPreview().getParent()).removeView(a.this.bCM.getPreview());
                a.this.bCN.addView(a.this.bCM.getPreview());
            }
            a.this.bCS.a(a.this.bCM.getPreview(), 0, 0L, true, false);
            a.this.bCM.startRecord();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void bf(long j) {
            a.this.TB();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void c(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStopChatResult imUK=" + j + " index=" + i + " erroCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bGW && a.this.bCS != null) {
                a.this.bCS.fH(i);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void d(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStartChatResult imUK=" + j + " index=" + i + " errorCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bGP) {
                a.this.ix(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bGQ) {
                a.this.ix(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bGV) {
                a.this.ix(a.this.mPageContext.getString(a.h.talent_invite_timeout));
                if (a.this.bCS != null) {
                    a.this.bCS.fH(i);
                }
            } else if (i2 == 0) {
                a.this.bCS.a(i, j, true, true);
                a.this.TB();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void e(long j, int i, int i2) {
            if (i2 == com.baidu.live.talentshow.d.d.bGR) {
                a.this.ix(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.bCS != null) {
                    a.this.bCS.fH(i);
                }
            } else if (i2 == com.baidu.live.talentshow.d.d.bGS) {
                a.this.ix(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bGU) {
                a.this.ix(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.bCS != null) {
                    a.this.bCS.fH(i);
                }
            }
            a.this.TB();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void iy(String str) {
            if (a.this.bCR != null) {
                if (a.this.bCQ.isFull()) {
                    a.this.bCR.UC();
                    return;
                }
                a.this.bCR.af(a.this.ab(a.this.bCR.UB()));
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void g(long j, int i) {
            View bi = a.this.bCQ.bi(j);
            BdLog.e("BCVideoChat blmsdk" + bi + "|imuk=" + j + "|index=" + i);
            if (bi != null) {
                a.this.bCS.a(bi, i, j, true, false);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(com.baidu.live.talentshow.d.a.b bVar, int i) {
            if (i >= 15 && a.this.bCS != null) {
                a.this.bCS.fH(bVar.index);
                a.this.bCQ.bj(bVar.bHp.aCG);
                String string = a.this.mPageContext.getString(a.h.talent_close_chat);
                if (a.this.bCR == null) {
                    a.this.mPageContext.showToast(string);
                    return;
                }
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.J(a.this.bCR.bg(bVar.bHp.aCG), 16) + string);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void h(long j, int i) {
            if (a.this.bCS != null) {
                a.this.bCS.fH(i);
            }
            if (a.this.bCR != null) {
                a.this.bCR.UC();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void i(long j, int i) {
            if (a.this.bCS != null) {
                a.this.bCS.fH(i);
            }
            String string = a.this.mPageContext.getString(a.h.talent_close_chat);
            if (a.this.bCR == null) {
                a.this.mPageContext.showToast(string);
            } else {
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.J(a.this.bCR.bg(j), 16) + string);
            }
            if (a.this.bCR != null) {
                a.this.bCR.UC();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void fB(int i) {
            if (i >= 15 && a.this.bCQ != null) {
                a.this.bCQ.UY();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(c cVar) {
            if (a.this.bCV != null) {
                a.this.bCV.c(cVar);
            }
        }
    };
    private CustomMessageListener bDh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.talentshow.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                boolean booleanValue = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (a.this.bCQ != null) {
                    if (booleanValue) {
                        a.this.bCQ.onBackground();
                    } else {
                        a.this.bCQ.onForeground();
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        com.baidu.live.alablmsdk.a.be(TbadkCoreApplication.getInst().isDebugMode());
        this.mPageContext = tbPageContext;
        this.bCV = new com.baidu.live.talentshow.model.d(tbPageContext);
        this.bCU = new com.baidu.live.talentshow.components.selector.b(tbPageContext);
        this.bCU.a(this.bDa);
        this.bCU.a(this.bDb);
        this.bCQ = new g();
        this.bCQ.init(tbPageContext.getPageActivity());
        this.bCQ.a(this.bDg);
        this.bCS = new com.baidu.live.talentshow.components.b.b(tbPageContext.getPageActivity(), this.bDf);
        this.bCO = new com.baidu.live.talentshow.components.enter.a(tbPageContext, true);
        this.bCO.a(this.bDc);
        bd(tbPageContext.getPageActivity());
        BdLog.e("BCVideoChat  cuid=" + TbadkCoreApplication.getInst().getCuid() + " imUK=" + AccountManager.getUK(TbadkCoreApplication.getInst()));
        MessageManager.getInstance().registerListener(this.bDh);
    }

    @Override // com.baidu.live.ao.b
    public void H(Object obj) {
        if (this.bCQ != null && (obj instanceof AlaLiveRecorder)) {
            this.bCQ.a((AlaLiveRecorder) obj);
            this.bCM = (AlaLiveRecorder) obj;
        }
    }

    @Override // com.baidu.live.ao.b
    public void setLiveShowData(x xVar) {
        this.aGe = xVar;
        if (this.bCU != null) {
            this.bCU.u(this.aGe);
        }
        if (this.bCQ != null && xVar != null) {
            this.bCQ.setLiveShowData(xVar);
        }
        if (this.bCO != null && xVar != null) {
            this.bCO.t(xVar);
        }
        BdLog.e("BCVideoChat liveID=" + xVar.mLiveInfo.live_id + " roomID=" + xVar.mLiveInfo.room_id + " pushUrl=" + xVar.mLiveInfo.getPushUrl());
    }

    @Override // com.baidu.live.ao.b
    public void Y(JSONObject jSONObject) {
        jSONObject.optLong("uid");
        if (this.bCO != null) {
            this.bCO.fE(1);
        }
    }

    @Override // com.baidu.live.ao.b
    public void Y(View view) {
        this.bCW = view;
    }

    @Override // com.baidu.live.ao.b
    public void Tw() {
        if (this.bCQ != null) {
            this.bCQ.UY();
        }
    }

    @Override // com.baidu.live.ao.b
    public boolean Tx() {
        if (this.bCQ != null) {
            return this.bCQ.UW() || this.bCQ.UX();
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Ty()) {
            return true;
        }
        if (this.bCT != null) {
            this.bCT.onDestroy();
            this.bCT = null;
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public void setMute(boolean z) {
        if (this.bCQ != null) {
            this.bCQ.setMute(z);
        }
    }

    @Override // com.baidu.live.ao.b
    public void onDestroy() {
        if (this.bCT != null) {
            this.bCT.onDestroy();
            this.bCT = null;
        }
        if (this.bCP != null) {
            this.bCP.listen(this.mPhoneStateListener, 0);
            this.bCP = null;
        }
        if (this.bCQ != null) {
            this.bCQ.onDestroy();
            this.bCQ = null;
        }
        if (this.bCU != null) {
            this.bCU.onDestroy();
            this.bCU = null;
        }
        if (this.bCV != null) {
            this.bCV.onDestroy();
            this.bCV = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bDh);
    }

    @Override // com.baidu.live.ao.b
    public boolean Ty() {
        if (this.bCX == null) {
            this.bCX = new com.baidu.live.talentshow.components.a.b();
        }
        boolean z = this.bCX != null && (this.bCQ.UW() || this.bCQ.UX());
        if (z) {
            this.bCX.a(this.mPageContext, this.mPageContext.getResources().getString(a.h.linkmic_close_confirm), this.bCZ);
        }
        return z;
    }

    @Override // com.baidu.live.ao.b
    public void a(com.baidu.live.ao.a aVar) {
        this.bCY = aVar;
    }

    @Override // com.baidu.live.ao.b
    public void a(FrameLayout frameLayout) {
        this.bCN = frameLayout;
    }

    @Override // com.baidu.live.ao.b
    public View getEnterView() {
        if (this.bCO != null) {
            return this.bCO.getEnterView();
        }
        return null;
    }

    private void bd(Context context) {
        this.bCP = (TelephonyManager) context.getSystemService("phone");
        if (this.bCP != null) {
            this.bCP.listen(this.mPhoneStateListener, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Tz() {
        if (this.bCY == null) {
            return true;
        }
        return this.bCY.Tz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TA() {
        if (this.bCR == null) {
            this.bCR = new d(this.mPageContext.getPageActivity());
            this.bCR.a(this.bDe);
            this.bCR.a(this.bDd);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bCR.TA();
        } else {
            this.bCR.UA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.talentshow.b.d dVar) {
        if (dVar != null) {
            BdLog.e("BCVideoChat master controller: start chat " + dVar.nickName);
            com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
            bVar.uid = dVar.uid;
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.aCG = JavaTypesHelper.toLong(dVar.bGr, 0L);
            cVar.cuid = dVar.cuid;
            cVar.aCM = dVar.uk;
            cVar.userName = dVar.nickName;
            cVar.appId = JavaTypesHelper.toLong(dVar.appid, 0L);
            cVar.appVersion = TbConfig.getVersion();
            bVar.bHp = cVar;
            int a2 = this.bCQ.a(bVar);
            if (a2 == -2) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_invite_others));
            } else if (a2 < 0) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, JSONObject jSONObject) {
        this.bCS.fH(0);
        this.bCS.Ui();
        if (this.bCM != null && this.bCM.getPreview() != null && this.bCM.getPreview().getParent() != null) {
            ((ViewGroup) this.bCM.getPreview().getParent()).removeView(this.bCM.getPreview());
        }
        if (this.bCM != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(this.bCM.getPreview(), 0.0f);
            }
            this.bCN.addView(this.bCM.getPreview(), 0);
            this.bCM.startRecord();
            if (this.bCW != null) {
                this.bCW.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TB() {
        long j;
        long j2;
        if (this.bCU != null) {
            if (this.bCQ != null) {
                j2 = this.bCQ.fJ(1);
                j = this.bCQ.fJ(2);
            } else {
                j = 0;
                j2 = 0;
            }
            this.bCU.b(1, j2, j);
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
        if (list != null && !ListUtils.isEmpty(list) && this.bCQ != null) {
            for (com.baidu.live.talentshow.b.d dVar : list) {
                int bh = this.bCQ.bh(JavaTypesHelper.toLong(dVar.bGr, 0L));
                BdLog.e("BCVideoChat chat user local state " + bh + " isFull " + this.bCQ.isFull());
                if (bh == -1) {
                    bh = com.baidu.live.talentshow.d.d.bGJ;
                }
                if (this.bCQ.isFull() && bh != com.baidu.live.talentshow.d.d.bGN && bh != com.baidu.live.talentshow.d.d.bGM && list.size() > 2) {
                    bh = 5;
                }
                dVar.status = bh;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ix(String str) {
        if (this.mPageContext != null) {
            this.mPageContext.showToast(str);
        }
    }
}
