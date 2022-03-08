package c.a.q.g.a;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static a f11626i;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f11627b;

    /* renamed from: c  reason: collision with root package name */
    public c f11628c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q.g.a.k.b f11629d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f11630e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f11631f;

    /* renamed from: g  reason: collision with root package name */
    public j f11632g;

    /* renamed from: h  reason: collision with root package name */
    public Context f11633h;

    /* renamed from: c.a.q.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0799a {
        public static /* synthetic */ Interceptable $ic;
        public static C0799a a;
        public transient /* synthetic */ FieldHolder $fh;

        public C0799a(Context context) {
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
            if (a.f11626i == null) {
                synchronized (a.class) {
                    if (a.f11626i == null) {
                        a unused = a.f11626i = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C0799a c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (a == null) {
                    synchronized (a.class) {
                        if (a == null) {
                            a = new C0799a(context);
                        }
                    }
                }
                return a;
            }
            return (C0799a) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.f11626i.f11630e = new HashMap();
                a.f11626i.f11630e.put(BOSTokenRequest.CHARSET, "utf-8");
                a.f11626i.f11630e.put("Content-type", "application/json");
                a.f11626i.f11629d = new c.a.q.g.a.r.a();
            }
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (a.f11626i.f11629d == null) {
                    a();
                }
                return a.f11626i;
            }
            return (a) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11634e;

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
            this.f11634e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f11634e;
                aVar.f11628c = new g(aVar.f11633h);
                if (this.f11634e.f11632g != null) {
                    this.f11634e.f11632g.a(this.f11634e.f11628c.a());
                    z = this.f11634e.f11632g.b();
                } else {
                    z = false;
                }
                if (z && this.f11634e.k()) {
                    this.f11634e.o();
                    this.f11634e.m();
                }
                this.f11634e.a = null;
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
        this.f11627b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f11633h = context;
        this.f11632g = new o(context);
    }

    public /* synthetic */ a(Context context, c.a.q.g.a.b bVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f11631f;
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
        c.a.q.g.a.k.c a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            c.a.q.g.a.k.b bVar = this.f11629d;
            JSONObject a2 = n.a((bVar == null || (a = bVar.a()) == null) ? null : a.a(e2, "POST", this.f11630e, this.f11628c.a()));
            return a2 != null && a2.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicInteger = this.f11627b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public final void o() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f11632g) == null) {
            return;
        }
        jVar.b(this.f11628c.a());
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (a.class) {
                if (this.f11627b.get() == 0) {
                    if (this.f11633h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f11627b.set(1);
                    if (this.a == null) {
                        this.a = new Thread(h());
                    }
                    this.a.start();
                }
            }
        }
    }
}
