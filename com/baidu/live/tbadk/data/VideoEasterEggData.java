package com.baidu.live.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoEasterEggData implements Serializable {
    private String activityID;
    private String popImageUrl;
    private String popText;
    private String shareContent;
    private String shareImageUrl;
    private String shareTitle;
    private String shareUrl;
    private String videoUrl;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.activityID = jSONObject.optString("activity_id", "");
            this.videoUrl = jSONObject.optString("video_url", "");
            this.popText = jSONObject.optString("pop_text", "");
            this.popImageUrl = jSONObject.optString("pop_imageurl", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("share_info");
            if (optJSONObject != null) {
                this.shareTitle = optJSONObject.optString("title", "");
                this.shareContent = optJSONObject.optString("content", "");
                this.shareUrl = optJSONObject.optString("url", "");
                this.shareImageUrl = optJSONObject.optString("imageurl", "");
            }
        }
    }

    public String getActivityID() {
        return this.activityID;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getPopText() {
        return this.popText;
    }

    public String getPopImageUrl() {
        return this.popImageUrl;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareContent() {
        return this.shareContent;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getShareImageUrl() {
        return this.shareImageUrl;
    }
}
