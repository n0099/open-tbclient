package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class AbstractService implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4785a = "3";
    protected SapiConfiguration configuration;
    protected String versionName;

    public AbstractService(SapiConfiguration sapiConfiguration, String str) {
        this.configuration = sapiConfiguration;
        this.versionName = str;
    }

    protected HttpHashMapWrap buildSapiParams(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put(SapiContext.KEY_SDK_VERSION, "3");
        return httpHashMapWrap;
    }

    protected void cancelRequest(HttpClientWrap httpClientWrap) {
        if (httpClientWrap != null) {
            httpClientWrap.cancelRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getErrorCode(String str) {
        try {
            return new JSONObject(str).getInt(BaseJsonData.TAG_ERRNO);
        } catch (Exception e) {
            Log.e(e);
            return -100;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getErrorMsg(String str) {
        try {
            return new JSONObject(str).optString(BaseJsonData.TAG_ERRMSG);
        } catch (Exception e) {
            Log.e(e);
            return "网络连接失败，请检查网络设置";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getUaInfo() {
        return "tpl:" + this.configuration.tpl + ";android_sapi_v" + this.versionName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SapiAccount parseAccount(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
        sapiAccount.username = jSONObject.optString(BdStatsConstant.StatsKey.UNAME);
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.ptoken = jSONObject.optString("ptoken");
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }
}
