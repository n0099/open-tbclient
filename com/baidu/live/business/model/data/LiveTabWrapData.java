package com.baidu.live.business.model.data;

import android.text.TextUtils;
import com.baidu.tieba.fa0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveTabWrapData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LIVE_FEED_PAGE_TAB_CACHE_KEY = "live_feed_page_tab_cache_key";
    public static final String LIVE_FEED_PAGE_TAB_CACHE_TIME = "live_feed_page_tab_cache_time";
    public transient /* synthetic */ FieldHolder $fh;
    public int cacheCause;
    public long cacheTime;
    public int errCode;
    public String errMsg;
    public boolean isCacheData;
    public List<LiveTabEntity> tabList;

    public LiveTabWrapData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void getTabListByJson(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, jSONArray) == null) && jSONArray != null && jSONArray.length() > 0) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONObject, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            if (jSONObject != null) {
                this.errCode = jSONObject.optInt("inner_errno");
                this.errMsg = jSONObject.optString("inner_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                getTabListByJson(optJSONArray);
                if (z && optJSONArray != null && (list = this.tabList) != null && !list.isEmpty() && z2) {
                    fa0.e(LIVE_FEED_PAGE_TAB_CACHE_TIME, System.currentTimeMillis());
                    fa0.f(LIVE_FEED_PAGE_TAB_CACHE_KEY, optJSONArray.toString());
                }
            }
            if (z2 && z) {
                List<LiveTabEntity> list2 = this.tabList;
                if (list2 == null || list2.isEmpty()) {
                    this.cacheCause = 2;
                    String b = fa0.b(LIVE_FEED_PAGE_TAB_CACHE_KEY, "");
                    if (!TextUtils.isEmpty(b)) {
                        try {
                            getTabListByJson(new JSONArray(b));
                            this.isCacheData = true;
                            if (i == -101) {
                                this.cacheCause = 1;
                            } else if (this.errCode != 0) {
                                this.cacheCause = 3;
                            }
                            this.cacheTime = fa0.c(LIVE_FEED_PAGE_TAB_CACHE_TIME, 0L);
                        } catch (JSONException unused) {
                            fa0.g(LIVE_FEED_PAGE_TAB_CACHE_KEY);
                            fa0.g(LIVE_FEED_PAGE_TAB_CACHE_TIME);
                        }
                    }
                }
            }
        }
    }
}
