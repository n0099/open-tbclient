package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: com.baidu.android.pushservice.message.a.k$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053386149, "Lcom/baidu/android/pushservice/message/a/k$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053386149, "Lcom/baidu/android/pushservice/message/a/k$1;");
                    return;
                }
            }
            int[] iArr = new int[l.a().length];
            a = iArr;
            try {
                iArr[l.f33191b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.f33192c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.f33196g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.f33193d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[l.f33194e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[l.f33195f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[l.f33197h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[l.f33198i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[l.f33199j.ordinal()] = 9;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public d a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            switch (AnonymousClass1.a[lVar.ordinal()]) {
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
                    return new c(this.a);
                case 9:
                    return new a(this.a);
                default:
                    m.a(">>> Unknown msg_type : " + lVar, this.a);
                    return null;
            }
        }
        return (d) invokeL.objValue;
    }
}
