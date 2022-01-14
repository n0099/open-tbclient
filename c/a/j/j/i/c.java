package c.a.j.j.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UBCManager a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.j.j.i.d.a f3996b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1478746318, "Lc/a/j/j/i/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1478746318, "Lc/a/j/j/i/c;");
        }
    }

    public c() {
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
        this.a = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.f3996b = (c.a.j.j.i.d.a) ServiceManager.getService(c.a.j.j.i.d.a.a.a());
    }

    @Override // c.a.j.j.i.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str2);
            hashMap.put("page", str);
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "it.toString()");
                hashMap.put("ext", jSONObject2);
            }
            UBCManager uBCManager = this.a;
            if (uBCManager != null) {
                uBCManager.onEvent("3676", hashMap);
            }
        }
    }

    @Override // c.a.j.j.i.a
    public void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
            String extra = jSONObject.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("value", str);
            hashMap.put("type", "abnormal");
            Intrinsics.checkExpressionValueIsNotNull(extra, "extra");
            hashMap.put("ext", extra);
            c.a.j.j.i.d.a aVar = this.f3996b;
            if (aVar != null) {
                aVar.a("3677", str, extra);
            }
        }
    }
}
