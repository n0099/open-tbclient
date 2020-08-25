package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ba extends BaseData {
    public List<a> aJf;
    public String aJg;
    public String aJh;
    public String aJi;
    public String aJj;
    public String aJk;
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
                this.aJf = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aJf.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aJg = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aJg) && this.aJg.charAt(0) != '#') {
                    this.aJg = UgcConstant.TOPIC_PATTERN_TAG + this.aJg;
                }
                this.aJh = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aJh) && this.aJh.charAt(0) != '#') {
                    this.aJh = UgcConstant.TOPIC_PATTERN_TAG + this.aJh;
                }
                this.aJi = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aJi) && this.aJi.charAt(0) != '#') {
                    this.aJi = UgcConstant.TOPIC_PATTERN_TAG + this.aJi;
                }
                this.aJj = jSONObject.optString("transparency");
                this.aJk = jSONObject.optString("timer_point_text");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public String text;
        public String value;

        a(JSONObject jSONObject) {
            this.text = jSONObject.optString("text");
            this.value = jSONObject.optString("value");
        }
    }
}
