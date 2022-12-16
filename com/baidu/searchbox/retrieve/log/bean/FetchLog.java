package com.baidu.searchbox.retrieve.log.bean;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String END_TIME = "endTime";
    public static final String EXPIRED = "expiredTime";
    public static final String FETCH_LOG_TYPE = "flow";
    public static final String INFO = "info";
    public static final String JOB_ID = "jobId";
    public static final String MAX_FILE_SIZE = "maxTotalFileSize";
    public static final String NETWORK = "network";
    public static final String SPACE = "space";
    public static final String START_TIME = "startTime";
    public static final String TAG = "FetchFileData";
    public static final String TYPE = "type";
    public static final String VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-627659978, "Lcom/baidu/searchbox/retrieve/log/bean/FetchLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-627659978, "Lcom/baidu/searchbox/retrieve/log/bean/FetchLog;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchLog() {
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FetchLogBean parseJsonContent(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        String str;
        String str2;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("info")) == null) {
                return null;
            }
            String optString = jSONObject.optString("type");
            if (!TextUtils.equals("flow", optString)) {
                return null;
            }
            String optString2 = jSONObject.optString("jobId");
            String optString3 = jSONObject.optString("version");
            try {
                long longValue = Long.valueOf(jSONObject.optString("expiredTime")).longValue() * 1000;
                try {
                    if (longValue < System.currentTimeMillis()) {
                        reportTaskCheckFail(optString, optString2, optString2, jSONObject);
                        return null;
                    }
                    String optString4 = optJSONObject.optString(START_TIME);
                    String optString5 = optJSONObject.optString(END_TIME);
                    long parseLong = Long.parseLong(optString4) * 1000;
                    long parseLong2 = Long.parseLong(optString5) * 1000;
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("space");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String string = optJSONArray.getString(i);
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                    }
                    str = optString2;
                    str2 = optString3;
                    try {
                        return new FetchLogBean(optString2, optString, optString3, longValue, parseLong, parseLong2, Long.parseLong(optJSONObject.optString("maxTotalFileSize")), arrayList, optJSONObject.optString("network"));
                    } catch (Exception e) {
                        e = e;
                        jSONObject2 = jSONObject;
                        reportTaskCheckFail(optString, str, str2, jSONObject2);
                        if (DEBUG) {
                        }
                        reportTaskCheckFail(optString, str, str2, jSONObject2);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                    str = optString2;
                    str2 = optString3;
                    reportTaskCheckFail(optString, str, str2, jSONObject2);
                    if (DEBUG) {
                        Log.d("FetchFileData", e.getMessage());
                    }
                    reportTaskCheckFail(optString, str, str2, jSONObject2);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                str = optString2;
                str2 = optString3;
            }
        } else {
            return (FetchLogBean) invokeL.objValue;
        }
    }

    public static void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, str, str2, str3, jSONObject) == null) {
            ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskCheckFail(str, str2, str3, jSONObject);
        }
    }
}
