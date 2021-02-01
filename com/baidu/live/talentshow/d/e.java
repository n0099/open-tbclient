package com.baidu.live.talentshow.d;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static JSONObject a(ab abVar, com.baidu.live.alablmsdk.module.c cVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (abVar != null) {
                if (abVar.aId != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(abVar.aId.userId));
                }
                if (abVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(abVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
                jSONObject.putOpt("user_id", TbadkCoreApplication.getCurrentAccount());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(ab abVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (abVar != null) {
                if (abVar.aId != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(abVar.aId.userId));
                }
                if (abVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(abVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
            }
            jSONObject.putOpt("user_id", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(ab abVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (abVar != null) {
                if (abVar.aId != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(abVar.aId.userId));
                }
                if (abVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(abVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
            }
            jSONObject.putOpt("user_id", str);
            jSONObject.putOpt("line", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(ab abVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            jSONObject.putOpt("user_id", str);
            if (abVar != null) {
                if (abVar.aId != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(abVar.aId.userId));
                }
                if (abVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(abVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject w(ab abVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (abVar != null && abVar.mLiveInfo != null) {
                jSONObject.putOpt("room_id", Long.valueOf(abVar.mLiveInfo.room_id));
                jSONObject.putOpt("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                jSONObject.put("anchor_id", abVar.mLiveInfo.user_id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(ab abVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("line", i);
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (abVar != null && abVar.mLiveInfo != null) {
                jSONObject.put("live_id", abVar.mLiveInfo.live_id);
                jSONObject.put("room_id", abVar.mLiveInfo.room_id);
                jSONObject.put("anchor_id", abVar.mLiveInfo.user_id);
            }
            if (abVar != null && abVar.aIz != null) {
                jSONObject.put("user_id", abVar.aIz.userId);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static JSONObject c(ab abVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("line", i);
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (abVar != null && abVar.mLiveInfo != null) {
                jSONObject.put("live_id", abVar.mLiveInfo.live_id);
                jSONObject.put("room_id", abVar.mLiveInfo.room_id);
                jSONObject.put("anchor_id", abVar.mLiveInfo.user_id);
            }
            if (abVar != null && abVar.aIz != null) {
                jSONObject.put("user_id", abVar.aIz.userId);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
