package com.alipay.sdk.app;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final c f35933c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f35934d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f35935e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f35936f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f35937g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f35938h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f35939i;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ c[] f35940j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f35941a;

    /* renamed from: b  reason: collision with root package name */
    public String f35942b;

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
        f35933c = new c("SUCCEEDED", 0, 9000, "处理成功");
        f35934d = new c("FAILED", 1, 4000, "系统繁忙，请稍后再试");
        f35935e = new c("CANCELED", 2, ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, "用户取消");
        f35936f = new c("NETWORK_ERROR", 3, 6002, "网络连接异常");
        f35937g = new c("PARAMS_ERROR", 4, 4001, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
        f35938h = new c("DOUBLE_REQUEST", 5, 5000, "重复请求");
        c cVar = new c("PAY_WAITTING", 6, 8000, "支付结果确认中");
        f35939i = cVar;
        f35940j = new c[]{f35933c, f35934d, f35935e, f35936f, f35937g, f35938h, cVar};
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
        this.f35941a = i3;
        this.f35942b = str2;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (c[]) f35940j.clone() : (c[]) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f35941a = i2;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35941a : invokeV.intValue;
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
                                    return f35934d;
                                }
                                return f35936f;
                            }
                            return f35935e;
                        }
                        return f35933c;
                    }
                    return f35939i;
                }
                return f35938h;
            }
            return f35937g;
        }
        return (c) invokeI.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f35942b = str;
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35942b : (String) invokeV.objValue;
    }
}
