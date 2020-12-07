package com.baidu.live.gift;

import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aa extends g {
    public List<a> aYb;

    public boolean Io() {
        return "30".equals(Hd());
    }

    @Override // com.baidu.live.gift.g
    public boolean He() {
        return super.He() && !Io();
    }

    /* loaded from: classes4.dex */
    public static class a {
        public boolean aYc;
        public String aYd;
        public String name;
        public int num;
        public String pic;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.name = jSONObject.optString("fragment_name");
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.num = jSONObject.optInt("num");
                this.aYc = jSONObject.optInt("is_rare") == 1;
                this.aYd = jSONObject.optString("get_method");
            }
        }
    }
}
