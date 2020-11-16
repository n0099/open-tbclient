package com.baidu.live.yuyinnoble.c;

import com.baidu.live.data.cv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0240a bSA;
    public b bSB;
    public int bnB;
    public int bnx;
    public String bny;
    public List<cv> list;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        cv cvVar = new cv();
                        cvVar.parserJson(optJSONObject);
                        this.list.add(cvVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("text");
            if (optJSONObject2 != null) {
                this.bSA = new C0240a();
                this.bSA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bSB = new b();
                this.bSB.parserJson(optJSONObject3);
            }
            this.bnx = jSONObject.optInt("total_online");
            this.bny = jSONObject.optString("help_url");
            this.bnB = jSONObject.optInt("poll_time");
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0240a {
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

    /* loaded from: classes4.dex */
    public static class b {
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
