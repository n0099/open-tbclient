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
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.alablmsdk.a.c;
import com.baidu.live.alablmsdk.c.d;
import com.baidu.live.alablmsdk.config.enums.BLMMediaType;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private String aCM;
    public BIMRtcListener aCN;
    private Context mContext;
    private String mSource;
    private BLMRoomMode aCK = BLMRoomMode.BLMROOMMODE_1V1;
    private BLMMediaType aCL = BLMMediaType.BLMMEDIATYPE_AUDIO;
    private a aCJ = new a(c.xr());

    public b(Context context, BIMRtcListener bIMRtcListener) {
        this.mContext = context.getApplicationContext();
        this.aCN = bIMRtcListener;
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            BIMRtcClient.setRtcDebugAndLogEnable(this.mContext, true, true);
        } else {
            BIMRtcClient.setRtcDebugAndLogEnable(this.mContext, false, false);
        }
        BIMRtcClient.registerRtcListener(context, this.aCN);
    }

    public void v(HashMap<String, Object> hashMap) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        if (hashMap != null) {
            if (hashMap.containsKey("room_mode") && (obj4 = hashMap.get("room_mode")) != null) {
                this.aCK = (BLMRoomMode) obj4;
            }
            if (hashMap.containsKey("media_type") && (obj3 = hashMap.get("media_type")) != null) {
                this.aCL = (BLMMediaType) obj3;
            }
            if (hashMap.containsKey("rtc_room_source_key") && (obj2 = hashMap.get("rtc_room_source_key")) != null) {
                this.mSource = (String) obj2;
            }
            if (hashMap.containsKey("rtc_business_source_key") && (obj = hashMap.get("rtc_business_source_key")) != null) {
                this.aCM = (String) obj;
                com.baidu.live.alablmsdk.a.b.c.xx().eL(this.aCM);
            }
        }
    }

    public long zq() {
        return AccountManager.getUK(this.mContext);
    }

    public void a(BIMRtcTokenListener bIMRtcTokenListener) {
        com.baidu.live.alablmsdk.a.b.a.ag(" createRoom  mSource = " + this.mSource, "");
        this.aCJ.createRoom(this.mContext, this.mSource, bIMRtcTokenListener);
    }

    public void join(String str, final IStatusListener iStatusListener) {
        this.aCJ.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.1
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                iStatusListener.onResult(i, str2);
            }
        });
    }

    public void c(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final d dVar) {
        if (TextUtils.isEmpty(str) || com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.d("invite fail , param error");
            com.baidu.live.alablmsdk.a.b.a.eG("invite fail  param error");
            if (dVar != null) {
                dVar.f(2, 1001, "invite param error");
                return;
            }
            return;
        }
        BIMInviteRtcInfo bIMInviteRtcInfo = new BIMInviteRtcInfo(this.mContext);
        bIMInviteRtcInfo.setRtcRoomId(str);
        bIMInviteRtcInfo.setRtcRoomType(2);
        if (this.aCL == BLMMediaType.BLMMEDIATYPE_AUDIO) {
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
            com.baidu.live.alablmsdk.module.c cVar = list.get(i2);
            if (cVar != null && cVar.appId != 0 && cVar.azK != 0 && !TextUtils.isEmpty(cVar.cuid) && !TextUtils.isEmpty(cVar.azQ)) {
                BIMInviteRtcInfo.BIMInviteUser bIMInviteUser = new BIMInviteRtcInfo.BIMInviteUser();
                bIMInviteUser.appId = cVar.appId;
                bIMInviteUser.uk = cVar.azK;
                bIMInviteUser.cuid = cVar.cuid;
                bIMInviteUser.thirdUserId = cVar.azQ;
                bIMInviteUser.appVersion = cVar.appVersion;
                arrayList.add(bIMInviteUser);
                com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
                bVar.azK = cVar.azK;
                bVar.order = cVar.order;
                jSONArray.put(bVar.toJSON());
            } else {
                com.baidu.live.alablmsdk.a.b.a.d("invite user info check error");
                com.baidu.live.alablmsdk.a.b.a.eG("invite user info check error");
            }
            i = i2 + 1;
        }
        if (com.baidu.live.alablmsdk.a.a.isEmpty(arrayList)) {
            if (dVar != null) {
                dVar.f(2, 1001, "list is empty");
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.baidu.live.alablmsdk.a.b.c.xx().xG();
        }
        aVar.azZ = jSONArray.toString();
        bIMInviteRtcInfo.setRtcExt(aVar.w(jSONObject));
        bIMInviteRtcInfo.setBIMInviteUsers(arrayList);
        com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom invite execute ");
        com.baidu.live.alablmsdk.a.b.a.eG(" BLMSignalRoom invite execute");
        this.aCJ.invite(this.mContext, bIMInviteRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i4, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom invite onResult i=" + i4 + " , s=" + str2);
                com.baidu.live.alablmsdk.a.b.a.eG(" BLMSignalRoom invite onResult i " + i4 + " s " + str2);
                if (i4 == 0) {
                    if (dVar != null) {
                        dVar.f(2, 0, "invite users success");
                    }
                } else if (dVar != null) {
                    dVar.f(2, -1, "invite users fail , i=" + i4 + " , s=" + str2);
                }
            }
        });
    }

    public void a(String str, long j, BIMRtcTokenListener bIMRtcTokenListener) {
        if (this.aCJ != null) {
            this.aCJ.generateToken(this.mContext, this.mSource, str, j, bIMRtcTokenListener);
        }
    }

    public void d(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, final d dVar) {
        if (TextUtils.isEmpty(str) || com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.d("cancelCall fail , param error");
            com.baidu.live.alablmsdk.a.b.a.eG("cancelCall fail param error");
            if (dVar != null) {
                dVar.f(3, 1001, "param error");
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
            com.baidu.live.alablmsdk.module.c cVar = list.get(i2);
            if (cVar != null && cVar.appId != 0 && cVar.azK != 0 && !TextUtils.isEmpty(cVar.cuid) && !TextUtils.isEmpty(cVar.azQ)) {
                BIMCancelRtcInfo.BIMCancelUser bIMCancelUser = new BIMCancelRtcInfo.BIMCancelUser();
                bIMCancelUser.appId = cVar.appId;
                bIMCancelUser.uk = cVar.azK;
                bIMCancelUser.cuid = cVar.cuid;
                bIMCancelUser.thirdUserId = cVar.azQ;
                arrayList.add(bIMCancelUser);
                bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
            }
            i = i2 + 1;
        }
        bIMCancelRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().w(jSONObject));
        if (com.baidu.live.alablmsdk.a.a.isEmpty(arrayList)) {
            if (dVar != null) {
                dVar.f(3, 1001, "list is empty");
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.c.xx().xH();
        com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom cancelCall execute");
        com.baidu.live.alablmsdk.a.b.a.eG(" BLMSignalRoom cancelCall execute");
        this.aCJ.cancelCall(this.mContext, bIMCancelRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i3, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d("cancelCall responseCode " + i3 + " , errorMessage = " + str2);
                com.baidu.live.alablmsdk.a.b.a.eG("cancelCall responseCode " + i3 + " , errorMessage " + str2);
                if (i3 == 0) {
                    if (dVar != null) {
                        dVar.f(3, 0, "cancel call success");
                    }
                } else if (dVar != null) {
                    int i4 = i3 != 5029 ? -1 : 5029;
                    com.baidu.live.alablmsdk.a.b.a.d("cancelCall callback errorCode=" + i4);
                    com.baidu.live.alablmsdk.a.b.a.eG("cancelCall callback errorCode " + i4);
                    dVar.f(3, i4, "cancel call fail. responseCode=" + i3 + " errorMessage=" + str2);
                }
            }
        });
    }

    private void a(String str, int i, JSONObject jSONObject, final d dVar) {
        final int i2 = 4;
        if (i == 2) {
            i2 = 5;
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.a.b.a.d("answer fail , roomId im empty");
            com.baidu.live.alablmsdk.a.b.a.eG("answer fail roomId im empty");
            if (dVar != null) {
                dVar.f(i2, 1001, "roomId im empty");
                return;
            }
            return;
        }
        BIMAnswerRtcInfo bIMAnswerRtcInfo = new BIMAnswerRtcInfo();
        bIMAnswerRtcInfo.setRtcRoomId(str);
        bIMAnswerRtcInfo.setAnswerType(i);
        if (this.aCL == BLMMediaType.BLMMEDIATYPE_AUDIO) {
            bIMAnswerRtcInfo.setAnswerMediaType(1);
        } else {
            bIMAnswerRtcInfo.setAnswerMediaType(2);
        }
        if (jSONObject != null) {
            bIMAnswerRtcInfo.setRtcExt(jSONObject.toString());
        }
        this.aCJ.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i3, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d("answer responseCode = " + i3 + " , errorMessage = " + str2);
                com.baidu.live.alablmsdk.a.b.a.eG("answer responseCode " + i3 + " errorMessage " + str2);
                if (i3 == 0) {
                    if (dVar != null) {
                        dVar.f(i2, 0, "answer success");
                    }
                } else if (dVar != null) {
                    dVar.f(i2, -1, "answer fail. responseCode = " + i3 + " , errorMessage = " + str2);
                }
            }
        });
    }

    public void d(String str, JSONObject jSONObject, d dVar) {
        a(str, 1, jSONObject, dVar);
    }

    public void e(String str, JSONObject jSONObject, d dVar) {
        a(str, 2, jSONObject, dVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject, d dVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.azQ) || TextUtils.isEmpty(cVar.cuid) || cVar.appId == 0 || cVar.azK == 0) {
            if (dVar != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("kick off,user info error", "");
                dVar.f(9, -1, "kick off,user info error");
                return;
            }
            return;
        }
        BIMKickRequestRtcInfo bIMKickRequestRtcInfo = new BIMKickRequestRtcInfo();
        bIMKickRequestRtcInfo.setRtcRoomId(str);
        BIMUser bIMUser = new BIMUser();
        bIMUser.thirdUserId = cVar.azQ;
        bIMUser.cuid = cVar.cuid;
        bIMUser.appId = cVar.appId;
        bIMUser.uk = cVar.azK;
        bIMKickRequestRtcInfo.setBIMKickedUser(bIMUser);
        if (jSONObject != null) {
            bIMKickRequestRtcInfo.setRtcExt(jSONObject.toString());
        }
        com.baidu.live.alablmsdk.a.b.c.xx().xN();
        this.aCJ.kickoff(this.mContext, bIMKickRequestRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    com.baidu.live.alablmsdk.a.b.a.ag("kick off, success , responseCode=" + i, "");
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag("kick off, fail, responseCode=" + i, "");
                }
            }
        });
    }

    public void hangout(String str, IStatusListener iStatusListener) {
        this.aCJ.hangout(this.mContext, str, iStatusListener);
    }

    public void a(String str, JSONObject jSONObject, IStatusListener iStatusListener) {
        com.baidu.live.alablmsdk.a.b.a.d(" signal hangout , roomId=" + str);
        com.baidu.live.alablmsdk.a.b.a.eG(" signal hangout roomId " + str);
        BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
        bIMRtcInfo.setRtcRoomId(str);
        bIMRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().w(jSONObject));
        this.aCJ.hangout(this.mContext, bIMRtcInfo, iStatusListener);
    }

    public void a(String str, IStatusListener iStatusListener) {
        b(str, null, iStatusListener);
    }

    public void b(String str, JSONObject jSONObject, final IStatusListener iStatusListener) {
        com.baidu.live.alablmsdk.a.b.a.d(" signal closeRoom , roomId=" + str);
        com.baidu.live.alablmsdk.a.b.a.eG(" signal closeRoom roomId " + str);
        BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
        bIMCloseRoomRtcInfo.setRtcRoomId(str);
        bIMCloseRoomRtcInfo.setRoomDuration(0L);
        bIMCloseRoomRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().w(jSONObject));
        this.aCJ.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.a.d("closeRoom onResult code " + i + ", msg :" + str2);
                com.baidu.live.alablmsdk.a.b.a.eG("closeRoom onResult code " + i + " msg " + str2);
                if (iStatusListener != null) {
                    iStatusListener.onResult(i, str2);
                }
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BLMSignalRoom release ");
        com.baidu.live.alablmsdk.a.b.a.eG(" BLMSignalRoom release ");
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aCN);
        this.aCN = null;
        if (this.aCJ != null) {
            this.aCJ.release();
        }
    }
}
