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
import com.baidu.live.data.co;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
    private w aFN;
    private AlaLiveRecorder bBK;
    private com.baidu.live.alablmsdk.a bMe;
    private f bMf;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bMg = null;
    private com.baidu.live.alablmsdk.module.c bMh = null;
    private JSONObject bMi = null;
    private int mChatStatus = c.bBW;
    private String bMj = null;
    private long bMk = 0;
    private boolean isMute = false;
    private boolean bMl = true;
    private com.baidu.live.alablmsdk.c.c bMm = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.c
        public void f(final int i, final int i2, final String str) {
            BdLog.e("blmsdk:type=" + i + "|status=" + i2 + "|msg=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 2) {
                        g.this.P(i2, str);
                    } else if (i == 4) {
                        g.this.T(i2, str);
                    } else if (i == 5) {
                        g.this.U(i2, str);
                    } else if (i == 7) {
                        g.this.V(i2, str);
                    } else if (i == 8) {
                        g.this.S(i2, str);
                    } else if (i == 3) {
                        g.this.R(i2, str);
                    } else if (i == 6) {
                        g.this.Q(i2, str);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.c.b bBL = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.6
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.XG();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + aVar.aCp);
            g.this.bMl = true;
            if (g.this.bMg != null && g.this.bMg.aCp == aVar.aCp) {
                g.this.bMl = false;
            }
            if (g.this.bMh != null && g.this.bMh.aCp == aVar.aCp) {
                g.this.bMl = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bMf != null) {
                        g.this.bMf.q(i, g.this.bMl);
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
        public void fX(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.iO(str);
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
                    jSONObject2.put("blm_from", c.bLI);
                } catch (JSONException e) {
                }
                UbcStatisticManager.getInstance().logLMSdkEvent(str, jSONObject, jSONObject2);
            }
        }
    };

    @Override // com.baidu.live.videochat.d.a
    public void init(Context context) {
        BdLog.e("blmsdk：LiveBBVideoChatLogicController init context = " + context);
        if (this.bMe == null) {
            this.bMe = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
            this.bMe.a(this.bBL);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bBV);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf((int) FeatureCodes.ADVANCE_BEAUTY));
            hashMap.put("encode_min_bitrate", 1100);
            hashMap.put("external_audio_capture", true);
            this.bMe.v(hashMap);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void s(w wVar) {
        this.aFN = wVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bMf = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bBK == null) {
            this.bBK = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = 15;
            aVar.aBA = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aBF = true;
            aVar.aBE = this.bBK.getPushUrl();
            List<co.a> list = com.baidu.live.ae.a.RB().brA.aOM.dataList;
            co.a aVar2 = list.get(0) == null ? co.a.aTC.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.c cVar = new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            co.a aVar3 = list.get(1) == null ? co.a.aTC.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.c cVar2 = new com.baidu.live.alablmsdk.config.a.c(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aFN == null || this.aFN.mLiveInfo == null) ? false : this.aFN.mLiveInfo.isPubShow) {
                arrayList.add(cVar2);
                arrayList.add(cVar);
            } else {
                arrayList.add(cVar);
                arrayList.add(cVar2);
            }
            aVar.aBI = arrayList;
            aVar.aBH = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.ae.a.RB().brA.aOM.aTx, com.baidu.live.ae.a.RB().brA.aOM.aTy);
            aVar.aBC = FeatureCodes.ADVANCE_BEAUTY;
            aVar.aBG = aVar.Cl();
            com.baidu.live.alablmsdk.a.b.a.d(" mixTemplate =" + aVar.aBG);
            aVar.aBD = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bMe != null) {
                this.bMe.a(aVar);
            }
        }
    }

    private void fK(int i) {
        this.mChatStatus = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int Uc() {
        return this.mChatStatus;
    }

    private boolean XD() {
        BdLog.e("mCurInvitedUser=" + this.bMg);
        return this.bMg != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c XB() {
        return this.bMg;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bMe != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bMe.bg(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void WG() {
        if (this.bMe != null) {
            this.bMe.enterBackground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void WH() {
        if (this.bMe != null) {
            this.bMe.enterForeground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject XC() {
        return this.bMi;
    }

    private String XE() {
        StringBuilder sb = new StringBuilder();
        if (this.bMi != null) {
            b af = d.af(this.bMi);
            sb.append("sender:");
            if (af.bLG != null) {
                sb.append(af.bLG.userId);
            }
            sb.append(",");
            sb.append("receiver:");
            if (af.bLH != null) {
                sb.append(af.bLH.userId);
            }
            if (this.bMg != null) {
                sb.append(",");
                sb.append("imuk:");
                sb.append(this.bMg.aCp);
                sb.append(",");
                sb.append("cuid:");
                sb.append(this.bMg.cuid);
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
        if (this.mChatStatus == c.bBW) {
            fK(c.bLK);
            this.bMk = System.currentTimeMillis();
            XF();
            this.bMg = cVar;
            this.bMi = jSONObject;
            this.bMe.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
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
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bMk) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.mChatStatus + "|ext=" + jSONObject);
        this.bMk = System.currentTimeMillis();
        if (this.mChatStatus == c.bLK) {
            if (i == 0) {
                this.bMj = str;
                a(str, jSONObject, cVar);
                return;
            }
            if (this.bMf != null) {
                this.bMf.a(c.bCc, true, i, str2, str, XE());
            }
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bCc, true);
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + jSONObject);
        if (this.mChatStatus == c.bLK) {
            cVar.order = "1";
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bMe.a(str, arrayList, jSONObject, this.bMm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bMk) + "|mChatStatus=" + this.mChatStatus + "|msg=" + str);
        this.bMk = System.currentTimeMillis();
        if (this.mChatStatus == c.bLK) {
            if (i == 0) {
                fK(c.bLL);
                if (this.bMf != null) {
                    this.bMf.WV();
                    return;
                }
                return;
            }
            this.bMe.d(this.bMj, d.aV("invite_fail", this.bMj), this.bMm);
            if (this.bMf != null) {
                this.bMf.a(c.bCd, true, i, str, this.bMj, XE());
            }
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bCd, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (XD() && this.mChatStatus == c.bLL) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bMg);
            this.bMe.b(this.bMj, arrayList, null, this.bMm);
            this.bMe.d(this.bMj, d.aV("invite_time_out", str), this.bMm);
            if (this.bMf != null) {
                this.bMf.a(c.bCh, true, c.bCh, "inviteTimeOut", str, XE());
            }
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bCh, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bMj + "|isChatSender()=" + XD() + "|costTime=" + (System.currentTimeMillis() - this.bMk));
        this.bMk = System.currentTimeMillis();
        if (this.mChatStatus == c.bLL && this.bMj != null && this.bMj.equals(str) && cVar != null && this.bMg != null) {
            BdLog.e("blmsdk:user uk=" + cVar.aCp + "|invite user uk" + this.bMg.aCp);
            if (cVar.aCp == this.bMg.aCp) {
                fK(c.bBZ);
                Te();
                iQ(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bMg);
            this.bMe.b(this.bMj, arrayList, null, this.bMm);
            this.bMe.d(this.bMj, d.aV("user_data_error", str), this.bMm);
            if (this.bMf != null) {
                this.bMf.a(c.bCe, true, c.bCe, "inviteAcceptDataError", str, XE());
            }
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bCe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + XD() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bMk) + "ext=" + jSONObject);
        this.bMk = System.currentTimeMillis();
        if (XD() && this.mChatStatus == c.bLL) {
            this.bMe.d(str, d.aV("invite_reject", str), this.bMm);
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bCi, true);
            }
        }
    }

    private void iQ(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|costTime=" + (System.currentTimeMillis() - this.bMk));
        this.bMk = System.currentTimeMillis();
        if (this.mChatStatus == c.bBZ) {
            this.bMe.a(str, this.bMm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bMk) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.mChatStatus);
        this.bMk = System.currentTimeMillis();
        if (this.mChatStatus == c.bBZ) {
            if (i == 0) {
                fK(c.bCa);
                if (this.bMf != null) {
                    this.bMf.C(this.bMj, XD());
                    return;
                }
                return;
            }
            this.bMe.d(this.bMj, d.aV("join_fail", this.bMj), this.bMm);
            Td();
            if (this.bMf != null) {
                this.bMf.a(c.bCf, true, i, str, this.bMj, XE());
            }
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bCf, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, String str) {
    }

    private void dt(boolean z) {
        if (this.mChatStatus == c.bLK) {
            if (this.bMj != null) {
                this.bMe.d(this.bMj, d.aV("closed_by_user_in_create", this.bMj), this.bMm);
            }
            fK(c.bBW);
            XF();
            if (z) {
                if (this.bMf != null) {
                    this.bMf.p(c.bLO, true);
                }
            } else if (this.bMf != null) {
                this.bMf.p(c.bLP, true);
            }
        } else if (this.mChatStatus == c.bLL) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bMg);
            this.bMe.b(this.bMj, arrayList, null, this.bMm);
            this.bMe.d(this.bMj, d.aV(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bMj), this.bMm);
            fK(c.bBW);
            XF();
            if (z) {
                if (this.bMf != null) {
                    this.bMf.p(c.bLO, true);
                }
            } else if (this.bMf != null) {
                this.bMf.p(c.bLP, true);
            }
        } else if (this.mChatStatus == c.bBZ) {
            this.bMe.d(this.bMj, d.aV("closed_by_user_in_connecting", this.bMj), this.bMm);
            Td();
            fK(c.bBW);
            XF();
            if (z) {
                if (this.bMf != null) {
                    this.bMf.p(c.bLO, true);
                }
            } else if (this.bMf != null) {
                this.bMf.p(c.bLP, true);
            }
        } else if (this.mChatStatus == c.bCa) {
            this.bMe.d(this.bMj, d.aV("closed_by_user", this.bMj), this.bMm);
            Td();
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.D(this.bMj, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|currentRoomId=" + this.bMj + "|ext=" + jSONObject);
        if (this.mChatStatus == c.bBW) {
            this.bMj = str;
            this.bMh = cVar;
            this.bMi = d.a(d.ad(jSONObject), this.aFN, d.bMb);
            fK(c.bLJ);
            if (this.bMf != null) {
                this.bMf.a(cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void XA() {
        fK(c.bBW);
        XF();
    }

    @Override // com.baidu.live.videochat.d.a
    public void ab(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bLJ) {
            fK(c.bBZ);
            Te();
            this.bMe.a(this.bMj, jSONObject, this.bMm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|msg=" + str);
        if (this.mChatStatus == c.bBZ) {
            if (i == 0) {
                fK(c.bCa);
                if (this.bMf != null) {
                    this.bMf.C(this.bMj, XD());
                    return;
                }
                return;
            }
            Td();
            if (this.bMf != null) {
                this.bMf.a(c.bCg, false, i, str, this.bMj, XE());
            }
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bCg, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bLJ) {
            boolean XD = XD();
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.p(c.bLM, XD);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void ac(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bLJ) {
            this.bMe.b(this.bMj, jSONObject, this.bMm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        fK(c.bBW);
        XF();
        if (this.bMf != null) {
            this.bMf.p(c.bLP, false);
        }
    }

    private void du(boolean z) {
        if (this.mChatStatus == c.bBZ) {
            this.bMe.c(this.bMj, d.aV(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bMj), this.bMm);
            Td();
            fK(c.bBW);
            XF();
            if (z) {
                if (this.bMf != null) {
                    this.bMf.p(c.bLO, false);
                }
            } else if (this.bMf != null) {
                this.bMf.p(c.bLP, false);
            }
        } else if (this.mChatStatus == c.bCa) {
            this.bMe.c(this.bMj, d.aV("leave_by_user", this.bMj), this.bMm);
            Td();
            fK(c.bBW);
            XF();
            if (this.bMf != null) {
                this.bMf.D(this.bMj, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.mChatStatus + "isChatSender =" + XD());
        if (XD()) {
            if (this.mChatStatus == c.bCa) {
                this.bMe.d(str, d.aV("user_leave", str), this.bMm);
                Td();
                fK(c.bBW);
                XF();
                if (this.bMf != null) {
                    this.bMf.D(str, false);
                }
            } else if (this.mChatStatus == c.bBZ) {
                this.bMe.d(str, d.aV("user_leave_in_connecting", str), this.bMm);
                Td();
                fK(c.bBW);
                XF();
                if (this.bMf != null) {
                    this.bMf.p(c.bLN, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.mChatStatus + "|chatRoomId=" + str);
        if (!XD()) {
            if (this.mChatStatus == c.bCa) {
                this.bMe.c(this.bMj, d.aV("room_closed", this.bMj), this.bMm);
                Td();
                fK(c.bBW);
                XF();
                if (this.bMf != null) {
                    this.bMf.D(this.bMj, false);
                }
            } else if (this.mChatStatus == c.bBZ) {
                Td();
                fK(c.bBW);
                XF();
                if (this.bMf != null) {
                    this.bMf.p(c.bLN, true);
                }
            }
        }
    }

    private void XF() {
        this.bMg = null;
        this.bMh = null;
        this.bMj = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void ds(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + XD());
        if (XD()) {
            dt(z);
        } else {
            du(z);
        }
    }

    private void Te() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|mAuthorLiveRecorder=" + this.bBK);
        final com.baidu.live.alablmsdk.c.a.a CW = this.bMe.BR().CW();
        if (this.bBK != null) {
            this.bBK.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (CW != null) {
                        CW.onError(i, str);
                    }
                }
            });
            this.bBK.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (CW == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|capturer=" + CW);
                    } else {
                        CW.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XG() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.bMe != null) {
            com.baidu.live.alablmsdk.a.b.a.d("StreamArrive" + this.isMute);
            this.bMe.bg(this.isMute);
        }
        if (this.bMf != null) {
            this.bMf.WW();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View getPlayerView() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        return XD() ? this.bMe.BR().c(this.bMg) : this.bMe.BR().c(this.bMh);
    }

    private void Td() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.bBK.setDefaultCloudRtcMode(null);
                g.this.bBK.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.bBK = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bMe != null) {
            this.bMe.onRelease();
            this.bMe = null;
        }
    }
}
