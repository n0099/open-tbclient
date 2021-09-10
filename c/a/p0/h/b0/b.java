package c.a.p0.h.b0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
import c.a.p0.a.n0.d;
import c.a.p0.a.n0.f;
import c.a.p0.a.v1.c.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b extends c.a.p0.a.v1.a.a.a implements c.a.p0.a.v1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11026g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f11027h;

    /* renamed from: i  reason: collision with root package name */
    public static long f11028i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f11029f;

    /* loaded from: classes3.dex */
    public class a implements i.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f11031f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f11032g;

        public a(b bVar, boolean z, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z), bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11032g = bVar;
            this.f11030e = z;
            this.f11031f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f11030e) {
                    if (b.f11026g) {
                        String str2 = "execCall: addCallback CALLBACK_TERM = " + b.f11028i;
                    }
                    e.k().c(this.f11032g, b.f11028i);
                }
                d d2 = f.c().d();
                if (d2 != null) {
                    List<String> singletonList = Collections.singletonList(this.f11031f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    c.a.p0.a.n0.l.c l = c.a.p0.a.n0.l.c.l();
                    l.i(6);
                    d2.h(singletonList, true, l.k());
                }
                if (b.f11026g) {
                    String str3 = "execCall: addCallback purge finish = " + d2;
                }
                if (this.f11030e) {
                    return;
                }
                this.f11032g.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1563942934, "Lc/a/p0/h/b0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1563942934, "Lc/a/p0/h/b0/b;");
                return;
            }
        }
        f11026g = k.f7077a;
        f11027h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        f11028i = TimeUnit.SECONDS.toMillis(10L);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11029f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // c.a.p0.a.v1.c.f.a
    public void a(String str, c.a.p0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f9264f.index == this.f11029f && f11027h.contains(str)) {
            e.k().h(this);
            if (f11026g) {
                String str2 = "onEvent: event = " + str;
            }
            h();
        }
    }

    @Override // c.a.p0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f11029f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (f11026g) {
                String str = "execCall: target = " + this.f11029f;
                String str2 = "execCall: waitCallback = " + checkProcessId;
            }
            i.d.i("").o(Schedulers.io()).B(new a(this, checkProcessId, bundle));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.f9200a.getString("scheme");
            if (f11026g) {
                String str = "invoke: scheme = " + string;
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }

    @Override // c.a.p0.a.v1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = f11026g;
            h();
        }
    }
}
