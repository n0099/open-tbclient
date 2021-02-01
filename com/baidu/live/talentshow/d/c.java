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
/* loaded from: classes11.dex */
public class c {
    private ab aDd;
    private com.baidu.live.talentshow.components.b.b bCp;
    private String bFn;
    private com.baidu.live.talentshow.d.a.b bFo;
    private b bFq;
    private AlaLiveRecorder bFr;
    private boolean isMute;
    private Context mContext;
    private Handler mMainHandler;
    private int mChatStatus = d.bFG;
    private final com.baidu.live.alablmsdk.c.b bFs = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.c.4
        @Override // com.baidu.live.alablmsdk.c.b
        public void g(int i, String str) {
            BdLog.e("BCVideoChat blmsdk  erroCode=" + i + " msg=" + str);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.c cVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat blmsdk  state=" + bLMStreamState + " imuk=" + cVar.ayk);
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
                BdLog.e("BCVideoChat blmsdk leavedForSeconds imUk=" + cVar.ayk + " sec=" + i + " order " + cVar.order);
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
            BdLog.e("BCVideoChat blmsdk onRoomReceivedRing roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " user=null | ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
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
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
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
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.ayk);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.ayk + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserJoined roomId=" + str + " imUk=" + cVar.ayk);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserLeaved roomId=" + str + " imUk=" + cVar.ayk);
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
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.ayk + "  currentuk: " + AccountManager.getUK(c.this.mContext));
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
        public void ey(final String str) {
            BdLog.e("BCVideoChat blmsdk onRoomClosed roomId=" + str);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.hO(str);
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
    com.baidu.live.alablmsdk.c.b.e bFt = new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.live.talentshow.d.c.5
        @Override // com.baidu.live.alablmsdk.c.b.e
        public void a(String str, String str2, final com.baidu.live.alablmsdk.c.b.a aVar) {
            com.baidu.live.yyrtc.a.ZK().a(str, str2, new com.baidu.live.yyrtc.b() { // from class: com.baidu.live.talentshow.d.c.5.1
                @Override // com.baidu.live.yyrtc.b
                public void ai(String str3, String str4) {
                    if (c.this.bFp != null) {
                        c.this.bFp.ew(str3);
                    }
                    if (aVar != null) {
                        aVar.ai(str3, str4);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.a bFp = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());

    public c(Context context) {
        this.mContext = context;
        Tb();
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bFr = alaLiveRecorder;
    }

    public void a(com.baidu.live.talentshow.components.b.b bVar) {
        this.bCp = bVar;
    }

    public void a(b bVar) {
        this.bFq = bVar;
    }

    public void t(ab abVar) {
        this.aDd = abVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk: chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|ext=" + jSONObject + "|user=" + cVar);
        if (SX() && cVar != null) {
            ej(d.bFI);
            this.bFn = str;
            this.bFo = k(cVar);
            if (this.bFo.index == -1 && jSONObject != null) {
                this.bFo.index = jSONObject.optInt("line", -1);
            }
            if (this.bFq != null) {
                this.bFq.b(cVar, this.bFo.index);
            }
        } else if (SW() && cVar != null) {
            JSONObject c = e.c(this.aDd, JavaTypesHelper.toInt(cVar.order, -1));
            this.bFp.a(str, c, (com.baidu.live.alablmsdk.c.d) null);
            b(com.baidu.live.talentshow.b.c.bEQ, str, com.baidu.live.talentshow.b.c.bFd, TbadkCoreApplication.getCurrentAccount(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk dealReceivedInviteCancel roomId = " + str + "|currentRoomId = " + this.bFn + "|status = " + this.mChatStatus + "|ext=" + jSONObject + "|user=" + cVar);
        if (TextUtils.equals(this.bFn, str) && SY()) {
            resetData();
            SU();
            if (this.bFq != null) {
                this.bFq.RK();
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
        BdLog.e("BCVideoChat blmsdk " + cVar + "|imUk=" + cVar.ayk + "|order=" + cVar.order + "|status=" + this.mChatStatus);
        if (Ta()) {
            try {
                i = Integer.parseInt(cVar.order);
            } catch (NumberFormatException e) {
                i = -1;
            }
            BdLog.e("BCVideoChat blmsdk  order=" + cVar.order + " index=" + i);
            if (this.bCp != null && Build.VERSION.SDK_INT >= 14) {
                View aH = this.bFp.xl().aH(cVar.ayk);
                if (aH != null) {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival  renderView=" + aH + "|index=" + i + "|stream.imUk=" + cVar.ayk);
                } else {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival renderView==null");
                }
                this.bCp.a(aH, i, cVar.ayk, false, false);
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
                SP();
            } else if (this.bFo != null && TextUtils.equals(cVar.order, this.bFo.index + "")) {
                BdLog.e("BCVideoChat blmsdk  currentOrder " + this.bFo.index);
                SP();
            } else {
                BdLog.e("BCVideoChat blmsdk  other");
                if (this.bCp != null) {
                    try {
                        i2 = Integer.parseInt(cVar.order);
                    } catch (NumberFormatException e) {
                        i2 = -1;
                    }
                    this.bCp.ef(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk |roomId=" + str + "|user=" + cVar);
        if (TextUtils.equals(str, this.bFn) && cVar != null) {
            if (cVar.ayk == AccountManager.getUK(this.mContext)) {
                ei(2);
            } else if (this.bFo != null && !TextUtils.equals(cVar.order, this.bFo.index + "") && this.bCp != null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed order = " + cVar.order);
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bCp.ef(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|user=" + cVar + "|mBIMRoomId=" + this.bFn);
        if (this.bFn != null && this.bFn.equals(str) && cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.ayk + " order " + cVar.order);
            if (this.bCp != null) {
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bCp.ef(i);
            }
            b(com.baidu.live.talentshow.b.c.bES, this.bFn, null, TbadkCoreApplication.getCurrentAccount(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(String str) {
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|mBIMRoomId=" + this.bFn);
        if (TextUtils.equals(str, this.bFn)) {
            ei(1);
        }
    }

    public void SN() {
        BdLog.e("BCVideoChat blmsdk acceptChat status=" + this.mChatStatus);
        if (SY()) {
            ej(d.bFJ);
            this.bCp.RY();
            SQ();
            SR();
            final JSONObject b2 = e.b(this.aDd, this.bFo.index);
            this.bFo.bFk = b2;
            this.bFp.aY(this.isMute);
            this.bFp.a(this.bFn, b2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.c.1
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
                                c.this.b(b2, i, str);
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
        if (SZ()) {
            if (i == 0) {
                ej(d.bFK);
                if (this.bFq != null) {
                    this.bFq.RJ();
                }
                b(com.baidu.live.talentshow.b.c.bEQ, this.bFn, com.baidu.live.talentshow.b.c.bFc, TbadkCoreApplication.getCurrentAccount(), jSONObject);
                return;
            }
            if (this.bFq != null) {
                this.bFq.ea(i);
            }
            SP();
        }
    }

    public void SO() {
        BdLog.e("BCVideoChat blmsdk rejectChat mChatStatus=" + this.mChatStatus);
        if (SY() && this.bFp != null) {
            JSONObject c = e.c(this.aDd, this.bFo.index);
            this.bFp.a(this.bFn, c, (com.baidu.live.alablmsdk.c.d) null);
            b(com.baidu.live.talentshow.b.c.bEQ, this.bFn, com.baidu.live.talentshow.b.c.bFd, TbadkCoreApplication.getCurrentAccount(), c);
            resetData();
            SU();
        }
    }

    public void SP() {
        ei(0);
    }

    public void ei(int i) {
        BdLog.e("BCVideoChat blmsdk mChatStatus " + this.mChatStatus + "|code=" + i);
        if (Ta()) {
            JSONObject a2 = e.a(this.aDd, this.bFo.index);
            if (i != 2) {
                this.bFp.b(this.bFn, a2, (com.baidu.live.alablmsdk.c.d) null);
            }
            SS();
            if (this.bCp != null) {
                this.bCp.RX();
            }
            SU();
            if (this.bFq != null) {
                this.bFq.cW(i == 0);
            }
            b(com.baidu.live.talentshow.b.c.bER, this.bFn, null, TbadkCoreApplication.getCurrentAccount(), a2);
            resetData();
            return;
        }
        resetData();
        SU();
    }

    private void SQ() {
        BdLog.e("BCVideoChat blmsdk addRecorderToRtcView");
        if (this.bFr != null && this.bFr.getPreview() != null && this.bCp != null && this.bFo != null) {
            this.bCp.a(this.bFr.getPreview(), this.bFo.index, 0L, true, true);
            this.bFr.startRecord();
        }
    }

    private void SR() {
        final com.baidu.live.alablmsdk.c.a.a yG = this.bFp.xl().yG();
        if (this.bFr != null) {
            this.bFr.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.c.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (yG != null) {
                        yG.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + yG);
                    }
                }
            });
            this.bFr.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.c.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (yG != null) {
                        yG.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + yG);
                    }
                }
            });
        }
    }

    private void SS() {
        BdLog.e("BCVideoChat blmsdk switchNormalLive");
        if (this.bFr != null) {
            this.bFr.setEnableCloudRtc(false, null);
            this.bFr.setRecorderErrorCallback(null);
        }
    }

    private void b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.bFq != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = str;
            cVar.bFf = str2;
            cVar.bFg = str3;
            cVar.bFh = str4;
            cVar.bFk = jSONObject;
            this.bFq.b(cVar);
        }
    }

    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk isMute=" + z);
        this.isMute = z;
        if (this.bFp != null) {
            this.bFp.aY(z);
        }
    }

    private void resetData() {
        this.isMute = false;
        this.bFn = null;
        this.bFo = null;
    }

    public void ST() {
        ej(d.bFH);
    }

    public void SU() {
        ej(d.bFG);
    }

    private void ej(int i) {
        BdLog.e("BCVideoChat blmsdk updateStatus=" + i + " oldStatus = " + this.mChatStatus);
        this.mChatStatus = i;
    }

    public int SV() {
        return this.mChatStatus;
    }

    public boolean SW() {
        return this.mChatStatus == d.bFG;
    }

    public boolean SX() {
        return this.mChatStatus == d.bFH;
    }

    public boolean SY() {
        return this.mChatStatus == d.bFI;
    }

    public boolean SZ() {
        return this.mChatStatus == d.bFJ;
    }

    public boolean Ta() {
        return this.mChatStatus == d.bFJ || this.mChatStatus == d.bFK;
    }

    private com.baidu.live.talentshow.d.a.b k(com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk user=" + cVar.toString());
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.index = JavaTypesHelper.toInt(cVar.order, -1);
        bVar.status = d.bFG;
        bVar.bGn = cVar.clone();
        return bVar;
    }

    private void Tb() {
        if (this.bFp != null) {
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
        }
    }

    public void onStarted() {
        if (this.bFp != null) {
            this.bFp.enterForeground();
        }
    }

    public void onStopped() {
        if (this.bFp != null) {
            this.bFp.enterBackground();
        }
    }

    public void onDestroy() {
        BdLog.e("BCVideoChat blmsdk onDestroy");
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bFp != null) {
            this.bFp.onRelease();
            this.bFp = null;
            com.baidu.live.yyrtc.a.ZK().release();
        }
    }
}
