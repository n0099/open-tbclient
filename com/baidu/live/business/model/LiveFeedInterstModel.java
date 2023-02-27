package com.baidu.live.business.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tieba.lc0;
import com.baidu.tieba.mc0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedInterstModel {
    public static final String FEED_PAGE_INTEREST_URL = "https://tiebac.baidu.com/livefeed/interest";

    /* loaded from: classes2.dex */
    public interface OnInterestDataLoadCallback {
        void onFail(@Nullable int i, @Nullable String str, @Nullable Map<String, String> map);

        void onSuccess(@Nullable LiveFeedData liveFeedData, @Nullable Map<String, String> map);
    }

    public void reqInterestData(@Nullable String str, String str2, @Nullable String str3, @Nullable final OnInterestDataLoadCallback onInterestDataLoadCallback) {
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("session_id", str);
        hashMap.put("live_tag", str2);
        hashMap.put("feed_tag", str3);
        mc0.f(FEED_PAGE_INTEREST_URL, hashMap, new lc0<LiveFeedData>() { // from class: com.baidu.live.business.model.LiveFeedInterstModel.1
            /* renamed from: onNetResponse  reason: avoid collision after fix types in other method */
            public void onNetResponse2(NetResponse netResponse, LiveFeedData liveFeedData, Map<String, String> map, List<String> list) {
                if (netResponse != null) {
                    if (netResponse.isSuccessful() && liveFeedData != null) {
                        OnInterestDataLoadCallback onInterestDataLoadCallback2 = onInterestDataLoadCallback;
                        if (onInterestDataLoadCallback2 != null) {
                            onInterestDataLoadCallback2.onSuccess(liveFeedData, map);
                            return;
                        }
                        return;
                    }
                    OnInterestDataLoadCallback onInterestDataLoadCallback3 = onInterestDataLoadCallback;
                    if (onInterestDataLoadCallback3 != null) {
                        onInterestDataLoadCallback3.onFail(netResponse.netErrorCode, netResponse.exception, map);
                        return;
                    }
                    return;
                }
                OnInterestDataLoadCallback onInterestDataLoadCallback4 = onInterestDataLoadCallback;
                if (onInterestDataLoadCallback4 != null) {
                    onInterestDataLoadCallback4.onFail(-100, "网络不给力，请稍后重试", map);
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.searchbox.live.interfaces.net.NetResponse, java.lang.Object, java.util.Map, java.util.List] */
            @Override // com.baidu.tieba.lc0
            public /* bridge */ /* synthetic */ void onNetResponse(NetResponse netResponse, LiveFeedData liveFeedData, Map map, List list) {
                onNetResponse2(netResponse, liveFeedData, (Map<String, String>) map, (List<String>) list);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.lc0
            public LiveFeedData onParseResponseInBackground(NetResponse netResponse) {
                LiveFeedData liveFeedData = new LiveFeedData();
                if (netResponse != null && !TextUtils.isEmpty(netResponse.decodedResponseStr)) {
                    try {
                        liveFeedData.parserJson(new JSONObject(netResponse.decodedResponseStr), 2, false, true);
                    } catch (JSONException e) {
                        LiveFeedPageSdk.liveLog(e.getMessage());
                    }
                }
                return liveFeedData;
            }
        }, 0, 0, null, new ArrayList());
    }
}
