package com.baidu.sofire.p;

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
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f43150a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f43151b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f43152c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f43153d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f43154e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f43155f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f43156g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f43157h;

        /* renamed from: i  reason: collision with root package name */
        public static final a f43158i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final /* synthetic */ a[] o;
        public transient /* synthetic */ FieldHolder $fh;
        public int m;
        public String n;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641096586, "Lcom/baidu/sofire/p/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(641096586, "Lcom/baidu/sofire/p/b$a;");
                    return;
                }
            }
            f43150a = new a("UNSUPPORT", 0, -1, "unsupport");
            f43151b = new a("HUA_WEI", 1, 0, "HUAWEI");
            f43152c = new a("XIAOMI", 2, 1, "Xiaomi");
            f43153d = new a("VIVO", 3, 2, RomUtils.MANUFACTURER_VIVO);
            f43154e = new a("OPPO", 4, 3, RomUtils.MANUFACTURER_OPPO);
            f43155f = new a("MOTO", 5, 4, "motorola");
            f43156g = new a("LENOVO", 6, 5, "lenovo");
            f43157h = new a("ASUS", 7, 6, "asus");
            f43158i = new a("SAMSUNG", 8, 7, ManufacturerUtils.SAMSUNG);
            j = new a("MEIZU", 9, 8, "meizu");
            k = new a("ALPS", 10, 9, "alps");
            a aVar = new a(RomUtils.ROM_NUBIA, 11, 10, "nubia");
            l = aVar;
            o = new a[]{f43150a, f43151b, f43152c, f43153d, f43154e, f43155f, f43156g, f43157h, f43158i, j, k, aVar};
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
            this.m = i3;
            this.n = str2;
        }

        public static a a(String str) {
            InterceptResult invokeL;
            a[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return f43150a;
                }
                for (a aVar : values()) {
                    if (aVar.n.equalsIgnoreCase(str)) {
                        return aVar;
                    }
                }
                return f43150a;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (a[]) o.clone() : (a[]) invokeV.objValue;
        }
    }
}
