package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class al extends BaseData {
    public String acA;
    public String acB;
    public String acC;
    public String acD;
    public String acE;
    public List<a> acz;
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
                this.acz = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.acz.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.acA = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.acA) && this.acA.charAt(0) != '#') {
                    this.acA = '#' + this.acA;
                }
                this.acB = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.acB) && this.acB.charAt(0) != '#') {
                    this.acB = '#' + this.acB;
                }
                this.acC = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.acC) && this.acC.charAt(0) != '#') {
                    this.acC = '#' + this.acC;
                }
                this.acD = jSONObject.optString("transparency");
                this.acE = jSONObject.optString("timer_point_text");
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
