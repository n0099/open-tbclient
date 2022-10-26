package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes2.dex */
public abstract class SwitchListener extends AbstractCommandListener<SwitchData> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String VERSION_POSTFIX = "_version";
    public transient /* synthetic */ FieldHolder $fh;

    public abstract String getKey(String str, String str2);

    public SwitchListener() {
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

    public static boolean getSwitchValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.equals(str, "1") || !TextUtils.equals(str, "0")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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
    public boolean executeCommand(Context context, String str, String str2, ActionData<SwitchData> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            String key = getKey(str, str2);
            if (key == null) {
                if (!AppConfig.isDebug()) {
                    return false;
                }
                throw new IllegalArgumentException("getKey should be implemented correctly to return preference key");
            }
            Object obj = actionData.data;
            if (obj == null || ((SwitchData) obj).auth == null || !handleData(context, str, str2, key, getSwitchValue(((SwitchData) obj).auth))) {
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

    public boolean handleData(Context context, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z)})) == null) {
            DefaultSharedPrefsWrapper.getInstance().putBoolean(str3, z);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
