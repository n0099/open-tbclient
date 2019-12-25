package com.baidu.ala.notify;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveUserNotifyData {
    private static final int GUARDIAN_DUE = 1;
    private static final int GUARDIAN_GRAB = 2;
    public String create_time;
    public AlaNotifyContent notifyContent;
    public int notify_type;
    public String user_id;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.create_time = jSONObject.optString("create_time");
            this.notify_type = jSONObject.optInt("notify_type");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optJSONObject != null) {
                this.notifyContent = new AlaNotifyContent();
                this.notifyContent.text = optJSONObject.optString("text");
                this.notifyContent.anchor_id = optJSONObject.optString("anchor_id");
                this.notifyContent.anchor_portrait = optJSONObject.optString("anchor_portrait");
            }
        }
    }

    public boolean isSuperGuardian() {
        return this.notify_type == 1 || this.notify_type == 2;
    }

    public String getMessageContent() {
        return this.notifyContent != null ? this.notifyContent.text : "";
    }

    public String getAnchorPortrait() {
        return this.notifyContent != null ? this.notifyContent.anchor_portrait : "";
    }

    /* loaded from: classes2.dex */
    private static class AlaNotifyContent {
        public String anchor_id;
        public String anchor_portrait;
        public String text;

        private AlaNotifyContent() {
        }
    }
}
