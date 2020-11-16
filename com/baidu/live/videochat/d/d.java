package com.baidu.live.videochat.d;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bGI = "sender_room_id";
    public static String bGJ = "sender_portrait";
    public static String bGK = "sender_name";
    public static String bGL = "sender_user_id";
    public static String bGM = "sender_live_id";
    public static String bGN = "receiver_portrait";
    public static String bGO = "receiver_room_id";
    public static String bGP = "receiver_name";
    public static String bGQ = "receiver_user_id";
    public static String bGR = "receiver_live_id";
    public static String bGS = "create";
    public static String bGT = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bGU = "accept_time_out";
    public static String bGV = "reject";

    public static JSONObject a(w wVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (wVar != null) {
                if (wVar.aHk != null) {
                    jSONObject.putOpt(bGK, wVar.aHk.userName);
                    jSONObject.putOpt(bGJ, wVar.aHk.portrait);
                    jSONObject.putOpt(bGL, Long.valueOf(wVar.aHk.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt(bGI, Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bGM, Long.valueOf(wVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bGP, aVar.userName);
                jSONObject.putOpt(bGN, aVar.portrait);
                jSONObject.putOpt(bGQ, aVar.userId);
                jSONObject.putOpt(bGO, aVar.roomId);
                jSONObject.putOpt(bGR, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static e ab(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bGK);
                eVar.roomId = jSONObject.optString(bGI);
                eVar.userId = jSONObject.optString(bGL);
                eVar.portrait = jSONObject.optString(bGJ);
                eVar.liveId = jSONObject.optString(bGM);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e ac(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bGP);
                eVar.roomId = jSONObject.optString(bGO);
                eVar.userId = jSONObject.optString(bGQ);
                eVar.portrait = jSONObject.optString(bGN);
                eVar.liveId = jSONObject.optString(bGR);
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
                jSONObject.putOpt(bGI, eVar.roomId);
                jSONObject.putOpt(bGL, eVar.userId);
                jSONObject.putOpt(bGM, eVar.liveId);
                jSONObject.putOpt(bGK, eVar.userName);
                jSONObject.putOpt(bGJ, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (wVar != null) {
            if (wVar.aHk != null) {
                jSONObject.putOpt(bGP, wVar.aHk.userName);
                jSONObject.putOpt(bGN, wVar.aHk.portrait);
                jSONObject.putOpt(bGQ, Long.valueOf(wVar.aHk.userId));
            }
            if (wVar.mLiveInfo != null) {
                jSONObject.putOpt(bGO, Long.valueOf(wVar.mLiveInfo.room_id));
                jSONObject.putOpt(bGR, Long.valueOf(wVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static b ad(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bGy = ab(jSONObject);
            bVar.bGz = ac(jSONObject);
        }
        return bVar;
    }

    public static JSONObject aR(String str, String str2) {
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
