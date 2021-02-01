package com.baidu.live.videochat.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderErrorCallback;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.config.a;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.alablmsdk.module.rtc.BLMJoinRoomStage;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.ab;
import com.baidu.live.data.cw;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g implements a {
    private ab aDd;
    private AlaLiveRecorder bFr;
    private com.baidu.live.alablmsdk.a bPQ;
    private f bPR;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bPS = null;
    private com.baidu.live.alablmsdk.module.c bPT = null;
    private JSONObject bPU = null;
    private int mChatStatus = c.bFG;
    private String bPV = null;
    private long bPW = 0;
    private boolean isMute = false;
    private boolean bPX = true;
    private com.baidu.live.alablmsdk.c.d bPY = new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.d
        public void f(final int i, final int i2, final String str) {
            BdLog.e("blmsdk:type=" + i + "|status=" + i2 + "|msg=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 2) {
                        g.this.W(i2, str);
                    } else if (i == 5) {
                        g.this.ab(i2, str);
                    } else if (i == 7) {
                        g.this.ac(i2, str);
                    } else if (i == 8) {
                        g.this.Z(i2, str);
                    } else if (i == 3) {
                        g.this.Y(i2, str);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.c.c bPZ = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.6
        @Override // com.baidu.live.alablmsdk.c.c
        public void a(final int i, BLMJoinRoomStage bLMJoinRoomStage, final com.baidu.live.alablmsdk.module.common.a aVar) {
            if (bLMJoinRoomStage != null && bLMJoinRoomStage == BLMJoinRoomStage.HOST_TRANS) {
                if (g.this.mMainHandler != null) {
                    g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str = "";
                            if (aVar != null) {
                                str = aVar.msg;
                            }
                            g.this.X(i, str);
                        }
                    });
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag(" JoinRoomListener stage=" + bLMJoinRoomStage, "");
        }
    };
    private com.baidu.live.alablmsdk.c.c bQa = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.7
        @Override // com.baidu.live.alablmsdk.c.c
        public void a(final int i, BLMJoinRoomStage bLMJoinRoomStage, final com.baidu.live.alablmsdk.module.common.a aVar) {
            if (bLMJoinRoomStage != null && bLMJoinRoomStage == BLMJoinRoomStage.HOST_TRANS && g.this.mMainHandler != null) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str = "";
                        if (aVar != null) {
                            str = aVar.msg;
                        }
                        g.this.aa(i, str);
                    }
                });
            }
        }
    };
    private com.baidu.live.alablmsdk.c.b bFs = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.8
        @Override // com.baidu.live.alablmsdk.c.b
        public void g(int i, String str) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|errorCode=" + i + "|msg=" + str);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.WE();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + cVar.ayk);
            g.this.bPX = true;
            if (g.this.bPS != null && g.this.bPS.ayk == cVar.ayk) {
                g.this.bPX = false;
            }
            if (g.this.bPT != null && g.this.bPT.ayk == cVar.ayk) {
                g.this.bPX = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bPR != null) {
                        g.this.bPR.q(i, g.this.bPX);
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
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.l(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.m(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.j(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.k(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|mMainHandler=" + g.this.mMainHandler);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.o(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void ey(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.hO(str);
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
                    jSONObject2.put("blm_from", c.bPt);
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
    com.baidu.live.alablmsdk.c.b.e bFt = new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.live.videochat.d.g.9
        @Override // com.baidu.live.alablmsdk.c.b.e
        public void a(String str, String str2, final com.baidu.live.alablmsdk.c.b.a aVar) {
            com.baidu.live.yyrtc.a.ZK().a(str, str2, new com.baidu.live.yyrtc.b() { // from class: com.baidu.live.videochat.d.g.9.1
                @Override // com.baidu.live.yyrtc.b
                public void ai(String str3, String str4) {
                    if (g.this.bPQ != null) {
                        g.this.bPQ.ew(str3);
                    }
                    if (aVar != null) {
                        aVar.ai(str3, str4);
                    }
                }
            });
        }
    };

    @Override // com.baidu.live.videochat.d.a
    public void init(Context context) {
        BdLog.e("blmsdk：LiveBBVideoChatLogicController init context = " + context);
        if (this.bPQ == null) {
            this.bPQ = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
            this.bPQ.ev(com.baidu.live.ae.a.Qj().buX.aNE);
            this.bPQ.a(this.bFt);
            this.bPQ.a(this.bFs);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bFF);
            hashMap.put("rtc_business_source_key", c.bPt);
            hashMap.put("is_auto_publish", true);
            hashMap.put("has_audio", true);
            hashMap.put("has_video", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qj().buX.aNv.maxBitrate));
            hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qj().buX.aNv.aSM));
            hashMap.put("external_audio_capture", true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("yy_rtc_app_id_key", c.bPu);
            hashMap2.put("yy_rtc_room_mode_key", 0);
            hashMap2.put("yy_rtc_media_mode_key", 1);
            hashMap2.put("yy_rtc_audio_config_key", 8);
            hashMap2.put("yy_rtc_commu_mode_key", 2);
            hashMap2.put("yy_rtc_scenario_mode_key", 1);
            hashMap2.put("yy_rtc_publish_codec_mode", Integer.valueOf(com.baidu.live.ae.a.Qj().buX.aNv.aSN));
            hashMap2.put("yy_rtc_publish_play_type_key", 1);
            hashMap.put("yy_rtc_private_params_key", hashMap2);
            this.bPQ.v(hashMap);
            this.bPQ.a(this.bFt);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void t(ab abVar) {
        this.aDd = abVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bPR = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bFr == null) {
            this.bFr = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            a.C0161a c0161a = new a.C0161a();
            c0161a.fps = com.baidu.live.ae.a.Qj().buX.aNv.fps;
            c0161a.axo = new com.baidu.live.alablmsdk.config.a.b(alaLiveRecorder.getVideoConfig().getVideoWidth(), alaLiveRecorder.getVideoConfig().getVideoHeight());
            c0161a.axs = true;
            c0161a.axr = this.bFr.getPushUrl();
            List<cw.a> list = com.baidu.live.ae.a.Qj().buX.aNv.dataList;
            cw.a aVar2 = list.get(0) == null ? cw.a.aSP.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.d dVar = new com.baidu.live.alablmsdk.config.a.d(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            cw.a aVar3 = list.get(1) == null ? cw.a.aSP.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.d dVar2 = new com.baidu.live.alablmsdk.config.a.d(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aDd == null || this.aDd.mLiveInfo == null) ? false : this.aDd.mLiveInfo.isPubShow) {
                com.baidu.live.alablmsdk.config.a.a aVar4 = new com.baidu.live.alablmsdk.config.a.a("", 1, BLMViewShapeType.RECTANGLE, dVar2);
                com.baidu.live.alablmsdk.config.a.a aVar5 = new com.baidu.live.alablmsdk.config.a.a("", 0, BLMViewShapeType.RECTANGLE, dVar);
                arrayList.add(aVar4);
                arrayList.add(aVar5);
            } else {
                com.baidu.live.alablmsdk.config.a.a aVar6 = new com.baidu.live.alablmsdk.config.a.a("", 0, BLMViewShapeType.RECTANGLE, dVar);
                com.baidu.live.alablmsdk.config.a.a aVar7 = new com.baidu.live.alablmsdk.config.a.a("", 1, BLMViewShapeType.RECTANGLE, dVar2);
                arrayList.add(aVar6);
                arrayList.add(aVar7);
            }
            c0161a.axu = arrayList;
            c0161a.axt = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.ae.a.Qj().buX.aNv.aSK, com.baidu.live.ae.a.Qj().buX.aNv.aSL);
            c0161a.axq = com.baidu.live.ae.a.Qj().buX.aNv.maxBitrate;
            c0161a.axx = aVar.a(c0161a);
            aVar.axn = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            aVar.axm = c0161a;
            if (this.bPQ != null) {
                this.bPQ.a(aVar);
            }
        }
    }

    private void ej(int i) {
        this.mChatStatus = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int SV() {
        return this.mChatStatus;
    }

    private boolean WB() {
        BdLog.e("mCurInvitedUser=" + this.bPS);
        return this.bPS != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c Wy() {
        return this.bPS;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bPQ != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bPQ.aY(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void VA() {
        if (this.bPQ != null) {
            this.bPQ.enterBackground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void VB() {
        if (this.bPQ != null) {
            this.bPQ.enterForeground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject Wz() {
        return this.bPU;
    }

    private String WC() {
        StringBuilder sb = new StringBuilder();
        if (this.bPU != null) {
            b ap = d.ap(this.bPU);
            sb.append("sender:");
            if (ap.bPr != null) {
                sb.append(ap.bPr.userId);
            }
            sb.append(",");
            sb.append("receiver:");
            if (ap.bPs != null) {
                sb.append(ap.bPs.userId);
            }
            if (this.bPS != null) {
                sb.append(",");
                sb.append("imuk:");
                sb.append(this.bPS.ayk);
                sb.append(",");
                sb.append("cuid:");
                sb.append(this.bPS.cuid);
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
        if (this.mChatStatus == c.bFG) {
            ej(c.bPw);
            this.bPW = System.currentTimeMillis();
            WD();
            this.bPS = cVar;
            this.bPU = jSONObject;
            this.bPQ.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
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
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bPW) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.mChatStatus + "|ext=" + jSONObject);
        this.bPW = System.currentTimeMillis();
        if (this.mChatStatus == c.bPw) {
            if (i == 0) {
                this.bPV = str;
                a(str, jSONObject, cVar);
                return;
            }
            if (this.bPR != null) {
                this.bPR.a(c.bFM, true, i, str2, str, WC());
            }
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.p(c.bFM, true);
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + jSONObject);
        if (this.mChatStatus == c.bPw) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bPQ.a(str, arrayList, jSONObject, this.bPY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bPW) + "|mChatStatus=" + this.mChatStatus + "|msg=" + str);
        this.bPW = System.currentTimeMillis();
        if (this.mChatStatus == c.bPw) {
            if (i == 0) {
                ej(c.bPx);
                if (this.bPR != null) {
                    this.bPR.VS();
                    return;
                }
                return;
            }
            this.bPQ.c(this.bPV, d.aP("invite_fail", this.bPV), this.bPY);
            if (this.bPR != null) {
                this.bPR.a(c.bFN, true, i, str, this.bPV, WC());
            }
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.p(c.bFN, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (WB() && this.mChatStatus == c.bPx) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bPS);
            this.bPQ.b(this.bPV, arrayList, null, this.bPY);
            this.bPQ.c(this.bPV, d.aP("invite_time_out", str), this.bPY);
            if (this.bPR != null) {
                this.bPR.a(c.bFR, true, c.bFR, "inviteTimeOut", str, WC());
            }
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.p(c.bFR, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bPV + "|isChatSender()=" + WB() + "|costTime=" + (System.currentTimeMillis() - this.bPW));
        this.bPW = System.currentTimeMillis();
        if (this.mChatStatus == c.bPx && this.bPV != null && this.bPV.equals(str) && cVar != null && this.bPS != null) {
            BdLog.e("blmsdk:user uk=" + cVar.ayk + "|invite user uk" + this.bPS.ayk);
            if (cVar.ayk == this.bPS.ayk) {
                ej(c.bFJ);
                RY();
                hQ(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bPS);
            this.bPQ.b(this.bPV, arrayList, null, this.bPY);
            this.bPQ.c(this.bPV, d.aP("user_data_error", str), this.bPY);
            if (this.bPR != null) {
                this.bPR.a(c.bFO, true, c.bFO, "inviteAcceptDataError", str, WC());
            }
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.p(c.bFO, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + WB() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bPW) + "ext=" + jSONObject);
        this.bPW = System.currentTimeMillis();
        if (WB() && this.mChatStatus == c.bPx) {
            this.bPQ.c(str, d.aP("invite_reject", str), this.bPY);
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.p(c.bFS, true);
            }
        }
    }

    private void hQ(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|costTime=" + (System.currentTimeMillis() - this.bPW));
        this.bPW = System.currentTimeMillis();
        if (this.mChatStatus == c.bFJ) {
            this.bPQ.a(str, this.bPZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bPW) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.mChatStatus);
        this.bPW = System.currentTimeMillis();
        if (this.mChatStatus == c.bFJ) {
            if (i == 0) {
                ej(c.bFK);
                if (this.bPR != null) {
                    this.bPR.C(this.bPV, WB());
                    return;
                }
                return;
            }
            this.bPQ.c(this.bPV, d.aP("join_fail", this.bPV), this.bPY);
            RX();
            if (this.bPR != null) {
                this.bPR.a(c.bFP, true, i, str, this.bPV, WC());
            }
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.p(c.bFP, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
    }

    private void dA(boolean z) {
        if (this.mChatStatus == c.bPw) {
            if (this.bPV != null) {
                this.bPQ.c(this.bPV, d.aP("closed_by_user_in_create", this.bPV), this.bPY);
            }
            ej(c.bFG);
            WD();
            if (z) {
                if (this.bPR != null) {
                    this.bPR.p(c.bPA, true);
                }
            } else if (this.bPR != null) {
                this.bPR.p(c.bPB, true);
            }
        } else if (this.mChatStatus == c.bPx) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bPS);
            this.bPQ.b(this.bPV, arrayList, null, this.bPY);
            this.bPQ.c(this.bPV, d.aP(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bPV), this.bPY);
            ej(c.bFG);
            WD();
            if (z) {
                if (this.bPR != null) {
                    this.bPR.p(c.bPA, true);
                }
            } else if (this.bPR != null) {
                this.bPR.p(c.bPB, true);
            }
        } else if (this.mChatStatus == c.bFJ) {
            this.bPQ.c(this.bPV, d.aP("closed_by_user_in_connecting", this.bPV), this.bPY);
            RX();
            ej(c.bFG);
            WD();
            if (z) {
                if (this.bPR != null) {
                    this.bPR.p(c.bPA, true);
                }
            } else if (this.bPR != null) {
                this.bPR.p(c.bPB, true);
            }
        } else if (this.mChatStatus == c.bFK) {
            this.bPQ.c(this.bPV, d.aP("closed_by_user", this.bPV), this.bPY);
            RX();
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.D(this.bPV, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|currentRoomId=" + this.bPV + "|ext=" + jSONObject);
        if (this.mChatStatus == c.bFG) {
            this.bPV = str;
            this.bPT = cVar;
            this.bPU = d.a(d.an(jSONObject), this.aDd, d.bPN);
            ej(c.bPv);
            if (this.bPR != null) {
                this.bPR.a(cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void Wx() {
        ej(c.bFG);
        WD();
    }

    @Override // com.baidu.live.videochat.d.a
    public void al(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bPv) {
            ej(c.bFJ);
            RY();
            this.bPQ.a(this.bPV, jSONObject, this.bQa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|msg=" + str);
        if (this.mChatStatus == c.bFJ) {
            if (i == 0) {
                ej(c.bFK);
                if (this.bPR != null) {
                    this.bPR.C(this.bPV, WB());
                    return;
                }
                return;
            }
            RX();
            if (this.bPR != null) {
                this.bPR.a(c.bFQ, false, i, str, this.bPV, WC());
            }
            if (this.bPR != null) {
                this.bPR.p(c.bFQ, false);
            }
            ej(c.bFG);
            WD();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public String WA() {
        return this.bPV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        boolean WB = WB();
        if (this.mChatStatus == c.bPv) {
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.p(c.bPy, WB);
            }
        } else if (this.mChatStatus == c.bFJ) {
            RX();
            if (this.bPR != null) {
                this.bPR.D(str, WB);
            }
            ej(c.bFG);
            WD();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void am(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bPv) {
            this.bPQ.a(this.bPV, jSONObject, this.bPY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        ej(c.bFG);
        WD();
        if (this.bPR != null) {
            this.bPR.p(c.bPB, false);
        }
    }

    private void dB(boolean z) {
        if (this.mChatStatus == c.bFJ) {
            this.bPQ.b(this.bPV, d.aP(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bPV), this.bPY);
            RX();
            ej(c.bFG);
            WD();
            if (z) {
                if (this.bPR != null) {
                    this.bPR.p(c.bPA, false);
                }
            } else if (this.bPR != null) {
                this.bPR.p(c.bPB, false);
            }
        } else if (this.mChatStatus == c.bFK) {
            this.bPQ.b(this.bPV, d.aP("leave_by_user", this.bPV), this.bPY);
            RX();
            ej(c.bFG);
            WD();
            if (this.bPR != null) {
                this.bPR.D(this.bPV, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.mChatStatus + "isChatSender =" + WB());
        if (WB()) {
            if (this.mChatStatus == c.bFK) {
                this.bPQ.c(str, d.aP("user_leave", str), this.bPY);
                RX();
                ej(c.bFG);
                WD();
                if (this.bPR != null) {
                    this.bPR.D(str, false);
                }
            } else if (this.mChatStatus == c.bFJ) {
                this.bPQ.c(str, d.aP("user_leave_in_connecting", str), this.bPY);
                RX();
                ej(c.bFG);
                WD();
                if (this.bPR != null) {
                    this.bPR.p(c.bPz, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.mChatStatus + "|chatRoomId=" + str);
        if (!WB()) {
            if (this.mChatStatus == c.bFK) {
                this.bPQ.b(this.bPV, d.aP("room_closed", this.bPV), this.bPY);
                RX();
                ej(c.bFG);
                WD();
                if (this.bPR != null) {
                    this.bPR.D(this.bPV, false);
                }
            } else if (this.mChatStatus == c.bFJ) {
                RX();
                ej(c.bFG);
                WD();
                if (this.bPR != null) {
                    this.bPR.p(c.bPz, true);
                }
            }
        }
    }

    private void WD() {
        this.bPS = null;
        this.bPT = null;
        this.bPV = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void dz(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + WB());
        if (WB()) {
            dA(z);
        } else {
            dB(z);
        }
    }

    private void RY() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|mAuthorLiveRecorder=" + this.bFr);
        final com.baidu.live.alablmsdk.c.a.a yG = this.bPQ.xl().yG();
        if (this.bFr != null) {
            this.bFr.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (yG != null) {
                        yG.onError(i, str);
                    }
                }
            });
            this.bFr.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (yG == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|capturer=" + yG);
                    } else {
                        yG.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.bPQ != null) {
            com.baidu.live.alablmsdk.a.b.a.d("StreamArrive" + this.isMute);
            this.bPQ.aY(this.isMute);
        }
        if (this.bPR != null) {
            this.bPR.VT();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View MS() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        return WB() ? this.bPQ.xl().j(this.bPS) : this.bPQ.xl().j(this.bPT);
    }

    private void RX() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.bFr.setEnableCloudRtc(false, null);
                g.this.bFr.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.bFr = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bPQ != null) {
            this.bPQ.onRelease();
            this.bPQ = null;
        }
        com.baidu.live.yyrtc.a.ZK().release();
    }
}
