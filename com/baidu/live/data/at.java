package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class at extends BaseData {
    public List<a> aAp;
    public String aAq;
    public String aAr;
    public String aAs;
    public String aAt;
    public String aAu;
    public String point;
    public String text;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int length;
        if (jSONObject != null) {
            this.text = jSONObject.optString("text");
            this.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
                this.aAp = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aAp.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aAq = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aAq) && this.aAq.charAt(0) != '#') {
                    this.aAq = UgcConstant.TOPIC_PATTERN_TAG + this.aAq;
                }
                this.aAr = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aAr) && this.aAr.charAt(0) != '#') {
                    this.aAr = UgcConstant.TOPIC_PATTERN_TAG + this.aAr;
                }
                this.aAs = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aAs) && this.aAs.charAt(0) != '#') {
                    this.aAs = UgcConstant.TOPIC_PATTERN_TAG + this.aAs;
                }
                this.aAt = jSONObject.optString("transparency");
                this.aAu = jSONObject.optString("timer_point_text");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String text;
        public String value;

        a(JSONObject jSONObject) {
            this.text = jSONObject.optString("text");
            this.value = jSONObject.optString("value");
        }
    }
}
