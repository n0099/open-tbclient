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
/* loaded from: classes11.dex */
public class c {
    private x aGe;
    private com.baidu.live.talentshow.components.b.b bDv;
    private String bGt;
    private com.baidu.live.talentshow.d.a.b bGu;
    private b bGw;
    private AlaLiveRecorder bGx;
    private boolean isMute;
    private Context mContext;
    private Handler mMainHandler;
    private int mChatStatus = d.bGJ;
    private final com.baidu.live.alablmsdk.c.b bGy = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.c.4
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat blmsdk  state=" + bLMStreamState + " imuk=" + aVar.aCG);
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
                BdLog.e("BCVideoChat blmsdk leavedForSeconds imUk=" + aVar.aCG + " sec=" + i + " order " + aVar.order);
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
            BdLog.e("BCVideoChat blmsdk onRoomReceivedRing roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " user=null | ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
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
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
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
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.aCG);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.aCG + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserJoined roomId=" + str + " imUk=" + cVar.aCG);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserLeaved roomId=" + str + " imUk=" + cVar.aCG);
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
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.aCG + "  currentuk: " + AccountManager.getUK(c.this.mContext));
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("BCVideoChat blmsdk onRoomClosed roomId=" + str);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.4.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.iD(str);
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
    private com.baidu.live.alablmsdk.a bGv = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());

    public c(Context context) {
        this.mContext = context;
        Vn();
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bGx = alaLiveRecorder;
    }

    public void a(com.baidu.live.talentshow.components.b.b bVar) {
        this.bDv = bVar;
    }

    public void a(b bVar) {
        this.bGw = bVar;
    }

    public void t(x xVar) {
        this.aGe = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk: chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|ext=" + jSONObject + "|user=" + cVar);
        if (Vj() && cVar != null) {
            fL(d.bGL);
            this.bGt = str;
            this.bGu = d(cVar);
            if (this.bGu.index == -1 && jSONObject != null) {
                this.bGu.index = jSONObject.optInt("line", -1);
            }
            if (this.bGw != null) {
                this.bGw.b(cVar, this.bGu.index);
            }
        } else if (Vi() && cVar != null) {
            JSONObject c = e.c(this.aGe, JavaTypesHelper.toInt(cVar.order, -1));
            this.bGv.b(str, c, (com.baidu.live.alablmsdk.c.c) null);
            b(com.baidu.live.talentshow.b.c.bFW, str, com.baidu.live.talentshow.b.c.bGj, TbadkCoreApplication.getCurrentAccount(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk dealReceivedInviteCancel roomId = " + str + "|currentRoomId = " + this.bGt + "|status = " + this.mChatStatus + "|ext=" + jSONObject + "|user=" + cVar);
        if (TextUtils.equals(this.bGt, str) && Vk()) {
            resetData();
            Vg();
            if (this.bGw != null) {
                this.bGw.TV();
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
        BdLog.e("BCVideoChat blmsdk " + aVar + "|imUk=" + aVar.aCG + "|order=" + aVar.order + "|status=" + this.mChatStatus);
        if (Vm()) {
            try {
                i = Integer.parseInt(aVar.order);
            } catch (NumberFormatException e) {
                i = -1;
            }
            BdLog.e("BCVideoChat blmsdk  order=" + aVar.order + " index=" + i);
            if (this.bDv != null && Build.VERSION.SDK_INT >= 14) {
                TextureView aE = this.bGv.Bi().aE(aVar.aCG);
                if (aE != null) {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival  renderView=" + aE + "|index=" + i + "|stream.imUk=" + aVar.aCG + "|renderView.surface=" + aE.getSurfaceTexture());
                } else {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival renderView==null");
                }
                this.bDv.a(aE, i, aVar.aCG, false, false);
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
                Vb();
            } else if (this.bGu != null && TextUtils.equals(aVar.order, this.bGu.index + "")) {
                BdLog.e("BCVideoChat blmsdk  currentOrder " + this.bGu.index);
                Vb();
            } else {
                BdLog.e("BCVideoChat blmsdk  other");
                if (this.bDv != null) {
                    try {
                        i2 = Integer.parseInt(aVar.order);
                    } catch (NumberFormatException e) {
                        i2 = -1;
                    }
                    this.bDv.fH(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk |roomId=" + str + "|user=" + cVar);
        if (TextUtils.equals(str, this.bGt) && cVar != null) {
            if (cVar.aCG == AccountManager.getUK(this.mContext)) {
                fK(2);
            } else if (this.bGu != null && !TextUtils.equals(cVar.order, this.bGu.index + "") && this.bDv != null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed order = " + cVar.order);
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bDv.fH(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|user=" + cVar + "|mBIMRoomId=" + this.bGt);
        if (this.bGt != null && this.bGt.equals(str) && cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aCG + " order " + cVar.order);
            if (this.bDv != null) {
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bDv.fH(i);
            }
            b(com.baidu.live.talentshow.b.c.bFY, this.bGt, null, TbadkCoreApplication.getCurrentAccount(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(String str) {
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|mBIMRoomId=" + this.bGt);
        if (TextUtils.equals(str, this.bGt)) {
            fK(1);
        }
    }

    public void UZ() {
        BdLog.e("BCVideoChat blmsdk acceptChat status=" + this.mChatStatus);
        if (Vk()) {
            fL(d.bGM);
            this.bDv.Uj();
            Vc();
            Vd();
            final JSONObject b2 = e.b(this.aGe, this.bGu.index);
            this.bGu.bGq = b2;
            this.bGv.bd(this.isMute);
            this.bGv.a(this.bGt, b2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.c.1
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
        if (Vl()) {
            if (i == 0) {
                fL(d.bGN);
                if (this.bGw != null) {
                    this.bGw.TU();
                }
                b(com.baidu.live.talentshow.b.c.bFW, this.bGt, com.baidu.live.talentshow.b.c.bGi, TbadkCoreApplication.getCurrentAccount(), jSONObject);
                return;
            }
            if (this.bGw != null) {
                this.bGw.fC(i);
            }
            Vb();
        }
    }

    public void Va() {
        BdLog.e("BCVideoChat blmsdk rejectChat mChatStatus=" + this.mChatStatus);
        if (Vk() && this.bGv != null) {
            JSONObject c = e.c(this.aGe, this.bGu.index);
            this.bGv.b(this.bGt, c, (com.baidu.live.alablmsdk.c.c) null);
            b(com.baidu.live.talentshow.b.c.bFW, this.bGt, com.baidu.live.talentshow.b.c.bGj, TbadkCoreApplication.getCurrentAccount(), c);
            resetData();
            Vg();
        }
    }

    public void Vb() {
        fK(0);
    }

    public void fK(int i) {
        BdLog.e("BCVideoChat blmsdk mChatStatus " + this.mChatStatus + "|code=" + i);
        if (Vm()) {
            JSONObject a2 = e.a(this.aGe, this.bGu.index);
            if (i != 2) {
                this.bGv.c(this.bGt, a2, (com.baidu.live.alablmsdk.c.c) null);
            }
            Ve();
            if (this.bDv != null) {
                this.bDv.Ui();
            }
            Vg();
            if (this.bGw != null) {
                this.bGw.cS(i == 0);
            }
            b(com.baidu.live.talentshow.b.c.bFX, this.bGt, null, TbadkCoreApplication.getCurrentAccount(), a2);
            resetData();
            return;
        }
        resetData();
        Vg();
    }

    private void Vc() {
        BdLog.e("BCVideoChat blmsdk addRecorderToRtcView");
        if (this.bGx != null && this.bGx.getPreview() != null && this.bDv != null && this.bGu != null) {
            this.bDv.a(this.bGx.getPreview(), this.bGu.index, 0L, true, true);
            this.bGx.startRecord();
        }
    }

    private void Vd() {
        final com.baidu.live.alablmsdk.c.a.a Cn = this.bGv.Bi().Cn();
        if (this.bGx != null) {
            this.bGx.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.talentshow.d.c.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (Cn != null) {
                        Cn.onError(i, str);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + Cn);
                    }
                }
            });
            this.bGx.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.c.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (Cn != null) {
                        Cn.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + Cn);
                    }
                }
            });
        }
    }

    private void Ve() {
        BdLog.e("BCVideoChat blmsdk switchNormalLive");
        if (this.bGx != null) {
            this.bGx.setEnableCloudRtc(false, null);
            this.bGx.setRecorderErrorCallback(null);
        }
    }

    private void b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.bGw != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = str;
            cVar.bGl = str2;
            cVar.bGm = str3;
            cVar.bGn = str4;
            cVar.bGq = jSONObject;
            this.bGw.b(cVar);
        }
    }

    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk isMute=" + z);
        this.isMute = z;
        if (this.bGv != null) {
            this.bGv.bd(z);
        }
    }

    private void resetData() {
        this.isMute = false;
        this.bGt = null;
        this.bGu = null;
    }

    public void Vf() {
        fL(d.bGK);
    }

    public void Vg() {
        fL(d.bGJ);
    }

    private void fL(int i) {
        BdLog.e("BCVideoChat blmsdk updateStatus=" + i + " oldStatus = " + this.mChatStatus);
        this.mChatStatus = i;
    }

    public int Vh() {
        return this.mChatStatus;
    }

    public boolean Vi() {
        return this.mChatStatus == d.bGJ;
    }

    public boolean Vj() {
        return this.mChatStatus == d.bGK;
    }

    public boolean Vk() {
        return this.mChatStatus == d.bGL;
    }

    public boolean Vl() {
        return this.mChatStatus == d.bGM;
    }

    public boolean Vm() {
        return this.mChatStatus == d.bGM || this.mChatStatus == d.bGN;
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk user=" + cVar.toString());
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.index = JavaTypesHelper.toInt(cVar.order, -1);
        bVar.status = d.bGJ;
        bVar.bHp = cVar.clone();
        return bVar;
    }

    private void Vn() {
        if (this.bGv != null) {
            this.bGv.a(this.bGy);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", d.bGO);
            hashMap.put("rtc_room_source_key", d.bGI);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(15);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.af.a.SE().bwi.aPu.aUB));
            hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.af.a.SE().bwi.aPu.aUA));
            hashMap.put("external_audio_capture", true);
            this.bGv.v(hashMap);
        }
    }

    public void onStarted() {
        if (this.bGv != null) {
            this.bGv.enterForeground();
        }
    }

    public void onStopped() {
        if (this.bGv != null) {
            this.bGv.enterBackground();
        }
    }

    public void onDestroy() {
        BdLog.e("BCVideoChat blmsdk onDestroy");
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bGv != null) {
            this.bGv.onRelease();
            this.bGv = null;
        }
    }
}
