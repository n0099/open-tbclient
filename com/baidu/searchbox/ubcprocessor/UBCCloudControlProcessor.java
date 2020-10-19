package com.baidu.searchbox.ubcprocessor;

import android.text.TextUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.ubc.aa;
import com.baidu.ubc.s;
import com.baidu.ubc.v;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class UBCCloudControlProcessor implements ICloudControlProcessor {
    private static final String SP_UBC_FILE_NAME = "com.baidu.searchbox_ubc";
    static final String UBC_CLOUDCONFIG_VERSION = "ubc_cloudconfig_version";
    private static final String UBC_KEY = "ubc";
    private static final String UBC_VERSION_ASC = "version_asc";
    private static final String UBC_VERSION_ASC_DEFAULT = "0";
    private static final String UBC_VERSION_DEFAULT = "0";

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, final ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        JSONObject option = cloudControlResponseInfo.getOption();
        JSONObject serviceData = cloudControlResponseInfo.getServiceData();
        if (TextUtils.equals(cloudControlResponseInfo.getServiceName(), UBC_KEY) && serviceData != null) {
            String str = "0";
            if (option != null) {
                str = option.optString(UBC_VERSION_ASC);
            }
            boolean z = !"0".equals(str);
            v vVar = new v("", serviceData);
            vVar.aZC();
            ((aa) c.a(aa.SERVICE_REFERENCE)).b(vVar, z, new s() { // from class: com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor.1
                @Override // com.baidu.ubc.s
                public void setUBCConfigStatisticData(JSONObject jSONObject) {
                    if (jSONObject != null && iCloudControlUBCCallBack != null) {
                        iCloudControlUBCCallBack.setServiceInfo(jSONObject);
                    }
                }
            });
            String dTN = vVar.dTN();
            if (!TextUtils.isEmpty(dTN)) {
                sharedPrefsWrapper().putString(UBC_CLOUDCONFIG_VERSION, dTN);
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

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() != 0) {
            return new CloudControlRequestInfo(UBC_KEY, sharedPrefsWrapper().getString(UBC_CLOUDCONFIG_VERSION, "0"), null, "");
        }
        return null;
    }

    private static SharedPrefsWrapper sharedPrefsWrapper() {
        return new SharedPrefsWrapper(SP_UBC_FILE_NAME);
    }
}
