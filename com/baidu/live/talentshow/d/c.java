package com.baidu.live.talentshow.d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private w aDh;
    private com.baidu.live.talentshow.components.b.b bty;
    private b bwA;
    private AlaLiveRecorder bwB;
    private String bww;
    private com.baidu.live.talentshow.d.a.b bwx;
    private boolean isMute;
    private Context mContext;
    private Handler mMainHandler;
    private int bwz = d.bwO;
    private final com.baidu.live.alablmsdk.c.b bwC = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.c.3
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat blmsdk  state=" + bLMStreamState + " imuk=" + aVar.azK);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(aVar, bLMStreamState);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            if (aVar != null) {
                BdLog.e("BCVideoChat blmsdk leavedForSeconds imUk=" + aVar.azK + " sec=" + i + " order " + aVar.order);
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(aVar, i);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedRing roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " user=null | ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " user=null ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.g(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.azK);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserJoined roomId=" + str + " imUk=" + cVar.azK);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserLeaved roomId=" + str + " imUk=" + cVar.azK);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.g(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " user=null  currentuk: " + AccountManager.getUK(c.this.mContext));
            } else {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.azK + "  currentuk: " + AccountManager.getUK(c.this.mContext));
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fB(final String str) {
            BdLog.e("BCVideoChat blmsdk onRoomClosed roomId=" + str);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ik(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fC(String str) {
            BdLog.e("BCVideoChat blmsdk onLogReport message=" + str);
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
    private com.baidu.live.alablmsdk.b bwy = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());

    public c(Context context) {
        this.mContext = context;
        RK();
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bwB = alaLiveRecorder;
    }

    public void a(com.baidu.live.talentshow.components.b.b bVar) {
        this.bty = bVar;
    }

    public void a(b bVar) {
        this.bwA = bVar;
    }

    public void s(w wVar) {
        this.aDh = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk: chatStatus=" + this.bwz + "|chatRoomId=" + str + "|ext=" + jSONObject + "|user=" + cVar);
        if (RG() && cVar != null) {
            fm(d.bwQ);
            this.bww = str;
            this.bwx = d(cVar);
            if (this.bwx.index == -1 && jSONObject != null) {
                this.bwx.index = jSONObject.optInt("line", -1);
            }
            if (this.bwA != null) {
                this.bwA.b(cVar, this.bwx.index);
            }
        } else if (RF() && cVar != null) {
            JSONObject c = e.c(this.aDh, JavaTypesHelper.toInt(cVar.order, -1));
            this.bwy.b(str, c, (com.baidu.live.alablmsdk.c.c) null);
            a(com.baidu.live.talentshow.b.c.bvZ, str, com.baidu.live.talentshow.b.c.bwm, TbadkCoreApplication.getCurrentAccount(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk dealReceivedInviteCancel roomId = " + str + "|currentRoomId = " + this.bww + "|status = " + this.bwz + "|ext=" + jSONObject + "|user=" + cVar);
        if (TextUtils.equals(this.bww, str) && RH()) {
            resetData();
            RD();
            if (this.bwA != null) {
                this.bwA.Qx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        int i;
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        BdLog.e("BCVideoChat blmsdk " + aVar + "|imUk=" + aVar.azK + "|order=" + aVar.order + "|status=" + this.bwz);
        if (RJ()) {
            try {
                i = Integer.parseInt(aVar.order);
            } catch (NumberFormatException e) {
                i = -1;
            }
            BdLog.e("BCVideoChat blmsdk  order=" + aVar.order + " index=" + i);
            if (this.bty != null && Build.VERSION.SDK_INT >= 14) {
                TextureView ah = this.bwy.Av().ah(aVar.azK);
                if (ah != null) {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival  renderView=" + ah + "|index=" + i + "|stream.imUk=" + aVar.azK + "|renderView.surface=" + ah.getSurfaceTexture());
                } else {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival renderView==null");
                }
                this.bty.a(ah, i, aVar.azK, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        int i2;
        BdLog.e("BCVideoChat blmsdk |sec=" + i);
        if (aVar != null && i >= 15) {
            if (TextUtils.equals("0", aVar.order)) {
                BdLog.e("BCVideoChat blmsdk  host");
                Ry();
            } else if (this.bwx != null && TextUtils.equals(aVar.order, this.bwx.index + "")) {
                BdLog.e("BCVideoChat blmsdk  currentOrder " + this.bwx.index);
                Ry();
            } else {
                BdLog.e("BCVideoChat blmsdk  other");
                if (this.bty != null) {
                    try {
                        i2 = Integer.parseInt(aVar.order);
                    } catch (NumberFormatException e) {
                        i2 = -1;
                    }
                    this.bty.fi(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk |roomId=" + str + "|user=" + cVar);
        if (TextUtils.equals(str, this.bww) && cVar != null) {
            if (cVar.azK == AccountManager.getUK(this.mContext)) {
                fl(2);
            } else if (this.bwx != null && !TextUtils.equals(cVar.order, this.bwx.index + "") && this.bty != null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed order = " + cVar.order);
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bty.fi(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|user=" + cVar + "|mBIMRoomId=" + this.bww);
        if (this.bww != null && this.bww.equals(str) && cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " order " + cVar.order);
            if (this.bty != null) {
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bty.fi(i);
            }
            a(com.baidu.live.talentshow.b.c.bwb, this.bww, null, TbadkCoreApplication.getCurrentAccount(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(String str) {
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|mBIMRoomId=" + this.bww);
        if (TextUtils.equals(str, this.bww)) {
            fl(1);
        }
    }

    public void Rw() {
        BdLog.e("BCVideoChat blmsdk acceptChat status=" + this.bwz);
        if (RH()) {
            fm(d.bwR);
            this.bty.QG();
            Rz();
            RA();
            final JSONObject b = e.b(this.aDh, this.bwx.index);
            this.bwx.ext = b;
            this.bwy.ba(this.isMute);
            this.bwy.a(this.bww, b, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.c.1
                @Override // com.baidu.live.alablmsdk.c.c
                public void e(int i, final int i2, final String str) {
                    c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(b, i2, str);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, int i, String str) {
        BdLog.e("BCVideoChat blmsdk |status=" + i + "|msg=" + str + "|ext=" + jSONObject + "|mChatStatus: " + this.bwz);
        if (RI()) {
            if (i == 0) {
                fm(d.bwS);
                if (this.bwA != null) {
                    this.bwA.Qw();
                }
                a(com.baidu.live.talentshow.b.c.bvZ, this.bww, com.baidu.live.talentshow.b.c.bwl, TbadkCoreApplication.getCurrentAccount(), jSONObject);
                return;
            }
            if (this.bwA != null) {
                this.bwA.fd(i);
            }
            Ry();
        }
    }

    public void Rx() {
        BdLog.e("BCVideoChat blmsdk rejectChat mChatStatus=" + this.bwz);
        if (RH() && this.bwy != null) {
            JSONObject c = e.c(this.aDh, this.bwx.index);
            this.bwy.b(this.bww, c, (com.baidu.live.alablmsdk.c.c) null);
            a(com.baidu.live.talentshow.b.c.bvZ, this.bww, com.baidu.live.talentshow.b.c.bwm, TbadkCoreApplication.getCurrentAccount(), c);
            resetData();
            RD();
        }
    }

    public void Ry() {
        fl(0);
    }

    public void fl(int i) {
        BdLog.e("BCVideoChat blmsdk mChatStatus " + this.bwz + "|code=" + i);
        if (RJ()) {
            JSONObject a2 = e.a(this.aDh, this.bwx.index);
            if (i != 2) {
                this.bwy.c(this.bww, a2, (com.baidu.live.alablmsdk.c.c) null);
            }
            RB();
            if (this.bty != null) {
                this.bty.QF();
            }
            RD();
            if (this.bwA != null) {
                this.bwA.cB(i == 0);
            }
            a(com.baidu.live.talentshow.b.c.bwa, this.bww, null, TbadkCoreApplication.getCurrentAccount(), a2);
            resetData();
            return;
        }
        resetData();
        RD();
    }

    private void Rz() {
        BdLog.e("BCVideoChat blmsdk addRecorderToRtcView");
        if (this.bwB != null && this.bwB.getPreview() != null && this.bty != null && this.bwx != null) {
            this.bty.a(this.bwB.getPreview(), this.bwx.index, 0L, true, true);
            this.bwB.startRecord();
        }
    }

    private void RA() {
        final com.baidu.live.alablmsdk.c.a.a Bo = this.bwy.Av().Bo();
        if (this.bwB != null) {
            this.bwB.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.c.2
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (Bo != null) {
                        Bo.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + Bo);
                    }
                }
            });
        }
    }

    private void RB() {
        BdLog.e("BCVideoChat blmsdk switchNormalLive");
        if (this.bwB != null) {
            this.bwB.setDefaultCloudRtcMode(null);
        }
    }

    private void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.bwA != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = str;
            cVar.bwo = str2;
            cVar.bwp = str3;
            cVar.bwq = str4;
            cVar.ext = jSONObject;
            this.bwA.b(cVar);
        }
    }

    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk isMute=" + z);
        this.isMute = z;
        if (this.bwy != null) {
            this.bwy.ba(z);
        }
    }

    private void resetData() {
        this.isMute = false;
        this.bww = null;
        this.bwx = null;
    }

    public void RC() {
        fm(d.bwP);
    }

    public void RD() {
        fm(d.bwO);
    }

    private void fm(int i) {
        BdLog.e("BCVideoChat blmsdk updateStatus=" + i + " oldStatus = " + this.bwz);
        this.bwz = i;
    }

    public int RE() {
        return this.bwz;
    }

    public boolean RF() {
        return this.bwz == d.bwO;
    }

    public boolean RG() {
        return this.bwz == d.bwP;
    }

    public boolean RH() {
        return this.bwz == d.bwQ;
    }

    public boolean RI() {
        return this.bwz == d.bwR;
    }

    public boolean RJ() {
        return this.bwz == d.bwR || this.bwz == d.bwS;
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk user=" + cVar.toString());
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.index = JavaTypesHelper.toInt(cVar.order, -1);
        bVar.status = d.bwO;
        bVar.bxu = cVar.clone();
        return bVar;
    }

    private void RK() {
        if (this.bwy != null) {
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
        }
    }

    public void onDestroy() {
        BdLog.e("BCVideoChat blmsdk onDestroy");
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bwy != null) {
            this.bwy.onRelease();
            this.bwy = null;
        }
    }
}
