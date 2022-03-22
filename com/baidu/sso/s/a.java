package com.baidu.sso.s;

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
import com.kuaishou.weapon.un.g;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f28708b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f28709c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f28710d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f28711e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f28712f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f28713g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f28714h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final /* synthetic */ a[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public String n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-894165980, "Lcom/baidu/sso/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-894165980, "Lcom/baidu/sso/s/a;");
                return;
            }
        }
        a = new a("UNSUPPORT", 0, -1, "unsupport");
        f28708b = new a("HUA_WEI", 1, 0, "HUAWEI");
        f28709c = new a("XIAOMI", 2, 1, "Xiaomi");
        f28710d = new a("VIVO", 3, 2, RomUtils.MANUFACTURER_VIVO);
        f28711e = new a("OPPO", 4, 3, RomUtils.MANUFACTURER_OPPO);
        f28712f = new a("MOTO", 5, 4, "motorola");
        f28713g = new a("LENOVO", 6, 5, "lenovo");
        f28714h = new a("ASUS", 7, 6, "asus");
        i = new a(g.j, 8, 7, ManufacturerUtils.SAMSUNG);
        j = new a("MEIZU", 9, 8, "meizu");
        k = new a("ALPS", 10, 9, "alps");
        a aVar = new a(RomUtils.ROM_NUBIA, 11, 10, RomUtils.MANUFACTURER_NUBIA);
        l = aVar;
        m = new a[]{a, f28708b, f28709c, f28710d, f28711e, f28712f, f28713g, f28714h, i, j, k, aVar};
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
                return a;
            }
            for (a aVar : values()) {
                if (aVar.n.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return a;
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
