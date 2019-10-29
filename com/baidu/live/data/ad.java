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
    public String TS;
    public List<a> TT;
    public String TU;
    public String TV;
    public String TW;
    public String TX;
    public String TY;
    public String text;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int length;
        if (jSONObject != null) {
            this.text = jSONObject.optString("text");
            this.TS = jSONObject.optString(Config.EVENT_HEAT_POINT);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
                this.TT = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.TT.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.TU = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.TU) && this.TU.charAt(0) != '#') {
                    this.TU = '#' + this.TU;
                }
                this.TV = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.TV) && this.TV.charAt(0) != '#') {
                    this.TV = '#' + this.TV;
                }
                this.TW = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.TW) && this.TW.charAt(0) != '#') {
                    this.TW = '#' + this.TW;
                }
                this.TX = jSONObject.optString("transparency");
                this.TY = jSONObject.optString("timer_point_text");
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
