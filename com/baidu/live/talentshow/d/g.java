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
    private w aES;
    private String byh;
    private com.baidu.live.alablmsdk.b byj;
    private Context mContext;
    private Handler mMainHandler;
    private com.baidu.live.talentshow.d.a.a byN = new com.baidu.live.talentshow.d.a.a();
    private AlaLiveRecorder bym = null;
    private f byO = null;
    private com.baidu.live.alablmsdk.c.b byn = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.g.9
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat onStreamStateChanged state=" + bLMStreamState + " imUk=" + aVar.aBv);
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
            BdLog.e("BCVideoChat leavedForSeconds imUk=" + aVar.aBv + " sec=" + i);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(aVar, i);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedRing roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar.aBv);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInvite roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.aBv);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("BCVideoChat onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserJoined roomId=" + str + " imUk=" + cVar.aBv);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserLeaved roomId=" + str + " imUk=" + cVar.aBv);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.aBv);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.10
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("BCVideoChat onRoomClosed roomId=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.9.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.ir(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fI(String str) {
            BdLog.e("BCVideoChat onLogReport message=" + str);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("blm_msg", str);
                    jSONObject.put("blm_from", "show_pub_v2");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(com.baidu.live.alablmsdk.a.aAm, com.baidu.live.alablmsdk.a.LOG_TYPE, com.baidu.live.alablmsdk.a.aAn, com.baidu.live.alablmsdk.a.aAo);
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logLMSdkEvent(ubcStatisticItem);
            }
        }
    };

    @Override // com.baidu.live.talentshow.d.a
    public void init(Context context) {
        this.mContext = context;
        this.byj = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());
        this.byj.a(this.byn);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("room_mode", d.byE);
        hashMap.put("rtc_room_source_key", d.byy);
        hashMap.put("is_auto_publish", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(15);
        hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
        hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.aa.a.PQ().bod.aNB.aSn));
        hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.aa.a.PQ().bod.aNB.aSm));
        hashMap.put("external_audio_capture", true);
        this.byj.v(hashMap);
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bym == null) {
            this.bym = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = com.baidu.live.aa.a.PQ().bod.aNB.fps;
            aVar.aAH = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aAM = true;
            aVar.aAL = this.bym.getPushUrl();
            aVar.aAJ = com.baidu.live.aa.a.PQ().bod.aNB.aSj;
            List<cn.a> list = com.baidu.live.aa.a.PQ().bod.aNB.dataList;
            aVar.aAO = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.aa.a.PQ().bod.aNB.aSg, com.baidu.live.aa.a.PQ().bod.aNB.aSh);
            ArrayList arrayList = new ArrayList();
            for (cn.a aVar2 : list) {
                BLMViewShapeType bLMViewShapeType = BLMViewShapeType.RECTANGLE;
                if (aVar2.shape == 1) {
                    bLMViewShapeType = BLMViewShapeType.CIRCLE;
                }
                arrayList.add(new com.baidu.live.alablmsdk.config.a.a(aVar2.order, aVar2.z, bLMViewShapeType, new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height)));
            }
            aVar.aAQ = arrayList;
            aVar.aAR = com.baidu.live.aa.a.PQ().bod.aNB.aSo;
            aVar.aAN = aVar.Bm();
            com.baidu.live.alablmsdk.a.b.d(" BCVideoChat blmsdk mixTemplate =" + aVar.aAN);
            aVar.aAK = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.byj != null) {
                this.byj.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void onDestroy() {
        this.bym = null;
        if (this.byj != null) {
            this.byj.onRelease();
            this.byj = null;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        BdLog.e("BCVideoChat blmsdk onDestroy");
    }

    @Override // com.baidu.live.talentshow.d.a
    public void a(f fVar) {
        this.byO = fVar;
        BdLog.e("BCVideoChat blmsdk callback=" + fVar);
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setLiveShowData(w wVar) {
        this.aES = wVar;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Se() {
        BdLog.e("BCVideoChat blmsdk, count=" + this.byN.getCount());
        if (this.byh != null && this.byh.length() != 0) {
            Ce();
        }
        return true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Sc() {
        if (this.byh == null || this.byh.length() == 0 || this.byN.isEmpty()) {
            return false;
        }
        boolean fr = this.byN.fr(d.byC);
        boolean fr2 = this.byN.fr(d.byD);
        BdLog.e("BCVideoChat  blmsdk connecting=" + fr + " connected=" + fr2);
        return fr || fr2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean Sd() {
        if (this.byh == null || this.byh.length() == 0 || this.byN.isEmpty()) {
            return false;
        }
        boolean fr = this.byN.fr(d.byz);
        boolean fr2 = this.byN.fr(d.byB);
        BdLog.e("BCVideoChat blmsdk idle=" + fr + " wait=" + fr2);
        return fr || fr2;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean isFull() {
        return (this.byh == null || this.byh.length() == 0 || !this.byN.isFull()) ? false : true;
    }

    @Override // com.baidu.live.talentshow.d.a
    public boolean aL(long j) {
        BdLog.e("BCVideoChat blmsdk imUK=" + j + "|mBIMRoomId=" + this.byh + "|count=" + this.byN.getCount());
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(j);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK fail");
            return false;
        } else if (aP.status == d.byB) {
            BdLog.e("BCVideoChat blmsdk start Cancel invite user:" + aP.uid);
            cD(false);
            return true;
        } else if (this.byN.getCount() == 1) {
            Ce();
            return true;
        } else {
            a(j, aP);
            return true;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int a(com.baidu.live.talentshow.d.a.b bVar) {
        if (bVar == null || bVar.bzf == null) {
            return -1;
        }
        BdLog.e("BCVideoChat blmsdk user=" + bVar.bzf.toString() + "|mBIMRoomId=" + this.byh);
        if (this.byN.isFull()) {
            BdLog.e("BCVideoChat blmsdk isFull user=" + bVar.bzf.toString());
            return -3;
        } else if (!this.byN.aN(bVar.bzf.aBv)) {
            BdLog.e("BCVideoChat blmsdk cannot invite more user=" + bVar.bzf.toString());
            return -2;
        } else {
            final com.baidu.live.talentshow.d.a.b d = d(bVar.bzf);
            d.uid = bVar.uid;
            this.byN.c(d);
            if (this.byh == null || this.byh.length() == 0) {
                this.byj.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.talentshow.d.g.1
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
            a(this.byh, 0, "", d);
            return 0;
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk setMute=" + z);
        if (this.byj != null) {
            this.byj.aY(z);
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public int aJ(long j) {
        com.baidu.live.talentshow.d.a.b aP;
        BdLog.e("BCVideoChat blmsdk  imUK=" + j);
        if (this.byN.isEmpty() || (aP = this.byN.aP(j)) == null || aP.bzf == null || aP.bzf.aBv != j) {
            return -1;
        }
        return aP.status;
    }

    @Override // com.baidu.live.talentshow.d.a
    public String aM(long j) {
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(j);
        if (aP == null || aP.bzf == null) {
            return "";
        }
        return aP.bzf.userName;
    }

    @Override // com.baidu.live.talentshow.d.a
    public long fo(int i) {
        com.baidu.live.talentshow.d.a.b fs;
        if ((i == 1 || i == 2) && (fs = this.byN.fs(i)) != null) {
            if (fs.status == d.byC || fs.status == d.byD) {
                long j = JavaTypesHelper.toLong(fs.uid, 0L);
                BdLog.e("BCVideoChat index=" + i + " uid=" + j);
                return j;
            }
            return 0L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int i, String str2, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " status=" + i + " msg=" + str2 + " imUK=" + bVar.bzf.aBv);
        if (i != 0) {
            this.byN.aO(bVar.bzf.aBv);
            BdLog.e("BCVideoChat blmsdk createRoom fail roomId=" + str + " status=" + i + " msg=" + str2);
            if (this.byO != null) {
                this.byO.d(bVar.bzf.aBv, bVar.index, d.byF);
                return;
            }
            return;
        }
        this.byh = str;
        BdLog.e("BCVideoChat blmsdk invite-ext=" + bVar.ext + " userIndex=" + bVar.index);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.bzf);
        this.byj.a(str, arrayList, bVar.ext, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.2
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(final int i2, final int i3, final String str3) {
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
            if (this.byO != null) {
                this.byO.d(bVar.bzf.aBv, bVar.index, d.byG);
            }
            this.byN.aO(bVar.bzf.aBv);
            if (this.byN.isEmpty()) {
                Ce();
            }
            BdLog.e("BCVideoChat blmsdk inviteUser fail roomId=" + str + " status=" + i2 + " msg=" + str2);
            return;
        }
        BdLog.e("BCVideoChat blmsdk inviteUser succ roomId=" + str + " user=" + bVar.bzf.toString() + " ret=" + this.byN.i(bVar.bzf.aBv, d.byB));
        if (this.byO != null) {
            if (this.byN.getCount() == 1 && !this.byN.Sv()) {
                this.byO.QL();
            }
            this.byO.d(bVar.bzf.aBv, bVar.index, 0);
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bxH;
            cVar.bxZ = this.byh;
            cVar.byb = TbadkCoreApplication.getCurrentAccount();
            cVar.ext = bVar.ext;
            this.byO.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        long j = cVar.aBv;
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(cVar.aBv);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        } else if (this.byh == null || !this.byh.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.byh);
            this.byN.aO(cVar.aBv);
            if (this.byN.isEmpty()) {
                Ce();
            }
            if (this.byO != null) {
                this.byO.E(str, d.byH);
            }
        } else {
            try {
                String optString = jSONObject.optString(UbcStatConstant.KEY_LIVE_TYPE, "");
                int optInt = jSONObject.optInt("line", -1);
                if (aP.index != optInt || !optString.equals("show_pub_v2")) {
                    BdLog.e("BCVideoChat blmsdk check fail index=" + optInt + " roomIndex=" + aP.index + " liveType=" + optString);
                    this.byN.aO(cVar.aBv);
                    if (this.byN.isEmpty()) {
                        Ce();
                    }
                    if (this.byO != null) {
                        this.byO.E(str, d.byH);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.byN.getCount() == 1) {
                Rp();
                is(this.byh);
            }
            this.byN.i(cVar.aBv, d.byC);
            if (this.byO != null) {
                this.byO.aH(cVar.aBv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        long j = cVar.aBv;
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(cVar.aBv);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        } else if (this.byh == null || !this.byh.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.byh);
            this.byN.aO(cVar.aBv);
        } else {
            this.byN.aO(cVar.aBv);
            if (this.byO != null) {
                this.byO.d(cVar.aBv, aP.index, d.byL);
                if (this.byN.isEmpty()) {
                    Ce();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv);
        long j = cVar.aBv;
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(cVar.aBv);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j);
        } else if (this.byh == null || !this.byh.equals(str)) {
            this.byN.aO(cVar.aBv);
        } else {
            this.byN.aO(cVar.aBv);
            if (this.byO != null) {
                this.byO.h(cVar.aBv, aP.index);
            }
            if (this.byN.isEmpty() && this.byN.Sv()) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + j + " switchToRTMP");
                Ce();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.byh == null || str == null || !this.byh.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomUserJoin params error");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomUserJoin roomId=" + str + " imUK=" + cVar.aBv);
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(cVar.aBv);
        if (aP != null && this.byO != null) {
            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
            cVar2.action = com.baidu.live.talentshow.b.c.bxQ;
            cVar2.bxZ = this.byh;
            cVar2.byb = TbadkCoreApplication.getCurrentAccount();
            cVar2.ext = aP.ext;
            this.byO.a(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, JSONObject jSONObject, boolean z, int i, String str) {
        com.baidu.live.talentshow.d.a.b aP;
        BdLog.e("BCVideoChat blmsdk dealCancelInviteUsers imUK=" + j + " status=" + i + "|isFromClose=" + z + "|ext=" + jSONObject);
        if (i == 0 && (aP = this.byN.aP(j)) != null) {
            if (this.byO != null) {
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bxR;
                cVar.bxZ = this.byh;
                cVar.byb = TbadkCoreApplication.getCurrentAccount();
                cVar.ext = jSONObject;
                this.byO.a(cVar);
                this.byO.c(aP.bzf.aBv, aP.index, d.byM);
                this.byO.aH(aP.bzf.aBv);
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " status=" + i + " isFromClose=" + z + " ext=" + jSONObject.toString());
            }
            this.byN.aO(j);
            if (this.byN.isEmpty() && !z) {
                BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                Ce();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        BdLog.e("BCVideoChat blmsdk dealJoinRoom status=" + i + " msg=" + str2);
        if (i != 0) {
            Ce();
            if (this.byO != null) {
                this.byO.E(this.byh, d.byI);
            }
        } else if (this.byO != null) {
            this.byO.il(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv);
        if (this.byh == null || !this.byh.equals(str)) {
            BdLog.e("BCVideoChat blmsdk roomId not equal roomId=" + str + " mBIMRoomId=" + this.byh);
            if (this.byO != null) {
                this.byO.aH(cVar.aBv);
            }
            this.byN.aO(cVar.aBv);
        } else if (!this.byN.fr(d.byB)) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " user wait not exist");
        } else {
            this.byN.a(d.byB, new a.InterfaceC0205a() { // from class: com.baidu.live.talentshow.d.g.3
                @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0205a
                public void b(com.baidu.live.talentshow.d.a.b bVar) {
                    if (bVar != null && bVar.bzf != null) {
                        BdLog.e("BCVideoChat blmsdk roomId=" + str + " onSelect");
                        if (g.this.byO != null) {
                            g.this.byO.aH(bVar.bzf.aBv);
                            JSONObject a2 = e.a(g.this.aES, bVar.uid, bVar.index);
                            com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                            cVar2.action = com.baidu.live.talentshow.b.c.bxR;
                            cVar2.bxZ = g.this.byh;
                            cVar2.byb = TbadkCoreApplication.getCurrentAccount();
                            cVar2.ext = a2;
                            g.this.byO.a(cVar2);
                        }
                        g.this.byN.aO(bVar.bzf.aBv);
                        if (g.this.byN.isEmpty()) {
                            g.this.Ce();
                        }
                    }
                }
            });
            if (this.byO != null) {
                this.byO.E(str, d.byK);
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
        if (str == null || this.byh == null || !this.byh.equals(str)) {
            BdLog.e("BCVideoChat blmsdk dealRoomRing params error ");
            return;
        }
        BdLog.e("BCVideoChat blmsdk dealRoomRing imUK = " + j + " roomId=" + str);
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(j);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null imUK=" + j);
        } else if (this.byO != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = com.baidu.live.talentshow.b.c.bxJ;
            cVar.bxZ = this.byh;
            cVar.byb = TbadkCoreApplication.getCurrentAccount();
            cVar.ext = aP.ext;
            this.byO.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(String str) {
        BdLog.e("BCVideoChat blmsdk roomId =" + str + " " + this.byh);
        if (!TextUtils.isEmpty(str) && str.equals(this.byh)) {
            if (this.byN.Sv()) {
                Ro();
            }
            this.byN.reset();
            if (this.byO != null) {
                this.byO.d("", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomID=" + str + " imUK=" + cVar.aBv);
            com.baidu.live.talentshow.d.a.b aP = this.byN.aP(cVar.aBv);
            if (aP == null) {
                BdLog.e("BCVideoChat blmsdk find user failed");
            } else if (TextUtils.isEmpty(str) || !str.equals(this.byh)) {
                BdLog.e("BCVideoChat blmsdk room not eq");
            } else {
                JSONObject b = e.b(this.aES, aP.uid, aP.index);
                if (this.byO != null) {
                    com.baidu.live.talentshow.b.c cVar2 = new com.baidu.live.talentshow.b.c();
                    cVar2.action = com.baidu.live.talentshow.b.c.bxU;
                    cVar2.bxZ = this.byh;
                    cVar2.byb = TbadkCoreApplication.getCurrentAccount();
                    cVar2.ext = b;
                    this.byO.a(cVar2);
                    this.byO.g(cVar.aBv, aP.index);
                }
                long j = aP.bzf.aBv;
                this.byN.aO(j);
                if (this.byN.isEmpty()) {
                    BdLog.e("BCVideoChat blmsdk imUK=" + j + " later closeRoom");
                    Ce();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        BdLog.e("BCVideoChat blmsdk stream.state=" + aVar.aBO + " imUk=" + aVar.aBv);
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(aVar.aBv);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk queryByImUK return null");
            return;
        }
        if (aP != null && aP.status == d.byC) {
            aP.status = d.byD;
        }
        if (this.byO != null) {
            this.byO.f(aVar.aBv, aP.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        if (aVar.aBv == AccountManager.getUK(this.mContext)) {
            BdLog.e("BCVideoChat blmsdk mystream is break");
            if (this.byO != null) {
                this.byO.fg(i);
                return;
            }
            return;
        }
        BdLog.e("BCVideoChat blmsdk imUK=" + aVar.aBv + " order=" + aVar.order);
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(aVar.aBv);
        if (aP == null) {
            BdLog.e("BCVideoChat blmsdk chatUser = null");
            return;
        }
        if (this.byO != null) {
            this.byO.a(aP, i);
            if (i >= 15) {
                JSONObject b = e.b(this.aES, aP.uid, aP.index);
                if (this.byO != null) {
                    com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                    cVar.action = com.baidu.live.talentshow.b.c.bxU;
                    cVar.bxZ = this.byh;
                    cVar.byb = TbadkCoreApplication.getCurrentAccount();
                    cVar.ext = b;
                    this.byO.a(cVar);
                }
            }
        }
        if (i >= 15) {
            this.byN.aO(aVar.aBv);
            if (this.byN.isEmpty()) {
                BdLog.e("BCVideoChat blmsdk closeRoom imUK=" + aVar.aBv + " order=" + aVar.order);
                Ce();
            }
        }
    }

    @Override // com.baidu.live.talentshow.d.a
    public View aK(long j) {
        BdLog.e("BCVideoChat blmsdk" + this.byN.getCount() + "|imuk=" + j);
        com.baidu.live.talentshow.d.a.b aP = this.byN.aP(j);
        if (aP == null || !(aP.index == 1 || aP.index == 2)) {
            return null;
        }
        return this.byj.Be().c(aP.bzf);
    }

    private void Rp() {
        BdLog.e("BCVideoChat  blmsdk mAuthorLiveRecorder=" + this.bym);
        final com.baidu.live.alablmsdk.c.a.a BX = this.byj.Be().BX();
        if (this.bym != null) {
            this.bym.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.g.4
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (BX != null) {
                        BX.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat capturer=" + BX);
                    }
                }
            });
        }
    }

    private void Ro() {
        BdLog.e("BCVideoChat blmsdk count=" + this.byN.getCount());
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.live.talentshow.d.g.5
            @Override // java.lang.Runnable
            public void run() {
                g.this.bym.setDefaultCloudRtcMode(null);
                g.this.bym.startPush();
            }
        }, 500L);
    }

    private void cD(boolean z) {
        if (!this.byN.isEmpty()) {
            this.byN.a(d.byB, new AnonymousClass6(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.talentshow.d.g$6  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass6 implements a.InterfaceC0205a {
        final /* synthetic */ boolean byU;

        AnonymousClass6(boolean z) {
            this.byU = z;
        }

        @Override // com.baidu.live.talentshow.d.a.a.InterfaceC0205a
        public void b(final com.baidu.live.talentshow.d.a.b bVar) {
            BdLog.e("BCVideoChat blmsdk onSelect imUK=" + bVar.bzf.aBv);
            if (g.this.byj != null && g.this.byh != null && g.this.byh.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.bzf);
                final JSONObject a2 = e.a(g.this.aES, bVar.uid, bVar.index);
                g.this.byj.b(g.this.byh, arrayList, a2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.6.1
                    @Override // com.baidu.live.alablmsdk.c.c
                    public void f(int i, final int i2, final String str) {
                        BdLog.e("BCVideoChat blmsdk status=" + i2 + " msg=" + str);
                        g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.g.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.a(bVar.bzf.aBv, a2, AnonymousClass6.this.byU, i2, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private void a(final long j, final com.baidu.live.talentshow.d.a.b bVar) {
        BdLog.e("BCVideoChat blmsdk imUK = " + j + " uid=" + bVar.uid);
        com.baidu.live.alablmsdk.module.c clone = bVar.bzf.clone();
        ArrayList arrayList = new ArrayList();
        arrayList.add(clone);
        final JSONObject b = e.b(this.aES, bVar.uid, bVar.index);
        this.byj.a(this.byh, b, arrayList, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.7
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str) {
                g.this.a(j, bVar.uid, b, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        BdLog.e("BCVideoChat blmsdk roomId=" + this.byh + " count=" + this.byN.getCount());
        if (this.byh != null && this.byh.length() != 0) {
            cD(true);
            JSONObject v = e.v(this.aES);
            this.byj.d(this.byh, v, (com.baidu.live.alablmsdk.c.c) null);
            this.byN.reset();
            Ro();
            if (this.byO != null) {
                this.byO.d(this.byh, v);
                com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
                cVar.action = com.baidu.live.talentshow.b.c.bxN;
                cVar.bxZ = this.byh;
                cVar.byb = TbadkCoreApplication.getCurrentAccount();
                cVar.ext = v;
                this.byO.a(cVar);
            }
            this.byh = "";
        }
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        int Su = this.byN.Su();
        BdLog.e("BCVideoChat blmsdk index=" + Su);
        JSONObject a2 = e.a(this.aES, cVar, Su);
        cVar.order = Su + "";
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.ext = a2;
        bVar.index = Su;
        bVar.status = d.byz;
        bVar.bzf = cVar;
        return bVar;
    }

    private void is(final String str) {
        BdLog.e("BCVideoChat blmsdk roomID=" + str + " isRtc=" + this.byN.Sv());
        if (!this.byN.Sv()) {
            this.byN.cE(true);
            com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
            cVar.aBv = AccountManager.getUK(TbadkCoreApplication.getInst());
            cVar.order = "0";
            this.byj.a(str, cVar, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.g.8
                @Override // com.baidu.live.alablmsdk.c.c
                public void f(int i, final int i2, final String str2) {
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
