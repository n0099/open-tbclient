package com.baidu.live.gift;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class aa extends g {
    public List<a> aZG;

    public boolean HP() {
        return "30".equals(GE());
    }

    @Override // com.baidu.live.gift.g
    public boolean GF() {
        return super.GF() && !HP();
    }

    /* loaded from: classes11.dex */
    public static class a {
        public boolean aZH;
        public String aZI;
        public String name;
        public int num;
        public String pic;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.name = jSONObject.optString("fragment_name");
                this.pic = jSONObject.optString("pic");
                this.num = jSONObject.optInt("num");
                this.aZH = jSONObject.optInt("is_rare") == 1;
                this.aZI = jSONObject.optString("get_method");
            }
        }
    }
}
