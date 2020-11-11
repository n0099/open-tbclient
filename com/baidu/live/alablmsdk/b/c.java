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
    private com.baidu.live.alablmsdk.e.b aAV;
    private com.baidu.live.alablmsdk.c.b aAq;
    public com.baidu.live.alablmsdk.module.a aBa;
    private a aBg;
    private b aBh;
    private com.baidu.live.alablmsdk.d.c aBi;
    private com.baidu.live.alablmsdk.d.b aBj;
    private com.baidu.live.alablmsdk.d.a aBk;
    private com.baidu.live.alablmsdk.c.c aBl;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a(this);
        this.aAV = new com.baidu.live.alablmsdk.e.b(context, this);
        this.aBg = new a(this.aAV);
        this.aBg.Bx();
        this.aBh = new b(this);
        this.aBi = new com.baidu.live.alablmsdk.d.c(context);
        this.aBi.a(this);
        this.aBj = new com.baidu.live.alablmsdk.d.b(this.aBi);
        this.aBk = new com.baidu.live.alablmsdk.d.a(context, this.aBi);
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aAq = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        this.aBh.w(hashMap);
        this.aBi.v(hashMap);
        this.aAV.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aBi.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Be() {
        return this.aBk;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.aAV.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    com.baidu.live.alablmsdk.a.b.d("createRoom onResult responseCode = " + i + " , errorMessage = " + str);
                    com.baidu.live.alablmsdk.a.b.fJ("createRoom onResult code " + i + " message " + str);
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        com.baidu.live.alablmsdk.a.b.d("createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        c.this.b(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId);
                        c.this.aAV.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                com.baidu.live.alablmsdk.a.b.d(" signal join onResult , responseCode=" + i2 + " , errorMessage=" + str2);
                                com.baidu.live.alablmsdk.a.b.fJ(" signal join onResult code " + i2 + " message " + str2);
                                if (i2 == 0) {
                                    if (c.this.aBa != null) {
                                        c.this.aBa.a(BLMSignalState.JOINED);
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
        this.aBa = new com.baidu.live.alablmsdk.module.a();
        this.aBa.roomId = str;
        this.aBa.token = str2;
        this.aBa.rtcAppId = str3;
        this.aBa.aBv = j;
        d dVar = new d();
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aBv = j;
        cVar.aBA = UserPermission.OWNER;
        dVar.aBD = cVar;
        this.aBa.aBw = dVar;
        if (this.aBg != null) {
            a aVar = this.aBg;
            a.fK(this.aBa.roomId);
            this.aBg.a(str, this.aBa.BI());
        }
        com.baidu.live.alablmsdk.module.b.BP().c(this.aBa);
        if (this.aBh != null) {
            this.aBh.a(this.aBa);
        }
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAV.c(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.3
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void b(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAV.d(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.4
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if ((i2 == 0 || i2 == -1) && c.this.aBa != null) {
                    c.this.aBa.t(list);
                    if (c.this.aBa.BL()) {
                        c.this.BG();
                    }
                }
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.ah(" acceptRoom ", " , extJson=" + jSONObject);
        this.aAV.e(str, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.BP().a(str, BLMSignalState.JOINED);
                    c.this.b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void f(int i3, int i4, String str3) {
                            com.baidu.live.alablmsdk.a.b.d(" visiter join room， status=" + i4 + " , msg" + str3);
                            com.baidu.live.alablmsdk.a.b.fJ(" visiter join room， status " + i4 + " msg " + str3);
                            if (i4 == 0) {
                                com.baidu.live.alablmsdk.module.b.BP().a(str, BLMRtcState.JOINED);
                                if (cVar != null) {
                                    cVar.f(4, 0, "acceptRoom join rtc room success");
                                    return;
                                }
                                return;
                            }
                            com.baidu.live.alablmsdk.module.b.BP().a(str, BLMRtcState.FAIL);
                            c.this.fL(str);
                            com.baidu.live.alablmsdk.a.b.d("acceptRoom join rtc room error ; msg = " + str3);
                            com.baidu.live.alablmsdk.a.b.fJ("acceptRoom join rtc room error msg " + str3);
                            if (cVar != null) {
                                cVar.f(4, -1, "acceptRoom join rtc room error ; msg = " + str3);
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.d("acceptRoom join signal room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.fJ("acceptRoom join signal room error msg " + str2);
                c.this.BG();
                if (cVar != null) {
                    cVar.f(4, -1, "acceptRoom join signal room error ; msg = " + str2);
                }
            }
        });
    }

    private JSONObject t(JSONObject jSONObject) {
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        if (this.aBa != null && this.aBa.aBw != null && this.aBa.aBw.aBD != null) {
            com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
            bVar.aBv = this.aBa.aBw.aBD.aBv;
            bVar.order = this.aBa.aBw.aBD.order;
            aVar.aBJ = com.baidu.live.alablmsdk.module.a.b.a(bVar);
        }
        JSONObject t = aVar.t(jSONObject);
        if (t == null) {
            return new JSONObject();
        }
        return t;
    }

    public void b(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aAV.f(str, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.6
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                c.this.BG();
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, com.baidu.live.alablmsdk.module.c cVar, final com.baidu.live.alablmsdk.c.c cVar2) {
        a(cVar);
        b(str, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.7
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                com.baidu.live.alablmsdk.a.b.d(" owner join room， status=" + i2 + " , msg" + str2);
                com.baidu.live.alablmsdk.a.b.fJ(" owner join room status " + i2 + " msg" + str2);
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.BP().a(str, BLMRtcState.JOINED);
                    if (cVar2 != null) {
                        cVar2.f(4, 0, "acceptRoom join rtc room success");
                        return;
                    }
                    return;
                }
                com.baidu.live.alablmsdk.module.b.BP().a(str, BLMRtcState.FAIL);
                c.this.d(str, (JSONObject) null, (com.baidu.live.alablmsdk.c.c) null);
                com.baidu.live.alablmsdk.a.b.d("acceptRoom join rtc room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.fJ("acceptRoom join rtc room error msg " + str2);
                if (cVar2 != null) {
                    cVar2.f(4, -1, "acceptRoom join rtc room error ; msg = " + str2);
                }
            }
        });
    }

    private void a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null && this.aBa != null && this.aBa.aBw != null && this.aBa.aBw.aBD != null) {
            this.aBa.aBw.aBD.order = cVar.order;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.module.c BM;
        this.aBl = cVar;
        com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.BP().fN(str);
        if (fN == null) {
            com.baidu.live.alablmsdk.a.b.ah("joinRoom param error getChatInfo null ", "");
            if (this.aBl != null) {
                this.aBl.f(6, 1000, "join rtc room param error , getChatInfo null");
            }
        } else if (!com.baidu.live.alablmsdk.module.a.b(fN)) {
            com.baidu.live.alablmsdk.a.b.ah("joinRoom chatInfo check error", "");
            if (this.aBl != null) {
                this.aBl.f(6, 1000, "joinRoom chatInfo check error");
            }
        } else {
            if (this.aBa != null && (BM = this.aBa.BM()) != null && !TextUtils.isEmpty(BM.order)) {
                this.aBi.fR(BM.order);
            }
            this.aBi.c(str, fN.token, fN.rtcAppId, fN.aBv);
        }
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        if (this.aBi != null && !TextUtils.isEmpty(this.aBi.Ca()) && this.aBi.Ca().equals(str) && !com.baidu.live.alablmsdk.a.a.isEmpty(list) && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.module.c cVar2 = list.get(0);
            this.aBi.ai(cVar2.aBv);
            this.aAV.a(str, cVar2, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.8
                @Override // com.baidu.live.alablmsdk.c.c
                public void f(int i, int i2, String str2) {
                }
            });
            if (cVar != null) {
                cVar.f(9, 0, "kick off user send");
            }
        } else if (cVar != null) {
            cVar.f(9, -1, "room or user check error");
        }
    }

    public void aY(boolean z) {
        if (this.aBj != null) {
            com.baidu.live.alablmsdk.a.b.d("muteMicrophone " + z);
            com.baidu.live.alablmsdk.a.b.fJ("muteMicrophone " + z);
            this.aBj.aY(z);
        }
    }

    private void BE() {
        com.baidu.live.alablmsdk.a.b.ah(" currentKickedOffLeave ", "");
        if (this.aBi != null) {
            this.aBi.Cf();
        }
        BH();
        BG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(String str) {
        c(str, com.baidu.live.alablmsdk.module.a.a.BW(), (com.baidu.live.alablmsdk.c.c) null);
    }

    public void c(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d(" leaveRoom");
        com.baidu.live.alablmsdk.a.b.fJ(" leaveRoom ");
        this.aBi.Cf();
        this.aAV.a(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.d(" leaveRoom onResult ，responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.fJ(" leaveRoom onResult code " + i + " message " + str2);
                if (i == 0) {
                    if (c.this.aBg != null) {
                        c.this.aBg.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (cVar != null) {
                        cVar.f(7, 0, "leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (c.this.aBg != null) {
                    c.this.aBg.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (cVar != null) {
                    cVar.f(7, -1, "leaveRoom hangout signal fail");
                }
            }
        });
        BH();
        BG();
    }

    public void d(final String str, final JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d(" closeRoom roomId=" + str);
        com.baidu.live.alablmsdk.a.b.fJ(" closeRoom roomId " + str);
        com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.BP().fN(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (fN != null) {
            userPermission = fN.BI();
        }
        com.baidu.live.alablmsdk.a.b.d(" closeRoom permission=" + userPermission);
        com.baidu.live.alablmsdk.a.b.fJ(" closeRoom permission " + userPermission);
        if (userPermission == UserPermission.OWNER) {
            this.aBi.Ce();
        } else {
            this.aBi.Cf();
        }
        this.aAV.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.d(" closeRoom-signal hangout  responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.fJ(" closeRoom-signal hangout code " + i + " errorMessage " + str2);
                if (userPermission == UserPermission.OWNER) {
                    com.baidu.live.alablmsdk.a.b.d(" signal close ");
                    com.baidu.live.alablmsdk.a.b.fJ(" signal close ");
                    c.this.aAV.b(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str3) {
                            com.baidu.live.alablmsdk.a.b.d(" signal closeRoom , responseCode=" + i2 + " , errorMessage=" + str3);
                            com.baidu.live.alablmsdk.a.b.fJ(" signal closeRoom code " + i2 + " errorMessage " + str3);
                            if (i2 == 0) {
                                if (c.this.aBg != null) {
                                    c.this.aBg.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (cVar != null) {
                                    cVar.f(8, 0, "closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (c.this.aBg != null) {
                                c.this.aBg.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (cVar != null) {
                                cVar.f(8, -1, "closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        BG();
        BH();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        com.baidu.live.alablmsdk.a.b.d(" b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        com.baidu.live.alablmsdk.a.b.d(" im 连接状态 responseCode = " + i);
        com.baidu.live.alablmsdk.a.b.fJ(" im long connection code " + i);
        dx(i);
    }

    private void dx(int i) {
        if (i == 0) {
            if (this.aBa != null) {
                BF();
            } else if (this.aBa == null) {
                this.aBg.Bw();
            }
        }
    }

    private void BF() {
        com.baidu.live.alablmsdk.a.b.ah(" reJoinSignalAndRtcRoomInner ", "");
        if (this.aBa != null) {
            this.aAV.join(this.aBa.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    com.baidu.live.alablmsdk.a.b.ah(" reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str, "");
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.ah(" reJoinSignalAndRtcRoomInner signal join success", "");
                        c.this.aBi.Ck();
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.ah(" reJoinSignalAndRtcRoomInner signal join fail", "");
                }
            });
        } else {
            com.baidu.live.alablmsdk.a.b.ah(" reJoinSignalAndRtcRoomInner mCurrentChatInfo==null", "");
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
        if (i == 89) {
            com.baidu.live.alablmsdk.a.b.d(" signal onRtcResult room closed ");
            com.baidu.live.alablmsdk.a.b.fJ(" signal onRtcResult room closed ");
            String str = "";
            if (bIMRtcInfo != null) {
                str = bIMRtcInfo.getRtcRoomId();
            }
            if (this.aBa != null && !TextUtils.isEmpty(this.aBa.roomId) && this.aBa.roomId.equals(str)) {
                BG();
            }
            if (this.aAq != null) {
                com.baidu.live.alablmsdk.a.b.d(" room closed callback ,  roomId=" + str);
                com.baidu.live.alablmsdk.a.b.fJ(" room closed callback roomId " + str);
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
                cVar.aBv = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        com.baidu.live.alablmsdk.a.b.ah(" caller invite time out", " , other imUk=" + cVar.aBv);
        if (this.aBa != null && this.aBa.BJ()) {
            if (this.aBa.ad(cVar.aBv)) {
                com.baidu.live.alablmsdk.module.b.BP().a(str, cVar.aBv, BLMSignalState.TIMEOUT);
                if (this.aAq != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" caller invite time out callback ", "");
                    this.aAq.a(str, cVar);
                    return;
                }
                return;
            } else if (this.aAq != null) {
                com.baidu.live.alablmsdk.a.b.ah(" caller invite time out, check imUk error, but callback ", "");
                this.aAq.a(str, cVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.ah(" caller invite time out not callback ", "");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerGetAnswerSyncByCallee(int i, BIMRtcInfo bIMRtcInfo) {
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        JSONObject jSONObject = null;
        com.baidu.live.alablmsdk.a.b.ah(" roomCallerGetAnswerSyncByCallee ", "");
        long j = 0;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.d(" roomCallerGetAnswerSyncByCallee ext=" + rtcExt);
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.fO(rtcExt);
            } else {
                aVar = null;
            }
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                BIMSyncRtcInfo bIMSyncRtcInfo = (BIMSyncRtcInfo) bIMRtcInfo;
                j = bIMSyncRtcInfo.getInitiatorUk();
                cVar.aBv = bIMSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (!TextUtils.isEmpty(rtcRoomId) && this.aBa != null && !TextUtils.isEmpty(this.aBa.roomId) && this.aBa.roomId.equals(rtcRoomId)) {
                    d dVar = new d();
                    dVar.aBD = cVar.clone();
                    this.aBa.a(dVar, BLMStateType.SIGNAL);
                }
                com.baidu.live.alablmsdk.a.b.ah(" caller receive callee response", " callee 的 uk=" + cVar.aBv);
            }
            str = rtcRoomId;
        } else {
            str = null;
        }
        if (i == 1) {
            com.baidu.live.alablmsdk.a.b.ah(" caller，callee answer ok", "");
            com.baidu.live.alablmsdk.module.b.BP().a(str, j, BLMSignalState.JOINED);
            if (this.aAq != null) {
                com.baidu.live.alablmsdk.a.b.ah(" caller，callee answer ok callback", "");
                this.aAq.d(str, cVar, jSONObject);
            }
        } else if (i == 2) {
            com.baidu.live.alablmsdk.a.b.ah(" caller，callee answer no", "");
            com.baidu.live.alablmsdk.module.b.BP().a(str, j, BLMSignalState.REJECT);
            if (this.aAq != null) {
                com.baidu.live.alablmsdk.a.b.ah(" caller，callee answer no callback", "");
                this.aAq.e(str, cVar, jSONObject);
            }
        } else if (i == 3) {
            com.baidu.live.alablmsdk.a.b.ah(" caller，callee answer timeout 30s", "");
            com.baidu.live.alablmsdk.module.b.BP().a(str, j, BLMSignalState.TIMEOUT);
            if (this.aAq != null) {
                com.baidu.live.alablmsdk.a.b.ah(" caller，callee answer timeout 30s callback", "");
                this.aAq.a(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.a.b.d(" 被叫方接收到邀请(解析 rtc room 的相关信息，");
        com.baidu.live.alablmsdk.a.b.fJ(" callee receive invite ");
        if (bIMRtcInfo != null && (bIMRtcInfo instanceof BIMInviteSyncRtcInfo)) {
            BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = (BIMInviteSyncRtcInfo) bIMRtcInfo;
            String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
            com.baidu.live.alablmsdk.a.b.ah(" callee receive invite roomId " + rtcRoomId, "");
            if (!TextUtils.isEmpty(rtcRoomId)) {
                if (this.aBa != null && this.aBa.roomId != null && !this.aBa.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.a.b.d(" callee get invite. mCurrentChatInfo.roomId != roomId , return。  mCurrentChatInfo.roomId=" + this.aBa.roomId);
                    com.baidu.live.alablmsdk.a.b.fJ(" callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.aBa.roomId);
                    return;
                }
                String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
                com.baidu.live.alablmsdk.a.b.d(" callee receive invite,  originalExt=" + rtcExt);
                com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
                JSONObject fO = aVar.fO(rtcExt);
                com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.BP().fN(rtcRoomId);
                if (fN == null) {
                    fN = new com.baidu.live.alablmsdk.module.a();
                }
                fN.roomId = rtcRoomId;
                fN.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                fN.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                fN.aBv = bIMInviteSyncRtcInfo.getRtcUserId();
                d dVar = new d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aBv = fN.aBv;
                cVar.aBA = UserPermission.VISITER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                dVar.aBD = cVar;
                dVar.b(BLMSignalState.RING);
                fN.aBw = dVar;
                d dVar2 = new d();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.aBv = bIMInviteSyncRtcInfo.getInitiatorUk();
                cVar2.aBA = UserPermission.OWNER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar2, aVar);
                dVar2.aBD = cVar2;
                dVar2.b(BLMSignalState.JOINED);
                fN.a(dVar2, BLMStateType.SIGNAL);
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d("callee 收到邀请 ， " + fN.BK());
                }
                this.aBa = fN;
                com.baidu.live.alablmsdk.module.b.BP().c(fN);
                if (this.aBh != null) {
                    this.aBh.a(this.aBa);
                }
                if (this.aBg != null) {
                    a aVar2 = this.aBg;
                    a.fK(fN.roomId);
                    this.aBg.a(fN.roomId, fN.BI());
                }
                com.baidu.live.alablmsdk.module.c clone = cVar2.clone();
                if (this.aAq != null) {
                    this.aAq.b(rtcRoomId, clone, fO);
                }
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        String str = null;
        com.baidu.live.alablmsdk.module.a.a aVar = null;
        com.baidu.live.alablmsdk.a.b.ah(" callee,  caller cancel invite ", "");
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.fO(rtcExt);
            } else {
                jSONObject = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aBv = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
        }
        if (this.aBa != null && this.aBa.BJ() && !TextUtils.isEmpty(this.aBa.roomId) && this.aBa.roomId.equals(str) && this.aBa.ad(cVar.aBv)) {
            BG();
            if (this.aAq != null) {
                this.aAq.c(str, cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.BP().a(bIMRtcInfo.getRtcRoomId(), BLMSignalState.DEFAULT);
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
                jSONObject = aVar.fO(rtcExt);
            } else {
                aVar = null;
            }
            str = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aBv = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (this.aBa != null && (ac = this.aBa.ac(cVar.aBv)) != null && !TextUtils.isEmpty(ac.order)) {
                    cVar.order = ac.order;
                }
            }
        }
        if (com.baidu.live.alablmsdk.a.b.isDebug()) {
            com.baidu.live.alablmsdk.a.b.d(" 对方的事件 : roomEventType=" + roomEventType + "  roomId=" + str + " , imUk=" + cVar.aBv);
        }
        com.baidu.live.alablmsdk.a.b.fJ("roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str);
        if (fM(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                com.baidu.live.alablmsdk.a.b.ah(" signal： other ringing ", "");
                com.baidu.live.alablmsdk.module.b.BP().a(str, cVar.aBv, BLMSignalState.RING);
                if (this.aAq != null) {
                    this.aAq.a(str, cVar, jSONObject);
                    return;
                }
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.JOIN_ROOM) {
                com.baidu.live.alablmsdk.a.b.ah(" signal： other join signal room", "");
                e(str, cVar);
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.EXIT_ROOM) {
                com.baidu.live.alablmsdk.a.b.ah(" signal： other exit signal room", "");
                a(str, cVar, aVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.ah(" not current room chart do nothing", "");
    }

    private void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.a fN;
        if (cVar != null && (fN = com.baidu.live.alablmsdk.module.b.BP().fN(str)) != null) {
            d dVar = new d();
            dVar.aBD = cVar.clone();
            dVar.b(BLMSignalState.JOINED);
            fN.a(dVar, BLMStateType.SIGNAL);
        }
    }

    private void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.module.a.a aVar) {
        if (cVar != null) {
            com.baidu.live.alablmsdk.a.b.ah("handleSignalUserLeave roomId " + str, " , callbackUser = " + cVar.toString());
            if (this.aBa != null && !TextUtils.isEmpty(this.aBa.roomId) && this.aBa.roomId.equals(str) && this.aBa.BJ()) {
                com.baidu.live.alablmsdk.a.b.ah(" handleSignalUserLeave ，remove otherImUk ", "");
                this.aBa.aa(cVar.aBv);
                if (aVar != null && aVar.aBK) {
                    com.baidu.live.alablmsdk.a.b.ah(" handleSignalUserLeave ，hasStatusCheckInfoKey reture ", "");
                } else if (this.aAq != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" handleSignalUserLeave ，onRoomUserLeaved callback ", "");
                    this.aAq.c(str, cVar);
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
        com.baidu.live.alablmsdk.module.c BM;
        com.baidu.live.alablmsdk.a.b.ah(" roomKickedUserFromKickerSync ", "");
        if (bIMKickReqSyncRtcInfo != null) {
            try {
                j = bIMKickReqSyncRtcInfo.getBIMKickedUsers().uk;
                try {
                    com.baidu.live.alablmsdk.a.b.ah(" roomKickedUserFromKickerSync kickedImUk=" + j, "");
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                j = 0;
            }
            if (this.aBa != null && (BM = this.aBa.BM()) != null && BM.aBv != 0 && BM.aBv == j) {
                X(j);
                return 1;
            }
        }
        return 0;
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo) {
        com.baidu.live.alablmsdk.a.b.ah(" roomEventKickedStatusByKickedUser ", "");
        if (bIMKickResSyncRtcInfo != null) {
            long j = 0;
            try {
                j = bIMKickResSyncRtcInfo.getBIMKickedUsers().uk;
                com.baidu.live.alablmsdk.a.b.ah(" roomEventKickedStatusByKickedUser kickedThirdUserId=" + j, "");
            } catch (Exception e) {
            }
            Y(j);
        }
    }

    private void X(long j) {
        String str;
        com.baidu.live.alablmsdk.module.c cVar = null;
        com.baidu.live.alablmsdk.a.b.fJ(" handleCurrentUserKicked ");
        if (this.aBa != null) {
            str = this.aBa.roomId;
            com.baidu.live.alablmsdk.module.c BM = this.aBa.BM();
            if (BM != null) {
                cVar = BM.clone();
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aBv = j;
            }
        } else {
            str = null;
        }
        BE();
        if (this.aAq != null) {
            com.baidu.live.alablmsdk.a.b.ah(" current, onRoomUserKickoffed call back", "");
            this.aAq.d(str, cVar);
        }
    }

    private void Y(long j) {
        String str;
        com.baidu.live.alablmsdk.module.c cVar = null;
        com.baidu.live.alablmsdk.a.b.ah(" handleOtherUserKicked uk=" + j, "");
        if (this.aBa != null) {
            str = this.aBa.roomId;
            com.baidu.live.alablmsdk.module.c ac = this.aBa.ac(j);
            if (ac != null) {
                cVar = ac.clone();
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aBv = j;
            }
        } else {
            str = null;
        }
        if (this.aBa != null) {
            this.aBa.aa(j);
        }
        if (this.aAq != null) {
            com.baidu.live.alablmsdk.a.b.ah(" other, onRoomUserKickoffed call back", "");
            this.aAq.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void dy(int i) {
        com.baidu.live.alablmsdk.a.b.ah(" onRtcCurrentUserStreamChange status " + i, "");
        if (i == 2) {
            this.aBh.BB();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void g(int i, String str) {
        if (i == 0) {
            com.baidu.live.alablmsdk.a.b.ah(" onRtcCurrentUserJoinRoomStatus success msg " + str, "");
            this.aBh.BC();
            if (this.aBl != null) {
                this.aBl.f(6, 0, str);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.ah(" onRtcCurrentUserJoinRoomStatus fail msg " + str, "");
        if (this.aBl != null) {
            this.aBl.f(6, -1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void onRoomEventUpdate(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.ah(" rtc onRoomEventUpdate roomEvents " + i, " , imUK=" + j + " , extra_info=" + str);
        a(i, j, str);
    }

    private void a(int i, long j, String str) {
        if (this.aBa != null) {
            if (!TextUtils.isEmpty(this.aBa.roomId)) {
                if (this.aBa.BJ()) {
                    if (this.aBa.Z(j) || (j == 0 && i == 100)) {
                        b(i, j, str);
                        return;
                    }
                    c(i, j, str);
                    if (this.aBa.ad(j)) {
                        d(i, j, str);
                        return;
                    } else {
                        e(i, j, str);
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.ah(" handleRtc hasStartedTransaction is false ", "imUk=" + j);
                return;
            }
            com.baidu.live.alablmsdk.a.b.ah(" handleRtc mCurrentChatInfo.roomId is empty", "imUk=" + j);
            return;
        }
        com.baidu.live.alablmsdk.a.b.ah(" handleRtc mCurrentChatInfo is null", "imUk=" + j);
    }

    private void b(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.ah(" handleRtcCurrentUser ", "imUk=" + j + "  extraInfo=" + str);
        if (this.aBa == null) {
            com.baidu.live.alablmsdk.a.b.ah(" handleRtcCurrentUser mCurrentChatInfo info error", "");
        } else if (i == 100) {
            if (this.aBa.aBw != null && this.aBa.aBw.aBD != null && !TextUtils.isEmpty(this.aBa.aBw.aBD.order)) {
                String b = com.baidu.live.alablmsdk.module.a.b.b(this.aBa.aBw.aBD);
                this.aBi.setUserAttribute(b);
                com.baidu.live.alablmsdk.a.b.d(" setUserAttribute " + b);
            }
        } else if (i == 115) {
            com.baidu.live.alablmsdk.a.b.ah("rtc current user kicked ，do rtc leave room ", "");
            this.aBi.Cf();
        }
    }

    private void c(int i, long j, String str) {
        if (i == 300 && this.aBa.BI() == UserPermission.VISITER) {
            if (this.aBa.ab(j) == null) {
                com.baidu.live.alablmsdk.a.b.fJ(" not current user, permission is visiter, add other list");
                d dVar = new d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aBv = j;
                dVar.aBD = cVar;
                dVar.b(BLMRtcState.JOINED);
                this.aBa.a(dVar, BLMStateType.RTC);
                return;
            }
            com.baidu.live.alablmsdk.a.b.fJ(" not current user, permission is visiter, has include the other");
        }
    }

    private void d(int i, long j, String str) {
        com.baidu.live.alablmsdk.module.c cVar;
        com.baidu.live.alablmsdk.a.b.ah(" handleRtcHasIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
        if (j != 0 && this.aBa != null) {
            com.baidu.live.alablmsdk.module.c ac = this.aBa.ac(j);
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.aBv = j;
            if (ac != null) {
                aVar.order = ac.order;
            }
            com.baidu.live.alablmsdk.a.b.ah(" current transaction  yes ", "");
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.ah("remote join  invite join or reJoin rtc", "");
                if (this.aAq != null) {
                    if (ac != null) {
                        cVar = ac.clone();
                    } else {
                        cVar = new com.baidu.live.alablmsdk.module.c();
                        cVar.aBv = j;
                    }
                    this.aAq.b(this.aBa.roomId, cVar);
                }
            } else if (i == 303) {
                com.baidu.live.alablmsdk.a.b.ah("rtc remote attribute arrive", "");
                if (this.aBa != null) {
                    this.aBa.c(j, str);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.ah("rtc remote user leave", "");
            } else if (i == 106) {
                String str2 = "";
                if (aVar != null) {
                    str2 = aVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.ah("rtc remote stream arrival , streamInfo=" + str2, "");
                if (this.aBk != null) {
                    this.aBk.b(true, j);
                }
                if (this.aAq != null) {
                    this.aAq.a(aVar, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                }
                this.aBh.W(j);
            } else if (i == 107) {
                com.baidu.live.alablmsdk.a.b.ah("rtc remote stream leave", "");
                if (this.aAq != null) {
                    this.aAq.a(aVar, BLMStreamState.BLMSTREAMSTATE_REMOVE);
                }
                this.aBh.V(j);
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.ah("rtc other user kicked, include  don nothing", "imUk = " + j);
            }
        }
    }

    public void e(int i, long j, String str) {
        if (j != 0) {
            com.baidu.live.alablmsdk.a.b.ah(" handleRtcHasNotIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.ah("remote join :  invite join or reJoin rtc", "");
                if (this.aBa.BI() == UserPermission.OWNER && this.aBi != null) {
                    this.aBi.ai(j);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.ah("remote user leave", "");
            } else if (i == 106) {
                com.baidu.live.alablmsdk.a.b.ah("remote stream arrival", "");
                if (this.aBa.BI() == UserPermission.OWNER && this.aBi != null) {
                    this.aBi.ai(j);
                }
            } else if (i == 107) {
                com.baidu.live.alablmsdk.a.b.ah("remote stream leave", "");
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.ah(" un include, other user kicked ", "imUk = " + j);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.b.b.a
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.aAq != null) {
            this.aAq.a(aVar, i);
        }
    }

    public void BG() {
        com.baidu.live.alablmsdk.a.b.ah(" resetCurrentChat ", "");
        this.aBa = null;
        com.baidu.live.alablmsdk.module.b.BP().clearAll();
    }

    public boolean fM(String str) {
        return (this.aBa == null || TextUtils.isEmpty(this.aBa.roomId) || !this.aBa.roomId.equals(str)) ? false : true;
    }

    public void BH() {
        com.baidu.live.alablmsdk.a.b.ah("stop all stream leave count down", "");
        this.aBh.BD();
        this.aBh.BC();
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.d(" BMLSignalRtcSyncManager  release ");
        com.baidu.live.alablmsdk.a.b.fJ(" BMLSignalRtcSyncManager  release ");
        this.aBl = null;
        this.aAq = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.aAV != null) {
            this.aAV.release();
            this.aAV = null;
        }
        if (this.aBh != null) {
            this.aBh.release();
        }
        if (this.aBi != null) {
            this.aBi.release();
            this.aBi = null;
        }
        if (this.aBk != null) {
            this.aBk.release();
        }
        if (this.aBg != null) {
            this.aBg.release();
        }
        com.baidu.live.alablmsdk.a.b.Bf();
        BG();
        BH();
        f.Bj().release();
    }

    @Override // com.baidu.live.alablmsdk.a.b.a
    public void fI(String str) {
        if (this.aAq != null) {
            this.aAq.fI(str);
        }
    }
}
