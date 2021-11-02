package b.a.p0.a.p1;

import android.os.Bundle;
import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.k;
import b.a.p0.a.v1.c.c;
import b.a.p0.a.v2.e1.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7301b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f7302c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f7303d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b<SwanAppPageInfo> f7304a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1331983570, "Lb/a/p0/a/p1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1331983570, "Lb/a/p0/a/p1/a;");
                return;
            }
        }
        f7301b = k.f6397a;
        f7303d = b.a.p0.a.c1.a.m().a() + "_";
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
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7302c == null) {
                synchronized (a.class) {
                    if (f7302c == null) {
                        f7302c = new a();
                    }
                }
            }
            return f7302c;
        }
        return (a) invokeV.objValue;
    }

    public final b.a.p0.a.f1.e.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e P = e.P();
            if (P == null || P.K() == null) {
                return null;
            }
            return P.K();
        }
        return (b.a.p0.a.f1.e.b) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            String optString = jSONObject.optString("type");
            if (TextUtils.isEmpty(optString) || !optString.startsWith(f7303d)) {
                return;
            }
            b.a.p0.a.f1.e.b b2 = b();
            if (b2 != null) {
                try {
                    jSONObject.put("appName", b2.J());
                    jSONObject.put("iconUrl", b2.P());
                    jSONObject.put("appDesc", b2.b1());
                } catch (JSONException e2) {
                    if (f7301b) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("type", optString.substring(f7303d.length()));
            b<SwanAppPageInfo> bVar = this.f7304a;
            if (bVar != null) {
                bVar.onCallback(new SwanAppPageInfo(jSONObject));
            }
            if (SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
                d();
                Bundle bundle = new Bundle();
                bundle.putString("page_info", jSONObject.toString());
                b.a.p0.a.v1.c.a.e().h(new c(24, bundle));
                boolean z = f7301b;
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f7304a == null) {
            return;
        }
        this.f7304a = null;
    }
}
