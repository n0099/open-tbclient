package com.baidu.sofire.utility;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PrivacyPolicyUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FLAG_FILE_NAME_PRIVACY_POLICY = ".ffnpp";
    public static int sCheckFlag = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1728282545, "Lcom/baidu/sofire/utility/PrivacyPolicyUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1728282545, "Lcom/baidu/sofire/utility/PrivacyPolicyUtil;");
        }
    }

    public PrivacyPolicyUtil() {
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

    public static void agree(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) || context == null) {
            return;
        }
        sCheckFlag = z ? 1 : 2;
        CommonMethods.writeFlagFile(context, FLAG_FILE_NAME_PRIVACY_POLICY, !z ? 1 : 0);
        setAgreeToPreference(context, z);
    }

    public static boolean check(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return false;
            }
            int isMainProcess = CommonMethods.isMainProcess(context);
            if (isMainProcess == 1 && (i = sCheckFlag) != -1) {
                return i == 1;
            }
            boolean agreePolicy = SharedPreferenceManager.getInstance(context).getAgreePolicy();
            boolean z = !CommonMethods.checkFlagFile(context, FLAG_FILE_NAME_PRIVACY_POLICY);
            if (agreePolicy && !z && isMainProcess == 1) {
                CommonMethods.writeFlagFile(context, FLAG_FILE_NAME_PRIVACY_POLICY, 0);
                z = true;
            }
            if (isMainProcess == 1) {
                if (z) {
                    sCheckFlag = 1;
                } else {
                    sCheckFlag = 2;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void setAgreeToPreference(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z) == null) || context == null) {
            return;
        }
        SharedPreferenceManager.getInstance(context).setAgreePolicy(z);
    }
}
