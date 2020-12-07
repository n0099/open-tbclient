package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    public String nicName;
    public long userId;
    public int volumeLevel;

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.userId);
            jSONObject.put("displayName", this.nicName);
            jSONObject.put("volumeLevel", this.volumeLevel);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
