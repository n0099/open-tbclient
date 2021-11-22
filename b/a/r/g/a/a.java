package b.a.r.g.a;

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
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static a f15269i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f15270a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f15271b;

    /* renamed from: c  reason: collision with root package name */
    public c f15272c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r.g.a.k.b f15273d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f15274e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f15275f;

    /* renamed from: g  reason: collision with root package name */
    public j f15276g;

    /* renamed from: h  reason: collision with root package name */
    public Context f15277h;

    /* renamed from: b.a.r.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0772a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C0772a f15278a;
        public transient /* synthetic */ FieldHolder $fh;

        public C0772a(Context context) {
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
            if (a.f15269i == null) {
                synchronized (a.class) {
                    if (a.f15269i == null) {
                        a unused = a.f15269i = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C0772a c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f15278a == null) {
                    synchronized (a.class) {
                        if (f15278a == null) {
                            f15278a = new C0772a(context);
                        }
                    }
                }
                return f15278a;
            }
            return (C0772a) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.f15269i.f15274e = new HashMap();
                a.f15269i.f15274e.put(BOSTokenRequest.CHARSET, "utf-8");
                a.f15269i.f15274e.put("Content-type", "application/json");
                a.f15269i.f15273d = new b.a.r.g.a.r.a();
            }
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (a.f15269i.f15273d == null) {
                    a();
                }
                return a.f15269i;
            }
            return (a) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15279e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15279e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f15279e;
                aVar.f15272c = new g(aVar.f15277h);
                if (this.f15279e.f15276g != null) {
                    this.f15279e.f15276g.a(this.f15279e.f15272c.a());
                    z = this.f15279e.f15276g.b();
                } else {
                    z = false;
                }
                if (z && this.f15279e.k()) {
                    this.f15279e.o();
                    this.f15279e.m();
                }
                this.f15279e.f15270a = null;
            }
        }
    }

    public a(Context context) {
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
        this.f15271b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f15277h = context;
        this.f15276g = new o(context);
    }

    public /* synthetic */ a(Context context, b.a.r.g.a.b bVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f15275f;
            return hashMap == null ? str : q.a(str, hashMap);
        }
        return (String) invokeL.objValue;
    }

    public final Runnable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (Runnable) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        b.a.r.g.a.k.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            b.a.r.g.a.k.b bVar = this.f15273d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f15274e, this.f15272c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicInteger = this.f15271b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public final void o() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f15276g) == null) {
            return;
        }
        jVar.b(this.f15272c.a());
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (a.class) {
                if (this.f15271b.get() == 0) {
                    if (this.f15277h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f15271b.set(1);
                    if (this.f15270a == null) {
                        this.f15270a = new Thread(h());
                    }
                    this.f15270a.start();
                }
            }
        }
    }
}
