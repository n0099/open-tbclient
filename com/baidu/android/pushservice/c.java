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
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f32709b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f32710c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f32711d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f32712e;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i2, List<String> list);
    }

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
        this.f32709b = context.getApplicationContext();
        this.f32710c = new Handler(context.getMainLooper());
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, aVar, str)) == null) ? new com.baidu.android.pushservice.httpapi.g(this.f32709b, str, new g.a(this, aVar) { // from class: com.baidu.android.pushservice.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f32714b;

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
                this.f32714b = this;
                this.a = aVar;
            }

            @Override // com.baidu.android.pushservice.httpapi.g.a
            public void a(List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    if (this.f32714b.f32710c != null) {
                        this.f32714b.f32710c.removeCallbacksAndMessages(null);
                    }
                    if (this.f32714b.f32712e) {
                        this.f32714b.f32712e = false;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, aVar, str)) == null) ? new com.baidu.android.pushservice.httpapi.j(this.f32709b, str, new j.a(this, aVar) { // from class: com.baidu.android.pushservice.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f32715b;

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
                this.f32715b = this;
                this.a = aVar;
            }

            @Override // com.baidu.android.pushservice.httpapi.j.a
            public void a(int i2, List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                    this.a.a(i2, list);
                }
            }
        }) : (com.baidu.android.pushservice.g.c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, a aVar) {
        com.baidu.android.pushservice.g.c a2;
        String c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (i2 == 0) {
            c2 = g.d(this.f32709b);
        } else if (i2 != 1) {
            if (i2 == 2) {
                if (this.f32711d == null) {
                    this.f32711d = new Runnable(this, aVar) { // from class: com.baidu.android.pushservice.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f32713b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f32713b = this;
                            this.a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f32713b.f32712e = true;
                                this.a.a(-1, null);
                            }
                        }
                    };
                }
                this.f32710c.postDelayed(this.f32711d, 5000L);
                a2 = a(aVar, g.c(this.f32709b));
                if (a2 == null) {
                    com.baidu.android.pushservice.g.e.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            c2 = g.c(this.f32709b);
        }
        a2 = b(aVar, c2);
        if (a2 == null) {
        }
    }
}
