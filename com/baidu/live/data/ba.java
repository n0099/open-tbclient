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
    public List<a> aJh;
    public String aJi;
    public String aJj;
    public String aJk;
    public String aJl;
    public String aJm;
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
                this.aJh = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aJh.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aJi = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aJi) && this.aJi.charAt(0) != '#') {
                    this.aJi = UgcConstant.TOPIC_PATTERN_TAG + this.aJi;
                }
                this.aJj = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aJj) && this.aJj.charAt(0) != '#') {
                    this.aJj = UgcConstant.TOPIC_PATTERN_TAG + this.aJj;
                }
                this.aJk = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aJk) && this.aJk.charAt(0) != '#') {
                    this.aJk = UgcConstant.TOPIC_PATTERN_TAG + this.aJk;
                }
                this.aJl = jSONObject.optString("transparency");
                this.aJm = jSONObject.optString("timer_point_text");
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
