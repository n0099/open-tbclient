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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.am.b {
    private ab aDd;
    private AlaLiveRecorder bBG;
    private FrameLayout bBH;
    private com.baidu.live.talentshow.components.enter.a bBI;
    private TelephonyManager bBJ;
    private com.baidu.live.talentshow.d.a bBK;
    private d bBL;
    private com.baidu.live.talentshow.components.b.b bBM;
    private com.baidu.live.talentshow.components.a.b bBN;
    private com.baidu.live.talentshow.components.selector.b bBO;
    private com.baidu.live.talentshow.model.d bBP;
    private View bBQ;
    private com.baidu.live.talentshow.components.a.b bBR;
    private com.baidu.live.am.a bBS;
    private TbPageContext mPageContext;
    private b.a bBT = new b.a() { // from class: com.baidu.live.talentshow.a.1
        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Qa() {
            if (a.this.bBK != null) {
                a.this.bBK.SM();
            }
        }

        @Override // com.baidu.live.talentshow.components.a.b.a
        public void Qb() {
        }
    };
    private com.baidu.live.talentshow.c.b bBU = new com.baidu.live.talentshow.c.b() { // from class: com.baidu.live.talentshow.a.4
        @Override // com.baidu.live.talentshow.c.b
        public void ad(List<com.baidu.live.talentshow.b.d> list) {
            a.this.bBL.ag(a.this.ac(list));
        }

        @Override // com.baidu.live.talentshow.c.b
        public void C(int i, String str) {
            a.this.hI(str);
        }
    };
    private com.baidu.live.talentshow.c.a bBV = new com.baidu.live.talentshow.c.a() { // from class: com.baidu.live.talentshow.a.5
        @Override // com.baidu.live.talentshow.c.a
        public void a(int i, String str, com.baidu.live.talentshow.b.d dVar) {
            if (i == 1) {
                a.this.a(dVar);
                return;
            }
            a.this.hI(str);
            a.this.Rq();
        }

        @Override // com.baidu.live.talentshow.c.a
        public void D(int i, String str) {
            a.this.hI(str);
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
                    if (a.this.bBK != null) {
                        a.this.bBK.SM();
                        break;
                    }
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private com.baidu.live.talentshow.components.enter.b bBW = new com.baidu.live.talentshow.components.enter.b() { // from class: com.baidu.live.talentshow.a.7
        @Override // com.baidu.live.talentshow.components.enter.b
        public void Z(View view) {
            if (a.this.Ro()) {
                a.this.Rp();
            }
            com.baidu.live.talentshow.e.a.Tp();
        }
    };
    private LiveBCMasterChatSelectorLayer.a bBX = new LiveBCMasterChatSelectorLayer.a() { // from class: com.baidu.live.talentshow.a.8
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Rr() {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a.this.Rq();
            }
            com.baidu.live.talentshow.e.a.To();
        }

        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.a
        public void Rs() {
        }
    };
    private LiveBCMasterChatSelectorLayer.b bBY = new LiveBCMasterChatSelectorLayer.b() { // from class: com.baidu.live.talentshow.a.9
        @Override // com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer.b
        public void b(com.baidu.live.talentshow.b.d dVar) {
            long j;
            long j2;
            if (dVar.status == 5) {
                a.this.hI(a.this.mPageContext.getString(a.h.talent_chat_queue_is_full));
                return;
            }
            if (a.this.bBO != null) {
                if (a.this.bBK != null) {
                    j2 = a.this.bBK.eh(1);
                    j = a.this.bBK.eh(2);
                } else {
                    j = 0;
                    j2 = 0;
                }
                a.this.bBO.a(dVar, j2, j);
            }
            com.baidu.live.talentshow.e.a.Tn();
        }
    };
    private a.InterfaceC0201a bBZ = new a.InterfaceC0201a() { // from class: com.baidu.live.talentshow.a.10
        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0201a
        public void a(View view, int i, final long j) {
            if (a.this.bBN == null) {
                a.this.bBN = new com.baidu.live.talentshow.components.a.b();
            }
            String K = com.baidu.live.videochat.d.K(a.this.bBK.bo(j), 16);
            Resources resources = a.this.mPageContext.getResources();
            int i2 = a.h.linkmic_close_confirm_with_user_name;
            Object[] objArr = new Object[1];
            if (K == null) {
                K = "";
            }
            objArr[0] = K;
            a.this.bBN.a(a.this.mPageContext, resources.getString(i2, objArr), new b.a() { // from class: com.baidu.live.talentshow.a.10.1
                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Qa() {
                    if (a.this.bBK != null) {
                        a.this.bBK.bn(j);
                    }
                }

                @Override // com.baidu.live.talentshow.components.a.b.a
                public void Qb() {
                }
            });
        }

        @Override // com.baidu.live.talentshow.components.b.a.InterfaceC0201a
        public void b(View view, boolean z) {
        }
    };
    private f bCa = new f() { // from class: com.baidu.live.talentshow.a.11
        @Override // com.baidu.live.talentshow.d.f
        public void e(String str, JSONObject jSONObject) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913302));
            a.this.d(str, jSONObject);
        }

        @Override // com.baidu.live.talentshow.d.f
        public void Rt() {
            a.this.bBM.d(a.this.bBH);
            a.this.bBM.RY();
            if (a.this.bBQ != null) {
                a.this.bBQ.setEnabled(false);
            }
            if (a.this.bBG != null && a.this.bBG.getPreview() != null && a.this.bBG.getPreview().getParent() != null) {
                ((ViewGroup) a.this.bBG.getPreview().getParent()).removeView(a.this.bBG.getPreview());
                a.this.bBH.addView(a.this.bBG.getPreview());
            }
            a.this.bBM.a(a.this.bBG.getPreview(), 0, 0L, true, false);
            a.this.bBG.startRecord();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void bj(long j) {
            a.this.Rq();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void c(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStopChatResult imUK=" + j + " index=" + i + " erroCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bFT && a.this.bBM != null) {
                a.this.bBM.ef(i);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void d(long j, int i, int i2) {
            BdLog.e("BCVideoChat onStartChatResult imUK=" + j + " index=" + i + " errorCode=" + i2);
            if (i2 == com.baidu.live.talentshow.d.d.bFM) {
                a.this.hI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bFN) {
                a.this.hI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bFS) {
                a.this.hI(a.this.mPageContext.getString(a.h.talent_invite_timeout));
                if (a.this.bBM != null) {
                    a.this.bBM.ef(i);
                }
            } else if (i2 == 0) {
                a.this.bBM.a(i, j, true, true);
                a.this.Rq();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void e(long j, int i, int i2) {
            if (i2 == com.baidu.live.talentshow.d.d.bFO) {
                a.this.hI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.bBM != null) {
                    a.this.bBM.ef(i);
                }
            } else if (i2 == com.baidu.live.talentshow.d.d.bFP) {
                a.this.hI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            } else if (i2 == com.baidu.live.talentshow.d.d.bFR) {
                a.this.hI(a.this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
                if (a.this.bBM != null) {
                    a.this.bBM.ef(i);
                }
            }
            a.this.Rq();
        }

        @Override // com.baidu.live.talentshow.d.f
        public void hJ(String str) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913301));
            if (a.this.bBL != null) {
                if (a.this.bBK.isFull()) {
                    a.this.bBL.Sr();
                    return;
                }
                a.this.bBL.ag(a.this.ac(a.this.bBL.Sq()));
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void g(long j, int i) {
            View bm = a.this.bBK.bm(j);
            BdLog.e("BCVideoChat blmsdk" + bm + "|imuk=" + j + "|index=" + i);
            if (bm != null) {
                a.this.bBM.a(bm, i, j, true, false);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(com.baidu.live.talentshow.d.a.b bVar, int i) {
            if (i >= 15 && a.this.bBM != null) {
                a.this.bBM.ef(bVar.index);
                a.this.bBK.bn(bVar.bGn.ayk);
                String string = a.this.mPageContext.getString(a.h.talent_close_chat);
                if (a.this.bBL == null) {
                    a.this.mPageContext.showToast(string);
                    return;
                }
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.K(a.this.bBL.bk(bVar.bGn.ayk), 16) + string);
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void h(long j, int i) {
            if (a.this.bBM != null) {
                a.this.bBM.ef(i);
            }
            if (a.this.bBL != null) {
                a.this.bBL.Sr();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void i(long j, int i) {
            if (a.this.bBM != null) {
                a.this.bBM.ef(i);
            }
            String string = a.this.mPageContext.getString(a.h.talent_close_chat);
            if (a.this.bBL == null) {
                a.this.mPageContext.showToast(string);
            } else {
                a.this.mPageContext.showToast(com.baidu.live.videochat.d.K(a.this.bBL.bk(j), 16) + string);
            }
            if (a.this.bBL != null) {
                a.this.bBL.Sr();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void dZ(int i) {
            if (i >= 15 && a.this.bBK != null) {
                a.this.bBK.SM();
            }
        }

        @Override // com.baidu.live.talentshow.d.f
        public void a(c cVar) {
            if (a.this.bBP != null) {
                a.this.bBP.c(cVar);
            }
        }
    };
    private CustomMessageListener bCb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.talentshow.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                boolean booleanValue = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (a.this.bBK != null) {
                    if (booleanValue) {
                        a.this.bBK.onBackground();
                    } else {
                        a.this.bBK.onForeground();
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        com.baidu.live.alablmsdk.a.ba(TbadkCoreApplication.getInst().isDebugMode());
        this.mPageContext = tbPageContext;
        this.bBP = new com.baidu.live.talentshow.model.d(tbPageContext);
        this.bBO = new com.baidu.live.talentshow.components.selector.b(tbPageContext);
        this.bBO.a(this.bBU);
        this.bBO.a(this.bBV);
        this.bBK = new g();
        this.bBK.init(tbPageContext.getPageActivity());
        this.bBK.a(this.bCa);
        this.bBM = new com.baidu.live.talentshow.components.b.b(tbPageContext.getPageActivity(), this.bBZ);
        this.bBI = new com.baidu.live.talentshow.components.enter.a(tbPageContext, true);
        this.bBI.a(this.bBW);
        bc(tbPageContext.getPageActivity());
        BdLog.e("BCVideoChat  cuid=" + TbadkCoreApplication.getInst().getCuid() + " imUK=" + AccountManager.getUK(TbadkCoreApplication.getInst()));
        MessageManager.getInstance().registerListener(this.bCb);
    }

    @Override // com.baidu.live.am.b
    public void H(Object obj) {
        if (this.bBK != null && (obj instanceof AlaLiveRecorder)) {
            this.bBK.a((AlaLiveRecorder) obj);
            this.bBG = (AlaLiveRecorder) obj;
        }
    }

    @Override // com.baidu.live.am.b
    public void setLiveShowData(ab abVar) {
        this.aDd = abVar;
        if (this.bBO != null) {
            this.bBO.u(this.aDd);
        }
        if (this.bBK != null && abVar != null) {
            this.bBK.setLiveShowData(abVar);
        }
        if (this.bBI != null && abVar != null) {
            this.bBI.t(abVar);
        }
        BdLog.e("BCVideoChat liveID=" + abVar.mLiveInfo.live_id + " roomID=" + abVar.mLiveInfo.room_id + " pushUrl=" + abVar.mLiveInfo.getPushUrl());
    }

    @Override // com.baidu.live.am.b
    public void aa(JSONObject jSONObject) {
        jSONObject.optLong("uid");
        if (this.bBI != null) {
            this.bBI.ec(1);
        }
    }

    @Override // com.baidu.live.am.b
    public void Y(View view) {
        this.bBQ = view;
    }

    @Override // com.baidu.live.am.b
    public void Rl() {
        if (this.bBK != null) {
            this.bBK.SM();
        }
    }

    @Override // com.baidu.live.am.b
    public boolean Rm() {
        if (this.bBK != null) {
            return this.bBK.SK() || this.bBK.SL();
        }
        return false;
    }

    @Override // com.baidu.live.am.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Rn()) {
            return true;
        }
        if (this.bBN != null) {
            this.bBN.onDestroy();
            this.bBN = null;
        }
        return false;
    }

    @Override // com.baidu.live.am.b
    public void setMute(boolean z) {
        if (this.bBK != null) {
            this.bBK.setMute(z);
        }
    }

    @Override // com.baidu.live.am.b
    public void onDestroy() {
        if (this.bBN != null) {
            this.bBN.onDestroy();
            this.bBN = null;
        }
        if (this.bBJ != null) {
            this.bBJ.listen(this.mPhoneStateListener, 0);
            this.bBJ = null;
        }
        if (this.bBK != null) {
            this.bBK.onDestroy();
            this.bBK = null;
        }
        if (this.bBO != null) {
            this.bBO.onDestroy();
            this.bBO = null;
        }
        if (this.bBP != null) {
            this.bBP.onDestroy();
            this.bBP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bCb);
    }

    @Override // com.baidu.live.am.b
    public boolean Rn() {
        if (this.bBR == null) {
            this.bBR = new com.baidu.live.talentshow.components.a.b();
        }
        boolean z = this.bBR != null && (this.bBK.SK() || this.bBK.SL());
        if (z) {
            this.bBR.a(this.mPageContext, this.mPageContext.getResources().getString(a.h.linkmic_close_confirm), this.bBT);
        }
        return z;
    }

    @Override // com.baidu.live.am.b
    public void a(com.baidu.live.am.a aVar) {
        this.bBS = aVar;
    }

    @Override // com.baidu.live.am.b
    public void a(FrameLayout frameLayout) {
        this.bBH = frameLayout;
    }

    @Override // com.baidu.live.am.b
    public View getEnterView() {
        if (this.bBI != null) {
            return this.bBI.getEnterView();
        }
        return null;
    }

    private void bc(Context context) {
        this.bBJ = (TelephonyManager) context.getSystemService("phone");
        if (this.bBJ != null) {
            this.bBJ.listen(this.mPhoneStateListener, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ro() {
        if (this.bBS == null) {
            return true;
        }
        return this.bBS.Ro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rp() {
        if (this.bBL == null) {
            this.bBL = new d(this.mPageContext.getPageActivity());
            this.bBL.a(this.bBY);
            this.bBL.a(this.bBX);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bBL.Rp();
        } else {
            this.bBL.Sp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.talentshow.b.d dVar) {
        if (dVar != null) {
            BdLog.e("BCVideoChat master controller: start chat " + dVar.nickName);
            com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
            bVar.uid = dVar.uid;
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.ayk = JavaTypesHelper.toLong(dVar.bFl, 0L);
            cVar.cuid = dVar.cuid;
            cVar.ayq = dVar.uk;
            cVar.userName = dVar.nickName;
            cVar.appId = JavaTypesHelper.toLong(dVar.appid, 0L);
            cVar.appVersion = TbConfig.getVersion();
            bVar.bGn = cVar;
            int a2 = this.bBK.a(bVar);
            if (a2 == -2) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_invite_others));
            } else if (a2 < 0) {
                this.mPageContext.showToast(this.mPageContext.getString(a.h.talent_chat_start_chat_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, JSONObject jSONObject) {
        this.bBM.ef(0);
        this.bBM.RX();
        if (this.bBG != null && this.bBG.getPreview() != null && this.bBG.getPreview().getParent() != null) {
            ((ViewGroup) this.bBG.getPreview().getParent()).removeView(this.bBG.getPreview());
        }
        if (this.bBG != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(this.bBG.getPreview(), 0.0f);
            }
            this.bBH.addView(this.bBG.getPreview(), 0);
            this.bBG.startRecord();
            if (this.bBQ != null) {
                this.bBQ.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rq() {
        long j;
        long j2;
        if (this.bBO != null) {
            if (this.bBK != null) {
                j2 = this.bBK.eh(1);
                j = this.bBK.eh(2);
            } else {
                j = 0;
                j2 = 0;
            }
            this.bBO.b(1, j2, j);
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
        if (list != null && !ListUtils.isEmpty(list) && this.bBK != null) {
            for (com.baidu.live.talentshow.b.d dVar : list) {
                int bl = this.bBK.bl(JavaTypesHelper.toLong(dVar.bFl, 0L));
                BdLog.e("BCVideoChat chat user local state " + bl + " isFull " + this.bBK.isFull());
                if (bl == -1) {
                    bl = com.baidu.live.talentshow.d.d.bFG;
                }
                if (this.bBK.isFull() && bl != com.baidu.live.talentshow.d.d.bFK && bl != com.baidu.live.talentshow.d.d.bFJ && list.size() > 2) {
                    bl = 5;
                }
                dVar.status = bl;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(String str) {
        if (this.mPageContext != null) {
            this.mPageContext.showToast(str);
        }
    }
}
