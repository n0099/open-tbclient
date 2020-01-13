package com.baidu.searchbox.ugc.upload;

import android.text.TextUtils;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.b.b.b;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.digest4util.EncryptUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class HttpRequestTokenModule {
    public static final boolean DEBUG = false;
    private static final String ENCYPT_CONSTANT_STR = "searchbox_2017";
    public static final int HTTP_STATUS_CODE_OK = 200;
    private static final int RESPONSE_NO_ERR = 0;
    private static final String TAG = HttpRequestTokenModule.class.getSimpleName();
    private STSInfo mSTSInfo = new STSInfo();

    /* loaded from: classes12.dex */
    public static class STSInfo {
        public String ak;
        public String bucket;
        public String endpoint;
        public Map<String, BosInfo> map = new HashMap();
        public String sk;
        public String token;

        /* loaded from: classes12.dex */
        public class BosInfo {
            public String bosobject;
            public String key;
            public String url;

            public BosInfo() {
            }
        }
    }

    private Map<String, String> generateRequestTokenParams(List<String> list, boolean z, int i, String str) {
        HashMap hashMap = new HashMap();
        String uk = UgcLoginUtils.getUK();
        String cuid = AppCuidRuntime.getAppCuidManager().getCuid();
        if (TextUtils.isEmpty(uk) || TextUtils.isEmpty(cuid)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        String str2 = "";
        for (String str3 : list) {
            String generateObjectName = generateObjectName(str3, cuid, uk, z);
            if (TextUtils.isEmpty(generateObjectName)) {
                return null;
            }
            jSONArray.put(generateObjectName);
            str2 = str2 + generateObjectName;
            STSInfo sTSInfo = this.mSTSInfo;
            sTSInfo.getClass();
            STSInfo.BosInfo bosInfo = new STSInfo.BosInfo();
            bosInfo.key = generateObjectName;
            this.mSTSInfo.map.put(str3, bosInfo);
        }
        hashMap.put("sign", EncryptUtils.encrypt("MD5", (str2 + ENCYPT_CONSTANT_STR).getBytes(), false));
        if (z) {
            hashMap.put("type", "1");
        } else {
            hashMap.put("type", "0");
        }
        hashMap.put("from", str);
        hashMap.put("oname_list", jSONArray.toString());
        return hashMap;
    }

    public String generateObjectName(String str, String str2, String str3, boolean z) {
        String encrypt = EncryptUtils.encrypt("MD5", str.getBytes(), true);
        if (TextUtils.isEmpty(encrypt)) {
            return null;
        }
        String str4 = "";
        if (!z) {
            str4 = FileUtils.getSuffix(str);
        }
        try {
            return str3 + EncryptUtils.encrypt("MD5", (str2 + encrypt).getBytes(), false) + str4;
        } catch (Exception e) {
            return null;
        }
    }

    public STSInfo requestToken(List<String> list, boolean z, int i, String str) {
        Map<String, String> generateRequestTokenParams = generateRequestTokenParams(list, z, i, str);
        if (generateRequestTokenParams.size() <= 0) {
            return null;
        }
        try {
            STSInfo parseTokenResponse = parseTokenResponse(requestToken(generateRequestTokenParams));
            if (checkIfSTSValid(parseTokenResponse, z)) {
                return parseTokenResponse;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public String requestToken(Map<String, String> map) {
        try {
            ?? cookieManager = ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(b.nk().processUrl(UgcServerApiUtils.getHostAddress() + UgcServerApiUtils.TOKEN_ADDRESS_PATH))).addParams(map).cookieManager((CookieManager) UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false));
            String publisherUserAgent = UgcServerApiUtils.getPublisherUserAgent();
            if (!TextUtils.isEmpty(publisherUserAgent)) {
                cookieManager.addHeader("User-Agent", publisherUserAgent);
            }
            String referer = UgcServerApiUtils.getReferer();
            if (!TextUtils.isEmpty(referer)) {
                cookieManager.addHeader("Referer", referer);
            }
            Response executeSync = cookieManager.build().executeSync();
            if (executeSync == null || executeSync.code() != 200) {
                return null;
            }
            ResponseBody body = executeSync.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string;
        } catch (Exception e) {
            return null;
        }
    }

    public STSInfo parseTokenResponse(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("errno", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.mSTSInfo.ak = optJSONObject.optString("ak");
                this.mSTSInfo.sk = optJSONObject.optString("sk");
                this.mSTSInfo.token = optJSONObject.optString("token");
                this.mSTSInfo.endpoint = optJSONObject.optString("endpoint");
                this.mSTSInfo.bucket = optJSONObject.optString("bucket");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("oname_list");
                if (optJSONObject2 != null && this.mSTSInfo.map != null) {
                    for (STSInfo.BosInfo bosInfo : this.mSTSInfo.map.values()) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject(bosInfo.key);
                        if (optJSONObject3 != null) {
                            bosInfo.url = optJSONObject3.optString("bosurl");
                            bosInfo.bosobject = optJSONObject3.optString("bosobject");
                        }
                    }
                }
                return this.mSTSInfo;
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    private boolean checkIfSTSValid(STSInfo sTSInfo, boolean z) {
        if (sTSInfo != null) {
            if (z) {
                if (!TextUtils.isEmpty(sTSInfo.ak) && !TextUtils.isEmpty(sTSInfo.sk) && !TextUtils.isEmpty(sTSInfo.token)) {
                    return true;
                }
            } else if (!TextUtils.isEmpty(sTSInfo.ak) && !TextUtils.isEmpty(sTSInfo.sk) && !TextUtils.isEmpty(sTSInfo.token) && !TextUtils.isEmpty(sTSInfo.bucket) && sTSInfo.map != null && sTSInfo.map.size() > 0) {
                return true;
            }
        }
        return false;
    }
}
