package c.a.n0.a.c1.d;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import c.a.n0.q.o.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3959c;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, JSONObject> a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, JSONObject> f3960b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(714691889, "Lc/a/n0/a/c1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(714691889, "Lc/a/n0/a/c1/d/a;");
                return;
            }
        }
        f3959c = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LruCache<>(5);
        this.f3960b = new LruCache<>(5);
    }

    public final JSONObject a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                if (f3959c) {
                    Log.e("SwanAppExtInfo", "appInfo is null");
                }
                return null;
            }
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.appSign);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String e2 = e(str, valueOf);
                JSONObject jSONObject = this.a.get(e2);
                if (jSONObject == null) {
                    jSONObject = f.p(b.a(pMSAppInfo));
                    this.a.put(e2, jSONObject);
                }
                if (f3959c) {
                    Log.d("SwanAppExtInfo", "appId - " + str + " app info' ext - " + jSONObject.toString());
                }
                return jSONObject;
            }
            if (f3959c) {
                Log.e("SwanAppExtInfo", "appId or app sign is empty");
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject b(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo)) == null) {
            JSONObject a = a(pMSAppInfo);
            if (a == null) {
                if (f3959c) {
                    Log.e("SwanAppExtInfo", "appInfoExt is null");
                }
                return null;
            }
            JSONObject optJSONObject = a.optJSONObject("client");
            if (optJSONObject == null) {
                if (f3959c) {
                    Log.e("SwanAppExtInfo", "clientInfo is null");
                }
                return null;
            }
            if (f3959c) {
                Log.d("SwanAppExtInfo", "clientInfo - " + optJSONObject);
            }
            return optJSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String c(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pMSAppInfo)) == null) {
            JSONObject a = a(pMSAppInfo);
            if (a == null) {
                if (f3959c) {
                    Log.e("SwanAppExtInfo", "appInfoExt is null");
                }
                return null;
            }
            String optString = a.optString("webview_whitelist_switch");
            if (TextUtils.isEmpty(optString)) {
                if (f3959c) {
                    Log.e("SwanAppExtInfo", "webview whitelist switch is empty");
                }
                return null;
            }
            if (f3959c) {
                Log.d("SwanAppExtInfo", "webview whitelist switch - " + optString);
            }
            return optString;
        }
        return (String) invokeL.objValue;
    }

    public final JSONObject d(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                if (f3959c) {
                    Log.e("SwanAppExtInfo", "appInfo is null");
                }
                return null;
            }
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.versionCode);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String e2 = e(str, valueOf);
                JSONObject jSONObject = this.f3960b.get(e2);
                if (jSONObject == null) {
                    jSONObject = f.p(c.f(pMSAppInfo));
                    this.a.put(e2, jSONObject);
                }
                if (f3959c) {
                    Log.d("SwanAppExtInfo", "appId - " + str + " pkg info' ext - " + jSONObject.toString());
                }
                return jSONObject;
            }
            if (f3959c) {
                Log.e("SwanAppExtInfo", "appId or version code is empty");
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            return str + "_" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f3959c) {
                Log.d("SwanAppExtInfo", "release cache");
            }
            this.a.evictAll();
            this.f3960b.evictAll();
        }
    }
}
