package com.baidu.searchbox.ugc.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.utils.UgcConfigUrl;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UgcTagDisplayModel implements Serializable {
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = UgcTagDisplayModel.class.getSimpleName();
    public String tagName;
    public String tagNum;
    public String tagScheme;

    /* loaded from: classes11.dex */
    public interface UgcTagRequestCallback {
        void onFailed(String str);

        void onSuccess(UgcTagDisplayModel ugcTagDisplayModel);
    }

    public void displayUgcTag(final UgcTagRequestCallback ugcTagRequestCallback) {
        try {
            String processUrl = UgcRuntime.getUgcInterface().processUrl(UgcConfigUrl.getUgcTagUrl());
            if (!TextUtils.isEmpty(processUrl)) {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(processUrl)).addParam("data", generateRequestParams()).cookieManager((CookieManager) UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false))).build().executeAsyncOnUIBack(new StringResponseCallback() { // from class: com.baidu.searchbox.ugc.model.UgcTagDisplayModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onSuccess(String str, int i) {
                        String str2 = null;
                        if (UgcTagDisplayModel.DEBUG) {
                            Log.d(UgcTagDisplayModel.TAG, "onSuccess: " + str + ", statusCode = " + i);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (TextUtils.equals(jSONObject.optString("errno"), "0")) {
                                UgcTagDisplayModel parseTagDisplayResponse = UgcTagDisplayModel.this.parseTagDisplayResponse(jSONObject);
                                if (parseTagDisplayResponse != null) {
                                    ugcTagRequestCallback.onSuccess(parseTagDisplayResponse);
                                    return;
                                }
                                ugcTagRequestCallback.onFailed(null);
                            } else {
                                str2 = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                            }
                        } catch (Exception e) {
                            if (UgcTagDisplayModel.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                        if (ugcTagRequestCallback != null) {
                            ugcTagRequestCallback.onFailed(str2);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (UgcTagDisplayModel.DEBUG && exc != null) {
                            Log.d(UgcTagDisplayModel.TAG, "onFail: " + exc.getMessage());
                        }
                        if (ugcTagRequestCallback != null) {
                            ugcTagRequestCallback.onFailed(null);
                        }
                    }
                });
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            if (ugcTagRequestCallback != null) {
                ugcTagRequestCallback.onFailed(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UgcTagDisplayModel parseTagDisplayResponse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (jSONObject == null || jSONObject.optJSONObject("data") == null || (optJSONObject = jSONObject.optJSONObject("data").optJSONObject("603")) == null || (optJSONObject2 = optJSONObject.optJSONObject("ugctag")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("data")) == null) {
            return null;
        }
        UgcTagDisplayModel ugcTagDisplayModel = new UgcTagDisplayModel();
        ugcTagDisplayModel.tagName = optJSONObject3.optString("tag_name");
        ugcTagDisplayModel.tagNum = optJSONObject3.optString("tag_num");
        ugcTagDisplayModel.tagScheme = optJSONObject3.optString("tag_schema");
        return ugcTagDisplayModel;
    }

    private String generateRequestParams() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject2.put("ugctag", "0");
            jSONObject.put("sign", jSONObject2);
            jSONObject4.put("resource_params", jSONObject3);
            jSONObject.put("params", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
