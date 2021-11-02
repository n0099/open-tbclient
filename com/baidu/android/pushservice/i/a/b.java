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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.i.a.b$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35636a;
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
            f35636a = iArr;
            try {
                iArr[a.e.f35478b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35636a[a.e.f35479c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35636a[a.e.f35480d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35636a[a.e.f35481e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35636a[a.e.f35482f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f35637a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f35638b;

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
            this.f35638b = aVar;
            this.f35637a = context;
            aVar.f35030a = "";
            aVar.f35031b = "";
            aVar.f35032c = -1L;
            aVar.f35033d = "";
            aVar.f35034e = -1L;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f35638b.f35032c = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f35638b.f35030a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.f35637a, a.e.f35482f, this.f35638b);
            }
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f35638b.f35034e = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f35638b.f35031b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f35638b.f35033d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1566b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f35639a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f35640b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35641c;

        public C1566b(Context context) {
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
            this.f35640b = bVar;
            this.f35639a = context;
            bVar.f35043a = -1L;
            bVar.f35044b = -1L;
            bVar.f35045c = "";
            bVar.f35046d = -1L;
            bVar.f35047e = -1L;
            bVar.f35048f = "";
            bVar.f35049g = -1L;
        }

        public C1566b a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f35640b.f35043a = j;
                return this;
            }
            return (C1566b) invokeJ.objValue;
        }

        public C1566b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f35640b.f35045c = str;
                return this;
            }
            return (C1566b) invokeL.objValue;
        }

        public C1566b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f35641c = z;
                return this;
            }
            return (C1566b) invokeZ.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f35641c) {
                    e.a(this.f35639a).a(this.f35640b);
                } else {
                    b.b(this.f35639a, a.e.f35480d, this.f35640b);
                }
            }
        }

        public C1566b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f35640b.f35044b = j;
                return this;
            }
            return (C1566b) invokeJ.objValue;
        }

        public C1566b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f35640b.f35048f = str;
                return this;
            }
            return (C1566b) invokeL.objValue;
        }

        public C1566b c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.f35640b.f35047e = j;
                return this;
            }
            return (C1566b) invokeJ.objValue;
        }

        public C1566b d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f35640b.f35049g = j;
                return this;
            }
            return (C1566b) invokeJ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f35642a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f35643b;

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
            this.f35643b = cVar;
            this.f35642a = context;
            cVar.f35059a = "";
            cVar.f35060b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f35643b;
            cVar2.f35061c = "";
            cVar2.f35062d = 201001L;
        }

        public c a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f35643b.f35062d = j;
                return this;
            }
            return (c) invokeJ.objValue;
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f35643b.f35059a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f35643b.f35059a)) {
                return;
            }
            b.b(this.f35642a, a.e.f35478b, this.f35643b);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f35644a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f35645b;

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
            this.f35645b = eVar;
            this.f35644a = context;
            eVar.f35081a = "";
            eVar.f35082b = "";
            eVar.f35083c = -1L;
            eVar.f35084d = -1L;
            eVar.f35085e = -1L;
            eVar.f35086f = "";
            eVar.f35087g = -1L;
        }

        public d a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.f35645b.f35083c = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f35645b.f35081a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.f35644a, a.e.f35481e, this.f35645b);
            }
        }

        public d b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f35645b.f35084d = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f35645b.f35082b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.f35645b.f35085e = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f35645b.f35086f = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f35645b.f35087g = j;
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
                    public final /* synthetic */ a.e f35633a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f35634b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Object f35635c;

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
                        this.f35633a = eVar;
                        this.f35634b = applicationContext;
                        this.f35635c = obj;
                    }

                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (e.f35186a) {
                                int i2 = AnonymousClass2.f35636a[this.f35633a.ordinal()];
                                if (i2 == 1) {
                                    e.a(this.f35634b).a((com.baidu.android.pushservice.c.a.c) this.f35635c);
                                } else if (i2 == 2) {
                                    e.a(this.f35634b).a((com.baidu.android.pushservice.c.a.d) this.f35635c);
                                } else if (i2 == 3) {
                                    e.a(this.f35634b).a((com.baidu.android.pushservice.c.a.b) this.f35635c);
                                } else if (i2 == 4) {
                                    e.a(this.f35634b).a((com.baidu.android.pushservice.c.a.e) this.f35635c);
                                } else if (i2 == 5) {
                                    e.a(this.f35634b).a((com.baidu.android.pushservice.c.a.a) this.f35635c);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
