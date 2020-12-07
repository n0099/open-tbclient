package com.baidu.live.talentshow.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderErrorCallback;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.cp;
import com.baidu.live.data.w;
import com.baidu.live.talentshow.d.a.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements a {
    private w aFN;
    private String bBG;
    private com.baidu.live.alablmsdk.a bBI;
    private Context mContext;
    private Handler mMainHandler;
    private com.baidu.live.talentshow.d.a.a bCk = new com.baidu.live.talentshow.d.a.a();
    private AlaLiveRecorder bBK = null;
    private f bCl = null;
    private com.baidu.live.alablmsdk.c.b bBL = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.g.2
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat onStreamStateChanged state=" + bLMStreamState + " imUk=" + aVar.aCp);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.c(aVar, bLMStreamState);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("BCVideoChat leavedForSeconds imUk=" + aVar.aCp + " sec=" + i);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(aVar, i);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedRing roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar.aCp);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInvite roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.aCp);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserJoined roomId=" + str + " imUk=" + cVar.aCp);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserLeaved roomId=" + str + " imUk=" + cVar.aCp);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.aCp);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.10
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fX(final String str) {
            BdLog.e("BCVideoChat onRoomClosed roomId=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.iP(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            if (!TextUtils.isEmpty(str)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                try {
                    jSONObject2.put("blm_from", "show_pub_v2");
                } catch (JSONException e) {
                }
                UbcStatisticManager.getInstance().logLMSdkEvent(str, jSONObject, jSONObject2);
            }
        }
    };

    @Override // com.baidu.live.talentshow.d.a
    public void init(Context context) {
        this.mContext = context;
        this.bBI = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
        this.bBI.a(this.bBL);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("room_mode", d.bCb);
        hashMap.put("rtc_room_source_key", d.bBV);
        hashMap.put("is_auto_publish", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(15);
        hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
        hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.ae.a.RB().brA.aON.aTE));
        hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.ae.a.RB().brA.aON.aTD));
        hashMap.put("external_audio_capture", true);
        this.bBI.v(hashMap);
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bBK == null) {
            this.bBK = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = com.baidu.live.ae.a.RB().brA.aON.fps;
            aVar.aBA = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aBF = true;
            aVar.aBE = this.bBK.getPushUrl();
            aVar.aBC = com.baidu.live.ae.a.RB().brA.aON.aTA;
            List<cp.a> list = com.baidu.live.ae.a.RB().brA.aON.dataList;
            aVar.aBH = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.ae.a.RB().brA.aON.aTx, com.baidu.live.ae.a.RB().brA.aON.aTy);
            ArrayList arrayList = new ArrayList();
            for (cp.a aVar2 : list) {
                BLMViewShapeType bLMViewShapeType = BLMViewShapeType.RECTANGLE;
                if (aVar2.shape == 1) {
                    bLMViewShapeType = BLMViewShapeType.CIRCLE;
                }
                arrayList.add(new com.baidu.live.alablmsdk.config.a.a(aVar2.order, aVar2.z, bLMViewShapeType, new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height)));
            }
            aVar.aBJ = arrayList;
            aVar.aBK = com.baidu.live.ae.a.RB().brA.aON.aTF;
            aVar.aBG = aVar.Cl();
            com.baidu.live.alablmsdk.a.b.a.d(" BCVideoChat blmsdk mixTemplate =" + aVar.aBG);
            aVar.aBD = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bBI != null) {
                this.bBI.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onDestroy() {
        this.bBK = null;
        if (this.bBI != null) {
            this.bBI.onRelease();
            this.bBI = null;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        BdLog.e("BCVideoChat blmsdk onDestroy");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(f fVar) {
        this.bCl = fVar;
        BdLog.e("BCVideoChat blmsdk callback=" + fVar);
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setLiveShowData(w wVar) {
        this.aFN = wVar;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean TT() {
        BdLog.e("BCVideoChat blmsdk, count=" + this.bCk.getCount());
        if (this.bBG != null && this.bBG.length() != 0) {
            De();
        }
        return true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean TR() {
        if (this.bBG == null || this.bBG.length() == 0 || this.bCk.isEmpty()) {
            return false;
        }
        boolean fL = this.bCk.fL(d.bBZ);
        boolean fL2 = this.bCk.fL(d.bCa);
        BdLog.e("BCVideoChat  blmsdk connecting=" + fL + " connected=" + fL2);
        return fL || fL2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean TS() {
        if (this.bBG == null || this.bBG.length() == 0 || this.bCk.isEmpty()) {
            return false;
        }
        boolean fL = this.bCk.fL(d.bBW);
        boolean fL2 = this.bCk.fL(d.bBY);
        BdLog.e("BCVideoChat blmsdk idle=" + fL + " wait=" + fL2);
        return fL || fL2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean isFull() {
        return (this.bBG == null || this.bBG.length() == 0 || !this.bCk.isFull()) ? false : true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean bj(long j) {
        BdLog.e("BCVideoChat blmsdk imUK=" + j + "|mBIMRoomId=" + this.bBG + "|count=" + this.bCk.getCount());
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(j);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK fail");
            return false;
        } else if (bn.status == d.bBY) {
            BdLog.e("BCVideoChat blmsdk start Cancel invite user:" + bn.uid);
            cT(false);
            return true;
        } else if (this.bCk.getCount() == 1) {
            De();
            return true;
        } else {
            a(j, bn);
            return true;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int a(com.baidu.live.talentshow.d.a.b bVar) {
        if (bVar == null || bVar.bCC == null) {
            return -1;
        }
        BdLog.e("BCVideoChat blmsdk user=" + bVar.bCC.toString() + "|mBIMRoomId=" + this.bBG);
        if (this.bCk.isFull()) {
            BdLog.e("BCVideoChat blmsdk isFull user=" + bVar.bCC.toString());
            return -3;
        } else if (!this.bCk.bl(bVar.bCC.aCp)) {
            BdLog.e("BCVideoChat blmsdk cannot invite more user=" + bVar.bCC.toString());
            return -2;
        } else {
            final com.baidu.live.talentshow.d.a.b d = d(bVar.bCC);
            d.uid = bVar.uid;
            this.bCk.c(d);
            if (this.bBG == null || this.bBG.length() == 0) {
                this.bBI.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.talentshow.d.g.1
                    @Override // com.baidu.live.alablmsdk.c.a
                    public void c(final String str, final int i, final String str2) {
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(str, i, str2, d);
                            }
                        });
                    }
                });
                return 0;
            }
            a(this.bBG, 0, "", d);
            return 0;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk setMute=" + z);
        if (this.bBI != null) {
            this.bBI.bg(z);
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int bh(long j) {
        com.baidu.live.talentshow.d.a.b bn;
        BdLog.e("BCVideoChat blmsdk  imUK=" + j);
        if (this.bCk.isEmpty() || (bn = this.bCk.bn(j)) == null || bn.bCC == null || bn.bCC.aCp != j) {
            return -1;
        }
        return bn.status;
    }

    @Override // com.baidu.live.talentshow.d.a
    public String bk(long j) {
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(j);
        if (bn == null || bn.bCC == null) {
            return "";
        }
        return bn.bCC.userName;
    }

    @Override // com.baidu.live.talentshow.d.a
    public long fI(int i) {
        com.baidu.live.talentshow.d.a.b fM;
        if ((i == 1 || i == 2) && (fM = this.bCk.fM(i)) != null) {
            if (fM.status == d.bBZ || fM.status == d.bCa) {
                long j = JavaTypesHelper.toLong(fM.uid, 0L);
                BdLog.e("BCVideoChat index=" + i + " uid=" + j);
                return j;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onBackground() {
        if (this.bBI != null) {
            this.bBI.enterBackground();
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onForeground() {
        if (this.bBI != null) {
            this.bBI.enterForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int i, String str2, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " status=" + i + " msg=" + str2 + " imUK=" + bVar.bCC.aCp);
        if (i != 0) {
            this.bCk.bm(bVar.bCC.aCp);
            BdLog.e("BCVideoChat blmsdk createRoom fail roomId=" + str + " status=" + i + " msg=" + str2);
            if (this.bCl != null) {
                this.bCl.d(bVar.bCC.aCp, bVar.index, d.bCc);
                return;
            }
            return;
        }
        this.bBG = str;
        BdLog.e("BCVideoChat blmsdk invite-ext=" + bVar.ext + " userIndex=" + bVar.index);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.bCC);
        this.bBI.a(str, arrayList, bVar.ext, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.3
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(final int i2, final int i3, final String str3) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.a(str, i2, i3, str3, bVar);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, String str2, com.baidu.live.talentshow.d.a.b bVar) {
        if (i2 != 0) {
            if (this.bCl != null) {
                this.bCl.d(bVar.bCC.aCp, bVar.index, d.bCd);
            }
            this.bCk.bm(bVar.bCC.aCp);
            if (this.bCk.isEmpty()) {
                De();
            }
            BdLog.e("BCVideoChat blmsdk inviteUser fail roomId=" + str + " status=" + i2 + " msg=" + str2);
            return;
        }
        BdLog.e("BCVideoChat blmsdk inviteUser succ roomId=" + str + " user=" + bVar.bCC.toString() + " ret=" + this.bCk.i(bVar.bCC.aCp, d.bBY));
        if (this.bCl != null) {
            if (this.bCk.getCount() == 1 && !this.bCk.Uk()) {
                this.bCl.SA();
            }
            this.bCl.d(bVar.bCC.aCp, bVar.index, 0);
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bBg;
            cVar.bBy = this.bBG;
            cVar.bBA = TbadkCoreApplication.getCurrentAccount();
            cVar.ext = bVar.ext;
            this.bCl.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        long j = cVar.aCp;
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(cVar.aCp);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        } else if (this.bBG == null || !this.bBG.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bBG);
            this.bCk.bm(cVar.aCp);
            if (this.bCk.isEmpty()) {
                De();
            } else {
                a(cVar.aCp, bn);
            }
            if (this.bCl != null) {
                this.bCl.e(bn.bCC.aCp, bn.index, d.bCe);
            }
        } else {
            try {
                String optString = jSONObject.optString(UbcStatConstant.KEY_LIVE_TYPE, "");
                int optInt = jSONObject.optInt("line", -1);
                if (bn.index != optInt || !optString.equals("show_pub_v2")) {
                    BdLog.e("BCVideoChat blmsdk check fail index=" + optInt + " roomIndex=" + bn.index + " liveType=" + optString);
                    this.bCk.bm(cVar.aCp);
                    if (this.bCk.isEmpty()) {
                        De();
                    } else {
                        a(cVar.aCp, bn);
                    }
                    if (this.bCl != null) {
                        this.bCl.e(bn.bCC.aCp, bn.index, d.bCe);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bCk.getCount() == 1) {
                Te();
                iQ(this.bBG);
            }
            this.bCk.i(cVar.aCp, d.bBZ);
            if (this.bCl != null) {
                this.bCl.bf(cVar.aCp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        long j = cVar.aCp;
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(cVar.aCp);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        } else if (this.bBG == null || !this.bBG.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bBG);
            this.bCk.bm(cVar.aCp);
        } else {
            this.bCk.bm(cVar.aCp);
            if (this.bCl != null) {
                this.bCl.d(cVar.aCp, bn.index, d.bCi);
                if (this.bCk.isEmpty()) {
                    De();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp);
        long j = cVar.aCp;
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(cVar.aCp);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j);
        } else if (this.bBG == null || !this.bBG.equals(str)) {
            this.bCk.bm(cVar.aCp);
        } else {
            this.bCk.bm(cVar.aCp);
            if (this.bCl != null) {
                this.bCl.h(cVar.aCp, bn.index);
            }
            if (this.bCk.isEmpty() && this.bCk.Uk()) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j + " switchToRTMP");
                De();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.bBG == null || str == null || !this.bBG.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomUserJoin params error");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomUserJoin roomId=" + str + " imUK=" + cVar.aCp);
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(cVar.aCp);
        if (bn != null && this.bCl != null) {
            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
            cVar2.action = com.baidu.live.talentshow.b.c.bBp;
            cVar2.bBy = this.bBG;
            cVar2.bBA = TbadkCoreApplication.getCurrentAccount();
            cVar2.ext = bn.ext;
            this.bCl.a(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, JSONObject jSONObject, boolean z, int i, String str) {
        com.baidu.live.talentshow.d.a.b bn;
        BdLog.e("BCVideoChat blmsdk dealCancelInviteUsers imUK=" + j + " status=" + i + "|isFromClose=" + z + "|ext=" + jSONObject);
        if (i == 0 && (bn = this.bCk.bn(j)) != null) {
            if (this.bCl != null) {
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bBq;
                cVar.bBy = this.bBG;
                cVar.bBA = TbadkCoreApplication.getCurrentAccount();
                cVar.ext = jSONObject;
                this.bCl.a(cVar);
                this.bCl.c(bn.bCC.aCp, bn.index, d.bCj);
                this.bCl.bf(bn.bCC.aCp);
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " status=" + i + " isFromClose=" + z + " ext=" + jSONObject.toString());
            }
            this.bCk.bm(j);
            if (this.bCk.isEmpty() && !z) {
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                De();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealJoinRoom status=" + i + " msg=" + str2);
        if (i != 0) {
            De();
            if (this.bCl != null) {
                this.bCl.e(0L, 0, d.bCf);
            }
        } else if (this.bCl != null) {
            this.bCl.iJ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp);
        if (this.bBG == null || !this.bBG.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bBG);
            if (this.bCl != null) {
                this.bCl.bf(cVar.aCp);
            }
            this.bCk.bm(cVar.aCp);
        } else if (!this.bCk.fL(d.bBY)) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " user wait not exist");
        } else {
            this.bCk.a(d.bBY, new a.InterfaceC0213a() { // from class: com.baidu.live.talentshow.d.g.4
                @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0213a
                public void b(com.baidu.live.talentshow.d.a.b bVar) {
                    if (bVar != null && bVar.bCC != null) {
                        BdLog.e("BCVideoChat blmsdk roomId=" + str + " onSelect");
                        if (g.this.bCl != null) {
                            g.this.bCl.e(bVar.bCC.aCp, bVar.index, d.bCh);
                        }
                        if (g.this.bCl != null) {
                            g.this.bCl.bf(bVar.bCC.aCp);
                            JSONObject a2 = e.a(g.this.aFN, bVar.uid, bVar.index);
                            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                            cVar2.action = com.baidu.live.talentshow.b.c.bBq;
                            cVar2.bBy = g.this.bBG;
                            cVar2.bBA = TbadkCoreApplication.getCurrentAccount();
                            cVar2.ext = a2;
                            g.this.bCl.a(cVar2);
                        }
                        g.this.bCk.bm(bVar.bCC.aCp);
                        if (g.this.bCk.isEmpty()) {
                            g.this.De();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, JSONObject jSONObject, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealKickOffUser imUK=" + j + " uid=" + str + " status=" + i + " msg=" + str2);
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, long j) {
        if (str == null || this.bBG == null || !this.bBG.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomRing params error ");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomRing imUK = " + j + " roomId=" + str);
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(j);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null imUK=" + j);
        } else if (this.bCl != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bBi;
            cVar.bBy = this.bBG;
            cVar.bBA = TbadkCoreApplication.getCurrentAccount();
            cVar.ext = bn.ext;
            this.bCl.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP(String str) {
        BdLog.e("BCVideoChat blmsdk roomId =" + str + " " + this.bBG);
        if (!TextUtils.isEmpty(str) && str.equals(this.bBG)) {
            if (this.bCk.Uk()) {
                Td();
            }
            this.bCk.reset();
            if (this.bCl != null) {
                this.bCl.d("", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomID=" + str + " imUK=" + cVar.aCp);
            com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(cVar.aCp);
            if (bn == null) {
                BdLog.e("BCVideoChat blmsdk find user failed");
            } else if (TextUtils.isEmpty(str) || !str.equals(this.bBG)) {
                BdLog.e("BCVideoChat blmsdk room not eq");
            } else {
                JSONObject b = e.b(this.aFN, bn.uid, bn.index);
                if (this.bCl != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bBt;
                    cVar2.bBy = this.bBG;
                    cVar2.bBA = TbadkCoreApplication.getCurrentAccount();
                    cVar2.ext = b;
                    this.bCl.a(cVar2);
                    this.bCl.g(cVar.aCp, bn.index);
                }
                long j = bn.bCC.aCp;
                this.bCk.bm(j);
                if (this.bCk.isEmpty()) {
                    BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                    De();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        BdLog.e("BCVideoChat blmsdk stream.state=" + aVar.aCJ + " imUk=" + aVar.aCp);
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(aVar.aCp);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK return null");
            return;
        }
        if (bn != null && bn.status == d.bBZ) {
            bn.status = d.bCa;
        }
        if (this.bCl != null) {
            this.bCl.f(aVar.aCp, bn.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        if (aVar.aCp == AccountManager.getUK(this.mContext)) {
            BdLog.e("BCVideoChat blmsdk mystream is break");
            if (this.bCl != null) {
                this.bCl.fA(i);
                return;
            }
            return;
        }
        BdLog.e("BCVideoChat blmsdk imUK=" + aVar.aCp + " order=" + aVar.order);
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(aVar.aCp);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null");
            return;
        }
        if (this.bCl != null) {
            this.bCl.a(bn, i);
            if (i >= 15) {
                JSONObject b = e.b(this.aFN, bn.uid, bn.index);
                if (this.bCl != null) {
                    com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                    cVar.action = com.baidu.live.talentshow.b.c.bBt;
                    cVar.bBy = this.bBG;
                    cVar.bBA = TbadkCoreApplication.getCurrentAccount();
                    cVar.ext = b;
                    this.bCl.a(cVar);
                }
            }
        }
        if (i >= 15) {
            this.bCk.bm(aVar.aCp);
            if (this.bCk.isEmpty()) {
                BdLog.e("BCVideoChat blmsdk closeRoom imUK=" + aVar.aCp + " order=" + aVar.order);
                De();
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public View bi(long j) {
        BdLog.e("BCVideoChat blmsdk" + this.bCk.getCount() + "|imuk=" + j);
        com.baidu.live.talentshow.d.a.b bn = this.bCk.bn(j);
        if (bn == null || !(bn.index == 1 || bn.index == 2)) {
            return null;
        }
        return this.bBI.BR().c(bn.bCC);
    }

    private void Te() {
        BdLog.e("BCVideoChat  blmsdk mAuthorLiveRecorder=" + this.bBK);
        final com.baidu.live.alablmsdk.c.a.a CW = this.bBI.BR().CW();
        if (this.bBK != null) {
            this.bBK.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.g.5
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (CW != null) {
                        CW.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + CW);
                    }
                }
            });
            this.bBK.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.g.6
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (CW != null) {
                        CW.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + CW);
                    }
                }
            });
        }
    }

    private void Td() {
        BdLog.e("BCVideoChat blmsdk count=" + this.bCk.getCount());
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.live.talentshow.d.g.7
            @Override // java.lang.Runnable
            public void run() {
                g.this.bBK.setDefaultCloudRtcMode(null);
                g.this.bBK.setRecorderErrorCallback(null);
                g.this.bBK.startPush();
            }
        }, 500L);
    }

    private void cT(boolean z) {
        if (!this.bCk.isEmpty()) {
            this.bCk.a(d.bBY, new AnonymousClass8(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.talentshow.d.g$8  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass8 implements a.InterfaceC0213a {
        final /* synthetic */ boolean bCs;

        AnonymousClass8(boolean z) {
            this.bCs = z;
        }

        @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0213a
        public void b(final com.baidu.live.talentshow.d.a.b bVar) {
            BdLog.e("BCVideoChat blmsdk onSelect imUK=" + bVar.bCC.aCp);
            if (g.this.bBI != null && g.this.bBG != null && g.this.bBG.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.bCC);
                final JSONObject a2 = e.a(g.this.aFN, bVar.uid, bVar.index);
                g.this.bBI.b(g.this.bBG, arrayList, a2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.8.1
                    @Override // com.baidu.live.alablmsdk.c.c
                    public void f(int i, final int i2, final String str) {
                        BdLog.e("BCVideoChat blmsdk status=" + i2 + " msg=" + str);
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(bVar.bCC.aCp, a2, AnonymousClass8.this.bCs, i2, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private void a(final long j, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk imUK = " + j + " uid=" + bVar.uid);
        com.baidu.live.alablmsdk.module.c clone = bVar.bCC.clone();
        ArrayList arrayList = new ArrayList();
        arrayList.add(clone);
        final JSONObject b = e.b(this.aFN, bVar.uid, bVar.index);
        this.bBI.a(this.bBG, b, arrayList, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.9
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str) {
                g.this.a(j, bVar.uid, b, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De() {
        BdLog.e("BCVideoChat blmsdk roomId=" + this.bBG + " count=" + this.bCk.getCount());
        if (this.bBG != null && this.bBG.length() != 0) {
            cT(true);
            JSONObject v = e.v(this.aFN);
            this.bBI.d(this.bBG, v, (com.baidu.live.alablmsdk.c.c) null);
            this.bCk.reset();
            Td();
            if (this.bCl != null) {
                this.bCl.d(this.bBG, v);
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bBm;
                cVar.bBy = this.bBG;
                cVar.bBA = TbadkCoreApplication.getCurrentAccount();
                cVar.ext = v;
                this.bCl.a(cVar);
            }
            this.bBG = "";
        }
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        int Uj = this.bCk.Uj();
        BdLog.e("BCVideoChat blmsdk index=" + Uj);
        JSONObject a2 = e.a(this.aFN, cVar, Uj);
        cVar.order = Uj + "";
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.ext = a2;
        bVar.index = Uj;
        bVar.status = d.bBW;
        bVar.bCC = cVar;
        return bVar;
    }

    private void iQ(final String str) {
        BdLog.e("BCVideoChat blmsdk roomID=" + str + " isRtc=" + this.bCk.Uk());
        if (!this.bCk.Uk()) {
            this.bCk.cU(true);
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.aCp = AccountManager.getUK(TbadkCoreApplication.getInst());
            cVar.order = "0";
            this.bBI.a(str, cVar, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.10
                @Override // com.baidu.live.alablmsdk.c.c
                public void f(int i, final int i2, final String str2) {
                    g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.f(str, i2, str2);
                        }
                    });
                }
            });
        }
    }
}
