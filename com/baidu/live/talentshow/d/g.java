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
/* loaded from: classes11.dex */
public class g implements a {
    private ab aDd;
    private String bFn;
    private com.baidu.live.alablmsdk.a bFp;
    private Context mContext;
    private Handler mMainHandler;
    private com.baidu.live.talentshow.d.a.a bFU = new com.baidu.live.talentshow.d.a.a();
    private AlaLiveRecorder bFr = null;
    private f bFV = null;
    private com.baidu.live.alablmsdk.c.b bFs = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.g.2
        @Override // com.baidu.live.alablmsdk.c.b
        public void g(int i, String str) {
            BdLog.e("BCVideoChat onErrorEventUpdated erroCode=" + i + " msg=" + str);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.c cVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat onStreamStateChanged state=" + bLMStreamState + " imUk=" + cVar.ayk);
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
            BdLog.e("BCVideoChat leavedForSeconds imUk=" + cVar.ayk + " sec=" + i);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(cVar, i);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedRing roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar.ayk);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInvite roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.ayk);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.m(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserJoined roomId=" + str + " imUk=" + cVar.ayk);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.l(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserLeaved roomId=" + str + " imUk=" + cVar.ayk);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.ayk);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.10
                @Override // java.lang.Runnable
                public void run() {
                    g.this.n(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserShutuped roomId=" + str + " imUk=" + cVar.ayk);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserDisshutuped roomId=" + str + " imUk=" + cVar.ayk);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void ey(final String str) {
            BdLog.e("BCVideoChat onRoomClosed roomId=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.hP(str);
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
        public String xn() {
            return null;
        }
    };
    com.baidu.live.alablmsdk.c.b.e bFt = new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.live.talentshow.d.g.3
        @Override // com.baidu.live.alablmsdk.c.b.e
        public void a(String str, String str2, final com.baidu.live.alablmsdk.c.b.a aVar) {
            com.baidu.live.yyrtc.a.ZK().a(str, str2, new com.baidu.live.yyrtc.b() { // from class: com.baidu.live.talentshow.d.g.3.1
                @Override // com.baidu.live.yyrtc.b
                public void ai(String str3, String str4) {
                    if (g.this.bFp != null) {
                        g.this.bFp.ew(str3);
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
        this.bFp = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
        this.bFp.ev(com.baidu.live.ae.a.Qj().buX.aNE);
        this.bFp.a(this.bFt);
        this.bFp.a(this.bFs);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("room_mode", d.bFL);
        hashMap.put("rtc_room_source_key", d.bFF);
        hashMap.put("rtc_business_source_key", "show_pub_v2");
        hashMap.put("is_auto_publish", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(15);
        hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
        hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qj().buX.aNw.aSR));
        hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qj().buX.aNw.aSQ));
        hashMap.put("external_audio_capture", true);
        this.bFp.v(hashMap);
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bFr == null) {
            this.bFr = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            a.C0161a c0161a = new a.C0161a();
            c0161a.fps = com.baidu.live.ae.a.Qj().buX.aNw.fps;
            c0161a.axo = new com.baidu.live.alablmsdk.config.a.b(540, 960);
            c0161a.axs = true;
            c0161a.axr = this.bFr.getPushUrl();
            c0161a.axq = com.baidu.live.ae.a.Qj().buX.aNw.aSM;
            List<cx.a> list = com.baidu.live.ae.a.Qj().buX.aNw.dataList;
            c0161a.axt = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.ae.a.Qj().buX.aNw.aSK, com.baidu.live.ae.a.Qj().buX.aNw.aSL);
            ArrayList arrayList = new ArrayList();
            for (cx.a aVar2 : list) {
                BLMViewShapeType bLMViewShapeType = BLMViewShapeType.RECTANGLE;
                if (aVar2.aSU == 1) {
                    bLMViewShapeType = BLMViewShapeType.CIRCLE;
                }
                arrayList.add(new com.baidu.live.alablmsdk.config.a.a(aVar2.order, aVar2.z, bLMViewShapeType, new com.baidu.live.alablmsdk.config.a.d(aVar2.x, aVar2.y, aVar2.width, aVar2.height)));
            }
            c0161a.axv = arrayList;
            c0161a.axw = com.baidu.live.ae.a.Qj().buX.aNw.aSS;
            c0161a.axx = aVar.a(c0161a);
            aVar.axn = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            aVar.axm = c0161a;
            if (this.bFp != null) {
                this.bFp.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onDestroy() {
        this.bFr = null;
        if (this.bFp != null) {
            this.bFp.onRelease();
            this.bFp = null;
        }
        com.baidu.live.yyrtc.a.ZK().release();
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        BdLog.e("BCVideoChat blmsdk onDestroy");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(f fVar) {
        this.bFV = fVar;
        BdLog.e("BCVideoChat blmsdk callback=" + fVar);
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setLiveShowData(ab abVar) {
        this.aDd = abVar;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean SM() {
        BdLog.e("BCVideoChat blmsdk, count=" + this.bFU.getCount());
        if (this.bFn != null && this.bFn.length() != 0) {
            yp();
        }
        return true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean SK() {
        if (this.bFn == null || this.bFn.length() == 0 || this.bFU.isEmpty()) {
            return false;
        }
        boolean ek = this.bFU.ek(d.bFJ);
        boolean ek2 = this.bFU.ek(d.bFK);
        BdLog.e("BCVideoChat  blmsdk connecting=" + ek + " connected=" + ek2);
        return ek || ek2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean SL() {
        if (this.bFn == null || this.bFn.length() == 0 || this.bFU.isEmpty()) {
            return false;
        }
        boolean ek = this.bFU.ek(d.bFG);
        boolean ek2 = this.bFU.ek(d.bFI);
        BdLog.e("BCVideoChat blmsdk idle=" + ek + " wait=" + ek2);
        return ek || ek2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean isFull() {
        return (this.bFn == null || this.bFn.length() == 0 || !this.bFU.isFull()) ? false : true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean bn(long j) {
        BdLog.e("BCVideoChat blmsdk imUK=" + j + "|mBIMRoomId=" + this.bFn + "|count=" + this.bFU.getCount());
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(j);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK fail");
            return false;
        } else if (br.status == d.bFI) {
            BdLog.e("BCVideoChat blmsdk start Cancel invite user:" + br.uid);
            da(false);
            return true;
        } else if (this.bFU.getCount() == 1) {
            yp();
            return true;
        } else {
            a(j, br);
            return true;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int a(com.baidu.live.talentshow.d.a.b bVar) {
        if (bVar == null || bVar.bGn == null) {
            return -1;
        }
        BdLog.e("BCVideoChat blmsdk user=" + bVar.bGn.toString() + "|mBIMRoomId=" + this.bFn);
        if (this.bFU.isFull()) {
            BdLog.e("BCVideoChat blmsdk isFull user=" + bVar.bGn.toString());
            return -3;
        } else if (!this.bFU.bp(bVar.bGn.ayk)) {
            BdLog.e("BCVideoChat blmsdk cannot invite more user=" + bVar.bGn.toString());
            return -2;
        } else {
            final com.baidu.live.talentshow.d.a.b k = k(bVar.bGn);
            k.uid = bVar.uid;
            this.bFU.c(k);
            if (this.bFn == null || this.bFn.length() == 0) {
                this.bFp.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.talentshow.d.g.1
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
            a(this.bFn, 0, "", k);
            return 0;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk setMute=" + z);
        if (this.bFp != null) {
            this.bFp.aY(z);
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int bl(long j) {
        com.baidu.live.talentshow.d.a.b br;
        BdLog.e("BCVideoChat blmsdk  imUK=" + j);
        if (this.bFU.isEmpty() || (br = this.bFU.br(j)) == null || br.bGn == null || br.bGn.ayk != j) {
            return -1;
        }
        return br.status;
    }

    @Override // com.baidu.live.talentshow.d.a
    public String bo(long j) {
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(j);
        if (br == null || br.bGn == null) {
            return "";
        }
        return br.bGn.userName;
    }

    @Override // com.baidu.live.talentshow.d.a
    public long eh(int i) {
        com.baidu.live.talentshow.d.a.b el;
        if ((i == 1 || i == 2) && (el = this.bFU.el(i)) != null) {
            if (el.status == d.bFJ || el.status == d.bFK) {
                long j = JavaTypesHelper.toLong(el.uid, 0L);
                BdLog.e("BCVideoChat index=" + i + " uid=" + j);
                return j;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onBackground() {
        if (this.bFp != null) {
            this.bFp.enterBackground();
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onForeground() {
        if (this.bFp != null) {
            this.bFp.enterForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int i, String str2, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " status=" + i + " msg=" + str2 + " imUK=" + bVar.bGn.ayk);
        if (i != 0) {
            this.bFU.bq(bVar.bGn.ayk);
            BdLog.e("BCVideoChat blmsdk createRoom fail roomId=" + str + " status=" + i + " msg=" + str2);
            if (this.bFV != null) {
                this.bFV.d(bVar.bGn.ayk, bVar.index, d.bFM);
                return;
            }
            return;
        }
        this.bFn = str;
        BdLog.e("BCVideoChat blmsdk invite-ext=" + bVar.bFk + " userIndex=" + bVar.index);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.bGn);
        this.bFp.a(str, arrayList, bVar.bFk, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.talentshow.d.g.4
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
            if (this.bFV != null) {
                this.bFV.d(bVar.bGn.ayk, bVar.index, d.bFN);
            }
            this.bFU.bq(bVar.bGn.ayk);
            if (this.bFU.isEmpty()) {
                yp();
            }
            BdLog.e("BCVideoChat blmsdk inviteUser fail roomId=" + str + " status=" + i2 + " msg=" + str2);
            return;
        }
        BdLog.e("BCVideoChat blmsdk inviteUser succ roomId=" + str + " user=" + bVar.bGn.toString() + " ret=" + this.bFU.j(bVar.bGn.ayk, d.bFI));
        if (this.bFV != null) {
            if (this.bFU.getCount() == 1 && !this.bFU.Td()) {
                this.bFV.Rt();
            }
            this.bFV.d(bVar.bGn.ayk, bVar.index, 0);
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bEN;
            cVar.bFf = this.bFn;
            cVar.bFh = TbadkCoreApplication.getCurrentAccount();
            cVar.bFk = bVar.bFk;
            this.bFV.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        long j = cVar.ayk;
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(cVar.ayk);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        } else if (this.bFn == null || !this.bFn.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bFn);
            this.bFU.bq(cVar.ayk);
            if (this.bFU.isEmpty()) {
                yp();
            } else {
                a(cVar.ayk, br);
            }
            if (this.bFV != null) {
                this.bFV.e(br.bGn.ayk, br.index, d.bFO);
            }
        } else {
            try {
                String optString = jSONObject.optString(UbcStatConstant.KEY_LIVE_TYPE, "");
                int optInt = jSONObject.optInt("line", -1);
                if (br.index != optInt || !optString.equals("show_pub_v2")) {
                    BdLog.e("BCVideoChat blmsdk check fail index=" + optInt + " roomIndex=" + br.index + " liveType=" + optString);
                    this.bFU.bq(cVar.ayk);
                    if (this.bFU.isEmpty()) {
                        yp();
                    } else {
                        a(cVar.ayk, br);
                    }
                    if (this.bFV != null) {
                        this.bFV.e(br.bGn.ayk, br.index, d.bFO);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bFU.getCount() == 1) {
                RY();
                hQ(this.bFn);
            }
            this.bFU.j(cVar.ayk, d.bFJ);
            if (this.bFV != null) {
                this.bFV.bj(cVar.ayk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        long j = cVar.ayk;
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(cVar.ayk);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        } else if (this.bFn == null || !this.bFn.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bFn);
            this.bFU.bq(cVar.ayk);
        } else {
            this.bFU.bq(cVar.ayk);
            if (this.bFV != null) {
                this.bFV.d(cVar.ayk, br.index, d.bFS);
                if (this.bFU.isEmpty()) {
                    yp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk);
        long j = cVar.ayk;
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(cVar.ayk);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j);
        } else if (this.bFn == null || !this.bFn.equals(str)) {
            this.bFU.bq(cVar.ayk);
        } else {
            this.bFU.bq(cVar.ayk);
            if (this.bFV != null) {
                this.bFV.i(cVar.ayk, br.index);
            }
            if (this.bFU.isEmpty() && this.bFU.Td()) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j + " switchToRTMP");
                yp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.bFn == null || str == null || !this.bFn.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomUserJoin params error");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomUserJoin roomId=" + str + " imUK=" + cVar.ayk);
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(cVar.ayk);
        if (br != null && this.bFV != null) {
            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
            cVar2.action = com.baidu.live.talentshow.b.c.bEW;
            cVar2.bFf = this.bFn;
            cVar2.bFh = TbadkCoreApplication.getCurrentAccount();
            cVar2.bFk = br.bFk;
            this.bFV.a(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, JSONObject jSONObject, boolean z, int i, String str) {
        com.baidu.live.talentshow.d.a.b br;
        BdLog.e("BCVideoChat blmsdk dealCancelInviteUsers imUK=" + j + " status=" + i + "|isFromClose=" + z + "|ext=" + jSONObject);
        if (i == 0 && (br = this.bFU.br(j)) != null) {
            if (this.bFV != null) {
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bEX;
                cVar.bFf = this.bFn;
                cVar.bFh = TbadkCoreApplication.getCurrentAccount();
                cVar.bFk = jSONObject;
                this.bFV.a(cVar);
                this.bFV.c(br.bGn.ayk, br.index, d.bFT);
                this.bFV.bj(br.bGn.ayk);
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " status=" + i + " isFromClose=" + z + " ext=" + jSONObject.toString());
            }
            this.bFU.bq(j);
            if (this.bFU.isEmpty() && !z) {
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                yp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealJoinRoom status=" + i + " msg=" + str2);
        if (i != 0) {
            yp();
            if (this.bFV != null) {
                this.bFV.e(0L, 0, d.bFP);
            }
        } else if (this.bFV != null) {
            this.bFV.hJ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk);
        if (this.bFn == null || !this.bFn.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bFn);
            if (this.bFV != null) {
                this.bFV.bj(cVar.ayk);
            }
            this.bFU.bq(cVar.ayk);
        } else if (!this.bFU.ek(d.bFI)) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " user wait not exist");
        } else {
            this.bFU.a(d.bFI, new a.InterfaceC0204a() { // from class: com.baidu.live.talentshow.d.g.5
                @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0204a
                public void b(com.baidu.live.talentshow.d.a.b bVar) {
                    if (bVar != null && bVar.bGn != null) {
                        BdLog.e("BCVideoChat blmsdk roomId=" + str + " onSelect");
                        if (g.this.bFV != null) {
                            g.this.bFV.e(bVar.bGn.ayk, bVar.index, d.bFR);
                        }
                        if (g.this.bFV != null) {
                            g.this.bFV.bj(bVar.bGn.ayk);
                            JSONObject a2 = e.a(g.this.aDd, bVar.uid, bVar.index);
                            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                            cVar2.action = com.baidu.live.talentshow.b.c.bEX;
                            cVar2.bFf = g.this.bFn;
                            cVar2.bFh = TbadkCoreApplication.getCurrentAccount();
                            cVar2.bFk = a2;
                            g.this.bFV.a(cVar2);
                        }
                        g.this.bFU.bq(bVar.bGn.ayk);
                        if (g.this.bFU.isEmpty()) {
                            g.this.yp();
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
        if (str == null || this.bFn == null || !this.bFn.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomRing params error ");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomRing imUK = " + j + " roomId=" + str);
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(j);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null imUK=" + j);
        } else if (this.bFV != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bEP;
            cVar.bFf = this.bFn;
            cVar.bFh = TbadkCoreApplication.getCurrentAccount();
            cVar.bFk = br.bFk;
            this.bFV.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(String str) {
        BdLog.e("BCVideoChat blmsdk roomId =" + str + " " + this.bFn);
        if (!TextUtils.isEmpty(str) && str.equals(this.bFn)) {
            if (this.bFU.Td()) {
                RX();
            }
            this.bFU.reset();
            if (this.bFV != null) {
                this.bFV.e("", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomID=" + str + " imUK=" + cVar.ayk);
            com.baidu.live.talentshow.d.a.b br = this.bFU.br(cVar.ayk);
            if (br == null) {
                BdLog.e("BCVideoChat blmsdk find user failed");
            } else if (TextUtils.isEmpty(str) || !str.equals(this.bFn)) {
                BdLog.e("BCVideoChat blmsdk room not eq");
            } else {
                JSONObject b2 = e.b(this.aDd, br.uid, br.index);
                if (this.bFV != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bFa;
                    cVar2.bFf = this.bFn;
                    cVar2.bFh = TbadkCoreApplication.getCurrentAccount();
                    cVar2.bFk = b2;
                    this.bFV.a(cVar2);
                    this.bFV.h(cVar.ayk, br.index);
                }
                long j = br.bGn.ayk;
                this.bFU.bq(j);
                if (this.bFU.isEmpty()) {
                    BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                    yp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
        BdLog.e("BCVideoChat blmsdk stream.state=" + cVar.ayH + " imUk=" + cVar.ayk);
        if (cVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(cVar.ayk);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK return null");
            return;
        }
        if (br != null && br.status == d.bFJ) {
            br.status = d.bFK;
        }
        if (this.bFV != null) {
            this.bFV.g(cVar.ayk, br.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.c cVar, int i) {
        if (cVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        if (cVar.ayk == AccountManager.getUK(this.mContext)) {
            BdLog.e("BCVideoChat blmsdk mystream is break");
            if (this.bFV != null) {
                this.bFV.dZ(i);
                return;
            }
            return;
        }
        BdLog.e("BCVideoChat blmsdk imUK=" + cVar.ayk + " order=" + cVar.order);
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(cVar.ayk);
        if (br == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null");
            return;
        }
        if (this.bFV != null) {
            this.bFV.a(br, i);
            if (i >= 15) {
                JSONObject b2 = e.b(this.aDd, br.uid, br.index);
                if (this.bFV != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bFa;
                    cVar2.bFf = this.bFn;
                    cVar2.bFh = TbadkCoreApplication.getCurrentAccount();
                    cVar2.bFk = b2;
                    this.bFV.a(cVar2);
                }
            }
        }
        if (i >= 15) {
            this.bFU.bq(cVar.ayk);
            if (this.bFU.isEmpty()) {
                BdLog.e("BCVideoChat blmsdk closeRoom imUK=" + cVar.ayk + " order=" + cVar.order);
                yp();
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public View bm(long j) {
        BdLog.e("BCVideoChat blmsdk" + this.bFU.getCount() + "|imuk=" + j);
        com.baidu.live.talentshow.d.a.b br = this.bFU.br(j);
        if (br == null || !(br.index == 1 || br.index == 2)) {
            return null;
        }
        return this.bFp.xl().j(br.bGn);
    }

    private void RY() {
        BdLog.e("BCVideoChat  blmsdk mAuthorLiveRecorder=" + this.bFr);
        final com.baidu.live.alablmsdk.c.a.a yG = this.bFp.xl().yG();
        if (this.bFr != null) {
            this.bFr.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.g.6
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (yG != null) {
                        yG.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + yG);
                    }
                }
            });
            this.bFr.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.g.7
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (yG != null) {
                        yG.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + yG);
                    }
                }
            });
        }
    }

    private void RX() {
        BdLog.e("BCVideoChat blmsdk count=" + this.bFU.getCount());
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.live.talentshow.d.g.8
            @Override // java.lang.Runnable
            public void run() {
                g.this.bFr.setEnableCloudRtc(false, null);
                g.this.bFr.setRecorderErrorCallback(null);
                g.this.bFr.startPush();
            }
        }, 500L);
    }

    private void da(boolean z) {
        if (!this.bFU.isEmpty()) {
            this.bFU.a(d.bFI, new AnonymousClass9(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.talentshow.d.g$9  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass9 implements a.InterfaceC0204a {
        final /* synthetic */ boolean bGd;

        AnonymousClass9(boolean z) {
            this.bGd = z;
        }

        @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0204a
        public void b(final com.baidu.live.talentshow.d.a.b bVar) {
            BdLog.e("BCVideoChat blmsdk onSelect imUK=" + bVar.bGn.ayk);
            if (g.this.bFp != null && g.this.bFn != null && g.this.bFn.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.bGn);
                final JSONObject a2 = e.a(g.this.aDd, bVar.uid, bVar.index);
                g.this.bFp.b(g.this.bFn, arrayList, a2, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.talentshow.d.g.9.1
                    @Override // com.baidu.live.alablmsdk.c.d
                    public void f(int i, final int i2, final String str) {
                        BdLog.e("BCVideoChat blmsdk status=" + i2 + " msg=" + str);
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(bVar.bGn.ayk, a2, AnonymousClass9.this.bGd, i2, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private void a(final long j, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk imUK = " + j + " uid=" + bVar.uid);
        com.baidu.live.alablmsdk.module.c clone = bVar.bGn.clone();
        ArrayList arrayList = new ArrayList();
        arrayList.add(clone);
        final JSONObject b2 = e.b(this.aDd, bVar.uid, bVar.index);
        this.bFp.a(this.bFn, b2, arrayList, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.talentshow.d.g.10
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str) {
                g.this.a(j, bVar.uid, b2, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp() {
        BdLog.e("BCVideoChat blmsdk roomId=" + this.bFn + " count=" + this.bFU.getCount());
        if (this.bFn != null && this.bFn.length() != 0) {
            da(true);
            JSONObject w = e.w(this.aDd);
            this.bFp.c(this.bFn, w, (com.baidu.live.alablmsdk.c.d) null);
            this.bFU.reset();
            RX();
            if (this.bFV != null) {
                this.bFV.e(this.bFn, w);
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bET;
                cVar.bFf = this.bFn;
                cVar.bFh = TbadkCoreApplication.getCurrentAccount();
                cVar.bFk = w;
                this.bFV.a(cVar);
            }
            this.bFn = "";
        }
    }

    private com.baidu.live.talentshow.d.a.b k(com.baidu.live.alablmsdk.module.c cVar) {
        int Tc = this.bFU.Tc();
        BdLog.e("BCVideoChat blmsdk index=" + Tc);
        JSONObject a2 = e.a(this.aDd, cVar, Tc);
        cVar.order = Tc + "";
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.bFk = a2;
        bVar.index = Tc;
        bVar.status = d.bFG;
        bVar.bGn = cVar;
        return bVar;
    }

    private void hQ(final String str) {
        BdLog.e("BCVideoChat blmsdk roomID=" + str + " isRtc=" + this.bFU.Td());
        if (!this.bFU.Td()) {
            this.bFU.db(true);
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.ayk = AccountManager.getUK(TbadkCoreApplication.getInst());
            cVar.order = "0";
            this.bFp.a(str, cVar, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.11
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
