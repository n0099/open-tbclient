package com.baidu.live.business.model.data;

import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedData {
    public LiveBannerWrapData bannerWrapData;
    public int errno;
    public LiveFeedConfig feedConfig;
    public LiveFeedWrapData feedWrapData;
    public LiveFollowWrapData followWrapData;
    public boolean isMinor;
    public String logId;
    public String msg;
    public LiveFeedReserveWrapData reserveWrapData;
    public String resource;
    public LiveTabWrapData tabWrapData;
    public LiveFeedToolWrapData toolWrapData;

    public void getDataByCache(int i, String str, boolean z, boolean z2) {
        this.errno = i;
        this.msg = str;
        LiveTabWrapData liveTabWrapData = new LiveTabWrapData();
        this.tabWrapData = liveTabWrapData;
        liveTabWrapData.parserJson(null, z, this.errno, z2);
        LiveFeedConfig liveFeedConfig = new LiveFeedConfig();
        this.feedConfig = liveFeedConfig;
        liveFeedConfig.parserJson(null, z, z);
    }

    public void parserJson(JSONObject jSONObject, int i, boolean z) {
        parserJson(jSONObject, i, z, false);
    }

    public void parserJson(JSONObject jSONObject, int i, boolean z, boolean z2) {
        if (jSONObject == null) {
            return;
        }
        this.errno = jSONObject.optInt("errno");
        this.msg = jSONObject.optString("msg");
        this.logId = jSONObject.optString("logid");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return;
        }
        this.resource = optJSONObject.optString("resource");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_BANNER);
        if (optJSONObject2 != null) {
            LiveBannerWrapData liveBannerWrapData = new LiveBannerWrapData();
            this.bannerWrapData = liveBannerWrapData;
            liveBannerWrapData.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("follow");
        if (optJSONObject3 != null) {
            LiveFollowWrapData liveFollowWrapData = new LiveFollowWrapData();
            this.followWrapData = liveFollowWrapData;
            liveFollowWrapData.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("all_follow");
        if (optJSONObject4 != null) {
            LiveFollowWrapData liveFollowWrapData2 = new LiveFollowWrapData();
            liveFollowWrapData2.parserJson(optJSONObject4);
            List<LiveFollowEntity> list = liveFollowWrapData2.followList;
            if (list != null && !list.isEmpty()) {
                this.followWrapData = liveFollowWrapData2;
            }
        }
        JSONObject optJSONObject5 = optJSONObject.optJSONObject("tab");
        if (optJSONObject5 != null) {
            LiveTabWrapData liveTabWrapData = new LiveTabWrapData();
            this.tabWrapData = liveTabWrapData;
            liveTabWrapData.parserJson(optJSONObject5, z, this.errno, z2);
        }
        JSONObject optJSONObject6 = optJSONObject.optJSONObject("feed");
        if (optJSONObject6 != null) {
            LiveFeedWrapData liveFeedWrapData = new LiveFeedWrapData();
            this.feedWrapData = liveFeedWrapData;
            liveFeedWrapData.parserJson(optJSONObject6, i, z2);
        }
        JSONObject optJSONObject7 = optJSONObject.optJSONObject("interest");
        if (optJSONObject6 == null && optJSONObject7 != null) {
            LiveFeedWrapData liveFeedWrapData2 = new LiveFeedWrapData();
            this.feedWrapData = liveFeedWrapData2;
            liveFeedWrapData2.parseJsonByResponseOnly(optJSONObject7);
        }
        JSONObject optJSONObject8 = optJSONObject.optJSONObject("config");
        if (optJSONObject8 != null) {
            LiveFeedConfig liveFeedConfig = new LiveFeedConfig();
            this.feedConfig = liveFeedConfig;
            liveFeedConfig.parserJson(optJSONObject8, z, z2);
        }
        this.reserveWrapData = LiveFeedReserveWrapData.parse(optJSONObject.optJSONObject("reserve"));
        this.toolWrapData = LiveFeedToolWrapData.parse(optJSONObject.optJSONObject("diamond"));
        JSONObject optJSONObject9 = optJSONObject.optJSONObject("state");
        if (optJSONObject9 != null) {
            boolean z3 = true;
            if (optJSONObject9.optInt("is_minor") != 1) {
                z3 = false;
            }
            this.isMinor = z3;
        }
    }
}
