package com.baidu.android.pushservice.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.i.a.a.a;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.i.a.b$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3404a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1089200641, "Lcom/baidu/android/pushservice/i/a/b$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1089200641, "Lcom/baidu/android/pushservice/i/a/b$2;");
                    return;
                }
            }
            int[] iArr = new int[a.e.a().length];
            f3404a = iArr;
            try {
                iArr[a.e.f3246b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3404a[a.e.f3247c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3404a[a.e.f3248d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3404a[a.e.f3249e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3404a[a.e.f3250f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f3405a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3406b;

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
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3406b = aVar;
            this.f3405a = context;
            aVar.f2798a = "";
            aVar.f2799b = "";
            aVar.f2800c = -1L;
            aVar.f2801d = "";
            aVar.f2802e = -1L;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f3406b.f2800c = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f3406b.f2798a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.f3405a, a.e.f3250f, this.f3406b);
            }
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f3406b.f2802e = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f3406b.f2799b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f3406b.f2801d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0053b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f3407a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3408b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3409c;

        public C0053b(Context context) {
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
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3408b = bVar;
            this.f3407a = context;
            bVar.f2811a = -1L;
            bVar.f2812b = -1L;
            bVar.f2813c = "";
            bVar.f2814d = -1L;
            bVar.f2815e = -1L;
            bVar.f2816f = "";
            bVar.f2817g = -1L;
        }

        public C0053b a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f3408b.f2811a = j;
                return this;
            }
            return (C0053b) invokeJ.objValue;
        }

        public C0053b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f3408b.f2813c = str;
                return this;
            }
            return (C0053b) invokeL.objValue;
        }

        public C0053b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f3409c = z;
                return this;
            }
            return (C0053b) invokeZ.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f3409c) {
                    e.a(this.f3407a).a(this.f3408b);
                } else {
                    b.b(this.f3407a, a.e.f3248d, this.f3408b);
                }
            }
        }

        public C0053b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f3408b.f2812b = j;
                return this;
            }
            return (C0053b) invokeJ.objValue;
        }

        public C0053b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f3408b.f2816f = str;
                return this;
            }
            return (C0053b) invokeL.objValue;
        }

        public C0053b c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.f3408b.f2815e = j;
                return this;
            }
            return (C0053b) invokeJ.objValue;
        }

        public C0053b d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f3408b.f2817g = j;
                return this;
            }
            return (C0053b) invokeJ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f3410a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3411b;

        public c(Context context) {
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
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3411b = cVar;
            this.f3410a = context;
            cVar.f2827a = "";
            cVar.f2828b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3411b;
            cVar2.f2829c = "";
            cVar2.f2830d = 201001L;
        }

        public c a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f3411b.f2830d = j;
                return this;
            }
            return (c) invokeJ.objValue;
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f3411b.f2827a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f3411b.f2827a)) {
                return;
            }
            b.b(this.f3410a, a.e.f3246b, this.f3411b);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f3412a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3413b;

        public d(Context context) {
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
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3413b = eVar;
            this.f3412a = context;
            eVar.f2849a = "";
            eVar.f2850b = "";
            eVar.f2851c = -1L;
            eVar.f2852d = -1L;
            eVar.f2853e = -1L;
            eVar.f2854f = "";
            eVar.f2855g = -1L;
        }

        public d a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f3413b.f2851c = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f3413b.f2849a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.f3412a, a.e.f3249e, this.f3413b);
            }
        }

        public d b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f3413b.f2852d = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f3413b.f2850b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.f3413b.f2853e = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f3413b.f2854f = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f3413b.f2855g = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }
    }

    public static void b(Context context, a.e eVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, eVar, obj) == null) {
            Context applicationContext = context.getApplicationContext();
            if (com.baidu.android.pushservice.b.d.g(applicationContext)) {
                com.baidu.android.pushservice.h.d a2 = com.baidu.android.pushservice.h.d.a();
                a2.a(new com.baidu.android.pushservice.h.c("reportTracker - " + eVar.name(), (short) 90, eVar, applicationContext, obj) { // from class: com.baidu.android.pushservice.i.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a.e f3401a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f3402b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Object f3403c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8, r9);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r8, Short.valueOf(r9), eVar, applicationContext, obj};
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
                        this.f3401a = eVar;
                        this.f3402b = applicationContext;
                        this.f3403c = obj;
                    }

                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (e.f2954a) {
                                int i2 = AnonymousClass2.f3404a[this.f3401a.ordinal()];
                                if (i2 == 1) {
                                    e.a(this.f3402b).a((com.baidu.android.pushservice.c.a.c) this.f3403c);
                                } else if (i2 == 2) {
                                    e.a(this.f3402b).a((com.baidu.android.pushservice.c.a.d) this.f3403c);
                                } else if (i2 == 3) {
                                    e.a(this.f3402b).a((com.baidu.android.pushservice.c.a.b) this.f3403c);
                                } else if (i2 == 4) {
                                    e.a(this.f3402b).a((com.baidu.android.pushservice.c.a.e) this.f3403c);
                                } else if (i2 == 5) {
                                    e.a(this.f3402b).a((com.baidu.android.pushservice.c.a.a) this.f3403c);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
