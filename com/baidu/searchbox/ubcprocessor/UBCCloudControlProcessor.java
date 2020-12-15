package com.baidu.searchbox.ubcprocessor;

import android.text.TextUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.ubc.ab;
import com.baidu.ubc.s;
import com.baidu.ubc.w;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class UBCCloudControlProcessor implements ICloudControlProcessor {
    private static final String KEY_STATISTIC_DATA_COUNT = "count";
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
            w wVar = new w("", serviceData);
            if (wVar.bgt()) {
                final String eiW = wVar.eiW();
                ((ab) c.a(ab.SERVICE_REFERENCE)).b(wVar, z, new s() { // from class: com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor.1
                    @Override // com.baidu.ubc.s
                    public void setUBCConfigStatisticData(JSONObject jSONObject) {
                        if (jSONObject != null && iCloudControlUBCCallBack != null) {
                            iCloudControlUBCCallBack.setServiceInfo(jSONObject);
                            if (UBCCloudControlProcessor.this.checkStatisticData(jSONObject) && !TextUtils.isEmpty(eiW)) {
                                UBCCloudControlProcessor.sharedPrefsWrapper().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, eiW);
                            }
                        }
                    }
                });
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

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPrefsWrapper sharedPrefsWrapper() {
        return new SharedPrefsWrapper(SP_UBC_FILE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkStatisticData(JSONObject jSONObject) {
        String[] split;
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        String optString = jSONObject.optString("count");
        if (TextUtils.isEmpty(optString) || (split = optString.split(",")) == null || split.length != 3) {
            return false;
        }
        try {
            return Integer.parseInt(split[0]) == Integer.parseInt(split[2]) + Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
