package com.baidu.searchbox.devicescore.config;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.devicescore.DeviceScoreConfig;
import com.baidu.searchbox.devicescore.IDeviceScoreConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = "device_score", module = "performance")
/* loaded from: classes10.dex */
public class DeviceScoreConfigUpdateListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String KEY_UPDATE_VERSION = "device_score_update_version";
    public static final String TAG = "DeviceScoreConfig";
    public static final String UPDATE_ACTION = "device_score";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-966311392, "Lcom/baidu/searchbox/devicescore/config/DeviceScoreConfigUpdateListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-966311392, "Lcom/baidu/searchbox/devicescore/config/DeviceScoreConfigUpdateListener;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public DeviceScoreConfigUpdateListener() {
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

    private float getFloatByString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            try {
                return new BigDecimal(str).setScale(4, RoundingMode.DOWN).floatValue();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return -1.0f;
            }
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) || commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put("device_score", getLocalVersion(context, str, str2));
        if (DEBUG) {
            String str3 = "post version " + commandPostData.getVersion().toString();
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            if (DEBUG) {
                String str3 = "executeCommand: " + str + " content " + actionData;
            }
            if (actionData == null || actionData.data == null || TextUtils.isEmpty(actionData.version)) {
                return false;
            }
            JSONObject optJSONObject = actionData.data.optJSONObject("score_threshold");
            if (optJSONObject != null) {
                QuickPersistConfig.getInstance().putString(KEY_UPDATE_VERSION, actionData.version);
                DeviceScoreConfig deviceScoreConfig = new DeviceScoreConfig();
                deviceScoreConfig.lowThreshold = getFloatByString(optJSONObject.optString("low_threshold"));
                deviceScoreConfig.midThreshold = getFloatByString(optJSONObject.optString("mid_threshold"));
                ((IDeviceScoreConfig) ServiceManager.getService(IDeviceScoreConfig.SERVICE_REFERENCE)).updateConfig(deviceScoreConfig);
            }
            if (DEBUG) {
                String str4 = "version " + actionData.version + " content " + actionData.data.toString();
                return true;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) ? QuickPersistConfig.getInstance().getString(KEY_UPDATE_VERSION, "0") : (String) invokeLLL.objValue;
    }
}
