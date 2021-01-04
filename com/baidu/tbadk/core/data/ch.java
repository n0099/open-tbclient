package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.VideoDesc;
/* loaded from: classes.dex */
public class ch {
    public static VideoDesc dq(JSONObject jSONObject) {
        VideoDesc.Builder builder = new VideoDesc.Builder();
        if (jSONObject != null) {
            builder.video_id = Integer.valueOf(jSONObject.optInt("video_id"));
            builder.video_md5 = jSONObject.optString("video_md5");
            builder.video_url = jSONObject.optString("video_url");
            builder.video_width = jSONObject.optString("video_width");
            builder.video_height = jSONObject.optString("video_height");
        }
        return builder.build(true);
    }
}
