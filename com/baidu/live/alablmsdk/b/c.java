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
/* loaded from: classes10.dex */
public class c implements BIMRtcListener, IConnectListener, ILiveMsgReceiveListener, d, b.a, f {
    private com.baidu.live.alablmsdk.c.b axQ;
    private com.baidu.live.alablmsdk.e.b azf;
    public com.baidu.live.alablmsdk.module.a azk;
    private a azq;
    private b azr;
    private com.baidu.live.alablmsdk.d.c azs;
    private com.baidu.live.alablmsdk.d.b azt;
    private com.baidu.live.alablmsdk.d.a azu;
    private com.baidu.live.alablmsdk.c.d azv;
    private com.baidu.live.alablmsdk.c.c azw;
    private boolean azx;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a.a(this);
        com.baidu.live.alablmsdk.a.b.c.xx().b(this);
        this.azf = new com.baidu.live.alablmsdk.e.b(context, this);
        this.azq = new a(this.azf);
        this.azq.xX();
        this.azr = new b(this);
        this.azs = new com.baidu.live.alablmsdk.d.c(context);
        this.azs.a(this);
        this.azt = new com.baidu.live.alablmsdk.d.b(this.azs);
        this.azu = new com.baidu.live.alablmsdk.d.a(context, this.azs);
        this.azu.a(this.azs.yq());
        BIMManager.registerConnectListenerToList(this);
        BIMManager.registerStudioUsePaReceiveMsg(this.mContext, this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.axQ = bVar;
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.config.b.xQ().xR();
        this.azr.x(hashMap);
        this.azs.v(hashMap);
        this.azf.v(hashMap);
    }

    public int w(HashMap<String, Object> hashMap) {
        if (this.azs == null) {
            return 1000;
        }
        return this.azs.w(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.azs.a(aVar);
    }

    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync startLiveServerStreaming mode " + bLMLiveTransferMode, "");
        this.azs.a(bLMLiveTransferMode);
    }

    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync stopLiveServerStreaming mode " + bLMLiveTransferMode, "");
        this.azs.b(bLMLiveTransferMode);
    }

    public int a(com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync publishStream", "");
        this.azv = dVar;
        return this.azs.yl();
    }

    public void xn() {
        this.azs.xn();
    }

    public com.baidu.live.alablmsdk.d.a xo() {
        return this.azu;
    }

    public com.baidu.live.alablmsdk.d.b xp() {
        return this.azt;
    }

    public void a(final com.baidu.live.alablmsdk.c.a aVar) {
        this.azf.a(new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str, final BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (aVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync createRoom onResult code " + i + " message " + str, "");
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync createRoom onResult :   roomId=" + bIMRTCGetTokeResult.roomId + " , token=" + bIMRTCGetTokeResult.token + " , rtcAppId=" + bIMRTCGetTokeResult.rtcAppId + " , useId=" + bIMRTCGetTokeResult.useId);
                    }
                    if (i == 0 && bIMRTCGetTokeResult != null && !TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) && !TextUtils.isEmpty(bIMRTCGetTokeResult.token) && !TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) && bIMRTCGetTokeResult.useId != -1) {
                        c.this.a(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId, UserPermission.OWNER);
                        c.this.azf.join(bIMRTCGetTokeResult.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.1.1
                            @Override // com.baidu.android.imrtc.utils.IStatusListener
                            public void onResult(int i2, String str2) {
                                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal join onResult code " + i2 + " message " + str2, "");
                                if (i2 == 0) {
                                    if (c.this.azk != null) {
                                        c.this.azk.a(BLMSignalState.JOINED);
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
        if (this.azk == null) {
            this.azk = new com.baidu.live.alablmsdk.module.a();
        }
        this.azk.roomId = str;
        this.azk.token = str2;
        this.azk.rtcAppId = str3;
        this.azk.azK = j;
        com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
        com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
        cVar.azK = j;
        cVar.azP = userPermission;
        dVar.azT = cVar;
        this.azk.azL = dVar;
        com.baidu.live.alablmsdk.a.b.c.xx().setRtcRoomId(this.azk.roomId);
        if (this.azq != null) {
            a aVar = this.azq;
            a.eQ(this.azk.roomId);
            this.azq.a(str, this.azk.yt());
        }
        com.baidu.live.alablmsdk.module.b.yC().b(this.azk);
        if (this.azr != null) {
            this.azr.a(this.azk);
        }
    }

    public void a(String str, final List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.d dVar) {
        this.azf.c(str, list, jSONObject, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.4
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                if (i2 == 0 && c.this.azk != null && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list.size()) {
                            break;
                        }
                        com.baidu.live.alablmsdk.module.c cVar = (com.baidu.live.alablmsdk.module.c) list.get(i4);
                        if (cVar != null) {
                            com.baidu.live.alablmsdk.module.d dVar2 = new com.baidu.live.alablmsdk.module.d();
                            dVar2.azT = cVar.clone();
                            if (c.this.azk.yz() != null) {
                                dVar2.azT.azR = c.this.azk.yz().azK;
                            }
                            dVar2.b(BLMRtcState.DEFAULT);
                            c.this.azk.a(dVar2, BLMStateType.SIGNAL);
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
        this.azf.d(str, list, jSONObject, new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.5
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                if ((i2 == 0 || i2 == -1) && c.this.azk != null) {
                    c.this.azk.u(list);
                    if (c.this.azk.yy()) {
                        c.this.yi();
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
        this.azf.d(str, v(jSONObject), new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.6
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                if (i2 == 0) {
                    com.baidu.live.alablmsdk.module.b.yC().a(str, BLMSignalState.JOINED);
                    c.this.a(str, false, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.alablmsdk.b.c.6.1
                        @Override // com.baidu.live.alablmsdk.c.c
                        public void a(int i3, BLMJoinRoomStage bLMJoinRoomStage, com.baidu.live.alablmsdk.module.common.a aVar) {
                            String str3 = aVar != null ? aVar.msg : "";
                            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync accept: visiter join rtc room， status=" + i3 + " msg=" + str3, "");
                            if (i3 == 0) {
                                com.baidu.live.alablmsdk.module.b.yC().a(str, BLMRtcState.JOINED);
                            } else {
                                com.baidu.live.alablmsdk.module.b.yC().a(str, BLMRtcState.FAIL);
                                c.this.eR(str);
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
                c.this.yi();
                if (cVar != null) {
                    com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                    aVar.msg = str3;
                    cVar.a(i2, BLMJoinRoomStage.JOIN, aVar);
                }
            }
        });
    }

    private JSONObject v(JSONObject jSONObject) {
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        if (this.azk != null && this.azk.azL != null && this.azk.azL.azT != null) {
            com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
            bVar.azK = this.azk.azL.azT.azK;
            bVar.order = this.azk.azL.azT.order;
            aVar.azZ = com.baidu.live.alablmsdk.module.a.b.a(bVar);
        }
        JSONObject v = aVar.v(jSONObject);
        if (v == null) {
            return new JSONObject();
        }
        return v;
    }

    public void a(String str, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.d dVar) {
        this.azf.e(str, v(jSONObject), new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.7
            @Override // com.baidu.live.alablmsdk.c.d
            public void f(int i, int i2, String str2) {
                c.this.yi();
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
                    com.baidu.live.alablmsdk.module.b.yC().a(str, BLMRtcState.JOINED);
                } else {
                    com.baidu.live.alablmsdk.module.b.yC().a(str, BLMRtcState.FAIL);
                }
                if (cVar2 != null) {
                    cVar2.a(i, bLMJoinRoomStage, aVar);
                }
            }
        });
    }

    private void a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar != null && this.azk != null && this.azk.azL != null && this.azk.azL.azT != null) {
            this.azk.azL.azT.order = cVar.order;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, boolean z, com.baidu.live.alablmsdk.c.c cVar) {
        if (this.axQ != null) {
            com.baidu.live.alablmsdk.a.b.c.xx().eK(this.axQ.xq());
        }
        this.azw = cVar;
        final com.baidu.live.alablmsdk.module.rtc.b bVar = new com.baidu.live.alablmsdk.module.rtc.b();
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync joinRoom param error, roomId isEmpty", "");
            if (this.azw != null) {
                com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                aVar.msg = "signal-rtc-sync joinRoom param error, roomId isEmpty";
                this.azw.a(-1, BLMJoinRoomStage.JOIN, aVar);
            }
        } else if (this.azk != null && !TextUtils.isEmpty(this.azk.roomId) && !this.azk.roomId.equals(str)) {
            if (this.azw != null) {
                com.baidu.live.alablmsdk.module.common.a aVar2 = new com.baidu.live.alablmsdk.module.common.a();
                aVar2.msg = "signal-rtc-sync currentChatInfo roomid , roomId different";
                this.azw.a(-1, BLMJoinRoomStage.JOIN, aVar2);
            }
        } else {
            if (z) {
                com.baidu.live.alablmsdk.a.b.c.xx().xF();
            }
            if (this.azk == null || this.azk.yw() != BLMSignalState.JOINED) {
                if (this.azf != null) {
                    this.azf.join(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.9
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str2) {
                            if (i != 0) {
                                c.this.a(BLMJoinRoomStage.JOIN, "signal-rtc-sync join signal error, code=" + i + " , msg=" + str2);
                                return;
                            }
                            if (c.this.azk == null) {
                                c.this.azk = new com.baidu.live.alablmsdk.module.a();
                            }
                            c.this.azk.a(BLMSignalState.JOINED);
                            c.this.azf.a(str, c.this.azf.zq(), new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.b.c.9.1
                                @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
                                public void onResult(int i2, String str3, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                                    com.baidu.live.alablmsdk.a.b.a.eG("signal-rtc-sync generateToken onResult code " + i2 + " message=" + str3);
                                    if (i2 != 0 || bIMRTCGetTokeResult == null || TextUtils.isEmpty(bIMRTCGetTokeResult.roomId) || TextUtils.isEmpty(bIMRTCGetTokeResult.token) || TextUtils.isEmpty(bIMRTCGetTokeResult.rtcAppId) || bIMRTCGetTokeResult.useId == -1) {
                                        c.this.a(BLMJoinRoomStage.JOIN, "signal-rtc-sync generateToken error: code=" + i2 + " , message=" + str3);
                                        return;
                                    }
                                    c.this.a(bIMRTCGetTokeResult.roomId, bIMRTCGetTokeResult.token, bIMRTCGetTokeResult.rtcAppId, bIMRTCGetTokeResult.useId, UserPermission.VISITER);
                                    bVar.azh = bIMRTCGetTokeResult.roomId;
                                    bVar.aAf = bIMRTCGetTokeResult.rtcAppId;
                                    bVar.aAe = bIMRTCGetTokeResult.token;
                                    bVar.aAg = bIMRTCGetTokeResult.useId;
                                    c.this.azs.a(bVar, c.this.azw);
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
            bVar.azh = this.azk.roomId;
            bVar.aAf = this.azk.rtcAppId;
            bVar.aAe = this.azk.token;
            bVar.aAg = this.azk.azK;
            com.baidu.live.alablmsdk.module.c yz = this.azk.yz();
            if (yz != null && !TextUtils.isEmpty(yz.order)) {
                this.azs.eT(yz.order);
            }
            this.azs.a(bVar, this.azw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BLMJoinRoomStage bLMJoinRoomStage, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync join Room error: stage=" + bLMJoinRoomStage + " msg=" + str, "");
        if (this.azw != null) {
            com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
            aVar.msg = str;
            this.azw.a(-1, BLMJoinRoomStage.JOIN, aVar);
        }
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.d dVar) {
        if (this.azs != null && !TextUtils.isEmpty(this.azs.yp()) && this.azs.yp().equals(str) && !com.baidu.live.alablmsdk.a.a.isEmpty(list) && !com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.module.c cVar = list.get(0);
            this.azs.az(cVar.azK);
            this.azf.a(str, cVar, v(jSONObject), new com.baidu.live.alablmsdk.c.d() { // from class: com.baidu.live.alablmsdk.b.c.10
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
        this.azs.b(str, list, z);
    }

    public void aY(boolean z) {
        if (this.azt != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal-rtc-sync muteMicrophone " + z, "");
            this.azt.aY(z);
        }
    }

    public void aZ(boolean z) {
        if (this.azt != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync muteSpeaker " + z, "");
            this.azt.aZ(z);
        }
    }

    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.azs != null) {
            return this.azs.h(str, cVar);
        }
        return false;
    }

    private void ye() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync currentKickedOffLeave ", "");
        if (this.azs != null) {
            this.azs.yr();
        }
        yj();
        yi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(String str) {
        a(str, com.baidu.live.alablmsdk.module.a.a.yI(), false, (com.baidu.live.alablmsdk.c.d) null);
    }

    public void a(String str, JSONObject jSONObject, boolean z, final com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync leaveRoom", "");
        if (z) {
            if (this.azk != null && this.azk.yu() && !this.azk.yy()) {
                com.baidu.live.alablmsdk.a.b.c.xx().bc(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.xx().bc(false);
            }
            com.baidu.live.alablmsdk.a.b.c.xx().xL();
        }
        this.azs.yr();
        this.azf.a(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.11
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync leaveRoom onResult code " + i + " message " + str2, "");
                if (i == 0) {
                    if (c.this.azq != null) {
                        c.this.azq.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                    }
                    if (dVar != null) {
                        dVar.f(7, 0, "signal-rtc-sync leaveRoom hangout signal success");
                        return;
                    }
                    return;
                }
                if (c.this.azq != null) {
                    c.this.azq.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                }
                if (dVar != null) {
                    dVar.f(7, -1, "signal-rtc-sync leaveRoom hangout signal fail");
                }
            }
        });
        yj();
        yi();
    }

    public void a(final String str, boolean z, final JSONObject jSONObject, boolean z2, final com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync closeRoom roomId " + str, "");
        if (z2) {
            if (this.azk != null && this.azk.yu() && !this.azk.yy()) {
                com.baidu.live.alablmsdk.a.b.c.xx().bc(true);
            } else {
                com.baidu.live.alablmsdk.a.b.c.xx().bc(false);
            }
            com.baidu.live.alablmsdk.a.b.c.xx().xM();
        }
        com.baidu.live.alablmsdk.module.a eU = com.baidu.live.alablmsdk.module.b.yC().eU(str);
        final UserPermission userPermission = UserPermission.OWNER;
        if (eU != null) {
            userPermission = eU.yt();
        }
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync closeRoom permission " + userPermission, "");
        if (z) {
            this.azs.ys();
        } else if (userPermission == UserPermission.OWNER) {
            this.azs.ys();
        } else {
            this.azs.yr();
        }
        this.azf.hangout(str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync closeRoom-signal hangout code " + i + " errorMessage " + str2, "");
                if (userPermission == UserPermission.OWNER) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal close ", "");
                    c.this.azf.b(str, jSONObject, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.2.1
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i2, String str3) {
                            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal closeRoom code " + i2 + " errorMessage " + str3, "");
                            if (i2 == 0) {
                                if (c.this.azq != null) {
                                    c.this.azq.a(BLMLegacyRoomStatus.LOGIC_END_SUCCESS);
                                }
                                if (dVar != null) {
                                    dVar.f(8, 0, "signal-rtc-sync closeRoom signal success");
                                    return;
                                }
                                return;
                            }
                            if (c.this.azq != null) {
                                c.this.azq.a(BLMLegacyRoomStatus.LOGIC_END_FAIL);
                            }
                            if (dVar != null) {
                                dVar.f(8, -1, "signal-rtc-sync closeRoom signal success");
                            }
                        }
                    });
                }
            }
        });
        yi();
        yj();
    }

    @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
    public void onReceiveMessage(int i, JSONArray jSONArray) {
        com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync b2c可靠消息通道的监听  ");
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync im long connection code " + i, "");
        ch(i);
        com.baidu.live.alablmsdk.a.b.c.xx().bd(i == 0);
    }

    private void ch(int i) {
        if (i == 0) {
            if (this.azk != null) {
                yf();
            } else if (this.azk == null) {
                this.azq.xW();
            }
        }
    }

    private void yf() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner ", "");
        if (this.azk != null) {
            this.azf.join(this.azk.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.c.3
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner signal join onResult code=" + i + " message=" + str, "");
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync reJoinSignalAndRtcRoomInner signal join success", "");
                        c.this.azs.ym();
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
            if (this.azk != null && !TextUtils.isEmpty(this.azk.roomId) && this.azk.roomId.equals(str)) {
                yi();
            }
            if (this.axQ != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync room closed callback roomId " + str, "");
                this.axQ.eE(str);
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
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller invite time out", " , other imUk=" + cVar.azK);
        if (this.azk != null && this.azk.yu()) {
            if (this.azk.aE(cVar.azK)) {
                com.baidu.live.alablmsdk.module.b.yC().a(str, cVar.azK, BLMSignalState.TIMEOUT);
                com.baidu.live.alablmsdk.a.b.c.xx().xJ();
                if (this.axQ != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller invite time out callback ", "");
                    this.axQ.b(str, cVar);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.c.xx().xJ();
            if (this.axQ != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller invite time out, check imUk error, but callback ", "");
                this.axQ.b(str, cVar);
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
                jSONObject = aVar2.eV(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                BIMSyncRtcInfo bIMSyncRtcInfo = (BIMSyncRtcInfo) bIMRtcInfo;
                j2 = bIMSyncRtcInfo.getInitiatorUk();
                cVar.azK = bIMSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (!TextUtils.isEmpty(str) && this.azk != null && !TextUtils.isEmpty(this.azk.roomId) && this.azk.roomId.equals(str)) {
                    com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                    dVar.azT = cVar.clone();
                    this.azk.a(dVar, BLMStateType.SIGNAL);
                }
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller receive callee response", " callee 的 uk=" + cVar.azK);
            }
            j = j2;
        }
        if (i == 1) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer ok", "");
            com.baidu.live.alablmsdk.module.b.yC().a(str, j, BLMSignalState.JOINED);
            if (this.axQ != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer ok callback", "");
                this.axQ.d(str, cVar, jSONObject);
            }
        } else if (i == 2) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer no", "");
            com.baidu.live.alablmsdk.module.b.yC().a(str, j, BLMSignalState.REJECT);
            com.baidu.live.alablmsdk.a.b.c.xx().xI();
            if (this.axQ != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer no callback", "");
                this.axQ.e(str, cVar, jSONObject);
            }
        } else if (i == 3) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer timeout 30s", "");
            com.baidu.live.alablmsdk.module.b.yC().a(str, j, BLMSignalState.TIMEOUT);
            com.baidu.live.alablmsdk.a.b.c.xx().xJ();
            if (this.axQ != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync caller，callee answer timeout 30s callback", "");
                this.axQ.b(str, cVar);
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
                if (this.azk != null && this.azk.roomId != null && !this.azk.roomId.equals(rtcRoomId)) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync callee get invite mCurrentChatInfo.roomId != roomId return mCurrentChatInfo.roomId " + this.azk.roomId, "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.c.xx().setRtcRoomId(rtcRoomId);
                String rtcExt = bIMInviteSyncRtcInfo.getRtcExt();
                com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync callee receive invite,  originalExt=" + rtcExt);
                com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
                JSONObject eV = aVar.eV(rtcExt);
                com.baidu.live.alablmsdk.module.a eU = com.baidu.live.alablmsdk.module.b.yC().eU(rtcRoomId);
                if (eU == null) {
                    eU = new com.baidu.live.alablmsdk.module.a();
                }
                eU.roomId = rtcRoomId;
                eU.token = bIMInviteSyncRtcInfo.getRtcRoomToken();
                eU.rtcAppId = bIMInviteSyncRtcInfo.getRtcAppId();
                eU.azK = bIMInviteSyncRtcInfo.getRtcUserId();
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = eU.azK;
                cVar.azP = UserPermission.VISITER;
                cVar.azR = bIMInviteSyncRtcInfo.getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                dVar.azT = cVar;
                dVar.b(BLMSignalState.RING);
                eU.azL = dVar;
                com.baidu.live.alablmsdk.module.d dVar2 = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.azK = bIMInviteSyncRtcInfo.getInitiatorUk();
                cVar2.azP = UserPermission.OWNER;
                com.baidu.live.alablmsdk.module.a.b.a(cVar2, aVar);
                dVar2.azT = cVar2;
                dVar2.b(BLMSignalState.JOINED);
                eU.a(dVar2, BLMStateType.SIGNAL);
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("signal-rtc-sync callee 收到邀请 ， " + eU.yv());
                }
                this.azk = eU;
                com.baidu.live.alablmsdk.module.b.yC().b(eU);
                if (this.azr != null) {
                    this.azr.a(this.azk);
                }
                if (this.azq != null) {
                    a aVar2 = this.azq;
                    a.eQ(eU.roomId);
                    this.azq.a(eU.roomId, eU.yt());
                }
                com.baidu.live.alablmsdk.module.c clone = cVar2.clone();
                if (this.axQ != null) {
                    this.axQ.b(rtcRoomId, clone, eV);
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
                jSONObject = aVar.eV(rtcExt);
            } else {
                aVar = null;
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
            str = null;
        }
        if (this.azk != null && this.azk.yu() && !TextUtils.isEmpty(this.azk.roomId) && this.azk.roomId.equals(str) && this.azk.aE(cVar.azK)) {
            yi();
            if (this.axQ != null) {
                this.axQ.c(str, cVar, jSONObject);
            }
        }
    }

    @Override // com.baidu.android.imrtc.msg.BIMRtcListener
    public void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo) {
        com.baidu.live.alablmsdk.module.b.yC().a(bIMRtcInfo.getRtcRoomId(), BLMSignalState.DEFAULT);
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
                jSONObject = aVar2.eV(rtcExt);
                aVar = aVar2;
            } else {
                jSONObject = null;
                aVar = null;
            }
            String rtcRoomId = bIMRtcInfo.getRtcRoomId();
            if (bIMRtcInfo instanceof BIMSyncRtcInfo) {
                cVar.azK = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
                com.baidu.live.alablmsdk.module.a.b.a(cVar, aVar);
                if (this.azk != null && (aD = this.azk.aD(cVar.azK)) != null && !TextUtils.isEmpty(aD.order)) {
                    cVar.order = aD.order;
                }
            }
            str = rtcRoomId;
        } else {
            jSONObject = null;
            aVar = null;
        }
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync roomEventSyncByOthers roomEventType " + roomEventType + " roomId " + str, "");
        if (eS(str)) {
            if (roomEventType == RtcConstants.RoomEventType.CALLEE_RING) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync signal： other ringing ", "");
                com.baidu.live.alablmsdk.module.b.yC().a(str, cVar.azK, BLMSignalState.RING);
                if (this.axQ != null) {
                    this.axQ.a(str, cVar, jSONObject);
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
        com.baidu.live.alablmsdk.module.a eU;
        if (cVar != null && (eU = com.baidu.live.alablmsdk.module.b.yC().eU(str)) != null) {
            com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
            dVar.azT = cVar.clone();
            dVar.b(BLMSignalState.JOINED);
            eU.a(dVar, BLMStateType.SIGNAL);
        }
    }

    private void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.module.a.a aVar) {
        if (cVar != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave roomId " + str, " , callbackUser = " + cVar.toString());
            if (this.azk != null && !TextUtils.isEmpty(this.azk.roomId) && this.azk.roomId.equals(str) && this.azk.yu()) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave ，remove otherImUk ", "");
                this.azk.aB(cVar.azK);
                if (aVar != null && aVar.aAa) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave ，hasStatusCheckInfoKey reture ", "");
                } else if (this.axQ != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleSignalUserLeave ，onRoomUserLeaved callback ", "");
                    this.axQ.d(str, cVar);
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
        com.baidu.live.alablmsdk.module.c yz;
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
            if (this.azk != null && (yz = this.azk.yz()) != null && yz.azK != 0 && yz.azK == j) {
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
        com.baidu.live.alablmsdk.a.b.a.eG("signal-rtc-sync handleCurrentUserKicked ");
        if (this.azk != null) {
            String str2 = this.azk.roomId;
            com.baidu.live.alablmsdk.module.c yz = this.azk.yz();
            if (yz != null) {
                cVar = yz.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        ye();
        if (this.axQ != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync current, onRoomUserKickoffed call back", "");
            this.axQ.e(str, cVar);
        }
    }

    private void av(long j) {
        com.baidu.live.alablmsdk.module.c cVar;
        String str;
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync handleOtherUserKicked uk=" + j, "");
        if (this.azk != null) {
            String str2 = this.azk.roomId;
            com.baidu.live.alablmsdk.module.c aD = this.azk.aD(j);
            if (aD != null) {
                cVar = aD.clone();
                str = str2;
            } else {
                cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = j;
                str = str2;
            }
        } else {
            cVar = null;
            str = null;
        }
        if (this.azk != null) {
            this.azk.aB(j);
        }
        if (this.axQ != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync other, onRoomUserKickoffed call back", "");
            this.axQ.e(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void onError(int i, String str) {
        if (this.axQ != null) {
            this.axQ.g(i, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public List<com.baidu.live.alablmsdk.module.c> yg() {
        if (this.azk != null) {
            return this.azk.yx();
        }
        return null;
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void i(int i, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserJoinRoom status " + i + " , msg=" + str, "");
        if (yh() && i == 0) {
            if (this.azk.azL != null && this.azk.azL.azT != null && !TextUtils.isEmpty(this.azk.azL.azT.order)) {
                String i2 = com.baidu.live.alablmsdk.module.a.b.i(this.azk.azL.azT);
                this.azs.setUserAttribute(i2);
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync setUserAttribute " + i2, "");
            }
            com.baidu.live.alablmsdk.a.b.c.xx().xz();
        }
        if (this.azw != null) {
            if (i == 0) {
                com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                aVar.msg = str;
                this.azw.a(0, BLMJoinRoomStage.JOIN, aVar);
            } else {
                com.baidu.live.alablmsdk.module.common.a aVar2 = new com.baidu.live.alablmsdk.module.common.a();
                aVar2.msg = str;
                this.azw.a(-1, BLMJoinRoomStage.JOIN, aVar2);
            }
            if (!this.azs.yo()) {
                this.azw = null;
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserPushMediaOk ", "");
        if (this.azv != null) {
            this.azv.f(10, 0, cVar != null ? cVar.toString() : " push media ok ");
            this.azv = null;
        }
        if (this.azw != null) {
            com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
            aVar.msg = cVar != null ? cVar.toString() : " push media ok ";
            this.azw.a(0, BLMJoinRoomStage.PUBLISH, aVar);
            if (!this.azs.yo()) {
                this.azw = null;
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void b(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserPushMediaFail ", "");
        if (this.azv != null) {
            this.azv.f(10, -1, cVar != null ? cVar.toString() : " push media error ");
            this.azv = null;
        }
        if (this.azw != null) {
            com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
            aVar.msg = cVar != null ? cVar.toString() : " push media ok ";
            this.azw.a(-1, BLMJoinRoomStage.PUBLISH, aVar);
            this.azw = null;
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void j(int i, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserTransStream status " + i + " , msg=" + str, "");
        if (i == 0) {
            this.azr.yc();
            if (this.azw != null) {
                com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                aVar.msg = str;
                this.azw.a(0, BLMJoinRoomStage.HOST_TRANS, aVar);
                this.azw = null;
            }
        } else if (this.azw != null) {
            com.baidu.live.alablmsdk.module.common.a aVar2 = new com.baidu.live.alablmsdk.module.common.a();
            aVar2.msg = str;
            this.azw.a(-1, BLMJoinRoomStage.HOST_TRANS, aVar2);
            this.azw = null;
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void ci(int i) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtcCurrentUserStreamChange status " + i, "");
        if (i == 2) {
            this.azr.yb();
        } else if (i == 1) {
            this.azr.yc();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void b(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.module.c cVar2;
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc user join room ", "");
        if (yh() && cVar != null) {
            aw(cVar.azK);
            if (this.azk.aE(cVar.azK)) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync remote join  invite join or reJoin rtc", "");
                com.baidu.live.alablmsdk.module.d aC = this.azk.aC(cVar.azK);
                com.baidu.live.alablmsdk.module.c aD = this.azk.aD(cVar.azK);
                if (aC != null) {
                    if (aC.yE() == BLMRtcState.DEFAULT) {
                        if (aD != null && aD.azR != 0 && this.azk.yz() != null && aD.azR == this.azk.yz().azK) {
                            com.baidu.live.alablmsdk.a.b.c.xx().cd(1);
                            com.baidu.live.alablmsdk.a.b.c.xx().xK();
                        } else if (this.azk.yz() != null && this.azk.yz().azR == 0 && !this.azx) {
                            this.azx = true;
                            com.baidu.live.alablmsdk.a.b.c.xx().cd(0);
                            com.baidu.live.alablmsdk.a.b.c.xx().xK();
                        }
                    }
                    aC.b(BLMRtcState.JOINED);
                }
                if (this.axQ != null) {
                    if (aD != null) {
                        cVar2 = aD.clone();
                    } else {
                        cVar2 = new com.baidu.live.alablmsdk.module.c();
                        cVar2.azK = cVar.azK;
                    }
                    this.axQ.c(this.azk.roomId, cVar2);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync remote join :  invite join or reJoin rtc", "");
            if (this.azk.yt() == UserPermission.OWNER && this.azs != null) {
                this.azs.az(cVar.azK);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void c(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc user leave room ", "");
        if (yh() && cVar != null && this.azk.aE(cVar.azK)) {
            com.baidu.live.alablmsdk.module.d aC = this.azk.aC(cVar.azK);
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote user leave", "");
            if (aC != null) {
                aC.b(BLMRtcState.LEAVE);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void d(com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.f(this.azk.roomId, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void e(com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.g(this.azk.roomId, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void c(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote stream arrived ", "");
        if (yh() && cVar != null) {
            if (this.azk.aE(cVar.azK)) {
                com.baidu.live.alablmsdk.module.d aC = this.azk.aC(cVar.azK);
                com.baidu.live.alablmsdk.module.c aD = this.azk.aD(cVar.azK);
                com.baidu.live.alablmsdk.module.rtc.c cVar2 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar2.azK = cVar.azK;
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
                if (this.azu != null) {
                    this.azu.j(true, cVar.azK);
                }
                if (this.axQ != null) {
                    this.axQ.a(cVar2, BLMStreamState.BLMSTREAMSTATE_ARRIVAL);
                }
                this.azr.at(cVar.azK);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync remote stream arrival", "");
            if (this.azk.yt() == UserPermission.OWNER && this.azs != null) {
                this.azs.az(cVar.azK);
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void d(com.baidu.live.alablmsdk.module.rtc.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote stream gone ", "");
        if (yh() && cVar != null && this.azk.aE(cVar.azK)) {
            com.baidu.live.alablmsdk.module.d aC = this.azk.aC(cVar.azK);
            com.baidu.live.alablmsdk.module.c aD = this.azk.aD(cVar.azK);
            com.baidu.live.alablmsdk.module.rtc.c cVar2 = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar2.azK = cVar.azK;
            if (aD != null) {
                cVar2.order = aD.order;
            }
            if (aC != null) {
                aC.b(BLMRtcState.STREAM_NO);
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote stream leave", "");
            if (this.axQ != null) {
                this.axQ.a(cVar2, BLMStreamState.BLMSTREAMSTATE_REMOVE);
            }
            this.azr.as(cVar.azK);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void f(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc remote attribute arrive", "");
        if (this.azk != null) {
            this.azk.h(cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void g(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc user kicked", "");
        if (yh() && cVar != null && this.azk.aA(cVar.azK)) {
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync rtc current user kicked ，do rtc leave room ", "");
            this.azs.yr();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void a(com.baidu.live.alablmsdk.c.b.b bVar) {
        if (bVar != null && this.azf != null) {
            bVar.ax(this.azf.zq());
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.f
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        if (this.axQ != null) {
            this.axQ.a(aVar);
        }
    }

    private boolean yh() {
        if (this.azk != null) {
            if (!TextUtils.isEmpty(this.azk.roomId)) {
                if (this.azk.yu()) {
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
        if (this.azk.yt() == UserPermission.VISITER) {
            if (this.azk.aC(j) == null) {
                com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync not current user, permission is visiter, add other list", "");
                com.baidu.live.alablmsdk.module.d dVar = new com.baidu.live.alablmsdk.module.d();
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = j;
                dVar.azT = cVar;
                this.azk.a(dVar, BLMStateType.NONE);
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync not current user, permission is visiter, has include the other", "");
        }
    }

    public void eC(String str) {
        if (this.azs != null) {
            this.azs.eC(str);
        }
    }

    public void a(e eVar) {
        if (this.azs != null) {
            this.azs.a(eVar);
        }
    }

    public void eD(String str) {
        if (this.azs != null) {
            this.azs.eD(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.b.b.a
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i) {
        if (this.axQ != null) {
            this.axQ.a(cVar, i);
        }
    }

    public void yi() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync resetCurrentChat ", "");
        this.azk = null;
        this.azx = false;
        com.baidu.live.alablmsdk.module.b.yC().clearAll();
    }

    public boolean eS(String str) {
        return (this.azk == null || TextUtils.isEmpty(this.azk.roomId) || !this.azk.roomId.equals(str)) ? false : true;
    }

    public void yj() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync stop all stream leave count down", "");
        this.azr.yd();
        this.azr.yc();
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.ag("signal-rtc-sync release ", "");
        this.azw = null;
        this.axQ = null;
        BIMManager.unregisterConnectListenerFromList(this);
        BIMManager.unregisterStudioUsePaReceiveMsg(this.mContext, this);
        if (this.azf != null) {
            this.azf.release();
            this.azf = null;
        }
        if (this.azr != null) {
            this.azr.release();
        }
        if (this.azs != null) {
            this.azs.release();
            this.azs = null;
        }
        if (this.azu != null) {
            this.azu.release();
        }
        if (this.azq != null) {
            this.azq.release();
        }
        this.azv = null;
        yi();
        yj();
        com.baidu.live.alablmsdk.a.e.xt().release();
        com.baidu.live.alablmsdk.a.b.a.release();
        com.baidu.live.alablmsdk.a.b.c.xx().release();
    }

    @Override // com.baidu.live.alablmsdk.a.b.d
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.axQ != null) {
            this.axQ.onLogReport(str, jSONObject, jSONObject2);
        }
    }
}
