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
    private w aDh;
    private com.baidu.live.alablmsdk.b bGW;
    private f bGX;
    private AlaLiveRecorder bwB;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bGY = null;
    private com.baidu.live.alablmsdk.module.c bGZ = null;
    private JSONObject bHa = null;
    private int bwz = c.bwO;
    private String bHb = null;
    private long bHc = 0;
    private boolean isMute = false;
    private boolean bHd = true;
    private com.baidu.live.alablmsdk.c.c bHe = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.4
        @Override // com.baidu.live.alablmsdk.c.c
        public void e(final int i, final int i2, final String str) {
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
    private com.baidu.live.alablmsdk.c.b bwC = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.Vg();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + aVar.azK);
            g.this.bHd = true;
            if (g.this.bGY != null && g.this.bGY.azK == aVar.azK) {
                g.this.bHd = false;
            }
            if (g.this.bGZ != null && g.this.bGZ.azK == aVar.azK) {
                g.this.bHd = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bGX != null) {
                        g.this.bGX.q(i, g.this.bHd);
                    }
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz + "|mMainHandler=" + g.this.mMainHandler + "|ext=" + jSONObject);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.l(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz);
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
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz + "|mMainHandler=" + g.this.mMainHandler);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bwz);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fB(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.bwz);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.ik(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fC(String str) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("blm_msg", str);
                    jSONObject.put("blm_from", c.bGA);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(com.baidu.live.alablmsdk.a.ayB, com.baidu.live.alablmsdk.a.LOG_TYPE, com.baidu.live.alablmsdk.a.ayC, com.baidu.live.alablmsdk.a.ayD);
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logLMSdkEvent(ubcStatisticItem);
            }
        }
    };

    @Override // com.baidu.live.videochat.d.a
    public void init(Context context) {
        BdLog.e("blmsdk：LiveBBVideoChatLogicController init context = " + context);
        if (this.bGW == null) {
            this.bGW = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());
            this.bGW.a(this.bwC);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bwN);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf((int) FeatureCodes.ADVANCE_BEAUTY));
            hashMap.put("encode_min_bitrate", 1100);
            hashMap.put("external_audio_capture", true);
            this.bGW.v(hashMap);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void s(w wVar) {
        this.aDh = wVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bGX = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bwB == null) {
            this.bwB = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = 15;
            aVar.ayW = new com.baidu.live.alablmsdk.config.a.b(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.azb = true;
            aVar.aza = this.bwB.getPushUrl();
            List<cm.a> list = com.baidu.live.aa.a.Ph().bms.aLP.dataList;
            cm.a aVar2 = list.get(0) == null ? cm.a.aQA.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.c cVar = new com.baidu.live.alablmsdk.config.a.c(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            cm.a aVar3 = list.get(1) == null ? cm.a.aQA.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.c cVar2 = new com.baidu.live.alablmsdk.config.a.c(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aDh == null || this.aDh.mLiveInfo == null) ? false : this.aDh.mLiveInfo.isPubShow) {
                arrayList.add(cVar2);
                arrayList.add(cVar);
            } else {
                arrayList.add(cVar);
                arrayList.add(cVar2);
            }
            aVar.aze = arrayList;
            aVar.azd = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.aa.a.Ph().bms.aLP.aQv, com.baidu.live.aa.a.Ph().bms.aLP.aQw);
            aVar.ayY = FeatureCodes.ADVANCE_BEAUTY;
            aVar.azc = aVar.AD();
            com.baidu.live.alablmsdk.a.b.d(" mixTemplate =" + aVar.azc);
            aVar.ayZ = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            if (this.bGW != null) {
                this.bGW.a(aVar);
            }
        }
    }

    private void fm(int i) {
        this.bwz = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int RE() {
        return this.bwz;
    }

    private boolean Vd() {
        BdLog.e("mCurInvitedUser=" + this.bGY);
        return this.bGY != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c Vb() {
        return this.bGY;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bGW != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bGW.ba(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject Vc() {
        return this.bHa;
    }

    private String Ve() {
        StringBuilder sb = new StringBuilder();
        if (this.bHa != null) {
            b ad = d.ad(this.bHa);
            sb.append("sender:");
            if (ad.bGy != null) {
                sb.append(ad.bGy.userId);
            }
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("receiver:");
            if (ad.bGz != null) {
                sb.append(ad.bGz.userId);
            }
            if (this.bGY != null) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("imuk:");
                sb.append(this.bGY.azK);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("cuid:");
                sb.append(this.bGY.cuid);
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
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|ext=" + jSONObject + "|user=" + cVar.toString());
        if (this.bwz == c.bwO) {
            fm(c.bGC);
            this.bHc = System.currentTimeMillis();
            Vf();
            this.bGY = cVar;
            this.bHa = jSONObject;
            this.bGW.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
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
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bHc) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.bwz + "|ext=" + jSONObject);
        this.bHc = System.currentTimeMillis();
        if (this.bwz == c.bGC) {
            if (i == 0) {
                this.bHb = str;
                a(str, jSONObject, cVar);
                return;
            }
            if (this.bGX != null) {
                this.bGX.a(c.bwU, true, i, str2, str, Ve());
            }
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bwU, true);
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + jSONObject);
        if (this.bwz == c.bGC) {
            cVar.order = "1";
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bGW.a(str, arrayList, jSONObject, this.bHe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bHc) + "|mChatStatus=" + this.bwz + "|msg=" + str);
        this.bHc = System.currentTimeMillis();
        if (this.bwz == c.bGC) {
            if (i == 0) {
                fm(c.bGD);
                if (this.bGX != null) {
                    this.bGX.Ut();
                    return;
                }
                return;
            }
            this.bGW.d(this.bHb, d.aR("invite_fail", this.bHb), this.bHe);
            if (this.bGX != null) {
                this.bGX.a(c.bwV, true, i, str, this.bHb, Ve());
            }
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bwV, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        if (Vd() && this.bwz == c.bGD) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bGY);
            this.bGW.b(this.bHb, arrayList, null, this.bHe);
            this.bGW.d(this.bHb, d.aR("invite_time_out", str), this.bHe);
            if (this.bGX != null) {
                this.bGX.a(c.bwZ, true, c.bwZ, "inviteTimeOut", str, Ve());
            }
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bwZ, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bHb + "|isChatSender()=" + Vd() + "|costTime=" + (System.currentTimeMillis() - this.bHc));
        this.bHc = System.currentTimeMillis();
        if (this.bwz == c.bGD && this.bHb != null && this.bHb.equals(str) && cVar != null && this.bGY != null) {
            BdLog.e("blmsdk:user uk=" + cVar.azK + "|invite user uk" + this.bGY.azK);
            if (cVar.azK == this.bGY.azK) {
                fm(c.bwR);
                QG();
                im(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bGY);
            this.bGW.b(this.bHb, arrayList, null, this.bHe);
            this.bGW.d(this.bHb, d.aR("user_data_error", str), this.bHe);
            if (this.bGX != null) {
                this.bGX.a(c.bwW, true, c.bwW, "inviteAcceptDataError", str, Ve());
            }
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bwW, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|isChatSender()=" + Vd() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bHc) + "ext=" + jSONObject);
        this.bHc = System.currentTimeMillis();
        if (Vd() && this.bwz == c.bGD) {
            this.bGW.d(str, d.aR("invite_reject", str), this.bHe);
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bxa, true);
            }
        }
    }

    private void im(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|costTime=" + (System.currentTimeMillis() - this.bHc));
        this.bHc = System.currentTimeMillis();
        if (this.bwz == c.bwR) {
            this.bGW.a(str, this.bHe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bHc) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.bwz);
        this.bHc = System.currentTimeMillis();
        if (this.bwz == c.bwR) {
            if (i == 0) {
                fm(c.bwS);
                if (this.bGX != null) {
                    this.bGX.B(this.bHb, Vd());
                    return;
                }
                return;
            }
            this.bGW.d(this.bHb, d.aR("join_fail", this.bHb), this.bHe);
            QF();
            if (this.bGX != null) {
                this.bGX.a(c.bwX, true, i, str, this.bHb, Ve());
            }
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bwX, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, String str) {
    }

    private void df(boolean z) {
        if (this.bwz == c.bGC) {
            if (this.bHb != null) {
                this.bGW.d(this.bHb, d.aR("closed_by_user_in_create", this.bHb), this.bHe);
            }
            fm(c.bwO);
            Vf();
            if (z) {
                if (this.bGX != null) {
                    this.bGX.p(c.bGG, true);
                }
            } else if (this.bGX != null) {
                this.bGX.p(c.bGH, true);
            }
        } else if (this.bwz == c.bGD) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bGY);
            this.bGW.b(this.bHb, arrayList, null, this.bHe);
            this.bGW.d(this.bHb, d.aR(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bHb), this.bHe);
            fm(c.bwO);
            Vf();
            if (z) {
                if (this.bGX != null) {
                    this.bGX.p(c.bGG, true);
                }
            } else if (this.bGX != null) {
                this.bGX.p(c.bGH, true);
            }
        } else if (this.bwz == c.bwR) {
            this.bGW.d(this.bHb, d.aR("closed_by_user_in_connecting", this.bHb), this.bHe);
            QF();
            fm(c.bwO);
            Vf();
            if (z) {
                if (this.bGX != null) {
                    this.bGX.p(c.bGG, true);
                }
            } else if (this.bGX != null) {
                this.bGX.p(c.bGH, true);
            }
        } else if (this.bwz == c.bwS) {
            this.bGW.d(this.bHb, d.aR("closed_by_user", this.bHb), this.bHe);
            QF();
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.C(this.bHb, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|chatRoomId=" + str + "|currentRoomId=" + this.bHb + "|ext=" + jSONObject);
        if (this.bwz == c.bwO) {
            this.bHb = str;
            this.bGZ = cVar;
            this.bHa = d.a(d.ab(jSONObject), this.aDh, d.bGT);
            fm(c.bGB);
            if (this.bGX != null) {
                this.bGX.a(cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void Va() {
        fm(c.bwO);
        Vf();
    }

    @Override // com.baidu.live.videochat.d.a
    public void Z(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        if (this.bwz == c.bGB) {
            fm(c.bwR);
            QG();
            this.bGW.a(this.bHb, jSONObject, this.bHe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|msg=" + str);
        if (this.bwz == c.bwR) {
            if (i == 0) {
                fm(c.bwS);
                if (this.bGX != null) {
                    this.bGX.B(this.bHb, Vd());
                    return;
                }
                return;
            }
            QF();
            if (this.bGX != null) {
                this.bGX.a(c.bwY, false, i, str, this.bHb, Ve());
            }
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bwY, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        if (this.bwz == c.bGB) {
            boolean Vd = Vd();
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.p(c.bGE, Vd);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void aa(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        if (this.bwz == c.bGB) {
            this.bGW.b(this.bHb, jSONObject, this.bHe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        fm(c.bwO);
        Vf();
        if (this.bGX != null) {
            this.bGX.p(c.bGH, false);
        }
    }

    private void dg(boolean z) {
        if (this.bwz == c.bwR) {
            this.bGW.c(this.bHb, d.aR(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bHb), this.bHe);
            QF();
            fm(c.bwO);
            Vf();
            if (z) {
                if (this.bGX != null) {
                    this.bGX.p(c.bGG, false);
                }
            } else if (this.bGX != null) {
                this.bGX.p(c.bGH, false);
            }
        } else if (this.bwz == c.bwS) {
            this.bGW.c(this.bHb, d.aR("leave_by_user", this.bHb), this.bHe);
            QF();
            fm(c.bwO);
            Vf();
            if (this.bGX != null) {
                this.bGX.C(this.bHb, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.bwz + "isChatSender =" + Vd());
        if (Vd()) {
            if (this.bwz == c.bwS) {
                this.bGW.d(str, d.aR("user_leave", str), this.bHe);
                QF();
                fm(c.bwO);
                Vf();
                if (this.bGX != null) {
                    this.bGX.C(str, false);
                }
            } else if (this.bwz == c.bwR) {
                this.bGW.d(str, d.aR("user_leave_in_connecting", str), this.bHe);
                QF();
                fm(c.bwO);
                Vf();
                if (this.bGX != null) {
                    this.bGX.p(c.bGF, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.bwz + "|chatRoomId=" + str);
        if (!Vd()) {
            if (this.bwz == c.bwS) {
                this.bGW.c(this.bHb, d.aR("room_closed", this.bHb), this.bHe);
                QF();
                fm(c.bwO);
                Vf();
                if (this.bGX != null) {
                    this.bGX.C(this.bHb, false);
                }
            } else if (this.bwz == c.bwR) {
                QF();
                fm(c.bwO);
                Vf();
                if (this.bGX != null) {
                    this.bGX.p(c.bGF, true);
                }
            }
        }
    }

    private void Vf() {
        this.bGY = null;
        this.bGZ = null;
        this.bHb = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void de(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|isChatSender()=" + Vd());
        if (Vd()) {
            df(z);
        } else {
            dg(z);
        }
    }

    private void QG() {
        BdLog.e("blmsdk:chatStatus=" + this.bwz + "|mAuthorLiveRecorder=" + this.bwB);
        final com.baidu.live.alablmsdk.c.a.a Bo = this.bGW.Av().Bo();
        if (this.bwB != null) {
            this.bwB.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (Bo == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.bwz + "|capturer=" + Bo);
                    } else {
                        Bo.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vg() {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        if (this.bGW != null) {
            com.baidu.live.alablmsdk.a.b.d("StreamArrive" + this.isMute);
            this.bGW.ba(this.isMute);
        }
        if (this.bGX != null) {
            this.bGX.Uu();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View getPlayerView() {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        return Vd() ? this.bGW.Av().c(this.bGY) : this.bGW.Av().c(this.bGZ);
    }

    private void QF() {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.bwB.setDefaultCloudRtcMode(null);
                g.this.bwB.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.bwz);
        this.bwB = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bGW != null) {
            this.bGW.onRelease();
            this.bGW = null;
        }
    }
}
