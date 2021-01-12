package com.baidu.live.gift;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aa extends g {
    public List<a> aUT;

    public boolean DU() {
        return "30".equals(CJ());
    }

    @Override // com.baidu.live.gift.g
    public boolean CK() {
        return super.CK() && !DU();
    }

    /* loaded from: classes10.dex */
    public static class a {
        public boolean aUU;
        public String aUV;
        public String name;
        public int num;
        public String pic;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.name = jSONObject.optString("fragment_name");
                this.pic = jSONObject.optString("pic");
                this.num = jSONObject.optInt("num");
                this.aUU = jSONObject.optInt("is_rare") == 1;
                this.aUV = jSONObject.optString("get_method");
            }
        }
    }
}
