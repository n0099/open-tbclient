package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ag extends BaseData {
    public String aao;
    public List<a> aap;
    public String aaq;
    public String aar;
    public String aas;
    public String aat;
    public String aau;
    public String text;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int length;
        if (jSONObject != null) {
            this.text = jSONObject.optString("text");
            this.aao = jSONObject.optString(Config.EVENT_HEAT_POINT);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
                this.aap = new ArrayList();
                for (int i = 0; i < length; i++) {
                    this.aap.add(new a(optJSONArray.optJSONObject(i)));
                }
                this.aaq = jSONObject.optString("text_color");
                if (!TextUtils.isEmpty(this.aaq) && this.aaq.charAt(0) != '#') {
                    this.aaq = '#' + this.aaq;
                }
                this.aar = jSONObject.optString("value_color");
                if (!TextUtils.isEmpty(this.aar) && this.aar.charAt(0) != '#') {
                    this.aar = '#' + this.aar;
                }
                this.aas = jSONObject.optString("background_color");
                if (!TextUtils.isEmpty(this.aas) && this.aas.charAt(0) != '#') {
                    this.aas = '#' + this.aas;
                }
                this.aat = jSONObject.optString("transparency");
                this.aau = jSONObject.optString("timer_point_text");
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
