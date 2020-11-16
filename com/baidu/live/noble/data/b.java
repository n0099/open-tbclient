package com.baidu.live.noble.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public C0192b bnA;
    public int bnB;
    public int bnx;
    public String bny;
    public a bnz;
    public List<com.baidu.live.noble.data.a> list;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        com.baidu.live.noble.data.a aVar = new com.baidu.live.noble.data.a();
                        aVar.parserJson(optJSONObject);
                        this.list.add(aVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("text");
            if (optJSONObject2 != null) {
                this.bnz = new a();
                this.bnz.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bnA = new C0192b();
                this.bnA.parserJson(optJSONObject3);
            }
            this.bnx = jSONObject.optInt("total_online");
            this.bny = jSONObject.optString("help_url");
            this.bnB = jSONObject.optInt("poll_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public String bnC;
        public String buy_url;
        public String icon_url;
        public String text;
        public int type_id;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type_id = jSONObject.optInt("type_id");
                this.text = jSONObject.optString("text");
                this.bnC = jSONObject.optString("sub_text");
                this.icon_url = jSONObject.optString("icon_url");
                this.buy_url = jSONObject.optString("buy_url");
            }
        }
    }

    /* renamed from: com.baidu.live.noble.data.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0192b {
        public int bnD;
        public String description;
        public String id;
        public String name;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.description = jSONObject.optString("description");
                this.bnD = jSONObject.optInt("is_noble");
            }
        }
    }
}
