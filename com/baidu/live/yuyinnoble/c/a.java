package com.baidu.live.yuyinnoble.c;

import com.baidu.live.data.cr;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0230a bOA;
    public b bOB;
    public int bnP;
    public String bnQ;
    public int bnT;
    public List<cr> list;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        cr crVar = new cr();
                        crVar.parserJson(optJSONObject);
                        this.list.add(crVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("text");
            if (optJSONObject2 != null) {
                this.bOA = new C0230a();
                this.bOA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bOB = new b();
                this.bOB.parserJson(optJSONObject3);
            }
            this.bnP = jSONObject.optInt("total_online");
            this.bnQ = jSONObject.optString("help_url");
            this.bnT = jSONObject.optInt("poll_time");
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0230a {
        public String bnU;
        public String buy_url;
        public String icon_url;
        public String text;
        public int type_id;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type_id = jSONObject.optInt("type_id");
                this.text = jSONObject.optString("text");
                this.bnU = jSONObject.optString("sub_text");
                this.icon_url = jSONObject.optString("icon_url");
                this.buy_url = jSONObject.optString("buy_url");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public int bnV;
        public String description;
        public String id;
        public String name;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.description = jSONObject.optString("description");
                this.bnV = jSONObject.optInt("is_noble");
            }
        }
    }
}
