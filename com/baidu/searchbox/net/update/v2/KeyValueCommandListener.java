package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonElement;
import org.json.JSONException;
/* loaded from: classes3.dex */
public abstract class KeyValueCommandListener extends AbstractCommandListener<JsonElement> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String VERSION_POSTFIX = "_version";
    public transient /* synthetic */ FieldHolder $fh;

    public abstract String getKey(String str, String str2);

    public KeyValueCommandListener() {
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
            if (commandPostData != null && commandPostData.getVersion() != null) {
                commandPostData.getVersion().put(str2, localVersion);
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JsonElement> actionData) {
        InterceptResult invokeLLLL;
        String jsonElement;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            String key = getKey(str, str2);
            if (key == null) {
                if (!AppConfig.isDebug()) {
                    return false;
                }
                throw new IllegalArgumentException("getKey should be implemented correctly to return preference key");
            }
            if (actionData.data.isJsonPrimitive()) {
                jsonElement = actionData.data.getAsString();
            } else {
                jsonElement = actionData.data.toString();
            }
            if (!handleData(context, str, str2, key, jsonElement)) {
                return false;
            }
            DefaultSharedPrefsWrapper defaultSharedPrefsWrapper = DefaultSharedPrefsWrapper.getInstance();
            defaultSharedPrefsWrapper.putString(key + "_version", actionData.version);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, str2)) == null) {
            return DefaultSharedPrefsWrapper.getInstance().getString(getKey(str, str2) + "_version", "0");
        }
        return (String) invokeLLL.objValue;
    }

    public boolean handleData(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, context, str, str2, str3, str4)) == null) {
            DefaultSharedPrefsWrapper.getInstance().putString(str3, str4);
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
