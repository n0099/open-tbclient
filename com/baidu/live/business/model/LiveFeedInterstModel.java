package com.baidu.live.business.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tieba.xb0;
import com.baidu.tieba.yb0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedInterstModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FEED_PAGE_INTEREST_URL = "https://tiebac.baidu.com/livefeed/interest";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface OnInterestDataLoadCallback {
        void onFail(int i, String str, Map map);

        void onSuccess(LiveFeedData liveFeedData, Map map);
    }

    public LiveFeedInterstModel() {
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

    public void reqInterestData(String str, String str2, String str3, OnInterestDataLoadCallback onInterestDataLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, onInterestDataLoadCallback) == null) {
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = "";
            }
            hashMap.put("session_id", str);
            hashMap.put("live_tag", str2);
            hashMap.put("feed_tag", str3);
            yb0.f(FEED_PAGE_INTEREST_URL, hashMap, new xb0(this, onInterestDataLoadCallback) { // from class: com.baidu.live.business.model.LiveFeedInterstModel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveFeedInterstModel this$0;
                public final /* synthetic */ OnInterestDataLoadCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onInterestDataLoadCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = onInterestDataLoadCallback;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.xb0
                public void onNetResponse(NetResponse netResponse, LiveFeedData liveFeedData, Map map, List list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, netResponse, liveFeedData, map, list) == null) {
                        if (netResponse != null) {
                            if (netResponse.isSuccessful() && liveFeedData != null) {
                                OnInterestDataLoadCallback onInterestDataLoadCallback2 = this.val$callback;
                                if (onInterestDataLoadCallback2 != null) {
                                    onInterestDataLoadCallback2.onSuccess(liveFeedData, map);
                                    return;
                                }
                                return;
                            }
                            OnInterestDataLoadCallback onInterestDataLoadCallback3 = this.val$callback;
                            if (onInterestDataLoadCallback3 != null) {
                                onInterestDataLoadCallback3.onFail(netResponse.netErrorCode, netResponse.exception, map);
                                return;
                            }
                            return;
                        }
                        OnInterestDataLoadCallback onInterestDataLoadCallback4 = this.val$callback;
                        if (onInterestDataLoadCallback4 != null) {
                            onInterestDataLoadCallback4.onFail(-100, "网络不给力，请稍后重试", map);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.xb0
                public LiveFeedData onParseResponseInBackground(NetResponse netResponse) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
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
                    return (LiveFeedData) invokeL.objValue;
                }
            }, 0, 0, null, new ArrayList());
        }
    }
}
