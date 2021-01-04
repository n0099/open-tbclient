package com.baidu.live.talentshow.d;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static JSONObject a(x xVar, com.baidu.live.alablmsdk.module.c cVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (xVar != null) {
                if (xVar.aKu != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(xVar.aKu.userId));
                }
                if (xVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(xVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
                jSONObject.putOpt("user_id", TbadkCoreApplication.getCurrentAccount());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(x xVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (xVar != null) {
                if (xVar.aKu != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(xVar.aKu.userId));
                }
                if (xVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(xVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
            }
            jSONObject.putOpt("user_id", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(x xVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (xVar != null) {
                if (xVar.aKu != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(xVar.aKu.userId));
                }
                if (xVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(xVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
            }
            jSONObject.putOpt("user_id", str);
            jSONObject.putOpt("line", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(x xVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            jSONObject.putOpt("user_id", str);
            if (xVar != null) {
                if (xVar.aKu != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(xVar.aKu.userId));
                }
                if (xVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(xVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject w(x xVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (xVar != null && xVar.mLiveInfo != null) {
                jSONObject.putOpt("room_id", Long.valueOf(xVar.mLiveInfo.room_id));
                jSONObject.putOpt("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                jSONObject.put("anchor_id", xVar.mLiveInfo.user_id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(x xVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("line", i);
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (xVar != null && xVar.mLiveInfo != null) {
                jSONObject.put("live_id", xVar.mLiveInfo.live_id);
                jSONObject.put("room_id", xVar.mLiveInfo.room_id);
                jSONObject.put("anchor_id", xVar.mLiveInfo.user_id);
            }
            if (xVar != null && xVar.aKQ != null) {
                jSONObject.put("user_id", xVar.aKQ.userId);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static JSONObject c(x xVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("line", i);
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (xVar != null && xVar.mLiveInfo != null) {
                jSONObject.put("live_id", xVar.mLiveInfo.live_id);
                jSONObject.put("room_id", xVar.mLiveInfo.room_id);
                jSONObject.put("anchor_id", xVar.mLiveInfo.user_id);
            }
            if (xVar != null && xVar.aKQ != null) {
                jSONObject.put("user_id", xVar.aKQ.userId);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
