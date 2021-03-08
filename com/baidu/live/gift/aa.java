package com.baidu.live.gift;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aa extends g {
    public List<a> aZB;

    public boolean Fn() {
        return "30".equals(Ec());
    }

    @Override // com.baidu.live.gift.g
    public boolean Ed() {
        return super.Ed() && !Fn();
    }

    /* loaded from: classes10.dex */
    public static class a {
        public boolean aZC;
        public String aZD;
        public String name;
        public int num;
        public String pic;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.name = jSONObject.optString("fragment_name");
                this.pic = jSONObject.optString("pic");
                this.num = jSONObject.optInt("num");
                this.aZC = jSONObject.optInt("is_rare") == 1;
                this.aZD = jSONObject.optString("get_method");
            }
        }
    }
}
