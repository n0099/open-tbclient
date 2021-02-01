package com.baidu.live.tbadk.coreextra.data;

import org.json.JSONObject;
@Deprecated
/* loaded from: classes11.dex */
public class ActivityPrizeData {
    private String dotTimestamp;
    private String enterForumText;
    private String feedText;
    private String h5Url;
    private String myTabText;
    private boolean personItemSwitch;
    private String personItemText;
    private boolean switchTurn;
    private boolean userSatisfy;

    public boolean isSwitchTurn() {
        return this.switchTurn;
    }

    public void setSwitchTurn(boolean z) {
        this.switchTurn = z;
    }

    public boolean isPersonItemSwitch() {
        return this.personItemSwitch;
    }

    public void setPersonItemSwitch(boolean z) {
        this.personItemSwitch = z;
    }

    public String getPersonItemText() {
        return this.personItemText;
    }

    public void setPersonItemText(String str) {
        this.personItemText = str;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public boolean isUserSatisfy() {
        return this.userSatisfy;
    }

    public void setUserSatisfy(boolean z) {
        this.userSatisfy = z;
    }

    public String getDotTimestamp() {
        return this.dotTimestamp;
    }

    public void setDotTimestamp(String str) {
        this.dotTimestamp = str;
    }

    public String getMyTabText() {
        return this.myTabText;
    }

    public void setMyTabText(String str) {
        this.myTabText = str;
    }

    public String getEnterForumText() {
        return this.enterForumText;
    }

    public void setEnterForumText(String str) {
        this.enterForumText = str;
    }

    public String getFeedText() {
        return this.feedText;
    }

    public void setFeedText(String str) {
        this.feedText = str;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            setSwitchTurn(jSONObject.optInt("switch") == 1);
            this.feedText = jSONObject.optString("feed_text");
            this.enterForumText = jSONObject.optString("enter_forum_text");
            this.myTabText = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.dotTimestamp = optLong == 0 ? "" : optLong + "";
            this.userSatisfy = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.personItemSwitch = jSONObject.optInt("person_item_switch") == 1;
            this.personItemText = jSONObject.optString("person_item_text");
        }
    }
}
