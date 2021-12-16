package com.baidu.mytransformapp.util;

import android.app.Activity;
import androidx.annotation.Keep;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.switchs.AndroidActivityLogSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes10.dex */
public class LogUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long INTERVAL = 50;
    public static final String LOG_ID = "4728";
    public static long lastLogTime;
    public static String lastPageName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1832958594, "Lcom/baidu/mytransformapp/util/LogUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1832958594, "Lcom/baidu/mytransformapp/util/LogUtil;");
        }
    }

    public LogUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void logActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, activity) == null) {
            logActivity(activity, "");
        }
    }

    @Keep
    public static void logActivity(Activity activity, String str) {
        UBCManager uBCManager;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, activity, str) == null) && AndroidActivityLogSwitch.isOn() && "onCreate".equals(str) && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null && activity != null) {
            String className = activity.getComponentName().getClassName();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastLogTime >= 50 || (str2 = lastPageName) == null || !str2.equals(className)) {
                lastPageName = className;
                lastLogTime = currentTimeMillis;
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("page", className);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", TbConfig.getVersion());
                    jSONObject.put("page", jSONObject2);
                    jSONObject.put("value", jSONObject3);
                    uBCManager.onEvent(LOG_ID, jSONObject);
                } catch (JSONException e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }
}
