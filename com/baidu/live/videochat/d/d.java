package com.baidu.live.videochat.d;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bLQ = "sender_room_id";
    public static String bLR = "sender_portrait";
    public static String bLS = "sender_name";
    public static String bLT = "sender_user_id";
    public static String bLU = "sender_live_id";
    public static String bLV = "receiver_portrait";
    public static String bLW = "receiver_room_id";
    public static String bLX = "receiver_name";
    public static String bLY = "receiver_user_id";
    public static String bLZ = "receiver_live_id";
    public static String bMa = "create";
    public static String bMb = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bMc = "accept_time_out";
    public static String bMd = "reject";

    public static JSONObject a(w wVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (wVar != null) {
                if (wVar.aJV != null) {
                    jSONObject.putOpt(bLS, wVar.aJV.userName);
                    jSONObject.putOpt(bLR, wVar.aJV.portrait);
                    jSONObject.putOpt(bLT, Long.valueOf(wVar.aJV.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt(bLQ, Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bLU, Long.valueOf(wVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bLX, aVar.userName);
                jSONObject.putOpt(bLV, aVar.portrait);
                jSONObject.putOpt(bLY, aVar.userId);
                jSONObject.putOpt(bLW, aVar.roomId);
                jSONObject.putOpt(bLZ, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static e ad(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bLS);
                eVar.roomId = jSONObject.optString(bLQ);
                eVar.userId = jSONObject.optString(bLT);
                eVar.portrait = jSONObject.optString(bLR);
                eVar.liveId = jSONObject.optString(bLU);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e ae(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bLX);
                eVar.roomId = jSONObject.optString(bLW);
                eVar.userId = jSONObject.optString(bLY);
                eVar.portrait = jSONObject.optString(bLV);
                eVar.liveId = jSONObject.optString(bLZ);
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
                jSONObject.putOpt(bLQ, eVar.roomId);
                jSONObject.putOpt(bLT, eVar.userId);
                jSONObject.putOpt(bLU, eVar.liveId);
                jSONObject.putOpt(bLS, eVar.userName);
                jSONObject.putOpt(bLR, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (wVar != null) {
            if (wVar.aJV != null) {
                jSONObject.putOpt(bLX, wVar.aJV.userName);
                jSONObject.putOpt(bLV, wVar.aJV.portrait);
                jSONObject.putOpt(bLY, Long.valueOf(wVar.aJV.userId));
            }
            if (wVar.mLiveInfo != null) {
                jSONObject.putOpt(bLW, Long.valueOf(wVar.mLiveInfo.room_id));
                jSONObject.putOpt(bLZ, Long.valueOf(wVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static b af(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bLG = ad(jSONObject);
            bVar.bLH = ae(jSONObject);
        }
        return bVar;
    }

    public static JSONObject aV(String str, String str2) {
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
