package com.baidu.searchbox.schemeauthenticate;

import android.content.Context;
import android.util.Log;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.schemeauthenticate.SchemeAuthenticateMonitor;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AuthenticateNetManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_DATA = "data";
    public static final String KEY_ERRNO = "errno";
    public static final String KEY_EXPIRE_TIME = "scheme_timeout";
    public static final String KEY_EXT = "ext";
    public static final String KEY_NAME = "name";
    public static final String KEY_SCHEME_LIST = "scheme_list";
    public static final String KEY_SCHEME_LIST_H5 = "schemeList";
    public static final String KEY_SCHEME_VERSION = "scheme_version";
    public static final String KEY_TAG = "tag";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    public static final String TAG = "AuthenticateNetManager";

    /* loaded from: classes4.dex */
    public interface Authenticatecallback {
        void onFailure();

        void onNoNetwork();

        void onsucess(SiteauthenticateResult siteauthenticateResult);
    }

    /* loaded from: classes4.dex */
    public static class SiteauthenticateResult {
        public String errno;
        public long mExpireTime;
        public String mSchemeList;
        public String mType;
        public String mUrl;

        public long getExpireTime() {
            return this.mExpireTime;
        }

        public String getSchemeList() {
            return this.mSchemeList;
        }

        public String getType() {
            return this.mType;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public String toString() {
            return HttpRetryStatistic.RETRY_URL + this.mUrl + ",schemeList:" + this.mSchemeList + ",expireTime:" + this.mExpireTime;
        }

        public void setExpireTime(long j) {
            this.mExpireTime = j;
        }

        public void setSchemeList(String str) {
            this.mSchemeList = str;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }
    }

    public static void schemeList2Map(String str, Map<String, String> map) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            map.put(jSONObject.getString("name"), jSONObject.getString("tag"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SiteauthenticateResult parseSiteAuthenticateInfo(String str) throws Exception {
        if (DEBUG) {
            String str2 = TAG;
            Log.i(str2, "parseSiteAuthenticateInfo reponse:" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt("errno");
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            String string = jSONObject2.getString("scheme_list");
            long j = jSONObject2.getLong(KEY_EXPIRE_TIME);
            SiteauthenticateResult siteauthenticateResult = new SiteauthenticateResult();
            siteauthenticateResult.setSchemeList(string);
            siteauthenticateResult.setExpireTime(System.currentTimeMillis() + (j * 1000));
            return siteauthenticateResult;
        } catch (Exception e) {
            throw e;
        }
    }

    public static SchemeAuthenticateMonitor.SiteAuthenticateInfo siteauthenticateResult2SiteAuthenticateInfo(SiteauthenticateResult siteauthenticateResult) {
        SchemeAuthenticateMonitor.SiteAuthenticateInfo siteAuthenticateInfo = new SchemeAuthenticateMonitor.SiteAuthenticateInfo();
        String schemeList = siteauthenticateResult.getSchemeList();
        HashMap hashMap = new HashMap();
        try {
            schemeList2Map(schemeList, hashMap);
            siteAuthenticateInfo.setSchemeList(hashMap);
            siteAuthenticateInfo.setExpireTime(siteauthenticateResult.getExpireTime());
            siteAuthenticateInfo.setType(siteauthenticateResult.getType());
            siteAuthenticateInfo.setUrl(siteauthenticateResult.getUrl());
        } catch (Exception e) {
            if (DEBUG) {
                String str = TAG;
                Log.i(str, "result2Info exception:" + e);
            }
        }
        return siteAuthenticateInfo;
    }

    public final void authenticateConfig(Context context, final String str, JSONObject jSONObject, final Authenticatecallback authenticatecallback) {
        String appendParam = BaiduIdentityManager.getInstance().appendParam(SchemeAuthConfigUrl.getAuthenticateUrl(), 1);
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = new JSONObject();
        final String str2 = null;
        try {
            jSONObject2.put(KEY_SCHEME_VERSION, PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW);
            jSONObject2.put("url", str);
            jSONObject2.put("ext", jSONObject.getJSONObject("ext"));
            jSONObject2.put("scheme_list", jSONObject.getJSONArray("schemeList"));
            str2 = jSONObject.getString("type");
            jSONObject2.put("type", str2);
        } catch (Exception e) {
            if (DEBUG) {
                String str3 = TAG;
                Log.e(str3, "autherticate e:" + e);
            }
        }
        if (DEBUG) {
            String str4 = TAG;
            Log.i(str4, "authenticate paramJson:" + jSONObject2.toString());
        }
        hashMap.put("data", jSONObject2.toString());
        ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(context).postFormRequest().url(appendParam)).addParams(hashMap).build().executeAsyncOnUIBack(new ResponseCallback<SiteauthenticateResult>() { // from class: com.baidu.searchbox.schemeauthenticate.AuthenticateNetManager.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Authenticatecallback authenticatecallback2 = authenticatecallback;
                if (authenticatecallback2 != null) {
                    authenticatecallback2.onFailure();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(SiteauthenticateResult siteauthenticateResult, int i) {
                if (authenticatecallback != null) {
                    if (siteauthenticateResult != null) {
                        siteauthenticateResult.setType(str2);
                        siteauthenticateResult.setUrl(str);
                    }
                    authenticatecallback.onsucess(siteauthenticateResult);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public SiteauthenticateResult parseResponse(Response response, int i) {
                if (response != null && response.body() != null) {
                    try {
                        return AuthenticateNetManager.this.parseSiteAuthenticateInfo(response.body().string());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
        });
    }
}
