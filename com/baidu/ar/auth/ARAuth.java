package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ARAuth {
    public static /* synthetic */ Interceptable $ic;
    public static com.baidu.ar.h.h iW;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1692973877, "Lcom/baidu/ar/auth/ARAuth;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1692973877, "Lcom/baidu/ar/auth/ARAuth;");
                return;
            }
        }
        iW = new com.baidu.ar.h.h("com.baidu.ar.auth.ARAuthFacade");
    }

    public ARAuth() {
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

    public static List checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, bArr, iDuMixAuthCallback)) == null) {
            j jVar = (j) iW.gA();
            return jVar != null ? jVar.checkAuth(context, bArr, iDuMixAuthCallback) : new ArrayList();
        }
        return (List) invokeLLL.objValue;
    }

    public static List checkAuth(Context context, byte[] bArr, ICallbackWith iCallbackWith, ICallbackWith iCallbackWith2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, bArr, iCallbackWith, iCallbackWith2)) == null) {
            j jVar = (j) iW.gA();
            return jVar != null ? jVar.checkAuth(context, bArr, iCallbackWith, iCallbackWith2) : new ArrayList();
        }
        return (List) invokeLLLL.objValue;
    }

    public static boolean checkFeatureAuth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            j jVar = (j) iW.gA();
            if (jVar != null) {
                return jVar.checkFeatureAuth(i);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, bArr)) == null) {
            j jVar = (j) iW.gA();
            if (jVar != null) {
                return jVar.checkOfflineLicenseAuth(context, bArr);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static Bitmap createTipBitmap(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            j jVar = (j) iW.gA();
            if (jVar != null) {
                return jVar.createTipBitmap(context);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void doAuth(Context context, IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, iAuthCallback) == null) {
            AuthJni.init();
            j jVar = (j) iW.gA();
            if (jVar != null) {
                jVar.doAuth(context, iAuthCallback);
            }
        }
    }

    public static boolean enableFeature(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            j jVar = (j) iW.gA();
            if (jVar != null) {
                return jVar.enableFeature(i);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean isShowAuthTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            j jVar = (j) iW.gA();
            if (jVar != null) {
                return jVar.isShowAuthTip();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void loadAuthInfo(Context context) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, context) == null) || (jVar = (j) iW.gA()) == null) {
            return;
        }
        jVar.loadAuthInfo(context);
    }

    public static void receiveAuthFailMessage(int i) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65547, null, i) == null) || (jVar = (j) iW.gA()) == null) {
            return;
        }
        jVar.receiveAuthFailMessage(i);
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            j jVar = (j) iW.gB();
            if (jVar != null) {
                jVar.release();
            }
            iW.release();
            AuthJni.release();
        }
    }

    public static void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65549, null, bArr, str, str2, str3) == null) || (jVar = (j) iW.gA()) == null) {
            return;
        }
        jVar.setAuthLicense(bArr, str, str2, str3);
    }
}
