package com.baidu.live.business.model.data;

import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSearchResultInfo {
    public LiveStatInfo statInfo;
    public String question = "";
    public String displayName = "百度";
    public String avatar = "";
    public String audienceCount = "";
    public String roomId = "";
    public String cmd = "";
    public String description = "";
    public boolean hasFollowed = false;
    public boolean hasLiving = false;
    public String feedId = "";
    public String liveType = "";
    public String yyuid = "";
    public String sid = "";
    public String ssid = "";
    public String tpl = "";
    public String templateId = "";
    public String uid = "";
    public String thirdId = "";
    public String type = "";
    public String status = "";
    public String uk = "";

    public boolean isHasFollowed(JSONObject jSONObject) {
        if (jSONObject.optString("has_follow").equals("1")) {
            return true;
        }
        return false;
    }

    public boolean isHasLiving(JSONObject jSONObject) {
        if (jSONObject.optString(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS).equals("1")) {
            return true;
        }
        return false;
    }

    public void parseJSONObj(JSONObject jSONObject) {
        this.question = jSONObject.optString("q");
        this.displayName = jSONObject.optString("name");
        this.avatar = jSONObject.optString("avatar");
        this.audienceCount = jSONObject.optString("AudienceCount");
        this.roomId = jSONObject.optString("room_id");
        this.cmd = jSONObject.optString("cmd");
        this.description = jSONObject.optString("description");
        this.hasFollowed = isHasFollowed(jSONObject);
        this.hasLiving = isHasLiving(jSONObject);
        this.status = jSONObject.optString(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.feedId = jSONObject.optString("feed_id");
        this.uid = jSONObject.optString("user_id");
        this.uk = jSONObject.optString("uk");
        this.thirdId = jSONObject.optString("third_id");
        this.type = jSONObject.optString("type");
        JSONObject optJSONObject = jSONObject.optJSONObject("stat");
        if (optJSONObject != null) {
            this.liveType = optJSONObject.optString("live_type");
            this.yyuid = optJSONObject.optString("yyuid");
            this.sid = optJSONObject.optString("sid");
            this.ssid = optJSONObject.optString(YyLiveRoomConfig.KEY_SSID);
            this.tpl = optJSONObject.optString("tpl");
            this.templateId = optJSONObject.optString("template_id");
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject);
        }
    }
}
