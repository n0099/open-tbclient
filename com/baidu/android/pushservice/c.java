package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.pushservice.httpapi.g;
import com.baidu.android.pushservice.httpapi.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f24206b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f24207c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f24208d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f24209e;

    /* loaded from: classes3.dex */
    public interface a {
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
        this.f24206b = context.getApplicationContext();
        this.f24207c = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c(context);
                    }
                }
            }
            return a;
        }
        return (c) invokeL.objValue;
    }

    private com.baidu.android.pushservice.g.c a(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, aVar, str)) == null) ? new com.baidu.android.pushservice.httpapi.g(this.f24206b, str, new g.a(this, aVar) { // from class: com.baidu.android.pushservice.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f24211b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24211b = this;
                this.a = aVar;
            }

            @Override // com.baidu.android.pushservice.httpapi.g.a
            public void a(List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    if (this.f24211b.f24207c != null) {
                        this.f24211b.f24207c.removeCallbacksAndMessages(null);
                    }
                    if (this.f24211b.f24209e) {
                        this.f24211b.f24209e = false;
                    } else {
                        this.a.a(0, list);
                    }
                }
            }
        }) : (com.baidu.android.pushservice.g.c) invokeLL.objValue;
    }

    private com.baidu.android.pushservice.g.c b(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, aVar, str)) == null) ? new com.baidu.android.pushservice.httpapi.j(this.f24206b, str, new j.a(this, aVar) { // from class: com.baidu.android.pushservice.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f24212b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24212b = this;
                this.a = aVar;
            }

            @Override // com.baidu.android.pushservice.httpapi.j.a
            public void a(int i, List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, list) == null) {
                    this.a.a(i, list);
                }
            }
        }) : (com.baidu.android.pushservice.g.c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, a aVar) {
        com.baidu.android.pushservice.g.c a2;
        String c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, aVar) == null) || aVar == null) {
            return;
        }
        if (i == 0) {
            c2 = g.d(this.f24206b);
        } else if (i != 1) {
            if (i == 2) {
                if (this.f24208d == null) {
                    this.f24208d = new Runnable(this, aVar) { // from class: com.baidu.android.pushservice.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f24210b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f24210b = this;
                            this.a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f24210b.f24209e = true;
                                this.a.a(-1, null);
                            }
                        }
                    };
                }
                this.f24207c.postDelayed(this.f24208d, 5000L);
                a2 = a(aVar, g.c(this.f24206b));
                if (a2 == null) {
                    com.baidu.android.pushservice.g.e.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            c2 = g.c(this.f24206b);
        }
        a2 = b(aVar, c2);
        if (a2 == null) {
        }
    }
}
