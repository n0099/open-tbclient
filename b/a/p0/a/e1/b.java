package b.a.p0.a.e1;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // b.a.p0.a.e1.e
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? SchemeCollecter.CLASSIFY_SWAN_V8.equals(str) && "request".equals(str2) : invokeLL.booleanValue;
    }

    @Override // b.a.p0.a.e1.e
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RequestDescInterceptor" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.e1.e
    @NonNull
    public JSONObject c(@NonNull String str, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject)) == null) {
            try {
                jSONObject.put("invoke", "swan.method.v8BindingObject");
                jSONObject.put("method", "_naSwan.naRequest");
                JSONArray optJSONArray = jSONObject.optJSONArray("args");
                if (optJSONArray != null) {
                    List asList = Arrays.asList("cb", "ping", "__requestDataType__");
                    for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(length);
                        if (optJSONObject != null && asList.contains(optJSONObject.optString("name"))) {
                            optJSONArray.remove(length);
                        }
                    }
                    optJSONArray.put(d("success", "function="));
                    optJSONArray.put(d(com.baidu.pass.biometrics.face.liveness.b.a.g0, "function="));
                    optJSONArray.put(d(XAdRemoteEvent.COMPLETE, "function="));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    @Override // b.a.p0.a.e1.e
    public boolean enable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.p0.a.u.e.i.e.h() : invokeV.booleanValue;
    }
}
