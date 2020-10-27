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
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.ck;
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
    private w aEc;
    private com.baidu.live.alablmsdk.b bCP;
    private AlaLiveRecorder bCQ;
    private f bCR;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bCS = null;
    private com.baidu.live.alablmsdk.module.c bCT = null;
    private JSONObject bCU = null;
    private int bBa = c.bCk;
    private String bCV = null;
    private long bCW = 0;
    private boolean isMute = false;
    private boolean bCX = true;
    private com.baidu.live.alablmsdk.c.c bCY = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.4
        @Override // com.baidu.live.alablmsdk.c.c
        public void f(final int i, final int i2, final String str) {
            BdLog.e("blmsdk:type=" + i + "|status=" + i2 + "|msg=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 2) {
                        g.this.L(i2, str);
                    } else if (i == 4) {
                        g.this.P(i2, str);
                    } else if (i == 5) {
                        g.this.Q(i2, str);
                    } else if (i == 7) {
                        g.this.R(i2, str);
                    } else if (i == 8) {
                        g.this.O(i2, str);
                    } else if (i == 3) {
                        g.this.N(i2, str);
                    } else if (i == 6) {
                        g.this.M(i2, str);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.c.b bCZ = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bBa + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.To();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + aVar.aBi);
            g.this.bCX = true;
            if (g.this.bCS != null && g.this.bCS.aBi == aVar.aBi) {
                g.this.bCX = false;
            }
            if (g.this.bCT != null && g.this.bCT.aBi == aVar.aBi) {
                g.this.bCX = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bCR != null) {
                        g.this.bCR.q(i, g.this.bCX);
                    }
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bBa);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bBa + "|mMainHandler=" + g.this.mMainHandler + "|ext=" + str2);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bBa);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bBa);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.e(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bBa);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bBa + "|mMainHandler=" + g.this.mMainHandler);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.bBa);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.iy(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fI(String str) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("blm_msg", str);
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
        if (this.bCP == null) {
            this.bCP = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());
            this.bCP.a(this.bCZ);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bCj);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf((int) FeatureCodes.ADVANCE_BEAUTY));
            hashMap.put("encode_min_bitrate", 1100);
            hashMap.put("external_audio_capture", true);
            this.bCP.v(hashMap);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void r(w wVar) {
        this.aEc = wVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bCR = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bCQ == null) {
            this.bCQ = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = 15;
            aVar.aAz = new com.baidu.live.alablmsdk.config.a.a(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aAF = true;
            aVar.aAE = this.bCQ.getPushUrl();
            List<ck.a> list = com.baidu.live.z.a.Pq().bmJ.aMA.dataList;
            ck.a aVar2 = list.get(0) == null ? ck.a.aRj.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.b bVar = new com.baidu.live.alablmsdk.config.a.b(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            ck.a aVar3 = list.get(1) == null ? ck.a.aRj.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.b bVar2 = new com.baidu.live.alablmsdk.config.a.b(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aEc == null || this.aEc.mLiveInfo == null) ? false : this.aEc.mLiveInfo.isPubShow) {
                arrayList.add(bVar2);
                arrayList.add(bVar);
            } else {
                arrayList.add(bVar);
                arrayList.add(bVar2);
            }
            aVar.aAI = arrayList;
            aVar.aAH = new com.baidu.live.alablmsdk.config.a.a(com.baidu.live.z.a.Pq().bmJ.aMA.aRe, com.baidu.live.z.a.Pq().bmJ.aMA.aRf);
            aVar.aAA = FeatureCodes.ADVANCE_BEAUTY;
            aVar.aAG = aVar.Bk();
            com.baidu.live.alablmsdk.a.c.d(" mixTemplate =" + aVar.aAG);
            if (this.bCP != null) {
                this.bCP.a(aVar);
            }
        }
    }

    private void ga(int i) {
        this.bBa = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int Ta() {
        return this.bBa;
    }

    private boolean Tk() {
        BdLog.e("mCurInvitedUser=" + this.bCS);
        return this.bCS != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c Ti() {
        return this.bCS;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bCP != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bCP.aY(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject Tj() {
        return this.bCU;
    }

    private String Tl() {
        StringBuilder sb = new StringBuilder();
        if (this.bCU != null) {
            b ad = d.ad(this.bCU);
            sb.append("sender:");
            if (ad.bCh != null) {
                sb.append(ad.bCh.userId);
            }
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("receiver:");
            if (ad.bCi != null) {
                sb.append(ad.bCi.userId);
            }
            if (this.bCS != null) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("imuk:");
                sb.append(this.bCS.aBi);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("cuid:");
                sb.append(this.bCS.cuid);
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.live.videochat.d.a
    public boolean b(final com.baidu.live.alablmsdk.module.c cVar, final String str) {
        if (cVar == null) {
            BdLog.e("blmsdk:user is null");
            return false;
        }
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|ext=" + str + "|user=" + cVar.toString());
        if (this.bBa == c.bCk) {
            ga(c.bCm);
            this.bCW = System.currentTimeMillis();
            Tm();
            this.bCS = cVar;
            this.bCU = d.iw(str);
            this.bCP.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
                @Override // com.baidu.live.alablmsdk.c.a
                public void c(final String str2, final int i, final String str3) {
                    g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a(str2, i, str3, str, cVar);
                        }
                    });
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2, String str3, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bCW) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.bBa + "|ext=" + str3);
        this.bCW = System.currentTimeMillis();
        if (this.bBa == c.bCm) {
            if (i == 0) {
                this.bCV = str;
                a(str, str3, cVar);
                return;
            }
            if (this.bCR != null) {
                this.bCR.a(c.bCq, true, i, str2, str, Tl());
            }
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCq, true);
            }
        }
    }

    private void a(String str, String str2, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + str2);
        if (this.bBa == c.bCm) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bCP.a(str, arrayList, str2, this.bCY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bCW) + "|mChatStatus=" + this.bBa + "|msg=" + str);
        this.bCW = System.currentTimeMillis();
        if (this.bBa == c.bCm) {
            if (i == 0) {
                ga(c.bCn);
                if (this.bCR != null) {
                    this.bCR.Su();
                    return;
                }
                return;
            }
            this.bCP.d(this.bCV, d.aR("invite_fail", this.bCV), this.bCY);
            if (this.bCR != null) {
                this.bCR.a(c.bCr, true, i, str, this.bCV, Tl());
            }
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCr, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        if (Tk() && this.bBa == c.bCn) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bCS);
            this.bCP.b(this.bCV, arrayList, null, this.bCY);
            this.bCP.d(this.bCV, d.aR("invite_time_out", str), this.bCY);
            if (this.bCR != null) {
                this.bCR.a(c.bCv, true, c.bCv, "inviteTimeOut", str, Tl());
            }
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCv, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bCV + "|isChatSender()=" + Tk() + "|costTime=" + (System.currentTimeMillis() - this.bCW));
        this.bCW = System.currentTimeMillis();
        if (this.bBa == c.bCn && this.bCV != null && this.bCV.equals(str) && cVar != null && this.bCS != null) {
            BdLog.e("blmsdk:user uk=" + cVar.aBi + "|invite user uk" + this.bCS.aBi);
            if (cVar.aBi == this.bCS.aBi) {
                ga(c.bCo);
                Tn();
                ix(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bCS);
            this.bCP.b(this.bCV, arrayList, null, this.bCY);
            this.bCP.d(this.bCV, d.aR("user_data_error", str), this.bCY);
            if (this.bCR != null) {
                this.bCR.a(c.bCs, true, c.bCs, "inviteAcceptDataError", str, Tl());
            }
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCs, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|isChatSender()=" + Tk() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bCW) + "ext=" + str2);
        this.bCW = System.currentTimeMillis();
        if (Tk() && this.bBa == c.bCn) {
            this.bCP.d(str, d.aR("invite_reject", str), this.bCY);
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCw, true);
            }
        }
    }

    private void ix(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|costTime=" + (System.currentTimeMillis() - this.bCW));
        this.bCW = System.currentTimeMillis();
        if (this.bBa == c.bCo) {
            this.bCP.a(str, this.bCY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bCW) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.bBa);
        this.bCW = System.currentTimeMillis();
        if (this.bBa == c.bCo) {
            if (i == 0) {
                ga(c.bCp);
                if (this.bCR != null) {
                    this.bCR.B(this.bCV, Tk());
                    return;
                }
                return;
            }
            this.bCP.d(this.bCV, d.aR("join_fail", this.bCV), this.bCY);
            Tp();
            if (this.bCR != null) {
                this.bCR.a(c.bCt, true, i, str, this.bCV, Tl());
            }
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCt, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, String str) {
    }

    private void cW(boolean z) {
        if (this.bBa == c.bCm) {
            if (this.bCV != null) {
                this.bCP.d(this.bCV, d.aR("closed_by_user_in_create", this.bCV), this.bCY);
            }
            ga(c.bCk);
            Tm();
            if (z) {
                if (this.bCR != null) {
                    this.bCR.p(c.bCz, true);
                }
            } else if (this.bCR != null) {
                this.bCR.p(c.bCA, true);
            }
        } else if (this.bBa == c.bCn) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bCS);
            this.bCP.b(this.bCV, arrayList, null, this.bCY);
            this.bCP.d(this.bCV, d.aR(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bCV), this.bCY);
            ga(c.bCk);
            Tm();
            if (z) {
                if (this.bCR != null) {
                    this.bCR.p(c.bCz, true);
                }
            } else if (this.bCR != null) {
                this.bCR.p(c.bCA, true);
            }
        } else if (this.bBa == c.bCo) {
            this.bCP.d(this.bCV, d.aR("closed_by_user_in_connecting", this.bCV), this.bCY);
            Tp();
            ga(c.bCk);
            Tm();
            if (z) {
                if (this.bCR != null) {
                    this.bCR.p(c.bCz, true);
                }
            } else if (this.bCR != null) {
                this.bCR.p(c.bCA, true);
            }
        } else if (this.bBa == c.bCp) {
            this.bCP.d(this.bCV, d.aR("closed_by_user", this.bCV), this.bCY);
            Tp();
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.C(this.bCV, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|chatRoomId=" + str + "|currentRoomId=" + this.bCV + "|ext=" + str2);
        if (this.bBa == c.bCk) {
            this.bCV = str;
            this.bCT = cVar;
            this.bCU = d.a(d.iv(str2), this.aEc, d.bCM);
            ga(c.bCl);
            if (this.bCR != null) {
                this.bCR.a(cVar, str2);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void Th() {
        ga(c.bCk);
        Tm();
    }

    @Override // com.baidu.live.videochat.d.a
    public void aa(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        if (this.bBa == c.bCl) {
            ga(c.bCo);
            Tn();
            this.bCP.a(this.bCV, jSONObject.toString(), this.bCY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|msg=" + str);
        if (this.bBa == c.bCo) {
            if (i == 0) {
                ga(c.bCp);
                if (this.bCR != null) {
                    this.bCR.B(this.bCV, Tk());
                    return;
                }
                return;
            }
            Tp();
            if (this.bCR != null) {
                this.bCR.a(c.bCu, false, i, str, this.bCV, Tl());
            }
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCu, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        if (this.bBa == c.bCl) {
            boolean Tk = Tk();
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.p(c.bCx, Tk);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void ab(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        if (this.bBa == c.bCl) {
            this.bCP.b(this.bCV, jSONObject.toString(), this.bCY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
        ga(c.bCk);
        Tm();
        if (this.bCR != null) {
            this.bCR.p(c.bCA, false);
        }
    }

    private void cX(boolean z) {
        if (this.bBa == c.bCo) {
            this.bCP.c(this.bCV, d.aR(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bCV), this.bCY);
            Tp();
            ga(c.bCk);
            Tm();
            if (z) {
                if (this.bCR != null) {
                    this.bCR.p(c.bCz, false);
                }
            } else if (this.bCR != null) {
                this.bCR.p(c.bCA, false);
            }
        } else if (this.bBa == c.bCp) {
            this.bCP.c(this.bCV, d.aR("leave_by_user", this.bCV), this.bCY);
            Tp();
            ga(c.bCk);
            Tm();
            if (this.bCR != null) {
                this.bCR.C(this.bCV, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.bBa + "isChatSender =" + Tk());
        if (Tk()) {
            if (this.bBa == c.bCp) {
                this.bCP.d(str, d.aR("user_leave", str), this.bCY);
                Tp();
                ga(c.bCk);
                Tm();
                if (this.bCR != null) {
                    this.bCR.C(str, false);
                }
            } else if (this.bBa == c.bCo) {
                this.bCP.d(str, d.aR("user_leave_in_connecting", str), this.bCY);
                Tp();
                ga(c.bCk);
                Tm();
                if (this.bCR != null) {
                    this.bCR.p(c.bCy, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iy(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.bBa + "|chatRoomId=" + str);
        if (!Tk()) {
            if (this.bBa == c.bCp) {
                this.bCP.c(this.bCV, d.aR("room_closed", this.bCV), this.bCY);
                Tp();
                ga(c.bCk);
                Tm();
                if (this.bCR != null) {
                    this.bCR.C(this.bCV, false);
                }
            } else if (this.bBa == c.bCo) {
                Tp();
                ga(c.bCk);
                Tm();
                if (this.bCR != null) {
                    this.bCR.p(c.bCy, true);
                }
            }
        }
    }

    private void Tm() {
        this.bCS = null;
        this.bCT = null;
        this.bCV = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void cV(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|isChatSender()=" + Tk());
        if (Tk()) {
            cW(z);
        } else {
            cX(z);
        }
    }

    private void Tn() {
        BdLog.e("blmsdk:chatStatus=" + this.bBa + "|mAuthorLiveRecorder=" + this.bCQ);
        final com.baidu.live.alablmsdk.c.a.a BF = this.bCP.Be().BF();
        if (this.bCQ != null) {
            this.bCQ.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (BF == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.bBa + "|capturer=" + BF);
                    } else {
                        BF.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void To() {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        if (this.bCP != null) {
            com.baidu.live.alablmsdk.a.c.d("StreamArrive" + this.isMute);
            this.bCP.aY(this.isMute);
        }
        if (this.bCR != null) {
            this.bCR.Sv();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View getPlayerView() {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        return Tk() ? this.bCP.Be().a(this.bCS) : this.bCP.Be().a(this.bCT);
    }

    private void Tp() {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.bCQ.setDefaultCloudRtcMode(null);
                g.this.bCQ.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.bBa);
        this.bCQ = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bCP != null) {
            this.bCP.onRelease();
            this.bCP = null;
        }
    }
}
