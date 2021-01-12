package com.baidu.live.talentshow.d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderErrorCallback;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private x aBr;
    private String bBH;
    private com.baidu.live.talentshow.d.a.b bBI;
    private b bBK;
    private AlaLiveRecorder bBL;
    private com.baidu.live.talentshow.components.b.b byJ;
    private boolean isMute;
    private Context mContext;
    private Handler mMainHandler;
    private int mChatStatus = d.bBX;
    private final com.baidu.live.alablmsdk.c.b bBM = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.c.4
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat blmsdk  state=" + bLMStreamState + " imuk=" + aVar.axT);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.1
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
                BdLog.e("BCVideoChat blmsdk leavedForSeconds imUk=" + aVar.axT + " sec=" + i + " order " + aVar.order);
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(aVar, i);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedRing roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " user=null | ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.3
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
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.g(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.axT);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.axT + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserJoined roomId=" + str + " imUk=" + cVar.axT);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserLeaved roomId=" + str + " imUk=" + cVar.axT);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.5
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
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.axT + "  currentuk: " + AccountManager.getUK(c.this.mContext));
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void ev(final String str) {
            BdLog.e("BCVideoChat blmsdk onRoomClosed roomId=" + str);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.hs(str);
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
    private com.baidu.live.alablmsdk.a bBJ = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());

    public c(Context context) {
        this.mContext = context;
        Ru();
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bBL = alaLiveRecorder;
    }

    public void a(com.baidu.live.talentshow.components.b.b bVar) {
        this.byJ = bVar;
    }

    public void a(b bVar) {
        this.bBK = bVar;
    }

    public void t(x xVar) {
        this.aBr = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk: chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|ext=" + jSONObject + "|user=" + cVar);
        if (Rq() && cVar != null) {
            ef(d.bBZ);
            this.bBH = str;
            this.bBI = d(cVar);
            if (this.bBI.index == -1 && jSONObject != null) {
                this.bBI.index = jSONObject.optInt("line", -1);
            }
            if (this.bBK != null) {
                this.bBK.b(cVar, this.bBI.index);
            }
        } else if (Rp() && cVar != null) {
            JSONObject c = e.c(this.aBr, JavaTypesHelper.toInt(cVar.order, -1));
            this.bBJ.b(str, c, (com.baidu.live.alablmsdk.c.c) null);
            b(com.baidu.live.talentshow.b.c.bBk, str, com.baidu.live.talentshow.b.c.bBx, TbadkCoreApplication.getCurrentAccount(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk dealReceivedInviteCancel roomId = " + str + "|currentRoomId = " + this.bBH + "|status = " + this.mChatStatus + "|ext=" + jSONObject + "|user=" + cVar);
        if (TextUtils.equals(this.bBH, str) && Rr()) {
            resetData();
            Rn();
            if (this.bBK != null) {
                this.bBK.Qa();
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
        BdLog.e("BCVideoChat blmsdk " + aVar + "|imUk=" + aVar.axT + "|order=" + aVar.order + "|status=" + this.mChatStatus);
        if (Rt()) {
            try {
                i = Integer.parseInt(aVar.order);
            } catch (NumberFormatException e) {
                i = -1;
            }
            BdLog.e("BCVideoChat blmsdk  order=" + aVar.order + " index=" + i);
            if (this.byJ != null && Build.VERSION.SDK_INT >= 14) {
                TextureView aE = this.bBJ.xn().aE(aVar.axT);
                if (aE != null) {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival  renderView=" + aE + "|index=" + i + "|stream.imUk=" + aVar.axT + "|renderView.surface=" + aE.getSurfaceTexture());
                } else {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival renderView==null");
                }
                this.byJ.a(aE, i, aVar.axT, false, false);
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
                Ri();
            } else if (this.bBI != null && TextUtils.equals(aVar.order, this.bBI.index + "")) {
                BdLog.e("BCVideoChat blmsdk  currentOrder " + this.bBI.index);
                Ri();
            } else {
                BdLog.e("BCVideoChat blmsdk  other");
                if (this.byJ != null) {
                    try {
                        i2 = Integer.parseInt(aVar.order);
                    } catch (NumberFormatException e) {
                        i2 = -1;
                    }
                    this.byJ.eb(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk |roomId=" + str + "|user=" + cVar);
        if (TextUtils.equals(str, this.bBH) && cVar != null) {
            if (cVar.axT == AccountManager.getUK(this.mContext)) {
                ee(2);
            } else if (this.bBI != null && !TextUtils.equals(cVar.order, this.bBI.index + "") && this.byJ != null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed order = " + cVar.order);
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.byJ.eb(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|user=" + cVar + "|mBIMRoomId=" + this.bBH);
        if (this.bBH != null && this.bBH.equals(str) && cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.axT + " order " + cVar.order);
            if (this.byJ != null) {
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.byJ.eb(i);
            }
            b(com.baidu.live.talentshow.b.c.bBm, this.bBH, null, TbadkCoreApplication.getCurrentAccount(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(String str) {
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|mBIMRoomId=" + this.bBH);
        if (TextUtils.equals(str, this.bBH)) {
            ee(1);
        }
    }

    public void Rg() {
        BdLog.e("BCVideoChat blmsdk acceptChat status=" + this.mChatStatus);
        if (Rr()) {
            ef(d.bCa);
            this.byJ.Qo();
            Rj();
            Rk();
            final JSONObject b2 = e.b(this.aBr, this.bBI.index);
            this.bBI.bBE = b2;
            this.bBJ.aZ(this.isMute);
            this.bBJ.a(this.bBH, b2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.c.1
                @Override // com.baidu.live.alablmsdk.c.c
                public void f(int i, final int i2, final String str) {
                    c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.b(b2, i2, str);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, int i, String str) {
        BdLog.e("BCVideoChat blmsdk |status=" + i + "|msg=" + str + "|ext=" + jSONObject + "|mChatStatus: " + this.mChatStatus);
        if (Rs()) {
            if (i == 0) {
                ef(d.bCb);
                if (this.bBK != null) {
                    this.bBK.PZ();
                }
                b(com.baidu.live.talentshow.b.c.bBk, this.bBH, com.baidu.live.talentshow.b.c.bBw, TbadkCoreApplication.getCurrentAccount(), jSONObject);
                return;
            }
            if (this.bBK != null) {
                this.bBK.dW(i);
            }
            Ri();
        }
    }

    public void Rh() {
        BdLog.e("BCVideoChat blmsdk rejectChat mChatStatus=" + this.mChatStatus);
        if (Rr() && this.bBJ != null) {
            JSONObject c = e.c(this.aBr, this.bBI.index);
            this.bBJ.b(this.bBH, c, (com.baidu.live.alablmsdk.c.c) null);
            b(com.baidu.live.talentshow.b.c.bBk, this.bBH, com.baidu.live.talentshow.b.c.bBx, TbadkCoreApplication.getCurrentAccount(), c);
            resetData();
            Rn();
        }
    }

    public void Ri() {
        ee(0);
    }

    public void ee(int i) {
        BdLog.e("BCVideoChat blmsdk mChatStatus " + this.mChatStatus + "|code=" + i);
        if (Rt()) {
            JSONObject a2 = e.a(this.aBr, this.bBI.index);
            if (i != 2) {
                this.bBJ.c(this.bBH, a2, (com.baidu.live.alablmsdk.c.c) null);
            }
            Rl();
            if (this.byJ != null) {
                this.byJ.Qn();
            }
            Rn();
            if (this.bBK != null) {
                this.bBK.cO(i == 0);
            }
            b(com.baidu.live.talentshow.b.c.bBl, this.bBH, null, TbadkCoreApplication.getCurrentAccount(), a2);
            resetData();
            return;
        }
        resetData();
        Rn();
    }

    private void Rj() {
        BdLog.e("BCVideoChat blmsdk addRecorderToRtcView");
        if (this.bBL != null && this.bBL.getPreview() != null && this.byJ != null && this.bBI != null) {
            this.byJ.a(this.bBL.getPreview(), this.bBI.index, 0L, true, true);
            this.bBL.startRecord();
        }
    }

    private void Rk() {
        final com.baidu.live.alablmsdk.c.a.a ys = this.bBJ.xn().ys();
        if (this.bBL != null) {
            this.bBL.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.c.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (ys != null) {
                        ys.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + ys);
                    }
                }
            });
            this.bBL.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.c.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (ys != null) {
                        ys.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + ys);
                    }
                }
            });
        }
    }

    private void Rl() {
        BdLog.e("BCVideoChat blmsdk switchNormalLive");
        if (this.bBL != null) {
            this.bBL.setEnableCloudRtc(false, null);
            this.bBL.setRecorderErrorCallback(null);
        }
    }

    private void b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.bBK != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = str;
            cVar.bBz = str2;
            cVar.bBA = str3;
            cVar.bBB = str4;
            cVar.bBE = jSONObject;
            this.bBK.b(cVar);
        }
    }

    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk isMute=" + z);
        this.isMute = z;
        if (this.bBJ != null) {
            this.bBJ.aZ(z);
        }
    }

    private void resetData() {
        this.isMute = false;
        this.bBH = null;
        this.bBI = null;
    }

    public void Rm() {
        ef(d.bBY);
    }

    public void Rn() {
        ef(d.bBX);
    }

    private void ef(int i) {
        BdLog.e("BCVideoChat blmsdk updateStatus=" + i + " oldStatus = " + this.mChatStatus);
        this.mChatStatus = i;
    }

    public int Ro() {
        return this.mChatStatus;
    }

    public boolean Rp() {
        return this.mChatStatus == d.bBX;
    }

    public boolean Rq() {
        return this.mChatStatus == d.bBY;
    }

    public boolean Rr() {
        return this.mChatStatus == d.bBZ;
    }

    public boolean Rs() {
        return this.mChatStatus == d.bCa;
    }

    public boolean Rt() {
        return this.mChatStatus == d.bCa || this.mChatStatus == d.bCb;
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk user=" + cVar.toString());
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.index = JavaTypesHelper.toInt(cVar.order, -1);
        bVar.status = d.bBX;
        bVar.bCD = cVar.clone();
        return bVar;
    }

    private void Ru() {
        if (this.bBJ != null) {
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
        }
    }

    public void onStarted() {
        if (this.bBJ != null) {
            this.bBJ.enterForeground();
        }
    }

    public void onStopped() {
        if (this.bBJ != null) {
            this.bBJ.enterBackground();
        }
    }

    public void onDestroy() {
        BdLog.e("BCVideoChat blmsdk onDestroy");
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bBJ != null) {
            this.bBJ.onRelease();
            this.bBJ = null;
        }
    }
}
