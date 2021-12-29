package c.a.r0.a.u1;

import android.text.TextUtils;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c.a.r0.a.z2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9541e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438015540, "Lc/a/r0/a/u1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438015540, "Lc/a/r0/a/u1/a;");
                return;
            }
        }
        f9541e = k.a;
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

    public final JSONObject a(HybridUbcFlow hybridUbcFlow) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hybridUbcFlow)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (hybridUbcFlow != null && !hybridUbcFlow.f40320f.isEmpty()) {
                jSONObject.put("flowId", hybridUbcFlow.l());
                JSONArray jSONArray = new JSONArray();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f40320f) {
                    if (!ubcFlowEvent.b() && !TextUtils.isEmpty(ubcFlowEvent.a)) {
                        if (f9541e) {
                            String str = "buildJoMsg: event=" + ubcFlowEvent;
                        }
                        jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.a).put("timestamp", ubcFlowEvent.g()));
                    }
                }
                jSONObject.put("data", jSONArray);
            }
            if (f9541e) {
                String str2 = "buildJoMsg: joMsg=" + jSONObject;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.z2.g1.c
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            if (f9541e) {
                String str = "report: flow=" + hybridUbcFlow;
            }
            if (c.a.r0.a.g1.f.U().Y()) {
                if (f9541e || c.a.r0.a.g1.f.U().N()) {
                    try {
                        j.e().c(a(hybridUbcFlow));
                    } catch (JSONException e2) {
                        if (f9541e) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
