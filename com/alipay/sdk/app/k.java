package com.alipay.sdk.app;

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
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final k f1809a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f1810b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f1811c;

    /* renamed from: d  reason: collision with root package name */
    public static final k f1812d;

    /* renamed from: e  reason: collision with root package name */
    public static final k f1813e;

    /* renamed from: f  reason: collision with root package name */
    public static final k f1814f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f1815g;
    public static final /* synthetic */ k[] j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f1816h;

    /* renamed from: i  reason: collision with root package name */
    public String f1817i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(434189918, "Lcom/alipay/sdk/app/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(434189918, "Lcom/alipay/sdk/app/k;");
                return;
            }
        }
        f1809a = new k("SUCCEEDED", 0, 9000, "处理成功");
        f1810b = new k("FAILED", 1, 4000, "系统繁忙，请稍后再试");
        f1811c = new k("CANCELED", 2, ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, "用户取消");
        f1812d = new k("NETWORK_ERROR", 3, 6002, "网络连接异常");
        f1813e = new k("PARAMS_ERROR", 4, 4001, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
        f1814f = new k("DOUBLE_REQUEST", 5, 5000, "重复请求");
        k kVar = new k("PAY_WAITTING", 6, 8000, "支付结果确认中");
        f1815g = kVar;
        j = new k[]{f1809a, f1810b, f1811c, f1812d, f1813e, f1814f, kVar};
    }

    public k(String str, int i2, int i3, String str2) {
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
        this.f1816h = i3;
        this.f1817i = str2;
    }

    public static k valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (k) Enum.valueOf(k.class, str) : (k) invokeL.objValue;
    }

    public static k[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (k[]) j.clone() : (k[]) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f1816h = i2;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1817i : (String) invokeV.objValue;
    }

    public static k b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 4001) {
                if (i2 != 5000) {
                    if (i2 != 8000) {
                        if (i2 != 9000) {
                            if (i2 != 6001) {
                                if (i2 != 6002) {
                                    return f1810b;
                                }
                                return f1812d;
                            }
                            return f1811c;
                        }
                        return f1809a;
                    }
                    return f1815g;
                }
                return f1814f;
            }
            return f1813e;
        }
        return (k) invokeI.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1816h : invokeV.intValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f1817i = str;
        }
    }
}
