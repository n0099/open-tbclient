package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
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
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ApsCloudControlProcessor implements ICloudControlProcessor {
    public static String SERVER_APS = "aps";

    public static RequestParams getRegisterParams(String str) {
        IPmsContext pmsContext = PmsRuntime.getPmsContext();
        if (pmsContext == null) {
            return null;
        }
        return pmsContext.getRegisterParams(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processServiceDataInThread(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) {
        ResponseDataProcess responseDataProcess = new ResponseDataProcess();
        if (cloudControlResponseInfo == null) {
            StatisticUtils.sendCloudCtrl("【响应结果】cloudControlResponseInfo  is null", null);
        } else if (!SERVER_APS.equals(cloudControlResponseInfo.getServiceName())) {
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
                    responseDataProcess.process();
                }
            } else if (checkData instanceof RequestTask) {
                responseDataProcess.setResponseInfo(cloudControlResponseInfo);
                responseDataProcess.setChannelList(((RequestTask) checkData).getRequestParams().getChannelList());
                responseDataProcess.process();
            }
            ResponseDataProcess.sendCloudControlUBCData(iCloudControlUBCCallBack, responseDataProcess);
        }
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
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

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(final CloudControlResponseInfo cloudControlResponseInfo, final ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        CommonUtils.postThread(new Runnable() { // from class: com.baidu.searchbox.pms.init.ApsCloudControlProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                ApsCloudControlProcessor.this.processServiceDataInThread(cloudControlResponseInfo, iCloudControlUBCCallBack);
            }
        }, "pms_processServiceData");
    }
}
