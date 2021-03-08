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
import com.baidu.live.alablmsdk.config.a;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.alablmsdk.module.rtc.BLMJoinRoomStage;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.ab;
import com.baidu.live.data.cx;
import com.baidu.live.talentshow.d.a.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g implements a {
    private ab aED;
    private String bGN;
    private com.baidu.live.alablmsdk.a bGP;
    private Context mContext;
    private Handler mMainHandler;
    private com.baidu.live.talentshow.d.a.a bHu = new com.baidu.live.talentshow.d.a.a();
    private AlaLiveRecorder bGR = null;
    private f bHv = null;
    private com.baidu.live.alablmsdk.c.b bGS = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.g.2
        @Override // com.baidu.live.alablmsdk.c.b
        public void g(int i, String str) {
            BdLog.e("BCVideoChat onErrorEventUpdated erroCode=" + i + " msg=" + str);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.c cVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat onStreamStateChanged state=" + bLMStreamState + " imUk=" + cVar.azK);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.c(cVar, bLMStreamState);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.c cVar, final int i) {
            BdLog.e("BCVideoChat leavedForSeconds imUk=" + cVar.azK + " sec=" + i);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(cVar, i);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedRing roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar.azK);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInvite roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.m(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserJoined roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.l(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserLeaved roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.10
                @Override // java.lang.Runnable
                public void run() {
                    g.this.n(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserShutuped roomId=" + str + " imUk=" + cVar.azK);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserDisshutuped roomId=" + str + " imUk=" + cVar.azK);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void eE(final String str) {
            BdLog.e("BCVideoChat onRoomClosed roomId=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.hV(str);
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

        @Override // com.baidu.live.alablmsdk.c.b
        public String xq() {
            return null;
        }
    };
    com.baidu.live.alablmsdk.c.b.e bGT = new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.live.talentshow.d.g.3
        @Override // com.baidu.live.alablmsdk.c.b.e
        public void a(String str, String str2, final com.baidu.live.alablmsdk.c.b.a aVar) {
            com.baidu.live.yyrtc.a.ZN().a(str, str2, new com.baidu.live.yyrtc.b() { // from class: com.baidu.live.talentshow.d.g.3.1
                @Override // com.baidu.live.yyrtc.b
                public void ai(String str3, String str4) {
                    if (g.this.bGP != null) {
                        g.this.bGP.eD(str3);
                    }
                    if (aVar != null) {
                        aVar.ai(str3, str4);
                    }
                }
            });
        }
    };

    @Override // com.baidu.live.talentshow.d.a
    public void init(Context context) {
        this.mContext = context;
        this.bGP = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
        this.bGP.eC(com.baidu.live.ae.a.Qm().bwx.aPe);
        this.bGP.a(this.bGT);
        this.bGP.a(this.bGS);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("room_mode", d.bHl);
        hashMap.put("rtc_room_source_key", d.bHf);
        hashMap.put("rtc_business_source_key", "show_pub_v2");
        hashMap.put("is_auto_publish", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(15);
        hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
        hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qm().bwx.aOW.aUr));
        hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qm().bwx.aOW.aUq));
        hashMap.put("external_audio_capture", true);
        this.bGP.v(hashMap);
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bGR == null) {
            this.bGR = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            a.C0167a c0167a = new a.C0167a();
            c0167a.fps = com.baidu.live.ae.a.Qm().bwx.aOW.fps;
            c0167a.ayO = new com.baidu.live.alablmsdk.config.a.b(540, 960);
            c0167a.ayS = true;
            c0167a.ayR = this.bGR.getPushUrl();
            c0167a.ayQ = com.baidu.live.ae.a.Qm().bwx.aOW.aUm;
            List<cx.a> list = com.baidu.live.ae.a.Qm().bwx.aOW.dataList;
            c0167a.ayT = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.ae.a.Qm().bwx.aOW.aUk, com.baidu.live.ae.a.Qm().bwx.aOW.aUl);
            ArrayList arrayList = new ArrayList();
            for (cx.a aVar2 : list) {
                BLMViewShapeType bLMViewShapeType = BLMViewShapeType.RECTANGLE;
                if (aVar2.aUu == 1) {
                    bLMViewShapeType = BLMViewShapeType.CIRCLE;
                }
                arrayList.add(new com.baidu.live.alablmsdk.config.a.a(aVar2.order, aVar2.z, bLMViewShapeType, new com.baidu.live.alablmsdk.config.a.d(aVar2.x, aVar2.y, aVar2.width, aVar2.height)));
            }
            c0167a.ayV = arrayList;
            c0167a.ayW = com.baidu.live.ae.a.Qm().bwx.aOW.aUs;
            c0167a.ayX = aVar.a(c0167a);
            aVar.ayN = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            aVar.ayM = c0167a;
            if (this.bGP != null) {
                this.bGP.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onDestroy() {
        this.bGR = null;
        if (this.bGP != null) {
            this.bGP.onRelease();
            this.bGP = null;
        }
        com.baidu.live.yyrtc.a.ZN().release();
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        BdLog.e("BCVideoChat blmsdk onDestroy");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(f fVar) {
        this.bHv = fVar;
        BdLog.e("BCVideoChat blmsdk callback=" + fVar);
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setLiveShowData(ab abVar) {
        this.aED = abVar;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean SP() {
        BdLog.e("BCVideoChat blmsdk, count=" + this.bHu.getCount());
        if (this.bGN != null && this.bGN.length() != 0) {
            ys();
        }
        return true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean SN() {
        if (this.bGN == null || this.bGN.length() == 0 || this.bHu.isEmpty()) {
            return false;
        }
        boolean el = this.bHu.el(d.bHj);
        boolean el2 = this.bHu.el(d.bHk);
        BdLog.e("BCVideoChat  blmsdk connecting=" + el + " connected=" + el2);
        return el || el2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean SO() {
        if (this.bGN == null || this.bGN.length() == 0 || this.bHu.isEmpty()) {
            return false;
        }
        boolean el = this.bHu.el(d.bHg);
        boolean el2 = this.bHu.el(d.bHi);
        BdLog.e("BCVideoChat blmsdk idle=" + el + " wait=" + el2);
        return el || el2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean isFull() {
        return (this.bGN == null || this.bGN.length() == 0 || !this.bHu.isFull()) ? false : true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean bn(long j) {
        BdLog.e("BCVideoChat blmsdk imUK=" + j + "|mBIMRoomId=" + this.bGN + "|count=" + this.bHu.getCount());
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(j);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK fail");
            return false;
        } else if (br.status == d.bHi) {
            BdLog.e("BCVideoChat blmsdk start Cancel invite user:" + br.uid);
            da(false);
            return true;
        } else if (this.bHu.getCount() == 1) {
            ys();
            return true;
        } else {
            a(j, br);
            return true;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int a(com.baidu.live.talentshow.d.a.b bVar) {
        if (bVar == null || bVar.bHN == null) {
            return -1;
        }
        BdLog.e("BCVideoChat blmsdk user=" + bVar.bHN.toString() + "|mBIMRoomId=" + this.bGN);
        if (this.bHu.isFull()) {
            BdLog.e("BCVideoChat blmsdk isFull user=" + bVar.bHN.toString());
            return -3;
        } else if (!this.bHu.bp(bVar.bHN.azK)) {
            BdLog.e("BCVideoChat blmsdk cannot invite more user=" + bVar.bHN.toString());
            return -2;
        } else {
            final com.baidu.live.talentshow.d.a.b k = k(bVar.bHN);
            k.uid = bVar.uid;
            this.bHu.c(k);
            if (this.bGN == null || this.bGN.length() == 0) {
                this.bGP.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.talentshow.d.g.1
                    @Override // com.baidu.live.alablmsdk.c.a
                    public void c(final String str, final int i, final String str2) {
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(str, i, str2, k);
                            }
                        });
                    }
                });
                return 0;
            }
            a(this.bGN, 0, "", k);
            return 0;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk setMute=" + z);
        if (this.bGP != null) {
            this.bGP.aY(z);
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int bl(long j) {
        com.baidu.live.talentshow.d.a.b br;
        BdLog.e("BCVideoChat blmsdk  imUK=" + j);
        if (this.bHu.isEmpty() || (br = this.bHu.br(j)) == null || br.bHN == null || br.bHN.azK != j) {
            return -1;
        }
        return br.status;
    }

    @Override // com.baidu.live.talentshow.d.a
    public String bo(long j) {
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(j);
        if (br == null || br.bHN == null) {
            return "";
        }
        return br.bHN.userName;
    }

    @Override // com.baidu.live.talentshow.d.a
    public long ei(int i) {
        com.baidu.live.talentshow.d.a.b em;
        if ((i == 1 || i == 2) && (em = this.bHu.em(i)) != null) {
            if (em.status == d.bHj || em.status == d.bHk) {
                long j = JavaTypesHelper.toLong(em.uid, 0L);
                BdLog.e("BCVideoChat index=" + i + " uid=" + j);
                return j;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onBackground() {
        if (this.bGP != null) {
            this.bGP.enterBackground();
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onForeground() {
        if (this.bGP != null) {
            this.bGP.enterForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int i, String str2, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " status=" + i + " msg=" + str2 + " imUK=" + bVar.bHN.azK);
        if (i != 0) {
            this.bHu.bq(bVar.bHN.azK);
            BdLog.e("BCVideoChat blmsdk createRoom fail roomId=" + str + " status=" + i + " msg=" + str2);
            if (this.bHv != null) {
                this.bHv.d(bVar.bHN.azK, bVar.index, d.bHm);
                return;
            }
            return;
        }
        this.bGN = str;
        BdLog.e("BCVideoChat blmsdk invite-ext=" + bVar.bGK + " userIndex=" + bVar.index);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.bHN);
        this.bGP.a(str, arrayList, bVar.bGK, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.talentshow.d.g.4
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(final int i2, final int i3, final String str3) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.4.1
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
            if (this.bHv != null) {
                this.bHv.d(bVar.bHN.azK, bVar.index, d.bHn);
            }
            this.bHu.bq(bVar.bHN.azK);
            if (this.bHu.isEmpty()) {
                ys();
            }
            BdLog.e("BCVideoChat blmsdk inviteUser fail roomId=" + str + " status=" + i2 + " msg=" + str2);
            return;
        }
        BdLog.e("BCVideoChat blmsdk inviteUser succ roomId=" + str + " user=" + bVar.bHN.toString() + " ret=" + this.bHu.j(bVar.bHN.azK, d.bHi));
        if (this.bHv != null) {
            if (this.bHu.getCount() == 1 && !this.bHu.Tg()) {
                this.bHv.Rw();
            }
            this.bHv.d(bVar.bHN.azK, bVar.index, 0);
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bGn;
            cVar.bGF = this.bGN;
            cVar.bGH = TbadkCoreApplication.getCurrentAccount();
            cVar.bGK = bVar.bGK;
            this.bHv.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        long j = cVar.azK;
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(cVar.azK);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        } else if (this.bGN == null || !this.bGN.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bGN);
            this.bHu.bq(cVar.azK);
            if (this.bHu.isEmpty()) {
                ys();
            } else {
                a(cVar.azK, br);
            }
            if (this.bHv != null) {
                this.bHv.e(br.bHN.azK, br.index, d.bHo);
            }
        } else {
            try {
                String optString = jSONObject.optString(UbcStatConstant.KEY_LIVE_TYPE, "");
                int optInt = jSONObject.optInt("line", -1);
                if (br.index != optInt || !optString.equals("show_pub_v2")) {
                    BdLog.e("BCVideoChat blmsdk check fail index=" + optInt + " roomIndex=" + br.index + " liveType=" + optString);
                    this.bHu.bq(cVar.azK);
                    if (this.bHu.isEmpty()) {
                        ys();
                    } else {
                        a(cVar.azK, br);
                    }
                    if (this.bHv != null) {
                        this.bHv.e(br.bHN.azK, br.index, d.bHo);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bHu.getCount() == 1) {
                Sb();
                hW(this.bGN);
            }
            this.bHu.j(cVar.azK, d.bHj);
            if (this.bHv != null) {
                this.bHv.bj(cVar.azK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        long j = cVar.azK;
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(cVar.azK);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        } else if (this.bGN == null || !this.bGN.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bGN);
            this.bHu.bq(cVar.azK);
        } else {
            this.bHu.bq(cVar.azK);
            if (this.bHv != null) {
                this.bHv.d(cVar.azK, br.index, d.bHs);
                if (this.bHu.isEmpty()) {
                    ys();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK);
        long j = cVar.azK;
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(cVar.azK);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j);
        } else if (this.bGN == null || !this.bGN.equals(str)) {
            this.bHu.bq(cVar.azK);
        } else {
            this.bHu.bq(cVar.azK);
            if (this.bHv != null) {
                this.bHv.i(cVar.azK, br.index);
            }
            if (this.bHu.isEmpty() && this.bHu.Tg()) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j + " switchToRTMP");
                ys();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.bGN == null || str == null || !this.bGN.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomUserJoin params error");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomUserJoin roomId=" + str + " imUK=" + cVar.azK);
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(cVar.azK);
        if (br != null && this.bHv != null) {
            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
            cVar2.action = com.baidu.live.talentshow.b.c.bGw;
            cVar2.bGF = this.bGN;
            cVar2.bGH = TbadkCoreApplication.getCurrentAccount();
            cVar2.bGK = br.bGK;
            this.bHv.a(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, JSONObject jSONObject, boolean z, int i, String str) {
        com.baidu.live.talentshow.d.a.b br;
        BdLog.e("BCVideoChat blmsdk dealCancelInviteUsers imUK=" + j + " status=" + i + "|isFromClose=" + z + "|ext=" + jSONObject);
        if (i == 0 && (br = this.bHu.br(j)) != null) {
            if (this.bHv != null) {
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bGx;
                cVar.bGF = this.bGN;
                cVar.bGH = TbadkCoreApplication.getCurrentAccount();
                cVar.bGK = jSONObject;
                this.bHv.a(cVar);
                this.bHv.c(br.bHN.azK, br.index, d.bHt);
                this.bHv.bj(br.bHN.azK);
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " status=" + i + " isFromClose=" + z + " ext=" + jSONObject.toString());
            }
            this.bHu.bq(j);
            if (this.bHu.isEmpty() && !z) {
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                ys();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealJoinRoom status=" + i + " msg=" + str2);
        if (i != 0) {
            ys();
            if (this.bHv != null) {
                this.bHv.e(0L, 0, d.bHp);
            }
        } else if (this.bHv != null) {
            this.bHv.hP(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK);
        if (this.bGN == null || !this.bGN.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bGN);
            if (this.bHv != null) {
                this.bHv.bj(cVar.azK);
            }
            this.bHu.bq(cVar.azK);
        } else if (!this.bHu.el(d.bHi)) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " user wait not exist");
        } else {
            this.bHu.a(d.bHi, new a.InterfaceC0210a() { // from class: com.baidu.live.talentshow.d.g.5
                @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0210a
                public void b(com.baidu.live.talentshow.d.a.b bVar) {
                    if (bVar != null && bVar.bHN != null) {
                        BdLog.e("BCVideoChat blmsdk roomId=" + str + " onSelect");
                        if (g.this.bHv != null) {
                            g.this.bHv.e(bVar.bHN.azK, bVar.index, d.bHr);
                        }
                        if (g.this.bHv != null) {
                            g.this.bHv.bj(bVar.bHN.azK);
                            JSONObject a2 = e.a(g.this.aED, bVar.uid, bVar.index);
                            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                            cVar2.action = com.baidu.live.talentshow.b.c.bGx;
                            cVar2.bGF = g.this.bGN;
                            cVar2.bGH = TbadkCoreApplication.getCurrentAccount();
                            cVar2.bGK = a2;
                            g.this.bHv.a(cVar2);
                        }
                        g.this.bHu.bq(bVar.bHN.azK);
                        if (g.this.bHu.isEmpty()) {
                            g.this.ys();
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
    public void f(String str, long j) {
        if (str == null || this.bGN == null || !this.bGN.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomRing params error ");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomRing imUK = " + j + " roomId=" + str);
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(j);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null imUK=" + j);
        } else if (this.bHv != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bGp;
            cVar.bGF = this.bGN;
            cVar.bGH = TbadkCoreApplication.getCurrentAccount();
            cVar.bGK = br.bGK;
            this.bHv.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV(String str) {
        BdLog.e("BCVideoChat blmsdk roomId =" + str + " " + this.bGN);
        if (!TextUtils.isEmpty(str) && str.equals(this.bGN)) {
            if (this.bHu.Tg()) {
                Sa();
            }
            this.bHu.reset();
            if (this.bHv != null) {
                this.bHv.f("", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomID=" + str + " imUK=" + cVar.azK);
            com.baidu.live.talentshow.d.a.b br = this.bHu.br(cVar.azK);
            if (br == null) {
                BdLog.e("BCVideoChat blmsdk find user failed");
            } else if (TextUtils.isEmpty(str) || !str.equals(this.bGN)) {
                BdLog.e("BCVideoChat blmsdk room not eq");
            } else {
                JSONObject b = e.b(this.aED, br.uid, br.index);
                if (this.bHv != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bGA;
                    cVar2.bGF = this.bGN;
                    cVar2.bGH = TbadkCoreApplication.getCurrentAccount();
                    cVar2.bGK = b;
                    this.bHv.a(cVar2);
                    this.bHv.h(cVar.azK, br.index);
                }
                long j = br.bHN.azK;
                this.bHu.bq(j);
                if (this.bHu.isEmpty()) {
                    BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                    ys();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
        BdLog.e("BCVideoChat blmsdk stream.state=" + cVar.aAh + " imUk=" + cVar.azK);
        if (cVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(cVar.azK);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK return null");
            return;
        }
        if (br != null && br.status == d.bHj) {
            br.status = d.bHk;
        }
        if (this.bHv != null) {
            this.bHv.g(cVar.azK, br.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.c cVar, int i) {
        if (cVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        if (cVar.azK == AccountManager.getUK(this.mContext)) {
            BdLog.e("BCVideoChat blmsdk mystream is break");
            if (this.bHv != null) {
                this.bHv.ea(i);
                return;
            }
            return;
        }
        BdLog.e("BCVideoChat blmsdk imUK=" + cVar.azK + " order=" + cVar.order);
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(cVar.azK);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null");
            return;
        }
        if (this.bHv != null) {
            this.bHv.a(br, i);
            if (i >= 15) {
                JSONObject b = e.b(this.aED, br.uid, br.index);
                if (this.bHv != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bGA;
                    cVar2.bGF = this.bGN;
                    cVar2.bGH = TbadkCoreApplication.getCurrentAccount();
                    cVar2.bGK = b;
                    this.bHv.a(cVar2);
                }
            }
        }
        if (i >= 15) {
            this.bHu.bq(cVar.azK);
            if (this.bHu.isEmpty()) {
                BdLog.e("BCVideoChat blmsdk closeRoom imUK=" + cVar.azK + " order=" + cVar.order);
                ys();
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public View bm(long j) {
        BdLog.e("BCVideoChat blmsdk" + this.bHu.getCount() + "|imuk=" + j);
        com.baidu.live.talentshow.d.a.b br = this.bHu.br(j);
        if (br == null || !(br.index == 1 || br.index == 2)) {
            return null;
        }
        return this.bGP.xo().j(br.bHN);
    }

    private void Sb() {
        BdLog.e("BCVideoChat  blmsdk mAuthorLiveRecorder=" + this.bGR);
        final com.baidu.live.alablmsdk.c.a.a yJ = this.bGP.xo().yJ();
        if (this.bGR != null) {
            this.bGR.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.g.6
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (yJ != null) {
                        yJ.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + yJ);
                    }
                }
            });
            this.bGR.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.g.7
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (yJ != null) {
                        yJ.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + yJ);
                    }
                }
            });
        }
    }

    private void Sa() {
        BdLog.e("BCVideoChat blmsdk count=" + this.bHu.getCount());
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.live.talentshow.d.g.8
            @Override // java.lang.Runnable
            public void run() {
                g.this.bGR.setEnableCloudRtc(false, null);
                g.this.bGR.setRecorderErrorCallback(null);
                g.this.bGR.startPush();
            }
        }, 500L);
    }

    private void da(boolean z) {
        if (!this.bHu.isEmpty()) {
            this.bHu.a(d.bHi, new AnonymousClass9(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.talentshow.d.g$9  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass9 implements a.InterfaceC0210a {
        final /* synthetic */ boolean bHD;

        AnonymousClass9(boolean z) {
            this.bHD = z;
        }

        @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0210a
        public void b(final com.baidu.live.talentshow.d.a.b bVar) {
            BdLog.e("BCVideoChat blmsdk onSelect imUK=" + bVar.bHN.azK);
            if (g.this.bGP != null && g.this.bGN != null && g.this.bGN.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.bHN);
                final JSONObject a2 = e.a(g.this.aED, bVar.uid, bVar.index);
                g.this.bGP.b(g.this.bGN, arrayList, a2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.talentshow.d.g.9.1
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, final int i2, final String str) {
                        BdLog.e("BCVideoChat blmsdk status=" + i2 + " msg=" + str);
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(bVar.bHN.azK, a2, AnonymousClass9.this.bHD, i2, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private void a(final long j, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk imUK = " + j + " uid=" + bVar.uid);
        com.baidu.live.alablmsdk.module.c clone = bVar.bHN.clone();
        ArrayList arrayList = new ArrayList();
        arrayList.add(clone);
        final JSONObject b = e.b(this.aED, bVar.uid, bVar.index);
        this.bGP.a(this.bGN, b, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.talentshow.d.g.10
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str) {
                g.this.a(j, bVar.uid, b, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys() {
        BdLog.e("BCVideoChat blmsdk roomId=" + this.bGN + " count=" + this.bHu.getCount());
        if (this.bGN != null && this.bGN.length() != 0) {
            da(true);
            JSONObject w = e.w(this.aED);
            this.bGP.c(this.bGN, w, (com.baidu.live.alablmsdk.c.d) null);
            this.bHu.reset();
            Sa();
            if (this.bHv != null) {
                this.bHv.f(this.bGN, w);
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bGt;
                cVar.bGF = this.bGN;
                cVar.bGH = TbadkCoreApplication.getCurrentAccount();
                cVar.bGK = w;
                this.bHv.a(cVar);
            }
            this.bGN = "";
        }
    }

    private com.baidu.live.talentshow.d.a.b k(com.baidu.live.alablmsdk.module.c cVar) {
        int Tf = this.bHu.Tf();
        BdLog.e("BCVideoChat blmsdk index=" + Tf);
        JSONObject a2 = e.a(this.aED, cVar, Tf);
        cVar.order = Tf + "";
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.bGK = a2;
        bVar.index = Tf;
        bVar.status = d.bHg;
        bVar.bHN = cVar;
        return bVar;
    }

    private void hW(final String str) {
        BdLog.e("BCVideoChat blmsdk roomID=" + str + " isRtc=" + this.bHu.Tg());
        if (!this.bHu.Tg()) {
            this.bHu.db(true);
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.azK = AccountManager.getUK(TbadkCoreApplication.getInst());
            cVar.order = "0";
            this.bGP.a(str, cVar, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.11
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(final int i, BLMJoinRoomStage bLMJoinRoomStage, final com.baidu.live.alablmsdk.module.common.a aVar) {
                    if (bLMJoinRoomStage != null && bLMJoinRoomStage == BLMJoinRoomStage.HOST_TRANS) {
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str2 = "";
                                if (aVar != null) {
                                    str2 = aVar.msg;
                                }
                                g.this.e(str, i, str2);
                            }
                        });
                    }
                }
            });
        }
    }
}
