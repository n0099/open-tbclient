package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f1917a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f1918b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f1919c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f1920d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f1921e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f1922f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ a[] f1923h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f1924g;

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
        f1917a = new a("None", 0, "none");
        f1918b = new a("WapPay", 1, "js://wappay");
        f1919c = new a("Update", 2, "js://update");
        f1920d = new a("OpenWeb", 3, "loc:openweb");
        f1921e = new a("SetResult", 4, "loc:setResult");
        a aVar = new a("Exit", 5, "loc:exit");
        f1922f = aVar;
        f1923h = new a[]{f1917a, f1918b, f1919c, f1920d, f1921e, aVar};
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
        this.f1924g = str2;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        a[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return f1917a;
            }
            a aVar = f1917a;
            for (a aVar2 : values()) {
                if (str.startsWith(aVar2.f1924g)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (a[]) f1923h.clone() : (a[]) invokeV.objValue;
    }
}
