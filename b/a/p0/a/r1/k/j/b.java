package b.a.p0.a.r1.k.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c {
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

    @Override // b.a.p0.a.r1.k.j.c
    public List<b.a.p0.a.r1.k.a> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            ArrayList arrayList = new ArrayList();
            String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
            c("api-name " + optString);
            if (TextUtils.isEmpty(optString)) {
                return arrayList;
            }
            int optInt = jSONObject.optInt("count");
            c("api-count " + optInt);
            if (optInt > 0 && (optJSONObject = jSONObject.optJSONObject("caller")) != null) {
                b(optString, optJSONObject.optJSONObject("swan"), arrayList, 0);
                b(optString, optJSONObject.optJSONObject("boxjs"), arrayList, 1);
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void b(String str, @Nullable JSONObject jSONObject, @NonNull List<b.a.p0.a.r1.k.a> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, list, i2) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("startTime");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("endTime");
        if (optJSONArray == null || optJSONArray2 == null) {
            return;
        }
        int min = Math.min(optJSONArray.length(), optJSONArray2.length());
        for (int i3 = 0; i3 < min; i3++) {
            b.a.p0.a.r1.k.a aVar = new b.a.p0.a.r1.k.a();
            aVar.g(i2);
            aVar.f(str);
            aVar.i(optJSONArray.optLong(i3));
            aVar.h(optJSONArray2.optLong(i3));
            list.add(aVar);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            boolean z = c.f7705a;
        }
    }
}
