package com.baidu.live.yuyinnoble.c;

import com.baidu.live.data.cv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0242a bUk;
    public b bUl;
    public int bpi;
    public String bpj;
    public int bpm;
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
                this.bUk = new C0242a();
                this.bUk.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user");
            if (optJSONObject3 != null) {
                this.bUl = new b();
                this.bUl.parserJson(optJSONObject3);
            }
            this.bpi = jSONObject.optInt("total_online");
            this.bpj = jSONObject.optString("help_url");
            this.bpm = jSONObject.optInt("poll_time");
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0242a {
        public String bpn;
        public String buy_url;
        public String icon_url;
        public String text;
        public int type_id;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type_id = jSONObject.optInt("type_id");
                this.text = jSONObject.optString("text");
                this.bpn = jSONObject.optString("sub_text");
                this.icon_url = jSONObject.optString("icon_url");
                this.buy_url = jSONObject.optString("buy_url");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public int bpo;
        public String description;
        public String id;
        public String name;

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.description = jSONObject.optString("description");
                this.bpo = jSONObject.optInt("is_noble");
            }
        }
    }
}
