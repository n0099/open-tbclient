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
public class ao extends BaseData {
    public List<a> avb;
    public String avc;
    public String avd;
    public String ave;
    public String avf;
    public String avg;
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
                this.avb = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.avb.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.avc = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.avc) && this.avc.charAt(0) != '#') {
                    this.avc = UgcConstant.TOPIC_PATTERN_TAG + this.avc;
                }
                this.avd = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.avd) && this.avd.charAt(0) != '#') {
                    this.avd = UgcConstant.TOPIC_PATTERN_TAG + this.avd;
                }
                this.ave = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.ave) && this.ave.charAt(0) != '#') {
                    this.ave = UgcConstant.TOPIC_PATTERN_TAG + this.ave;
                }
                this.avf = jSONObject.optString("transparency");
                this.avg = jSONObject.optString("timer_point_text");
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
