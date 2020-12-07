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
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private w aFN;
    private String bBG;
    private com.baidu.live.talentshow.d.a.b bBH;
    private b bBJ;
    private AlaLiveRecorder bBK;
    private com.baidu.live.talentshow.components.b.b byJ;
    private boolean isMute;
    private Context mContext;
    private Handler mMainHandler;
    private int mChatStatus = d.bBW;
    private final com.baidu.live.alablmsdk.c.b bBL = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.c.4
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat blmsdk  state=" + bLMStreamState + " imuk=" + aVar.aCp);
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
                BdLog.e("BCVideoChat blmsdk leavedForSeconds imUk=" + aVar.aCp + " sec=" + i + " order " + aVar.order);
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
            BdLog.e("BCVideoChat blmsdk onRoomReceivedRing roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " user=null | ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
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
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
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
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.aCp);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.aCp + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserJoined roomId=" + str + " imUk=" + cVar.aCp);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserLeaved roomId=" + str + " imUk=" + cVar.aCp);
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
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.aCp + "  currentuk: " + AccountManager.getUK(c.this.mContext));
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fX(final String str) {
            BdLog.e("BCVideoChat blmsdk onRoomClosed roomId=" + str);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.iO(str);
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
    private com.baidu.live.alablmsdk.a bBI = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());

    public c(Context context) {
        this.mContext = context;
        Ui();
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bBK = alaLiveRecorder;
    }

    public void a(com.baidu.live.talentshow.components.b.b bVar) {
        this.byJ = bVar;
    }

    public void a(b bVar) {
        this.bBJ = bVar;
    }

    public void s(w wVar) {
        this.aFN = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk: chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|ext=" + jSONObject + "|user=" + cVar);
        if (Ue() && cVar != null) {
            fK(d.bBY);
            this.bBG = str;
            this.bBH = d(cVar);
            if (this.bBH.index == -1 && jSONObject != null) {
                this.bBH.index = jSONObject.optInt("line", -1);
            }
            if (this.bBJ != null) {
                this.bBJ.b(cVar, this.bBH.index);
            }
        } else if (Ud() && cVar != null) {
            JSONObject c = e.c(this.aFN, JavaTypesHelper.toInt(cVar.order, -1));
            this.bBI.b(str, c, (com.baidu.live.alablmsdk.c.c) null);
            b(com.baidu.live.talentshow.b.c.bBj, str, com.baidu.live.talentshow.b.c.bBw, TbadkCoreApplication.getCurrentAccount(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk dealReceivedInviteCancel roomId = " + str + "|currentRoomId = " + this.bBG + "|status = " + this.mChatStatus + "|ext=" + jSONObject + "|user=" + cVar);
        if (TextUtils.equals(this.bBG, str) && Uf()) {
            resetData();
            Ub();
            if (this.bBJ != null) {
                this.bBJ.SV();
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
        BdLog.e("BCVideoChat blmsdk " + aVar + "|imUk=" + aVar.aCp + "|order=" + aVar.order + "|status=" + this.mChatStatus);
        if (Uh()) {
            try {
                i = Integer.parseInt(aVar.order);
            } catch (NumberFormatException e) {
                i = -1;
            }
            BdLog.e("BCVideoChat blmsdk  order=" + aVar.order + " index=" + i);
            if (this.byJ != null && Build.VERSION.SDK_INT >= 14) {
                TextureView aF = this.bBI.BR().aF(aVar.aCp);
                if (aF != null) {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival  renderView=" + aF + "|index=" + i + "|stream.imUk=" + aVar.aCp + "|renderView.surface=" + aF.getSurfaceTexture());
                } else {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival renderView==null");
                }
                this.byJ.a(aF, i, aVar.aCp, false, false);
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
                TW();
            } else if (this.bBH != null && TextUtils.equals(aVar.order, this.bBH.index + "")) {
                BdLog.e("BCVideoChat blmsdk  currentOrder " + this.bBH.index);
                TW();
            } else {
                BdLog.e("BCVideoChat blmsdk  other");
                if (this.byJ != null) {
                    try {
                        i2 = Integer.parseInt(aVar.order);
                    } catch (NumberFormatException e) {
                        i2 = -1;
                    }
                    this.byJ.fG(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk |roomId=" + str + "|user=" + cVar);
        if (TextUtils.equals(str, this.bBG) && cVar != null) {
            if (cVar.aCp == AccountManager.getUK(this.mContext)) {
                fJ(2);
            } else if (this.bBH != null && !TextUtils.equals(cVar.order, this.bBH.index + "") && this.byJ != null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed order = " + cVar.order);
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.byJ.fG(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|user=" + cVar + "|mBIMRoomId=" + this.bBG);
        if (this.bBG != null && this.bBG.equals(str) && cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCp + " order " + cVar.order);
            if (this.byJ != null) {
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.byJ.fG(i);
            }
            b(com.baidu.live.talentshow.b.c.bBl, this.bBG, null, TbadkCoreApplication.getCurrentAccount(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(String str) {
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|mBIMRoomId=" + this.bBG);
        if (TextUtils.equals(str, this.bBG)) {
            fJ(1);
        }
    }

    public void TU() {
        BdLog.e("BCVideoChat blmsdk acceptChat status=" + this.mChatStatus);
        if (Uf()) {
            fK(d.bBZ);
            this.byJ.Te();
            TX();
            TY();
            final JSONObject b = e.b(this.aFN, this.bBH.index);
            this.bBH.ext = b;
            this.bBI.bg(this.isMute);
            this.bBI.a(this.bBG, b, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.c.1
                @Override // com.baidu.live.alablmsdk.c.c
                public void f(int i, final int i2, final String str) {
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
        BdLog.e("BCVideoChat blmsdk |status=" + i + "|msg=" + str + "|ext=" + jSONObject + "|mChatStatus: " + this.mChatStatus);
        if (Ug()) {
            if (i == 0) {
                fK(d.bCa);
                if (this.bBJ != null) {
                    this.bBJ.SU();
                }
                b(com.baidu.live.talentshow.b.c.bBj, this.bBG, com.baidu.live.talentshow.b.c.bBv, TbadkCoreApplication.getCurrentAccount(), jSONObject);
                return;
            }
            if (this.bBJ != null) {
                this.bBJ.fB(i);
            }
            TW();
        }
    }

    public void TV() {
        BdLog.e("BCVideoChat blmsdk rejectChat mChatStatus=" + this.mChatStatus);
        if (Uf() && this.bBI != null) {
            JSONObject c = e.c(this.aFN, this.bBH.index);
            this.bBI.b(this.bBG, c, (com.baidu.live.alablmsdk.c.c) null);
            b(com.baidu.live.talentshow.b.c.bBj, this.bBG, com.baidu.live.talentshow.b.c.bBw, TbadkCoreApplication.getCurrentAccount(), c);
            resetData();
            Ub();
        }
    }

    public void TW() {
        fJ(0);
    }

    public void fJ(int i) {
        BdLog.e("BCVideoChat blmsdk mChatStatus " + this.mChatStatus + "|code=" + i);
        if (Uh()) {
            JSONObject a2 = e.a(this.aFN, this.bBH.index);
            if (i != 2) {
                this.bBI.c(this.bBG, a2, (com.baidu.live.alablmsdk.c.c) null);
            }
            TZ();
            if (this.byJ != null) {
                this.byJ.Td();
            }
            Ub();
            if (this.bBJ != null) {
                this.bBJ.cP(i == 0);
            }
            b(com.baidu.live.talentshow.b.c.bBk, this.bBG, null, TbadkCoreApplication.getCurrentAccount(), a2);
            resetData();
            return;
        }
        resetData();
        Ub();
    }

    private void TX() {
        BdLog.e("BCVideoChat blmsdk addRecorderToRtcView");
        if (this.bBK != null && this.bBK.getPreview() != null && this.byJ != null && this.bBH != null) {
            this.byJ.a(this.bBK.getPreview(), this.bBH.index, 0L, true, true);
            this.bBK.startRecord();
        }
    }

    private void TY() {
        final com.baidu.live.alablmsdk.c.a.a CW = this.bBI.BR().CW();
        if (this.bBK != null) {
            this.bBK.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.c.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (CW != null) {
                        CW.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + CW);
                    }
                }
            });
            this.bBK.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.c.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (CW != null) {
                        CW.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + CW);
                    }
                }
            });
        }
    }

    private void TZ() {
        BdLog.e("BCVideoChat blmsdk switchNormalLive");
        if (this.bBK != null) {
            this.bBK.setDefaultCloudRtcMode(null);
            this.bBK.setRecorderErrorCallback(null);
        }
    }

    private void b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.bBJ != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = str;
            cVar.bBy = str2;
            cVar.bBz = str3;
            cVar.bBA = str4;
            cVar.ext = jSONObject;
            this.bBJ.b(cVar);
        }
    }

    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk isMute=" + z);
        this.isMute = z;
        if (this.bBI != null) {
            this.bBI.bg(z);
        }
    }

    private void resetData() {
        this.isMute = false;
        this.bBG = null;
        this.bBH = null;
    }

    public void Ua() {
        fK(d.bBX);
    }

    public void Ub() {
        fK(d.bBW);
    }

    private void fK(int i) {
        BdLog.e("BCVideoChat blmsdk updateStatus=" + i + " oldStatus = " + this.mChatStatus);
        this.mChatStatus = i;
    }

    public int Uc() {
        return this.mChatStatus;
    }

    public boolean Ud() {
        return this.mChatStatus == d.bBW;
    }

    public boolean Ue() {
        return this.mChatStatus == d.bBX;
    }

    public boolean Uf() {
        return this.mChatStatus == d.bBY;
    }

    public boolean Ug() {
        return this.mChatStatus == d.bBZ;
    }

    public boolean Uh() {
        return this.mChatStatus == d.bBZ || this.mChatStatus == d.bCa;
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk user=" + cVar.toString());
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.index = JavaTypesHelper.toInt(cVar.order, -1);
        bVar.status = d.bBW;
        bVar.bCC = cVar.clone();
        return bVar;
    }

    private void Ui() {
        if (this.bBI != null) {
            this.bBI.a(this.bBL);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", d.bCb);
            hashMap.put("rtc_room_source_key", d.bBV);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(15);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.ae.a.RB().brA.aON.aTE));
            hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.ae.a.RB().brA.aON.aTD));
            hashMap.put("external_audio_capture", true);
            this.bBI.v(hashMap);
        }
    }

    public void onStarted() {
        if (this.bBI != null) {
            this.bBI.enterForeground();
        }
    }

    public void onStopped() {
        if (this.bBI != null) {
            this.bBI.enterBackground();
        }
    }

    public void onDestroy() {
        BdLog.e("BCVideoChat blmsdk onDestroy");
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bBI != null) {
            this.bBI.onRelease();
            this.bBI = null;
        }
    }
}
