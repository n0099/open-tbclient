package com.baidu.live.videochat.d;

import com.baidu.live.data.u;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bzF = "sender_room_id";
    public static String bzG = "sender_portrait";
    public static String bzH = "sender_name";
    public static String bzI = "sender_user_id";
    public static String bzJ = "sender_live_id";
    public static String bzK = "receiver_portrait";
    public static String bzL = "receiver_room_id";
    public static String bzM = "receiver_name";
    public static String bzN = "receiver_user_id";
    public static String bzO = "receiver_live_id";
    public static String bzP = "create";
    public static String bzQ = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bzR = "accept_time_out";
    public static String bzS = "reject";

    public static String a(u uVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (uVar != null) {
                if (uVar.aHD != null) {
                    jSONObject.putOpt(bzH, uVar.aHD.userName);
                    jSONObject.putOpt(bzG, uVar.aHD.portrait);
                    jSONObject.putOpt(bzI, Long.valueOf(uVar.aHD.userId));
                }
                if (uVar.mLiveInfo != null) {
                    jSONObject.putOpt(bzF, Long.valueOf(uVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bzJ, Long.valueOf(uVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bzM, aVar.userName);
                jSONObject.putOpt(bzK, aVar.portrait);
                jSONObject.putOpt(bzN, aVar.userId);
                jSONObject.putOpt(bzL, aVar.roomId);
                jSONObject.putOpt(bzO, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static e ik(String str) {
        e eVar = new e();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar.userName = jSONObject.optString(bzH);
                eVar.roomId = jSONObject.optString(bzF);
                eVar.userId = jSONObject.optString(bzI);
                eVar.portrait = jSONObject.optString(bzG);
                eVar.liveId = jSONObject.optString(bzJ);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e aa(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bzM);
                eVar.roomId = jSONObject.optString(bzL);
                eVar.userId = jSONObject.optString(bzN);
                eVar.portrait = jSONObject.optString(bzK);
                eVar.liveId = jSONObject.optString(bzO);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static JSONObject a(e eVar, u uVar, String str) {
        JSONObject jSONObject = new JSONObject();
        if (eVar != null) {
            try {
                jSONObject.putOpt(bzF, eVar.roomId);
                jSONObject.putOpt(bzI, eVar.userId);
                jSONObject.putOpt(bzJ, eVar.liveId);
                jSONObject.putOpt(bzH, eVar.userName);
                jSONObject.putOpt(bzG, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (uVar != null) {
            if (uVar.aHD != null) {
                jSONObject.putOpt(bzM, uVar.aHD.userName);
                jSONObject.putOpt(bzK, uVar.aHD.portrait);
                jSONObject.putOpt(bzN, Long.valueOf(uVar.aHD.userId));
            }
            if (uVar.mLiveInfo != null) {
                jSONObject.putOpt(bzL, Long.valueOf(uVar.mLiveInfo.room_id));
                jSONObject.putOpt(bzO, Long.valueOf(uVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static JSONObject il(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static b ab(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bzl = ik(jSONObject.toString());
            bVar.bzm = aa(jSONObject);
        }
        return bVar;
    }

    public static String aL(String str, String str2) {
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
