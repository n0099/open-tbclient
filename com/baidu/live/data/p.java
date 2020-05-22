package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {
    public String avB;
    public String imgUrl;
    public String subTitle;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.avB = jSONObject.optString("main_title");
            this.subTitle = jSONObject.optString("subtitle");
            this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
        }
    }
}
