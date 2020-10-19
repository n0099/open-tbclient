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
    public List<a> aNC;
    public String aND;
    public String aNE;
    public String aNF;
    public String aNG;
    public String aNH;
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
                this.aNC = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aNC.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aND = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aND) && this.aND.charAt(0) != '#') {
                    this.aND = UgcConstant.TOPIC_PATTERN_TAG + this.aND;
                }
                this.aNE = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aNE) && this.aNE.charAt(0) != '#') {
                    this.aNE = UgcConstant.TOPIC_PATTERN_TAG + this.aNE;
                }
                this.aNF = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aNF) && this.aNF.charAt(0) != '#') {
                    this.aNF = UgcConstant.TOPIC_PATTERN_TAG + this.aNF;
                }
                this.aNG = jSONObject.optString("transparency");
                this.aNH = jSONObject.optString("timer_point_text");
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
