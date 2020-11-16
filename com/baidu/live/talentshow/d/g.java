package com.baidu.live.talentshow.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.cn;
import com.baidu.live.data.w;
import com.baidu.live.talentshow.d.a.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
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
    private w aDh;
    private String bww;
    private com.baidu.live.alablmsdk.b bwy;
    private Context mContext;
    private Handler mMainHandler;
    private com.baidu.live.talentshow.d.a.a bxc = new com.baidu.live.talentshow.d.a.a();
    private AlaLiveRecorder bwB = null;
    private f bxd = null;
    private com.baidu.live.alablmsdk.c.b bwC = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.g.9
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat onStreamStateChanged state=" + bLMStreamState + " imUk=" + aVar.azK);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.c(aVar, bLMStreamState);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("BCVideoChat leavedForSeconds imUk=" + aVar.azK + " sec=" + i);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(aVar, i);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedRing roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar.azK);
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
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserJoined roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserLeaved roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.azK);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.10
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fB(final String str) {
            BdLog.e("BCVideoChat onRoomClosed roomId=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.il(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fC(String str) {
            BdLog.e("BCVideoChat onLogReport message=" + str);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("blm_msg", str);
                    jSONObject.put("blm_from", "show_pub_v2");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(com.baidu.live.alablmsdk.a.ayB, com.baidu.live.alablmsdk.a.LOG_TYPE, com.baidu.live.alablmsdk.a.ayC, com.baidu.live.alablmsdk.a.ayD);
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logLMSdkEvent(ubcStatisticItem);
            }
        }
    };

    @Override // com.baidu.live.talentshow.d.a
    public void init(Context context) {
        this.mContext = context;
        this.bwy = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());
        this.bwy.a(this.bwC);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("room_mode", d.bwT);
        hashMap.put("rtc_room_source_key", d.bwN);
        hashMap.put("is_auto_publish", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(15);
        hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
        hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.aa.a.Ph().bms.aLQ.aQC));
        hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.aa.a.Ph().bms.aLQ.aQB));
        hashMap.put("external_audio_capture", true);
        this.bwy.v(hashMap);
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bwB == null) {
            this.bwB = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = com.baidu.live.aa.a.Ph().bms.aLQ.fps;
            aVar.ayW = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.azb = true;
            aVar.aza = this.bwB.getPushUrl();
            aVar.ayY = com.baidu.live.aa.a.Ph().bms.aLQ.aQy;
            List<cn.a> list = com.baidu.live.aa.a.Ph().bms.aLQ.dataList;
            aVar.azd = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.aa.a.Ph().bms.aLQ.aQv, com.baidu.live.aa.a.Ph().bms.aLQ.aQw);
            ArrayList arrayList = new ArrayList();
            for (cn.a aVar2 : list) {
                BLMViewShapeType bLMViewShapeType = BLMViewShapeType.RECTANGLE;
                if (aVar2.shape == 1) {
                    bLMViewShapeType = BLMViewShapeType.CIRCLE;
                }
                arrayList.add(new com.baidu.live.alablmsdk.config.a.a(aVar2.order, aVar2.z, bLMViewShapeType, new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height)));
            }
            aVar.azf = arrayList;
            aVar.azg = com.baidu.live.aa.a.Ph().bms.aLQ.aQD;
            aVar.azc = aVar.AD();
            com.baidu.live.alablmsdk.a.b.d(" BCVideoChat blmsdk mixTemplate =" + aVar.azc);
            aVar.ayZ = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bwy != null) {
                this.bwy.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onDestroy() {
        this.bwB = null;
        if (this.bwy != null) {
            this.bwy.onRelease();
            this.bwy = null;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        BdLog.e("BCVideoChat blmsdk onDestroy");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(f fVar) {
        this.bxd = fVar;
        BdLog.e("BCVideoChat blmsdk callback=" + fVar);
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setLiveShowData(w wVar) {
        this.aDh = wVar;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Rv() {
        BdLog.e("BCVideoChat blmsdk, count=" + this.bxc.getCount());
        if (this.bww != null && this.bww.length() != 0) {
            Bv();
        }
        return true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Rt() {
        if (this.bww == null || this.bww.length() == 0 || this.bxc.isEmpty()) {
            return false;
        }
        boolean fn = this.bxc.fn(d.bwR);
        boolean fn2 = this.bxc.fn(d.bwS);
        BdLog.e("BCVideoChat  blmsdk connecting=" + fn + " connected=" + fn2);
        return fn || fn2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Ru() {
        if (this.bww == null || this.bww.length() == 0 || this.bxc.isEmpty()) {
            return false;
        }
        boolean fn = this.bxc.fn(d.bwO);
        boolean fn2 = this.bxc.fn(d.bwQ);
        BdLog.e("BCVideoChat blmsdk idle=" + fn + " wait=" + fn2);
        return fn || fn2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean isFull() {
        return (this.bww == null || this.bww.length() == 0 || !this.bxc.isFull()) ? false : true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean aL(long j) {
        BdLog.e("BCVideoChat blmsdk imUK=" + j + "|mBIMRoomId=" + this.bww + "|count=" + this.bxc.getCount());
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(j);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK fail");
            return false;
        } else if (aP.status == d.bwQ) {
            BdLog.e("BCVideoChat blmsdk start Cancel invite user:" + aP.uid);
            cF(false);
            return true;
        } else if (this.bxc.getCount() == 1) {
            Bv();
            return true;
        } else {
            a(j, aP);
            return true;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int a(com.baidu.live.talentshow.d.a.b bVar) {
        if (bVar == null || bVar.bxu == null) {
            return -1;
        }
        BdLog.e("BCVideoChat blmsdk user=" + bVar.bxu.toString() + "|mBIMRoomId=" + this.bww);
        if (this.bxc.isFull()) {
            BdLog.e("BCVideoChat blmsdk isFull user=" + bVar.bxu.toString());
            return -3;
        } else if (!this.bxc.aN(bVar.bxu.azK)) {
            BdLog.e("BCVideoChat blmsdk cannot invite more user=" + bVar.bxu.toString());
            return -2;
        } else {
            final com.baidu.live.talentshow.d.a.b d = d(bVar.bxu);
            d.uid = bVar.uid;
            this.bxc.c(d);
            if (this.bww == null || this.bww.length() == 0) {
                this.bwy.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.talentshow.d.g.1
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
            a(this.bww, 0, "", d);
            return 0;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk setMute=" + z);
        if (this.bwy != null) {
            this.bwy.ba(z);
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int aJ(long j) {
        com.baidu.live.talentshow.d.a.b aP;
        BdLog.e("BCVideoChat blmsdk  imUK=" + j);
        if (this.bxc.isEmpty() || (aP = this.bxc.aP(j)) == null || aP.bxu == null || aP.bxu.azK != j) {
            return -1;
        }
        return aP.status;
    }

    @Override // com.baidu.live.talentshow.d.a
    public String aM(long j) {
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(j);
        if (aP == null || aP.bxu == null) {
            return "";
        }
        return aP.bxu.userName;
    }

    @Override // com.baidu.live.talentshow.d.a
    public long fk(int i) {
        com.baidu.live.talentshow.d.a.b fo;
        if ((i == 1 || i == 2) && (fo = this.bxc.fo(i)) != null) {
            if (fo.status == d.bwR || fo.status == d.bwS) {
                long j = JavaTypesHelper.toLong(fo.uid, 0L);
                BdLog.e("BCVideoChat index=" + i + " uid=" + j);
                return j;
            }
            return 0L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int i, String str2, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " status=" + i + " msg=" + str2 + " imUK=" + bVar.bxu.azK);
        if (i != 0) {
            this.bxc.aO(bVar.bxu.azK);
            BdLog.e("BCVideoChat blmsdk createRoom fail roomId=" + str + " status=" + i + " msg=" + str2);
            if (this.bxd != null) {
                this.bxd.d(bVar.bxu.azK, bVar.index, d.bwU);
                return;
            }
            return;
        }
        this.bww = str;
        BdLog.e("BCVideoChat blmsdk invite-ext=" + bVar.ext + " userIndex=" + bVar.index);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.bxu);
        this.bwy.a(str, arrayList, bVar.ext, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.2
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(final int i2, final int i3, final String str3) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.1
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
            if (this.bxd != null) {
                this.bxd.d(bVar.bxu.azK, bVar.index, d.bwV);
            }
            this.bxc.aO(bVar.bxu.azK);
            if (this.bxc.isEmpty()) {
                Bv();
            }
            BdLog.e("BCVideoChat blmsdk inviteUser fail roomId=" + str + " status=" + i2 + " msg=" + str2);
            return;
        }
        BdLog.e("BCVideoChat blmsdk inviteUser succ roomId=" + str + " user=" + bVar.bxu.toString() + " ret=" + this.bxc.i(bVar.bxu.azK, d.bwQ));
        if (this.bxd != null) {
            if (this.bxc.getCount() == 1 && !this.bxc.RM()) {
                this.bxd.Qc();
            }
            this.bxd.d(bVar.bxu.azK, bVar.index, 0);
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bvW;
            cVar.bwo = this.bww;
            cVar.bwq = TbadkCoreApplication.getCurrentAccount();
            cVar.ext = bVar.ext;
            this.bxd.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        long j = cVar.azK;
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(cVar.azK);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        } else if (this.bww == null || !this.bww.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bww);
            this.bxc.aO(cVar.azK);
            if (this.bxc.isEmpty()) {
                Bv();
            }
            if (this.bxd != null) {
                this.bxd.E(str, d.bwW);
            }
        } else {
            try {
                String optString = jSONObject.optString(UbcStatConstant.KEY_LIVE_TYPE, "");
                int optInt = jSONObject.optInt("line", -1);
                if (aP.index != optInt || !optString.equals("show_pub_v2")) {
                    BdLog.e("BCVideoChat blmsdk check fail index=" + optInt + " roomIndex=" + aP.index + " liveType=" + optString);
                    this.bxc.aO(cVar.azK);
                    if (this.bxc.isEmpty()) {
                        Bv();
                    }
                    if (this.bxd != null) {
                        this.bxd.E(str, d.bwW);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bxc.getCount() == 1) {
                QG();
                im(this.bww);
            }
            this.bxc.i(cVar.azK, d.bwR);
            if (this.bxd != null) {
                this.bxd.aH(cVar.azK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        long j = cVar.azK;
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(cVar.azK);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        } else if (this.bww == null || !this.bww.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bww);
            this.bxc.aO(cVar.azK);
        } else {
            this.bxc.aO(cVar.azK);
            if (this.bxd != null) {
                this.bxd.d(cVar.azK, aP.index, d.bxa);
                if (this.bxc.isEmpty()) {
                    Bv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK);
        long j = cVar.azK;
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(cVar.azK);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j);
        } else if (this.bww == null || !this.bww.equals(str)) {
            this.bxc.aO(cVar.azK);
        } else {
            this.bxc.aO(cVar.azK);
            if (this.bxd != null) {
                this.bxd.h(cVar.azK, aP.index);
            }
            if (this.bxc.isEmpty() && this.bxc.RM()) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j + " switchToRTMP");
                Bv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.bww == null || str == null || !this.bww.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomUserJoin params error");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomUserJoin roomId=" + str + " imUK=" + cVar.azK);
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(cVar.azK);
        if (aP != null && this.bxd != null) {
            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
            cVar2.action = com.baidu.live.talentshow.b.c.bwf;
            cVar2.bwo = this.bww;
            cVar2.bwq = TbadkCoreApplication.getCurrentAccount();
            cVar2.ext = aP.ext;
            this.bxd.a(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, JSONObject jSONObject, boolean z, int i, String str) {
        com.baidu.live.talentshow.d.a.b aP;
        BdLog.e("BCVideoChat blmsdk dealCancelInviteUsers imUK=" + j + " status=" + i + "|isFromClose=" + z + "|ext=" + jSONObject);
        if (i == 0 && (aP = this.bxc.aP(j)) != null) {
            if (this.bxd != null) {
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bwg;
                cVar.bwo = this.bww;
                cVar.bwq = TbadkCoreApplication.getCurrentAccount();
                cVar.ext = jSONObject;
                this.bxd.a(cVar);
                this.bxd.c(aP.bxu.azK, aP.index, d.bxb);
                this.bxd.aH(aP.bxu.azK);
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " status=" + i + " isFromClose=" + z + " ext=" + jSONObject.toString());
            }
            this.bxc.aO(j);
            if (this.bxc.isEmpty() && !z) {
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                Bv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealJoinRoom status=" + i + " msg=" + str2);
        if (i != 0) {
            Bv();
            if (this.bxd != null) {
                this.bxd.E(this.bww, d.bwX);
            }
        } else if (this.bxd != null) {
            this.bxd.mo22if(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK);
        if (this.bww == null || !this.bww.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bww);
            if (this.bxd != null) {
                this.bxd.aH(cVar.azK);
            }
            this.bxc.aO(cVar.azK);
        } else if (!this.bxc.fn(d.bwQ)) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " user wait not exist");
        } else {
            this.bxc.a(d.bwQ, new a.InterfaceC0203a() { // from class: com.baidu.live.talentshow.d.g.3
                @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0203a
                public void b(com.baidu.live.talentshow.d.a.b bVar) {
                    if (bVar != null && bVar.bxu != null) {
                        BdLog.e("BCVideoChat blmsdk roomId=" + str + " onSelect");
                        if (g.this.bxd != null) {
                            g.this.bxd.aH(bVar.bxu.azK);
                            JSONObject a2 = e.a(g.this.aDh, bVar.uid, bVar.index);
                            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                            cVar2.action = com.baidu.live.talentshow.b.c.bwg;
                            cVar2.bwo = g.this.bww;
                            cVar2.bwq = TbadkCoreApplication.getCurrentAccount();
                            cVar2.ext = a2;
                            g.this.bxd.a(cVar2);
                        }
                        g.this.bxc.aO(bVar.bxu.azK);
                        if (g.this.bxc.isEmpty()) {
                            g.this.Bv();
                        }
                    }
                }
            });
            if (this.bxd != null) {
                this.bxd.E(str, d.bwZ);
            }
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
        if (str == null || this.bww == null || !this.bww.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomRing params error ");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomRing imUK = " + j + " roomId=" + str);
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(j);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null imUK=" + j);
        } else if (this.bxd != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bvY;
            cVar.bwo = this.bww;
            cVar.bwq = TbadkCoreApplication.getCurrentAccount();
            cVar.ext = aP.ext;
            this.bxd.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il(String str) {
        BdLog.e("BCVideoChat blmsdk roomId =" + str + " " + this.bww);
        if (!TextUtils.isEmpty(str) && str.equals(this.bww)) {
            if (this.bxc.RM()) {
                QF();
            }
            this.bxc.reset();
            if (this.bxd != null) {
                this.bxd.d("", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomID=" + str + " imUK=" + cVar.azK);
            com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(cVar.azK);
            if (aP == null) {
                BdLog.e("BCVideoChat blmsdk find user failed");
            } else if (TextUtils.isEmpty(str) || !str.equals(this.bww)) {
                BdLog.e("BCVideoChat blmsdk room not eq");
            } else {
                JSONObject b = e.b(this.aDh, aP.uid, aP.index);
                if (this.bxd != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bwj;
                    cVar2.bwo = this.bww;
                    cVar2.bwq = TbadkCoreApplication.getCurrentAccount();
                    cVar2.ext = b;
                    this.bxd.a(cVar2);
                    this.bxd.g(cVar.azK, aP.index);
                }
                long j = aP.bxu.azK;
                this.bxc.aO(j);
                if (this.bxc.isEmpty()) {
                    BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                    Bv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        BdLog.e("BCVideoChat blmsdk stream.state=" + aVar.aAd + " imUk=" + aVar.azK);
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(aVar.azK);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK return null");
            return;
        }
        if (aP != null && aP.status == d.bwR) {
            aP.status = d.bwS;
        }
        if (this.bxd != null) {
            this.bxd.f(aVar.azK, aP.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        if (aVar.azK == AccountManager.getUK(this.mContext)) {
            BdLog.e("BCVideoChat blmsdk mystream is break");
            if (this.bxd != null) {
                this.bxd.fc(i);
                return;
            }
            return;
        }
        BdLog.e("BCVideoChat blmsdk imUK=" + aVar.azK + " order=" + aVar.order);
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(aVar.azK);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null");
            return;
        }
        if (this.bxd != null) {
            this.bxd.a(aP, i);
            if (i >= 15) {
                JSONObject b = e.b(this.aDh, aP.uid, aP.index);
                if (this.bxd != null) {
                    com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                    cVar.action = com.baidu.live.talentshow.b.c.bwj;
                    cVar.bwo = this.bww;
                    cVar.bwq = TbadkCoreApplication.getCurrentAccount();
                    cVar.ext = b;
                    this.bxd.a(cVar);
                }
            }
        }
        if (i >= 15) {
            this.bxc.aO(aVar.azK);
            if (this.bxc.isEmpty()) {
                BdLog.e("BCVideoChat blmsdk closeRoom imUK=" + aVar.azK + " order=" + aVar.order);
                Bv();
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public View aK(long j) {
        BdLog.e("BCVideoChat blmsdk" + this.bxc.getCount() + "|imuk=" + j);
        com.baidu.live.talentshow.d.a.b aP = this.bxc.aP(j);
        if (aP == null || !(aP.index == 1 || aP.index == 2)) {
            return null;
        }
        return this.bwy.Av().c(aP.bxu);
    }

    private void QG() {
        BdLog.e("BCVideoChat  blmsdk mAuthorLiveRecorder=" + this.bwB);
        final com.baidu.live.alablmsdk.c.a.a Bo = this.bwy.Av().Bo();
        if (this.bwB != null) {
            this.bwB.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.g.4
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (Bo != null) {
                        Bo.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + Bo);
                    }
                }
            });
        }
    }

    private void QF() {
        BdLog.e("BCVideoChat blmsdk count=" + this.bxc.getCount());
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.live.talentshow.d.g.5
            @Override // java.lang.Runnable
            public void run() {
                g.this.bwB.setDefaultCloudRtcMode(null);
                g.this.bwB.startPush();
            }
        }, 500L);
    }

    private void cF(boolean z) {
        if (!this.bxc.isEmpty()) {
            this.bxc.a(d.bwQ, new AnonymousClass6(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.talentshow.d.g$6  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass6 implements a.InterfaceC0203a {
        final /* synthetic */ boolean bxj;

        AnonymousClass6(boolean z) {
            this.bxj = z;
        }

        @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0203a
        public void b(final com.baidu.live.talentshow.d.a.b bVar) {
            BdLog.e("BCVideoChat blmsdk onSelect imUK=" + bVar.bxu.azK);
            if (g.this.bwy != null && g.this.bww != null && g.this.bww.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.bxu);
                final JSONObject a2 = e.a(g.this.aDh, bVar.uid, bVar.index);
                g.this.bwy.b(g.this.bww, arrayList, a2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.6.1
                    @Override // com.baidu.live.alablmsdk.c.c
                    public void e(int i, final int i2, final String str) {
                        BdLog.e("BCVideoChat blmsdk status=" + i2 + " msg=" + str);
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(bVar.bxu.azK, a2, AnonymousClass6.this.bxj, i2, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private void a(final long j, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk imUK = " + j + " uid=" + bVar.uid);
        com.baidu.live.alablmsdk.module.c clone = bVar.bxu.clone();
        ArrayList arrayList = new ArrayList();
        arrayList.add(clone);
        final JSONObject b = e.b(this.aDh, bVar.uid, bVar.index);
        this.bwy.a(this.bww, b, arrayList, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.7
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str) {
                g.this.a(j, bVar.uid, b, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv() {
        BdLog.e("BCVideoChat blmsdk roomId=" + this.bww + " count=" + this.bxc.getCount());
        if (this.bww != null && this.bww.length() != 0) {
            cF(true);
            JSONObject v = e.v(this.aDh);
            this.bwy.d(this.bww, v, (com.baidu.live.alablmsdk.c.c) null);
            this.bxc.reset();
            QF();
            if (this.bxd != null) {
                this.bxd.d(this.bww, v);
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bwc;
                cVar.bwo = this.bww;
                cVar.bwq = TbadkCoreApplication.getCurrentAccount();
                cVar.ext = v;
                this.bxd.a(cVar);
            }
            this.bww = "";
        }
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        int RL = this.bxc.RL();
        BdLog.e("BCVideoChat blmsdk index=" + RL);
        JSONObject a2 = e.a(this.aDh, cVar, RL);
        cVar.order = RL + "";
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.ext = a2;
        bVar.index = RL;
        bVar.status = d.bwO;
        bVar.bxu = cVar;
        return bVar;
    }

    private void im(final String str) {
        BdLog.e("BCVideoChat blmsdk roomID=" + str + " isRtc=" + this.bxc.RM());
        if (!this.bxc.RM()) {
            this.bxc.cG(true);
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.azK = AccountManager.getUK(TbadkCoreApplication.getInst());
            cVar.order = "0";
            this.bwy.a(str, cVar, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.8
                @Override // com.baidu.live.alablmsdk.c.c
                public void e(int i, final int i2, final String str2) {
                    g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.8.1
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
