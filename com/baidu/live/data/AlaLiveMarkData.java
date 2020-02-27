package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveMarkData implements Serializable {
    public static final String DEFAULT_ANCHOR_USER_ID = "0";
    public static final int TYPE_FAN = 6;
    public static final int TYPE_USER_ACHIEVE = 103;
    public static final int TYPE_USER_ADMIN = 2;
    public static final int TYPE_USER_GUARD_CLUB = 102;
    public static final int TYPE_USER_HORNOR = 104;
    public static final int TYPE_USER_LABEL = 3;
    public static final int TYPE_USER_LEVEL = 1;
    public static final int TYPE_USER_TB_ACTIVITY = 4;
    public String anchor_user_id;
    public int height;
    public long mark_id;
    public String mark_name;
    public String mark_pic;
    public int type;
    public int width;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.anchor_user_id = jSONObject.optString("anchor_user_id");
            this.mark_id = jSONObject.optLong("mark_id");
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("anchor_user_id", this.anchor_user_id);
            jSONObject.put("mark_id", this.mark_id);
            jSONObject.put("mark_name", this.mark_name);
            jSONObject.put("mark_pic", this.mark_pic);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
