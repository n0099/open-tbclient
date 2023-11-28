package com.baidu.android.pushservice.w.m;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(62560943, "Lcom/baidu/android/pushservice/w/m/k$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(62560943, "Lcom/baidu/android/pushservice/w/m/k$a;");
                    return;
                }
            }
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[l.f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[l.g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[l.i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[l.j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[l.k.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public c a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            switch (a.a[lVar.ordinal()]) {
                case 1:
                case 2:
                    return new g(this.a);
                case 3:
                    return new h(this.a);
                case 4:
                case 5:
                    return new i(this.a);
                case 6:
                    return new e(this.a);
                case 7:
                    return new b(this.a);
                case 8:
                    return new com.baidu.android.pushservice.w.m.a(this.a);
                case 9:
                    return new d(this.a);
                default:
                    return null;
            }
        }
        return (c) invokeL.objValue;
    }
}
