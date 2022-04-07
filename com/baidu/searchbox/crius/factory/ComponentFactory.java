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
public class ComponentFactory implements IComponentFactory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ComponentFactory sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public IComponentFactory componentFactory;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1966378216, "Lcom/baidu/searchbox/crius/factory/ComponentFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1966378216, "Lcom/baidu/searchbox/crius/factory/ComponentFactory;");
        }
    }

    public ComponentFactory() {
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

    public static ComponentFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (ComponentFactory.class) {
                    if (sInstance == null) {
                        sInstance = new ComponentFactory();
                    }
                }
            }
            return sInstance;
        }
        return (ComponentFactory) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.crius.factory.IComponentFactory
    public View createComponent(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.componentFactory == null || str == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.componentFactory.createComponent(context, str);
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.crius.factory.IComponentFactory
    public boolean renderComponent(String str, View view2, RenderData renderData, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, view2, renderData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            IComponentFactory iComponentFactory = this.componentFactory;
            if (iComponentFactory == null || view2 == null || renderData == null) {
                return false;
            }
            return iComponentFactory.renderComponent(str, view2, renderData, z, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public void setComponentFactory(IComponentFactory iComponentFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iComponentFactory) == null) {
            this.componentFactory = iComponentFactory;
        }
    }
}
