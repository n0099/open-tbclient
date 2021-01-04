package com.baidu.live.noble.data;

import com.baidu.live.data.cz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public a bxA;
    public b bxB;
    public int bxq;
    public String bxr;
    public int bxu;
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
                this.bxA = new a();
                this.bxA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bxB = new b();
                this.bxB.parserJson(optJSONObject3);
            }
            this.bxq = jSONObject.optInt("total_online");
            this.bxr = jSONObject.optString("help_url");
            this.bxu = jSONObject.optInt("poll_time");
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public String buy_url;
        public String bxv;
        public String icon_url;
        public String text;
        public int type_id;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type_id = jSONObject.optInt("type_id");
                this.text = jSONObject.optString("text");
                this.bxv = jSONObject.optString("sub_text");
                this.icon_url = jSONObject.optString("icon_url");
                this.buy_url = jSONObject.optString("buy_url");
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int bxw;
        public String description;
        public String id;
        public String name;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.description = jSONObject.optString("description");
                this.bxw = jSONObject.optInt("is_noble");
            }
        }
    }
}
