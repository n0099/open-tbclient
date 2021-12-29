package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: com.baidu.android.pushservice.message.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(562019383, "Lcom/baidu/android/pushservice/message/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(562019383, "Lcom/baidu/android/pushservice/message/a$1;");
                    return;
                }
            }
            int[] iArr = new int[h.a().length];
            a = iArr;
            try {
                iArr[h.f33358b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.f33359c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.f33363g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.f33360d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[h.f33362f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[h.f33361e.ordinal()] = 6;
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

    public c a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            int i2 = AnonymousClass1.a[hVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return new l(this.a);
                }
                if (i2 != 6) {
                    return null;
                }
                return new j(this.a);
            }
            return new b(this.a);
        }
        return (c) invokeL.objValue;
    }
}
