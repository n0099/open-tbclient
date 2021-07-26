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
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f1951a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f1952b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f1953c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f1954d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f1955e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f1956f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ a[] f1957h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f1958g;

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
        f1951a = new a("None", 0, "none");
        f1952b = new a("WapPay", 1, "js://wappay");
        f1953c = new a("Update", 2, "js://update");
        f1954d = new a("OpenWeb", 3, "loc:openweb");
        f1955e = new a("SetResult", 4, "loc:setResult");
        a aVar = new a("Exit", 5, "loc:exit");
        f1956f = aVar;
        f1957h = new a[]{f1951a, f1952b, f1953c, f1954d, f1955e, aVar};
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
        this.f1958g = str2;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        a[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return f1951a;
            }
            a aVar = f1951a;
            for (a aVar2 : values()) {
                if (str.startsWith(aVar2.f1958g)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (a[]) f1957h.clone() : (a[]) invokeV.objValue;
    }
}
