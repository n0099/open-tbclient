package com.baidu.sso.r;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f44181a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f44182b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f44183c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f44184d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f44185e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f44186f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f44187g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f44188h;

    /* renamed from: i  reason: collision with root package name */
    public static final a f44189i;
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
        f44181a = new a("UNSUPPORT", 0, -1, "unsupport");
        f44182b = new a("HUA_WEI", 1, 0, "HUAWEI");
        f44183c = new a("XIAOMI", 2, 1, "Xiaomi");
        f44184d = new a("VIVO", 3, 2, RomUtils.MANUFACTURER_VIVO);
        f44185e = new a("OPPO", 4, 3, RomUtils.MANUFACTURER_OPPO);
        f44186f = new a("MOTO", 5, 4, "motorola");
        f44187g = new a("LENOVO", 6, 5, "lenovo");
        f44188h = new a("ASUS", 7, 6, "asus");
        f44189i = new a("SAMSUNG", 8, 7, ManufacturerUtils.SAMSUNG);
        j = new a("MEIZU", 9, 8, "meizu");
        k = new a("ALPS", 10, 9, "alps");
        a aVar = new a(RomUtils.ROM_NUBIA, 11, 10, "nubia");
        l = aVar;
        m = new a[]{f44181a, f44182b, f44183c, f44184d, f44185e, f44186f, f44187g, f44188h, f44189i, j, k, aVar};
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
                return f44181a;
            }
            for (a aVar : values()) {
                if (aVar.n.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return f44181a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (a[]) m.clone() : (a[]) invokeV.objValue;
    }
}
