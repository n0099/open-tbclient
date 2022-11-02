package com.baidu.live.business.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.LiveFeedAllFollowModel;
import com.baidu.live.business.model.data.LiveFeedFollowLivingData;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.wb0;
import com.baidu.tieba.xb0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \b:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/baidu/live/business/model/LiveFeedAllFollowModel;", "Lcom/baidu/live/business/model/LiveFeedAllFollowModel$OnFollowLivingDataLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "requestFollowLiving", "(Lcom/baidu/live/business/model/LiveFeedAllFollowModel$OnFollowLivingDataLoadCallback;)V", "<init>", "()V", "Companion", "OnFollowLivingDataLoadCallback", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveFeedAllFollowModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String FEED_PAGE_FOLLOW_LIVING = "https://tiebac.baidu.com/livefeed/user/followLivingList";
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/live/business/model/LiveFeedAllFollowModel$OnFollowLivingDataLoadCallback;", "Lkotlin/Any;", "", StatConstants.KEY_EXT_ERR_CODE, "", StatConstants.KEY_EXT_ERR_MSG, "", "onFail", "(ILjava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveFeedFollowLivingData;", "livingData", "onSuccess", "(Lcom/baidu/live/business/model/data/LiveFeedFollowLivingData;)V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnFollowLivingDataLoadCallback {
        void onFail(int i, String str);

        void onSuccess(LiveFeedFollowLivingData liveFeedFollowLivingData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1193885926, "Lcom/baidu/live/business/model/LiveFeedAllFollowModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1193885926, "Lcom/baidu/live/business/model/LiveFeedAllFollowModel;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/live/business/model/LiveFeedAllFollowModel$Companion;", "", "FEED_PAGE_FOLLOW_LIVING", "Ljava/lang/String;", "<init>", "()V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LiveFeedAllFollowModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ void requestFollowLiving$default(LiveFeedAllFollowModel liveFeedAllFollowModel, OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            onFollowLivingDataLoadCallback = null;
        }
        liveFeedAllFollowModel.requestFollowLiving(onFollowLivingDataLoadCallback);
    }

    public final void requestFollowLiving(final OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onFollowLivingDataLoadCallback) == null) {
            xb0.f(FEED_PAGE_FOLLOW_LIVING, new LinkedHashMap(), new wb0<LiveFeedFollowLivingData>(onFollowLivingDataLoadCallback) { // from class: com.baidu.live.business.model.LiveFeedAllFollowModel$requestFollowLiving$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onFollowLivingDataLoadCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$callback = onFollowLivingDataLoadCallback;
                }

                /* renamed from: onNetResponse  reason: avoid collision after fix types in other method */
                public void onNetResponse2(NetResponse netResponse, LiveFeedFollowLivingData liveFeedFollowLivingData, Map<String, String> map, List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, netResponse, liveFeedFollowLivingData, map, list) == null) {
                        if (netResponse != null) {
                            if (netResponse.isSuccessful() && liveFeedFollowLivingData != null) {
                                LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback2 = this.$callback;
                                if (onFollowLivingDataLoadCallback2 != null) {
                                    onFollowLivingDataLoadCallback2.onSuccess(liveFeedFollowLivingData);
                                    return;
                                }
                                return;
                            }
                            LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback3 = this.$callback;
                            if (onFollowLivingDataLoadCallback3 != null) {
                                onFollowLivingDataLoadCallback3.onFail(netResponse.netErrorCode, netResponse.exception);
                                return;
                            }
                            return;
                        }
                        LiveFeedAllFollowModel.OnFollowLivingDataLoadCallback onFollowLivingDataLoadCallback4 = this.$callback;
                        if (onFollowLivingDataLoadCallback4 != null) {
                            onFollowLivingDataLoadCallback4.onFail(-100, "");
                        }
                    }
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.searchbox.live.interfaces.net.NetResponse, java.lang.Object, java.util.Map, java.util.List] */
                @Override // com.baidu.tieba.wb0
                public /* bridge */ /* synthetic */ void onNetResponse(NetResponse netResponse, LiveFeedFollowLivingData liveFeedFollowLivingData, Map map, List list) {
                    onNetResponse2(netResponse, liveFeedFollowLivingData, (Map<String, String>) map, (List<String>) list);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.wb0
                public LiveFeedFollowLivingData onParseResponseInBackground(NetResponse netResponse) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
                        LiveFeedFollowLivingData liveFeedFollowLivingData = new LiveFeedFollowLivingData();
                        if (netResponse != null && !TextUtils.isEmpty(netResponse.decodedResponseStr)) {
                            try {
                                liveFeedFollowLivingData.parserJson(new JSONObject(netResponse.decodedResponseStr));
                            } catch (JSONException e) {
                                LiveFeedPageSdk.liveLog(e.getMessage());
                            }
                        }
                        return liveFeedFollowLivingData;
                    }
                    return (LiveFeedFollowLivingData) invokeL.objValue;
                }
            }, 0, 0, null, new ArrayList());
        }
    }
}
