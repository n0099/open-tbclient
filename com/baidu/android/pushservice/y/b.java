package com.baidu.android.pushservice.y;

import android.content.Context;
import com.baidu.android.pushservice.w.j;
import com.baidu.android.pushservice.w.k;
import com.baidu.android.pushservice.w.m.l;
import com.baidu.android.pushservice.y.e.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676423343, "Lcom/baidu/android/pushservice/y/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676423343, "Lcom/baidu/android/pushservice/y/b;");
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            b = i;
        }
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            k kVar = new k();
            try {
                kVar.a(iVar.a());
                kVar.c(iVar.h());
                kVar.e(iVar.g());
                kVar.d(b);
                j.a(this.a, kVar, iVar.e().toString("UTF-8"));
            } catch (Exception unused) {
            }
            byte[] byteArray = iVar.f().toByteArray();
            l a = l.a(kVar.q());
            if (a != l.j && com.baidu.android.pushservice.m.d.a(this.a, kVar.g())) {
                String str = "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.";
                return;
            }
            com.baidu.android.pushservice.w.m.c a2 = new com.baidu.android.pushservice.w.m.k(this.a).a(a);
            int a3 = a2 != null ? a2.a(kVar, byteArray).a() : 2;
            if (a == l.c || a == l.d || a == l.h) {
                com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), byteArray, kVar.k(), kVar.c(), a3, kVar.i());
            } else if (a != l.j) {
                com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), null, null, 0L, a3, kVar.i());
            }
        }
    }
}
