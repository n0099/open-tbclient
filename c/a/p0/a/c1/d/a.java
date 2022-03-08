package c.a.p0.a.c1.d;

import android.text.TextUtils;
import android.util.LruCache;
import c.a.p0.q.o.f;
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
    public static final boolean f4655c;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, JSONObject> a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, JSONObject> f4656b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(972857327, "Lc/a/p0/a/c1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(972857327, "Lc/a/p0/a/c1/d/a;");
                return;
            }
        }
        f4655c = c.a.p0.a.a.a;
    }

    public a() {
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
        this.a = new LruCache<>(5);
        this.f4656b = new LruCache<>(5);
    }

    public final JSONObject a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                boolean z = f4655c;
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
                if (f4655c) {
                    String str2 = "appId - " + str + " app info' ext - " + jSONObject.toString();
                }
                return jSONObject;
            }
            boolean z2 = f4655c;
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
                boolean z = f4655c;
                return null;
            }
            JSONObject optJSONObject = a.optJSONObject("client");
            if (optJSONObject == null) {
                boolean z2 = f4655c;
                return null;
            }
            if (f4655c) {
                String str = "clientInfo - " + optJSONObject;
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
                boolean z = f4655c;
                return null;
            }
            String optString = a.optString("webview_whitelist_switch");
            if (TextUtils.isEmpty(optString)) {
                boolean z2 = f4655c;
                return null;
            }
            if (f4655c) {
                String str = "webview whitelist switch - " + optString;
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
                boolean z = f4655c;
                return null;
            }
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.versionCode);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String e2 = e(str, valueOf);
                JSONObject jSONObject = this.f4656b.get(e2);
                if (jSONObject == null) {
                    jSONObject = f.p(c.f(pMSAppInfo));
                    this.a.put(e2, jSONObject);
                }
                if (f4655c) {
                    String str2 = "appId - " + str + " pkg info' ext - " + jSONObject.toString();
                }
                return jSONObject;
            }
            boolean z2 = f4655c;
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
            boolean z = f4655c;
            this.a.evictAll();
            this.f4656b.evictAll();
        }
    }
}
