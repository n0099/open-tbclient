package com.baidu.live.alablmsdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMSyncRtcInfo;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.live.alablmsdk.a.b;
import com.baidu.live.alablmsdk.a.c;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.alablmsdk.module.state.LegacyRoomStatus;
import com.baidu.live.alablmsdk.module.state.LinkUserStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements BIMRtcListener, IConnectListener, ILiveMsgReceiveListener, b.a, c.a, com.baidu.live.alablmsdk.c.b.a {
    private com.baidu.live.alablmsdk.e.b aAE;
    private a aAI;
    private com.baidu.live.alablmsdk.d.c aAJ;
    private com.baidu.live.alablmsdk.d.b aAK;
    private com.baidu.live.alablmsdk.d.a aAL;
    public com.baidu.live.alablmsdk.module.a aAM;
    private com.baidu.live.alablmsdk.c.c aAN;
    private com.baidu.live.alablmsdk.a.b aAO;
    private com.baidu.live.alablmsdk.a.b aAP;
    private List<Integer> aAQ;
    private List<com.baidu.live.alablmsdk.module.rtc.b> aAR = new ArrayList();
    private int aAS;
    private int aAT;
    private com.baidu.live.alablmsdk.c.b aAl;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        c.a(this);
        this.aAE = new com.baidu.live.alablmsdk.e.b(context, this);
        this.aAI = new a(this.aAE);
        this.aAI.Bs();
        this.aAJ = new com.baidu.live.alablmsdk.d.c(context);
        this.aAJ.a(this);
        this.aAK = new com.baidu.live.alablmsdk.d.b(this.aAJ);
        this.aAL = new com.baidu.live.alablmsdk.d.a(context, this.aAJ);
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aAl = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        w(hashMap);
        this.aAJ.v(hashMap);
        this.aAE.v(hashMap);
    }

    private void w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.aAQ = (List) obj;
            Collections.sort(this.aAQ);
            Collections.reverse(this.aAQ);
            Bt();
        }
    }

    private void Bt() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aAQ)) {
            for (int i = 0; i < this.aAQ.size(); i++) {
                com.baidu.live.alablmsdk.module.rtc.b bVar = new com.baidu.live.alablmsdk.module.rtc.b();
                bVar.time = this.aAQ.get(i).intValue();
                bVar.aBn = false;
                this.aAR.add(bVar);
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aAJ.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Be() {
        return this.aAL;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.aAE.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.b.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    c.d("createRoom onResult responseCode = " + i + " , errorMessage = " + str);
                    c.fJ("createRoom onResult code " + i + " message " + str);
                    if (c.isDebug()) {
                        c.d("createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        b.this.b(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId);
                        b.this.aAE.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                c.d(" signal join onResult , responseCode=" + i2 + " , errorMessage=" + str2);
                                c.fJ(" signal join onResult code " + i2 + " message " + str2);
                                if (i2 == 0) {
                                    aVar.c(bIMRTCGetTokeResult.roomId, 0, "create signal room suc");
                                } else {
                                    aVar.c("", -1, "join signal room fail responseCode=" + i2 + " errorMessage=" + str2);
                                }
                            }
                        });
                        return;
                    }
                    aVar.c("", 1001, "create signal room fail responseCode" + i + " errorMessage=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, long j) {
        this.aAM = new com.baidu.live.alablmsdk.module.a();
        this.aAM.roomId = str;
        this.aAM.token = str2;
        this.aAM.rtcAppId = str3;
        this.aAM.aBd = j;
        this.aAM.aBe = UserPermission.OWNER;
        if (this.aAI != null) {
            this.aAI.a(str, this.aAM.aBe);
        }
        com.baidu.live.alablmsdk.module.b.BE().b(this.aAM);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.INVITING);
        this.aAE.c(str, list, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.4
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str3) {
                if (cVar != null) {
                    cVar.e(i, i2, str3);
                }
            }
        });
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAE.d(str, list, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.5
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str3) {
                if (i2 == 0 || i2 == -1) {
                    b.this.BA();
                }
                if (cVar != null) {
                    cVar.e(i, i2, str3);
                }
            }
        });
    }

    public void a(final String str, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAE.e(str, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.6
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str3) {
                if (i2 == 0) {
                    b.this.b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.6.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void e(int i3, int i4, String str4) {
                            c.d(" visiter join room， status=" + i4 + " , msg" + str4);
                            c.fJ(" visiter join room， status " + i4 + " msg " + str4);
                            if (i4 != 0) {
                                b.this.c(str, b.this.Bu(), null);
                                c.d("acceptRoom join rtc room error ; msg = " + str4);
                                c.fJ("acceptRoom join rtc room error msg " + str4);
                                if (cVar != null) {
                                    cVar.e(4, -1, "acceptRoom join rtc room error ; msg = " + str4);
                                    return;
                                }
                                return;
                            }
                            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.CONNECTED);
                            if (cVar != null) {
                                cVar.e(4, 0, "acceptRoom join rtc room success");
                            }
                        }
                    });
                    return;
                }
                c.d("acceptRoom join signal room error ; msg = " + str3);
                c.fJ("acceptRoom join signal room error msg " + str3);
                b.this.BA();
                if (cVar != null) {
                    cVar.e(4, -1, "acceptRoom join signal room error ; msg = " + str3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("blm_status_check_info", "");
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        c.d(" structureErrorExt " + jSONObject2);
        c.fJ(" structureErrorExt " + jSONObject2);
        return jSONObject2;
    }

    public void b(String str, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAE.f(str, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.7
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str3) {
                b.this.BA();
                if (cVar != null) {
                    cVar.e(i, i2, str3);
                }
            }
        });
    }

    public void a(final String str, final com.baidu.live.alablmsdk.c.c cVar) {
        b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.8
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str2) {
                c.d(" owner join room， status=" + i2 + " , msg" + str2);
                c.fJ(" owner join room status " + i2 + " msg" + str2);
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.CONNECTED);
                    if (cVar != null) {
                        cVar.e(4, 0, "acceptRoom join rtc room success");
                        return;
                    }
                    return;
                }
                b.this.d(str, "", null);
                c.d("acceptRoom join rtc room error ; msg = " + str2);
                c.fJ("acceptRoom join rtc room error msg " + str2);
                if (cVar != null) {
                    cVar.e(4, -1, "acceptRoom join rtc room error ; msg = " + str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, com.baidu.live.alablmsdk.c.c cVar) {
        this.aAN = cVar;
        com.baidu.live.alablmsdk.module.a fL = com.baidu.live.alablmsdk.module.b.BE().fL(str);
        if (fL == null) {
            c.d("joinRoom param error , getChatInfo null ");
            c.fJ("joinRoom param error getChatInfo null ");
            if (this.aAN != null) {
                this.aAN.e(6, 1000, "join rtc room param error , getChatInfo null");
            }
        } else if (!com.baidu.live.alablmsdk.module.a.a(fL)) {
            c.d("joinRoom chatInfo check error");
            c.fJ("joinRoom chatInfo check error");
            if (this.aAN != null) {
                this.aAN.e(6, 1000, "joinRoom chatInfo check error");
            }
        } else {
            this.aAL.BI();
            this.aAL.b(true, fL.aBf);
            this.aAL.BG();
            this.aAJ.c(str, fL.token, fL.rtcAppId, fL.aBd);
        }
    }

    public void aY(boolean z) {
        if (this.aAK != null) {
            c.d("muteMicrophone " + z);
            c.fJ("muteMicrophone " + z);
            this.aAK.aY(z);
        }
    }

    public void c(String str, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        c.d(" leaveRoom ext" + str2);
        c.fJ(" leaveRoom ");
        this.aAJ.BP();
        this.aAE.a(str, str2, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str3) {
                c.d(" leaveRoom onResult ，responseCode=" + i + " , errorMessage=" + str3);
                c.fJ(" leaveRoom onResult code " + i + " message " + str3);
                if (i == 0) {
                    if (b.this.aAI != null) {
                        b.this.aAI.a(LegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (cVar != null) {
                        cVar.e(7, 0, "leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (b.this.aAI != null) {
                    b.this.aAI.a(LegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (cVar != null) {
                    cVar.e(7, -1, "leaveRoom hangout signal fail");
                }
            }
        });
        BA();
        BB();
    }

    public void d(final String str, final String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        c.d(" closeRoom roomId=" + str + " ext " + str2);
        c.fJ(" closeRoom roomId " + str);
        com.baidu.live.alablmsdk.module.a fL = com.baidu.live.alablmsdk.module.b.BE().fL(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (fL != null) {
            userPermission = fL.aBe;
        }
        c.d(" closeRoom permission=" + userPermission);
        c.fJ(" closeRoom permission " + userPermission);
        if (userPermission == UserPermission.OWNER) {
            this.aAJ.BO();
        } else {
            this.aAJ.BP();
        }
        this.aAE.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str3) {
                c.d(" closeRoom-signal hangout  responseCode=" + i + " , errorMessage=" + str3);
                c.fJ(" closeRoom-signal hangout code " + i + " errorMessage " + str3);
                if (userPermission == UserPermission.OWNER) {
                    c.d(" signal close ");
                    c.fJ(" signal close ");
                    b.this.aAE.b(str, str2, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.10.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str4) {
                            c.d(" signal closeRoom , responseCode=" + i2 + " , errorMessage=" + str4);
                            c.fJ(" signal closeRoom code " + i2 + " errorMessage " + str4);
                            if (i2 == 0) {
                                if (b.this.aAI != null) {
                                    b.this.aAI.a(LegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (cVar != null) {
                                    cVar.e(8, 0, "closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (b.this.aAI != null) {
                                b.this.aAI.a(LegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (cVar != null) {
                                cVar.e(8, -1, "closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        BA();
        BB();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        c.d(" b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        c.d(" im 连接状态 responseCode = " + i);
        c.fJ(" im long connection code " + i);
        dx(i);
    }

    private void dx(int i) {
        if (i == 0) {
            if (this.aAM != null) {
                Bv();
            } else if (this.aAM == null) {
                this.aAI.Br();
            }
        }
    }

    private void Bv() {
        c.d(" reJoinSignalAndRtcRoomInner ");
        c.fJ(" reJoinSignalAndRtcRoomInner ");
        if (this.aAM != null) {
            this.aAE.join(this.aAM.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.11
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    c.d(" reJoinSignalAndRtcRoomInner signal join onResult , responseCode=" + i + " , errorMessage=" + str);
                    c.fJ(" reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str);
                    if (i == 0) {
                        c.d(" reJoinSignalAndRtcRoomInner signal join success");
                        c.fJ(" reJoinSignalAndRtcRoomInner signal join success");
                        b.this.aAJ.BS();
                        return;
                    }
                    c.d(" reJoinSignalAndRtcRoomInner signal join fail");
                    c.fJ(" reJoinSignalAndRtcRoomInner signal join fail");
                }
            });
            return;
        }
        c.d(" reJoinSignalAndRtcRoomInner mCurrentChatInfo==null  ");
        c.fJ(" reJoinSignalAndRtcRoomInner mCurrentChatInfo==null");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
        if (i == 89) {
            c.d(" signal onRtcResult room closed ");
            c.fJ(" signal onRtcResult room closed ");
            String str = "";
            if (bIMRtcInfo != null) {
                str = bIMRtcInfo.getRtcRoomId();
            }
            if (this.aAM != null && !TextUtils.isEmpty(this.aAM.roomId) && this.aAM.roomId.equals(str)) {
                BA();
            }
            if (this.aAl != null) {
                c.d(" room closed callback ,  roomId=" + str);
                c.fJ(" room closed callback roomId " + str);
                this.aAl.fH(str);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerInviteTimeoutByCallee(BIMRtcInfo bIMRtcInfo) {
        String str = null;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            str = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aBd = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        c.d(" caller invite time out, other imUk=" + cVar.aBd);
        c.fJ(" caller invite time out");
        if (this.aAM != null && this.aAM.BC() && this.aAM.aBf == cVar.aBd) {
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.FAIL);
            if (this.aAl != null) {
                c.d(" caller invite time out , callback ");
                c.fJ(" caller invite time out callback ");
                this.aAl.a(str, cVar);
                return;
            }
            return;
        }
        c.d(" caller invite time out , not callback ");
        c.fJ(" caller invite time out not callback ");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerGetAnswerSyncByCallee(int i, BIMRtcInfo bIMRtcInfo) {
        c.d(" roomCallerGetAnswerSyncByCallee ");
        c.fJ(" roomCallerGetAnswerSyncByCallee ");
        String str = null;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        String str2 = "";
        if (bIMRtcInfo != null) {
            str = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aBd = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.live.alablmsdk.module.b.BE().fL(str).aBf = cVar.aBd;
                }
                c.d(" caller 收到 callee 的响应 ， callee 的 uk=" + cVar.aBd);
                c.fJ(" caller receive callee response");
            }
            str2 = bIMRtcInfo.getRtcExt();
        }
        if (i == 1) {
            c.d(" caller，callee answer ok");
            c.fJ(" caller，callee answer ok");
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.CONNECTING);
            if (this.aAl != null) {
                c.d(" caller，callee answer ok ， callback");
                c.fJ(" caller，callee answer ok callback");
                this.aAl.d(str, cVar, str2);
            }
        } else if (i == 2) {
            c.d(" caller，callee answer no");
            c.fJ(" caller，callee answer no");
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.REFUSE);
            if (this.aAl != null) {
                c.d(" caller，callee answer no ， callback");
                c.fJ(" caller，callee answer no callback");
                this.aAl.e(str, cVar, str2);
            }
        } else if (i == 3) {
            c.d(" caller，callee answer timeout 30s");
            c.fJ(" caller，callee answer timeout 30s");
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.FAIL);
            if (this.aAl != null) {
                c.d(" caller，callee answer timeout 30s ， callback");
                c.fJ(" caller，callee answer timeout 30s callback");
                this.aAl.a(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo) {
        c.d(" 被叫方接收到邀请(解析 rtc room 的相关信息，");
        c.fJ(" callee receive invite ");
        if (bIMRtcInfo != null && (bIMRtcInfo instanceof BIMInviteSyncRtcInfo)) {
            BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = (BIMInviteSyncRtcInfo) bIMRtcInfo;
            String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
            String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
            c.d(" 被叫方接收到邀请 roomId=" + rtcRoomId);
            c.fJ(" callee receive invite roomId " + rtcRoomId);
            if (!TextUtils.isEmpty(rtcRoomId)) {
                if (this.aAM != null) {
                    if (this.aAM.roomId != null && !this.aAM.roomId.equals(rtcRoomId)) {
                        c.d(" callee get invite. mCurrentChatInfo.roomId != roomId , return。  mCurrentChatInfo.roomId=" + this.aAM.roomId);
                        c.fJ(" callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.aAM.roomId);
                        return;
                    } else if (this.aAM.BC() && this.aAM.aBf != 0) {
                        c.d("callee get invite。 transaction has start, return");
                        c.fJ("callee get invite transaction has start return");
                        return;
                    }
                }
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                if (com.baidu.live.alablmsdk.module.b.BE().fL(rtcRoomId) == null) {
                    com.baidu.live.alablmsdk.module.a aVar = new com.baidu.live.alablmsdk.module.a();
                    aVar.roomId = rtcRoomId;
                    aVar.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                    aVar.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                    aVar.aBd = bIMInviteSyncRtcInfo.getRtcUserId();
                    aVar.aBe = UserPermission.VISITER;
                    aVar.aBf = bIMInviteSyncRtcInfo.getInitiatorUk();
                    aVar.a(LinkUserStatus.RING);
                    if (c.isDebug()) {
                        c.d("callee 收到邀请 ， " + aVar.BD());
                    }
                    this.aAM = aVar;
                    com.baidu.live.alablmsdk.module.b.BE().b(aVar);
                    if (this.aAI != null) {
                        this.aAI.a(aVar.roomId, aVar.aBe);
                    }
                }
                cVar.aBd = bIMInviteSyncRtcInfo.getInitiatorUk();
                if (this.aAl != null) {
                    this.aAl.b(rtcRoomId, cVar, rtcExt);
                }
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        c.d(" callee,  caller cancel invite ");
        c.fJ(" callee,  caller cancel invite ");
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        String str = null;
        String str2 = "";
        if (bIMRtcInfo != null) {
            str = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aBd = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
            str2 = bIMRtcInfo.getRtcExt();
        }
        if (this.aAM != null && this.aAM.BC() && !TextUtils.isEmpty(this.aAM.roomId) && this.aAM.roomId.equals(str) && this.aAM.aBf != 0 && this.aAM.aBf == cVar.aBd) {
            BA();
            if (this.aAl != null) {
                this.aAl.c(str, cVar, str2);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.BE().a(bIMRtcInfo.getRtcRoomId(), LinkUserStatus.DEFAULT);
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerByFromOtherCallee(int i, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventSyncByOthers(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
        String str = "";
        String str2 = "";
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            str = bIMRtcInfo.getRtcRoomId();
            str2 = bIMRtcInfo.getRtcExt();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aBd = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        if (c.isDebug()) {
            c.d(" 对方的事件 : roomEventType=" + roomEventType + "  roomId=" + str + " , imUk=" + (cVar == null ? 0L : cVar.aBd) + " ext=" + str2);
        }
        c.fJ("roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str);
        if (fK(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                c.d(" signal： 对方 ringing ");
                c.fJ(" signal： other ringing ");
                com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.RING);
                if (this.aAl != null) {
                    this.aAl.a(str, cVar, str2);
                    return;
                }
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.JOIN_ROOM) {
                c.d(" signal： 对方 join 信令房间");
                c.fJ(" signal： other join signal room");
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.EXIT_ROOM) {
                c.d(" signal： 对方 exit 信令房间 ");
                c.fJ(" signal： other exit signal room");
                d(str, cVar);
                return;
            } else {
                return;
            }
        }
        c.d(" 对方的事件 非当前 room chart ，不处理");
        c.fJ(" not current room chart do nothing");
    }

    private void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (c.isDebug()) {
            c.d(" handleSignalUserLeave :  roomId=" + str + " , imUk=" + (cVar == null ? 0L : cVar.aBd));
        }
        c.fJ("handleSignalUserLeave roomId " + str);
        if (this.aAM != null && !TextUtils.isEmpty(this.aAM.roomId) && this.aAM.roomId.equals(str) && this.aAM.BC()) {
            c.d(" handleSignalUserLeave ， otherImUk 清除 ");
            Bw();
            this.aAM.aBf = 0L;
            if (this.aAl != null) {
                this.aAl.c(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void fetchRoomState(boolean z, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void fetchRoomSignal(boolean z, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void dy(int i) {
        c.d(" onCurrentUserStreamChange status=" + i);
        c.fJ(" onCurrentUserStreamChange status " + i);
        if (i == 2) {
            Bz();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void g(int i, String str) {
        if (i == 0) {
            c.d(" onJoinRtcRoomStatus success msg=" + str);
            c.fJ(" onJoinRtcRoomStatus success msg " + str);
            Bx();
            if (this.aAN != null) {
                this.aAN.e(6, 0, str);
                return;
            }
            return;
        }
        c.d(" onJoinRtcRoomStatus fail msg=" + str);
        c.fJ(" onJoinRtcRoomStatus fail msg " + str);
        if (this.aAN != null) {
            this.aAN.e(6, -1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void onRoomEventUpdate(int i, long j, String str) {
        c.d(" rtc onRoomEventUpdate roomEvents=" + i + " , imUK=" + j + " , extra_info=" + str);
        c.fJ(" rtc onRoomEventUpdate roomEvents " + i);
        c(i, j);
    }

    private void c(int i, long j) {
        if (j != 0) {
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.aBd = j;
            if (this.aAM != null) {
                if (!TextUtils.isEmpty(this.aAM.roomId)) {
                    if (this.aAM.BC()) {
                        if (this.aAM.aBf == j) {
                            c.d(" 是当前事务用户: yes ");
                            c.fJ(" current transaction  yes ");
                            if (i == 300) {
                                c.d("remote join :  invite join or reJoin rtc");
                                c.fJ("remote join  invite join or reJoin rtc");
                                if (this.aAl != null) {
                                    com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                                    cVar.aBd = j;
                                    this.aAl.b(this.aAM.roomId, cVar);
                                    return;
                                }
                                return;
                            } else if (i == 301) {
                                c.d("remote user leave");
                                c.fJ("remote user leave");
                                return;
                            } else if (i == 106) {
                                c.d("remote stream arrival");
                                c.fJ("remote stream arrival");
                                if (this.aAl != null) {
                                    this.aAl.a(aVar, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                                }
                                Bw();
                                return;
                            } else if (i == 107) {
                                c.d("remote stream leave");
                                c.fJ("remote stream leave");
                                if (this.aAl != null) {
                                    this.aAl.a(aVar, BLMStreamState.BLMSTREAMSTATE_REMOVE);
                                }
                                a(aVar);
                                return;
                            } else {
                                return;
                            }
                        }
                        c.d(" 是当前事务用户 : no ");
                        c.fJ(" current transaction no ");
                        if (i == 300) {
                            c.d("remote join :  invite join or reJoin rtc");
                            c.fJ("remote join :  invite join or reJoin rtc");
                            if (this.aAM.aBe == UserPermission.OWNER && this.aAJ != null) {
                                this.aAJ.W(j);
                                return;
                            }
                            return;
                        } else if (i == 301) {
                            c.d("remote user leave");
                            c.fJ("remote user leave");
                            return;
                        } else if (i == 106) {
                            c.d("remote stream arrival");
                            c.fJ("remote stream arrival");
                            if (this.aAM.aBe == UserPermission.OWNER && this.aAJ != null) {
                                this.aAJ.W(j);
                                return;
                            }
                            return;
                        } else if (i == 107) {
                            c.d("remote stream leave");
                            c.fJ("remote stream leave");
                            return;
                        } else {
                            return;
                        }
                    }
                    c.d(" handleRtc , hasStartedTransaction is false , imUk=" + j);
                    c.fJ(" handleRtc hasStartedTransaction is false ");
                    return;
                }
                c.d(" handleRtc , mCurrentChatInfo.roomId is empty , imUk=" + j);
                c.fJ(" handleRtc mCurrentChatInfo.roomId is empty");
                return;
            }
            c.d(" handleRtc , mCurrentChatInfo is null , imUk=" + j);
            c.fJ(" handleRtc mCurrentChatInfo is null");
        }
    }

    private void Bw() {
        if (this.aAP != null) {
            c.d("leave count down stop");
            c.fJ("leave count down stop");
            this.aAP.cancelTimer();
        }
    }

    private void Bx() {
        if (this.aAO != null) {
            c.d("current user leave count down stop");
            c.fJ("current user leave count down stop");
            this.aAO.cancelTimer();
        }
    }

    private void By() {
        this.aAS = com.baidu.live.alablmsdk.a.a.s(this.aAQ);
        if (this.aAS <= 0) {
            this.aAT = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        } else {
            this.aAT = this.aAS * 1000;
        }
    }

    private void a(final com.baidu.live.alablmsdk.module.rtc.a aVar) {
        c.d("leave count down start");
        c.fJ("leave count down start");
        By();
        c.d("leave count down, maxCountDownTime=" + this.aAT);
        c.fJ("leave count down maxCountDownTime " + this.aAT);
        d.Bi().post(new Runnable() { // from class: com.baidu.live.alablmsdk.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.aAP == null) {
                    b.this.aAP = new com.baidu.live.alablmsdk.a.b();
                }
                b.this.aAP.I(aVar);
                b.this.aAP.a(2, b.this.aAT, 1000L, b.this);
            }
        });
    }

    private void Bz() {
        c.d(" current user leave count down start");
        c.fJ(" current user leave count down start");
        By();
        c.d(" current user leave count down, maxCountDownTime=" + this.aAT);
        c.fJ(" current user leave count down maxCountDownTime " + this.aAT);
        d.Bi().post(new Runnable() { // from class: com.baidu.live.alablmsdk.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.aAO == null) {
                    b.this.aAO = new com.baidu.live.alablmsdk.a.b();
                }
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                if (b.this.aAM != null) {
                    aVar.aBd = b.this.aAM.aBd;
                }
                b.this.aAO.I(aVar);
                b.this.aAO.a(1, b.this.aAT, 1000L, b.this);
            }
        });
    }

    @Override // com.baidu.live.alablmsdk.a.b.a
    public void a(int i, long j, Object obj) {
        float f = (float) (this.aAS - (j / 1000));
        c.d(" onTick time = " + f);
        c.fJ(" onTick time " + f);
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aAR)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aAR.size()) {
                    com.baidu.live.alablmsdk.module.rtc.b bVar = this.aAR.get(i3);
                    if (bVar != null && !bVar.aBn && f >= bVar.time && this.aAl != null) {
                        com.baidu.live.alablmsdk.module.rtc.a aVar = null;
                        if (obj instanceof com.baidu.live.alablmsdk.module.rtc.a) {
                            aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
                        }
                        if (c.isDebug()) {
                            c.d(" onTick 回调给上层接口 leavedForSeconds , stream.imUk=" + (aVar == null ? 0L : aVar.aBd) + " time=" + bVar.time);
                        }
                        c.fJ(" onTick callback leavedForSeconds");
                        bVar.aBn = true;
                        this.aAl.a(aVar, bVar.time);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.a.b.a
    public void b(int i, Object obj) {
        com.baidu.live.alablmsdk.module.rtc.a aVar;
        c.d(" onCountDownFinish ");
        c.fJ(" onCountDownFinish ");
        if (this.aAl != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
            }
            int i2 = 0;
            if (this.aAP != null) {
                i2 = (int) this.aAP.Bf();
            }
            if (c.isDebug()) {
                c.d(" onCountDownFinish 回调给上层接口 leavedForSeconds , stream.imUk=" + (aVar == null ? 0L : aVar.aBd) + " finishTime=" + i2);
            }
            c.fJ(" onCountDownFinish callback leavedForSeconds");
            if (this.aAM != null) {
                this.aAM.aBf = 0L;
            }
            this.aAl.a(aVar, i2);
        }
    }

    public void BA() {
        c.d(" resetCurrentChat ");
        c.fJ(" resetCurrentChat ");
        this.aAM = null;
        com.baidu.live.alablmsdk.module.b.BE().clearAll();
    }

    public boolean fK(String str) {
        return (this.aAM == null || TextUtils.isEmpty(this.aAM.roomId) || !this.aAM.roomId.equals(str)) ? false : true;
    }

    public void BB() {
        Bw();
        Bx();
    }

    public void release() {
        c.d(" BMLSignalRtcSyncManager  release ");
        c.fJ(" BMLSignalRtcSyncManager  release ");
        this.aAN = null;
        this.aAl = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.aAE != null) {
            this.aAE.release();
            this.aAE = null;
        }
        if (this.aAJ != null) {
            this.aAJ.release();
            this.aAJ = null;
        }
        if (this.aAL != null) {
            this.aAL.release();
        }
        c.Bg();
        BA();
        BB();
    }

    @Override // com.baidu.live.alablmsdk.a.c.a
    public void fI(String str) {
        if (this.aAl != null) {
            this.aAl.fI(str);
        }
    }
}
