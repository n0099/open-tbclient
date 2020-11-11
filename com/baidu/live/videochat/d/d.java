package com.baidu.live.videochat.d;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bIt = "sender_room_id";
    public static String bIu = "sender_portrait";
    public static String bIv = "sender_name";
    public static String bIw = "sender_user_id";
    public static String bIx = "sender_live_id";
    public static String bIy = "receiver_portrait";
    public static String bIz = "receiver_room_id";
    public static String bIA = "receiver_name";
    public static String bIB = "receiver_user_id";
    public static String bIC = "receiver_live_id";
    public static String bID = "create";
    public static String bIE = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bIF = "accept_time_out";
    public static String bIG = "reject";

    public static JSONObject a(w wVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (wVar != null) {
                if (wVar.aIV != null) {
                    jSONObject.putOpt(bIv, wVar.aIV.userName);
                    jSONObject.putOpt(bIu, wVar.aIV.portrait);
                    jSONObject.putOpt(bIw, Long.valueOf(wVar.aIV.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt(bIt, Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bIx, Long.valueOf(wVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bIA, aVar.userName);
                jSONObject.putOpt(bIy, aVar.portrait);
                jSONObject.putOpt(bIB, aVar.userId);
                jSONObject.putOpt(bIz, aVar.roomId);
                jSONObject.putOpt(bIC, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static e ah(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bIv);
                eVar.roomId = jSONObject.optString(bIt);
                eVar.userId = jSONObject.optString(bIw);
                eVar.portrait = jSONObject.optString(bIu);
                eVar.liveId = jSONObject.optString(bIx);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e ai(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bIA);
                eVar.roomId = jSONObject.optString(bIz);
                eVar.userId = jSONObject.optString(bIB);
                eVar.portrait = jSONObject.optString(bIy);
                eVar.liveId = jSONObject.optString(bIC);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static JSONObject a(e eVar, w wVar, String str) {
        JSONObject jSONObject = new JSONObject();
        if (eVar != null) {
            try {
                jSONObject.putOpt(bIt, eVar.roomId);
                jSONObject.putOpt(bIw, eVar.userId);
                jSONObject.putOpt(bIx, eVar.liveId);
                jSONObject.putOpt(bIv, eVar.userName);
                jSONObject.putOpt(bIu, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (wVar != null) {
            if (wVar.aIV != null) {
                jSONObject.putOpt(bIA, wVar.aIV.userName);
                jSONObject.putOpt(bIy, wVar.aIV.portrait);
                jSONObject.putOpt(bIB, Long.valueOf(wVar.aIV.userId));
            }
            if (wVar.mLiveInfo != null) {
                jSONObject.putOpt(bIz, Long.valueOf(wVar.mLiveInfo.room_id));
                jSONObject.putOpt(bIC, Long.valueOf(wVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static b aj(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bIj = ah(jSONObject);
            bVar.bIk = ai(jSONObject);
        }
        return bVar;
    }

    public static JSONObject aS(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(TiebaInitialize.LogFields.REASON, str);
            jSONObject.putOpt("room_id", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
