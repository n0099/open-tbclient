package com.baidu.mobstat.dxmpay.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q.b;
import c.a.q.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CuidUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CuidUtil() {
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

    public static String getCuid3(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                str = b.f(context).c();
                try {
                    if (TextUtils.isEmpty(str)) {
                        b.f(context).j(new d<String>() { // from class: com.baidu.mobstat.dxmpay.util.CuidUtil.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // c.a.q.d
                            public void onError(int i2, Throwable th, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, th, bundle) == null) {
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // c.a.q.d
                            public void onResult(String str2, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str2, bundle) == null) {
                                }
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getGaid(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                str = u.a().b();
                try {
                    if (TextUtils.isEmpty(str)) {
                        b.f(context).m(new d<String>() { // from class: com.baidu.mobstat.dxmpay.util.CuidUtil.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // c.a.q.d
                            public void onError(int i2, Throwable th, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, th, bundle) == null) {
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // c.a.q.d
                            public void onResult(String str2, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str2, bundle) == null) || TextUtils.isEmpty(str2)) {
                                    return;
                                }
                                u.a().a(str2);
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getIid(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                str = b.f(context).e();
            } catch (Throwable unused) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getOaid(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                str = b.f(context).g();
                try {
                    if (TextUtils.isEmpty(str)) {
                        b.f(context).o(new d<String>() { // from class: com.baidu.mobstat.dxmpay.util.CuidUtil.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // c.a.q.d
                            public void onError(int i2, Throwable th, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, th, bundle) == null) {
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // c.a.q.d
                            public void onResult(String str2, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str2, bundle) == null) {
                                }
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getSsaid(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                str = b.f(context).h();
            } catch (Throwable unused) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }
}
