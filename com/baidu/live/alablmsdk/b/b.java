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
    private com.baidu.live.alablmsdk.e.b aAJ;
    private a aAN;
    private com.baidu.live.alablmsdk.d.c aAO;
    private com.baidu.live.alablmsdk.d.b aAP;
    private com.baidu.live.alablmsdk.d.a aAQ;
    public com.baidu.live.alablmsdk.module.a aAR;
    private com.baidu.live.alablmsdk.c.c aAS;
    private com.baidu.live.alablmsdk.a.b aAT;
    private com.baidu.live.alablmsdk.a.b aAU;
    private List<Integer> aAV;
    private List<com.baidu.live.alablmsdk.module.rtc.b> aAW = new ArrayList();
    private int aAX;
    private int aAY;
    private com.baidu.live.alablmsdk.c.b aAq;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        c.a(this);
        this.aAJ = new com.baidu.live.alablmsdk.e.b(context, this);
        this.aAN = new a(this.aAJ);
        this.aAN.Bs();
        this.aAO = new com.baidu.live.alablmsdk.d.c(context);
        this.aAO.a(this);
        this.aAP = new com.baidu.live.alablmsdk.d.b(this.aAO);
        this.aAQ = new com.baidu.live.alablmsdk.d.a(context, this.aAO);
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aAq = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        w(hashMap);
        this.aAO.v(hashMap);
        this.aAJ.v(hashMap);
    }

    private void w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.aAV = (List) obj;
            Collections.sort(this.aAV);
            Collections.reverse(this.aAV);
            Bt();
        }
    }

    private void Bt() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aAV)) {
            for (int i = 0; i < this.aAV.size(); i++) {
                com.baidu.live.alablmsdk.module.rtc.b bVar = new com.baidu.live.alablmsdk.module.rtc.b();
                bVar.time = this.aAV.get(i).intValue();
                bVar.aBs = false;
                this.aAW.add(bVar);
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aAO.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Be() {
        return this.aAQ;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.aAJ.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.b.1
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
                        b.this.aAJ.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.1.1
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
        this.aAR = new com.baidu.live.alablmsdk.module.a();
        this.aAR.roomId = str;
        this.aAR.token = str2;
        this.aAR.rtcAppId = str3;
        this.aAR.aBi = j;
        this.aAR.aBj = UserPermission.OWNER;
        if (this.aAN != null) {
            this.aAN.a(str, this.aAR.aBj);
        }
        com.baidu.live.alablmsdk.module.b.BE().b(this.aAR);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.INVITING);
        this.aAJ.c(str, list, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.4
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str3) {
                if (cVar != null) {
                    cVar.f(i, i2, str3);
                }
            }
        });
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAJ.d(str, list, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.5
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str3) {
                if (i2 == 0 || i2 == -1) {
                    b.this.BA();
                }
                if (cVar != null) {
                    cVar.f(i, i2, str3);
                }
            }
        });
    }

    public void a(final String str, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAJ.e(str, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.6
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str3) {
                if (i2 == 0) {
                    b.this.b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.6.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void f(int i3, int i4, String str4) {
                            c.d(" visiter join room， status=" + i4 + " , msg" + str4);
                            c.fJ(" visiter join room， status " + i4 + " msg " + str4);
                            if (i4 != 0) {
                                b.this.c(str, b.this.Bu(), null);
                                c.d("acceptRoom join rtc room error ; msg = " + str4);
                                c.fJ("acceptRoom join rtc room error msg " + str4);
                                if (cVar != null) {
                                    cVar.f(4, -1, "acceptRoom join rtc room error ; msg = " + str4);
                                    return;
                                }
                                return;
                            }
                            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.CONNECTED);
                            if (cVar != null) {
                                cVar.f(4, 0, "acceptRoom join rtc room success");
                            }
                        }
                    });
                    return;
                }
                c.d("acceptRoom join signal room error ; msg = " + str3);
                c.fJ("acceptRoom join signal room error msg " + str3);
                b.this.BA();
                if (cVar != null) {
                    cVar.f(4, -1, "acceptRoom join signal room error ; msg = " + str3);
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
        this.aAJ.f(str, str2, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.7
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str3) {
                b.this.BA();
                if (cVar != null) {
                    cVar.f(i, i2, str3);
                }
            }
        });
    }

    public void a(final String str, final com.baidu.live.alablmsdk.c.c cVar) {
        b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.b.8
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                c.d(" owner join room， status=" + i2 + " , msg" + str2);
                c.fJ(" owner join room status " + i2 + " msg" + str2);
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.CONNECTED);
                    if (cVar != null) {
                        cVar.f(4, 0, "acceptRoom join rtc room success");
                        return;
                    }
                    return;
                }
                b.this.d(str, "", null);
                c.d("acceptRoom join rtc room error ; msg = " + str2);
                c.fJ("acceptRoom join rtc room error msg " + str2);
                if (cVar != null) {
                    cVar.f(4, -1, "acceptRoom join rtc room error ; msg = " + str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, com.baidu.live.alablmsdk.c.c cVar) {
        this.aAS = cVar;
        com.baidu.live.alablmsdk.module.a fL = com.baidu.live.alablmsdk.module.b.BE().fL(str);
        if (fL == null) {
            c.d("joinRoom param error , getChatInfo null ");
            c.fJ("joinRoom param error getChatInfo null ");
            if (this.aAS != null) {
                this.aAS.f(6, 1000, "join rtc room param error , getChatInfo null");
            }
        } else if (!com.baidu.live.alablmsdk.module.a.a(fL)) {
            c.d("joinRoom chatInfo check error");
            c.fJ("joinRoom chatInfo check error");
            if (this.aAS != null) {
                this.aAS.f(6, 1000, "joinRoom chatInfo check error");
            }
        } else {
            this.aAQ.BI();
            this.aAQ.b(true, fL.aBk);
            this.aAQ.BG();
            this.aAO.c(str, fL.token, fL.rtcAppId, fL.aBi);
        }
    }

    public void aY(boolean z) {
        if (this.aAP != null) {
            c.d("muteMicrophone " + z);
            c.fJ("muteMicrophone " + z);
            this.aAP.aY(z);
        }
    }

    public void c(String str, String str2, final com.baidu.live.alablmsdk.c.c cVar) {
        c.d(" leaveRoom ext" + str2);
        c.fJ(" leaveRoom ");
        this.aAO.BP();
        this.aAJ.a(str, str2, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str3) {
                c.d(" leaveRoom onResult ，responseCode=" + i + " , errorMessage=" + str3);
                c.fJ(" leaveRoom onResult code " + i + " message " + str3);
                if (i == 0) {
                    if (b.this.aAN != null) {
                        b.this.aAN.a(LegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (cVar != null) {
                        cVar.f(7, 0, "leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (b.this.aAN != null) {
                    b.this.aAN.a(LegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (cVar != null) {
                    cVar.f(7, -1, "leaveRoom hangout signal fail");
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
            userPermission = fL.aBj;
        }
        c.d(" closeRoom permission=" + userPermission);
        c.fJ(" closeRoom permission " + userPermission);
        if (userPermission == UserPermission.OWNER) {
            this.aAO.BO();
        } else {
            this.aAO.BP();
        }
        this.aAJ.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str3) {
                c.d(" closeRoom-signal hangout  responseCode=" + i + " , errorMessage=" + str3);
                c.fJ(" closeRoom-signal hangout code " + i + " errorMessage " + str3);
                if (userPermission == UserPermission.OWNER) {
                    c.d(" signal close ");
                    c.fJ(" signal close ");
                    b.this.aAJ.b(str, str2, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.10.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str4) {
                            c.d(" signal closeRoom , responseCode=" + i2 + " , errorMessage=" + str4);
                            c.fJ(" signal closeRoom code " + i2 + " errorMessage " + str4);
                            if (i2 == 0) {
                                if (b.this.aAN != null) {
                                    b.this.aAN.a(LegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (cVar != null) {
                                    cVar.f(8, 0, "closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (b.this.aAN != null) {
                                b.this.aAN.a(LegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (cVar != null) {
                                cVar.f(8, -1, "closeRoom signal success");
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
            if (this.aAR != null) {
                Bv();
            } else if (this.aAR == null) {
                this.aAN.Br();
            }
        }
    }

    private void Bv() {
        c.d(" reJoinSignalAndRtcRoomInner ");
        c.fJ(" reJoinSignalAndRtcRoomInner ");
        if (this.aAR != null) {
            this.aAJ.join(this.aAR.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.b.11
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    c.d(" reJoinSignalAndRtcRoomInner signal join onResult , responseCode=" + i + " , errorMessage=" + str);
                    c.fJ(" reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str);
                    if (i == 0) {
                        c.d(" reJoinSignalAndRtcRoomInner signal join success");
                        c.fJ(" reJoinSignalAndRtcRoomInner signal join success");
                        b.this.aAO.BS();
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
            if (this.aAR != null && !TextUtils.isEmpty(this.aAR.roomId) && this.aAR.roomId.equals(str)) {
                BA();
            }
            if (this.aAq != null) {
                c.d(" room closed callback ,  roomId=" + str);
                c.fJ(" room closed callback roomId " + str);
                this.aAq.fH(str);
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
                cVar.aBi = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        c.d(" caller invite time out, other imUk=" + cVar.aBi);
        c.fJ(" caller invite time out");
        if (this.aAR != null && this.aAR.BC() && this.aAR.aBk == cVar.aBi) {
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.FAIL);
            if (this.aAq != null) {
                c.d(" caller invite time out , callback ");
                c.fJ(" caller invite time out callback ");
                this.aAq.a(str, cVar);
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
                cVar.aBi = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.live.alablmsdk.module.b.BE().fL(str).aBk = cVar.aBi;
                }
                c.d(" caller 收到 callee 的响应 ， callee 的 uk=" + cVar.aBi);
                c.fJ(" caller receive callee response");
            }
            str2 = bIMRtcInfo.getRtcExt();
        }
        if (i == 1) {
            c.d(" caller，callee answer ok");
            c.fJ(" caller，callee answer ok");
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.CONNECTING);
            if (this.aAq != null) {
                c.d(" caller，callee answer ok ， callback");
                c.fJ(" caller，callee answer ok callback");
                this.aAq.d(str, cVar, str2);
            }
        } else if (i == 2) {
            c.d(" caller，callee answer no");
            c.fJ(" caller，callee answer no");
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.REFUSE);
            if (this.aAq != null) {
                c.d(" caller，callee answer no ， callback");
                c.fJ(" caller，callee answer no callback");
                this.aAq.e(str, cVar, str2);
            }
        } else if (i == 3) {
            c.d(" caller，callee answer timeout 30s");
            c.fJ(" caller，callee answer timeout 30s");
            com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.FAIL);
            if (this.aAq != null) {
                c.d(" caller，callee answer timeout 30s ， callback");
                c.fJ(" caller，callee answer timeout 30s callback");
                this.aAq.a(str, cVar);
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
                if (this.aAR != null) {
                    if (this.aAR.roomId != null && !this.aAR.roomId.equals(rtcRoomId)) {
                        c.d(" callee get invite. mCurrentChatInfo.roomId != roomId , return。  mCurrentChatInfo.roomId=" + this.aAR.roomId);
                        c.fJ(" callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.aAR.roomId);
                        return;
                    } else if (this.aAR.BC() && this.aAR.aBk != 0) {
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
                    aVar.aBi = bIMInviteSyncRtcInfo.getRtcUserId();
                    aVar.aBj = UserPermission.VISITER;
                    aVar.aBk = bIMInviteSyncRtcInfo.getInitiatorUk();
                    aVar.a(LinkUserStatus.RING);
                    if (c.isDebug()) {
                        c.d("callee 收到邀请 ， " + aVar.BD());
                    }
                    this.aAR = aVar;
                    com.baidu.live.alablmsdk.module.b.BE().b(aVar);
                    if (this.aAN != null) {
                        this.aAN.a(aVar.roomId, aVar.aBj);
                    }
                }
                cVar.aBi = bIMInviteSyncRtcInfo.getInitiatorUk();
                if (this.aAq != null) {
                    this.aAq.b(rtcRoomId, cVar, rtcExt);
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
                cVar.aBi = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
            str2 = bIMRtcInfo.getRtcExt();
        }
        if (this.aAR != null && this.aAR.BC() && !TextUtils.isEmpty(this.aAR.roomId) && this.aAR.roomId.equals(str) && this.aAR.aBk != 0 && this.aAR.aBk == cVar.aBi) {
            BA();
            if (this.aAq != null) {
                this.aAq.c(str, cVar, str2);
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
                cVar.aBi = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        if (c.isDebug()) {
            c.d(" 对方的事件 : roomEventType=" + roomEventType + "  roomId=" + str + " , imUk=" + (cVar == null ? 0L : cVar.aBi) + " ext=" + str2);
        }
        c.fJ("roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str);
        if (fK(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                c.d(" signal： 对方 ringing ");
                c.fJ(" signal： other ringing ");
                com.baidu.live.alablmsdk.module.b.BE().a(str, LinkUserStatus.RING);
                if (this.aAq != null) {
                    this.aAq.a(str, cVar, str2);
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
            c.d(" handleSignalUserLeave :  roomId=" + str + " , imUk=" + (cVar == null ? 0L : cVar.aBi));
        }
        c.fJ("handleSignalUserLeave roomId " + str);
        if (this.aAR != null && !TextUtils.isEmpty(this.aAR.roomId) && this.aAR.roomId.equals(str) && this.aAR.BC()) {
            c.d(" handleSignalUserLeave ， otherImUk 清除 ");
            Bw();
            this.aAR.aBk = 0L;
            if (this.aAq != null) {
                this.aAq.c(str, cVar);
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
            if (this.aAS != null) {
                this.aAS.f(6, 0, str);
                return;
            }
            return;
        }
        c.d(" onJoinRtcRoomStatus fail msg=" + str);
        c.fJ(" onJoinRtcRoomStatus fail msg " + str);
        if (this.aAS != null) {
            this.aAS.f(6, -1, str);
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
            aVar.aBi = j;
            if (this.aAR != null) {
                if (!TextUtils.isEmpty(this.aAR.roomId)) {
                    if (this.aAR.BC()) {
                        if (this.aAR.aBk == j) {
                            c.d(" 是当前事务用户: yes ");
                            c.fJ(" current transaction  yes ");
                            if (i == 300) {
                                c.d("remote join :  invite join or reJoin rtc");
                                c.fJ("remote join  invite join or reJoin rtc");
                                if (this.aAq != null) {
                                    com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                                    cVar.aBi = j;
                                    this.aAq.b(this.aAR.roomId, cVar);
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
                                if (this.aAq != null) {
                                    this.aAq.a(aVar, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                                }
                                Bw();
                                return;
                            } else if (i == 107) {
                                c.d("remote stream leave");
                                c.fJ("remote stream leave");
                                if (this.aAq != null) {
                                    this.aAq.a(aVar, BLMStreamState.BLMSTREAMSTATE_REMOVE);
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
                            if (this.aAR.aBj == UserPermission.OWNER && this.aAO != null) {
                                this.aAO.W(j);
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
                            if (this.aAR.aBj == UserPermission.OWNER && this.aAO != null) {
                                this.aAO.W(j);
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
        if (this.aAU != null) {
            c.d("leave count down stop");
            c.fJ("leave count down stop");
            this.aAU.cancelTimer();
        }
    }

    private void Bx() {
        if (this.aAT != null) {
            c.d("current user leave count down stop");
            c.fJ("current user leave count down stop");
            this.aAT.cancelTimer();
        }
    }

    private void By() {
        this.aAX = com.baidu.live.alablmsdk.a.a.s(this.aAV);
        if (this.aAX <= 0) {
            this.aAY = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        } else {
            this.aAY = this.aAX * 1000;
        }
    }

    private void a(final com.baidu.live.alablmsdk.module.rtc.a aVar) {
        c.d("leave count down start");
        c.fJ("leave count down start");
        By();
        c.d("leave count down, maxCountDownTime=" + this.aAY);
        c.fJ("leave count down maxCountDownTime " + this.aAY);
        d.Bi().post(new Runnable() { // from class: com.baidu.live.alablmsdk.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.aAU == null) {
                    b.this.aAU = new com.baidu.live.alablmsdk.a.b();
                }
                b.this.aAU.I(aVar);
                b.this.aAU.a(2, b.this.aAY, 1000L, b.this);
            }
        });
    }

    private void Bz() {
        c.d(" current user leave count down start");
        c.fJ(" current user leave count down start");
        By();
        c.d(" current user leave count down, maxCountDownTime=" + this.aAY);
        c.fJ(" current user leave count down maxCountDownTime " + this.aAY);
        d.Bi().post(new Runnable() { // from class: com.baidu.live.alablmsdk.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.aAT == null) {
                    b.this.aAT = new com.baidu.live.alablmsdk.a.b();
                }
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                if (b.this.aAR != null) {
                    aVar.aBi = b.this.aAR.aBi;
                }
                b.this.aAT.I(aVar);
                b.this.aAT.a(1, b.this.aAY, 1000L, b.this);
            }
        });
    }

    @Override // com.baidu.live.alablmsdk.a.b.a
    public void a(int i, long j, Object obj) {
        float f = (float) (this.aAX - (j / 1000));
        c.d(" onTick time = " + f);
        c.fJ(" onTick time " + f);
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aAW)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aAW.size()) {
                    com.baidu.live.alablmsdk.module.rtc.b bVar = this.aAW.get(i3);
                    if (bVar != null && !bVar.aBs && f >= bVar.time && this.aAq != null) {
                        com.baidu.live.alablmsdk.module.rtc.a aVar = null;
                        if (obj instanceof com.baidu.live.alablmsdk.module.rtc.a) {
                            aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
                        }
                        if (c.isDebug()) {
                            c.d(" onTick 回调给上层接口 leavedForSeconds , stream.imUk=" + (aVar == null ? 0L : aVar.aBi) + " time=" + bVar.time);
                        }
                        c.fJ(" onTick callback leavedForSeconds");
                        bVar.aBs = true;
                        this.aAq.a(aVar, bVar.time);
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
        if (this.aAq != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
            }
            int i2 = 0;
            if (this.aAU != null) {
                i2 = (int) this.aAU.Bf();
            }
            if (c.isDebug()) {
                c.d(" onCountDownFinish 回调给上层接口 leavedForSeconds , stream.imUk=" + (aVar == null ? 0L : aVar.aBi) + " finishTime=" + i2);
            }
            c.fJ(" onCountDownFinish callback leavedForSeconds");
            if (this.aAR != null) {
                this.aAR.aBk = 0L;
            }
            this.aAq.a(aVar, i2);
        }
    }

    public void BA() {
        c.d(" resetCurrentChat ");
        c.fJ(" resetCurrentChat ");
        this.aAR = null;
        com.baidu.live.alablmsdk.module.b.BE().clearAll();
    }

    public boolean fK(String str) {
        return (this.aAR == null || TextUtils.isEmpty(this.aAR.roomId) || !this.aAR.roomId.equals(str)) ? false : true;
    }

    public void BB() {
        Bw();
        Bx();
    }

    public void release() {
        c.d(" BMLSignalRtcSyncManager  release ");
        c.fJ(" BMLSignalRtcSyncManager  release ");
        this.aAS = null;
        this.aAq = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.aAJ != null) {
            this.aAJ.release();
            this.aAJ = null;
        }
        if (this.aAO != null) {
            this.aAO.release();
            this.aAO = null;
        }
        if (this.aAQ != null) {
            this.aAQ.release();
        }
        c.Bg();
        BA();
        BB();
    }

    @Override // com.baidu.live.alablmsdk.a.c.a
    public void fI(String str) {
        if (this.aAq != null) {
            this.aAq.fI(str);
        }
    }
}
