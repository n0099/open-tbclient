package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.pushservice.d.g;
import com.baidu.android.pushservice.d.j;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f36796a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f36797b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f36798c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f36799d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f36800e;

    /* loaded from: classes4.dex */
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
        this.f36797b = context.getApplicationContext();
        this.f36798c = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f36796a == null) {
                synchronized (c.class) {
                    if (f36796a == null) {
                        f36796a = new c(context);
                    }
                }
            }
            return f36796a;
        }
        return (c) invokeL.objValue;
    }

    private com.baidu.android.pushservice.h.c a(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, aVar, str)) == null) ? new com.baidu.android.pushservice.d.g(this.f36797b, str, new g.a(this, aVar) { // from class: com.baidu.android.pushservice.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f36803a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f36804b;

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
                this.f36804b = this;
                this.f36803a = aVar;
            }

            @Override // com.baidu.android.pushservice.d.g.a
            public void a(List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    if (this.f36804b.f36798c != null) {
                        this.f36804b.f36798c.removeCallbacksAndMessages(null);
                    }
                    if (this.f36804b.f36800e) {
                        this.f36804b.f36800e = false;
                    } else {
                        this.f36803a.a(0, list);
                    }
                }
            }
        }) : (com.baidu.android.pushservice.h.c) invokeLL.objValue;
    }

    private com.baidu.android.pushservice.h.c b(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, aVar, str)) == null) ? new com.baidu.android.pushservice.d.j(this.f36797b, str, new j.a(this, aVar) { // from class: com.baidu.android.pushservice.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f36805a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f36806b;

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
                this.f36806b = this;
                this.f36805a = aVar;
            }

            @Override // com.baidu.android.pushservice.d.j.a
            public void a(int i2, List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                    this.f36805a.a(i2, list);
                }
            }
        }) : (com.baidu.android.pushservice.h.c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, a aVar) {
        com.baidu.android.pushservice.h.c a2;
        String c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (i2 == 0) {
            c2 = h.d(this.f36797b);
        } else if (i2 != 1) {
            if (i2 == 2) {
                if (this.f36799d == null) {
                    this.f36799d = new Runnable(this, aVar) { // from class: com.baidu.android.pushservice.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f36801a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f36802b;

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
                            this.f36802b = this;
                            this.f36801a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f36802b.f36800e = true;
                                this.f36801a.a(-1, null);
                            }
                        }
                    };
                }
                this.f36798c.postDelayed(this.f36799d, 5000L);
                a2 = a(aVar, h.c(this.f36797b));
                if (a2 == null) {
                    com.baidu.android.pushservice.h.d.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            c2 = h.c(this.f36797b);
        }
        a2 = b(aVar, c2);
        if (a2 == null) {
        }
    }
}
