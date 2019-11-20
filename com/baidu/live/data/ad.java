package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ad extends BaseData {
    public String TA;
    public String TB;
    public String TC;
    public String TD;
    public String Tx;
    public List<a> Ty;
    public String Tz;
    public String text;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int length;
        if (jSONObject != null) {
            this.text = jSONObject.optString("text");
            this.Tx = jSONObject.optString(Config.EVENT_HEAT_POINT);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
                this.Ty = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.Ty.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.Tz = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.Tz) && this.Tz.charAt(0) != '#') {
                    this.Tz = '#' + this.Tz;
                }
                this.TA = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.TA) && this.TA.charAt(0) != '#') {
                    this.TA = '#' + this.TA;
                }
                this.TB = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.TB) && this.TB.charAt(0) != '#') {
                    this.TB = '#' + this.TB;
                }
                this.TC = jSONObject.optString("transparency");
                this.TD = jSONObject.optString("timer_point_text");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public String text;
        public String value;

        a(JSONObject jSONObject) {
            this.text = jSONObject.optString("text");
            this.value = jSONObject.optString("value");
        }
    }
}
