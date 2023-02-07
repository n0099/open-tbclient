package com.baidu.searchbox.retrieve.timer.bean;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchTimer extends FetchBasicTimer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String END_TIME = "endTime";
    public static final String FREQUENCY = "frequency";
    public static final String MAX_TOTAL_FILE_SIZE = "maxTotalFileSize";
    public static final String NETWORK = "network";
    public static final String SPACE = "space";
    public static final String START_TIME = "startTime";
    public transient /* synthetic */ FieldHolder $fh;

    public FetchTimer() {
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FetchTimerBean parseJsonContent(JSONObject jSONObject) {
        InterceptResult invokeL;
        FetchTimerBasicBean parseJsonContent;
        JSONObject optJSONObject;
        String str;
        String str2;
        JSONObject jSONObject2;
        String str3;
        long expiredTime;
        long parseLong;
        long parseLong2;
        ArrayList arrayList;
        String optString;
        long parseLong3;
        String optString2;
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
                expiredTime = parseJsonContent.getExpiredTime();
                String optString3 = optJSONObject.optString("startTime");
                String optString4 = optJSONObject.optString("endTime");
                parseLong = Long.parseLong(optString3) * 1000;
                parseLong2 = Long.parseLong(optString4) * 1000;
                arrayList = new ArrayList();
                String optString5 = optJSONObject.optString("space");
                if (!TextUtils.isEmpty(optString5)) {
                    try {
                        arrayList.addAll(Arrays.asList(optString5.split(",")));
                    } catch (Exception e) {
                        e = e;
                        jSONObject2 = jSONObject;
                        str = version;
                        str3 = type;
                        str2 = jobId;
                        FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                        if (FetchBasicTimer.DEBUG) {
                            Log.d(FetchBasicTimer.TAG, e.getMessage());
                        }
                        FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                        return null;
                    }
                }
                optString = optJSONObject.optString("network");
                parseLong3 = Long.parseLong(optJSONObject.optString("maxTotalFileSize"));
                optString2 = optJSONObject.optString(FREQUENCY);
                if (TextUtils.isEmpty(optString2)) {
                    FetchBasicTimer.reportTaskCheckFail(type, jobId, version, jSONObject);
                }
                str = version;
                str2 = jobId;
            } catch (Exception e2) {
                e = e2;
                str = version;
                str2 = jobId;
                jSONObject2 = jSONObject;
                str3 = type;
            }
            try {
                return new FetchTimerBean(jobId, type, version, expiredTime, parseLong, parseLong2, parseLong3, arrayList, optString, Integer.parseInt(optString2));
            } catch (Exception e3) {
                e = e3;
                jSONObject2 = jSONObject;
                str3 = type;
                FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                if (FetchBasicTimer.DEBUG) {
                }
                FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                return null;
            }
        }
        return (FetchTimerBean) invokeL.objValue;
    }
}
