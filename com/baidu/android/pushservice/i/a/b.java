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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.i.a.b$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37334a;
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
            f37334a = iArr;
            try {
                iArr[a.e.f37170b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37334a[a.e.f37171c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37334a[a.e.f37172d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37334a[a.e.f37173e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37334a[a.e.f37174f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f37335a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f37336b;

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
            this.f37336b = aVar;
            this.f37335a = context;
            aVar.f36705a = "";
            aVar.f36706b = "";
            aVar.f36707c = -1L;
            aVar.f36708d = "";
            aVar.f36709e = -1L;
        }

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f37336b.f36707c = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f37336b.f36705a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.f37335a, a.e.f37174f, this.f37336b);
            }
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.f37336b.f36709e = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f37336b.f36706b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f37336b.f36708d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1599b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f37337a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f37338b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37339c;

        public C1599b(Context context) {
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
            this.f37338b = bVar;
            this.f37337a = context;
            bVar.f36718a = -1L;
            bVar.f36719b = -1L;
            bVar.f36720c = "";
            bVar.f36721d = -1L;
            bVar.f36722e = -1L;
            bVar.f36723f = "";
            bVar.f36724g = -1L;
        }

        public C1599b a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f37338b.f36718a = j2;
                return this;
            }
            return (C1599b) invokeJ.objValue;
        }

        public C1599b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f37338b.f36720c = str;
                return this;
            }
            return (C1599b) invokeL.objValue;
        }

        public C1599b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f37339c = z;
                return this;
            }
            return (C1599b) invokeZ.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f37339c) {
                    e.a(this.f37337a).a(this.f37338b);
                } else {
                    b.b(this.f37337a, a.e.f37172d, this.f37338b);
                }
            }
        }

        public C1599b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                this.f37338b.f36719b = j2;
                return this;
            }
            return (C1599b) invokeJ.objValue;
        }

        public C1599b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f37338b.f36723f = str;
                return this;
            }
            return (C1599b) invokeL.objValue;
        }

        public C1599b c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                this.f37338b.f36722e = j2;
                return this;
            }
            return (C1599b) invokeJ.objValue;
        }

        public C1599b d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                this.f37338b.f36724g = j2;
                return this;
            }
            return (C1599b) invokeJ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f37340a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f37341b;

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
            this.f37341b = cVar;
            this.f37340a = context;
            cVar.f36735a = "";
            cVar.f36736b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f37341b;
            cVar2.f36737c = "";
            cVar2.f36738d = 201001L;
        }

        public c a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f37341b.f36738d = j2;
                return this;
            }
            return (c) invokeJ.objValue;
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f37341b.f36735a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f37341b.f36735a)) {
                return;
            }
            b.b(this.f37340a, a.e.f37170b, this.f37341b);
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f37342a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f37343b;

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
            this.f37343b = eVar;
            this.f37342a = context;
            eVar.f36758a = "";
            eVar.f36759b = "";
            eVar.f36760c = -1L;
            eVar.f36761d = -1L;
            eVar.f36762e = -1L;
            eVar.f36763f = "";
            eVar.f36764g = -1L;
        }

        public d a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f37343b.f36760c = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f37343b.f36758a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.b(this.f37342a, a.e.f37173e, this.f37343b);
            }
        }

        public d b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.f37343b.f36761d = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f37343b.f36759b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                this.f37343b.f36762e = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f37343b.f36763f = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                this.f37343b.f36764g = j2;
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
                    public final /* synthetic */ a.e f37331a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f37332b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Object f37333c;

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
                        this.f37331a = eVar;
                        this.f37332b = applicationContext;
                        this.f37333c = obj;
                    }

                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (e.f36867a) {
                                int i2 = AnonymousClass2.f37334a[this.f37331a.ordinal()];
                                if (i2 == 1) {
                                    e.a(this.f37332b).a((com.baidu.android.pushservice.c.a.c) this.f37333c);
                                } else if (i2 == 2) {
                                    e.a(this.f37332b).a((com.baidu.android.pushservice.c.a.d) this.f37333c);
                                } else if (i2 == 3) {
                                    e.a(this.f37332b).a((com.baidu.android.pushservice.c.a.b) this.f37333c);
                                } else if (i2 == 4) {
                                    e.a(this.f37332b).a((com.baidu.android.pushservice.c.a.e) this.f37333c);
                                } else if (i2 == 5) {
                                    e.a(this.f37332b).a((com.baidu.android.pushservice.c.a.a) this.f37333c);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
