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
import com.baidu.live.alablmsdk.a.b.d;
import com.baidu.live.alablmsdk.a.e;
import com.baidu.live.alablmsdk.b.b;
import com.baidu.live.alablmsdk.module.UserPermission;
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
public class c implements BIMRtcListener, IConnectListener, ILiveMsgReceiveListener, d, b.a, com.baidu.live.alablmsdk.c.b.a {
    private com.baidu.live.alablmsdk.c.b aAX;
    private com.baidu.live.alablmsdk.e.b aBO;
    public com.baidu.live.alablmsdk.module.a aBT;
    private a aBZ;
    private b aCa;
    private com.baidu.live.alablmsdk.d.c aCb;
    private com.baidu.live.alablmsdk.d.b aCc;
    private com.baidu.live.alablmsdk.d.a aCd;
    private com.baidu.live.alablmsdk.c.c aCe;
    private boolean aCf;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a.a(this);
        com.baidu.live.alablmsdk.a.b.c.BY().b(this);
        this.aBO = new com.baidu.live.alablmsdk.e.b(context, this);
        this.aBZ = new a(this.aBO);
        this.aBZ.Cw();
        this.aCa = new b(this);
        this.aCb = new com.baidu.live.alablmsdk.d.c(context);
        this.aCb.a(this);
        this.aCc = new com.baidu.live.alablmsdk.d.b(this.aCb);
        this.aCd = new com.baidu.live.alablmsdk.d.a(context, this.aCb);
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aAX = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        this.aCa.w(hashMap);
        this.aCb.v(hashMap);
        this.aBO.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aCb.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a BR() {
        return this.aCd;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.aBO.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.d("createRoom onResult responseCode = " + i + " , errorMessage = " + str);
                    com.baidu.live.alablmsdk.a.b.a.fY("createRoom onResult code " + i + " message " + str);
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        com.baidu.live.alablmsdk.a.b.a.d("createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        c.this.c(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId);
                        c.this.aBO.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                com.baidu.live.alablmsdk.a.b.a.d(" signal join onResult , responseCode=" + i2 + " , errorMessage=" + str2);
                                com.baidu.live.alablmsdk.a.b.a.fY(" signal join onResult code " + i2 + " message " + str2);
                                if (i2 == 0) {
                                    if (c.this.aBT != null) {
                                        c.this.aBT.a(BLMSignalState.JOINED);
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
    public void c(String str, String str2, String str3, long j) {
        this.aBT = new com.baidu.live.alablmsdk.module.a();
        this.aBT.roomId = str;
        this.aBT.token = str2;
        this.aBT.rtcAppId = str3;
        this.aBT.aCp = j;
        com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aCp = j;
        cVar.aCu = UserPermission.OWNER;
        dVar.aCy = cVar;
        this.aBT.aCq = dVar;
        com.baidu.live.alablmsdk.a.b.c.BY().setRtcRoomId(this.aBT.roomId);
        if (this.aBZ != null) {
            a aVar = this.aBZ;
            a.ga(this.aBT.roomId);
            this.aBZ.a(str, this.aBT.CH());
        }
        com.baidu.live.alablmsdk.module.b.CP().c(this.aBT);
        if (this.aCa != null) {
            this.aCa.a(this.aBT);
        }
    }

    public void a(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aBO.c(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.3
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (i2 == 0 && c.this.aBT != null && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list.size()) {
                            break;
                        }
                        com.baidu.live.alablmsdk.module.c cVar2 = (com.baidu.live.alablmsdk.module.c) list.get(i4);
                        if (cVar2 != null) {
                            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                            dVar.aCy = cVar2.clone();
                            if (c.this.aBT.CM() != null) {
                                dVar.aCy.aCw = c.this.aBT.CM().aCp;
                            }
                            dVar.b(BLMRtcState.DEFAULT);
                            c.this.aBT.a(dVar, BLMStateType.SIGNAL);
                        }
                        i3 = i4 + 1;
                    }
                }
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void b(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aBO.d(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.4
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if ((i2 == 0 || i2 == -1) && c.this.aBT != null) {
                    c.this.aBT.u(list);
                    if (c.this.aBT.CL()) {
                        c.this.CF();
                    }
                }
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ak(" acceptRoom ", " , extJson=" + jSONObject);
        this.aBO.e(str, n(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.CP().a(str, BLMSignalState.JOINED);
                    c.this.a(str, false, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void f(int i3, int i4, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.d(" visiter join room， status=" + i4 + " , msg" + str3);
                            com.baidu.live.alablmsdk.a.b.a.fY(" visiter join room， status " + i4 + " msg " + str3);
                            if (i4 == 0) {
                                com.baidu.live.alablmsdk.module.b.CP().a(str, BLMRtcState.JOINED);
                                if (cVar != null) {
                                    cVar.f(4, 0, "acceptRoom join rtc room success");
                                    return;
                                }
                                return;
                            }
                            com.baidu.live.alablmsdk.module.b.CP().a(str, BLMRtcState.FAIL);
                            c.this.gb(str);
                            com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join rtc room error ; msg = " + str3);
                            com.baidu.live.alablmsdk.a.b.a.fY("acceptRoom join rtc room error msg " + str3);
                            if (cVar != null) {
                                cVar.f(4, -1, "acceptRoom join rtc room error ; msg = " + str3);
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join signal room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.a.fY("acceptRoom join signal room error msg " + str2);
                c.this.CF();
                if (cVar != null) {
                    cVar.f(4, -1, "acceptRoom join signal room error ; msg = " + str2);
                }
            }
        });
    }

    private JSONObject n(JSONObject jSONObject) {
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        if (this.aBT != null && this.aBT.aCq != null && this.aBT.aCq.aCy != null) {
            com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
            bVar.aCp = this.aBT.aCq.aCy.aCp;
            bVar.order = this.aBT.aCq.aCy.order;
            aVar.aCE = com.baidu.live.alablmsdk.module.a.b.a(bVar);
        }
        JSONObject n = aVar.n(jSONObject);
        if (n == null) {
            return new JSONObject();
        }
        return n;
    }

    public void b(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aBO.f(str, n(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.6
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                c.this.CF();
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, com.baidu.live.alablmsdk.module.c cVar, final com.baidu.live.alablmsdk.c.c cVar2) {
        a(cVar);
        a(str, true, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.7
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" owner join room， status=" + i2 + " , msg" + str2);
                com.baidu.live.alablmsdk.a.b.a.fY(" owner join room status " + i2 + " msg" + str2);
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.CP().a(str, BLMRtcState.JOINED);
                    if (cVar2 != null) {
                        cVar2.f(4, 0, "acceptRoom join rtc room success");
                        return;
                    }
                    return;
                }
                com.baidu.live.alablmsdk.module.b.CP().a(str, BLMRtcState.FAIL);
                c.this.b(str, (JSONObject) null, false, (com.baidu.live.alablmsdk.c.c) null);
                com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join rtc room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.a.fY("acceptRoom join rtc room error msg " + str2);
                if (cVar2 != null) {
                    cVar2.f(4, -1, "acceptRoom join rtc room error ; msg = " + str2);
                }
            }
        });
    }

    private void a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null && this.aBT != null && this.aBT.aCq != null && this.aBT.aCq.aCy != null) {
            this.aBT.aCq.aCy.order = cVar.order;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.module.c CM;
        this.aCe = cVar;
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.a.b.a.ak("joinRoom param error, roomId isEmpty", "");
            if (this.aCe != null) {
                this.aCe.f(6, 1000, "joinRoom param error, roomId isEmpty");
                return;
            }
            return;
        }
        if (z && this.aBT != null && this.aBT.CK() == BLMSignalState.DEFAULT) {
            com.baidu.live.alablmsdk.a.b.c.BY().Cc();
        }
        com.baidu.live.alablmsdk.module.a gd = com.baidu.live.alablmsdk.module.b.CP().gd(str);
        if (gd == null) {
            com.baidu.live.alablmsdk.a.b.a.ak("joinRoom param error getChatInfo null ", "");
            if (this.aCe != null) {
                this.aCe.f(6, 1000, "join rtc room param error , getChatInfo null");
            }
        } else if (!com.baidu.live.alablmsdk.module.a.b(gd)) {
            com.baidu.live.alablmsdk.a.b.a.ak("joinRoom chatInfo check error", "");
            if (this.aCe != null) {
                this.aCe.f(6, 1000, "joinRoom chatInfo check error");
            }
        } else {
            if (this.aBT != null && (CM = this.aBT.CM()) != null && !TextUtils.isEmpty(CM.order)) {
                this.aCb.gh(CM.order);
            }
            this.aCb.d(str, gd.token, gd.rtcAppId, gd.aCp);
        }
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        if (this.aCb != null && !TextUtils.isEmpty(this.aCb.CZ()) && this.aCb.CZ().equals(str) && !com.baidu.live.alablmsdk.a.a.isEmpty(list) && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.module.c cVar2 = list.get(0);
            this.aCb.aG(cVar2.aCp);
            this.aBO.a(str, cVar2, n(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.8
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

    public void bg(boolean z) {
        if (this.aCc != null) {
            com.baidu.live.alablmsdk.a.b.a.d("muteMicrophone " + z);
            com.baidu.live.alablmsdk.a.b.a.fY("muteMicrophone " + z);
            this.aCc.bg(z);
        }
    }

    private void CD() {
        com.baidu.live.alablmsdk.a.b.a.ak(" currentKickedOffLeave ", "");
        if (this.aCb != null) {
            this.aCb.Df();
        }
        CG();
        CF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(String str) {
        a(str, com.baidu.live.alablmsdk.module.a.a.CV(), false, (com.baidu.live.alablmsdk.c.c) null);
    }

    public void a(String str, JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d(" leaveRoom");
        com.baidu.live.alablmsdk.a.b.a.fY(" leaveRoom ");
        if (z) {
            if (this.aBT != null && this.aBT.CI() && !this.aBT.CL()) {
                com.baidu.live.alablmsdk.a.b.c.BY().bj(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.BY().bj(false);
            }
            com.baidu.live.alablmsdk.a.b.c.BY().Ci();
        }
        this.aCb.Df();
        this.aBO.a(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" leaveRoom onResult ，responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.a.fY(" leaveRoom onResult code " + i + " message " + str2);
                if (i == 0) {
                    if (c.this.aBZ != null) {
                        c.this.aBZ.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (cVar != null) {
                        cVar.f(7, 0, "leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (c.this.aBZ != null) {
                    c.this.aBZ.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (cVar != null) {
                    cVar.f(7, -1, "leaveRoom hangout signal fail");
                }
            }
        });
        CG();
        CF();
    }

    public void b(final String str, final JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ak(" closeRoom roomId " + str, "");
        if (z) {
            if (this.aBT != null && this.aBT.CI() && !this.aBT.CL()) {
                com.baidu.live.alablmsdk.a.b.c.BY().bj(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.BY().bj(false);
            }
            com.baidu.live.alablmsdk.a.b.c.BY().Cj();
        }
        com.baidu.live.alablmsdk.module.a gd = com.baidu.live.alablmsdk.module.b.CP().gd(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (gd != null) {
            userPermission = gd.CH();
        }
        com.baidu.live.alablmsdk.a.b.a.d(" closeRoom permission=" + userPermission);
        com.baidu.live.alablmsdk.a.b.a.fY(" closeRoom permission " + userPermission);
        if (userPermission == UserPermission.OWNER) {
            this.aCb.De();
            if (this.aCb.Db()) {
                com.baidu.live.alablmsdk.a.b.c.BY().pushEnd();
            }
        } else {
            this.aCb.Df();
        }
        this.aBO.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" closeRoom-signal hangout  responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.a.fY(" closeRoom-signal hangout code " + i + " errorMessage " + str2);
                if (userPermission == UserPermission.OWNER) {
                    com.baidu.live.alablmsdk.a.b.a.d(" signal close ");
                    com.baidu.live.alablmsdk.a.b.a.fY(" signal close ");
                    c.this.aBO.b(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.d(" signal closeRoom , responseCode=" + i2 + " , errorMessage=" + str3);
                            com.baidu.live.alablmsdk.a.b.a.fY(" signal closeRoom code " + i2 + " errorMessage " + str3);
                            if (i2 == 0) {
                                if (c.this.aBZ != null) {
                                    c.this.aBZ.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (cVar != null) {
                                    cVar.f(8, 0, "closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (c.this.aBZ != null) {
                                c.this.aBZ.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (cVar != null) {
                                cVar.f(8, -1, "closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        CF();
        CG();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        com.baidu.live.alablmsdk.a.b.a.d(" b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        com.baidu.live.alablmsdk.a.b.a.d(" im 连接状态 responseCode = " + i);
        com.baidu.live.alablmsdk.a.b.a.fY(" im long connection code " + i);
        dM(i);
    }

    private void dM(int i) {
        if (i == 0) {
            if (this.aBT != null) {
                CE();
            } else if (this.aBT == null) {
                this.aBZ.Cv();
            }
        }
    }

    private void CE() {
        com.baidu.live.alablmsdk.a.b.a.ak(" reJoinSignalAndRtcRoomInner ", "");
        if (this.aBT != null) {
            this.aBO.join(this.aBT.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str, "");
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.ak(" reJoinSignalAndRtcRoomInner signal join success", "");
                        c.this.aCb.Dk();
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ak(" reJoinSignalAndRtcRoomInner signal join fail", "");
                }
            });
        } else {
            com.baidu.live.alablmsdk.a.b.a.ak(" reJoinSignalAndRtcRoomInner mCurrentChatInfo==null", "");
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
        if (i == 89) {
            com.baidu.live.alablmsdk.a.b.a.d(" signal onRtcResult room closed ");
            com.baidu.live.alablmsdk.a.b.a.fY(" signal onRtcResult room closed ");
            String str = "";
            if (bIMRtcInfo != null) {
                str = bIMRtcInfo.getRtcRoomId();
            }
            if (this.aBT != null && !TextUtils.isEmpty(this.aBT.roomId) && this.aBT.roomId.equals(str)) {
                CF();
            }
            if (this.aAX != null) {
                com.baidu.live.alablmsdk.a.b.a.d(" room closed callback ,  roomId=" + str);
                com.baidu.live.alablmsdk.a.b.a.fY(" room closed callback roomId " + str);
                this.aAX.fX(str);
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
                cVar.aCp = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" caller invite time out", " , other imUk=" + cVar.aCp);
        if (this.aBT != null && this.aBT.CI()) {
            if (this.aBT.aB(cVar.aCp)) {
                com.baidu.live.alablmsdk.module.b.CP().a(str, cVar.aCp, BLMSignalState.TIMEOUT);
                com.baidu.live.alablmsdk.a.b.c.BY().Cg();
                if (this.aAX != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" caller invite time out callback ", "");
                    this.aAX.a(str, cVar);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.c.BY().Cg();
            if (this.aAX != null) {
                com.baidu.live.alablmsdk.a.b.a.ak(" caller invite time out, check imUk error, but callback ", "");
                this.aAX.a(str, cVar);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" caller invite time out not callback ", "");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerGetAnswerSyncByCallee(int i, BIMRtcInfo bIMRtcInfo) {
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        JSONObject jSONObject = null;
        com.baidu.live.alablmsdk.a.b.a.ak(" roomCallerGetAnswerSyncByCallee ", "");
        long j = 0;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.a.d(" roomCallerGetAnswerSyncByCallee ext=" + rtcExt);
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.ge(rtcExt);
            } else {
                aVar = null;
            }
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                BIMSyncRtcInfo bIMSyncRtcInfo = (BIMSyncRtcInfo) bIMRtcInfo;
                j = bIMSyncRtcInfo.getInitiatorUk();
                cVar.aCp = bIMSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (!TextUtils.isEmpty(rtcRoomId) && this.aBT != null && !TextUtils.isEmpty(this.aBT.roomId) && this.aBT.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                    dVar.aCy = cVar.clone();
                    this.aBT.a(dVar, BLMStateType.SIGNAL);
                }
                com.baidu.live.alablmsdk.a.b.a.ak(" caller receive callee response", " callee 的 uk=" + cVar.aCp);
            }
            str = rtcRoomId;
        } else {
            str = null;
        }
        if (i == 1) {
            com.baidu.live.alablmsdk.a.b.a.ak(" caller，callee answer ok", "");
            com.baidu.live.alablmsdk.module.b.CP().a(str, j, BLMSignalState.JOINED);
            if (this.aAX != null) {
                com.baidu.live.alablmsdk.a.b.a.ak(" caller，callee answer ok callback", "");
                this.aAX.d(str, cVar, jSONObject);
            }
        } else if (i == 2) {
            com.baidu.live.alablmsdk.a.b.a.ak(" caller，callee answer no", "");
            com.baidu.live.alablmsdk.module.b.CP().a(str, j, BLMSignalState.REJECT);
            com.baidu.live.alablmsdk.a.b.c.BY().Cf();
            if (this.aAX != null) {
                com.baidu.live.alablmsdk.a.b.a.ak(" caller，callee answer no callback", "");
                this.aAX.e(str, cVar, jSONObject);
            }
        } else if (i == 3) {
            com.baidu.live.alablmsdk.a.b.a.ak(" caller，callee answer timeout 30s", "");
            com.baidu.live.alablmsdk.module.b.CP().a(str, j, BLMSignalState.TIMEOUT);
            com.baidu.live.alablmsdk.a.b.c.BY().Cg();
            if (this.aAX != null) {
                com.baidu.live.alablmsdk.a.b.a.ak(" caller，callee answer timeout 30s callback", "");
                this.aAX.a(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.d(" 被叫方接收到邀请(解析 rtc room 的相关信息，");
        com.baidu.live.alablmsdk.a.b.a.fY(" callee receive invite ");
        if (bIMRtcInfo != null && (bIMRtcInfo instanceof BIMInviteSyncRtcInfo)) {
            BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = (BIMInviteSyncRtcInfo) bIMRtcInfo;
            String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
            com.baidu.live.alablmsdk.a.b.a.ak(" callee receive invite roomId " + rtcRoomId, "");
            if (!TextUtils.isEmpty(rtcRoomId)) {
                if (this.aBT != null && this.aBT.roomId != null && !this.aBT.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.a.b.a.d(" callee get invite. mCurrentChatInfo.roomId != roomId , return。  mCurrentChatInfo.roomId=" + this.aBT.roomId);
                    com.baidu.live.alablmsdk.a.b.a.fY(" callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.aBT.roomId);
                    return;
                }
                com.baidu.live.alablmsdk.a.b.c.BY().setRtcRoomId(rtcRoomId);
                String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
                com.baidu.live.alablmsdk.a.b.a.d(" callee receive invite,  originalExt=" + rtcExt);
                com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
                JSONObject ge = aVar.ge(rtcExt);
                com.baidu.live.alablmsdk.module.a gd = com.baidu.live.alablmsdk.module.b.CP().gd(rtcRoomId);
                if (gd == null) {
                    gd = new com.baidu.live.alablmsdk.module.a();
                }
                gd.roomId = rtcRoomId;
                gd.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                gd.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                gd.aCp = bIMInviteSyncRtcInfo.getRtcUserId();
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCp = gd.aCp;
                cVar.aCu = UserPermission.VISITER;
                cVar.aCw = bIMInviteSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                dVar.aCy = cVar;
                dVar.b(BLMSignalState.RING);
                gd.aCq = dVar;
                com.baidu.live.alablmsdk.module.d dVar2 = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.aCp = bIMInviteSyncRtcInfo.getInitiatorUk();
                cVar2.aCu = UserPermission.OWNER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar2, aVar);
                dVar2.aCy = cVar2;
                dVar2.b(BLMSignalState.JOINED);
                gd.a(dVar2, BLMStateType.SIGNAL);
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("callee 收到邀请 ， " + gd.CJ());
                }
                this.aBT = gd;
                com.baidu.live.alablmsdk.module.b.CP().c(gd);
                if (this.aCa != null) {
                    this.aCa.a(this.aBT);
                }
                if (this.aBZ != null) {
                    a aVar2 = this.aBZ;
                    a.ga(gd.roomId);
                    this.aBZ.a(gd.roomId, gd.CH());
                }
                com.baidu.live.alablmsdk.module.c clone = cVar2.clone();
                if (this.aAX != null) {
                    this.aAX.b(rtcRoomId, clone, ge);
                }
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        String str = null;
        com.baidu.live.alablmsdk.module.a.a aVar = null;
        com.baidu.live.alablmsdk.a.b.a.ak(" callee,  caller cancel invite ", "");
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.ge(rtcExt);
            } else {
                jSONObject = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aCp = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
        }
        if (this.aBT != null && this.aBT.CI() && !TextUtils.isEmpty(this.aBT.roomId) && this.aBT.roomId.equals(str) && this.aBT.aB(cVar.aCp)) {
            CF();
            if (this.aAX != null) {
                this.aAX.c(str, cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.CP().a(bIMRtcInfo.getRtcRoomId(), BLMSignalState.DEFAULT);
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerByFromOtherCallee(int i, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventSyncByOthers(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.module.c aA;
        JSONObject jSONObject = null;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo == null) {
            str = "";
            aVar = null;
        } else {
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.a.d(" 振铃|加入|离开 : roomEventType=" + roomEventType + " , extStr=" + rtcExt);
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.ge(rtcExt);
            } else {
                aVar = null;
            }
            str = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aCp = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (this.aBT != null && (aA = this.aBT.aA(cVar.aCp)) != null && !TextUtils.isEmpty(aA.order)) {
                    cVar.order = aA.order;
                }
            }
        }
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.d(" 对方的事件 : roomEventType=" + roomEventType + "  roomId=" + str + " , imUk=" + cVar.aCp);
        }
        com.baidu.live.alablmsdk.a.b.a.fY("roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str);
        if (gc(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                com.baidu.live.alablmsdk.a.b.a.ak(" signal： other ringing ", "");
                com.baidu.live.alablmsdk.module.b.CP().a(str, cVar.aCp, BLMSignalState.RING);
                if (this.aAX != null) {
                    this.aAX.a(str, cVar, jSONObject);
                    return;
                }
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.JOIN_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.ak(" signal： other join signal room", "");
                e(str, cVar);
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.EXIT_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.ak(" signal： other exit signal room", "");
                a(str, cVar, aVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" not current room chart do nothing", "");
    }

    private void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.a gd;
        if (cVar != null && (gd = com.baidu.live.alablmsdk.module.b.CP().gd(str)) != null) {
            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
            dVar.aCy = cVar.clone();
            dVar.b(BLMSignalState.JOINED);
            gd.a(dVar, BLMStateType.SIGNAL);
        }
    }

    private void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.module.a.a aVar) {
        if (cVar != null) {
            com.baidu.live.alablmsdk.a.b.a.ak("handleSignalUserLeave roomId " + str, " , callbackUser = " + cVar.toString());
            if (this.aBT != null && !TextUtils.isEmpty(this.aBT.roomId) && this.aBT.roomId.equals(str) && this.aBT.CI()) {
                com.baidu.live.alablmsdk.a.b.a.ak(" handleSignalUserLeave ，remove otherImUk ", "");
                this.aBT.ay(cVar.aCp);
                if (aVar != null && aVar.aCF) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" handleSignalUserLeave ，hasStatusCheckInfoKey reture ", "");
                } else if (this.aAX != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" handleSignalUserLeave ，onRoomUserLeaved callback ", "");
                    this.aAX.c(str, cVar);
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
        com.baidu.live.alablmsdk.module.c CM;
        com.baidu.live.alablmsdk.a.b.a.ak(" roomKickedUserFromKickerSync ", "");
        if (bIMKickReqSyncRtcInfo != null) {
            try {
                j = bIMKickReqSyncRtcInfo.getBIMKickedUsers().uk;
                try {
                    com.baidu.live.alablmsdk.a.b.a.ak(" roomKickedUserFromKickerSync kickedImUk=" + j, "");
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                j = 0;
            }
            if (this.aBT != null && (CM = this.aBT.CM()) != null && CM.aCp != 0 && CM.aCp == j) {
                av(j);
                return 1;
            }
        }
        return 0;
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.ak(" roomEventKickedStatusByKickedUser ", "");
        if (bIMKickResSyncRtcInfo != null) {
            long j = 0;
            try {
                j = bIMKickResSyncRtcInfo.getBIMKickedUsers().uk;
                com.baidu.live.alablmsdk.a.b.a.ak(" roomEventKickedStatusByKickedUser kickedThirdUserId=" + j, "");
            } catch (Exception e) {
            }
            aw(j);
        }
    }

    private void av(long j) {
        String str;
        com.baidu.live.alablmsdk.module.c cVar = null;
        com.baidu.live.alablmsdk.a.b.a.fY(" handleCurrentUserKicked ");
        if (this.aBT != null) {
            str = this.aBT.roomId;
            com.baidu.live.alablmsdk.module.c CM = this.aBT.CM();
            if (CM != null) {
                cVar = CM.clone();
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCp = j;
            }
        } else {
            str = null;
        }
        CD();
        if (this.aAX != null) {
            com.baidu.live.alablmsdk.a.b.a.ak(" current, onRoomUserKickoffed call back", "");
            this.aAX.d(str, cVar);
        }
    }

    private void aw(long j) {
        String str;
        com.baidu.live.alablmsdk.module.c cVar = null;
        com.baidu.live.alablmsdk.a.b.a.ak(" handleOtherUserKicked uk=" + j, "");
        if (this.aBT != null) {
            str = this.aBT.roomId;
            com.baidu.live.alablmsdk.module.c aA = this.aBT.aA(j);
            if (aA != null) {
                cVar = aA.clone();
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCp = j;
            }
        } else {
            str = null;
        }
        if (this.aBT != null) {
            this.aBT.ay(j);
        }
        if (this.aAX != null) {
            com.baidu.live.alablmsdk.a.b.a.ak(" other, onRoomUserKickoffed call back", "");
            this.aAX.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void dN(int i) {
        com.baidu.live.alablmsdk.a.b.a.ak(" onRtcCurrentUserStreamChange status " + i, "");
        if (i == 2) {
            this.aCa.CA();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void g(int i, String str) {
        if (i == 0) {
            com.baidu.live.alablmsdk.a.b.a.ak(" onRtcCurrentUserJoinRoomStatus success msg " + str, "");
            this.aCa.CB();
            if (this.aCe != null) {
                this.aCe.f(6, 0, str);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" onRtcCurrentUserJoinRoomStatus fail msg " + str, "");
        if (this.aCe != null) {
            this.aCe.f(6, -1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void onRoomEventUpdate(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.ak(" rtc onRoomEventUpdate roomEvents " + i, " , imUK=" + j + " , extra_info=" + str);
        a(i, j, str);
    }

    private void a(int i, long j, String str) {
        if (this.aBT != null) {
            if (!TextUtils.isEmpty(this.aBT.roomId)) {
                if (this.aBT.CI()) {
                    if (this.aBT.ax(j) || (j == 0 && i == 100)) {
                        b(i, j, str);
                        return;
                    }
                    c(i, j, str);
                    if (this.aBT.aB(j)) {
                        d(i, j, str);
                        return;
                    } else {
                        e(i, j, str);
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ak(" handleRtc hasStartedTransaction is false ", "imUk=" + j);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ak(" handleRtc mCurrentChatInfo.roomId is empty", "imUk=" + j);
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" handleRtc mCurrentChatInfo is null", "imUk=" + j);
    }

    private void b(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.ak(" handleRtcCurrentUser ", "imUk=" + j + "  extraInfo=" + str);
        if (this.aBT == null) {
            com.baidu.live.alablmsdk.a.b.a.ak(" handleRtcCurrentUser mCurrentChatInfo info error", "");
        } else if (i == 100) {
            if (this.aBT.aCq != null && this.aBT.aCq.aCy != null && !TextUtils.isEmpty(this.aBT.aCq.aCy.order)) {
                String b = com.baidu.live.alablmsdk.module.a.b.b(this.aBT.aCq.aCy);
                this.aCb.setUserAttribute(b);
                com.baidu.live.alablmsdk.a.b.a.d(" setUserAttribute " + b);
            }
            if (this.aCb.Db()) {
                com.baidu.live.alablmsdk.a.b.c.BY().Ca();
            }
        } else if (i == 115) {
            com.baidu.live.alablmsdk.a.b.a.ak("rtc current user kicked ，do rtc leave room ", "");
            this.aCb.Df();
        }
    }

    private void c(int i, long j, String str) {
        if (i == 300 && this.aBT.CH() == UserPermission.VISITER) {
            if (this.aBT.az(j) == null) {
                com.baidu.live.alablmsdk.a.b.a.fY(" not current user, permission is visiter, add other list");
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCp = j;
                dVar.aCy = cVar;
                this.aBT.a(dVar, BLMStateType.NONE);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.fY(" not current user, permission is visiter, has include the other");
        }
    }

    private void d(int i, long j, String str) {
        com.baidu.live.alablmsdk.module.c cVar;
        com.baidu.live.alablmsdk.a.b.a.ak(" handleRtcHasIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
        if (j != 0 && this.aBT != null) {
            com.baidu.live.alablmsdk.module.d az = this.aBT.az(j);
            com.baidu.live.alablmsdk.module.c aA = this.aBT.aA(j);
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.aCp = j;
            if (aA != null) {
                aVar.order = aA.order;
            }
            com.baidu.live.alablmsdk.a.b.a.ak(" current transaction  yes ", "");
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.a.ak("remote join  invite join or reJoin rtc", "");
                if (az != null) {
                    if (az.CR() == BLMRtcState.DEFAULT) {
                        if (aA != null && aA.aCw != 0 && this.aBT.CM() != null && aA.aCw == this.aBT.CM().aCp) {
                            com.baidu.live.alablmsdk.a.b.c.BY().dL(1);
                            com.baidu.live.alablmsdk.a.b.c.BY().Ch();
                        } else if (this.aBT.CM() != null && this.aBT.CM().aCw == 0 && !this.aCf) {
                            this.aCf = true;
                            com.baidu.live.alablmsdk.a.b.c.BY().dL(0);
                            com.baidu.live.alablmsdk.a.b.c.BY().Ch();
                        }
                    }
                    az.b(BLMRtcState.JOINED);
                }
                if (this.aAX != null) {
                    if (aA != null) {
                        cVar = aA.clone();
                    } else {
                        cVar = new com.baidu.live.alablmsdk.module.c();
                        cVar.aCp = j;
                    }
                    this.aAX.b(this.aBT.roomId, cVar);
                }
            } else if (i == 303) {
                com.baidu.live.alablmsdk.a.b.a.ak("rtc remote attribute arrive", "");
                if (this.aBT != null) {
                    this.aBT.e(j, str);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.a.ak("rtc remote user leave", "");
                if (az != null) {
                    az.b(BLMRtcState.LEAVE);
                }
            } else if (i == 106) {
                if (az != null) {
                    az.b(BLMRtcState.STREAM);
                }
                String str2 = "";
                if (aVar != null) {
                    str2 = aVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.ak("rtc remote stream arrival , streamInfo=" + str2, "");
                if (this.aCd != null) {
                    this.aCd.b(true, j);
                }
                if (this.aAX != null) {
                    this.aAX.a(aVar, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                }
                this.aCa.au(j);
            } else if (i == 107) {
                if (az != null) {
                    az.b(BLMRtcState.STREAM_NO);
                }
                com.baidu.live.alablmsdk.a.b.a.ak("rtc remote stream leave", "");
                if (this.aAX != null) {
                    this.aAX.a(aVar, BLMStreamState.BLMSTREAMSTATE_REMOVE);
                }
                this.aCa.at(j);
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.a.ak("rtc other user kicked, include  don nothing", "imUk = " + j);
            }
        }
    }

    public void e(int i, long j, String str) {
        if (j != 0) {
            com.baidu.live.alablmsdk.a.b.a.ak(" handleRtcHasNotIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.a.ak("remote join :  invite join or reJoin rtc", "");
                if (this.aBT.CH() == UserPermission.OWNER && this.aCb != null) {
                    this.aCb.aG(j);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.a.ak("remote user leave", "");
            } else if (i == 106) {
                com.baidu.live.alablmsdk.a.b.a.ak("remote stream arrival", "");
                if (this.aBT.CH() == UserPermission.OWNER && this.aCb != null) {
                    this.aCb.aG(j);
                }
            } else if (i == 107) {
                com.baidu.live.alablmsdk.a.b.a.ak("remote stream leave", "");
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.a.ak(" un include, other user kicked ", "imUk = " + j);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.b.b.a
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.aAX != null) {
            this.aAX.a(aVar, i);
        }
    }

    public void CF() {
        com.baidu.live.alablmsdk.a.b.a.ak(" resetCurrentChat ", "");
        this.aBT = null;
        this.aCf = false;
        com.baidu.live.alablmsdk.module.b.CP().clearAll();
    }

    public boolean gc(String str) {
        return (this.aBT == null || TextUtils.isEmpty(this.aBT.roomId) || !this.aBT.roomId.equals(str)) ? false : true;
    }

    public void CG() {
        com.baidu.live.alablmsdk.a.b.a.ak("stop all stream leave count down", "");
        this.aCa.CC();
        this.aCa.CB();
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BMLSignalRtcSyncManager  release ");
        com.baidu.live.alablmsdk.a.b.a.fY(" BMLSignalRtcSyncManager  release ");
        this.aCe = null;
        this.aAX = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.aBO != null) {
            this.aBO.release();
            this.aBO = null;
        }
        if (this.aCa != null) {
            this.aCa.release();
        }
        if (this.aCb != null) {
            this.aCb.release();
            this.aCb = null;
        }
        if (this.aCd != null) {
            this.aCd.release();
        }
        if (this.aBZ != null) {
            this.aBZ.release();
        }
        CF();
        CG();
        e.BU().release();
        com.baidu.live.alablmsdk.a.b.a.release();
        com.baidu.live.alablmsdk.a.b.c.BY().release();
    }

    @Override // com.baidu.live.alablmsdk.a.b.d
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.aAX != null) {
            this.aAX.onLogReport(str, jSONObject, jSONObject2);
        }
    }
}
