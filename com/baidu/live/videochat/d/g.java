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
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g implements a {
    private x aBr;
    private AlaLiveRecorder bBL;
    private com.baidu.live.alablmsdk.a bMf;
    private f bMg;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bMh = null;
    private com.baidu.live.alablmsdk.module.c bMi = null;
    private JSONObject bMj = null;
    private int mChatStatus = c.bBX;
    private String bMk = null;
    private long bMl = 0;
    private boolean isMute = false;
    private boolean bMm = true;
    private com.baidu.live.alablmsdk.c.c bMn = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.c
        public void f(final int i, final int i2, final String str) {
            BdLog.e("blmsdk:type=" + i + "|status=" + i2 + "|msg=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 2) {
                        g.this.S(i2, str);
                    } else if (i == 4) {
                        g.this.W(i2, str);
                    } else if (i == 5) {
                        g.this.X(i2, str);
                    } else if (i == 7) {
                        g.this.Y(i2, str);
                    } else if (i == 8) {
                        g.this.V(i2, str);
                    } else if (i == 3) {
                        g.this.U(i2, str);
                    } else if (i == 6) {
                        g.this.T(i2, str);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.c.b bBM = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.6
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.UV();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + aVar.axT);
            g.this.bMm = true;
            if (g.this.bMh != null && g.this.bMh.axT == aVar.axT) {
                g.this.bMm = false;
            }
            if (g.this.bMi != null && g.this.bMi.axT == aVar.axT) {
                g.this.bMm = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bMg != null) {
                        g.this.bMg.q(i, g.this.bMm);
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
        public void ev(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.hs(str);
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
                    jSONObject2.put("blm_from", c.bLJ);
                } catch (JSONException e) {
                }
                UbcStatisticManager.getInstance().logLMSdkEvent(str, jSONObject, jSONObject2);
            }
        }
    };

    @Override // com.baidu.live.videochat.d.a
    public void init(Context context) {
        BdLog.e("blmsdk：LiveBBVideoChatLogicController init context = " + context);
        if (this.bMf == null) {
            this.bMf = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
            this.bMf.a(this.bBM);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bBW);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf((int) FeatureCodes.ADVANCE_BEAUTY));
            hashMap.put("encode_min_bitrate", 1100);
            hashMap.put("external_audio_capture", true);
            this.bMf.v(hashMap);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void t(x xVar) {
        this.aBr = xVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bMg = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bBL == null) {
            this.bBL = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = 15;
            aVar.axe = new com.baidu.live.alablmsdk.config.a.b(540, TbConfig.HEAD_IMG_SIZE);
            aVar.axj = true;
            aVar.axi = this.bBL.getPushUrl();
            List<cq.a> list = com.baidu.live.af.a.OJ().bru.aKG.dataList;
            cq.a aVar2 = list.get(0) == null ? cq.a.aPM.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.c cVar = new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            cq.a aVar3 = list.get(1) == null ? cq.a.aPM.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.c cVar2 = new com.baidu.live.alablmsdk.config.a.c(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aBr == null || this.aBr.mLiveInfo == null) ? false : this.aBr.mLiveInfo.isPubShow) {
                arrayList.add(cVar2);
                arrayList.add(cVar);
            } else {
                arrayList.add(cVar);
                arrayList.add(cVar2);
            }
            aVar.axm = arrayList;
            aVar.axl = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.af.a.OJ().bru.aKG.aPI, com.baidu.live.af.a.OJ().bru.aKG.aPJ);
            aVar.axg = FeatureCodes.ADVANCE_BEAUTY;
            aVar.axk = aVar.xH();
            com.baidu.live.alablmsdk.a.b.a.d(" mixTemplate =" + aVar.axk);
            aVar.axh = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bMf != null) {
                this.bMf.a(aVar);
            }
        }
    }

    private void ef(int i) {
        this.mChatStatus = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int Ro() {
        return this.mChatStatus;
    }

    private boolean US() {
        BdLog.e("mCurInvitedUser=" + this.bMh);
        return this.bMh != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c UP() {
        return this.bMh;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bMf != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bMf.aZ(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void TS() {
        if (this.bMf != null) {
            this.bMf.enterBackground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void TT() {
        if (this.bMf != null) {
            this.bMf.enterForeground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject UQ() {
        return this.bMj;
    }

    private String UT() {
        StringBuilder sb = new StringBuilder();
        if (this.bMj != null) {
            b an = d.an(this.bMj);
            sb.append("sender:");
            if (an.bLH != null) {
                sb.append(an.bLH.userId);
            }
            sb.append(",");
            sb.append("receiver:");
            if (an.bLI != null) {
                sb.append(an.bLI.userId);
            }
            if (this.bMh != null) {
                sb.append(",");
                sb.append("imuk:");
                sb.append(this.bMh.axT);
                sb.append(",");
                sb.append("cuid:");
                sb.append(this.bMh.cuid);
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
        if (this.mChatStatus == c.bBX) {
            ef(c.bLL);
            this.bMl = System.currentTimeMillis();
            UU();
            this.bMh = cVar;
            this.bMj = jSONObject;
            this.bMf.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
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
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bMl) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.mChatStatus + "|ext=" + jSONObject);
        this.bMl = System.currentTimeMillis();
        if (this.mChatStatus == c.bLL) {
            if (i == 0) {
                this.bMk = str;
                a(str, jSONObject, cVar);
                return;
            }
            if (this.bMg != null) {
                this.bMg.a(c.bCd, true, i, str2, str, UT());
            }
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.p(c.bCd, true);
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + jSONObject);
        if (this.mChatStatus == c.bLL) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bMf.a(str, arrayList, jSONObject, this.bMn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bMl) + "|mChatStatus=" + this.mChatStatus + "|msg=" + str);
        this.bMl = System.currentTimeMillis();
        if (this.mChatStatus == c.bLL) {
            if (i == 0) {
                ef(c.bLM);
                if (this.bMg != null) {
                    this.bMg.Uj();
                    return;
                }
                return;
            }
            this.bMf.d(this.bMk, d.aP("invite_fail", this.bMk), this.bMn);
            if (this.bMg != null) {
                this.bMg.a(c.bCe, true, i, str, this.bMk, UT());
            }
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.p(c.bCe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (US() && this.mChatStatus == c.bLM) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bMh);
            this.bMf.b(this.bMk, arrayList, null, this.bMn);
            this.bMf.d(this.bMk, d.aP("invite_time_out", str), this.bMn);
            if (this.bMg != null) {
                this.bMg.a(c.bCi, true, c.bCi, "inviteTimeOut", str, UT());
            }
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.p(c.bCi, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bMk + "|isChatSender()=" + US() + "|costTime=" + (System.currentTimeMillis() - this.bMl));
        this.bMl = System.currentTimeMillis();
        if (this.mChatStatus == c.bLM && this.bMk != null && this.bMk.equals(str) && cVar != null && this.bMh != null) {
            BdLog.e("blmsdk:user uk=" + cVar.axT + "|invite user uk" + this.bMh.axT);
            if (cVar.axT == this.bMh.axT) {
                ef(c.bCa);
                Qo();
                hu(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bMh);
            this.bMf.b(this.bMk, arrayList, null, this.bMn);
            this.bMf.d(this.bMk, d.aP("user_data_error", str), this.bMn);
            if (this.bMg != null) {
                this.bMg.a(c.bCf, true, c.bCf, "inviteAcceptDataError", str, UT());
            }
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.p(c.bCf, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + US() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bMl) + "ext=" + jSONObject);
        this.bMl = System.currentTimeMillis();
        if (US() && this.mChatStatus == c.bLM) {
            this.bMf.d(str, d.aP("invite_reject", str), this.bMn);
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.p(c.bCj, true);
            }
        }
    }

    private void hu(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|costTime=" + (System.currentTimeMillis() - this.bMl));
        this.bMl = System.currentTimeMillis();
        if (this.mChatStatus == c.bCa) {
            this.bMf.a(str, this.bMn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bMl) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.mChatStatus);
        this.bMl = System.currentTimeMillis();
        if (this.mChatStatus == c.bCa) {
            if (i == 0) {
                ef(c.bCb);
                if (this.bMg != null) {
                    this.bMg.C(this.bMk, US());
                    return;
                }
                return;
            }
            this.bMf.d(this.bMk, d.aP("join_fail", this.bMk), this.bMn);
            Qn();
            if (this.bMg != null) {
                this.bMg.a(c.bCg, true, i, str, this.bMk, UT());
            }
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.p(c.bCg, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
    }

    private void ds(boolean z) {
        if (this.mChatStatus == c.bLL) {
            if (this.bMk != null) {
                this.bMf.d(this.bMk, d.aP("closed_by_user_in_create", this.bMk), this.bMn);
            }
            ef(c.bBX);
            UU();
            if (z) {
                if (this.bMg != null) {
                    this.bMg.p(c.bLP, true);
                }
            } else if (this.bMg != null) {
                this.bMg.p(c.bLQ, true);
            }
        } else if (this.mChatStatus == c.bLM) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bMh);
            this.bMf.b(this.bMk, arrayList, null, this.bMn);
            this.bMf.d(this.bMk, d.aP(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bMk), this.bMn);
            ef(c.bBX);
            UU();
            if (z) {
                if (this.bMg != null) {
                    this.bMg.p(c.bLP, true);
                }
            } else if (this.bMg != null) {
                this.bMg.p(c.bLQ, true);
            }
        } else if (this.mChatStatus == c.bCa) {
            this.bMf.d(this.bMk, d.aP("closed_by_user_in_connecting", this.bMk), this.bMn);
            Qn();
            ef(c.bBX);
            UU();
            if (z) {
                if (this.bMg != null) {
                    this.bMg.p(c.bLP, true);
                }
            } else if (this.bMg != null) {
                this.bMg.p(c.bLQ, true);
            }
        } else if (this.mChatStatus == c.bCb) {
            this.bMf.d(this.bMk, d.aP("closed_by_user", this.bMk), this.bMn);
            Qn();
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.D(this.bMk, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|currentRoomId=" + this.bMk + "|ext=" + jSONObject);
        if (this.mChatStatus == c.bBX) {
            this.bMk = str;
            this.bMi = cVar;
            this.bMj = d.a(d.al(jSONObject), this.aBr, d.bMc);
            ef(c.bLK);
            if (this.bMg != null) {
                this.bMg.a(cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void UO() {
        ef(c.bBX);
        UU();
    }

    @Override // com.baidu.live.videochat.d.a
    public void aj(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bLK) {
            ef(c.bCa);
            Qo();
            this.bMf.a(this.bMk, jSONObject, this.bMn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|msg=" + str);
        if (this.mChatStatus == c.bCa) {
            if (i == 0) {
                ef(c.bCb);
                if (this.bMg != null) {
                    this.bMg.C(this.bMk, US());
                    return;
                }
                return;
            }
            Qn();
            if (this.bMg != null) {
                this.bMg.a(c.bCh, false, i, str, this.bMk, UT());
            }
            if (this.bMg != null) {
                this.bMg.p(c.bCh, false);
            }
            ef(c.bBX);
            UU();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public String UR() {
        return this.bMk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        boolean US = US();
        if (this.mChatStatus == c.bLK) {
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.p(c.bLN, US);
            }
        } else if (this.mChatStatus == c.bCa) {
            Qn();
            if (this.bMg != null) {
                this.bMg.D(str, US);
            }
            ef(c.bBX);
            UU();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void ak(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bLK) {
            this.bMf.b(this.bMk, jSONObject, this.bMn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        ef(c.bBX);
        UU();
        if (this.bMg != null) {
            this.bMg.p(c.bLQ, false);
        }
    }

    private void dt(boolean z) {
        if (this.mChatStatus == c.bCa) {
            this.bMf.c(this.bMk, d.aP(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bMk), this.bMn);
            Qn();
            ef(c.bBX);
            UU();
            if (z) {
                if (this.bMg != null) {
                    this.bMg.p(c.bLP, false);
                }
            } else if (this.bMg != null) {
                this.bMg.p(c.bLQ, false);
            }
        } else if (this.mChatStatus == c.bCb) {
            this.bMf.c(this.bMk, d.aP("leave_by_user", this.bMk), this.bMn);
            Qn();
            ef(c.bBX);
            UU();
            if (this.bMg != null) {
                this.bMg.D(this.bMk, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.mChatStatus + "isChatSender =" + US());
        if (US()) {
            if (this.mChatStatus == c.bCb) {
                this.bMf.d(str, d.aP("user_leave", str), this.bMn);
                Qn();
                ef(c.bBX);
                UU();
                if (this.bMg != null) {
                    this.bMg.D(str, false);
                }
            } else if (this.mChatStatus == c.bCa) {
                this.bMf.d(str, d.aP("user_leave_in_connecting", str), this.bMn);
                Qn();
                ef(c.bBX);
                UU();
                if (this.bMg != null) {
                    this.bMg.p(c.bLO, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.mChatStatus + "|chatRoomId=" + str);
        if (!US()) {
            if (this.mChatStatus == c.bCb) {
                this.bMf.c(this.bMk, d.aP("room_closed", this.bMk), this.bMn);
                Qn();
                ef(c.bBX);
                UU();
                if (this.bMg != null) {
                    this.bMg.D(this.bMk, false);
                }
            } else if (this.mChatStatus == c.bCa) {
                Qn();
                ef(c.bBX);
                UU();
                if (this.bMg != null) {
                    this.bMg.p(c.bLO, true);
                }
            }
        }
    }

    private void UU() {
        this.bMh = null;
        this.bMi = null;
        this.bMk = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void dr(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + US());
        if (US()) {
            ds(z);
        } else {
            dt(z);
        }
    }

    private void Qo() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|mAuthorLiveRecorder=" + this.bBL);
        final com.baidu.live.alablmsdk.c.a.a ys = this.bMf.xn().ys();
        if (this.bBL != null) {
            this.bBL.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (ys != null) {
                        ys.onError(i, str);
                    }
                }
            });
            this.bBL.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (ys == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|capturer=" + ys);
                    } else {
                        ys.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UV() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.bMf != null) {
            com.baidu.live.alablmsdk.a.b.a.d("StreamArrive" + this.isMute);
            this.bMf.aZ(this.isMute);
        }
        if (this.bMg != null) {
            this.bMg.Uk();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View Lu() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        return US() ? this.bMf.xn().c(this.bMh) : this.bMf.xn().c(this.bMi);
    }

    private void Qn() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.bBL.setEnableCloudRtc(false, null);
                g.this.bBL.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.bBL = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bMf != null) {
            this.bMf.onRelease();
            this.bMf = null;
        }
    }
}
