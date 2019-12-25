package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class ak {
    public static McnAdInfo ch(JSONObject jSONObject) {
        McnAdInfo.Builder builder = new McnAdInfo.Builder();
        if (jSONObject != null) {
            builder.ad_start_time = Long.valueOf(jSONObject.optLong(SharedPrefConfig.AD_START_TIME));
            builder.ad_end_time = Long.valueOf(jSONObject.optLong(SharedPrefConfig.AD_END_TIME));
            builder.pic_url = jSONObject.optString("pic_url");
            builder.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            builder.card_title = jSONObject.optString("card_title");
            builder.button_title = jSONObject.optString("button_title");
            builder.effect_time = Long.valueOf(jSONObject.optLong("effect_time"));
            builder.expire_time = Long.valueOf(jSONObject.optLong("expire_time"));
        }
        return builder.build(true);
    }
}
