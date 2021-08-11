package c.a.n0.a.l1.d;

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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.n0.a.l1.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f6978a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536987353, "Lc/a/n0/a/l1/d/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(536987353, "Lc/a/n0/a/l1/d/d$b;");
                    return;
                }
            }
            f6978a = new d(null);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f6978a : (d) invokeV.objValue;
    }

    public boolean g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            JSONObject c2 = c(pMSAppInfo);
            if (c2 == null || c2.length() <= 0) {
                return false;
            }
            boolean optBoolean = c2.optBoolean("is_opti");
            if (c.a.n0.a.l1.d.a.f6973c) {
                String str = "is opt pkg  - " + optBoolean;
            }
            return optBoolean;
        }
        return invokeL.booleanValue;
    }

    public boolean h(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo)) == null) {
            JSONObject b2 = b(pMSAppInfo);
            if (b2 != null && b2.has(PrefetchEvent.MODULE)) {
                z = b2.optBoolean(PrefetchEvent.MODULE);
            } else {
                JSONObject a2 = a(pMSAppInfo);
                z = a2 != null && a2.optBoolean(PrefetchEvent.MODULE);
            }
            if (c.a.n0.a.l1.d.a.f6973c) {
                String str = "is prefetch on - " + z;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public JSONObject i(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pMSAppInfo)) == null) {
            JSONObject b2 = b(pMSAppInfo);
            if (b2 == null || b2.length() <= 0) {
                return null;
            }
            return b2.optJSONObject("topPages");
        }
        return (JSONObject) invokeL.objValue;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
