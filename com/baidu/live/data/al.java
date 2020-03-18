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
    public List<a> acJ;
    public String acK;
    public String acL;
    public String acM;
    public String acN;
    public String acO;
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
                this.acJ = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.acJ.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.acK = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.acK) && this.acK.charAt(0) != '#') {
                    this.acK = '#' + this.acK;
                }
                this.acL = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.acL) && this.acL.charAt(0) != '#') {
                    this.acL = '#' + this.acL;
                }
                this.acM = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.acM) && this.acM.charAt(0) != '#') {
                    this.acM = '#' + this.acM;
                }
                this.acN = jSONObject.optString("transparency");
                this.acO = jSONObject.optString("timer_point_text");
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
