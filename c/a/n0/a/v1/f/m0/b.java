package c.a.n0.a.v1.f.m0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.k.c.d;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.e;
import c.a.n0.q.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.n0.a.k.e.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static c.a.n0.a.a0.a f6794f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.n0.a.v1.f.m0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0496a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f6795b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f6796c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f6797d;

            /* renamed from: c.a.n0.a.v1.f.m0.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0497a implements c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ RunnableC0496a f6798b;

                public C0497a(RunnableC0496a runnableC0496a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0496a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6798b = runnableC0496a;
                    this.a = str;
                }

                @Override // c.a.n0.q.e.c
                public void a(@Nullable Map<String, String> map) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                        if (map == null) {
                            c.a.n0.a.u.d.c("PreloadPackageApi", "preloadPackage keyMap null");
                            return;
                        }
                        RunnableC0496a runnableC0496a = this.f6798b;
                        runnableC0496a.f6797d.a.z(map.get(this.f6798b.f6795b), this.a, runnableC0496a.f6796c);
                    }
                }

                @Override // c.a.n0.q.e.c
                public void onFail(Exception exc) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                        c.a.n0.a.u.d.c("PreloadPackageApi", "preloadPackage transform openBundleId fail");
                    }
                }
            }

            public RunnableC0496a(a aVar, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6797d = aVar;
                this.a = jSONObject;
                this.f6795b = str;
                this.f6796c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean g2 = c.a.n0.q.j.j.b.e().g(!q0.G());
                    String optString = this.a.optString(PrefetchEvent.EVENT_KEY_PAGE_URL);
                    if (!g2) {
                        this.f6797d.a.z(this.f6795b, optString, this.f6796c);
                    } else {
                        c.a.n0.q.b.e(Collections.singletonList(this.f6795b), b.f6794f.c(), new C0497a(this, optString));
                    }
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.a.k.c.d.a
        public c.a.n0.a.k.h.b a(e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("appKey");
                if (!TextUtils.isEmpty(optString)) {
                    if (!b.f6794f.a(1)) {
                        return new c.a.n0.a.k.h.b(402, "over single max limit");
                    }
                    q.h().execute(new RunnableC0496a(this, jSONObject, optString, str), "PreloadPackageApi");
                    return c.a.n0.a.k.h.b.f();
                }
                return new c.a.n0.a.k.h.b(202, "appKey must not empty");
            }
            return (c.a.n0.a.k.h.b) invokeLLL.objValue;
        }
    }

    /* renamed from: c.a.n0.a.v1.f.m0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0498b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0498b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                String string = bundle.getString("appKey");
                String e1 = c.a.n0.a.v0.e.c.e1(string, bundle.getString(PrefetchEvent.EVENT_KEY_PAGE_URL), 0, null);
                PrefetchEvent.b bVar = new PrefetchEvent.b();
                bVar.e("show");
                bVar.d(e1);
                bVar.c("10");
                bVar.a(string);
                c.a.n0.a.x.o.d.g().f(bVar.b());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.n0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#preloadPackage", false);
            String a2 = c.a.n0.a.l.a.a(c.a.n0.a.t1.d.J().getAppId());
            if (TextUtils.isEmpty(a2)) {
                return new c.a.n0.a.k.h.b(101, "runtime parameter error");
            }
            c.a.n0.a.a0.a aVar = f6794f;
            if (aVar == null || !aVar.d(a2)) {
                f6794f = new c.a.n0.a.a0.a(a2, c.a.n0.q.j.i.t.a.b(a2));
            }
            if (f6794f.e()) {
                return new c.a.n0.a.k.h.b(402, "over max limit");
            }
            if (!f6794f.b()) {
                return new c.a.n0.a.k.h.b(402, "over time interval limit");
            }
            return l(str, false, new a(this));
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PreloadPackageApi" : (String) invokeV.objValue;
    }

    public final void z(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appKey", str);
            bundle.putString(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
            c.a.n0.a.o1.b.e.b(C0498b.class, bundle);
        }
    }
}
