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
public class ay extends BaseData {
    public List<a> aDV;
    public String aDW;
    public String aDX;
    public String aDY;
    public String aDZ;
    public String aEa;
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
                this.aDV = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aDV.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aDW = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aDW) && this.aDW.charAt(0) != '#') {
                    this.aDW = UgcConstant.TOPIC_PATTERN_TAG + this.aDW;
                }
                this.aDX = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aDX) && this.aDX.charAt(0) != '#') {
                    this.aDX = UgcConstant.TOPIC_PATTERN_TAG + this.aDX;
                }
                this.aDY = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aDY) && this.aDY.charAt(0) != '#') {
                    this.aDY = UgcConstant.TOPIC_PATTERN_TAG + this.aDY;
                }
                this.aDZ = jSONObject.optString("transparency");
                this.aEa = jSONObject.optString("timer_point_text");
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
