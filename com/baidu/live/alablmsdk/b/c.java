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
/* loaded from: classes10.dex */
public class c implements BIMRtcListener, IConnectListener, ILiveMsgReceiveListener, d, b.a, com.baidu.live.alablmsdk.c.b.a {
    private com.baidu.live.alablmsdk.c.b awB;
    private a axD;
    private b axE;
    private com.baidu.live.alablmsdk.d.c axF;
    private com.baidu.live.alablmsdk.d.b axG;
    private com.baidu.live.alablmsdk.d.a axH;
    private com.baidu.live.alablmsdk.c.c axI;
    private boolean axJ;
    private com.baidu.live.alablmsdk.e.b axs;
    public com.baidu.live.alablmsdk.module.a axx;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a.a(this);
        com.baidu.live.alablmsdk.a.b.c.xu().b(this);
        this.axs = new com.baidu.live.alablmsdk.e.b(context, this);
        this.axD = new a(this.axs);
        this.axD.xS();
        this.axE = new b(this);
        this.axF = new com.baidu.live.alablmsdk.d.c(context);
        this.axF.a(this);
        this.axG = new com.baidu.live.alablmsdk.d.b(this.axF);
        this.axH = new com.baidu.live.alablmsdk.d.a(context, this.axF);
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.awB = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        this.axE.w(hashMap);
        this.axF.v(hashMap);
        this.axs.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.axF.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a xn() {
        return this.axH;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.axs.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.d("createRoom onResult responseCode = " + i + " , errorMessage = " + str);
                    com.baidu.live.alablmsdk.a.b.a.ew("createRoom onResult code " + i + " message " + str);
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        com.baidu.live.alablmsdk.a.b.a.d("createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        c.this.c(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId);
                        c.this.axs.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                com.baidu.live.alablmsdk.a.b.a.d(" signal join onResult , responseCode=" + i2 + " , errorMessage=" + str2);
                                com.baidu.live.alablmsdk.a.b.a.ew(" signal join onResult code " + i2 + " message " + str2);
                                if (i2 == 0) {
                                    if (c.this.axx != null) {
                                        c.this.axx.a(BLMSignalState.JOINED);
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
        this.axx = new com.baidu.live.alablmsdk.module.a();
        this.axx.roomId = str;
        this.axx.token = str2;
        this.axx.rtcAppId = str3;
        this.axx.axT = j;
        com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.axT = j;
        cVar.axY = UserPermission.OWNER;
        dVar.ayc = cVar;
        this.axx.axU = dVar;
        com.baidu.live.alablmsdk.a.b.c.xu().setRtcRoomId(this.axx.roomId);
        if (this.axD != null) {
            a aVar = this.axD;
            a.ez(this.axx.roomId);
            this.axD.a(str, this.axx.yd());
        }
        com.baidu.live.alablmsdk.module.b.yl().c(this.axx);
        if (this.axE != null) {
            this.axE.a(this.axx);
        }
    }

    public void a(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.axs.c(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.3
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (i2 == 0 && c.this.axx != null && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list.size()) {
                            break;
                        }
                        com.baidu.live.alablmsdk.module.c cVar2 = (com.baidu.live.alablmsdk.module.c) list.get(i4);
                        if (cVar2 != null) {
                            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                            dVar.ayc = cVar2.clone();
                            if (c.this.axx.yi() != null) {
                                dVar.ayc.aya = c.this.axx.yi().axT;
                            }
                            dVar.b(BLMRtcState.DEFAULT);
                            c.this.axx.a(dVar, BLMStateType.SIGNAL);
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
        this.axs.d(str, list, jSONObject, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.4
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if ((i2 == 0 || i2 == -1) && c.this.axx != null) {
                    c.this.axx.u(list);
                    if (c.this.axx.yh()) {
                        c.this.yb();
                    }
                }
                if (cVar != null) {
                    cVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ai(" acceptRoom ", " , extJson=" + jSONObject);
        this.axs.e(str, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.yl().a(str, BLMSignalState.JOINED);
                    c.this.a(str, false, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.5.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void f(int i3, int i4, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.d(" visiter join room， status=" + i4 + " , msg" + str3);
                            com.baidu.live.alablmsdk.a.b.a.ew(" visiter join room， status " + i4 + " msg " + str3);
                            if (i4 == 0) {
                                com.baidu.live.alablmsdk.module.b.yl().a(str, BLMRtcState.JOINED);
                                if (cVar != null) {
                                    cVar.f(4, 0, "acceptRoom join rtc room success");
                                    return;
                                }
                                return;
                            }
                            com.baidu.live.alablmsdk.module.b.yl().a(str, BLMRtcState.FAIL);
                            c.this.eA(str);
                            com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join rtc room error ; msg = " + str3);
                            com.baidu.live.alablmsdk.a.b.a.ew("acceptRoom join rtc room error msg " + str3);
                            if (cVar != null) {
                                cVar.f(4, -1, "acceptRoom join rtc room error ; msg = " + str3);
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join signal room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.a.ew("acceptRoom join signal room error msg " + str2);
                c.this.yb();
                if (cVar != null) {
                    cVar.f(4, -1, "acceptRoom join signal room error ; msg = " + str2);
                }
            }
        });
    }

    private JSONObject t(JSONObject jSONObject) {
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        if (this.axx != null && this.axx.axU != null && this.axx.axU.ayc != null) {
            com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
            bVar.axT = this.axx.axU.ayc.axT;
            bVar.order = this.axx.axU.ayc.order;
            aVar.ayi = com.baidu.live.alablmsdk.module.a.b.a(bVar);
        }
        JSONObject t = aVar.t(jSONObject);
        if (t == null) {
            return new JSONObject();
        }
        return t;
    }

    public void b(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        this.axs.f(str, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.6
            @Override // com.baidu.live.alablmsdk.c.c
            public void f(int i, int i2, String str2) {
                c.this.yb();
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
                com.baidu.live.alablmsdk.a.b.a.ew(" owner join room status " + i2 + " msg" + str2);
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.yl().a(str, BLMRtcState.JOINED);
                    if (cVar2 != null) {
                        cVar2.f(4, 0, "acceptRoom join rtc room success");
                        return;
                    }
                    return;
                }
                com.baidu.live.alablmsdk.module.b.yl().a(str, BLMRtcState.FAIL);
                c.this.b(str, (JSONObject) null, false, (com.baidu.live.alablmsdk.c.c) null);
                com.baidu.live.alablmsdk.a.b.a.d("acceptRoom join rtc room error ; msg = " + str2);
                com.baidu.live.alablmsdk.a.b.a.ew("acceptRoom join rtc room error msg " + str2);
                if (cVar2 != null) {
                    cVar2.f(4, -1, "acceptRoom join rtc room error ; msg = " + str2);
                }
            }
        });
    }

    private void a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null && this.axx != null && this.axx.axU != null && this.axx.axU.ayc != null) {
            this.axx.axU.ayc.order = cVar.order;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.module.c yi;
        this.axI = cVar;
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.a.b.a.ai("joinRoom param error, roomId isEmpty", "");
            if (this.axI != null) {
                this.axI.f(6, 1000, "joinRoom param error, roomId isEmpty");
                return;
            }
            return;
        }
        if (z && this.axx != null && this.axx.yg() == BLMSignalState.DEFAULT) {
            com.baidu.live.alablmsdk.a.b.c.xu().xy();
        }
        com.baidu.live.alablmsdk.module.a eC = com.baidu.live.alablmsdk.module.b.yl().eC(str);
        if (eC == null) {
            com.baidu.live.alablmsdk.a.b.a.ai("joinRoom param error getChatInfo null ", "");
            if (this.axI != null) {
                this.axI.f(6, 1000, "join rtc room param error , getChatInfo null");
            }
        } else if (!com.baidu.live.alablmsdk.module.a.b(eC)) {
            com.baidu.live.alablmsdk.a.b.a.ai("joinRoom chatInfo check error", "");
            if (this.axI != null) {
                this.axI.f(6, 1000, "joinRoom chatInfo check error");
            }
        } else {
            if (this.axx != null && (yi = this.axx.yi()) != null && !TextUtils.isEmpty(yi.order)) {
                this.axF.eG(yi.order);
            }
            this.axF.d(str, eC.token, eC.rtcAppId, eC.axT);
        }
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        if (this.axF != null && !TextUtils.isEmpty(this.axF.yv()) && this.axF.yv().equals(str) && !com.baidu.live.alablmsdk.a.a.isEmpty(list) && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.module.c cVar2 = list.get(0);
            this.axF.aF(cVar2.axT);
            this.axs.a(str, cVar2, t(jSONObject), new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.8
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

    public void aZ(boolean z) {
        if (this.axG != null) {
            com.baidu.live.alablmsdk.a.b.a.d("muteMicrophone " + z);
            com.baidu.live.alablmsdk.a.b.a.ew("muteMicrophone " + z);
            this.axG.aZ(z);
        }
    }

    private void xZ() {
        com.baidu.live.alablmsdk.a.b.a.ai(" currentKickedOffLeave ", "");
        if (this.axF != null) {
            this.axF.yB();
        }
        yc();
        yb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(String str) {
        a(str, com.baidu.live.alablmsdk.module.a.a.yr(), false, (com.baidu.live.alablmsdk.c.c) null);
    }

    public void a(String str, JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d(" leaveRoom");
        com.baidu.live.alablmsdk.a.b.a.ew(" leaveRoom ");
        if (z) {
            if (this.axx != null && this.axx.ye() && !this.axx.yh()) {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(false);
            }
            com.baidu.live.alablmsdk.a.b.c.xu().xE();
        }
        this.axF.yB();
        this.axs.a(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" leaveRoom onResult ，responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.a.ew(" leaveRoom onResult code " + i + " message " + str2);
                if (i == 0) {
                    if (c.this.axD != null) {
                        c.this.axD.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (cVar != null) {
                        cVar.f(7, 0, "leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (c.this.axD != null) {
                    c.this.axD.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (cVar != null) {
                    cVar.f(7, -1, "leaveRoom hangout signal fail");
                }
            }
        });
        yc();
        yb();
    }

    public void b(final String str, final JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ai(" closeRoom roomId " + str, "");
        if (z) {
            if (this.axx != null && this.axx.ye() && !this.axx.yh()) {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(false);
            }
            com.baidu.live.alablmsdk.a.b.c.xu().xF();
        }
        com.baidu.live.alablmsdk.module.a eC = com.baidu.live.alablmsdk.module.b.yl().eC(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (eC != null) {
            userPermission = eC.yd();
        }
        com.baidu.live.alablmsdk.a.b.a.d(" closeRoom permission=" + userPermission);
        com.baidu.live.alablmsdk.a.b.a.ew(" closeRoom permission " + userPermission);
        if (userPermission == UserPermission.OWNER) {
            this.axF.yA();
            if (this.axF.yx()) {
                com.baidu.live.alablmsdk.a.b.c.xu().pushEnd();
            }
        } else {
            this.axF.yB();
        }
        this.axs.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" closeRoom-signal hangout  responseCode=" + i + " , errorMessage=" + str2);
                com.baidu.live.alablmsdk.a.b.a.ew(" closeRoom-signal hangout code " + i + " errorMessage " + str2);
                if (userPermission == UserPermission.OWNER) {
                    com.baidu.live.alablmsdk.a.b.a.d(" signal close ");
                    com.baidu.live.alablmsdk.a.b.a.ew(" signal close ");
                    c.this.axs.b(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.10.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.d(" signal closeRoom , responseCode=" + i2 + " , errorMessage=" + str3);
                            com.baidu.live.alablmsdk.a.b.a.ew(" signal closeRoom code " + i2 + " errorMessage " + str3);
                            if (i2 == 0) {
                                if (c.this.axD != null) {
                                    c.this.axD.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (cVar != null) {
                                    cVar.f(8, 0, "closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (c.this.axD != null) {
                                c.this.axD.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (cVar != null) {
                                cVar.f(8, -1, "closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        yb();
        yc();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        com.baidu.live.alablmsdk.a.b.a.d(" b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        com.baidu.live.alablmsdk.a.b.a.d(" im 连接状态 responseCode = " + i);
        com.baidu.live.alablmsdk.a.b.a.ew(" im long connection code " + i);
        cd(i);
    }

    private void cd(int i) {
        if (i == 0) {
            if (this.axx != null) {
                ya();
            } else if (this.axx == null) {
                this.axD.xR();
            }
        }
    }

    private void ya() {
        com.baidu.live.alablmsdk.a.b.a.ai(" reJoinSignalAndRtcRoomInner ", "");
        if (this.axx != null) {
            this.axs.join(this.axx.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str, "");
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.ai(" reJoinSignalAndRtcRoomInner signal join success", "");
                        c.this.axF.yG();
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ai(" reJoinSignalAndRtcRoomInner signal join fail", "");
                }
            });
        } else {
            com.baidu.live.alablmsdk.a.b.a.ai(" reJoinSignalAndRtcRoomInner mCurrentChatInfo==null", "");
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
        if (i == 89) {
            com.baidu.live.alablmsdk.a.b.a.d(" signal onRtcResult room closed ");
            com.baidu.live.alablmsdk.a.b.a.ew(" signal onRtcResult room closed ");
            String str = "";
            if (bIMRtcInfo != null) {
                str = bIMRtcInfo.getRtcRoomId();
            }
            if (this.axx != null && !TextUtils.isEmpty(this.axx.roomId) && this.axx.roomId.equals(str)) {
                yb();
            }
            if (this.awB != null) {
                com.baidu.live.alablmsdk.a.b.a.d(" room closed callback ,  roomId=" + str);
                com.baidu.live.alablmsdk.a.b.a.ew(" room closed callback roomId " + str);
                this.awB.ev(str);
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
                cVar.axT = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" caller invite time out", " , other imUk=" + cVar.axT);
        if (this.axx != null && this.axx.ye()) {
            if (this.axx.aA(cVar.axT)) {
                com.baidu.live.alablmsdk.module.b.yl().a(str, cVar.axT, BLMSignalState.TIMEOUT);
                com.baidu.live.alablmsdk.a.b.c.xu().xC();
                if (this.awB != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" caller invite time out callback ", "");
                    this.awB.a(str, cVar);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.c.xu().xC();
            if (this.awB != null) {
                com.baidu.live.alablmsdk.a.b.a.ai(" caller invite time out, check imUk error, but callback ", "");
                this.awB.a(str, cVar);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" caller invite time out not callback ", "");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerGetAnswerSyncByCallee(int i, BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        long j;
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.a.b.a.ai(" roomCallerGetAnswerSyncByCallee ", "");
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
                jSONObject = aVar2.eD(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                BIMSyncRtcInfo bIMSyncRtcInfo = (BIMSyncRtcInfo) bIMRtcInfo;
                j2 = bIMSyncRtcInfo.getInitiatorUk();
                cVar.axT = bIMSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (!TextUtils.isEmpty(str) && this.axx != null && !TextUtils.isEmpty(this.axx.roomId) && this.axx.roomId.equals(str)) {
                    com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                    dVar.ayc = cVar.clone();
                    this.axx.a(dVar, BLMStateType.SIGNAL);
                }
                com.baidu.live.alablmsdk.a.b.a.ai(" caller receive callee response", " callee 的 uk=" + cVar.axT);
            }
            j = j2;
        }
        if (i == 1) {
            com.baidu.live.alablmsdk.a.b.a.ai(" caller，callee answer ok", "");
            com.baidu.live.alablmsdk.module.b.yl().a(str, j, BLMSignalState.JOINED);
            if (this.awB != null) {
                com.baidu.live.alablmsdk.a.b.a.ai(" caller，callee answer ok callback", "");
                this.awB.d(str, cVar, jSONObject);
            }
        } else if (i == 2) {
            com.baidu.live.alablmsdk.a.b.a.ai(" caller，callee answer no", "");
            com.baidu.live.alablmsdk.module.b.yl().a(str, j, BLMSignalState.REJECT);
            com.baidu.live.alablmsdk.a.b.c.xu().xB();
            if (this.awB != null) {
                com.baidu.live.alablmsdk.a.b.a.ai(" caller，callee answer no callback", "");
                this.awB.e(str, cVar, jSONObject);
            }
        } else if (i == 3) {
            com.baidu.live.alablmsdk.a.b.a.ai(" caller，callee answer timeout 30s", "");
            com.baidu.live.alablmsdk.module.b.yl().a(str, j, BLMSignalState.TIMEOUT);
            com.baidu.live.alablmsdk.a.b.c.xu().xC();
            if (this.awB != null) {
                com.baidu.live.alablmsdk.a.b.a.ai(" caller，callee answer timeout 30s callback", "");
                this.awB.a(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.d(" 被叫方接收到邀请(解析 rtc room 的相关信息，");
        com.baidu.live.alablmsdk.a.b.a.ew(" callee receive invite ");
        if (bIMRtcInfo != null && (bIMRtcInfo instanceof BIMInviteSyncRtcInfo)) {
            BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = (BIMInviteSyncRtcInfo) bIMRtcInfo;
            String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
            com.baidu.live.alablmsdk.a.b.a.ai(" callee receive invite roomId " + rtcRoomId, "");
            if (!TextUtils.isEmpty(rtcRoomId)) {
                if (this.axx != null && this.axx.roomId != null && !this.axx.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.a.b.a.d(" callee get invite. mCurrentChatInfo.roomId != roomId , return。  mCurrentChatInfo.roomId=" + this.axx.roomId);
                    com.baidu.live.alablmsdk.a.b.a.ew(" callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.axx.roomId);
                    return;
                }
                com.baidu.live.alablmsdk.a.b.c.xu().setRtcRoomId(rtcRoomId);
                String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
                com.baidu.live.alablmsdk.a.b.a.d(" callee receive invite,  originalExt=" + rtcExt);
                com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
                JSONObject eD = aVar.eD(rtcExt);
                com.baidu.live.alablmsdk.module.a eC = com.baidu.live.alablmsdk.module.b.yl().eC(rtcRoomId);
                if (eC == null) {
                    eC = new com.baidu.live.alablmsdk.module.a();
                }
                eC.roomId = rtcRoomId;
                eC.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                eC.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                eC.axT = bIMInviteSyncRtcInfo.getRtcUserId();
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.axT = eC.axT;
                cVar.axY = UserPermission.VISITER;
                cVar.aya = bIMInviteSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                dVar.ayc = cVar;
                dVar.b(BLMSignalState.RING);
                eC.axU = dVar;
                com.baidu.live.alablmsdk.module.d dVar2 = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.axT = bIMInviteSyncRtcInfo.getInitiatorUk();
                cVar2.axY = UserPermission.OWNER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar2, aVar);
                dVar2.ayc = cVar2;
                dVar2.b(BLMSignalState.JOINED);
                eC.a(dVar2, BLMStateType.SIGNAL);
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("callee 收到邀请 ， " + eC.yf());
                }
                this.axx = eC;
                com.baidu.live.alablmsdk.module.b.yl().c(eC);
                if (this.axE != null) {
                    this.axE.a(this.axx);
                }
                if (this.axD != null) {
                    a aVar2 = this.axD;
                    a.ez(eC.roomId);
                    this.axD.a(eC.roomId, eC.yd());
                }
                com.baidu.live.alablmsdk.module.c clone = cVar2.clone();
                if (this.awB != null) {
                    this.awB.b(rtcRoomId, clone, eD);
                }
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.a.b.a.ai(" callee,  caller cancel invite ", "");
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.eD(rtcExt);
            } else {
                aVar = null;
                jSONObject = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.axT = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
            str = null;
        }
        if (this.axx != null && this.axx.ye() && !TextUtils.isEmpty(this.axx.roomId) && this.axx.roomId.equals(str) && this.axx.aA(cVar.axT)) {
            yb();
            if (this.awB != null) {
                this.awB.c(str, cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.yl().a(bIMRtcInfo.getRtcRoomId(), BLMSignalState.DEFAULT);
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
                jSONObject = aVar2.eD(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.axT = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (this.axx != null && (az = this.axx.az(cVar.axT)) != null && !TextUtils.isEmpty(az.order)) {
                    cVar.order = az.order;
                }
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
            aVar = null;
        }
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.d(" 对方的事件 : roomEventType=" + roomEventType + "  roomId=" + str + " , imUk=" + cVar.axT);
        }
        com.baidu.live.alablmsdk.a.b.a.ew("roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str);
        if (eB(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                com.baidu.live.alablmsdk.a.b.a.ai(" signal： other ringing ", "");
                com.baidu.live.alablmsdk.module.b.yl().a(str, cVar.axT, BLMSignalState.RING);
                if (this.awB != null) {
                    this.awB.a(str, cVar, jSONObject);
                    return;
                }
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.JOIN_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.ai(" signal： other join signal room", "");
                e(str, cVar);
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.EXIT_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.ai(" signal： other exit signal room", "");
                a(str, cVar, aVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" not current room chart do nothing", "");
    }

    private void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.a eC;
        if (cVar != null && (eC = com.baidu.live.alablmsdk.module.b.yl().eC(str)) != null) {
            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
            dVar.ayc = cVar.clone();
            dVar.b(BLMSignalState.JOINED);
            eC.a(dVar, BLMStateType.SIGNAL);
        }
    }

    private void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.module.a.a aVar) {
        if (cVar != null) {
            com.baidu.live.alablmsdk.a.b.a.ai("handleSignalUserLeave roomId " + str, " , callbackUser = " + cVar.toString());
            if (this.axx != null && !TextUtils.isEmpty(this.axx.roomId) && this.axx.roomId.equals(str) && this.axx.ye()) {
                com.baidu.live.alablmsdk.a.b.a.ai(" handleSignalUserLeave ，remove otherImUk ", "");
                this.axx.ax(cVar.axT);
                if (aVar != null && aVar.ayj) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" handleSignalUserLeave ，hasStatusCheckInfoKey reture ", "");
                } else if (this.awB != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" handleSignalUserLeave ，onRoomUserLeaved callback ", "");
                    this.awB.c(str, cVar);
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
        com.baidu.live.alablmsdk.module.c yi;
        com.baidu.live.alablmsdk.a.b.a.ai(" roomKickedUserFromKickerSync ", "");
        if (bIMKickReqSyncRtcInfo != null) {
            try {
                j = bIMKickReqSyncRtcInfo.getBIMKickedUsers().uk;
                try {
                    com.baidu.live.alablmsdk.a.b.a.ai(" roomKickedUserFromKickerSync kickedImUk=" + j, "");
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                j = 0;
            }
            if (this.axx != null && (yi = this.axx.yi()) != null && yi.axT != 0 && yi.axT == j) {
                au(j);
                return 1;
            }
        }
        return 0;
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.ai(" roomEventKickedStatusByKickedUser ", "");
        if (bIMKickResSyncRtcInfo != null) {
            long j = 0;
            try {
                j = bIMKickResSyncRtcInfo.getBIMKickedUsers().uk;
                com.baidu.live.alablmsdk.a.b.a.ai(" roomEventKickedStatusByKickedUser kickedThirdUserId=" + j, "");
            } catch (Exception e) {
            }
            av(j);
        }
    }

    private void au(long j) {
        com.baidu.live.alablmsdk.module.c cVar;
        String str;
        com.baidu.live.alablmsdk.a.b.a.ew(" handleCurrentUserKicked ");
        if (this.axx != null) {
            String str2 = this.axx.roomId;
            com.baidu.live.alablmsdk.module.c yi = this.axx.yi();
            if (yi != null) {
                cVar = yi.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.axT = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        xZ();
        if (this.awB != null) {
            com.baidu.live.alablmsdk.a.b.a.ai(" current, onRoomUserKickoffed call back", "");
            this.awB.d(str, cVar);
        }
    }

    private void av(long j) {
        com.baidu.live.alablmsdk.module.c cVar;
        String str;
        com.baidu.live.alablmsdk.a.b.a.ai(" handleOtherUserKicked uk=" + j, "");
        if (this.axx != null) {
            String str2 = this.axx.roomId;
            com.baidu.live.alablmsdk.module.c az = this.axx.az(j);
            if (az != null) {
                cVar = az.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.axT = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        if (this.axx != null) {
            this.axx.ax(j);
        }
        if (this.awB != null) {
            com.baidu.live.alablmsdk.a.b.a.ai(" other, onRoomUserKickoffed call back", "");
            this.awB.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void ce(int i) {
        com.baidu.live.alablmsdk.a.b.a.ai(" onRtcCurrentUserStreamChange status " + i, "");
        if (i == 2) {
            this.axE.xW();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void h(int i, String str) {
        if (i == 0) {
            com.baidu.live.alablmsdk.a.b.a.ai(" onRtcCurrentUserJoinRoomStatus success msg " + str, "");
            this.axE.xX();
            if (this.axI != null) {
                this.axI.f(6, 0, str);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" onRtcCurrentUserJoinRoomStatus fail msg " + str, "");
        if (this.axI != null) {
            this.axI.f(6, -1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.a
    public void onRoomEventUpdate(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.ai(" rtc onRoomEventUpdate roomEvents " + i, " , imUK=" + j + " , extra_info=" + str);
        c(i, j, str);
    }

    private void c(int i, long j, String str) {
        if (this.axx != null) {
            if (!TextUtils.isEmpty(this.axx.roomId)) {
                if (this.axx.ye()) {
                    if (this.axx.aw(j) || (j == 0 && i == 100)) {
                        d(i, j, str);
                        return;
                    }
                    e(i, j, str);
                    if (this.axx.aA(j)) {
                        f(i, j, str);
                        return;
                    } else {
                        g(i, j, str);
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ai(" handleRtc hasStartedTransaction is false ", "imUk=" + j);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ai(" handleRtc mCurrentChatInfo.roomId is empty", "imUk=" + j);
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" handleRtc mCurrentChatInfo is null", "imUk=" + j);
    }

    private void d(int i, long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.ai(" handleRtcCurrentUser ", "imUk=" + j + "  extraInfo=" + str);
        if (this.axx == null) {
            com.baidu.live.alablmsdk.a.b.a.ai(" handleRtcCurrentUser mCurrentChatInfo info error", "");
        } else if (i == 100) {
            if (this.axx.axU != null && this.axx.axU.ayc != null && !TextUtils.isEmpty(this.axx.axU.ayc.order)) {
                String b2 = com.baidu.live.alablmsdk.module.a.b.b(this.axx.axU.ayc);
                this.axF.setUserAttribute(b2);
                com.baidu.live.alablmsdk.a.b.a.d(" setUserAttribute " + b2);
            }
            if (this.axF.yx()) {
                com.baidu.live.alablmsdk.a.b.c.xu().xw();
            }
        } else if (i == 115) {
            com.baidu.live.alablmsdk.a.b.a.ai("rtc current user kicked ，do rtc leave room ", "");
            this.axF.yB();
        }
    }

    private void e(int i, long j, String str) {
        if (i == 300 && this.axx.yd() == UserPermission.VISITER) {
            if (this.axx.ay(j) == null) {
                com.baidu.live.alablmsdk.a.b.a.ew(" not current user, permission is visiter, add other list");
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.axT = j;
                dVar.ayc = cVar;
                this.axx.a(dVar, BLMStateType.NONE);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ew(" not current user, permission is visiter, has include the other");
        }
    }

    private void f(int i, long j, String str) {
        com.baidu.live.alablmsdk.module.c cVar;
        com.baidu.live.alablmsdk.a.b.a.ai(" handleRtcHasIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
        if (j != 0 && this.axx != null) {
            com.baidu.live.alablmsdk.module.d ay = this.axx.ay(j);
            com.baidu.live.alablmsdk.module.c az = this.axx.az(j);
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.axT = j;
            if (az != null) {
                aVar.order = az.order;
            }
            com.baidu.live.alablmsdk.a.b.a.ai(" current transaction  yes ", "");
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.a.ai("remote join  invite join or reJoin rtc", "");
                if (ay != null) {
                    if (ay.yn() == BLMRtcState.DEFAULT) {
                        if (az != null && az.aya != 0 && this.axx.yi() != null && az.aya == this.axx.yi().axT) {
                            com.baidu.live.alablmsdk.a.b.c.xu().cc(1);
                            com.baidu.live.alablmsdk.a.b.c.xu().xD();
                        } else if (this.axx.yi() != null && this.axx.yi().aya == 0 && !this.axJ) {
                            this.axJ = true;
                            com.baidu.live.alablmsdk.a.b.c.xu().cc(0);
                            com.baidu.live.alablmsdk.a.b.c.xu().xD();
                        }
                    }
                    ay.b(BLMRtcState.JOINED);
                }
                if (this.awB != null) {
                    if (az != null) {
                        cVar = az.clone();
                    } else {
                        cVar = new com.baidu.live.alablmsdk.module.c();
                        cVar.axT = j;
                    }
                    this.awB.b(this.axx.roomId, cVar);
                }
            } else if (i == 303) {
                com.baidu.live.alablmsdk.a.b.a.ai("rtc remote attribute arrive", "");
                if (this.axx != null) {
                    this.axx.e(j, str);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.a.ai("rtc remote user leave", "");
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
                com.baidu.live.alablmsdk.a.b.a.ai("rtc remote stream arrival , streamInfo=" + str2, "");
                if (this.axH != null) {
                    this.axH.i(true, j);
                }
                if (this.awB != null) {
                    this.awB.a(aVar, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                }
                this.axE.at(j);
            } else if (i == 107) {
                if (ay != null) {
                    ay.b(BLMRtcState.STREAM_NO);
                }
                com.baidu.live.alablmsdk.a.b.a.ai("rtc remote stream leave", "");
                if (this.awB != null) {
                    this.awB.a(aVar, BLMStreamState.BLMSTREAMSTATE_REMOVE);
                }
                this.axE.as(j);
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.a.ai("rtc other user kicked, include  don nothing", "imUk = " + j);
            }
        }
    }

    public void g(int i, long j, String str) {
        if (j != 0) {
            com.baidu.live.alablmsdk.a.b.a.ai(" handleRtcHasNotIncludedOtherUser ", ", roomEvents=" + i + " , imUk=" + j + ", extraInfo=" + str);
            if (i == 300) {
                com.baidu.live.alablmsdk.a.b.a.ai("remote join :  invite join or reJoin rtc", "");
                if (this.axx.yd() == UserPermission.OWNER && this.axF != null) {
                    this.axF.aF(j);
                }
            } else if (i == 301) {
                com.baidu.live.alablmsdk.a.b.a.ai("remote user leave", "");
            } else if (i == 106) {
                com.baidu.live.alablmsdk.a.b.a.ai("remote stream arrival", "");
                if (this.axx.yd() == UserPermission.OWNER && this.axF != null) {
                    this.axF.aF(j);
                }
            } else if (i == 107) {
                com.baidu.live.alablmsdk.a.b.a.ai("remote stream leave", "");
            } else if (i == 115) {
                com.baidu.live.alablmsdk.a.b.a.ai(" un include, other user kicked ", "imUk = " + j);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.b.b.a
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.awB != null) {
            this.awB.a(aVar, i);
        }
    }

    public void yb() {
        com.baidu.live.alablmsdk.a.b.a.ai(" resetCurrentChat ", "");
        this.axx = null;
        this.axJ = false;
        com.baidu.live.alablmsdk.module.b.yl().clearAll();
    }

    public boolean eB(String str) {
        return (this.axx == null || TextUtils.isEmpty(this.axx.roomId) || !this.axx.roomId.equals(str)) ? false : true;
    }

    public void yc() {
        com.baidu.live.alablmsdk.a.b.a.ai("stop all stream leave count down", "");
        this.axE.xY();
        this.axE.xX();
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BMLSignalRtcSyncManager  release ");
        com.baidu.live.alablmsdk.a.b.a.ew(" BMLSignalRtcSyncManager  release ");
        this.axI = null;
        this.awB = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.axs != null) {
            this.axs.release();
            this.axs = null;
        }
        if (this.axE != null) {
            this.axE.release();
        }
        if (this.axF != null) {
            this.axF.release();
            this.axF = null;
        }
        if (this.axH != null) {
            this.axH.release();
        }
        if (this.axD != null) {
            this.axD.release();
        }
        yb();
        yc();
        e.xq().release();
        com.baidu.live.alablmsdk.a.b.a.release();
        com.baidu.live.alablmsdk.a.b.c.xu().release();
    }

    @Override // com.baidu.live.alablmsdk.a.b.d
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.awB != null) {
            this.awB.onLogReport(str, jSONObject, jSONObject2);
        }
    }
}
