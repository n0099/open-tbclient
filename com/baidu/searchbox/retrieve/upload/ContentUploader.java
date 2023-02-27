package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class ContentUploader extends BaseContentUploader {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchContentUploader";

    @Override // com.baidu.searchbox.retrieve.upload.BaseContentUploader
    public void uploadDataRequestASync(String str, String str2, Map<String, String> map, ResponseCallback<JSONObject> responseCallback) {
        PostFormRequest.PostFormRequestBuilder postFormRequest = HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest();
        postFormRequest.url(getUploadUrl(str));
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                postFormRequest.addHeader(entry.getKey(), entry.getValue());
            }
        }
        postFormRequest.addParam("req", str2);
        postFormRequest.cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, true));
        postFormRequest.build().executeAsync(responseCallback);
    }
}
