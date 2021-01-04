package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bv {
    public int has_more;
    public List<bh> user_list;

    public void parserJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        parserJson(jSONObject);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.user_list = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bh bhVar = new bh();
                        bhVar.parserJson(optJSONObject);
                        this.user_list.add(bhVar);
                    }
                }
            }
            this.has_more = jSONObject.optInt("has_more");
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (this.user_list != null && !this.user_list.isEmpty()) {
            for (bh bhVar : this.user_list) {
                jSONArray.put(bhVar.toString());
            }
        }
        try {
            jSONObject.put("user_list", jSONArray.toString());
            jSONObject.put("has_more", this.has_more);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
