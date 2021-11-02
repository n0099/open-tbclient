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
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f35766a;

    /* renamed from: com.baidu.android.pushservice.message.a.k$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35767a;
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
            f35767a = iArr;
            try {
                iArr[l.f35769b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35767a[l.f35770c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35767a[l.f35774g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35767a[l.f35771d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35767a[l.f35772e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35767a[l.f35773f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35767a[l.f35775h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35767a[l.f35776i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35767a[l.j.ordinal()] = 9;
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
        this.f35766a = context;
    }

    public d a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            switch (AnonymousClass1.f35767a[lVar.ordinal()]) {
                case 1:
                case 2:
                    return new g(this.f35766a);
                case 3:
                    return new h(this.f35766a);
                case 4:
                case 5:
                    return new i(this.f35766a);
                case 6:
                    return new e(this.f35766a);
                case 7:
                    return new b(this.f35766a);
                case 8:
                    return new c(this.f35766a);
                case 9:
                    return new a(this.f35766a);
                default:
                    m.a(">>> Unknown msg_type : " + lVar, this.f35766a);
                    return null;
            }
        }
        return (d) invokeL.objValue;
    }
}
