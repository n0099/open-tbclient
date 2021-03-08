package com.baidu.live.noble.data;

import com.baidu.live.data.df;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public int bxG;
    public String bxH;
    public int bxK;
    public a bxQ;
    public b bxR;
    public List<df> list;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        df dfVar = new df();
                        dfVar.parserJson(optJSONObject);
                        this.list.add(dfVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("text");
            if (optJSONObject2 != null) {
                this.bxQ = new a();
                this.bxQ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bxR = new b();
                this.bxR.parserJson(optJSONObject3);
            }
            this.bxG = jSONObject.optInt("total_online");
            this.bxH = jSONObject.optString("help_url");
            this.bxK = jSONObject.optInt("poll_time");
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public String buy_url;
        public String bxL;
        public String icon_url;
        public String text;
        public int type_id;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type_id = jSONObject.optInt("type_id");
                this.text = jSONObject.optString("text");
                this.bxL = jSONObject.optString("sub_text");
                this.icon_url = jSONObject.optString("icon_url");
                this.buy_url = jSONObject.optString("buy_url");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public int bxM;
        public String description;
        public String id;
        public String name;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.description = jSONObject.optString("description");
                this.bxM = jSONObject.optInt("is_noble");
            }
        }
    }
}
