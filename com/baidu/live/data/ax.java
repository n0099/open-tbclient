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
public class ax extends BaseData {
    public List<a> aCA;
    public String aCB;
    public String aCC;
    public String aCD;
    public String aCE;
    public String aCF;
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
                this.aCA = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aCA.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aCB = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aCB) && this.aCB.charAt(0) != '#') {
                    this.aCB = UgcConstant.TOPIC_PATTERN_TAG + this.aCB;
                }
                this.aCC = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aCC) && this.aCC.charAt(0) != '#') {
                    this.aCC = UgcConstant.TOPIC_PATTERN_TAG + this.aCC;
                }
                this.aCD = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aCD) && this.aCD.charAt(0) != '#') {
                    this.aCD = UgcConstant.TOPIC_PATTERN_TAG + this.aCD;
                }
                this.aCE = jSONObject.optString("transparency");
                this.aCF = jSONObject.optString("timer_point_text");
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
