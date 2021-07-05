package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PermissionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PERMISSION_APP_LIST = "permission_app_list";
    public static final String PERMISSION_LOCATION = "permission_location";
    public static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    public static final String PERMISSION_STORAGE = "permission_storage";
    public static boolean mAccessAppListGranted = true;
    public static boolean mAccessLocationGranted;
    public static boolean mExternalStorageGranted;
    public static boolean mReadPhoneStateGranted;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(192493575, "Lcom/baidu/mobads/container/util/PermissionUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(192493575, "Lcom/baidu/mobads/container/util/PermissionUtils;");
        }
    }

    public PermissionUtils() {
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

    public static boolean checkPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 23 ? context.checkSelfPermission(str) == 0 : context.checkCallingOrSelfPermission(str) == 0;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean hasPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if ("permission_location".equalsIgnoreCase(str)) {
                return mAccessLocationGranted;
            }
            if ("permission_storage".equalsIgnoreCase(str)) {
                return mExternalStorageGranted;
            }
            if ("permission_app_list".equalsIgnoreCase(str)) {
                return mAccessAppListGranted;
            }
            if ("permission_read_phone_state".equalsIgnoreCase(str)) {
                return mReadPhoneStateGranted;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setPermissionInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("permission_location");
        if (!TextUtils.isEmpty(optString)) {
            mAccessLocationGranted = Boolean.parseBoolean(optString);
        }
        String optString2 = jSONObject.optString("permission_storage");
        if (!TextUtils.isEmpty(optString2)) {
            mExternalStorageGranted = Boolean.parseBoolean(optString2);
        }
        String optString3 = jSONObject.optString("permission_app_list");
        if (!TextUtils.isEmpty(optString3)) {
            mAccessAppListGranted = Boolean.parseBoolean(optString3);
        }
        String optString4 = jSONObject.optString("permission_read_phone_state");
        if (TextUtils.isEmpty(optString4)) {
            return;
        }
        mReadPhoneStateGranted = Boolean.parseBoolean(optString4);
    }
}
