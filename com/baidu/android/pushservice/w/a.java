package com.baidu.android.pushservice.w;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: com.baidu.android.pushservice.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0039a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1560078057, "Lcom/baidu/android/pushservice/w/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1560078057, "Lcom/baidu/android/pushservice/w/a$a;");
                    return;
                }
            }
            int[] iArr = new int[h.values().length];
            a = iArr;
            try {
                iArr[h.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[h.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[h.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public a(Context context) {
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

    public c a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            int i = C0039a.a[hVar.ordinal()];
            if (i != 1) {
                if (i == 2 || i == 3) {
                    return new l(this.a);
                }
                if (i != 6) {
                    return null;
                }
                return new j(this.a);
            }
            return new b(this.a);
        }
        return (c) invokeL.objValue;
    }
}
