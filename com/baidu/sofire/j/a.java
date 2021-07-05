package com.baidu.sofire.j;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.o.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f10415a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b f10416b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10417c;

    /* renamed from: com.baidu.sofire.j.a$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10418a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(469290401, "Lcom/baidu/sofire/j/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(469290401, "Lcom/baidu/sofire/j/a$1;");
                    return;
                }
            }
            int[] iArr = new int[b.a.values().length];
            f10418a = iArr;
            try {
                iArr[b.a.f10463d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10418a[b.a.f10464e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10418a[b.a.f10462c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10418a[b.a.f10461b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10418a[b.a.f10460a.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10416b = null;
        this.f10417c = false;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f10415a == null) {
                synchronized (a.class) {
                    if (f10415a == null) {
                        f10415a = new a();
                    }
                }
            }
            return f10415a;
        }
        return (a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:4:0x0004, B:7:0x0009, B:24:0x0047, B:26:0x004b, B:18:0x0029, B:19:0x002d, B:20:0x0032, B:21:0x0035, B:22:0x003b, B:23:0x0041), top: B:34:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.sofire.j.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Context context, c cVar) {
        b cVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, context, cVar) != null) {
            return;
        }
        try {
            if (this.f10417c) {
                return;
            }
            this.f10417c = true;
            int i2 = AnonymousClass1.f10418a[b.a.a(Build.MANUFACTURER).ordinal()];
            if (i2 == 1) {
                cVar2 = new com.baidu.sofire.m.c();
            } else if (i2 == 2) {
                cVar2 = new com.baidu.sofire.l.c();
            } else if (i2 == 3) {
                cVar2 = new com.baidu.sofire.n.b();
            } else if (i2 != 4) {
                if (i2 == 5) {
                    this.f10416b = null;
                }
                if (this.f10416b == null) {
                    this.f10416b.a(context, cVar);
                    return;
                }
                return;
            } else {
                cVar2 = new com.baidu.sofire.k.b();
            }
            this.f10416b = cVar2;
            if (this.f10416b == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.f10416b;
            if (bVar == null) {
                return null;
            }
            try {
                return bVar.b();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
