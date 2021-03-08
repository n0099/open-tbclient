package com.baidu.live.videochat.d;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static String KEY_TYPE = "type";
    public static String bRc = "sender_room_id";
    public static String bRd = "sender_portrait";
    public static String bRe = "sender_name";
    public static String bRf = "sender_user_id";
    public static String bRg = "sender_live_id";
    public static String bRh = "receiver_portrait";
    public static String bRi = "receiver_room_id";
    public static String bRj = "receiver_name";
    public static String bRk = "receiver_user_id";
    public static String bRl = "receiver_live_id";
    public static String bRm = "create";
    public static String bRn = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET;
    public static String bRo = "accept_time_out";
    public static String bRp = "reject";

    public static JSONObject a(ab abVar, com.baidu.live.videochat.panel.a.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KEY_TYPE, str);
            if (abVar != null) {
                if (abVar.aJD != null) {
                    jSONObject.putOpt(bRe, abVar.aJD.userName);
                    jSONObject.putOpt(bRd, abVar.aJD.portrait);
                    jSONObject.putOpt(bRf, Long.valueOf(abVar.aJD.userId));
                }
                if (abVar.mLiveInfo != null) {
                    jSONObject.putOpt(bRc, Long.valueOf(abVar.mLiveInfo.room_id));
                    jSONObject.putOpt(bRg, Long.valueOf(abVar.mLiveInfo.live_id));
                }
            }
            if (aVar != null) {
                jSONObject.putOpt(bRj, aVar.userName);
                jSONObject.putOpt(bRh, aVar.portrait);
                jSONObject.putOpt(bRk, aVar.userId);
                jSONObject.putOpt(bRi, aVar.roomId);
                jSONObject.putOpt(bRl, aVar.liveId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static e ap(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bRe);
                eVar.roomId = jSONObject.optString(bRc);
                eVar.userId = jSONObject.optString(bRf);
                eVar.portrait = jSONObject.optString(bRd);
                eVar.liveId = jSONObject.optString(bRg);
                eVar.type = jSONObject.optString(KEY_TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e aq(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                eVar.userName = jSONObject.optString(bRj);
                eVar.roomId = jSONObject.optString(bRi);
                eVar.userId = jSONObject.optString(bRk);
                eVar.portrait = jSONObject.optString(bRh);
                eVar.liveId = jSONObject.optString(bRl);
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
                jSONObject.putOpt(bRc, eVar.roomId);
                jSONObject.putOpt(bRf, eVar.userId);
                jSONObject.putOpt(bRg, eVar.liveId);
                jSONObject.putOpt(bRe, eVar.userName);
                jSONObject.putOpt(bRd, eVar.portrait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.putOpt(KEY_TYPE, str);
        if (abVar != null) {
            if (abVar.aJD != null) {
                jSONObject.putOpt(bRj, abVar.aJD.userName);
                jSONObject.putOpt(bRh, abVar.aJD.portrait);
                jSONObject.putOpt(bRk, Long.valueOf(abVar.aJD.userId));
            }
            if (abVar.mLiveInfo != null) {
                jSONObject.putOpt(bRi, Long.valueOf(abVar.mLiveInfo.room_id));
                jSONObject.putOpt(bRl, Long.valueOf(abVar.mLiveInfo.live_id));
            }
        }
        return jSONObject;
    }

    public static b ar(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.type = jSONObject.optString(KEY_TYPE);
            bVar.bQR = ap(jSONObject);
            bVar.bQS = aq(jSONObject);
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
