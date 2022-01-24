package com.baidu.searchbox.fluency.config;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = FpsConfigCommandListener.CLOUD_FLUENCY_FPS_ACTION, module = "aap_share_20")
/* loaded from: classes11.dex */
public class FpsConfigCommandListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLOUD_FLUENCY_FPS_ACTION = "apm_fluency_fps";
    public static final String CLOUD_FLUENCY_FPS_AUTH = "auth";
    public static final String CLOUD_FLUENCY_FPS_AUTH_CLOSE = "0";
    public static final String CLOUD_FLUENCY_FPS_AUTH_OPEN = "1";
    public static final String SP_DEFAULT_VERSION_CODE = "0";
    public static final String SP_FLUENCY_FPS_SWITCHER = "fluency_apm_fps_switcher";
    public static final String SP_FLUENCY_FPS_VERSION = "fluency_fps_version";
    public static final String TAG = "FpsConfigCommand";
    public transient /* synthetic */ FieldHolder $fh;

    public FpsConfigCommandListener() {
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

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) || commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put(str2, getLocalVersion(context, str, str2));
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            if (actionData != null && actionData.data != null && TextUtils.equals(str2, CLOUD_FLUENCY_FPS_ACTION)) {
                if (AppConfig.isDebug()) {
                    String str3 = "executeCommand: " + actionData.data.toString();
                }
                String str4 = actionData.version;
                JSONObject jSONObject = actionData.data;
                if (TextUtils.isEmpty(str4) || jSONObject == null || jSONObject.length() == 0 || getLocalVersion(context, str, str2).equals(str4)) {
                    return false;
                }
                String optString = jSONObject.optString("auth");
                if ("1".equals(optString)) {
                    QuickPersistConfig.getInstance().putString(SP_FLUENCY_FPS_VERSION, str4);
                    QuickPersistConfig.getInstance().putBoolean(SP_FLUENCY_FPS_SWITCHER, true);
                    return true;
                } else if ("0".equals(optString)) {
                    QuickPersistConfig.getInstance().putString(SP_FLUENCY_FPS_VERSION, str4);
                    QuickPersistConfig.getInstance().putBoolean(SP_FLUENCY_FPS_SWITCHER, false);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) ? QuickPersistConfig.getInstance().getString(SP_FLUENCY_FPS_VERSION, "0") : (String) invokeLLL.objValue;
    }
}
