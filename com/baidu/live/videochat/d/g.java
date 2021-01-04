package com.baidu.live.videochat.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderErrorCallback;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.cq;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g implements a {
    private x aGe;
    private AlaLiveRecorder bGx;
    private com.baidu.live.alablmsdk.a bQR;
    private f bQS;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bQT = null;
    private com.baidu.live.alablmsdk.module.c bQU = null;
    private JSONObject bQV = null;
    private int mChatStatus = c.bGJ;
    private String bQW = null;
    private long bQX = 0;
    private boolean isMute = false;
    private boolean bQY = true;
    private com.baidu.live.alablmsdk.c.c bQZ = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.c
        public void f(final int i, final int i2, final String str) {
            BdLog.e("blmsdk:type=" + i + "|status=" + i2 + "|msg=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 2) {
                        g.this.R(i2, str);
                    } else if (i == 4) {
                        g.this.V(i2, str);
                    } else if (i == 5) {
                        g.this.W(i2, str);
                    } else if (i == 7) {
                        g.this.X(i2, str);
                    } else if (i == 8) {
                        g.this.U(i2, str);
                    } else if (i == 3) {
                        g.this.T(i2, str);
                    } else if (i == 6) {
                        g.this.S(i2, str);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.c.b bGy = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.6
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.YN();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + aVar.aCG);
            g.this.bQY = true;
            if (g.this.bQT != null && g.this.bQT.aCG == aVar.aCG) {
                g.this.bQY = false;
            }
            if (g.this.bQU != null && g.this.bQU.aCG == aVar.aCG) {
                g.this.bQY = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bQS != null) {
                        g.this.bQS.q(i, g.this.bQY);
                    }
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|mMainHandler=" + g.this.mMainHandler + "|ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.l(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|mMainHandler=" + g.this.mMainHandler);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.iD(str);
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
                    jSONObject2.put("blm_from", c.bQv);
                } catch (JSONException e) {
                }
                UbcStatisticManager.getInstance().logLMSdkEvent(str, jSONObject, jSONObject2);
            }
        }
    };

    @Override // com.baidu.live.videochat.d.a
    public void init(Context context) {
        BdLog.e("blmsdk：LiveBBVideoChatLogicController init context = " + context);
        if (this.bQR == null) {
            this.bQR = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
            this.bQR.a(this.bGy);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bGI);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf((int) FeatureCodes.ADVANCE_BEAUTY));
            hashMap.put("encode_min_bitrate", 1100);
            hashMap.put("external_audio_capture", true);
            this.bQR.v(hashMap);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void t(x xVar) {
        this.aGe = xVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bQS = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bGx == null) {
            this.bGx = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = 15;
            aVar.aBR = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aBW = true;
            aVar.aBV = this.bGx.getPushUrl();
            List<cq.a> list = com.baidu.live.af.a.SE().bwi.aPt.dataList;
            cq.a aVar2 = list.get(0) == null ? cq.a.aUz.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.c cVar = new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            cq.a aVar3 = list.get(1) == null ? cq.a.aUz.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.c cVar2 = new com.baidu.live.alablmsdk.config.a.c(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aGe == null || this.aGe.mLiveInfo == null) ? false : this.aGe.mLiveInfo.isPubShow) {
                arrayList.add(cVar2);
                arrayList.add(cVar);
            } else {
                arrayList.add(cVar);
                arrayList.add(cVar2);
            }
            aVar.aBZ = arrayList;
            aVar.aBY = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.af.a.SE().bwi.aPt.aUv, com.baidu.live.af.a.SE().bwi.aPt.aUw);
            aVar.aBT = FeatureCodes.ADVANCE_BEAUTY;
            aVar.aBX = aVar.BC();
            com.baidu.live.alablmsdk.a.b.a.d(" mixTemplate =" + aVar.aBX);
            aVar.aBU = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bQR != null) {
                this.bQR.a(aVar);
            }
        }
    }

    private void fL(int i) {
        this.mChatStatus = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int Vh() {
        return this.mChatStatus;
    }

    private boolean YK() {
        BdLog.e("mCurInvitedUser=" + this.bQT);
        return this.bQT != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c YH() {
        return this.bQT;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bQR != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bQR.bd(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void XK() {
        if (this.bQR != null) {
            this.bQR.enterBackground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void XL() {
        if (this.bQR != null) {
            this.bQR.enterForeground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject YI() {
        return this.bQV;
    }

    private String YL() {
        StringBuilder sb = new StringBuilder();
        if (this.bQV != null) {
            b an = d.an(this.bQV);
            sb.append("sender:");
            if (an.bQt != null) {
                sb.append(an.bQt.userId);
            }
            sb.append(",");
            sb.append("receiver:");
            if (an.bQu != null) {
                sb.append(an.bQu.userId);
            }
            if (this.bQT != null) {
                sb.append(",");
                sb.append("imuk:");
                sb.append(this.bQT.aCG);
                sb.append(",");
                sb.append("cuid:");
                sb.append(this.bQT.cuid);
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.live.videochat.d.a
    public boolean b(final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
        if (cVar == null) {
            BdLog.e("blmsdk:user is null");
            return false;
        }
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|ext=" + jSONObject + "|user=" + cVar.toString());
        if (this.mChatStatus == c.bGJ) {
            fL(c.bQx);
            this.bQX = System.currentTimeMillis();
            YM();
            this.bQT = cVar;
            this.bQV = jSONObject;
            this.bQR.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
                @Override // com.baidu.live.alablmsdk.c.a
                public void c(final String str, final int i, final String str2) {
                    g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a(str, i, str2, jSONObject, cVar);
                        }
                    });
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bQX) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.mChatStatus + "|ext=" + jSONObject);
        this.bQX = System.currentTimeMillis();
        if (this.mChatStatus == c.bQx) {
            if (i == 0) {
                this.bQW = str;
                a(str, jSONObject, cVar);
                return;
            }
            if (this.bQS != null) {
                this.bQS.a(c.bGP, true, i, str2, str, YL());
            }
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.p(c.bGP, true);
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + jSONObject);
        if (this.mChatStatus == c.bQx) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bQR.a(str, arrayList, jSONObject, this.bQZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bQX) + "|mChatStatus=" + this.mChatStatus + "|msg=" + str);
        this.bQX = System.currentTimeMillis();
        if (this.mChatStatus == c.bQx) {
            if (i == 0) {
                fL(c.bQy);
                if (this.bQS != null) {
                    this.bQS.Yb();
                    return;
                }
                return;
            }
            this.bQR.d(this.bQW, d.aQ("invite_fail", this.bQW), this.bQZ);
            if (this.bQS != null) {
                this.bQS.a(c.bGQ, true, i, str, this.bQW, YL());
            }
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.p(c.bGQ, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (YK() && this.mChatStatus == c.bQy) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bQT);
            this.bQR.b(this.bQW, arrayList, null, this.bQZ);
            this.bQR.d(this.bQW, d.aQ("invite_time_out", str), this.bQZ);
            if (this.bQS != null) {
                this.bQS.a(c.bGU, true, c.bGU, "inviteTimeOut", str, YL());
            }
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.p(c.bGU, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bQW + "|isChatSender()=" + YK() + "|costTime=" + (System.currentTimeMillis() - this.bQX));
        this.bQX = System.currentTimeMillis();
        if (this.mChatStatus == c.bQy && this.bQW != null && this.bQW.equals(str) && cVar != null && this.bQT != null) {
            BdLog.e("blmsdk:user uk=" + cVar.aCG + "|invite user uk" + this.bQT.aCG);
            if (cVar.aCG == this.bQT.aCG) {
                fL(c.bGM);
                Uj();
                iF(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bQT);
            this.bQR.b(this.bQW, arrayList, null, this.bQZ);
            this.bQR.d(this.bQW, d.aQ("user_data_error", str), this.bQZ);
            if (this.bQS != null) {
                this.bQS.a(c.bGR, true, c.bGR, "inviteAcceptDataError", str, YL());
            }
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.p(c.bGR, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + YK() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bQX) + "ext=" + jSONObject);
        this.bQX = System.currentTimeMillis();
        if (YK() && this.mChatStatus == c.bQy) {
            this.bQR.d(str, d.aQ("invite_reject", str), this.bQZ);
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.p(c.bGV, true);
            }
        }
    }

    private void iF(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|costTime=" + (System.currentTimeMillis() - this.bQX));
        this.bQX = System.currentTimeMillis();
        if (this.mChatStatus == c.bGM) {
            this.bQR.a(str, this.bQZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bQX) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.mChatStatus);
        this.bQX = System.currentTimeMillis();
        if (this.mChatStatus == c.bGM) {
            if (i == 0) {
                fL(c.bGN);
                if (this.bQS != null) {
                    this.bQS.C(this.bQW, YK());
                    return;
                }
                return;
            }
            this.bQR.d(this.bQW, d.aQ("join_fail", this.bQW), this.bQZ);
            Ui();
            if (this.bQS != null) {
                this.bQS.a(c.bGS, true, i, str, this.bQW, YL());
            }
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.p(c.bGS, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
    }

    private void dw(boolean z) {
        if (this.mChatStatus == c.bQx) {
            if (this.bQW != null) {
                this.bQR.d(this.bQW, d.aQ("closed_by_user_in_create", this.bQW), this.bQZ);
            }
            fL(c.bGJ);
            YM();
            if (z) {
                if (this.bQS != null) {
                    this.bQS.p(c.bQB, true);
                }
            } else if (this.bQS != null) {
                this.bQS.p(c.bQC, true);
            }
        } else if (this.mChatStatus == c.bQy) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bQT);
            this.bQR.b(this.bQW, arrayList, null, this.bQZ);
            this.bQR.d(this.bQW, d.aQ(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bQW), this.bQZ);
            fL(c.bGJ);
            YM();
            if (z) {
                if (this.bQS != null) {
                    this.bQS.p(c.bQB, true);
                }
            } else if (this.bQS != null) {
                this.bQS.p(c.bQC, true);
            }
        } else if (this.mChatStatus == c.bGM) {
            this.bQR.d(this.bQW, d.aQ("closed_by_user_in_connecting", this.bQW), this.bQZ);
            Ui();
            fL(c.bGJ);
            YM();
            if (z) {
                if (this.bQS != null) {
                    this.bQS.p(c.bQB, true);
                }
            } else if (this.bQS != null) {
                this.bQS.p(c.bQC, true);
            }
        } else if (this.mChatStatus == c.bGN) {
            this.bQR.d(this.bQW, d.aQ("closed_by_user", this.bQW), this.bQZ);
            Ui();
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.D(this.bQW, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|currentRoomId=" + this.bQW + "|ext=" + jSONObject);
        if (this.mChatStatus == c.bGJ) {
            this.bQW = str;
            this.bQU = cVar;
            this.bQV = d.a(d.al(jSONObject), this.aGe, d.bQO);
            fL(c.bQw);
            if (this.bQS != null) {
                this.bQS.a(cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void YG() {
        fL(c.bGJ);
        YM();
    }

    @Override // com.baidu.live.videochat.d.a
    public void aj(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bQw) {
            fL(c.bGM);
            Uj();
            this.bQR.a(this.bQW, jSONObject, this.bQZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|msg=" + str);
        if (this.mChatStatus == c.bGM) {
            if (i == 0) {
                fL(c.bGN);
                if (this.bQS != null) {
                    this.bQS.C(this.bQW, YK());
                    return;
                }
                return;
            }
            Ui();
            if (this.bQS != null) {
                this.bQS.a(c.bGT, false, i, str, this.bQW, YL());
            }
            if (this.bQS != null) {
                this.bQS.p(c.bGT, false);
            }
            fL(c.bGJ);
            YM();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public String YJ() {
        return this.bQW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        boolean YK = YK();
        if (this.mChatStatus == c.bQw) {
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.p(c.bQz, YK);
            }
        } else if (this.mChatStatus == c.bGM) {
            Ui();
            if (this.bQS != null) {
                this.bQS.D(str, YK);
            }
            fL(c.bGJ);
            YM();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void ak(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bQw) {
            this.bQR.b(this.bQW, jSONObject, this.bQZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, String str) {
        fL(c.bGJ);
        YM();
        if (this.bQS != null) {
            this.bQS.p(c.bQC, false);
        }
    }

    private void dx(boolean z) {
        if (this.mChatStatus == c.bGM) {
            this.bQR.c(this.bQW, d.aQ(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bQW), this.bQZ);
            Ui();
            fL(c.bGJ);
            YM();
            if (z) {
                if (this.bQS != null) {
                    this.bQS.p(c.bQB, false);
                }
            } else if (this.bQS != null) {
                this.bQS.p(c.bQC, false);
            }
        } else if (this.mChatStatus == c.bGN) {
            this.bQR.c(this.bQW, d.aQ("leave_by_user", this.bQW), this.bQZ);
            Ui();
            fL(c.bGJ);
            YM();
            if (this.bQS != null) {
                this.bQS.D(this.bQW, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.mChatStatus + "isChatSender =" + YK());
        if (YK()) {
            if (this.mChatStatus == c.bGN) {
                this.bQR.d(str, d.aQ("user_leave", str), this.bQZ);
                Ui();
                fL(c.bGJ);
                YM();
                if (this.bQS != null) {
                    this.bQS.D(str, false);
                }
            } else if (this.mChatStatus == c.bGM) {
                this.bQR.d(str, d.aQ("user_leave_in_connecting", str), this.bQZ);
                Ui();
                fL(c.bGJ);
                YM();
                if (this.bQS != null) {
                    this.bQS.p(c.bQA, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.mChatStatus + "|chatRoomId=" + str);
        if (!YK()) {
            if (this.mChatStatus == c.bGN) {
                this.bQR.c(this.bQW, d.aQ("room_closed", this.bQW), this.bQZ);
                Ui();
                fL(c.bGJ);
                YM();
                if (this.bQS != null) {
                    this.bQS.D(this.bQW, false);
                }
            } else if (this.mChatStatus == c.bGM) {
                Ui();
                fL(c.bGJ);
                YM();
                if (this.bQS != null) {
                    this.bQS.p(c.bQA, true);
                }
            }
        }
    }

    private void YM() {
        this.bQT = null;
        this.bQU = null;
        this.bQW = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void dv(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + YK());
        if (YK()) {
            dw(z);
        } else {
            dx(z);
        }
    }

    private void Uj() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|mAuthorLiveRecorder=" + this.bGx);
        final com.baidu.live.alablmsdk.c.a.a Cn = this.bQR.Bi().Cn();
        if (this.bGx != null) {
            this.bGx.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (Cn != null) {
                        Cn.onError(i, str);
                    }
                }
            });
            this.bGx.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (Cn == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|capturer=" + Cn);
                    } else {
                        Cn.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YN() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.bQR != null) {
            com.baidu.live.alablmsdk.a.b.a.d("StreamArrive" + this.isMute);
            this.bQR.bd(this.isMute);
        }
        if (this.bQS != null) {
            this.bQS.Yc();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View Pp() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        return YK() ? this.bQR.Bi().c(this.bQT) : this.bQR.Bi().c(this.bQU);
    }

    private void Ui() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.bGx.setEnableCloudRtc(false, null);
                g.this.bGx.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.bGx = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bQR != null) {
            this.bQR.onRelease();
            this.bQR = null;
        }
    }
}
