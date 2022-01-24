package com.baidu.android.pushservice.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.h.a.a.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.h.a.b$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-653609694, "Lcom/baidu/android/pushservice/h/a/b$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-653609694, "Lcom/baidu/android/pushservice/h/a/b$2;");
                    return;
                }
            }
            int[] iArr = new int[a.e.a().length];
            a = iArr;
            try {
                iArr[a.e.f32051b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.e.f32052c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.e.f32053d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.e.f32054e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[a.e.f32055f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f32193b;

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
            this.f32193b = aVar;
            this.a = context;
            aVar.a = "";
            aVar.f31707b = "";
            aVar.f31708c = -1L;
            aVar.f31709d = "";
            aVar.f31710e = -1L;
        }

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f32193b.f31708c = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f32193b.a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.a, a.e.f32055f, this.f32193b);
            }
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.f32193b.f31710e = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f32193b.f31707b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f32193b.f31709d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: com.baidu.android.pushservice.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C1743b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f32194b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f32195c;

        public C1743b(Context context) {
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
            this.f32194b = bVar;
            this.a = context;
            bVar.a = -1L;
            bVar.f31718b = -1L;
            bVar.f31719c = "";
            bVar.f31720d = -1L;
            bVar.f31721e = -1L;
            bVar.f31722f = "";
            bVar.f31723g = -1L;
        }

        public C1743b a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f32194b.a = j2;
                return this;
            }
            return (C1743b) invokeJ.objValue;
        }

        public C1743b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f32194b.f31719c = str;
                return this;
            }
            return (C1743b) invokeL.objValue;
        }

        public C1743b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f32195c = z;
                return this;
            }
            return (C1743b) invokeZ.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f32195c) {
                    e.a(this.a).a(this.f32194b);
                } else {
                    b.b(this.a, a.e.f32053d, this.f32194b);
                }
            }
        }

        public C1743b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                this.f32194b.f31718b = j2;
                return this;
            }
            return (C1743b) invokeJ.objValue;
        }

        public C1743b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f32194b.f31722f = str;
                return this;
            }
            return (C1743b) invokeL.objValue;
        }

        public C1743b c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                this.f32194b.f31721e = j2;
                return this;
            }
            return (C1743b) invokeJ.objValue;
        }

        public C1743b d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                this.f32194b.f31723g = j2;
                return this;
            }
            return (C1743b) invokeJ.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f32196b;

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
            this.f32196b = cVar;
            this.a = context;
            cVar.a = "";
            cVar.f31733b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f32196b;
            cVar2.f31734c = "";
            cVar2.f31735d = 201001L;
        }

        public c a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f32196b.f31735d = j2;
                return this;
            }
            return (c) invokeJ.objValue;
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f32196b.a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f32196b.a)) {
                return;
            }
            b.b(this.a, a.e.f32051b, this.f32196b);
        }
    }

    /* loaded from: classes10.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f32197b;

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
            this.f32197b = eVar;
            this.a = context;
            eVar.a = "";
            eVar.f31753b = "";
            eVar.f31754c = -1L;
            eVar.f31755d = -1L;
            eVar.f31756e = -1L;
            eVar.f31757f = "";
            eVar.f31758g = -1L;
        }

        public d a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f32197b.f31754c = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f32197b.a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.a, a.e.f32054e, this.f32197b);
            }
        }

        public d b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.f32197b.f31755d = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f32197b.f31753b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                this.f32197b.f31756e = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f32197b.f31757f = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                this.f32197b.f31758g = j2;
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
                com.baidu.android.pushservice.g.e a2 = com.baidu.android.pushservice.g.e.a();
                a2.a(new com.baidu.android.pushservice.g.c("reportTracker - " + eVar.name(), (short) 90, eVar, applicationContext, obj) { // from class: com.baidu.android.pushservice.h.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a.e a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f32191b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Object f32192c;

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
                        this.a = eVar;
                        this.f32191b = applicationContext;
                        this.f32192c = obj;
                    }

                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (e.a) {
                                int i2 = AnonymousClass2.a[this.a.ordinal()];
                                if (i2 == 1) {
                                    e.a(this.f32191b).a((com.baidu.android.pushservice.c.a.c) this.f32192c);
                                } else if (i2 == 2) {
                                    e.a(this.f32191b).a((com.baidu.android.pushservice.c.a.d) this.f32192c);
                                } else if (i2 == 3) {
                                    e.a(this.f32191b).a((com.baidu.android.pushservice.c.a.b) this.f32192c);
                                } else if (i2 == 4) {
                                    e.a(this.f32191b).a((com.baidu.android.pushservice.c.a.e) this.f32192c);
                                } else if (i2 == 5) {
                                    e.a(this.f32191b).a((com.baidu.android.pushservice.c.a.a) this.f32192c);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
