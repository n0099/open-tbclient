package c.a.r.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static b f15370i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f15371a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f15372b;

    /* renamed from: c  reason: collision with root package name */
    public c f15373c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r.f.a.k.b f15374d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f15375e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f15376f;

    /* renamed from: g  reason: collision with root package name */
    public j f15377g;

    /* renamed from: h  reason: collision with root package name */
    public Context f15378h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15379e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15379e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f15379e;
                bVar.f15373c = new g(bVar.f15378h);
                if (this.f15379e.f15377g != null) {
                    this.f15379e.f15377g.a(this.f15379e.f15373c.a());
                    z = this.f15379e.f15377g.a();
                } else {
                    z = false;
                }
                if (z && this.f15379e.k()) {
                    this.f15379e.m();
                    this.f15379e.o();
                }
                this.f15379e.f15371a = null;
            }
        }
    }

    /* renamed from: c.a.r.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0735b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C0735b f15380a;
        public transient /* synthetic */ FieldHolder $fh;

        public C0735b(Context context) {
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
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (b.f15370i == null) {
                synchronized (b.class) {
                    if (b.f15370i == null) {
                        b unused = b.f15370i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C0735b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f15380a == null) {
                    synchronized (b.class) {
                        if (f15380a == null) {
                            f15380a = new C0735b(context);
                        }
                    }
                }
                return f15380a;
            }
            return (C0735b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.f15370i.f15375e = new HashMap();
                b.f15370i.f15375e.put(BOSTokenRequest.CHARSET, "utf-8");
                b.f15370i.f15375e.put("Content-type", "application/json");
                b.f15370i.f15374d = new c.a.r.f.a.r.a();
            }
        }

        public b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (b.f15370i.f15374d == null) {
                    a();
                }
                return b.f15370i;
            }
            return (b) invokeV.objValue;
        }
    }

    public b(Context context) {
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
        this.f15372b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f15378h = context;
        this.f15377g = new o(context);
    }

    public /* synthetic */ b(Context context, c.a.r.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f15376f;
            return hashMap == null ? str : q.b(str, hashMap);
        }
        return (String) invokeL.objValue;
    }

    public final Runnable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (Runnable) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        c.a.r.f.a.k.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            c.a.r.f.a.k.b bVar = this.f15374d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f15375e, this.f15373c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f15377g) == null) {
            return;
        }
        jVar.b(this.f15373c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.f15372b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (b.class) {
                if (this.f15372b.get() == 0) {
                    if (this.f15378h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f15372b.set(1);
                    if (this.f15371a == null) {
                        this.f15371a = new Thread(h());
                    }
                    this.f15371a.start();
                }
            }
        }
    }
}
