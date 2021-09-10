package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f37675a;

    /* renamed from: com.baidu.android.pushservice.message.a$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37676a;
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
            f37676a = iArr;
            try {
                iArr[h.f37714b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37676a[h.f37715c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37676a[h.f37719g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37676a[h.f37716d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37676a[h.f37718f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37676a[h.f37717e.ordinal()] = 6;
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
        this.f37675a = context;
    }

    public c a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            int i2 = AnonymousClass1.f37676a[hVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return new l(this.f37675a);
                }
                if (i2 != 6) {
                    return null;
                }
                return new j(this.f37675a);
            }
            return new b(this.f37675a);
        }
        return (c) invokeL.objValue;
    }
}
