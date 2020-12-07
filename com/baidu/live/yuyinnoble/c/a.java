package com.baidu.live.yuyinnoble.c;

import com.baidu.live.data.cx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0249a bXQ;
    public b bXR;
    public int bsF;
    public String bsG;
    public int bsJ;
    public List<cx> list;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        cx cxVar = new cx();
                        cxVar.parserJson(optJSONObject);
                        this.list.add(cxVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("text");
            if (optJSONObject2 != null) {
                this.bXQ = new C0249a();
                this.bXQ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bXR = new b();
                this.bXR.parserJson(optJSONObject3);
            }
            this.bsF = jSONObject.optInt("total_online");
            this.bsG = jSONObject.optString("help_url");
            this.bsJ = jSONObject.optInt("poll_time");
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0249a {
        public String bsK;
        public String buy_url;
        public String icon_url;
        public String text;
        public int type_id;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type_id = jSONObject.optInt("type_id");
                this.text = jSONObject.optString("text");
                this.bsK = jSONObject.optString("sub_text");
                this.icon_url = jSONObject.optString("icon_url");
                this.buy_url = jSONObject.optString("buy_url");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public int bsL;
        public String description;
        public String id;
        public String name;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.description = jSONObject.optString("description");
                this.bsL = jSONObject.optInt("is_noble");
            }
        }
    }
}
