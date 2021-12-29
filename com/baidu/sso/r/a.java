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
import com.kuaishou.weapon.un.g;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f39886b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f39887c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f39888d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f39889e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f39890f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f39891g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f39892h;

    /* renamed from: i  reason: collision with root package name */
    public static final a f39893i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f39894j;

    /* renamed from: k  reason: collision with root package name */
    public static final a f39895k;
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
        a = new a("UNSUPPORT", 0, -1, "unsupport");
        f39886b = new a("HUA_WEI", 1, 0, "HUAWEI");
        f39887c = new a("XIAOMI", 2, 1, "Xiaomi");
        f39888d = new a("VIVO", 3, 2, RomUtils.MANUFACTURER_VIVO);
        f39889e = new a("OPPO", 4, 3, RomUtils.MANUFACTURER_OPPO);
        f39890f = new a("MOTO", 5, 4, "motorola");
        f39891g = new a("LENOVO", 6, 5, "lenovo");
        f39892h = new a("ASUS", 7, 6, "asus");
        f39893i = new a(g.f57226j, 8, 7, ManufacturerUtils.SAMSUNG);
        f39894j = new a("MEIZU", 9, 8, "meizu");
        f39895k = new a("ALPS", 10, 9, "alps");
        a aVar = new a(RomUtils.ROM_NUBIA, 11, 10, "nubia");
        l = aVar;
        m = new a[]{a, f39886b, f39887c, f39888d, f39889e, f39890f, f39891g, f39892h, f39893i, f39894j, f39895k, aVar};
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
