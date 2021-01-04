package com.baidu.live.videochat.d;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bQD = "sender_room_id";
    public static String bQE = "sender_portrait";
    public static String bQF = "sender_name";
    public static String bQG = "sender_user_id";
    public static String bQH = "sender_live_id";
    public static String bQI = "receiver_portrait";
    public static String bQJ = "receiver_room_id";
    public static String bQK = "receiver_name";
    public static String bQL = "receiver_user_id";
    public static String bQM = "receiver_live_id";
    public static String bQN = "create";
    public static String bQO = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bQP = "accept_time_out";
    public static String bQQ = "reject";

    public static JSONObject a(x xVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (xVar != null) {
                if (xVar.aKu != null) {
                    jSONObject.putOpt(bQF, xVar.aKu.userName);
                    jSONObject.putOpt(bQE, xVar.aKu.portrait);
                    jSONObject.putOpt(bQG, Long.valueOf(xVar.aKu.userId));
                }
                if (xVar.mLiveInfo != null) {
                    jSONObject.putOpt(bQD, Long.valueOf(xVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bQH, Long.valueOf(xVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bQK, aVar.userName);
                jSONObject.putOpt(bQI, aVar.portrait);
                jSONObject.putOpt(bQL, aVar.userId);
                jSONObject.putOpt(bQJ, aVar.roomId);
                jSONObject.putOpt(bQM, aVar.liveId);
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
                eVar.userName = jSONObject.optString(bQF);
                eVar.roomId = jSONObject.optString(bQD);
                eVar.userId = jSONObject.optString(bQG);
                eVar.portrait = jSONObject.optString(bQE);
                eVar.liveId = jSONObject.optString(bQH);
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
                eVar.userName = jSONObject.optString(bQK);
                eVar.roomId = jSONObject.optString(bQJ);
                eVar.userId = jSONObject.optString(bQL);
                eVar.portrait = jSONObject.optString(bQI);
                eVar.liveId = jSONObject.optString(bQM);
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
                jSONObject.putOpt(bQD, eVar.roomId);
                jSONObject.putOpt(bQG, eVar.userId);
                jSONObject.putOpt(bQH, eVar.liveId);
                jSONObject.putOpt(bQF, eVar.userName);
                jSONObject.putOpt(bQE, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (xVar != null) {
            if (xVar.aKu != null) {
                jSONObject.putOpt(bQK, xVar.aKu.userName);
                jSONObject.putOpt(bQI, xVar.aKu.portrait);
                jSONObject.putOpt(bQL, Long.valueOf(xVar.aKu.userId));
            }
            if (xVar.mLiveInfo != null) {
                jSONObject.putOpt(bQJ, Long.valueOf(xVar.mLiveInfo.room_id));
                jSONObject.putOpt(bQM, Long.valueOf(xVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static b an(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bQt = al(jSONObject);
            bVar.bQu = am(jSONObject);
        }
        return bVar;
    }

    public static JSONObject aQ(String str, String str2) {
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
