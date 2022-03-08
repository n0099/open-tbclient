package c.a.p0.a.k;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.b0.c;
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
public class a implements c.a.p0.a.k.c.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5866e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Context a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f5867b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f5868c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.x.f.a f5869d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358963819, "Lc/a/p0/a/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358963819, "Lc/a/p0/a/k/a;");
                return;
            }
        }
        f5866e = c.a.p0.a.a.a;
    }

    public a(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull c.a.p0.a.x.f.a aVar) {
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
        this.a = context;
        this.f5867b = callbackHandler;
        this.f5869d = aVar;
    }

    public void a(@NonNull c.a.p0.a.x.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
        }
    }

    public final void b(@NonNull c.a.p0.a.x.f.a aVar) {
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
            e(cVar, SwanApi$$ModulesProvider.getV8ApiModules(this), c.a.p0.a.s0.a.s().b(this));
        }
    }

    public final void d(@NonNull c.a.p0.a.x.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            e(aVar, SwanApi$$ModulesProvider.getWebviewApiModules(this), c.a.p0.a.s0.a.s().c(this));
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void e(@NonNull c.a.p0.a.x.f.a aVar, Map<String, Object> map, Map<String, Object> map2) {
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
                        if (f5866e) {
                            e2.printStackTrace();
                            throw new RuntimeException("doBindSwanApis fail: " + e2.getMessage());
                        }
                        return;
                    }
                }
            }
            if (map == null) {
                if (f5866e) {
                    throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
                }
                return;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    if (f5866e) {
                        throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                    }
                } else if (value == null) {
                    if (f5866e) {
                        throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                    }
                } else {
                    aVar.addJavascriptInterface(value, key);
                    if (f5866e) {
                        String str = "doBindSwanApis(" + (aVar instanceof c ? "V8" : "Webview") + "): bound " + key;
                    }
                }
            }
            if (f5866e) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 5) {
                    String str2 = "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms";
                }
            }
        }
    }

    @NonNull
    public final Context f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            WeakReference<Activity> weakReference = this.f5868c;
            Activity activity = weakReference != null ? weakReference.get() : null;
            return activity == null ? this.a : activity;
        }
        return (Context) invokeV.objValue;
    }

    @Override // c.a.p0.a.k.c.b
    @NonNull
    public c.a.p0.a.x.f.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5869d : (c.a.p0.a.x.f.a) invokeV.objValue;
    }

    @Override // c.a.p0.a.k.c.b
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f() : (Context) invokeV.objValue;
    }

    @Override // c.a.p0.a.k.c.b
    @NonNull
    public CallbackHandler h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5867b : (CallbackHandler) invokeV.objValue;
    }

    public void i(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, activity) == null) || activity == null) {
            return;
        }
        this.f5868c = new WeakReference<>(activity);
    }
}
