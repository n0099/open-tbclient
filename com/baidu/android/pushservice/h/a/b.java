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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.h.a.b$2  reason: invalid class name */
    /* loaded from: classes3.dex */
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
                iArr[a.e.f24521b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.e.f24522c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.e.f24523d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.e.f24524e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[a.e.f24525f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f24648b;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f24648b = aVar;
            this.a = context;
            aVar.a = "";
            aVar.f24215b = "";
            aVar.f24216c = -1L;
            aVar.f24217d = "";
            aVar.f24218e = -1L;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f24648b.f24216c = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f24648b.a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.a, a.e.f24525f, this.f24648b);
            }
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f24648b.f24218e = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f24648b.f24215b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f24648b.f24217d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: com.baidu.android.pushservice.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1697b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f24649b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f24650c;

        public C1697b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f24649b = bVar;
            this.a = context;
            bVar.a = -1L;
            bVar.f24226b = -1L;
            bVar.f24227c = "";
            bVar.f24228d = -1L;
            bVar.f24229e = -1L;
            bVar.f24230f = "";
            bVar.f24231g = -1L;
        }

        public C1697b a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f24649b.a = j;
                return this;
            }
            return (C1697b) invokeJ.objValue;
        }

        public C1697b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f24649b.f24227c = str;
                return this;
            }
            return (C1697b) invokeL.objValue;
        }

        public C1697b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f24650c = z;
                return this;
            }
            return (C1697b) invokeZ.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f24650c) {
                    e.a(this.a).a(this.f24649b);
                } else {
                    b.b(this.a, a.e.f24523d, this.f24649b);
                }
            }
        }

        public C1697b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f24649b.f24226b = j;
                return this;
            }
            return (C1697b) invokeJ.objValue;
        }

        public C1697b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f24649b.f24230f = str;
                return this;
            }
            return (C1697b) invokeL.objValue;
        }

        public C1697b c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.f24649b.f24229e = j;
                return this;
            }
            return (C1697b) invokeJ.objValue;
        }

        public C1697b d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f24649b.f24231g = j;
                return this;
            }
            return (C1697b) invokeJ.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f24651b;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f24651b = cVar;
            this.a = context;
            cVar.a = "";
            cVar.f24239b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f24651b;
            cVar2.f24240c = "";
            cVar2.f24241d = 201001L;
        }

        public c a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f24651b.f24241d = j;
                return this;
            }
            return (c) invokeJ.objValue;
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f24651b.a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f24651b.a)) {
                return;
            }
            b.b(this.a, a.e.f24521b, this.f24651b);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f24652b;

        public d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f24652b = eVar;
            this.a = context;
            eVar.a = "";
            eVar.f24256b = "";
            eVar.f24257c = -1L;
            eVar.f24258d = -1L;
            eVar.f24259e = -1L;
            eVar.f24260f = "";
            eVar.f24261g = -1L;
        }

        public d a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f24652b.f24257c = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f24652b.a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.a, a.e.f24524e, this.f24652b);
            }
        }

        public d b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f24652b.f24258d = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f24652b.f24256b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.f24652b.f24259e = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f24652b.f24260f = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f24652b.f24261g = j;
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
                    public final /* synthetic */ Context f24646b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Object f24647c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8, r9);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r8, Short.valueOf(r9), eVar, applicationContext, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = eVar;
                        this.f24646b = applicationContext;
                        this.f24647c = obj;
                    }

                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (e.a) {
                                int i = AnonymousClass2.a[this.a.ordinal()];
                                if (i == 1) {
                                    e.a(this.f24646b).a((com.baidu.android.pushservice.c.a.c) this.f24647c);
                                } else if (i == 2) {
                                    e.a(this.f24646b).a((com.baidu.android.pushservice.c.a.d) this.f24647c);
                                } else if (i == 3) {
                                    e.a(this.f24646b).a((com.baidu.android.pushservice.c.a.b) this.f24647c);
                                } else if (i == 4) {
                                    e.a(this.f24646b).a((com.baidu.android.pushservice.c.a.e) this.f24647c);
                                } else if (i == 5) {
                                    e.a(this.f24646b).a((com.baidu.android.pushservice.c.a.a) this.f24647c);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
