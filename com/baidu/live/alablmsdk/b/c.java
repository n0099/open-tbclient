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
import com.baidu.live.alablmsdk.b.b;
import com.baidu.live.alablmsdk.c.b.e;
import com.baidu.live.alablmsdk.c.b.f;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.rtc.BLMJoinRoomStage;
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
public class c implements BIMRtcListener, IConnectListener, ILiveMsgReceiveListener, d, b.a, f {
    private com.baidu.live.alablmsdk.c.b awq;
    private com.baidu.live.alablmsdk.e.b axF;
    public com.baidu.live.alablmsdk.module.a axK;
    private a axQ;
    private b axR;
    private com.baidu.live.alablmsdk.d.c axS;
    private com.baidu.live.alablmsdk.d.b axT;
    private com.baidu.live.alablmsdk.d.a axU;
    private com.baidu.live.alablmsdk.c.d axV;
    private com.baidu.live.alablmsdk.c.c axW;
    private boolean axX;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a.a(this);
        com.baidu.live.alablmsdk.a.b.c.xu().b(this);
        this.axF = new com.baidu.live.alablmsdk.e.b(context, this);
        this.axQ = new a(this.axF);
        this.axQ.xU();
        this.axR = new b(this);
        this.axS = new com.baidu.live.alablmsdk.d.c(context);
        this.axS.a(this);
        this.axT = new com.baidu.live.alablmsdk.d.b(this.axS);
        this.axU = new com.baidu.live.alablmsdk.d.a(context, this.axS);
        this.axU.a(this.axS.yn());
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.awq = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.config.b.xN().xO();
        this.axR.x(hashMap);
        this.axS.v(hashMap);
        this.axF.v(hashMap);
    }

    public int w(HashMap<String, Object> hashMap) {
        if (this.axS == null) {
            return 1000;
        }
        return this.axS.w(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.axS.a(aVar);
    }

    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync startLiveServerStreaming mode " + bLMLiveTransferMode, "");
        this.axS.a(bLMLiveTransferMode);
    }

    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync stopLiveServerStreaming mode " + bLMLiveTransferMode, "");
        this.axS.b(bLMLiveTransferMode);
    }

    public int a(com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync publishStream", "");
        this.axV = dVar;
        return this.axS.yi();
    }

    public void xk() {
        this.axS.xk();
    }

    public com.baidu.live.alablmsdk.d.a xl() {
        return this.axU;
    }

    public com.baidu.live.alablmsdk.d.b xm() {
        return this.axT;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.axF.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync createRoom onResult code " + i + " message " + str, "");
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        c.this.a(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId, UserPermission.OWNER);
                        c.this.axF.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal join onResult code " + i2 + " message " + str2, "");
                                if (i2 == 0) {
                                    if (c.this.axK != null) {
                                        c.this.axK.a(BLMSignalState.JOINED);
                                    }
                                    aVar.c(bIMRTCGetTokeResult.roomId, 0, "create signal room suc");
                                    return;
                                }
                                aVar.c("", -1, "signal-rtc-sync join signal room fail responseCode=" + i2 + " errorMessage=" + str2);
                            }
                        });
                        return;
                    }
                    aVar.c("", -1, "signal-rtc-sync create signal room fail responseCode" + i + " errorMessage=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, long j, UserPermission userPermission) {
        if (this.axK == null) {
            this.axK = new com.baidu.live.alablmsdk.module.a();
        }
        this.axK.roomId = str;
        this.axK.token = str2;
        this.axK.rtcAppId = str3;
        this.axK.ayk = j;
        com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.ayk = j;
        cVar.ayp = userPermission;
        dVar.ayt = cVar;
        this.axK.ayl = dVar;
        com.baidu.live.alablmsdk.a.b.c.xu().setRtcRoomId(this.axK.roomId);
        if (this.axQ != null) {
            a aVar = this.axQ;
            a.eK(this.axK.roomId);
            this.axQ.a(str, this.axK.yq());
        }
        com.baidu.live.alablmsdk.module.b.yz().b(this.axK);
        if (this.axR != null) {
            this.axR.a(this.axK);
        }
    }

    public void a(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.d dVar) {
        this.axF.c(str, list, jSONObject, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.4
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                if (i2 == 0 && c.this.axK != null && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list.size()) {
                            break;
                        }
                        com.baidu.live.alablmsdk.module.c cVar = (com.baidu.live.alablmsdk.module.c) list.get(i4);
                        if (cVar != null) {
                            com.baidu.live.alablmsdk.module.d dVar2 = new com.baidu.live.alablmsdk.module.d();
                            dVar2.ayt = cVar.clone();
                            if (c.this.axK.yw() != null) {
                                dVar2.ayt.ayr = c.this.axK.yw().ayk;
                            }
                            dVar2.b(BLMRtcState.DEFAULT);
                            c.this.axK.a(dVar2, BLMStateType.SIGNAL);
                        }
                        i3 = i4 + 1;
                    }
                }
                if (dVar != null) {
                    dVar.f(i, i2, str2);
                }
            }
        });
    }

    public void b(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.d dVar) {
        this.axF.d(str, list, jSONObject, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.5
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                if ((i2 == 0 || i2 == -1) && c.this.axK != null) {
                    c.this.axK.u(list);
                    if (c.this.axK.yv()) {
                        c.this.yf();
                    }
                }
                if (dVar != null) {
                    dVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync acceptRoom ", " , extJson=" + jSONObject);
        this.axF.d(str, t(jSONObject), new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.6
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.yz().a(str, BLMSignalState.JOINED);
                    c.this.a(str, false, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.6.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void a(int i3, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar) {
                            String str3 = aVar != null ? aVar.msg : "";
                            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync accept: visiter join rtc room， status=" + i3 + " msg=" + str3, "");
                            if (i3 == 0) {
                                com.baidu.live.alablmsdk.module.b.yz().a(str, BLMRtcState.JOINED);
                            } else {
                                com.baidu.live.alablmsdk.module.b.yz().a(str, BLMRtcState.FAIL);
                                c.this.eL(str);
                                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync acceptRoom join rtc room error msg=" + str3, "");
                            }
                            if (cVar != null) {
                                cVar.a(i3, bLMJoinRoomStage, aVar);
                            }
                        }
                    });
                    return;
                }
                String str3 = "signal-rtc-sync acceptRoom join signal room error: msg=" + str2;
                com.baidu.live.alablmsdk.a.b.a.ag(str3, "");
                c.this.yf();
                if (cVar != null) {
                    com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                    aVar.msg = str3;
                    cVar.a(i2, BLMJoinRoomStage.JOIN, aVar);
                }
            }
        });
    }

    private JSONObject t(JSONObject jSONObject) {
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        if (this.axK != null && this.axK.ayl != null && this.axK.ayl.ayt != null) {
            com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
            bVar.ayk = this.axK.ayl.ayt.ayk;
            bVar.order = this.axK.ayl.ayt.order;
            aVar.ayz = com.baidu.live.alablmsdk.module.a.b.a(bVar);
        }
        JSONObject t = aVar.t(jSONObject);
        if (t == null) {
            return new JSONObject();
        }
        return t;
    }

    public void a(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.d dVar) {
        this.axF.e(str, t(jSONObject), new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.7
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                c.this.yf();
                if (dVar != null) {
                    dVar.f(i, i2, str2);
                }
            }
        });
    }

    public void a(final String str, com.baidu.live.alablmsdk.module.c cVar, final com.baidu.live.alablmsdk.c.c cVar2) {
        a(cVar);
        a(str, true, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.8
            @Override // com.baidu.live.alablmsdk.c.c
            public void a(int i, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync join rtc room status=" + i + " msg=" + (aVar != null ? aVar.msg : ""), "");
                if (i == 0) {
                    com.baidu.live.alablmsdk.module.b.yz().a(str, BLMRtcState.JOINED);
                } else {
                    com.baidu.live.alablmsdk.module.b.yz().a(str, BLMRtcState.FAIL);
                }
                if (cVar2 != null) {
                    cVar2.a(i, bLMJoinRoomStage, aVar);
                }
            }
        });
    }

    private void a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null && this.axK != null && this.axK.ayl != null && this.axK.ayl.ayt != null) {
            this.axK.ayl.ayt.order = cVar.order;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, boolean z, com.baidu.live.alablmsdk.c.c cVar) {
        if (this.awq != null) {
            com.baidu.live.alablmsdk.a.b.c.xu().eE(this.awq.xn());
        }
        this.axW = cVar;
        final com.baidu.live.alablmsdk.module.rtc.b bVar = new com.baidu.live.alablmsdk.module.rtc.b();
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync joinRoom param error, roomId isEmpty", "");
            if (this.axW != null) {
                com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                aVar.msg = "signal-rtc-sync joinRoom param error, roomId isEmpty";
                this.axW.a(-1, BLMJoinRoomStage.JOIN, aVar);
            }
        } else if (this.axK != null && !TextUtils.isEmpty(this.axK.roomId) && !this.axK.roomId.equals(str)) {
            if (this.axW != null) {
                com.baidu.live.alablmsdk.module.common.a aVar2 = new com.baidu.live.alablmsdk.module.common.a();
                aVar2.msg = "signal-rtc-sync currentChatInfo roomid , roomId different";
                this.axW.a(-1, BLMJoinRoomStage.JOIN, aVar2);
            }
        } else {
            if (z) {
                com.baidu.live.alablmsdk.a.b.c.xu().xC();
            }
            if (this.axK == null || this.axK.yt() != BLMSignalState.JOINED) {
                if (this.axF != null) {
                    this.axF.join(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.9
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str2) {
                            if (i != 0) {
                                c.this.a(BLMJoinRoomStage.JOIN, "signal-rtc-sync join signal error, code=" + i + " , msg=" + str2);
                                return;
                            }
                            if (c.this.axK == null) {
                                c.this.axK = new com.baidu.live.alablmsdk.module.a();
                            }
                            c.this.axK.a(BLMSignalState.JOINED);
                            c.this.axF.a(str, c.this.axF.zn(), new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.9.1
                                @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                                public void onResult(int i2, String str3, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                                    com.baidu.live.alablmsdk.a.b.a.eA("signal-rtc-sync generateToken onResult code " + i2 + " message=" + str3);
                                    if (i2 != 0 || bIMRTCGetTokeResult == null || TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) || TextUtils.isEmpty(bIMRTCGetTokeResult.token) || TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) || bIMRTCGetTokeResult.useId == -1) {
                                        c.this.a(BLMJoinRoomStage.JOIN, "signal-rtc-sync generateToken error: code=" + i2 + " , message=" + str3);
                                        return;
                                    }
                                    c.this.a(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId, UserPermission.VISITER);
                                    bVar.axH = bIMRTCGetTokeResult.roomId;
                                    bVar.ayF = bIMRTCGetTokeResult.rtcAppId;
                                    bVar.ayE = bIMRTCGetTokeResult.token;
                                    bVar.ayG = bIMRTCGetTokeResult.useId;
                                    c.this.axS.a(bVar, c.this.axW);
                                }
                            });
                        }
                    });
                    return;
                } else {
                    a(BLMJoinRoomStage.JOIN, "signal-rtc-sync mBLMSignalRoom is null");
                    return;
                }
            }
            bVar.axH = this.axK.roomId;
            bVar.ayF = this.axK.rtcAppId;
            bVar.ayE = this.axK.token;
            bVar.ayG = this.axK.ayk;
            com.baidu.live.alablmsdk.module.c yw = this.axK.yw();
            if (yw != null && !TextUtils.isEmpty(yw.order)) {
                this.axS.eN(yw.order);
            }
            this.axS.a(bVar, this.axW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BLMJoinRoomStage bLMJoinRoomStage, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync join Room error: stage=" + bLMJoinRoomStage + " msg=" + str, "");
        if (this.axW != null) {
            com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
            aVar.msg = str;
            this.axW.a(-1, BLMJoinRoomStage.JOIN, aVar);
        }
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.d dVar) {
        if (this.axS != null && !TextUtils.isEmpty(this.axS.ym()) && this.axS.ym().equals(str) && !com.baidu.live.alablmsdk.a.a.isEmpty(list) && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.module.c cVar = list.get(0);
            this.axS.az(cVar.ayk);
            this.axF.a(str, cVar, t(jSONObject), new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.10
                @Override // com.baidu.live.alablmsdk.c.d
                public void f(int i, int i2, String str2) {
                }
            });
            if (dVar != null) {
                dVar.f(9, 0, "signal-rtc-sync kick off user send");
            }
        } else if (dVar != null) {
            dVar.f(9, -1, "signal-rtc-sync room or user check error");
        }
    }

    public void a(String str, boolean z, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.d dVar) {
        this.axS.b(str, list, z);
    }

    public void aY(boolean z) {
        if (this.axT != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal-rtc-sync muteMicrophone " + z, "");
            this.axT.aY(z);
        }
    }

    public void aZ(boolean z) {
        if (this.axT != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync muteSpeaker " + z, "");
            this.axT.aZ(z);
        }
    }

    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axS != null) {
            return this.axS.h(str, cVar);
        }
        return false;
    }

    private void yb() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync currentKickedOffLeave ", "");
        if (this.axS != null) {
            this.axS.yo();
        }
        yg();
        yf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(String str) {
        a(str, com.baidu.live.alablmsdk.module.a.a.yF(), false, (com.baidu.live.alablmsdk.c.d) null);
    }

    public void a(String str, JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync leaveRoom", "");
        if (z) {
            if (this.axK != null && this.axK.yr() && !this.axK.yv()) {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(false);
            }
            com.baidu.live.alablmsdk.a.b.c.xu().xI();
        }
        this.axS.yo();
        this.axF.a(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.11
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync leaveRoom onResult code " + i + " message " + str2, "");
                if (i == 0) {
                    if (c.this.axQ != null) {
                        c.this.axQ.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (dVar != null) {
                        dVar.f(7, 0, "signal-rtc-sync leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (c.this.axQ != null) {
                    c.this.axQ.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (dVar != null) {
                    dVar.f(7, -1, "signal-rtc-sync leaveRoom hangout signal fail");
                }
            }
        });
        yg();
        yf();
    }

    public void a(final String str, boolean z, final JSONObject jSONObject, boolean z2, final com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync closeRoom roomId " + str, "");
        if (z2) {
            if (this.axK != null && this.axK.yr() && !this.axK.yv()) {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.xu().bc(false);
            }
            com.baidu.live.alablmsdk.a.b.c.xu().xJ();
        }
        com.baidu.live.alablmsdk.module.a eO = com.baidu.live.alablmsdk.module.b.yz().eO(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (eO != null) {
            userPermission = eO.yq();
        }
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync closeRoom permission " + userPermission, "");
        if (z) {
            this.axS.yp();
        } else if (userPermission == UserPermission.OWNER) {
            this.axS.yp();
        } else {
            this.axS.yo();
        }
        this.axF.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync closeRoom-signal hangout code " + i + " errorMessage " + str2, "");
                if (userPermission == UserPermission.OWNER) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal close ", "");
                    c.this.axF.b(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal closeRoom code " + i2 + " errorMessage " + str3, "");
                            if (i2 == 0) {
                                if (c.this.axQ != null) {
                                    c.this.axQ.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (dVar != null) {
                                    dVar.f(8, 0, "signal-rtc-sync closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (c.this.axQ != null) {
                                c.this.axQ.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (dVar != null) {
                                dVar.f(8, -1, "signal-rtc-sync closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        yf();
        yg();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync im long connection code " + i, "");
        cg(i);
        com.baidu.live.alablmsdk.a.b.c.xu().bd(i == 0);
    }

    private void cg(int i) {
        if (i == 0) {
            if (this.axK != null) {
                yc();
            } else if (this.axK == null) {
                this.axQ.xT();
            }
        }
    }

    private void yc() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner ", "");
        if (this.axK != null) {
            this.axF.join(this.axK.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.3
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str, "");
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner signal join success", "");
                        c.this.axS.yj();
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner signal join fail", "");
                }
            });
        } else {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner mCurrentChatInfo==null", "");
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void onRtcResult(int i, BIMRtcInfo bIMRtcInfo) {
        if (i == 89) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal onRtcResult room closed ", "");
            String str = "";
            if (bIMRtcInfo != null) {
                str = bIMRtcInfo.getRtcRoomId();
            }
            if (this.axK != null && !TextUtils.isEmpty(this.axK.roomId) && this.axK.roomId.equals(str)) {
                yf();
            }
            if (this.awq != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync room closed callback roomId " + str, "");
                this.awq.ey(str);
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
                cVar.ayk = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller invite time out", " , other imUk=" + cVar.ayk);
        if (this.axK != null && this.axK.yr()) {
            if (this.axK.aE(cVar.ayk)) {
                com.baidu.live.alablmsdk.module.b.yz().a(str, cVar.ayk, BLMSignalState.TIMEOUT);
                com.baidu.live.alablmsdk.a.b.c.xu().xG();
                if (this.awq != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller invite time out callback ", "");
                    this.awq.b(str, cVar);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.c.xu().xG();
            if (this.awq != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller invite time out, check imUk error, but callback ", "");
                this.awq.b(str, cVar);
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller invite time out not callback ", "");
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCallerGetAnswerSyncByCallee(int i, BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        long j;
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync roomCallerGetAnswerSyncByCallee ", "");
        long j2 = 0;
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo == null) {
            jSONObject = null;
            j = 0;
            str = null;
        } else {
            str = bIMRtcInfo.getRtcRoomId();
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync roomCallerGetAnswerSyncByCallee ext=" + rtcExt);
            if (rtcExt != null) {
                com.baidu.live.alablmsdk.module.a.a aVar2 = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar2.eP(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                BIMSyncRtcInfo bIMSyncRtcInfo = (BIMSyncRtcInfo) bIMRtcInfo;
                j2 = bIMSyncRtcInfo.getInitiatorUk();
                cVar.ayk = bIMSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (!TextUtils.isEmpty(str) && this.axK != null && !TextUtils.isEmpty(this.axK.roomId) && this.axK.roomId.equals(str)) {
                    com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                    dVar.ayt = cVar.clone();
                    this.axK.a(dVar, BLMStateType.SIGNAL);
                }
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller receive callee response", " callee 的 uk=" + cVar.ayk);
            }
            j = j2;
        }
        if (i == 1) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer ok", "");
            com.baidu.live.alablmsdk.module.b.yz().a(str, j, BLMSignalState.JOINED);
            if (this.awq != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer ok callback", "");
                this.awq.d(str, cVar, jSONObject);
            }
        } else if (i == 2) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer no", "");
            com.baidu.live.alablmsdk.module.b.yz().a(str, j, BLMSignalState.REJECT);
            com.baidu.live.alablmsdk.a.b.c.xu().xF();
            if (this.awq != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer no callback", "");
                this.awq.e(str, cVar, jSONObject);
            }
        } else if (i == 3) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer timeout 30s", "");
            com.baidu.live.alablmsdk.module.b.yz().a(str, j, BLMSignalState.TIMEOUT);
            com.baidu.live.alablmsdk.a.b.c.xu().xG();
            if (this.awq != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer timeout 30s callback", "");
                this.awq.b(str, cVar);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync callee receive invite ", "");
        if (bIMRtcInfo != null && (bIMRtcInfo instanceof BIMInviteSyncRtcInfo)) {
            BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = (BIMInviteSyncRtcInfo) bIMRtcInfo;
            String rtcRoomId = bIMInviteSyncRtcInfo.getRtcRoomId();
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync callee receive invite roomId " + rtcRoomId, "");
            if (!TextUtils.isEmpty(rtcRoomId)) {
                if (this.axK != null && this.axK.roomId != null && !this.axK.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.axK.roomId, "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.c.xu().setRtcRoomId(rtcRoomId);
                String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
                com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync callee receive invite,  originalExt=" + rtcExt);
                com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
                JSONObject eP = aVar.eP(rtcExt);
                com.baidu.live.alablmsdk.module.a eO = com.baidu.live.alablmsdk.module.b.yz().eO(rtcRoomId);
                if (eO == null) {
                    eO = new com.baidu.live.alablmsdk.module.a();
                }
                eO.roomId = rtcRoomId;
                eO.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                eO.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                eO.ayk = bIMInviteSyncRtcInfo.getRtcUserId();
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.ayk = eO.ayk;
                cVar.ayp = UserPermission.VISITER;
                cVar.ayr = bIMInviteSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                dVar.ayt = cVar;
                dVar.b(BLMSignalState.RING);
                eO.ayl = dVar;
                com.baidu.live.alablmsdk.module.d dVar2 = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.ayk = bIMInviteSyncRtcInfo.getInitiatorUk();
                cVar2.ayp = UserPermission.OWNER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar2, aVar);
                dVar2.ayt = cVar2;
                dVar2.b(BLMSignalState.JOINED);
                eO.a(dVar2, BLMStateType.SIGNAL);
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync callee 收到邀请 ， " + eO.ys());
                }
                this.axK = eO;
                com.baidu.live.alablmsdk.module.b.yz().b(eO);
                if (this.axR != null) {
                    this.axR.a(this.axK);
                }
                if (this.axQ != null) {
                    a aVar2 = this.axQ;
                    a.eK(eO.roomId);
                    this.axQ.a(eO.roomId, eO.yq());
                }
                com.baidu.live.alablmsdk.module.c clone = cVar2.clone();
                if (this.awq != null) {
                    this.awq.b(rtcRoomId, clone, eP);
                }
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        String str;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync callee,  caller cancel invite ", "");
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (rtcExt != null) {
                aVar = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar.eP(rtcExt);
            } else {
                aVar = null;
                jSONObject = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.ayk = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
            str = null;
        }
        if (this.axK != null && this.axK.yr() && !TextUtils.isEmpty(this.axK.roomId) && this.axK.roomId.equals(str) && this.axK.aE(cVar.ayk)) {
            yf();
            if (this.awq != null) {
                this.awq.c(str, cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.yz().a(bIMRtcInfo.getRtcRoomId(), BLMSignalState.DEFAULT);
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerByFromOtherCallee(int i, BIMRtcInfo bIMRtcInfo) {
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventSyncByOthers(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo) {
        JSONObject jSONObject;
        com.baidu.live.alablmsdk.module.a.a aVar;
        com.baidu.live.alablmsdk.module.c aD;
        String str = "";
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        if (bIMRtcInfo != null) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync 振铃|加入|离开 : roomEventType=" + roomEventType + " , extStr=" + rtcExt);
            if (rtcExt != null) {
                com.baidu.live.alablmsdk.module.a.a aVar2 = new com.baidu.live.alablmsdk.module.a.a();
                jSONObject = aVar2.eP(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.ayk = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (this.axK != null && (aD = this.axK.aD(cVar.ayk)) != null && !TextUtils.isEmpty(aD.order)) {
                    cVar.order = aD.order;
                }
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
            aVar = null;
        }
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str, "");
        if (eM(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal： other ringing ", "");
                com.baidu.live.alablmsdk.module.b.yz().a(str, cVar.ayk, BLMSignalState.RING);
                if (this.awq != null) {
                    this.awq.a(str, cVar, jSONObject);
                    return;
                }
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.JOIN_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal： other join signal room", "");
                i(str, cVar);
                return;
            } else if (roomEventType == RtcConstants.RoomEventType.EXIT_ROOM) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal： other exit signal room", "");
                a(str, cVar, aVar);
                return;
            } else {
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync not current room chart do nothing", "");
    }

    private void i(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.a eO;
        if (cVar != null && (eO = com.baidu.live.alablmsdk.module.b.yz().eO(str)) != null) {
            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
            dVar.ayt = cVar.clone();
            dVar.b(BLMSignalState.JOINED);
            eO.a(dVar, BLMStateType.SIGNAL);
        }
    }

    private void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.module.a.a aVar) {
        if (cVar != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave roomId " + str, " , callbackUser = " + cVar.toString());
            if (this.axK != null && !TextUtils.isEmpty(this.axK.roomId) && this.axK.roomId.equals(str) && this.axK.yr()) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave ，remove otherImUk ", "");
                this.axK.aB(cVar.ayk);
                if (aVar != null && aVar.ayA) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave ，hasStatusCheckInfoKey reture ", "");
                } else if (this.awq != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave ，onRoomUserLeaved callback ", "");
                    this.awq.d(str, cVar);
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
        com.baidu.live.alablmsdk.module.c yw;
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync roomKickedUserFromKickerSync ", "");
        if (bIMKickReqSyncRtcInfo != null) {
            try {
                j = bIMKickReqSyncRtcInfo.getBIMKickedUsers().uk;
                try {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync roomKickedUserFromKickerSync kickedImUk=" + j, "");
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                j = 0;
            }
            if (this.axK != null && (yw = this.axK.yw()) != null && yw.ayk != 0 && yw.ayk == j) {
                au(j);
                return 1;
            }
        }
        return 0;
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync roomEventKickedStatusByKickedUser ", "");
        if (bIMKickResSyncRtcInfo != null) {
            long j = 0;
            try {
                j = bIMKickResSyncRtcInfo.getBIMKickedUsers().uk;
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync roomEventKickedStatusByKickedUser kickedThirdUserId=" + j, "");
            } catch (Exception e) {
            }
            av(j);
        }
    }

    private void au(long j) {
        com.baidu.live.alablmsdk.module.c cVar;
        String str;
        com.baidu.live.alablmsdk.a.b.a.eA("signal-rtc-sync handleCurrentUserKicked ");
        if (this.axK != null) {
            String str2 = this.axK.roomId;
            com.baidu.live.alablmsdk.module.c yw = this.axK.yw();
            if (yw != null) {
                cVar = yw.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.ayk = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        yb();
        if (this.awq != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync current, onRoomUserKickoffed call back", "");
            this.awq.e(str, cVar);
        }
    }

    private void av(long j) {
        com.baidu.live.alablmsdk.module.c cVar;
        String str;
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleOtherUserKicked uk=" + j, "");
        if (this.axK != null) {
            String str2 = this.axK.roomId;
            com.baidu.live.alablmsdk.module.c aD = this.axK.aD(j);
            if (aD != null) {
                cVar = aD.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.ayk = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        if (this.axK != null) {
            this.axK.aB(j);
        }
        if (this.awq != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync other, onRoomUserKickoffed call back", "");
            this.awq.e(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void onError(int i, String str) {
        if (this.awq != null) {
            this.awq.g(i, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public List<com.baidu.live.alablmsdk.module.c> yd() {
        if (this.axK != null) {
            return this.axK.yu();
        }
        return null;
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void i(int i, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserJoinRoom status " + i + " , msg=" + str, "");
        if (ye() && i == 0) {
            if (this.axK.ayl != null && this.axK.ayl.ayt != null && !TextUtils.isEmpty(this.axK.ayl.ayt.order)) {
                String i2 = com.baidu.live.alablmsdk.module.a.b.i(this.axK.ayl.ayt);
                this.axS.setUserAttribute(i2);
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync setUserAttribute " + i2, "");
            }
            com.baidu.live.alablmsdk.a.b.c.xu().xw();
        }
        if (this.axW != null) {
            if (i == 0) {
                com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                aVar.msg = str;
                this.axW.a(0, BLMJoinRoomStage.JOIN, aVar);
            } else {
                com.baidu.live.alablmsdk.module.common.a aVar2 = new com.baidu.live.alablmsdk.module.common.a();
                aVar2.msg = str;
                this.axW.a(-1, BLMJoinRoomStage.JOIN, aVar2);
            }
            if (!this.axS.yl()) {
                this.axW = null;
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserPushMediaOk ", "");
        if (this.axV != null) {
            this.axV.f(10, 0, cVar != null ? cVar.toString() : " push media ok ");
            this.axV = null;
        }
        if (this.axW != null) {
            com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
            aVar.msg = cVar != null ? cVar.toString() : " push media ok ";
            this.axW.a(0, BLMJoinRoomStage.PUBLISH, aVar);
            if (!this.axS.yl()) {
                this.axW = null;
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void b(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserPushMediaFail ", "");
        if (this.axV != null) {
            this.axV.f(10, -1, cVar != null ? cVar.toString() : " push media error ");
            this.axV = null;
        }
        if (this.axW != null) {
            com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
            aVar.msg = cVar != null ? cVar.toString() : " push media ok ";
            this.axW.a(-1, BLMJoinRoomStage.PUBLISH, aVar);
            this.axW = null;
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void j(int i, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserTransStream status " + i + " , msg=" + str, "");
        if (i == 0) {
            this.axR.xZ();
            if (this.axW != null) {
                com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                aVar.msg = str;
                this.axW.a(0, BLMJoinRoomStage.HOST_TRANS, aVar);
                this.axW = null;
            }
        } else if (this.axW != null) {
            com.baidu.live.alablmsdk.module.common.a aVar2 = new com.baidu.live.alablmsdk.module.common.a();
            aVar2.msg = str;
            this.axW.a(-1, BLMJoinRoomStage.HOST_TRANS, aVar2);
            this.axW = null;
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void ch(int i) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserStreamChange status " + i, "");
        if (i == 2) {
            this.axR.xY();
        } else if (i == 1) {
            this.axR.xZ();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void b(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.c cVar2;
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc user join room ", "");
        if (ye() && cVar != null) {
            aw(cVar.ayk);
            if (this.axK.aE(cVar.ayk)) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync remote join  invite join or reJoin rtc", "");
                com.baidu.live.alablmsdk.module.d aC = this.axK.aC(cVar.ayk);
                com.baidu.live.alablmsdk.module.c aD = this.axK.aD(cVar.ayk);
                if (aC != null) {
                    if (aC.yB() == BLMRtcState.DEFAULT) {
                        if (aD != null && aD.ayr != 0 && this.axK.yw() != null && aD.ayr == this.axK.yw().ayk) {
                            com.baidu.live.alablmsdk.a.b.c.xu().cc(1);
                            com.baidu.live.alablmsdk.a.b.c.xu().xH();
                        } else if (this.axK.yw() != null && this.axK.yw().ayr == 0 && !this.axX) {
                            this.axX = true;
                            com.baidu.live.alablmsdk.a.b.c.xu().cc(0);
                            com.baidu.live.alablmsdk.a.b.c.xu().xH();
                        }
                    }
                    aC.b(BLMRtcState.JOINED);
                }
                if (this.awq != null) {
                    if (aD != null) {
                        cVar2 = aD.clone();
                    } else {
                        cVar2 = new com.baidu.live.alablmsdk.module.c();
                        cVar2.ayk = cVar.ayk;
                    }
                    this.awq.c(this.axK.roomId, cVar2);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync remote join :  invite join or reJoin rtc", "");
            if (this.axK.yq() == UserPermission.OWNER && this.axS != null) {
                this.axS.az(cVar.ayk);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void c(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc user leave room ", "");
        if (ye() && cVar != null && this.axK.aE(cVar.ayk)) {
            com.baidu.live.alablmsdk.module.d aC = this.axK.aC(cVar.ayk);
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote user leave", "");
            if (aC != null) {
                aC.b(BLMRtcState.LEAVE);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void d(com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.f(this.axK.roomId, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void e(com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.g(this.axK.roomId, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void c(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote stream arrived ", "");
        if (ye() && cVar != null) {
            if (this.axK.aE(cVar.ayk)) {
                com.baidu.live.alablmsdk.module.d aC = this.axK.aC(cVar.ayk);
                com.baidu.live.alablmsdk.module.c aD = this.axK.aD(cVar.ayk);
                com.baidu.live.alablmsdk.module.rtc.c cVar2 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar2.ayk = cVar.ayk;
                if (aD != null) {
                    cVar2.order = aD.order;
                }
                if (aC != null) {
                    aC.b(BLMRtcState.STREAM);
                }
                String str = "";
                if (cVar2 != null) {
                    str = cVar2.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote stream arrival , streamInfo=" + str, "");
                if (this.axU != null) {
                    this.axU.i(true, cVar.ayk);
                }
                if (this.awq != null) {
                    this.awq.a(cVar2, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                }
                this.axR.at(cVar.ayk);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync remote stream arrival", "");
            if (this.axK.yq() == UserPermission.OWNER && this.axS != null) {
                this.axS.az(cVar.ayk);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void d(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote stream gone ", "");
        if (ye() && cVar != null && this.axK.aE(cVar.ayk)) {
            com.baidu.live.alablmsdk.module.d aC = this.axK.aC(cVar.ayk);
            com.baidu.live.alablmsdk.module.c aD = this.axK.aD(cVar.ayk);
            com.baidu.live.alablmsdk.module.rtc.c cVar2 = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar2.ayk = cVar.ayk;
            if (aD != null) {
                cVar2.order = aD.order;
            }
            if (aC != null) {
                aC.b(BLMRtcState.STREAM_NO);
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote stream leave", "");
            if (this.awq != null) {
                this.awq.a(cVar2, BLMStreamState.BLMSTREAMSTATE_REMOVE);
            }
            this.axR.as(cVar.ayk);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void f(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote attribute arrive", "");
        if (this.axK != null) {
            this.axK.h(cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void g(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc user kicked", "");
        if (ye() && cVar != null && this.axK.aA(cVar.ayk)) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc current user kicked ，do rtc leave room ", "");
            this.axS.yo();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void a(com.baidu.live.alablmsdk.c.b.b bVar) {
        if (bVar != null && this.axF != null) {
            bVar.ax(this.axF.zn());
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        if (this.awq != null) {
            this.awq.a(aVar);
        }
    }

    private boolean ye() {
        if (this.axK != null) {
            if (!TextUtils.isEmpty(this.axK.roomId)) {
                if (this.axK.yr()) {
                    return true;
                }
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleRtc hasStartedTransaction is false ", "");
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleRtc mCurrentChatInfo.roomId is empty", "");
            }
        } else {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleRtc mCurrentChatInfo is null", "");
        }
        return false;
    }

    private void aw(long j) {
        if (this.axK.yq() == UserPermission.VISITER) {
            if (this.axK.aC(j) == null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync not current user, permission is visiter, add other list", "");
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.ayk = j;
                dVar.ayt = cVar;
                this.axK.a(dVar, BLMStateType.NONE);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync not current user, permission is visiter, has include the other", "");
        }
    }

    public void ev(String str) {
        if (this.axS != null) {
            this.axS.ev(str);
        }
    }

    public void a(e eVar) {
        if (this.axS != null) {
            this.axS.a(eVar);
        }
    }

    public void ew(String str) {
        if (this.axS != null) {
            this.axS.ew(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.b.b.a
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i) {
        if (this.awq != null) {
            this.awq.a(cVar, i);
        }
    }

    public void yf() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync resetCurrentChat ", "");
        this.axK = null;
        this.axX = false;
        com.baidu.live.alablmsdk.module.b.yz().clearAll();
    }

    public boolean eM(String str) {
        return (this.axK == null || TextUtils.isEmpty(this.axK.roomId) || !this.axK.roomId.equals(str)) ? false : true;
    }

    public void yg() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync stop all stream leave count down", "");
        this.axR.ya();
        this.axR.xZ();
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync release ", "");
        this.axW = null;
        this.awq = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.axF != null) {
            this.axF.release();
            this.axF = null;
        }
        if (this.axR != null) {
            this.axR.release();
        }
        if (this.axS != null) {
            this.axS.release();
            this.axS = null;
        }
        if (this.axU != null) {
            this.axU.release();
        }
        if (this.axQ != null) {
            this.axQ.release();
        }
        this.axV = null;
        yf();
        yg();
        com.baidu.live.alablmsdk.a.e.xq().release();
        com.baidu.live.alablmsdk.a.b.a.release();
        com.baidu.live.alablmsdk.a.b.c.xu().release();
    }

    @Override // com.baidu.live.alablmsdk.a.b.d
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.awq != null) {
            this.awq.onLogReport(str, jSONObject, jSONObject2);
        }
    }
}
