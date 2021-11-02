package b.a.p0.a.r1;

import android.text.TextUtils;
import b.a.p0.a.k;
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
public class a implements b.a.p0.a.v2.e1.b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7618e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1333830612, "Lb/a/p0/a/r1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1333830612, "Lb/a/p0/a/r1/a;");
                return;
            }
        }
        f7618e = k.f6397a;
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
            if (hybridUbcFlow != null && !hybridUbcFlow.f43872f.isEmpty()) {
                jSONObject.put("flowId", hybridUbcFlow.j());
                JSONArray jSONArray = new JSONArray();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f43872f) {
                    if (!ubcFlowEvent.b() && !TextUtils.isEmpty(ubcFlowEvent.f43881a)) {
                        if (f7618e) {
                            String str = "buildJoMsg: event=" + ubcFlowEvent;
                        }
                        jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.f43881a).put("timestamp", ubcFlowEvent.g()));
                    }
                }
                jSONObject.put("data", jSONArray);
            }
            if (f7618e) {
                String str2 = "buildJoMsg: joMsg=" + jSONObject;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.v2.e1.b
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            if (f7618e) {
                String str = "report: flow=" + hybridUbcFlow;
            }
            if (b.a.p0.a.g1.f.T().X()) {
                if (f7618e || b.a.p0.a.g1.f.T().M()) {
                    try {
                        j.e().c(a(hybridUbcFlow));
                    } catch (JSONException e2) {
                        if (f7618e) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
