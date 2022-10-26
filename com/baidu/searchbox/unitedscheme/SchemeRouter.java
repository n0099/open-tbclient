package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SchemeRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SchemeRouter() {
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

    public static boolean invokeSchemeForInner(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, uri)) == null) {
            return invokeScheme(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        }
        return invokeLL.booleanValue;
    }

    public static boolean invokeNextScheme(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            if (intent == null) {
                return false;
            }
            if (context == null) {
                context = SchemeConfig.getAppContext();
            }
            String stringExtra = intent.getStringExtra(UnitedSchemeConstants.INTENT_KEY_FOR_NEXT);
            if (TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            return invokeScheme(context, Uri.parse(stringExtra), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        }
        return invokeLL.booleanValue;
    }

    public static boolean invokeScheme(Context context, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, str)) == null) {
            return invokeScheme(context, uri, str, null);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isSchemeAvailable(Context context, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, uri, str)) == null) {
            if (context == null) {
                context = SchemeConfig.getAppContext();
            }
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(uri, str);
            unitedSchemeEntity.setOnlyVerify(true);
            return unitedSchemeMainDispatcher.dispatch(context, unitedSchemeEntity);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean invokeScheme(Context context, Uri uri, String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, uri, str, callbackHandler)) == null) {
            if (context == null) {
                context = SchemeConfig.getAppContext();
            }
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(uri, str);
            unitedSchemeEntity.setOnlyVerify(false);
            return unitedSchemeMainDispatcher.dispatch(context, unitedSchemeEntity, callbackHandler);
        }
        return invokeLLLL.booleanValue;
    }
}
