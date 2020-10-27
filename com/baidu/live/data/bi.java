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
public class bi extends BaseData {
    public List<a> aOh;
    public String aOi;
    public String aOj;
    public String aOk;
    public String aOl;
    public String aOm;
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
                this.aOh = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aOh.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aOi = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aOi) && this.aOi.charAt(0) != '#') {
                    this.aOi = UgcConstant.TOPIC_PATTERN_TAG + this.aOi;
                }
                this.aOj = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aOj) && this.aOj.charAt(0) != '#') {
                    this.aOj = UgcConstant.TOPIC_PATTERN_TAG + this.aOj;
                }
                this.aOk = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aOk) && this.aOk.charAt(0) != '#') {
                    this.aOk = UgcConstant.TOPIC_PATTERN_TAG + this.aOk;
                }
                this.aOl = jSONObject.optString("transparency");
                this.aOm = jSONObject.optString("timer_point_text");
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
