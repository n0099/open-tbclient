package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TopicSelect implements Jsonable, Serializable {
    public static final int TYPE_HIDDEN = -1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SOLID = 1;
    public boolean selected = false;
    public int type = 0;
    public String name = "";
    public String id = "";

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("tid", this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("selected", this.selected);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.type = jSONObject.optInt("type");
            this.id = jSONObject.optString("tid");
            this.name = jSONObject.optString("name");
            this.selected = jSONObject.optBoolean("selected");
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
