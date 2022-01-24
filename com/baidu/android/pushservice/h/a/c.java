package com.baidu.android.pushservice.h.a;

import android.content.Context;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.g.e;
import com.baidu.android.pushservice.i.g;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1989504689, "Lcom/baidu/android/pushservice/h/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1989504689, "Lcom/baidu/android/pushservice/h/a/c;");
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && context != null && d.g(context) && g.a(context) && PushSettings.n(context)) {
            e.a().a(new com.baidu.android.pushservice.g.c("upload_push_track", (short) 90, context) { // from class: com.baidu.android.pushservice.h.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

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
                    this.a = context;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.b(this.a, false);
                    }
                }
            });
        }
    }

    public static /* synthetic */ int b() {
        int i2 = a;
        a = i2 + 1;
        return i2;
    }

    public static void b(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, aVar) == null) {
            aVar.a();
            com.baidu.android.pushservice.c.e.a(context).f();
            a = 0;
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
                com.baidu.android.pushservice.h.b.a(context).a(null, b2, "", new com.baidu.android.pushservice.h.c(z, context, aVar) { // from class: com.baidu.android.pushservice.h.a.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f32198b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f32199c;

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
                        this.a = z;
                        this.f32198b = context;
                        this.f32199c = aVar;
                    }

                    @Override // com.baidu.android.pushservice.h.c
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.a) {
                            return;
                        }
                        PushSettings.m(this.f32198b);
                        if (i2 == 0) {
                            c.b(this.f32198b, this.f32199c);
                            int unused = c.a = 0;
                            return;
                        }
                        int i3 = 1;
                        if (c.a < 1) {
                            c.b(this.f32198b, false);
                            c.b();
                            return;
                        }
                        int unused2 = c.a = 0;
                        int o = PushSettings.o(this.f32198b);
                        if (o >= 3) {
                            c.b(this.f32198b, this.f32199c);
                        } else {
                            i3 = 1 + o;
                        }
                        PushSettings.b(this.f32198b, i3);
                    }
                });
            }
        }
    }
}
