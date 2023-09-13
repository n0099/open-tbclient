package com.baidu.live.business.model.data;

import android.text.TextUtils;
import com.baidu.tieba.ua0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveTabWrapData {
    public static final String LIVE_FEED_PAGE_TAB_CACHE_KEY = "live_feed_page_tab_cache_key";
    public static final String LIVE_FEED_PAGE_TAB_CACHE_TIME = "live_feed_page_tab_cache_time";
    public int cacheCause;
    public long cacheTime;
    public int errCode;
    public String errMsg;
    public boolean isCacheData;
    public List<LiveTabEntity> tabList;

    private void getTabListByJson(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.tabList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    LiveTabEntity liveTabEntity = new LiveTabEntity();
                    liveTabEntity.parserJson(optJSONObject);
                    this.tabList.add(liveTabEntity);
                }
            }
        }
    }

    public void parserJson(JSONObject jSONObject, boolean z, int i, boolean z2) {
        List<LiveTabEntity> list;
        if (jSONObject != null) {
            this.errCode = jSONObject.optInt("inner_errno");
            this.errMsg = jSONObject.optString("inner_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            getTabListByJson(optJSONArray);
            if (z && optJSONArray != null && (list = this.tabList) != null && !list.isEmpty() && z2) {
                ua0.e(LIVE_FEED_PAGE_TAB_CACHE_TIME, System.currentTimeMillis());
                ua0.f(LIVE_FEED_PAGE_TAB_CACHE_KEY, optJSONArray.toString());
            }
        }
        if (z2 && z) {
            List<LiveTabEntity> list2 = this.tabList;
            if (list2 == null || list2.isEmpty()) {
                this.cacheCause = 2;
                String b = ua0.b(LIVE_FEED_PAGE_TAB_CACHE_KEY, "");
                if (!TextUtils.isEmpty(b)) {
                    try {
                        getTabListByJson(new JSONArray(b));
                        this.isCacheData = true;
                        if (i == -101) {
                            this.cacheCause = 1;
                        } else if (this.errCode != 0) {
                            this.cacheCause = 3;
                        }
                        this.cacheTime = ua0.c(LIVE_FEED_PAGE_TAB_CACHE_TIME, 0L);
                    } catch (JSONException unused) {
                        ua0.g(LIVE_FEED_PAGE_TAB_CACHE_KEY);
                        ua0.g(LIVE_FEED_PAGE_TAB_CACHE_TIME);
                    }
                }
            }
        }
    }
}
