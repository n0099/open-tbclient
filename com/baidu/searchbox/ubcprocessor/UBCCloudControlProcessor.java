package com.baidu.searchbox.ubcprocessor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.g2b;
import com.baidu.tieba.k2b;
import com.baidu.ubc.UBCManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UBCCloudControlProcessor implements ICloudControlProcessor {
    public static final String KEY_STATISTIC_DATA_COUNT = "count";
    public static final String KEY_UBC_APP_VERSION = "ubc_app_version";
    public static final String SP_UBC_FILE_NAME = "com.baidu.searchbox_ubc";
    public static final String TAG = "UBCCloudProcessor";
    public static final String UBC_APP_VERSION_DEFAULT = "0";
    public static final String UBC_CLOUDCONFIG_VERSION = "ubc_cloudconfig_version";
    public static final String UBC_KEY = "ubc";
    public static final String UBC_VERSION_ASC = "version_asc";
    public static final String UBC_VERSION_ASC_DEFAULT = "0";
    public static final String UBC_VERSION_DEFAULT = "0";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static boolean sCheckedAppVersion = false;

    public UBCCloudControlProcessor() {
        checkAppVersion();
    }

    public static /* synthetic */ SharedPrefsWrapper access$100() {
        return sharedPrefsWrapper();
    }

    private JSONObject generateFailStatisticData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("items", new JSONArray());
            jSONObject.put("count", "0,0,0");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static SharedPrefsWrapper sharedPrefsWrapper() {
        return new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences(SP_UBC_FILE_NAME));
    }

    private void checkAppVersion() {
        PackageInfo packageInfo;
        if (sCheckedAppVersion) {
            return;
        }
        String str = "";
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean z = false;
        try {
            packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (packageInfo == null) {
            return;
        }
        str = packageInfo.versionName;
        String string = sharedPrefsWrapper().getString(KEY_UBC_APP_VERSION, "0");
        if (DEBUG) {
            Log.d(TAG, "current version: " + str + ", oldVersion: " + string);
        }
        z = !TextUtils.equals(str, string);
        if (z) {
            sharedPrefsWrapper().putString(UBC_CLOUDCONFIG_VERSION, "0");
            sharedPrefsWrapper().putString(KEY_UBC_APP_VERSION, str);
            if (DEBUG) {
                Log.d(TAG, "reset step: 0, save app version: " + str);
            }
        }
        sCheckedAppVersion = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkStatisticData(JSONObject jSONObject) {
        String[] split;
        if (jSONObject != null && jSONObject.length() != 0) {
            String optString = jSONObject.optString("count");
            if (!TextUtils.isEmpty(optString) && (split = optString.split(",")) != null && split.length == 3) {
                try {
                    if (Integer.parseInt(split[0]) == Integer.parseInt(split[1]) + Integer.parseInt(split[2])) {
                        return true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() == 0) {
            return null;
        }
        return new CloudControlRequestInfo("ubc", sharedPrefsWrapper().getString(UBC_CLOUDCONFIG_VERSION, "0"), null, "");
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, final ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        String str;
        JSONObject option = cloudControlResponseInfo.getOption();
        JSONObject serviceData = cloudControlResponseInfo.getServiceData();
        if (!TextUtils.equals(cloudControlResponseInfo.getServiceName(), "ubc") || serviceData == null) {
            return;
        }
        if (option == null) {
            str = "0";
        } else {
            str = option.optString("version_asc");
        }
        boolean z = !"0".equals(str);
        k2b k2bVar = new k2b("", serviceData);
        if (k2bVar.l()) {
            final String g = k2bVar.g();
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).registerConfig(k2bVar, z, new g2b() { // from class: com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor.1
                @Override // com.baidu.tieba.g2b
                public void setUBCConfigStatisticData(JSONObject jSONObject) {
                    ICloudControlUBCCallBack iCloudControlUBCCallBack2;
                    if (jSONObject != null && (iCloudControlUBCCallBack2 = iCloudControlUBCCallBack) != null) {
                        iCloudControlUBCCallBack2.setServiceInfo(jSONObject);
                        if (UBCCloudControlProcessor.this.checkStatisticData(jSONObject) && !TextUtils.isEmpty(g)) {
                            UBCCloudControlProcessor.access$100().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, g);
                        }
                    }
                }
            });
        } else if (iCloudControlUBCCallBack != null) {
            iCloudControlUBCCallBack.setServiceInfo(generateFailStatisticData());
        }
        List<UBCCloudConfigObserver> list = new UBCCloudConfigObservers().mObservers.getList();
        if (list != null && !list.isEmpty()) {
            String jSONObject = serviceData.toString();
            for (UBCCloudConfigObserver uBCCloudConfigObserver : list) {
                try {
                    uBCCloudConfigObserver.onReceiveUbcCloudConfig(jSONObject, option);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
