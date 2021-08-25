package com.baidu.swan.config.core;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.d.g.a;
import c.a.o0.d.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ConfigNode {
    public static final /* synthetic */ ConfigNode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ConfigNode EXTENSION;
    public static final ConfigNode FRAMEWORK;
    public static final ConfigNode HOST_INFO;
    public static final ConfigNode TIP_MSG;
    public transient /* synthetic */ FieldHolder $fh;
    public String mName;
    public Class<? extends Object> mParamsProvider;
    public Class<? extends Object> mProcessor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948806276, "Lcom/baidu/swan/config/core/ConfigNode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948806276, "Lcom/baidu/swan/config/core/ConfigNode;");
                return;
            }
        }
        HOST_INFO = new ConfigNode("HOST_INFO", 0, "host_info", a.class, b.class);
        FRAMEWORK = new ConfigNode("FRAMEWORK", 1, "framework", c.a.o0.d.f.a.class, c.a.o0.d.f.b.class);
        EXTENSION = new ConfigNode("EXTENSION", 2, ETAG.KEY_EXTENSION, c.a.o0.d.e.a.class, c.a.o0.d.e.b.class);
        ConfigNode configNode = new ConfigNode("TIP_MSG", 3, "tipmsgs", c.a.o0.d.h.a.class, c.a.o0.d.h.b.class);
        TIP_MSG = configNode;
        $VALUES = new ConfigNode[]{HOST_INFO, FRAMEWORK, EXTENSION, configNode};
    }

    public ConfigNode(String str, int i2, String str2, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, cls, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mName = str2;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
    }

    public static ConfigNode getNodeByConfigName(String str) {
        InterceptResult invokeL;
        ConfigNode[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (ConfigNode configNode : values()) {
                if (configNode != null && TextUtils.equals(configNode.getName(), str)) {
                    return configNode;
                }
            }
            return null;
        }
        return (ConfigNode) invokeL.objValue;
    }

    public static ConfigNode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ConfigNode) Enum.valueOf(ConfigNode.class, str) : (ConfigNode) invokeL.objValue;
    }

    public static ConfigNode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ConfigNode[]) $VALUES.clone() : (ConfigNode[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public Class<? extends Object> getParamsProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamsProvider : (Class) invokeV.objValue;
    }

    public Class<? extends Object> getProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mProcessor : (Class) invokeV.objValue;
    }
}
