package b.a.p0.a.u;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.l0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.api.module.network.SwanApiNetworkV8Module;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes.dex */
public class a implements b.a.p0.a.u.c.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7990e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f7991a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f7992b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f7993c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.h0.f.a f7994d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065262902, "Lb/a/p0/a/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065262902, "Lb/a/p0/a/u/a;");
                return;
            }
        }
        f7990e = k.f6397a;
    }

    public a(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull b.a.p0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, callbackHandler, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7991a = context;
        this.f7992b = callbackHandler;
        this.f7994d = aVar;
    }

    public void a(@NonNull b.a.p0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
        }
    }

    public final void b(@NonNull b.a.p0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar instanceof c) {
                c((c) aVar);
            } else {
                d(aVar);
            }
        }
    }

    public final void c(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            e(cVar, SwanApi$$ModulesProvider.getV8ApiModules(this), b.a.p0.a.c1.a.s().a(this));
        }
    }

    public final void d(@NonNull b.a.p0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            e(aVar, SwanApi$$ModulesProvider.getWebviewApiModules(this), b.a.p0.a.c1.a.s().c(this));
        }
    }

    public final void e(@NonNull b.a.p0.a.h0.f.a aVar, Map<String, Object> map, Map<String, Object> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, aVar, map, map2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (map2 != null) {
                if (map == null) {
                    map = map2;
                } else {
                    try {
                        map.putAll(map2);
                    } catch (Exception e2) {
                        if (f7990e) {
                            e2.printStackTrace();
                            throw new RuntimeException("doBindSwanApis fail: " + e2.getMessage());
                        }
                        return;
                    }
                }
            }
            if (map == null) {
                if (f7990e) {
                    throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
                }
                return;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    if (f7990e) {
                        throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                    }
                } else if (value == null) {
                    if (f7990e) {
                        throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                    }
                } else {
                    aVar.addJavascriptInterface(value, key);
                    if (f7990e) {
                        String str = "doBindSwanApis(" + (aVar instanceof c ? "V8" : "Webview") + "): bound " + key;
                    }
                }
            }
            if (f7990e) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 5) {
                    String str2 = "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms";
                }
            }
        }
    }

    @Override // b.a.p0.a.u.c.b
    @NonNull
    public b.a.p0.a.h0.f.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7994d : (b.a.p0.a.h0.f.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.b
    @NonNull
    public CallbackHandler g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7992b : (CallbackHandler) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.b
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? h() : (Context) invokeV.objValue;
    }

    @NonNull
    public final Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WeakReference<Activity> weakReference = this.f7993c;
            Activity activity = weakReference != null ? weakReference.get() : null;
            return activity == null ? this.f7991a : activity;
        }
        return (Context) invokeV.objValue;
    }

    public void i(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, activity) == null) || activity == null) {
            return;
        }
        this.f7993c = new WeakReference<>(activity);
    }
}
