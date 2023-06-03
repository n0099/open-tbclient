package com.baidu.searchbox.downloads.filter;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.HashMap;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ApkDownloadFilter implements DownloadFilter {
    public static final String FILTER_SERVER = "/searchbox?action=capable&cmd=174";
    public static final String POST_TAG_DATA = "data";
    public static final String POST_TAG_FILE = "file";
    public static final String POST_TAG_URL = "url";
    public static final String RESPONSE_TAG_ERRNO = "errno";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = ApkDownloadFilter.class.getSimpleName();

    @Override // com.baidu.searchbox.downloads.filter.DownloadFilter
    public boolean filter(Object obj) {
        String string;
        if (!(obj instanceof DownloadDataInfo)) {
            return false;
        }
        String appendParam = BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).appendParam(HostConfig.getSearchboxHostForHttps() + FILTER_SERVER, 1);
        if (DEBUG) {
            String str = TAG;
            Log.d(str, "DownloadFitler Request URL: " + appendParam);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", ((DownloadDataInfo) obj).url);
            jSONObject.put("file", ((DownloadDataInfo) obj).filename);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w(TAG, Log.getStackTraceString(e));
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", jSONObject.toString());
        try {
            Response executeSync = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(appendParam)).params(hashMap).enableStat(true)).requestFrom(10)).requestSubFrom(1022)).build().executeSync();
            if (DEBUG) {
                String str2 = TAG;
                Log.d(str2, "Request Download Filter, Response = " + executeSync);
            }
            if (executeSync != null) {
                if (executeSync.body() == null) {
                    string = "";
                } else {
                    string = executeSync.body().string();
                }
                return !TextUtils.equals(new JSONObject(string).getString("errno"), "0");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
