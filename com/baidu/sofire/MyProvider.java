package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MyProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43822a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1258633103, "Lcom/baidu/sofire/MyProvider;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1258633103, "Lcom/baidu/sofire/MyProvider;");
        }
    }

    public MyProvider() {
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

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f43822a : invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Bundle a2;
        String callingPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, bundle)) == null) {
            try {
                if ((Build.VERSION.SDK_INT < 19 || (callingPackage = getCallingPackage()) == null || callingPackage.equals(getContext().getPackageName())) && !TextUtils.isEmpty(str)) {
                    if ("setAgreePolicy".equals(str)) {
                        com.baidu.sofire.core.d.b(getContext(), bundle.getBoolean("_agree_policy", true));
                        a2 = new Bundle();
                        a2.putBoolean("handle_flag", true);
                    } else if ("CallPreferences".equals(str)) {
                        a2 = com.baidu.sofire.h.a.a(getContext()).a(bundle);
                        if (a2 == null) {
                            a2 = new Bundle();
                        }
                        a2.putBoolean("handle_flag", true);
                    } else if (str.startsWith("sub_process_")) {
                        a2 = com.baidu.sofire.mutiprocess.b.a(str, bundle);
                        if (a2 == null) {
                            a2 = new Bundle();
                        }
                        a2.putBoolean("handle_flag", true);
                    } else if ("getRemoteZid".equals(str)) {
                        String b2 = com.baidu.sofire.utility.e.b(getContext());
                        new Bundle();
                        Bundle bundle2 = new Bundle();
                        if (!TextUtils.isEmpty(b2)) {
                            bundle2.putString("_zid", b2);
                        }
                        bundle2.putBoolean("handle_flag", true);
                        a2 = bundle2;
                    } else {
                        a2 = com.baidu.sofire.core.d.a(getContext().getApplicationContext(), str, bundle);
                    }
                    if (a2 != null) {
                        a2.putString("server_version", "3.5.8.8");
                    }
                    return a2;
                }
                return null;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            f43822a = true;
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, uri, strArr, str, strArr2, str2)) == null) {
            return null;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, uri, contentValues, str, strArr)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
