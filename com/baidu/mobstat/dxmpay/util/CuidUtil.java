package com.baidu.mobstat.dxmpay.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r.b;
import b.a.r.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.dxmpay.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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
                str = b.e(context).b();
                try {
                    if (TextUtils.isEmpty(str)) {
                        b.e(context).i(new c<String>() { // from class: com.baidu.mobstat.dxmpay.util.CuidUtil.2
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

                            @Override // b.a.r.c
                            public void onError(int i2, Throwable th, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, th, bundle) == null) {
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // b.a.r.c
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
                        b.e(context).k(new c<String>() { // from class: com.baidu.mobstat.dxmpay.util.CuidUtil.3
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

                            @Override // b.a.r.c
                            public void onError(int i2, Throwable th, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, th, bundle) == null) {
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // b.a.r.c
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
                str = b.e(context).d();
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
                str = b.e(context).f();
                try {
                    if (TextUtils.isEmpty(str)) {
                        b.e(context).m(new c<String>() { // from class: com.baidu.mobstat.dxmpay.util.CuidUtil.1
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

                            @Override // b.a.r.c
                            public void onError(int i2, Throwable th, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, th, bundle) == null) {
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // b.a.r.c
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                str = b.e(context).g();
            } catch (Throwable unused) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }
}
