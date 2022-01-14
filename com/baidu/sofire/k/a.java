package com.baidu.sofire.k;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.p.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b f38476b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38477c;

    /* renamed from: com.baidu.sofire.k.a$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(497919552, "Lcom/baidu/sofire/k/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(497919552, "Lcom/baidu/sofire/k/a$1;");
                    return;
                }
            }
            int[] iArr = new int[b.a.values().length];
            a = iArr;
            try {
                iArr[b.a.f38505d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.a.f38506e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.a.f38504c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.a.f38503b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.a.a.ordinal()] = 5;
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
        this.f38476b = null;
        this.f38477c = false;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:4:0x0004, B:7:0x0009, B:24:0x0047, B:26:0x004b, B:18:0x0029, B:19:0x002d, B:20:0x0032, B:21:0x0035, B:22:0x003b, B:23:0x0041), top: B:34:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.sofire.k.b
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
            if (this.f38477c) {
                return;
            }
            this.f38477c = true;
            int i2 = AnonymousClass1.a[b.a.a(Build.MANUFACTURER).ordinal()];
            if (i2 == 1) {
                cVar2 = new com.baidu.sofire.n.c();
            } else if (i2 == 2) {
                cVar2 = new com.baidu.sofire.m.c();
            } else if (i2 == 3) {
                cVar2 = new com.baidu.sofire.o.b();
            } else if (i2 != 4) {
                if (i2 == 5) {
                    this.f38476b = null;
                }
                if (this.f38476b == null) {
                    this.f38476b.a(context, cVar);
                    return;
                }
                return;
            } else {
                cVar2 = new com.baidu.sofire.l.b();
            }
            this.f38476b = cVar2;
            if (this.f38476b == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.sofire.k.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.f38476b;
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
