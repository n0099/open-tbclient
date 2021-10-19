package com.baidu.android.pushservice.i.a;

import android.content.Context;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.j.g;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f37621a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1960875538, "Lcom/baidu/android/pushservice/i/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1960875538, "Lcom/baidu/android/pushservice/i/a/c;");
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && context != null && d.g(context) && g.a(context) && PushSettings.m(context)) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("upload_push_track", (short) 90, context) { // from class: com.baidu.android.pushservice.i.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f37622a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8, r9);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r8, Short.valueOf(r9), context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37622a = context;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.b(this.f37622a, false);
                    }
                }
            });
        }
    }

    public static /* synthetic */ int b() {
        int i2 = f37621a;
        f37621a = i2 + 1;
        return i2;
    }

    public static void b(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, aVar) == null) {
            aVar.a();
            e.a(context).f();
            f37621a = 0;
        }
    }

    public static void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, context, z) == null) {
            a aVar = new a();
            byte[] b2 = z ? aVar.b(context) : aVar.a(context);
            if (b2 == null || b2.length >= 307200) {
                b(context, aVar);
            } else {
                com.baidu.android.pushservice.i.b.a(context).a(null, b2, "", new com.baidu.android.pushservice.i.c(z, context, aVar) { // from class: com.baidu.android.pushservice.i.a.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f37623a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f37624b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f37625c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(z), context, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37623a = z;
                        this.f37624b = context;
                        this.f37625c = aVar;
                    }

                    @Override // com.baidu.android.pushservice.i.c
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f37623a) {
                            return;
                        }
                        PushSettings.l(this.f37624b);
                        if (i2 == 0) {
                            c.b(this.f37624b, this.f37625c);
                            int unused = c.f37621a = 0;
                            return;
                        }
                        int i3 = 1;
                        if (c.f37621a < 1) {
                            c.b(this.f37624b, false);
                            c.b();
                            return;
                        }
                        int unused2 = c.f37621a = 0;
                        int n = PushSettings.n(this.f37624b);
                        if (n >= 3) {
                            c.b(this.f37624b, this.f37625c);
                        } else {
                            i3 = 1 + n;
                        }
                        PushSettings.b(this.f37624b, i3);
                    }
                });
            }
        }
    }
}
