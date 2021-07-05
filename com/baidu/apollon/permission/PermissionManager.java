package com.baidu.apollon.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.apollon.NoProguard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PermissionManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_CODE_CALL_PHONE = 2;
    public static final int REQUEST_CODE_READ_CONTRACT = 3;
    public static final int REQUEST_CODE_READ_SMS = 1;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 4;

    /* renamed from: a  reason: collision with root package name */
    public static final int f3804a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f3805b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1770479969, "Lcom/baidu/apollon/permission/PermissionManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1770479969, "Lcom/baidu/apollon/permission/PermissionManager;");
        }
    }

    public PermissionManager() {
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

    @TargetApi(23)
    public static boolean checkCallingOrSelfPermission(Activity activity, String[] strArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, activity, strArr, i2)) == null) {
            if (activity == null || strArr == null || Build.VERSION.SDK_INT < 23) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (!checkCallingPermission(activity, strArr[i3])) {
                    arrayList.add(strArr[i3]);
                }
            }
            if (arrayList.isEmpty()) {
                return true;
            }
            activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i2);
            return true;
        }
        return invokeLLI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (com.baidu.apollon.permission.c.a(r4, r5) == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (com.baidu.apollon.permission.c.a(r4, r5) == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkCallingPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 23) {
                if (getTargetSdkVersion(context) >= 23) {
                    if (context.checkSelfPermission(str) == 0) {
                        z = true;
                    }
                    return z;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static int getTargetSdkVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            if (f3805b == 0) {
                try {
                    f3805b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return f3805b;
        }
        return invokeL.intValue;
    }
}
