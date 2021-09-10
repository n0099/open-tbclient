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
    public static b f15338i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f15339a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f15340b;

    /* renamed from: c  reason: collision with root package name */
    public c f15341c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r.f.a.k.b f15342d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f15343e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f15344f;

    /* renamed from: g  reason: collision with root package name */
    public j f15345g;

    /* renamed from: h  reason: collision with root package name */
    public Context f15346h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15347e;

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
            this.f15347e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f15347e;
                bVar.f15341c = new g(bVar.f15346h);
                if (this.f15347e.f15345g != null) {
                    this.f15347e.f15345g.a(this.f15347e.f15341c.a());
                    z = this.f15347e.f15345g.a();
                } else {
                    z = false;
                }
                if (z && this.f15347e.k()) {
                    this.f15347e.m();
                    this.f15347e.o();
                }
                this.f15347e.f15339a = null;
            }
        }
    }

    /* renamed from: c.a.r.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0735b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C0735b f15348a;
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
            if (b.f15338i == null) {
                synchronized (b.class) {
                    if (b.f15338i == null) {
                        b unused = b.f15338i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C0735b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f15348a == null) {
                    synchronized (b.class) {
                        if (f15348a == null) {
                            f15348a = new C0735b(context);
                        }
                    }
                }
                return f15348a;
            }
            return (C0735b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.f15338i.f15343e = new HashMap();
                b.f15338i.f15343e.put(BOSTokenRequest.CHARSET, "utf-8");
                b.f15338i.f15343e.put("Content-type", "application/json");
                b.f15338i.f15342d = new c.a.r.f.a.r.a();
            }
        }

        public b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (b.f15338i.f15342d == null) {
                    a();
                }
                return b.f15338i;
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
        this.f15340b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f15346h = context;
        this.f15345g = new o(context);
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
            HashMap<String, String> hashMap = this.f15344f;
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
            c.a.r.f.a.k.b bVar = this.f15342d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f15343e, this.f15341c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f15345g) == null) {
            return;
        }
        jVar.b(this.f15341c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.f15340b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (b.class) {
                if (this.f15340b.get() == 0) {
                    if (this.f15346h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f15340b.set(1);
                    if (this.f15339a == null) {
                        this.f15339a = new Thread(h());
                    }
                    this.f15339a.start();
                }
            }
        }
    }
}
