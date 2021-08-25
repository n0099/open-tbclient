package c.a.o0.h.b0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.o0.a.k;
import c.a.o0.a.n0.d;
import c.a.o0.a.n0.f;
import c.a.o0.a.v1.c.f.e;
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
public class b extends c.a.o0.a.v1.a.a.a implements c.a.o0.a.v1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f10998g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f10999h;

    /* renamed from: i  reason: collision with root package name */
    public static long f11000i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f11001f;

    /* loaded from: classes3.dex */
    public class a implements i.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11002e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f11003f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f11004g;

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
            this.f11004g = bVar;
            this.f11002e = z;
            this.f11003f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f11002e) {
                    if (b.f10998g) {
                        String str2 = "execCall: addCallback CALLBACK_TERM = " + b.f11000i;
                    }
                    e.k().c(this.f11004g, b.f11000i);
                }
                d d2 = f.c().d();
                if (d2 != null) {
                    List<String> singletonList = Collections.singletonList(this.f11003f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    c.a.o0.a.n0.l.c l = c.a.o0.a.n0.l.c.l();
                    l.i(6);
                    d2.h(singletonList, true, l.k());
                }
                if (b.f10998g) {
                    String str3 = "execCall: addCallback purge finish = " + d2;
                }
                if (this.f11002e) {
                    return;
                }
                this.f11004g.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1367429429, "Lc/a/o0/h/b0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1367429429, "Lc/a/o0/h/b0/b;");
                return;
            }
        }
        f10998g = k.f7049a;
        f10999h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        f11000i = TimeUnit.SECONDS.toMillis(10L);
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
        this.f11001f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // c.a.o0.a.v1.c.f.a
    public void a(String str, c.a.o0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f9236f.index == this.f11001f && f10999h.contains(str)) {
            e.k().h(this);
            if (f10998g) {
                String str2 = "onEvent: event = " + str;
            }
            h();
        }
    }

    @Override // c.a.o0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f11001f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (f10998g) {
                String str = "execCall: target = " + this.f11001f;
                String str2 = "execCall: waitCallback = " + checkProcessId;
            }
            i.d.i("").o(Schedulers.io()).B(new a(this, checkProcessId, bundle));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.f9172a.getString("scheme");
            if (f10998g) {
                String str = "invoke: scheme = " + string;
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }

    @Override // c.a.o0.a.v1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = f10998g;
            h();
        }
    }
}
