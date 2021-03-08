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
/* loaded from: classes10.dex */
public class g implements a {
    private ab aED;
    private AlaLiveRecorder bGR;
    private com.baidu.live.alablmsdk.a bRq;
    private f bRr;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bRs = null;
    private com.baidu.live.alablmsdk.module.c bRt = null;
    private JSONObject bRu = null;
    private int mChatStatus = c.bHg;
    private String bRv = null;
    private long bRw = 0;
    private boolean isMute = false;
    private boolean bRx = true;
    private com.baidu.live.alablmsdk.c.d bRy = new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.videochat.d.g.5
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
    private com.baidu.live.alablmsdk.c.c bRz = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.6
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
    private com.baidu.live.alablmsdk.c.c bRA = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.7
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
    private com.baidu.live.alablmsdk.c.b bGS = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.8
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
                        g.this.WH();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + cVar.azK);
            g.this.bRx = true;
            if (g.this.bRs != null && g.this.bRs.azK == cVar.azK) {
                g.this.bRx = false;
            }
            if (g.this.bRt != null && g.this.bRt.azK == cVar.azK) {
                g.this.bRx = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bRr != null) {
                        g.this.bRr.q(i, g.this.bRx);
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
        public void eE(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.mChatStatus);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.8.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.hU(str);
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
                    jSONObject2.put("blm_from", c.bQT);
                } catch (JSONException e) {
                }
                UbcStatisticManager.getInstance().logLMSdkEvent(str, jSONObject, jSONObject2);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public String xq() {
            return null;
        }
    };
    com.baidu.live.alablmsdk.c.b.e bGT = new com.baidu.live.alablmsdk.c.b.e() { // from class: com.baidu.live.videochat.d.g.9
        @Override // com.baidu.live.alablmsdk.c.b.e
        public void a(String str, String str2, final com.baidu.live.alablmsdk.c.b.a aVar) {
            com.baidu.live.yyrtc.a.ZN().a(str, str2, new com.baidu.live.yyrtc.b() { // from class: com.baidu.live.videochat.d.g.9.1
                @Override // com.baidu.live.yyrtc.b
                public void ai(String str3, String str4) {
                    if (g.this.bRq != null) {
                        g.this.bRq.eD(str3);
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
        if (this.bRq == null) {
            this.bRq = new com.baidu.live.alablmsdk.a(TbadkCoreApplication.getInst());
            this.bRq.eC(com.baidu.live.ae.a.Qm().bwx.aPe);
            this.bRq.a(this.bGT);
            this.bRq.a(this.bGS);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bHf);
            hashMap.put("rtc_business_source_key", c.bQT);
            hashMap.put("is_auto_publish", true);
            hashMap.put("has_audio", true);
            hashMap.put("has_video", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qm().bwx.aOV.maxBitrate));
            hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.ae.a.Qm().bwx.aOV.aUm));
            hashMap.put("external_audio_capture", true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("yy_rtc_app_id_key", c.bQU);
            hashMap2.put("yy_rtc_room_mode_key", 0);
            hashMap2.put("yy_rtc_media_mode_key", 1);
            hashMap2.put("yy_rtc_audio_config_key", 8);
            hashMap2.put("yy_rtc_commu_mode_key", 2);
            hashMap2.put("yy_rtc_scenario_mode_key", 1);
            hashMap2.put("yy_rtc_publish_codec_mode", Integer.valueOf(com.baidu.live.ae.a.Qm().bwx.aOV.aUn));
            hashMap2.put("yy_rtc_publish_play_type_key", 1);
            hashMap.put("yy_rtc_private_params_key", hashMap2);
            this.bRq.v(hashMap);
            this.bRq.a(this.bGT);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void t(ab abVar) {
        this.aED = abVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bRr = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bGR == null) {
            this.bGR = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            a.C0167a c0167a = new a.C0167a();
            c0167a.fps = com.baidu.live.ae.a.Qm().bwx.aOV.fps;
            c0167a.ayO = new com.baidu.live.alablmsdk.config.a.b(alaLiveRecorder.getVideoConfig().getVideoWidth(), alaLiveRecorder.getVideoConfig().getVideoHeight());
            c0167a.ayS = true;
            c0167a.ayR = this.bGR.getPushUrl();
            List<cw.a> list = com.baidu.live.ae.a.Qm().bwx.aOV.dataList;
            cw.a aVar2 = list.get(0) == null ? cw.a.aUp.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.d dVar = new com.baidu.live.alablmsdk.config.a.d(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            cw.a aVar3 = list.get(1) == null ? cw.a.aUp.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.d dVar2 = new com.baidu.live.alablmsdk.config.a.d(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aED == null || this.aED.mLiveInfo == null) ? false : this.aED.mLiveInfo.isPubShow) {
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
            c0167a.ayU = arrayList;
            c0167a.ayT = new com.baidu.live.alablmsdk.config.a.b(com.baidu.live.ae.a.Qm().bwx.aOV.aUk, com.baidu.live.ae.a.Qm().bwx.aOV.aUl);
            c0167a.ayQ = com.baidu.live.ae.a.Qm().bwx.aOV.maxBitrate;
            c0167a.ayX = aVar.a(c0167a);
            aVar.ayN = BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
            aVar.ayM = c0167a;
            if (this.bRq != null) {
                this.bRq.a(aVar);
            }
        }
    }

    private void ek(int i) {
        this.mChatStatus = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int SY() {
        return this.mChatStatus;
    }

    private boolean WE() {
        BdLog.e("mCurInvitedUser=" + this.bRs);
        return this.bRs != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c WB() {
        return this.bRs;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bRq != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bRq.aY(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void VD() {
        if (this.bRq != null) {
            this.bRq.enterBackground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void VE() {
        if (this.bRq != null) {
            this.bRq.enterForeground();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject WC() {
        return this.bRu;
    }

    private String WF() {
        StringBuilder sb = new StringBuilder();
        if (this.bRu != null) {
            b ar = d.ar(this.bRu);
            sb.append("sender:");
            if (ar.bQR != null) {
                sb.append(ar.bQR.userId);
            }
            sb.append(",");
            sb.append("receiver:");
            if (ar.bQS != null) {
                sb.append(ar.bQS.userId);
            }
            if (this.bRs != null) {
                sb.append(",");
                sb.append("imuk:");
                sb.append(this.bRs.azK);
                sb.append(",");
                sb.append("cuid:");
                sb.append(this.bRs.cuid);
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
        if (this.mChatStatus == c.bHg) {
            ek(c.bQW);
            this.bRw = System.currentTimeMillis();
            WG();
            this.bRs = cVar;
            this.bRu = jSONObject;
            this.bRq.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
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
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bRw) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.mChatStatus + "|ext=" + jSONObject);
        this.bRw = System.currentTimeMillis();
        if (this.mChatStatus == c.bQW) {
            if (i == 0) {
                this.bRv = str;
                a(str, jSONObject, cVar);
                return;
            }
            if (this.bRr != null) {
                this.bRr.a(c.bHm, true, i, str2, str, WF());
            }
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.p(c.bHm, true);
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + jSONObject);
        if (this.mChatStatus == c.bQW) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bRq.a(str, arrayList, jSONObject, this.bRy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bRw) + "|mChatStatus=" + this.mChatStatus + "|msg=" + str);
        this.bRw = System.currentTimeMillis();
        if (this.mChatStatus == c.bQW) {
            if (i == 0) {
                ek(c.bQX);
                if (this.bRr != null) {
                    this.bRr.VV();
                    return;
                }
                return;
            }
            this.bRq.c(this.bRv, d.aP("invite_fail", this.bRv), this.bRy);
            if (this.bRr != null) {
                this.bRr.a(c.bHn, true, i, str, this.bRv, WF());
            }
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.p(c.bHn, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (WE() && this.mChatStatus == c.bQX) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bRs);
            this.bRq.b(this.bRv, arrayList, null, this.bRy);
            this.bRq.c(this.bRv, d.aP("invite_time_out", str), this.bRy);
            if (this.bRr != null) {
                this.bRr.a(c.bHr, true, c.bHr, "inviteTimeOut", str, WF());
            }
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.p(c.bHr, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bRv + "|isChatSender()=" + WE() + "|costTime=" + (System.currentTimeMillis() - this.bRw));
        this.bRw = System.currentTimeMillis();
        if (this.mChatStatus == c.bQX && this.bRv != null && this.bRv.equals(str) && cVar != null && this.bRs != null) {
            BdLog.e("blmsdk:user uk=" + cVar.azK + "|invite user uk" + this.bRs.azK);
            if (cVar.azK == this.bRs.azK) {
                ek(c.bHj);
                Sb();
                hW(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bRs);
            this.bRq.b(this.bRv, arrayList, null, this.bRy);
            this.bRq.c(this.bRv, d.aP("user_data_error", str), this.bRy);
            if (this.bRr != null) {
                this.bRr.a(c.bHo, true, c.bHo, "inviteAcceptDataError", str, WF());
            }
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.p(c.bHo, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + WE() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bRw) + "ext=" + jSONObject);
        this.bRw = System.currentTimeMillis();
        if (WE() && this.mChatStatus == c.bQX) {
            this.bRq.c(str, d.aP("invite_reject", str), this.bRy);
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.p(c.bHs, true);
            }
        }
    }

    private void hW(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|costTime=" + (System.currentTimeMillis() - this.bRw));
        this.bRw = System.currentTimeMillis();
        if (this.mChatStatus == c.bHj) {
            this.bRq.a(str, this.bRz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bRw) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.mChatStatus);
        this.bRw = System.currentTimeMillis();
        if (this.mChatStatus == c.bHj) {
            if (i == 0) {
                ek(c.bHk);
                if (this.bRr != null) {
                    this.bRr.C(this.bRv, WE());
                    return;
                }
                return;
            }
            this.bRq.c(this.bRv, d.aP("join_fail", this.bRv), this.bRy);
            Sa();
            if (this.bRr != null) {
                this.bRr.a(c.bHp, true, i, str, this.bRv, WF());
            }
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.p(c.bHp, true);
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
        if (this.mChatStatus == c.bQW) {
            if (this.bRv != null) {
                this.bRq.c(this.bRv, d.aP("closed_by_user_in_create", this.bRv), this.bRy);
            }
            ek(c.bHg);
            WG();
            if (z) {
                if (this.bRr != null) {
                    this.bRr.p(c.bRa, true);
                }
            } else if (this.bRr != null) {
                this.bRr.p(c.bRb, true);
            }
        } else if (this.mChatStatus == c.bQX) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bRs);
            this.bRq.b(this.bRv, arrayList, null, this.bRy);
            this.bRq.c(this.bRv, d.aP(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bRv), this.bRy);
            ek(c.bHg);
            WG();
            if (z) {
                if (this.bRr != null) {
                    this.bRr.p(c.bRa, true);
                }
            } else if (this.bRr != null) {
                this.bRr.p(c.bRb, true);
            }
        } else if (this.mChatStatus == c.bHj) {
            this.bRq.c(this.bRv, d.aP("closed_by_user_in_connecting", this.bRv), this.bRy);
            Sa();
            ek(c.bHg);
            WG();
            if (z) {
                if (this.bRr != null) {
                    this.bRr.p(c.bRa, true);
                }
            } else if (this.bRr != null) {
                this.bRr.p(c.bRb, true);
            }
        } else if (this.mChatStatus == c.bHk) {
            this.bRq.c(this.bRv, d.aP("closed_by_user", this.bRv), this.bRy);
            Sa();
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.D(this.bRv, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|chatRoomId=" + str + "|currentRoomId=" + this.bRv + "|ext=" + jSONObject);
        if (this.mChatStatus == c.bHg) {
            this.bRv = str;
            this.bRt = cVar;
            this.bRu = d.a(d.ap(jSONObject), this.aED, d.bRn);
            ek(c.bQV);
            if (this.bRr != null) {
                this.bRr.a(cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void WA() {
        ek(c.bHg);
        WG();
    }

    @Override // com.baidu.live.videochat.d.a
    public void an(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bQV) {
            ek(c.bHj);
            Sb();
            this.bRq.a(this.bRv, jSONObject, this.bRA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|msg=" + str);
        if (this.mChatStatus == c.bHj) {
            if (i == 0) {
                ek(c.bHk);
                if (this.bRr != null) {
                    this.bRr.C(this.bRv, WE());
                    return;
                }
                return;
            }
            Sa();
            if (this.bRr != null) {
                this.bRr.a(c.bHq, false, i, str, this.bRv, WF());
            }
            if (this.bRr != null) {
                this.bRr.p(c.bHq, false);
            }
            ek(c.bHg);
            WG();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public String WD() {
        return this.bRv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        boolean WE = WE();
        if (this.mChatStatus == c.bQV) {
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.p(c.bQY, WE);
            }
        } else if (this.mChatStatus == c.bHj) {
            Sa();
            if (this.bRr != null) {
                this.bRr.D(str, WE);
            }
            ek(c.bHg);
            WG();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void ao(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.mChatStatus == c.bQV) {
            this.bRq.a(this.bRv, jSONObject, this.bRy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        ek(c.bHg);
        WG();
        if (this.bRr != null) {
            this.bRr.p(c.bRb, false);
        }
    }

    private void dB(boolean z) {
        if (this.mChatStatus == c.bHj) {
            this.bRq.b(this.bRv, d.aP(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bRv), this.bRy);
            Sa();
            ek(c.bHg);
            WG();
            if (z) {
                if (this.bRr != null) {
                    this.bRr.p(c.bRa, false);
                }
            } else if (this.bRr != null) {
                this.bRr.p(c.bRb, false);
            }
        } else if (this.mChatStatus == c.bHk) {
            this.bRq.b(this.bRv, d.aP("leave_by_user", this.bRv), this.bRy);
            Sa();
            ek(c.bHg);
            WG();
            if (this.bRr != null) {
                this.bRr.D(this.bRv, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.mChatStatus + "isChatSender =" + WE());
        if (WE()) {
            if (this.mChatStatus == c.bHk) {
                this.bRq.c(str, d.aP("user_leave", str), this.bRy);
                Sa();
                ek(c.bHg);
                WG();
                if (this.bRr != null) {
                    this.bRr.D(str, false);
                }
            } else if (this.mChatStatus == c.bHj) {
                this.bRq.c(str, d.aP("user_leave_in_connecting", str), this.bRy);
                Sa();
                ek(c.bHg);
                WG();
                if (this.bRr != null) {
                    this.bRr.p(c.bQZ, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.mChatStatus + "|chatRoomId=" + str);
        if (!WE()) {
            if (this.mChatStatus == c.bHk) {
                this.bRq.b(this.bRv, d.aP("room_closed", this.bRv), this.bRy);
                Sa();
                ek(c.bHg);
                WG();
                if (this.bRr != null) {
                    this.bRr.D(this.bRv, false);
                }
            } else if (this.mChatStatus == c.bHj) {
                Sa();
                ek(c.bHg);
                WG();
                if (this.bRr != null) {
                    this.bRr.p(c.bQZ, true);
                }
            }
        }
    }

    private void WG() {
        this.bRs = null;
        this.bRt = null;
        this.bRv = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void dz(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|isChatSender()=" + WE());
        if (WE()) {
            dA(z);
        } else {
            dB(z);
        }
    }

    private void Sb() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus + "|mAuthorLiveRecorder=" + this.bGR);
        final com.baidu.live.alablmsdk.c.a.a yJ = this.bRq.xo().yJ();
        if (this.bGR != null) {
            this.bGR.setRecorderErrorCallback(new RecorderErrorCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.recorder.RecorderErrorCallback
                public void onError(int i, String str) {
                    if (yJ != null) {
                        yJ.onError(i, str);
                    }
                }
            });
            this.bGR.setEnableCloudRtc(true, new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.3
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (yJ == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.mChatStatus + "|capturer=" + yJ);
                    } else {
                        yJ.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WH() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        if (this.bRq != null) {
            com.baidu.live.alablmsdk.a.b.a.d("StreamArrive" + this.isMute);
            this.bRq.aY(this.isMute);
        }
        if (this.bRr != null) {
            this.bRr.VW();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View MV() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        return WE() ? this.bRq.xo().j(this.bRs) : this.bRq.xo().j(this.bRt);
    }

    private void Sa() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.bGR.setEnableCloudRtc(false, null);
                g.this.bGR.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.mChatStatus);
        this.bGR = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bRq != null) {
            this.bRq.onRelease();
            this.bRq = null;
        }
        com.baidu.live.yyrtc.a.ZN().release();
    }
}
