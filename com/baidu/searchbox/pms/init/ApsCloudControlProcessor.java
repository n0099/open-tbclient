package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.PmsRuntime;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.request.RequestDataUtils;
import com.baidu.searchbox.pms.init.request.RequestTask;
import com.baidu.searchbox.pms.init.response.ResponseDataProcess;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.searchbox.pms.utils.StatisticUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ApsCloudControlProcessor implements ICloudControlProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SERVER_APS = "aps";
    public static final String SERVER_DPM = "dpm";
    public transient /* synthetic */ FieldHolder $fh;
    public String serviceName;

    public ApsCloudControlProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.serviceName = "aps";
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), jSONObject})) == null) {
            RequestParams registerParams = getRegisterParams(str);
            if (registerParams == null) {
                DebugUtils.log("requestParams is empty runType:", str);
                return null;
            }
            String checkParamsWithMsg = RequestDataUtils.checkParamsWithMsg(registerParams);
            if (!TextUtils.isEmpty(checkParamsWithMsg)) {
                ResponseDataProcess.dispatchFetchError(new ErrorInfo(2102, checkParamsWithMsg), registerParams.getChannelList());
                return null;
            }
            CloudControlRequestInfo createPostData = new RequestTask(registerParams).createPostData();
            if (createPostData == null) {
                DebugUtils.log("requestInfo is empty");
                return null;
            }
            return createPostData;
        }
        return (CloudControlRequestInfo) invokeCommon.objValue;
    }

    public RequestParams getRegisterParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            IPmsContext pmsContext = PmsRuntime.getPmsContext();
            if (pmsContext == null) {
                return null;
            }
            return pmsContext.getRegisterParams(str, this.serviceName);
        }
        return (RequestParams) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cloudControlResponseInfo, iCloudControlUBCCallBack) == null) {
            CommonUtils.postThread(new Runnable(this, cloudControlResponseInfo, iCloudControlUBCCallBack) { // from class: com.baidu.searchbox.pms.init.ApsCloudControlProcessor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ApsCloudControlProcessor this$0;
                public final /* synthetic */ CloudControlResponseInfo val$cloudControlResponseInfo;
                public final /* synthetic */ ICloudControlUBCCallBack val$cloudControlUBCCallBack;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cloudControlResponseInfo, iCloudControlUBCCallBack};
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
                    this.val$cloudControlResponseInfo = cloudControlResponseInfo;
                    this.val$cloudControlUBCCallBack = iCloudControlUBCCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.processServiceDataInThread(this.val$cloudControlResponseInfo, this.val$cloudControlUBCCallBack);
                    }
                }
            }, "pms_processServiceData");
        }
    }

    public void processServiceDataInThread(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cloudControlResponseInfo, iCloudControlUBCCallBack) == null) {
            ResponseDataProcess responseDataProcess = new ResponseDataProcess();
            if (cloudControlResponseInfo == null) {
                StatisticUtils.sendCloudCtrl("【响应结果】cloudControlResponseInfo  is null", null);
            } else if (!this.serviceName.equals(cloudControlResponseInfo.getServiceName())) {
                StatisticUtils.sendCloudCtrl("【响应结果】ServiceName err: " + cloudControlResponseInfo.getServiceName(), null);
            } else {
                Object checkData = cloudControlResponseInfo.getCheckData();
                if (checkData == null) {
                    IPmsContext pmsContext = PmsRuntime.getPmsContext();
                    if (pmsContext == null) {
                        return;
                    }
                    List<RequestParams.Channel> longConnectParams = pmsContext.getLongConnectParams();
                    if (longConnectParams != null && longConnectParams.size() > 0) {
                        responseDataProcess.setResponseInfo(cloudControlResponseInfo);
                        responseDataProcess.setChannelList(longConnectParams);
                        responseDataProcess.process(this.serviceName);
                    }
                } else if (checkData instanceof RequestTask) {
                    responseDataProcess.setResponseInfo(cloudControlResponseInfo);
                    responseDataProcess.setChannelList(((RequestTask) checkData).getRequestParams().getChannelList());
                    responseDataProcess.process(this.serviceName);
                }
                ResponseDataProcess.sendCloudControlUBCData(iCloudControlUBCCallBack, responseDataProcess);
            }
        }
    }

    public ApsCloudControlProcessor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.serviceName = "aps";
        this.serviceName = str;
    }
}
