package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public String attribute;
    public int role;
    public long userId;
    public String userName;

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.userId);
            jSONObject.put("displayName", this.userName);
            jSONObject.put(Config.EVENT_ATTR, this.attribute);
            jSONObject.put("role", this.role);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
