package b.a.p0.a.f2.f.m0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.d2.e;
import b.a.p0.a.u.c.d;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.q.f.c;
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
public class b extends b.a.p0.a.u.e.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b.a.p0.a.k0.a f5057f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5058a;

        /* renamed from: b.a.p0.a.f2.f.m0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0181a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f5059e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f5060f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f5061g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f5062h;

            /* renamed from: b.a.p0.a.f2.f.m0.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0182a implements c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f5063a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ RunnableC0181a f5064b;

                public C0182a(RunnableC0181a runnableC0181a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0181a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5064b = runnableC0181a;
                    this.f5063a = str;
                }

                @Override // b.a.p0.q.f.c
                public void onFail(Exception exc) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                        b.a.p0.a.e0.d.c("PreloadPackageApi", "preloadPackage transform openBundleId fail");
                    }
                }

                @Override // b.a.p0.q.f.c
                public void onResult(@Nullable Map<String, String> map) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                        if (map == null) {
                            b.a.p0.a.e0.d.c("PreloadPackageApi", "preloadPackage keyMap null");
                            return;
                        }
                        RunnableC0181a runnableC0181a = this.f5064b;
                        runnableC0181a.f5062h.f5058a.z(map.get(this.f5064b.f5060f), this.f5063a, runnableC0181a.f5061g);
                    }
                }
            }

            public RunnableC0181a(a aVar, JSONObject jSONObject, String str, String str2) {
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
                this.f5062h = aVar;
                this.f5059e = jSONObject;
                this.f5060f = str;
                this.f5061g = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean g2 = b.a.p0.q.k.j.b.e().g(!q0.G());
                    String optString = this.f5059e.optString("pageUrl");
                    if (!g2) {
                        this.f5062h.f5058a.z(this.f5060f, optString, this.f5061g);
                    } else {
                        b.a.p0.q.b.e(Collections.singletonList(this.f5060f), b.f5057f.c(), new C0182a(this, optString));
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
            this.f5058a = bVar;
        }

        @Override // b.a.p0.a.u.c.d.a
        public b.a.p0.a.u.h.b a(e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("appKey");
                if (!TextUtils.isEmpty(optString)) {
                    if (!b.f5057f.a(1)) {
                        return new b.a.p0.a.u.h.b(402, "over single max limit");
                    }
                    q.h().execute(new RunnableC0181a(this, jSONObject, optString, str), "PreloadPackageApi");
                    return b.a.p0.a.u.h.b.f();
                }
                return new b.a.p0.a.u.h.b(202, "appKey must not empty");
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* renamed from: b.a.p0.a.f2.f.m0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0183b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0183b() {
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
                String e1 = b.a.p0.a.f1.e.c.e1(string, bundle.getString("pageUrl"), 0, null);
                PrefetchEvent.b bVar = new PrefetchEvent.b();
                bVar.e("show");
                bVar.d(e1);
                bVar.c("10");
                bVar.a(string);
                b.a.p0.a.h0.o.d.g().f(bVar.b());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#preloadPackage", false);
            String a2 = b.a.p0.a.v.a.a(b.a.p0.a.d2.d.J().getAppId());
            if (TextUtils.isEmpty(a2)) {
                return new b.a.p0.a.u.h.b(101, "runtime parameter error");
            }
            b.a.p0.a.k0.a aVar = f5057f;
            if (aVar == null || !aVar.d(a2)) {
                f5057f = new b.a.p0.a.k0.a(a2, b.a.p0.q.k.i.t.a.b(a2));
            }
            if (f5057f.e()) {
                return new b.a.p0.a.u.h.b(402, "over max limit");
            }
            if (!f5057f.b()) {
                return new b.a.p0.a.u.h.b(402, "over time interval limit");
            }
            return l(str, false, new a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
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
            b.a.p0.a.y1.b.e.b(C0183b.class, bundle);
        }
    }
}
