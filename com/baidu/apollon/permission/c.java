package com.baidu.apollon.permission;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f36878a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f36879b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f36880c = -2;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface a {
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(@NonNull Context context, @NonNull String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            if (context.checkPermission(str, i2, i3) == -1) {
                return -1;
            }
            String a2 = com.baidu.apollon.permission.a.a(str);
            if (a2 == null) {
                return 0;
            }
            if (str2 == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            return com.baidu.apollon.permission.a.a(context, a2, str2) != 0 ? -2 : 0;
        }
        return invokeCommon.intValue;
    }

    public static int b(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            return a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
        }
        return invokeLL.intValue;
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? a(context, str, Process.myPid(), Process.myUid(), context.getPackageName()) : invokeLL.intValue;
    }

    public static int a(@NonNull Context context, @NonNull String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            if (Binder.getCallingPid() == Process.myPid()) {
                return -1;
            }
            return a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
        }
        return invokeLLL.intValue;
    }
}
