package com.baidu.searchbox.updateprocessor;

import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class UpdateCloudControlProcessor implements ICloudControlProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLOUD_UPDATE_ACTION_NAME = "config";
    public transient /* synthetic */ FieldHolder $fh;

    public UpdateCloudControlProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), jSONObject})) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject2.put("version", jSONObject3);
                jSONObject2.put("data", jSONObject4);
                jSONObject2.put(UpdateConstants.POST_DATA_PUBDATA, jSONObject5);
                new CommandListenerRegistry().collectPostData(AppRuntime.getAppContext(), new CommandPostData(jSONObject3, jSONObject4, jSONObject5), new IUpdatePostDataFilter(this, UpdateRuntime.getUpdateContext().getCustomUpdateBlackList(), jSONObject) { // from class: com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UpdateCloudControlProcessor this$0;
                    public final /* synthetic */ List val$customUpdateBlackList;
                    public final /* synthetic */ JSONObject val$degradeJsonObject;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, jSONObject};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$customUpdateBlackList = r7;
                        this.val$degradeJsonObject = jSONObject;
                    }

                    @Override // com.baidu.searchbox.net.update.v2.IUpdatePostDataFilter
                    public boolean isNeedFilter(String str2, String str3) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str2, str3)) == null) {
                            List list = this.val$customUpdateBlackList;
                            if (list == null || !list.contains(String.format("%s/%s", str2, str3))) {
                                return CloudControlManager.getInstance().isInDegradeList(this.val$degradeJsonObject, str2, str3);
                            }
                            return true;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                return new CloudControlRequestInfo(CLOUD_UPDATE_ACTION_NAME, jSONObject3, null, null);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (CloudControlRequestInfo) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudControlResponseInfo, iCloudControlUBCCallBack) == null) {
            String serviceName = cloudControlResponseInfo.getServiceName();
            JSONObject serviceData = cloudControlResponseInfo.getServiceData();
            JSONObject option = cloudControlResponseInfo.getOption();
            if (!CLOUD_UPDATE_ACTION_NAME.equals(serviceName) || serviceData == null) {
                return;
            }
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
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
