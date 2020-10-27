package com.baidu.live.videochat.d;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bCB = "sender_room_id";
    public static String bCC = "sender_portrait";
    public static String bCD = "sender_name";
    public static String bCE = "sender_user_id";
    public static String bCF = "sender_live_id";
    public static String bCG = "receiver_portrait";
    public static String bCH = "receiver_room_id";
    public static String bCI = "receiver_name";
    public static String bCJ = "receiver_user_id";
    public static String bCK = "receiver_live_id";
    public static String bCL = "create";
    public static String bCM = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bCN = "accept_time_out";
    public static String bCO = "reject";

    public static String a(w wVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (wVar != null) {
                if (wVar.aIe != null) {
                    jSONObject.putOpt(bCD, wVar.aIe.userName);
                    jSONObject.putOpt(bCC, wVar.aIe.portrait);
                    jSONObject.putOpt(bCE, Long.valueOf(wVar.aIe.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt(bCB, Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bCF, Long.valueOf(wVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bCI, aVar.userName);
                jSONObject.putOpt(bCG, aVar.portrait);
                jSONObject.putOpt(bCJ, aVar.userId);
                jSONObject.putOpt(bCH, aVar.roomId);
                jSONObject.putOpt(bCK, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static e iv(String str) {
        e eVar = new e();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar.userName = jSONObject.optString(bCD);
                eVar.roomId = jSONObject.optString(bCB);
                eVar.userId = jSONObject.optString(bCE);
                eVar.portrait = jSONObject.optString(bCC);
                eVar.liveId = jSONObject.optString(bCF);
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
                eVar.userName = jSONObject.optString(bCI);
                eVar.roomId = jSONObject.optString(bCH);
                eVar.userId = jSONObject.optString(bCJ);
                eVar.portrait = jSONObject.optString(bCG);
                eVar.liveId = jSONObject.optString(bCK);
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
                jSONObject.putOpt(bCB, eVar.roomId);
                jSONObject.putOpt(bCE, eVar.userId);
                jSONObject.putOpt(bCF, eVar.liveId);
                jSONObject.putOpt(bCD, eVar.userName);
                jSONObject.putOpt(bCC, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (wVar != null) {
            if (wVar.aIe != null) {
                jSONObject.putOpt(bCI, wVar.aIe.userName);
                jSONObject.putOpt(bCG, wVar.aIe.portrait);
                jSONObject.putOpt(bCJ, Long.valueOf(wVar.aIe.userId));
            }
            if (wVar.mLiveInfo != null) {
                jSONObject.putOpt(bCH, Long.valueOf(wVar.mLiveInfo.room_id));
                jSONObject.putOpt(bCK, Long.valueOf(wVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static JSONObject iw(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static b ad(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bCh = iv(jSONObject.toString());
            bVar.bCi = ac(jSONObject);
        }
        return bVar;
    }

    public static String aR(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(TiebaInitialize.LogFields.REASON, str);
            jSONObject.putOpt("room_id", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
