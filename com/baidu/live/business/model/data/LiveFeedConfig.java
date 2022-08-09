package com.baidu.live.business.model.data;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o80;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LIVE_FEED_PAGE_CONFIG_CACHE_KEY = "live_feed_page_config_cache_key";
    public transient /* synthetic */ FieldHolder $fh;
    public AbSwitchConfig abSwitchConfig;
    public boolean footprintSwitch;
    public String footprintUrl;
    public InterestInsert interestInsert;
    public PlayConfig playConfig;
    public boolean searchIsOpen;
    public String startLiveScheme;
    public long timeoutRefreshTime;

    /* loaded from: classes2.dex */
    public static class AbSwitchConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean newBanner;
        public boolean newTab;
        public boolean otherNewStyle;

        public AbSwitchConfig() {
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

        public static AbSwitchConfig parserJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject != null) {
                    AbSwitchConfig abSwitchConfig = new AbSwitchConfig();
                    abSwitchConfig.newBanner = jSONObject.optInt(SpeedStatsUtils.UBC_VALUE_BANNER) == 1;
                    abSwitchConfig.newTab = jSONObject.optInt("tab") == 1;
                    abSwitchConfig.otherNewStyle = jSONObject.optInt(ImageViewerConfig.FROM_OTHER) == 1;
                    return abSwitchConfig;
                }
                return null;
            }
            return (AbSwitchConfig) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class InterestInsert {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int duration;
        public int frequency;
        public JSONArray tab;

        public InterestInsert() {
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

        public static InterestInsert parserJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject != null) {
                    InterestInsert interestInsert = new InterestInsert();
                    interestInsert.duration = jSONObject.optInt("duration");
                    interestInsert.frequency = jSONObject.optInt("frequency");
                    interestInsert.tab = jSONObject.optJSONArray("tab");
                    return interestInsert;
                }
                return null;
            }
            return (InterestInsert) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class PlayConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean enable;
        public int maxPlayCount;

        public PlayConfig() {
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

        public static PlayConfig parserJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject != null) {
                    PlayConfig playConfig = new PlayConfig();
                    playConfig.enable = jSONObject.optInt("enable") == 1;
                    playConfig.maxPlayCount = jSONObject.optInt("max_auto_play_count");
                    return playConfig;
                }
                return null;
            }
            return (PlayConfig) invokeL.objValue;
        }
    }

    public LiveFeedConfig() {
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

    public void parserJson(JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (jSONObject != null) {
                this.startLiveScheme = jSONObject.optString("start_live_scheme");
                this.timeoutRefreshTime = jSONObject.optLong("timeout_refresh_time");
                this.searchIsOpen = jSONObject.optInt("feed_search_switch") == 1;
                this.playConfig = PlayConfig.parserJson(jSONObject.optJSONObject("auto_play"));
                this.abSwitchConfig = AbSwitchConfig.parserJson(jSONObject.optJSONObject("ab_switch"));
                this.interestInsert = InterestInsert.parserJson(jSONObject.optJSONObject("interest_insert"));
                this.footprintSwitch = jSONObject.optString("watch_history_switch").equals("1");
                this.footprintUrl = jSONObject.optString("watch_history_url");
                if (z && z2) {
                    o80.f(LIVE_FEED_PAGE_CONFIG_CACHE_KEY, jSONObject.toString());
                }
            } else if (z && z2) {
                String b = o80.b(LIVE_FEED_PAGE_CONFIG_CACHE_KEY, "");
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(b);
                    this.startLiveScheme = jSONObject2.optString("start_live_scheme");
                    this.timeoutRefreshTime = jSONObject2.optLong("timeout_refresh_time");
                    this.searchIsOpen = jSONObject2.optInt("feed_search_switch") == 1;
                    this.playConfig = PlayConfig.parserJson(jSONObject2.optJSONObject("auto_play"));
                    this.abSwitchConfig = AbSwitchConfig.parserJson(jSONObject2.optJSONObject("ab_switch"));
                } catch (JSONException unused) {
                    o80.g(LIVE_FEED_PAGE_CONFIG_CACHE_KEY);
                }
            }
        }
    }

    public boolean supportPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PlayConfig playConfig = this.playConfig;
            if (playConfig != null) {
                return playConfig.enable;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
