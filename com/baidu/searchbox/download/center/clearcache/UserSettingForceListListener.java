package com.baidu.searchbox.download.center.clearcache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.AppConfig;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = UserSettingForceListListener.FORCE_LIST_ACTION, module = "usersetting")
/* loaded from: classes2.dex */
public class UserSettingForceListListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String DEFAULT_VERSION = "0";
    public static final String FORCE_LIST_ACTION = "force_list";
    public static final String FORCE_LIST_DATA_KEY = "force_list_data";
    public static final String FORCE_LIST_ITEM_ID_KEY = "ID";
    public static final String FORCE_LIST_ITEM_SHOW_KEY = "isShow";
    public static final String FORCE_LIST_ITEM_SHOW_TRUE = "1";
    public static final String FORCE_LIST_VERSION_KEY = "force_list_version";
    public static final String TAG = "ForceListListener";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1109860694, "Lcom/baidu/searchbox/download/center/clearcache/UserSettingForceListListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1109860694, "Lcom/baidu/searchbox/download/center/clearcache/UserSettingForceListListener;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public UserSettingForceListListener() {
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

    public static JSONArray getForceList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String string = new SharedPrefsWrapper("").getString(FORCE_LIST_DATA_KEY, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string).optJSONArray(str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) {
            String localVersion = getLocalVersion(context, str, str2);
            if (commandPostData != null && commandPostData.getVersion() != null) {
                commandPostData.getVersion().put(FORCE_LIST_ACTION, localVersion);
                if (DEBUG) {
                    Log.d(TAG, "post data version: " + localVersion);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            if (DEBUG) {
                Log.d(TAG, "execute command action: " + str2);
            }
            if (actionData != null && TextUtils.equals(str2, FORCE_LIST_ACTION)) {
                JSONObject jSONObject = actionData.data;
                if (jSONObject == null) {
                    str3 = "";
                } else {
                    str3 = jSONObject.toString();
                }
                new SharedPrefsWrapper("").putString(FORCE_LIST_DATA_KEY, str3);
                new SharedPrefsWrapper("").putString(FORCE_LIST_VERSION_KEY, actionData.version);
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
            return new SharedPrefsWrapper("").getString(FORCE_LIST_VERSION_KEY, "0");
        }
        return (String) invokeLLL.objValue;
    }
}
