package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AbstractService implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10510a = "3";
    public SapiConfiguration configuration;
    public String versionName;

    public AbstractService(SapiConfiguration sapiConfiguration, String str) {
        this.configuration = sapiConfiguration;
        this.versionName = str;
    }

    public HttpHashMapWrap buildSapiParams(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put("sdk_version", "3");
        return httpHashMapWrap;
    }

    public void cancelRequest(HttpClientWrap httpClientWrap) {
        if (httpClientWrap != null) {
            httpClientWrap.cancelRequest();
        }
    }

    public int getErrorCode(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e2) {
            Log.e(e2);
            return -100;
        }
    }

    public String getErrorMsg(String str) {
        try {
            return new JSONObject(str).optString("errmsg");
        } catch (Exception e2) {
            Log.e(e2);
            return "网络连接失败，请检查网络设置";
        }
    }

    public String getUaInfo() {
        return "tpl:" + this.configuration.tpl + ";android_sapi_v" + this.versionName;
    }

    public SapiAccount parseAccount(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.ptoken = jSONObject.optString(SapiAccount.f10606h);
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }
}
