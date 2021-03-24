package com.baidu.ala.notify;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveUserNotifyData {
    public static final int GUARDIAN_DUE = 1;
    public static final int GUARDIAN_GRAB = 2;
    public String create_time;
    public AlaNotifyContent notifyContent;
    public int notify_type;
    public String user_id;

    /* loaded from: classes2.dex */
    public static class AlaNotifyContent {
        public String anchor_id;
        public String anchor_portrait;
        public String text;

        public AlaNotifyContent() {
        }
    }

    public String getAnchorPortrait() {
        AlaNotifyContent alaNotifyContent = this.notifyContent;
        return alaNotifyContent != null ? alaNotifyContent.anchor_portrait : "";
    }

    public String getMessageContent() {
        AlaNotifyContent alaNotifyContent = this.notifyContent;
        return alaNotifyContent != null ? alaNotifyContent.text : "";
    }

    public boolean isSuperGuardian() {
        int i = this.notify_type;
        return i == 1 || i == 2;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.user_id = jSONObject.optString("user_id");
        this.create_time = jSONObject.optString("create_time");
        this.notify_type = jSONObject.optInt("notify_type");
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optJSONObject != null) {
            AlaNotifyContent alaNotifyContent = new AlaNotifyContent();
            this.notifyContent = alaNotifyContent;
            alaNotifyContent.text = optJSONObject.optString("text");
            this.notifyContent.anchor_id = optJSONObject.optString("anchor_id");
            this.notifyContent.anchor_portrait = optJSONObject.optString("anchor_portrait");
        }
    }
}
