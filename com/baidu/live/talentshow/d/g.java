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
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g implements a {
    private x aBr;
    private String bBH;
    private com.baidu.live.alablmsdk.a bBJ;
    private Context mContext;
    private Handler mMainHandler;
    private com.baidu.live.talentshow.d.a.a bCl = new com.baidu.live.talentshow.d.a.a();
    private AlaLiveRecorder bBL = null;
    private f bCm = null;
    private com.baidu.live.alablmsdk.c.b bBM = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.g.2
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat onStreamStateChanged state=" + bLMStreamState + " imUk=" + aVar.axT);
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
            BdLog.e("BCVideoChat leavedForSeconds imUk=" + aVar.axT + " sec=" + i);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(aVar, i);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedRing roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar.axT);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInvite roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.axT);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserJoined roomId=" + str + " imUk=" + cVar.axT);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserLeaved roomId=" + str + " imUk=" + cVar.axT);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.axT);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.10
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void ev(final String str) {
            BdLog.e("BCVideoChat onRoomClosed roomId=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.2.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.ht(str);
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
        this.bBJ = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
        this.bBJ.a(this.bBM);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("room_mode", d.bCc);
        hashMap.put("rtc_room_source_key", d.bBW);
        hashMap.put("is_auto_publish", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(15);
        hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
        hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.af.a.OJ().bru.aKH.aPO));
        hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.af.a.OJ().bru.aKH.aPN));
        hashMap.put("external_audio_capture", true);
        this.bBJ.v(hashMap);
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bBL == null) {
            this.bBL = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = com.baidu.live.af.a.OJ().bru.aKH.fps;
            aVar.axe = new com.baidu.live.alablmsdk.config.a.b(540, TbConfig.HEAD_IMG_SIZE);
            aVar.axj = true;
            aVar.axi = this.bBL.getPushUrl();
            aVar.axg = com.baidu.live.af.a.OJ().bru.aKH.aPK;
            List<cr.a> list = com.baidu.live.af.a.OJ().bru.aKH.dataList;
            aVar.axl = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.af.a.OJ().bru.aKH.aPI, com.baidu.live.af.a.OJ().bru.aKH.aPJ);
            ArrayList arrayList = new ArrayList();
            for (cr.a aVar2 : list) {
                BLMViewShapeType bLMViewShapeType = BLMViewShapeType.RECTANGLE;
                if (aVar2.aPR == 1) {
                    bLMViewShapeType = BLMViewShapeType.CIRCLE;
                }
                arrayList.add(new com.baidu.live.alablmsdk.config.a.a(aVar2.order, aVar2.z, bLMViewShapeType, new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height)));
            }
            aVar.axn = arrayList;
            aVar.axo = com.baidu.live.af.a.OJ().bru.aKH.aPP;
            aVar.axk = aVar.xH();
            com.baidu.live.alablmsdk.a.b.a.d(" BCVideoChat blmsdk mixTemplate =" + aVar.axk);
            aVar.axh = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bBJ != null) {
                this.bBJ.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onDestroy() {
        this.bBL = null;
        if (this.bBJ != null) {
            this.bBJ.onRelease();
            this.bBJ = null;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        BdLog.e("BCVideoChat blmsdk onDestroy");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(f fVar) {
        this.bCm = fVar;
        BdLog.e("BCVideoChat blmsdk callback=" + fVar);
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setLiveShowData(x xVar) {
        this.aBr = xVar;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Rd() {
        BdLog.e("BCVideoChat blmsdk, count=" + this.bCl.getCount());
        if (this.bBH != null && this.bBH.length() != 0) {
            yA();
        }
        return true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Rb() {
        if (this.bBH == null || this.bBH.length() == 0 || this.bCl.isEmpty()) {
            return false;
        }
        boolean eg = this.bCl.eg(d.bCa);
        boolean eg2 = this.bCl.eg(d.bCb);
        BdLog.e("BCVideoChat  blmsdk connecting=" + eg + " connected=" + eg2);
        return eg || eg2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Rc() {
        if (this.bBH == null || this.bBH.length() == 0 || this.bCl.isEmpty()) {
            return false;
        }
        boolean eg = this.bCl.eg(d.bBX);
        boolean eg2 = this.bCl.eg(d.bBZ);
        BdLog.e("BCVideoChat blmsdk idle=" + eg + " wait=" + eg2);
        return eg || eg2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean isFull() {
        return (this.bBH == null || this.bBH.length() == 0 || !this.bCl.isFull()) ? false : true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean bj(long j) {
        BdLog.e("BCVideoChat blmsdk imUK=" + j + "|mBIMRoomId=" + this.bBH + "|count=" + this.bCl.getCount());
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(j);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK fail");
            return false;
        } else if (bn.status == d.bBZ) {
            BdLog.e("BCVideoChat blmsdk start Cancel invite user:" + bn.uid);
            cS(false);
            return true;
        } else if (this.bCl.getCount() == 1) {
            yA();
            return true;
        } else {
            a(j, bn);
            return true;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int a(com.baidu.live.talentshow.d.a.b bVar) {
        if (bVar == null || bVar.bCD == null) {
            return -1;
        }
        BdLog.e("BCVideoChat blmsdk user=" + bVar.bCD.toString() + "|mBIMRoomId=" + this.bBH);
        if (this.bCl.isFull()) {
            BdLog.e("BCVideoChat blmsdk isFull user=" + bVar.bCD.toString());
            return -3;
        } else if (!this.bCl.bl(bVar.bCD.axT)) {
            BdLog.e("BCVideoChat blmsdk cannot invite more user=" + bVar.bCD.toString());
            return -2;
        } else {
            final com.baidu.live.talentshow.d.a.b d = d(bVar.bCD);
            d.uid = bVar.uid;
            this.bCl.c(d);
            if (this.bBH == null || this.bBH.length() == 0) {
                this.bBJ.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.talentshow.d.g.1
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
            a(this.bBH, 0, "", d);
            return 0;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk setMute=" + z);
        if (this.bBJ != null) {
            this.bBJ.aZ(z);
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int bh(long j) {
        com.baidu.live.talentshow.d.a.b bn;
        BdLog.e("BCVideoChat blmsdk  imUK=" + j);
        if (this.bCl.isEmpty() || (bn = this.bCl.bn(j)) == null || bn.bCD == null || bn.bCD.axT != j) {
            return -1;
        }
        return bn.status;
    }

    @Override // com.baidu.live.talentshow.d.a
    public String bk(long j) {
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(j);
        if (bn == null || bn.bCD == null) {
            return "";
        }
        return bn.bCD.userName;
    }

    @Override // com.baidu.live.talentshow.d.a
    public long ed(int i) {
        com.baidu.live.talentshow.d.a.b eh;
        if ((i == 1 || i == 2) && (eh = this.bCl.eh(i)) != null) {
            if (eh.status == d.bCa || eh.status == d.bCb) {
                long j = JavaTypesHelper.toLong(eh.uid, 0L);
                BdLog.e("BCVideoChat index=" + i + " uid=" + j);
                return j;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // com.baidu.live.talentshow.d.a
    public void Re() {
        if (this.bBJ != null) {
            this.bBJ.enterBackground();
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void Rf() {
        if (this.bBJ != null) {
            this.bBJ.enterForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int i, String str2, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " status=" + i + " msg=" + str2 + " imUK=" + bVar.bCD.axT);
        if (i != 0) {
            this.bCl.bm(bVar.bCD.axT);
            BdLog.e("BCVideoChat blmsdk createRoom fail roomId=" + str + " status=" + i + " msg=" + str2);
            if (this.bCm != null) {
                this.bCm.d(bVar.bCD.axT, bVar.index, d.bCd);
                return;
            }
            return;
        }
        this.bBH = str;
        BdLog.e("BCVideoChat blmsdk invite-ext=" + bVar.bBE + " userIndex=" + bVar.index);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.bCD);
        this.bBJ.a(str, arrayList, bVar.bBE, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.3
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
            if (this.bCm != null) {
                this.bCm.d(bVar.bCD.axT, bVar.index, d.bCe);
            }
            this.bCl.bm(bVar.bCD.axT);
            if (this.bCl.isEmpty()) {
                yA();
            }
            BdLog.e("BCVideoChat blmsdk inviteUser fail roomId=" + str + " status=" + i2 + " msg=" + str2);
            return;
        }
        BdLog.e("BCVideoChat blmsdk inviteUser succ roomId=" + str + " user=" + bVar.bCD.toString() + " ret=" + this.bCl.j(bVar.bCD.axT, d.bBZ));
        if (this.bCm != null) {
            if (this.bCl.getCount() == 1 && !this.bCl.Rw()) {
                this.bCm.PJ();
            }
            this.bCm.d(bVar.bCD.axT, bVar.index, 0);
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bBh;
            cVar.bBz = this.bBH;
            cVar.bBB = TbadkCoreApplication.getCurrentAccount();
            cVar.bBE = bVar.bBE;
            this.bCm.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        long j = cVar.axT;
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(cVar.axT);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        } else if (this.bBH == null || !this.bBH.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bBH);
            this.bCl.bm(cVar.axT);
            if (this.bCl.isEmpty()) {
                yA();
            } else {
                a(cVar.axT, bn);
            }
            if (this.bCm != null) {
                this.bCm.e(bn.bCD.axT, bn.index, d.bCf);
            }
        } else {
            try {
                String optString = jSONObject.optString(UbcStatConstant.KEY_LIVE_TYPE, "");
                int optInt = jSONObject.optInt("line", -1);
                if (bn.index != optInt || !optString.equals("show_pub_v2")) {
                    BdLog.e("BCVideoChat blmsdk check fail index=" + optInt + " roomIndex=" + bn.index + " liveType=" + optString);
                    this.bCl.bm(cVar.axT);
                    if (this.bCl.isEmpty()) {
                        yA();
                    } else {
                        a(cVar.axT, bn);
                    }
                    if (this.bCm != null) {
                        this.bCm.e(bn.bCD.axT, bn.index, d.bCf);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bCl.getCount() == 1) {
                Qo();
                hu(this.bBH);
            }
            this.bCl.j(cVar.axT, d.bCa);
            if (this.bCm != null) {
                this.bCm.bf(cVar.axT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        long j = cVar.axT;
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(cVar.axT);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        } else if (this.bBH == null || !this.bBH.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bBH);
            this.bCl.bm(cVar.axT);
        } else {
            this.bCl.bm(cVar.axT);
            if (this.bCm != null) {
                this.bCm.d(cVar.axT, bn.index, d.bCj);
                if (this.bCl.isEmpty()) {
                    yA();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT);
        long j = cVar.axT;
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(cVar.axT);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j);
        } else if (this.bBH == null || !this.bBH.equals(str)) {
            this.bCl.bm(cVar.axT);
        } else {
            this.bCl.bm(cVar.axT);
            if (this.bCm != null) {
                this.bCm.i(cVar.axT, bn.index);
            }
            if (this.bCl.isEmpty() && this.bCl.Rw()) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j + " switchToRTMP");
                yA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.bBH == null || str == null || !this.bBH.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomUserJoin params error");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomUserJoin roomId=" + str + " imUK=" + cVar.axT);
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(cVar.axT);
        if (bn != null && this.bCm != null) {
            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
            cVar2.action = com.baidu.live.talentshow.b.c.bBq;
            cVar2.bBz = this.bBH;
            cVar2.bBB = TbadkCoreApplication.getCurrentAccount();
            cVar2.bBE = bn.bBE;
            this.bCm.a(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, JSONObject jSONObject, boolean z, int i, String str) {
        com.baidu.live.talentshow.d.a.b bn;
        BdLog.e("BCVideoChat blmsdk dealCancelInviteUsers imUK=" + j + " status=" + i + "|isFromClose=" + z + "|ext=" + jSONObject);
        if (i == 0 && (bn = this.bCl.bn(j)) != null) {
            if (this.bCm != null) {
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bBr;
                cVar.bBz = this.bBH;
                cVar.bBB = TbadkCoreApplication.getCurrentAccount();
                cVar.bBE = jSONObject;
                this.bCm.a(cVar);
                this.bCm.c(bn.bCD.axT, bn.index, d.bCk);
                this.bCm.bf(bn.bCD.axT);
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " status=" + i + " isFromClose=" + z + " ext=" + jSONObject.toString());
            }
            this.bCl.bm(j);
            if (this.bCl.isEmpty() && !z) {
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                yA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealJoinRoom status=" + i + " msg=" + str2);
        if (i != 0) {
            yA();
            if (this.bCm != null) {
                this.bCm.e(0L, 0, d.bCg);
            }
        } else if (this.bCm != null) {
            this.bCm.hn(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT);
        if (this.bBH == null || !this.bBH.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.bBH);
            if (this.bCm != null) {
                this.bCm.bf(cVar.axT);
            }
            this.bCl.bm(cVar.axT);
        } else if (!this.bCl.eg(d.bBZ)) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " user wait not exist");
        } else {
            this.bCl.a(d.bBZ, new a.InterfaceC0202a() { // from class: com.baidu.live.talentshow.d.g.4
                @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0202a
                public void b(com.baidu.live.talentshow.d.a.b bVar) {
                    if (bVar != null && bVar.bCD != null) {
                        BdLog.e("BCVideoChat blmsdk roomId=" + str + " onSelect");
                        if (g.this.bCm != null) {
                            g.this.bCm.e(bVar.bCD.axT, bVar.index, d.bCi);
                        }
                        if (g.this.bCm != null) {
                            g.this.bCm.bf(bVar.bCD.axT);
                            JSONObject a2 = e.a(g.this.aBr, bVar.uid, bVar.index);
                            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                            cVar2.action = com.baidu.live.talentshow.b.c.bBr;
                            cVar2.bBz = g.this.bBH;
                            cVar2.bBB = TbadkCoreApplication.getCurrentAccount();
                            cVar2.bBE = a2;
                            g.this.bCm.a(cVar2);
                        }
                        g.this.bCl.bm(bVar.bCD.axT);
                        if (g.this.bCl.isEmpty()) {
                            g.this.yA();
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
        if (str == null || this.bBH == null || !this.bBH.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomRing params error ");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomRing imUK = " + j + " roomId=" + str);
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(j);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null imUK=" + j);
        } else if (this.bCm != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bBj;
            cVar.bBz = this.bBH;
            cVar.bBB = TbadkCoreApplication.getCurrentAccount();
            cVar.bBE = bn.bBE;
            this.bCm.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(String str) {
        BdLog.e("BCVideoChat blmsdk roomId =" + str + " " + this.bBH);
        if (!TextUtils.isEmpty(str) && str.equals(this.bBH)) {
            if (this.bCl.Rw()) {
                Qn();
            }
            this.bCl.reset();
            if (this.bCm != null) {
                this.bCm.e("", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomID=" + str + " imUK=" + cVar.axT);
            com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(cVar.axT);
            if (bn == null) {
                BdLog.e("BCVideoChat blmsdk find user failed");
            } else if (TextUtils.isEmpty(str) || !str.equals(this.bBH)) {
                BdLog.e("BCVideoChat blmsdk room not eq");
            } else {
                JSONObject b2 = e.b(this.aBr, bn.uid, bn.index);
                if (this.bCm != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bBu;
                    cVar2.bBz = this.bBH;
                    cVar2.bBB = TbadkCoreApplication.getCurrentAccount();
                    cVar2.bBE = b2;
                    this.bCm.a(cVar2);
                    this.bCm.h(cVar.axT, bn.index);
                }
                long j = bn.bCD.axT;
                this.bCl.bm(j);
                if (this.bCl.isEmpty()) {
                    BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                    yA();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        BdLog.e("BCVideoChat blmsdk stream.state=" + aVar.ayn + " imUk=" + aVar.axT);
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(aVar.axT);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK return null");
            return;
        }
        if (bn != null && bn.status == d.bCa) {
            bn.status = d.bCb;
        }
        if (this.bCm != null) {
            this.bCm.g(aVar.axT, bn.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        if (aVar.axT == AccountManager.getUK(this.mContext)) {
            BdLog.e("BCVideoChat blmsdk mystream is break");
            if (this.bCm != null) {
                this.bCm.dV(i);
                return;
            }
            return;
        }
        BdLog.e("BCVideoChat blmsdk imUK=" + aVar.axT + " order=" + aVar.order);
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(aVar.axT);
        if (bn == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null");
            return;
        }
        if (this.bCm != null) {
            this.bCm.a(bn, i);
            if (i >= 15) {
                JSONObject b2 = e.b(this.aBr, bn.uid, bn.index);
                if (this.bCm != null) {
                    com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                    cVar.action = com.baidu.live.talentshow.b.c.bBu;
                    cVar.bBz = this.bBH;
                    cVar.bBB = TbadkCoreApplication.getCurrentAccount();
                    cVar.bBE = b2;
                    this.bCm.a(cVar);
                }
            }
        }
        if (i >= 15) {
            this.bCl.bm(aVar.axT);
            if (this.bCl.isEmpty()) {
                BdLog.e("BCVideoChat blmsdk closeRoom imUK=" + aVar.axT + " order=" + aVar.order);
                yA();
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public View bi(long j) {
        BdLog.e("BCVideoChat blmsdk" + this.bCl.getCount() + "|imuk=" + j);
        com.baidu.live.talentshow.d.a.b bn = this.bCl.bn(j);
        if (bn == null || !(bn.index == 1 || bn.index == 2)) {
            return null;
        }
        return this.bBJ.xn().c(bn.bCD);
    }

    private void Qo() {
        BdLog.e("BCVideoChat  blmsdk mAuthorLiveRecorder=" + this.bBL);
        final com.baidu.live.alablmsdk.c.a.a ys = this.bBJ.xn().ys();
        if (this.bBL != null) {
            this.bBL.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.g.5
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (ys != null) {
                        ys.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + ys);
                    }
                }
            });
            this.bBL.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.g.6
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (ys != null) {
                        ys.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + ys);
                    }
                }
            });
        }
    }

    private void Qn() {
        BdLog.e("BCVideoChat blmsdk count=" + this.bCl.getCount());
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.live.talentshow.d.g.7
            @Override // java.lang.Runnable
            public void run() {
                g.this.bBL.setEnableCloudRtc(false, null);
                g.this.bBL.setRecorderErrorCallback(null);
                g.this.bBL.startPush();
            }
        }, 500L);
    }

    private void cS(boolean z) {
        if (!this.bCl.isEmpty()) {
            this.bCl.a(d.bBZ, new AnonymousClass8(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.talentshow.d.g$8  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass8 implements a.InterfaceC0202a {
        final /* synthetic */ boolean bCt;

        AnonymousClass8(boolean z) {
            this.bCt = z;
        }

        @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0202a
        public void b(final com.baidu.live.talentshow.d.a.b bVar) {
            BdLog.e("BCVideoChat blmsdk onSelect imUK=" + bVar.bCD.axT);
            if (g.this.bBJ != null && g.this.bBH != null && g.this.bBH.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.bCD);
                final JSONObject a2 = e.a(g.this.aBr, bVar.uid, bVar.index);
                g.this.bBJ.b(g.this.bBH, arrayList, a2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.8.1
                    @Override // com.baidu.live.alablmsdk.c.c
                    public void f(int i, final int i2, final String str) {
                        BdLog.e("BCVideoChat blmsdk status=" + i2 + " msg=" + str);
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(bVar.bCD.axT, a2, AnonymousClass8.this.bCt, i2, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private void a(final long j, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk imUK = " + j + " uid=" + bVar.uid);
        com.baidu.live.alablmsdk.module.c clone = bVar.bCD.clone();
        ArrayList arrayList = new ArrayList();
        arrayList.add(clone);
        final JSONObject b2 = e.b(this.aBr, bVar.uid, bVar.index);
        this.bBJ.a(this.bBH, b2, arrayList, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.9
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str) {
                g.this.a(j, bVar.uid, b2, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yA() {
        BdLog.e("BCVideoChat blmsdk roomId=" + this.bBH + " count=" + this.bCl.getCount());
        if (this.bBH != null && this.bBH.length() != 0) {
            cS(true);
            JSONObject w = e.w(this.aBr);
            this.bBJ.d(this.bBH, w, (com.baidu.live.alablmsdk.c.c) null);
            this.bCl.reset();
            Qn();
            if (this.bCm != null) {
                this.bCm.e(this.bBH, w);
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bBn;
                cVar.bBz = this.bBH;
                cVar.bBB = TbadkCoreApplication.getCurrentAccount();
                cVar.bBE = w;
                this.bCm.a(cVar);
            }
            this.bBH = "";
        }
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        int Rv = this.bCl.Rv();
        BdLog.e("BCVideoChat blmsdk index=" + Rv);
        JSONObject a2 = e.a(this.aBr, cVar, Rv);
        cVar.order = Rv + "";
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.bBE = a2;
        bVar.index = Rv;
        bVar.status = d.bBX;
        bVar.bCD = cVar;
        return bVar;
    }

    private void hu(final String str) {
        BdLog.e("BCVideoChat blmsdk roomID=" + str + " isRtc=" + this.bCl.Rw());
        if (!this.bCl.Rw()) {
            this.bCl.cT(true);
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.axT = AccountManager.getUK(TbadkCoreApplication.getInst());
            cVar.order = "0";
            this.bBJ.a(str, cVar, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.10
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
