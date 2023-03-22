package com.baidu.searchbox.updateprocessor;

import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.net.update.ioc.UpdateRuntime;
import com.baidu.searchbox.net.update.v2.CommandListenerRegistry;
import com.baidu.searchbox.net.update.v2.GsonTool;
import com.baidu.searchbox.net.update.v2.IUpdatePostDataFilter;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UpdateCloudControlProcessor implements ICloudControlProcessor {
    public static final String CLOUD_UPDATE_ACTION_NAME = "config";

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, final JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject2.put("version", jSONObject3);
            jSONObject2.put("data", jSONObject4);
            jSONObject2.put(UpdateConstants.POST_DATA_PUBDATA, jSONObject5);
            final List<String> customUpdateBlackList = UpdateRuntime.getUpdateContext().getCustomUpdateBlackList();
            IUpdatePostDataFilter iUpdatePostDataFilter = new IUpdatePostDataFilter() { // from class: com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor.1
                @Override // com.baidu.searchbox.net.update.v2.IUpdatePostDataFilter
                public boolean isNeedFilter(String str2, String str3) {
                    List list = customUpdateBlackList;
                    if (list != null && list.contains(String.format("%s/%s", str2, str3))) {
                        return true;
                    }
                    return CloudControlManager.getInstance().isInDegradeList(jSONObject, str2, str3);
                }
            };
            new CommandListenerRegistry().collectPostData(AppRuntime.getAppContext(), new CommandPostData(jSONObject3, jSONObject4, jSONObject5), iUpdatePostDataFilter);
            return new CloudControlRequestInfo("config", jSONObject3, null, null);
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        String serviceName = cloudControlResponseInfo.getServiceName();
        JSONObject serviceData = cloudControlResponseInfo.getServiceData();
        JSONObject option = cloudControlResponseInfo.getOption();
        if ("config".equals(serviceName) && serviceData != null) {
            try {
                GsonTool gsonTool = new GsonTool(new CommandListenerRegistry());
                gsonTool.readData(new StringReader(serviceData.toString()), 16, option);
                JSONObject reportInfo = gsonTool.getReportInfo();
                if (reportInfo == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray optJSONArray = reportInfo.optJSONArray("detail");
                String optString = reportInfo.optString("totalCount");
                String optString2 = reportInfo.optString("successCount");
                String optString3 = reportInfo.optString("versionFilterCount");
                jSONObject.put("items", optJSONArray);
                jSONObject.put("count", String.format("%s,%s,%s", optString, optString2, optString3));
                iCloudControlUBCCallBack.setServiceInfo(jSONObject);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
