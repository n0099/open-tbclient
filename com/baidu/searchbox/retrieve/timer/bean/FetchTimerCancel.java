package com.baidu.searchbox.retrieve.timer.bean;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchTimerCancel extends FetchBasicTimer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CANCEL_JOB_ID = "jobId";
    public transient /* synthetic */ FieldHolder $fh;

    public FetchTimerCancel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static FetchTimerCancelBean parseJsonContent(JSONObject jSONObject) {
        InterceptResult invokeL;
        FetchTimerBasicBean parseJsonContent;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null || (parseJsonContent = FetchBasicTimer.parseJsonContent(jSONObject)) == null || (optJSONObject = jSONObject.optJSONObject("info")) == null) {
                return null;
            }
            String type = parseJsonContent.getType();
            if (!TextUtils.equals(Constants.FetchType.FETCH_TIMER_TYPE, type)) {
                return null;
            }
            String jobId = parseJsonContent.getJobId();
            String version = parseJsonContent.getVersion();
            try {
                long expiredTime = parseJsonContent.getExpiredTime();
                String optString = optJSONObject.optString("jobId");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                return new FetchTimerCancelBean(jobId, type, version, expiredTime, optString);
            } catch (Exception e) {
                FetchBasicTimer.reportTaskCheckFail(type, jobId, version, jSONObject);
                if (FetchBasicTimer.DEBUG) {
                    Log.d(FetchBasicTimer.TAG, e.getMessage());
                }
                FetchBasicTimer.reportTaskCheckFail(type, jobId, version, jSONObject);
                return null;
            }
        }
        return (FetchTimerCancelBean) invokeL.objValue;
    }
}
