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
    public Context f36595a;

    /* renamed from: com.baidu.android.pushservice.message.a.k$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36596a;
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
            f36596a = iArr;
            try {
                iArr[l.f36598b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36596a[l.f36599c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36596a[l.f36603g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36596a[l.f36600d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36596a[l.f36601e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36596a[l.f36602f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36596a[l.f36604h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36596a[l.f36605i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36596a[l.j.ordinal()] = 9;
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
        this.f36595a = context;
    }

    public d a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            switch (AnonymousClass1.f36596a[lVar.ordinal()]) {
                case 1:
                case 2:
                    return new g(this.f36595a);
                case 3:
                    return new h(this.f36595a);
                case 4:
                case 5:
                    return new i(this.f36595a);
                case 6:
                    return new e(this.f36595a);
                case 7:
                    return new b(this.f36595a);
                case 8:
                    return new c(this.f36595a);
                case 9:
                    return new a(this.f36595a);
                default:
                    m.a(">>> Unknown msg_type : " + lVar, this.f36595a);
                    return null;
            }
        }
        return (d) invokeL.objValue;
    }
}
