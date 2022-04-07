package com.baidu.searchbox.download.center.clearcache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
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
@UpdateAction(action = DiskDirToolListener.DISK_DIR_TOOL_ACTION, module = "disk_dir")
/* loaded from: classes2.dex */
public class DiskDirToolListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DISK_DIR_TOOL_ACTION = "disk_dir_tool";
    public static final String DISK_DIR_TOOL_DATA = "disk_dir_tool_data";
    public static final String DISK_DIR_TOOL_VERSION = "disk_dir_tool_version";
    public static final String TAG = "DiskDirToolListener";
    public transient /* synthetic */ FieldHolder $fh;

    public DiskDirToolListener() {
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

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) {
            String localVersion = getLocalVersion(context, str, str2);
            if (commandPostData == null || commandPostData.getVersion() == null) {
                return;
            }
            commandPostData.getVersion().put(DISK_DIR_TOOL_ACTION, localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            try {
                String localVersion = getLocalVersion(context, str, str2);
                if (actionData == null || actionData.version == null || TextUtils.equals(actionData.version, localVersion) || (jSONObject = actionData.data) == null) {
                    return false;
                }
                PreferenceUtils.setString(DISK_DIR_TOOL_VERSION, actionData.version);
                PreferenceUtils.setString(DISK_DIR_TOOL_DATA, jSONObject.toString());
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "target file data: " + jSONObject.toString());
                    return true;
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) ? PreferenceUtils.getString(DISK_DIR_TOOL_VERSION, "0") : (String) invokeLLL.objValue;
    }
}
