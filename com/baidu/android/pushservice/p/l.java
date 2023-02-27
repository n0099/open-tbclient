package com.baidu.android.pushservice.p;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final /* synthetic */ a[] j;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1760154413, "Lcom/baidu/android/pushservice/p/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1760154413, "Lcom/baidu/android/pushservice/p/l$a;");
                    return;
                }
            }
            b = new a("MODEL_O", 0, 1);
            c = new a("MODEL_C", 1, 2);
            d = new a("MODEL_HW", 2, 3);
            e = new a("MODEL_XM", 3, 4);
            f = new a("MODEL_MZ", 4, 5);
            g = new a("MODEL_OP", 5, 6);
            h = new a("MODEL_VI", 6, 7);
            a aVar = new a("MODEL_HN", 7, 8);
            i = aVar;
            j = new a[]{b, c, d, e, f, g, h, aVar};
        }

        public a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i3;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (a[]) j.clone() : (a[]) invokeV.objValue;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            int a2 = a.b.a();
            int b = com.baidu.android.pushservice.l.d.i(context).b();
            if (!com.baidu.android.pushservice.l.d.m(context)) {
                if (com.baidu.android.pushservice.l.d.B(context)) {
                    aVar = a.e;
                } else if (com.baidu.android.pushservice.l.d.p(context)) {
                    aVar = a.g;
                } else if (com.baidu.android.pushservice.l.d.A(context)) {
                    aVar = a.h;
                } else if (com.baidu.android.pushservice.l.d.n(context)) {
                    aVar = a.f;
                } else if (b == 2 || b == 4 || b == 3) {
                    aVar = a.c;
                } else if (!com.baidu.android.pushservice.l.d.t(context)) {
                    return a2;
                } else {
                    if (com.baidu.android.pushservice.l.d.l(context)) {
                        aVar = a.i;
                    }
                }
                return aVar.a();
            }
            aVar = a.d;
            return aVar.a();
        }
        return invokeL.intValue;
    }
}
