package com.alipay.sdk.app;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final c f31783c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f31784d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f31785e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f31786f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f31787g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f31788h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f31789i;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ c[] f31790j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f31791b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(434189670, "Lcom/alipay/sdk/app/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(434189670, "Lcom/alipay/sdk/app/c;");
                return;
            }
        }
        f31783c = new c("SUCCEEDED", 0, 9000, "处理成功");
        f31784d = new c("FAILED", 1, 4000, "系统繁忙，请稍后再试");
        f31785e = new c("CANCELED", 2, 6001, "用户取消");
        f31786f = new c("NETWORK_ERROR", 3, w0.p6, "网络连接异常");
        f31787g = new c("PARAMS_ERROR", 4, 4001, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
        f31788h = new c("DOUBLE_REQUEST", 5, 5000, "重复请求");
        c cVar = new c("PAY_WAITTING", 6, 8000, "支付结果确认中");
        f31789i = cVar;
        f31790j = new c[]{f31783c, f31784d, f31785e, f31786f, f31787g, f31788h, cVar};
    }

    public c(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i3;
        this.f31791b = str2;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (c[]) f31790j.clone() : (c[]) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.a = i2;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public static c b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 4001) {
                if (i2 != 5000) {
                    if (i2 != 8000) {
                        if (i2 != 9000) {
                            if (i2 != 6001) {
                                if (i2 != 6002) {
                                    return f31784d;
                                }
                                return f31786f;
                            }
                            return f31785e;
                        }
                        return f31783c;
                    }
                    return f31789i;
                }
                return f31788h;
            }
            return f31787g;
        }
        return (c) invokeI.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f31791b = str;
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31791b : (String) invokeV.objValue;
    }
}
