package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.p.g;
import com.baidu.android.pushservice.p.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Handler b;
    public Runnable c;
    public volatile boolean d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ c b;

        public a(c cVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cVar;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d = true;
                this.a.a(-1, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ c b;

        public b(c cVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cVar;
            this.a = dVar;
        }

        @Override // com.baidu.android.pushservice.p.g.a
        public void a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                if (this.b.b != null) {
                    this.b.b.removeCallbacksAndMessages(null);
                }
                if (this.b.d) {
                    this.b.d = false;
                } else {
                    this.a.a(0, list);
                }
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0022c implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public C0022c(c cVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.android.pushservice.p.j.a
        public void a(int i, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
                this.a.a(i, list);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i, List<String> list);
    }

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
        this.a = context.getApplicationContext();
        this.b = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (e == null) {
                synchronized (c.class) {
                    if (e == null) {
                        e = new c(context);
                    }
                }
            }
            return e;
        }
        return (c) invokeL.objValue;
    }

    public final com.baidu.android.pushservice.z.c a(d dVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, str)) == null) ? new com.baidu.android.pushservice.p.g(this.a, str, new b(this, dVar)) : (com.baidu.android.pushservice.z.c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, d dVar) {
        com.baidu.android.pushservice.z.c a2;
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, dVar) == null) || dVar == null) {
            return;
        }
        if (i == 0) {
            b2 = g.a(this.a);
        } else if (i != 1) {
            if (i == 2) {
                if (this.c == null) {
                    this.c = new a(this, dVar);
                }
                this.b.postDelayed(this.c, 5000L);
                a2 = a(dVar, g.b(this.a));
                if (a2 == null) {
                    com.baidu.android.pushservice.z.e.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            b2 = g.b(this.a);
        }
        a2 = b(dVar, b2);
        if (a2 == null) {
        }
    }

    public final com.baidu.android.pushservice.z.c b(d dVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, str)) == null) ? new com.baidu.android.pushservice.p.j(this.a, str, new C0022c(this, dVar)) : (com.baidu.android.pushservice.z.c) invokeLL.objValue;
    }
}
