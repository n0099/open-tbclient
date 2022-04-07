package com.baidu.sofire.utility;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DoubleListUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static int sIsBaiduGroupFlag = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(769622264, "Lcom/baidu/sofire/utility/DoubleListUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(769622264, "Lcom/baidu/sofire/utility/DoubleListUtil;");
        }
    }

    public DoubleListUtil() {
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

    public static void clearTmp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
            sharedPreferenceManager.setAndroidId("");
            sharedPreferenceManager.setIMEI("");
            sharedPreferenceManager.setIMEINew("");
            sharedPreferenceManager.setOaidTmp("");
            sharedPreferenceManager.setOaidTmpTime(0L);
            sharedPreferenceManager.setSimOperatorTmp("");
            sharedPreferenceManager.setSimOperatorTmpTime(0L);
            sharedPreferenceManager.setNetworkOperatorTmp("");
            sharedPreferenceManager.setNetworkOperatorTmpTime(0L);
            if (isBaiduGroup(context)) {
                sharedPreferenceManager.setExternalCuidTmp("");
                sharedPreferenceManager.setExternalCuidTmpTime(0L);
                sharedPreferenceManager.setSettingCuidTmp("");
                sharedPreferenceManager.setSettingCuidTmpTime(0L);
                sharedPreferenceManager.setAndroidIdTmp("");
                sharedPreferenceManager.setAndroidIdTmpTime(0L);
                sharedPreferenceManager.setImeiTmp("");
                sharedPreferenceManager.setImeiTmpTime(0L);
            }
        }
    }

    public static void doubleListReset(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            try {
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                if (sharedPreferenceManager.getResetDoubleListFlag()) {
                    return;
                }
                clearTmp(context);
                DbUtil.resetZid(context);
                sharedPreferenceManager.setResetDoubleListFlag();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static boolean hasBaiduDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean isBaiduGroup(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, null, context)) != null) {
            return invokeL.booleanValue;
        }
        synchronized (DoubleListUtil.class) {
            if (sIsBaiduGroupFlag != -1) {
                return sIsBaiduGroupFlag == 1;
            }
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return false;
            }
            if (!packageName.toLowerCase().contains("baidu") && !hasBaiduDeviceId()) {
                sIsBaiduGroupFlag = 0;
                return sIsBaiduGroupFlag != 1;
            }
            sIsBaiduGroupFlag = 1;
            if (sIsBaiduGroupFlag != 1) {
            }
        }
    }
}
