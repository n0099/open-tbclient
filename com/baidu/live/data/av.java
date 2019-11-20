package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class av {
    public int Vb;
    public int Vc;
    public String new_props_id;
    public int props_id;
    public String wars_item;
    public String wars_name;

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("props_id", this.props_id);
            jSONObject.put("money", this.Vb);
            jSONObject.put("props_mon", this.Vc);
            jSONObject.put("wars_name", this.wars_name);
            jSONObject.put("wars_item", this.wars_item);
            jSONObject.put("new_props_id", this.new_props_id);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
