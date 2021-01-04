package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TagSelect implements Jsonable, Serializable {
    public String id = "";
    public String name = "";
    public String type = "";
    public String postId = "";

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("type", this.type);
            jSONObject.put("post_id", this.postId);
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
            this.id = jSONObject.optString("id");
            this.name = jSONObject.optString("name");
            this.type = jSONObject.optString("type");
            this.postId = jSONObject.optString("post_id");
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
