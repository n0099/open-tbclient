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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f35844a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f35845b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f35846c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f35847d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f35848e;

    /* loaded from: classes6.dex */
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
        this.f35845b = context.getApplicationContext();
        this.f35846c = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f35844a == null) {
                synchronized (c.class) {
                    if (f35844a == null) {
                        f35844a = new c(context);
                    }
                }
            }
            return f35844a;
        }
        return (c) invokeL.objValue;
    }

    private com.baidu.android.pushservice.h.c a(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, aVar, str)) == null) ? new com.baidu.android.pushservice.d.g(this.f35845b, str, new g.a(this, aVar) { // from class: com.baidu.android.pushservice.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35851a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f35852b;

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
                this.f35852b = this;
                this.f35851a = aVar;
            }

            @Override // com.baidu.android.pushservice.d.g.a
            public void a(List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    if (this.f35852b.f35846c != null) {
                        this.f35852b.f35846c.removeCallbacksAndMessages(null);
                    }
                    if (this.f35852b.f35848e) {
                        this.f35852b.f35848e = false;
                    } else {
                        this.f35851a.a(0, list);
                    }
                }
            }
        }) : (com.baidu.android.pushservice.h.c) invokeLL.objValue;
    }

    private com.baidu.android.pushservice.h.c b(a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, aVar, str)) == null) ? new com.baidu.android.pushservice.d.j(this.f35845b, str, new j.a(this, aVar) { // from class: com.baidu.android.pushservice.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35853a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f35854b;

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
                this.f35854b = this;
                this.f35853a = aVar;
            }

            @Override // com.baidu.android.pushservice.d.j.a
            public void a(int i2, List<String> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                    this.f35853a.a(i2, list);
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
            c2 = h.d(this.f35845b);
        } else if (i2 != 1) {
            if (i2 == 2) {
                if (this.f35847d == null) {
                    this.f35847d = new Runnable(this, aVar) { // from class: com.baidu.android.pushservice.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f35849a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f35850b;

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
                            this.f35850b = this;
                            this.f35849a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f35850b.f35848e = true;
                                this.f35849a.a(-1, null);
                            }
                        }
                    };
                }
                this.f35846c.postDelayed(this.f35847d, 5000L);
                a2 = a(aVar, h.c(this.f35845b));
                if (a2 == null) {
                    com.baidu.android.pushservice.h.d.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            c2 = h.c(this.f35845b);
        }
        a2 = b(aVar, c2);
        if (a2 == null) {
        }
    }
}
