package com.baidu.sso.r;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f10545a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f10546b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f10547c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f10548d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f10549e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10550f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f10551g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f10552h;

    /* renamed from: i  reason: collision with root package name */
    public static final a f10553i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final /* synthetic */ a[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public String n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-894195771, "Lcom/baidu/sso/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-894195771, "Lcom/baidu/sso/r/a;");
                return;
            }
        }
        f10545a = new a("UNSUPPORT", 0, -1, "unsupport");
        f10546b = new a("HUA_WEI", 1, 0, "HUAWEI");
        f10547c = new a("XIAOMI", 2, 1, "Xiaomi");
        f10548d = new a("VIVO", 3, 2, RomUtils.MANUFACTURER_VIVO);
        f10549e = new a("OPPO", 4, 3, RomUtils.MANUFACTURER_OPPO);
        f10550f = new a("MOTO", 5, 4, "motorola");
        f10551g = new a("LENOVO", 6, 5, "lenovo");
        f10552h = new a("ASUS", 7, 6, "asus");
        f10553i = new a("SAMSUNG", 8, 7, ManufacturerUtils.SAMSUNG);
        j = new a("MEIZU", 9, 8, "meizu");
        k = new a("ALPS", 10, 9, "alps");
        a aVar = new a(RomUtils.ROM_NUBIA, 11, 10, "nubia");
        l = aVar;
        m = new a[]{f10545a, f10546b, f10547c, f10548d, f10549e, f10550f, f10551g, f10552h, f10553i, j, k, aVar};
    }

    public a(String str, int i2, int i3, String str2) {
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
        this.n = str2;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        a[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return f10545a;
            }
            for (a aVar : values()) {
                if (aVar.n.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return f10545a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (a[]) m.clone() : (a[]) invokeV.objValue;
    }
}
