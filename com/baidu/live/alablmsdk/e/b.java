package com.baidu.live.alablmsdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.send.BIMKickRequestRtcInfo;
import com.baidu.android.imrtc.send.BIMUser;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.c;
import com.baidu.live.alablmsdk.config.enums.BLMMediaType;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public BIMRtcListener aEv;
    private Context mContext;
    private String mSource;
    private BLMRoomMode aEt = BLMRoomMode.BLMROOMMODE_1V1;
    private BLMMediaType aEu = BLMMediaType.BLMMEDIATYPE_AUDIO;
    private a aEs = new a(c.Bj());

    public b(Context context, BIMRtcListener bIMRtcListener) {
        this.mContext = context.getApplicationContext();
        this.aEv = bIMRtcListener;
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            BIMRtcClient.setRtcDebugAndLogEnable(this.mContext, true, true);
        } else {
            BIMRtcClient.setRtcDebugAndLogEnable(this.mContext, false, false);
        }
        BIMRtcClient.registerRtcListener(context, this.aEv);
    }

    public void v(HashMap<String, Object> hashMap) {
        Object obj;
        Object obj2;
        Object obj3;
        if (hashMap != null) {
            if (hashMap.containsKey("room_mode") && (obj3 = hashMap.get("room_mode")) != null) {
                this.aEt = (BLMRoomMode) obj3;
            }
            if (hashMap.containsKey("media_type") && (obj2 = hashMap.get("media_type")) != null) {
                this.aEu = (BLMMediaType) obj2;
            }
            if (hashMap.containsKey("rtc_room_source_key") && (obj = hashMap.get("rtc_room_source_key")) != null) {
                this.mSource = (String) obj;
                com.baidu.live.alablmsdk.a.b.c.Bp().fJ(this.mSource);
            }
        }
    }

    public void a(BIMRtcTokenListener bIMRtcTokenListener) {
        com.baidu.live.alablmsdk.a.b.a.aj(" createRoom  mSource = " + this.mSource, "");
        this.aEs.createRoom(this.mContext, this.mSource, bIMRtcTokenListener);
    }

    public void join(String str, final IStatusListener iStatusListener) {
        this.aEs.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.1
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                iStatusListener.onResult(i, str2);
            }
        });
    }

    public void c(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        if (TextUtils.isEmpty(str) || com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.d("invite fail , param error");
            com.baidu.live.alablmsdk.a.b.a.fI("invite fail  param error");
            if (cVar != null) {
                cVar.f(2, 1000, "invite param error");
                return;
            }
            return;
        }
        BIMInviteRtcInfo bIMInviteRtcInfo = new BIMInviteRtcInfo(this.mContext);
        bIMInviteRtcInfo.setRtcRoomId(str);
        bIMInviteRtcInfo.setRtcRoomType(2);
        if (this.aEu == BLMMediaType.BLMMEDIATYPE_AUDIO) {
            bIMInviteRtcInfo.setMediaType(1);
        } else {
            bIMInviteRtcInfo.setMediaType(2);
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.baidu.live.alablmsdk.module.a.a aVar = new com.baidu.live.alablmsdk.module.a.a();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            com.baidu.live.alablmsdk.module.c cVar2 = list.get(i2);
            if (cVar2 != null && cVar2.appId != 0 && cVar2.aCG != 0 && !TextUtils.isEmpty(cVar2.cuid) && !TextUtils.isEmpty(cVar2.aCM)) {
                BIMInviteRtcInfo.BIMInviteUser bIMInviteUser = new BIMInviteRtcInfo.BIMInviteUser();
                bIMInviteUser.appId = cVar2.appId;
                bIMInviteUser.uk = cVar2.aCG;
                bIMInviteUser.cuid = cVar2.cuid;
                bIMInviteUser.thirdUserId = cVar2.aCM;
                bIMInviteUser.appVersion = cVar2.appVersion;
                arrayList.add(bIMInviteUser);
                com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
                bVar.aCG = cVar2.aCG;
                bVar.order = cVar2.order;
                jSONArray.put(bVar.toJSON());
            } else {
                com.baidu.live.alablmsdk.a.b.a.d("invite user info check error");
                com.baidu.live.alablmsdk.a.b.a.fI("invite user info check error");
            }
            i = i2 + 1;
        }
        if (com.baidu.live.alablmsdk.a.a.isEmpty(arrayList)) {
            if (cVar != null) {
                cVar.f(2, 1000, "list is empty");
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.baidu.live.alablmsdk.a.b.c.Bp().Bu();
        }
        aVar.aCV = jSONArray.toString();
        bIMInviteRtcInfo.setRtcExt(aVar.u(jSONObject));
        bIMInviteRtcInfo.setBIMInviteUsers(arrayList);
        com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom invite execute ");
        com.baidu.live.alablmsdk.a.b.a.fI(" BLMSignalRoom invite execute");
        this.aEs.invite(this.mContext, bIMInviteRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i4, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom invite onResult i=" + i4 + " , s=" + str2);
                com.baidu.live.alablmsdk.a.b.a.fI(" BLMSignalRoom invite onResult i " + i4 + " s " + str2);
                if (i4 == 0) {
                    if (cVar != null) {
                        cVar.f(2, 0, "invite users success");
                    }
                } else if (cVar != null) {
                    cVar.f(2, -1, "invite users fail , i=" + i4 + " , s=" + str2);
                }
            }
        });
    }

    public void d(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        if (TextUtils.isEmpty(str) || com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.d("cancelCall fail , param error");
            com.baidu.live.alablmsdk.a.b.a.fI("cancelCall fail param error");
            if (cVar != null) {
                cVar.f(3, 1000, "param error");
                return;
            }
            return;
        }
        BIMCancelRtcInfo bIMCancelRtcInfo = new BIMCancelRtcInfo();
        bIMCancelRtcInfo.setRtcRoomId(str);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            com.baidu.live.alablmsdk.module.c cVar2 = list.get(i2);
            if (cVar2 != null && cVar2.appId != 0 && cVar2.aCG != 0 && !TextUtils.isEmpty(cVar2.cuid) && !TextUtils.isEmpty(cVar2.aCM)) {
                BIMCancelRtcInfo.BIMCancelUser bIMCancelUser = new BIMCancelRtcInfo.BIMCancelUser();
                bIMCancelUser.appId = cVar2.appId;
                bIMCancelUser.uk = cVar2.aCG;
                bIMCancelUser.cuid = cVar2.cuid;
                bIMCancelUser.thirdUserId = cVar2.aCM;
                arrayList.add(bIMCancelUser);
                bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
            }
            i = i2 + 1;
        }
        bIMCancelRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().u(jSONObject));
        if (com.baidu.live.alablmsdk.a.a.isEmpty(arrayList)) {
            if (cVar != null) {
                cVar.f(3, 1000, "list is empty");
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.c.Bp().Bv();
        com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom cancelCall execute");
        com.baidu.live.alablmsdk.a.b.a.fI(" BLMSignalRoom cancelCall execute");
        this.aEs.cancelCall(this.mContext, bIMCancelRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i3, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d("cancelCall responseCode " + i3 + " , errorMessage = " + str2);
                com.baidu.live.alablmsdk.a.b.a.fI("cancelCall responseCode " + i3 + " , errorMessage " + str2);
                if (i3 == 0) {
                    if (cVar != null) {
                        cVar.f(3, 0, "cancel call success");
                    }
                } else if (cVar != null) {
                    int i4 = i3 != 5029 ? -1 : 5029;
                    com.baidu.live.alablmsdk.a.b.a.d("cancelCall callback errorCode=" + i4);
                    com.baidu.live.alablmsdk.a.b.a.fI("cancelCall callback errorCode " + i4);
                    cVar.f(3, i4, "cancel call fail. responseCode=" + i3 + " errorMessage=" + str2);
                }
            }
        });
    }

    private void a(String str, int i, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        final int i2 = 4;
        if (i == 2) {
            i2 = 5;
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.a.b.a.d("answer fail , roomId im empty");
            com.baidu.live.alablmsdk.a.b.a.fI("answer fail roomId im empty");
            if (cVar != null) {
                cVar.f(i2, 1000, "roomId im empty");
                return;
            }
            return;
        }
        BIMAnswerRtcInfo bIMAnswerRtcInfo = new BIMAnswerRtcInfo();
        bIMAnswerRtcInfo.setRtcRoomId(str);
        bIMAnswerRtcInfo.setAnswerType(i);
        if (this.aEu == BLMMediaType.BLMMEDIATYPE_AUDIO) {
            bIMAnswerRtcInfo.setAnswerMediaType(1);
        } else {
            bIMAnswerRtcInfo.setAnswerMediaType(2);
        }
        if (jSONObject != null) {
            bIMAnswerRtcInfo.setRtcExt(jSONObject.toString());
        }
        this.aEs.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i3, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d("answer responseCode = " + i3 + " , errorMessage = " + str2);
                com.baidu.live.alablmsdk.a.b.a.fI("answer responseCode " + i3 + " errorMessage " + str2);
                if (i3 == 0) {
                    if (cVar != null) {
                        cVar.f(i2, 0, "cancel call success");
                    }
                } else if (cVar != null) {
                    cVar.f(i2, -1, "cancel call fail. responseCode = " + i3 + " , errorMessage = " + str2);
                }
            }
        });
    }

    public void e(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        a(str, 1, jSONObject, cVar);
    }

    public void f(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        a(str, 2, jSONObject, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar2) {
        if (cVar == null || TextUtils.isEmpty(cVar.aCM) || TextUtils.isEmpty(cVar.cuid) || cVar.appId == 0 || cVar.aCG == 0) {
            if (cVar2 != null) {
                com.baidu.live.alablmsdk.a.b.a.aj("kick off,user info error", "");
                cVar2.f(9, -1, "kick off,user info error");
                return;
            }
            return;
        }
        BIMKickRequestRtcInfo bIMKickRequestRtcInfo = new BIMKickRequestRtcInfo();
        bIMKickRequestRtcInfo.setRtcRoomId(str);
        BIMUser bIMUser = new BIMUser();
        bIMUser.thirdUserId = cVar.aCM;
        bIMUser.cuid = cVar.cuid;
        bIMUser.appId = cVar.appId;
        bIMUser.uk = cVar.aCG;
        bIMKickRequestRtcInfo.setBIMKickedUser(bIMUser);
        if (jSONObject != null) {
            bIMKickRequestRtcInfo.setRtcExt(jSONObject.toString());
        }
        com.baidu.live.alablmsdk.a.b.c.Bp().BB();
        this.aEs.kickoff(this.mContext, bIMKickRequestRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    com.baidu.live.alablmsdk.a.b.a.aj("kick off, success , responseCode=" + i, "");
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj("kick off, fail, responseCode=" + i, "");
                }
            }
        });
    }

    public void hangout(String str, IStatusListener iStatusListener) {
        this.aEs.hangout(this.mContext, str, iStatusListener);
    }

    public void a(String str, JSONObject jSONObject, IStatusListener iStatusListener) {
        com.baidu.live.alablmsdk.a.b.a.d(" signal hangout , roomId=" + str);
        com.baidu.live.alablmsdk.a.b.a.fI(" signal hangout roomId " + str);
        BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
        bIMRtcInfo.setRtcRoomId(str);
        bIMRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().u(jSONObject));
        this.aEs.hangout(this.mContext, bIMRtcInfo, iStatusListener);
    }

    public void a(String str, IStatusListener iStatusListener) {
        b(str, null, iStatusListener);
    }

    public void b(String str, JSONObject jSONObject, final IStatusListener iStatusListener) {
        com.baidu.live.alablmsdk.a.b.a.d(" signal closeRoom , roomId=" + str);
        com.baidu.live.alablmsdk.a.b.a.fI(" signal closeRoom roomId " + str);
        BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
        bIMCloseRoomRtcInfo.setRtcRoomId(str);
        bIMCloseRoomRtcInfo.setRoomDuration(0L);
        bIMCloseRoomRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().u(jSONObject));
        this.aEs.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d("closeRoom onResult code " + i + ", msg :" + str2);
                com.baidu.live.alablmsdk.a.b.a.fI("closeRoom onResult code " + i + " msg " + str2);
                if (iStatusListener != null) {
                    iStatusListener.onResult(i, str2);
                }
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom release ");
        com.baidu.live.alablmsdk.a.b.a.fI(" BLMSignalRoom release ");
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aEv);
        this.aEv = null;
        if (this.aEs != null) {
            this.aEs.release();
        }
    }
}
