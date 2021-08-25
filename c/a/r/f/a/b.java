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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static b f29508i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f29509a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f29510b;

    /* renamed from: c  reason: collision with root package name */
    public c f29511c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r.f.a.k.b f29512d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f29513e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f29514f;

    /* renamed from: g  reason: collision with root package name */
    public j f29515g;

    /* renamed from: h  reason: collision with root package name */
    public Context f29516h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29517e;

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
            this.f29517e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f29517e;
                bVar.f29511c = new g(bVar.f29516h);
                if (this.f29517e.f29515g != null) {
                    this.f29517e.f29515g.a(this.f29517e.f29511c.a());
                    z = this.f29517e.f29515g.a();
                } else {
                    z = false;
                }
                if (z && this.f29517e.k()) {
                    this.f29517e.m();
                    this.f29517e.o();
                }
                this.f29517e.f29509a = null;
            }
        }
    }

    /* renamed from: c.a.r.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1377b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1377b f29518a;
        public transient /* synthetic */ FieldHolder $fh;

        public C1377b(Context context) {
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
            if (b.f29508i == null) {
                synchronized (b.class) {
                    if (b.f29508i == null) {
                        b unused = b.f29508i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1377b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f29518a == null) {
                    synchronized (b.class) {
                        if (f29518a == null) {
                            f29518a = new C1377b(context);
                        }
                    }
                }
                return f29518a;
            }
            return (C1377b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.f29508i.f29513e = new HashMap();
                b.f29508i.f29513e.put(BOSTokenRequest.CHARSET, "utf-8");
                b.f29508i.f29513e.put("Content-type", "application/json");
                b.f29508i.f29512d = new c.a.r.f.a.r.a();
            }
        }

        public b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (b.f29508i.f29512d == null) {
                    a();
                }
                return b.f29508i;
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
        this.f29510b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f29516h = context;
        this.f29515g = new o(context);
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
            HashMap<String, String> hashMap = this.f29514f;
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
            c.a.r.f.a.k.b bVar = this.f29512d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f29513e, this.f29511c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f29515g) == null) {
            return;
        }
        jVar.b(this.f29511c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.f29510b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (b.class) {
                if (this.f29510b.get() == 0) {
                    if (this.f29516h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f29510b.set(1);
                    if (this.f29509a == null) {
                        this.f29509a = new Thread(h());
                    }
                    this.f29509a.start();
                }
            }
        }
    }
}
