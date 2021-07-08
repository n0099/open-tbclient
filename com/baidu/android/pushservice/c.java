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
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f2786a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f2787b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f2788c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f2789d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f2790e;

    /* loaded from: classes.dex */
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
        this.f2787b = context.getApplicationContext();
        this.f2788c = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f2786a == null) {
                synchronized (c.class) {
                    if (f2786a == null) {
                        f2786a = new c(context);
                    }
                }
            }
            return f2786a;
        }
        return (c) invokeL.objValue;
    }

    private com.baidu.android.pushservice.h.c a(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, aVar, str)) == null) ? new com.baidu.android.pushservice.d.g(this.f2787b, str, new g.a(this, aVar) { // from class: com.baidu.android.pushservice.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f2793a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f2794b;

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
                this.f2794b = this;
                this.f2793a = aVar;
            }

            @Override // com.baidu.android.pushservice.d.g.a
            public void a(List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    if (this.f2794b.f2788c != null) {
                        this.f2794b.f2788c.removeCallbacksAndMessages(null);
                    }
                    if (this.f2794b.f2790e) {
                        this.f2794b.f2790e = false;
                    } else {
                        this.f2793a.a(0, list);
                    }
                }
            }
        }) : (com.baidu.android.pushservice.h.c) invokeLL.objValue;
    }

    private com.baidu.android.pushservice.h.c b(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, aVar, str)) == null) ? new com.baidu.android.pushservice.d.j(this.f2787b, str, new j.a(this, aVar) { // from class: com.baidu.android.pushservice.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f2795a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f2796b;

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
                this.f2796b = this;
                this.f2795a = aVar;
            }

            @Override // com.baidu.android.pushservice.d.j.a
            public void a(int i2, List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                    this.f2795a.a(i2, list);
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
            c2 = h.d(this.f2787b);
        } else if (i2 != 1) {
            if (i2 == 2) {
                if (this.f2789d == null) {
                    this.f2789d = new Runnable(this, aVar) { // from class: com.baidu.android.pushservice.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f2791a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f2792b;

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
                            this.f2792b = this;
                            this.f2791a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f2792b.f2790e = true;
                                this.f2791a.a(-1, null);
                            }
                        }
                    };
                }
                this.f2788c.postDelayed(this.f2789d, 5000L);
                a2 = a(aVar, h.c(this.f2787b));
                if (a2 == null) {
                    com.baidu.android.pushservice.h.d.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            c2 = h.c(this.f2787b);
        }
        a2 = b(aVar, c2);
        if (a2 == null) {
        }
    }
}
