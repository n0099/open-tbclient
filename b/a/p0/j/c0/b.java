package b.a.p0.j.c0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.a.n0.d;
import b.a.p0.a.n0.f;
import b.a.p0.a.y1.c.f.e;
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
/* loaded from: classes4.dex */
public class b extends b.a.p0.a.y1.a.a.a implements b.a.p0.a.y1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11035g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f11036h;

    /* renamed from: i  reason: collision with root package name */
    public static long f11037i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f11038f;

    /* loaded from: classes4.dex */
    public class a implements h.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11039e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f11040f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f11041g;

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
            this.f11041g = bVar;
            this.f11039e = z;
            this.f11040f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f11039e) {
                    if (b.f11035g) {
                        String str2 = "execCall: addCallback CALLBACK_TERM = " + b.f11037i;
                    }
                    e.k().c(this.f11041g, b.f11037i);
                }
                d d2 = f.c().d();
                if (d2 != null) {
                    List<String> singletonList = Collections.singletonList(this.f11040f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
                    l.i(6);
                    d2.h(singletonList, true, l.k());
                }
                if (b.f11035g) {
                    String str3 = "execCall: addCallback purge finish = " + d2;
                }
                if (this.f11039e) {
                    return;
                }
                this.f11041g.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(717546574, "Lb/a/p0/j/c0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(717546574, "Lb/a/p0/j/c0/b;");
                return;
            }
        }
        f11035g = k.f6863a;
        f11036h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        f11037i = TimeUnit.SECONDS.toMillis(10L);
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
        this.f11038f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // b.a.p0.a.y1.c.f.a
    public void a(String str, b.a.p0.a.y1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f9497f.index == this.f11038f && f11036h.contains(str)) {
            e.k().h(this);
            if (f11035g) {
                String str2 = "onEvent: event = " + str;
            }
            h();
        }
    }

    @Override // b.a.p0.a.y1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f11038f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (f11035g) {
                String str = "execCall: target = " + this.f11038f;
                String str2 = "execCall: waitCallback = " + checkProcessId;
            }
            h.d.f("").k(Schedulers.io()).w(new a(this, checkProcessId, bundle));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.f9433a.getString("scheme");
            if (f11035g) {
                String str = "invoke: scheme = " + string;
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }

    @Override // b.a.p0.a.y1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = f11035g;
            h();
        }
    }
}
