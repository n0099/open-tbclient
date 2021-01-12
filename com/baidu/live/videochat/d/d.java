package com.baidu.live.videochat.d;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bLR = "sender_room_id";
    public static String bLS = "sender_portrait";
    public static String bLT = "sender_name";
    public static String bLU = "sender_user_id";
    public static String bLV = "sender_live_id";
    public static String bLW = "receiver_portrait";
    public static String bLX = "receiver_room_id";
    public static String bLY = "receiver_name";
    public static String bLZ = "receiver_user_id";
    public static String bMa = "receiver_live_id";
    public static String bMb = "create";
    public static String bMc = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bMd = "accept_time_out";
    public static String bMe = "reject";

    public static JSONObject a(x xVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (xVar != null) {
                if (xVar.aFH != null) {
                    jSONObject.putOpt(bLT, xVar.aFH.userName);
                    jSONObject.putOpt(bLS, xVar.aFH.portrait);
                    jSONObject.putOpt(bLU, Long.valueOf(xVar.aFH.userId));
                }
                if (xVar.mLiveInfo != null) {
                    jSONObject.putOpt(bLR, Long.valueOf(xVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bLV, Long.valueOf(xVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bLY, aVar.userName);
                jSONObject.putOpt(bLW, aVar.portrait);
                jSONObject.putOpt(bLZ, aVar.userId);
                jSONObject.putOpt(bLX, aVar.roomId);
                jSONObject.putOpt(bMa, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static e al(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bLT);
                eVar.roomId = jSONObject.optString(bLR);
                eVar.userId = jSONObject.optString(bLU);
                eVar.portrait = jSONObject.optString(bLS);
                eVar.liveId = jSONObject.optString(bLV);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e am(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bLY);
                eVar.roomId = jSONObject.optString(bLX);
                eVar.userId = jSONObject.optString(bLZ);
                eVar.portrait = jSONObject.optString(bLW);
                eVar.liveId = jSONObject.optString(bMa);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static JSONObject a(e eVar, x xVar, String str) {
        JSONObject jSONObject = new JSONObject();
        if (eVar != null) {
            try {
                jSONObject.putOpt(bLR, eVar.roomId);
                jSONObject.putOpt(bLU, eVar.userId);
                jSONObject.putOpt(bLV, eVar.liveId);
                jSONObject.putOpt(bLT, eVar.userName);
                jSONObject.putOpt(bLS, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (xVar != null) {
            if (xVar.aFH != null) {
                jSONObject.putOpt(bLY, xVar.aFH.userName);
                jSONObject.putOpt(bLW, xVar.aFH.portrait);
                jSONObject.putOpt(bLZ, Long.valueOf(xVar.aFH.userId));
            }
            if (xVar.mLiveInfo != null) {
                jSONObject.putOpt(bLX, Long.valueOf(xVar.mLiveInfo.room_id));
                jSONObject.putOpt(bMa, Long.valueOf(xVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static b an(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bLH = al(jSONObject);
            bVar.bLI = am(jSONObject);
        }
        return bVar;
    }

    public static JSONObject aP(String str, String str2) {
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
