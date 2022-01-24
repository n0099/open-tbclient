package c.a.r.g.a;

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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static a f5035i;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f5036b;

    /* renamed from: c  reason: collision with root package name */
    public c f5037c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r.g.a.k.b f5038d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f5039e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f5040f;

    /* renamed from: g  reason: collision with root package name */
    public j f5041g;

    /* renamed from: h  reason: collision with root package name */
    public Context f5042h;

    /* renamed from: c.a.r.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0257a {
        public static /* synthetic */ Interceptable $ic;
        public static C0257a a;
        public transient /* synthetic */ FieldHolder $fh;

        public C0257a(Context context) {
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
            if (a.f5035i == null) {
                synchronized (a.class) {
                    if (a.f5035i == null) {
                        a unused = a.f5035i = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C0257a c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (a == null) {
                    synchronized (a.class) {
                        if (a == null) {
                            a = new C0257a(context);
                        }
                    }
                }
                return a;
            }
            return (C0257a) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.f5035i.f5039e = new HashMap();
                a.f5035i.f5039e.put(BOSTokenRequest.CHARSET, "utf-8");
                a.f5035i.f5039e.put("Content-type", "application/json");
                a.f5035i.f5038d = new c.a.r.g.a.r.a();
            }
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (a.f5035i.f5038d == null) {
                    a();
                }
                return a.f5035i;
            }
            return (a) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5043e;

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
            this.f5043e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f5043e;
                aVar.f5037c = new g(aVar.f5042h);
                if (this.f5043e.f5041g != null) {
                    this.f5043e.f5041g.a(this.f5043e.f5037c.a());
                    z = this.f5043e.f5041g.b();
                } else {
                    z = false;
                }
                if (z && this.f5043e.k()) {
                    this.f5043e.o();
                    this.f5043e.m();
                }
                this.f5043e.a = null;
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
        this.f5036b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f5042h = context;
        this.f5041g = new o(context);
    }

    public /* synthetic */ a(Context context, c.a.r.g.a.b bVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f5040f;
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
        c.a.r.g.a.k.c a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            c.a.r.g.a.k.b bVar = this.f5038d;
            JSONObject a2 = n.a((bVar == null || (a = bVar.a()) == null) ? null : a.a(e2, "POST", this.f5039e, this.f5037c.a()));
            return a2 != null && a2.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicInteger = this.f5036b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public final void o() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f5041g) == null) {
            return;
        }
        jVar.b(this.f5037c.a());
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (a.class) {
                if (this.f5036b.get() == 0) {
                    if (this.f5042h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f5036b.set(1);
                    if (this.a == null) {
                        this.a = new Thread(h());
                    }
                    this.a.start();
                }
            }
        }
    }
}
