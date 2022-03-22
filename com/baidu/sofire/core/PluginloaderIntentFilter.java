package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PluginloaderIntentFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String fromPluginPkgName;
    public IntentFilter intentFilter;
    public String targetClass;
    public String targetMethod;

    public PluginloaderIntentFilter(String str, IntentFilter intentFilter, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, intentFilter, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fromPluginPkgName = str;
        this.intentFilter = intentFilter;
        this.targetClass = str2;
        this.targetMethod = str3;
    }

    public boolean isSameObj(PluginloaderIntentFilter pluginloaderIntentFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pluginloaderIntentFilter)) == null) {
            if (pluginloaderIntentFilter != null) {
                try {
                    if (!TextUtils.isEmpty(pluginloaderIntentFilter.fromPluginPkgName) && !TextUtils.isEmpty(pluginloaderIntentFilter.targetClass) && !TextUtils.isEmpty(pluginloaderIntentFilter.targetMethod) && pluginloaderIntentFilter.fromPluginPkgName.equals(this.fromPluginPkgName) && pluginloaderIntentFilter.targetClass.equals(this.targetClass) && pluginloaderIntentFilter.targetMethod.equals(this.targetMethod)) {
                        if (pluginloaderIntentFilter.intentFilter != null && this.intentFilter != null) {
                            return this.intentFilter == pluginloaderIntentFilter.intentFilter;
                        }
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "PluginloaderIntentFilter:" + this.fromPluginPkgName + "-" + this.targetClass + "-" + this.targetMethod + "-" + this.intentFilter;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
