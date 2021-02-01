package com.baidu.live.videochat.d;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bPC = "sender_room_id";
    public static String bPD = "sender_portrait";
    public static String bPE = "sender_name";
    public static String bPF = "sender_user_id";
    public static String bPG = "sender_live_id";
    public static String bPH = "receiver_portrait";
    public static String bPI = "receiver_room_id";
    public static String bPJ = "receiver_name";
    public static String bPK = "receiver_user_id";
    public static String bPL = "receiver_live_id";
    public static String bPM = "create";
    public static String bPN = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bPO = "accept_time_out";
    public static String bPP = "reject";

    public static JSONObject a(ab abVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (abVar != null) {
                if (abVar.aId != null) {
                    jSONObject.putOpt(bPE, abVar.aId.userName);
                    jSONObject.putOpt(bPD, abVar.aId.portrait);
                    jSONObject.putOpt(bPF, Long.valueOf(abVar.aId.userId));
                }
                if (abVar.mLiveInfo != null) {
                    jSONObject.putOpt(bPC, Long.valueOf(abVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bPG, Long.valueOf(abVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bPJ, aVar.userName);
                jSONObject.putOpt(bPH, aVar.portrait);
                jSONObject.putOpt(bPK, aVar.userId);
                jSONObject.putOpt(bPI, aVar.roomId);
                jSONObject.putOpt(bPL, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static e an(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bPE);
                eVar.roomId = jSONObject.optString(bPC);
                eVar.userId = jSONObject.optString(bPF);
                eVar.portrait = jSONObject.optString(bPD);
                eVar.liveId = jSONObject.optString(bPG);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e ao(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bPJ);
                eVar.roomId = jSONObject.optString(bPI);
                eVar.userId = jSONObject.optString(bPK);
                eVar.portrait = jSONObject.optString(bPH);
                eVar.liveId = jSONObject.optString(bPL);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static JSONObject a(e eVar, ab abVar, String str) {
        JSONObject jSONObject = new JSONObject();
        if (eVar != null) {
            try {
                jSONObject.putOpt(bPC, eVar.roomId);
                jSONObject.putOpt(bPF, eVar.userId);
                jSONObject.putOpt(bPG, eVar.liveId);
                jSONObject.putOpt(bPE, eVar.userName);
                jSONObject.putOpt(bPD, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (abVar != null) {
            if (abVar.aId != null) {
                jSONObject.putOpt(bPJ, abVar.aId.userName);
                jSONObject.putOpt(bPH, abVar.aId.portrait);
                jSONObject.putOpt(bPK, Long.valueOf(abVar.aId.userId));
            }
            if (abVar.mLiveInfo != null) {
                jSONObject.putOpt(bPI, Long.valueOf(abVar.mLiveInfo.room_id));
                jSONObject.putOpt(bPL, Long.valueOf(abVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static b ap(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bPr = an(jSONObject);
            bVar.bPs = ao(jSONObject);
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
