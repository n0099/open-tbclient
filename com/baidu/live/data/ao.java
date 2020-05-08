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
    public List<a> avh;
    public String avi;
    public String avj;
    public String avk;
    public String avl;
    public String avm;
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
                this.avh = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.avh.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.avi = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.avi) && this.avi.charAt(0) != '#') {
                    this.avi = UgcConstant.TOPIC_PATTERN_TAG + this.avi;
                }
                this.avj = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.avj) && this.avj.charAt(0) != '#') {
                    this.avj = UgcConstant.TOPIC_PATTERN_TAG + this.avj;
                }
                this.avk = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.avk) && this.avk.charAt(0) != '#') {
                    this.avk = UgcConstant.TOPIC_PATTERN_TAG + this.avk;
                }
                this.avl = jSONObject.optString("transparency");
                this.avm = jSONObject.optString("timer_point_text");
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
