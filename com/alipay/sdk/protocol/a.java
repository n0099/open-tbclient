package com.alipay.sdk.protocol;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final a f34153b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f34154c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f34155d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f34156e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f34157f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f34158g;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ a[] f34159h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34160a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-597236655, "Lcom/alipay/sdk/protocol/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-597236655, "Lcom/alipay/sdk/protocol/a;");
                return;
            }
        }
        f34153b = new a("None", 0, "none");
        f34154c = new a("WapPay", 1, "js://wappay");
        f34155d = new a("Update", 2, "js://update");
        f34156e = new a("OpenWeb", 3, "loc:openweb");
        f34157f = new a("SetResult", 4, "loc:setResult");
        a aVar = new a("Exit", 5, "loc:exit");
        f34158g = aVar;
        f34159h = new a[]{f34153b, f34154c, f34155d, f34156e, f34157f, aVar};
    }

    public a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34160a = str2;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        a[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return f34153b;
            }
            a aVar = f34153b;
            for (a aVar2 : values()) {
                if (str.startsWith(aVar2.f34160a)) {
                    return aVar2;
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
    }

    public static a[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (a[]) f34159h.clone() : (a[]) invokeV.objValue;
    }
}
