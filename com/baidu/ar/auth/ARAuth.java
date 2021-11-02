package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ARAuth {
    public static /* synthetic */ Interceptable $ic;
    public static com.baidu.ar.h.h<j> iW;
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
        iW = new com.baidu.ar.h.h<>("com.baidu.ar.auth.ARAuthFacade");
    }

    public ARAuth() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, bArr, iDuMixAuthCallback)) == null) {
            j gA = iW.gA();
            return gA != null ? gA.checkAuth(context, bArr, iDuMixAuthCallback) : new ArrayList();
        }
        return (List) invokeLLL.objValue;
    }

    public static List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, bArr, iCallbackWith, iCallbackWith2)) == null) {
            j gA = iW.gA();
            return gA != null ? gA.checkAuth(context, bArr, iCallbackWith, iCallbackWith2) : new ArrayList();
        }
        return (List) invokeLLLL.objValue;
    }

    public static boolean checkFeatureAuth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            j gA = iW.gA();
            if (gA != null) {
                return gA.checkFeatureAuth(i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, bArr)) == null) {
            j gA = iW.gA();
            if (gA != null) {
                return gA.checkOfflineLicenseAuth(context, bArr);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static Bitmap createTipBitmap(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            j gA = iW.gA();
            if (gA != null) {
                return gA.createTipBitmap(context);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void doAuth(Context context, IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, iAuthCallback) == null) {
            AuthJni.init();
            j gA = iW.gA();
            if (gA != null) {
                gA.doAuth(context, iAuthCallback);
            }
        }
    }

    public static boolean enableFeature(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            j gA = iW.gA();
            if (gA != null) {
                return gA.enableFeature(i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean isShowAuthTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            j gA = iW.gA();
            if (gA != null) {
                return gA.isShowAuthTip();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void loadAuthInfo(Context context) {
        j gA;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, context) == null) || (gA = iW.gA()) == null) {
            return;
        }
        gA.loadAuthInfo(context);
    }

    public static void receiveAuthFailMessage(int i2) {
        j gA;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65547, null, i2) == null) || (gA = iW.gA()) == null) {
            return;
        }
        gA.receiveAuthFailMessage(i2);
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            j gB = iW.gB();
            if (gB != null) {
                gB.release();
            }
            iW.release();
            AuthJni.release();
        }
    }

    public static void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        j gA;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65549, null, bArr, str, str2, str3) == null) || (gA = iW.gA()) == null) {
            return;
        }
        gA.setAuthLicense(bArr, str, str2, str3);
    }
}
