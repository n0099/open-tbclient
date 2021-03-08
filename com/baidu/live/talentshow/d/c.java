package com.baidu.live.talentshow.d;

import android.content.Context;
import android.os.Build;
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
import com.baidu.live.alablmsdk.module.rtc.BLMJoinRoomStage;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private ab aED;
    private com.baidu.live.talentshow.components.b.b bDP;
    private String bGN;
    private com.baidu.live.talentshow.d.a.b bGO;
    private b bGQ;
    private AlaLiveRecorder bGR;
    private boolean isMute;
    private Context mContext;
    private Handler mMainHandler;
    private int mChatStatus = d.bHg;
    private final com.baidu.live.alablmsdk.c.b bGS = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.c.4
        @Override // com.baidu.live.alablmsdk.c.b
        public void g(int i, String str) {
            BdLog.e("BCVideoChat blmsdk  erroCode=" + i + " msg=" + str);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.c cVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat blmsdk  state=" + bLMStreamState + " imuk=" + cVar.azK);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(cVar, bLMStreamState);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.c cVar, final int i) {
            if (cVar != null) {
                BdLog.e("BCVideoChat blmsdk leavedForSeconds imUk=" + cVar.azK + " sec=" + i + " order " + cVar.order);
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(cVar, i);
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
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.azK + " ext=" + jSONObject);
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.g(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
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
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserJoined roomId=" + str + " imUk=" + cVar.azK);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserLeaved roomId=" + str + " imUk=" + cVar.azK);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.k(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " user=null  currentuk: " + AccountManager.getUK(c.this.mContext));
            } else {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.azK + "  currentuk: " + AccountManager.getUK(c.this.mContext));
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.j(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserShutuped roomId=" + str);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserDisshutuped roomId=" + str);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void eE(final String str) {
            BdLog.e("BCVideoChat blmsdk onRoomClosed roomId=" + str);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.hU(str);
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
    com.baidu.live.alablmsdk.c.b.e bGT = new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.live.talentshow.d.c.5
        @Override // com.baidu.live.alablmsdk.c.b.e
        public void a(String str, String str2, final com.baidu.live.alablmsdk.c.b.a aVar) {
            com.baidu.live.yyrtc.a.ZN().a(str, str2, new com.baidu.live.yyrtc.b() { // from class: com.baidu.live.talentshow.d.c.5.1
                @Override // com.baidu.live.yyrtc.b
                public void ai(String str3, String str4) {
                    if (c.this.bGP != null) {
                        c.this.bGP.eD(str3);
                    }
                    if (aVar != null) {
                        aVar.ai(str3, str4);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.a bGP = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());

    public c(Context context) {
        this.mContext = context;
        Te();
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bGR = alaLiveRecorder;
    }

    public void a(com.baidu.live.talentshow.components.b.b bVar) {
        this.bDP = bVar;
    }

    public void a(b bVar) {
        this.bGQ = bVar;
    }

    public void t(ab abVar) {
        this.aED = abVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk: chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|ext=" + jSONObject + "|user=" + cVar);
        if (Ta() && cVar != null) {
            ek(d.bHi);
            this.bGN = str;
            this.bGO = k(cVar);
            if (this.bGO.index == -1 && jSONObject != null) {
                this.bGO.index = jSONObject.optInt("line", -1);
            }
            if (this.bGQ != null) {
                this.bGQ.b(cVar, this.bGO.index);
            }
        } else if (SZ() && cVar != null) {
            JSONObject c = e.c(this.aED, JavaTypesHelper.toInt(cVar.order, -1));
            this.bGP.a(str, c, (com.baidu.live.alablmsdk.c.d) null);
            b(com.baidu.live.talentshow.b.c.bGq, str, com.baidu.live.talentshow.b.c.bGD, TbadkCoreApplication.getCurrentAccount(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk dealReceivedInviteCancel roomId = " + str + "|currentRoomId = " + this.bGN + "|status = " + this.mChatStatus + "|ext=" + jSONObject + "|user=" + cVar);
        if (TextUtils.equals(this.bGN, str) && Tb()) {
            resetData();
            SX();
            if (this.bGQ != null) {
                this.bGQ.RN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
        int i;
        if (cVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        BdLog.e("BCVideoChat blmsdk " + cVar + "|imUk=" + cVar.azK + "|order=" + cVar.order + "|status=" + this.mChatStatus);
        if (Td()) {
            try {
                i = Integer.parseInt(cVar.order);
            } catch (NumberFormatException e) {
                i = -1;
            }
            BdLog.e("BCVideoChat blmsdk  order=" + cVar.order + " index=" + i);
            if (this.bDP != null && Build.VERSION.SDK_INT >= 14) {
                View aH = this.bGP.xo().aH(cVar.azK);
                if (aH != null) {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival  renderView=" + aH + "|index=" + i + "|stream.imUk=" + cVar.azK);
                } else {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival renderView==null");
                }
                this.bDP.a(aH, i, cVar.azK, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.alablmsdk.module.rtc.c cVar, int i) {
        int i2;
        BdLog.e("BCVideoChat blmsdk |sec=" + i);
        if (cVar != null && i >= 15) {
            if (TextUtils.equals("0", cVar.order)) {
                BdLog.e("BCVideoChat blmsdk  host");
                SS();
            } else if (this.bGO != null && TextUtils.equals(cVar.order, this.bGO.index + "")) {
                BdLog.e("BCVideoChat blmsdk  currentOrder " + this.bGO.index);
                SS();
            } else {
                BdLog.e("BCVideoChat blmsdk  other");
                if (this.bDP != null) {
                    try {
                        i2 = Integer.parseInt(cVar.order);
                    } catch (NumberFormatException e) {
                        i2 = -1;
                    }
                    this.bDP.eg(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk |roomId=" + str + "|user=" + cVar);
        if (TextUtils.equals(str, this.bGN) && cVar != null) {
            if (cVar.azK == AccountManager.getUK(this.mContext)) {
                ej(2);
            } else if (this.bGO != null && !TextUtils.equals(cVar.order, this.bGO.index + "") && this.bDP != null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed order = " + cVar.order);
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bDP.eg(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|user=" + cVar + "|mBIMRoomId=" + this.bGN);
        if (this.bGN != null && this.bGN.equals(str) && cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.azK + " order " + cVar.order);
            if (this.bDP != null) {
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bDP.eg(i);
            }
            b(com.baidu.live.talentshow.b.c.bGs, this.bGN, null, TbadkCoreApplication.getCurrentAccount(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(String str) {
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|mBIMRoomId=" + this.bGN);
        if (TextUtils.equals(str, this.bGN)) {
            ej(1);
        }
    }

    public void SQ() {
        BdLog.e("BCVideoChat blmsdk acceptChat status=" + this.mChatStatus);
        if (Tb()) {
            ek(d.bHj);
            this.bDP.Sb();
            ST();
            SU();
            final JSONObject b = e.b(this.aED, this.bGO.index);
            this.bGO.bGK = b;
            this.bGP.aY(this.isMute);
            this.bGP.a(this.bGN, b, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.c.1
                @Override // com.baidu.live.alablmsdk.c.c
                public void a(final int i, BLMJoinRoomStage bLMJoinRoomStage, final com.baidu.live.alablmsdk.module.common.a aVar) {
                    if (bLMJoinRoomStage != null && bLMJoinRoomStage == BLMJoinRoomStage.JOIN) {
                        c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = "";
                                if (aVar != null) {
                                    str = aVar.msg;
                                }
                                c.this.b(b, i, str);
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, int i, String str) {
        BdLog.e("BCVideoChat blmsdk |status=" + i + "|msg=" + str + "|ext=" + jSONObject + "|mChatStatus: " + this.mChatStatus);
        if (Tc()) {
            if (i == 0) {
                ek(d.bHk);
                if (this.bGQ != null) {
                    this.bGQ.RM();
                }
                b(com.baidu.live.talentshow.b.c.bGq, this.bGN, com.baidu.live.talentshow.b.c.bGC, TbadkCoreApplication.getCurrentAccount(), jSONObject);
                return;
            }
            if (this.bGQ != null) {
                this.bGQ.eb(i);
            }
            SS();
        }
    }

    public void SR() {
        BdLog.e("BCVideoChat blmsdk rejectChat mChatStatus=" + this.mChatStatus);
        if (Tb() && this.bGP != null) {
            JSONObject c = e.c(this.aED, this.bGO.index);
            this.bGP.a(this.bGN, c, (com.baidu.live.alablmsdk.c.d) null);
            b(com.baidu.live.talentshow.b.c.bGq, this.bGN, com.baidu.live.talentshow.b.c.bGD, TbadkCoreApplication.getCurrentAccount(), c);
            resetData();
            SX();
        }
    }

    public void SS() {
        ej(0);
    }

    public void ej(int i) {
        BdLog.e("BCVideoChat blmsdk mChatStatus " + this.mChatStatus + "|code=" + i);
        if (Td()) {
            JSONObject a2 = e.a(this.aED, this.bGO.index);
            if (i != 2) {
                this.bGP.b(this.bGN, a2, (com.baidu.live.alablmsdk.c.d) null);
            }
            SV();
            if (this.bDP != null) {
                this.bDP.Sa();
            }
            SX();
            if (this.bGQ != null) {
                this.bGQ.cW(i == 0);
            }
            b(com.baidu.live.talentshow.b.c.bGr, this.bGN, null, TbadkCoreApplication.getCurrentAccount(), a2);
            resetData();
            return;
        }
        resetData();
        SX();
    }

    private void ST() {
        BdLog.e("BCVideoChat blmsdk addRecorderToRtcView");
        if (this.bGR != null && this.bGR.getPreview() != null && this.bDP != null && this.bGO != null) {
            this.bDP.a(this.bGR.getPreview(), this.bGO.index, 0L, true, true);
            this.bGR.startRecord();
        }
    }

    private void SU() {
        final com.baidu.live.alablmsdk.c.a.a yJ = this.bGP.xo().yJ();
        if (this.bGR != null) {
            this.bGR.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.c.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (yJ != null) {
                        yJ.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + yJ);
                    }
                }
            });
            this.bGR.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.c.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (yJ != null) {
                        yJ.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + yJ);
                    }
                }
            });
        }
    }

    private void SV() {
        BdLog.e("BCVideoChat blmsdk switchNormalLive");
        if (this.bGR != null) {
            this.bGR.setEnableCloudRtc(false, null);
            this.bGR.setRecorderErrorCallback(null);
        }
    }

    private void b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.bGQ != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = str;
            cVar.bGF = str2;
            cVar.bGG = str3;
            cVar.bGH = str4;
            cVar.bGK = jSONObject;
            this.bGQ.b(cVar);
        }
    }

    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk isMute=" + z);
        this.isMute = z;
        if (this.bGP != null) {
            this.bGP.aY(z);
        }
    }

    private void resetData() {
        this.isMute = false;
        this.bGN = null;
        this.bGO = null;
    }

    public void SW() {
        ek(d.bHh);
    }

    public void SX() {
        ek(d.bHg);
    }

    private void ek(int i) {
        BdLog.e("BCVideoChat blmsdk updateStatus=" + i + " oldStatus = " + this.mChatStatus);
        this.mChatStatus = i;
    }

    public int SY() {
        return this.mChatStatus;
    }

    public boolean SZ() {
        return this.mChatStatus == d.bHg;
    }

    public boolean Ta() {
        return this.mChatStatus == d.bHh;
    }

    public boolean Tb() {
        return this.mChatStatus == d.bHi;
    }

    public boolean Tc() {
        return this.mChatStatus == d.bHj;
    }

    public boolean Td() {
        return this.mChatStatus == d.bHj || this.mChatStatus == d.bHk;
    }

    private com.baidu.live.talentshow.d.a.b k(com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk user=" + cVar.toString());
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.index = JavaTypesHelper.toInt(cVar.order, -1);
        bVar.status = d.bHg;
        bVar.bHN = cVar.clone();
        return bVar;
    }

    private void Te() {
        if (this.bGP != null) {
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
        }
    }

    public void onStarted() {
        if (this.bGP != null) {
            this.bGP.enterForeground();
        }
    }

    public void onStopped() {
        if (this.bGP != null) {
            this.bGP.enterBackground();
        }
    }

    public void onDestroy() {
        BdLog.e("BCVideoChat blmsdk onDestroy");
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bGP != null) {
            this.bGP.onRelease();
            this.bGP = null;
            com.baidu.live.yyrtc.a.ZN().release();
        }
    }
}
