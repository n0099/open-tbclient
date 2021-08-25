package c.a.o0.a.h0.o;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6259b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f6260a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(958024298, "Lc/a/o0/a/h0/o/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(958024298, "Lc/a/o0/a/h0/o/b;");
                return;
            }
        }
        f6259b = k.f7049a;
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
        this.f6260a = c.f6261a;
    }

    public final void a(@NonNull c.a.o0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, prefetchEvent, pMSAppInfo) == null) {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
            if (pMSAppInfo == null) {
                pMSAppInfo = c.a.o0.n.g.a.h().s(prefetchEvent.appId);
            }
            if (pMSAppInfo == null) {
                return;
            }
            bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
            if (this.f6260a.a(prefetchEvent, pMSAppInfo, bundle)) {
                c.a.o0.a.v1.c.a e2 = c.a.o0.a.v1.c.a.e();
                c.a.o0.a.v1.c.c cVar2 = new c.a.o0.a.v1.c.c(120, bundle);
                cVar2.b(cVar.f9236f);
                cVar2.p(false);
                e2.h(cVar2);
            }
        }
    }

    public void b(@NonNull PrefetchEvent prefetchEvent, @NonNull c.a.o0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, cVar, pMSAppInfo) == null) {
            a(cVar, prefetchEvent, pMSAppInfo);
            cVar.X(prefetchEvent);
            if (f6259b) {
                String str = "onPrefetchReady event: " + prefetchEvent;
                String str2 = "onPrefetchReady client id: " + cVar.f9236f.index;
            }
        }
    }
}
