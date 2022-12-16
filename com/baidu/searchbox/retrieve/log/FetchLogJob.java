package com.baidu.searchbox.retrieve.log;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.retrieve.log.bean.FetchLogBean;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class FetchLogJob extends IFetchJob {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FetchLogJob";
    public static final String UPLOAD_WIFI_TYPE = "1";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "flow" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1195066924, "Lcom/baidu/searchbox/retrieve/log/FetchLogJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1195066924, "Lcom/baidu/searchbox/retrieve/log/FetchLogJob;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchLogJob() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void statDispatchData(boolean z, FetchLogBean fetchLogBean, String str) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), fetchLogBean, str}) == null) && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
            iStatTask.recordDispatchRetrieveData(z, fetchLogBean.getJobId(), fetchLogBean.getType(), fetchLogBean.getVersion(), str);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchLogBean parseJsonContent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || (parseJsonContent = FetchLog.parseJsonContent(jSONObject)) == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "日志回捞收到命令 " + jSONObject);
        }
        if ("1".equals(parseJsonContent.getNetwork()) && !NetWorkUtils.NetType.WIFI.equals(NetWorkUtils.getNetworkType())) {
            statDispatchData(false, parseJsonContent, "2");
            return;
        }
        statDispatchData(true, parseJsonContent, "");
        ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).fetchUpload(parseJsonContent.getType(), parseJsonContent.getJobId(), parseJsonContent.getVersion(), parseJsonContent.getMaxSizeLimit(), parseJsonContent.getStartTime(), parseJsonContent.getEndTime(), parseJsonContent.getSpace());
    }
}
