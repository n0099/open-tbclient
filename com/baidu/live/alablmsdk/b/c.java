package com.baidu.live.alablmsdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickResSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMSyncRtcInfo;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.live.alablmsdk.a.b;
import com.baidu.live.alablmsdk.a.f;
import com.baidu.live.alablmsdk.b.b;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.d;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements BIMRtcListener, IConnectListener, ILiveMsgReceiveListener, b.a, b.a, com.baidu.live.alablmsdk.c.b.a {
    private com.baidu.live.alablmsdk.c.b ayF;
    private com.baidu.live.alablmsdk.c.c azA;
    private com.baidu.live.alablmsdk.e.b azk;
    public com.baidu.live.alablmsdk.module.a azp;
    private a azv;
    private b azw;
    private com.baidu.live.alablmsdk.d.c azx;
    private com.baidu.live.alablmsdk.d.b azy;
    private com.baidu.live.alablmsdk.d.a azz;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a(this);
        this.azk = new com.baidu.live.alablmsdk.e.b(context, this);
        this.azv = new a(this.azk);
        this.azv.AO();
        this.azw = new b(this);
        this.azx = new com.baidu.live.alablmsdk.d.c(context);
        this.azx.a(this);
        this.azy = new com.baidu.live.alablmsdk.d.b(this.azx);
        this.azz = new com.baidu.live.alablmsdk.d.a(context, this.azx);
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.ayF = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        this.azw.w(hashMap);
        this.azx.v(hashMap);
        this.azk.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.azx.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Av() {
        return this.azz;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.azk.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    com.baidu.live.alablmsdk.a.b.d("createRoom onResult responseCode = " + i + " , errorMessage = " + str);
                    com.baidu.live.alablmsdk.a.b.fD("createRoom onResult code " + i + " message " + str);
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        com.baidu.live.alablmsdk.a.b.d("createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        c.this.b(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId);
                        c.this.azk.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                com.baidu.live.alablmsdk.a.b.d(" signal join onResult , responseCode=" + i2 + " , errorMessage=" + str2);
                                com.baidu.live.alablmsdk.a.b.fD(" signal join onResult code " + i2 + " message " + str2);
                                if (i2 == 0) {
                                    if (c.this.azp != null) {
                                        c.this.azp.a(BLMSignalState.JOINED);
                                    }
                                    aVar.c(bIMRTCGetTokeResult.roomId, 0, "create signal room suc");
                                    return;
                                }
                                aVar.c("", -1, "join signal room fail responseCode=" + i2 + " errorMessage=" + str2);
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
        this.azp = new com.baidu.live.alablmsdk.module.a();
        this.azp.roomId = str;
        this.azp.token = str2;
        this.azp.rtcAppId = str3;
        this.azp.azK = j;
        d dVar = new d();
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.azK = j;
        cVar.azP = UserPermission.OWNER;
        dVar.azS = cVar;
        this.azp.azL = dVar;
        if (this.azv != null) {
            a aVar = this.azv;
            a.fE(this.azp.roomId);
            this.azv.a(str, this.azp.AZ());
        }
        com.baidu.live.alablmsdk.module.b.Bg().c(this.azp);
        if (this.azw != null) {
            this.azw.a(this.azp);
        }
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.azk.c(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.3
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str2) {
                if (cVar != null) {
                    cVar.e(i, i2, str2);
                }
            }
        });
    }

    public void b(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.azk.d(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.4
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str2) {
                if ((i2 == 0 || i2 == -1) && c.this.azp != null) {
                    c.this.azp.t(list);
                    if (c.this.azp.Bc()) {
                        c.this.AX();
                    }
                }
                if (cVar != null) {
                    cVar.e(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.ag(" acceptRoom ", " , extJson=" + jSONObject);
        this.azk.e(str, n(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str2) {
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.Bg().a(str, BLMSignalState.JOINED);
                    c.this.b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void e(int i3, int i4, String str3) {
                            com.baidu.live.alablmsdk.a.b.d(" visiter join room， status=" + i4 + " , msg" + str3);
                            com.baidu.live.alablmsdk.a.b.fD(" visiter join room， status " + i4 + " msg " + str3);
                            if (i4 == 0) {
                                com.baidu.live.alablmsdk.module.b.Bg().a(str, BLMRtcState.JOINED);
                                if (cVar != null) {
                                    cVar.e(4, 0, "acceptRoom join rtc room success");
                                    return;
                                }
                                return;
                            }
                            com.baidu.live.alablmsdk.module.b.Bg().a(str, BLMRtcState.FAIL);
                            c.this.fF(str);
                            com.baidu.live.alablmsdk.a.b.d("acceptRoom join rtc room error ; msg = " + str3);
                            com.baidu.live.alablmsdk.a.b.fD("acceptRoom join rtc room error msg " + str3);
                            if (cVar != null) {
                                cVar.e(4, -1, "acceptRoom join rtc room error ; msg = " + str3);
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.d("acceptRoom join signal room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.fD("acceptRoom join signal room error msg " + str2);
                c.this.AX();
                if (cVar != null) {
                    cVar.e(4, -1, "acceptRoom join signal room error ; msg = " + str2);
                }
            }
        });
    }

    private JSONObject n(JSONObject jSONObject) {
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        if (this.azp != null && this.azp.azL != null && this.azp.azL.azS != null) {
            com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
            bVar.azK = this.azp.azL.azS.azK;
            bVar.order = this.azp.azL.azS.order;
            aVar.azY = com.baidu.live.alablmsdk.module.a.b.a(bVar);
        }
        JSONObject n = aVar.n(jSONObject);
        if (n == null) {
            return new JSONObject();
        }
        return n;
    }

    public void b(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.azk.f(str, n(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.6
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str2) {
                c.this.AX();
                if (cVar != null) {
                    cVar.e(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, com.baidu.live.alablmsdk.module.c cVar, final com.baidu.live.alablmsdk.c.c cVar2) {
        a(cVar);
        b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.7
            @Override // com.baidu.live.alablmsdk.c.c
            public void e(int i, int i2, String str2) {
                com.baidu.live.alablmsdk.a.b.d(" owner join room， status=" + i2 + " , msg" + str2);
                com.baidu.live.alablmsdk.a.b.fD(" owner join room status " + i2 + " msg" + str2);
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.Bg().a(str, BLMRtcState.JOINED);
                    if (cVar2 != null) {
                        cVar2.e(4, 0, "acceptRoom join rtc room success");
                        return;
                    }
                    return;
                }
                com.baidu.live.alablmsdk.module.b.Bg().a(str, BLMRtcState.FAIL);
                c.this.d(str, (JSONObject) null, (com.baidu.live.alablmsdk.c.c) null);
                com.baidu.live.alablmsdk.a.b.d("acceptRoom join rtc room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.fD("acceptRoom join rtc room error msg " + str2);
                if (cVar2 != null) {
                    cVar2.e(4, -1, "acceptRoom join rtc room error ; msg = " + str2);
                }
            }
        });
    }

    private void a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null && this.azp != null && this.azp.azL != null && this.azp.azL.azS != null) {
            this.azp.azL.azS.order = cVar.order;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.module.c Bd;
        this.azA = cVar;
        com.baidu.live.alablmsdk.module.a fH = com.baidu.live.alablmsdk.module.b.Bg().fH(str);
        if (fH == null) {
            com.baidu.live.alablmsdk.a.b.ag("joinRoom param error getChatInfo null ", "");
            if (this.azA != null) {
                this.azA.e(6, 1000, "join rtc room param error , getChatInfo null");
            }
        } else if (!com.baidu.live.alablmsdk.module.a.b(fH)) {
            com.baidu.live.alablmsdk.a.b.ag("joinRoom chatInfo check error", "");
            if (this.azA != null) {
                this.azA.e(6, 1000, "joinRoom chatInfo check error");
            }
        } else {
            if (this.azp != null && (Bd = this.azp.Bd()) != null && !TextUtils.isEmpty(Bd.order)) {
                this.azx.fL(Bd.order);
            }
            this.azx.c(str, fH.token, fH.rtcAppId, fH.azK);
        }
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        if (this.azx != null && !TextUtils.isEmpty(this.azx.Br()) && this.azx.Br().equals(str) && !com.baidu.live.alablmsdk.a.a.isEmpty(list) && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.module.c cVar2 = list.get(0);
            this.azx.ai(cVar2.azK);
            this.azk.a(str, cVar2, n(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.8
                @Override // com.baidu.live.alablmsdk.c.c
                public void e(int i, int i2, String str2) {
                }
            });
            if (cVar != null) {
                cVar.e(9, 0, "kick off user send");
            }
        } else if (cVar != null) {
            cVar.e(9, -1, "room or user check error");
        }
    }

    public void ba(boolean z) {
        if (this.azy != null) {
            com.baidu.live.alablmsdk.a.b.d("muteMicrophone " + z);
            com.baidu.live.alablmsdk.a.b.fD("muteMicrophone " + z);
            this.azy.ba(z);
        }
    }

    private void AV() {
        com.baidu.live.alablmsdk.a.b.ag(" currentKickedOffLeave ", "");
        if (this.azx != null) {
            this.azx.Bw();
        }
        AY();
        AX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(String str) {
        c(str, com.baidu.live.alablmsdk.module.a.a.Bn(), (com.baidu.live.alablmsdk.c.c) null);
    }

    public void c(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d(" leaveRoom");
        com.baidu.live.alablmsdk.a.b.fD(" leaveRoom ");
        this.azx.Bw();
        this.azk.a(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.d(" leaveRoom onResult ，responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.fD(" leaveRoom onResult code " + i + " message " + str2);
                if (i == 0) {
                    if (c.this.azv != null) {
                        c.this.azv.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (cVar != null) {
                        cVar.e(7, 0, "leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (c.this.azv != null) {
                    c.this.azv.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (cVar != null) {
                    cVar.e(7, -1, "leaveRoom hangout signal fail");
                }
            }
        });
        AY();
        AX();
    }

    public void d(final String str, final JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d(" closeRoom roomId=" + str);
        com.baidu.live.alablmsdk.a.b.fD(" closeRoom roomId " + str);
        com.baidu.live.alablmsdk.module.a fH = com.baidu.live.alablmsdk.module.b.Bg().fH(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (fH != null) {
            userPermission = fH.AZ();
        }
        com.baidu.live.alablmsdk.a.b.d(" closeRoom permission=" + userPermission);
        com.baidu.live.alablmsdk.a.b.fD(" closeRoom permission " + userPermission);
        if (userPermission == UserPermission.OWNER) {
            this.azx.Bv();
        } else {
            this.azx.Bw();
        }
        this.azk.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.d(" closeRoom-signal hangout  responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.fD(" closeRoom-signal hangout code " + i + " errorMessage " + str2);
                if (userPermission == UserPermission.OWNER) {
                    com.baidu.live.alablmsdk.a.b.d(" signal close ");
                    com.baidu.live.alablmsdk.a.b.fD(" signal close ");
                    c.this.azk.b(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str3) {
                            com.baidu.live.alablmsdk.a.b.d(" signal closeRoom , responseCode=" + i2 + " , errorMessage=" + str3);
                            com.baidu.live.alablmsdk.a.b.fD(" signal closeRoom code " + i2 + " errorMessage " + str3);
                            if (i2 == 0) {
                                if (c.this.azv != null) {
                                    c.this.azv.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (cVar != null) {
                                    cVar.e(8, 0, "closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (c.this.azv != null) {
                                c.this.azv.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (cVar != null) {
                                cVar.e(8, -1, "closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        AX();
        AY();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        com.baidu.live.alablmsdk.a.b.d(" b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        com.baidu.live.alablmsdk.a.b.d(" im 连接状态 responseCode = " + i);
        com.baidu.live.alablmsdk.a.b.fD(" im long connection code " + i);
        dt(i);
    }

    private void dt(int i) {
        if (i == 0) {
            if (this.azp != null) {
                AW();
            } else if (this.azp == null) {
                this.azv.AN();
            }
        }
    }

    private void AW() {
        com.baidu.live.alablmsdk.a.b.ag(" reJoinSignalAndRtcRoomInner ", "");
        if (this.azp != null) {
            this.azk.join(this.azp.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    com.baidu.live.alablmsdk.a.b.ag(" reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str, "");
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.ag(" reJoinSignalAndRtcRoomInner signal join success", "");
                        c.this.azx.BB();
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.ag(" reJoinSignalAndRtcRoomInner signal join fail", "");
                }
            });
        } else {
            com.baidu.live.alablmsdk.a.b.ag(" reJoinSignalAndRtcRoomInner mCurrentChatInfo==null", "");
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
        if (i == 89) {
            com.baidu.live.alablmsdk.a.b.d(" signal onRtcResult room closed ");
            com.baidu.live.alablmsdk.a.b.fD(" signal onRtcResult room closed ");
            String str = "";
            if (bIMRtcInfo != null) {
                str = bIMRtcInfo.getRtcRoomId();
            }
            if (this.azp != null && !TextUtils.isEmpty(this.azp.roomId) && this.azp.roomId.equals(str)) {
                AX();
            }
            if (this.ayF != null) {
                com.baidu.live.alablmsdk.a.b.d(" room closed callback ,  roomId=" + str);
                com.baidu.live.alablmsdk.a.b.fD(" room closed callback roomId " + str);
                this.ayF.fB(str);
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
                cVar.azK = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        com.baidu.live.alablmsdk.a.b.ag(" caller invite time out", " , other imUk=" + cVar.azK);
        if (this.azp != null && this.azp.Ba()) {
            if (this.azp.ad(cVar.azK)) {
                com.baidu.live.alablmsdk.module.b.Bg().a(str, cVar.azK, BLMSignalState.TIMEOUT);
                if (this.ayF != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" caller invite time out callback ", "");
                    this.ayF.a(str, cVar);
                    return;
                }
                return;
            } else if (this.ayF != null) {
                com.baidu.live.alablmsdk.a.b.ag(" caller invite time out, check imUk error, but callback ", "");
                this.ayF.a(str, cVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.ag(" caller invite time out not callback ", "");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerGetAnswerSyncByCallee(int i, BIMRtcInfo bIMRtcInfo) {
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        JSONObject jSONObject = null;
        com.baidu.live.alablmsdk.a.b.ag(" roomCallerGetAnswerSyncByCallee ", "");
        long j = 0;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.d(" roomCallerGetAnswerSyncByCallee ext=" + rtcExt);
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.fI(rtcExt);
            } else {
                aVar = null;
            }
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                BIMSyncRtcInfo bIMSyncRtcInfo = (BIMSyncRtcInfo) bIMRtcInfo;
                j = bIMSyncRtcInfo.getInitiatorUk();
                cVar.azK = bIMSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (!TextUtils.isEmpty(rtcRoomId) && this.azp != null && !TextUtils.isEmpty(this.azp.roomId) && this.azp.roomId.equals(rtcRoomId)) {
                    d dVar = new d();
                    dVar.azS = cVar.clone();
                    this.azp.a(dVar, BLMStateType.SIGNAL);
                }
                com.baidu.live.alablmsdk.a.b.ag(" caller receive callee response", " callee 的 uk=" + cVar.azK);
            }
            str = rtcRoomId;
        } else {
            str = null;
        }
        if (i == 1) {
            com.baidu.live.alablmsdk.a.b.ag(" caller，callee answer ok", "");
            com.baidu.live.alablmsdk.module.b.Bg().a(str, j, BLMSignalState.JOINED);
            if (this.ayF != null) {
                com.baidu.live.alablmsdk.a.b.ag(" caller，callee answer ok callback", "");
                this.ayF.d(str, cVar, jSONObject);
            }
        } else if (i == 2) {
            com.baidu.live.alablmsdk.a.b.ag(" caller，callee answer no", "");
            com.baidu.live.alablmsdk.module.b.Bg().a(str, j, BLMSignalState.REJECT);
            if (this.ayF != null) {
                com.baidu.live.alablmsdk.a.b.ag(" caller，callee answer no callback", "");
                this.ayF.e(str, cVar, jSONObject);
            }
        } else if (i == 3) {
            com.baidu.live.alablmsdk.a.b.ag(" caller，callee answer timeout 30s", "");
            com.baidu.live.alablmsdk.module.b.Bg().a(str, j, BLMSignalState.TIMEOUT);
            if (this.ayF != null) {
                com.baidu.live.alablmsdk.a.b.ag(" caller，callee answer timeout 30s callback", "");
                this.ayF.a(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.a.b.d(" 被叫方接收到邀请(解析 rtc room 的相关信息，");
        com.baidu.live.alablmsdk.a.b.fD(" callee receive invite ");
        if (bIMRtcInfo != null && (bIMRtcInfo instanceof BIMInviteSyncRtcInfo)) {
            BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = (BIMInviteSyncRtcInfo) bIMRtcInfo;
            String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
            com.baidu.live.alablmsdk.a.b.ag(" callee receive invite roomId " + rtcRoomId, "");
            if (!TextUtils.isEmpty(rtcRoomId)) {
                if (this.azp != null && this.azp.roomId != null && !this.azp.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.a.b.d(" callee get invite. mCurrentChatInfo.roomId != roomId , return。  mCurrentChatInfo.roomId=" + this.azp.roomId);
                    com.baidu.live.alablmsdk.a.b.fD(" callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.azp.roomId);
                    return;
                }
                String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
                com.baidu.live.alablmsdk.a.b.d(" callee receive invite,  originalExt=" + rtcExt);
                com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
                JSONObject fI = aVar.fI(rtcExt);
                com.baidu.live.alablmsdk.module.a fH = com.baidu.live.alablmsdk.module.b.Bg().fH(rtcRoomId);
                if (fH == null) {
                    fH = new com.baidu.live.alablmsdk.module.a();
                }
                fH.roomId = rtcRoomId;
                fH.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                fH.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                fH.azK = bIMInviteSyncRtcInfo.getRtcUserId();
                d dVar = new d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = fH.azK;
                cVar.azP = UserPermission.VISITER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                dVar.azS = cVar;
                dVar.b(BLMSignalState.RING);
                fH.azL = dVar;
                d dVar2 = new d();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.azK = bIMInviteSyncRtcInfo.getInitiatorUk();
                cVar2.azP = UserPermission.OWNER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar2, aVar);
                dVar2.azS = cVar2;
                dVar2.b(BLMSignalState.JOINED);
                fH.a(dVar2, BLMStateType.SIGNAL);
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d("callee 收到邀请 ， " + fH.Bb());
                }
                this.azp = fH;
                com.baidu.live.alablmsdk.module.b.Bg().c(fH);
                if (this.azw != null) {
                    this.azw.a(this.azp);
                }
                if (this.azv != null) {
                    a aVar2 = this.azv;
                    a.fE(fH.roomId);
                    this.azv.a(fH.roomId, fH.AZ());
                }
                com.baidu.live.alablmsdk.module.c clone = cVar2.clone();
                if (this.ayF != null) {
                    this.ayF.b(rtcRoomId, clone, fI);
                }
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        String str = null;
        com.baidu.live.alablmsdk.module.a.a aVar = null;
        com.baidu.live.alablmsdk.a.b.ag(" callee,  caller cancel invite ", "");
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.fI(rtcExt);
            } else {
                jSONObject = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.azK = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
        }
        if (this.azp != null && this.azp.Ba() && !TextUtils.isEmpty(this.azp.roomId) && this.azp.roomId.equals(str) && this.azp.ad(cVar.azK)) {
            AX();
            if (this.ayF != null) {
                this.ayF.c(str, cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.Bg().a(bIMRtcInfo.getRtcRoomId(), BLMSignalState.DEFAULT);
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerByFromOtherCallee(int i, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventSyncByOthers(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.module.c ac;
        JSONObject jSONObject = null;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo == null) {
            str = "";
            aVar = null;
        } else {
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.d(" 振铃|加入|离开 : roomEventType=" + roomEventType + " , extStr=" + rtcExt);
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.fI(rtcExt);
            } else {
                aVar = null;
            }
            str = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.azK = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (this.azp != null && (ac = this.azp.ac(cVar.azK)) != null && !TextUtils.isEmpty(ac.order)) {
                    cVar.order = ac.order;
                }
            }
        }
        if (com.baidu.live.alablmsdk.a.b.isDebug()) {
            com.baidu.live.alablmsdk.a.b.d(" 对方的事件 : roomEventType=" + roomEventType + "  roomId=" + str + " , imUk=" + cVar.azK);
        }
        com.baidu.live.alablmsdk.a.b.fD("roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str);
        if (fG(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                com.baidu.live.alablmsdk.a.b.ag(" signal： other ringing ", "");
                com.baidu.live.alablmsdk.module.b.Bg().a(str, cVar.azK, BLMSignalState.RING);
                if (this.ayF != null) {
                    this.ayF.a(str, cVar, jSONObject);
                    return;
                }
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.JOIN_ROOM) {
                com.baidu.live.alablmsdk.a.b.ag(" signal： other join signal room", "");
                e(str, cVar);
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.EXIT_ROOM) {
                com.baidu.live.alablmsdk.a.b.ag(" signal： other exit signal room", "");
                a(str, cVar, aVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.ag(" not current room chart do nothing", "");
    }

    private void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.a fH;
        if (cVar != null && (fH = com.baidu.live.alablmsdk.module.b.Bg().fH(str)) != null) {
            d dVar = new d();
            dVar.azS = cVar.clone();
            dVar.b(BLMSignalState.JOINED);
            fH.a(dVar, BLMStateType.SIGNAL);
        }
    }

    private void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.module.a.a aVar) {
        if (cVar != null) {
            com.baidu.live.alablmsdk.a.b.ag("handleSignalUserLeave roomId " + str, " , callbackUser = " + cVar.toString());
            if (this.azp != null && !TextUtils.isEmpty(this.azp.roomId) && this.azp.roomId.equals(str) && this.azp.Ba()) {
                com.baidu.live.alablmsdk.a.b.ag(" handleSignalUserLeave ，remove otherImUk ", "");
                this.azp.aa(cVar.azK);
                if (aVar != null && aVar.azZ) {
                    com.baidu.live.alablmsdk.a.b.ag(" handleSignalUserLeave ，hasStatusCheckInfoKey reture ", "");
                } else if (this.ayF != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" handleSignalUserLeave ，onRoomUserLeaved callback ", "");
                    this.ayF.c(str, cVar);
                }
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

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public int roomKickedUserFromKickerSync(BIMKickReqSyncRtcInfo bIMKickReqSyncRtcInfo) {
        long j;
        com.baidu.live.alablmsdk.module.c Bd;
        com.baidu.live.alablmsdk.a.b.ag(" roomKickedUserFromKickerSync ", "");
        if (bIMKickReqSyncRtcInfo != null) {
            try {
                j = bIMKickReqSyncRtcInfo.getBIMKickedUsers().uk;
                try {
                    com.baidu.live.alablmsdk.a.b.ag(" roomKickedUserFromKickerSync kickedImUk=" + j, "");
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                j = 0;
            }
            if (this.azp != null && (Bd = this.azp.Bd()) != null && Bd.azK != 0 && Bd.azK == j) {
                X(j);
                return 1;
            }
        }
        return 0;
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo) {
        com.baidu.live.alablmsdk.a.b.ag(" roomEventKickedStatusByKickedUser ", "");
        if (bIMKickResSyncRtcInfo != null) {
            long j = 0;
            try {
                j = bIMKickResSyncRtcInfo.getBIMKickedUsers().uk;
                com.baidu.live.alablmsdk.a.b.ag(" roomEventKickedStatusByKickedUser kickedThirdUserId=" + j, "");
            } catch (Exception e) {
            }
            Y(j);
        }
    }

    private void X(long j) {
        String str;
        com.baidu.live.alablmsdk.module.c cVar = null;
        com.baidu.live.alablmsdk.a.b.fD(" handleCurrentUserKicked ");
        if (this.azp != null) {
            str = this.azp.roomId;
            com.baidu.live.alablmsdk.module.c Bd = this.azp.Bd();
            if (Bd != null) {
                cVar = Bd.clone();
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = j;
            }
        } else {
            str = null;
        }
        AV();
        if (this.ayF != null) {
            com.baidu.live.alablmsdk.a.b.ag(" current, onRoomUserKickoffed call back", "");
            this.ayF.d(str, cVar);
        }
    }

    private void Y(long j) {
        String str;
        com.baidu.live.alablmsdk.module.c cVar = null;
        com.baidu.live.alablmsdk.a.b.ag(" handleOtherUserKicked uk=" + j, "");
        if (this.azp != null) {
            str = this.azp.roomId;
            com.baidu.live.alablmsdk.module.c ac = this.azp.ac(j);
            if (ac != null) {
                cVar = ac.clone();
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = j;
            }
        } else {
            str = null;
        }
        if (this.azp != null) {
            this.azp.aa(j);
        }
        if (this.ayF != null) {
            com.baidu.live.alablmsdk.a.b.ag(" other, onRoomUserKickoffed call back", "");
            this.ayF.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void du(int i) {
        com.baidu.live.alablmsdk.a.b.ag(" onRtcCurrentUserStreamChange status " + i, "");
        if (i == 2) {
            this.azw.AS();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void g(int i, String str) {
        if (i == 0) {
            com.baidu.live.alablmsdk.a.b.ag(" onRtcCurrentUserJoinRoomStatus success msg " + str, "");
            this.azw.AT();
            if (this.azA != null) {
                this.azA.e(6, 0, str);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.ag(" onRtcCurrentUserJoinRoomStatus fail msg " + str, "");
        if (this.azA != null) {
            this.azA.e(6, -1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void onRoomEventUpdate(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.ag(" rtc onRoomEventUpdate roomEvents " + i, " , imUK=" + j + " , extra_info=" + str);
        a(i, j, str);
    }

    private void a(int i, long j, String str) {
        if (this.azp != null) {
            if (!TextUtils.isEmpty(this.azp.roomId)) {
                if (this.azp.Ba()) {
                    if (this.azp.Z(j) || (j == 0 && i == 100)) {
                        b(i, j, str);
                        return;
                    }
                    c(i, j, str);
                    if (this.azp.ad(j)) {
                        d(i, j, str);
                        return;
                    } else {
                        e(i, j, str);
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.ag(" handleRtc hasStartedTransaction is false ", "imUk=" + j);
                return;
            }
            com.baidu.live.alablmsdk.a.b.ag(" handleRtc mCurrentChatInfo.roomId is empty", "imUk=" + j);
            return;
        }
        com.baidu.live.alablmsdk.a.b.ag(" handleRtc mCurrentChatInfo is null", "imUk=" + j);
    }

    private void b(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.ag(" handleRtcCurrentUser ", "imUk=" + j + "  extraInfo=" + str);
        if (this.azp == null) {
            com.baidu.live.alablmsdk.a.b.ag(" handleRtcCurrentUser mCurrentChatInfo info error", "");
        } else if (i == 100) {
            if (this.azp.azL != null && this.azp.azL.azS != null && !TextUtils.isEmpty(this.azp.azL.azS.order)) {
                String b = com.baidu.live.alablmsdk.module.a.b.b(this.azp.azL.azS);
                this.azx.setUserAttribute(b);
                com.baidu.live.alablmsdk.a.b.d(" setUserAttribute " + b);
            }
        } else if (i == 115) {
            com.baidu.live.alablmsdk.a.b.ag("rtc current user kicked ，do rtc leave room ", "");
            this.azx.Bw();
        }
    }

    private void c(int i, long j, String str) {
        if (i == 300 && this.azp.AZ() == UserPermission.VISITER) {
            if (this.azp.ab(j) == null) {
                com.baidu.live.alablmsdk.a.b.fD(" not current user, permission is visiter, add other list");
                d dVar = new d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = j;
                dVar.azS = cVar;
                dVar.b(BLMRtcState.JOINED);
                this.azp.a(dVar, BLMStateType.RTC);
                return;
            }
            com.baidu.live.alablmsdk.a.b.fD(" not current user, permission is visiter, has include the other");
        }
    }

    private void d(int i, long j, String str) {
        com.baidu.live.alablmsdk.module.c cVar;
        com.baidu.live.alablmsdk.a.b.ag(" handleRtcHasIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
        if (j != 0 && this.azp != null) {
            com.baidu.live.alablmsdk.module.c ac = this.azp.ac(j);
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.azK = j;
            if (ac != null) {
                aVar.order = ac.order;
            }
            com.baidu.live.alablmsdk.a.b.ag(" current transaction  yes ", "");
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.ag("remote join  invite join or reJoin rtc", "");
                if (this.ayF != null) {
                    if (ac != null) {
                        cVar = ac.clone();
                    } else {
                        cVar = new com.baidu.live.alablmsdk.module.c();
                        cVar.azK = j;
                    }
                    this.ayF.b(this.azp.roomId, cVar);
                }
            } else if (i == 303) {
                com.baidu.live.alablmsdk.a.b.ag("rtc remote attribute arrive", "");
                if (this.azp != null) {
                    this.azp.c(j, str);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.ag("rtc remote user leave", "");
            } else if (i == 106) {
                String str2 = "";
                if (aVar != null) {
                    str2 = aVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.ag("rtc remote stream arrival , streamInfo=" + str2, "");
                if (this.azz != null) {
                    this.azz.b(true, j);
                }
                if (this.ayF != null) {
                    this.ayF.a(aVar, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                }
                this.azw.W(j);
            } else if (i == 107) {
                com.baidu.live.alablmsdk.a.b.ag("rtc remote stream leave", "");
                if (this.ayF != null) {
                    this.ayF.a(aVar, BLMStreamState.BLMSTREAMSTATE_REMOVE);
                }
                this.azw.V(j);
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.ag("rtc other user kicked, include  don nothing", "imUk = " + j);
            }
        }
    }

    public void e(int i, long j, String str) {
        if (j != 0) {
            com.baidu.live.alablmsdk.a.b.ag(" handleRtcHasNotIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.ag("remote join :  invite join or reJoin rtc", "");
                if (this.azp.AZ() == UserPermission.OWNER && this.azx != null) {
                    this.azx.ai(j);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.ag("remote user leave", "");
            } else if (i == 106) {
                com.baidu.live.alablmsdk.a.b.ag("remote stream arrival", "");
                if (this.azp.AZ() == UserPermission.OWNER && this.azx != null) {
                    this.azx.ai(j);
                }
            } else if (i == 107) {
                com.baidu.live.alablmsdk.a.b.ag("remote stream leave", "");
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.ag(" un include, other user kicked ", "imUk = " + j);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.b.b.a
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.ayF != null) {
            this.ayF.a(aVar, i);
        }
    }

    public void AX() {
        com.baidu.live.alablmsdk.a.b.ag(" resetCurrentChat ", "");
        this.azp = null;
        com.baidu.live.alablmsdk.module.b.Bg().clearAll();
    }

    public boolean fG(String str) {
        return (this.azp == null || TextUtils.isEmpty(this.azp.roomId) || !this.azp.roomId.equals(str)) ? false : true;
    }

    public void AY() {
        com.baidu.live.alablmsdk.a.b.ag("stop all stream leave count down", "");
        this.azw.AU();
        this.azw.AT();
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.d(" BMLSignalRtcSyncManager  release ");
        com.baidu.live.alablmsdk.a.b.fD(" BMLSignalRtcSyncManager  release ");
        this.azA = null;
        this.ayF = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.azk != null) {
            this.azk.release();
            this.azk = null;
        }
        if (this.azw != null) {
            this.azw.release();
        }
        if (this.azx != null) {
            this.azx.release();
            this.azx = null;
        }
        if (this.azz != null) {
            this.azz.release();
        }
        if (this.azv != null) {
            this.azv.release();
        }
        com.baidu.live.alablmsdk.a.b.Aw();
        AX();
        AY();
        f.AA().release();
    }

    @Override // com.baidu.live.alablmsdk.a.b.a
    public void fC(String str) {
        if (this.ayF != null) {
            this.ayF.fC(str);
        }
    }
}
