package com.baidu.fsg.base.armor;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RimArmor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY = "key";
    public static RimArmor ins;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-792007129, "Lcom/baidu/fsg/base/armor/RimArmor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-792007129, "Lcom/baidu/fsg/base/armor/RimArmor;");
                return;
            }
        }
        try {
            System.loadLibrary("bd_fsg_rim_v1_3");
        } catch (Throwable unused) {
        }
    }

    public RimArmor() {
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

    public static synchronized RimArmor getInstance() {
        InterceptResult invokeV;
        RimArmor rimArmor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (RimArmor.class) {
                if (ins == null) {
                    RimArmor rimArmor2 = new RimArmor();
                    ins = rimArmor2;
                    rimArmor2.init(ResUtils.getApplicationContext());
                }
                rimArmor = ins;
            }
            return rimArmor;
        }
        return (RimArmor) invokeV.objValue;
    }

    private native void init(Context context);

    public native String decrypt(String str);

    public String decryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return decrypt(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public native String encrypt(String str);

    public String encryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return encrypt(str);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public native String getFpk(Context context);

    public native String getToken();

    public native String getak();

    public native String getpw();

    public String getpwProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return getpw();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public native String localDecrypt(String str);

    public String localDecryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                return localDecrypt(str);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public native String localEncrypt(String str);

    public String localEncryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            try {
                return localEncrypt(str);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
