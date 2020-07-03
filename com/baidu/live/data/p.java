package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {
    public String axH;
    public String imgUrl;
    public String subTitle;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axH = jSONObject.optString("main_title");
            this.subTitle = jSONObject.optString("subtitle");
            this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
        }
    }
}
