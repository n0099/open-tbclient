package com.baidu.searchbox.wordscommand.util;

import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.Map;
/* loaded from: classes4.dex */
public class WordCommandNetRequest {
    public static final int CONNECTION_TIME_OUT = 3000;

    /* JADX WARN: Type inference failed for: r2v2, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void makePostRequest(String str, Map<String, String> map, ResponseCallback responseCallback) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().params(map).connectionTimeout(3000)).enableStat(true)).requestFrom(10)).requestSubFrom(1009)).url(CommonUrlParamManager.getInstance().appendParam(str, 1)).build().executeAsyncOnUIBack(responseCallback);
    }
}
