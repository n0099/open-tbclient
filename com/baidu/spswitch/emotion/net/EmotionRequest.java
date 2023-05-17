package com.baidu.spswitch.emotion.net;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionCommonParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import okhttp3.Response;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class EmotionRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EmotionRequest() {
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

    public static void getEmoIdList(String str, EmotionRequestCallback emotionRequestCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, emotionRequestCallback) == null) {
            if (TextUtils.isEmpty(str)) {
                if (emotionRequestCallback != null) {
                    emotionRequestCallback.onFailure(null);
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("nid", str);
            String processUrl = InteractionCommonParamManager.processUrl(EmotionUrlConfig.getEmoIdList());
            ResponseCallback<String> responseCallback = new ResponseCallback<String>(emotionRequestCallback) { // from class: com.baidu.spswitch.emotion.net.EmotionRequest.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionRequestCallback val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {emotionRequestCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = emotionRequestCallback;
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    EmotionRequestCallback emotionRequestCallback2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) && (emotionRequestCallback2 = this.val$listener) != null) {
                        emotionRequestCallback2.onFailure(exc.getMessage());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str2, int i) {
                    EmotionRequestCallback emotionRequestCallback2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str2, i) == null) && (emotionRequestCallback2 = this.val$listener) != null) {
                        emotionRequestCallback2.onSuccess(str2, i);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public String parseResponse(Response response, int i) throws Exception {
                    InterceptResult invokeLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048580, this, response, i)) == null) {
                        if (response != null && response.body() != null) {
                            return response.body().string();
                        }
                        return null;
                    }
                    return (String) invokeLI.objValue;
                }
            };
            if (NetWorkUtils.isConnected(AppRuntime.getAppContext())) {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(processUrl)).tag(EmotionUrlConfig.EMO_ID_LIST_TAG)).addParams(hashMap).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, false))).build().executeAsyncOnUIBack(responseCallback);
            } else if (emotionRequestCallback != null) {
                emotionRequestCallback.onFailure(null);
            }
        }
    }

    public static void getEmoList(List<String> list, EmotionRequestCallback emotionRequestCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, list, emotionRequestCallback) == null) {
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put(MapBundleKey.MapObjKey.OBJ_BID, jSONArray.toString());
                String processUrl = InteractionCommonParamManager.processUrl(EmotionUrlConfig.getEmoList());
                ResponseCallback<String> responseCallback = new ResponseCallback<String>(emotionRequestCallback) { // from class: com.baidu.spswitch.emotion.net.EmotionRequest.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionRequestCallback val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {emotionRequestCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = emotionRequestCallback;
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        EmotionRequestCallback emotionRequestCallback2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) && (emotionRequestCallback2 = this.val$listener) != null) {
                            emotionRequestCallback2.onFailure(exc.getMessage());
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onSuccess(String str2, int i) {
                        EmotionRequestCallback emotionRequestCallback2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str2, i) == null) && (emotionRequestCallback2 = this.val$listener) != null) {
                            emotionRequestCallback2.onSuccess(str2, i);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public String parseResponse(Response response, int i) throws Exception {
                        InterceptResult invokeLI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048580, this, response, i)) == null) {
                            if (response != null && response.body() != null) {
                                return response.body().string();
                            }
                            return null;
                        }
                        return (String) invokeLI.objValue;
                    }
                };
                if (NetWorkUtils.isConnected(AppRuntime.getAppContext())) {
                    ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(processUrl)).params(hashMap).tag(EmotionUrlConfig.EMO_LIST_TAG)).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, false))).build().executeAsyncOnUIBack(responseCallback);
                } else if (emotionRequestCallback != null) {
                    emotionRequestCallback.onFailure(null);
                }
            } else if (emotionRequestCallback != null) {
                emotionRequestCallback.onFailure(null);
            }
        }
    }
}
