package b.a.r.f.a;

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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static b f14448i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f14449a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f14450b;

    /* renamed from: c  reason: collision with root package name */
    public c f14451c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r.f.a.k.b f14452d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f14453e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f14454f;

    /* renamed from: g  reason: collision with root package name */
    public j f14455g;

    /* renamed from: h  reason: collision with root package name */
    public Context f14456h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14457e;

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
            this.f14457e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f14457e;
                bVar.f14451c = new g(bVar.f14456h);
                if (this.f14457e.f14455g != null) {
                    this.f14457e.f14455g.a(this.f14457e.f14451c.a());
                    z = this.f14457e.f14455g.a();
                } else {
                    z = false;
                }
                if (z && this.f14457e.k()) {
                    this.f14457e.m();
                    this.f14457e.o();
                }
                this.f14457e.f14449a = null;
            }
        }
    }

    /* renamed from: b.a.r.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0731b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C0731b f14458a;
        public transient /* synthetic */ FieldHolder $fh;

        public C0731b(Context context) {
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
            if (b.f14448i == null) {
                synchronized (b.class) {
                    if (b.f14448i == null) {
                        b unused = b.f14448i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C0731b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f14458a == null) {
                    synchronized (b.class) {
                        if (f14458a == null) {
                            f14458a = new C0731b(context);
                        }
                    }
                }
                return f14458a;
            }
            return (C0731b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.f14448i.f14453e = new HashMap();
                b.f14448i.f14453e.put(BOSTokenRequest.CHARSET, "utf-8");
                b.f14448i.f14453e.put("Content-type", "application/json");
                b.f14448i.f14452d = new b.a.r.f.a.r.a();
            }
        }

        public b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (b.f14448i.f14452d == null) {
                    a();
                }
                return b.f14448i;
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
        this.f14450b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f14456h = context;
        this.f14455g = new o(context);
    }

    public /* synthetic */ b(Context context, b.a.r.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f14454f;
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
        b.a.r.f.a.k.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            b.a.r.f.a.k.b bVar = this.f14452d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f14453e, this.f14451c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f14455g) == null) {
            return;
        }
        jVar.b(this.f14451c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.f14450b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (b.class) {
                if (this.f14450b.get() == 0) {
                    if (this.f14456h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f14450b.set(1);
                    if (this.f14449a == null) {
                        this.f14449a = new Thread(h());
                    }
                    this.f14449a.start();
                }
            }
        }
    }
}
