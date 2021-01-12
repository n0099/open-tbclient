package com.baidu.live.noble.data;

import com.baidu.live.data.cz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public int bsC;
    public String bsD;
    public int bsG;
    public a bsM;
    public b bsN;
    public List<cz> list;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        cz czVar = new cz();
                        czVar.parserJson(optJSONObject);
                        this.list.add(czVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("text");
            if (optJSONObject2 != null) {
                this.bsM = new a();
                this.bsM.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bsN = new b();
                this.bsN.parserJson(optJSONObject3);
            }
            this.bsC = jSONObject.optInt("total_online");
            this.bsD = jSONObject.optString("help_url");
            this.bsG = jSONObject.optInt("poll_time");
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public String bsH;
        public String buy_url;
        public String icon_url;
        public String text;
        public int type_id;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type_id = jSONObject.optInt("type_id");
                this.text = jSONObject.optString("text");
                this.bsH = jSONObject.optString("sub_text");
                this.icon_url = jSONObject.optString("icon_url");
                this.buy_url = jSONObject.optString("buy_url");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public int bsI;
        public String description;
        public String id;
        public String name;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.description = jSONObject.optString("description");
                this.bsI = jSONObject.optInt("is_noble");
            }
        }
    }
}
