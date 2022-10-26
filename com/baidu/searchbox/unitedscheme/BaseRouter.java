package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BaseRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseRouter() {
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

    public static boolean invoke(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (UnitedSchemeUtility.isUnitedScheme(str)) {
                return invokeSchemeForInner(context, Uri.parse(str));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static boolean invokeNextScheme(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            return SchemeRouter.invokeNextScheme(context, intent);
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static boolean invokeScheme(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, uri)) == null) {
            return SchemeRouter.invokeSchemeForInner(context, uri);
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static boolean invokeSchemeForInner(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, uri)) == null) {
            return SchemeRouter.invokeSchemeForInner(context, uri);
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static boolean isAvailable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (UnitedSchemeUtility.isUnitedScheme(str)) {
                return isSchemeAvailable(context, Uri.parse(str), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean invokeScheme(Context context, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, uri, str)) == null) {
            return invokeScheme(context, uri, str, null);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isSchemeAvailable(Context context, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, uri, str)) == null) {
            if (context == null) {
                context = AppRuntime.getAppContext();
            }
            return SchemeRouter.isSchemeAvailable(context, uri, str);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean invokeScheme(Context context, Uri uri, String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, uri, str, callbackHandler)) == null) {
            if (context == null) {
                context = AppRuntime.getAppContext();
            }
            return SchemeRouter.invokeScheme(context, uri, str, callbackHandler);
        }
        return invokeLLLL.booleanValue;
    }
}
