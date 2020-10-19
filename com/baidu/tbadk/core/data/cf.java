package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class cf {
    public static VideoInfo de(JSONObject jSONObject) {
        if (jSONObject != null) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = jSONObject.optString("video_md5");
            builder.video_url = jSONObject.optString("video_url");
            builder.video_duration = Integer.valueOf(jSONObject.optInt("video_duration"));
            builder.video_width = Integer.valueOf(jSONObject.optInt("video_width"));
            builder.video_height = Integer.valueOf(jSONObject.optInt("video_height"));
            builder.thumbnail_url = jSONObject.optString("thumbnail_url");
            builder.thumbnail_width = Integer.valueOf(jSONObject.optInt("thumbnail_width"));
            builder.thumbnail_height = Integer.valueOf(jSONObject.optInt("thumbnail_height"));
            builder.video_length = Integer.valueOf(jSONObject.optInt("video_length"));
            builder.play_count = Integer.valueOf(jSONObject.optInt("play_count"));
            builder.media_subtitle = jSONObject.optString("media_subtitle");
            builder.video_desc = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("video_desc");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    builder.video_desc.add(ce.dd(optJSONArray.optJSONObject(i)));
                }
            }
            builder.video_select_flag = Integer.valueOf(jSONObject.optInt("video_select_flag"));
            builder.video_type = Integer.valueOf(jSONObject.optInt(LogConfig.LOG_VIDEO_TYPE));
            builder.is_vertical = Integer.valueOf(jSONObject.optInt("is_vertical"));
            builder.video_h265 = ce.dd(jSONObject.optJSONObject("video_h265"));
            builder.mcn_lead_page = jSONObject.optString("mcn_lead_page");
            builder.mcn_ad_card = aq.db(jSONObject.optJSONObject("mcn_ad_card"));
            builder.wth_mid_loc = Double.valueOf(jSONObject.optDouble("wth_mid_loc"));
            builder.hth_mid_loc = Double.valueOf(jSONObject.optDouble("hth_mid_loc"));
            return builder.build(true);
        }
        return null;
    }
}
