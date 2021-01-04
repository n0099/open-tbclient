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
import com.baidu.live.data.cr;
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class g implements a {
    private x aGe;
    private String bGt;
    private com.baidu.live.alablmsdk.a bGv;
    private Context mContext;
    private Handler mMainHandler;
    private com.baidu.live.talentshow.d.a.a bGX = new com.baidu.live.talentshow.d.a.a();
    private AlaLiveRecorder bGx = null;
    private f bGY = null;
    private com.baidu.live.alablmsdk.c.b bGy = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.g.2
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat onStreamStateChanged state=" + bLMStreamState + " imUk=" + aVar.aCG);
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
            BdLog.e("BCVideoChat leavedForSeconds imUk=" + aVar.aCG + " sec=" + i);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(aVar, i);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedRing roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar.aCG);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInvite roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.aCG);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserJoined roomId=" + str + " imUk=" + cVar.aCG);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserLeaved roomId=" + str + " imUk=" + cVar.aCG);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.aCG);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.10
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("BCVideoChat onRoomClosed roomId=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.iE(str);
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
        this.bGv = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
        this.bGv.a(this.bGy);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("room_mode", d.bGO);
        hashMap.put("rtc_room_source_key", d.bGI);
        hashMap.put("is_auto_publish", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(15);
        hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
        hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.af.a.SE().bwi.aPu.aUB));
        hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.af.a.SE().bwi.aPu.aUA));
        hashMap.put("external_audio_capture", true);
        this.bGv.v(hashMap);
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bGx == null) {
            this.bGx = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = com.baidu.live.af.a.SE().bwi.aPu.fps;
            aVar.aBR = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aBW = true;
            aVar.aBV = this.bGx.getPushUrl();
            aVar.aBT = com.baidu.live.af.a.SE().bwi.aPu.aUx;
            List<cr.a> list = com.baidu.live.af.a.SE().bwi.aPu.dataList;
            aVar.aBY = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.af.a.SE().bwi.aPu.aUv, com.baidu.live.af.a.SE().bwi.aPu.aUw);
            ArrayList arrayList = new ArrayList();
            for (cr.a aVar2 : list) {
                BLMViewShapeType bLMViewShapeType = BLMViewShapeType.RECTANGLE;
                if (aVar2.aUE == 1) {
                    bLMViewShapeType = BLMViewShapeType.CIRCLE;
                }
                arrayList.add(new com.baidu.live.alablmsdk.config.a.a(aVar2.order, aVar2.z, bLMViewShapeType, new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height)));
            }
            aVar.aCa = arrayList;
            aVar.aCb = com.baidu.live.af.a.SE().bwi.aPu.aUC;
            aVar.aBX = aVar.BC();
            com.baidu.live.alablmsdk.a.b.a.d(" BCVideoChat blmsdk mixTemplate =" + aVar.aBX);
            aVar.aBU = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bGv != null) {
                this.bGv.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onDestroy() {
        this.bGx = null;
        if (this.bGv != null) {
            this.bGv.onRelease();
            this.bGv = null;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        BdLog.e("BCVideoChat blmsdk onDestroy");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(f fVar) {
        this.bGY = fVar;
        BdLog.e("BCVideoChat blmsdk callback=" + fVar);
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setLiveShowData(x xVar) {
        this.aGe = xVar;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean UY() {
        BdLog.e("BCVideoChat blmsdk, count=" + this.bGX.getCount());
        if (this.bGt != null && this.bGt.length() != 0) {
            Cv();
        }
        return true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean UW() {
        if (this.bGt == null || this.bGt.length() == 0 || this.bGX.isEmpty()) {
            return false;
        }
        boolean fM = this.bGX.fM(d.bGM);
        boolean fM2 = this.bGX.fM(d.bGN);
        BdLog.e("BCVideoChat  blmsdk connecting=" + fM + " connected=" + fM2);
        return fM || fM2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean UX() {
        if (this.bGt == null || this.bGt.length() == 0 || this.bGX.isEmpty()) {
            return false;
        }
        boolean fM = this.bGX.fM(d.bGJ);
        boolean fM2 = this.bGX.fM(d.bGL);
        BdLog.e("BCVideoChat blmsdk idle=" + fM + " wait=" + fM2);
        return fM || fM2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean isFull() {
        return (this.bGt == null || this.bGt.length() == 0 || !this.bGX.isFull()) ? false : true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean bj(long j) {
        BdLog.e("BCVideoChat blmsdk imUK=" + j + "|mBIMRoomId=" + this.bGt + "|count=" + this.bGX.getCount());
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(j);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK fail");
            return false;
        } else if (bn.status == d.bGL) {
            BdLog.e("BCVideoChat blmsdk start Cancel invite user:" + bn.uid);
            cW(false);
            return true;
        } else if (this.bGX.getCount() == 1) {
            Cv();
            return true;
        } else {
            a(j, bn);
            return true;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int a(com.baidu.live.talentshow.d.a.b bVar) {
        if (bVar == null || bVar.bHp == null) {
            return -1;
        }
        BdLog.e("BCVideoChat blmsdk user=" + bVar.bHp.toString() + "|mBIMRoomId=" + this.bGt);
        if (this.bGX.isFull()) {
            BdLog.e("BCVideoChat blmsdk isFull user=" + bVar.bHp.toString());
            return -3;
        } else if (!this.bGX.bl(bVar.bHp.aCG)) {
            BdLog.e("BCVideoChat blmsdk cannot invite more user=" + bVar.bHp.toString());
            return -2;
        } else {
            final com.baidu.live.talentshow.d.a.b d = d(bVar.bHp);
            d.uid = bVar.uid;
            this.bGX.c(d);
            if (this.bGt == null || this.bGt.length() == 0) {
                this.bGv.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.talentshow.d.g.1
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
            a(this.bGt, 0, "", d);
            return 0;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk setMute=" + z);
        if (this.bGv != null) {
            this.bGv.bd(z);
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int bh(long j) {
        com.baidu.live.talentshow.d.a.b bn;
        BdLog.e("BCVideoChat blmsdk  imUK=" + j);
        if (this.bGX.isEmpty() || (bn = this.bGX.bn(j)) == null || bn.bHp == null || bn.bHp.aCG != j) {
            return -1;
        }
        return bn.status;
    }

    @Override // com.baidu.live.talentshow.d.a
    public String bk(long j) {
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(j);
        if (bn == null || bn.bHp == null) {
            return "";
        }
        return bn.bHp.userName;
    }

    @Override // com.baidu.live.talentshow.d.a
    public long fJ(int i) {
        com.baidu.live.talentshow.d.a.b fN;
        if ((i == 1 || i == 2) && (fN = this.bGX.fN(i)) != null) {
            if (fN.status == d.bGM || fN.status == d.bGN) {
                long j = JavaTypesHelper.toLong(fN.uid, 0L);
                BdLog.e("BCVideoChat index=" + i + " uid=" + j);
                return j;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onBackground() {
        if (this.bGv != null) {
            this.bGv.enterBackground();
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onForeground() {
        if (this.bGv != null) {
            this.bGv.enterForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int i, String str2, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " status=" + i + " msg=" + str2 + " imUK=" + bVar.bHp.aCG);
        if (i != 0) {
            this.bGX.bm(bVar.bHp.aCG);
            BdLog.e("BCVideoChat blmsdk createRoom fail roomId=" + str + " status=" + i + " msg=" + str2);
            if (this.bGY != null) {
                this.bGY.d(bVar.bHp.aCG, bVar.index, d.bGP);
                return;
            }
            return;
        }
        this.bGt = str;
        BdLog.e("BCVideoChat blmsdk invite-ext=" + bVar.bGq + " userIndex=" + bVar.index);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.bHp);
        this.bGv.a(str, arrayList, bVar.bGq, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.3
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
            if (this.bGY != null) {
                this.bGY.d(bVar.bHp.aCG, bVar.index, d.bGQ);
            }
            this.bGX.bm(bVar.bHp.aCG);
            if (this.bGX.isEmpty()) {
                Cv();
            }
            BdLog.e("BCVideoChat blmsdk inviteUser fail roomId=" + str + " status=" + i2 + " msg=" + str2);
            return;
        }
        BdLog.e("BCVideoChat blmsdk inviteUser succ roomId=" + str + " user=" + bVar.bHp.toString() + " ret=" + this.bGX.j(bVar.bHp.aCG, d.bGL));
        if (this.bGY != null) {
            if (this.bGX.getCount() == 1 && !this.bGX.Vp()) {
                this.bGY.TE();
            }
            this.bGY.d(bVar.bHp.aCG, bVar.index, 0);
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bFT;
            cVar.bGl = this.bGt;
            cVar.bGn = TbadkCoreApplication.getCurrentAccount();
            cVar.bGq = bVar.bGq;
            this.bGY.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        long j = cVar.aCG;
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(cVar.aCG);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        } else if (this.bGt == null || !this.bGt.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bGt);
            this.bGX.bm(cVar.aCG);
            if (this.bGX.isEmpty()) {
                Cv();
            } else {
                a(cVar.aCG, bn);
            }
            if (this.bGY != null) {
                this.bGY.e(bn.bHp.aCG, bn.index, d.bGR);
            }
        } else {
            try {
                String optString = jSONObject.optString(UbcStatConstant.KEY_LIVE_TYPE, "");
                int optInt = jSONObject.optInt("line", -1);
                if (bn.index != optInt || !optString.equals("show_pub_v2")) {
                    BdLog.e("BCVideoChat blmsdk check fail index=" + optInt + " roomIndex=" + bn.index + " liveType=" + optString);
                    this.bGX.bm(cVar.aCG);
                    if (this.bGX.isEmpty()) {
                        Cv();
                    } else {
                        a(cVar.aCG, bn);
                    }
                    if (this.bGY != null) {
                        this.bGY.e(bn.bHp.aCG, bn.index, d.bGR);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bGX.getCount() == 1) {
                Uj();
                iF(this.bGt);
            }
            this.bGX.j(cVar.aCG, d.bGM);
            if (this.bGY != null) {
                this.bGY.bf(cVar.aCG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        long j = cVar.aCG;
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(cVar.aCG);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        } else if (this.bGt == null || !this.bGt.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bGt);
            this.bGX.bm(cVar.aCG);
        } else {
            this.bGX.bm(cVar.aCG);
            if (this.bGY != null) {
                this.bGY.d(cVar.aCG, bn.index, d.bGV);
                if (this.bGX.isEmpty()) {
                    Cv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG);
        long j = cVar.aCG;
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(cVar.aCG);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j);
        } else if (this.bGt == null || !this.bGt.equals(str)) {
            this.bGX.bm(cVar.aCG);
        } else {
            this.bGX.bm(cVar.aCG);
            if (this.bGY != null) {
                this.bGY.i(cVar.aCG, bn.index);
            }
            if (this.bGX.isEmpty() && this.bGX.Vp()) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j + " switchToRTMP");
                Cv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.bGt == null || str == null || !this.bGt.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomUserJoin params error");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomUserJoin roomId=" + str + " imUK=" + cVar.aCG);
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(cVar.aCG);
        if (bn != null && this.bGY != null) {
            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
            cVar2.action = com.baidu.live.talentshow.b.c.bGc;
            cVar2.bGl = this.bGt;
            cVar2.bGn = TbadkCoreApplication.getCurrentAccount();
            cVar2.bGq = bn.bGq;
            this.bGY.a(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, JSONObject jSONObject, boolean z, int i, String str) {
        com.baidu.live.talentshow.d.a.b bn;
        BdLog.e("BCVideoChat blmsdk dealCancelInviteUsers imUK=" + j + " status=" + i + "|isFromClose=" + z + "|ext=" + jSONObject);
        if (i == 0 && (bn = this.bGX.bn(j)) != null) {
            if (this.bGY != null) {
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bGd;
                cVar.bGl = this.bGt;
                cVar.bGn = TbadkCoreApplication.getCurrentAccount();
                cVar.bGq = jSONObject;
                this.bGY.a(cVar);
                this.bGY.c(bn.bHp.aCG, bn.index, d.bGW);
                this.bGY.bf(bn.bHp.aCG);
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " status=" + i + " isFromClose=" + z + " ext=" + jSONObject.toString());
            }
            this.bGX.bm(j);
            if (this.bGX.isEmpty() && !z) {
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                Cv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealJoinRoom status=" + i + " msg=" + str2);
        if (i != 0) {
            Cv();
            if (this.bGY != null) {
                this.bGY.e(0L, 0, d.bGS);
            }
        } else if (this.bGY != null) {
            this.bGY.iy(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG);
        if (this.bGt == null || !this.bGt.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bGt);
            if (this.bGY != null) {
                this.bGY.bf(cVar.aCG);
            }
            this.bGX.bm(cVar.aCG);
        } else if (!this.bGX.fM(d.bGL)) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " user wait not exist");
        } else {
            this.bGX.a(d.bGL, new a.InterfaceC0211a() { // from class: com.baidu.live.talentshow.d.g.4
                @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0211a
                public void b(com.baidu.live.talentshow.d.a.b bVar) {
                    if (bVar != null && bVar.bHp != null) {
                        BdLog.e("BCVideoChat blmsdk roomId=" + str + " onSelect");
                        if (g.this.bGY != null) {
                            g.this.bGY.e(bVar.bHp.aCG, bVar.index, d.bGU);
                        }
                        if (g.this.bGY != null) {
                            g.this.bGY.bf(bVar.bHp.aCG);
                            JSONObject a2 = e.a(g.this.aGe, bVar.uid, bVar.index);
                            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                            cVar2.action = com.baidu.live.talentshow.b.c.bGd;
                            cVar2.bGl = g.this.bGt;
                            cVar2.bGn = TbadkCoreApplication.getCurrentAccount();
                            cVar2.bGq = a2;
                            g.this.bGY.a(cVar2);
                        }
                        g.this.bGX.bm(bVar.bHp.aCG);
                        if (g.this.bGX.isEmpty()) {
                            g.this.Cv();
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
        if (str == null || this.bGt == null || !this.bGt.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomRing params error ");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomRing imUK = " + j + " roomId=" + str);
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(j);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null imUK=" + j);
        } else if (this.bGY != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bFV;
            cVar.bGl = this.bGt;
            cVar.bGn = TbadkCoreApplication.getCurrentAccount();
            cVar.bGq = bn.bGq;
            this.bGY.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE(String str) {
        BdLog.e("BCVideoChat blmsdk roomId =" + str + " " + this.bGt);
        if (!TextUtils.isEmpty(str) && str.equals(this.bGt)) {
            if (this.bGX.Vp()) {
                Ui();
            }
            this.bGX.reset();
            if (this.bGY != null) {
                this.bGY.e("", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomID=" + str + " imUK=" + cVar.aCG);
            com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(cVar.aCG);
            if (bn == null) {
                BdLog.e("BCVideoChat blmsdk find user failed");
            } else if (TextUtils.isEmpty(str) || !str.equals(this.bGt)) {
                BdLog.e("BCVideoChat blmsdk room not eq");
            } else {
                JSONObject b2 = e.b(this.aGe, bn.uid, bn.index);
                if (this.bGY != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bGg;
                    cVar2.bGl = this.bGt;
                    cVar2.bGn = TbadkCoreApplication.getCurrentAccount();
                    cVar2.bGq = b2;
                    this.bGY.a(cVar2);
                    this.bGY.h(cVar.aCG, bn.index);
                }
                long j = bn.bHp.aCG;
                this.bGX.bm(j);
                if (this.bGX.isEmpty()) {
                    BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                    Cv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        BdLog.e("BCVideoChat blmsdk stream.state=" + aVar.aDa + " imUk=" + aVar.aCG);
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(aVar.aCG);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK return null");
            return;
        }
        if (bn != null && bn.status == d.bGM) {
            bn.status = d.bGN;
        }
        if (this.bGY != null) {
            this.bGY.g(aVar.aCG, bn.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        if (aVar.aCG == AccountManager.getUK(this.mContext)) {
            BdLog.e("BCVideoChat blmsdk mystream is break");
            if (this.bGY != null) {
                this.bGY.fB(i);
                return;
            }
            return;
        }
        BdLog.e("BCVideoChat blmsdk imUK=" + aVar.aCG + " order=" + aVar.order);
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(aVar.aCG);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null");
            return;
        }
        if (this.bGY != null) {
            this.bGY.a(bn, i);
            if (i >= 15) {
                JSONObject b2 = e.b(this.aGe, bn.uid, bn.index);
                if (this.bGY != null) {
                    com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                    cVar.action = com.baidu.live.talentshow.b.c.bGg;
                    cVar.bGl = this.bGt;
                    cVar.bGn = TbadkCoreApplication.getCurrentAccount();
                    cVar.bGq = b2;
                    this.bGY.a(cVar);
                }
            }
        }
        if (i >= 15) {
            this.bGX.bm(aVar.aCG);
            if (this.bGX.isEmpty()) {
                BdLog.e("BCVideoChat blmsdk closeRoom imUK=" + aVar.aCG + " order=" + aVar.order);
                Cv();
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public View bi(long j) {
        BdLog.e("BCVideoChat blmsdk" + this.bGX.getCount() + "|imuk=" + j);
        com.baidu.live.talentshow.d.a.b bn = this.bGX.bn(j);
        if (bn == null || !(bn.index == 1 || bn.index == 2)) {
            return null;
        }
        return this.bGv.Bi().c(bn.bHp);
    }

    private void Uj() {
        BdLog.e("BCVideoChat  blmsdk mAuthorLiveRecorder=" + this.bGx);
        final com.baidu.live.alablmsdk.c.a.a Cn = this.bGv.Bi().Cn();
        if (this.bGx != null) {
            this.bGx.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.g.5
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (Cn != null) {
                        Cn.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + Cn);
                    }
                }
            });
            this.bGx.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.g.6
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (Cn != null) {
                        Cn.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + Cn);
                    }
                }
            });
        }
    }

    private void Ui() {
        BdLog.e("BCVideoChat blmsdk count=" + this.bGX.getCount());
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.live.talentshow.d.g.7
            @Override // java.lang.Runnable
            public void run() {
                g.this.bGx.setEnableCloudRtc(false, null);
                g.this.bGx.setRecorderErrorCallback(null);
                g.this.bGx.startPush();
            }
        }, 500L);
    }

    private void cW(boolean z) {
        if (!this.bGX.isEmpty()) {
            this.bGX.a(d.bGL, new AnonymousClass8(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.talentshow.d.g$8  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass8 implements a.InterfaceC0211a {
        final /* synthetic */ boolean bHf;

        AnonymousClass8(boolean z) {
            this.bHf = z;
        }

        @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0211a
        public void b(final com.baidu.live.talentshow.d.a.b bVar) {
            BdLog.e("BCVideoChat blmsdk onSelect imUK=" + bVar.bHp.aCG);
            if (g.this.bGv != null && g.this.bGt != null && g.this.bGt.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.bHp);
                final JSONObject a2 = e.a(g.this.aGe, bVar.uid, bVar.index);
                g.this.bGv.b(g.this.bGt, arrayList, a2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.8.1
                    @Override // com.baidu.live.alablmsdk.c.c
                    public void f(int i, final int i2, final String str) {
                        BdLog.e("BCVideoChat blmsdk status=" + i2 + " msg=" + str);
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(bVar.bHp.aCG, a2, AnonymousClass8.this.bHf, i2, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private void a(final long j, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk imUK = " + j + " uid=" + bVar.uid);
        com.baidu.live.alablmsdk.module.c clone = bVar.bHp.clone();
        ArrayList arrayList = new ArrayList();
        arrayList.add(clone);
        final JSONObject b2 = e.b(this.aGe, bVar.uid, bVar.index);
        this.bGv.a(this.bGt, b2, arrayList, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.9
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str) {
                g.this.a(j, bVar.uid, b2, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv() {
        BdLog.e("BCVideoChat blmsdk roomId=" + this.bGt + " count=" + this.bGX.getCount());
        if (this.bGt != null && this.bGt.length() != 0) {
            cW(true);
            JSONObject w = e.w(this.aGe);
            this.bGv.d(this.bGt, w, (com.baidu.live.alablmsdk.c.c) null);
            this.bGX.reset();
            Ui();
            if (this.bGY != null) {
                this.bGY.e(this.bGt, w);
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bFZ;
                cVar.bGl = this.bGt;
                cVar.bGn = TbadkCoreApplication.getCurrentAccount();
                cVar.bGq = w;
                this.bGY.a(cVar);
            }
            this.bGt = "";
        }
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        int Vo = this.bGX.Vo();
        BdLog.e("BCVideoChat blmsdk index=" + Vo);
        JSONObject a2 = e.a(this.aGe, cVar, Vo);
        cVar.order = Vo + "";
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.bGq = a2;
        bVar.index = Vo;
        bVar.status = d.bGJ;
        bVar.bHp = cVar;
        return bVar;
    }

    private void iF(final String str) {
        BdLog.e("BCVideoChat blmsdk roomID=" + str + " isRtc=" + this.bGX.Vp());
        if (!this.bGX.Vp()) {
            this.bGX.cX(true);
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.aCG = AccountManager.getUK(TbadkCoreApplication.getInst());
            cVar.order = "0";
            this.bGv.a(str, cVar, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.10
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
