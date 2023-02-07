package com.baidu.searchbox.retrieve.timer;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimerCancel;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimerCancelBean;
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
public class FetchTimerCancelJob extends IFetchJob {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FetchTimerCancelJob";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Constants.FetchType.FETCH_TIMER_CANCEL_TYPE : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-385132058, "Lcom/baidu/searchbox/retrieve/timer/FetchTimerCancelJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-385132058, "Lcom/baidu/searchbox/retrieve/timer/FetchTimerCancelJob;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchTimerCancelJob() {
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

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchTimerCancelBean parseJsonContent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || (parseJsonContent = FetchTimerCancel.parseJsonContent(jSONObject)) == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "日志回捞收到取消命令 " + jSONObject);
        }
        String cancelJobId = parseJsonContent.getCancelJobId();
        if (FetchTimerList.getInstance().hasJob(cancelJobId)) {
            if (DEBUG) {
                Log.i(TAG, "周期性定时回捞任务取消 ：" + cancelJobId);
            }
            FetchTimerList.getInstance().removeJob(cancelJobId);
            FetchTaskManager.getInstance().removeOriginTimerData(cancelJobId);
        }
        ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskDone(parseJsonContent.getType(), parseJsonContent.getJobId(), parseJsonContent.getVersion(), "0", "", "");
    }
}
