package c.a.s0.a.f2.f.m0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.a.d2.e;
import c.a.s0.a.u.c.d;
import c.a.s0.a.z2.q;
import c.a.s0.a.z2.q0;
import c.a.s0.q.f.c;
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
public class b extends c.a.s0.a.u.e.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static c.a.s0.a.k0.a f6288f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.s0.a.f2.f.m0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0350a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f6289e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f6290f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f6291g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f6292h;

            /* renamed from: c.a.s0.a.f2.f.m0.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0351a implements c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ RunnableC0350a f6293b;

                public C0351a(RunnableC0350a runnableC0350a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0350a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6293b = runnableC0350a;
                    this.a = str;
                }

                @Override // c.a.s0.q.f.c
                public void onFail(Exception exc) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                        c.a.s0.a.e0.d.c("PreloadPackageApi", "preloadPackage transform openBundleId fail");
                    }
                }

                @Override // c.a.s0.q.f.c
                public void onResult(@Nullable Map<String, String> map) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                        if (map == null) {
                            c.a.s0.a.e0.d.c("PreloadPackageApi", "preloadPackage keyMap null");
                            return;
                        }
                        RunnableC0350a runnableC0350a = this.f6293b;
                        runnableC0350a.f6292h.a.z(map.get(this.f6293b.f6290f), this.a, runnableC0350a.f6291g);
                    }
                }
            }

            public RunnableC0350a(a aVar, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6292h = aVar;
                this.f6289e = jSONObject;
                this.f6290f = str;
                this.f6291g = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean g2 = c.a.s0.q.k.j.b.e().g(!q0.G());
                    String optString = this.f6289e.optString("pageUrl");
                    if (!g2) {
                        this.f6292h.a.z(this.f6290f, optString, this.f6291g);
                    } else {
                        c.a.s0.q.b.e(Collections.singletonList(this.f6290f), b.f6288f.c(), new C0351a(this, optString));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.s0.a.u.c.d.a
        public c.a.s0.a.u.h.b a(e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("appKey");
                if (!TextUtils.isEmpty(optString)) {
                    if (!b.f6288f.a(1)) {
                        return new c.a.s0.a.u.h.b(402, "over single max limit");
                    }
                    q.h().execute(new RunnableC0350a(this, jSONObject, optString, str), "PreloadPackageApi");
                    return c.a.s0.a.u.h.b.f();
                }
                return new c.a.s0.a.u.h.b(202, "appKey must not empty");
            }
            return (c.a.s0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* renamed from: c.a.s0.a.f2.f.m0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0352b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0352b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                String e1 = c.a.s0.a.f1.e.c.e1(string, bundle.getString("pageUrl"), 0, null);
                PrefetchEvent.b bVar = new PrefetchEvent.b();
                bVar.e("show");
                bVar.d(e1);
                bVar.c("10");
                bVar.a(string);
                c.a.s0.a.h0.o.d.g().f(bVar.b());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.s0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.s0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#preloadPackage", false);
            String a2 = c.a.s0.a.v.a.a(c.a.s0.a.d2.d.J().getAppId());
            if (TextUtils.isEmpty(a2)) {
                return new c.a.s0.a.u.h.b(101, "runtime parameter error");
            }
            c.a.s0.a.k0.a aVar = f6288f;
            if (aVar == null || !aVar.d(a2)) {
                f6288f = new c.a.s0.a.k0.a(a2, c.a.s0.q.k.i.t.a.b(a2));
            }
            if (f6288f.e()) {
                return new c.a.s0.a.u.h.b(402, "over max limit");
            }
            if (!f6288f.b()) {
                return new c.a.s0.a.u.h.b(402, "over time interval limit");
            }
            return l(str, false, new a(this));
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.s0.a.u.c.d
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
            bundle.putString("pageUrl", str2);
            c.a.s0.a.y1.b.e.b(C0352b.class, bundle);
        }
    }
}
