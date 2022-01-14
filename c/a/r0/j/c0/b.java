package c.a.r0.j.c0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.k;
import c.a.r0.a.n0.d;
import c.a.r0.a.n0.f;
import c.a.r0.a.y1.c.f.e;
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
/* loaded from: classes6.dex */
public class b extends c.a.r0.a.y1.a.a.a implements c.a.r0.a.y1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f10919g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f10920h;

    /* renamed from: i  reason: collision with root package name */
    public static long f10921i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f10922f;

    /* loaded from: classes6.dex */
    public class a implements i.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f10923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f10924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f10925g;

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
            this.f10925g = bVar;
            this.f10923e = z;
            this.f10924f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f10923e) {
                    if (b.f10919g) {
                        String str2 = "execCall: addCallback CALLBACK_TERM = " + b.f10921i;
                    }
                    e.k().c(this.f10925g, b.f10921i);
                }
                d d2 = f.c().d();
                if (d2 != null) {
                    List<String> singletonList = Collections.singletonList(this.f10924f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    c.a.r0.a.n0.l.c l = c.a.r0.a.n0.l.c.l();
                    l.i(6);
                    d2.h(singletonList, true, l.k());
                }
                if (b.f10919g) {
                    String str3 = "execCall: addCallback purge finish = " + d2;
                }
                if (this.f10923e) {
                    return;
                }
                this.f10925g.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-181039061, "Lc/a/r0/j/c0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-181039061, "Lc/a/r0/j/c0/b;");
                return;
            }
        }
        f10919g = k.a;
        f10920h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        f10921i = TimeUnit.SECONDS.toMillis(10L);
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
        this.f10922f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // c.a.r0.a.y1.c.f.a
    public void a(String str, c.a.r0.a.y1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f9731f.index == this.f10922f && f10920h.contains(str)) {
            e.k().h(this);
            if (f10919g) {
                String str2 = "onEvent: event = " + str;
            }
            h();
        }
    }

    @Override // c.a.r0.a.y1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f10922f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (f10919g) {
                String str = "execCall: target = " + this.f10922f;
                String str2 = "execCall: waitCallback = " + checkProcessId;
            }
            i.d.f("").k(Schedulers.io()).w(new a(this, checkProcessId, bundle));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.a.getString("scheme");
            if (f10919g) {
                String str = "invoke: scheme = " + string;
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }

    @Override // c.a.r0.a.y1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = f10919g;
            h();
        }
    }
}
