package com.baidu.live.talentshow.d;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static JSONObject a(w wVar, com.baidu.live.alablmsdk.module.c cVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (wVar != null) {
                if (wVar.aJV != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(wVar.aJV.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                jSONObject.putOpt("user_id", TbadkCoreApplication.getCurrentAccount());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(w wVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (wVar != null) {
                if (wVar.aJV != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(wVar.aJV.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
            }
            jSONObject.putOpt("user_id", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(w wVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (wVar != null) {
                if (wVar.aJV != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(wVar.aJV.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
            }
            jSONObject.putOpt("user_id", str);
            jSONObject.putOpt("line", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(w wVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("line", Integer.valueOf(i));
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            jSONObject.putOpt("user_id", str);
            if (wVar != null) {
                if (wVar.aJV != null) {
                    jSONObject.putOpt("anchor_id", Long.valueOf(wVar.aJV.userId));
                }
                if (wVar.mLiveInfo != null) {
                    jSONObject.putOpt("room_id", Long.valueOf(wVar.mLiveInfo.room_id));
                    jSONObject.putOpt("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject v(w wVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (wVar != null && wVar.mLiveInfo != null) {
                jSONObject.putOpt("room_id", Long.valueOf(wVar.mLiveInfo.room_id));
                jSONObject.putOpt("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                jSONObject.put("anchor_id", wVar.mLiveInfo.user_id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(w wVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("line", i);
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (wVar != null && wVar.mLiveInfo != null) {
                jSONObject.put("live_id", wVar.mLiveInfo.live_id);
                jSONObject.put("room_id", wVar.mLiveInfo.room_id);
                jSONObject.put("anchor_id", wVar.mLiveInfo.user_id);
            }
            if (wVar != null && wVar.aKr != null) {
                jSONObject.put("user_id", wVar.aKr.userId);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static JSONObject c(w wVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("line", i);
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, "show_pub_v2");
            if (wVar != null && wVar.mLiveInfo != null) {
                jSONObject.put("live_id", wVar.mLiveInfo.live_id);
                jSONObject.put("room_id", wVar.mLiveInfo.room_id);
                jSONObject.put("anchor_id", wVar.mLiveInfo.user_id);
            }
            if (wVar != null && wVar.aKr != null) {
                jSONObject.put("user_id", wVar.aKr.userId);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
