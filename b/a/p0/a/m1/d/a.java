package b.a.p0.a.m1.d;

import android.text.TextUtils;
import android.util.LruCache;
import b.a.p0.a.k;
import b.a.p0.q.p.f;
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
    public static final boolean f7028c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, JSONObject> f7029a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, JSONObject> f7030b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1768493722, "Lb/a/p0/a/m1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1768493722, "Lb/a/p0/a/m1/d/a;");
                return;
            }
        }
        f7028c = k.f6863a;
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
        this.f7029a = new LruCache<>(5);
        this.f7030b = new LruCache<>(5);
    }

    public final JSONObject a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                boolean z = f7028c;
                return null;
            }
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.appSign);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String e2 = e(str, valueOf);
                JSONObject jSONObject = this.f7029a.get(e2);
                if (jSONObject == null) {
                    jSONObject = f.p(b.a(pMSAppInfo));
                    this.f7029a.put(e2, jSONObject);
                }
                if (f7028c) {
                    String str2 = "appId - " + str + " app info' ext - " + jSONObject.toString();
                }
                return jSONObject;
            }
            boolean z2 = f7028c;
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject b(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo)) == null) {
            JSONObject a2 = a(pMSAppInfo);
            if (a2 == null) {
                boolean z = f7028c;
                return null;
            }
            JSONObject optJSONObject = a2.optJSONObject("client");
            if (optJSONObject == null) {
                boolean z2 = f7028c;
                return null;
            }
            if (f7028c) {
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
            JSONObject a2 = a(pMSAppInfo);
            if (a2 == null) {
                boolean z = f7028c;
                return null;
            }
            String optString = a2.optString("webview_whitelist_switch");
            if (TextUtils.isEmpty(optString)) {
                boolean z2 = f7028c;
                return null;
            }
            if (f7028c) {
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
                boolean z = f7028c;
                return null;
            }
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.versionCode);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String e2 = e(str, valueOf);
                JSONObject jSONObject = this.f7030b.get(e2);
                if (jSONObject == null) {
                    jSONObject = f.p(c.f(pMSAppInfo));
                    this.f7029a.put(e2, jSONObject);
                }
                if (f7028c) {
                    String str2 = "appId - " + str + " pkg info' ext - " + jSONObject.toString();
                }
                return jSONObject;
            }
            boolean z2 = f7028c;
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
            boolean z = f7028c;
            this.f7029a.evictAll();
            this.f7030b.evictAll();
        }
    }
}
