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
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.config.enums.BLMMediaType;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import com.baidu.live.alablmsdk.module.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public BIMRtcListener aBy;
    private Context mContext;
    private String mSource;
    private BLMRoomMode aBw = BLMRoomMode.BLMROOMMODE_1V1;
    private BLMMediaType aBx = BLMMediaType.BLMMEDIATYPE_AUDIO;
    private a aBv = new a(d.Ay());

    public b(Context context, BIMRtcListener bIMRtcListener) {
        this.mContext = context.getApplicationContext();
        this.aBy = bIMRtcListener;
        if (com.baidu.live.alablmsdk.a.b.isDebug()) {
            BIMRtcClient.setRtcDebugAndLogEnable(this.mContext, true, true);
        } else {
            BIMRtcClient.setRtcDebugAndLogEnable(this.mContext, false, false);
        }
        BIMRtcClient.registerRtcListener(context, this.aBy);
    }

    public void v(HashMap<String, Object> hashMap) {
        Object obj;
        Object obj2;
        Object obj3;
        if (hashMap != null) {
            if (hashMap.containsKey("room_mode") && (obj3 = hashMap.get("room_mode")) != null) {
                this.aBw = (BLMRoomMode) obj3;
            }
            if (hashMap.containsKey("media_type") && (obj2 = hashMap.get("media_type")) != null) {
                this.aBx = (BLMMediaType) obj2;
            }
            if (hashMap.containsKey("rtc_room_source_key") && (obj = hashMap.get("rtc_room_source_key")) != null) {
                this.mSource = (String) obj;
            }
        }
    }

    public void a(BIMRtcTokenListener bIMRtcTokenListener) {
        com.baidu.live.alablmsdk.a.b.d(" createRoom  mSource = " + this.mSource);
        com.baidu.live.alablmsdk.a.b.fD(" createRoom  mSource = " + this.mSource);
        this.aBv.createRoom(this.mContext, this.mSource, bIMRtcTokenListener);
    }

    public void join(String str, final IStatusListener iStatusListener) {
        this.aBv.join(this.mContext, str, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.1
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                iStatusListener.onResult(i, str2);
            }
        });
    }

    public void c(String str, List<c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        if (TextUtils.isEmpty(str) || com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.d("invite fail , param error");
            com.baidu.live.alablmsdk.a.b.fD("invite fail  param error");
            if (cVar != null) {
                cVar.e(2, 1000, "invite param error");
                return;
            }
            return;
        }
        BIMInviteRtcInfo bIMInviteRtcInfo = new BIMInviteRtcInfo(this.mContext);
        bIMInviteRtcInfo.setRtcRoomId(str);
        bIMInviteRtcInfo.setRtcRoomType(2);
        if (this.aBx == BLMMediaType.BLMMEDIATYPE_AUDIO) {
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
            c cVar2 = list.get(i2);
            if (cVar2 != null && cVar2.appId != 0 && cVar2.azK != 0 && !TextUtils.isEmpty(cVar2.cuid) && !TextUtils.isEmpty(cVar2.azQ)) {
                BIMInviteRtcInfo.BIMInviteUser bIMInviteUser = new BIMInviteRtcInfo.BIMInviteUser();
                bIMInviteUser.appId = cVar2.appId;
                bIMInviteUser.uk = cVar2.azK;
                bIMInviteUser.cuid = cVar2.cuid;
                bIMInviteUser.thirdUserId = cVar2.azQ;
                bIMInviteUser.appVersion = cVar2.appVersion;
                arrayList.add(bIMInviteUser);
                com.baidu.live.alablmsdk.module.a.b bVar = new com.baidu.live.alablmsdk.module.a.b();
                bVar.azK = cVar2.azK;
                bVar.order = cVar2.order;
                jSONArray.put(bVar.toJSON());
            } else {
                com.baidu.live.alablmsdk.a.b.d("invite user info check error");
                com.baidu.live.alablmsdk.a.b.fD("invite user info check error");
            }
            i = i2 + 1;
        }
        if (com.baidu.live.alablmsdk.a.a.isEmpty(arrayList)) {
            if (cVar != null) {
                cVar.e(2, 1000, "list is empty");
                return;
            }
            return;
        }
        aVar.azY = jSONArray.toString();
        bIMInviteRtcInfo.setRtcExt(aVar.o(jSONObject));
        bIMInviteRtcInfo.setBIMInviteUsers(arrayList);
        com.baidu.live.alablmsdk.a.b.d(" BLMSignalRoom invite execute ");
        com.baidu.live.alablmsdk.a.b.fD(" BLMSignalRoom invite execute");
        this.aBv.invite(this.mContext, bIMInviteRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i3, String str2) {
                com.baidu.live.alablmsdk.a.b.d(" BLMSignalRoom invite onResult i=" + i3 + " , s=" + str2);
                com.baidu.live.alablmsdk.a.b.fD(" BLMSignalRoom invite onResult i " + i3 + " s " + str2);
                if (i3 == 0) {
                    if (cVar != null) {
                        cVar.e(2, 0, "invite users success");
                    }
                } else if (cVar != null) {
                    cVar.e(2, -1, "invite users fail , i=" + i3 + " , s=" + str2);
                }
            }
        });
    }

    public void d(String str, List<c> list, JSONObject jSONObject, final com.baidu.live.alablmsdk.c.c cVar) {
        if (TextUtils.isEmpty(str) || com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.d("cancelCall fail , param error");
            com.baidu.live.alablmsdk.a.b.fD("cancelCall fail param error");
            if (cVar != null) {
                cVar.e(3, 1000, "param error");
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
            c cVar2 = list.get(i2);
            if (cVar2 != null && cVar2.appId != 0 && cVar2.azK != 0 && !TextUtils.isEmpty(cVar2.cuid) && !TextUtils.isEmpty(cVar2.azQ)) {
                BIMCancelRtcInfo.BIMCancelUser bIMCancelUser = new BIMCancelRtcInfo.BIMCancelUser();
                bIMCancelUser.appId = cVar2.appId;
                bIMCancelUser.uk = cVar2.azK;
                bIMCancelUser.cuid = cVar2.cuid;
                bIMCancelUser.thirdUserId = cVar2.azQ;
                arrayList.add(bIMCancelUser);
                bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
            }
            i = i2 + 1;
        }
        bIMCancelRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().o(jSONObject));
        if (com.baidu.live.alablmsdk.a.a.isEmpty(arrayList)) {
            if (cVar != null) {
                cVar.e(3, 1000, "list is empty");
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.d(" BLMSignalRoom cancelCall execute");
        com.baidu.live.alablmsdk.a.b.fD(" BLMSignalRoom cancelCall execute");
        this.aBv.cancelCall(this.mContext, bIMCancelRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i3, String str2) {
                com.baidu.live.alablmsdk.a.b.d("cancelCall responseCode " + i3 + " , errorMessage = " + str2);
                com.baidu.live.alablmsdk.a.b.fD("cancelCall responseCode " + i3 + " , errorMessage " + str2);
                if (i3 == 0) {
                    if (cVar != null) {
                        cVar.e(3, 0, "cancel call success");
                    }
                } else if (cVar != null) {
                    int i4 = i3 != 5029 ? -1 : 5029;
                    com.baidu.live.alablmsdk.a.b.d("cancelCall callback errorCode=" + i4);
                    com.baidu.live.alablmsdk.a.b.fD("cancelCall callback errorCode " + i4);
                    cVar.e(3, i4, "cancel call fail. responseCode=" + i3 + " errorMessage=" + str2);
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
            com.baidu.live.alablmsdk.a.b.d("answer fail , roomId im empty");
            com.baidu.live.alablmsdk.a.b.fD("answer fail roomId im empty");
            if (cVar != null) {
                cVar.e(i2, 1000, "roomId im empty");
                return;
            }
            return;
        }
        BIMAnswerRtcInfo bIMAnswerRtcInfo = new BIMAnswerRtcInfo();
        bIMAnswerRtcInfo.setRtcRoomId(str);
        bIMAnswerRtcInfo.setAnswerType(i);
        if (this.aBx == BLMMediaType.BLMMEDIATYPE_AUDIO) {
            bIMAnswerRtcInfo.setAnswerMediaType(1);
        } else {
            bIMAnswerRtcInfo.setAnswerMediaType(2);
        }
        if (jSONObject != null) {
            bIMAnswerRtcInfo.setRtcExt(jSONObject.toString());
        }
        this.aBv.answer(this.mContext, bIMAnswerRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i3, String str2) {
                com.baidu.live.alablmsdk.a.b.d("answer responseCode = " + i3 + " , errorMessage = " + str2);
                com.baidu.live.alablmsdk.a.b.fD("answer responseCode " + i3 + " errorMessage " + str2);
                if (i3 == 0) {
                    if (cVar != null) {
                        cVar.e(i2, 0, "cancel call success");
                    }
                } else if (cVar != null) {
                    cVar.e(i2, -1, "cancel call fail. responseCode = " + i3 + " , errorMessage = " + str2);
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

    public void a(String str, c cVar, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar2) {
        if (cVar == null || TextUtils.isEmpty(cVar.azQ) || TextUtils.isEmpty(cVar.cuid) || cVar.appId == 0 || cVar.azK == 0) {
            if (cVar2 != null) {
                com.baidu.live.alablmsdk.a.b.ag("kick off,user info error", "");
                cVar2.e(9, -1, "kick off,user info error");
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
        this.aBv.kickoff(this.mContext, bIMKickRequestRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (i == 0) {
                    com.baidu.live.alablmsdk.a.b.ag("kick off, success , responseCode=" + i, "");
                } else {
                    com.baidu.live.alablmsdk.a.b.ag("kick off, fail, responseCode=" + i, "");
                }
            }
        });
    }

    public void hangout(String str, IStatusListener iStatusListener) {
        this.aBv.hangout(this.mContext, str, iStatusListener);
    }

    public void a(String str, JSONObject jSONObject, IStatusListener iStatusListener) {
        com.baidu.live.alablmsdk.a.b.d(" signal hangout , roomId=" + str);
        com.baidu.live.alablmsdk.a.b.fD(" signal hangout roomId " + str);
        BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
        bIMRtcInfo.setRtcRoomId(str);
        bIMRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().o(jSONObject));
        this.aBv.hangout(this.mContext, bIMRtcInfo, iStatusListener);
    }

    public void a(String str, IStatusListener iStatusListener) {
        b(str, null, iStatusListener);
    }

    public void b(String str, JSONObject jSONObject, final IStatusListener iStatusListener) {
        com.baidu.live.alablmsdk.a.b.d(" signal closeRoom , roomId=" + str);
        com.baidu.live.alablmsdk.a.b.fD(" signal closeRoom roomId " + str);
        BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo();
        bIMCloseRoomRtcInfo.setRtcRoomId(str);
        bIMCloseRoomRtcInfo.setRoomDuration(0L);
        bIMCloseRoomRtcInfo.setRtcExt(new com.baidu.live.alablmsdk.module.a.a().o(jSONObject));
        this.aBv.closeRoom(this.mContext, bIMCloseRoomRtcInfo, new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.b.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                com.baidu.live.alablmsdk.a.b.d("closeRoom onResult code " + i + ", msg :" + str2);
                com.baidu.live.alablmsdk.a.b.fD("closeRoom onResult code " + i + " msg " + str2);
                if (iStatusListener != null) {
                    iStatusListener.onResult(i, str2);
                }
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.d(" BLMSignalRoom release ");
        com.baidu.live.alablmsdk.a.b.fD(" BLMSignalRoom release ");
        BIMRtcClient.unRegisterRtcListener(this.mContext, this.aBy);
        this.aBy = null;
    }
}
