package com.baidu.live.videochat.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.cm;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements a {
    private w aES;
    private com.baidu.live.alablmsdk.b bIH;
    private f bII;
    private AlaLiveRecorder bym;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bIJ = null;
    private com.baidu.live.alablmsdk.module.c bIK = null;
    private JSONObject bIL = null;
    private int byk = c.byz;
    private String bIM = null;
    private long bIN = 0;
    private boolean isMute = false;
    private boolean bIO = true;
    private com.baidu.live.alablmsdk.c.c bIP = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.4
        @Override // com.baidu.live.alablmsdk.c.c
        public void f(final int i, final int i2, final String str) {
            BdLog.e("blmsdk:type=" + i + "|status=" + i2 + "|msg=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4.1
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
    private com.baidu.live.alablmsdk.c.b byn = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.VP();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + aVar.aBv);
            g.this.bIO = true;
            if (g.this.bIJ != null && g.this.bIJ.aBv == aVar.aBv) {
                g.this.bIO = false;
            }
            if (g.this.bIK != null && g.this.bIK.aBv == aVar.aBv) {
                g.this.bIO = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bII != null) {
                        g.this.bII.q(i, g.this.bIO);
                    }
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk + "|mMainHandler=" + g.this.mMainHandler + "|ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.l(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk + "|mMainHandler=" + g.this.mMainHandler);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.byk);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.byk);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.iq(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fI(String str) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("blm_msg", str);
                    jSONObject.put("blm_from", c.bIl);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(com.baidu.live.alablmsdk.a.aAm, com.baidu.live.alablmsdk.a.LOG_TYPE, com.baidu.live.alablmsdk.a.aAn, com.baidu.live.alablmsdk.a.aAo);
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logLMSdkEvent(ubcStatisticItem);
            }
        }
    };

    @Override // com.baidu.live.videochat.d.a
    public void init(Context context) {
        BdLog.e("blmsdk：LiveBBVideoChatLogicController init context = " + context);
        if (this.bIH == null) {
            this.bIH = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());
            this.bIH.a(this.byn);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.byy);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf((int) FeatureCodes.ADVANCE_BEAUTY));
            hashMap.put("encode_min_bitrate", 1100);
            hashMap.put("external_audio_capture", true);
            this.bIH.v(hashMap);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void s(w wVar) {
        this.aES = wVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bII = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bym == null) {
            this.bym = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = 15;
            aVar.aAH = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aAM = true;
            aVar.aAL = this.bym.getPushUrl();
            List<cm.a> list = com.baidu.live.aa.a.PQ().bod.aNA.dataList;
            cm.a aVar2 = list.get(0) == null ? cm.a.aSl.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.c cVar = new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            cm.a aVar3 = list.get(1) == null ? cm.a.aSl.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.c cVar2 = new com.baidu.live.alablmsdk.config.a.c(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aES == null || this.aES.mLiveInfo == null) ? false : this.aES.mLiveInfo.isPubShow) {
                arrayList.add(cVar2);
                arrayList.add(cVar);
            } else {
                arrayList.add(cVar);
                arrayList.add(cVar2);
            }
            aVar.aAP = arrayList;
            aVar.aAO = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.aa.a.PQ().bod.aNA.aSg, com.baidu.live.aa.a.PQ().bod.aNA.aSh);
            aVar.aAJ = FeatureCodes.ADVANCE_BEAUTY;
            aVar.aAN = aVar.Bm();
            com.baidu.live.alablmsdk.a.b.d(" mixTemplate =" + aVar.aAN);
            aVar.aAK = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bIH != null) {
                this.bIH.a(aVar);
            }
        }
    }

    private void fq(int i) {
        this.byk = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int Sn() {
        return this.byk;
    }

    private boolean VM() {
        BdLog.e("mCurInvitedUser=" + this.bIJ);
        return this.bIJ != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c VK() {
        return this.bIJ;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bIH != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bIH.aY(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject VL() {
        return this.bIL;
    }

    private String VN() {
        StringBuilder sb = new StringBuilder();
        if (this.bIL != null) {
            b aj = d.aj(this.bIL);
            sb.append("sender:");
            if (aj.bIj != null) {
                sb.append(aj.bIj.userId);
            }
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("receiver:");
            if (aj.bIk != null) {
                sb.append(aj.bIk.userId);
            }
            if (this.bIJ != null) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("imuk:");
                sb.append(this.bIJ.aBv);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("cuid:");
                sb.append(this.bIJ.cuid);
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
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|ext=" + jSONObject + "|user=" + cVar.toString());
        if (this.byk == c.byz) {
            fq(c.bIn);
            this.bIN = System.currentTimeMillis();
            VO();
            this.bIJ = cVar;
            this.bIL = jSONObject;
            this.bIH.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
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
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bIN) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.byk + "|ext=" + jSONObject);
        this.bIN = System.currentTimeMillis();
        if (this.byk == c.bIn) {
            if (i == 0) {
                this.bIM = str;
                a(str, jSONObject, cVar);
                return;
            }
            if (this.bII != null) {
                this.bII.a(c.byF, true, i, str2, str, VN());
            }
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.byF, true);
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + jSONObject);
        if (this.byk == c.bIn) {
            cVar.order = "1";
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bIH.a(str, arrayList, jSONObject, this.bIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bIN) + "|mChatStatus=" + this.byk + "|msg=" + str);
        this.bIN = System.currentTimeMillis();
        if (this.byk == c.bIn) {
            if (i == 0) {
                fq(c.bIo);
                if (this.bII != null) {
                    this.bII.Vc();
                    return;
                }
                return;
            }
            this.bIH.d(this.bIM, d.aS("invite_fail", this.bIM), this.bIP);
            if (this.bII != null) {
                this.bII.a(c.byG, true, i, str, this.bIM, VN());
            }
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.byG, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        if (VM() && this.byk == c.bIo) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bIJ);
            this.bIH.b(this.bIM, arrayList, null, this.bIP);
            this.bIH.d(this.bIM, d.aS("invite_time_out", str), this.bIP);
            if (this.bII != null) {
                this.bII.a(c.byK, true, c.byK, "inviteTimeOut", str, VN());
            }
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.byK, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bIM + "|isChatSender()=" + VM() + "|costTime=" + (System.currentTimeMillis() - this.bIN));
        this.bIN = System.currentTimeMillis();
        if (this.byk == c.bIo && this.bIM != null && this.bIM.equals(str) && cVar != null && this.bIJ != null) {
            BdLog.e("blmsdk:user uk=" + cVar.aBv + "|invite user uk" + this.bIJ.aBv);
            if (cVar.aBv == this.bIJ.aBv) {
                fq(c.byC);
                Rp();
                is(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bIJ);
            this.bIH.b(this.bIM, arrayList, null, this.bIP);
            this.bIH.d(this.bIM, d.aS("user_data_error", str), this.bIP);
            if (this.bII != null) {
                this.bII.a(c.byH, true, c.byH, "inviteAcceptDataError", str, VN());
            }
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.byH, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|isChatSender()=" + VM() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bIN) + "ext=" + jSONObject);
        this.bIN = System.currentTimeMillis();
        if (VM() && this.byk == c.bIo) {
            this.bIH.d(str, d.aS("invite_reject", str), this.bIP);
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.byL, true);
            }
        }
    }

    private void is(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|costTime=" + (System.currentTimeMillis() - this.bIN));
        this.bIN = System.currentTimeMillis();
        if (this.byk == c.byC) {
            this.bIH.a(str, this.bIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bIN) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.byk);
        this.bIN = System.currentTimeMillis();
        if (this.byk == c.byC) {
            if (i == 0) {
                fq(c.byD);
                if (this.bII != null) {
                    this.bII.B(this.bIM, VM());
                    return;
                }
                return;
            }
            this.bIH.d(this.bIM, d.aS("join_fail", this.bIM), this.bIP);
            Ro();
            if (this.bII != null) {
                this.bII.a(c.byI, true, i, str, this.bIM, VN());
            }
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.byI, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, String str) {
    }

    private void dd(boolean z) {
        if (this.byk == c.bIn) {
            if (this.bIM != null) {
                this.bIH.d(this.bIM, d.aS("closed_by_user_in_create", this.bIM), this.bIP);
            }
            fq(c.byz);
            VO();
            if (z) {
                if (this.bII != null) {
                    this.bII.p(c.bIr, true);
                }
            } else if (this.bII != null) {
                this.bII.p(c.bIs, true);
            }
        } else if (this.byk == c.bIo) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bIJ);
            this.bIH.b(this.bIM, arrayList, null, this.bIP);
            this.bIH.d(this.bIM, d.aS(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bIM), this.bIP);
            fq(c.byz);
            VO();
            if (z) {
                if (this.bII != null) {
                    this.bII.p(c.bIr, true);
                }
            } else if (this.bII != null) {
                this.bII.p(c.bIs, true);
            }
        } else if (this.byk == c.byC) {
            this.bIH.d(this.bIM, d.aS("closed_by_user_in_connecting", this.bIM), this.bIP);
            Ro();
            fq(c.byz);
            VO();
            if (z) {
                if (this.bII != null) {
                    this.bII.p(c.bIr, true);
                }
            } else if (this.bII != null) {
                this.bII.p(c.bIs, true);
            }
        } else if (this.byk == c.byD) {
            this.bIH.d(this.bIM, d.aS("closed_by_user", this.bIM), this.bIP);
            Ro();
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.C(this.bIM, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|chatRoomId=" + str + "|currentRoomId=" + this.bIM + "|ext=" + jSONObject);
        if (this.byk == c.byz) {
            this.bIM = str;
            this.bIK = cVar;
            this.bIL = d.a(d.ah(jSONObject), this.aES, d.bIE);
            fq(c.bIm);
            if (this.bII != null) {
                this.bII.a(cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void VJ() {
        fq(c.byz);
        VO();
    }

    @Override // com.baidu.live.videochat.d.a
    public void af(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        if (this.byk == c.bIm) {
            fq(c.byC);
            Rp();
            this.bIH.a(this.bIM, jSONObject, this.bIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|msg=" + str);
        if (this.byk == c.byC) {
            if (i == 0) {
                fq(c.byD);
                if (this.bII != null) {
                    this.bII.B(this.bIM, VM());
                    return;
                }
                return;
            }
            Ro();
            if (this.bII != null) {
                this.bII.a(c.byJ, false, i, str, this.bIM, VN());
            }
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.byJ, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        if (this.byk == c.bIm) {
            boolean VM = VM();
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.p(c.bIp, VM);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void ag(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        if (this.byk == c.bIm) {
            this.bIH.b(this.bIM, jSONObject, this.bIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        fq(c.byz);
        VO();
        if (this.bII != null) {
            this.bII.p(c.bIs, false);
        }
    }

    private void de(boolean z) {
        if (this.byk == c.byC) {
            this.bIH.c(this.bIM, d.aS(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bIM), this.bIP);
            Ro();
            fq(c.byz);
            VO();
            if (z) {
                if (this.bII != null) {
                    this.bII.p(c.bIr, false);
                }
            } else if (this.bII != null) {
                this.bII.p(c.bIs, false);
            }
        } else if (this.byk == c.byD) {
            this.bIH.c(this.bIM, d.aS("leave_by_user", this.bIM), this.bIP);
            Ro();
            fq(c.byz);
            VO();
            if (this.bII != null) {
                this.bII.C(this.bIM, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.byk + "isChatSender =" + VM());
        if (VM()) {
            if (this.byk == c.byD) {
                this.bIH.d(str, d.aS("user_leave", str), this.bIP);
                Ro();
                fq(c.byz);
                VO();
                if (this.bII != null) {
                    this.bII.C(str, false);
                }
            } else if (this.byk == c.byC) {
                this.bIH.d(str, d.aS("user_leave_in_connecting", str), this.bIP);
                Ro();
                fq(c.byz);
                VO();
                if (this.bII != null) {
                    this.bII.p(c.bIq, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.byk + "|chatRoomId=" + str);
        if (!VM()) {
            if (this.byk == c.byD) {
                this.bIH.c(this.bIM, d.aS("room_closed", this.bIM), this.bIP);
                Ro();
                fq(c.byz);
                VO();
                if (this.bII != null) {
                    this.bII.C(this.bIM, false);
                }
            } else if (this.byk == c.byC) {
                Ro();
                fq(c.byz);
                VO();
                if (this.bII != null) {
                    this.bII.p(c.bIq, true);
                }
            }
        }
    }

    private void VO() {
        this.bIJ = null;
        this.bIK = null;
        this.bIM = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void dc(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|isChatSender()=" + VM());
        if (VM()) {
            dd(z);
        } else {
            de(z);
        }
    }

    private void Rp() {
        BdLog.e("blmsdk:chatStatus=" + this.byk + "|mAuthorLiveRecorder=" + this.bym);
        final com.baidu.live.alablmsdk.c.a.a BX = this.bIH.Be().BX();
        if (this.bym != null) {
            this.bym.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (BX == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.byk + "|capturer=" + BX);
                    } else {
                        BX.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VP() {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        if (this.bIH != null) {
            com.baidu.live.alablmsdk.a.b.d("StreamArrive" + this.isMute);
            this.bIH.aY(this.isMute);
        }
        if (this.bII != null) {
            this.bII.Vd();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View getPlayerView() {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        return VM() ? this.bIH.Be().c(this.bIJ) : this.bIH.Be().c(this.bIK);
    }

    private void Ro() {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.bym.setDefaultCloudRtcMode(null);
                g.this.bym.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.byk);
        this.bym = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bIH != null) {
            this.bIH.onRelease();
            this.bIH = null;
        }
    }
}
