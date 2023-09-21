package com.baidu.live.business.model.data;

import android.text.TextUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimer;
import com.baidu.tieba.ta0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveFeedConfig {
    public static final String LIVE_FEED_PAGE_CONFIG_CACHE_KEY = "live_feed_page_config_cache_key";
    public AbSwitchConfig abSwitchConfig;
    public int followShowNum;
    public boolean footprintSwitch;
    public String footprintUrl;
    public InterestInsert interestInsert;
    public String minorUfoUrl;
    public PlayConfig playConfig;
    public boolean searchIsOpen;
    public String startLiveScheme;
    public long timeoutRefreshTime;

    public int getFollowShowNum() {
        if (this.followShowNum <= 0) {
            this.followShowNum = 20;
        }
        return this.followShowNum;
    }

    public boolean supportPlay() {
        PlayConfig playConfig = this.playConfig;
        if (playConfig != null) {
            return playConfig.enable;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public static class AbSwitchConfig {
        public boolean newBanner;
        public boolean newTab;
        public boolean otherNewStyle;

        public static AbSwitchConfig parserJson(JSONObject jSONObject) {
            boolean z;
            boolean z2;
            if (jSONObject != null) {
                AbSwitchConfig abSwitchConfig = new AbSwitchConfig();
                boolean z3 = false;
                if (jSONObject.optInt(SpeedStatsUtils.UBC_VALUE_BANNER) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                abSwitchConfig.newBanner = z;
                if (jSONObject.optInt("tab") == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                abSwitchConfig.newTab = z2;
                if (jSONObject.optInt("other") == 1) {
                    z3 = true;
                }
                abSwitchConfig.otherNewStyle = z3;
                return abSwitchConfig;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class InterestInsert {
        public int duration;
        public int frequency;
        public JSONArray tab;

        public static InterestInsert parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                InterestInsert interestInsert = new InterestInsert();
                interestInsert.duration = jSONObject.optInt("duration");
                interestInsert.frequency = jSONObject.optInt(FetchTimer.FREQUENCY);
                interestInsert.tab = jSONObject.optJSONArray("tab");
                return interestInsert;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class PlayConfig {
        public boolean enable;
        public int maxPlayCount;

        public static PlayConfig parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                PlayConfig playConfig = new PlayConfig();
                boolean z = true;
                if (jSONObject.optInt("enable") != 1) {
                    z = false;
                }
                playConfig.enable = z;
                playConfig.maxPlayCount = jSONObject.optInt("max_auto_play_count");
                return playConfig;
            }
            return null;
        }
    }

    public void parserJson(JSONObject jSONObject, boolean z, boolean z2) {
        boolean z3 = false;
        if (jSONObject != null) {
            this.startLiveScheme = jSONObject.optString("start_live_scheme");
            this.timeoutRefreshTime = jSONObject.optLong("timeout_refresh_time");
            if (jSONObject.optInt("feed_search_switch") == 1) {
                z3 = true;
            }
            this.searchIsOpen = z3;
            this.playConfig = PlayConfig.parserJson(jSONObject.optJSONObject("auto_play"));
            this.abSwitchConfig = AbSwitchConfig.parserJson(jSONObject.optJSONObject("ab_switch"));
            this.interestInsert = InterestInsert.parserJson(jSONObject.optJSONObject("interest_insert"));
            this.footprintSwitch = jSONObject.optString("watch_history_switch").equals("1");
            this.footprintUrl = jSONObject.optString("watch_history_url");
            this.followShowNum = jSONObject.optInt("follow_show_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_minor_conf");
            if (optJSONObject != null) {
                this.minorUfoUrl = optJSONObject.optString("ufo_url");
            }
            if (z && z2) {
                ta0.f(LIVE_FEED_PAGE_CONFIG_CACHE_KEY, jSONObject.toString());
            }
        } else if (z && z2) {
            String b = ta0.b(LIVE_FEED_PAGE_CONFIG_CACHE_KEY, "");
            if (!TextUtils.isEmpty(b)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(b);
                    this.startLiveScheme = jSONObject2.optString("start_live_scheme");
                    this.timeoutRefreshTime = jSONObject2.optLong("timeout_refresh_time");
                    if (jSONObject2.optInt("feed_search_switch") == 1) {
                        z3 = true;
                    }
                    this.searchIsOpen = z3;
                    this.playConfig = PlayConfig.parserJson(jSONObject2.optJSONObject("auto_play"));
                    this.abSwitchConfig = AbSwitchConfig.parserJson(jSONObject2.optJSONObject("ab_switch"));
                    this.followShowNum = jSONObject2.optInt("follow_show_num");
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("user_minor_conf");
                    if (optJSONObject2 != null) {
                        this.minorUfoUrl = optJSONObject2.optString("ufo_url");
                    }
                } catch (JSONException unused) {
                    ta0.g(LIVE_FEED_PAGE_CONFIG_CACHE_KEY);
                }
            }
        }
    }
}
