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
/* loaded from: classes11.dex */
public class c implements BIMRtcListener, IConnectListener, ILiveMsgReceiveListener, d, b.a, com.baidu.live.alablmsdk.c.b.a {
    private com.baidu.live.alablmsdk.c.b aBo;
    private com.baidu.live.alablmsdk.e.b aCf;
    public com.baidu.live.alablmsdk.module.a aCk;
    private a aCq;
    private b aCr;
    private com.baidu.live.alablmsdk.d.c aCs;
    private com.baidu.live.alablmsdk.d.b aCt;
    private com.baidu.live.alablmsdk.d.a aCu;
    private com.baidu.live.alablmsdk.c.c aCv;
    private boolean aCw;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a.a(this);
        com.baidu.live.alablmsdk.a.b.c.Bp().b(this);
        this.aCf = new com.baidu.live.alablmsdk.e.b(context, this);
        this.aCq = new a(this.aCf);
        this.aCq.BN();
        this.aCr = new b(this);
        this.aCs = new com.baidu.live.alablmsdk.d.c(context);
        this.aCs.a(this);
        this.aCt = new com.baidu.live.alablmsdk.d.b(this.aCs);
        this.aCu = new com.baidu.live.alablmsdk.d.a(context, this.aCs);
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aBo = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        this.aCr.w(hashMap);
        this.aCs.v(hashMap);
        this.aCf.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aCs.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Bi() {
        return this.aCu;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.aCf.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.d("createRoom onResult responseCode = " + i + " , errorMessage = " + str);
                    com.baidu.live.alablmsdk.a.b.a.fI("createRoom onResult code " + i + " message " + str);
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        com.baidu.live.alablmsdk.a.b.a.d("createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        c.this.c(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId);
                        c.this.aCf.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                com.baidu.live.alablmsdk.a.b.a.d(" signal join onResult , responseCode=" + i2 + " , errorMessage=" + str2);
                                com.baidu.live.alablmsdk.a.b.a.fI(" signal join onResult code " + i2 + " message " + str2);
                                if (i2 == 0) {
                                    if (c.this.aCk != null) {
                                        c.this.aCk.a(BLMSignalState.JOINED);
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
        this.aCk = new com.baidu.live.alablmsdk.module.a();
        this.aCk.roomId = str;
        this.aCk.token = str2;
        this.aCk.rtcAppId = str3;
        this.aCk.aCG = j;
        com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.aCG = j;
        cVar.aCL = UserPermission.OWNER;
        dVar.aCP = cVar;
        this.aCk.aCH = dVar;
        com.baidu.live.alablmsdk.a.b.c.Bp().setRtcRoomId(this.aCk.roomId);
        if (this.aCq != null) {
            a aVar = this.aCq;
            a.fK(this.aCk.roomId);
            this.aCq.a(str, this.aCk.BY());
        }
        com.baidu.live.alablmsdk.module.b.Cg().c(this.aCk);
        if (this.aCr != null) {
            this.aCr.a(this.aCk);
        }
    }

    public void a(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aCf.c(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.3
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (i2 == 0 && c.this.aCk != null && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list.size()) {
                            break;
                        }
                        com.baidu.live.alablmsdk.module.c cVar2 = (com.baidu.live.alablmsdk.module.c) list.get(i4);
                        if (cVar2 != null) {
                            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                            dVar.aCP = cVar2.clone();
                            if (c.this.aCk.Cd() != null) {
                                dVar.aCP.aCN = c.this.aCk.Cd().aCG;
                            }
                            dVar.b(BLMRtcState.DEFAULT);
                            c.this.aCk.a(dVar, BLMStateType.SIGNAL);
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
        this.aCf.d(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.4
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if ((i2 == 0 || i2 == -1) && c.this.aCk != null) {
                    c.this.aCk.u(list);
                    if (c.this.aCk.Cc()) {
                        c.this.BW();
                    }
                }
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.aj(" acceptRoom ", " , extJson=" + jSONObject);
        this.aCf.e(str, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.Cg().a(str, BLMSignalState.JOINED);
                    c.this.a(str, false, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void f(int i3, int i4, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.d(" visiter join room， status=" + i4 + " , msg" + str3);
                            com.baidu.live.alablmsdk.a.b.a.fI(" visiter join room， status " + i4 + " msg " + str3);
                            if (i4 == 0) {
                                com.baidu.live.alablmsdk.module.b.Cg().a(str, BLMRtcState.JOINED);
                                if (cVar != null) {
                                    cVar.f(4, 0, "acceptRoom join rtc room success");
                                    return;
                                }
                                return;
                            }
                            com.baidu.live.alablmsdk.module.b.Cg().a(str, BLMRtcState.FAIL);
                            c.this.fL(str);
                            com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join rtc room error ; msg = " + str3);
                            com.baidu.live.alablmsdk.a.b.a.fI("acceptRoom join rtc room error msg " + str3);
                            if (cVar != null) {
                                cVar.f(4, -1, "acceptRoom join rtc room error ; msg = " + str3);
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join signal room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.a.fI("acceptRoom join signal room error msg " + str2);
                c.this.BW();
                if (cVar != null) {
                    cVar.f(4, -1, "acceptRoom join signal room error ; msg = " + str2);
                }
            }
        });
    }

    private JSONObject t(JSONObject jSONObject) {
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        if (this.aCk != null && this.aCk.aCH != null && this.aCk.aCH.aCP != null) {
            com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
            bVar.aCG = this.aCk.aCH.aCP.aCG;
            bVar.order = this.aCk.aCH.aCP.order;
            aVar.aCV = com.baidu.live.alablmsdk.module.a.b.a(bVar);
        }
        JSONObject t = aVar.t(jSONObject);
        if (t == null) {
            return new JSONObject();
        }
        return t;
    }

    public void b(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.aCf.f(str, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.6
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                c.this.BW();
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
                com.baidu.live.alablmsdk.a.b.a.fI(" owner join room status " + i2 + " msg" + str2);
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.Cg().a(str, BLMRtcState.JOINED);
                    if (cVar2 != null) {
                        cVar2.f(4, 0, "acceptRoom join rtc room success");
                        return;
                    }
                    return;
                }
                com.baidu.live.alablmsdk.module.b.Cg().a(str, BLMRtcState.FAIL);
                c.this.b(str, (JSONObject) null, false, (com.baidu.live.alablmsdk.c.c) null);
                com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join rtc room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.a.fI("acceptRoom join rtc room error msg " + str2);
                if (cVar2 != null) {
                    cVar2.f(4, -1, "acceptRoom join rtc room error ; msg = " + str2);
                }
            }
        });
    }

    private void a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null && this.aCk != null && this.aCk.aCH != null && this.aCk.aCH.aCP != null) {
            this.aCk.aCH.aCP.order = cVar.order;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.module.c Cd;
        this.aCv = cVar;
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.a.b.a.aj("joinRoom param error, roomId isEmpty", "");
            if (this.aCv != null) {
                this.aCv.f(6, 1000, "joinRoom param error, roomId isEmpty");
                return;
            }
            return;
        }
        if (z && this.aCk != null && this.aCk.Cb() == BLMSignalState.DEFAULT) {
            com.baidu.live.alablmsdk.a.b.c.Bp().Bt();
        }
        com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.Cg().fN(str);
        if (fN == null) {
            com.baidu.live.alablmsdk.a.b.a.aj("joinRoom param error getChatInfo null ", "");
            if (this.aCv != null) {
                this.aCv.f(6, 1000, "join rtc room param error , getChatInfo null");
            }
        } else if (!com.baidu.live.alablmsdk.module.a.b(fN)) {
            com.baidu.live.alablmsdk.a.b.a.aj("joinRoom chatInfo check error", "");
            if (this.aCv != null) {
                this.aCv.f(6, 1000, "joinRoom chatInfo check error");
            }
        } else {
            if (this.aCk != null && (Cd = this.aCk.Cd()) != null && !TextUtils.isEmpty(Cd.order)) {
                this.aCs.fR(Cd.order);
            }
            this.aCs.d(str, fN.token, fN.rtcAppId, fN.aCG);
        }
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        if (this.aCs != null && !TextUtils.isEmpty(this.aCs.Cq()) && this.aCs.Cq().equals(str) && !com.baidu.live.alablmsdk.a.a.isEmpty(list) && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.module.c cVar2 = list.get(0);
            this.aCs.aF(cVar2.aCG);
            this.aCf.a(str, cVar2, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.8
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

    public void bd(boolean z) {
        if (this.aCt != null) {
            com.baidu.live.alablmsdk.a.b.a.d("muteMicrophone " + z);
            com.baidu.live.alablmsdk.a.b.a.fI("muteMicrophone " + z);
            this.aCt.bd(z);
        }
    }

    private void BU() {
        com.baidu.live.alablmsdk.a.b.a.aj(" currentKickedOffLeave ", "");
        if (this.aCs != null) {
            this.aCs.Cw();
        }
        BX();
        BW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(String str) {
        a(str, com.baidu.live.alablmsdk.module.a.a.Cm(), false, (com.baidu.live.alablmsdk.c.c) null);
    }

    public void a(String str, JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d(" leaveRoom");
        com.baidu.live.alablmsdk.a.b.a.fI(" leaveRoom ");
        if (z) {
            if (this.aCk != null && this.aCk.BZ() && !this.aCk.Cc()) {
                com.baidu.live.alablmsdk.a.b.c.Bp().bg(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.Bp().bg(false);
            }
            com.baidu.live.alablmsdk.a.b.c.Bp().Bz();
        }
        this.aCs.Cw();
        this.aCf.a(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" leaveRoom onResult ，responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.a.fI(" leaveRoom onResult code " + i + " message " + str2);
                if (i == 0) {
                    if (c.this.aCq != null) {
                        c.this.aCq.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (cVar != null) {
                        cVar.f(7, 0, "leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (c.this.aCq != null) {
                    c.this.aCq.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (cVar != null) {
                    cVar.f(7, -1, "leaveRoom hangout signal fail");
                }
            }
        });
        BX();
        BW();
    }

    public void b(final String str, final JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.aj(" closeRoom roomId " + str, "");
        if (z) {
            if (this.aCk != null && this.aCk.BZ() && !this.aCk.Cc()) {
                com.baidu.live.alablmsdk.a.b.c.Bp().bg(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.Bp().bg(false);
            }
            com.baidu.live.alablmsdk.a.b.c.Bp().BA();
        }
        com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.Cg().fN(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (fN != null) {
            userPermission = fN.BY();
        }
        com.baidu.live.alablmsdk.a.b.a.d(" closeRoom permission=" + userPermission);
        com.baidu.live.alablmsdk.a.b.a.fI(" closeRoom permission " + userPermission);
        if (userPermission == UserPermission.OWNER) {
            this.aCs.Cv();
            if (this.aCs.Cs()) {
                com.baidu.live.alablmsdk.a.b.c.Bp().pushEnd();
            }
        } else {
            this.aCs.Cw();
        }
        this.aCf.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" closeRoom-signal hangout  responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.a.fI(" closeRoom-signal hangout code " + i + " errorMessage " + str2);
                if (userPermission == UserPermission.OWNER) {
                    com.baidu.live.alablmsdk.a.b.a.d(" signal close ");
                    com.baidu.live.alablmsdk.a.b.a.fI(" signal close ");
                    c.this.aCf.b(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.d(" signal closeRoom , responseCode=" + i2 + " , errorMessage=" + str3);
                            com.baidu.live.alablmsdk.a.b.a.fI(" signal closeRoom code " + i2 + " errorMessage " + str3);
                            if (i2 == 0) {
                                if (c.this.aCq != null) {
                                    c.this.aCq.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (cVar != null) {
                                    cVar.f(8, 0, "closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (c.this.aCq != null) {
                                c.this.aCq.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (cVar != null) {
                                cVar.f(8, -1, "closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        BW();
        BX();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        com.baidu.live.alablmsdk.a.b.a.d(" b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        com.baidu.live.alablmsdk.a.b.a.d(" im 连接状态 responseCode = " + i);
        com.baidu.live.alablmsdk.a.b.a.fI(" im long connection code " + i);
        dJ(i);
    }

    private void dJ(int i) {
        if (i == 0) {
            if (this.aCk != null) {
                BV();
            } else if (this.aCk == null) {
                this.aCq.BM();
            }
        }
    }

    private void BV() {
        com.baidu.live.alablmsdk.a.b.a.aj(" reJoinSignalAndRtcRoomInner ", "");
        if (this.aCk != null) {
            this.aCf.join(this.aCk.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str, "");
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.aj(" reJoinSignalAndRtcRoomInner signal join success", "");
                        c.this.aCs.CB();
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.aj(" reJoinSignalAndRtcRoomInner signal join fail", "");
                }
            });
        } else {
            com.baidu.live.alablmsdk.a.b.a.aj(" reJoinSignalAndRtcRoomInner mCurrentChatInfo==null", "");
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
        if (i == 89) {
            com.baidu.live.alablmsdk.a.b.a.d(" signal onRtcResult room closed ");
            com.baidu.live.alablmsdk.a.b.a.fI(" signal onRtcResult room closed ");
            String str = "";
            if (bIMRtcInfo != null) {
                str = bIMRtcInfo.getRtcRoomId();
            }
            if (this.aCk != null && !TextUtils.isEmpty(this.aCk.roomId) && this.aCk.roomId.equals(str)) {
                BW();
            }
            if (this.aBo != null) {
                com.baidu.live.alablmsdk.a.b.a.d(" room closed callback ,  roomId=" + str);
                com.baidu.live.alablmsdk.a.b.a.fI(" room closed callback roomId " + str);
                this.aBo.fH(str);
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
                cVar.aCG = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" caller invite time out", " , other imUk=" + cVar.aCG);
        if (this.aCk != null && this.aCk.BZ()) {
            if (this.aCk.aA(cVar.aCG)) {
                com.baidu.live.alablmsdk.module.b.Cg().a(str, cVar.aCG, BLMSignalState.TIMEOUT);
                com.baidu.live.alablmsdk.a.b.c.Bp().Bx();
                if (this.aBo != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" caller invite time out callback ", "");
                    this.aBo.a(str, cVar);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.c.Bp().Bx();
            if (this.aBo != null) {
                com.baidu.live.alablmsdk.a.b.a.aj(" caller invite time out, check imUk error, but callback ", "");
                this.aBo.a(str, cVar);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" caller invite time out not callback ", "");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerGetAnswerSyncByCallee(int i, BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        long j;
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.a.b.a.aj(" roomCallerGetAnswerSyncByCallee ", "");
        long j2 = 0;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo == null) {
            jSONObject = null;
            j = 0;
            str = null;
        } else {
            str = bIMRtcInfo.getRtcRoomId();
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.a.d(" roomCallerGetAnswerSyncByCallee ext=" + rtcExt);
            if (rtcExt != null) {
                com.baidu.live.alablmsdk.module.a.a aVar2 = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar2.fO(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                BIMSyncRtcInfo bIMSyncRtcInfo = (BIMSyncRtcInfo) bIMRtcInfo;
                j2 = bIMSyncRtcInfo.getInitiatorUk();
                cVar.aCG = bIMSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (!TextUtils.isEmpty(str) && this.aCk != null && !TextUtils.isEmpty(this.aCk.roomId) && this.aCk.roomId.equals(str)) {
                    com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                    dVar.aCP = cVar.clone();
                    this.aCk.a(dVar, BLMStateType.SIGNAL);
                }
                com.baidu.live.alablmsdk.a.b.a.aj(" caller receive callee response", " callee 的 uk=" + cVar.aCG);
            }
            j = j2;
        }
        if (i == 1) {
            com.baidu.live.alablmsdk.a.b.a.aj(" caller，callee answer ok", "");
            com.baidu.live.alablmsdk.module.b.Cg().a(str, j, BLMSignalState.JOINED);
            if (this.aBo != null) {
                com.baidu.live.alablmsdk.a.b.a.aj(" caller，callee answer ok callback", "");
                this.aBo.d(str, cVar, jSONObject);
            }
        } else if (i == 2) {
            com.baidu.live.alablmsdk.a.b.a.aj(" caller，callee answer no", "");
            com.baidu.live.alablmsdk.module.b.Cg().a(str, j, BLMSignalState.REJECT);
            com.baidu.live.alablmsdk.a.b.c.Bp().Bw();
            if (this.aBo != null) {
                com.baidu.live.alablmsdk.a.b.a.aj(" caller，callee answer no callback", "");
                this.aBo.e(str, cVar, jSONObject);
            }
        } else if (i == 3) {
            com.baidu.live.alablmsdk.a.b.a.aj(" caller，callee answer timeout 30s", "");
            com.baidu.live.alablmsdk.module.b.Cg().a(str, j, BLMSignalState.TIMEOUT);
            com.baidu.live.alablmsdk.a.b.c.Bp().Bx();
            if (this.aBo != null) {
                com.baidu.live.alablmsdk.a.b.a.aj(" caller，callee answer timeout 30s callback", "");
                this.aBo.a(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.d(" 被叫方接收到邀请(解析 rtc room 的相关信息，");
        com.baidu.live.alablmsdk.a.b.a.fI(" callee receive invite ");
        if (bIMRtcInfo != null && (bIMRtcInfo instanceof BIMInviteSyncRtcInfo)) {
            BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = (BIMInviteSyncRtcInfo) bIMRtcInfo;
            String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
            com.baidu.live.alablmsdk.a.b.a.aj(" callee receive invite roomId " + rtcRoomId, "");
            if (!TextUtils.isEmpty(rtcRoomId)) {
                if (this.aCk != null && this.aCk.roomId != null && !this.aCk.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.a.b.a.d(" callee get invite. mCurrentChatInfo.roomId != roomId , return。  mCurrentChatInfo.roomId=" + this.aCk.roomId);
                    com.baidu.live.alablmsdk.a.b.a.fI(" callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.aCk.roomId);
                    return;
                }
                com.baidu.live.alablmsdk.a.b.c.Bp().setRtcRoomId(rtcRoomId);
                String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
                com.baidu.live.alablmsdk.a.b.a.d(" callee receive invite,  originalExt=" + rtcExt);
                com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
                JSONObject fO = aVar.fO(rtcExt);
                com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.Cg().fN(rtcRoomId);
                if (fN == null) {
                    fN = new com.baidu.live.alablmsdk.module.a();
                }
                fN.roomId = rtcRoomId;
                fN.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                fN.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                fN.aCG = bIMInviteSyncRtcInfo.getRtcUserId();
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCG = fN.aCG;
                cVar.aCL = UserPermission.VISITER;
                cVar.aCN = bIMInviteSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                dVar.aCP = cVar;
                dVar.b(BLMSignalState.RING);
                fN.aCH = dVar;
                com.baidu.live.alablmsdk.module.d dVar2 = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.aCG = bIMInviteSyncRtcInfo.getInitiatorUk();
                cVar2.aCL = UserPermission.OWNER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar2, aVar);
                dVar2.aCP = cVar2;
                dVar2.b(BLMSignalState.JOINED);
                fN.a(dVar2, BLMStateType.SIGNAL);
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("callee 收到邀请 ， " + fN.Ca());
                }
                this.aCk = fN;
                com.baidu.live.alablmsdk.module.b.Cg().c(fN);
                if (this.aCr != null) {
                    this.aCr.a(this.aCk);
                }
                if (this.aCq != null) {
                    a aVar2 = this.aCq;
                    a.fK(fN.roomId);
                    this.aCq.a(fN.roomId, fN.BY());
                }
                com.baidu.live.alablmsdk.module.c clone = cVar2.clone();
                if (this.aBo != null) {
                    this.aBo.b(rtcRoomId, clone, fO);
                }
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.a.b.a.aj(" callee,  caller cancel invite ", "");
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.fO(rtcExt);
            } else {
                aVar = null;
                jSONObject = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aCG = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
            str = null;
        }
        if (this.aCk != null && this.aCk.BZ() && !TextUtils.isEmpty(this.aCk.roomId) && this.aCk.roomId.equals(str) && this.aCk.aA(cVar.aCG)) {
            BW();
            if (this.aBo != null) {
                this.aBo.c(str, cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.Cg().a(bIMRtcInfo.getRtcRoomId(), BLMSignalState.DEFAULT);
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerByFromOtherCallee(int i, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventSyncByOthers(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.module.c az;
        String str = "";
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.a.d(" 振铃|加入|离开 : roomEventType=" + roomEventType + " , extStr=" + rtcExt);
            if (rtcExt != null) {
                com.baidu.live.alablmsdk.module.a.a aVar2 = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar2.fO(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.aCG = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (this.aCk != null && (az = this.aCk.az(cVar.aCG)) != null && !TextUtils.isEmpty(az.order)) {
                    cVar.order = az.order;
                }
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
            aVar = null;
        }
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.d(" 对方的事件 : roomEventType=" + roomEventType + "  roomId=" + str + " , imUk=" + cVar.aCG);
        }
        com.baidu.live.alablmsdk.a.b.a.fI("roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str);
        if (fM(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                com.baidu.live.alablmsdk.a.b.a.aj(" signal： other ringing ", "");
                com.baidu.live.alablmsdk.module.b.Cg().a(str, cVar.aCG, BLMSignalState.RING);
                if (this.aBo != null) {
                    this.aBo.a(str, cVar, jSONObject);
                    return;
                }
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.JOIN_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.aj(" signal： other join signal room", "");
                e(str, cVar);
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.EXIT_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.aj(" signal： other exit signal room", "");
                a(str, cVar, aVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" not current room chart do nothing", "");
    }

    private void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.a fN;
        if (cVar != null && (fN = com.baidu.live.alablmsdk.module.b.Cg().fN(str)) != null) {
            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
            dVar.aCP = cVar.clone();
            dVar.b(BLMSignalState.JOINED);
            fN.a(dVar, BLMStateType.SIGNAL);
        }
    }

    private void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.module.a.a aVar) {
        if (cVar != null) {
            com.baidu.live.alablmsdk.a.b.a.aj("handleSignalUserLeave roomId " + str, " , callbackUser = " + cVar.toString());
            if (this.aCk != null && !TextUtils.isEmpty(this.aCk.roomId) && this.aCk.roomId.equals(str) && this.aCk.BZ()) {
                com.baidu.live.alablmsdk.a.b.a.aj(" handleSignalUserLeave ，remove otherImUk ", "");
                this.aCk.ax(cVar.aCG);
                if (aVar != null && aVar.aCW) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" handleSignalUserLeave ，hasStatusCheckInfoKey reture ", "");
                } else if (this.aBo != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" handleSignalUserLeave ，onRoomUserLeaved callback ", "");
                    this.aBo.c(str, cVar);
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
        com.baidu.live.alablmsdk.module.c Cd;
        com.baidu.live.alablmsdk.a.b.a.aj(" roomKickedUserFromKickerSync ", "");
        if (bIMKickReqSyncRtcInfo != null) {
            try {
                j = bIMKickReqSyncRtcInfo.getBIMKickedUsers().uk;
                try {
                    com.baidu.live.alablmsdk.a.b.a.aj(" roomKickedUserFromKickerSync kickedImUk=" + j, "");
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                j = 0;
            }
            if (this.aCk != null && (Cd = this.aCk.Cd()) != null && Cd.aCG != 0 && Cd.aCG == j) {
                au(j);
                return 1;
            }
        }
        return 0;
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.aj(" roomEventKickedStatusByKickedUser ", "");
        if (bIMKickResSyncRtcInfo != null) {
            long j = 0;
            try {
                j = bIMKickResSyncRtcInfo.getBIMKickedUsers().uk;
                com.baidu.live.alablmsdk.a.b.a.aj(" roomEventKickedStatusByKickedUser kickedThirdUserId=" + j, "");
            } catch (Exception e) {
            }
            av(j);
        }
    }

    private void au(long j) {
        com.baidu.live.alablmsdk.module.c cVar;
        String str;
        com.baidu.live.alablmsdk.a.b.a.fI(" handleCurrentUserKicked ");
        if (this.aCk != null) {
            String str2 = this.aCk.roomId;
            com.baidu.live.alablmsdk.module.c Cd = this.aCk.Cd();
            if (Cd != null) {
                cVar = Cd.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCG = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        BU();
        if (this.aBo != null) {
            com.baidu.live.alablmsdk.a.b.a.aj(" current, onRoomUserKickoffed call back", "");
            this.aBo.d(str, cVar);
        }
    }

    private void av(long j) {
        com.baidu.live.alablmsdk.module.c cVar;
        String str;
        com.baidu.live.alablmsdk.a.b.a.aj(" handleOtherUserKicked uk=" + j, "");
        if (this.aCk != null) {
            String str2 = this.aCk.roomId;
            com.baidu.live.alablmsdk.module.c az = this.aCk.az(j);
            if (az != null) {
                cVar = az.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCG = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        if (this.aCk != null) {
            this.aCk.ax(j);
        }
        if (this.aBo != null) {
            com.baidu.live.alablmsdk.a.b.a.aj(" other, onRoomUserKickoffed call back", "");
            this.aBo.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void dK(int i) {
        com.baidu.live.alablmsdk.a.b.a.aj(" onRtcCurrentUserStreamChange status " + i, "");
        if (i == 2) {
            this.aCr.BR();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void g(int i, String str) {
        if (i == 0) {
            com.baidu.live.alablmsdk.a.b.a.aj(" onRtcCurrentUserJoinRoomStatus success msg " + str, "");
            this.aCr.BS();
            if (this.aCv != null) {
                this.aCv.f(6, 0, str);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" onRtcCurrentUserJoinRoomStatus fail msg " + str, "");
        if (this.aCv != null) {
            this.aCv.f(6, -1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void onRoomEventUpdate(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.aj(" rtc onRoomEventUpdate roomEvents " + i, " , imUK=" + j + " , extra_info=" + str);
        c(i, j, str);
    }

    private void c(int i, long j, String str) {
        if (this.aCk != null) {
            if (!TextUtils.isEmpty(this.aCk.roomId)) {
                if (this.aCk.BZ()) {
                    if (this.aCk.aw(j) || (j == 0 && i == 100)) {
                        d(i, j, str);
                        return;
                    }
                    e(i, j, str);
                    if (this.aCk.aA(j)) {
                        f(i, j, str);
                        return;
                    } else {
                        g(i, j, str);
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.aj(" handleRtc hasStartedTransaction is false ", "imUk=" + j);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.aj(" handleRtc mCurrentChatInfo.roomId is empty", "imUk=" + j);
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" handleRtc mCurrentChatInfo is null", "imUk=" + j);
    }

    private void d(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.aj(" handleRtcCurrentUser ", "imUk=" + j + "  extraInfo=" + str);
        if (this.aCk == null) {
            com.baidu.live.alablmsdk.a.b.a.aj(" handleRtcCurrentUser mCurrentChatInfo info error", "");
        } else if (i == 100) {
            if (this.aCk.aCH != null && this.aCk.aCH.aCP != null && !TextUtils.isEmpty(this.aCk.aCH.aCP.order)) {
                String b2 = com.baidu.live.alablmsdk.module.a.b.b(this.aCk.aCH.aCP);
                this.aCs.setUserAttribute(b2);
                com.baidu.live.alablmsdk.a.b.a.d(" setUserAttribute " + b2);
            }
            if (this.aCs.Cs()) {
                com.baidu.live.alablmsdk.a.b.c.Bp().Br();
            }
        } else if (i == 115) {
            com.baidu.live.alablmsdk.a.b.a.aj("rtc current user kicked ，do rtc leave room ", "");
            this.aCs.Cw();
        }
    }

    private void e(int i, long j, String str) {
        if (i == 300 && this.aCk.BY() == UserPermission.VISITER) {
            if (this.aCk.ay(j) == null) {
                com.baidu.live.alablmsdk.a.b.a.fI(" not current user, permission is visiter, add other list");
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.aCG = j;
                dVar.aCP = cVar;
                this.aCk.a(dVar, BLMStateType.NONE);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.fI(" not current user, permission is visiter, has include the other");
        }
    }

    private void f(int i, long j, String str) {
        com.baidu.live.alablmsdk.module.c cVar;
        com.baidu.live.alablmsdk.a.b.a.aj(" handleRtcHasIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
        if (j != 0 && this.aCk != null) {
            com.baidu.live.alablmsdk.module.d ay = this.aCk.ay(j);
            com.baidu.live.alablmsdk.module.c az = this.aCk.az(j);
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.aCG = j;
            if (az != null) {
                aVar.order = az.order;
            }
            com.baidu.live.alablmsdk.a.b.a.aj(" current transaction  yes ", "");
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.a.aj("remote join  invite join or reJoin rtc", "");
                if (ay != null) {
                    if (ay.Ci() == BLMRtcState.DEFAULT) {
                        if (az != null && az.aCN != 0 && this.aCk.Cd() != null && az.aCN == this.aCk.Cd().aCG) {
                            com.baidu.live.alablmsdk.a.b.c.Bp().dI(1);
                            com.baidu.live.alablmsdk.a.b.c.Bp().By();
                        } else if (this.aCk.Cd() != null && this.aCk.Cd().aCN == 0 && !this.aCw) {
                            this.aCw = true;
                            com.baidu.live.alablmsdk.a.b.c.Bp().dI(0);
                            com.baidu.live.alablmsdk.a.b.c.Bp().By();
                        }
                    }
                    ay.b(BLMRtcState.JOINED);
                }
                if (this.aBo != null) {
                    if (az != null) {
                        cVar = az.clone();
                    } else {
                        cVar = new com.baidu.live.alablmsdk.module.c();
                        cVar.aCG = j;
                    }
                    this.aBo.b(this.aCk.roomId, cVar);
                }
            } else if (i == 303) {
                com.baidu.live.alablmsdk.a.b.a.aj("rtc remote attribute arrive", "");
                if (this.aCk != null) {
                    this.aCk.e(j, str);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.a.aj("rtc remote user leave", "");
                if (ay != null) {
                    ay.b(BLMRtcState.LEAVE);
                }
            } else if (i == 106) {
                if (ay != null) {
                    ay.b(BLMRtcState.STREAM);
                }
                String str2 = "";
                if (aVar != null) {
                    str2 = aVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.aj("rtc remote stream arrival , streamInfo=" + str2, "");
                if (this.aCu != null) {
                    this.aCu.i(true, j);
                }
                if (this.aBo != null) {
                    this.aBo.a(aVar, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                }
                this.aCr.at(j);
            } else if (i == 107) {
                if (ay != null) {
                    ay.b(BLMRtcState.STREAM_NO);
                }
                com.baidu.live.alablmsdk.a.b.a.aj("rtc remote stream leave", "");
                if (this.aBo != null) {
                    this.aBo.a(aVar, BLMStreamState.BLMSTREAMSTATE_REMOVE);
                }
                this.aCr.as(j);
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.a.aj("rtc other user kicked, include  don nothing", "imUk = " + j);
            }
        }
    }

    public void g(int i, long j, String str) {
        if (j != 0) {
            com.baidu.live.alablmsdk.a.b.a.aj(" handleRtcHasNotIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.a.aj("remote join :  invite join or reJoin rtc", "");
                if (this.aCk.BY() == UserPermission.OWNER && this.aCs != null) {
                    this.aCs.aF(j);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.a.aj("remote user leave", "");
            } else if (i == 106) {
                com.baidu.live.alablmsdk.a.b.a.aj("remote stream arrival", "");
                if (this.aCk.BY() == UserPermission.OWNER && this.aCs != null) {
                    this.aCs.aF(j);
                }
            } else if (i == 107) {
                com.baidu.live.alablmsdk.a.b.a.aj("remote stream leave", "");
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.a.aj(" un include, other user kicked ", "imUk = " + j);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.b.b.a
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.aBo != null) {
            this.aBo.a(aVar, i);
        }
    }

    public void BW() {
        com.baidu.live.alablmsdk.a.b.a.aj(" resetCurrentChat ", "");
        this.aCk = null;
        this.aCw = false;
        com.baidu.live.alablmsdk.module.b.Cg().clearAll();
    }

    public boolean fM(String str) {
        return (this.aCk == null || TextUtils.isEmpty(this.aCk.roomId) || !this.aCk.roomId.equals(str)) ? false : true;
    }

    public void BX() {
        com.baidu.live.alablmsdk.a.b.a.aj("stop all stream leave count down", "");
        this.aCr.BT();
        this.aCr.BS();
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BMLSignalRtcSyncManager  release ");
        com.baidu.live.alablmsdk.a.b.a.fI(" BMLSignalRtcSyncManager  release ");
        this.aCv = null;
        this.aBo = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.aCf != null) {
            this.aCf.release();
            this.aCf = null;
        }
        if (this.aCr != null) {
            this.aCr.release();
        }
        if (this.aCs != null) {
            this.aCs.release();
            this.aCs = null;
        }
        if (this.aCu != null) {
            this.aCu.release();
        }
        if (this.aCq != null) {
            this.aCq.release();
        }
        BW();
        BX();
        e.Bl().release();
        com.baidu.live.alablmsdk.a.b.a.release();
        com.baidu.live.alablmsdk.a.b.c.Bp().release();
    }

    @Override // com.baidu.live.alablmsdk.a.b.d
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.aBo != null) {
            this.aBo.onLogReport(str, jSONObject, jSONObject2);
        }
    }
}
