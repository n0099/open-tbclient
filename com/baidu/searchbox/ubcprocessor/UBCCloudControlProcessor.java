package com.baidu.searchbox.ubcprocessor;

import android.text.TextUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.ubc.UBCManager;
import d.a.p0.t;
import d.a.p0.x;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UBCCloudControlProcessor implements ICloudControlProcessor {
    public static final String KEY_STATISTIC_DATA_COUNT = "count";
    public static final String SP_UBC_FILE_NAME = "com.baidu.searchbox_ubc";
    public static final String UBC_CLOUDCONFIG_VERSION = "ubc_cloudconfig_version";
    public static final String UBC_KEY = "ubc";
    public static final String UBC_VERSION_ASC = "version_asc";
    public static final String UBC_VERSION_ASC_DEFAULT = "0";
    public static final String UBC_VERSION_DEFAULT = "0";

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

    public static SharedPrefsWrapper sharedPrefsWrapper() {
        return new SharedPrefsWrapper(SP_UBC_FILE_NAME);
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() != 0) {
            return new CloudControlRequestInfo(UBC_KEY, sharedPrefsWrapper().getString(UBC_CLOUDCONFIG_VERSION, "0"), null, "");
        }
        return null;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, final ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        JSONObject option = cloudControlResponseInfo.getOption();
        JSONObject serviceData = cloudControlResponseInfo.getServiceData();
        if (TextUtils.equals(cloudControlResponseInfo.getServiceName(), UBC_KEY) && serviceData != null) {
            boolean z = !"0".equals(option != null ? option.optString("version_asc") : "0");
            x xVar = new x("", serviceData);
            if (xVar.h()) {
                final String e2 = xVar.e();
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).registerConfig(xVar, z, new t() { // from class: com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor.1
                    @Override // d.a.p0.t
                    public void setUBCConfigStatisticData(JSONObject jSONObject) {
                        ICloudControlUBCCallBack iCloudControlUBCCallBack2;
                        if (jSONObject == null || (iCloudControlUBCCallBack2 = iCloudControlUBCCallBack) == null) {
                            return;
                        }
                        iCloudControlUBCCallBack2.setServiceInfo(jSONObject);
                        if (!UBCCloudControlProcessor.this.checkStatisticData(jSONObject) || TextUtils.isEmpty(e2)) {
                            return;
                        }
                        UBCCloudControlProcessor.sharedPrefsWrapper().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, e2);
                    }
                });
            }
            List<UBCCloudConfigObserver> list = new UBCCloudConfigObservers().mObservers.getList();
            if (list == null || list.isEmpty()) {
                return;
            }
            String jSONObject = serviceData.toString();
            for (UBCCloudConfigObserver uBCCloudConfigObserver : list) {
                try {
                    uBCCloudConfigObserver.onReceiveUbcCloudConfig(jSONObject, option);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
