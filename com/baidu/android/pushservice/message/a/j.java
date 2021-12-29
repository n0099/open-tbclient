package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: com.baidu.android.pushservice.message.a.j$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053415940, "Lcom/baidu/android/pushservice/message/a/j$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053415940, "Lcom/baidu/android/pushservice/message/a/j$1;");
                    return;
                }
            }
            int[] iArr = new int[k.a().length];
            a = iArr;
            try {
                iArr[k.f33341b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.f33342c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k.f33346g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[k.f33343d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[k.f33344e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[k.f33345f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[k.f33347h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[k.f33348i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public j(Context context) {
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

    public c a(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
            switch (AnonymousClass1.a[kVar.ordinal()]) {
                case 1:
                case 2:
                    return new f(this.a);
                case 3:
                    return new g(this.a);
                case 4:
                case 5:
                    return new h(this.a);
                case 6:
                    return new d(this.a);
                case 7:
                    return new b(this.a);
                case 8:
                    return new a(this.a);
                default:
                    return null;
            }
        }
        return (c) invokeL.objValue;
    }
}
