package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ak extends BaseData {
    public List<a> aaB;
    public String aaC;
    public String aaD;
    public String aaE;
    public String aaF;
    public String aaG;
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
                this.aaB = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aaB.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aaC = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aaC) && this.aaC.charAt(0) != '#') {
                    this.aaC = '#' + this.aaC;
                }
                this.aaD = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aaD) && this.aaD.charAt(0) != '#') {
                    this.aaD = '#' + this.aaD;
                }
                this.aaE = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aaE) && this.aaE.charAt(0) != '#') {
                    this.aaE = '#' + this.aaE;
                }
                this.aaF = jSONObject.optString("transparency");
                this.aaG = jSONObject.optString("timer_point_text");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public String text;
        public String value;

        a(JSONObject jSONObject) {
            this.text = jSONObject.optString("text");
            this.value = jSONObject.optString("value");
        }
    }
}
