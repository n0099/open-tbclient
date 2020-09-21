package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bf extends BaseData {
    public String aKA;
    public String aKB;
    public String aKC;
    public List<a> aKx;
    public String aKy;
    public String aKz;
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
                this.aKx = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aKx.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aKy = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aKy) && this.aKy.charAt(0) != '#') {
                    this.aKy = UgcConstant.TOPIC_PATTERN_TAG + this.aKy;
                }
                this.aKz = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aKz) && this.aKz.charAt(0) != '#') {
                    this.aKz = UgcConstant.TOPIC_PATTERN_TAG + this.aKz;
                }
                this.aKA = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aKA) && this.aKA.charAt(0) != '#') {
                    this.aKA = UgcConstant.TOPIC_PATTERN_TAG + this.aKA;
                }
                this.aKB = jSONObject.optString("transparency");
                this.aKC = jSONObject.optString("timer_point_text");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public String text;
        public String value;

        a(JSONObject jSONObject) {
            this.text = jSONObject.optString("text");
            this.value = jSONObject.optString("value");
        }
    }
}
