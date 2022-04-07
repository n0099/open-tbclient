package com.baidu.searchbox.crius.factory;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.data.RenderData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NativeRenderFactory implements INativeRenderFactory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile NativeRenderFactory sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public INativeRenderFactory nativeRenderFactory;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1966148268, "Lcom/baidu/searchbox/crius/factory/NativeRenderFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1966148268, "Lcom/baidu/searchbox/crius/factory/NativeRenderFactory;");
        }
    }

    public NativeRenderFactory() {
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

    public static NativeRenderFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (NativeRenderFactory.class) {
                    if (sInstance == null) {
                        sInstance = new NativeRenderFactory();
                    }
                }
            }
            return sInstance;
        }
        return (NativeRenderFactory) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public View createView(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.nativeRenderFactory == null || context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.nativeRenderFactory.createView(context, str);
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public boolean renderBackground(String str, View view2, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, str2, str3)) == null) {
            if (this.nativeRenderFactory == null || view2 == null || TextUtils.isEmpty(str2)) {
                return false;
            }
            return this.nativeRenderFactory.renderBackground(str, view2, str2, str3);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public boolean renderView(String str, View view2, RenderData renderData, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, view2, renderData, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            INativeRenderFactory iNativeRenderFactory = this.nativeRenderFactory;
            if (iNativeRenderFactory == null || view2 == null || renderData == null) {
                return false;
            }
            return iNativeRenderFactory.renderView(str, view2, renderData, z, z2);
        }
        return invokeCommon.booleanValue;
    }

    public void setNativeRenderFactory(INativeRenderFactory iNativeRenderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iNativeRenderFactory) == null) {
            this.nativeRenderFactory = iNativeRenderFactory;
        }
    }
}
