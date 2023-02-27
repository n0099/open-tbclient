package com.baidu.live.business.model.data;

import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFollowEntity {
    public String audienceCount;
    public String cmd;
    public String feedId;
    public LiveHostInfo hostInfo;
    public int liveStatus;
    public String liveTag;
    public String nid;
    public String roomId;
    public LiveStatInfo statInfo;
    public String title;
    public boolean isMore = false;
    public boolean needLogShow = true;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.isMore = false;
        this.feedId = jSONObject.optString("feed_id");
        this.nid = jSONObject.optString("nid");
        this.roomId = jSONObject.optString("room_id");
        this.title = jSONObject.optString("title");
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.liveTag = jSONObject.optString("live_tag");
        this.cmd = jSONObject.optString("cmd");
        this.audienceCount = jSONObject.optString("audience_count");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("stat");
        if (optJSONObject2 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject2);
        }
    }
}
