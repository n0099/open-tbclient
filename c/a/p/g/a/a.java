package c.a.p.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
    public static a i;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f11722b;

    /* renamed from: c  reason: collision with root package name */
    public c f11723c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p.g.a.k.b f11724d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f11725e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f11726f;

    /* renamed from: g  reason: collision with root package name */
    public j f11727g;

    /* renamed from: h  reason: collision with root package name */
    public Context f11728h;

    /* renamed from: c.a.p.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0889a {
        public static /* synthetic */ Interceptable $ic;
        public static C0889a a;
        public transient /* synthetic */ FieldHolder $fh;

        public C0889a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.i == null) {
                synchronized (a.class) {
                    if (a.i == null) {
                        a unused = a.i = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C0889a c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (a == null) {
                    synchronized (a.class) {
                        if (a == null) {
                            a = new C0889a(context);
                        }
                    }
                }
                return a;
            }
            return (C0889a) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.i.f11725e = new HashMap();
                a.i.f11725e.put(BOSTokenRequest.CHARSET, IMAudioTransRequest.CHARSET);
                a.i.f11725e.put("Content-type", "application/json");
                a.i.f11724d = new c.a.p.g.a.r.a();
            }
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (a.i.f11724d == null) {
                    a();
                }
                return a.i;
            }
            return (a) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.a;
                aVar.f11723c = new g(aVar.f11728h);
                if (this.a.f11727g != null) {
                    this.a.f11727g.a(this.a.f11723c.a());
                    z = this.a.f11727g.b();
                } else {
                    z = false;
                }
                if (z && this.a.k()) {
                    this.a.o();
                    this.a.m();
                }
                this.a.a = null;
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
        this.f11722b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f11728h = context;
        this.f11727g = new o(context);
    }

    public /* synthetic */ a(Context context, c.a.p.g.a.b bVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f11726f;
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
        c.a.p.g.a.k.c a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            c.a.p.g.a.k.b bVar = this.f11724d;
            JSONObject a2 = n.a((bVar == null || (a = bVar.a()) == null) ? null : a.a(e2, "POST", this.f11725e, this.f11723c.a()));
            return a2 != null && a2.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicInteger = this.f11722b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public final void o() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f11727g) == null) {
            return;
        }
        jVar.b(this.f11723c.a());
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (a.class) {
                if (this.f11722b.get() == 0) {
                    if (this.f11728h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f11722b.set(1);
                    if (this.a == null) {
                        this.a = new Thread(h());
                    }
                    this.a.start();
                }
            }
        }
    }
}
